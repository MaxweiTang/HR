package manage.dao;

import java.util.List;

import manage.model.DO.Program;

public interface ProgramMapper {
    int deleteByPrimaryKey(String id);

    int insert(Program record);

    int insertSelective(Program record);

    List<Program> selectAll();
    Program selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Program record);

    int updateByPrimaryKey(Program record);
}