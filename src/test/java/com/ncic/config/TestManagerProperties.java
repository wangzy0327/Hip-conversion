package com.ncic.config;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestManagerProperties {


    @Before
    public void init(){
        System.out.println("加载配置文件....");
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
