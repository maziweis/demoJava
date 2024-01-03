package com.example.demo.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TestFile {

    public static void main(String[] args) throws Exception {
        test3();


    }

    public static void test4() throws Exception {
        File f1 = new File("d:/test/Clash for Windows.exe");
        File f2 = new File("d:/test/lol3.txt");
        
    }

    public static void test3() throws Exception {
        File f1 = new File("d:/test/lol.txt");
        File f2 = new File("d:/test/lol2.txt");
        FileInputStream fi = new FileInputStream(f1);
        byte[] all = new byte[(int) f1.length()];
        fi.read(all);
        for (byte b : all) {
            System.out.println(b);
        }
        fi.close();
        FileOutputStream fo = new FileOutputStream(f2);
        fo.write(all);
        fo.close();
    }

    public static void test2() {
        File f1 = new File("C:/windows");
        List<File> collect = Arrays.stream(f1.listFiles()).filter(s -> s.isFile()).filter(s -> s.length() > 0).sorted((a, b) -> (int) (a.length() - b.length())).collect(Collectors.toList());
        System.out.println("最大文件" + collect.get(collect.size() - 1) + ",大小" + collect.get(collect.size() - 1).length());
        System.out.println("最小文件" + collect.get(0) + ",大小" + collect.get(0).length());
    }


    public static void test1() {
        File f1 = new File("d:/test");
        File f2 = new File("lol.txt");
        File f3 = new File(f1, "lol.txt");
        System.out.println("f1: " + f1.getAbsolutePath());
        System.out.println("f2: " + f2.getAbsolutePath());
        System.out.println("f3: " + f3.getAbsolutePath());
        System.out.println("当前文件是：" + f3);
        System.out.println("是否存在" + f3.exists());
        System.out.println("是否文件夹" + f3.isDirectory());
        System.out.println("是否文件" + f3.isFile());
        System.out.println("文件长度" + f3.length());
        long time = f3.lastModified();
        Date d = new Date(time);
        System.out.println("文件最后修改时间按" + d);
        f1.setLastModified(0);
        File f4 = new File("d:/test/dota.txt");
        f3.renameTo(f4);
        System.out.println("改名");
    }
}
