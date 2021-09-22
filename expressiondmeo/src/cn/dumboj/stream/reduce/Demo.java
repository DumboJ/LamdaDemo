package cn.dumboj.stream.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * reduce：规约，也称缩减，将一个流缩减成一个值，可以实现对集合的求和，求乘积和求最值操作
 * */
public class Demo {
    public static void main(String[] args) {
        demo();
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
}
