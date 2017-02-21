public class Solution {
  public int[] reorder(int[] array) {
    // ABCD1234 -> A1B2C3D4
    // AB CD | 12 34 
    //    DC | 21 => 12 | CD
    // => AB 12 | CD 34 
    //    A 1 B 2 | C 3 D 4
    if (array == null || array.length <1){
      return array;
    }
    int length = array.length;
    // maks sure only pass even length array
    if(length %2 == 0){
      reorder(array, 0, length-1);
    }
    else
      reorder(array, 0, length-2);
    return array;
  }
  
  public void reorder(int[] array, int left, int right){
    if(right-left <=1)
      return;
    int size = right-left+1;
    int midd = left + size/2;
    int leftMidd = left + size/4;
    int rightMidd = left + size * 3/4;
    
    reverse(array, leftMidd, midd-1);
    reverse(array, midd, rightMidd-1);
    reverse(array, leftMidd, rightMidd-1); // CD12 -> DC21 -> 12CD
    
    /*
    reorder(array, left, left + 2*(leftMidd-left)-1);
    reorder(array, left+2*(leftMidd-left), right);
    */
    reorder(array, left, midd-1);
    reorder(array, midd, right);
  }
  
  private void reverse(int[] array, int left, int right){
    while(left < right){
      swap(array, left++, right--);
    }
  }
  
  private void swap(int[] array, int left, int right){
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
  
}
