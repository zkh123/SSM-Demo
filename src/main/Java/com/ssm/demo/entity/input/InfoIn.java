package com.ssm.demo.entity.input;

import com.alibaba.fastjson.annotation.JSONField;

public class InfoIn {
    @JSONField(name="AppVer")
    private String appVer = "2.0.1";
    @JSONField(name="AppId")
    private String appId = "pataq";

    public String getAppVer() {
        return appVer;
    }

    public void setAppVer(String appVer) {
        this.appVer = appVer;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
