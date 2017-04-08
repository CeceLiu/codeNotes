public class Solution {
  public int longest(int[] array) {
    // Write your solution here.
    if (array == null || array.length <1)
      return 0;

    // use O(1) space for local maxi and compare with global
    int currL = 1;
    int max = currL;
    for(int i=1; i<array.length; i++){
      if(array[i] > array[i-1]){
        currL += 1;
        max = Math.max(currL, max);
      }
      else
        currL = 1;
    }
    return max;
  }
}
