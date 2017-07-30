public class Solution {
  public int[] largestAndSmallest(int[] array) {
    // The first element is the largest number,
    // the second element is the smallest number.
    if(array==null || array.length<1)
      return array;
    List<Integer> small = new LinkedList<>();
    List<Integer> large = new LinkedList<>();
    for(int i=0; i<array.length; i+=2){
      // ** check last elment and add to both list
      if(i+1==array.length){
        small.add(array[i]);
        large.add(array[i]);
      }
      else if(array[i]>=array[i+1]){
        small.add(array[i+1]);
        large.add(array[i]);
      }
      else{
        small.add(array[i]);
        large.add(array[i+1]);
      }
    }
    return new int[]{getLarge(large), getSmall(small)};
  }
  
  public int getLarge(List<Integer> large){
    int res = Integer.MIN_VALUE;
    // ** int instead of Integer
    for(int num:large){
      res = Math.max(num, res);
    }
    return res;
  }
  
  public int getSmall(List<Integer> small){
    int res = Integer.MAX_VALUE;
    for(int num:small){
      res = Math.min(num, res);
    }
    return res;
  }
}
