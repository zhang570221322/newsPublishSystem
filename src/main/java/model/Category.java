package model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import util.CustomDateSerializer;

import java.util.Date;
import java.util.List;

/**
 * Created by zwl on 2017/9/8.
 * May god bless me
 */
public class Category {
    private Integer id;
    private Integer clickNumber;
    private String name;
    private String content;
    private Date gmt_create;
    private Date gmt_modified;
    private User categoryUser;
    private List<Report> reports;

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    public User getCategoryUser() {
        return categoryUser;
    }

    public void setCategoryUser(User categoryUser) {
        this.categoryUser = categoryUser;
    }



    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
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

    public Integer getClickNumber() {
        return clickNumber;
    }

    public void setClickNumber(Integer clickNumber) {
        this.clickNumber = clickNumber;
    }
}
