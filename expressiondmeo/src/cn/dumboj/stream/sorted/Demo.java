package cn.dumboj.stream.sorted;

import cn.dumboj.stream.Person;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String [] args){
        List<Person> person = Person.getPerson();
        List<String> collect = person.stream().sorted(Comparator.comparing(Person::getSalary)).map(Person::getName).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);
    }
}
