package com.chinawiserv.dsp.dir.controller.feedback;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.dir.entity.vo.feedback.DirDataCorrectionVo;
import com.chinawiserv.dsp.dir.service.feedback.IDirDataCorrectionService;
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
 * 数据纠错记录 前端控制器
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
@Controller
@RequestMapping("/feedback/dirdatacorrection")
//todo 将所有的XXX修改为真实值
public class DirDataCorrectionController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IDirDataCorrectionService service;

    @RequiresPermissions("feedback:dirdatacorrection")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap){
		setCurrentMenuInfo(paramMap);
    	return "feedback/datacorrection/datacorrectionList";
    }

    /**
     * 分页查询数据纠错记录
     */
    @RequiresPermissions("feedback:dirdatacorrection:list")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String , Object> paramMap){
		PageResult pageResult = new PageResult();
        int minRoleLevl  = ShiroUtils.getLoginUser().getMinRoleLevel();
        String depId = ShiroUtils.getLoginUserDeptId();
        //非超管和区域管理员，则要做权限过滤
        if(minRoleLevl>0){
            if(!StringUtils.isEmpty(depId)){
                //查找当前用户拥有权限的目录类别的数据集，以及本部门及子部门的数据集，以及分配了其他部门权限的数据集
                paramMap.put("userId",ShiroUtils.getLoginUserId());
            }else{ //非超管和区域管理员,又没部门,直接不让看所有数据
                return null;
            }
        }
		try {
		    Page<DirDataCorrectionVo> page = service.selectVoPage(paramMap);
		    pageResult.setPage(page);
		} catch (Exception e) {
		    pageResult.error("分页查询数据纠错记录出错");
		    logger.error("分页查询数据纠错记录出错", e);
		}
		return pageResult;
    }
    /**
     * 查询数据集纠错详情
     */
    @RequiresPermissions("feedback:dirdatacorrection:list")
    @RequestMapping("/detail")
    @ResponseBody
    public PageResult detail(@RequestParam Map<String , Object> paramMap){
        PageResult pageResult = new PageResult();
        try {
            Page<DirDataCorrectionVo> page = service.selectDetailByDcmId(paramMap);
            pageResult.setPage(page);
        } catch (Exception e) {
            pageResult.error("分页查询数据纠错记录出错");
            logger.error("分页查询数据纠错记录出错", e);
        }
        return pageResult;
    }

    /**
     * 新增数据纠错记录
     */
    @RequiresPermissions("feedback:dirdatacorrection:add")
    @RequestMapping("/add")
    public  String add(){
		return "XXX/XXX/XXXAdd";
    }

    /**
     * 执行新增
     */
    @RequiresPermissions("feedback:dirdatacorrection:add")
    @Log("创建数据纠错记录")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(DirDataCorrectionVo entity){
		HandleResult handleResult = new HandleResult();
		try {
		    service.insertVO(entity);
		    handleResult.success("创建数据纠错记录成功");
		} catch (Exception e) {
		    handleResult.error("创建数据纠错记录失败");
		    logger.error("创建数据纠错记录失败", e);
		}
		return handleResult;
    }

    /**
     * 删除数据纠错记录
     */
    @RequiresPermissions("feedback:dirdatacorrection:delete")
    @Log("删除数据纠错记录")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(@RequestParam String id){
		//todo 逻辑删除
    	//service.deleteById(id);
		return new HandleResult().success("删除数据纠错记录成功");
    }

    /**
     * 编辑数据纠错记录
     */
    @RequiresPermissions("feedback:dirdatacorrection:edit")
    @RequestMapping("/edit")
    public  String edit(@RequestParam String id,Model model){
		model.addAttribute("id",id);
		return "XXX/XXX/XXXEdit";
    }

    @RequiresPermissions("feedback:dirdatacorrection:edit")
    @RequestMapping("/editLoad")
    @ResponseBody
    public  HandleResult editLoad(@RequestParam String id){
		HandleResult handleResult = new HandleResult();
		try {
            DirDataCorrectionVo vo = service.selectVoById(id);
		    handleResult.put("vo", vo);
		} catch (Exception e) {
		    handleResult.error("获取数据纠错记录信息失败");
		    logger.error("获取数据纠错记录信息失败", e);
		}
		return handleResult;
		}

    /**
     * 执行编辑
     */
    @RequiresPermissions("feedback:dirdatacorrection:edit")
    @Log("编辑数据纠错记录")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(DirDataCorrectionVo entity,Model model){
		HandleResult handleResult = new HandleResult();
		try {
		    service.updateVO(entity);
		    handleResult.success("编辑数据纠错记录成功");
		} catch (Exception e) {
		    handleResult.error("编辑数据纠错记录失败");
		    logger.error("编辑数据纠错记录失败", e);
		}
		return handleResult;
    }
}
