public class CountSubsetSum{

    public int isSubsetSumPresent(int[] arr, int sum, int[][] dp){
        return findSubsetSum(arr, sum, arr.length, dp);
    }

    public int findSubsetSum(int[] arr, int sum, int n, int[][] dp){
        
        // Base condition
        if ( sum == 0) return 1;
        if ( n == 0) return 0;

        // Check existing in DP
        if(dp[n-1][sum] != -1) return dp[n-1][sum];

        // Check as per choice diagram
        if ( arr[n-1] <= sum){
            int left = findSubsetSum(arr, sum-arr[n-1], n-1, dp);
            int right = findSubsetSum(arr, sum, n-1, dp);
            dp[n-1][sum] = left + right;
            return dp[n-1][sum];
        }
        else{
            int left = findSubsetSum(arr, sum, n-1, dp);
            dp[n-1][sum] = left;
            return dp[n-1][sum];
        }
    }

    public static void main(String[] args){
        CountSubsetSum s = new CountSubsetSum();
        int[] arr = {2,3,7,5,5};
        int sum = 26;

        int[][] dp = new int[arr.length+1][sum+1];
        for(int i=0; i<arr.length+1; i++){
            for(int j=0; j<sum+1; j++){
                dp[i][j] = -1;
            }
        }

        System.out.println(s.isSubsetSumPresent(arr, sum, dp));
    }
}

// Bottom-up

public class CountSubsetSum{

    public static void main(String[] args){
        CountSubsetSum s = new CountSubsetSum();
        int[] arr = {2,3,7,5,5};
        int sum = 5;

        int[][] dp = new int[arr.length+1][sum+1];

        for(int i=0; i<arr.length+1; i++){
            for(int j=0; j<sum+1; j++){
                if (i == 0) dp[i][j] = 0;
                if (j == 0) dp[i][j] = 1;
            }
        }


        for(int i=1; i<arr.length+1; i++){
            for(int j=1; j<sum+1; j++){
                dp[i][j] = arr[i-1] <= j ? dp[i-1][j] + dp[i-1][j-arr[i-1]] : dp[i-1][j];
            }
        }

        int answer = dp[arr.length][sum];
        System.out.println(answer);
    }
}