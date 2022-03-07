package cn.dumboj.stream.collect.toList_toMap_toSet;

import cn.dumboj.stream.Person;

import java.util.*;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        /**
         * 收集流处理后元素
         * 对集合数据对2取余为0的数值分别收集为list和set--set不可重复，6对应的只会存储一份
         * */
        List<Integer> list = Arrays.asList(1, 6, 3, 4, 6, 7, 9, 6, 20);
        List<Integer> collect = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        Set<Integer> set = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toSet());
        collect.stream().forEach(System.out::println);
        set.stream().forEach(System.out::print);

        //员工工资大于8000的姓名和对应属性map
        Map<String, Person> map = Person.getPerson().stream().filter(x -> x.getSalary() > 8000).collect(Collectors.toMap(Person::getName, p -> p));
        System.out.println(map);
    }
}
