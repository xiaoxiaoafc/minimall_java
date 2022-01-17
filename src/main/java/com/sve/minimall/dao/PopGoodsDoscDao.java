package com.sve.minimall.dao;

import com.sve.minimall.entity.PopGoodsDosc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PopGoodsDoscDao extends JpaRepository<PopGoodsDosc, Long> {
    public Optional<PopGoodsDosc> findByIid(String itemId);
}
