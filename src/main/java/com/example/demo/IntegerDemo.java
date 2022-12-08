package com.example.demo;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntegerDemo {
    public static void main(String[] args)throws IOException {
        test2();
    }



    static void test2(){
        Random random = new Random();
        DoubleStream doubleStream = random.doubles();
        doubleStream.limit(10).forEach(System.out::println);

        random.ints(0,10).limit(10).forEach(System.out::println);
        IntStream intStream = random.ints(0, 100);
        List<Integer> randomBetween0And99 = intStream
                .limit(100)
                .boxed()
                .collect(Collectors.toList());
        randomBetween0And99.forEach(System.out::println);

        Stream.generate(random::nextGaussian).limit(10).mapToDouble(e->e).forEach(System.out::println);
    }

    static void test(){
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        long max = (1l<<32) -1;
        System.out.println(max);
        String s = String.valueOf(max);
        System.out.println(s);
        int i = Integer.parseUnsignedInt(s,10);
        System.out.println(i);
        String s2 = Integer.toUnsignedString(i,10);
        System.out.println(s2);
    }

    static void test1(){
        long l = 1<<2;
        System.out.println(l);
        long l1 = 6>>1;
        System.out.println(l1);
    }


}
