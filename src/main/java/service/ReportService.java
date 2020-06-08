package service;

 ;
import model.Report;

 import java.util.Map;

/**
 * Created by zwl on 2017/9/10.
 * May god bless me
 */
public interface ReportService extends BaseService<Report> {
     Report getById(int id);
}
