package com.chinawiserv.dsp.dir.controller.drap;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapRequirementResourcesVo;
import com.chinawiserv.dsp.dir.service.drap.IDrapRequirementResourcesService;
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

import java.util.Map;

/**
 * <p>
 * 需求资源信息表 前端控制器
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Controller
@RequestMapping("/drapRequirementResources")
//todo 将所有的XXX修改为真实值
public class DrapRequirementResourcesController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IDrapRequirementResourcesService service;

//    @RequiresPermissions("XXX:XXX:list")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap){
		setCurrentMenuInfo(paramMap);
    	return "feedback/requirement/requirementList";
    }

    /**
     * 分页查询需求资源信息表
     */
//    @RequiresPermissions("XXX:XXX:list")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String , Object> paramMap){
		PageResult pageResult = new PageResult();
        int minRoleLevl  = ShiroUtils.getLoginUser().getMinRoleLevel();
        String deptId  = ShiroUtils.getLoginUser().getDeptId();
        //非超管和区域管理员，不让管理
        if(minRoleLevl>0){
            if(!StringUtils.isEmpty(deptId)){
                //查找当前用户拥有权限的目录类别的数据集，以及本部门及子部门的数据集，以及分配了其他部门权限的数据集
                paramMap.put("deptId",deptId);
            }else{ //非超管和区域管理员,又没部门,直接不让看所有数据
                return null;
            }
        }
		try {
		    Page<DrapRequirementResourcesVo> page = service.selectVoPage(paramMap);
		    pageResult.setPage(page);
		} catch (Exception e) {
		    pageResult.error("分页查询需求资源信息表出错");
		    logger.error("分页查询需求资源信息表出错", e);
		}
		return pageResult;
    }

    /**
     * 跳转需求资源详情表
     */
//    @RequiresPermissions("XXX:XXX:add")
    @RequestMapping("/loadDetailPage")
    public  String loadDetailPage(@RequestParam String id,Model model){
        model.addAttribute("requirementId",id);
		return "feedback/requirement/requirementDetail";
    }

    /**
     * 执行新增
     */
    @RequiresPermissions("XXX:XXX:add")
    @Log("创建需求资源信息表")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(DrapRequirementResourcesVo entity){
		HandleResult handleResult = new HandleResult();
		try {
		    service.insertVO(entity);
		    handleResult.success("创建需求资源信息表成功");
		} catch (Exception e) {
		    handleResult.error("创建需求资源信息表失败");
		    logger.error("创建需求资源信息表失败", e);
		}
		return handleResult;
    }

    /**
     * 删除需求资源信息表
     */
    @RequiresPermissions("XXX:XXX:delete")
    @Log("删除需求资源信息表")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(@RequestParam String id){
		//todo 逻辑删除
    	//service.deleteById(id);
		return new HandleResult().success("删除需求资源信息表成功");
    }

    /**
     * 编辑需求资源信息表
     */
    @RequiresPermissions("XXX:XXX:edit")
    @RequestMapping("/edit")
    public  String edit(@RequestParam String id,Model model){
		model.addAttribute("id",id);
		return "XXX/XXX/XXXEdit";
    }

//    @RequiresPermissions("XXX:XXX:edit")
    @RequestMapping("/loadDetail")
    @ResponseBody
    public  HandleResult loadDetail(@RequestParam String id){
		HandleResult handleResult = new HandleResult();
		try {
            DrapRequirementResourcesVo vo = service.selectVoById(id);
		    handleResult.put("vo", vo);
		} catch (Exception e) {
		    handleResult.error("获取需求资源信息表信息失败");
		    logger.error("获取需求资源信息表信息失败", e);
		}
		return handleResult;
		}

    /**
     * 执行编辑
     */
    @RequiresPermissions("XXX:XXX:edit")
    @Log("编辑需求资源信息表")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(DrapRequirementResourcesVo entity,Model model){
		HandleResult handleResult = new HandleResult();
		try {
		    service.updateVO(entity);
		    handleResult.success("编辑需求资源信息表成功");
		} catch (Exception e) {
		    handleResult.error("编辑需求资源信息表失败");
		    logger.error("编辑需求资源信息表失败", e);
		}
		return handleResult;
    }
}
