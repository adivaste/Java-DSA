# Lecture 17 - Maths for DSA | Bitwise Operators & Number System

<aside>
💎 Don’t take the learning’s as it is, please verify it, do check from another concepts with it from various resources.

</aside>

## 1. Bitwise Operators

> **What is meant by bitwise operators**
> 
- Normal operators which we call as decimal operator ( +, -, *, / ) they perform operation on decimal numbers.
- Just like a decimal operators bitwise operators are used to perform operation on binary numbers.
- Ex. Bitwise Operators
    - `&`  ⇒ AND
    - `|`  ⇒ OR
    - `^`  ⇒ XOR
    - `~` ⇒ NOT
    - `>>`  ⇒ Right Shift
    - `<<`  ⇒ Left Shift

> **”AND” Operator**
> 
- AND operator is used to perform logical AND operation on bits
- Number and result :
    
    
    | A | B | Result |
    | --- | --- | --- |
    | 0 | 0 | 0 |
    | 0 | 1 | 0 |
    | 1 | 0 | 0 |
    | 1 | 1 | 1 |
- Facts and Conclusions :
    - Any of the number is false “0” then result is false “0”
    - Both numbers are true “1” then and then only result is true “1”
    - When we do AND “1” with any decimal number, we get the last bit of number.
    - When we do AND “0” with any decimal number, the number becomes zero.

> **”OR” Operator**
> 
- AND operator is used to perform logical OR operation on bits
- Number and result :
    
    
    | A | B | Result |
    | --- | --- | --- |
    | 0 | 0 | 0 |
    | 0 | 1 | 1 |
    | 1 | 0 | 1 |
    | 1 | 1 | 1 |
- Facts and Conclusions :
    - Any of the number is true “1” then result is true “1”
    - Both numbers are false “0” then and then only result is false “0”
    - When we do OR “1” with any decimal number, then last bit get changed to 1
    - When we do AND “0” with any decimal number, the number remains same.

> **”XOR” Operator**
> 
- XOR operator is used to perform logical XOR operation on bits, if numbers are same then output is 0, else output is 1.
- Number and result :
    
    
    | A | B | Result |
    | --- | --- | --- |
    | 0 | 0 | 0 |
    | 0 | 1 | 1 |
    | 1 | 0 | 1 |
    | 1 | 1 | 0 |
- Facts and Conclusions :
    - If both number are same then “0” is answer, else “1”
    - You can use it to check given numbers are same or not.
    - `1^(any bit) = Compliment of that bit`
    - `0^(any number) = Bit Itself`
    - XOR follows Associative property where 3^4^5^6 = 4^3^6^5 just like normal operators.
    

> **”NOT” Operator**
> 
- Not Operator is denoted by the `~`
- It flips all the bits in the number, output can be decided as if number is positive the output is must to be negative, as first bit get flipped, and for the remaining bits, we find 2’s compliment.

> **“<<” Left Shift Operator**
> 
- This left shift operator is used to shift the all bits of number to right by `n`
- For positive number padding is 0 and for negative numbers padding is decided by compiler.
- Ex.  `10101001 << 1 = 101010010`
- Facts and Conclusions :
    - If any number left shift “1” it will just double that number. Ex. `10 << 1 = 20`
    - Ex. `x << n = x*2^n`
    - Can be used to find the duplicate numbers and odd numbers from even ones.
    - Used to make number double in case of small number’s but for large number’s it can make negative number
        
        Ex. `01100011` after making left shift by 1 number becomes `11000110` which is negative number as first bit is one.
        

> **“>>” Right Shift Operator**
> 
- This right shift operator is used to shift the all bits of number to right by `n`
- New number come on left side is `0`
- Ex.  `10101001 >> 1 = 01010100`
- Facts and Conclusions :
    - If we right shift number by 1 number get divided by 2.

## 2. Identifying and Solving the bitwise problems

- Repetition of the numbers
- Find the binary of the numbers, check what are the similarities between them and how can I remove them, How do I differentiate them. Suppose any repetition question is there, you will be thinking of XOR, that correct, when multiple repetitions are there then you can make something divide, think always like an aggregate in terms of bitwise questions.
- Make something collective in solutions, and play with bits of all numbers. Start finding out the difference between given question and removing the actual problem data from question input itself.

> **Solving**
> 
- First understand the thing, like “what is number which power of two”
- How, when, what, where, ask this questions to that number here you will get idea or logic, now try with “non - power of two” number find its properties, ask the questions to him.