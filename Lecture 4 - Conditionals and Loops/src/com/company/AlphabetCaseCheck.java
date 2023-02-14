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
