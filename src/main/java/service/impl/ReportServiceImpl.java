package service.impl;

import com.sun.org.apache.regexp.internal.RE;
import dao.ReportMapper;
import model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ReportService;

import java.util.List;

/**
 * Created by zwl on 2017/9/10.
 * May god bless me
 */
@Service
public class ReportServiceImpl extends BaseServiceImpl<Report> implements ReportService  {

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public void afterPropertiesSet() throws Exception {
         setBaseMapper(reportMapper);
    }

    @Override
    public  Report getById( int id) {
        Report r=new Report();
        r.setId(id);
        return  reportMapper.get(r);
    }
}
