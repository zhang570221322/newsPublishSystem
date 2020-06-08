package dao;

import model.Info;
import model.Report;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zwl on 2017/9/6.
 * May god bless me
 */
@Repository
public interface BaseMapper<T> {
    /**
     * 添加单一对象接口
     * @param t
     * @return
     */
    int  insert(T t);

    /**
     * 修改单一对象接口
     * @param t
     * @return
     */
    int  update(T t);


    /**
     * 统一修改多对象接口
     * @param info
     *  cloumnName 列名
     *  cloumnValue 列值
     *  likeOrin 底层关键字
     *  t 修改模板
     * @return
     */
     int   update2(Info<T> info);
    /**
     * 得到单一对象接口
     * @param t
     * @return
     */
     T get(T t);

    /**
     * 统一删除多对象接口
     * @param ids
     * @return
     */
     int delete(@Param("ids")String ids);

    /**
     * 得到多对象接口
     * @param info
     *  cloumnName 列名
     *  cloumnValue 列值
     *  likeOrin 底层关键字
     * @return
     */
     List<T> list(Info<T> info);

    /**
     * 得到有多少行
     * @return
     */
    int getCount(@Param("whereCondition")String whereCondition);


}
