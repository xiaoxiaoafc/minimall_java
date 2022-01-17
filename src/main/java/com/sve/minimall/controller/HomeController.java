package com.sve.minimall.controller;

import com.sve.minimall.entity.Banner;
import com.sve.minimall.entity.Goods;
import com.sve.minimall.entity.PopGoods;
import com.sve.minimall.entity.Recommend;
import com.sve.minimall.servlet.HomeService;
import com.sve.minimall.vo.ApiResultModelVo;
import com.sve.minimall.vo.PageModelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private HomeService homeServlet;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/home/initData")
    public String getGoods() throws Exception {

        homeServlet.initHomeData();

        return  "11";
    }


    @RequestMapping("/home/goods")
    public PageModelVO<PopGoods> getGoodsList(String goodsType, Integer page, Integer pageNo) throws Exception {
        if(page == null || page.intValue() < 1){
            page = 30;
        }
        if(pageNo == null || pageNo.intValue() < 1){
            pageNo = 1;
        }
        if(!StringUtils.hasText(goodsType)){
            goodsType = "index";
        }
        return homeServlet.getGoodsList(goodsType,page,pageNo);
    }

    @RequestMapping("/home/getRecommend")
    public PageModelVO<Recommend> getRecommend() throws Exception {
        return homeServlet.getRecommend();
    }

    @RequestMapping("/home/getBanner")
    public PageModelVO<Banner> getBanner() throws Exception {
        return homeServlet.getBanner();
    }



    @RequestMapping("/home/detail")
    public ApiResultModelVo<String> detail(String itemId) throws Exception {

        return this.homeServlet.detail(itemId);
    }





}
