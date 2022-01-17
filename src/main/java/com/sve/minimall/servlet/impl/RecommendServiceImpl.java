package com.sve.minimall.servlet.impl;

import com.sve.minimall.dao.RecommendDao;
import com.sve.minimall.entity.Recommend;
import com.sve.minimall.servlet.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendServiceImpl implements RecommendService {

    @Autowired
    public RecommendDao recommendDao;


    @Override
    public void saveRecommends(List<Recommend> recommends) {
        recommendDao.saveAll(recommends);
    }

    @Override
    public List<Recommend> findAllRecommend() {
        return recommendDao.findAll();
    }
}
