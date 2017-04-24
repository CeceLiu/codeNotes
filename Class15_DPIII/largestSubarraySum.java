public class Solution {
  public int largestSum(int[] array) {
    // Write your solution here.
    if(array == null || array.length<1)
      return 0;
    int global = array[0];
    int curr = array[0];
    // Kadane's algorithm is O(n)
    // either the maximum subarray sum ending at position i+1 includes the maximum subarray sum 
    // ending at position i as a prefix, or it doesn't.
    for(int i=1; i<array.length; i++){
      curr = Math.max(curr+array[i], array[i]);
      // WRONG: curr = Math.max(curr+array[i], curr);
      global = Math.max(global, curr);
    }
    return global;
  }
}
