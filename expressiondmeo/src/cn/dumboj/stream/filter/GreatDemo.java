package cn.dumboj.stream.filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 筛选出Integer集合中大于7的元素，并打印出来
 * */
public class GreatDemo {
    public static void main(String[] args) {
        final List<Integer> list = Arrays.asList(8, 3, 7, 6, 5, 74, 21);
        Stream<Integer> stream = list.stream();
        stream.filter(x-> x<=7).forEach(System.out::println)    ;
    }
}
