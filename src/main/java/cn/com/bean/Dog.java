package cn.com.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wx
 * @version 1.0
 * @date 2021/1/1 14:00
 */
@Data
public class Dog implements Serializable {

    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Dog() {
    }



    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
