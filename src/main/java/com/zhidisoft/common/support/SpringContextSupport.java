package com.zhidisoft.common.support;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.zhidisoft.exception.UserStatusException;

/**
 * SpringContext的持有者，可以通过该类访问Spring IoC容器中的JavaBean实例
 * @author Lu Jianliang
 *
 */
@Component
public class SpringContextSupport implements ApplicationContextAware{
	
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextSupport.applicationContext = applicationContext;
	}
	
	public static ApplicationContext getApplicationContext() {
        assertApplicationContext();
        return applicationContext;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName) {
        assertApplicationContext();
        return (T) applicationContext.getBean(beanName);
    }

    public static <T> T getBean(Class<T> requiredType) {
        assertApplicationContext();
        return applicationContext.getBean(requiredType);
    }

    private static void assertApplicationContext() {
        if (SpringContextSupport.applicationContext == null) {
            throw new UserStatusException("applicaitonContext属性为null,请检查是否注入了SpringContextHolder!");
        }
    }
}
