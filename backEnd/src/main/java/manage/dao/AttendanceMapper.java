package manage.dao;

import java.awt.List;

import manage.model.DO.Attendance;

public interface AttendanceMapper {
    int deleteByPrimaryKey(String id);

    int insert(Attendance record);

    int insertSelective(Attendance record);

    java.util.List<Attendance> selectAll();
    java.util.List<Attendance> selectByStaffId(String staffId);

    Attendance selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Attendance record);

    int updateByPrimaryKey(Attendance record);
}