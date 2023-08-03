// Q.1) 2 Sum problem, array is unsorted, return single and only pair

class ArraySpace{
    
    // :: A1 - Brutforce
    public int[] brutforce(int[] arr, int target){

        int size = arr.length;

        for(int  i=0; i<size; i++){
            for(int j=i+1; j<size; j++){
                int sum = arr[i] + arr[j];
                if (sum ==  target) return new int[]{i, j};
            }
        }

        return new int[]{-1, -1};
    }

    // :: A2 : Optimal (Using Hashmap)
    public int[] optimal(int[] arr, int target){

        int size = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<size; i++){
            int diff = target - arr[i];
            if (map.containsKey(diff)) return new int[]{i, map.get(diff)};
            map.put(arr[i], i);
        }

        return new int[]{-1,-1};
    }

    // :: A3 : Optimized
       

    // Driver
    public static void main(String[] args){



        
    }
}
