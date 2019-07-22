package manage.dao;

import java.util.List;

import manage.model.DO.Salary;

public interface SalaryMapper {
    int deleteByPrimaryKey(String id);

    int insert(Salary record);

    int insertSelective(Salary record);

    List<Salary> selectAll();

    Salary selectByPrimaryKey(String id);

    List<Salary> selectByStaffId(String staffId);

    int updateByPrimaryKeySelective(Salary record);

    int updateByPrimaryKey(Salary record);
}