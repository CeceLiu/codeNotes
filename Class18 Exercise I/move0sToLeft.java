public class Solution {
  public int[] moveZero(int[] array) {
    // Write your solution here.
    if(array==null || array.length<=1)
      return array;
    // ** check first postion as well
    int i=0, j=0;
    while(j<array.length){
      if(array[j]!= 0){
        array[i++] = array[j++];
      }
      else{
        j++;
      }
    }
    while(i<array.length){
      array[i++]=0;
    }
    return array;
  }
}
