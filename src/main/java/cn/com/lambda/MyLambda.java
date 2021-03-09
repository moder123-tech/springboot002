package cn.com.lambda;

import cn.com.bean.Dog;
import cn.com.bean.Employee;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author wx
 * @version 1.0
 * @date 2021/1/24 13:36
 */
public class MyLambda {

    public static void main(String[] args) {
        List<Dog> list= Arrays.asList(
                new Dog("xiaoming",20),
                new Dog("xiaohong",10),
                new Dog("wanggang",30)
        );
        List<Employee> list1 = Arrays.asList(
                new Employee(101,"张三",18,9999.99),
                new Employee(102,"李四",59,6666.66),
                new Employee(103,"王五",18,3333.33),
                new Employee(104,"赵六",8,7777.77),
                new Employee(105,"田七",38,5555.55)
        );
        list.stream()
                .limit(2)
                .filter((e) ->e.getAge()>20)
                .forEach(System.out::println);
        System.out.println("---------------");
        list.stream()
                .map(Dog::getName)
                .forEach(System.out::println);
        System.out.println("---------------");
        Comparator<Integer> comparator = (x,y) -> Integer.compare(x, y);
        System.out.println("---------------");
        Collections.sort(list1, (e1,e2) -> {
            if(e1.getEmployeeAge()==e2.getEmployeeAge()){
                return e2.getEmployeeSalary().compareTo(e1.getEmployeeSalary());
            }else{
                return Integer.compare(e1.getEmployeeAge(), e2.getEmployeeAge());
            }
        });
        for(Employee employee:list1){
            System.out.println(employee);
        }
        System.out.println("---------------");
        test1(10000,(m) -> System.out.println("123456"));
        System.out.println("---------------");
        List<Integer> numList = getNumList(10, () -> (int) (Math.random()*100));
        System.out.println(numList);
        BiPredicate<String,String> biPredicate= String::equals;
        boolean test = biPredicate.test("123", "123");
        System.out.println(test);
    }


    public static void  test1(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }

    public static List<Integer> getNumList(int num, Supplier<Integer> sup){
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer integer = sup.get();
            list.add(integer);
        }
        return list;
    }
}

