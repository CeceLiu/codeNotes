public class Solution {
  public int[] dedup(int[] array) {
    // Write your solution here.
    if(array==null || array.length<1)
      return array;
    int s=0;
    int f=1;
    while(f<array.length){
      // move slow first then copy fast back
      if(array[s]!=array[f]){
        array[++s] = array[f++]; 
      }
      else{
        f++;
      }
    }
    // ** return a subArray [from, to)
    return Arrays.copyOfRange(array, 0, s+1);
  }
}
