# Lecture 4 - Conditionals Loops

## 1. Conditionals

> **Conditionals :  `if` `else if` `else`**
> 
- Based on the condition/event occurs the code we execute the code.
- `if` : Checks the given condition, if true then executes the code, if any other absolute `if` statement exists then, control will move there,
- `else if` :  If `if` condition doesn’t match then control flow moves to `else if` block, and just like `if` it executes.
- `else` : If None of the above condition matches then control moves to this section, and code executes without any condition.
- Example :
    
    ```java
    int salary = 25000;
    if ( salary > 20000){
    	salary = salary + 2000;
    }
    else if (salary > 10000){
    	salary = salary + 1000;
    }
    else{
    	salary = salary + 50;
    }
    ```
    

---

## 2. Loops

> **For loop**
> 
- Loops are used to perform repetitive tasks.
- `for` loop is used when we know how many times the loop will run.
- Example :
    
    ```java
    // Table of 10
    
    for (int i=1; i<11; i++){
    	System.out.println(10*i);
    }
    ```
    

> **While loop**
> 
- `while` loop works on condition, if we don’t know repetitions then we can use `while` loop.
- Example :
    
    ```java
    // Until use enter's 'Q' take input
    Scanner input = new Scanner(System.in);
    String word = input.nextLine();
    
    String wordList = "";
    
    while(!Objects.equals(word, "Q")){
    		wordList = wordList + word + ", ";
        word = input.nextLine();
    }
    System.out.println(wordList);
    ```
    

> **Do while Loop**
> 
- Do while is used where, I want to execute our code at-least ones. For first time there is no condition, but from now onwards it will start  checking the condition, and based on that output will differ.
- Example :
    
    ```java
    // Take input atleast ones
    Scanner input = new Scanner(System.in);
    String wordList = "";
    String word;
    
    do {
    	word = input.nextLine();
    	wordList = wordList + word;
    } while (!Objects.equals(word, "Q"));
            
    System.out.println(wordList);
    ```
    

> **For each loop**
> 
- It will run for each item in iterable.
- Example :
    
    ```java
    String[] wordList = {"Hello", "How", "Are", "You" };
    
    for (String word: wordList){
    	System.out.println(word);
    }
    ```
    

---

## 3. Switch Case

> **Use**
> 

In switch cases you can jump on different cases and print case output, in very simple way.

> **Syntax**
> 

```java
switch(expression){
	// cases
	case one:
		// do something
		break;
	case two:
		// do something
		break;
	default:
		// DO THIS
		break;
}
```

> **Notes**
> 
- Expression can be anything variable, actual expression but case value must of same type.
- Break statement used to break flow, if we don’t add it will print all other cases until he get `break;`
- Default case is used if any one of above don’t match.
- Duplicate cases are not allowed.
- For default case `break;` statement is optional (May or may not use)

> **Enhanced Syntax**
> 

```java
switch(expression){
	case one -> // do this;
	case one -> // do this;
	case one -> // do this;
	case default -> // do this;
}
// For this syntax automatic break statement is applied for all cases.
```

> **Nested Switch case**
> 

```java
String college = "SKNCOE";
String dept = "IT"

switch(expression){
	case "SCOE":
		System.out.println("Sinhhad's College of Engineering");
		break;
	case "SKNCOE":
		switch(dept):
			case "CS":
				System.out.println("Computer Science");
				break;
			case "IT":
				System.out.println("Internet Technology");
				break;
			case "ENTC":
				System.out.println("Electronics and telecommunications")
				break;
	case "NBN":
		System.out.println("NBN - don't know FF");
	case "RMD":
		System.out.println("RMD -  So long and also I am bored");
	case default:
		System.out.println("Go to Google and search by yourself, f*cking Idiot");
}
```

---

## 4. Practise Examples

- Calculator Program
    
    ```java
    package com.company;
    
    import java.util.Scanner;
    
    public class CalculatorProgram {
        public static void main(String[] args) {
    
            // Create scanner object for input
            Scanner input = new Scanner(System.in);
    
            // Take user input
            System.out.print("Enter Operation type : ");
            char op = input.next().trim().charAt(0);
            if ((op == '+') || op == '-' || op == '*' || op == '/' || op == '^' || op == '%'){
                System.out.print("Enter Num 1 : ");
                int num1 = input.nextInt();
                System.out.print("Enter Num 2 : ");
                int num2 = input.nextInt();
    
                if (op == '+') System.out.println("Addition : " + sum(num1, num2));
                else if (op == '-') System.out.println("Subtraction : " + sub(num1, num2));
                else if (op == '*') System.out.println("Multiplication : " + mul(num1, num2));
                else if (op == '/') System.out.println("Division : " + div(num1, num2));
                else if (op == '%') System.out.println("Remainder : " + rem(num1, num2));
            }
            else{
                System.out.println("Enter valid operation !");
            }
        }
    
        private static int sum(int num1, int num2) {
            return num1+num2;
        }
        private static int sub(int num1, int num2) {
            return num1-num2;
        }
        private static int mul(int num1, int num2) {
            return num1*num2;
        }
        private static int div(int num1, int num2) {
            return num1/num2;
        }
        private static int rem(int num1, int num2) {
            return num1%num2;
        }
    }
    ```
    
