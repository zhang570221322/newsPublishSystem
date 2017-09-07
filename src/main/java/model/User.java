package model;

import java.util.Date;

public class User {
    private Integer id;

    private String username;

    private String password;

    private String phone;

    private Byte frozen;

    private Byte admin;

    private Date gmtModified;

    private Date gmtCreate;

    public User(Integer id, String username, String password, String phone, Byte frozen, Byte admin, Date gmtModified, Date gmtCreate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.frozen = frozen;
        this.admin = admin;
        this.gmtModified = gmtModified;
        this.gmtCreate = gmtCreate;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Byte getFrozen() {
        return frozen;
    }

    public void setFrozen(Byte frozen) {
        this.frozen = frozen;
    }

    public Byte getAdmin() {
        return admin;
    }

    public void setAdmin(Byte admin) {
        this.admin = admin;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}