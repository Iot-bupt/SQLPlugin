package com.bupt.sqlplugin.service;

import com.bupt.sqlplugin.entity.FilteredData;
import com.bupt.sqlplugin.mapper.FilteredDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilteredDataService {

    @Autowired
    FilteredDataMapper filteredDataMapper;

    public FilteredData insert(FilteredData filteredData){
        this.filteredDataMapper.add(filteredData);
        return filteredData;
    }

    public List<FilteredData> getDataByRule(Integer rule_id){
        return this.filteredDataMapper.getDataByRuleId(rule_id);
    }

    public List<FilteredData> getDataByDevice(String device_id){
        return this.filteredDataMapper.getDataByDeviceId(device_id);
    }

    public void removeDataByRule(Integer rule_id){
        this.filteredDataMapper.removeDataByRuleId(rule_id);
    }

    public void removeDataByDevice(String device_id){
        this.filteredDataMapper.removeDataByDeviceId(device_id);
    }


}
