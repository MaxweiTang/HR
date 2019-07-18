package manage.service;

import java.util.List;

import manage.model.VO.PeopleListVO;
import manage.model.VO.PeopleSelectVO;
import manage.model.VO.PeopleVO;

public interface PeopleService {
    boolean newPeople(PeopleVO pVo);
    //若 pvo 设置了 peole_id，选择特定用户的ID
    List<PeopleListVO> list(PeopleSelectVO pVo);
}