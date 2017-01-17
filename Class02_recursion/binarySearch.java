public class Solution {
  public int binarySearch(int[] array, int target) {
    // Write your solution here.
    if (array == null || array.length == 0){
      return -1;
    }
    return binarySearch(array, 0, array.length-1, target);
  }
  
  public int binarySearch(int[] array, int left, int right, int target){
    // no recursion just linear scan. Time complexity O(logn)
    while(left <= right){
      int midd = (left+right)/2;
      if (array[midd] == target){
        return midd;
      }
      else if(array[midd] < target){
        left = midd+1;
      }
      else{
        right = midd-1;
      }
    }
    return -1;
  }
}