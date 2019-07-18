package manage.dao;

import manage.model.DO.Profile;

public interface ProfileMapper {
    int deleteByPrimaryKey(String id);

    int insert(Profile record);

    int insertSelective(Profile record);

    Profile selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Profile record);

    int updateByPrimaryKey(Profile record);
}