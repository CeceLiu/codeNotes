public class Solution {
  public int[] search(int[][] matrix, int target) {
    // Write your solution here.
    if (matrix == null || matrix.length <1){
      return new int[] {-1,-1};
    }
    int rows = matrix.length;
    int cols = matrix[0].length;
    int i = 0;
    int j = rows*cols-1;
    while(i<=j){
      int midd = (i+j)/2;
      // get current midd position
      int r = midd / cols;
      int c = midd % cols;
      if (matrix[r][c] == target){
        return new int[] {r,c};
      }
      else if (matrix[r][c] < target){
        i = midd+1;
      }
      else{
        j = midd-1;
      }
    }
    return new int[] {-1, -1};
  }
}
