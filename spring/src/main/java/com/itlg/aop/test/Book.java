package com.itlg.aop.test;

import lombok.Data;
import lombok.Setter;

@Data
public class Book {
    String name;
    Integer order;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
