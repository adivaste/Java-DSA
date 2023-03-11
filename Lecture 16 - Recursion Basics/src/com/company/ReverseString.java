package com.company;

public class ReverseString {
    public static void main(String[] args) {

        // Reverse string 1
        String word = "Aditya";
        String reverseWord = "";
        int len = word.length();
        System.out.println(reverseString(word, reverseWord, len-1));

        // Reverse string 2
        String string2 = "Aditya Vaste";
        reverseString2(string2, string2.length()-1);

        // Reverse string 3
        String string3 = "Ch*tiya Dhawal";
        System.out.println();
        System.out.println(reverseString3(string3));

        String string4 = "Chutiya Dhawal";
        System.out.println(reverseString4(string4));

    }

    // Storing the string
    private static String reverseString(String word, String reverseWord, int idx){
        if (idx < 0) return reverseWord;
        reverseWord = reverseWord+word.charAt(idx);
        return reverseString(word,reverseWord,idx-1);
    }

    // Just printing it
    private static void reverseString2(String word, int idx){
        if (idx < 0) return;
        System.out.print(word.charAt(idx));
        reverseString2(word,idx-1);
    }

    // Without creating the variable
    private static String reverseString3(String str){
        if (str.isEmpty()) return str;
        return str.charAt(str.length()-1) + reverseString3(str.substring(0,str.length()-1));
    }

    // Without creating the variable
    private static String reverseString4(String str){
        if (str.isEmpty()) return str;
        return reverseString4(str.substring(1)) + str.charAt(0);
    }
}
