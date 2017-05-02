public class Solution {
  public int largest(int[][] matrix) {
    // Write your solution here.
    int N = matrix.length;
    if(N==0)
      return 0;
    int M = matrix[0].length;
    if(M==0)
      return 0;
    
    int[][] left = new int[N][M];
    int[][] right = new int[N][M];
    int[][] down = new int[N][M];
    int[][] up = new int[N][M];
    
    // left-up to right-bottom AND right-up to left-bottom
    for(int i=0; i<N;i++){
      for(int j=0; j<M; j++){
        if(matrix[i][j] == 1)
          left[i][j] = getNum(left, i-1, j-1, N, M)+1;
          down[i][j] = getNum(down, i-1, j+1, N, M)+1;
      }
    }
    // left-bottom to right-up AND right-bottom to left-up
    for(int i=N-1; i>=0; i--){
      for(int j=M-1; j>=0; j--){
        if(matrix[i][j] == 1){
          right[i][j] = getNum(right, i+1, j+1, N, M)+1;
          up[i][j] = getNum(up, i+1, j-1, N, M)+1;
        }
      }
    }
    int max_arm = Integer.MIN_VALUE;
    for(int i=0; i<N; i++){
      for(int j=0; j<M; j++){
        left[i][j] = Math.min(left[i][j], down[i][j]);
        right[i][j] = Math.min(right[i][j], up[i][j]);
        left[i][j] = Math.min(left[i][j], right[i][j]);
        max_arm = Math.max(left[i][j], max_arm);
      }
    }
    return max_arm;
  }
  
  public int getNum(int[][] matrix, int i, int j, int N, int M){
    if(i<0||i>=N||j<0||j>=M)
      return 0;
    return matrix[i][j];
  }
}
