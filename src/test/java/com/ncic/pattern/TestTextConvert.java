package com.ncic.pattern;

import org.junit.Assert;
import org.junit.Test;

public class TestTextConvert {

    @Test
    public void testConvertHIPText(){
        TextConvert textConvert = new TextConvert();

        String s0 = "size_t offset = (blockIdx.x * blockDim.x + threadIdx.x);";
        String s1 = "CHECK ( hipMemcpy(C_h, C_d, Nbytes, hipMemcpyDeviceToHost))";
        String s2 = "using namespace hipcub;";
        String s3 = "hipcub::BlockRadixSort(temp_storage.sort).Sort(thread_keys);";
        String s4 = "size_t offset = (hipBlockIdx_x * hipBlockDim_x + hipThreadIdx_x);";

        String res0 = textConvert.convertHIPText(s0);
        String res1 = textConvert.convertHIPText(s1);
        String res2 = textConvert.convertHIPText(s2);
        String res3 = textConvert.convertHIPText(s3);
        String res4 = textConvert.convertHIPText(s4);

        String actualStr0 = "size_t offset = (blockIdx.x * blockDim.x + threadIdx.x);";
        String actualStr1 = "CHECK ( cudaMemcpy(C_h, C_d, Nbytes, cudaMemcpyDeviceToHost))";
        String actualStr2 = "using namespace cub;";
        String actualStr3 = "cub::BlockRadixSort(temp_storage.sort).Sort(thread_keys);";
        String actualStr4 = "size_t offset = (blockIdx.x * blockDim.x + threadIdx.x);";

        Assert.assertEquals(res0,actualStr0);
        Assert.assertEquals(res1,actualStr1);
        Assert.assertEquals(res2,actualStr2);
        Assert.assertEquals(res3,actualStr3);
        Assert.assertEquals(res4,actualStr4);
    }

    @Test
    public void testMatchKeyword(){
        TextConvert textConvert = new TextConvert();
        String s0 = "size_t offset = (blockIdx.x * blockDim.x + threadIdx.x);";
        String s1 = "CHECK ( hipMemcpy(C_h, C_d, Nbytes, hipMemcpyDeviceToHost))";
        String s2 = "using namespace hipcub;";
        String s3 = "hipcub::BlockRadixSort(temp_storage.sort).Sort(thread_keys);";
        String s4 = "size_t offset = (hipBlockIdx_x * hipBlockDim_x + hipThreadIdx_x);";

        String[] actualArr0 = {};
        String[] actualArr1 = {"hipMemcpy","hipMemcpyDeviceToHost"};
        String[] actualArr2 = {"hipcub"};
        String[] actualArr3 = {"hipcub"};
        String[] actualArr4 = {"hipBlockIdx_x","hipBlockDim_x","hipThreadIdx_x"};

        String[] resArr0 = textConvert.matchKeyword(s0);
        String[] resArr1 = textConvert.matchKeyword(s1);
        String[] resArr2 = textConvert.matchKeyword(s2);
        String[] resArr3 = textConvert.matchKeyword(s3);
        String[] resArr4 = textConvert.matchKeyword(s4);

        Assert.assertArrayEquals(resArr0,actualArr0);
        Assert.assertArrayEquals(resArr1,actualArr1);
        Assert.assertArrayEquals(resArr2,actualArr2);
        Assert.assertArrayEquals(resArr3,actualArr3);
        Assert.assertArrayEquals(resArr4,actualArr4);
    }

    @Test
    public void testReplaceHip(){
        TextConvert textConvert = new TextConvert();
        String s0 = "size_t offset = (blockIdx.x * blockDim.x + threadIdx.x);";
        String s1 = "CHECK ( hipMemcpy(C_h, C_d, Nbytes, hipMemcpyDeviceToHost))";
        String s2 = "using namespace hipcub;";
        String s3 = "hipcub::BlockRadixSort(temp_storage.sort).Sort(thread_keys);";
        String s4 = "size_t offset = (hipBlockIdx_x * hipBlockDim_x + hipThreadIdx_x);";

        String[] keyword0 = {};
        String[] keyword1 = {"hipMemcpy","hipMemcpyDeviceToHost"};
        String[] keyword2 = {"hipcub"};
        String[] keyword3 = {"hipcub"};
        String[] keyword4 = {"hipBlockIdx_x","hipBlockDim_x","hipThreadIdx_x"};

        String r0 = "size_t offset = (blockIdx.x * blockDim.x + threadIdx.x);";
        String r1 = "CHECK ( cudaMemcpy(C_h, C_d, Nbytes, cudaMemcpyDeviceToHost))";
        String r2 = "using namespace cub;";
        String r3 = "cub::BlockRadixSort(temp_storage.sort).Sort(thread_keys);";
        String r4 = "size_t offset = (blockIdx.x * blockDim.x + threadIdx.x);";


        Assert.assertEquals(textConvert.replaceHIP(s0,keyword0),r0);
        Assert.assertEquals(textConvert.replaceHIP(s1,keyword1),r1);
        Assert.assertEquals(textConvert.replaceHIP(s2,keyword2),r2);
        Assert.assertEquals(textConvert.replaceHIP(s3,keyword3),r3);
        Assert.assertEquals(textConvert.replaceHIP(s4,keyword4),r4);
    }

}
