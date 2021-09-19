package cn.dumboj.stream.max_min_count;

import cn.dumboj.stream.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * 获取Integer集合中的最大值
 */
public class MaxIntegerDemo {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(11, 89, 110, 154, 47, 44);
        /**
         * 自然排序
         * */
        Optional<Integer> max = integers.stream().max(Integer::compareTo);
        /**
         * 自定义排序
         * */
        Optional<Integer> max1 = integers.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("自然排序的最大值：" + max.get());
        System.out.println("自定义排序的最大值：" + max1.get());

        /**
         * 获取员工工资最高的人
         * */
        List<Person> person = Person.getPerson();
        Optional<Person> maxSalary = person.stream().min(Comparator.comparingInt(Person::getSalary));
        System.out.println("员工工资最低的人：" + maxSalary.get().getSalary() + "--职员：" + maxSalary.get().getName());
    }
}
