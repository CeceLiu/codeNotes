public class Solution {
  public int[][] spiralGenerate(int m, int n) {
    // Write your solution here.
    int[][] matrix = new int[m][n];
    int currR = 0;
    int currC = 0;
    int value = 1;
    while(currR < m && currC < n){
      // add the first row from remaining rows
      for(int i= currC; i< n; i++){
        matrix[currR][i] = value;
        value++;
      }
      currR++;
      // add the last column from remaining cols
      for(int i=currR; i<m; i++){
        matrix[i][n-1] = value;
        value++;
      }
      n--;
      
      // add the last row from remaining rows
      if (currR < m){
        // *** i >= currC / i >=currR *** 
        for(int i=n-1; i>=currC; i--){
          matrix[m-1][i] = value;
          value++;
        }
        m--;
      }
      // add the first col from remaining cols
      if (currC < n){
        for(int i=m-1; i>=currR; i--){
          matrix[i][currC] = value;
          value++;
        }
        currC++;
      }
    }
    return matrix;
  }
}
