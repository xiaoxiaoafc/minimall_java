package com.sve.minimall.dao;

import com.sve.minimall.entity.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface HomeDao  extends JpaRepository<Goods, Long> {
    public Page<Goods> findByGoodsType(String s, Pageable of);
}
