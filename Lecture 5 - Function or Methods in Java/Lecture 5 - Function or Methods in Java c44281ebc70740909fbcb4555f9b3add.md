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

Scoping defines the scope of the variable, means which variable can accessed from which location/position/scope. There are three types of scopes available in JAVA 

1. Class Level
2. Method Level
3. Block Level

> **Class Level Scope**
> 
- Any variables declared on the class level can be accessed within class and methods anywhere.
- While these variables may be accessed outside of class depending on scope of variable like public, private, protected.
- Ex.
    
    ```java
    class Car{
    		public String color;
    		private int price;
    
    		public Car(String color, int price){
    			this.color = color;
    			this.price = price;
    		}
    }
    
    public class Demo{
    		Car car1 = new Car('red',150000);
    		System.out.println(car1.color);    // You can print
    		System.out.println(car1.price);    // Error : private variable
    }
    ```
    

> **Method Scope in Java**
> 
- Variables declared inside a method can be accessed only within method or functions.
- Ex.
    
    ```java
    public class Demo{
    	public static void main(String[] args){
    		int a = 5;
    		int b = 10
    	}
    	System.out.println(a)   // You can't access this one
    	public static void main(String[] args){
    		System.out.println(a)   // Also You can't access this one
    	}
    }
    ```
    

> **Block Scope**
> 
- Variable declared outside can be modified from inside of the block scope but we cannot initialize new variable with same name inside a block.
- We can’t access variable initialized or created inside a block from outside. But we can create new one in our outside scope.
- For the other block like if, else if, else, while, for, foreach same condition are applied like these as they are blocks.
- Ex.
    
    ```java
    public class Demo{
    	public static void main(String[] args){
    		int a = 5;
    		
    		{
    			int b = 10;  // you can 
    			a  = 20      // you can
    		}
    		System.out.println(b)  // you can't
    		System.out.println(a)  // 20
    	}
    }
    ```
    

---

## 4. Shadowing, Variable arguments and Method Overloading

> **Shadowing**
> 

Shadowing is the practise of using the variables with same name in a overlapping scopes where the variable with a low-scope variable overrides the high-scope variable.

Ex.

```java
class Demo{
		static int name = "Aditya";
		public static void main(String[] args){
				System.out.println(name);   // Aditya 
				int name = "Rohit";
				System.out.println(name);   // Rohit (Shadowing)
				// ( In this case low scope varaible overrides the high-scope variables )
		}
}
```

> **VAR-ARGS (Variable length arguments )**
> 
- `Var-args` is the method of passing the variable length arguments to the function.
- `var-ags` parameter should be the last parameter while passing.
- You can only pass values with same data type.
- Syntax and example
    
    ```java
    public static void main(String[] args){
    		int total = sum(1,2,3,4,5,6,7,8);
    }
    public static int sum(int ...nums){
    		int total = 0;
    		for (int i=0; i<nums.length(); i++){
    			total += nums[i];
    		}
    		return total;
    }
    ```
    

> **Overloading**
> 
- When you have function with the same name but different parameter for each function. Function may different number of parameters, can same number of parameters but order or data type must be different is called as function overloading.
- Used in printing on console by `System.out.println()` by Java.
- When empty string is passed then it will give an error.
- Ex.
    
    ```java
    public static void main(String[] args){
    		int[] nums = {1,2,3,4,5,6,7,8};
    		String[] names = {"Aditya","Ravi","Rohit","Aniket","Adi"};
    		printme(nums);    // Print list of numbers
    		printme(names);   // Print list of names
    }
    public static void printMe(String[] list){
    		System.out.println(Arrays.toString(list));  
    }
    public static void printMe(int[] list){
    		System.out.println(Arrays.toString(list)); 
    }
    ```
    

---

## 5. Questions

