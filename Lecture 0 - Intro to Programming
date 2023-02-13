# Lecture 0 - Intro to Programming

## 1. What is Programming Language

> **Why we need Programming Language ?**
> 

To create the program like printing welcome message, printing the table of 10 and check the number is prime or not these computational tasks can be performed by the computer in very efficient and faster way.

But computers can only understand the binary language which consist of only ones and zeros (0’s and 1’s). To create the program or applications using only Binary language is more complicated, cumbersome and near to impossible. So we created the language which is human readable, where humans can write their instruction for computer and computers can easily execute.

> **What is compiler and why it is required ?**
> 

In real world, If two different entities understands two different language then to communicate between themselves we use INTERPRETER who can understand both the language, and communication occurs. 

Just like real world, for converting the Human readable instruction into machine readable instructions is done by compiler. Suppose you are having the `main.cpp` file after compiling it compiler generates the `main.out` file which is machine readable and consist of 0’s and 1’s.

> **Types of the Programming Languages**
> 

In actual, there are many types of programming languages but basically we can differentiate major three categories depending on method of writing they follow,

1. Procedural Language
    - It use the specific steps and procedure to create the program
    - Contains the systematic order of Functions, commands and statements for completing the task
    - Ex. Sum of all the even number provided.
2. Functional Language
    - More focus on the function for performing the task.
    - Uses first class functions.
    - Ex. Read the 100 files and modify it in some way, we can write function for it, not like one by one writing code for each file.
3. Object oriented Language
    - Talk more about classes and objects. Class is like a blueprint or template of the data. Object are instance of class, actually data is created using it.
    - Ex. Just like other data type int, string and float, class is custom data type consist of properties and functions. For storing data of 50 students we will use the Class-Object structure having name, roll no, email, marks.

---

## 2. Static and Dynamic Languages

> **Difference**
> 

| Feature | Static Programming Languages | Dynamic Programming Languages |
| --- | --- | --- |
| Type Checking | Type checking is performed at compile-time. | Type checking is performed at runtime. |
| Type Declaration | Variables must be declared with a specific type. | Variables do not need to be declared with a specific type. |
| Flexibility | Less flexible, as it's harder to change the type of a variable after it's been declared. | More flexible, as it's easier to change the type of a variable at runtime. |
| Error Detection | Errors can be detected early, at compile-time. | Errors can only be detected at runtime. |
| Performance | Generally faster, as type checking is done at compile-time. | Generally slower, as type checking is done at runtime. |
| Debugging | Easier to debug, as errors are detected early. | Harder to debug, as errors can only be detected at runtime. |

> **Little more about it**
> 

Static languages are the programming languages which require the code to be compiled before execution, and the code is bound to the machine instructions at compile time. Dynamic programming languages are the languages which are executed line by line and code is bound to machine instructions at runtime.

Static languages are considered more secure and reliable as the code is checked before execution, while dynamic languages provide more flexibility as code can be changed at runtime.

Java is a combination of both static and dynamic language as it is checked for errors at compile time, but at the same time it also supports dynamic loading and dynamic class redefinition at runtime.

---

## 3. Memory Management

> **Stack and Head Memory**
> 
- In a program point of view there are two types of memory, Stack and Heap Memory.
- Actually no physical partition is there for the Stack & Heap memory there is only Logical partition inside the Main Memory (RAM).
- When we declare the a = 10 then “a” (reference variable) is stored in stack memory and “10” (object) is stored in Heap memory. In Java there can be multiple reference variables for single object. Changes made by one reflected to others also.

> **STACK**
> 
1. Static Memory
2. Stack memory is fixed size of memory and its size is fixed by operating system at start of program.
3. Fast Access is possible as it uses LIFO data structure
4. Used as temporary storage.
5. Used to store function calls and function arguments.
6. Ex. When a function call happens then function call with its arguments is pushed into stack and after return of function they are popped out from stack. ( In Recursion )

> ********HEAP********
> 
1. Dynamic Memory
2. Heap memory is dynamic size of memory, and size is dynamic and can vary, and freed according to needs.
3. Slow access as memory is dynamically allocated and deallocated.
4. Used as persistent storage beyond the functions.
5. Used to create dynamic variable and data structures.
6. Ex. When you have store/perform operation on student data, but no of student are not known at program creation time, so we will allocated dynamically. 

---

## 4. Garbage Collection

> **Definition**
> 

A garbage collection is a automatic memory management, where the object with no reference variables are removed from the heap memory.

> **Uses**
> 
1. Avoid the memory leaks 
2. Increase developers productivity
3. Improve performance

> **Memory Leak**
> 

Software bug/issue in which program repeatedly allocates the memory but fails to deallocate it, which consumes system’s memory.

> **Examples of languages**
> 

Python and Java use mostly a garbage collection.
