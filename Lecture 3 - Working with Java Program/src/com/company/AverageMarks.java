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
