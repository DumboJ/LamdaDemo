package cn.dumboj.stream.pickup_makeup;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 提取去重部分：dinstinct,skip,limit
 * */
public class Demo {
    public static void main(String[] args) {
        String[] arr1 = {"a", "b", "c", "d"};
        String[] arr2 = {"d", "e", "f", "g"};
        Stream<String> stream1 = Stream.of(arr1);
        Stream<String> stream2 = Stream.of(arr2);
       // concat:合并两个流 distinct：去重
        List<String> collect = Stream.concat(stream1, stream2).distinct().collect(Collectors.toList());
        System.out.println("合并去重后：" + collect);

        // limit：限制从流中获得前n个数据
        List<Integer> limit  = Stream.iterate(1, x -> x + 6).limit(3).collect(Collectors.toList());
        System.out.println("限制从流中获取前三个数据" + limit);

        // skip：跳过前n个数据
        List<Integer> skip = Stream.iterate(1, x -> x + 3).limit(6).skip(2).collect(Collectors.toList());
        System.out.println("跳过前两个数后:" + skip);
    }
}
