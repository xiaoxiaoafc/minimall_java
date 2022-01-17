package com.sve.minimall.servlet;

import com.sve.minimall.entity.Recommend;

import java.util.List;

public interface RecommendService {

    public void saveRecommends(List<Recommend> recommends) throws Exception;

    public List<Recommend> findAllRecommend() throws Exception;
}
