package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SwapNumbers {
    public static void main(String[] args) {
        int num1 = 2;
        int num2 = 5;

        int a = num1;
        num1 = num2;
        num2 = a;

        System.out.println(num1);
        System.out.println(num2);

        int[] arr = {1,2,3,4,5};
        swap(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr){
        arr[2]= 50;
    }
}
