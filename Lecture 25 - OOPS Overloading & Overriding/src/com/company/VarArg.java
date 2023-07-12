package com.company;

class Parent{
    public void m1(int... args){
        System.out.println("Var-arg method");
    }
}

class Child extends Parent{
    public void m1(int... args){
        System.out.println("Also var-arg method");
    }
}
