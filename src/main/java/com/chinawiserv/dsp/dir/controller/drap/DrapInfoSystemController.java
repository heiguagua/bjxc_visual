package com.chinawiserv.dsp.dir.controller.drap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapInfoSystem;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapSystemUseDept;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapSystemUseInfo;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapInfoSystemVo;
import com.chinawiserv.dsp.dir.service.drap.IDrapInfoSystemService;
import com.chinawiserv.dsp.dir.service.drap.IDrapSystemUseDeptService;
import com.chinawiserv.dsp.dir.service.drap.IDrapSystemUseInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 信息系统表 前端控制器
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Controller
@RequestMapping("/drap/drapInfoSystem")
//todo 将所有的XXX修改为真实值
public class DrapInfoSystemController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IDrapInfoSystemService service;

    @Autowired
    private IDrapSystemUseInfoService useInfoService;

    @Autowired
    private IDrapSystemUseDeptService useDeptService;

    @RequiresPermissions("XXX:XXX:list")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap){
		setCurrentMenuInfo(paramMap);
    	return "XXX/XXX/XXXList";
    }

    /**
     * 分页查询信息系统表
     */
    @RequiresPermissions("XXX:XXX:list")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String , Object> paramMap){
		PageResult pageResult = new PageResult();
		try {
		    Page<DrapInfoSystemVo> page = service.selectVoPage(paramMap);
		    pageResult.setPage(page);
		} catch (Exception e) {
		    pageResult.error("分页查询信息系统表出错");
		    logger.error("分页查询信息系统表出错", e);
		}
		return pageResult;
    }

    /**
     * 新增信息系统表
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
    @Log("创建信息系统表")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(DrapInfoSystemVo entity){
		HandleResult handleResult = new HandleResult();
		try {
		    service.insertVO(entity);
		    handleResult.success("创建信息系统表成功");
		} catch (Exception e) {
		    handleResult.error("创建信息系统表失败");
		    logger.error("创建信息系统表失败", e);
		}
		return handleResult;
    }

    /**
     * 删除信息系统表
     */
    @RequiresPermissions("XXX:XXX:delete")
    @Log("删除信息系统表")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(@RequestParam String id){
		//todo 逻辑删除
    	//service.deleteById(id);
		return new HandleResult().success("删除信息系统表成功");
    }

    /**
     * 编辑信息系统表
     */
    @RequiresPermissions("XXX:XXX:edit")
    @RequestMapping("/edit")
    public  String edit(@RequestParam String id,Model model){
		model.addAttribute("id",id);
		return "XXX/XXX/XXXEdit";
    }

    @RequiresPermissions("XXX:XXX:edit")
    @RequestMapping("/editLoad")
    @ResponseBody
    public  HandleResult editLoad(@RequestParam String id){
		HandleResult handleResult = new HandleResult();
		try {
            DrapInfoSystemVo vo = service.selectVoById(id);
		    handleResult.put("vo", vo);
		} catch (Exception e) {
		    handleResult.error("获取信息系统表信息失败");
		    logger.error("获取信息系统表信息失败", e);
		}
		return handleResult;
		}

    /**
     * 执行编辑
     */
    @RequiresPermissions("XXX:XXX:edit")
    @Log("编辑信息系统表")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(DrapInfoSystemVo entity,Model model){
		HandleResult handleResult = new HandleResult();
		try {
		    service.updateVO(entity);
		    handleResult.success("编辑信息系统表成功");
		} catch (Exception e) {
		    handleResult.error("编辑信息系统表失败");
		    logger.error("编辑信息系统表失败", e);
		}
		return handleResult;
    }

    @RequestMapping("/api/receiveDate")
    public void receiveMessega(@RequestParam String  data, HttpServletResponse response){

        System.out.println(data);
        updateReceiveDate(data);
        response.setStatus(200);

    }

    public void updateReceiveDate(String data){

        Map<String,Object> paraMap = JSON.parseObject(data, new TypeReference<Map<String,Object>>(){});

        List<DrapInfoSystem> systems= (List<DrapInfoSystem>) paraMap.get("infoSystems");
        service.insertBatch(systems);

        List<DrapSystemUseInfo> useInfos = (List<DrapSystemUseInfo>) paraMap.get("systemUseInfos");
        useInfoService.insertBatch(useInfos);

        List<DrapSystemUseDept> systemUseDepts = (List<DrapSystemUseDept>) paraMap.get("systemUseDepts");
        useDeptService.insertBatch(systemUseDepts);

    }
}
