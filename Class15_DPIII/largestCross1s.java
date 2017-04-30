public class Solution {
  public int largest(int[][] matrix) {
    // N*M matrix
    int N = matrix.length;
    if(N==0)
      return 0;
    int M = matrix[0].length;
    if(M==0)
      return 0;
    int[][] LR = new int[N][M];
    int[][] RL = new int[N][M];
    int[][] UB = new int[N][M];
    int[][] BU = new int[N][M];
    
    int max_arm = Integer.MIN_VALUE;
    // left to right && up to bottom
    for(int i=0; i<N; i++){
      for(int j=0; j<M; j++){
        if(j==0)
          LR[i][j] = matrix[i][j] == 1 ? 1:0;
        else
          LR[i][j] = matrix[i][j] == 1? LR[i][j-1]+1:0;
        if(i==0)
          UB[i][j] = matrix[i][j] == 1 ? 1:0;
        else
          UB[i][j] = matrix[i][j] == 1 ? UB[i-1][j]+1:0;
      }
    }
    // right to left && bottom to up
    for(int i=N-1; i>=0; i--){
      for(int j=M-1; j>=0; j--){
        if(i==N-1)
          BU[i][j] = matrix[i][j] == 1 ? 1:0;
        else
          BU[i][j] = matrix[i][j] == 1 ? BU[i+1][j]+1:0;
        if(j==M-1)
          RL[i][j] = matrix[i][j] == 1 ? 1:0;
        else
          RL[i][j] = matrix[i][j] == 1 ? RL[i][j+1]+1:0;
      }
    }
    // arm = Math.min(M1,M2,M3,M4[i][j])
    for(int i=0; i<N; i++){
      for(int j=0; j<M; j++){
        LR[i][j] = Math.min(LR[i][j], UB[i][j]);
        RL[i][j] = Math.min(RL[i][j], BU[i][j]);
        LR[i][j] = Math.min(LR[i][j], RL[i][j]);
        max_arm = Math.max(LR[i][j], max_arm);
      }
    }
    return max_arm;
  }
}
