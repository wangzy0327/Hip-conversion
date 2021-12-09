package com.ncic.bytecode;

public class Father {
    static int age = 40;
    private String name = "father";

    static{
        System.out.println("static Father class");
        System.out.println("static Father variable value "+age);
    }

    {
        System.out.println("Father 构造代码块.......");
        System.out.println("Father 构造代码块 name "+name);
    }

    public Father(){
        System.out.println("Father constructor......");
        System.out.println("Father name "+name);
    }

}
