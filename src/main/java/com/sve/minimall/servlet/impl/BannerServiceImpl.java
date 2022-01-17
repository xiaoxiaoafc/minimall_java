package com.sve.minimall.servlet.impl;

import com.sve.minimall.dao.BannerDao;
import com.sve.minimall.entity.Banner;
import com.sve.minimall.servlet.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    public BannerDao bannerDao;
    @Override
    public List<Banner> finAllBanner() {
        return bannerDao.findAll();
    }
}
