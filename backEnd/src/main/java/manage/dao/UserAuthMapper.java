package manage.dao;

import manage.model.DO.UserAuth;

public interface UserAuthMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserAuth record);

    int insertSelective(UserAuth record);

    UserAuth selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserAuth record);

    int updateByPrimaryKey(UserAuth record);
}