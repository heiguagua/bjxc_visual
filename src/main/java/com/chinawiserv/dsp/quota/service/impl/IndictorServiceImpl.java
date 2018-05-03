package com.chinawiserv.dsp.quota.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.quota.entity.po.Indictor;
import com.chinawiserv.dsp.quota.entity.vo.IndictorDataVo;
import com.chinawiserv.dsp.quota.entity.vo.IndictorVo;
import com.chinawiserv.dsp.quota.mapper.IndictorDataMapper;
import com.chinawiserv.dsp.quota.mapper.IndictorMapper;
import com.chinawiserv.dsp.quota.service.IIndictorService;
import com.chinawiserv.dsp.vm.entity.po.ChartConf;
import com.chinawiserv.dsp.vm.entity.vo.ChartClassifyVo;
import com.chinawiserv.dsp.vm.entity.vo.ChartDescIndictorMapVo;
import com.chinawiserv.dsp.vm.entity.vo.ChartDescriptionVo;
import com.chinawiserv.dsp.vm.entity.vo.ClassifyIndictorMapVo;
import com.chinawiserv.dsp.vm.mapper.ChartClassifyMapper;
import com.chinawiserv.dsp.vm.mapper.ChartConfMapper;
import com.chinawiserv.dsp.vm.mapper.ChartDescIndictorMapMapper;
import com.chinawiserv.dsp.vm.mapper.ChartDescriptionMapper;
import com.chinawiserv.dsp.vm.mapper.ClassifyIndictorMapMapper;

/**
 * <p>
 * 指标表 服务实现类
 * </p>
 *
 * @author cranky123
 * @since 2018-04-27
 */
@Service
public class IndictorServiceImpl extends CommonServiceImpl<IndictorMapper, Indictor, IndictorVo> implements IIndictorService {

	@Autowired
	private IndictorMapper indictorMapper;

	@Override
	public boolean insertVO(IndictorVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean updateVO(IndictorVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		// todo
		return false;
	}

	@Override
	public IndictorVo selectVoById(String id) throws Exception {
		return null;
	}

	@Override
	public Page<IndictorVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		// todo
		return null;
	}

