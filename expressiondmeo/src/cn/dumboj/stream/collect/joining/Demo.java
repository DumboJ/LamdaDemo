package cn.dumboj.stream.collect.joining;

import cn.dumboj.stream.Person;
import sun.util.resources.cldr.nd.CalendarData_nd_ZW;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Joining 将stream中元素使用特定连接符拼接，没有则直接连接
 * */
public class Demo {
    public static void main(String[] args) {
        List<Person> person = Person.getPerson();

        //使用，链接所有员工姓名
        String mans = person.stream().map(Person::getName).collect(Collectors.joining(","));
        System.out.println("公司所有员工："+mans);

        //拼接字符串
        List<String> strings = Arrays.asList("A", "B", "C", "D");
        String collect = strings.stream().collect(Collectors.joining("-"));
        System.out.println(collect);
    }
}
