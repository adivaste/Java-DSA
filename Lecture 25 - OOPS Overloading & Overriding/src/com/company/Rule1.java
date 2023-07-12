package com.company;

class Parent{
    public Object m1(){
        System.out.println("Hello m1 from Parent");
        return (new Object());
    }
}
class Child{
    public String m1(){
        System.out.println("Hello m1 from Parent");
        return ("Adi");
    }
}
