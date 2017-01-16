package com.nhnent.benjamin;

import com.nhnent.benjamin.model.Pizza;
import com.nhnent.benjamin.service.PizzaService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by benjamin on 2017. 1. 15..
 */
public class Server {

    private static final String CONTEXT_PATH = "applicationContext.xml";

    public static void main(String args[]) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(CONTEXT_PATH);

        PizzaService pizzaService = (PizzaService) context.getBean("pizzaService");
        Pizza pizza = pizzaService.makePizza();

        System.out.println(pizza.toString() + ", " + pizza.hashCode());

        Pizza pepperoniPizza = context.getBean("pepperoniPizza", Pizza.class);
        System.out.println(pepperoniPizza.toString() + ", " + pepperoniPizza.hashCode());
        context.close();
    }
}
