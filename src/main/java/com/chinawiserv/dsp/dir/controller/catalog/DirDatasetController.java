package com.chinawiserv.dsp.dir.controller.catalog;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.dir.entity.po.catalog.DrapDataset;
import com.chinawiserv.dsp.dir.entity.po.catalog.DrapDatasetItem;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDataitemVo;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetClassifyMapVo;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetVo;
import com.chinawiserv.dsp.dir.enums.catalog.Dataset;
import com.chinawiserv.dsp.dir.service.catalog.IDirDataitemService;
import com.chinawiserv.dsp.dir.service.catalog.IDirDatasetService;
import com.chinawiserv.dsp.dir.service.catalog.IDirDatasetSourceRelationService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * <p>
 * 数据集（信息资源） 前端控制器
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
@Controller
@RequestMapping("/catalog")
public class DirDatasetController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IDirDatasetService service;

    @Autowired
    private IDirDataitemService dataitemService;

    @Autowired
    private IDirDatasetSourceRelationService relationService;

    @RequestMapping("/catalogue")
    public  String init(@RequestParam Map<String , Object> paramMap){
		setCurrentMenuInfo(paramMap);
    	return "catalog/catalogue/catalogueList";
    }

    @RequestMapping("/registe")
    public  String registeInit(@RequestParam Map<String , Object> paramMap){
        setCurrentMenuInfo(paramMap);
        return "catalog/registe/registeList";
    }

    @RequestMapping("/audit")
    public  String auditInit(@RequestParam Map<String , Object> paramMap){
        setCurrentMenuInfo(paramMap);
        return "catalog/audit/auditList";
    }

    @RequestMapping("/auditInfo")
    public  String auditInfo(@RequestParam String id, Model model){
        model.addAttribute("id", id);
        return "catalog/audit/auditInfo";
    }

    @RequestMapping("/release")
    public  String releaseInit(@RequestParam Map<String , Object> paramMap){
        setCurrentMenuInfo(paramMap);
        return "catalog/release/releaseList";
    }

    @RequestMapping("/query")
    public  String queryInit(@RequestParam Map<String , Object> paramMap){
        setCurrentMenuInfo(paramMap);
        return "catalog/query/queryList";
    }

    /**
     * 分页查询信息资源列表（编目）
     */
    @RequiresPermissions("catalog:catalogue:list")
    @RequestMapping("/catalogue/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String , Object> paramMap){
		PageResult pageResult = new PageResult();
		try {
		    Page<DirDatasetVo> page = service.selectVoPage(paramMap);
		    pageResult.setPage(page);
		} catch (Exception e) {
		    pageResult.error("分页查询数据集（编目）出错");
		    logger.error("分页查询数据集（编目）出错", e);
		}
		return pageResult;
    }

    /**
     * 分页查询信息资源列表（注册）
     */
    @RequiresPermissions("catalog:registe:list")
    @RequestMapping("/registe/list")
    @ResponseBody
    public PageResult registeList(@RequestParam Map<String , Object> paramMap){
        PageResult pageResult = new PageResult();
        try {
            if(paramMap == null){
                paramMap = new HashMap<>();
            }
            paramMap.put("allStatus",new String[]{"0","2","4","6"}); //查询过滤状态为待注册、审核不通过、审核驳回的数据
            Page<DirDatasetClassifyMapVo> page = service.selectClassifyMapVoPage(paramMap);
            pageResult.setPage(page);
        } catch (Exception e) {
            pageResult.error("分页查询数据集（注册）出错");
            logger.error("分页查询数据集（注册）出错", e);
        }
        return pageResult;
    }

    /**
     * 分页查询信息资源列表（审核）
     */
    @RequiresPermissions("catalog:audit:list")
    @RequestMapping("/audit/list")
    @ResponseBody
    public PageResult auditList(@RequestParam Map<String , Object> paramMap){
        PageResult pageResult = new PageResult();
        try {
            paramMap.put("status","1"); //查询过滤状态为待审核的数据
            Page<DirDatasetClassifyMapVo> page = service.selectClassifyMapVoPage(paramMap);
            pageResult.setPage(page);
        } catch (Exception e) {
            pageResult.error("分页查询数据集（审核）出错");
            logger.error("分页查询数据集（审核）出错", e);
        }
        return pageResult;
    }

    /**
     * 分页查询信息资源列表（未发布）
     */
    @RequiresPermissions("catalog:release:list")
    @RequestMapping("/unRelease/list")
    @ResponseBody
    public PageResult unReleaseList(@RequestParam Map<String , Object> paramMap){
        PageResult pageResult = new PageResult();
        try {
            paramMap.put("status","3"); //查询过滤状态为待发布的数据
            Page<DirDatasetClassifyMapVo> page = service.selectClassifyMapVoPage(paramMap);
            pageResult.setPage(page);
        } catch (Exception e) {
            pageResult.error("分页查询数据集（未发布）出错");
            logger.error("分页查询数据集（未发布）出错", e);
        }
        return pageResult;
    }

    /**
     * 分页查询信息资源列表（已发布）
     */
    @RequiresPermissions("catalog:release:list")
    @RequestMapping("/released/list")
    @ResponseBody
    public PageResult releasedList(@RequestParam Map<String , Object> paramMap){
        PageResult pageResult = new PageResult();
        try {
            paramMap.put("status","5"); //查询过滤状态为已发布的数据
            Page<DirDatasetClassifyMapVo> page = service.selectReleasedClassifyMapVoPage(paramMap);
            pageResult.setPage(page);
        } catch (Exception e) {
            pageResult.error("分页查询数据集（已发布）出错");
            logger.error("分页查询数据集（已发布）出错", e);
        }
        return pageResult;
    }

    /**
     * 分页查询信息资源列表（目录查询）
     */
    @RequiresPermissions("catalog:query:list")
    @RequestMapping("/query/list")
    @ResponseBody
    public PageResult queryList(@RequestParam Map<String , Object> paramMap){
        PageResult pageResult = new PageResult();
        try {
            Page<DirDatasetClassifyMapVo> page = service.selectClassifyMapVoPage(paramMap);
            pageResult.setPage(page);
        } catch (Exception e) {
            pageResult.error("分页查询数据集（目录查询）出错");
            logger.error("分页查询数据集（目录查询）出错", e);
        }
        return pageResult;
    }

    /**
     * 新增数据集（信息资源）
     */
    @RequiresPermissions("catalog:catalogue:add")
    @RequestMapping("/catalogue/add")
    public  String add(){
		return "catalog/catalogue/catalogueAdd";
    }

    /**
     * 执行新增
     */
    @RequiresPermissions("catalog:catalogue:add")
    @Log("创建数据集（信息资源）")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(DirDatasetVo entity){
		HandleResult handleResult = new HandleResult();
		try {
		    service.insertVO(entity);
		    handleResult.success("创建数据集（信息资源）成功");
		} catch (Exception e) {
		    handleResult.error("创建数据集（信息资源）失败");
		    logger.error("创建数据集（信息资源）失败", e);
		}
		return handleResult;
    }

    /**
     * 删除数据集（信息资源）
     */
    @RequiresPermissions("XXX:XXX:delete")
    @Log("删除数据集（信息资源）")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(@RequestParam String id){
		//todo 逻辑删除
    	//service.deleteById(id);
		return new HandleResult().success("删除数据集（信息资源）成功");
    }

    /**
     * 编辑数据集（信息资源）
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
            DirDatasetVo vo = service.selectVoById(id);
		    handleResult.put("vo", vo);
		} catch (Exception e) {
		    handleResult.error("获取数据集（信息资源）信息失败");
		    logger.error("获取数据集（信息资源）信息失败", e);
		}
		return handleResult;
		}

    /**
     * 执行编辑
     */
    @RequiresPermissions("XXX:XXX:edit")
    @Log("编辑数据集（信息资源）")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(DirDatasetVo entity,Model model){
		HandleResult handleResult = new HandleResult();
		try {
		    service.updateVO(entity);
		    handleResult.success("编辑数据集（信息资源）成功");
		} catch (Exception e) {
		    handleResult.error("编辑数据集（信息资源）失败");
		    logger.error("编辑数据集（信息资源）失败", e);
		}
		return handleResult;
    }

    /**
     * 执行注册
     */
    @RequiresPermissions("catalog:registe:save")
    @Log("信息资源注册")
    @RequestMapping("/registe/doRegiste")
    @ResponseBody
    public  HandleResult doRegiste(String dcmIds){
        HandleResult handleResult = new HandleResult();
        try {
            boolean registerResult = service.registe(dcmIds);
            if(registerResult){
                handleResult.success("注册成功");
            }else{
                handleResult.error("注册失败");
            }
        } catch (Exception e) {
            handleResult.error("信息资源注册失败");
            logger.error("信息资源注册失败", e);
        }
        return handleResult;
    }

    /**
     * 执行审核
     */
    @RequiresPermissions("catalog:audit:save")
    @Log("信息资源审核")
    @RequestMapping("/audit/doAudit")
    @ResponseBody
    public  HandleResult doAudit(@RequestParam Map<String , Object> paramMap){
        HandleResult handleResult = new HandleResult();
        try {
            boolean auditResult = service.audit(paramMap);
            if(auditResult){
                handleResult.success("审核成功");
            }else{
                handleResult.error("审核失败");
            }
        } catch (Exception e) {
            handleResult.error("信息资源审核失败");
            logger.error("信息资源审核失败", e);
        }
        return handleResult;
    }

    /**
     * 执行发布到互联网
     */
    @RequiresPermissions("catalog:release:save")
    @Log("信息资源发布到互联网")
    @RequestMapping("/release/releaseToInternet")
    @ResponseBody
    public  HandleResult releaseToInternet(@RequestParam String dcmId){
        HandleResult handleResult = new HandleResult();
        try {
            Map<String,Object> params = new HashMap<>();
            params.put("dcmId",dcmId);
            params.put("publishType", Dataset.PublishType.ToNet.getKey());
            boolean releaseResult = service.release(params);
            if(releaseResult){
                handleResult.success("发布成功");
            }else{
                handleResult.error("发布失败");
            }
        } catch (Exception e) {
            handleResult.error("信息资源发布到互联网失败");
            logger.error("信息资源发布到互联网失败", e);
        }
        return handleResult;
    }

    /**
     * 执行发布到电子政务外网
     */
    @RequiresPermissions("catalog:release:save")
    @Log("信息资源发布到电子政务外网")
    @RequestMapping("/release/releaseToDzzw")
    @ResponseBody
    public  HandleResult releaseToDzzw(@RequestParam String dcmId){
        HandleResult handleResult = new HandleResult();
        try {
            Map<String,Object> params = new HashMap<>();
            params.put("dcmId",dcmId);
            params.put("publishType", Dataset.PublishType.ToDzzw.getKey());
            boolean releaseResult = service.release(params);
            if(releaseResult){
                handleResult.success("发布成功");
            }else{
                handleResult.error("发布失败");
            }
        } catch (Exception e) {
            handleResult.error("信息资源发布到电子政务外网失败");
            logger.error("信息资源发布到电子政务外网失败", e);
        }
        return handleResult;
    }

    /**
     * 执行同时发布
     */
    @RequiresPermissions("catalog:release:save")
    @Log("信息资源同时发布")
    @RequestMapping("/release/releaseAll")
    @ResponseBody
    public  HandleResult releaseAll(@RequestParam String dcmId){
        HandleResult handleResult = new HandleResult();
        try {
            Map<String,Object> params = new HashMap<>();
            params.put("dcmId",dcmId);
            params.put("publishType", Dataset.PublishType.ToAll.getKey());
            boolean releaseResult = service.release(params);
            if(releaseResult){
                handleResult.success("发布成功");
            }else{
                handleResult.error("发布失败");
            }
        } catch (Exception e) {
            handleResult.error("信息资源同时发布失败");
            logger.error("信息资源同时发布失败", e);
        }
        return handleResult;
    }

    /**
     * 执行审核驳回
     */
    @RequiresPermissions("catalog:release:audit")
    @Log("审核驳回信息资源")
    @RequestMapping("/release/auditReject")
    @ResponseBody
    public  HandleResult auditReject(@RequestParam String dcmId){
        HandleResult handleResult = new HandleResult();
        try {
            boolean auditResult = service.auditReject(dcmId);
            if(auditResult){
                handleResult.success("驳回成功");
            }else{
                handleResult.error("驳回失败");
            }
        } catch (Exception e) {
            handleResult.error("信息资源审核驳回失败");
            logger.error("信息资源审核驳回失败", e);
        }
        return handleResult;
    }

    /**
     * 执行下架
     */
    @RequiresPermissions("catalog:release:off")
    @Log("信息资源下架")
    @RequestMapping("/release/offline")
    @ResponseBody
    public  HandleResult offline(@RequestParam String dcmId){
        HandleResult handleResult = new HandleResult();
        try {
            boolean offlineResult = service.offline(dcmId);
            if(offlineResult){
                handleResult.success("下架成功");
            }else{
                handleResult.error("下架失败");
            }
        } catch (Exception e) {
            handleResult.error("信息资源下架失败");
            logger.error("信息资源下架失败", e);
        }
        return handleResult;
    }


    /**
     * 获取梳理数据集详情
     * @param id
     * @return
     */
    @RequestMapping("/getDrapDatasetDetail")
    @ResponseBody
    public HandleResult getDrapDatasetDetail(String id){
        HandleResult result = new HandleResult();
        if(StringUtils.isEmpty(id)){
            result.error("参数不能为空");
        }else{
            DrapDataset drapdataset = service.getDrapDatasetDetail(id);
            result.put("result",drapdataset);
        }
        return result;
    }
    /**
     * 从资源添加数据集-快速添加页面
     */
    @RequestMapping("/catalogue/quickAddDatasetUI")
    public  String quickAddDatasetUI(){
        return "catalog/catalogue/quickAddDatasetUI";
    }
    /**
     * 从系统添加数据集-快速添加页面
     */
    @RequestMapping("/catalogue/quickSystemAddDatasetUI")
    public  String quickSystemAddDatasetUI(){
        return "catalog/catalogue/quickSystemAddDatasetUI";
    }
    /**
     * 从资源/系统添加数据集-快速添加
     * @param entity
     * @param model
     * @return
     */
    @RequestMapping("/quickAddDataset")
    @ResponseBody
    public  HandleResult quickAddDataset(DirDatasetVo entity, Model model){
        HandleResult handleResult = new HandleResult();
        try {
            service.insertVO(entity);
            relationService.insertDatasetListRelation(entity.getRelations(), entity.getId());
            handleResult.success("创建数据集（信息资源）成功");
        } catch (Exception e) {
            handleResult.error("创建数据集（信息资源）失败");
            logger.error("创建数据集（信息资源）失败", e);
        }
        return handleResult;
    }

    /**
     * 获取业务
     * @param dept_id
     * @param model
     * @return
     */
    @RequestMapping("/selectActivityByDeptId")
    @ResponseBody
    public  HandleResult selectActivityByDeptId(@RequestParam String dept_id,Model model){
        HandleResult handleResult = new HandleResult();
        if(StringUtils.isEmpty(dept_id)){
            handleResult.error("部门参数不能为空！");
        }else{
            List<Map<String, Object>> list = service.selectActivityByDeptId(dept_id);
            handleResult.put("list",list);
        }
        return handleResult;
    }

    /**
     * 获取数据集
     * @param activity_id
     * @param model
     * @return
     */
    @RequestMapping("/selectDatasetByActivityId")
    @ResponseBody
    public  HandleResult selectDatasetByActivityId(@RequestParam String activity_id,Model model){
        HandleResult handleResult = new HandleResult();
        if(StringUtils.isEmpty(activity_id)){
            handleResult.error("参数不能为空！");
        }else{
            List<Map<String, Object>> list = service.selectDatasetByActivityId(activity_id);
            handleResult.put("list",list);
        }
        return handleResult;
    }

    /**
     * 获取数据项
     * @param set_id
     * @param model
     * @return
     */
    @RequestMapping("/selectDatasetItemByDatasetId")
    @ResponseBody
    public  HandleResult selectDatasetItemByDatasetId(@RequestParam String set_id,Model model){
        HandleResult handleResult = new HandleResult();
        if(StringUtils.isEmpty(set_id)){
            handleResult.error("参数不能为空！");
        }else{
            List<DrapDatasetItem> list = service.selectDatasetItemByDatasetId(set_id);
            handleResult.put("list",list);
        }
        return handleResult;
    }

    /**
     * 检查在指定目录类别下的数据集名称是否重复
     * @param datasetName   数据集名称
     * @param classifyIds   目录类别ids
     * @return
     */
    @RequestMapping("/checkDatasetName")
    @ResponseBody
    public HandleResult checkDatasetName(@RequestParam(required = true) String datasetName, @RequestParam(required = true) String classifyIds){
        HandleResult handleResult = new HandleResult();
        try {
            boolean hasThisName = service.checkDatasetName(datasetName, classifyIds);
            handleResult.put("hasThisName",hasThisName);
        } catch (Exception e) {
            handleResult.error("检查数据集是否重名出错");
            logger.error("检查数据集是否重名出错", e);
        }
        return handleResult;
    }

    /**
     * 获取数据项
     * @param ids
     * @param model
     * @return
     */
    @RequestMapping("/selectDatasetItemByIds")
    @ResponseBody
    public  HandleResult selectDatasetItemByIds(String [] ids,Model model){
        HandleResult handleResult = new HandleResult();
        if(ids==null || ids.length==0){
            handleResult.error("参数不能为空！");
        }else{
            List<String> strings = new ArrayList<String>();
            for (String i:ids){
                strings.add(i);
            }
            List<DrapDatasetItem> list = service.selectDatasetItemByIds(strings);
            handleResult.put("list",list);
        }
        return handleResult;
    }
}
