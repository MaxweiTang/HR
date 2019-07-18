package manage.dao;

import java.util.List;

import manage.model.DO.Staff;

public interface StaffMapper {
    int deleteByPrimaryKey(String id);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(String id);

    List<Staff> selectAll();

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);
}