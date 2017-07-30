public class Solution {
  public void rotate(int[][] matrix) {
    // Write your solution here.
    if(matrix==null || matrix.length<=1)
      return;
    int N = matrix.length;
    int[][] res = new int[N][N];
    for(int i=0; i<N; i++){
      for(int j=0; j<N; j++)
        res[j][N-1-i] = matrix[i][j];
    }
    for(int i=0;i<N;i++){
      for(int j=0; j<N; j++)
        matrix[i][j] = res[i][j];
    }
  }
}
