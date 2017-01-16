package com.nhnent.benjamin.service;

import com.nhnent.benjamin.model.Pizza;

/**
 * Created by benjamin on 2017. 1. 16..
 */
public class PizzaService {

    private static PizzaService instance;

    public static PizzaService getInstance() {
        if (instance == null) {
            synchronized (PizzaService.class) {
                if (instance == null)
                    instance = new PizzaService();
            }
        }

        return instance;
    }

    private PizzaService() {
    }

    public Pizza makePizza() {
        return new Pizza();
    }
}
