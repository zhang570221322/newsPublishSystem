package util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * Created by zwl on 2017/9/10.
 * May god bless me
 */
public class GetSpringFactory   implements BeanFactoryAware{

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    private BeanFactory beanFactory;
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
      this.beanFactory=beanFactory;
    }
}
