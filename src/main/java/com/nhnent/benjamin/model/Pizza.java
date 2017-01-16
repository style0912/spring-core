package com.nhnent.benjamin.model;

/**
 * Created by benjamin on 2017. 1. 16..
 */
public class Pizza {

    private String name;

    public Pizza() {
        name = "normal pizza";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pizza{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
