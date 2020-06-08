package service.impl;

import controller.ReportController;
import model.Category;
import model.Report;
import model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.ReportService;

import java.util.List;

/**
 * Created by zwl on 2017/9/11.
 * May god bless me
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ReportControllerTest {
//    @Autowired
//    private ReportController reportController;
    @Autowired
    private ReportService reportService;
     @Test
    public  void getAllTTest(){

         List<Report> allT = reportService.getAllT(0, 0, " 1 = 1 ");
         allT.stream().forEach(report -> {
             System.out.println(report);
         });

     }
     @Test
     public void insetReport(){
        Report r[] =new Report[400];
        User u=new User();
        u.setId(0);
         Category category=new Category();

         for (int i = 0; i < r.length; i++) {
             category.setId(1+(int)(Math.random()*16));
             r[i]=new Report();
             r[i].setContent("郑州大学选入双一流大学名单"+i);
             r[i].setReportUser(u);
            r[i].setReportCategory(category);
            r[i].setTitle("郑州大学选入双一流大学名单"+i);
             r[i].setClickNumber(1+(int)(Math.random()*3000) );
            reportService.addT(r[i]);

         }
     }
     @Test
    public void  getAllTestForUpdate(){
         List<Report> allT = reportService.getAllT(1, 8, "1 = 1 order by Gmt_create desc");
        allT.forEach(report -> System.out.println(report.getGmt_create()));
     }
    @Test
    public void  getAllTestForSearch(){
        String where ="郑州";
//        List<Report> allT = reportService.getAllT(1, 8, "  re.title like '%"+where+"%'  or re.content like '%"+where+"%'  order by  re.Gmt_create desc");
        List<Report>   allT   = reportService.getAllT(1, 8, "  re.category_id = "+ 0+" order by  Gmt_create desc");
        allT.forEach(report -> {
            System.out.println(report.getReportCategory().getName());
            System.out.println(report.getReportUser().getUsername());
        });
    }
}
