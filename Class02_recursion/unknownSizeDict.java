/*
*  interface Dictionary {
*    public Integer get(int index);
*  }
*/

// You do not need to implement the Dictionary interface.
// You can use it directly, the implementation is provided when testing your solution.
public class Solution {
  public int search(Dictionary dict, int target) {
    // Write your solution here
    if (dict == null){
      return -1;
    }
    int left=0;
    int right = 1;
    // reduce the numbers to search
    while(dict.get(right) != null && dict.get(right)<target){
      left = right;
      right = right*2;
    }
    return binarySearch(dict,target, left, right);
  }
  
  public int binarySearch(Dictionary dict, int target, int left, int right){
    while(left <= right){
      int midd = (left+right)/2;
      // right is out of bound not the really index of bound
      if (dict.get(midd) == null || dict.get(midd) > target){
        right = midd-1;
      }
      else if (dict.get(midd) < target){
        left = midd+1;
      }
      else{
        return midd;
      }
    }
    return -1;
  }
}
