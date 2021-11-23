package com.ncic.pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 转换 命名空间、host函数接口API、头文件 的 hip 文本
 */
public class TextConvert {

    private static final Logger logger = LoggerFactory.getLogger(TextConvert.class);

    public static String convertHIPText(String s){
//        String text = "CHECK ( cudaMemcpy(C_h, C_d, Nbytes, cudaMemcpyDeviceToHost))";
        if(s == null)
            return "";
        String[] strArr = matchKeyword(s);
        if(strArr == null || strArr.length == 0)
            return s;
        String res = replaceHIP(s,strArr);
        return res;
    }

    public static String[] matchKeyword(String s){
//        Pattern p = Pattern.compile("(cuda|CUDA|cu|CU)\\w+");
//        Pattern p = Pattern.compile("(hip|HIP|hIP)\\w+");
        Pattern p = Pattern.compile("(hip|HIP|hIP)/*[\\w|/|_]+[.h]*");
//        (hip|HIP|hIP)/*[A-Z|a-z|/|_]+(.h)*
        Matcher m = p.matcher(s);
        int count = 0;
        List<String> list = new ArrayList<>();
        while(m.find()){
            //TODO replace
            logger.trace(m.group(count));
            list.add(m.group(count));
        }
        return list.toArray(String[]::new);
    }

    public static String replaceHIP(String s,String[] keywords){
        String r = s;
        logger.info(r);
        for(String keyword:keywords){
            r = r.replaceAll(keyword,MapTable.simSubMap.getOrDefault(keyword,keyword));
            logger.trace(" simSubMap -> "+r);
        }
        for(String keyword:keywords) {
            r = r.replaceAll(keyword, MapTable.indexMap.getOrDefault(keyword, keyword));
            logger.trace(" indexMap -> "+r);
        }
        for(String keyword:keywords){
            r = r.replaceAll(keyword,MapTable.experSubMap.getOrDefault(keyword,keyword));
            logger.trace(" experSubMap -> "+r);
        }
        for(String keyword:keywords){
            r = r.replaceAll(keyword,MapTable.expreCubNamespace.getOrDefault(keyword,keyword));
            logger.trace(" expreCubNamespace -> "+r);
        }
        logger.info(r);
        return r;
    }
}
