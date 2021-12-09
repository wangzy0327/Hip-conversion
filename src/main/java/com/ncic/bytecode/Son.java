package com.ncic.bytecode;

public class Son extends Father{

    private String name = "son";

    static int age = 10;

    static{
        System.out.println("static Son class");
        System.out.println("static Son variable value "+age);
    }

    {
        System.out.println("Son 构造代码块.......");
        System.out.println("Son 构造代码块 name "+name);
    }

    public Son(){
        System.out.println("Son constructor......");
        System.out.println("Son name "+name);
    }


    public static void main(String[] args) {
        Son son = new Son();
    }
}
