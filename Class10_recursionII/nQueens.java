public class Solution {
  public List<List<Integer>> nqueens(int n) {
    // Write your solution here.
    List<List<Integer>> solu = new ArrayList<List<Integer>>();
    List<Integer> curr = new ArrayList<Integer>();
    if (n <=0)
      return solu;
    nqueens(n, 0, curr, solu);
    return solu;
  }
  
  public void nqueens(int n, int index, List<Integer> curr, List<List<Integer>> solu){
    if (index == n){
      solu.add(new ArrayList<Integer> (curr));
      return;
    }
    
    for (int i=0; i<n; i++){
      curr.add(i);
      if(valid(curr)){
        nqueens(n, index+1, curr, solu);
      }
      curr.remove(curr.size()-1);
    }
  }
  
  public boolean valid(List<Integer> curr){
    /*
    * 1. No two queens share a column. --> curr[i] != curr[last]
      2. No two queens share a row. 
      3. No two queens share a top-right to left-bottom diagonal.
         --> slash[row][col] = row+col
      4. No two queens share a top-left to bottom-right diagonal.
         --> backSlash[row][col] = row-col+(N-1)
    */
    int size = curr.size();
    // compare last item with earlier ones
    // row: i col: curr[i]
    for(int i=0; i<size-1; i++){
      if ( curr.get(i) == curr.get(size-1) || 
           i + curr.get(i) == curr.get(size-1) + (size-1) ||
           i - curr.get(i) == (size-1) - curr.get(size-1)
        )
        return false;
    }
    return true;
  }
}
