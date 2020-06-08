package listener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import util.IndexContent;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Timer;

/**
 * Created by zwl on 2017/9/12.
 * May god bless me
 */
public class InitDataListener  implements ServletContextListener {
    private IndexContent indexContent = null; //定义一个ProductTimerTask对象
    private ApplicationContext context = null;

    @Override
    public void contextDestroyed(ServletContextEvent event) {

    }
    @Override
    public void contextInitialized(ServletContextEvent event) {
        context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
        indexContent = (IndexContent) context.getBean("indexContent");//从配置文件中获取ProductTimerTask对象
        //把内置对象交给productTimerTask,因为productTimerTask里面是拿不到application的，只能通过监听器set给它
        indexContent.setApplication(event.getServletContext());
        //通过设置定时器，让首页的数据每个一小时同步一次（配置为守护线程）
        new Timer(true).schedule(indexContent, 0, 1000*60*30);//每个一小时执行一次productTimerTask任务，即更新一下后台数据
    }
}
