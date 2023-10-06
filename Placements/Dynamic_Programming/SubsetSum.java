public class SubsetSum{

    public boolean isSubsetSumPresent(int[] arr, int sum){
        return findSubsetSum(arr, sum, arr.length);
    }

    public boolean findSubsetSum(int[] arr, int sum, int n){
        
        // Base condition
        if ( sum == 0) return true;
        if ( n == 0) return false;

        // Check as per choise diagram
        if ( arr[n-1] <= sum){
            boolean left = findSubsetSum(arr, sum-arr[n-1], n-1);
            if (left) return true;
            boolean right = findSubsetSum(arr, sum, n-1);
            return left || right;
        }
        else{
            return findSubsetSum(arr, sum, n-1);
        }
    }

    public static void main(String[] args){
        SubsetSum s = new SubsetSum();
        int[] arr = {2,3,7};
        int sum = 10;

        System.out.println(s.isSubsetSumPresent(arr, sum));
    }
}

// Using DP + RECURSION

public class SubsetSum{

    public boolean isSubsetSumPresent(int[] arr, int sum, Boolean[][] dp){
        return findSubsetSum(arr, sum, arr.length, dp);
    }

    public boolean findSubsetSum(int[] arr, int sum, int n, Boolean[][] dp){
        
        // Base condition
        if ( sum == 0) return true;
        if ( n == 0) return false;

        // Search in dp
        if (dp[n-1][sum] != null) return dp[n-1][sum];

        // Check as per choise diagram
        if ( arr[n-1] <= sum){
            dp[n-1][sum] = findSubsetSum(arr, sum-arr[n-1], n-1, dp);
            if (dp[n-1][sum]) return true;
            dp[n-1][sum] = findSubsetSum(arr, sum, n-1, dp);
            return dp[n-1][sum];
        }
        else{
            dp[n-1][sum] = findSubsetSum(arr, sum, n-1, dp);
            return dp[n-1][sum];
        }
    }

    public static void main(String[] args){
        SubsetSum s = new SubsetSum();
        int[] arr = {2,3,7};
        int sum = 10;

        Boolean[][] dp = new Boolean[arr.length+1][sum+1];
        for(int i=0; i<arr.length+1; i++){
            for(int j=0; j<sum+1; j++){
                dp[i][j] = null;
            }
        }

        System.out.println(s.isSubsetSumPresent(arr, sum, dp));
    }
}


// 
public class SubsetSum{

    public boolean isSubsetSumPresent(int[] arr, int sum, Boolean[][] dp){
        return findSubsetSum(arr, sum, arr.length, dp);
    }

    public boolean findSubsetSum(int[] arr, int sum, int n, Boolean[][] dp){
        
        // Base condition
        if ( sum == 0) return true;
        if ( n == 0) return false;

        // Search in dp
        if (dp[n-1][sum] != null) return dp[n-1][sum];

        // Check as per choise diagram
        if ( arr[n-1] <= sum){
            dp[n-1][sum] = findSubsetSum(arr, sum-arr[n-1], n-1, dp);
            if (dp[n-1][sum]) return true;
            dp[n-1][sum] = findSubsetSum(arr, sum, n-1, dp);
            return dp[n-1][sum];
        }
        else{
            dp[n-1][sum] = findSubsetSum(arr, sum, n-1, dp);
            return dp[n-1][sum];
        }
    }

    public static void main(String[] args){
        SubsetSum s = new SubsetSum();
        int[] arr = {2,3,7};
        int sum = 11;

        Boolean[][] dp = new Boolean[arr.length+1][sum+1];
        for(int i=0; i<arr.length+1; i++){
            for(int j=0; j<sum+1; j++){
                if ( i == 0 ) dp[i][j] = false;
                if ( j == 0 ) dp[i][j] = true;
            }
        }

        // Find solution
        for(int i=1; i<arr.length+1; i++){
            for(int j=1; j<sum+1; j++){
                dp[i][j] = dp[i - 1][j] || (j >= arr[i - 1] && dp[i - 1][j - arr[i - 1]]);
            }
        }

        int n = arr.length;
        boolean ans = dp[n][sum];
        System.out.println(ans);
        // System.out.println(s.isSubsetSumPresent(arr, sum, dp));
    }
}
