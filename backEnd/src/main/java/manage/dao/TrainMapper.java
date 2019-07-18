package manage.dao;

import manage.model.DO.Train;

public interface TrainMapper {
    int insert(Train record);

    int insertSelective(Train record);
}