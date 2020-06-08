package controller;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import service.BaseService;
import service.ReportService;
import util.ControllerUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zwl on 2017/9/11.
 * May god bless me
 */
@Controller
@Lazy(true)
public class BaseController<T> implements InitializingBean {
    protected BaseService<T> baseService;

   protected BaseService<T> getBaseService() {
        return baseService;
    }

    public void setBaseService(BaseService<T> baseService) {
        this.baseService = baseService;
    }

    /**
     * 添加 t
     * @param t
     * @return
     */
    public
    Map<String,Object> addT2(T t){
        Map<String,Object> map = new HashMap<String,Object>();
        int code=baseService.addT(t);
        ControllerUtil.handMap(code!=0,map,"注册失败，请重新注册","注册成功，跳转登陆页面");
        return map;
    }


    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    public   Map<String,Object> getAllT(int pageNum, int pageSize, String  where
    ){
        Map<String,Object> map = new HashMap<String,Object>();
        List<T> allT = baseService.getAllT(pageNum,pageSize,where);
        int total = baseService.getAllTNumber();
        map.put("rows",allT);
        map.put("total",total );
        return map;
    }
    /**
     * url 删除
     * @param ids
     * @return
     */
    public   Map<String,Object> removeT1( String ids){
        Map<String,Object> map = new HashMap<String,Object>();
        int code = baseService.removeT(ids);
        ControllerUtil.handMap(code!=0,map,"删除失败","删除成功");
        return  map;
    }
    /**
     * ajax删除
     * @param ids
     * @return
     */
    public   Map<String,Object> removeT2( String ids){
        Map<String,Object> map = new HashMap<String,Object>();
        int code = baseService.removeT(ids);
        ControllerUtil.handMap(code!=0,map,"删除失败","删除成功");
        return  map;
    }
    public Map<String,Object> updateT(T t) {
        Map<String,Object> map = new HashMap<String,Object>();
        int code = baseService.alterT(t);
        ControllerUtil.handMap(code!=0,map,"失败","成功");
        return  map;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
   setBaseService(baseService);
    }
}
