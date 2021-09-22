package cn.dumboj.stream.map_flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * flatMap:接收一个函数作为参数，将流中的每个值都换成另外一个流，然后把所有流连接成一个流
 * */
public class FlatMapDemo {
    public static void main(String[] args) {
        merge2StrList();
    }
    /**
     * 将两个字符数组合并成一个新的字符数组
     * */
    public static void merge2StrList(){
        List<String> srcList = Arrays.asList("o,o,p,s", "21,11,51,42");
        List<String> desList = srcList.stream().flatMap(s -> {
            //将集合的每个元素转化成一个stream流
            String[] split = s.split(",");
            Stream<String> stream = Arrays.stream(split);
            return stream;
        }).collect(Collectors.toList());

        System.out.println("转换前的集合：" + srcList.get(0));
        System.out.println("转换后的集合：" + desList.get(0));
    }
}
