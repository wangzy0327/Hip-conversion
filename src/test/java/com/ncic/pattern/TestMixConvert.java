package com.ncic.pattern;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMixConvert {

    private static final Logger logger = LoggerFactory.getLogger(TestMixConvert.class);

    @Test
    public void TestConvertText(){
//        String s = "#include \"hip/hip_runtime.h\"";
        String s = "CHECK ( hipMemcpy(A_d, A_h, Nbytes, hipMemcpyHostToDevice));";
        String r = MixConvert.convertText(s);
        logger.info(r);
    }

}
