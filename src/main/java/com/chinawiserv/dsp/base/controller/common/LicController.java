package com.chinawiserv.dsp.base.controller.common;

import com.alibaba.fastjson.JSON;
import com.chinawiserv.dsp.base.common.config.Config;
import com.chinawiserv.dsp.base.common.filter.LicFilter;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.service.system.ISysSettingService;
import com.qwserv.wiservlic.LicAuthorize;
import com.qwserv.wiservlic.impl.LicAuthorizeImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Map;

/**
 * license检查
 * 
 * @author Marke
 *
 */
@Controller
@RequestMapping("/lic")
@Configuration
public class LicController extends BaseController{


	private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ISysSettingService sysSettingService;

	/**
	 * license错误页
	 * 
	 * @param req
	 * @param res
	 * @param param
	 * @param model
	 * @return
	 */
	@RequestMapping("/licErrorPage")
	public String goToLinceseErrorPage(HttpServletRequest req,
			HttpServletResponse res, @RequestParam Map<String, Object> param,
			Model model) {
		setCurrentMenuInfo(param);
		param.put("status", "error");
		model.addAllAttributes(param);
		LicAuthorize lic = new LicAuthorizeImpl();
		 //获取项目标识简称 此简称与lic中的要一致才能通过
//        EntityWrapper<SysSetting> wrapper = new EntityWrapper<>();
//        SysSetting sysSetting = new SysSetting();
//        sysSetting.setSettingCode("integrateCurNo");
//        wrapper.setEntity(sysSetting);
//        sysSetting = sysSettingService.selectOne(wrapper);
//        String settingValue = sysSetting.getSettingValue();
        String checkResult = lic.doLicAuthorize(LicFilter.licSysName,
				LicFilter.licPath);
        JSON json = JSON.parseObject(checkResult);
		model.addAttribute("lic", json);
		return "system/lic/lic.warning";
	}

	/**
	 * license管理页
	 * 
	 * @param req
	 * @param res
	 * @param param
	 * @param model
	 * @return
	 */
    @RequiresPermissions("lic:licPage")
	@RequestMapping("/licPage")
	public String goToLincesePage(HttpServletRequest req,
			HttpServletResponse res, @RequestParam Map<String, Object> param,
			Model model) {
		setCurrentMenuInfo(param);
		param.put("status", "ok");
		model.addAllAttributes(param);
		LicAuthorize lic = new LicAuthorizeImpl();
		 //获取项目标识简称 此简称与lic中的要一致才能通过
//        EntityWrapper<SysSetting> wrapper = new EntityWrapper<>();
//        SysSetting sysSetting = new SysSetting();
//        sysSetting.setSettingCode("integrateCurNo");
//        wrapper.setEntity(sysSetting);
//        sysSetting = sysSettingService.selectOne(wrapper);
//        String settingValue = sysSetting.getSettingValue();
		String checkResult = lic.doLicAuthorize(LicFilter.licSysName,
				LicFilter.licPath);
		JSON json = JSON.parseObject(checkResult);
		model.addAttribute("lic", json);
		return "system/lic/lic";
	}

	/**
	 * lincense导入
	 * 
	 * @param licenseFile
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/uploadLic")
	@ResponseBody
	public Object uploadLicense(
			@RequestParam(value = "licenseFile", required = false) MultipartFile licenseFile,
			HttpServletRequest request, HttpServletResponse response) {
		HandleResult handleResult = new HandleResult();
		if (licenseFile == null) {
			handleResult.error("文件不能为空！");
		} else {
			final String originalFilename = licenseFile.getOriginalFilename();
			if (!Config.LIC_NAME.equals(originalFilename)) {
				handleResult.error("文件类型不正确。");
				return handleResult;
			}
			try {
				StringBuilder sbuilder = new StringBuilder();
				sbuilder.append(LicFilter.licPath);
                
				File file = new File(LicFilter.licPath);
				if (!file.exists()) {
					file.mkdirs();
				}
				logger.info(LicFilter.licPath + originalFilename);
				File licFilePath = new File(LicFilter.licPath + originalFilename);
				licFilePath.delete();
				licenseFile.transferTo(licFilePath);
				LicAuthorize lic = new LicAuthorizeImpl();
				// TODO 服务名称待定
				 //获取项目标识简称 此简称与lic中的要一致才能通过
//		        EntityWrapper<SysSetting> wrapper = new EntityWrapper<>();
//		        SysSetting sysSetting = new SysSetting();
//		        sysSetting.setSettingCode("integrateCurNo");
//		        wrapper.setEntity(sysSetting);
//		        sysSetting = sysSettingService.selectOne(wrapper);
//		        String settingValue = sysSetting.getSettingValue();
				String checkResult = lic.doLicAuthorize(LicFilter.licSysName,
						LicFilter.licPath);
				handleResult.success(checkResult);
				return handleResult;
			} catch (Exception e) {
				logger.error("文件上传失败。", e.toString());
				handleResult.error("文件上传失败。");
			}
		}
		return handleResult;
	}
}
