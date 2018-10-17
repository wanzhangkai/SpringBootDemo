package com.pipikai.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
public class TestObject implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @Min(value = 5, message = "too young")
    @Max(value = 30, message = "too old")
    private Integer age;

    private String cupSize;

    @NotNull(message = "money need")
    private Double money;

    public TestObject() {
    }

    @Override
    public String toString() {
        return "TestObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", cupSize='" + cupSize + '\'' +
                ", money=" + money +
                '}';
    }

}
