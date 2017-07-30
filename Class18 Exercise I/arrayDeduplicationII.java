public class Solution {
  public int[] dedup(int[] array) {
    // ** remove duplication from sorted array and keep at most of two same value
    if(array==null || array.length<3)
      return array;
    int slow = 2;
    for(int i=2; i<array.length; i++){
      if(array[i] != array[slow-2])
        array[slow++] = array[i];
    }
    // ** return [0,slow)
    return Arrays.copyOfRange(array, 0, slow);
  }
}
