package com.chinawiserv.dsp.dir.controller.configure;



import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.dir.entity.po.configure.DirDevelopApis;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirDevelopApisVo;
import com.chinawiserv.dsp.dir.service.configure.IDirDevelopApisService;

import net.sf.json.JSONObject;

import org.apache.shiro.authz.annotation.RequiresPermissions;
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
@RequestMapping("/dirDevelopApis")
//todo 将所有的XXX修改为真实值
public class DirDevelopApisController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IDirDevelopApisService service;

//    @RequiresPermissions("dirDevelopApis:list")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap){
		setCurrentMenuInfo(paramMap);
    	return "dir/configure/api/apiList";
    }

    /**
     * 分页查询开发者工具
     */
//    @RequiresPermissions("XXX:XXX:list")
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
     * 新增开发者工具
     */
//    @RequiresPermissions("XXX:XXX:add")
    @RequestMapping("/add")
    public  String add(@RequestParam String parentId, Model model){
    	model.addAttribute("parentId",parentId);
		return "dir/configure/api/apiAdd";
    }

    /**
     * 执行新增
     */
//    @RequiresPermissions("XXX:XXX:add")
    @Log("创建开发者工具")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(DirDevelopApisVo entity){
		HandleResult handleResult = new HandleResult();
		try {
		    service.insertVO(entity);
		    handleResult.success("创建开发者工具成功");
		} catch (Exception e) {
		    handleResult.error("创建开发者工具失败");
		    logger.error("创建开发者工具失败", e);
		}
		return handleResult;
    }

    /**
     * 删除开发者工具
     */
//    @RequiresPermissions("XXX:XXX:delete")
    @Log("删除开发者工具")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(@RequestParam String id){
		//todo 逻辑删除
    	//service.deleteById(id);
    	service.DeleteByFlag(id);
		return new HandleResult().success("删除开发者工具成功");
    }

    /**
     * 编辑开发者工具
     */
//    @RequiresPermissions("XXX:XXX:edit")
    @RequestMapping("/edit")
    public  String edit(@RequestParam String id,Model model){
		model.addAttribute("id",id);
		return "dir/configure/api/apiEdit";
    }

//    @RequiresPermissions("XXX:XXX:edit")
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
//    @RequiresPermissions("XXX:XXX:edit")
    @Log("编辑开发者工具")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(DirDevelopApisVo entity,Model model){
		HandleResult handleResult = new HandleResult();
		try {
		    service.updateVO(entity);
		    handleResult.success("编辑开发者工具成功");
		} catch (Exception e) {
		    handleResult.error("编辑开发者工具失败");
		    logger.error("编辑开发者工具失败", e);
		}
		return handleResult;
    }
}
