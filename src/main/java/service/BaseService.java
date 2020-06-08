package service;



import java.util.List;

/**
 * Created by zwl on 2017/9/8.
 * May god bless me
 * 管理员逻辑
 */
public interface BaseService<T> {
    /**
     * 修改单一对象 ，须有主键
     * @param  t
     * @return
     */
    int alterT(T t);
    /**
     * 	管理员增加t
     * @param t
     * @return
     */
    int addT(T t);

    /**
     * 得到所有行
     * @return
     */
    int getAllTNumber(String where);
    int getAllTNumber();
    /**
     * 4.2 有条件查询
     * @param pageNum
     * @param pageSize
     * @param where
     * @return
     */
    List<T> getAllT(int pageNum, int pageSize, String where);

    /**
     *  管理员查询
     * 查询所有
     * @return
     */
    List<T> getAllT(int pageNum, int pageSize);

    /**
     *  管理员删除
     * @param ids 根据多个id删除 (1,2,3 ) 必须为这样的形式
     * @return
     */
    int removeT(String ids);

}
