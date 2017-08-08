public class Solution {
  public boolean existSum(int[] array, int target) {
    if(array==null || array.length<1)
      return false;
    Arrays.sort(array);
    int i=0, j=array.length-1;
    while(i<j){
      if(array[i]+array[j]==target)
        return true;
      else if(array[i]+array[j]>target){
        j--;
      }
      else{
        i++;
      }
    }
    return false;
  }
}
