package com.chinawiserv.dsp.base.controller.license;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.qwserv.wiservlic.LicAuthorize;
import com.qwserv.wiservlic.impl.LicAuthorizeImpl;

/**
 * license检查
 * 
 * @author Marke
 *
 */
@Controller
@RequestMapping("/license")
@Configuration
public class LicenseController {

	/**
	 * license路径,不含服务路径
	 */
	private static String LICENSE_PATH = "licInfo/";
	
	/**
	 * license名称
	 */
	private static String LICENSE_NAME = "qinzhi_authorize.lic";
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 当前系统名称
	 */
	@Value("${dir_serverletPath}")
	private String servletPath;


	/**
	 * license错误页
	 * 
	 * @param req
	 * @param res
	 * @param param
	 * @param model
	 * @return
	 */
	@RequestMapping("/licenseErrorPage")
	public String goToLinceseErrorPage(HttpServletRequest req,
			HttpServletResponse res, @RequestParam Map<String, Object> param,
			Model model) {
		param.put("status", "error");
		model.addAllAttributes(param);
		LicAuthorize lic = new LicAuthorizeImpl();
		String checkResult = lic.doLicAuthorize(servletPath,
				LICENSE_PATH);
		JSON json = JSON.parseObject(checkResult);
		model.addAttribute("lic", json);
		return "system/license/license.warning";
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
	@RequestMapping("/licensePage")
	public String goToLincesePage(HttpServletRequest req,
			HttpServletResponse res, @RequestParam Map<String, Object> param,
			Model model) {
		param.put("status", "ok");
		model.addAllAttributes(param);
		LicAuthorize lic = new LicAuthorizeImpl();
		String checkResult = lic.doLicAuthorize(servletPath,
				LICENSE_PATH);
		JSON json = JSON.parseObject(checkResult);
		model.addAttribute("lic", json);
		return "system/license/license";
	}

	/**
	 * lincense导入
	 * 
	 * @param excelFile
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/uploadLicense")
	@ResponseBody
	public Object uploadLicense(
			@RequestParam(value = "licenseFile", required = false) MultipartFile licenseFile,
			HttpServletRequest request, HttpServletResponse response) {
		HandleResult handleResult = new HandleResult();
		if (licenseFile == null) {
			handleResult.error("文件不能为空！");
		} else {
			final String originalFilename = licenseFile.getOriginalFilename();
			if (!LICENSE_NAME.equals(originalFilename)) {
				handleResult.error("文件类型不正确。");
				return handleResult;
			}
			try {
				StringBuilder sbuilder = new StringBuilder();
				sbuilder.append(LICENSE_PATH);
                
				File file = new File(LICENSE_PATH);
				if (!file.exists()) {
					file.mkdirs();
				}
				logger.info(LICENSE_PATH + originalFilename);
				File licenseFilePath = new File(LICENSE_PATH + originalFilename);
				licenseFilePath.delete();
				licenseFile.transferTo(licenseFilePath);
				LicAuthorize lic = new LicAuthorizeImpl();
				// TODO 服务名称待定
				String checkResult = lic.doLicAuthorize(servletPath,
						LICENSE_PATH);
				handleResult.success(checkResult);
				return handleResult;
			} catch (Exception e) {
				logger.error("license上传失败。", e.toString());
				handleResult.error("license上传失败。");
			}
		}
		return handleResult;
	}
}
