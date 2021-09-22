package cn.dumboj.stream.map_flatmap;

import cn.dumboj.stream.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapDemo {
    public static void main(String[] args) {
        demo1();

        increaseSalary();
    }
    /**
     * 英文字符串数组的元素全部改为大写。整数数组每个元素+3
     * */
    public static void demo1(){
        String[] strArr = { "abcd", "bcdd", "defde", "fTr" };
        final List<String> strToupper = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());

        List<Integer> integers = Arrays.asList(77, 8, 45, 12, 11);
        final List<Integer> addIntegers = integers.stream().map(x -> x + 3).collect(Collectors.toList());

        System.out.println("都转为大写的字符串是：" + strToupper);
        System.out.println("都加3的数值是：" + addIntegers);
    }

    /**
     *将员工的薪资全部增加1000
     * */
    public static void  increaseSalary(){
        List<Person> personList = Person.getPerson();

        /**
         * 改变原来员工集合的方式--新旧集合中的工资都改动
         * */
        List<Person> personNewList = personList.stream().map(personT -> {
            personT.setSalary(personT.getSalary() + 1000);
            return personT;
        }).collect(Collectors.toList());
        System.out.println("改变原集合改动前：" + personList.get(0).getName() + "--" + personList.get(0).getSalary());
        System.out.println("改变原集合改动后：" + personNewList.get(0).getName() + "--" + personNewList.get(0).getSalary());

        /**
         * 不改变原来员工集合的方式--旧集合中的工资未改动
         * */
        List<Person> personNewList2 = personList.stream().map(person -> {
            Person personNew = new Person(person.getName(), 0, 0, null, null);
            personNew.setSalary(person.getSalary() + 1000);
            return personNew;
        }).collect(Collectors.toList());

        System.out.println("不改变原集合改动前：" + personList.get(0).getName() + "--" + personList.get(0).getSalary());
        System.out.println("不改变原集合改动后：" + personNewList2.get(0).getName() + "--" + personNewList2.get(0).getSalary());
    }
}
