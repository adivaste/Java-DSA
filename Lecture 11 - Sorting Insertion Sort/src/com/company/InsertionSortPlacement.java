import java.util.Arrays;
public class InsertionSortPlacement{

    private void insertionSort(int[] arr){
        
        // Size 
        int size = arr.length;

        for(int i=0; i<size; i++){
            int j = i;

            while(j > 0 && arr[j-1] > arr[j]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;

                j--;
            }
        }
    }

    public static void main(String[] args){
        InsertionSortPlacement i = new InsertionSortPlacement();

        int[] arr = {5,4,3,2,1};
        System.out.println(Arrays.toString(arr));
        i.insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
