public class Solution {
  
  /**
  * Compares its two arguments for order. 
  * Returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, 
  * or greater than the second.
  * i.e return one-two means small with higher priority
  *     return two-one means big 
  *
  */
  /*
  static class PQsort implements Comparator<Integer>{
    public int compare (Integer one, Integer two){
      if (one == two){
        return 0;
      }
      // maxHeap   or return two - one
      return one > two? -1:1;

      // minHeap as default
      // return one < two ? -1:1;
    }
  }
  // M1: create a maxHeap with k-size, if array[k+1] < maxHeap.head replace the head
  //     re-order to return
  public int[] kSmallest(int[] array, int k) {
    // Write your solution here
    assert array != null;
    if (array.length == 0 || k==0){
      return new int[0];
    }
    PQsort comp = new PQsort();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, comp);
    
    for (int i=0; i<array.length; i++){
      if (i < k){
        maxHeap.offer(array[i]);
      }
      else if (array[i] < maxHeap.peek()){
        maxHeap.poll();
        maxHeap.offer(array[i]);
      }
    }
    int [] result = new int[k];
    for(int i=k-1; i>=0; i--){
      result[i] = maxHeap.poll();
    }
    return result;
  }
  */
  // M2: quick sort
  public int[] kSmallest(int[] array, int k){

    if (array.length == 0 || k==0){
      return new int[0];
    }
    quickSort(array, 0, array.length-1, k-1);
    // copy first K elements then sort
    int[] ret = Arrays.copyOf(array, k);
    Arrays.sort(ret);
    return ret;
  }

  public void quickSort(int[] array, int left, int right, int target){
    int midd = partition(array, left, right);
    if (midd == target){
      return;
    }
    else if(midd < target){
      quickSort(array, midd+1, right, target);
    }
    else{
      quickSort(array, left, midd-1, target);
    }
  }

  public int partition(int[] array, int left, int right){
    int pivot = array[right];
    int start = left;
    int end = right-1;
    while(start <= end){
      if (array[start] < pivot){
        start++;
      }
      else if (array[end] >= pivot){
        end--;
      }
      else{
        swap(array, start++, end--);
      }
    }
    swap(array, start, right);
    return start;
  }

  public void swap(int[] array, int left, int right){
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}
