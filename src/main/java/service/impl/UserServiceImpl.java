package service.impl;

import com.github.pagehelper.PageHelper;
import dao.UserMapper;
import model.Info;
import model.User;
import model.UserBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.List;

/**
 * Created by zwl on 2017/9/6.
 * May god bless me
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User access(User u) {
         return userMapper.get(u);
    }

    @Override
    public int removeUser(String ids) {
        return userMapper.delete(ids);
    }


    @Override
    public List<User> getAllUser(int pageNum,int pageSize) {
        Info<User> info=new Info<>();
        info.setWhereCondition("1=1");
        PageHelper.startPage(pageNum, pageSize);
        return  userMapper.list(info);
    }

    @Override
    public List<User> getRightUser(int pageNum,int pageSize) {
        Info<User> info=new Info<>();
        info.setWhereCondition("forzen != 1");
        PageHelper.startPage(pageNum, pageSize);
        return  userMapper.list(info);

    }

    @Override
    public int addUser(User u) {
        return userMapper.insert(u);
    }

    @Override
    public int alterUser(User user) {
        return  userMapper.update(user);
    }

    @Override
    public int frozenUser(String ids) {
        Info<User> info=new Info<>();
        info.setWhereCondition("id in "+ ids);
        User u=new User();
        u.setFrozen((byte) 1);
        info.setT(u);
        return  userMapper.update2(info);
    }

    @Override
    public int register(UserBefore u) {
        if (u.getPassword1().equals(u.getPassword2())){
            u.setPassword(u.getPassword1());
            return userMapper.insert(u);
        }
         return 0;
    }

}
