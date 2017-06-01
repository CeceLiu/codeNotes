public class Solution {
  public void shuffle(int[] array) {
    // Write your solution here.
    if(array==null || array.length <1)
      return;
    
    for(int i=0; i<array.length; i++){
      // Math.random() returns a number from zero to one
      int pos = (int)(Math.random() * (array.length-i)) + i;
      swap(array, i, pos);
    }
  }
  
  public void swap(int[] array, int left, int right){
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}
