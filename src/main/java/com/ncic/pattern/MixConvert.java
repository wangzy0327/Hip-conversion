package com.ncic.pattern;

public class MixConvert {

    public static String convertText(String s){
        String r = KernelPattern.convertKernel(s);
        return TextConvert.convertHIPText(r)+"\n";
    }

}
