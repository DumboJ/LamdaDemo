package cn.dumboj.stream.collect.partitioningBy_groupingBy;

import cn.dumboj.stream.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 分区和分组
 * 分区：按条件将stream分为两个Map,
 * 分组：将集合分为多个map
 * */
public class Demo {
    public static void main(String[] args) {
        List<Person> person = Person.getPerson();
        // 将员工按薪资是否高于8000分组
        Map<Boolean, List<Person>> collect = person.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 8000));

        // 将员工按性别分组
        Map<String, List<Person>> collect1 = person.stream().collect(Collectors.groupingBy(Person::getSex));

        // 将员工先按性别分组，再按地区分组
        Map<String, Map<String, List<Person>>> collect2 = person.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));

        System.out.println("员工薪资是否高于八千分组：" + collect);
        System.out.println("员工性别分组：" + collect1);
        System.out.println("员工性别、地区分组：" + collect2);
    }
}
