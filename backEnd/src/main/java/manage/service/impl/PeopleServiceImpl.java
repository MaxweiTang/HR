package manage.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manage.dao.PeopleMapper;
import manage.model.DO.People;
import manage.model.VO.PeopleVO;
import manage.model.VO.TrainProgramVO;
import manage.service.ListService;
import manage.service.PeopleService;
import manage.util.DateUtil;
import manage.util.RandomUtil;

@Service
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    PeopleMapper peopleMapper;

    public boolean newPeople(PeopleVO pVo) {
        People people = new People();
        BeanUtils.copyProperties(pVo, people);
        people.setId(RandomUtil.generate());
        try {
            people.setRegisterDate(DateUtil.parse(pVo.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        peopleMapper.insertSelective(people);
        return true;
    }

}