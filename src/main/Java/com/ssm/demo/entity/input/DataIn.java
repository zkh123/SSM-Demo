package com.ssm.demo.entity.input;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class DataIn {
    @JSONField(name = "DataModel")
    private List<DataModelIn> dataModel;

    public List<DataModelIn> getDataModel() {
        return dataModel;
    }

    public void setDataModel(List<DataModelIn> dataModel) {
        this.dataModel = dataModel;
    }
}
