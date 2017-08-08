public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    // Test case:
    // 1. {1, 5, 7, -1} with 6 => 2
    // 2. {1, 5, 7, -1, 5} with 6 => 3
    // 3. {1, 1, 1, 1} with 2 => 6
    // 4. {10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1} with 11 => 9
    if(array==null || array.length<1)
            return null;
    HashMap<Integer, Integer> map = new HashMap<>();
    HashSet<List<Integer>> res = new HashSet<List<Integer>>();
    for(int i=0; i<array.length;i++)
        map.put(i, array[i]);
    for(int i=0; i<array.length; i++){
      for(Map.Entry<Integer,Integer> entry: map.entrySet()){
        // ** avoid add itself
        if(entry.getValue() == target - array[i] && entry.getKey() != i){
            List<Integer> curr = new LinkedList<>();
            if(entry.getKey()<i){
                curr.add(entry.getKey());
                curr.add(i);
            }
            else{
                curr.add(i);
                curr.add(entry.getKey());
            }
            res.add(curr);
        }
      }
    }
    return new ArrayList<List<Integer>>(res);
  }
}
