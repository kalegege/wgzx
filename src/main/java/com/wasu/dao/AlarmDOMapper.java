package com.wasu.dao;

import com.wasu.model.AlarmDO;
import com.wasu.model.AlarmDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlarmDOMapper {
    int countByExample(AlarmDOExample example);

    int deleteByExample(AlarmDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AlarmDO record);

    int insertSelective(AlarmDO record);

    List<AlarmDO> selectByExample(AlarmDOExample example);

    AlarmDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AlarmDO record, @Param("example") AlarmDOExample example);

    int updateByExample(@Param("record") AlarmDO record, @Param("example") AlarmDOExample example);

    int updateByPrimaryKeySelective(AlarmDO record);

    int updateByPrimaryKey(AlarmDO record);
}