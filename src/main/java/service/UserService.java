package service;

import model.Info;
import model.User;
import model.UserBefore;

import java.util.List;

/**
 * Created by zwl on 2017/9/6.
 * May god bless me
 */
public interface UserService {
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
     * 3.1、	管理员删除用户
     * @param ids 根据多个id删除 (1,2,3 ) 必须为这样的形式
      * @return
     */
     int removeUser(String ids);


    /**
     * 4.1、	管理员查询用户
     * 查询所有
     * @return
     */
     List<User> getAllUser(int pageNum,int pageSize);

    /**
     * 得到非冻结的用户
     * @return
     */
    List<User> getRightUser (int pageNum,int pageSize);

    /**
     * 5、	管理员增加用户
     * @param u
     * @return
     */
     int addUser(User u);

    /**
     * 修改单一用户，须有主键
     * @param user
     * @return
     */
     int alterUser(User user);

    /**
     * 批量冻结用户
     * @param ids 根据ids
     * @return
     */
     int frozenUser(String ids);
}
