package cn.com;

import cn.com.bean.Dog;
import cn.com.bean.Employee;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.*;

public class LogTest {

    public static void main(String[] args) {

        Dog dog = new Dog("xiaoming", 2);
        Object obj = JSONArray.toJSON(dog);
        String json = obj.toString();
        System.out.println("将Person对象转成json:" + json);
        System.out.println("------------------------------");
        List<Employee> list1 = Arrays.asList(
                new Employee(101,"张三",18,9999.99),
                new Employee(102,"101李四",59,6666.66),
                new Employee(103,"王五",18,3333.33),
                new Employee(104,"赵六",8,7777.77),
                new Employee(105,"田七",38,5555.55),
                new Employee(106,"周八",8,7777.77),
                new Employee(107,"陈九",8,7777.77)
        );
        list1.stream()
                .filter((e)->e.getEmployeeAge()>10)
                .limit(2)
                .forEach(System.out::println);
        System.out.println("------------------------------");
        list1.stream()
                .map(Employee::getEmployeeName)
                .forEach(System.out::println);
        System.out.println("------------------------------");
       list1.stream()
               .sorted((e1,e2)->{
                   if (e1.getEmployeeAge().equals(e2.getEmployeeAge())) {
                       return e1.getEmployeeId().compareTo(e2.getEmployeeId());
                   }else{
                       return e1.getEmployeeAge().compareTo(e2.getEmployeeAge());
                   }
               }).forEach(System.out::println);
    }
}