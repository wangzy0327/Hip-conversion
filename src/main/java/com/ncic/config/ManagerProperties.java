package com.ncic.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ManagerProperties {

    private static final Properties properties = new Properties();

    private ManagerProperties(){}

//    public static void loadProperty(){
//        InputStream inputStream = ManagerProperties.class.getClassLoader().getResourceAsStream("config.properties");
//        try {
//            properties.load(inputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                inputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    static{
        InputStream inputStream = ManagerProperties.class.getClassLoader().getResourceAsStream("config.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getConfigProperty(String key){
        return properties.getProperty(key);
    }



}