	@Override
	public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		// todo
		return 0;
	}

	@Autowired
	private ChartConfMapper chartConfMapper;

	@Autowired
	private ChartClassifyMapper chartClassifyMapper;

	@Autowired
	private ChartDescIndictorMapMapper chartDescIndictorMapMapper;

	@Autowired
	private ChartDescriptionMapper chartDescriptionMapper;

	@Autowired
	private ClassifyIndictorMapMapper classifyIndictorMapMapper;

	@Autowired
	private IndictorDataMapper indictorDataMapper;

	@Override
	public HandleResult getIndictorData(Map<String, Object> paramMap) throws Exception {
		HandleResult handleResult = new HandleResult();
		List<IndictorDataVo> extendData = new ArrayList<>();
		List<IndictorDataVo> basicData = new ArrayList<>();

		String id = paramMap.get("id").toString();
		String keyTime = paramMap.getOrDefault("keyTime", "").toString();
		// 获取图表配置信息
		ChartConf chartConf = chartConfMapper.selectById(id);

		// 当前时间 now_date
		// 当前时间-1 last_date
		// 自定义时间段 custom_date
		// 最近几年 recent_date
		// 图表时间范围类型
		chartConf.getChartTimeType();
		// 图表时间范围取值
		chartConf.getChartTimeScope();

		// 判断是否有详情附属指标
		if (1 == chartConf.getHasSubIndictor()) {
			List<ChartDescIndictorMapVo> listChartDescIndictorMapVo = chartDescIndictorMapMapper.selectByChartId(id);
			// 图表指标描述信息
			ChartDescriptionVo chartDescriptionVo = chartDescriptionMapper.selectByChartId(id);
			for (ChartDescIndictorMapVo chartDescIndictorMapVo : listChartDescIndictorMapVo) {
				// 扩展指标id
				chartDescIndictorMapVo.getIndictorCode();
				List<Map<String, Object>> listTimeMap = null;
				if ("".equals(keyTime)) {
					if ("now_date".equals(chartConf.getChartTimeType())) {
						listTimeMap = now_date(chartDescIndictorMapVo.getIndictorCode());
					} else if ("last_date".equals(chartConf.getChartTimeType())) {
						listTimeMap = last_date(chartDescIndictorMapVo.getIndictorCode());
					} else if ("custom_date".equals(chartConf.getChartTimeType())) {
						listTimeMap = custom_date(chartDescIndictorMapVo.getIndictorCode(), chartConf.getChartTimeScope());
					} else if ("recent_date".equals(chartConf.getChartTimeType())) {
						listTimeMap = recent_date(chartDescIndictorMapVo.getIndictorCode(), chartConf.getChartTimeScope());
					}
					for (Map<String, Object> map : listTimeMap) {
						IndictorDataVo indictorDataVo = indictorDataMapper.selectSumReportDateByMap(map);
						if ("custom_date".equals(chartConf.getChartTimeType())) {
							indictorDataVo.setStartTime = chartConf.getChartTimeType();
						} else {
							indictorDataVo.setStartTime = map.get("startTime").toString();
						}
						extendData.add(indictorDataVo);
					}
				} else {
					Map<String, Object> map = new HashMap<>();
					String str[] = keyTime.split("~");
					map.put("keyTimeStart", str[0].trim().toString());
					map.put("keyTimeEnd", str[1].trim().toString());
					map.put("indictorId", chartDescIndictorMapVo.getIndictorCode());
					IndictorDataVo indictorDataVo = indictorDataMapper.selectSumReportDateByMap(map);
					extendData.add(indictorDataVo);
				}
			}
		} else {

		}

		List<ChartClassifyVo> chartClassifyList = chartClassifyMapper.selectByChartId(id);
		for (ChartClassifyVo chartClassifyVo : chartClassifyList) {
			ClassifyIndictorMapVo classifyIndictorMapVo = classifyIndictorMapMapper.selectByClassifyId(chartClassifyVo.getId());
			// 基本指标id
			classifyIndictorMapVo.getIndictorCode();

			List<Map<String, Object>> listTimeMap = null;
			if ("".equals(keyTime)) {
				if ("now_date".equals(chartConf.getChartTimeType())) {
					listTimeMap = now_date(classifyIndictorMapVo.getIndictorCode());
				} else if ("last_date".equals(chartConf.getChartTimeType())) {
					listTimeMap = last_date(classifyIndictorMapVo.getIndictorCode());
				} else if ("custom_date".equals(chartConf.getChartTimeType())) {
					listTimeMap = custom_date(classifyIndictorMapVo.getIndictorCode(), chartConf.getChartTimeScope());
				} else if ("recent_date".equals(chartConf.getChartTimeType())) {
					listTimeMap = recent_date(classifyIndictorMapVo.getIndictorCode(), chartConf.getChartTimeScope());
				}
				for (Map<String, Object> map : listTimeMap) {
					IndictorDataVo indictorDataVo = indictorDataMapper.selectSumReportDateByMap(map);
					if ("custom_date".equals(chartConf.getChartTimeType())) {
						indictorDataVo.setStartTime = chartConf.getChartTimeType();
					} else {
						indictorDataVo.setStartTime = map.get("startTime").toString();
					}
					basicData.add(indictorDataVo);
				}
			} else {
				Map<String, Object> map = new HashMap<>();
				String str[] = keyTime.split("~");
				map.put("keyTimeStart", str[0].trim().toString());
				map.put("keyTimeEnd", str[1].trim().toString());
				map.put("indictorId", classifyIndictorMapVo.getIndictorCode());
				IndictorDataVo indictorDataVo = indictorDataMapper.selectSumReportDateByMap(map);
				basicData.add(indictorDataVo);
			}
		}
		handleResult.put("basicData", basicData);
		handleResult.put("extendData", extendData);
		handleResult.setMsg("加载指标数据成功");
		return handleResult;
	}

	/**
	 * 当前时间
	 * 
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> now_date(String id) {
		Map<String, Object> mapTime = new HashMap<>();
		List<Map<String, Object>> listMap = new ArrayList<>();
		// Calendar now = Calendar.getInstance();
		// int year = now.get(Calendar.YEAR);
		// mapTime.put("startTime", getCurrYearFirst(year));
		// mapTime.put("endTime", getCurrYearLast(year));
		mapTime.put("startTime", getPastYear(0));
		mapTime.put("endTime", getPastYear(-1));
		mapTime.put("indictorId", id);
		listMap.add(mapTime);
		return listMap;

	}

	/**
	 * 当前时间-1
	 * 
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> last_date(String id) {
		Map<String, Object> mapTime = new HashMap<>();
		List<Map<String, Object>> listMap = new ArrayList<>();
		// Calendar now = Calendar.getInstance();
		// int year = now.get(Calendar.YEAR) - 1;
		// mapTime.put("startTime", getCurrYearFirst(year));
		// mapTime.put("endTime", getCurrYearLast(year));
		mapTime.put("startTime", getPastYear(1));
		mapTime.put("endTime", getPastYear(0));
		mapTime.put("indictorId", id);
		listMap.add(mapTime);
		return listMap;
	}

	/**
	 * 自定义返回时间chartTimeScope"2016-01-01 ~ 2016-12-31"
	 * 
	 * @param id,chartTimeScope
	 * @return
	 */
	public List<Map<String, Object>> custom_date(String id, String chartTimeScope) {
		Map<String, Object> mapTime = new HashMap<>();
		List<Map<String, Object>> listMap = new ArrayList<>();
		String str[] = chartTimeScope.split("~");
		mapTime.put("startTime", str[0].toString().trim());
		mapTime.put("endTime", str[1].toString().trim());
		mapTime.put("indictorId", id);
		listMap.add(mapTime);
		return listMap;
	}

	/**
	 * 时间段 最近几年chartTimeScope形如3 Y /3 M /3 D
	 * 
	 * @param id，chartTimeScope
	 * @return
	 */
	public List<Map<String, Object>> recent_date(String id, String chartTimeScope) {

		int num = Integer.parseInt(chartTimeScope.trim().substring(0, chartTimeScope.trim().length() - 2));
		String unit = chartTimeScope.trim().substring(chartTimeScope.trim().length() - 1, chartTimeScope.trim().length());
		List<Map<String, Object>> listMap = new ArrayList<>();
		if ("Y".equals(unit.trim().toUpperCase())) {
			for (int i = 0; i < num; i++) {
				Map<String, Object> mapTime = new HashMap<>();
				// mapTime.put("startTime", getCurrYearFirst(getPastYear(i)));
				// mapTime.put("endTime", getCurrYearLast(getPastYear(i)));
				mapTime.put("startTime", getPastYear(i));
				mapTime.put("endTime", getPastYear(i - 1));
				mapTime.put("indictorId", id);
				listMap.add(mapTime);
			}
		}
		if ("M".equals(unit.trim().toUpperCase())) {
			for (int i = 0; i < num; i++) {
				Map<String, Object> mapTime = new HashMap<>();
				mapTime.put("startTime", getPastMonth(i));
				mapTime.put("endTime", getPastMonth(i - 1));
				mapTime.put("indictorId", id);
				listMap.add(mapTime);
			}
		}
		if ("D".equals(unit.trim().toUpperCase())) {
			for (int i = 0; i < num; i++) {
				Map<String, Object> mapTime = new HashMap<>();
				mapTime.put("startTime", getPastDate(i));
				mapTime.put("endTime", getPastDate(i - 1));
				mapTime.put("indictorId", id);
				listMap.add(mapTime);
			}
		}

		return listMap;
	}

	// 过去第几天
	public static String getPastDate(int past) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
		Date today = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String result = format.format(today);
		return result;
	}

	// 几月
	public static String getPastMonth(int past) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -past);
		Date today = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		String result = format.format(today);
		return result;
	}

	// 几年
	public static int getPastYear(int past) {
		List<String> strings = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -past);
		Date today = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		String result = format.format(today);
		return Integer.parseInt(result);
	}

	/**
	 * 获取某年第一天日期
	 * 
	 */
	public String getCurrYearFirst(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		Date currYearFirst = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String result = format.format(currYearFirst);
		return result;
	}

	/**
	 * 获取某年最后一天日期
	 * 
	 */
	public String getCurrYearLast(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.roll(Calendar.DAY_OF_YEAR, -1);
		Date currYearLast = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String result = format.format(currYearLast);
		return result;
	}

	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateNowStr = sdf.format(d);
		System.out.println("格式化后的日期：" + dateNowStr);

		Calendar c = Calendar.getInstance();
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH) + 1);
		System.out.println("日: " + c.get(Calendar.DAY_OF_MONTH));

		System.out.println(getPastMonth(8));

		String str[] = "2016.01.01 ~ 2016.12.31".split("~");
		System.out.println(str[0].toString().trim());
		System.out.println(str[1].toString().trim());

		String chartTimeScope = "3 Y";
		System.out.println(chartTimeScope.trim().substring(0, chartTimeScope.trim().length() - 2));
		System.out.println(chartTimeScope.trim().substring(chartTimeScope.trim().length() - 1, chartTimeScope.trim().length()));
		System.out.println(getPastYear(-1));
		System.out.println(getPastDate(-1));
		// 时间类型 当前时间2018.05.02为例
		// 当前时间
		// 2018.01.01-2018.05.02 返回一条数据
		// 当前时间-1
		// 2017.01.01-2017.12.31 返回一条数据
		// 时间段
		// 如2017.01.01-2017.12.31 返回一条数据
		// 最近3年
		// 2016.01.01-2016.12.31 返回一条数据
		// 2017.01.01-2017.12.31 返回一条数据
		// 2018.01.01-2018.12.31 返回一条数据
		// 最近3月
		// 2018.03.01-2018.3.31 返回一条数据
		// 2018.04.01-2018.4.31 返回一条数据
		// 2018.05.01-2018.5.31 返回一条数据
		// 最近3天
		// 2018.4.31 返回一条数据
		// 2018.05.01 返回一条数据
		// 2018.05.02返回一条数据

	}
}
