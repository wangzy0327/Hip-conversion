package com.ncic.bytecode;

public class ByteCode01 {
    public static void main(String[] args) {
        System.out.println(ByteCode01.class.getClassLoader());
        System.out.println(ByteCode01.class.getClassLoader().getParent());
        System.out.println(ByteCode01.class.getClassLoader().getParent().getClass().getClassLoader());
        System.out.println(ByteCode01.class.getClassLoader().getParent().getParent());
        System.out.println(String.class);
        System.out.println("-------------------------------------");
//        String cp = System.getProperty("java.class.path");
        String cp = System.getProperty("jdk.module.main");
        System.out.println(cp.replaceAll(";",System.lineSeparator()));
    }
}
