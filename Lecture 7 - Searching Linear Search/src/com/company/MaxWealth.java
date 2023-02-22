package com.company;

class MaxWealth {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6}
        };

        int maxWealth = maximumWealth(arr);
        System.out.println(maxWealth);
    }
    public static int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int i=0; i<accounts.length; i++){
            int personTotalWealth = 0;
            for (int j=0; j<accounts[i].length; j++){
                personTotalWealth += accounts[i][j];
            }
            if (maxWealth < personTotalWealth) maxWealth = personTotalWealth;
        }
        return maxWealth;
    }
}
