package com.wasu.dao;

import com.wasu.model.Call;
import com.wasu.model.CallExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CallMapper {
    int countByExample(CallExample example);

    int deleteByExample(CallExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Call record);

    int insertSelective(Call record);

    List<Call> selectByExample(CallExample example);

    Call selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Call record, @Param("example") CallExample example);

    int updateByExample(@Param("record") Call record, @Param("example") CallExample example);

    int updateByPrimaryKeySelective(Call record);

    int updateByPrimaryKey(Call record);
}