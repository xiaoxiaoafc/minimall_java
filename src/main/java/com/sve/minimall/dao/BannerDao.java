package com.sve.minimall.dao;

import com.sve.minimall.entity.Banner;
import com.sve.minimall.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerDao extends JpaRepository<Banner, Long> {

}
