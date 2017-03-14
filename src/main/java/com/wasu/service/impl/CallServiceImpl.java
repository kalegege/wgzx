package com.wasu.service.impl;

import com.wasu.dao.CallMapper;
import com.wasu.model.Call;
import com.wasu.model.CallExample;
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
    private CallMapper callMapper;

    public List<Call> findCall() {
        CallExample callExample=new CallExample();
        CallExample.Criteria criteria=callExample.createCriteria();
//        criteria.andIdEqualTo(2L);
        return callMapper.selectByExample(callExample);
    }
}
