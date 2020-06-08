package util;

import java.util.Map;

/**
 * Created by zwl on 2017/9/7.
 * May god bless me
 */
public class ControllerUtil {
    public static  void   handMap(Boolean boo,Map<String,Object> map,String errorInfo,String successInfo){
        if(boo){
            map.put("code","1");
            map.put("message",successInfo);
        }else{
            map.put("code","0");
            map.put("message",errorInfo);
        }

    }
}
