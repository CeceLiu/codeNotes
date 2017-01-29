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
  public boolean isBST(TreeNode root) {
    // Write your solution here.
    int min = Integer.MIN_VALUE;
    int max = Integer.MAX_VALUE;
    return isBST(root, min, max);
  }
  
  public boolean isBST(TreeNode root, int min, int max){
    if (root == null){
      return true;
    }
    /*
    if (root.key <= min || root.key >= max){
      return false;
    }
    return isBST(root.left, min, root.key) &&
           isBST(root.right, root.key, max);
    */

    if (root.key < max && root.key > min){
      return isBST(root.left, min, root.key) && isBST(root.right, root.key, max);
    }
    return false;
    
  }
}
