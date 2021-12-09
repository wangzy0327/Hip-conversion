package com.ncic.bytecode;

public class Hello_01 {
    public int m(int n){
        if(n == 1) return 1;
        return n*m(n-1);
    }
}
