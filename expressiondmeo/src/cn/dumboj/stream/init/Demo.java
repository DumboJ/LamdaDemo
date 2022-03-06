package cn.dumboj.stream.init;

import java.util.Arrays;
import java.util.Collection;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *  初始化Java Stream的方式
 * */
public class Demo {
    public static void main(String[] args) {
       /* getArrayStream();
        getSteamStatic();*/
        parallel();
    }
    /**
     * 方式一：用集合创建流 java.util.Collection。stream()
     *
     * stream()流和 parallelStream() 流区分：
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
        Stream<String>  parallelStream = list.parallelStream();
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
    /**
     *顺序流变为并行流
     * */
    public static void parallel(){
        int[] array = {3, 56, 7, 4, 22, 1, 7, 4};
        IntStream stream = Arrays.stream(array);
        OptionalInt any = stream.parallel().filter(x -> x > 6).findFirst();
        any.ifPresent(System.out::println);
    }
}
