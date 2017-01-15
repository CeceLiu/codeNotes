public class Solution {
  public int[] quickSort(int[] array) {
    // Write your solution here
    if (array == null || array.length <=1)
      return array;
    quickSort(array,0,array.length-1);
    // inplace so just return the original array
    return array;
  }
  
  public void quickSort(int[] array, int left, int right){
    if (left >= right){
      return;
    }
    int pivotIndex = partition(array, left, right);
    quickSort(array, left, pivotIndex-1);
    quickSort(array, pivotIndex+1, right);
  }
  
  public int partition(int[] array, int left, int right){
    //int pivot = array[right];
    // pivot choose enhancement -- with random function
    int pivotIndex = getPivotIndex(left, right);
    int pivot = array[pivotIndex];
    swap(array, pivotIndex, right);

    int i=left;
    int j = right-1;
    while(i<=j){
    if (array[i] < pivot){
      i++;
      }
    else if (array[j] >= pivot){
      j--;
      }
    else{
      swap(array,i++,j--);
      }
    }
    swap(array, i, right);
    return i;
  }
  
  public int getPivotIndex(int left, int right){
    return left + (int)(Math.random() * (right-left+1));
  }
  public void swap(int[] array, int left, int right){
    if (array[left] == array[right]){
      return;
    }
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}