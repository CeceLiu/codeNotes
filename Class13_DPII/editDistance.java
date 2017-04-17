public class Solution {
  public int editDistance(String one, String two) {
    /*
    // DP 
    // M[i][j] represents for s1[1..i] and s2[1..j] what is the shortest edit distance
    // to convert s1 to s2   
    int[][] matrix = new int[one.length()+1][two.length()+1];
    for(int j=0; j<two.length()+1; j++)
      matrix[0][j] = j;
    for(int i=0; i<one.length()+1; i++)
      matrix[i][0] = i;
    
    for(int i=1; i<one.length()+1; i++){
      for(int j=1; j<two.length()+1; j++){
        if(one.charAt(i-1) == two.charAt(j-1))
          matrix[i][j] = matrix[i-1][j-1];
        else{
          matrix[i][j] = Math.min(matrix[i-1][j-1], matrix[i-1][j]);
          matrix[i][j] = Math.min(matrix[i][j-1], matrix[i][j]);
          matrix[i][j] += 1;
        }
      }
    }
    return matrix[one.length()][two.length()];
    */
    
    // DFS
    // base case
    if(one.isEmpty()) return two.length();
    if(two.isEmpty()) return one.length();
    //1. char[0] is identical asn we do nothing
    int nothing = Integer.MAX_VALUE;
    if(one.charAt(0) == two.charAt(0))
      nothing = editDistance(one.substring(1), two.substring(1));
    // 2,3,4 the distance if we do a replace, delete and insert
    int replace = 1+ editDistance(one.substring(1), two.substring(1));
    int delete = 1 + editDistance(one.substring(1), two);
    int insert = 1+editDistance(one, two.substring(1));
    return minHelper(nothing, replace, delete, insert);
  }
  
  public int minHelper(int one, int two, int three, int four){
    int ret = Math.min(one, two);
    int ret2 = Math.min(three, four);
    ret = Math.min(ret, ret2);
    return ret;
  }
}
