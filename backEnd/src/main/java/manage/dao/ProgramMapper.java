package manage.dao;

import manage.model.DO.Program;

public interface ProgramMapper {
    int deleteByPrimaryKey(String id);

    int insert(Program record);

    int insertSelective(Program record);

    Program selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Program record);

    int updateByPrimaryKey(Program record);
}