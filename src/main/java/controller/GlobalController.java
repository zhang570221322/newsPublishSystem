package controller;

import model.Category;
import model.Report;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zwl on 2017/9/7.
 * May god bless me
 */
@Controller
@RequestMapping("/")
public class GlobalController {
    public static Logger logger = Logger.getLogger(GlobalController.class);
    @RequestMapping(value = "/GET/session/user",method = RequestMethod.GET)
    public @ResponseBody  Map<String,Object> turnTO1(HttpSession session){
        Map<String,Object> map = new HashMap<String,Object>();
        Object user = session.getAttribute("user");
        map.put("user",user);
        return map;
    }

    @RequestMapping(value = "/GET/application/indexContent",method = RequestMethod.GET)
    public @ResponseBody  Map<String,Object> get(HttpServletRequest request){
        ServletContext servletContext =request.getServletContext();
        Map<String,Object> map = new HashMap<String,Object>();
        List<Category> categories  = (List<Category>) servletContext.getAttribute("categories");
        List<Report> recentReports= (List<Report>) servletContext.getAttribute("recentReports");
        List<Report> hottestReports= (List<Report>) servletContext.getAttribute("hottestReports");
        map.put("categories",categories);
        map.put("recentReports",recentReports);
        map.put("hottestReports",hottestReports);
        return map;
    }


}
