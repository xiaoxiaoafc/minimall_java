package com.sve.minimall.servlet.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sve.minimall.dao.HomeDao;
import com.sve.minimall.entity.*;
import com.sve.minimall.servlet.*;
import com.sve.minimall.vo.ApiResultModelVo;
import com.sve.minimall.vo.PageModelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeDao homeDao;

    @Autowired
    private BannerService bannerService;

    @Autowired
    private RecommendService recommendService;

    @Autowired
    private PopGoodsService popGoodsService;

    @Autowired
    private PopGoodsDoscService popGoodsDoscService;


    @Override
    public List<Goods> finAll() throws Exception {
        return homeDao.findAll();
    }

    @Override
    public void initHomeData() throws Exception {
        //initGoods();
       // this.initRecommend();
        this.initPopGoods();
    }

    private void initPopGoods() throws Exception {
        List<String> urls = Arrays.asList(
                "https://api.mogu.com/h5/mwp.pagani.search/21/?data=%7B%22page%22%3A10%2C%22pageSize%22%3A24%2C%22sort%22%3A%22pop%22%2C%22ratio%22%3A%223%3A4%22%2C%22fcid%22%3A%2220003463%22%2C%22cKey%22%3A%22h5-shopping%22%2C%22pid%22%3A%229750%22%7D&mw-ckey=h5-shopping&mw-appkey=100028&mw-ttid=NMMain%40mgj_h5_1.0&mw-t=1640242692036&mw-uuid=87a63ac6-471b-458f-9ede-6f8346a00f02&mw-h5-os=Android&mw-sign=9a54febb6ded7f0b3b0b3a34f1c69ddd&callback=mwpCb10&_=1640242692037",
                "https://api.mogu.com/h5/mwp.pagani.search/21/?data=%7B%22page%22%3A11%2C%22pageSize%22%3A24%2C%22sort%22%3A%22pop%22%2C%22ratio%22%3A%223%3A4%22%2C%22fcid%22%3A%2220003463%22%2C%22cKey%22%3A%22h5-shopping%22%2C%22pid%22%3A%229750%22%7D&mw-ckey=h5-shopping&mw-appkey=100028&mw-ttid=NMMain%40mgj_h5_1.0&mw-t=1640242705476&mw-uuid=87a63ac6-471b-458f-9ede-6f8346a00f02&mw-h5-os=Android&mw-sign=95947f70d1ddf3d61fb1063d5fc8ef32&callback=mwpCb11&_=1640242705478",
                "https://api.mogu.com/h5/mwp.pagani.search/21/?data=%7B%22page%22%3A12%2C%22pageSize%22%3A24%2C%22sort%22%3A%22pop%22%2C%22ratio%22%3A%223%3A4%22%2C%22fcid%22%3A%2220003463%22%2C%22cKey%22%3A%22h5-shopping%22%2C%22pid%22%3A%229750%22%7D&mw-ckey=h5-shopping&mw-appkey=100028&mw-ttid=NMMain%40mgj_h5_1.0&mw-t=1640242753680&mw-uuid=87a63ac6-471b-458f-9ede-6f8346a00f02&mw-h5-os=Android&mw-sign=9c039fddceb5b9625067e0c041c4a010&callback=mwpCb12&_=1640242753681",
                "https://api.mogu.com/h5/mwp.pagani.search/21/?data=%7B%22page%22%3A13%2C%22pageSize%22%3A24%2C%22sort%22%3A%22pop%22%2C%22ratio%22%3A%223%3A4%22%2C%22fcid%22%3A%2220003463%22%2C%22cKey%22%3A%22h5-shopping%22%2C%22pid%22%3A%229750%22%7D&mw-ckey=h5-shopping&mw-appkey=100028&mw-ttid=NMMain%40mgj_h5_1.0&mw-t=1640242780125&mw-uuid=87a63ac6-471b-458f-9ede-6f8346a00f02&mw-h5-os=Android&mw-sign=e5ab6770d5219b93f015da71a113e7cc&callback=mwpCb13&_=1640242780126",
                "https://api.mogu.com/h5/mwp.pagani.search/21/?data=%7B%22page%22%3A14%2C%22pageSize%22%3A24%2C%22sort%22%3A%22pop%22%2C%22ratio%22%3A%223%3A4%22%2C%22fcid%22%3A%2220003463%22%2C%22cKey%22%3A%22h5-shopping%22%2C%22pid%22%3A%229750%22%7D&mw-ckey=h5-shopping&mw-appkey=100028&mw-ttid=NMMain%40mgj_h5_1.0&mw-t=1640242797217&mw-uuid=87a63ac6-471b-458f-9ede-6f8346a00f02&mw-h5-os=Android&mw-sign=3bf0bbbc25d06fc6387369621cf094a2&callback=mwpCb14&_=1640242797219",
                "https://api.mogu.com/h5/mwp.pagani.search/21/?data=%7B%22page%22%3A15%2C%22pageSize%22%3A24%2C%22sort%22%3A%22pop%22%2C%22ratio%22%3A%223%3A4%22%2C%22fcid%22%3A%2220003463%22%2C%22cKey%22%3A%22h5-shopping%22%2C%22pid%22%3A%229750%22%7D&mw-ckey=h5-shopping&mw-appkey=100028&mw-ttid=NMMain%40mgj_h5_1.0&mw-t=1640242813646&mw-uuid=87a63ac6-471b-458f-9ede-6f8346a00f02&mw-h5-os=Android&mw-sign=58602426b2a0916e0148b30bdf281d21&callback=mwpCb15&_=1640242813647",
                "https://api.mogu.com/h5/mwp.pagani.search/21/?data=%7B%22page%22%3A16%2C%22pageSize%22%3A24%2C%22sort%22%3A%22pop%22%2C%22ratio%22%3A%223%3A4%22%2C%22fcid%22%3A%2220003463%22%2C%22cKey%22%3A%22h5-shopping%22%2C%22pid%22%3A%229750%22%7D&mw-ckey=h5-shopping&mw-appkey=100028&mw-ttid=NMMain%40mgj_h5_1.0&mw-t=1640242827295&mw-uuid=87a63ac6-471b-458f-9ede-6f8346a00f02&mw-h5-os=Android&mw-sign=3394391d655f3dea5310d41ed526eb03&callback=mwpCb16&_=1640242827296",
                "https://api.mogu.com/h5/mwp.pagani.search/21/?data=%7B%22page%22%3A17%2C%22pageSize%22%3A24%2C%22sort%22%3A%22pop%22%2C%22ratio%22%3A%223%3A4%22%2C%22fcid%22%3A%2220003463%22%2C%22cKey%22%3A%22h5-shopping%22%2C%22pid%22%3A%229750%22%7D&mw-ckey=h5-shopping&mw-appkey=100028&mw-ttid=NMMain%40mgj_h5_1.0&mw-t=1640242839881&mw-uuid=87a63ac6-471b-458f-9ede-6f8346a00f02&mw-h5-os=Android&mw-sign=9eb222001e54dfe13654bc6a056af7f4&callback=mwpCb17&_=1640242839882",
                "https://api.mogu.com/h5/mwp.pagani.search/21/?data=%7B%22page%22%3A18%2C%22pageSize%22%3A24%2C%22sort%22%3A%22pop%22%2C%22ratio%22%3A%223%3A4%22%2C%22fcid%22%3A%2220003463%22%2C%22cKey%22%3A%22h5-shopping%22%2C%22pid%22%3A%229750%22%7D&mw-ckey=h5-shopping&mw-appkey=100028&mw-ttid=NMMain%40mgj_h5_1.0&mw-t=1640242939425&mw-uuid=87a63ac6-471b-458f-9ede-6f8346a00f02&mw-h5-os=Android&mw-sign=e3e4b9c96db8e531cdfc05a348ae54c3&callback=mwpCb18&_=1640242939426",
                "https://api.mogu.com/h5/mwp.pagani.search/21/?data=%7B%22page%22%3A19%2C%22pageSize%22%3A24%2C%22sort%22%3A%22pop%22%2C%22ratio%22%3A%223%3A4%22%2C%22fcid%22%3A%2220003463%22%2C%22cKey%22%3A%22h5-shopping%22%2C%22pid%22%3A%229750%22%7D&mw-ckey=h5-shopping&mw-appkey=100028&mw-ttid=NMMain%40mgj_h5_1.0&mw-t=1640242956461&mw-uuid=87a63ac6-471b-458f-9ede-6f8346a00f02&mw-h5-os=Android&mw-sign=d1cf8e32eab9f74ce183af4a91505c68&callback=mwpCb19&_=1640242956462",
                "https://api.mogu.com/h5/mwp.pagani.search/21/?data=%7B%22page%22%3A20%2C%22pageSize%22%3A24%2C%22sort%22%3A%22pop%22%2C%22ratio%22%3A%223%3A4%22%2C%22fcid%22%3A%2220003463%22%2C%22cKey%22%3A%22h5-shopping%22%2C%22pid%22%3A%229750%22%7D&mw-ckey=h5-shopping&mw-appkey=100028&mw-ttid=NMMain%40mgj_h5_1.0&mw-t=1640242971903&mw-uuid=87a63ac6-471b-458f-9ede-6f8346a00f02&mw-h5-os=Android&mw-sign=c0b97ca070307053b28b32f857c850ba&callback=mwpCb20&_=1640242971905",
                "https://api.mogu.com/h5/mwp.pagani.search/21/?data=%7B%22page%22%3A20%2C%22pageSize%22%3A24%2C%22sort%22%3A%22pop%22%2C%22ratio%22%3A%223%3A4%22%2C%22fcid%22%3A%2220003463%22%2C%22cKey%22%3A%22h5-shopping%22%2C%22pid%22%3A%229750%22%7D&mw-ckey=h5-shopping&mw-appkey=100028&mw-ttid=NMMain%40mgj_h5_1.0&mw-t=1640242971903&mw-uuid=87a63ac6-471b-458f-9ede-6f8346a00f02&mw-h5-os=Android&mw-sign=c0b97ca070307053b28b32f857c850ba&callback=mwpCb20&_=1640242971905",
                "https://api.mogu.com/h5/mwp.pagani.search/21/?data=%7B%22page%22%3A21%2C%22pageSize%22%3A24%2C%22sort%22%3A%22pop%22%2C%22ratio%22%3A%223%3A4%22%2C%22fcid%22%3A%2220003463%22%2C%22cKey%22%3A%22h5-shopping%22%2C%22pid%22%3A%229750%22%7D&mw-ckey=h5-shopping&mw-appkey=100028&mw-ttid=NMMain%40mgj_h5_1.0&mw-t=1640243621439&mw-uuid=87a63ac6-471b-458f-9ede-6f8346a00f02&mw-h5-os=Android&mw-sign=06b8a308764b8ed79d1d5a079aecba4d&callback=mwpCb21&_=1640243621440",
                "https://api.mogu.com/h5/mwp.pagani.search/21/?data=%7B%22page%22%3A22%2C%22pageSize%22%3A24%2C%22sort%22%3A%22pop%22%2C%22ratio%22%3A%223%3A4%22%2C%22fcid%22%3A%2220003463%22%2C%22cKey%22%3A%22h5-shopping%22%2C%22pid%22%3A%229750%22%7D&mw-ckey=h5-shopping&mw-appkey=100028&mw-ttid=NMMain%40mgj_h5_1.0&mw-t=1640243640260&mw-uuid=87a63ac6-471b-458f-9ede-6f8346a00f02&mw-h5-os=Android&mw-sign=b080de8d60e97604ae18cd19df13af25&callback=mwpCb22&_=1640243640262",
                "https://api.mogu.com/h5/mwp.pagani.search/21/?data=%7B%22page%22%3A23%2C%22pageSize%22%3A24%2C%22sort%22%3A%22pop%22%2C%22ratio%22%3A%223%3A4%22%2C%22fcid%22%3A%2220003463%22%2C%22cKey%22%3A%22h5-shopping%22%2C%22pid%22%3A%229750%22%7D&mw-ckey=h5-shopping&mw-appkey=100028&mw-ttid=NMMain%40mgj_h5_1.0&mw-t=1640243657310&mw-uuid=87a63ac6-471b-458f-9ede-6f8346a00f02&mw-h5-os=Android&mw-sign=b7e0bb99fde79ad8ded4820377a62218&callback=mwpCb23&_=1640243657312",
                "https://api.mogu.com/h5/mwp.pagani.search/21/?data=%7B%22page%22%3A24%2C%22pageSize%22%3A24%2C%22sort%22%3A%22pop%22%2C%22ratio%22%3A%223%3A4%22%2C%22fcid%22%3A%2220003463%22%2C%22cKey%22%3A%22h5-shopping%22%2C%22pid%22%3A%229750%22%7D&mw-ckey=h5-shopping&mw-appkey=100028&mw-ttid=NMMain%40mgj_h5_1.0&mw-t=1640243723554&mw-uuid=87a63ac6-471b-458f-9ede-6f8346a00f02&mw-h5-os=Android&mw-sign=63648e6fd2f3a9f915906432e9e7bb9f&callback=mwpCb24&_=1640243723555",
                "https://api.mogu.com/h5/mwp.pagani.search/21/?data=%7B%22page%22%3A25%2C%22pageSize%22%3A24%2C%22sort%22%3A%22pop%22%2C%22ratio%22%3A%223%3A4%22%2C%22fcid%22%3A%2220003463%22%2C%22cKey%22%3A%22h5-shopping%22%2C%22pid%22%3A%229750%22%7D&mw-ckey=h5-shopping&mw-appkey=100028&mw-ttid=NMMain%40mgj_h5_1.0&mw-t=1640243739521&mw-uuid=87a63ac6-471b-458f-9ede-6f8346a00f02&mw-h5-os=Android&mw-sign=e627248cc40ed07c8ede41a00fff86ee&callback=mwpCb25&_=1640243739522",
                "https://api.mogu.com/h5/mwp.pagani.search/21/?data=%7B%22page%22%3A26%2C%22pageSize%22%3A24%2C%22sort%22%3A%22pop%22%2C%22ratio%22%3A%223%3A4%22%2C%22fcid%22%3A%2220003463%22%2C%22cKey%22%3A%22h5-shopping%22%2C%22pid%22%3A%229750%22%7D&mw-ckey=h5-shopping&mw-appkey=100028&mw-ttid=NMMain%40mgj_h5_1.0&mw-t=1640243757508&mw-uuid=87a63ac6-471b-458f-9ede-6f8346a00f02&mw-h5-os=Android&mw-sign=ec98ccb928e0d0bcfc4ebd12f6ec1b7c&callback=mwpCb26&_=1640243757509");

        for (int i = 0; i < urls.size(); i ++){
            System.out.println(i);
            List<PopGoods> goodss =   initPopGoodsData(urls.get(i));
            if(goodss != null){
                savePopGoods(goodss,"A");
            }

        }
    }

    private List<PopGoods> initPopGoodsData(String urlt) throws Exception {

        Thread.sleep(Long.parseLong("5000"));
        String url1 = urlt;
        URL url = new URL(url1);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("cookie","__mgjuuid=87a63ac6-471b-458f-9ede-6f8346a00f02; smidV2=202111201105381a3158671eea241129bffae165b4dfd900057014e81686530; _mwp_h5_token=bf0a1bc70ad1503751c72c7b273efa41_1640067672617; _mwp_h5_token_enc=ff0f8b24982902c67d45ef187f746fd2; _TDeParam=1-1WO714erLtrlXQsfPWE4Mw");
        connection.setRequestProperty("referer","https://m.mogu.com/");
        connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        try (InputStream in = connection.getInputStream();) {

            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = in.read(buffer)) != -1) {
                output.write(buffer, 0, len);
            }

            String result = new String(output.toByteArray());
            JSONObject jsonObject = JSONObject.parseObject(result.substring(8,result.length() - 1));
            jsonObject.getJSONObject("data").getJSONArray("list");
            JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONObject("wall").getJSONArray("docs");
            List<PopGoods> popGoods = jsonArray.toJavaList(PopGoods.class);
            return popGoods;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private void savePopGoods(List<PopGoods> goodss, String type) throws Exception {
        goodss = goodss.stream().map(goods ->{
            goods.setGoodsType("index");
            return goods;
        }).collect(Collectors.toList());
        for (PopGoods goods : goodss) {

            popGoodsService.save(goods);
        }
    }


    public void initRecommend() throws Exception{
        String recommentJsonStr = " [\n" +
                "        {\n" +
                "          \"shouqLink\": \"\",\n" +
                "          \"description\": \"\",\n" +
                "          \"_material_end_time\": 2147483647,\n" +
                "          \"acm\": \"3.mce.1_10_1u0ds.140653.0.9RnSdsPgFOyPj.pos_883-m_700060-sd_119\",\n" +
                "          \"title\": \"女装\",\n" +
                "          \"h5Link\": \"//m.mogu.com/wall/s?q=女装\",\n" +
                "          \"image\": \"https://s10.mogucdn.com/mlcdn/c45406/210218_1ldikaae13k9be2kc2860h3l2kc5i_150x150.png\",\n" +
                "          \"_material_start_time\": 1619366400,\n" +
                "          \"link\": \"mgj://freemarket/girldress?title=女装&acm=3.mce.1_10_1u0ds.140653.0.9RnSdsPgFOyPj.pos_883-m_700060-sd_119\",\n" +
                "          \"titleColor\": \"#666666\",\n" +
                "          \"sort\": 1,\n" +
                "          \"_system_record_entry_id\": \"700060\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"acm\": \"3.mce.1_10_1u0dw.140653.0.9RnSdsPgFOyP6.pos_870-m_700062-sd_119\",\n" +
                "          \"title\": \"新人福利\",\n" +
                "          \"titleColor\": \"#666666\",\n" +
                "          \"sort\": 2,\n" +
                "          \"_system_record_entry_id\": \"700062\",\n" +
                "          \"link\": \"//act.mogu.com/1451yixia?acm=3.mce.1_10_1u0dw.140653.0.9RnSdsPgFOyP6.pos_870-m_700062-sd_119\",\n" +
                "          \"description\": \"\",\n" +
                "          \"_material_end_time\": 2147483647,\n" +
                "          \"h5Link\": \"//act.mogu.com/0127xinren\",\n" +
                "          \"image\": \"https://s10.mogucdn.com/mlcdn/c45406/210127_28lafia2el07d272h21h0dk09dcgb_150x150.webp\",\n" +
                "          \"_material_start_time\": 1619366400,\n" +
                "          \"shouqLink\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"sort\": 3,\n" +
                "          \"_material_end_time\": 2147483647,\n" +
                "          \"title\": \"上衣\",\n" +
                "          \"image\": \"https://s10.mogucdn.com/mlcdn/c45406/210218_7llgl01h7l8la47ki60g90ij4ib1i_150x150.png\",\n" +
                "          \"titleColor\": \"#666666\",\n" +
                "          \"h5Link\": \"//m.mogu.com/wall/s?q=上衣\",\n" +
                "          \"_material_start_time\": 1619366400,\n" +
                "          \"_system_record_entry_id\": \"700065\",\n" +
                "          \"shouqLink\": \"\",\n" +
                "          \"link\": \"mgj://freemarket/jacket?title=上衣&acm=3.mce.1_10_1u0e2.140653.0.9RnSdsPgFOyPl.pos_885-m_700065-sd_119\",\n" +
                "          \"description\": \"\",\n" +
                "          \"acm\": \"3.mce.1_10_1u0e2.140653.0.9RnSdsPgFOyPl.pos_885-m_700065-sd_119\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"titleColor\": \"#666666\",\n" +
                "          \"_material_start_time\": 1619366400,\n" +
                "          \"sort\": 4,\n" +
                "          \"shouqLink\": \"\",\n" +
                "          \"link\": \"mgj://freemarket/shoes?title=女鞋&acm=3.mce.1_10_1u0e8.140653.0.9RnSdsPgFOyP8.pos_872-m_700068-sd_119\",\n" +
                "          \"_material_end_time\": 2147483647,\n" +
                "          \"acm\": \"3.mce.1_10_1u0e8.140653.0.9RnSdsPgFOyP8.pos_872-m_700068-sd_119\",\n" +
                "          \"image\": \"https://s10.mogucdn.com/mlcdn/c45406/210218_28j7d696795ccb7llejdce9keli0c_150x150.png\",\n" +
                "          \"_system_record_entry_id\": \"700068\",\n" +
                "          \"description\": \"\",\n" +
                "          \"title\": \"女鞋\",\n" +
                "          \"h5Link\": \"//m.mogu.com/wall/s?q=女鞋\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"titleColor\": \"#666666\",\n" +
                "          \"h5Link\": \"//m.mogu.com/wall/s?q=裤子\",\n" +
                "          \"image\": \"https://s10.mogucdn.com/mlcdn/c45406/210218_16dal2iaj300ce73ada65g0514jlk_151x150.png\",\n" +
                "          \"shouqLink\": \"\",\n" +
                "          \"description\": \"\",\n" +
                "          \"_material_end_time\": 2147483647,\n" +
                "          \"acm\": \"3.mce.1_10_1u0ee.140653.0.9RnSdsPgFOyPn.pos_887-m_700071-sd_119\",\n" +
                "          \"title\": \"裤子\",\n" +
                "          \"link\": \"mgj://freemarket/pants?title=裤子&acm=3.mce.1_10_1u0ee.140653.0.9RnSdsPgFOyPn.pos_887-m_700071-sd_119\",\n" +
                "          \"_material_start_time\": 1619366400,\n" +
                "          \"sort\": 5,\n" +
                "          \"_system_record_entry_id\": \"700071\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"title\": \"美妆/护肤\",\n" +
                "          \"image\": \"https://s10.mogucdn.com/mlcdn/c45406/210218_2bdj4144677j5hlbdi5d490a2ad5c_150x150.png\",\n" +
                "          \"_material_start_time\": 1619366400,\n" +
                "          \"_system_record_entry_id\": \"700072\",\n" +
                "          \"shouqLink\": \"\",\n" +
                "          \"link\": \"mgj://freemarket/magic?title=美妆/个护&acm=3.mce.1_10_1u0eg.140653.0.9RnSdsPgFOyP9.pos_873-m_700072-sd_119\",\n" +
                "          \"description\": \"\",\n" +
                "          \"_material_end_time\": 2147483647,\n" +
                "          \"acm\": \"3.mce.1_10_1u0eg.140653.0.9RnSdsPgFOyP9.pos_873-m_700072-sd_119\",\n" +
                "          \"titleColor\": \"#666666\",\n" +
                "          \"h5Link\": \"//m.mogu.com/wall/s?q=美妆/个护\",\n" +
                "          \"sort\": 6\n" +
                "        },\n" +
                "        {\n" +
                "          \"_material_end_time\": 2147483647,\n" +
                "          \"acm\": \"3.mce.1_10_1u0eq.140653.0.9RnSdsPgFOyPp.pos_889-m_700077-sd_119\",\n" +
                "          \"title\": \"裙子\",\n" +
                "          \"_material_start_time\": 1619366400,\n" +
                "          \"_system_record_entry_id\": \"700077\",\n" +
                "          \"link\": \"mgj://freemarket/dress?title=裙子&acm=3.mce.1_10_1u0eq.140653.0.9RnSdsPgFOyPp.pos_889-m_700077-sd_119\",\n" +
                "          \"titleColor\": \"#666666\",\n" +
                "          \"h5Link\": \"//m.mogu.com/wall/s?q=裙子\",\n" +
                "          \"image\": \"https://s10.mogucdn.com/mlcdn/c45406/200327_2lliak11gh3a6714a9k5ifi0e6b4l_135x135.jpg\",\n" +
                "          \"sort\": 7,\n" +
                "          \"shouqLink\": \"\",\n" +
                "          \"description\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"_material_end_time\": 2147483647,\n" +
                "          \"acm\": \"3.mce.1_10_1u0es.140653.0.9RnSdsPgFOyPb.pos_875-m_700078-sd_119\",\n" +
                "          \"title\": \"母婴/童装\",\n" +
                "          \"h5Link\": \"//m.mogu.com/wall/s?q=母婴\",\n" +
                "          \"sort\": 8,\n" +
                "          \"description\": \"\",\n" +
                "          \"titleColor\": \"#666666\",\n" +
                "          \"image\": \"https://s10.mogucdn.com/mlcdn/c45406/210218_4jk839952i9aaac7jbh12jhgbkk88_151x150.png\",\n" +
                "          \"_material_start_time\": 1619366400,\n" +
                "          \"_system_record_entry_id\": \"700078\",\n" +
                "          \"shouqLink\": \"\",\n" +
                "          \"link\": \"mgj://freemarket/baby?title=母婴&acm=3.mce.1_10_1u0es.140653.0.9RnSdsPgFOyPb.pos_875-m_700078-sd_119\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"image\": \"https://s10.mogucdn.com/mlcdn/c45406/210218_571djje4gf3dj24cj6c24k6gl0kcl_150x150.png\",\n" +
                "          \"sort\": 9,\n" +
                "          \"shouqLink\": \"\",\n" +
                "          \"link\": \"mgj://freemarket/suite?title=套装&acm=3.mce.1_10_1u0ey.140653.0.9RnSdsPgFOyPq.pos_890-m_700081-sd_119\",\n" +
                "          \"description\": \"\",\n" +
                "          \"title\": \"套装\",\n" +
                "          \"titleColor\": \"#666666\",\n" +
                "          \"h5Link\": \"//m.mogu.com/wall/s?q=套装\",\n" +
                "          \"_material_start_time\": 1619366400,\n" +
                "          \"_system_record_entry_id\": \"700081\",\n" +
                "          \"_material_end_time\": 2147483647,\n" +
                "          \"acm\": \"3.mce.1_10_1u0ey.140653.0.9RnSdsPgFOyPq.pos_890-m_700081-sd_119\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"description\": \"\",\n" +
                "          \"_material_end_time\": 2147483647,\n" +
                "          \"title\": \"男装男鞋\",\n" +
                "          \"titleColor\": \"#666666\",\n" +
                "          \"h5Link\": \"//m.mogu.com/wall/s?q=男装\",\n" +
                "          \"sort\": 10,\n" +
                "          \"link\": \"mgj://freemarket/boyfriend?title=男装&acm=3.mce.1_10_1u0f2.140653.0.9RnSdsPgFOyPc.pos_876-m_700083-sd_119\",\n" +
                "          \"acm\": \"3.mce.1_10_1u0f2.140653.0.9RnSdsPgFOyPc.pos_876-m_700083-sd_119\",\n" +
                "          \"image\": \"https://s10.mogucdn.com/mlcdn/c45406/210218_6gkk1d58i9gfgba91k24kdkeke1jc_151x150.png\",\n" +
                "          \"_material_start_time\": 1619366400,\n" +
                "          \"_system_record_entry_id\": \"700083\",\n" +
                "          \"shouqLink\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"acm\": \"3.mce.1_10_1u0fa.140653.0.9RnSdsPgFOyPs.pos_892-m_700087-sd_119\",\n" +
                "          \"title\": \"内衣\",\n" +
                "          \"image\": \"https://s10.mogucdn.com/mlcdn/c45406/210218_6i5gdg03b8f2l4a342bl0c337i6d8_150x150.png\",\n" +
                "          \"sort\": 11,\n" +
                "          \"_system_record_entry_id\": \"700087\",\n" +
                "          \"link\": \"mgj://freemarket/underwear?title=内衣&acm=3.mce.1_10_1u0fa.140653.0.9RnSdsPgFOyPs.pos_892-m_700087-sd_119\",\n" +
                "          \"description\": \"\",\n" +
                "          \"_material_end_time\": 2147483647,\n" +
                "          \"shouqLink\": \"\",\n" +
                "          \"titleColor\": \"#666666\",\n" +
                "          \"h5Link\": \"//m.mogu.com/wall/s?q=内衣\",\n" +
                "          \"_material_start_time\": 1619366400\n" +
                "        },\n" +
                "        {\n" +
                "          \"acm\": \"3.mce.1_10_1u0fe.140653.0.9RnSdsPgFOyPe.pos_878-m_700089-sd_119\",\n" +
                "          \"h5Link\": \"//m.mogu.com/wall/s?q=配饰\",\n" +
                "          \"shouqLink\": \"\",\n" +
                "          \"description\": \"\",\n" +
                "          \"_material_end_time\": 2147483647,\n" +
                "          \"title\": \"配饰\",\n" +
                "          \"titleColor\": \"#666666\",\n" +
                "          \"image\": \"https://s10.mogucdn.com/mlcdn/c45406/210218_435b14j61676clgbd60k99d72d53j_150x150.png\",\n" +
                "          \"_material_start_time\": 1619366400,\n" +
                "          \"sort\": 12,\n" +
                "          \"_system_record_entry_id\": \"700089\",\n" +
                "          \"link\": \"mgj://freemarket/accessories?title=配饰&acm=3.mce.1_10_1u0fe.140653.0.9RnSdsPgFOyPe.pos_878-m_700089-sd_119\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"_material_start_time\": 1619366400,\n" +
                "          \"sort\": 13,\n" +
                "          \"description\": \"\",\n" +
                "          \"_material_end_time\": 2147483647,\n" +
                "          \"title\": \"家居\",\n" +
                "          \"titleColor\": \"#666666\",\n" +
                "          \"h5Link\": \"//m.mogu.com/wall/book/household?fcid=50526&title=家居百货\",\n" +
                "          \"image\": \"https://s10.mogucdn.com/mlcdn/c45406/210218_65b6l20557h1dklh2g95b17ajal8k_150x150.png\",\n" +
                "          \"_system_record_entry_id\": \"700093\",\n" +
                "          \"link\": \"mgj://freemarket/decorate?title=家居&acm=3.mce.1_10_1u0fm.140653.0.9RnSdsPgFOyPu.pos_894-m_700093-sd_119\",\n" +
                "          \"acm\": \"3.mce.1_10_1u0fm.140653.0.9RnSdsPgFOyPu.pos_894-m_700093-sd_119\",\n" +
                "          \"shouqLink\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"acm\": \"3.mce.1_10_1u0fs.140653.0.9RnSdsPgFOyPh.pos_881-m_700096-sd_119\",\n" +
                "          \"title\": \"包包\",\n" +
                "          \"titleColor\": \"#666666\",\n" +
                "          \"image\": \"https://s10.mogucdn.com/mlcdn/c45406/210218_51cdb7a3g5698612lg076465bk5d4_150x150.png\",\n" +
                "          \"_system_record_entry_id\": \"700096\",\n" +
                "          \"_material_end_time\": 2147483647,\n" +
                "          \"description\": \"\",\n" +
                "          \"h5Link\": \"//m.mogu.com/wall/s?q=包包\",\n" +
                "          \"_material_start_time\": 1619366400,\n" +
                "          \"sort\": 14,\n" +
                "          \"shouqLink\": \"\",\n" +
                "          \"link\": \"mgj://freemarket/bags?title=包包&acm=3.mce.1_10_1u0fs.140653.0.9RnSdsPgFOyPh.pos_881-m_700096-sd_119\"\n" +
                "        }\n" +
                "      ]";


        JSONArray jsonArray = (JSONArray) JSONObject.parse(recommentJsonStr);
        List<Recommend> recommends = jsonArray.toJavaList(Recommend.class);
        recommendService.saveRecommends(recommends);

    }

    public void  initGoods() throws Exception{

        for (int i = 0; i < 50; i ++){
           List<Goods> goodss =   initHomeData("home");
            saveGoods(goodss,"A");
        }

        for (int i = 0; i < 50; i ++){
            List<Goods> goodss =   initHomeData("home");
            saveGoods(goodss,"B");
        }

        for (int i = 0; i < 50; i ++){
            List<Goods> goodss =   initHomeData("home");
            saveGoods(goodss,"C");
        }
    }

    @Override
    public PageModelVO<PopGoods> getGoodsList(String goodsType,Integer page, Integer pageNo) throws Exception {

        Page<PopGoods>  goodsPage = this.popGoodsService.findByGoodsType(goodsType, PageRequest.of(pageNo,page));

        return new PageModelVO<>(goodsPage.getContent());
    }

    @Override
    public PageModelVO<Recommend> getRecommend() throws Exception {
        return new PageModelVO<>(this.recommendService.findAllRecommend());
    }

    @Override
    public PageModelVO<Banner> getBanner() throws Exception {
        return new PageModelVO<>(this.bannerService.finAllBanner());
    }

    @Override
    public ApiResultModelVo<String> detail(String itemId) throws Exception {
        PopGoodsDosc popGoodsDosc =  popGoodsDoscService.findByIid(itemId);


        ApiResultModelVo<String> apiResultModelVo = new ApiResultModelVo<>();
        apiResultModelVo.setData(popGoodsDosc.getDescText());
        return apiResultModelVo;
    }

    @Override
    public List<PopGoods> findAllPopGoods() throws Exception{
        return this.popGoodsService.finAll();
    }

    public void saveGoods(List<Goods> goodsList,String type){
        goodsList = goodsList.stream().map(goods ->{
            goods.setGoodsType("A");
            return goods;
        }).collect(Collectors.toList());
        for (Goods goods : goodsList) {
            goods.setLefttop_taglist(null);
            goods.setBar_taglist(null);
            goods.setPromotion_taglist(null);
            homeDao.save(goods);
        }
    }

    //教育部老师登录iPad自动跳转了线路（修改人员信息，登录iPad测试查看原因）
    public void initDetail(String itemId) throws Exception {
        String rs = "";
        String dataPaream = "{\"template\":\"6-2-detail_normal-1.0.0\",\"iid\":\""+itemId+"\",\"debug\":false,\"smbi\":true,\"sourceParams\":\"null\"}";
        String url1 = "https://api.mogu.com/h5/http.detail.api/1/?data="+ URLEncoder.encode(dataPaream,"UTF-8") +"&mw-appkey=100028&mw-ttid=NMMain@mgj_h5_1.0&mw-t=1640316023044&mw-uuid=87a63ac6-471b-458f-9ede-6f8346a00f02&mw-h5-os=Android&mw-sign=" +
                getMoGuSign(itemId) +
                "&callback=mwpCb1&_=1640246536888";
        URL url = new URL(url1);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("cookie","__mgjuuid=87a63ac6-471b-458f-9ede-6f8346a00f02; smidV2=202111201105381a3158671eea241129bffae165b4dfd900057014e81686530; _mwp_h5_token=bf0a1bc70ad1503751c72c7b273efa41_1640067672617; _mwp_h5_token_enc=ff0f8b24982902c67d45ef187f746fd2");
        connection.setRequestProperty("referer","https://h5.mogu.com/");
        try (InputStream in = connection.getInputStream();) {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = in.read(buffer)) != -1) {
                output.write(buffer, 0, len);
            }

            String result = new String(output.toByteArray());

            PopGoodsDosc popGoodsDosc = new PopGoodsDosc();
            popGoodsDosc.setDescText(result.substring(7, result.length() - 1));
            popGoodsDosc.setIid(itemId);
            popGoodsDoscService.save(popGoodsDosc);

            JSONObject jsonObject = JSONObject.parseObject(result.substring(7, result.length() - 1));
            rs = jsonObject.getJSONObject("data").getJSONObject("result").toJSONString();

        }
    }


    public List<Goods>  initHomeData(String type)  throws Exception {

        Thread.sleep(Long.parseLong("2000"));
        String url1 = "https://api.mogu.com/h5/mwp.pagani.search/22/?data={\"cKey\":\"actorItemMofangWall\",\"filter\":{\"hasExplain\":true,\"filterNoStock\":true},\"sorts\":[7],\"mbook\":\"eyJvZmZzZXQiOjAsInBhZ2UiOjIsInBhZ2VTaXplIjozMCwidCI6Ino4ZGx1c1FOQTJodXkiLCJ0b3BuQ29udGV4dCI6IiJ9\",\"page\":1,\"prismCode\":\"home_live_slice_h5_rec\",\"size\":30,\"\":\"\"}&mw-appkey=100028&mw-ttid=NMMain@mgj_h5_1.0&mw-t=1638778141160&mw-uuid=87a63ac6-471b-458f-9ede-6f8346a00f02&mw-h5-os=Android&mw-sign=755bda8137a3f15216089c9fa89a4606&callback=mwpCb5&_=1638778141162";
        URL url = new URL(url1);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("cookie","__mgjuuid=87a63ac6-471b-458f-9ede-6f8346a00f02; smidV2=202111201105381a3158671eea241129bffae165b4dfd900057014e81686530; _mwp_h5_token=2a845dc79f930cafa57bc2e46c49cce6_1638344381825; _mwp_h5_token_enc=0924f2f031b789793594c87c5e022b66");
        connection.setRequestProperty("referer","https://m.mogu.com/");
        connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        try (InputStream in = connection.getInputStream();) {

            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = in.read(buffer)) != -1) {
                output.write(buffer, 0, len);
            }

            String result = new String(output.toByteArray());


            JSONObject jsonObject = JSONObject.parseObject(result.substring(7,result.length() - 1));
            jsonObject.getJSONObject("data").getJSONArray("list");
            JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("list");
            List<Goods> goods = jsonArray.toJavaList(Goods.class);
            return goods;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public String getMoGuSign(String iid) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        engine.eval(new FileReader("F:\\svn\\hoyarCode\\minimall\\src\\main\\java\\com\\sve\\minimall\\servlet\\impl\\mogumwsign.js"));
        if (engine instanceof Invocable) {
            Invocable invocable = (Invocable) engine;
            String  mogumwsign = (String) invocable.invokeFunction("getMogumwsign",iid);
            return mogumwsign;

        }else{
            return null;
        }
    }
}



