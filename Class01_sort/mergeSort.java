public class Solution {

  /* Method one
  public int[] mergeSort(int[] array) {
    if (array == null || array.length <=1){
      return array;
    }
    int midd = array.length/2-1;
    int[] leftArray = halfArray(array, 0, midd);
    int[] rightArray = halfArray(array, midd+1, array.length-1);
    mergeSort(leftArray);
    mergeSort(rightArray);
    int[] solu = merge(leftArray, rightArray, array);
    return solu;
  }
  
  public int[] halfArray(int[] array, int leftIndex, int rightIndex){
    int[] half = new int[rightIndex-leftIndex+1];
    int j = 0;
    int i = leftIndex;
    while(i<=rightIndex){
      half[j++] = array[i++];
    }
    return half;
  }

  public int[] merge(int[] leftArray, int[] rightArray, int [] array){
    int i1 = 0;
    int i2 = 0;
    for (int i=0; i<array.length; i++){
      if (i2 >= rightArray.length || 
          (i1 < leftArray.length && leftArray[i1] < rightArray[i2])){
            array[i] = leftArray[i1];
            i1++;
          }
      else{
        array[i] = rightArray[i2];
        i2++;
      }
    }
    return array;
  }
  */

  // Mehod two
  public int[] mergeSort(int[] array) {
    // Write your solution here.
    if(array==null || array.length<1)
      return array;
    int[] helper = new int[array.length];
    // 0-n
    mergeSort(helper, 0, array.length-1, array);
    return array;
  }
  
  public void mergeSort(int[] helper, int left, int right, int[] array){
    // top-down split merge
    if(left>=right)
      return;
    int midd = left + (right-left)/2;
    mergeSort(helper, left, midd, array);
    mergeSort(helper, midd+1, right, array);
    merge(helper, left, midd, right, array);
  }
  
  public void merge(int[] helper, int left, int midd, int right, int[] array){
    // copy from array to res for elements between left/right
    for(int i=left; i<=right; i++)
      helper[i] = array[i];
    int leftIdx = left;
    int rightIdx = midd+1;
    while(leftIdx<=midd && rightIdx<=right){
      if(helper[leftIdx] <= helper[rightIdx])
        array[left++] = helper[leftIdx++];
      else
        array[left++] = helper[rightIdx++];
    }
    while(leftIdx<=midd)
      array[left++] = helper[leftIdx++];
  }

}
