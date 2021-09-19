package cn.dumboj.stream.filter;


import cn.dumboj.stream.Person;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 筛选工资高于8000的人，并形成新的集合。形成新集合依赖collect
 * */
public class FilterAndColl {
    public static void main(String[] args) {

        List<Person> persons = Person.getPerson();
        List<String> collect = persons.stream().filter(x -> x.getSalary() > 7500).map(Person::getName).collect(Collectors.toList());
        System.out.print("高于8000的员工姓名：" + collect);
    }
}
