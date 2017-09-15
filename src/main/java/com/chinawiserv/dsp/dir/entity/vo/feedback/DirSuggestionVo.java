package com.chinawiserv.dsp.dir.entity.vo.feedback;

import com.chinawiserv.dsp.dir.entity.po.feedback.DirSuggestion;

/**
 * <p>
 * 咨询建议表 Vo对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public class DirSuggestionVo extends DirSuggestion{
    /**
     * 回复人
     * */
    private String responserName;

    public String getResponserName() {
        return responserName;
    }

    public void setResponserName(String responserName) {
        this.responserName = responserName;
    }
}
