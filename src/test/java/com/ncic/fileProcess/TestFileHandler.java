package com.ncic.fileProcess;

import com.ncic.config.ManagerProperties;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class TestFileHandler {

    private static final Logger logger = LoggerFactory.getLogger(TestFileHandler.class);

    @Before
    public void init(){
        logger.info("初始化读取配置文件 init....");
        String rootPath = ManagerProperties.rootPathStr;
    }

    @Test
    public void testAddAllFiles(){
        String rootPath = ManagerProperties.rootPathStr;
        FileHandler fileHandler = new FileHandler();
        fileHandler.addAllFile(new File(rootPath));
        /**
         * C:\conversion\hello.txt
         * C:\conversion\w2.txt
         * C:\conversion\wor
         * C:\conversion\wor\h2.txt
         * C:\conversion\wor\w2
         * C:\conversion\wor\w2\need.txt
         * C:\conversion\world
         * C:\conversion\world\h1.txt
         */
    }

    @Test
    public void testConvertHIP(){
//        String rootPath = ManagerProperties.getConfigProperty("path");
        FileHandler fileHandler = new FileHandler();
        fileHandler.convertHIP();
    }


}
