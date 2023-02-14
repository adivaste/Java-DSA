package com.company;

public class ProductSumSubtract {

    public static void main(String[] args) {
        int number =  12345;
        int output = subtractProductAndSum(number);

        System.out.println(output);
    }
    private static int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;

        while(n !=0 ){
            sum = sum + n%10;
            product = product*(n%10);
            n = n/10;
        }
        return (product-sum);
    }
}
