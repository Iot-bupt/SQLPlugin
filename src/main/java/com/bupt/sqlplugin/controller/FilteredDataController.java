package com.bupt.sqlplugin.controller;

import com.bupt.sqlplugin.entity.FilteredData;
import com.bupt.sqlplugin.service.FilteredDataService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plugin")
public class FilteredDataController {

    @Autowired
    FilteredDataService filteredDataService;


    @RequestMapping(value=("/sql/insert"), method = RequestMethod.POST)
    public FilteredData insertFilteredData(@RequestBody String data){

        JsonObject jsonObj = (JsonObject)new JsonParser().parse(data);
        FilteredData addData = new FilteredData(jsonObj);
        FilteredData insertData = filteredDataService.insert(addData);
        return insertData;
    }

    @RequestMapping(value = ("/sql/getByRule/{rule_id}"), method = RequestMethod.GET)
    public List<FilteredData> getDataByRule(@PathVariable("rule_id") Integer rule_id){
        List<FilteredData> dataList = filteredDataService.getDataByRule(rule_id);
        return dataList;

    }

    @RequestMapping(value = ("/sql/getByDevice/{device_id}"), method = RequestMethod.GET)
    public List<FilteredData> getDataByRule(@PathVariable("device_id") String device_id){
        List<FilteredData> dataList = filteredDataService.getDataByDevice(device_id);
        return dataList;

    }

    @RequestMapping(value = ("/sql/removeByRule/{rule_id}"), method = RequestMethod.DELETE)
    public void removeByRule(@PathVariable("rule_id") Integer rule_id){
        filteredDataService.removeDataByRule(rule_id);
    }


    @RequestMapping(value = ("/sql/removeByDevice/{device_id}"), method = RequestMethod.DELETE)
    public void removeByDevice(@PathVariable("device_id") String device_id){
        filteredDataService.removeDataByDevice(device_id);
    }

}
