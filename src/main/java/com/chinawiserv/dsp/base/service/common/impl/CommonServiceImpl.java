package com.chinawiserv.dsp.base.service.common.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chinawiserv.dsp.base.common.SystemConst;
import com.chinawiserv.dsp.base.service.common.ICommonService;
import com.google.common.base.CaseFormat;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * 公用Service 实现
 * M ： Mapper ；P ：PO    V：VO
 * Created by jacky on 2017/5/11.
 */
public abstract class CommonServiceImpl<M extends BaseMapper<P> , P , V> extends ServiceImpl<M, P> implements ICommonService<P ,V> {

	@Override
	public <V> Page<V> getPage(Map<String, Object> paramMap) {
		int pageNumber = MapUtils.getIntValue(paramMap , "pageNumber" , 1) ;
		int pageSize = MapUtils.getIntValue(paramMap , "pageSize" , SystemConst.DEFAULT_PAGE_SIZE) ;

		String sortName = MapUtils.getString(paramMap , "sortName");
		String sortOrder = MapUtils.getString(paramMap , "sortOrder");

		Page<V> page = new Page<V>(pageNumber , pageSize);
		if (StringUtils.isNotBlank(sortName)) {
			String sortNameUnderline = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, sortName);
			page.setOrderByField(sortNameUnderline);
		}

		if (StringUtils.isNotBlank(sortOrder)) {
			page.setAsc(!"desc".equalsIgnoreCase(sortOrder));
		}

		return page;
	}
	//TODO
	@Override
	public String getRegionCodeCondition(String regionCode, Integer regionLevel){
		String regionCodeCondition;
		switch (regionLevel){
			case 1:
				regionCodeCondition = "";
				break;
			case 2:
				regionCodeCondition = regionCode.substring(0, 2);
				break;
			case 3: case 4:
				regionCodeCondition = regionCode.substring(0, 4);
				break;
			case 5:
				regionCodeCondition = regionCode.substring(0, 6);
				break;
			default:
				regionCodeCondition = regionCode;
		}
		return regionCodeCondition;
	}

}
