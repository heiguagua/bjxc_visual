package com.chinawiserv.dsp.base.controller.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.SystemConst;
import com.chinawiserv.dsp.base.common.exception.ErrorInfoException;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.entity.vo.system.SysProductIntegrateVo;
import com.chinawiserv.dsp.base.service.system.ISysProductIntegrateService;
import com.chinawiserv.dsp.base.service.system.ISysSettingService;
import com.google.common.base.CaseFormat;

/**
 * 基础控制器
 * 
 * @author Gaojun.Zhou
 * @date 2016年12月27日 上午11:50:57
 */
public class BaseController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected ISysProductIntegrateService productIntegrateService;

	@Autowired
	private ISysSettingService sysSettingService;

	/**
	 * 返回登录 Token
	 */
	// protected SysUser getSSOToken() {
	// SysUser loginUser = ShiroUtils.getLoginUser();
	// if ( loginUser == null ) {
	// throw new RuntimeException("-1,The user does not exist, please relogin.");
	// }
	// return loginUser;
	// }

	/**
	 * 是否为 post 请求
	 */
	// protected boolean isPost() {
	// return HttpUtil.isPost(request);
	// }
	//
	//
	// /**
	// * 是否为 get 请求
	// */
	// protected boolean isGet() {
	// return HttpUtil.isGet(request);
	// }

	/**
	 * <p>
	 * 获取分页对象
	 * </p>
	 *
	 * @param pageSize
	 *            每页显示数量
	 * @return
	 */
	protected <T> Page<T> getPage(int pageNumber, int pageSize) {
		return new Page<>(pageNumber, pageSize);
	}

	/**
	 * 获取分页对象
	 * 
	 * @param paramMap
	 * @param <T>
	 * @return
	 */
	protected <T> Page<T> getPage(Map<String, Object> paramMap) {
		int pageNumber = MapUtils.getIntValue(paramMap, "pageNumber", 1);
		int pageSize = MapUtils.getIntValue(paramMap, "pageSize", SystemConst.DEFAULT_PAGE_SIZE);

		String sortName = MapUtils.getString(paramMap, "sortName");
		String sortOrder = MapUtils.getString(paramMap, "sortOrder");

		Page<T> page = new Page<>(pageNumber, pageSize);
		if (StringUtils.isNotBlank(sortName)) {
			String sortNameUnderline = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, sortName);
			page.setOrderByField(sortNameUnderline);
		}

		if (StringUtils.isNotBlank(sortOrder)) {
			page.setAsc(!"desc".equalsIgnoreCase(sortOrder));
		}

		return page;
	}

	/**
	 * <p>
	 * 获取分页对象
	 * 
	 * @return
	 */
	// todo remove
	protected <T> Page<T> getPage(HttpServletRequest request) {
		String pageNumberStr = request.getParameter("pageNumber");
		String pageSizeStr = request.getParameter("pageSize");
		String sortName = request.getParameter("sortName");
		String sortOrder = request.getParameter("sortOrder");

		int pageNumber = 1;
		if (NumberUtils.isNumber(pageNumberStr)) {
			pageNumber = NumberUtils.toInt(pageNumberStr);
		}

		int pageSize = SystemConst.DEFAULT_PAGE_SIZE;
		if (NumberUtils.isNumber(pageSizeStr)) {
			pageSize = NumberUtils.toInt(pageSizeStr);
		}

		Page<T> page = new Page<>(pageNumber, pageSize);
		if (StringUtils.isNotBlank(sortName)) {
			String sortNameUnderline = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, sortName);
			page.setOrderByField(sortNameUnderline);
		}

		if (StringUtils.isNotBlank(sortOrder)) {
			page.setAsc(!"desc".equalsIgnoreCase(sortOrder));
		}

		return page;
	}

	/**
	 * 重定向至地址 url
	 * 
	 * @param url
	 *            请求地址
	 * @return
	 */
	protected String redirectTo(String url) {
		StringBuffer rto = new StringBuffer("redirect:");
		rto.append(url);
		return rto.toString();
	}

	/**
	 * 获取请求 当前 URL
	 * 
	 * @return 当前请求 URL
	 * @author AllenZhang
	 */
	public String getRequestURL(HttpServletRequest request) {
		if (request != null) {
			return request.getRequestURL().toString();
		} else {
			return "";
		}
	}

	/**
	 * 获取上下文基础地址
	 * 
	 * @return 上下文基础地址
	 * @author AllenZhang
	 */
	public String getBasePath(HttpServletRequest request) {
		if (request != null) {
			StringBuffer buffer = new StringBuffer();
			buffer.append(request.getScheme()).append("://").append(request.getServerName()).append(":").append(request.getServerPort()).append(request.getContextPath()).append("/");
			return buffer.toString();
		} else {
			return "";
		}
	}

	/**
	 * 设置当前菜单信息
	 * 
	 * @param paramMap
	 */
	protected void setCurrentMenuInfo(@RequestParam Map<String, Object> paramMap) {
		String res = MapUtils.getString(paramMap, "res");
		if (StringUtils.isNotBlank(res)) {
			ShiroUtils.setSessionAttribute(SystemConst.RES, res);
		}
		String cur = MapUtils.getString(paramMap, "cur");
		if (StringUtils.isNotBlank(cur)) {
			ShiroUtils.setSessionAttribute(SystemConst.CUR, cur);
		}
	}

	protected String getDataFromMaster(String url, String type) throws ErrorInfoException {
		String systemId = sysSettingService.findValueByCode(SystemConst.SYS_INTEGRATE_NO);
		SysProductIntegrateVo master;
		if (SystemConst.SYS_INTEGRATE_DEPT_HIGHT_RC.equals(type)) {
			master = productIntegrateService.getTheDeptMaster();
		} else {
			master = productIntegrateService.getTheMaster();

		}
		if (master.getProductNo().equals(systemId)) {
			throw new ErrorInfoException("同一系统，无需获取数据");
		}
		ResponseEntity<String> responseEntity = getRestTemplate().getForEntity(master.getRootPath() + url + "?systemId=" + systemId, String.class);
		if (!responseEntity.getStatusCode().equals(HttpStatus.OK)) {
			throw new ErrorInfoException("主系统响应状态码：" + responseEntity.getStatusCode());
		}
		return responseEntity.getBody();
	}

	protected RestTemplate getRestTemplate() {
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		requestFactory.setConnectTimeout(1000);// 设置超时
		requestFactory.setReadTimeout(1000);
		return new RestTemplate(requestFactory);
	}

	// 主次检查异常当未集成处理，表现为主
	protected boolean isMaster() {
		SysProductIntegrateVo master = null;
		try {
			master = productIntegrateService.getTheMaster();
		} catch (ErrorInfoException e) {

			logger.error("集成异常，未获得唯一主系统");
			return false;
		}
		return master(master);
	}

	// 主次检查异常当未集成处理，表现为主
	protected boolean isDeptMaster() {

		SysProductIntegrateVo master = null;
		try {
			master = productIntegrateService.getTheDeptMaster();
		} catch (ErrorInfoException e) {

			logger.error("集成异常，未获得唯一主系统");
			return false;
		}
		return master(master);
	}

	private boolean master(SysProductIntegrateVo master) {
		String systemId = sysSettingService.findValueByCode(SystemConst.SYS_INTEGRATE_NO);
		if (master != null) {
			if (!master.getProductNo().equals(systemId)) {
				return false;

			}
			if (master.getIntegrateFlag().equals(0)) {
				return false;

			}
		}
		return true;
	}

}
