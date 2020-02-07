package com.redis.demo.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 3450185709490973417L;
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
