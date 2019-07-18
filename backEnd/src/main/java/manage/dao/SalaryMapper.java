package manage.dao;

import manage.model.DO.Salary;

public interface SalaryMapper {
    int deleteByPrimaryKey(String id);

    int insert(Salary record);

    int insertSelective(Salary record);

    Salary selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Salary record);

    int updateByPrimaryKey(Salary record);
}