package service.impl;

import com.github.pagehelper.PageHelper;
import dao.BaseMapper;
import model.Info;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import service.BaseService;
import java.util.List;
import java.util.Objects;

/**
 * Created by zwl on 2017/9/10.
 * May god bless me
 */
@Service
@Lazy(true)
public class BaseServiceImpl<T> implements BaseService<T>  , InitializingBean {
    protected BaseMapper<T> baseMapper;
    /**
     * 修改单一对象 ，须有主键
     *
     * @param t
     * @return
     */
    @Override
    public int alterT(T t) {
    return  baseMapper.update(t);
    }

    /**
     * 管理员增加t
     *
     * @param t
     * @return
     */
    @Override
    public int addT(T t) {
        return baseMapper.insert(t);
    }

    /**
     * 得到所有行
     *
     * @return
     */
    @Override
    public int getAllTNumber(String where) {
        if (Objects.isNull(where)||where==""){
            where =" 1 =1 ";
        }
        return baseMapper.getCount(where);
    }
    @Override
    public int getAllTNumber() {
        return baseMapper.getCount(" 1 =1 ");
    }

    /**
     * 4.2 有条件查询
     *
     * @param pageNum
     * @param pageSize
     * @param where
     * @return
     */
    @Override
    public List<T> getAllT(int pageNum, int pageSize, String where) {
        Info<T> info=new Info<>();
        if (Objects.isNull(where)||where==""){
            info.setWhereCondition("1=1");
        }else{
            info.setWhereCondition(where);
        }

        PageHelper.startPage(pageNum, pageSize);
        return  baseMapper.list(info);
    }

    /**
     * 管理员查询
     * 查询所有
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<T> getAllT(int pageNum, int pageSize) {
        Info<T> info=new Info<>();
            info.setWhereCondition("1=1");
        PageHelper.startPage(pageNum, pageSize);
        return  baseMapper.list(info);
    }

    /**
     * 管理员删除
     *
     * @param ids 根据多个id删除 (1,2,3 ) 必须为这样的形式
     * @return
     */
    @Override
    public int removeT(String ids) {
        ids="("+ids+")";
        return  baseMapper.delete(ids);
    }

    public BaseMapper<T> getBaseMapper() {
        return baseMapper;
    }

    public void setBaseMapper(BaseMapper<T> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
