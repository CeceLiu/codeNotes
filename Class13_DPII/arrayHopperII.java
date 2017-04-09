public class Solution {
  public int minJump(int[] array) {
    // Write your solution here.
    if(array==null || array.length <1){
      return -1;
    }
    
    int[] dp = new int [array.length];
    // dp[n-1] = 0 as base case fill the array from n-2
    // dp[i] means the minimum number of jumps from i to target
    for(int i=array.length-2; i>=0; i--){
      // case1: directly jump to target
      if(i+array[i] > array.length)
        dp[i] = 1;
      else{
        int min = Integer.MAX_VALUE;
        // case2: 1+min(dp[j]) where j is the place you can jump directly from i by one step
        for(int j=i+1; j<= i+array[i]; j++){
          if(j<array.length && dp[j] != -1)
            min = Math.min(min, dp[j]);
        }
        // update to -1 if unable to reach
        if( min != Integer.MAX_VALUE)
          dp[i] = 1+ min;
        else
          dp[i] = -1;
        }
      }
     return dp[0];
    }
  }
