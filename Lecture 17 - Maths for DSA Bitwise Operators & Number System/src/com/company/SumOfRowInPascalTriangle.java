package com.company;

public class SumOfRowInPascalTriangle {
    public static void main(String[] args) {
        int row = 4;
        System.out.println(sumOfRow2(row));
    }
    private static int sumOfRow(int rowNo){
        return (int)Math.pow(2, rowNo-1);
    }

    private static int sumOfRow2(int rowNo){
        return 1 << rowNo-1;
    }
}
