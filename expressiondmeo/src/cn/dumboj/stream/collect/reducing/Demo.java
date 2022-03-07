package cn.dumboj.stream.collect.reducing;

import cn.dumboj.stream.Person;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Collectors类提供的reducing方法，相比于stream本身的reduce方法，增加了对自定义归约的支持
 * */
public class Demo {
    public static void main(String[] args) {
        /**
         * 计算员工扣税后薪资总和
         * */

        List<Person> person = Person.getPerson();
        // 每个员工减去起征点后的薪资之和---Collectors.reducing()方式
        Integer sumWithout = person.stream().collect(Collectors.reducing(0,Person::getSalary, (x, y) -> (x + y - 5000)));
        System.out.println("员工扣税后薪资总和"+sumWithout);

        //使用stream的reduce方式
        Optional<Integer> sumSalary = person.stream().map(Person::getSalary).reduce(Integer::sum);
        System.out.println("员工薪资总和" + sumSalary.get());
    }
}
