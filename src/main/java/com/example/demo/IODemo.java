package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IODemo {

    public static void main(String[] args) throws Exception {
        test6();
    }

    static void test6()throws IOException{
        Path path = Paths.get("src\\main\\java\\com\\example\\demo\\AbstractQueuedSynchronizerDemo.java");

        try(BufferedReader bufferedReader = Files.newBufferedReader(path)){
            System.out.println(bufferedReader.readLine());
        }
    }
    static void test5()throws IOException{
        List<String> strings = Files.readAllLines(Paths.get("src\\main\\java\\com\\example\\demo\\AbstractQueuedSynchronizerDemo.java"));
        strings.add("大失败");
        Files.write(Paths.get("test.txt"),strings);
    }

    static void test2() throws IOException {
        try (Stream<Path> stream = Files.list(Paths.get(""))){
            String joined = stream
                    .map(String::valueOf)
                    .filter(p->p.startsWith("."))
                    .sorted()
                    .collect(Collectors.joining(";"));
            System.out.println(joined);
        }
    }

    static void test3()throws IOException{
        Path start = Paths.get("");
        int maxDepth=10;
        try(Stream<Path> stream = Files.find(start,maxDepth,(path,s) -> String.valueOf(path).endsWith(".java"))){
            String joined = stream
                    .sorted()
                    .map(String::valueOf)
                    .collect(Collectors.joining(";"));
            System.out.println(joined);
        }
    }

    static void test4()throws IOException{
        Path start = Paths.get("");
        int maxDepth=10;
        try(Stream<Path> stream = Files.walk(start,maxDepth)){
            String joined = stream
                    .sorted()
                    .map(String::valueOf)
                    .filter(p->p.endsWith(".java"))
                    .collect(Collectors.joining(";"));
            System.out.println(joined);
        }
    }
}
