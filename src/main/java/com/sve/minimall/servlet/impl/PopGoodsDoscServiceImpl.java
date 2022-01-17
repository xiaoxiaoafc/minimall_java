package com.sve.minimall.servlet.impl;

import com.sve.minimall.dao.PopGoodsDoscDao;
import com.sve.minimall.entity.PopGoodsDosc;
import com.sve.minimall.servlet.PopGoodsDoscService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PopGoodsDoscServiceImpl implements PopGoodsDoscService {

    @Autowired
    private  PopGoodsDoscDao popGoodsDoscDao;

    @Override
    public void save(PopGoodsDosc popGoodsDosc) {
        popGoodsDoscDao.save(popGoodsDosc);
    }

    @Override
    public PopGoodsDosc findByIid(String itemId) throws Exception {
        Optional<PopGoodsDosc>  popGoodsDoscOptional =  popGoodsDoscDao.findByIid(itemId);
        if(popGoodsDoscOptional.isPresent()){
            return popGoodsDoscOptional.get();
        }
        return null;
    }
}
