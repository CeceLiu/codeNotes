public class Solution {
  public int percentile95(List<Integer> lengths) {
    // Write your solution here.
    if(lengths==null || lengths.size()<1)
      return 0;
    int[] array = new int[4097];
    for(int len: lengths)
      array[len]++;
    int sum = 0;

    int len = 4097;
    while(sum<= 0.05*lengths.size()){
      // start from position 4096 when break the loop that is the return value
      sum += array[--len];
    }
    return len;
  }
}
