// Recursive

class Solution{

	public int perfectSum(int arr[],int n, int sum){ 
	    int totalSum = 0;
	    return findPerfectSum(arr, sum, totalSum, n);
	}
	
	public int findPerfectSum(int[] arr, int sum, int totalSum, int n){
	    
	    // Base condition
	    if (n == 0){
	         if (totalSum == sum) return 1;
	         return 0;
	    }
	    
	    // Pick and not-pick
	    int left =  findPerfectSum(arr, sum, totalSum+arr[n-1], n-1);
	    int right =  findPerfectSum(arr, sum, totalSum, n-1);
	    
	    return left + right;
	}
}

// ASDFGK