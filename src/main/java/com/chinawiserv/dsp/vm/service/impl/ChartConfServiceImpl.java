package com.chinawiserv.dsp.vm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.vm.entity.po.ChartClassify;
import com.chinawiserv.dsp.vm.entity.po.ChartConf;
import com.chinawiserv.dsp.vm.entity.po.ChartDescIndictorMap;
import com.chinawiserv.dsp.vm.entity.po.ChartDescription;
import com.chinawiserv.dsp.vm.entity.po.ChartMenuCustom;
import com.chinawiserv.dsp.vm.entity.po.ClassifyIndictorMap;
import com.chinawiserv.dsp.vm.entity.vo.ChartClassifyVo;
import com.chinawiserv.dsp.vm.entity.vo.ChartConfVo;
import com.chinawiserv.dsp.vm.entity.vo.ClassifyIndictorMapVo;
import com.chinawiserv.dsp.vm.mapper.ChartClassifyMapper;
import com.chinawiserv.dsp.vm.mapper.ChartConfMapper;
import com.chinawiserv.dsp.vm.mapper.ChartDescIndictorMapMapper;
import com.chinawiserv.dsp.vm.mapper.ChartDescriptionMapper;
import com.chinawiserv.dsp.vm.mapper.ChartMenuCustomMapper;
import com.chinawiserv.dsp.vm.mapper.ClassifyIndictorMapMapper;
import com.chinawiserv.dsp.vm.service.IChartConfService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * <p>
 * 系统图表配置表 服务实现类
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
@Service
public class ChartConfServiceImpl extends CommonServiceImpl<ChartConfMapper, ChartConf, ChartConfVo> implements IChartConfService {

	@Autowired
	private ChartConfMapper chartConfMapper;

	@Override
	public boolean insertVO(ChartConfVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean updateVO(ChartConfVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		// todo
		return false;
	}

	@Override
	public ChartConfVo selectVoById(String id) throws Exception {

		ChartConfVo vo = chartConfMapper.selectVoById(id);
		List<ChartClassifyVo> listChartClassify = chartClassifyMapper.selectByChartId(id);
		vo.setListChartClassify(chartClassifyMapper.selectByChartId(id));
		vo.setListChartDescIndictorMap(chartDescIndictorMapMapper.selectByChartId(id));
		// vo.setListChartDescription(chartDescriptionMapperr.selectByChartId(id));
		List<ClassifyIndictorMapVo> listClassifyIndictorMap = new ArrayList<>();
		for (ChartClassifyVo chartClassifyVo : listChartClassify) {
			ClassifyIndictorMapVo classifyIndictorMapVo = classifyIndictorMapMapper.selectByClassifyId(chartClassifyVo.getId());
			listClassifyIndictorMap.add(classifyIndictorMapVo);
		}
		vo.setListClassifyIndictorMap(listClassifyIndictorMap);

		return vo;
	}

	@Override
	public Page<ChartConfVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		// todo
		return null;
	}

