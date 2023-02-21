package com.company;

public class PrimeNumbers {
    public static void main(String[] args) {
        System.out.println(isPrime(2));
    }
    public static boolean isPrime(int num){
        int divisor = 2;
        while (divisor*divisor <= num){
            if (num%divisor==0) return false;
            divisor++;
        }
        return true;
    }
}