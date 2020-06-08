package model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import util.CustomDateSerializer;

import java.util.Date;

/**
 * Created by zwl on 2017/9/8.
 * May god bless me
 */
public class Report {
    private Integer id;
    private Integer clickNumber;
    private String title;
    private String content;
    private Date gmt_create;
    private Date gmt_modified;
    private  User reportUser;
    private String upload;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClickNumber() {
        return clickNumber;
    }

    public void setClickNumber(Integer clickNumber) {
        this.clickNumber = clickNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @JsonSerialize(using= CustomDateSerializer.class)
    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }
    @JsonSerialize(using= CustomDateSerializer.class)
    public Date getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    public User getReportUser() {
        return reportUser;
    }

    public void setReportUser(User reportUser) {
        this.reportUser = reportUser;
    }

    public Category getReportCategory() {
        return reportCategory;
    }

    public void setReportCategory(Category reportCategory) {
        this.reportCategory = reportCategory;
    }

    private Category reportCategory;

}