	@Override
	public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		// todo
		return 0;
	}

	@Autowired
	private ChartClassifyMapper chartClassifyMapper;

	@Autowired
	private ChartDescIndictorMapMapper chartDescIndictorMapMapper;

	@Autowired
	private ChartDescriptionMapper chartDescriptionMapperr;

	@Autowired
	private ChartMenuCustomMapper chartMenuCustomMapper;

	@Autowired
	private ClassifyIndictorMapMapper classifyIndictorMapMapper;

	@Override
	public String insertUsersChart(Map<String, Object> paramsMap) throws Exception {
		if (paramsMap.isEmpty()) {
			return "";
		} else {
			ChartConf chartConf = new ChartConf();// 系统图表配置表

			List<ChartClassify> listChartClassify = new ArrayList<>();
			List<ChartDescIndictorMap> listChartDescIndictorMap = new ArrayList<>();
			// List<ChartDescription> listChartDescription = new ArrayList<>();
			List<ClassifyIndictorMap> listClassifyIndictorMap = new ArrayList<>();

			// ChartClassify chartClassify = new ChartClassify();// 图表分类信息
			// ChartDescIndictorMap chartDescIndictorMap = new ChartDescIndictorMap();//
			// 图表描述与指标关系表
			ChartDescription chartDescription = new ChartDescription();// 图表指标描述信息
			ChartMenuCustom chartMenuCustom = new ChartMenuCustom();// 图表与菜单自定义关系
			// ClassifyIndictorMap classifyIndictorMap = new ClassifyIndictorMap();//
			// 图表分类与指标关系表

			assembleData(CommonUtil.get32UUID(), chartConf, listChartClassify, listChartDescIndictorMap, chartDescription, chartMenuCustom, listClassifyIndictorMap, paramsMap);

			chartConfMapper.baseInsert(chartConf);
			for (ChartClassify chartClassify : listChartClassify) {
				chartClassifyMapper.baseInsert(chartClassify);
			}
			for (ChartDescIndictorMap chartDescIndictorMap : listChartDescIndictorMap) {
				chartDescIndictorMapMapper.baseInsert(chartDescIndictorMap);
			}
			// for (ChartDescription chartDescription : listChartDescription) {
			chartDescriptionMapperr.baseInsert(chartDescription);
			// }
			for (ClassifyIndictorMap classifyIndictorMap : listClassifyIndictorMap) {
				classifyIndictorMapMapper.baseInsert(classifyIndictorMap);
			}
			// chartClassifyMapper.baseInsert(chartClassify);
			// chartDescIndictorMapMapper.baseInsert(chartDescIndictorMap);
			// chartDescriptionMapperr.baseInsert(chartDescription);
			chartMenuCustomMapper.baseInsert(chartMenuCustom);
			// classifyIndictorMapMapper.baseInsert(classifyIndictorMap);

			return chartConf.getId();
		}
	}

	@Override
	public boolean deleteChartConfigById(String id) throws Exception {

		chartConfMapper.deleteById(id);

		List<ChartClassifyVo> chartClassifyVos = chartClassifyMapper.selectByChartId(id);
		for (ChartClassifyVo vo : chartClassifyVos) {

			classifyIndictorMapMapper.deleteByClassifyId(vo.getId());
			chartClassifyMapper.deleteById(vo.getId());
		}

		chartDescIndictorMapMapper.deleteByChartId(id);
		chartDescriptionMapperr.deleteByChartId(id);
		chartMenuCustomMapper.deleteByChartId(id);

		return true;
	}

	@Override
	public String editUsersChart(Map<String, Object> paramsMap) throws Exception {
		if ("".equals(paramsMap.getOrDefault("id", "").toString())) {
			return "";
		} else {
			/*
			 * ChartConf chartConf = new ChartConf();// 系统图表配置表 ChartClassify chartClassify
			 * = new ChartClassify();// 图表分类信息 ChartDescIndictorMap chartDescIndictorMap =
			 * new ChartDescIndictorMap();// 图表描述与指标关系表 ChartDescription chartDescription =
			 * new ChartDescription();// 图表指标描述信息 ChartMenuCustom chartMenuCustom = new
			 * ChartMenuCustom();// 图表与菜单自定义关系 ClassifyIndictorMap classifyIndictorMap = new
			 * ClassifyIndictorMap();// 图表分类与指标关系表
			 * 
			 * assembleDataEdit(chartConf, chartClassify, chartDescIndictorMap,
			 * chartDescription, chartMenuCustom, classifyIndictorMap, paramsMap);
			 * chartConf.setUpdateUserId(ShiroUtils.getLoginUserId());
			 * chartConf.setUpdateTime(new Date());
			 * 
			 * 
			 * chartConfMapper.baseInsert(chartConf);
			 * chartClassifyMapper.baseInsert(chartClassify);
			 * chartDescIndictorMapMapper.baseInsert(chartDescIndictorMap);
			 * chartDescriptionMapperr.baseInsert(chartDescription);
			 * chartMenuCustomMapper.baseInsert(chartMenuCustom);
			 * classifyIndictorMapMapper.baseInsert(classifyIndictorMap);
			 * 
			 * 
			 * // 如果 存在附属指标 则更新
			 * 
			 * // 如果不存在附属指标 则新增
			 * 
			 */
			ChartConf chartConf = new ChartConf();// 系统图表配置表
			List<ChartClassify> listChartClassify = new ArrayList<>();
			List<ChartDescIndictorMap> listChartDescIndictorMap = new ArrayList<>();
			// List<ChartDescription> listChartDescription = new ArrayList<>();
			List<ClassifyIndictorMap> listClassifyIndictorMap = new ArrayList<>();

			// ChartClassify chartClassify = new ChartClassify();// 图表分类信息
			// ChartDescIndictorMap chartDescIndictorMap = new ChartDescIndictorMap();//
			// 图表描述与指标关系表
			ChartDescription chartDescription = new ChartDescription();// 图表指标描述信息
			ChartMenuCustom chartMenuCustom = new ChartMenuCustom();// 图表与菜单自定义关系
			// ClassifyIndictorMap classifyIndictorMap = new ClassifyIndictorMap();//
			// 图表分类与指标关系表

			assembleData(paramsMap.getOrDefault("id", "").toString(), chartConf, listChartClassify, listChartDescIndictorMap, chartDescription, chartMenuCustom, listClassifyIndictorMap, paramsMap);
			deleteChartConfigById(paramsMap.getOrDefault("id", "").toString());
			chartConfMapper.baseInsert(chartConf);
			for (ChartClassify chartClassify : listChartClassify) {
				chartClassifyMapper.baseInsert(chartClassify);
			}
			for (ChartDescIndictorMap chartDescIndictorMap : listChartDescIndictorMap) {
				chartDescIndictorMapMapper.baseInsert(chartDescIndictorMap);
			}
			// for (ChartDescription chartDescription : listChartDescription) {
			chartDescriptionMapperr.baseInsert(chartDescription);
			// }
			for (ClassifyIndictorMap classifyIndictorMap : listClassifyIndictorMap) {
				classifyIndictorMapMapper.baseInsert(classifyIndictorMap);
			}
			// chartClassifyMapper.baseInsert(chartClassify);
			// chartDescIndictorMapMapper.baseInsert(chartDescIndictorMap);
			// chartDescriptionMapperr.baseInsert(chartDescription);
			chartMenuCustomMapper.baseInsert(chartMenuCustom);
			// classifyIndictorMapMapper.baseInsert(classifyIndictorMap);

			return chartConf.getId();

		}

	}

	/**
	 * 组装图标数据新增
	 * 
	 * @param chartConf
	 * @param chartClassify
	 * @param chartDescIndictorMap
	 * @param chartDescription
	 * @param chartMenuCustom
	 * @param classifyIndictorMap
	 * @param paramsMap
	 */
	public void assembleData(String chartId, ChartConf chartConf, List<ChartClassify> listChartClassify, List<ChartDescIndictorMap> listChartDescIndictorMap, ChartDescription chartDescription, ChartMenuCustom chartMenuCustom, List<ClassifyIndictorMap> listClassifyIndictorMap, Map<String, Object> paramsMap) {

		// 系统图表配置表
		// String chartId = CommonUtil.get32UUID();
		chartConf.setId(chartId);
		chartConf.setChartCode(CommonUtil.get32UUID());
		chartConf.setChartName(paramsMap.getOrDefault("chartName", "").toString());// 图表标题
		chartConf.setIsNameShow(paramsMap.getOrDefault("isNameShow", "false").toString().equals("true") ? 1 : 0);// 标题是否显示
		chartConf.setChartDesc(paramsMap.getOrDefault("chartDesc", "").toString());// 图表描述
		chartConf.setChartType(paramsMap.getOrDefault("chartType", "").toString());// 图表类型
		chartConf.setChartUrl("");// 图表URL
		chartConf.setChartTimeType(paramsMap.getOrDefault("chartTimeType", "").toString());// 图表时间范围类型
		chartConf.setChartTimeScope(paramsMap.getOrDefault("chartTimeScope", "").toString());// 图表时间范围取值
		chartConf.setStatus(1);// 状态
		chartConf.setCreateUserId(ShiroUtils.getLoginUserId());// 创建人
		chartConf.setCreateTime(new Date());// 创建时间
		chartConf.setHasSubIndictor(paramsMap.getOrDefault("hasSubIndictor", "false").toString().equals("true") ? 1 : 0);

		// String indicators=paramsMap.getOrDefault("indicators", "").toString();
		JSONArray indictorsArry = JSONArray.fromObject(paramsMap.getOrDefault("indictors", "").toString());
		for (int i = 0; i < indictorsArry.size(); i++) {
			JSONObject indictorJson = JSONObject.fromObject(indictorsArry.get(i).toString());
			// 图表分类信息
			ChartClassify chartClassify = new ChartClassify();
			chartClassify.setId(CommonUtil.get32UUID());
			chartClassify.setChartId(chartId);
			chartClassify.setClassifyName("");// 分类名称
			chartClassify.setClassifyLevel("");// 分类级别
			chartClassify.setChartType(paramsMap.getOrDefault("chartType", "").toString());// 对应图形类型
			listChartClassify.add(chartClassify);

			// 图表分类与指标关系表
			ClassifyIndictorMap classifyIndictorMap = new ClassifyIndictorMap();
			classifyIndictorMap.setId(CommonUtil.get32UUID());
			classifyIndictorMap.setClassifyId(chartClassify.getId());// 分类ID
			classifyIndictorMap.setHighlightFlag("0");// 是否高亮显示
			classifyIndictorMap.setIndictorCode(indictorJson.getString("code"));// 指标编号
			classifyIndictorMap.setIndictorShowName(indictorJson.optString("name", ""));// 指标显示名称
			classifyIndictorMap.setPointNum(paramsMap.getOrDefault("", "").toString());// 保留小数点位数
			listClassifyIndictorMap.add(classifyIndictorMap);
		}

		if (1 == chartConf.getHasSubIndictor()) {
			JSONArray subIndicators = JSONArray.fromObject(paramsMap.getOrDefault("subIndictors", "").toString());
			for (int i = 0; i < subIndicators.size(); i++) {
				JSONObject subIndictorJson = JSONObject.fromObject(subIndicators.get(i).toString());
				// 图表描述与指标关系表
				ChartDescIndictorMap chartDescIndictorMap = new ChartDescIndictorMap();
				chartDescIndictorMap.setId(CommonUtil.get32UUID());
				chartDescIndictorMap.setChartId(chartId);
				chartDescIndictorMap.setIndictorCode(subIndictorJson.getString("code"));// 指标编号
				chartDescIndictorMap.setIndictorShowName(subIndictorJson.optString("name", ""));// 指标显示名称
				listChartDescIndictorMap.add(chartDescIndictorMap);

			}

		}
		// 图表指标描述信息
		// ChartDescription chartDescription = new ChartDescription();
		chartDescription.setId(CommonUtil.get32UUID());
		chartDescription.setChartId(chartId);
		chartDescription.setSubTitle(paramsMap.getOrDefault("subTitle", "").toString());// 副标题
		chartDescription.setDescription(paramsMap.getOrDefault("description", "").toString());// 描述信息
		// listChartDescription.add(chartDescription);
		// 图表与菜单自定义关系
		chartMenuCustom.setId(CommonUtil.get32UUID());
		chartMenuCustom.setChartId(chartId);
		chartMenuCustom.setLocation(paramsMap.getOrDefault("location", "").toString());// 图表位置
		chartMenuCustom.setMenuId(ShiroUtils.getSessionAttribute("cur").toString());// 菜单ID
		chartMenuCustom.setShowOrder(paramsMap.getOrDefault("isNameShow", "false").toString().equals("true") ? 1 : 0);// 图表显示顺序
		chartMenuCustom.setUser(ShiroUtils.getLoginUserId());// 使用人

	}

	/**
	 * 组装图标数据编辑保存
	 * 
	 * @param chartConf
	 * @param chartClassify
	 * @param chartDescIndictorMap
	 * @param chartDescription
	 * @param chartMenuCustom
	 * @param classifyIndictorMap
	 * @param paramsMap
	 */
	public void assembleDataEdit(ChartConf chartConf, List<ChartClassify> listChartClassify, List<ChartDescIndictorMap> listChartDescIndictorMap, ChartDescription chartDescription, ChartMenuCustom chartMenuCustom, List<ClassifyIndictorMap> listClassifyIndictorMap, Map<String, Object> paramsMap) {
		/*
		 * // 系统图表配置表 String chartId = CommonUtil.get32UUID(); chartConf.setId(chartId);
		 * chartConf.setChartCode(CommonUtil.get32UUID());
		 * chartConf.setChartName(paramsMap.getOrDefault("chartName", "").toString());//
		 * 图表标题
		 * chartConf.setIsNameShow(Integer.parseInt(paramsMap.getOrDefault("isNameShow",
		 * "0").toString()));// 标题是否显示
		 * chartConf.setChartDesc(paramsMap.getOrDefault("chartDesc", "").toString());//
		 * 图表描述 chartConf.setChartType(paramsMap.getOrDefault("chartType",
		 * "").toString());// 图表类型 chartConf.setChartUrl("");// 图表URL
		 * chartConf.setChartTimeType(paramsMap.getOrDefault("chartTimeType",
		 * "").toString());// 图表时间范围类型
		 * chartConf.setChartTimeScope(paramsMap.getOrDefault("chartTimeScope",
		 * "").toString());// 图表时间范围取值 chartConf.setStatus(1);// 状态
		 * chartConf.setCreateUserId(ShiroUtils.getLoginUserId());// 创建人
		 * chartConf.setCreateTime(new Date());// 创建时间
		 * chartConf.setHasSubIndictor(Integer.parseInt(paramsMap.getOrDefault(
		 * "hasSubIndictor", "0").toString()));
		 * 
		 * // 图表分类信息 chartClassify.setId(CommonUtil.get32UUID());
		 * chartClassify.setChartId(chartId); chartClassify.setClassifyName("");// 分类名称
		 * chartClassify.setClassifyLevel("");// 分类级别
		 * chartClassify.setChartType(paramsMap.getOrDefault("chartType",
		 * "").toString());// 对应图形类型
		 * 
		 * if (1 == chartConf.getHasSubIndictor()) { // 图表描述与指标关系表
		 * chartDescIndictorMap.setId(CommonUtil.get32UUID());
		 * chartDescIndictorMap.setChartId(chartId);
		 * chartDescIndictorMap.setIndictorCode(paramsMap.getOrDefault(
		 * "subIndictorCode", "").toString());// 指标编号
		 * chartDescIndictorMap.setIndictorShowName(paramsMap.getOrDefault(
		 * "subIndictorShowName", "").toString());// 指标显示名称 // 图表指标描述信息
		 * chartDescription.setId(CommonUtil.get32UUID());
		 * chartDescription.setChartId(chartId);
		 * chartDescription.setSubTitle(paramsMap.getOrDefault("subTitle",
		 * "").toString());// 副标题
		 * chartDescription.setDescription(paramsMap.getOrDefault("description",
		 * "").toString());// 描述信息 } // 图表与菜单自定义关系
		 * chartMenuCustom.setId(CommonUtil.get32UUID());
		 * chartMenuCustom.setChartId(chartId);
		 * chartMenuCustom.setLocation(paramsMap.getOrDefault("location",
		 * "").toString());// 图表位置
		 * chartMenuCustom.setMenuId(ShiroUtils.getSessionAttribute("res").toString());/
		 * / 菜单ID chartMenuCustom.setShowOrder(Integer.parseInt(paramsMap.getOrDefault(
		 * "isNameShow", "0").toString()));// 图表显示顺序
		 * chartMenuCustom.setUser(ShiroUtils.getLoginUserId());// 使用人
		 * 
		 * // 图表分类与指标关系表 classifyIndictorMap.setId(CommonUtil.get32UUID());
		 * classifyIndictorMap.setClassifyId("custom");// 分类ID
		 * classifyIndictorMap.setHighlightFlag("1");// 是否高亮显示
		 * classifyIndictorMap.setIndictorCode(paramsMap.getOrDefault("",
		 * "").toString());// 指标编号
		 * classifyIndictorMap.setIndictorShowName(paramsMap.getOrDefault("",
		 * "").toString());// 指标显示名称
		 * classifyIndictorMap.setPointNum(paramsMap.getOrDefault("", "").toString());//
		 * 保留小数点位数
		 */
		// 系统图表配置表
		String chartId = paramsMap.getOrDefault("id", "").toString();
		chartConf.setId(chartId);
		chartConf.setChartCode(CommonUtil.get32UUID());
		chartConf.setChartName(paramsMap.getOrDefault("chartName", "").toString());// 图表标题
		chartConf.setIsNameShow(paramsMap.getOrDefault("isNameShow", "false").toString().equals("true") ? 1 : 0);// 标题是否显示
		chartConf.setChartDesc(paramsMap.getOrDefault("chartDesc", "").toString());// 图表描述
		chartConf.setChartType(paramsMap.getOrDefault("chartType", "").toString());// 图表类型
		chartConf.setChartUrl("");// 图表URL
		chartConf.setChartTimeType(paramsMap.getOrDefault("chartTimeType", "").toString());// 图表时间范围类型
		chartConf.setChartTimeScope(paramsMap.getOrDefault("chartTimeScope", "").toString());// 图表时间范围取值
		chartConf.setStatus(1);// 状态
		chartConf.setCreateUserId(ShiroUtils.getLoginUserId());// 创建人
		chartConf.setCreateTime(new Date());// 创建时间
		chartConf.setHasSubIndictor(paramsMap.getOrDefault("hasSubIndictor", "false").toString().equals("true") ? 1 : 0);

		// String indicators=paramsMap.getOrDefault("indicators", "").toString();
		JSONArray indictorsArry = JSONArray.fromObject(paramsMap.getOrDefault("indictors", "").toString());
		for (int i = 0; i < indictorsArry.size(); i++) {
			JSONObject indictorJson = JSONObject.fromObject(indictorsArry.get(i).toString());
			// 图表分类信息
			ChartClassify chartClassify = new ChartClassify();
			chartClassify.setId(CommonUtil.get32UUID());
			chartClassify.setChartId(chartId);
			chartClassify.setClassifyName("");// 分类名称
			chartClassify.setClassifyLevel("");// 分类级别
			chartClassify.setChartType(paramsMap.getOrDefault("chartType", "").toString());// 对应图形类型
			listChartClassify.add(chartClassify);

			// 图表分类与指标关系表
			ClassifyIndictorMap classifyIndictorMap = new ClassifyIndictorMap();
			classifyIndictorMap.setId(CommonUtil.get32UUID());
			classifyIndictorMap.setClassifyId(chartClassify.getId());// 分类ID
			classifyIndictorMap.setHighlightFlag("0");// 是否高亮显示
			classifyIndictorMap.setIndictorCode(indictorJson.getString("code"));// 指标编号
			classifyIndictorMap.setIndictorShowName(indictorJson.optString("name", ""));// 指标显示名称
			classifyIndictorMap.setPointNum(paramsMap.getOrDefault("", "").toString());// 保留小数点位数
			listClassifyIndictorMap.add(classifyIndictorMap);
		}

		if (1 == chartConf.getHasSubIndictor()) {
			JSONArray subIndicators = JSONArray.fromObject(paramsMap.getOrDefault("subIndictors", "").toString());
			for (int i = 0; i < subIndicators.size(); i++) {
				JSONObject subIndictorJson = JSONObject.fromObject(subIndicators.get(i).toString());
				// 图表描述与指标关系表
				ChartDescIndictorMap chartDescIndictorMap = new ChartDescIndictorMap();
				chartDescIndictorMap.setId(CommonUtil.get32UUID());
				chartDescIndictorMap.setChartId(chartId);
				chartDescIndictorMap.setIndictorCode(subIndictorJson.getString("code"));// 指标编号
				chartDescIndictorMap.setIndictorShowName(subIndictorJson.optString("name", ""));// 指标显示名称
				listChartDescIndictorMap.add(chartDescIndictorMap);

			}

		}
		// 图表指标描述信息
		// ChartDescription chartDescription = new ChartDescription();
		chartDescription.setId(CommonUtil.get32UUID());
		chartDescription.setChartId(chartId);
		chartDescription.setSubTitle(paramsMap.getOrDefault("subTitle", "").toString());// 副标题
		chartDescription.setDescription(paramsMap.getOrDefault("description", "").toString());// 描述信息
		// listChartDescription.add(chartDescription);
		// 图表与菜单自定义关系
		chartMenuCustom.setId(CommonUtil.get32UUID());
		chartMenuCustom.setChartId(chartId);
		chartMenuCustom.setLocation(paramsMap.getOrDefault("location", "").toString());// 图表位置
		chartMenuCustom.setMenuId(ShiroUtils.getSessionAttribute("res").toString());// 菜单ID
		chartMenuCustom.setShowOrder(paramsMap.getOrDefault("isNameShow", "false").toString().equals("true") ? 1 : 0);// 图表显示顺序
		chartMenuCustom.setUser(ShiroUtils.getLoginUserId());// 使用人
	}

}
