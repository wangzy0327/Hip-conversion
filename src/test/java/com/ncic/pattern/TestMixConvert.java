package com.ncic.pattern;

import org.junit.Test;

public class TestMixConvert {


    @Test
    public void TestConvertText(){
//        String s = "#include \"hip/hip_runtime.h\"";
        String s = "CHECK ( hipMemcpy(A_d, A_h, Nbytes, hipMemcpyHostToDevice));";
        String r = MixConvert.convertText(s);
        System.out.println(r);
    }

}
