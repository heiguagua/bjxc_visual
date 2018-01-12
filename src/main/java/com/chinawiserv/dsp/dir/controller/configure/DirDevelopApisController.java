package com.chinawiserv.dsp.dir.controller.configure;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.dir.entity.po.configure.DirDevelopApis;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirDevelopApisVo;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirHomeVo;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirNewsVo;
import com.chinawiserv.dsp.dir.mapper.configure.DirDevelopApisMapper;
import com.chinawiserv.dsp.dir.service.configure.IDirDevelopApisService;
import net.sf.json.JSONObject;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 开发者工具 前端控制器
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
@Controller
@RequestMapping("/portalConfig/dirDevelopApis")
//todo 将所有的XXX修改为真实值
public class DirDevelopApisController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IDirDevelopApisService service;
    
    @Autowired
    private DirDevelopApisMapper mapper;

    @RequiresPermissions("portalConfig:dirDevelopApis")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap){
		setCurrentMenuInfo(paramMap);
    	return "dir/configure/api/apiList";
    }

    /**
     * 分页查询开发者工具
     */
    @RequiresPermissions("portalConfig:dirDevelopApis:list")
    @RequestMapping("/list")
    @ResponseBody
    public JSONObject loadZtree(@RequestParam Map<String , Object> paramMap){
    	Map<String, Object> params = new HashMap<>();
    	List<DirDevelopApis> listTree = null;
    	JSONObject jsonObject = new JSONObject();
		try {			
			listTree = service.getDirApiZtree();			
//			actionResponse.setCode(ActionResponseCode.OK);
            jsonObject.put("data", listTree);
//		    Page<DirDevelopApisVo> page = service.selectVoPage(paramMap);
//		    pageResult.setPage(page);
		} catch (Exception e) {
//		    pageResult.error("分页查询开发者工具出错");
		    logger.error("分页查询开发者工具出错", e);
		}
		return jsonObject;
    }
    
    
    /**
     * 分页查询api表
     */
    @RequiresPermissions("portalConfig:dirDevelopApis:list")
    @RequestMapping("/subList")
    @ResponseBody
    public PageResult subList(@RequestParam Map<String , Object> paramMap){
		PageResult pageResult = new PageResult();
		try {
			String fid = (String) paramMap.get("parentId");
			if (StringUtils.isEmpty(fid)) {
				paramMap.put("parentId", "root");
			}
		    Page<DirDevelopApisVo> page = service.selectVoPage(paramMap);
		    pageResult.setPage(page);
		} catch (Exception e) {
		    pageResult.error("分页查询新闻表出错");
		    logger.error("分页查询新闻表出错", e);
		}
		return pageResult;
    }

    /**
     * 新增开发者工具
     */
    @RequiresPermissions("portalConfig:dirDevelopApis:add")
    @RequestMapping("/add")
    public  String add(@RequestParam String parentId, Model model){
    	model.addAttribute("parentId",parentId);
		return "dir/configure/api/apiAdd";
    }

    /**
     * 执行新增
     */
    @RequiresPermissions("portalConfig:dirDevelopApis:add")
    @Log("创建开发者工具")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(DirDevelopApisVo entity, @RequestParam(value="file",required=true)MultipartFile file,  
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
		    handleResult.error("新增失败");
		    logger.error("新增失败", e);
		}
		return handleResult;
    }

    /**
     * 删除开发者工具
     */
    @RequiresPermissions("portalConfig:dirDevelopApis:delete")
    @Log("删除开发者工具")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(@RequestParam String id){
		//todo 逻辑删除
    	//service.deleteById(id);
    	List<DirDevelopApis> list = null;
    	list = mapper.getApiByParentId(id);
    	if(!list.isEmpty() && list!=null ){
    		return new HandleResult().error("此节点下有子集，无法删除");   
    	}
    	service.DeleteByFlag(id);
		return new HandleResult().success("删除开发者工具成功");
    }
    
    /**
     * 删除前验证是否有子api
     */    
    @Log("删除验证子集")
    @RequestMapping("/Isdelete")
    @ResponseBody
    public HandleResult Isdelete(String id){
		//todo 逻辑删除
    	//service.deleteById(id);
    	
    	
    	return new HandleResult().success("");
    }

    /**
     * 编辑开发者工具
     */
    @RequiresPermissions("portalConfig:dirDevelopApis:edit")
    @RequestMapping("/edit")
    public  String edit(@RequestParam String id,Model model){
		model.addAttribute("id",id);
		return "dir/configure/api/apiEdit";
    }

    @RequiresPermissions("portalConfig:dirDevelopApis:edit")
    @RequestMapping("/editLoad")
    @ResponseBody
    public  HandleResult editLoad(@RequestParam String id){
		HandleResult handleResult = new HandleResult();
		try {
            DirDevelopApisVo vo = service.selectVoById(id);
		    handleResult.put("vo", vo);
		} catch (Exception e) {
		    handleResult.error("获取开发者工具信息失败");
		    logger.error("获取开发者工具信息失败", e);
		}
		return handleResult;
		}

    /**
     * 执行编辑
     */
    @RequiresPermissions("portalConfig:dirDevelopApis:edit")
    @Log("编辑开发者工具")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(DirDevelopApisVo entity,@RequestParam(value="file",required=false)MultipartFile file,  
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
