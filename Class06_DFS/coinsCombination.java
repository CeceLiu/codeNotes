public class Solution {
  public List<List<Integer>> combinations(int target, int[] coins) {
    // Write your solution here.
    List<List<Integer>> solu = new ArrayList<List<Integer>>();
    List<Integer> curr = new ArrayList<Integer>();
    combinations(coins, target, 0, curr, solu);
    return solu;
  }
  
  public void combinations(int[] coins, int target, int index, List<Integer> curr, List<List<Integer>> solu){
    // terminate at last digit
    if(index == coins.length-1){
      int num = target%coins[index];
      if (num ==0){
        curr.add(target/coins[index]);
        solu.add(new ArrayList<Integer>(curr));
        curr.remove(curr.size()-1);
      }
      return;
    }
    int num_branches = target/coins[index];
    for (int i=0; i<= num_branches; i++){
      curr.add(i);
      int remaining = target - i*coins[index];
      combinations(coins, remaining, index+1, curr, solu);
      curr.remove(curr.size()-1);
    }
  }
}
