package cn.dumboj.stream.max_min_count;

import java.util.Arrays;
import java.util.List;

/**
 * 计算Integer集合中大于6的元素的个数
 * */
public class CountDemo {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(8, 4, 22, 7, 6, 2);

        long count = integers.stream().filter(x -> x > 6).count();
        System.out.println("list中大于6的元素个数为：" + count);
    }
}
