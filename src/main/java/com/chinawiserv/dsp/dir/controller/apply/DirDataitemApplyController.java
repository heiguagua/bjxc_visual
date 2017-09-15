package com.chinawiserv.dsp.dir.controller.apply;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.dir.entity.vo.apply.DirDataitemApplyVo;
import com.chinawiserv.dsp.dir.enums.EnumTools;
import com.chinawiserv.dsp.dir.enums.apply.DataItemStatus;
import com.chinawiserv.dsp.dir.service.apply.IDirDataitemApplyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 数据项权限申请表 前端控制器
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
@Controller
@RequestMapping("/dirDataitemApply")
//todo 将所有的XXX修改为真实值
public class DirDataitemApplyController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IDirDataitemApplyService service;

//    @RequiresPermissions("XXX:XXX:list")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap){
		setCurrentMenuInfo(paramMap);
    	return "apply/dataItem/dirDataitemList";
    }

    /**
     * 分页查询共享审核消息申请表
     */
//    @RequiresPermissions("XXX:XXX:list")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult List(@RequestParam Map<String , Object> paramMap){
        PageResult pageResult = new PageResult();
        try {
            Page<DirDataitemApplyVo> page = service.selectVoPage(paramMap);
            pageResult.setPage(page);
        } catch (Exception e) {
            pageResult.error("分页查询共享审核消息申请表出错");
            logger.error("分页查询共享审核消息申请表出错", e);
        }
        return pageResult;
    }

    /**
     * 分页查询共享审核消息申请表
     */
//    @RequiresPermissions("XXX:XXX:list")
    @RequestMapping("/list/details")
    @ResponseBody
    public PageResult ListDetails(@RequestParam Map<String , Object> paramMap){
        PageResult pageResult = new PageResult();
        try {
            Page<DirDataitemApplyVo> page = service.selectVoPageDetails(paramMap);
            pageResult.setPage(page);

        } catch (Exception e) {
            pageResult.error("分页查询共享审核消息详情出错");
            logger.error("分页查询共享审核消息详情出错", e);
        }
        return pageResult;
    }

    /**
     * 新增数据项权限申请表
     */
    @RequiresPermissions("XXX:XXX:add")
    @RequestMapping("/add")
    public  String add(){
		return "XXX/XXX/XXXAdd";
    }

    /**
     * 执行新增
     */
    @RequiresPermissions("XXX:XXX:add")
    @Log("创建数据项权限申请表")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(DirDataitemApplyVo entity){
		HandleResult handleResult = new HandleResult();
		try {
		    service.insertVO(entity);
		    handleResult.success("创建数据项权限申请表成功");
		} catch (Exception e) {
		    handleResult.error("创建数据项权限申请表失败");
		    logger.error("创建数据项权限申请表失败", e);
		}
		return handleResult;
    }

    /**
     * 删除数据项权限申请表
     */
    @RequiresPermissions("XXX:XXX:delete")
    @Log("删除数据项权限申请表")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(@RequestParam String id){
		//todo 逻辑删除
    	//service.deleteById(id);
		return new HandleResult().success("删除数据项权限申请表成功");
    }

    /**
     * 编辑数据项权限申请表
     */
    @RequiresPermissions("XXX:XXX:edit")
    @RequestMapping("/edit")
    public  String edit(@RequestParam String id,Model model){
		model.addAttribute("id",id);
		return "apply/dataItem/dirDataitemList";
    }

//    @RequiresPermissions("XXX:XXX:edit")
    @RequestMapping("/editLoad")
    @ResponseBody
    public  HandleResult editLoad(@RequestParam String id){
		HandleResult handleResult = new HandleResult();
		try {
            DirDataitemApplyVo vo = service.selectVoById(id);
		    handleResult.put("vo", vo);
		} catch (Exception e) {
		    handleResult.error("获取数据项权限申请表信息失败");
		    logger.error("获取数据项权限申请表信息失败", e);
		}
		return handleResult;
		}

    /**
     * 执行编辑
     */
//    @RequiresPermissions("XXX:XXX:edit")
    @Log("编辑数据项权限申请表")
    @RequestMapping(value = "/doEdit",method = RequestMethod.PUT)
    @ResponseBody
    public  HandleResult doEdit(@RequestBody DirDataitemApplyVo dirDataitemApplyVo){
		HandleResult handleResult = new HandleResult();
		try {
            if (dirDataitemApplyVo.getOpration()){
                dirDataitemApplyVo.setStatus("1");
            }
            else {
                dirDataitemApplyVo.setStatus("2");
            }
            dirDataitemApplyVo.setDataItemStateName(DataItemStatus.valueOf(EnumTools.getName(dirDataitemApplyVo.getStatus())).getChValue());
		    service.updateVO(dirDataitemApplyVo);
		    handleResult.success("编辑数据项权限申请表成功");
		} catch (Exception e) {
		    handleResult.error("编辑数据项权限申请表失败");
		    logger.error("编辑数据项权限申请表失败", e);
		}
		return handleResult;
    }
}
