public class Solution {
  public int[] largestAndSecond(int[] array) {
    // The first element is the largest number,
    // the second element is the second largest number.
    /*
    List<Integer> res = new LinkedList<>();
    for(int num:array)
      res.add(num);
    // map to maintain a list of numbers less than current key
    // key:index value:list of index
    HashMap<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>(); 
    while(res.size()>1){
      List<Integer> next = new LinkedList<>();
      for(int i=0; i<res.size(); i+=2){
        if(i+1 == res.size()){
          next.add(res.get(i));
        }
        else if(res.get(i) >= res.get(i+1)){
          next.add(res.get(i));
          List<Integer> curr = map.get(i);
          if(curr==null)
            map.put(i, new LinkedList<Integer>());
          else
            map.put(i, curr.add(i+1));
        }
        else{
          next.add(res.get(i+1));
          List<Integer> curr = map.get(i+1);
          if(curr==null)
            map.put(i+1, new LinkedList<Integer>());
          else
            map.put(i+1, curr.add(i));
        }
      }
      res = next;
    }
    return new int[]{res.get(0), getMax(map.get(res.get(0).index)};
    */
    
    // A single tranversal with two variables first/second
    // time O(n)
    if(array==null || array.length<2)
      return array;
    int sec = Integer.MIN_VALUE;
    int fir = Integer.MIN_VALUE;
    for(int i=0; i<array.length; i++){
      if(array[i]>=fir){
        sec = fir;
        fir=array[i];
      }
      if(array[i]<fir && array[i]>sec)
        sec = array[i];
    }
    if(sec == Integer.MIN_VALUE)
      return new int[]{fir, fir};
    else
      return new int[]{fir, sec};
  }
}
