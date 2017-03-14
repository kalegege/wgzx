package com.wasu.service.impl;

import com.wasu.dao.AlarmDOMapper;
import com.wasu.model.AlarmDO;
import com.wasu.model.AlarmDOExample;
import com.wasu.service.CallService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by kale on 2016/12/19.
 */
@Service("CallService")
public class CallServiceImpl implements CallService{

    private static Logger logger = Logger.getLogger(CallServiceImpl.class.getName());


    @Resource
    private AlarmDOMapper alarmDOMapper;


    public List<AlarmDO> queryAlarmNum(String cityName) {
        AlarmDOExample alarmDOExample=new AlarmDOExample();
        AlarmDOExample.Criteria criteria=alarmDOExample.createCriteria();
        criteria.andNameEqualTo(cityName);
        return alarmDOMapper.selectByExample(alarmDOExample);
    }
}
