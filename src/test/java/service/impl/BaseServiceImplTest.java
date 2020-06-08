package service.impl;

import model.Category;
import model.Report;
import model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.CategoryService;
import service.ReportService;

import java.util.List;


/**
 * Created by zwl on 2017/9/11.
 * May god bless me
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class BaseServiceImplTest {
    @Autowired
    private ReportService reportService;
    @Test
    public  void  baseMapperTest(){
        List<Report> allT = reportService.getAllT(1, 5);
        allT.stream().forEach(report -> {
            System.out.println(report.getId());
        });
    }
}
