package manage.dao;

import manage.model.DO.Train;

public interface TrainMapper {
    int deleteByPrimaryKey(String id);

    int insert(Train record);

    int insertSelective(Train record);

    java.util.List<Train> selectAll();

    Train selectByPrimaryKey(String id);

    Train selectByStaffId(String staffId);

    int updateByPrimaryKeySelective(Train record);

    int updateByPrimaryKey(Train record);
}