
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
  public TreeNode insert(TreeNode root, int key) {
    // ** only insert unique keys
    if(root==null){
      root = new TreeNode(key);
      return root;
    }
    if(root.key<key)
      root.right = insert(root.right, key);
    else if(root.key>key)
      root.left = insert(root.left, key);
    return root;
  }
}
