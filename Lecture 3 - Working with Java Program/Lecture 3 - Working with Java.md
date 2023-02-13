# Lecture 3 - Working with Java Program

## 1. Structure of Java file

> **Java file basic structure**
> 

```java
package com.company

public class Demo{
	public static void main(String[] args){
		System.out.println("Hello World");
	}
}
```

- In java we write everything in terms of classes, each `.java` file has a class within it.
- Class name and file name must be same according to convention of the java.
- For compiling the java file we use `javac` command and for running `.class` file we use `java` command.
    - Compilation   :  `javac Demo.java`
    - Program Run :  `java Demo`
    
    ( We can also specify `.class` file directory using command `javac -d . Demo.java` )
    

Meaning : 

- `public` :  Class can be public/private/protected. Here public means our class can be accessed from anywhere from other java file.
- `class`  :  It is the named group of properties and functions.
- `Demo`  :  Just name of the class, same as file name.
- `main` : It’s the name of function, and it must be `main` , because that’s the entry-point of java program, java will look for main function otherwise your program will not run, although it will compile.
- `public` : Function can be accessed from anywhere in java file.
- `static` : Static means this function can directly run without creating any object of the class.
- `void` : It’s return type of the function, currently we are not returning anything, so its void.
- `String[]` : Its the array of command line arguments which will be passed while executing the program on command line. ( `java Demo "Aditya"`  argument “Aditya” will be passed to java program, and can be accessed using `args[1]` , by 0th argument is by default filename.
- `package` : In simple, its the folder in which your java file lies. ( Package is just a simple folder structure where all the java files are arranged and organised in specific way. It will be easy for maintain, provides security, avoid the naming conflicts )

- More explanation
    - `package [com.company](http://com.company)` : So first of all we have our first statement `package com.company`, here package is reserved keyword in java used to mention the package name.  `com.company` is the name of the package. So let’s understand what is package : A package is nothing but a directory/folder structure having all the java files organised in maintained in specific way. Why we use package ? : It is easy for use & maintain, provides the security, avoids the naming conflicts. Now here `com.company` is just package name indicating that `com` is the main folder and within in `company` is subfolder, in inside that all the `.class` files will be placed. `.` (dot) represents the nested folder type, folder within folder. Through terminal you have to specify the directory of package to store `.class` files. Command : `java -d . Main.java`
    - `public` : In general public means, it is accessible for everyone, everyone can watch it, go there, access it. Means everyone has rights to access it. Similarly in programming public means it can be accessible from anywhere, and anyone can call it and use it. So for JVM to access this class and call it for running we are making it public.
    - `class` :  Class is special data type having the properties and functions which can be performed on data. Suppose I have to store student name, I will use `string`, if I want to store numbers then I will use `int`. But If I want to store all personal information I will use the data type class, which is blueprint of information to store.
    - `Demo` : It is the name of the class which we are creating, every java file has a class and name of that class must be equal to filename, that the convention used in java. Class name should start with capital letter ex.`MyClassName`
    - 
    

---

## 2. Java Input & Outputs

> **Output**
> 

```java
System.out.println("Hello World");
```

Above statement is used for printing the output to console.

- System :  A System is a pre-defined java class, which provides various utility methods for developers to work with. So some of the most commonly used methods provided by `system` class are input/output streams, environment variable( `getenv()` ) , system properties (`getProperty()`), Array copying(`arraycopy()`), time in milliseconds and nanoseconds, garbage collector `gc()` , `exit()` . Also there are some most commonly used variable are also there like `in`, `out` and `err` which are object of `printstream` and `inputstream` classes used for printing on console, file and other places.
- `out` : Out of these variable we are using `out` of type `printstream` to print on console. By default value of `out` variable which is of `printstream` class is `null` , so its default option for printing stream is console. We can specify particular file for stream output/input, by changing `out` variable.
- `println` : For an `out` variable we are using `println()` method from the `printstream` class, which take on argument, it may be string, integer, float. and finally print on console. Also `print()` method is used for printing but it does not move cursor to next line by default, print on same line. `printf()` used to print in formatted way.
    
    Ex. `System.out.printf("Hi, %s how are you. I got to know that you got %d marks", "Aditya", 45);`
    
    `System.out.println("Hello, " + name + ". You are " + age + " years old.");`
    

> **Input**
> 

```java
Scanner input = new Scanner(System.in);
name = input.nextLine();
```

- Scanner : It is the class present inside the `java.util` package. The Scanner class is used to read the input from various sources like Console keyboard, File, Network socket. It has some methods which helps to parse the input data in efficient way like `nextInt()`, `nextFloat()`, `nextLine()`, `next()` and many other. `nextLine()` and `next()` used for reading but `nextLine()` read whole input string with spaces and all words, but `next()` reads only first word.

---

## 3. Data types in Java

> **Primitive Data types : Definition**
> 

Primitive data type are very basic data types, which are built into an programming language, it cannot be constructed from other data type and we cannot break into other data type.

Ex. `int` `float` `double` `byte` `short` `long` `boolean` `char`

> **Classification of Data types**
> 

![Untitled](Lecture%203%20-%20Working%20with%20Java%20Program%207a68115f6a804ae48643a735f7745a66/Untitled.png)

> **Limits of Primitive Data Types**
> 

| Data type | Meaning | Memory size | Range | Default Value |
| --- | --- | --- | --- | --- |
| byte | Whole numbers | 1 byte | -128 to +127 | 0 |
| short | Whole numbers | 2 bytes | -32768 to +32767 | 0 |
| int | Whole numbers | 4 bytes | -2,147,483,648 to +2,147,483,647 | 0 |
| long | Whole numbers | 8 bytes | -9,223,372,036,854,775,808 to +9,223,372,036,854,775,807 | 0L |
| float | Fractional numbers | 4 bytes | - | 0.0f |
| double | Fractional numbers | 8 bytes | - | 0.0d |
| char | Single character | 2 bytes | 0 to 65535 | \u0000 (NULL) |
| boolean | unsigned char | 1 bit | 0 or 1 | 0 (false) |

> **Wrapper Classes**
> 
- These are the classes created by JAVA to represent the primitive data types, which also provides various manipulation methods which are not available for primitive data types.
- To create and use wrapper classes we use simple class objects
    
    ```java
    Integer a = new Integer();
    Double  b = new Double();
    Boolean d = new Boolean(true);
    Character e = new Character('N')
    ```
    

> **Comments**
> 
1. Single line comments
    
    ```java
    // This is first comment, you can use two forward slashes
    ```
    
2. Multiline comments
    
    ```java
    /*
     * First Line 
     * Second Line
    */
    ```
    

> **Literals and Identifiers**
> 

A literal is the value given to the variables in the program, and Identifier is a name of variable, function, class, package, constant, argument and other elements.

Ex.

```java
int a = 10
boolean isValid = true

// Here 'a' and 'isValid' are identifiers and '10' and 'true' are literals.
```

---

## 4. Automatic Type Conversion | Typecasting | Automatic Type Promotion

> **Remember**
> 
- By default data type of any number is `int`
- By default data type of any decimal is `double`
- Java uses a UNICODE values means almost all the languages are supported by JAVA as `char` has 2 bytes makes 65,536 available characters.

> **Automatic Type Conversion | Widening | Implicit**
> 
- In an automatic type conversion, java automatically convert the lower data type to higher data type.
- Conditions for ATC :
    1. Both the data types should be compatible to each other.
    2. Destination data type should be greater than source type.
- Priority chart
    
    Byte → Short → Int → Long → Float → Double 
    
- Examples :
    
    ```java
    // Automatic conversion from INT to FLOAT ( opposite of this won't happen, will give an error )
    int x = 45
    float y = x
    ```
    

> **Typecasting | Explicit | Lossy conversion**
> 
- In Typecasting  we explicitly mention the data type of value to convert using braces.
- Example :
    
    ```java
    // Explicit conversion from 'char' to 'float'
    float x = (int)'a';
    System.out.println(x);
    
    // Oversizing the values
    int a = 257;
    byte = (byte)a;        // 1 :: Byte have only size of 8 bits, so 257%256 = 1 
    ```
    

> **Automatic Type Promotion**
> 
- This promotion usually occurs in expressions, when value of answer doesn’t fit inside a source data type, so it will be converted to `int` or `double` if decimal values are there.
- Example :
    
    ```java
    // Here value a*b is 2000, which cannot fit inside a 'byte' so its promoted to 'int' 
    // and now we are storing it into 'int'
    byte a = 50;
    byte b = 40;
    byte c = 100;
    int d = (a*b)/c 
    
    // This will give an error as you cannot store 1000 in 'byte'
    byte a = 50;
    a = 50*20;
    ```
    

> **Extra**
> 
- Code
    
    ```java
    // Answer will have the largest data type out of all. (Widening)
    
    byte b = 42;
    char c = 'a';
    short s = 1024;
    int i = 50000;
    float f = 5.67f;
    double d = 0.1234;
    double result = (f*b) + (i/c) - (d-c);
    
    System.out.println( f*b + " " + i/c + " " + (d-c) )  
    System.out.println(result)
    ```
    

---

## 5. Examples on Basics

- Temperature Conversion Program
    
    ```java
    package com.company;
    
    import java.util.Scanner;
    
    public class TemperatureConversion {
        public static void main(String[] args) {
    
            // Creating the scanner class for taking Input
            Scanner input = new Scanner(System.in);
    
            // Taking the input from user
            System.out.print("\n 1. Celsius to Fahrenheit \n 2. Fahrenheit to Celsius \n\nChoose mode of conversion : ");
            int choice = input.nextInt();
    
            // Checking User Input and making decision based on it
            if (choice == 1){
                System.out.print("* Enter Temp. In Celsius : ");
                double cel = input.nextDouble();
                float tempInFahre = (float) celToFahre(cel);
                System.out.println("* Temp. In Fahrenheit is : " + tempInFahre);
            }
            else if (choice == 2){
                System.out.print("* Enter Temp. In Fahrenheit : ");
                double fahre = input.nextDouble();
                float tempInCel = (float)fahreToCel(fahre);
                System.out.println("* Temp. In Celsius is : " + tempInCel);
            }
            else{
                System.out.println("\n* Please choose correct option !!");
            }
        }
    
        private static double fahreToCel(double fahre) {
            return (fahre - 32)*5/9;
        }
    
        private static double celToFahre(double cel) {
            return (cel + 32)*9/5;
        }
    }
    ```
    
- Principle, Rate and Time
    
    ```java
    package com.company;
    
    import java.util.Scanner;
    
    public class PrincipleRateTime {
    
        public static void main(String[] args) {
    
            // Create input object for taking input
            Scanner input = new Scanner(System.in);
    
            // Taking User Input
            System.out.print("Enter Principle amount : ");
            double principle = input.nextDouble();
    
            System.out.print("Enter Rate : ");
            double rate = input.nextDouble();
    
            System.out.print("Enter Time : ");
            double time = input.nextDouble();
    
            // Using formula
            float simpleInterest = (float)(principle*rate*time)/100;
    
            // Writing the output on console
            System.out.println("\nSimple Interest : " + simpleInterest) ;
        }
    
    }
    ```
    
- Average Marks
    
    ```java
    package com.company;
    
    import java.util.Scanner;
    
    public class AverageMarks<marks> {
        public static void main(String[] args) {
    
        /*    Average Marks :
        Write a program to input a name(as a single character) and marks of three tests as m1, m2, and m3 of a student
        considering all the three marks have been given in integer format. Now, you need to calculate the average of the
        given marks and print it along with the name as mentioned in the output format section. All the test marks are in
        integers and hence calculate the average in integer as well. That is, you need to print the integer part of the
        average only and neglect the decimal part.
    
        Input format :
        Line 1 : Name(Single character)
        Line 2 : Marks scored in the 3 tests separated by single space.
        Output format :
        First line of output prints the name of the student.
        Second line of the output prints the average mark.
        Constraints
        Marks for each student lie in the range 0 to 100 (both inclusive)
        Sample Input 1 :
        A
        3 4 6
        Sample Output 1 :
        A
        4
        Sample Input 2 :
        T
        7 3 8
        Sample Output 2 :
        T
        6
        */
    
            // Creating object for input
            Scanner input = new Scanner(System.in);
    
            // Taking User Input : Name
            String tempName = input.nextLine();
            // If you use next() instead of this Word + Nextline will be in buffer, but next() will pick up only word, so
            // in buffer now next line is present. Next time when you will be using the nextLine() it will automatically quit
            // without getting input, but actually it has god output from buffer i.e. new line in buffer. So better to use
            // nextline()
    
            char name = tempName.trim().charAt(0);
    
            // Taking User Input : Marks
            String marksString = input.nextLine();
            String[] marks = marksString.trim().split("\\s");
    
            int m1 = Integer.parseInt(marks[0]);
            int m2 = Integer.parseInt(marks[1]);
            int m3 = Integer.parseInt(marks[2]);
    
            int avg = (int)(m1 + m2 + m3)/3;
    
            // Printing Out average
            System.out.println(name);
            System.out.println(avg);
        }
    }
    ```