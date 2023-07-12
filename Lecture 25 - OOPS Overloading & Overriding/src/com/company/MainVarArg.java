package com.company;

public class MainVarArg{
    public static void main(String[] args){
        Parent va = new Parent();
        va.m1(5);

        Child c = new Child();
        c.m1(5);

        Parent p = new Child();
        p.m1(10);
    }
}
