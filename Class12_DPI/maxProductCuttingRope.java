public class Solution {
  public int maxProduct(int length) {
    // Write your solution here.
    if (length <=2)
      return 1;
    // leave array[0] unused
    int[] array = new int[length+1];
    array[1] = 1;
    array[2] = 1;
    // after one cut, one of the partition is length of j
    // for remaining partition, we can take max of i-j and array[i-j]
    for(int i=3; i<length+1; i++){
      for (int j=1; j<=i/2; j++)
        array[i] = Math.max(
                  array[i],
                  j * Math.max(i-j, array[i-j])
                  );
    }
    return array[length];
  }
}
