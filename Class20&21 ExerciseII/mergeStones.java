public class Solution {
  public int minCost(int[] stones) {
    // Write your solution here.
    if(stones==null || stones.length<1)
      return 0;
    int n = stones.length;
    int[][] minCost= new int[n][n];
    int[][] sum = new int[n][n];
    for(int e=0; e<n; e++){
      for(int s=e; s>=0; s--){
        if(s==e){
          minCost[s][e]=0;
          sum[s][e] = stones[e];
        }
        else{
        // ** update sum value and initialize minCost from bottom
        sum[s][e] = sum[s][e-1]+stones[e];
        minCost[s][e] = Integer.MAX_VALUE;
        for(int curr=e-1; curr>=s; curr--){
          minCost[s][e] = Math.min(minCost[s][e], 
                          minCost[s][curr]+minCost[curr+1][e]+sum[s][e]);
          }
        }
      }
    }
    return minCost[0][n-1];
  }
}
