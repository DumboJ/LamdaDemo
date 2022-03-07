package cn.dumboj.stream.collect.count_averaging;

import cn.dumboj.stream.Person;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
        /**Collectors提供数据统计的静态方法
        计数：count
        平均值：averagingInt、averagingLong、averagingDouble
        最值：maxBy、minBy
        求和：summingInt、summingLong、summingDouble
        统计以上所有：summarizingInt、summarizingLong、summarizingDouble*/

public class Demo {
    //案例：统计员工人数、平均工资、工资总额、最高工资。
    public static void main(String[] args) {
        List<Person> person = Person.getPerson();
        //// 求总数
        Long count = person.stream().collect(Collectors.counting());
        //求平均工资
        Double averageSalary = person.stream().collect(Collectors.averagingDouble(Person::getSalary));
        //求最高工资
        Optional<Integer> maxSalary = person.stream().map(Person::getSalary).collect(Collectors.maxBy(Integer::compare));
        // 求工资之和
        Integer sum = person.stream().collect(Collectors.summingInt(Person::getSalary));
        // 一次性统计所有信息
        DoubleSummaryStatistics summarizingSalary = person.stream().collect(Collectors.summarizingDouble(Person::getSalary));
        System.out.println("员工总数："+count);
        System.out.println("平均工资："+averageSalary);
        System.out.println("最高工资："+maxSalary.get());
        System.out.println("员工工资之和："+sum);
        System.out.println("一次性统计员工工资之和："+summarizingSalary);
    }
}
