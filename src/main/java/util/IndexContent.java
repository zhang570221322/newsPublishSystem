package util;

import model.Category;
import model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.CategoryService;
import service.ReportService;

import javax.servlet.ServletContext;
import java.util.List;
import java.util.TimerTask;

/**
 * Created by zwl on 2017/9/12.
 * May god bless me
 */
@Component
public class IndexContent  extends TimerTask{

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ReportService reportService;
    /**
     * The action to be performed by this timer task.
     */
    private ServletContext application ; //定义一个ServletContext对象，因为我们更新了后台数据后，需要存入application域里面

    public void setApplication(ServletContext application) {
        this.application = application; //通过监听器将这个application对象set进来，因为这里是无法拿application对象的
    }
    @Override
    public void run() {
        System.out.println("----run----");
        List<Category> categories = categoryService.getAllT(0, 0, " 1 = 1");
        List<Report> recentReports = reportService.getAllT(1, 8, "1 = 1 order by Gmt_create desc");
        List<Report> hottestReports = reportService.getAllT(1, 8, "1 = 1 order by clickNumber desc");
        categories.forEach(category -> {
            List<Report> reports = reportService.getAllT(1, 4, " category_id = " + category.getId());
                category.setReports(reports);
        });
        application.setAttribute("categories",categories);
        application.setAttribute("recentReports",recentReports);
        application.setAttribute("hottestReports",hottestReports);

    }
}
