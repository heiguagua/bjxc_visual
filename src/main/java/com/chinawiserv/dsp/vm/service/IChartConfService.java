package com.chinawiserv.dsp.vm.service;

import java.util.Map;

import com.chinawiserv.dsp.base.service.common.ICommonService;
import com.chinawiserv.dsp.vm.entity.po.ChartConf;
import com.chinawiserv.dsp.vm.entity.vo.ChartConfVo;

/**
 * <p>
 * 系统图表配置表 服务类
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
public interface IChartConfService extends ICommonService<ChartConf, ChartConfVo> {

	/**
	 * 新增某用户新增的图表
	 * 
	 * @param paramsMap
	 * @return
	 * @throws Exception
	 */
	String insertUsersChart(Map<String, Object> paramsMap) throws Exception;

	/**
	 * 根据id删除当前图标配置信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	boolean deleteChartConfigById(String id) throws Exception;

	/**
	 * 编辑用户图标配置
	 * 
	 * @param paramsMap
	 * @return
	 * @throws Exception
	 */
	String editUsersChart(Map<String, Object> paramsMap) throws Exception;

}
