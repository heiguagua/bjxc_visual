package com.chinawiserv.dsp.base.controller.system;


import com.chinawiserv.dsp.base.common.SystemConst;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.base.common.util.GetFileTypeByHead;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.system.SysUser;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.base.service.system.ISysLogService;
import com.chinawiserv.dsp.base.service.system.ISysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 用户中心控制器
 * @author Gaojun.Zhou
 * @date 2016年12月16日 下午4:24:04
 */
@Controller
@RequestMapping("/system/me")
public class MeController extends BaseController {
	@Autowired
    private ISysLogService sysLogService;
	
	@Autowired
    private ISysUserService sysUserService;
	
    @RequestMapping("/page")
    public  String page(Model model){
    	SysUser sysUser = ShiroUtils.getLoginUser();
    	model.addAttribute("sysUser", sysUser);
		return "system/me/page";
    }
	/**
	 * 修改密码
	 */
    @RequestMapping("/changePwd")
	public String changePwd(){
		return "system/me/changePassword";
	}
    /**
     * 执行修改密码
     */
    @RequestMapping("/doChangePwd")
	@ResponseBody
    public HandleResult doChangePwd(String password, String newpassword, String newpassword2, Model model, HttpServletRequest request) throws Exception {

		HandleResult result = new HandleResult();
    	
    	if(StringUtils.isBlank(password) || StringUtils.isBlank(newpassword) || StringUtils.isBlank(newpassword2)){
    		return result.error("修改的密码不能为空");
    	}

	    if(!newpassword2.equals(newpassword)){
		    return result.error("两次密码输入不一致");
	    }

		String loginUserId = ShiroUtils.getLoginUserId();
    	SysUserVo userVo = sysUserService.selectVoById(loginUserId);
    	if(!userVo.getPassword().equals(CommonUtil.string2MD5(password))){
    		return result.error("旧密码输入有误");
    	}

		try {
			SysUserVo newSysUser = new SysUserVo();
			newSysUser.setId(loginUserId);
			newSysUser.setPassword(CommonUtil.string2MD5(newpassword));

			if (sysUserService.updateVO(newSysUser)){
               sysLogService.insertLog("修改密码", ShiroUtils.getLoginUser(), request.getRequestURI(), "修改密码成功");
           } else{
               sysLogService.insertLog("修改密码", ShiroUtils.getLoginUser(), request.getRequestURI(), "修改密码失败");
           }
		} catch (Exception e) {
			e.printStackTrace();
			return result.error("密码修改失败");
		}
		ShiroUtils.logout();
		return result.success("密码修改成功，请重新登录！");
    }
	/**
	 * 执行图片上传
	 */
	@RequestMapping(value = "/uploadImage",method = RequestMethod.POST)
	@ResponseBody
	public HandleResult fileUpload(
			@RequestParam("systemLogo") MultipartFile file,
			HttpServletRequest request) {
		if (!file.isEmpty()) {
			try {
				int state = 0;
	            List<String> listType = new ArrayList<>();
	            String fileType = GetFileTypeByHead.getFileTypeByByte(file.getBytes());
	            listType.add("jpg");listType.add("tif");listType.add("png");listType.add("gif");listType.add("bmp");
	            for (Iterator iterator = listType.iterator(); iterator.hasNext();) {
	    			String string = (String) iterator.next();
	    			if(string.equals(fileType)){
	    				state++;
	    			}
	    		}
	            if(state!=1){
	            	return new HandleResult().error("上传类型错误");
	            }else {
					
					//得到当前登陆用户id
					String id = ShiroUtils.getLoginUserId();
				    SysUserVo userVo = sysUserService.selectVoById(id);
					// 文件保存路径
				    String resource = "/WEB-INF/static/images/userImg/";
				    String filenameOri = file.getOriginalFilename();
                	filenameOri = userVo.getId()+filenameOri.substring(filenameOri.lastIndexOf("."));
					String filePath = request.getSession().getServletContext().getRealPath("/") + resource
						+ filenameOri;
					//转存文件
					file.transferTo(new File(filePath));
					//保存到数据库的文件名
					String filename="/images/userImg/" + filenameOri;
					//修改用户图片的url
				    userVo.setUserImg(filename);
				    //更新用户
				    sysUserService.updateById(userVo);
				    //更新图片
                	ShiroUtils.setSessionAttribute(SystemConst.ME, userVo);
				    return new HandleResult().success("上传图片成功");
	            }
			} catch (Exception e) {
				e.printStackTrace();
				return new HandleResult().error("上传失败");
				//return "system/me/page";
			}

		}
		//return "system/me/page";
		return new HandleResult().error("请选择文件");
	}
}
