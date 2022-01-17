
package com.sve.minimall.entity;

import javax.persistence.*;

@Entity
@Table(name = "recommend")
public class Recommend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String shouqLink;
    private String description;
    private long _material_end_time;
    private String acm;
    private String title;
    private String h5Link;
    private String image;
    private long _material_start_time;
    private String link;
    private String titleColor;
    private int sort;
    private String _system_record_entry_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setShouqLink(String shouqLink) {
        this.shouqLink = shouqLink;
    }
    public String getShouqLink() {
        return shouqLink;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public void set_material_end_time(long _material_end_time) {
        this._material_end_time = _material_end_time;
    }
    public long get_material_end_time() {
        return _material_end_time;
    }

    public void setAcm(String acm) {
        this.acm = acm;
    }
    public String getAcm() {
        return acm;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setH5Link(String h5Link) {
        this.h5Link = h5Link;
    }
    public String getH5Link() {
        return h5Link;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getImage() {
        return image;
    }

    public void set_material_start_time(long _material_start_time) {
        this._material_start_time = _material_start_time;
    }
    public long get_material_start_time() {
        return _material_start_time;
    }

    public void setLink(String link) {
        this.link = link;
    }
    public String getLink() {
        return link;
    }

    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }
    public String getTitleColor() {
        return titleColor;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
    public int getSort() {
        return sort;
    }

    public void set_system_record_entry_id(String _system_record_entry_id) {
        this._system_record_entry_id = _system_record_entry_id;
    }
    public String get_system_record_entry_id() {
        return _system_record_entry_id;
    }

}