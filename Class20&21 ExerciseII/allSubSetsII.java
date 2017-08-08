public class Solution {
  public List<String> subSets(String set) {
        // Write your solution here.
      List<String> res = new LinkedList<>();
      StringBuilder sbd = new StringBuilder();
      if(set==null)
          return res;
      char[] array = set.toCharArray();
      Arrays.sort(array);
      subSets(array, 0, sbd, res);
      return res;
    }

  public void subSets(char[] array, int index, StringBuilder sbd, List<String> res){
      res.add(sbd.toString());
      for(int i=index; i<array.length; i++){
        // *** ignore duplicate element; looking from the index onwards
          if(i==index || array[i] != array[i-1]){
              sbd.append(array[i]);
              subSets(array, i+1, sbd, res);
              sbd.deleteCharAt(sbd.length()-1);
          }
     }
  }
}
