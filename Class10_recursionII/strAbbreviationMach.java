public class Solution {
  public boolean match(String input, String pattern) {
    // Write your solution here.
    /*
    // Iteration
    int inputL = input.length();
    int pattL = pattern.length();
    if(inputL < pattL)
      return false;
    int i = 0;
    int j = 0;
    while(i<pattL && j<inputL){
      while (i<pattL && (pattern.charAt(i) < '0' || pattern.charAt(i) > '9')){
        if (input.charAt(j) != pattern.charAt(i))
          return false;
        else{
          i++;
          j++;
        }
      }
      // use count to get whole num
      int count = 0;
      while(i<pattL && pattern.charAt(i) >= '0' && pattern.charAt(i) <= '9'){
        count = count*10+pattern.charAt(i)-'0';
        i++;
      }
      if (j <inputL && j + count > inputL)
        return false;
      else
        j = j+count;
    }
    if (j < inputL)
      return false;
    return true;
    */
    return matchHelper(input, pattern, 0, 0);
  }

  // Recursion
  public boolean matchHelper(String input, String pattern, int inputIdx, int pattIdx){
    if(inputIdx == input.length() && pattIdx == pattern.length())
      return true;
    if (inputIdx >= input.length() || pattIdx >= pattern.length())
      return false;
    if(pattern.charAt(pattIdx) < '0' || pattern.charAt(pattIdx) > '9'){
      if (input.charAt(inputIdx) != pattern.charAt(pattIdx))
        return false;
      return matchHelper(input, pattern, inputIdx+1, pattIdx+1);
    }
    int count=0;
    while(pattIdx<pattern.length() && pattern.charAt(pattIdx) >= '0' && pattern.charAt(pattIdx) <= '9'){
      count = count*10 + pattern.charAt(pattIdx) - '0';
      pattIdx++;
    }
    return matchHelper(input, pattern, inputIdx+count, pattIdx);
  }
}
