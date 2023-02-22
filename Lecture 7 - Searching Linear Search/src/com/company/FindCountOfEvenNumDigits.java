package com.company;

class FindCountOfEvenNumDigits {

    public static void main(String[] args) {
        int[] nums = {12,34,1,343,12232,534};
        System.out.println(findNumbers(nums));
    }
    public static int findNumbers(int[] nums) {
        int count = 0;
        for(int num:nums){
            if (haveEvenDigits(num)) count++;
        }
        return count;
    }
    private static boolean haveEvenDigits(int number){
        if (number<0) number = number*-1;
        return ((int)Math.log10(number) + 1)%2==0;
    }
}
