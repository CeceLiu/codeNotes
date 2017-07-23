public class Solution {
  public boolean canJump(int[] array) {
    // Write your solution here.
    if (array == null || array.length<=1)
      return true;
      
    // DP
    /*
    int[] dp = new int[array.length];
    dp[0] = array[0];
    // dp[i] contains the maximum index can jump to from i
    for(int i=1; i<array.length; i++){
      // update dp[i] when i-th is reachable and A[i] can jump to another position
      if(dp[i-1] > 0 && array[i] >0)
        dp[i] = i+array[i];
      // reach the end of array
      if(dp[i] >= array.length-1)
        return true;
    }
    return false;
    */
    
    // Greedy: not fully understand
    int curr = 0; // the max index current jump can reach
    int next = 0; // the max index next jump can reach
    for(int i=0; i<array.length; i++){
      if(i>curr){
        // we need a jump from curr to next
        if(curr == next)
          return false;
        curr = next;
      }
      next = Math.max(next, i+array[i]);
    }
    return true;
  }
}
