package service;


import model.User;
import model.UserBefore;

import java.util.List;

/**
 * Created by zwl on 2017/9/6.
 * May god bless me
 */
public interface UserService  extends BaseService<User>{
    /**
     * 1、	用户注册
     * @param u
     * @return
     */
    int register(UserBefore u);
    /**
     * 2、	用户登录
     * @param u
     * @return
     */
     User access(User u);

    /**
     * 得到非冻结的用户
     * @return
     */
    List<User> getRightUser (int pageNum,int pageSize);
    /**
     * 批量冻结用户
     * @param ids 根据ids
     * @return
     */
     int frozenUser(String ids);





}
