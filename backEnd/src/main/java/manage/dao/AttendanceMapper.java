package manage.dao;

import manage.model.Attendance;

public interface AttendanceMapper {
    int deleteByPrimaryKey(String id);

    int insert(Attendance record);

    int insertSelective(Attendance record);

    Attendance selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Attendance record);

    int updateByPrimaryKey(Attendance record);
}