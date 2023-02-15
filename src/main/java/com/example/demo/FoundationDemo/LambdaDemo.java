package com.example.demo.FoundationDemo;

import lombok.Data;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaDemo {

    public static void main(String[] args) {
        LambdaDemo lambdaDemo = new LambdaDemo();
        lambdaDemo.test9();
    }

    void  test9(){
        String bar = Pattern.compile(":")
                .splitAsStream("foobar:foo:bar")
                .filter(s -> s.contains("bar"))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(":"));
        System.out.println(bar);
        Pattern pattern = Pattern.compile(".*@gmail\\.com");
        List<String> collect = Stream.of("bob@gmail.com", "alice@hotmail.com")
                .filter(pattern.asPredicate())
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    void test8(){
        String s = "foobar:foo:bar"
                .chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char ) c))
                .sorted()
                .collect(Collectors.joining());
        System.out.println(s);
    }
    void test7(){
       List<Person> personList = Arrays.asList(
               new Person(306, 10,"DAI"),new Person(302, 103,"Dai"),new Person(303, 130,"zhong"),
                new Person(304, 410,"dai"),new Person(305, 150,"ji"),new Person(306, 105,"dai"),
                new Person(307, 170,"cao"),new Person(308, 107,"gu"),new Person(309, 170,"hu"));
       personList.stream().sorted(Comparator.comparing(Person::getName,String.CASE_INSENSITIVE_ORDER)
               .thenComparing(Person::getId, Comparator.naturalOrder())
               .thenComparingInt(Person::getAge)
       ).forEach(System.out::println);

       personList.stream().sorted(Comparator.comparing(Person::getId,Comparator.reverseOrder())).forEach(p-> System.out.println(p.getId()));
    }

    void test6(){
        List<JavaProgrammer> javaProgrammers = new ArrayList();
        javaProgrammers.add(new JavaProgrammer(23,"ma","female",12000));
        javaProgrammers.add(new JavaProgrammer(25,"li","female",14000));
        javaProgrammers.add(new JavaProgrammer(33,"zheng","male",11000));
        javaProgrammers.add(new JavaProgrammer(26,"feng","male",54000));
        javaProgrammers.add(new JavaProgrammer(28,"guo","female",72000));
        javaProgrammers.add(new JavaProgrammer(63,"mei","female",1200));
        javaProgrammers.add(new JavaProgrammer(21,"yuan","female",12000));

        javaProgrammers.stream()
                .filter(p->p.getAge()>25)
                .filter(p->p.getGender().equals("female"))
                .sorted((p2,p)->(p.getFirstName().compareTo(p2.getFirstName())))
                .limit(3)
                .forEach(p-> System.out.println(p.getFirstName()));
        JavaProgrammer javaProgrammer = javaProgrammers.stream()
                .max(Comparator.comparingInt(JavaProgrammer::getSalary))
                .get();
        System.out.println("max salary:"+javaProgrammer.getFirstName());

        TreeSet<String> collect = javaProgrammers.stream()
                .map(JavaProgrammer::getFirstName)
                .collect(Collectors.toCollection(TreeSet::new));
        for (String s : collect) {
            System.out.println(s);
        }

        int sum = javaProgrammers.parallelStream().mapToInt(p -> p.getSalary()).sum();
    }

    void test5(){
        List<Person> list= new ArrayList<>();
        list.add(new Person(4,"p4"));
        list.add(new Person(8,"p8"));
        list.add(new Person(6,"p6"));
        list.add(new Person(3,"1p3"));
        Person p = list.stream().max(Comparator.comparing(t->t.getId())).get();
        System.out.println(p.getName());
        List<Person> collect = list.stream().sorted((s2,s1)->{
            System.out.println("s1:"+s1.getId()+",s2:"+s2.getId());
            if(s1.getId()>s2.getId()){
                return -1;
            }if(s1.getId()<s2.getId()){
                return 1;
            }
            return 0;
        }).collect(Collectors.toList());
        List<Person> list2 = list.stream()
                .filter(f -> f.getName().startsWith("p"))
                .peek(t -> {
                    System.out.println(t.getName());
                })
                .collect(Collectors.toList());
        System.out.println(list2);

    }
    static void test4(){
        List<Integer> nums = Arrays.asList(100,200,300,400,500);
        List list = nums.stream().map(c->c+.12*c).collect(Collectors.toList());
        double bill = nums.stream().map(cost->cost + .12*cost).reduce((sum,cost)->{
            System.out.println("sum: " + sum+ ",cost" + cost);
            sum = sum+cost;
            return sum;
        }).get();
        System.out.println("total:"+bill);
    }

    static void test3(){
        List languages = Arrays.asList("Java","Java1", "Scala", "C++", "Haskell", "Lisp");
        Predicate<String> startJ= n->n.startsWith("J");
        Predicate<String> fourLong = n->n.length()>4;
        languages.stream().filter(startJ.and(fourLong))
                .forEach(System.out::println);
    }

    static void test(){
        List languages = Arrays.asList("Java","Java1", "Scala", "C++", "Haskell", "Lisp");
        System.out.println("Languages which starts with J :");
        filter(languages, str->str.toString().startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(languages, (str)->str.toString().endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str)->true);

        System.out.println("Print no language : ");
        filter(languages, (str)->false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str)->str.toString().length() > 4);
    }

    public static void filter(List names, Predicate condition) {
        names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
            System.out.println(name + " ");
        });
    }
    static void test2(){
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(System.out::println);
        Supplier<MyThread> myThread = MyThread::new;
        List num = Arrays.asList(1,2,3,4,654,7,57,6,7,7);
        TreeSet<Integer> set = new TreeSet<>(Integer::compareTo);

    }

    @Data
    class Person{
        Person(){

        }
        Person(int id, String name){
            this.id=id;
            this.name = name;
        }

        private Integer id;
        private Integer age;

        public Person(Integer id, Integer age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }

        private String name;
    }

    @Data
    class JavaProgrammer{
        private int age ;
        private String firstName;
        private String gender;
        private int salary;

        public JavaProgrammer(int age, String firstName, String gender, int salary) {
            this.age = age;
            this.firstName = firstName;
            this.gender = gender;
            this.salary = salary;
        }
    }
}
