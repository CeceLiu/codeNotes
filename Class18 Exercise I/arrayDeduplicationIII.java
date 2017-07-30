public class Solution {
  public int[] dedup(int[] array) {
    // Remove all duplicate elements and not remaining any of them
    if(array==null || array.length<=1)
      return array;
    boolean dup = false;
    int slow = 0;
    // ** use a flag to check if copy
    for(int i=1; i<array.length; i++){
      if(array[i]==array[slow])
        dup=true;
      // dup copy to s else copy to s+1
      else if(!dup){
        array[++slow]=array[i];
      }
      else{
        array[slow]=array[i];
        dup=false;
      }
    }
    // ** return based on dup flag
    return dup? Arrays.copyOfRange(array, 0, slow) : Arrays.copyOfRange(array, 0, slow+1);
  }
}