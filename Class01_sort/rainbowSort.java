public class Solution {
  public int[] rainbowSort(int[] array) {
    // Write your solution here.
    if (array == null || array.length <=1){
      return array;
    }
    // [0,i) all -1, [i,j) all 0, [j,end] all 1
    int i =0;
    int j = array.length-1;
    int k= 0;
    while(k<=j){
      if(array[k] == -1){
        swap(array, i++, k++);
      }
      else if(array[k] == 1){
        swap(array, j--, k);
      }
      else{
        k++;
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
