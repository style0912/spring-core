package com.nhnent.benjamin;

import com.nhnent.benjamin.model.Pizza;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;

/**
 * Created by benjamin on 2017. 1. 15..
 */
public class Server {
    private static final Logger LOGGER = LoggerFactory.getLogger(Server.class);

    public static void main(String args[]) {
        StaticApplicationContext context = new StaticApplicationContext();
        context.registerBeanDefinition("pizzaBean", new RootBeanDefinition(Pizza.class));

        Pizza pizzaBean = (Pizza) context.getBean("pizzaBean");
        System.out.println(pizzaBean.toString());
    }
}
