package manage.dao;

import manage.model.PositionLog;

public interface PositionLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(PositionLog record);

    int insertSelective(PositionLog record);

    PositionLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PositionLog record);

    int updateByPrimaryKey(PositionLog record);
}