package cn.dumboj.stream.FunctionImport;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 方法引用stream元素新生成对象
 * */
public class FuncImpot {
    public static void main(String[] args) {
        //例子不太恰当，凑合用吧
        //TODO eta使用案例
        List<String> strings = Arrays.asList("ab", "", "rr", "mm", "", "dd");
        List<Boolean> collect = strings.stream().map(x ->  x.isEmpty()).map(Boolean::new).collect(Collectors.toList());
        System.out.println(collect);
    }
}
