public class Solution {
  public int[] moveZero(int[] array) {
    // Write your solution here.
    if (array == null || array.length <=1){
      return array;
    }
    int i=0;
    int j=array.length -1;
    /*
    while(i<=j){
      if (array[i] == 0){
        swap(array, i, j--);
      }
      else{
        i++;
      }
    }*/
    // enhance to ignore 0s at end
    while(i<=j){
      if (array[i] != 0){
        i++;
      }
      else if(array[j] == 0){
        j--;
      }
      else{
        swap(array, i, j--);
      }
    }
    return array;
  }    
  
  public void swap(int[] array, int i, int j){
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
