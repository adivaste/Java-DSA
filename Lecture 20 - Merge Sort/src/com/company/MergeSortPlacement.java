import java.util.Arrays;

public class MergeSortPlacement{

    public void merge(int[] arr, int start, int mid, int end){

        // Array to store result
        int[] merged = new int[end-start+1];

        // Pointer to keep track
        int i = start;      // For first array
        int j = mid+1;      // For second array
        int k = 0;          // For merge array

        // Insert until one of array inserted
        while(i <= mid && j <=end){
            if(arr[i] < arr[j]){
                merged[k++] = arr[i++];
            }
            else{
                merged[k++] = arr[j++];
            }
        }

        // Insert remaining first array
        while(i <= mid){
            merged[k++] = arr[i++];
        }

        // Insert remaining second array
        while(j <= end){
            merged[k++] = arr[j++];
        }

        // Copy array to original one
        for(int x=0, y=start; x<merged.length; x++, y++) {
            arr[y] = merged[x];
        }


    }

    public void mergeSort(int[] arr, int start, int end){
        if (start < end){
            int mid = (start + end)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }

    }
    public static void main(String[] args){
        MergeSortPlacement m = new MergeSortPlacement();

        int[] arr = {5,4,3,1,2};
        System.out.println(Arrays.toString(arr));
        m.mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}