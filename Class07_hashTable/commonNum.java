public class Solution {
  public List<Integer> common(List<Integer> A, List<Integer> B) {
    // Write your solution here.
    /*
    List<Integer> solu = new ArrayList<Integer>();
    int i=0;
    int j=0;
    while(i<A.size() && j<B.size()){
      if (A.get(i) < B.get(j)){
        i++;
      }
      else if (A.get(i) > B.get(j)){
        j++;
      } 
      else{
        solu.add(A.get(i));
        i++;
        j++;
      }
    }
    return solu;
    */

    if (A.size() > B.size()){
      return common(B, A);
    }
    List<Integer> solu = new ArrayList<Integer>();
    HashMap<Integer, Integer> mapA = new HashMap<Integer, Integer>();
    for(int num: A){
      // int type can't compare with null so must declear as Integer
      Integer count = mapA.get(num);
      if (count != null){
        mapA.put(num, count+1);
      }
      else{
        mapA.put(num, 1);
      }
    }

    HashMap<Integer, Integer> mapB = new HashMap<Integer, Integer>();
    for(int num: B){
      Integer count = mapB.get(num);
      if (count != null){
        mapB.put(num, count+1);
      }
      else{
        mapB.put(num, 1);
      }
    }

    for(Map.Entry<Integer, Integer> entry: mapA.entrySet()){
      Integer count = mapB.get(entry.getKey());
      if (count !=null){
        int appear = Math.min(entry.getValue(), count);
        for (int i=0; i<appear; i++){
          solu.add(entry.getKey());
        }
      }
    }
    return solu;
  }
}
