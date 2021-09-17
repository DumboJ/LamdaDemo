package cn.dumboj.stream.init;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @deprecated 初始化Java Stream的方式
 * */
public class Demo {
    public static void main(String[] args) {
        getArrayStream();
        getSteamStatic();
    }
    /**
     * 方式一：用集合创建流 java.util.Collection。stream()
     *
     * stram()流和 parallelStream() 流区分：
     *          stram()  主线程安按顺序对流执行操作
     *          parallelStream() 以多线程方式对流操作
     *   使用注意：对流操作是否有顺序要求
     * */
    private static void getStreamColl(){
        final Collection<String> list = Arrays.asList("a", "b", "c");
        /**
         * 创建一个顺序流
         * */
        Stream<String> stream = list.stream();
        /**
         * 创建一个并行流
         * */
        Stream<String> stringStream = list.parallelStream();
    }
    /**
     * 方式二：用数组创建流  java.util.Arrays.stream(T array)
     * */
    private static void getArrayStream(){
        int[] arrays = {1,2,3,4};
        IntStream stream = Arrays.stream(arrays);
        stream.forEach(System.out::println);
    }
    /**
     * 方式三：使用Stream的静态方法  Stream.of()/Stream.iterate()/Stream.generate()
     * */
    private static void getSteamStatic(){
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);

        Stream<Integer> iterateStream = Stream.iterate(0, (x) -> x+3).limit(2);
        iterateStream.forEach(System.out::println);

        Stream<Double> genStream = Stream.generate(Math::random).limit(3);
        genStream.forEach(System.out::println);
    }
}
