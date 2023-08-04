import java.util.Arrays;

public class BubbleSortPlacement{

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void bubbleSort(int[] arr){
        
        int size = arr.length;
        boolean swapped = true;
        int swapTill = size;

        for(int i=0; i<size && swapped == true; i++){
            swapped = false;
            for(int j=1; j<swapTill; j++){
                if (arr[j-1] > arr[j]){
                    swap(arr, j-1, j);
                    swapped = true;
                }
            }
            swapTill--;
        }
    }

    public static void main(String[] args){
        
        BubbleSortPlacement b = new BubbleSortPlacement();

        int[] arr = {5,4,3,2,1};

        System.out.println(Arrays.toString(arr));
        b.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
