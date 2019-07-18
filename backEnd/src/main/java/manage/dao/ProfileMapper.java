package manage.dao;

import java.util.List;

import manage.model.DO.Profile;

public interface ProfileMapper {
    int deleteByPrimaryKey(String id);

    int insert(Profile record);

    int insertSelective(Profile record);

    List<Profile> selectAll();

    Profile selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Profile record);

    int updateByPrimaryKey(Profile record);
}