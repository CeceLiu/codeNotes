

// http://www.geeksforgeeks.org/generate-integer-from-1-to-7-with-equal-probability/
public class Solution {
  public int random7() {
    // write your solution here
    // you can use RandomFive.random5() for generating
    // 0 - 4 with equal probability.
    int temp = 5*RandomFive.random5() + RandomFive.random5();
    if(temp <21)
      return temp%7;
    else
      return random7();
  }
}
