public class Solution {
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
}
