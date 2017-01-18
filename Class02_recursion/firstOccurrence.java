public class Solution {
  public int firstOccur(int[] array, int target) {
    // Write your solution here
    if (array == null || array.length <1){
      return -1;
    }
    int left = 0;
    int right = array.length-1;
    // terminate when neighbor then post-processing
    while(left+1<right){
      int midd = (right+left)/2;
      if(array[midd] == target){
        right = midd;
      }
      else if(array[midd] < target){
        left = midd+1;
      }
      else{
        right = midd-1;
      }
    }
    if(array[left] == target){
      return left;
    }
    else if(array[right] == target){
      return right;
    }
    return -1;
  }
}
