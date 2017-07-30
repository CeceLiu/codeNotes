public class Solution {
  public int[] sortSpecial(int[] A1, int[] A2) {
    //1. Use a sorted HashMap to store value in A1
    //2. for any elements in A2 present in map, add that value to result as many times as count, 
    //    remove that entry from map
    //3. add remaining elements in map
    // key:value in A1 value:count
    Map<Integer, int[]> map = new TreeMap<Integer, int[]>();
    for(int i=0;i<A1.length;i++){
      int[] count = map.get(A1[i]);
      if(count!=null)
        count[0]++;
      else
        map.put(A1[i], new int[]{1});
    }
    List<Integer> res = new LinkedList<>();
    for(int i=0; i<A2.length; i++){
      int[] count = map.get(A2[i]);
      if(count!=null){
        while(count[0] !=0){
          res.add(A2[i]);
          count[0]--;
        }
        map.remove(A2[i]);
      }
    }
    // ** Map.Entry<Integer, int[]> entry: map.entrySet()
    for(Map.Entry<Integer, int[]> entry: map.entrySet()){
      while(entry.getValue()[0]>0){
        res.add(entry.getKey());
        entry.getValue()[0]--;
      }
    }
    // ** no good way to convert List<Integer> to int[].. simply looping
    int[] solu = new int[res.size()];
    for(int i=0; i<res.size(); i++){
        solu[i] = res.get(i);
    }
    return solu;
  }
}
