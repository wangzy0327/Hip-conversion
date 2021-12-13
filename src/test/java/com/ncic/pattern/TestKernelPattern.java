package com.ncic.pattern;

import org.junit.Assert;
import org.junit.Test;

public class TestKernelPattern {

    @Test
    public void testConvertKernel(){
        String s1 = "hipLaunchKernelGGL(vector_square, blocks, threadsPerBlock, 0, 0, C_d, A_d, N);";
        String s2 = "hipLaunchKernelGGL(vector_square, blocks, threadsPerBlock, 0, 0);";
        String s3 = "hipLaunchKernelGGL(HIP_KERNEL_NAME(vector_square1<double>), blocks, threadsPerBlock, 0, 0, C_d, A_d, N);";
        String s4 = "hipLaunchKernelGGL(HIP_KERNEL_NAME(vector_square1<long long>), blocks, threadsPerBlock, 0, 0);";
        String s5 = "hipLaunchKernelGGL(vector_square, blocks, threadsPerBlock, N, 0, C_d, A_d);";
        String s6 = "hipLaunchKernelGGL(vector_square, blocks, threadsPerBlock, N, 0);";
        String s7 = "hipLaunchKernelGGL(HIP_KERNEL_NAME(vector_square1<vector_square2>), blocks, threadsPerBlock, C_d, 0,  A_d, N);";
        String s8 = "hipLaunchKernelGGL(HIP_KERNEL_NAME(vector_square1<vector_square2>), blocks, threadsPerBlock, C_d, 0);";
        String s9 = "hipLaunchKernelGGL(vector_square, blocks, threadsPerBlock, C_d, A_d, N);";
        String s10 = "hipLaunchKernelGGL(vector_square, blocks, threadsPerBlock, C_d, A_d);";
        String s11 = "hipLaunchKernelGGL(HIP_KERNEL_NAME(vector_square1<vector_square2>),vector_square, blocks, threadsPerBlock, N, Num);";
        String s12 = "hipLaunchKernelGGL(HIP_KERNEL_NAME(vector_square1<vector_square2>),vector_square, blocks, threadsPerBlock, N);";
        String s13 = "hipLaunchKernelGGL(vector_square, dim3(blocks), dim3(threadsPerBlock), 0, 0, C_d, A_d, N);";
        String s14 = "hipLaunchKernelGGL(calculateForce, grid, block, 0, 0, d_phiold,d_Fx,d_Fy,d_Fz,";
        String s15 = "        hipLaunchKernelGGL(calculateForce, grid, block, 0, 0, d_phiold,d_Fx,d_Fy,d_Fz,";
        String s16 = "        hipLaunchKernelGGL(HIP_KERNEL_NAME(atomicDerived<unsigned long long>), dim3(NUM_BLOCKS), dim3(BLOCK_SIZE), 0, 0, d_res_u64);";

        String r1 = "vector_square <<< blocks, threadsPerBlock >>> (C_d, A_d, N);";
        String r2 = "vector_square <<< blocks, threadsPerBlock >>> ();";
        String r3 = "vector_square1<double> <<< blocks, threadsPerBlock >>> (C_d, A_d, N);";
        String r4 = "vector_square1<long long> <<< blocks, threadsPerBlock >>> ();";
        String r5 = "vector_square <<< blocks, threadsPerBlock, N >>> (C_d, A_d);";
        String r6 = "vector_square <<< blocks, threadsPerBlock, N >>> ();";
        String r7 = "vector_square1<vector_square2> <<< blocks, threadsPerBlock, C_d >>> (A_d, N);";
        String r8 = "vector_square1<vector_square2> <<< blocks, threadsPerBlock, C_d >>> ();";
        String r9 = "vector_square <<< blocks, threadsPerBlock, C_d, A_d >>> (N);";
        String r10 = "vector_square <<< blocks, threadsPerBlock, C_d, A_d >>> ();";
        String r11 = "vector_square1<vector_square2> <<< vector_square, blocks, threadsPerBlock, N >>> (Num);";
        String r12 = "vector_square1<vector_square2> <<< vector_square, blocks, threadsPerBlock, N >>> ();";
        String r13 = "vector_square <<< dim3(blocks), dim3(threadsPerBlock) >>> (C_d, A_d, N);";
        String r14 = "calculateForce <<< grid, block >>> (d_phiold, d_Fx, d_Fy, d_Fz, ";
        String r15 = "        calculateForce <<< grid, block >>> (d_phiold, d_Fx, d_Fy, d_Fz, ";
        String r16 = "        atomicDerived<unsigned long long> <<< dim3(NUM_BLOCKS), dim3(BLOCK_SIZE) >>> (d_res_u64);";


        Assert.assertEquals(r1,KernelPattern.convertKernel(s1));
        Assert.assertEquals(r2,KernelPattern.convertKernel(s2));
        Assert.assertEquals(r3,KernelPattern.convertKernel(s3));
        Assert.assertEquals(r4,KernelPattern.convertKernel(s4));
        Assert.assertEquals(r5,KernelPattern.convertKernel(s5));
        Assert.assertEquals(r6,KernelPattern.convertKernel(s6));
        Assert.assertEquals(r7,KernelPattern.convertKernel(s7));
        Assert.assertEquals(r8,KernelPattern.convertKernel(s8));
        Assert.assertEquals(r9,KernelPattern.convertKernel(s9));
        Assert.assertEquals(r10,KernelPattern.convertKernel(s10));
        Assert.assertEquals(r11,KernelPattern.convertKernel(s11));
        Assert.assertEquals(r12,KernelPattern.convertKernel(s12));
        Assert.assertEquals(r13,KernelPattern.convertKernel(s13));
        Assert.assertEquals(r14,KernelPattern.convertKernel(s14));
        Assert.assertEquals(r15,KernelPattern.convertKernel(s15));
        Assert.assertEquals(r16,KernelPattern.convertKernel(s16));
    }


