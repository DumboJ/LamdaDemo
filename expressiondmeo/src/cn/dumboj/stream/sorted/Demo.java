package cn.dumboj.stream.sorted;

import cn.dumboj.stream.Person;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
/**
 * 排序方式：sorted() 自然排序，stream中元素需要实现Comparable接口
 * */
public class Demo {
    public static void main(String [] args){
//        将员工按工资由高到低（工资一样则按年龄由大到小）排序
        List<Person> person = Person.getPerson();

        //按员工工资升序排序
        List<String> sort = person.stream().sorted(Comparator.comparing(Person::getSalary)).map(Person::getName).collect(Collectors.toList());
        //按员工工资降序排序
        List<String> reversedSort = person.stream().sorted(Comparator.comparing(Person::getSalary).reversed()).map(Person::getName).collect(Collectors.toList());
        System.out.println("升序排序"+sort);
        System.out.println("降序排序"+reversedSort);

        //先按工资再按年龄升序排序
        List<String> salaryThenAge = person.stream().sorted(Comparator.comparing(Person::getSalary).thenComparing(Person::getAge)).map(Person::getName).collect(Collectors.toList());
        System.out.println("先按工资再按年龄升序排序" + salaryThenAge);

        //先按薪资再按年龄自定义降序排序
        List<String> collect = person.stream().sorted((a, b) -> {
            if (a.getSalary() == b.getSalary()) {
                return b.getAge() - a.getAge();
            } else {
                return b.getSalary() - a.getSalary();
            }
        }).map(Person::getName).collect(Collectors.toList());
        System.out.println("自定义先按薪资后按年龄排序" + collect);
    }
}
