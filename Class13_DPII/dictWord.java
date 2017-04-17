public class Solution {
  /*
  public boolean canBreak(String input, String[] dict) {
    // Write your solution here.
    HashSet<String> mySet = new HashSet<String>(Arrays.asList(dict));
    return helper(input, mySet);
  }
  
  public boolean helper(String input, HashSet<String> dict){
    boolean canBreak = dict.contains(input);
    if(input.length() == 1 || canBreak)
      return canBreak;
    
    for(int i=1; i<input.length(); i++){
      if(dict.contains(input.substring(0,i)) &&
         helper(input.substring(i,input.length()), dict))
        return true;
    }
    return false;
  }
  */
  // DP
  // M[i]=true if substring(0,i) in the dict OR 
  // there is at least one j (j<=i) that M[j] is true and dict contains substring(j,i)
  public boolean canBreak(String input, String[] dict){
    boolean[] dp = new boolean[input.length()+1];
    HashSet<String> mySet = new HashSet<String>(Arrays.asList(dict));
    for(int i=1; i<input.length()+1; i++){
      if(mySet.contains(input.substring(0,i))){
        dp[i] = true;
        continue;
      }
      for(int j=1; j<i; j++){
        if(dp[j] && mySet.contains(input.substring(j,i))){
          dp[i] = true;
          break;
        }
      }
      //dp[i] = false;
    }
    return dp[input.length()];
  }
}