package com.chinawiserv.dsp.dir.controller.catalog;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.common.util.DateTimeUtils;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.base.service.system.ISysDictService;
import com.chinawiserv.dsp.dir.entity.po.catalog.*;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDataitemVo;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetClassifyMapVo;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetVo;
import com.chinawiserv.dsp.dir.enums.catalog.Dataset;
import com.chinawiserv.dsp.dir.mapper.catalog.DirClassifyMapper;
import com.chinawiserv.dsp.dir.mapper.catalog.DirDatasetClassifyMapMapper;
import com.chinawiserv.dsp.dir.schema.ExportExcelUtil;
import com.chinawiserv.dsp.dir.service.catalog.IDirDataitemService;
import com.chinawiserv.dsp.dir.service.catalog.IDirDatasetService;
import com.chinawiserv.dsp.dir.service.catalog.IDirDatasetSourceRelationService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @Autowired
    private DirClassifyMapper classifyMapper;

    @Autowired
    private ISysDictService sysDictService;

    @Autowired
    private DirDatasetClassifyMapMapper dirDatasetClassifyMapMapper;

    @RequestMapping("/catalogue/excelImportUI")
    public  String excelImportUI(){
        return "catalog/catalogue/excelImportUI";
    }

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

    @RequestMapping("/show")
    public  String showInit(@RequestParam String id,Model model){
        model.addAttribute("id", id);
        return "catalog/catalogue/catalogueShow";
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
    @RequiresPermissions("catalog:catalogue:delete")
    @Log("删除数据集（信息资源）")
    @RequestMapping("/doDelete")
    @ResponseBody
    public HandleResult doDelete(@RequestParam String id){
        HandleResult handleResult = new HandleResult();
        try {
            boolean deleteResult = service.deleteById(id);
            if(deleteResult){
                handleResult.success("删除成功");
            }else{
                handleResult.error("删除失败");
            }
        } catch (Exception e) {
            handleResult.error("删除信息资源失败");
            logger.error("删除信息资源失败", e);
        }
        return handleResult;
    }

    /**
     * 编辑数据集（信息资源）
     */
    @RequiresPermissions("catalog:catalogue:edit")
    @RequestMapping("/edit")
    public  String edit(@RequestParam String id,Model model){
		model.addAttribute("id",id);
		return "catalog/catalogue/catalogueEdit";
    }

    @RequiresPermissions("catalog:catalogue:edit")
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
    @RequiresPermissions("catalog:catalogue:edit")
    @Log("编辑数据集（信息资源）")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(DirDatasetVo entity,Model model){
		HandleResult handleResult = new HandleResult();
		try {
		    service.updateVO(entity);
		    handleResult.success("编辑成功");
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
            DirDatasetSurvey survey = service.selectDrapSurveyByDatasetId(id);
            result.put("result",drapdataset);
            result.put("survey",survey);
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
     * 从爬虫添加数据集-快速添加页面
     */
    @RequestMapping("/catalogue/quickCsAddDatasetUI")
    public  String quickCsAddDatasetUI(){
        return "catalog/catalogue/quickCsAddDatasetUI";
    }
    /**
     * 从关系型添加数据集-快速添加页面
     */
    @RequestMapping("/catalogue/quickDcmAddDatasetUI")
    public  String quickDcmAddDatasetUI(){
        return "catalog/catalogue/quickDcmAddDatasetUI";
    }
    /**
     * 从非关系型添加数据集-快速添加页面
     */
    @RequestMapping("/catalogue/quickDcmNosqlAddDatasetUI")
    public  String quickDcmNosqlAddDatasetUI(){
        return "catalog/catalogue/quickDcmNosqlAddDatasetUI";
    }
    /**
     * 从资源/系统添加数据集-快速添加
     * @param entity
     * @param model
     * @return
     */
    @RequestMapping("/quickAddDataset")
    @ResponseBody
    public  HandleResult quickAddDataset(DirDatasetVo entity,Integer tableNumber, Model model){
        HandleResult handleResult = new HandleResult();
        if(verifyRelations(entity.getRelations(),tableNumber)){
            try {
                service.insertVO(entity);
                relationService.insertDatasetListRelation(entity.getRelations(), entity.getId());
                handleResult.success("创建数据集（信息资源）成功");
            } catch (Exception e) {
                handleResult.error("创建数据集（信息资源）失败");
                logger.error("创建数据集（信息资源）失败", e);
            }
        }else{
            handleResult.error("表间关系不足，请检查！");
        }
        return handleResult;
    }

    public boolean verifyRelations(List<DirDatasetSourceRelation> relations,Integer tableNumber){
        boolean b=true;
        if(relations!=null||(tableNumber!=null&&tableNumber!=1)){
            try {
                if(tableNumber-1 > relations.size()){
                    b=false;
                }
            } catch (Exception e) {
                b=false;
            }
        }
        return b;
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
    /**
     * 导出完整模板excel
     */
    @RequestMapping("/downloadDatasetExcel")
    public void downloadDatasetExcel(String classify_id,String dataset_name,String region_id,HttpServletRequest request, HttpServletResponse response) throws IOException {
        OutputStream os=null;
        Workbook wb=null;
        try {
            String [] tree_codes=null;
            if(!StringUtils.isEmpty(classify_id)){
                String[] split = classify_id.split(",");
                Set<String> strings = classifyMapper.selectClassifyByIds(split);
                tree_codes=new String[strings.size()];
                int i=0;
                for (String code:strings
                     ) {
                    tree_codes[i]=code;
                    i++;
                }
            }
            List<ExportDatasetExcel> list = service.selectExportLists(tree_codes, dataset_name, region_id);
            ExportExcelUtil util = new ExportExcelUtil();
            File file =util.getExcelDemoFile("excelTemplate/完整目录模板.xlsx");
            String sheetName="Sheet1";
            wb = util.writeNewExcel(file, sheetName,list);

            String time = DateTimeUtils.convertDateTime_YYYYMMDDHHMMSS(new Date());
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename="+ URLEncoder.encode("政务信息资源-"+time+".xlsx", "utf-8"));
            os = response.getOutputStream();
            wb.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            os.flush();
            os.close();
            wb.close();
        }
    }

    //excel导入
    @RequestMapping("/excelImport")
    @ResponseBody
    public HandleResult excelImport(@RequestParam(value="file",required=false)MultipartFile file,HttpServletRequest request, HttpServletResponse response){
        HandleResult handleResult = new HandleResult();
        if(file==null){
            handleResult.error("文件不能为空");
        }else{
            String originalFilename = file.getOriginalFilename();
            try {

                Workbook workbook = createWorkbook(file.getInputStream(), originalFilename);
                boolean b = addDirDataset(workbook.getSheetAt(0));
                if(b){
                    handleResult.setMsg("导入成功！");
                }else{
                    handleResult.error("导入失败!");
                }
            } catch (IOException e) {
                handleResult.error("文件不能为空");
            }
        }
        return handleResult;
    }

    private boolean addDirDataset(Sheet sheet){
        //存放数据集
        List<DirDataset> lists=new ArrayList<DirDataset>();
        //存放数据项
        List<DirDataitemVo> items=new ArrayList<DirDataitemVo>();
        //存放数据集-目录中间关系
        List<DirDatasetClassifyMapVo> datamapList = new ArrayList<DirDatasetClassifyMapVo>();
        //存放新增数据集
        List<DirDataset> datasetList = new ArrayList<DirDataset>();
        DirDataset dataset=null;
        DirDataitemVo item=null;
        Map<String, String> hashMap = new HashMap<String,String>();
        for(int i=3;i<=sheet.getLastRowNum();i++){
            item=new DirDataitemVo();
            Row row = sheet.getRow(i);
            String classifyId = getClassifyId(row, hashMap);
            String datasetName = row.getCell(26).getStringCellValue();
            boolean b=true;
            for (DirDataset dirDataset : lists) {
                if(dirDataset.getDatasetName().equals(datasetName)){
                    setItem(item,row,dirDataset);
                    items.add(item);
                    b=false;
                    break;
                }
            }
            if(b){
                //查询数据集是否存在
                DirDataset tempDirDataset =service.selectDatasetByNameAndClassifyId(datasetName,classifyId);
                if(tempDirDataset!=null){
                    dataset=tempDirDataset;
                    dataitemService.deleteByDatasetId(dataset.getId());
                }else{
                    dataset=new DirDataset();
                    dataset.setDatasetName(datasetName);
                    dataset.setId(UUID.randomUUID().toString().replace("-", ""));
                    dataset.setDatasetCode(dataset.getId());
                    //信息资源提供方代码
                    String region=null,name=null;
                    try {
                        region= row.getCell(28).getStringCellValue();
                        name= row.getCell(29).getStringCellValue();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    String organization_code = null;//dirOrganizeMapper.selectByRegionAndName(region,name);
                    dataset.setBelongDeptType(organization_code);
                    dataset.setBelongDeptId(organization_code);
                    //摘要
                    try {
                        dataset.setDatasetDesc(row.getCell(31).getStringCellValue());
                    } catch (Exception e) {
                        dataset.setDatasetDesc(null);
                    }
                    //信息资源格式
                    try {
                        dataset.setStorageMedium(sysDictService.selectDictcodeByCategoryAndName(row.getCell(32).getStringCellValue(),"setItemStoreMedia"));
                    } catch (Exception e) {
                        dataset.setStorageMedium(null);
                    }
                    try {
                        dataset.setShareMethodCategory(sysDictService.selectDictcodeByCategoryAndName(row.getCell(33).getStringCellValue(),"setItemStoreMedia"));
                    } catch (Exception e) {
                        dataset.setShareMethodCategory(null);
                    }
                    //发布日期
                    try {
                        dataset.setCreateTime(row.getCell(51).getDateCellValue());
                    } catch (Exception e) {
                        String str=row.getCell(51).getStringCellValue();
                        Date d=null;
                        try {
                            d=new SimpleDateFormat("yyyy/MM/dd").parse(str);
                            dataset.setCreateTime(d);
                        } catch (ParseException e1) {
                        }
                    }
                    //数据集目录中间表
                    DirDatasetClassifyMapVo datasetmap = new DirDatasetClassifyMapVo();
                    datasetmap.setClassifyId(classifyId);
                    datasetmap.setDatasetId(dataset.getId());
                    datasetmap.setId(UUID.randomUUID().toString());
                    datasetmap.setStatus("0");
                    datasetmap.setDeleteFlag(0);
                    datasetmap.setUpdateTime(new Date());
                    datamapList.add(datasetmap);

                    //存放需要新增的数据集
                    datasetList.add(dataset);
                }
                lists.add(dataset);
		    	/*数据项*/
                setItem(item,row,dataset);
                items.add(item);
            }
        }


        //数据集
        service.insertListDataset(datasetList);
        //数据集-目录
        if(datamapList!=null&&datamapList.size()>0){
            dirDatasetClassifyMapMapper.insertListItem(datamapList);
        }
        //数据项
        dataitemService.insertListItem(items);

        return true;
    }

    /**
     * 设置数据项
     * @param item 数据项
     * @param row Row
     * @param dataset 数据集
     */
    private void setItem(DirDataitemVo item,Row row,DirDataset dataset){
        item.setId(UUID.randomUUID().toString().replace("-", ""));
        item.setItemCode(UUID.randomUUID().toString().replace("-", ""));
        item.setDatasetId(dataset.getId());
        item.setCreateUserId(ShiroUtils.getLoginUserId());
        try {
            item.setItemName(row.getCell(41).getStringCellValue());
        } catch (Exception e) {
            item.setItemName(null);
        }
        try {
            item.setItemType(sysDictService.selectDictcodeByCategoryAndName(row.getCell(42).getStringCellValue(),"dataitemType"));
        } catch (Exception e) {
            item.setItemType(null);
        }
        try {
            row.getCell(43).setCellType(CellType.STRING);
            item.setItemLength(Integer.parseInt(row.getCell(43).getStringCellValue()));
        } catch (NumberFormatException e) {
            item.setItemLength(null);
        }
        //共享类型
        try {
            item.setShareType(sysDictService.selectDictcodeByCategoryAndName(row.getCell(44).getStringCellValue(),"dataSetShareType"));
        } catch (Exception e) {
            item.setShareType(null);
        }
        //共享条件
        try {
            item.setShareCondition(row.getCell(45).getStringCellValue());
        } catch (Exception e) {
            item.setShareCondition(null);
        }
        //共享方式
        try {
            item.setShareMethodCategory(sysDictService.selectDictcodeByCategoryAndName(row.getCell(46).getStringCellValue(),"requirementExpectGetType"));
        } catch (Exception e) {
            item.setShareMethodCategory(null);
        }
        try {
            item.setShareMethod(sysDictService.selectDictcodeByCategoryAndName(row.getCell(47).getStringCellValue(),"requirementExpectGetType"));
        } catch (Exception e) {
            item.setShareMethod(null);
        }
        //开放属性
        try {
            item.setIsOpen(row.getCell(48).getStringCellValue().trim().equals("是")?"1":"0");
        } catch (Exception e) {
            item.setIsOpen(null);
        }
        try {
            item.setOpenCondition(row.getCell(49).getStringCellValue());
        } catch (Exception e) {}
        try {
            item.setUpdateFrequency(sysDictService.selectDictcodeByCategoryAndName(row.getCell(50).getStringCellValue(),"requirementExpectUpdateFrequence"));
        } catch (Exception e) {}
        item.setCreateTime(dataset.getCreateTime());
    }
    private String getClassifyId(Row row, Map<String, String> hashMap) {
        String classifyId=null;
        String string1 = row.getCell(0).getStringCellValue().trim();
        String string2 = row.getCell(1).getStringCellValue().trim();
        String string3 = row.getCell(2).getStringCellValue().trim();
        String string4 = row.getCell(3).getStringCellValue().trim();
        String strc=string1+"->"+string2+"->"+string3+"->"+string4;
        if(hashMap.containsKey(strc)){
            classifyId= hashMap.get(strc);
        }else{
            classifyId= classifyMapper.selectClassifyByStructrue(strc);
            hashMap.put(strc,classifyId);
        }
        return classifyId;
    }

    /**
     * 创建poi工作簿
     * @param is 文件流
     * @param excelFileFileName 文件完整名称
     * @return 工作簿对象
     * @throws IOException
     */
    private Workbook createWorkbook(InputStream is,String excelFileFileName) throws IOException{
        if(excelFileFileName.toLowerCase().endsWith("xls")){
            return new HSSFWorkbook(is);
        }
        if(excelFileFileName.toLowerCase().endsWith("xlsx")){
            return new XSSFWorkbook(is);
        }
        return null;
    }
}
