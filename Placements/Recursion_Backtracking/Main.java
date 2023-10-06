// === Recursion and Backtracking ===

// 1. Find all the subsequences of the array

import java.util.*;

public class FindAllSubsequence{

    private List<List<Integer>> getAllSubsequence(int[] arr){
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        findAllSubsequence(arr, answer, new ArrayList<Integer>(), 0);
        return answer;
    }

    private void findAllSubsequence(int[] arr, List<List<Integer>> answer, List<Integer> output, int curr){
        // Base condition
        if (curr == arr.length){
            answer.add(new ArrayList<>(output));
            return;
        }

        // Insert the current element
        output.add(arr[curr]);
        findAllSubsequence(arr, answer, output, curr+1);

        // Skip the current one
        output.remove(output.size() - 1);
        findAllSubsequence(arr, answer, output, curr+1);
    }

    public static void main(String[] args){
        FindAllSubsequence fas = new FindAllSubsequence();
        int[] arr = {1, 2, 3};
        List<List<Integer>> result = fas.getAllSubsequence(arr);
        System.out.println(result);
    }
}

/// -----------------------------------------------------------------

// 2. Find all the subsequences of the string

import java.util.*;
import java.util.ArrayList;

public class FindAllSubsequenceString {

    public List<String> getAllSubsequenceString(String str) {
        List<String> answer = new ArrayList<String>();
        findAllSubsequenceString(str, answer, new StringBuilder(), 0);
        return answer;
    }

    private void findAllSubsequenceString(String str, List<String> answer, StringBuilder output, int curr) {
        // Base case
        if (curr == str.length()) {
            if (output.toString().equals("")) answer.add("{}");
            else answer.add(output.toString());
            return;
        }

        // Insert into string
        output.append(str.charAt(curr));
        findAllSubsequenceString(str, answer, output, curr+1);

        // Skip current character
        output.deleteCharAt(output.length() - 1);
        findAllSubsequenceString(str, answer, output, curr+1);
    }

    public static void main(String[] args) {
        FindAllSubsequenceString fas = new FindAllSubsequenceString();
        String str = "Adi";
        List<String> result = fas.getAllSubsequenceString(str);
        System.out.println(result);
    }
}

// ------------------------------------------------------------------

// 3.Count all the subsequence of the String

import java.lang.StringBuilder;
import java.lang.String;
import java.List;
import java.ArrayList;

public class FindCountOfSubsequences{

    private int findCountOfSubsequences(String str){
        List<String> answer = new List<String>();
        return getCountOfSubsequences(str, answer, new StringBuilder(), 0);
    }

    private int getCountOfSubsequences(String str, List<String> answer, StringBuilder output, int curr){
        // Base case
        if (curr == str.length()){
            answer.add(output.toString());
            return 1;
        }

        // Insert current character
        output.add(str.charAt(curr));
        int left = getCountOfSubsequences(str, answer, output, curr + 1);

        // Skip current character
        output.remove(output.length() - 1);
        int right = getCountOfSubsequences(str, answer, output, curr + 1);

        return left+right;
    }

    public static void main(String[] args){
        
    }
}

// ------------------------------------------------------------------

// 4. Find the maximum sum of the subsequence 

public class MaxSumSubsequence{

    public int getMaxSumSubsequence(int[] arr){
        return findMaxSumSubsequence(int[], 0, 0);
    }

    public int findMaxSumSubsequence(int[] arr, int curr, int sum){

        // Base case
        if (curr == arr.length){
            return sum;
        }

        // Insert to sum
        int left = findMaxSumSubsequence(arr, curr+1, sum + arr[curr]);
        int right = findMaxSumSubsequence(arr, curr+1, sum );

        return Math.max(left, right);
    }

    public static void main(String[] args){
        MaxSumSubsequence ms = new MaxSumSubsequence();
        int[] arr = {1, -2, 3, 4, -1};
        int max = ms.getMaxSumSubsequence(arr);
        System.out.println(max);
    }
}





