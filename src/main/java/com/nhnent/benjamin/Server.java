package com.nhnent.benjamin;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by benjamin on 2017. 1. 15..
 */
public class Server {

    private static final String CONTEXT_PATH = "applicationContext.xml";

    public static void main(String args[]) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(CONTEXT_PATH);
        String dbName = context.getBean(String.class);

        System.out.println("DBNAME : " + dbName);

        context.close();
    }
}
