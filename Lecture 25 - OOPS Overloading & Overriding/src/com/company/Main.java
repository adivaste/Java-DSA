package com.company;

public class Main {

    public static void main(String[] args) {
    
    // Parent method called
    Animal a = new Animal();
    a.walk();
    a.makeSound();

    // Child method called
    Dog d = new Dog();
    d.walk();
    d.makeSound();

    // Parent holding the child but due to
    // runtime poly. child class method called
    Animal ad = new Dog();
    ad.makeSound();       
    
    }
}
