package com.chinawiserv.dsp.dir.controller.configure;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.base.entity.vo.system.SysDictVo;
import com.chinawiserv.dsp.base.service.system.ISysDictService;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirClassifyVo;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirDevelopApisVo;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirSpecialAppsVo;
import com.chinawiserv.dsp.dir.mapper.configure.DirSpecialAppsMapper;
import com.chinawiserv.dsp.dir.service.configure.IDirSpecialAppsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 专题应用表 前端控制器
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
@Controller
@RequestMapping("/dirSpecialApps")
//todo 将所有的XXX修改为真实值
public class DirSpecialAppsController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IDirSpecialAppsService service;
    
    @Autowired
    private DirSpecialAppsMapper mapper;
    
    @Autowired
    private ISysDictService service2;

//    @RequiresPermissions("XXX:XXX:list")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap){
		setCurrentMenuInfo(paramMap);
    	return "dir/configure/specialapp/specialappList";
    }

    /**
     * 分页查询专题应用表
     */
//    @RequiresPermissions("XXX:XXX:list")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String , Object> paramMap){
		PageResult pageResult = new PageResult();
		try {
		    Page<DirSpecialAppsVo> page = service.selectVoPage(paramMap);
		    pageResult.setPage(page);
		} catch (Exception e) {
		    pageResult.error("分页查询专题应用表出错");
		    logger.error("分页查询专题应用表出错", e);
		}
		return pageResult;
    }

    /**
     * 新增专题应用表
     */
//    @RequiresPermissions("XXX:XXX:add")
    @RequestMapping("/add")
    public  String add(){
		return "dir/configure/specialapp/specialappAdd";
    }

    /**
     * 执行新增
     */
//    @RequiresPermissions("XXX:XXX:add")
    @Log("创建专题应用表")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(DirSpecialAppsVo entity, @RequestParam(value="file",required=true)MultipartFile file,  
            HttpServletRequest request){
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
     * 删除专题应用表
     */
//    @RequiresPermissions("XXX:XXX:delete")
    @Log("删除专题应用表")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(@RequestParam String id){
		//todo 逻辑删除
    	//service.deleteById(id);
    	service.DeleteByFlag(id);
		return new HandleResult().success("删除专题应用表成功");
    }

    /**
     * 编辑专题应用表
     */
//    @RequiresPermissions("XXX:XXX:edit")
    @RequestMapping("/edit")
    public  String edit(@RequestParam String id,Model model){
		model.addAttribute("id",id);
		return "dir/configure/specialapp/specialappEdit";
    }

//    @RequiresPermissions("XXX:XXX:edit")
    @RequestMapping("/editLoad")
    @ResponseBody
    public  HandleResult editLoad(@RequestParam String id){
		HandleResult handleResult = new HandleResult();
		try {
            DirSpecialAppsVo vo = service.selectVoById(id);
		    handleResult.put("vo", vo);
		} catch (Exception e) {
		    handleResult.error("获取专题应用表信息失败");
		    logger.error("获取专题应用表信息失败", e);
		}
		return handleResult;
		}

    /**
     * 执行编辑
     */
//    @RequiresPermissions("XXX:XXX:edit")
    @Log("编辑专题应用表")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(DirSpecialAppsVo entity,@RequestParam(value="file",required=false)MultipartFile file,  
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
    
    
    /**
	 * category树形添加
	 */
//	@RequiresPermissions("")
	@RequestMapping("/categoryTree")
	@ResponseBody
	public HandleResult getCategoryListForLoginUser(@RequestParam Map<String, Object> paramMap) {
		HandleResult handleResult = new HandleResult();
		try {
			String parentCode = (String) paramMap.get("parentCode");
			if (StringUtils.isEmpty(parentCode)) {
				paramMap.put("parentCode", null);
			}
			List<SysDictVo> sysDictVoList = service2.selectVoListForTreeDataForApp(paramMap);
			handleResult.put("vo", sysDictVoList);
		} catch (Exception e) {
			handleResult.error("根据登录用户的权限获取应用分类信息失败");
			logger.error("根据登录用户的权限获取应用分类表信息失败", e);
		}
		return handleResult;
	}
	@RequestMapping("/loadCategory")
    @ResponseBody
    public  HandleResult loadCategory(@RequestParam String dictCode){
		HandleResult handleResult = new HandleResult();
		try {
            SysDictVo vo = mapper.selectVoCategoryApp(dictCode);
		    handleResult.put("vo", vo);
		} catch (Exception e) {
		    handleResult.error("获取专题应用类别信息失败");
		    logger.error("获取专题应用类别信息失败", e);
		}
		return handleResult;
		}
	
	
}
