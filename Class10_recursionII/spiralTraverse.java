public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    // Write your solution here.
    List<Integer> solu = new ArrayList<Integer>();
    int rows = matrix.length;
    if (rows == 0)
      return solu;
    int cols = matrix[0].length;
    if (cols == 0)
      return solu;
    spiral(matrix, rows, cols, solu);
    return solu;
  }
  
  public void spiral(int[][] matrix, int rows, int cols, List<Integer> solu ){
    int currR = 0;
    int currC = 0;
    /*
    currR: starting row index
    rows : ending row index
    currC: starting col index
    cols : ending col index
    i    : iterator
    
    */
    while(currR < rows && currC < cols){
      // add the first row from remaining rows
      for(int i= currC; i< cols; i++)
        solu.add(matrix[currR][i]);
      currR++;
      // add the last column from remaining cols
      for(int i=currR; i<rows; i++)
        solu.add(matrix[i][cols-1]);
      cols--;
      
      // add the last row from remaining rows
      if (currR < rows){
        // *** i >= currC / i >=currR *** 
        for(int i=cols-1; i>=currC; i--)
          solu.add(matrix[rows-1][i]);
        rows--;
      }
      // add the first col from remaining cols
      if (currC < cols){
        for(int i=rows-1; i>=currR; i--)
          solu.add(matrix[i][currC]);
        currC++;
      }
    }
  }
}
