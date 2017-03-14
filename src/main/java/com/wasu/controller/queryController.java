package com.wasu.controller;

import com.wasu.model.AlarmDO;
import com.wasu.service.CallService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kale on 2017/3/14.
 */
@Controller
@RequestMapping("/query")
public class queryController {
    private static Logger logger = Logger.getLogger(queryController.class.getName());

    @Autowired
    private CallService callService;

    @RequestMapping(value = "alarmNum")
    @ResponseBody
    public Object alarmNum(String cityName) throws Exception {
        String keywords;
        if (cityName != null) {
            keywords = cityName;
        } else {
            keywords = "zhejiang";
        }
        List<AlarmDO> result=callService.queryAlarmNum(keywords);

        return result;
    }
}
