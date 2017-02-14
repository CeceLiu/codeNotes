
public class Solution {
  public int strstr(String large, String small) {
    // write your solution here
    /*
    if (large.length() < small.length())
      return strstr(small, large);
      */
    
    if (small.length() == 0)
      return 0;
    int i=0;
    // out loop: until index l.length - s.length
    // inner loop: check each char in small
    while(i+small.length() <= large.length()){
      int j=0;
      while(j<small.length() && small.charAt(j) == large.charAt(i+j)){
        j++;
      }
      if (j == small.length())
        return i;
      i++;
    }
    return -1;
  }
}
