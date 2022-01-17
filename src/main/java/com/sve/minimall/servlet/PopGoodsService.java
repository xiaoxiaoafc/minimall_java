package com.sve.minimall.servlet;

import com.sve.minimall.entity.Goods;
import com.sve.minimall.entity.PopGoods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface PopGoodsService {
    void save(PopGoods goods) throws Exception;

    Page<PopGoods> findByGoodsType(String goodsType, PageRequest pageRequest) throws Exception;

    List<PopGoods> finAll();
}
