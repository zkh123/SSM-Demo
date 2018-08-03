package com.ssm.demo.entity.input;

import com.alibaba.fastjson.annotation.JSONField;

public class MasterIn {
    @JSONField(name = "Info")
    private InfoIn info;

    @JSONField(name = "Data")
    private DataIn data;

    public InfoIn getInfo() {
        return info;
    }

    public void setInfo(InfoIn info) {
        this.info = info;
    }

    public DataIn getData() {
        return data;
    }

    public void setData(DataIn data) {
        this.data = data;
    }
}