- KK - Assignments Status
    - [x]  [Define two methods to print the maximum and the minimum number respectively among three numbers entered by the user.](https://www.java67.com/2019/05/how-to-find-largest-and-smallest-of-three-numbers-in-java.html)
    - [x]  [Define a program to find out whether a given number is even or odd.](https://www.geeksforgeeks.org/java-program-to-check-if-a-given-integer-is-odd-or-even/)
    - [x]  [A person is eligible to vote if his/her age is greater than or equal to 18. Define a method to find out if he/she is eligible to vote.](https://www.efaculty.in/java-programs/voting-age-program-in-java/)
    - [x]  [Write a program to print the sum of two numbers entered by user by defining your own method.](https://code4coding.com/addition-of-two-numbers-in-java-using-method/)
    - [x]  [Define a method that returns the product of two numbers entered by user.](https://code4coding.com/java-program-to-multiply-two-numbers-using-method/)
    - [x]  [Write a program to print the circumference and area of a circle of radius entered by user by defining your own method.](https://beginnersbook.com/2014/01/java-program-to-calculate-area-and-circumference-of-circle/)
    - [x]  [Define a method to find out if a number is prime or not.](https://www.geeksforgeeks.org/java-program-to-check-if-a-number-is-prime-or-not/)
    - [x]  [Write a program that will ask the user to enter his/her marks (out of 100). Define a method that will display grades according to the marks entered as below:](https://www.techcrashcourse.com/2017/02/java-program-to-calculate-grade-of-students.html)
        
        ```
        
        Marks        Grade
        91-100         AA
        81-90          AB
        71-80          BB
        61-70          BC
        51-60          CD
        41-50          DD
        <=40          Fail
        ```
        
    - [x]  [Write a program to print the factorial of a number by defining a method named 'Factorial'.](https://www.javatpoint.com/factorial-program-in-java) Factorial of any number n is represented by n! and is equal to 1 * 2 * 3 * .... * (n-1) *n. E.g.
        
        ```
        4! = 1 * 2 * 3 * 4 = 24
        3! = 3 * 2 * 1 = 6
        2! = 2 * 1 = 2
        Also,
        1! = 1
        0! = 1
        ```
        
    - [x]  [Write a function to find if a number is a palindrome or not. Take number as parameter.](https://www.geeksforgeeks.org/check-if-a-number-is-palindrome/)
    - [x]  Convert the programs in [flow of program](https://github.com/kunal-kushwaha/DSA-Bootcamp-Java/blob/main/assignments/01-flow-of-program.md), [first java](https://github.com/kunal-kushwaha/DSA-Bootcamp-Java/blob/main/assignments/02-first-java.md), [conditionals & loops](https://github.com/kunal-kushwaha/DSA-Bootcamp-Java/blob/main/assignments/03-conditionals-loops.md) assignments into functions.
    - [x]  [Write a function to check if a given triplet is a Pythagorean triplet or not.](https://www.geeksforgeeks.org/find-pythagorean-triplet-in-an-unsorted-array/) (A Pythagorean triplet is when the sum of the square of two numbers is equal to the square of the third number).
    - [x]  [Write a function that returns all prime numbers between two given numbers.](https://www.geeksforgeeks.org/program-to-find-prime-numbers-between-given-interval/)
    - [x]  [Write a function that returns the sum of first n natural numbers.](https://www.geeksforgeeks.org/program-find-sum-first-n-natural-numbers/)
    
- Prime Numbers using functions
    
    ```java
    package com.company;
    
    public class PrimeNumbers {
        public static void main(String[] args) {
            System.out.println(isPrime(2));
        }
        public static boolean isPrime(int num){
            int divisor = 2;
            while (divisor*divisor <= num){
                if (num%divisor==0) return false;
                divisor++;
            }
            return true;
        }
    }
    ```
    
- Armstrong Number
    
    ```java
    package com.company;
    
    public class ArmstrongNumber {
        public static void main(String[] args) {
            for (int i = 0; i <10000; i++) {
                if (isArmstrongNumber3Digit(i)) System.out.println(i);
            }
        }
        public static int getNumOfDigits(int number){
            int digitCount = 0;
            while(number != 0){
                digitCount++;
                number = number/10;
            }
            return digitCount;
        }
        public static boolean isArmstrongNumber3Digit(int number){
            // Armstrong number : Sum of the digits powered to number of digit in numbers equal to number itself.
            int sum = 0;
            int tempNum = number;
            int digitCount = getNumOfDigits(number);
    
            while (tempNum != 0 ){
                sum = sum + (int)Math.pow(tempNum%10, digitCount);
                tempNum = tempNum/10;
            }
            return sum == number;
        }
    }
    ```
    
- All three digits of Armstrong numbers
    
    ```java
    package com.company;
    
    public class DigitsOfArmstrongNumber {
        public static void main(String[] args) {
            printDigitsOfArmstrongIfExists(370);
        }
    
        public static int getNumOfDigits(int number) {
            int digitCount = 0;
            while (number != 0) {
                digitCount++;
                number = number / 10;
            }
            return digitCount;
        }
    
        public static void printDigitsOfArmstrongIfExists(int number) {
            int digitCount = getNumOfDigits(number);
            int sum = 0;
            int copyOfInput = number;
            int secondCopyOfInput = number;
    
            while (copyOfInput != 0) {
                sum = sum + (int) Math.pow(copyOfInput % 10, digitCount);
                copyOfInput /= 10;
            }
            if (sum == number) {
                int copyOfDigitCount = digitCount;
                while (copyOfDigitCount > 0) {
                    int firstNum = (int) secondCopyOfInput / ((int) Math.pow(10, copyOfDigitCount - 1));
                    System.out.println(firstNum);
                    secondCopyOfInput = secondCopyOfInput - firstNum * (int) Math.pow(10, copyOfDigitCount - 1);
                    copyOfDigitCount--;
                }
            }
        }
    }
    ```
    
- Minimum and maximum of three using functions
    
    ```java
    // Problem: Write a Program to find the Maximum and Minimum of the Given Three Numbers.
    // Read more: https://www.java67.com/2019/05/how-to-find-largest-and-smallest-of-three-numbers-in-java.html#ixzz7twDvuQ2V
    package com.company;
    
    import java.util.Scanner;
    
    public class MaxMinOfThreeNumbers {
        public static void main(String[] args) {
    
            // Define the three numbers
            int num1;
            int num2;
            int num3;
    
            // Scanner object to take the input from the user.
            Scanner input = new Scanner(System.in);
            System.out.print("Enter number 1: ");
            num1 = input.nextInt();
            System.out.print("Enter number 2: ");
            num2 = input.nextInt();
            System.out.print("Enter number 3: ");
            num3 = input.nextInt();
    
            int maximum = maxOfThreeNums(num1,num2,num3);
            int minimum = minOfThreeNums(num1,num2,num3);
    
            System.out.printf("* Maximum of %d %d %d : %d \n", num1,num2,num3,maximum );
            System.out.printf("* Minimum of %d %d %d : %d \n", num1,num2,num3,minimum );
    
            // CLosing the scanner class
            input.close();
        }
    
        private static int maxOfThreeNums(int num1, int num2, int num3){
            int max = num1;
            if (num2 >= max) max = num2;
            if (num3 >= max) max = num3;
    
            return max;
        }
        private static int minOfThreeNums(int num1, int num2, int num3){
            int min = num1;
            if (num2 <= min) min = num2;
            if (num3 <= min) min = num3;
    
            return min;
        }
    }
    ```
    
- Check number is odd or even
    
    ```java
    package com.company;
    
    import java.util.Scanner;
    
    public class CheckOddOrEven {
        public static void main(String[] args) {
    
            // Scanner object to take input
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the number : ");
            int number = input.nextInt();
    
            // Calling the created function
            isEvenOrOdd(number);
    
            // Bitwise operations
            isEvenOrOddUsingBitwise(number);
    
            // LSB
            isEvenOrOddUsingLSB(number);
        }
    
        private static void isEvenOrOdd(int number){
            if (number%2 == 0){
                System.out.println("Number is even");
                return;
            }
            System.out.println("Number is odd");
        }
    
        private static void isEvenOrOddUsingBitwise(int number){
            // Using OR operation
            if ((number | 1) > number) System.out.println("Even Number (OR)");
            else if ((number | 1) == number ) System.out.println("Odd Number (OR)");
    
            // Using AND operation
            if ((number & 1) == 0) System.out.println("Even Number (AND)");
            else if ((number & 1) == 1) System.out.println("Odd Number (AND)");
    
            // Using XOR operation
            if ((number ^ 1) == number+1) System.out.println("Even Number (XOR)");
            else if ((number ^ 1) == number-1) System.out.println("Odd Number (XOR)");
        }
    
        private static void isEvenOrOddUsingLSB(int number){
            if (Integer.toBinaryString(number).endsWith("0")) {
                System.out.println("Number is even");
            }
            else if(Integer.toBinaryString(number).endsWith("1")){
                    System.out.println("Odd");
                }
            }
    }
    ```
    
- Eligible for vote or not
    
    ```java
    package com.company;
    
    import java.util.Scanner;
    
    public class CheckAdult {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter your age : ");
            int age = input.nextInt();
            boolean eligible = isEligibleOrNot(age);
            if (eligible) System.out.println("Eligible for vote");
            else System.out.println("Not eligible for vote");
        }
    
        public static boolean isEligibleOrNot(int age) {
            return age >= 18;
        }
    }
    ```
    
- Sum of two numbers using function
    
    ```java
    package com.company;
    
    import java.util.Scanner;
    
    public class SumOfTwoNumbers {
        public static void main(String[] args) {
            sumOfTwoNumbers();
        }
    
        private static void sumOfTwoNumbers() {
            Scanner input = new Scanner(System.in);
    
            System.out.println("Enter number 1 : ");
            int num1 = input.nextInt();
    
            System.out.println("Enter number 2 : ");
            int num2 = input.nextInt();
    
            int sum = num1 + num2;
            System.out.println("Sum of two numbers : " + sum);
        }
    }
    ```
    
- Product of two numbers
    
    ```java
    package com.company;
    
    public class ProductOfTwoNumberReturn {
        public static void main(String[] args) {
            int num1 = 10;
            int num2 = 20;
            
            int product = productOfTwoNumbers(num1,num2);         
        }
    
        private static int productOfTwoNumbers(int num1, int num2) {
            return num1*num2;
        }
    }
    ```
    
- Area and circumference of circle
    
    ```java
    package com.company;
    
    import java.util.Scanner;
    
    public class AreaCircumferenceOfCircle {
        public static void main(String[] args) {
            calculateAreaCircumferenceOfCircle();
        }
    
        private static void calculateAreaCircumferenceOfCircle() {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter Radius of circle : ");
            int radius = input.nextInt();
    
            double circumference = 2*Math.PI*radius;
            double area = Math.PI*Math.pow(radius,2);
    
            System.out.printf("Area : %f and Circumference : %f", area, circumference);
        }
    }
    ```
    
- Display the grades of the student
    
    ```java
    package com.company;
    
    import java.util.Scanner;
    
    public class FindGrades {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter your marks : ");
            int marks = input.nextInt();
            calculateGradesAndDisplay(marks);
        }
    
        private static void calculateGradesAndDisplay(int marks) {
            if (marks >= 91 && marks <= 100) System.out.println("AA");
            else if (marks >= 81 && marks <= 90) System.out.println("AB");
            else if (marks >= 71 && marks <= 80) System.out.println("BB");
            else if (marks >= 61 && marks <= 70) System.out.println("BC");
            else if (marks >= 51 && marks <= 60) System.out.println("CD");
            else if (marks >= 41 && marks <= 50) System.out.println("DD");
            else if (marks <= 40) System.out.println("Fail BC");
            else System.out.println("Marks cannot be negative !");
        }
    }
    ```
    
- Factorial of the number
    
    ```java
    package com.company;
    
    import java.util.Scanner;
    
    public class Factorial {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter your Number : ");
            int number = input.nextInt();
            long f = factorial(number);
            System.out.printf("Factorial of %d is %d", number, f);
        }
    
        private static long factorial(int number) {
            long factorial = 1;
            for (int i=1; i<=number; i++){
                factorial = factorial*i;
            }
            return factorial;
        }
    }
    ```
    
- Check number is palindrome
    
    ```java
    package com.company;
    
    import java.util.Scanner;
    
    public class CheckNumberPalindrome {
        public static void main(String[] args) {
    
            Scanner input = new Scanner(System.in);
            System.out.print("Enter your number : ");
            int number = input.nextInt();
    
            if (isPalindrome(number)) System.out.println("Number is palindrome");
            else System.out.println("Not palindrome");
        }
    
        private static int getNoOfDigits(int num){
            int count = 0;
            while(num > 0){
                count++;
                num = num/10;
            }
            return count;
        }
    
        private static int getReverse(int num){
            int digitCount = getNoOfDigits(num);
            int power = digitCount - 1;
    
            int reverse = 0;
            while(num > 0){
                reverse = reverse + (int)((num%10)*Math.pow(10,power));
                num = num/10;
                power--;
            }
    
            return reverse;
        }
    
        private static boolean isPalindrome(int num){
            int reverseNum = getReverse(num);
            return reverseNum == num;
        }
    }
    ```
    
- Check triplet is Pythagorean or not
    
    ```java
    package com.company;
    
    public class PythagoreanTriplet {
        public static void main(String[] args) {
            if (isPythagoreanTriplet(3,4,7)) System.out.println("This is pythagorean triplet");
            else System.out.println("Not pythagorean triplet");
        }
    
        private static int getMax(int num1,int num2, int num3){
            int max = num1;
            if (max < num2) max = num2;
            if (max < num3) max = num3;
            return max;
        }
    
        private static boolean isPythagoreanTriplet(int num1, int num2, int num3){
            int max = getMax(num1, num2, num3);
            if (num1 == max){
                return (num2*num2 + num3*num3 == num1*num1);
            }
            else if (num2 == max){
                return (num1*num1 + num3*num3 == num2*num2);
            }
            else {
                return (num2*num2 + num1*num1 == num3*num3);
            }
        }
    }
    ```
    
- Sum of n natural numbers
    
    ```java
    package com.company;
    
    public class SumOfNNaturalNumbers {
        public static void main(String[] args) {
            int num = 12;
            int sum = sumOfNaturalNumbers(num);
            System.out.println(sum);
        }
    
        private static int sumOfNaturalNumbers(int num) {
            int sum = 0;
            for (int i = 1; i <=num; i++) {
                sum += i;
            }
            return sum;
        }
    }
    ```
    

---