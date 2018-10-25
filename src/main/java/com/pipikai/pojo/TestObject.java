package com.pipikai.pojo;

public class TestObject {
    private Integer id;

    private Integer age;

    private String cupSize;

    private Double money;

    private String name;

    public TestObject(Integer id, Integer age, String cupSize, Double money, String name) {
        this.id = id;
        this.age = age;
        this.cupSize = cupSize;
        this.money = money;
        this.name = name;
    }

    public TestObject() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize == null ? null : cupSize.trim();
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}