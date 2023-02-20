# Lecture 5 - Function or Methods in Java

## 1. Basics About Function

> **What is function**
> 

A function is a block of a code contains a multiple statements or instructions that need to be executed when function with its name is called. A function have a name and arguments which need to be passed when function is get called, which are optional. It also returns the value.

> **Why is it required/need ?**
> 

Suppose you have a one file and you want to read and perform that operations on that file, then you will have to write code for it. Now you got the new list of files you have to perform operation having 1000+ file name then you won’t be writing that code again and again, because it will break DRY principle, and hard to maintain it.

- Parameter : The values that are required when function is called are called parameters.
- Arguments :  The values which are defined when function is defined are called arguments.

```java
											 //   ARGUMENTS
public static int sum(int num1, int num2){
		return num1 + num2;
}
sum(100,200)
// PARAMETERS
```

> **Structure of Function in Java**
> 

```java
access_modifier return_type name(arguments){
		//body
		return value;
}
// Access modifier :  Specify the access modifier to public, private, protocted
// Return Type : When the function execute all instructuction inside it then what should be the 
//               value of that call, is returned by "return"
// Name : Name of function you want to call
// Arguments : What values required for function externally are passed here, there are local 
//             variable and when function executes then are vanished, from call stacks
// Body : List of instructions you want to execute.
// Return : Function finally ends and return value you want to return to call.
```

> **Why in Java functions are called as Methods**
> 

When we create the class, we define attributes of it, like properties and methods. The function we define in the class is called as method, so in the Java write everything inside a classes so function we define is method now.

---

## 2. How values are passed to functions.

> **What is reference ?**
> 

```java
String mystring = new String("Hello World!")

// Here "new" keyword creates the object in heap memory at perticular address and the value stored in "Hello World!". Now at which address the value is stored is told the variable "mystring", means variable mystring holds the address/location in memory of that value("Hello World!"). We call that variable as "REFERENCE". So through the reference I can call its methods and change properties of it, means we can manipulate the object if we have reference(address) of it.
```

> **Introduction**
> 
- There are two types of passing the values to function, first one is call by value and second one is call by reference.
- Call By Value : Copy of value is passed to function.
- Call By Reference : Reference/address of values are passed to function.
- In Java, for primitive data type like int, float, boo-lean the copy of values are passed to function.
- And, for non-primitives copy of a reference address is passed not actual object.

> **Pass by Value**
> 
- In the following example we are passing the value to swap function, not the references/address. So inside the function it has own references for passed values i.e. a & b ( these are the function’s own references other than original ones, and they are assigned with the values provided). Which means given function cannot modify original values as only values are provided.
- Extra
    
    ![20230220_193007.jpg](Lecture%205%20-%20Function%20or%20Methods%20in%20Java%20c44281ebc70740909fbcb4555f9b3add/20230220_193007.jpg)
    
- Ex.
    
    ```java
    public static void main(String[] args){
    		int a = 5;
    		int b = 10;
    		swap(a,b);
    }
    
    public static void swap(int a, int b){
    		int temp = a;
    		a = b;
    		b = temp;
    }
    ```
    

> **Pass By Reference achieved using non-primitive data types**
> 
- We can achieve this using non-primitive data types such as class, string, array, interfaces.
- In Java when passing the object, actual object is not passed, a copy of a reference/address of object is passed so that it can modify the object properties and call functions. And within function its argument takes the value and store within itself. Means new stack reference is created for object, so two references are there for one object. Then it can modify the object accordingly.
- Extra
    
    ![20230220_192938.jpg](Lecture%205%20-%20Function%20or%20Methods%20in%20Java%20c44281ebc70740909fbcb4555f9b3add/20230220_192938.jpg)
    
- Ex.
    
    ```java
    class Prepbytes{
        int number=10;
        
        // pass object as parameter
        public static void increment(Prepbytes pb){
            pb.number = pb.number+1;  // increment variable by 1
            System.out.println("value in method: "+pb.number);
        }
        
        public static void main(String[] args) {
         Prepbytes pb=new Prepbytes(); // pb is an object of class Prepbytes
            
            System.out.println("value before method call: "+pb.number);
            increment(pb); // pass object of the class prepbytes
            System.out.println("value after method call: "+pb.number);
        }
    }
    ```
    

> **Java is a call by value or a call by reference?**
> 

Java is always call by value it is not call by reference, the copy of value of reference is passed not reference actually.

---

## 3. Scoping in Java

> **Introduction**
> 

Scoping defines the scope of the variable, means which variable can accessed from which location/position/scope.

> **Method Scope in Java**
> 

Variables declared inside a method can be accessed only within