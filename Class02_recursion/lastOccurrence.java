public class Solution {
  public int lastOccur(int[] array, int target) {
    // Write your solution here
    if (array == null || array.length < 1){
      return -1;
    }
    int left = 0;
    int right = array.length -1;
    // terminate while neighbore 
    while(left+1<right){
      int midd = (right+left)/2;
      if (array[midd] == target){
        left = midd;
      }
      else if(array[midd] < target){
        left = midd +1;
      }
      else{
        right = midd-1;
      }
    }
    // return right first for last occurrence
    if (array[right] == target){
      return right;
    }
    if (array[left] == target){
      return left;
    }
    return -1;
  }
}
