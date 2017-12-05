package com.chinawiserv.dsp.base.sso;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

import static java.util.Objects.isNull;

@ConfigurationProperties(prefix = "sso")
public class SSOConfigProperties {

    private long timeOut;

    private String secretCode;

    private boolean showUrlToken;

    private Map<String, String> jump;

    public Map<String, String> getJump() {
        return this.jump;
    }

    public String getJumpLocation(String key) {
        return isNull(this.jump) ? "" : this.jump.get(key);
    }

    public String getSecretCode() {
        return this.secretCode;
    }

    public long getTimeOut() {
        return this.timeOut;
    }

    public boolean isShowUrlToken() {
        return this.showUrlToken;
    }

    public void setJump(Map<String, String> jump) {
        this.jump = jump;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }

    public void setShowUrlToken(boolean showUrlToken) {
        this.showUrlToken = showUrlToken;
    }

    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }

}
