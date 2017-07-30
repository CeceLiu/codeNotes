/**
 * public class TreeNodeP {
 *   public int key;
 *   public TreeNodeP left;
 *   public TreeNodeP right;
 *   public TreeNodeP parent;
 *   public TreeNodeP(int key, TreeNodeP parent) {
 *     this.key = key;
 *     this.parent = parent;
 *   }
 * }
 */
public class Solution {
  /*
  public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
    // M1 with HashMap to maitain all ancestor for a single node
    // time O(hLogh) h is the height of binary tree and map takes O(logn) time to insert/search
    // space O(h)
    // ** HashMap can't accept primitive type arguments
    HashMap<TreeNodeP, Boolean> map = new HashMap<>();
    while(one!=null){
      map.put(one, true);
      one = one.parent;
    }
    while(two!=null){
      if(map.containsKey(two))
        return two;
      two = two.parent;
    }
    return null;
  }
  */

// M2 with O(1) space
  // If both nodes are at same level and if we traverse up using parent pointers of both nodes, 
  // the first common node in the path to root is lca.
 public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
    int oneL = getLength(one);
    int twoL = getLength(two);
    // ** pass the short node as first
    if(oneL<=twoL)
      return helper(one, two, twoL-oneL);
    else
      return helper(two, one, oneL-twoL);
  }
  
  public TreeNodeP helper(TreeNodeP small, TreeNodeP large, int diff){
    while(diff--!=0)
      large = large.parent;

    while(small!=null && large!=null){
      if(small==large)
        return large;
      small = small.parent;
      large = large.parent;
    }
    return null;
  }
  
  public int getLength(TreeNodeP node){
    int res = -1;
    while(node!=null){
      node = node.parent;
      res++;
    }
    return res;
  }
}
