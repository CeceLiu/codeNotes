public class Solution {
  public int closest(int[] array, int target) {
    // Write your solution here
    if(array == null || array.length < 1){
      return -1;
    }
    int left = 0;
    int right = array.length -1;
    while(left+1 < right){
      int midd = (left+right)/2;
      // found target directly return 
      if(array[midd] == target){
        return midd;
      }
      else if(array[midd] < target){
        left = midd;
      }
      else{
        right = midd;
      }
    }
    // Math.abs 
    if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)){
      return left;
    }
    else{
      return right;
    }
  }
}
