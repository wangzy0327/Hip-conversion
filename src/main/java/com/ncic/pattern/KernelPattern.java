package com.ncic.pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KernelPattern {

    private static String kernelPrefix = "hipLaunchKernelGGL";

    private static final Logger logger = LoggerFactory.getLogger(KernelPattern.class);

    public static String convertKernel(String s){
//        System.out.println(s);
        if(s == null || "".equals(s))
            return "";
        if(!s.contains(kernelPrefix))
            return s;
        int start = s.indexOf(kernelPrefix);
        char[] space = new char[start];
        Arrays.fill(space,' ');
        String[] groups = null;
        KPattern[] kPatterns = KPattern.values();
        String res = "";
        //是否 是以 分号结尾
        boolean isSuffix = s.endsWith(";");
        String[] params = s.split(",");
        //TODO repalce
        for(KPattern kPattern:kPatterns){
            groups = matchGroups(s,kPattern.getValue());
            if(groups != null && groups.length != 0 && s.contains("HIP_KERNEL_NAME")){
                res += groups[0]+"<"+groups[1]+">";
                res += " <<< ";
                for(int i = 2;i < groups.length;i++) {
                    if(i == groups.length - 1)
                        res += groups[i];
                    else
                        res += groups[i] + ", ";
                }
                res += " >>> (";
                for(int j = 1;j < params.length;j++){
                    String tmp = params[j].trim().replace(")","").replace(";","");
                    if(tmp.equals("0") || res.contains(tmp))
                        continue;
                    else if(isSuffix && j == params.length - 1){
                         res += tmp+");" ;
                    }else{
                        res += tmp + ", ";
                    }
                }
                if(isSuffix && !res.contains(");"))
                    res += ");";
                res = new String(space)+res;
                logger.trace(res);
                return res;
            }
            if(groups != null && groups.length != 0 && !s.contains("HIP_KERNEL_NAME")){
                res += groups[0]+" <<< ";
                for(int i = 1;i < groups.length;i++) {
                    if(i == groups.length - 1)
                        res += groups[i];
                    else
                        res += groups[i] + ", ";
                }
                res += " >>> (";
                for(int j = 1;j < params.length;j++){
                    String tmp = params[j].trim().replace(")","").replace(";","");
                    if(tmp.equals("0") || res.contains(tmp))
                        continue;
                    else if(isSuffix && j == params.length - 1){
                        res += tmp+");" ;
                    }else{
                        res += tmp + ", ";
                    }
                }
                if(isSuffix && !res.contains(");"))
                    res += ");";
                res = new String(space)+res;
                logger.trace(res);
                return res;
            }
        }
        return null;
    }

    public static String[] matchGroups(String s,final String pattern){
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(s);
        LinkedList<String> groupList = new LinkedList<>();
        while(matcher.find()){
            for(int i = 1;i <= matcher.groupCount();i++){
                logger.trace(matcher.group(i));
                groupList.addLast(matcher.group(i));
            }
            logger.trace(matcher.group(0));
            logger.trace("-----------------------------------------------------------------");
//            System.out.println(matcher.group(0));
        }
//        return groupList.toArray(new String[0]);
        String[] strings = groupList.toArray(String[]::new);
        return strings;
    }
}
