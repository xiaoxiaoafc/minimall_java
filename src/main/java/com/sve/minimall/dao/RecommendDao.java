package com.sve.minimall.dao;

import com.sve.minimall.entity.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendDao extends JpaRepository<Recommend, Long> {
}
