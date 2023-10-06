// import java.util.*;

// public class IncreasingSubsequences{
//     // [1,2,3]

//     public List<List<Integer>> getIncreasingSubsequences(int[] arr){
//         List<List<Integer>> answer = new ArrayList<>();
//         findIncreasingSubsequences(arr, answer, new ArrayList<Integer>(), 0, true);
//         return answer;
//     }

//     public void findIncreasingSubsequences(int[] arr, List<List<Integer>> answer, ArrayList<Integer> output, int curr, boolean isIncreasing){

//         // Base case
//         if (curr == arr.length){
//             if (isIncreasing) answer.add(new ArrayList<Integer>(output));
//             return;
//         }

//         // Insert 
//         boolean increasing = true;
//         if (!output.isEmpty() && output.get(output.size()-1) >= arr[curr]) increasing = false;


//         output.add(arr[curr]);
//         findIncreasingSubsequences(arr, answer, output, curr+1, increasing && isIncreasing);
//         output.remove(output.size() - 1);
//         findIncreasingSubsequences(arr, answer, output, curr+1, isIncreasing);

//     }

//     public static void main(String[] args){
//         IncreasingSubsequences is = new IncreasingSubsequences();
//         int[] arr = {5,1};
//         System.out.println(is.getIncreasingSubsequences(arr));
//     }
// }


// import java.util.*;

// public class IncreasingSubsequences{
//     // [1,2,3]

//     public List<List<Integer>> getIncreasingSubsequences(int[] arr){
//         List<List<Integer>> answer = new ArrayList<>();
//         findIncreasingSubsequences(arr, answer, new ArrayList<Integer>(), 0, true);
//         return answer;
//     }

//     public void findIncreasingSubsequences(int[] arr, List<List<Integer>> answer, ArrayList<Integer> output, int curr, boolean isIncreasing){

//         // Base case
//         if (curr == arr.length){
//             if (isIncreasing) answer.add(new ArrayList<Integer>(output));
//             return;
//         }

//         // Insert 
//         boolean increasing = true;
//         if (!output.isEmpty() && output.get(output.size()-1) >= arr[curr]) increasing = false;

//         if (isIncreasing && increasing){
//             output.add(arr[curr]);
//             findIncreasingSubsequences(arr, answer, output, curr+1, increasing && isIncreasing);
//             output.remove(output.size() - 1);
//         }

//         findIncreasingSubsequences(arr, answer, output, curr+1, isIncreasing);

//     }

//     public static void main(String[] args){
//         IncreasingSubsequences is = new IncreasingSubsequences();
//         int[] arr = {5,1};
//         System.out.println(is.getIncreasingSubsequences(arr));
//     }
// }

import java.util.*;

public class IncreasingSubsequences{
    // [1,2,3]

    public List<List<Integer>> getIncreasingSubsequences(int[] arr){
        return findIncreasingSubsequences(arr, null, 0, true);

    }

    public void findIncreasingSubsequences(int[] arr, Integer null, int curr, boolean isIncreasing){

        // Base case
        if (curr == arr.length){
            if (isIncreasing) return 1;
        }

        // Insert 
        boolean increasing = true;
        if (!output.isEmpty() && output.get(output.size()-1) >= arr[curr]) increasing = false;

        if (isIncreasing && increasing){
            output.add(arr[curr]);
            findIncreasingSubsequences(arr, answer, output, curr+1, increasing && isIncreasing);
            output.remove(output.size() - 1);
        }
        
        findIncreasingSubsequences(arr, answer, output, curr+1, isIncreasing);

    }

    public static void main(String[] args){
        IncreasingSubsequences is = new IncreasingSubsequences();
        int[] arr = {5,1};
        System.out.println(is.getIncreasingSubsequences(arr));
    }
}