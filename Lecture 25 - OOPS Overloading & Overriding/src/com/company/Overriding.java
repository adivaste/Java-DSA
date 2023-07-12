package com.company;

class Animal{
    public void walk(){
        System.out.println("I can Walk");
    }

    public void makeSound(){
        System.out.println("I can make sound");
    }
}

class Dog extends Animal{
    public void makeSound(){
        System.out.println("I can Bark");
    }
}
