import java.util.Arrays;

public class SelectionSortPlacement{
    
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void selectionSort(int[] arr){

        // Size of array
        int size = arr.length;

        // Perform the iterations and swapping to sort
        for(int i=0; i<size; i++){
            
            int minIndex = i;
            for(int j=i; j<size; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args){
        SelectionSortPlacement s = new SelectionSortPlacement();
        int[] arr = {5,4,3,2,1};
        System.out.println(Arrays.toString(arr));
        s.selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
