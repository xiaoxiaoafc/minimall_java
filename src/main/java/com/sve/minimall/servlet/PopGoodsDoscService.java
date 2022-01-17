package com.sve.minimall.servlet;

import com.sve.minimall.entity.PopGoods;
import com.sve.minimall.entity.PopGoodsDosc;

import java.util.List;

public interface PopGoodsDoscService {
    void save(PopGoodsDosc popGoodsDosc);

    PopGoodsDosc findByIid(String itemId) throws Exception;
}
