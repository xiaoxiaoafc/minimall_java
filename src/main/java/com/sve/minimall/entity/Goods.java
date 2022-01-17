/**
 * Copyright 2021 bejson.com
 */
package com.sve.minimall.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Auto-generated: 2021-12-04 14:26:49
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Entity
@Table(name = "goods")
public class Goods implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemIdUrl;
    private String itemImage;
    private String similarityUrl;
    private String acm;
    private String actorName;
    private String title;
    private int liveStatus;
    private int explainItemType;
    private String actorTag;
    private String videoH265Url;
    private String originItemImage;
    private boolean useVideoUrl;
    private String promotion_taglist;
    private String bar_taglist;
    private long liveId;
    private String bottomIcon;
    private String subtitle;
    private int itemType;
    private String showOrgPrice;
    private String itemMarks;
    private String actorIdUrl;
    private long actorId;
    private String link;
    private int orgPrice;
    private boolean hasSimilarity;
    private String videoUrl;
    private String showDiscountPrice;
    private String liveLink;
    private long itemId;
    private String sale;
    private String pcLink;
    private String actorAvatar;
    private String discountPrice;
    private int type;
    private int isSecKillItem;
    private long explainId;
    private long videoId;
    private String firstFrame;
    private boolean imageAdapt;
    private String lefttop_taglist;
    private String goodsType;

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public void setItemIdUrl(String itemIdUrl) {
        this.itemIdUrl = itemIdUrl;
    }
    public String getItemIdUrl() {
        return itemIdUrl;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }
    public String getItemImage() {
        return itemImage;
    }

    public void setSimilarityUrl(String similarityUrl) {
        this.similarityUrl = similarityUrl;
    }
    public String getSimilarityUrl() {
        return similarityUrl;
    }

    public void setAcm(String acm) {
        this.acm = acm;
    }
    public String getAcm() {
        return acm;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }
    public String getActorName() {
        return actorName;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setLiveStatus(int liveStatus) {
        this.liveStatus = liveStatus;
    }
    public int getLiveStatus() {
        return liveStatus;
    }

    public void setExplainItemType(int explainItemType) {
        this.explainItemType = explainItemType;
    }
    public int getExplainItemType() {
        return explainItemType;
    }

    public void setActorTag(String actorTag) {
        this.actorTag = actorTag;
    }
    public String getActorTag() {
        return actorTag;
    }

    public void setVideoH265Url(String videoH265Url) {
        this.videoH265Url = videoH265Url;
    }
    public String getVideoH265Url() {
        return videoH265Url;
    }

    public void setOriginItemImage(String originItemImage) {
        this.originItemImage = originItemImage;
    }
    public String getOriginItemImage() {
        return originItemImage;
    }

    public void setUseVideoUrl(boolean useVideoUrl) {
        this.useVideoUrl = useVideoUrl;
    }
    public boolean getUseVideoUrl() {
        return useVideoUrl;
    }

    public void setPromotion_taglist(String promotion_taglist) {
        this.promotion_taglist = promotion_taglist;
    }
    public String getPromotion_taglist() {
        return promotion_taglist;
    }

    public void setBar_taglist(String bar_taglist) {
        this.bar_taglist = bar_taglist;
    }
    public String getBar_taglist() {
        return bar_taglist;
    }

    public void setLiveId(long liveId) {
        this.liveId = liveId;
    }
    public long getLiveId() {
        return liveId;
    }

    public void setBottomIcon(String bottomIcon) {
        this.bottomIcon = bottomIcon;
    }
    public String getBottomIcon() {
        return bottomIcon;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
    public String getSubtitle() {
        return subtitle;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }
    public int getItemType() {
        return itemType;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public void setShowOrgPrice(String showOrgPrice) {
        this.showOrgPrice = showOrgPrice;
    }
    public String getShowOrgPrice() {
        return showOrgPrice;
    }

    public void setItemMarks(String itemMarks) {
        this.itemMarks = itemMarks;
    }
    public String getItemMarks() {
        return itemMarks;
    }

    public void setActorIdUrl(String actorIdUrl) {
        this.actorIdUrl = actorIdUrl;
    }
    public String getActorIdUrl() {
        return actorIdUrl;
    }

    public void setActorId(long actorId) {
        this.actorId = actorId;
    }
    public long getActorId() {
        return actorId;
    }

    public void setLink(String link) {
        this.link = link;
    }
    public String getLink() {
        return link;
    }

    public void setOrgPrice(int orgPrice) {
        this.orgPrice = orgPrice;
    }
    public int getOrgPrice() {
        return orgPrice;
    }

    public void setHasSimilarity(boolean hasSimilarity) {
        this.hasSimilarity = hasSimilarity;
    }
    public boolean getHasSimilarity() {
        return hasSimilarity;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
    public String getVideoUrl() {
        return videoUrl;
    }

    public void setShowDiscountPrice(String showDiscountPrice) {
        this.showDiscountPrice = showDiscountPrice;
    }
    public String getShowDiscountPrice() {
        return showDiscountPrice;
    }

    public void setLiveLink(String liveLink) {
        this.liveLink = liveLink;
    }
    public String getLiveLink() {
        return liveLink;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }
    public long getItemId() {
        return itemId;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }
    public String getSale() {
        return sale;
    }

    public void setPcLink(String pcLink) {
        this.pcLink = pcLink;
    }
    public String getPcLink() {
        return pcLink;
    }

    public void setActorAvatar(String actorAvatar) {
        this.actorAvatar = actorAvatar;
    }
    public String getActorAvatar() {
        return actorAvatar;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }
    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setType(int type) {
        this.type = type;
    }
    public int getType() {
        return type;
    }

    public void setIsSecKillItem(int isSecKillItem) {
        this.isSecKillItem = isSecKillItem;
    }
    public int getIsSecKillItem() {
        return isSecKillItem;
    }

    public void setExplainId(long explainId) {
        this.explainId = explainId;
    }
    public long getExplainId() {
        return explainId;
    }

    public void setVideoId(long videoId) {
        this.videoId = videoId;
    }
    public long getVideoId() {
        return videoId;
    }

    public void setLefttop_taglist(String lefttop_taglist) {
        this.lefttop_taglist = lefttop_taglist;
    }
    public String getLefttop_taglist() {
        return lefttop_taglist;
    }

    public void setFirstFrame(String firstFrame) {
        this.firstFrame = firstFrame;
    }
    public String getFirstFrame() {
        return firstFrame;
    }

    public void setImageAdapt(boolean imageAdapt) {
        this.imageAdapt = imageAdapt;
    }
    public boolean getImageAdapt() {
        return imageAdapt;
    }

}