public class Solution {
  public boolean isPowerOfTwo(int number) {
    // Write your solution here.
    /*
    if(number <=0)
      return false;
    while(number %2 !=1)
      number = number/2;
    return (number==1);
    */
    // binary operation
    // Any power of 2 minus 1 is all ones  --> 8 & 7 1000 & 0111 == 0000
    return number>0 && (number & (number-1)) == 0;
  }
}
