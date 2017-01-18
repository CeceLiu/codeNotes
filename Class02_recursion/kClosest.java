public class Solution {
  public int[] kClosest(int[] array, int target, int k) {
    // Write your solution here
    if(array == null || array.length < 1){
      return array;
    }
    int[] ret = new int[k];
    if (k == 0){
      return ret;
    }
    int left = 0;
    int right = array.length-1;
    while(left+1<right){
      int midd = (left+right)/2;
      if(array[midd] <= target){
        left = midd;
      }
      else{
        right = midd;
      }
    }
    // use k as control so no need to check i
    int i=0;
    while(k>0){
      if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)){
        ret[i++] = array[left--];
        k--;
        if (left <0){
          while(k>0){
            ret[i++] = array[right++];
            k--;
          }
        }
      }
      else if (Math.abs(array[left] - target) > Math.abs(array[right] - target)){
        ret[i++] = array[right++];
        k--;
        if(right>array.length-1){
          while(k>0){
            ret[i++] = array[left--];
            k--;
          }
        }
      }
    }
    return ret;
  }
}
