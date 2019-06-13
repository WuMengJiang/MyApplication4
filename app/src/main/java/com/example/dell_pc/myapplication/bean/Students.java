package com.example.dell_pc.myapplication.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Students {
    @Id(autoincrement = true)
    private Long id;
    private String text;
    private String thumbnail;
    private String top_comments_header;

    @Generated(hash = 1926753723)
    public Students(Long id, String text, String thumbnail,
            String top_comments_header) {
        this.id = id;
        this.text = text;
        this.thumbnail = thumbnail;
        this.top_comments_header = top_comments_header;
    }
    @Generated(hash = 174834727)
    public Students() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getText() {
        return this.text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getThumbnail() {
        return this.thumbnail;
    }
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    public String getTop_comments_header() {
        return this.top_comments_header;
    }
    public void setTop_comments_header(String top_comments_header) {
        this.top_comments_header = top_comments_header;
    }
    
}
