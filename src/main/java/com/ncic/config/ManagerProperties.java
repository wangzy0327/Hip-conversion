package com.ncic.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class ManagerProperties {

    private static final Properties properties = new Properties();

    private static final Logger logger = LoggerFactory.getLogger(ManagerProperties.class);

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
            properties.load(new InputStreamReader(inputStream,"UTF-8"));
            Set<Object> set = properties.keySet();
            Iterator<Object> iterator = set.iterator();
            while(iterator.hasNext()){
                String str = (String) iterator.next();
                logger.debug("key : "+str+" , value : "+properties.getProperty(str));
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
//            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                logger.error(e.getMessage());
//                e.printStackTrace();
            }
        }
    }

    public static String getConfigProperty(String key){
        return properties.getProperty(key);
    }



}
