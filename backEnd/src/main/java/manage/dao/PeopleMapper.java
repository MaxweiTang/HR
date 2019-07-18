package manage.dao;

import java.util.List;

import manage.model.DO.People;

public interface PeopleMapper {
    int deleteByPrimaryKey(String id);

    int insert(People record);

    int insertSelective(People record);

    People selectByPrimaryKey(String id);

    List<People> selectAll();

    int updateByPrimaryKeySelective(People record);

    int updateByPrimaryKey(People record);
}