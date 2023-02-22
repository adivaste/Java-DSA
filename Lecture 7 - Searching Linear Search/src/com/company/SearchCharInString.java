package com.company;

public class SearchCharInString {
    public static void main(String[] args) {
        System.out.println(searchChar("Aditya", 'a'));
        System.out.println(searchChar2("Aditya", 'a'));
    }

    private static boolean searchChar2(String word, char target) {
        if (word.length() == 0) return false;

        for (char letter : word.toCharArray()){
            if(letter == target) return true;
        }

        return false;
    }

    private static boolean searchChar(String word, char target){
        // If string length is 0 then return false
        if (word.length() == 0) return false;

        // Iterate over the Word and search for it
        for (int idx = 0; idx < word.length(); idx++) {
            if (word.charAt(idx) == target) return true;
        }

        // If char not found
        return false;
    }


}
