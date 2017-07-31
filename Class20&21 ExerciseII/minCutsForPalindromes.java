public class Solution {
  public int minCuts(String input) {
    // Write your solution here.
    if(input==null || input.length()<1)
      return 0;
    int len = input.length();
    boolean[][] P = new boolean[len][len];
    int[] cut = new int[len];
    char[] array = input.toCharArray();
    // all single letter is palindrome
    for(int i=0; i<len; i++)
      P[i][i] = true;
    // ** L<=len missing equal will not update value
    for(int L=2; L<=len; L++){
      for(int s=0; s<len-L+1; s++){
        int e = s+L-1;
        if(L==2)
          P[s][e] = array[s]==array[e];
        else
        // ** str between two letters is P and s/e letter is same
          P[s][e] = (array[s] == array[e]) && P[s+1][e-1];
      }
    }
    
    for(int i=0;i<len;i++){
      if(P[0][i])
        cut[i]=0;
      else{
        cut[i] = Integer.MAX_VALUE;
        for(int j=0;j<i;j++){
          if(P[j+1][i])
            cut[i]=Math.min(cut[i], 1+cut[j]);
        }
      }
    }
    return cut[len-1];
  }
}
