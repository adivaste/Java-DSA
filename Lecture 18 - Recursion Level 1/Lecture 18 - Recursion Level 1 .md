# Lecture 18 - Recursion | Level 1

<aside>
💎 Keep the video speed as 1x

</aside>

## Questions

- Numbers from N to 1
    
    ```java
    package com.company;
    
    public class Main {
    
        public static void main(String[] args) {
            int num = 10;
            printNumbers(num);
        }
    
        private static void printNumbers(int num){
            // Base condition
            if (num == 0) return;
    
            // Printing
            System.out.println(num);
    
            // Calling the recursive function
            printNumbers(num-1);
        }
    }
    
    ```
    
- Numbers from 1 to N
    
    ```java
    package com.company;
    
    public class OneToN {
        public static void main(String[] args) {
            int num = 6;
            printOneToN2(num);
        }
    
        private static void printOneToN(int num, int curr){
            if (curr > num) return;
    
            System.out.println(curr);
            printOneToN(num, curr+1);
        }
    
        private static void printOneToN2(int num){
            if (num == 0) return;
    
            printOneToN2(num-1);
            System.out.println(num);
        }
    }
    ```
    
- Both Way Printing for numbers
    - Space complexity  : O(n)
    - Time complexity  : O(n)
    
    ```java
    package com.company;
    
    public class BothWayNumberPrinting {
        public static void main(String[] args) {
            int num = 5;
            bothWayNumberPrinting(num);
        }
    
        private static void bothWayNumberPrinting(int num){
            if (num == 0) return;
    
            System.out.println(num);
            bothWayNumberPrinting(num-1);
            System.out.println(num);
        }
    }
    ```
    
- Factorial of numbers
    
    ```java
    package com.company;
    
    public class FactorialUsingRecursion {
        public static void main(String[] args) {
            int num = 6;
            System.out.println(factorialUsingRecursion(num));
        }
        private static int factorialUsingRecursion(int n){
            if (n <= 1) return 1;
            return n*factorialUsingRecursion(n-1);
        }
    }
    ```
    
- Sum of number up to N
    
    ```java
    package com.company;
    
    public class SumOfNNumbersUsingRecursion {
        public static void main(String[] args) {
            int num = 12;
            System.out.println(sumOfNNumbersUsingRecursion(num));
        }
    
        private static int sumOfNNumbersUsingRecursion(int num){
            if (num <= 1) return num;
            return num + sumOfNNumbersUsingRecursion(num-1);
        }
    }
    ```
    
- Sum of Digits
    - Time complexity O(log(n))
    - Space complexity O(log(n))
    
    ( Because the number of digits are equal to log(N) where N is the number )
    
    ```java
    package com.company;
    
    public class SumOfDigits {
        public static void main(String[] args) {
            int num = 10;
            int sum = 0;
            System.out.println(sumOfDigits(num,sum));
        }
    
        private static int sumOfDigits(int num, int sum){
            if (num == 0) return 0;
    
            int lastDigit = num%10;
            return lastDigit + sumOfDigits(num/10, sum);
        }
    }
    ```
    
- Concept
    
    ```java
    package com.company;
    
    public class Concept {
        public static void main(String[] args) {
            int num = 5;
            fun(num);
        }
    
        // Stack overflow : First calling then subtraction [Wrong Way]
        private static void fun(int num){
            if (num == 0) return;
            System.out.println(num);
            fun(num--);
        }
    
        // Correct way : First subtraction is done then calling
        private static void fun2(int num){
            if (num == 0) return;
            System.out.println(num);
            fun(--num);
        }
    }
    
    ```
    
- Reverse the Number
    
    ```java
    package com.company;
    
    public class ReverseNumberUsingRecursion {
        public static void main(String[] args) {
            int num = 8967;
            System.out.println(reverseNumberUsingRecursion2(num));
        }
    
        // Here we are updating our number each time in call, one number is getting divided in each
        // call, we are getting a last digit and adding it to 10th multiple of existing reverseNumber
        // so that each time number is increased in power of ten and single number is added to it.
        private static int reverseNumberUsingRecursion(int num, int reverseNum){
            // Return 0 when num is zero, as we are dividing each time.
            if (num == 0) return reverseNum;
    
            // ReverseNum will be updated with 10*reverseNumber and last digit of current number
            reverseNum = reverseNum*10 + num%10;
    
            // Passing the updated values of Number and Reverse Number
            return reverseNumberUsingRecursion(num/10, reverseNum);
        }
    
        private static int reverseNumberUsingRecursion2(int num){
            // Using the log10 to find the (number_of_digits-1) log(1000) = 3 which is the powered
            // with 10 each time
            int power = (int)Math.log10(num);
    
            return helper(num, power);
        }
    
        // Helper function to help original one
        private static int helper(int num, int power){
            if (num%10 == num) return num;
            return (num%10)*(int)Math.pow(10, power) + helper(num/10, power-1);
        }
    }
    ```
    
- Palindrome Number
    
    ```java
    package com.company;
    
    public class Palindrome {
        public static void main(String[] args) {
            int num = 1213;
            System.out.println(isPalindrome(num));
        }
        private static boolean isPalindrome(int num){
            int power = (int)Math.log10(num);
            int reverseNumber =  helper(num, power);
            return (reverseNumber == num);
        }
    
        // Helper function to help original one
        private static int helper(int num, int power){
            if (num%10 == num) return num;
            return (num%10)*(int)Math.pow(10, power) + helper(num/10, power-1);
        }
    }
    ```
    
- Count Number Of Zeros
    
    ```java
    package com.company;
    
    public class CountNumberOfZeros {
        public static void main(String[] args) {
            int num = 1100;
            System.out.println(countZeros(num));
        }
    
        private static int countZeros(int num) {
            if (num == 0) return 1;
            return helper(num, 0);
        }
    
        private static int helper(int number, int zeros){
            if (number == 0) return zeros;
            if (number%10 == 0) zeros++;
    
            return helper(number/10, zeros);
        }
    }
    ```
    
- Number of steps to reduce to Zero
    
    ```java
    package com.company;
    
    public class NumberOfStepsToReduceToZero {
        public static void main(String[] args) {
            int num = 123;
            System.out.println(numberOfStepsToReduceToZero(num, 0));
        }
    
        // Simple counting the steps per each call.
        private static int numberOfStepsToReduceToZero(int num, int steps){
            if (num == 0) return steps;
            if((num&1) == 0) return numberOfStepsToReduceToZero(num/2,++steps);
            else return numberOfStepsToReduceToZero(num-1,++steps);
        }
    }
    ```