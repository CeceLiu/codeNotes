public class Solution {
  public int longest(int[] array) {
    // corner case
    if(array==null || array.length <1)
      return 0;
    int[] dp = new int[array.length];
    dp[0] = array[0];
    int max = dp[0];
    for(int i=1; i<array.length; i++){
      dp[i] = array[i]==1?dp[i-1]+1:0;
      max = Math.max(max, dp[i]);
    }
    return max;
  }
}
