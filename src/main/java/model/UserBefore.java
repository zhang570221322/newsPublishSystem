package model;

import java.util.Date;

/**
 * Created by zwl on 2017/9/7.
 * May god bless me
 */
public class UserBefore extends User {
    private  String password1;
    private String password2;

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public UserBefore(Integer id, String username, String password, String phone, Byte frozen, Byte admin, Date gmtModified, Date gmtCreate, String password1, String password2) {
        super(id, username, password, phone, frozen, admin, gmtModified, gmtCreate);
        this.password1 = password1;
        this.password2 = password2;
    }

    public UserBefore(String password1, String password2) {
        this.password1 = password1;
        this.password2 = password2;
    }
    public UserBefore() {

    }
}
