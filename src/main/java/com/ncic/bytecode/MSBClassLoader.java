package com.ncic.bytecode;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class MSBClassLoader extends ClassLoader{

    @Override
    protected Class<?> findClass(String name){
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        byte[] bytes = null;
        try {
            File f = new File("C:/test/",name.replaceAll("\\.","/").concat(".class"));
            fis = new FileInputStream(f);
            baos = new ByteArrayOutputStream();
            int b = 0;

            while((b = fis.read()) != -1){
                baos.write(b);
            }
            bytes = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                baos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return defineClass(name,bytes,0,bytes.length);
//        return super.findClass(name);
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassLoader l = new MSBClassLoader();
        String name = "com.mashibing.jvm.Hello";
        String res = name.replaceAll("\\.","/").concat(".class");
        System.out.println(res);
        Class clazz = l.loadClass("com.mashibing.jvm.Hello");
        Object o =
                clazz.getDeclaredConstructor().newInstance();
//        o.m();

        System.out.println(clazz.getClassLoader());
        System.out.println(o.getClass().getClassLoader());
        System.out.println(l.getClass().getClassLoader());
        System.out.println(l.getParent());
    }

}
