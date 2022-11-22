package com.example.demo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class HashTest {
    public static void main(String[] args) {
        testConcurrentHashMap();
    }

    static void testConcurrentHashMap(){
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("sds","dsds");
        concurrentHashMap.put("sds1","dsds");
        concurrentHashMap.put("sds2","dsds");
        concurrentHashMap.put("sds3","dsds");
        Iterator iterator1 = concurrentHashMap.entrySet().iterator();
        while (iterator1.hasNext()){
            Map.Entry<String, String> next = (Map.Entry<String, String>)iterator1.next();
            if(next.getKey().equals("sds")){
                iterator1.remove();
            }
        }
        for (Map.Entry<String, String> entry : concurrentHashMap.entrySet()) {
            System.out.println(entry);
        }
    }

    static void testHashSet(){
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("as");
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();

        }
    }

    static void testHashMap(){
        Hashtable<String,String> hashtable = new Hashtable<>();
        hashtable.put("sd","dsd");
        Map<String,String> map =new HashMap<>();
        map.put("ss","sds");
        map.put("ss1","sds");
        map.put(null,null);
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            if(next.getKey()==null){
                iterator.remove();
            }
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry);
        }
        map.forEach((k,v)->{

        });
        map.entrySet().stream().forEach((entry)->{

        });
    }
}
