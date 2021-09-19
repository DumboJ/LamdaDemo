package cn.dumboj.stream.max_min_count;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
/**
 * 获取String集合中最长的元素。
 * */
public class MaxStrDemo {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("dumbo", "dumboj", "dumboj.github.io", "Oops", "Oopsl");
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        System.out.println("集合中最长字符串是：" + max.get());
    }
}
