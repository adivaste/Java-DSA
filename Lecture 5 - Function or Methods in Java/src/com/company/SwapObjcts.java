/*
    * Java uses the call by values
    * We cannot swap the object for different reference variable
    * So, we cannot use call by reference
 */

package com.company;

// Number class
class Number{
    int num;
}

// Regular class
public class SwapObjcts {

    public static void main(String[] args) {
        Number obj1 = new Number();
        obj1.num = 5;
        Number obj2 = new Number();
        obj2.num = 7;
        System.out.println("Object1 Before :: " + obj1.num);
        System.out.println("Object2 Before :: " + obj2.num);


        swap(obj1, obj2);
        System.out.println("Object1 After :: " + obj1.num);
        System.out.println("Object2 After :: " + obj2.num);
    }
    public static void swap(Number obj1, Number obj2){
        Number temp = obj1;
        obj1 = obj2;
        obj2 = temp;
    }
}
