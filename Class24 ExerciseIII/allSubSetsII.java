public class Solution {
  public List<String> subSets(String set) {
    // Write your solution here.
    List<String> res = new LinkedList<>();
    StringBuilder sbd = new StringBuilder();
    if(set==null)
      return res;
    HashMap<String, Boolean> map = new HashMap<>();
    subSets(set, 0, sbd, res, map);
    return res;
  }
  
  public void subSets(String set, int index, StringBuilder sbd, List<String> res, HashMap<String, Boolean> map){
    // ** remove duplication
    if(!map.containsKey(sbd.toString())){
      res.add(sbd.toString());
      map.put(sbd.toString(), true);
    }
    for(int i=index; i<set.length(); i++){
      sbd.append(set.charAt(i));
      subSets(set, i+1, sbd, res, map);
      sbd.deleteCharAt(sbd.length()-1);
    }
  }
}
