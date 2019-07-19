package manage.dao;

import java.awt.List;

import manage.model.DO.PositionLog;

public interface PositionLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(PositionLog record);

    int insertSelective(PositionLog record);

    java.util.List<PositionLog> selectByStaffId(String staffId);

    PositionLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PositionLog record);

    int updateByPrimaryKey(PositionLog record);
}