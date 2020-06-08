package service.impl;

import dao.CategoryMapper;
import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CategoryService;


/**
 * Created by zwl on 2017/9/10.
 * May god bless me
 */
@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void afterPropertiesSet() throws Exception {
          setBaseMapper(categoryMapper);
    }
}