- Reverse Number
    
    ```java
    package com.company;
    
    import java.util.Scanner;
    
    public class ReverseNumber {
        public static void main(String[] args) {
    
            // Create object of scanner to take input
            Scanner input = new Scanner(System.in);
    
            // Take user input
            System.out.print("Enter the number : ");
            int number = input.nextInt();
    
            // Calculate reverse
            int reverseNumber = 0;
            while (number != 0){
                reverseNumber = reverseNumber*10 + number%10;
                number = number/10;
            }
    
            System.out.print("Reverse Number : " + reverseNumber);
        }
    }
    ```
    
- Number Counting Occurrence
    
    ```java
    package com.company;
    
    import java.util.Scanner;
    
    public class NumberCountingOccurrence {
        public static void main(String[] args) {
    
            // Create scanner object to take input
            Scanner input = new Scanner(System.in);
    
            // Take user input
            System.out.print("Enter Number : ");
            int number = input.nextInt();
            System.out.print("Check for : ");
            int checkFor = input.nextInt();
    
            // Calculating the occurrences
            // Algo  :
            //      1. Divide the number
            //      2. Get remainder and check condition
            //      3. Update number
    
            int count = 0;
            while (number != 0){
                if ( number%10 == checkFor ) count++;
                number = number/10;
            }
    
            // Printing out results
            System.out.printf("Occurrence of %d is %d times in given number", checkFor, count);
    
        }
    }
    ```
    
- Fibonacci Number
    
    ```java
    package com.company;
    
    import java.util.Scanner;
    
    public class FibonacciNumber {
        public static void main(String[] args) {
    
            // Create scanner object to take input
            Scanner input = new Scanner(System.in);
    
            // Take user input
            System.out.print("Enter number : ");
            int number = input.nextInt();
    
            // Calculate Fibonacci
            int prev = 0;
            int curr = 1;
            int fibonacciNumber;
    
            for (int i = 0; i < number; i++) {
                fibonacciNumber = prev;
                prev = curr;
                curr = curr + fibonacciNumber;
    
                System.out.print(fibonacciNumber + " ");
            }
    
        }
    }
    ```
    
- Alphabet Check
    
    ```java
    package com.company;
    
    import java.util.Scanner;
    
    public class AlphabetCaseCheck {
        public static void main(String[] args) {
    
            // Create Scanner object to take input
            Scanner input = new Scanner(System.in);
    
            // Taking user input
            String word = input.next();
            char alpha = word.charAt(0);
    
            // Checking using conditionals
            if( alpha >= 'a' && alpha <= 'z'){
                System.out.println("Lowercase");
            }
            else if ( alpha >= 'A' && alpha <= 'Z'){
                System.out.println("Uppercase");
            }
            else{
                System.out.println("Neither Uppercase or Lowercase");
            }
        }
    }
    ```
    
- Largest of Three
    
    ```java
    package com.company;
    
    import java.util.Scanner;
    
    public class LargestOfThree {
        public static void main(String[] args) {
    
            // Create input object for taking input
            Scanner input = new Scanner(System.in);
    
            // Take user input
            System.out.print("Enter num1 : ");
            int num1 = input.nextInt();
            System.out.print("Enter num2 : ");
            int num2 = input.nextInt();
            System.out.print("Enter num3 : ");
            int num3 = input.nextInt();
    
            int largest = num1;
            if (num2 >= largest){
                largest = num2;
            }
            if (num3 >= largest){
                largest = num3;
            }
    
            // Print out the output
            System.out.println("Largest number : " + largest);
        }
    }
    ```
    
- Fruits case
    
    ```java
    String fruit = "Apple";
    
    switch(fruit){
    	case "Mango":
    		System.out.println("King of fruits");
    		break;
    	case "Apple":
    		System.out.println("Sweet red fruit");
    		break;
    	case "Orange":
    		System.out.println("Round Fruit");
    		break;
    	case "Grapes":
    		System.out.println("Small fruit");
    		break;
    	case default:
    		System.out.println("Enter the valid fruit");
    }
    ```
    
- Weekend and Weekdays
    
    ```java
    int day = 5;
    
    // Instead of writing each time "sout" you can write for last one, for all above will
    // fall in 5th case then print & break.
    switch(day):
    	case 1:
    	case 2:
    	case 3:
    	case 4:
    	case 5:
    		System.out.println("Weekday");
    		// more lines
    		break;
    	case 6:
    	case 7:
    		System.out.println("Weekend");
    		break;
    
    // Enhanced version
    switch(day):
    	case 1,2,3,4,5 -> System.out.println("Weekday");
    	case 6,7 -> System.out.println("Weekend");
    ```
    
- Days and Numbers
    
    ```java
    int day = 3;
    switch(day){
    	case 1 -> System.out.println("Monday");
    	case 2 -> System.out.println("Tuesday");
    	case 3 -> System.out.println("Wednesday");
    	case 4 -> {
    			System.out.println("Thursday");
    			// more lines
    	}
    	case 5 -> System.out.println("Friday");
    	case 6 -> System.out.println("Saturday");
    	case 7 -> System.out.println("Sunday");
    }
    ```