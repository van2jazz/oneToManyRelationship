package com.dayo.demo.service;

import com.dayo.demo.dao.AwardsDao;
import com.dayo.demo.entity.Awards;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AwardsService {

    @Autowired
    AwardsDao awardsDao;


    public List<Awards> getAwards() {
        return awardsDao.findAll();
    }

    public void delete(Long awardsId) {
         awardsDao.deleteById(awardsId);
    }

    public Awards createAwards(Awards awards) {
        return awardsDao.save(awards);
    }

    public Awards updateAwards(Awards awards) {
        return awardsDao.save(awards);
    }

    public Optional<Awards> getAwardsById(Long awardsId){
        return awardsDao.findById(awardsId);
    }
}
