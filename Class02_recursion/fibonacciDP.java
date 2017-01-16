public class Solution {

  // DP with O(n) space
  /*
  public long fibonacci(int K) {
    // Write your solution here
    if (K<=0){
      return 0;
    }
    long[] array = new long[K+1];
    array[1] = 1;
    for(int i=2; i<=K; i++){
      array[i] = array[i-1] + array[i-2];
    }
    return array[K];
  }*/

  public long fibonacci(int K){
    long a=0;
    long b=1;
    if (K<=0){
      return a;
    }
    while(K>1){
      long temp = a+b;
      a = b;
      b = temp;
      K--; 
    }
    return b;
  }

}
