package com.chinawiserv.dsp.base.entity.vo.system;


import com.chinawiserv.dsp.base.common.util.DateTimeUtils;
import com.chinawiserv.dsp.base.entity.po.system.SysDept;
import com.chinawiserv.dsp.base.entity.po.system.SysDeptContacts;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2017/5/15.1
 */
public class SysDeptVo extends SysDept {

    private String validateFromStr;

    private String validateToStr;

    private String regionName;

    private Boolean isLeaf;
    
    private String isSync;

    private Long cNum;

    private List<SysDeptVo> childs;

    private List<SysDeptContacts> items;

    public String getValidateFromStr() {
        if(StringUtils.isBlank(validateFromStr)){
            Date validateFrom = getValidateFrom();
            if(validateFrom != null){
                validateFromStr = DateTimeUtils.convertDateTime_YYYYMMDD(validateFrom);
            }
        }
        return validateFromStr;
    }

    public void setValidateFromStr(String validateFromStr) {
        this.validateFromStr = validateFromStr;
    }

    public String getValidateToStr() {
        if(StringUtils.isBlank(validateToStr)){
            Date validateTo = getValidateTo();
            if(validateTo != null){
                validateToStr = DateTimeUtils.convertDateTime_YYYYMMDD(validateTo);
            }
        }
        return validateToStr;
    }

    public void setValidateToStr(String validateToStr) {
        this.validateToStr = validateToStr;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Boolean getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public List<SysDeptVo> getChilds() {
        return childs;
    }

    public void setChilds(List<SysDeptVo> childs) {
        this.childs = childs;
    }

	public String getIsSync() {
		return isSync;
	}

	public void setIsSync(String isSync) {
		this.isSync = isSync;
	}

    public Long getcNum() {
        return cNum;
    }

    public void setcNum(Long cNum) {
        this.cNum = cNum;
    }

    public List<SysDeptContacts> getItems() {
        return items;
    }

    public void setItems(List<SysDeptContacts> items) {
        this.items = items;
    }
}
