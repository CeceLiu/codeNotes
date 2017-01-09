public class Solution {
  public int[] solve(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0){
      return array;
    }
  int global, temp;
  // outer loop from 0 to n-1
    for (int i=0;i<array.length-1; i++){
      global = i;
      // inner loop from i+1 to n
      for(int j=i+1; j<array.length; j++){
        if (array[j] < array[global]){
          global = j;
        }
      }
      temp = array[global];
      array[global] = array[i];
      array[i] = temp;
    }
    return array;
  }
}