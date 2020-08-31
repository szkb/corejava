package com.study.springboot.beanlifecycle.beanfactorypostprocessor;

import java.util.Map;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class PrematureBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, BBean> map = beanFactory.getBeansOfType(BBean.class);
//        for (BBean bBean : map.values()) {
//            assert bBean.getABean() == null;
//        }
    }
}

@Component("bBean")
class BBean {

    @Autowired
    private ABean aBean;

    public ABean getABean() {
        return aBean;
    }

}

@Component
class ABean {

    private String name = "a";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
