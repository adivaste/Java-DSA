package com.company;

public class FindMagicNumber {
    public static void main(String[] args) {
        int num = 15;
        System.out.println(findMagicNumber(num));
    }

    private static int findMagicNumber(int num){
        int magicNumber = 0;
        int power = 1;

        while ( num != 0 ){
            int lastBit = num & 1;
            magicNumber += (int)Math.pow(5, power)*lastBit;
            num >>= 1;
            power++;
        }
        return magicNumber;
    }
}
