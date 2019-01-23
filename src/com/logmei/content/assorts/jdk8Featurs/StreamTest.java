package com.logmei.content.assorts.jdk8Featurs;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 有多种方式生成 Stream Source：
 *
 * 从 Collection 和数组
 * Collection.stream()
 * Collection.parallelStream()
 * Arrays.stream(T array) or Stream.of()
 * 从 BufferedReader
 * java.io.BufferedReader.lines()
 * 静态工厂
 * java.util.stream.IntStream.range()
 * java.nio.file.Files.walk()
 * 自己构建
 * java.util.Spliterator
 * 其它
 * Random.ints()
 * BitSet.stream()
 * Pattern.splitAsStream(java.lang.CharSequence)
 * JarFile.stream()
 */
public class StreamTest {
    public static void main(String[] args){
        //构造Stream的几种方式
        Stream stream = Stream.of("sss","aa","bb");
        //2、数组形式
        String[] array = new String[] {"a","b","c"};
        stream = Stream.of(array);
        stream = Arrays.stream(array);
        //3、collections
        List<String> list = Arrays.asList(array);
        stream = Stream.of(list);


        /**
         * 数值流的构造
         */
        System.out.println("IntStream");
        IntStream.of(new int[]{2,4,7,9,3,5}).filter(i->i>4).sorted().forEach(System.out::print);
        System.out.println();
        IntStream.range(3,6).forEach(System.out::print);
        System.out.println();
        IntStream.rangeClosed(3,6).forEach(System.out::print);

        /**
         * 流转换为其他数据结构
         */
        System.out.println("Array");
        Stream stream1 = Stream.of("22","44","111");
        String strArray = stream1.collect(Collectors.joining()).toString();
        System.out.println(strArray);
        //List<String> list1 = (List<String>)stream.collect(Collectors.toCollection(ArrayList::new));


        String[] wordString = new String[]{"sd","qwe","aasdf","erer"};
        Stream wordStream = Stream.of(wordString);



    }
}
