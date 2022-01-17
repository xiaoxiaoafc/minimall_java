package com.sve.minimall.servlet.impl;

import com.sve.minimall.dao.PopGoodsDao;
import com.sve.minimall.entity.PopGoods;
import com.sve.minimall.servlet.PopGoodsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PopGoodsServiceImpl implements PopGoodsService {

    @Resource
    private PopGoodsDao popGoodsDao;

    @Override
    public void save(PopGoods goods) throws Exception {
        popGoodsDao.save(goods);
    }

    @Override
    public Page<PopGoods> findByGoodsType(String goodsType, PageRequest pageRequest) throws Exception {
        return popGoodsDao.findByGoodsType( goodsType,  pageRequest);
    }

    @Override
    public List<PopGoods> finAll() {
        return popGoodsDao.findAll();
    }
}
