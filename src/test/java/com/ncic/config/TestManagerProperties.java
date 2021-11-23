package com.ncic.config;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestManagerProperties {

    private static final Logger logger = LoggerFactory.getLogger(TestManagerProperties.class);

    @Before
    public void init(){

        System.out.println("加载配置文件....");
        logger.info("加载配置文件....");
//        ManagerProperties.loadProperty();
    }

    @After
    public void end(){
        System.out.println("测试结束.......");
    }

    @Test
    public void testProperties(){
        String rootPath = ManagerProperties.getConfigProperty("path");
        Assert.assertEquals("C:/conversion",rootPath);
        System.out.println("Root Path ："+rootPath);

    }

}
