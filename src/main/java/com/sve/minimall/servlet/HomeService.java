package com.sve.minimall.servlet;

import com.sve.minimall.entity.Banner;
import com.sve.minimall.entity.Goods;
import com.sve.minimall.entity.PopGoods;
import com.sve.minimall.entity.Recommend;
import com.sve.minimall.vo.ApiResultModelVo;
import com.sve.minimall.vo.PageModelVO;

import java.util.List;

public interface HomeService {

    public List<Goods> finAll() throws  Exception;

    void initHomeData() throws Exception;

    PageModelVO<PopGoods> getGoodsList(String goodsType, Integer page, Integer pageNo) throws Exception;

    PageModelVO<Recommend> getRecommend() throws Exception;

    PageModelVO<Banner> getBanner() throws Exception;

    ApiResultModelVo<String> detail(String itemId) throws Exception;

    List<PopGoods> findAllPopGoods() throws Exception;
}
