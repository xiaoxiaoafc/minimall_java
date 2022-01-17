package com.sve.minimall.dao;

import com.sve.minimall.entity.Goods;
import com.sve.minimall.entity.PopGoods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PopGoodsDao extends JpaRepository<PopGoods, Long> {
   public Page<PopGoods> findByGoodsType(String goodsType, Pageable pageRequest);
}
