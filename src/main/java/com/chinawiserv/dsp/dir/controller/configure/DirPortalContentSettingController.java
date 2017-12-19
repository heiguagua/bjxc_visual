package com.chinawiserv.dsp.dir.controller.configure;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.dir.entity.po.configure.DirDevelopApis;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirDevelopApisVo;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirIntrudeVo;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirPolicyVo;
import com.chinawiserv.dsp.dir.mapper.configure.DirDevelopApisMapper;
import com.chinawiserv.dsp.dir.mapper.configure.DirIntrudeMapper;
import com.chinawiserv.dsp.dir.service.configure.IDirDevelopApisService;
import com.chinawiserv.dsp.dir.service.configure.IDirIntrudeService;

import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 开发者工具 前端控制器
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
@Controller
@RequestMapping("/dirIntrude")
//todo 将所有的XXX修改为真实值
public class DirPortalContentSettingController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IDirIntrudeService service;
    
    @Autowired
    private DirIntrudeMapper mapper;

//    @RequiresPermissions("dirDevelopApis:list")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap){
		setCurrentMenuInfo(paramMap);
    	return "dir/configure/intrude/intrudeList";
    }

    /**
     * 分页查询开发者工具
     */
//  @RequiresPermissions("XXX:XXX:list")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String , Object> paramMap){
    	PageResult pageResult = new PageResult();
		try {
		    Page<DirIntrudeVo> page = service.selectVoPage(paramMap);
		    pageResult.setPage(page);
		} catch (Exception e) {
		    pageResult.error("分页查询网站简介内容表出错");
		    logger.error("分页查询网站简介内容表出错", e);
		}
		return pageResult;
    }

    /**
     * 新增网站简介内容
     */
    //@RequiresPermissions("XXX:XXX:add")
    @RequestMapping("/add")
    public  String add(){
		return "dir/configure/intrude/intrudeAdd";
    }

    /**
     * 执行新增
     */
//    @RequiresPermissions("XXX:XXX:add")
    @Log("创建网站简介内容")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(DirIntrudeVo entity){
		HandleResult handleResult = new HandleResult();
		try {
		    service.insertVO(entity);
		    handleResult.success("创建网站简介内容成功");
		} catch (Exception e) {
			if(e.getMessage().equals("内容太长，无法保存")){
				handleResult.error("内容太长，无法保存");
			    logger.error("内容太长，无法保存", e);
			}else{
				handleResult.error("创建门户内容失败");
			    logger.error("创建门户内容失败", e);
			}
		}
		return handleResult;
    }

    /**
     * 删除开发者工具
     */
//    @RequiresPermissions("XXX:XXX:delete")
    @Log("删除门户网站简介内容")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(@RequestParam String id){
		//todo 逻辑删除
    	//service.deleteById(id);
//    	List<DirDevelopApis> list = null;
//    	list = mapper.getApiByParentId(id);
//    	if(!list.isEmpty() && list!=null ){
//    		return new HandleResult().error("此节点下有子集，无法删除");   
//    	}
    	service.DeleteByFlag(id);
		return new HandleResult().success("删除门户网站简介内容成功");
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
//    @RequiresPermissions("XXX:XXX:edit")
    @RequestMapping("/edit")
    public  String edit(@RequestParam String id,Model model){
		model.addAttribute("id",id);
		return "dir/configure/intrude/intrudeEdit";
    }

//    @RequiresPermissions("XXX:XXX:edit")
    @RequestMapping("/editLoad")
    @ResponseBody
    public  HandleResult editLoad(@RequestParam String id){
		HandleResult handleResult = new HandleResult();
		try {
            DirIntrudeVo vo = service.selectVoById(id);
		    handleResult.put("vo", vo);
		} catch (Exception e) {
		    handleResult.error("获取网站简介内容失败");
		    logger.error("获取网站简介内容失败", e);
		}
		return handleResult;
		}

    /**
     * 执行编辑
     */
//    @RequiresPermissions("XXX:XXX:edit")
    @Log("编辑网站简介内容")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(DirIntrudeVo entity,Model model){
		HandleResult handleResult = new HandleResult();
		try {
			List<String> list = null;
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("id", entity.getId());
			paramMap.put("category", entity.getCategory());
			list = mapper.listExclude(paramMap);
			if(list==null || list.isEmpty()){
				service.updateVO(entity);
			    handleResult.success("编辑网站简介内容成功");
				
			}else{
				handleResult.error("已存在相关分类，请重新选择分类");
			}
		} catch (Exception e) {
			if(e.getMessage().equals("内容太长，无法保存")){
				handleResult.error("内容太长，无法保存");
			    logger.error("内容太长，无法保存", e);
			}else{
				handleResult.error("创建门户内容失败");
			    logger.error("创建门户内容失败", e);
			}
		}
		return handleResult;
    }
}
