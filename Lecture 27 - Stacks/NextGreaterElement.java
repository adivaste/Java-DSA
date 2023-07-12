import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;
import java.util.Arrays;

public class NextGreaterElement{
    
    public static ArrayList<Integer> nge1(int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            int max = maximum(arr, i, arr.length-1);
            if (max > arr[i]) answer.add(max);
            else { answer.add(-1);}
        }
        return answer;
    }

    public static ArrayList<Integer> nge2(int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        s.push(arr[arr.length-1]);
        answer.add(-1);

        for(int i=arr.length-2; i>=0; i--){
            
                while(s.size() > 0 && arr[i] >= s.peek()){
                    s.pop();
                }
                if (s.size() == 0) answer.add(-1);
                else{
                    answer.add(s.peek());
                }
                s.push(arr[i]);
        }
        Collections.reverse(answer);
        return answer;
    }

    public static int maximum(int[] arr,int startIndex, int endIndex){
        int max = arr[startIndex];
        for (int i=startIndex; i<=endIndex; i++){
            if (arr[i] > max) {
                max = arr[i]; 
                return max;
            }
        }
        return max;
    }
    
    public static int[] nge3(int[] arr){
        Stack<Integer> s = new Stack<>();
        int[] answer = new int[arr.length];

        s.push(0);
        for(int i=1; i<arr.length; i++){
            while( s.size() > 0 && arr[s.peek()] < arr[i]){
                int top = s.pop();
                answer[top] = arr[i];
            }
            s.push(i);
        }
        while(!s.empty()){
            int top = s.pop();
            answer[top] = -1;
        }
        return answer;
    }

    public static void main(String[] args){
        int[] arr = {2,5,9,3,1,12,6,8,7};
        ArrayList<Integer> a1 = nge2(arr);
        System.out.println(a1.toString());

        int[] ans = nge3(arr);
        System.out.println(Arrays.toString(ans));
    }

}
