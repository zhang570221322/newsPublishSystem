package controller;

import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.BaseService;
import service.CategoryService;

import java.util.Map;

/**
 * Created by zwl on 2017/9/11.
 * May god bless me
 */
@Controller
public class CategoryController extends  BaseController<Category> {
    @Autowired
    private CategoryService categoryService;

    @Override
    public void afterPropertiesSet() throws Exception {
        setBaseService(categoryService);
    }

    /**
     * 添加 t
     *
     * @param category
     * @return
     */
    @Override
    @RequestMapping(value = "/POST/category2",method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> addT2(Category category) {
        return super.addT2(category);
    }

    /**
     * 分页查询
     *
     * @param pageNum
     * @param pageSize
     * @param where
     * @return
     */
    @Override
    @RequestMapping(value = "/GET/categorys",method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody  Map<String, Object> getAllT(@RequestParam(value = "page",required = false) int pageNum,
                                       @RequestParam(value = "rows",required = false) int pageSize,
                                       @RequestParam(value = "where",required = false) String where) {
        return super.getAllT(pageNum, pageSize, where);
    }

    /**
     * url 删除
     *
     * @param ids
     * @return
     */
    @Override
    @RequestMapping(value = "/DELETE/category/{ids}")
    public  @ResponseBody  Map<String, Object> removeT1(@PathVariable("ids") String ids) {
        return super.removeT1(ids);
    }

    /**
     * ajax删除
     * @param ids
     * @return
     */
    @Override
    @RequestMapping(value = "/DELETE/categorys")
    public  @ResponseBody  Map<String, Object> removeT2(@RequestParam( "ids") String ids) {
        return super.removeT2(ids);
    }

    @Override
    @RequestMapping(value = "/PUT/category")
    public @ResponseBody   Map<String, Object> updateT(Category category) {
        return super.updateT(category);
    }
}
