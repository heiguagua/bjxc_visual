package com.chinawiserv.dsp.dir.controller.catalog;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.system.SysUser;
import com.chinawiserv.dsp.base.entity.vo.system.SysRegionVo;
import com.chinawiserv.dsp.base.service.system.ISysRegionService;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDeptMap;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirClassifyVo;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirNationalClassifyVo;
import com.chinawiserv.dsp.dir.mapper.catalog.DirClassifyMapper;
import com.chinawiserv.dsp.dir.mapper.catalog.DirDeptMapMapper;
import com.chinawiserv.dsp.dir.mapper.catalog.DirNationalClassifyMapper;
import com.chinawiserv.dsp.dir.service.catalog.IDirClassifyService;
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

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * <p>
 * 目录分类表 前端控制器
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
@Controller
@RequestMapping("/dirNationalClassify")
// todo 将所有的XXX修改为真实值
public class DirNationalClassifyController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DirNationalClassifyMapper mapper;
	
	/**
	 * 根据登录用户的权限获取目录类别树结构的数据
	 */
//	@RequiresPermissions("")
	@RequestMapping("/authorityList")
	@ResponseBody
	public HandleResult getClassifyListForLoginUser(@RequestParam Map<String, Object> paramMap) {
		HandleResult handleResult = new HandleResult();
		try {
			String fid = (String) paramMap.get("fcode");
			if (StringUtils.isEmpty(fid)) {
				paramMap.put("fcode", "2");
			}
//			String regionCode = ShiroUtils.getLoginUser().getRegionCode();
//			String dir_code = mapper.selectClassifyIdByRegionCode(regionCode);
//			paramMap.put("dir_code", dir_code);
//			List<SysRegionVo> SysRegionVoList = sysRegionService.selectAllRegionByRegionCode(regionCode);
//			paramMap.put("regionCodes", SysRegionVoList);
			List<DirNationalClassifyVo> dirNationalClassifyVoList = mapper.selectVoListForTreeData(paramMap);
			handleResult.put("vo", dirNationalClassifyVoList);
		} catch (Exception e) {
			handleResult.error("根据登录用户的权限获取目录分类表信息失败");
			logger.error("根据登录用户的权限获取目录分类表信息失败", e);
		}
		return handleResult;
	}
	
	@RequestMapping("/editLoad")
	@ResponseBody
	public HandleResult editLoad(@RequestParam String classifyCode) {
		HandleResult handleResult = new HandleResult();
		try {			
			DirNationalClassifyVo vo = mapper.selectVoById(classifyCode);
			handleResult.put("vo", vo);
		} catch (Exception e) {
			handleResult.error("获取目录分类表信息失败");
			logger.error("获取目录分类表信息失败", e);
		}
		return handleResult;
	}
}
