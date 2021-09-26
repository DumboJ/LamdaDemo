package cn.dumboj.stream.reduce;

import cn.dumboj.stream.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * reduce：规约，也称缩减，将一个流缩减成一个值，可以实现对集合的求和，求乘积和求最值操作
 * */
public class Demo {
    public static void main(String[] args) {
        //元素之和，最值，乘积
        demo();

        //工资最大值，工资之和
        sum_maxSalary();
    }
    /**
     * 求Integer集合的元素之和、乘积和最大值
     * */
    public static void demo(){
        List<Integer> integers = Arrays.asList(11, 2, 6, 9, 7);
        /**
         * 求和方式1
         * */
        Optional<Integer> sum1 = integers.stream().reduce((x, y) -> x + y);
        /**
         * 求和方式2
         * */
        Optional<Integer> sum2 = integers.stream().reduce(Integer::sum);
        /**
         * 求和方式3
         * */
        Integer sum3 = integers.stream().reduce(0, Integer::sum);
        /**
         * 求乘积
         * */
        Optional<Integer> product = integers.stream().reduce((x, y) -> x * y);
        /**
         * 求最大值方式1
         * */
        Optional<Integer> max1 = integers.stream().reduce((x, y) -> x > y ? x : y);
        /**
         * 求最大值方式2
         * */
        Integer max2 = integers.stream().reduce(1, Integer::max);

        System.out.println("求和：" + sum1.get() + "--" + sum2.get() + "--" + sum3);
        System.out.println("求乘积：" + product.get());
        System.out.println("求最大值：" + max1.get() + "--" + max2 );
    }
    /**
     * 求所有员工的工资之和和最高工资
     * */
    public static void sum_maxSalary(){
        List<Person> person = Person.getPerson();
        /**
         * 求工资之和 方式一
         * */
        Optional<Integer> sumSalary = person.stream().map(Person::getSalary).reduce(Integer::sum);
        /**
         * 求工资之和 方式二
         * */
        Integer sumSalary2 = person.stream().reduce(0, (sum, p) -> sum += p.getSalary(), (sum1, sum2) -> sum1 + sum2);
        /**
         * 求工资之和 方式三
         * */
        Integer sumSalary3 = person.stream().reduce(0, (sum, p) -> sum += p.getSalary(), (Integer::sum));
        /**
         * 求最高工资 方式一
         * */
        Integer maxSalary = person.stream().reduce(0, (max, p) -> max > p.getSalary() ? max : p.getSalary(), Integer::max);
        /**
         * 求最高工资 方式二
         * */
        Integer maxSalary2 = person.stream().reduce(0, (max, p) -> max > p.getSalary() ? max : p.getSalary(), (max1, max2) -> max1 > max2 ? max1 : max2);

        System.out.println("工资之和：" + sumSalary.get() + "," + sumSalary2 + "," + sumSalary3);
        System.out.println("最高工资：" + maxSalary + "," + maxSalary2);
    }
}
