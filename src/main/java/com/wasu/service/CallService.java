package com.wasu.service;


import com.wasu.model.AlarmDO;

import java.util.List;

/**
 * Created by kale on 2016/12/19.
 */
public interface CallService {

    public List<AlarmDO> queryAlarmNum(String cityName);
}
