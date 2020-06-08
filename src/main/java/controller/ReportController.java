package controller;

import model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.BaseService;
import service.ReportService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zwl on 2017/9/11.
 * May god bless me
 */
@Controller
public class ReportController   extends  BaseController<Report>{
    @Autowired
    private ReportService reportService;

    @Override
    public void afterPropertiesSet() throws Exception {

        setBaseService(reportService);
    }

    /**
     *得到 t
     * @param
     * @return
     */

    @RequestMapping(value = "/GET/report/{id}")
    public  @ResponseBody  Map<String, Object> getById(@PathVariable("id") int id) {
        Map<String,Object> map = new HashMap<String,Object>();
        Report byId = reportService.getById(id);
        map.put("report",byId);
        return  map;
    }
    /**
     * 添加 t
     * @param report
     * @return
     */
    @Override
    @RequestMapping(value = "/POST/report2",method = RequestMethod.POST)
    public  @ResponseBody  Map<String, Object> addT2(Report report) {
        return super.addT2(report);
    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @param where
     * @return
     */
    @Override
    @RequestMapping(value = "/GET/reports",method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody  Map<String, Object> getAllT(@RequestParam(value = "page",required = false) int pageNum,
                                       @RequestParam(value = "rows",required = false)int pageSize,
                                       @RequestParam(value = "where",required = false)String where) {
        System.out.println(where+"*************");
        System.out.println(baseService+"*************");
        Map<String,Object> map = new HashMap<String,Object>();
        List<Report> allT = baseService.getAllT(pageNum,pageSize,where);
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
    @Override
    @RequestMapping(value = "/DELETE/report/{ids}")
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
    @RequestMapping(value = "/DELETE/reports")
    public @ResponseBody  Map<String, Object> removeT2(@RequestParam("ids") String ids) {
        return super.removeT2(ids);
    }

    @Override
    @RequestMapping(value = "/PUT/report")
    public @ResponseBody  Map<String, Object> updateT(Report report) {
        return super.updateT(report);
    }
    @RequestMapping(value = "/GET/reports2")
    public @ResponseBody Map<String,Object> searchByWorld(@RequestParam(value = "page",required = false)Integer pageSize,@RequestParam(value = "searchValue",required = false)String search,@RequestParam(value = "category_id",required = false)Integer category_id){
        Map<String, Object> map = new HashMap<String, Object>();
        List<Report> allT = null;
        int total = 0;
        if(pageSize==null){
            pageSize=1;
        }
        if(search!=null) {
           String where = search;
            allT    = reportService.getAllT(pageSize, 8, "  re.title like '%" + where + "%'  or re.content like '%" + where + "%'  order by  Gmt_create desc");
            total = baseService.getAllTNumber("title like '%" + where + "%'  or content like '%" + where + "%'");
       }
       if(category_id!=null){
           String where = search;
           allT    = reportService.getAllT(pageSize, 8, "  re.category_id = "+ category_id+" order by  Gmt_create desc");
           total = baseService.getAllTNumber( "  category_id  ="+ category_id);

       }
        map.put("rows",allT);
        map.put("total",total );
        return map;
    }
}
