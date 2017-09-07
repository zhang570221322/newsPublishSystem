package controller;

import model.User;
import model.UserBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by zwl on 2017/9/7.
 * May god bless me
 */
@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 注册
     * @param user
     * @return
     */
     @RequestMapping(value = "/POST/user",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> register(UserBefore user){
         Map<String,Object> map = new HashMap<String,Object>();
         int code=userService.register(user);
         if(code!=0){
            map.put("code","success");
            map.put("message","注册成功，跳转登陆页面");
         }else{
             map.put("code","error");
             map.put("message","注册失败，请重新注册");
         }
        return map;
     }

    /**
     *登陆
     * @param user
     * @param session
     * @return
     */
    @RequestMapping(value = "/GET/user" ,method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> login(User user,HttpSession session){
        Map<String,Object> map = new HashMap<String,Object>();
        user=userService.access(user);
        if(Objects.nonNull(user.getId())&&user.getId()!=0){
            session.setAttribute("user",user);

            map.put("code","success");
            map.put("message","，登陆成功，跳转首页");
        }else{
            map.put("code","error");
            map.put("message","登陆失败，请重新登陆");
        }
        return map;
    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/GET/users",method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getAllUser(@RequestParam(value = "pageNum",required = false)int pageNum,
                                                       @RequestParam(value = "pageSize",required = false)int pageSize){
        Map<String,Object> map = new HashMap<String,Object>();
        List<User> allUser = userService.getAllUser(pageNum,pageSize);
        map.put("users",allUser);
        return map;
    }
}
