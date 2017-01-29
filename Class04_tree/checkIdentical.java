/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
/*
If we tweak teh lchild with rchild of an arbitrary node in a binary tree, 
the structure of the tree are not changed. To determine whether two binary tree structures are identical
*/
public class Solution {
  public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
    // Write your solution here.
    if (one==null && two==null){
      return true;
    }
    else if (one==null || two==null){
      return false;
    }
    else if (one.key != two.key){
      return false;
    }
    return isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right)
          || isTweakedIdentical(one.right, two.left) && isTweakedIdentical(one.left, two.right);
  }
}
