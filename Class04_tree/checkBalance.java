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
public class Solution {
  /*
  * There are two conventions to define height of Binary Tree
  * 1) Number of nodes on longest path from root to the deepest node. Return 0 when root==null
  * 2) Number of edges on longest path from root to the deepest node. Return -1 when root==null
  */
  /* M1: directly recursion
  public boolean isBalanced(TreeNode root) {
    // Write your solution here.
    if (root == null){
      return true;
    }
    int diff = getHeight(root.left) - getHeight(root.right);
    if ( Math.abs(diff) >1 ){
      return false;
    }
    return isBalanced(root.left) && isBalanced(root.right);
  }

  public Integer getHeight(TreeNode root){
    if (root == null){
      return 0;
    }
    int leftHeight = getHeight(root.left);
    int rightHeight = getHeight(root.right);
    return 1 + Math.max(leftHeight, rightHeight);
  }
  */
  // M2: break during getHeight of subtree, less time
  public boolean isBalanced(TreeNode root){
    if (root == null) return true;
    return getHeight(root) != -1;
  }
  
  public Integer getHeight(TreeNode root){
    if (root == null){
      return 0;
    }
    int leftH = getHeight(root.left);
    if (leftH == -1){
      return -1;
    }
    int rightH = getHeight(root.right);
    if (rightH == -1){
      return -1;
    }
    int diff = leftH - rightH;
    if ( Math.abs(diff) > 1){
      return -1;
    }
    return 1 + Math.max(leftH, rightH);
  }
  
}
