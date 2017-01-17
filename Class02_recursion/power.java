public class Solution {
  public long power(int a, int b) {
    // Write your solution here
    if (b == 0){
      return 1;
    }
    if (a == 0){
      //return 0;
      return b>0 ? 0:Long.MAX_VALUE;
    }
    long temp = power(a, b/2);
    /*
    if (b%2 == 1){
      return temp * temp *a;
    }
    else{
      return temp * temp;
    }
    */
    return b%2 ==0 ? temp*temp: temp*temp*a;
  }
}
