package com.chinawiserv.dsp.dir.controller.dirreport;

import java.util.Map;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetVo;
import com.chinawiserv.dsp.dir.service.catalog.IDirDatasetService;

/**
 * 目录上报
 * @author Marke
 *
 */
@Controller
@RequestMapping("/dirupload/")
public class DirReportController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IDirDatasetService service;
	/**
	 * 上报编目
	 * @param param
	 * @return
	 */
	@RequestMapping("catalogue")
	public String getCatalogePage(@RequestParam Map<String,Object> param){
		setCurrentMenuInfo(param);
		return "dir/reportTo/catalogue.reportTo.list";
	}
	
	/**
	 * 上报目录
	 * @param param
	 * @return
	 */
	@RequestMapping("dirclassify")
	public String getDirClassify(@RequestParam Map<String,Object> param){
		setCurrentMenuInfo(param);
		return "dir/reportTo/dir.reportTo.list";
	}
	
	/**
	 * 上报审核
	 * @param param
	 * @return
	 */
	@RequestMapping("dirAudit")
	public String dirAudit(@RequestParam Map<String,Object> param){
		setCurrentMenuInfo(param);
		return "dir/reportTo/dir.audit.list";
	}
	
	@RequestMapping("uploadDirPage")
	public String uploadDirPage(@RequestParam Map<String,Object> param,
			@RequestParam(value="scmIdArr",required=true)String scmIdArr,Model model){
		setCurrentMenuInfo(param);
		model.addAttribute("scmIdArr", scmIdArr);
		return "dir/reportTo/upload.dir";
	}
	 /**
     * 分页查询信息资源列表（编目）
     */
//    @RequiresPermissions("catalog:catalogue:list")
    @RequestMapping("catalogueList")
    @ResponseBody
    public String catalogueList(@RequestParam Map<String , Object> paramMap){
		PageResult pageResult = new PageResult();
		try {
		    Page<DirDatasetVo> page = service.selectDirTransferPage(paramMap);
		    pageResult.setPage(page);
		   
		} catch (Exception e) {
		    pageResult.error("分页查询数据集（编目）出错");
		    logger.error("分页查询数据集（编目）出错", e);
		}
		 JSONObject json = JSONObject.fromObject(pageResult);
		    return json.toString();
    }
    
    /**
     * 上传报告
     * @param paramMap
     * @return
     */
    @ResponseBody
    @RequestMapping("upload")
    public HandleResult uploadDir(@RequestParam Map<String , Object> paramMap){
    	return service.updateDirReport(paramMap);
    }
}
