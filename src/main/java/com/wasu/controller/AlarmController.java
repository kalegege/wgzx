package com.wasu.controller;

import com.wasu.model.Call;
import com.wasu.service.CallService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kale on 2016/12/22.
 */
@Controller
@RequestMapping("/alarm")
public class AlarmController {
    private static Logger logger = Logger.getLogger(AlarmController.class.getName());

    @Autowired
    private CallService callService;

    @RequestMapping(value = "/getalarm")
    public Object getAlarm(Model model) throws  Exception {
//		Response responses=badiduYunUtils.createGeotable("geotable");
        ModelAndView mad=new ModelAndView("alarm");
        mad.addObject("city","浙江");
//        callService.findCall();
//		System.out.println("message"+responses.getMessage()+"id"+responses.getId());
        return mad;
    }

    @RequestMapping(value="test")
    @ResponseBody
    public Object test()throws Exception{
        Map resultMap=new HashMap();
        resultMap.put("name","kale");
        resultMap.put("id",100);
        return resultMap;
    }



}
