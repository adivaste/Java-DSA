import java.util.Arrays;

public class CycleSortPlacement{


    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void cycleSort(int[] arr){

        int size = arr.length;
        int i = 0;
        while(i< size){
            int correctIndex = arr[i] - 1;
            if (correctIndex != i) {
                swap(arr, i, correctIndex);
            }
            else{
                ++i;
            }
        }
    }

    public static void main(String[] args){
        CycleSortPlacement c = new CycleSortPlacement();
        int[] arr = {5,4,3,2,1};
        System.out.println(Arrays.toString(arr));
        c.cycleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}