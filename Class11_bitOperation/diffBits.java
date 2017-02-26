public class Solution {
  public int diffBits(int a, int b) {
    // Write your solution here.
    /*
    << binary left shift operation
    >> binary right shift operation
    >>> zero fill right shift operation, shifted values are filled up with zeros
    */
    int count = 0;
    int c = a^b;
    while(c!=0){
      count += c&1;
      c = c>>>1;
    }
    return count;
  }
}
