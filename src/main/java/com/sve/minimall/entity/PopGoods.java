package com.sve.minimall.entity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "pop_goods")
public class PopGoods implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String tradeItemId;
        private String acm;
        private String similarityUrl;
        private String itemMarks;
        private String title;
        private String sale;
        private String price;
        private String cfav;
        private String img;
        private String itemType;
        private String iid;
        private String clientUrl;
        private String link;
        private String orgPrice;
        private String goodsType;


    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTradeItemId() {
        return tradeItemId;
    }

    public void setTradeItemId(String tradeItemId) {
        this.tradeItemId = tradeItemId;
    }

    public String getAcm() {
        return acm;
    }

    public void setAcm(String acm) {
        this.acm = acm;
    }



    public String getSimilarityUrl() {
        return similarityUrl;
    }

    public void setSimilarityUrl(String similarityUrl) {
        this.similarityUrl = similarityUrl;
    }

    public String getItemMarks() {
        return itemMarks;
    }

    public void setItemMarks(String itemMarks) {
        this.itemMarks = itemMarks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }



    public String getCfav() {
        return cfav;
    }

    public void setCfav(String cfav) {
        this.cfav = cfav;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }

    public String getClientUrl() {
        return clientUrl;
    }

    public void setClientUrl(String clientUrl) {
        this.clientUrl = clientUrl;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getOrgPrice() {
        return orgPrice;
    }

    public void setOrgPrice(String orgPrice) {
        this.orgPrice = orgPrice;
    }
}
