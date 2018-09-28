package com.pipikai.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Test {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @Min(value = 10, message = "too young")
    private Integer age;
    
    private String cupSize;

    @NotNull(message = "money need")
    private Double money;

    public Test() {
    }

}
