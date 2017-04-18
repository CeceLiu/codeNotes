public class Solution {
  public int largest(int[][] matrix) {
    // Write your solution here.
    int row = matrix.length;
    // corner case: empty matrix
    if(row == 0)
      return 0;
    int col = matrix[0].length;
    int[][] dp = new int[row][col];
    int i,j;
    int max = Integer.MIN_VALUE;
    /*
    // update globalMax when initialize
    for(i=0; i<row; i++){
      dp[i][0] = matrix[i][0]==1 ? 1:0;
      max = Math.max(max, dp[i][0]);
    }
    for(j=0; j<col; j++){
      dp[0][j] = matrix[0][j]==1 ? 1:0;
      max = Math.max(max, dp[0][j]);
    }
    for(i=1; i<row; i++){
      for(j=1; j<col; j++){
        // dp[i][j] is the max size of square with the coordinate[i][j] as 
        // its bottom right corner
        if(matrix[i][j] == 1){
          dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]);
          dp[i][j] = Math.min(dp[i-1][j-1], dp[i][j]);
          dp[i][j]++;
        }
        max = Math.max(max, dp[i][j]);
      }
    }
    */
    for(i=0; i<row; i++){
      for(j=0; j<col; j++){
        if(i==0 || j==0)
          dp[i][j] = matrix[i][j] ==1?1:0;
        else if(matrix[i][j] == 1){
          dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]);
          dp[i][j] = Math.min(dp[i-1][j-1], dp[i][j]);
          dp[i][j]++;
        }
        max = Math.max(max, dp[i][j]);
      }
    }
    return max;
  }
}
