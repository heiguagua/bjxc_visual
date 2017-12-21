package com.chinawiserv.dsp.dir.controller.configure;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirHomeVo;
import com.chinawiserv.dsp.dir.service.configure.IDirHomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 新闻表 前端控制器
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
@Controller
@RequestMapping("/dirHome")
//todo 将所有的XXX修改为真实值
public class DirHomeController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IDirHomeService service;

//    @RequiresPermissions("XXX:XXX:list")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap){
		setCurrentMenuInfo(paramMap);
    	return "dir/configure/home/homeList";
    }

    /**
     * 分页查询新闻表
     */
//    @RequiresPermissions("XXX:XXX:list")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String , Object> paramMap){
		PageResult pageResult = new PageResult();
		try {
		    Page<DirHomeVo> page = service.selectVoPage(paramMap);
		    pageResult.setPage(page);
		} catch (Exception e) {
		    pageResult.error("分页查询首页图片表出错");
		    logger.error("分页查询首页图片表出错", e);
		}
		return pageResult;
    }

    /**
     * 新增新闻表
     */
//    @RequiresPermissions("XXX:XXX:add")
    @RequestMapping("/add")
    public  String add(){
		return "dir/configure/home/homeAdd";
    }

    /**
     * 执行新增
     */
//    @RequiresPermissions("XXX:XXX:add")
    @Log("创建首页图片表")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(DirHomeVo entity,@RequestParam(value="file",required=true)MultipartFile file,  
            HttpServletRequest request)
    {
		HandleResult handleResult = new HandleResult();
		try {
//			String rs = "samePic";
			String rs = service.fileUpload(entity, file, request);
            if("samePic".equals(rs)){
            	handleResult.error("该图片已存在，请重新选择图片上传");
            }else if("type".equals(rs)){
            	handleResult.error("上传格式不正确，请重新选择图片上传") ;
            }else{
            	handleResult.success("图片上传成功");
            }
//		    service.insertVO(entity);		    
		} catch (Exception e) {
		    handleResult.error("图片上传失败");
		    logger.error("图片上传失败", e);
		}
		return handleResult;
    }

    /**
     * 删除新闻表
     */
//    @RequiresPermissions("XXX:XXX:delete")
    @Log("删除新闻表")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(@RequestParam String id){
		//todo 逻辑删除
    	service.DeleteByFlag(id);
		return new HandleResult().success("删除图片成功");
    }
    
    /**
     * 更改启用状态
     */
//    @RequiresPermissions("XXX:XXX:delete")
    @Log("更改启用状态")
    @RequestMapping("/updateStatus")
    @ResponseBody
    public HandleResult updateStatus(@RequestParam String id,@RequestParam String status){
		//todo 逻辑删除
    	String message = null;
    	if(status.equals("1")){
    		service.updateStatus(id,status);
    		 message = "图片禁用成功";    		
    	}else if(status.equals("0")){
    		service.updateStatus(id,status);
    		 message = "图片启用成功";
    	}
		
    	return new HandleResult().success(message);
    }


    /**
     * 编辑新闻表
     */
//    @RequiresPermissions("XXX:XXX:edit")
    @RequestMapping("/edit")
    public  String edit(@RequestParam String id,Model model){
		model.addAttribute("id",id);
		return "dir/configure/home/homeEdit";
    }

//    @RequiresPermissions("XXX:XXX:edit")
    @RequestMapping("/editLoad")
    @ResponseBody
    public  HandleResult editLoad(@RequestParam String id){
		HandleResult handleResult = new HandleResult();
		try {
            DirHomeVo vo = service.selectVoById(id);
		    handleResult.put("vo", vo);
		} catch (Exception e) {
		    handleResult.error("获取首页图片表信息失败");
		    logger.error("获取首页图片表信息失败", e);
		}
		return handleResult;
		}

    /**
     * 执行编辑
     */
//    @RequiresPermissions("XXX:XXX:edit")
    @Log("编辑首页图片表")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(DirHomeVo entity,@RequestParam(value="file",required=false)MultipartFile file,  
            HttpServletRequest request){
		HandleResult handleResult = new HandleResult();
		try {
			String rs = service.fileUpdate(entity, file, request);
            if("samePic".equals(rs)){
            	handleResult.error("该图片已存在，请重新选择图片上传");
            }else if("type".equals(rs)){
            	handleResult.error("上传格式不正确，请重新选择图片上传") ;
            }else{
            	handleResult.success("更新首页图片表成功");
            }
//		    service.insertVO(entity);		    
		} catch (Exception e) {
		    handleResult.error("更新首页图片表失败");
		    logger.error("更新首页图片表失败", e);
		}
		
		return handleResult;
    }
}