    @Test
    public void testMatchGroups(){
        String s1 = "hipLaunchKernelGGL(vector_square, blocks, threadsPerBlock, 0, 0, C_d, A_d, N);";
        String s2 = "hipLaunchKernelGGL(vector_square, blocks, threadsPerBlock, 0, 0);";
        String s3 = "hipLaunchKernelGGL(HIP_KERNEL_NAME(vector_square1<vector_square2>), blocks, threadsPerBlock, 0, 0, C_d, A_d, N);";
        String s4 = "hipLaunchKernelGGL(HIP_KERNEL_NAME(vector_square1<vector_square2>), blocks, threadsPerBlock, 0, 0);";
        String s5 = "hipLaunchKernelGGL(vector_square, blocks, threadsPerBlock, N, 0, C_d, A_d);";
        String s6 = "hipLaunchKernelGGL(vector_square, blocks, threadsPerBlock, N, 0);";
        String s7 = "hipLaunchKernelGGL(HIP_KERNEL_NAME(vector_square1<vector_square2>), blocks, threadsPerBlock, C_d, 0,  A_d, N);";
        String s8 = "hipLaunchKernelGGL(HIP_KERNEL_NAME(vector_square1<vector_square2>), blocks, threadsPerBlock, C_d, 0);";
        String s9 = "hipLaunchKernelGGL(vector_square, blocks, threadsPerBlock, C_d, A_d, N);";
        String s10 = "hipLaunchKernelGGL(vector_square, blocks, threadsPerBlock, C_d, A_d);";
        String s11 = "hipLaunchKernelGGL(HIP_KERNEL_NAME(vector_square1<vector_square2>),vector_square, blocks, threadsPerBlock, N, Num);";
        String s12 = "hipLaunchKernelGGL(HIP_KERNEL_NAME(vector_square1<vector_square2>),vector_square, blocks, threadsPerBlock, N);";

        String[] r1 = {"vector_square","blocks","threadsPerBlock"};
        String[] r2 = {"vector_square","blocks","threadsPerBlock"};
        String[] r3 = {"vector_square1","vector_square2","blocks","threadsPerBlock"};
        String[] r4 = {"vector_square1","vector_square2","blocks","threadsPerBlock"};
        String[] r5 = {"vector_square","blocks","threadsPerBlock","N"};
        String[] r6 = {"vector_square","blocks","threadsPerBlock","N"};
        String[] r7 = {"vector_square1","vector_square2","blocks","threadsPerBlock","C_d"};
        String[] r8 = {"vector_square1","vector_square2","blocks","threadsPerBlock","C_d"};
        String[] r9 = {"vector_square","blocks","threadsPerBlock","C_d","A_d"};
        String[] r10 = {"vector_square","blocks","threadsPerBlock","C_d","A_d"};
        String[] r11 = {"vector_square1","vector_square2","vector_square","blocks","threadsPerBlock","N"};
        String[] r12 = {"vector_square1","vector_square2","vector_square","blocks","threadsPerBlock","N"};

        Assert.assertArrayEquals(r1,KernelPattern.matchGroups(s1,KPattern.KPATTERN1.getValue()));
        Assert.assertArrayEquals(r2,KernelPattern.matchGroups(s2,KPattern.KPATTERN2.getValue()));
        Assert.assertArrayEquals(r3,KernelPattern.matchGroups(s3,KPattern.KPATTERN3.getValue()));
        Assert.assertArrayEquals(r4,KernelPattern.matchGroups(s4,KPattern.KPATTERN4.getValue()));
        Assert.assertArrayEquals(r5,KernelPattern.matchGroups(s5,KPattern.KPATTERN5.getValue()));
        Assert.assertArrayEquals(r6,KernelPattern.matchGroups(s6,KPattern.KPATTERN6.getValue()));
        Assert.assertArrayEquals(r7,KernelPattern.matchGroups(s7,KPattern.KPATTERN7.getValue()));
        Assert.assertArrayEquals(r8,KernelPattern.matchGroups(s8,KPattern.KPATTERN8.getValue()));
        Assert.assertArrayEquals(r9,KernelPattern.matchGroups(s9,KPattern.KPATTERN9.getValue()));
        Assert.assertArrayEquals(r10,KernelPattern.matchGroups(s10,KPattern.KPATTERN10.getValue()));
        Assert.assertArrayEquals(r11,KernelPattern.matchGroups(s11,KPattern.KPATTERN11.getValue()));
        Assert.assertArrayEquals(r12,KernelPattern.matchGroups(s12,KPattern.KPATTERN12.getValue()));
    }

}
