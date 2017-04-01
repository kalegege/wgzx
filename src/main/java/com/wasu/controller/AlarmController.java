package com.wasu.controller;

import com.google.common.cache.*;
import com.wasu.annotion.Alarm;
import com.wasu.annotion.Alarm.Color;
import com.wasu.service.CallService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Closeable;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by kale on 2016/12/22.
 */
@Controller
@RequestMapping("/alarm")
public class AlarmController {
    private static Logger logger = Logger.getLogger(AlarmController.class.getName());

    @Autowired
    private CallService callService;

    private Cache<String,String> cache1;


    @RequestMapping(value = "/getalarm")
    public Object getAlarm(@CookieValue(value = "name", required = false) String nameStr,
                           Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();

        ModelAndView mad = new ModelAndView("alarm");
        mad.addObject("city", "浙江");
        //测试session
        if (session.getAttribute("id") != null) {
            logger.info("id=" + session.getAttribute("id"));
        } else {
            logger.info("不存在id");
            session.setAttribute("id", "1000");
        }
        //测试cookies
        if (nameStr == null) {
            logger.info("不存在cookies");
            Cookie cookie = new Cookie("name", "kale");
            cookie.setMaxAge(60 * 60 * 24 * 7);
            response.addCookie(cookie);
        } else {
            logger.info("cokkies=" + nameStr);
        }

//        System.out.println("first:"+ehCacheTestService.getTimestamp("param"));
//        Thread.sleep(2000);
//        System.out.println("first+2:"+ehCacheTestService.getTimestamp("param"));
//        Thread.sleep(11000);
//        System.out.println("first+13:"+ehCacheTestService.getTimestamp("param"));

//        callService.findCall();
//		System.out.println("message"+responses.getMessage()+"id"+responses.getId());
        return "alarm";
    }

    @RequestMapping(value = "test")
    @ResponseBody
    public Object test() throws Exception {
        Map resultMap = new HashMap();
        resultMap.put("name", "kale");
        resultMap.put("id", 100);
        return resultMap;
    }

    @Alarm(color1 = Color.green)
    public Object test1() throws Exception {
        Map resultMap = new HashMap();
        resultMap.put("name", "kale");
        resultMap.put("id", 100);

        LoadingCache<Integer,String> alarmCache= CacheBuilder.newBuilder()
                .concurrencyLevel(8)
                .expireAfterAccess(18, TimeUnit.SECONDS)
                .removalListener(new RemovalListener<Object, Object>() {
                    public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
                        System.out.println();
                    }
                })
                .build(
                        new CacheLoader<Integer,String>(){
                            @Override
                            public String  load(Integer key) throws Exception{
                                System.out.println("load key"+key);
                                return "new";
                            }
                        }
                );

        alarmCache.put(1,"kkk");
        alarmCache.cleanUp();
        String a=new String();
        Date t=new Date(1000);
        System.out.println(t.toGMTString());

        DateFormat df=new SimpleDateFormat("yyyy年MM月dd日");
        df.format(t);
        df.parse("1977年7月3日");

        Calendar c=new GregorianCalendar();
        c.set(2001,Calendar.FEBRUARY,10,12,23,34);
        Date d=c.getTime();
        c.get(Calendar.YEAR);
        c.setTime(new Date());
        c.add(Calendar.DATE,30);
        c.get(Calendar.DAY_OF_WEEK);
        c.getActualMaximum(Calendar.DATE);

        List list=new LinkedList();

        return resultMap;
    }

    public static <T extends Closeable> void test(T[] a){
        for(T temp:a){
            try{
                if(null!=temp){
                    temp.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
