package controller;

import model.User;
import model.UserBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.BaseService;
import service.UserService;
import util.ControllerUtil;

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
public class UserController  extends  BaseController<User> {
    @Autowired
    private UserService userService;

    @Override
    public void afterPropertiesSet() throws Exception {
        setBaseService(userService);
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
        session.setAttribute("user",user);
        ControllerUtil.handMap(Objects.nonNull(user),map,"登陆失败，请重新登陆","登陆成功，跳转首页");
        return map;
    }
    /**
     * 注册
     * @param user
     * @return
     */
     @RequestMapping(value = "/POST/user",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> register(UserBefore user){
         Map<String,Object> map = new HashMap<String,Object>();
         int code=userService.register(user);
         ControllerUtil.handMap(code!=0,map,"注册失败，请重新注册","注册成功，跳转登陆页面");
        return map;
     }




    /**
     * 添加 t
     *
     * @param user
     * @return
     */
    @Override
    @RequestMapping(value = "/POST/user2",method = RequestMethod.POST)
    public @ResponseBody  Map<String, Object> addT2(User user) {
        return super.addT2(user);
    }

    /**
     * 分页查询
     *
     * @param pageNum
     * @param pageSize
     * @param where
     * @return
     */
    @Override
    @RequestMapping(value = "/GET/users",method = {RequestMethod.GET,RequestMethod.POST})
    public  @ResponseBody  Map<String, Object> getAllT(@RequestParam(value = "page",required = false) int pageNum,
                                       @RequestParam(value = "rows",required = false) int pageSize,
                                       @RequestParam(value = "where",required = false)String where) {
        return super.getAllT(pageNum, pageSize, where);
    }

    /**
     * url 删除
     *
     * @param ids
     * @return
     */
    @Override
    @RequestMapping(value = "/DELETE/user/{ids}")
    public @ResponseBody  Map<String, Object> removeT1(@PathVariable("ids") String ids) {
        return super.removeT1(ids);
    }

    /**
     * ajax删除
     *
     * @param ids
     * @return
     */
    @Override
    @RequestMapping(value = "/DELETE/users")
    public @ResponseBody  Map<String, Object> removeT2(@RequestParam("ids") String ids) {
        return super.removeT2(ids);
    }

    @Override
    @RequestMapping(value = "/PUT/user")
    public @ResponseBody  Map<String, Object> updateT(User user) {
        return super.updateT(user);
    }
}
