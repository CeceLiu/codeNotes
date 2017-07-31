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
  public TreeNode delete(TreeNode root, int key) {
    // case1: node to be deleted is leaf, simple remove the node
    // case2: node to be deleted has only one child, copy that child to node then delete child
    // case3: node to be deleted has two children, copy contents of in-order successor to current node
    //        then delete that successor; in BST that successor is the minimum value from right subtree
    if(root==null)
      return root;
    if(root.key<key)
      root.right = delete(root.right, key);
    else if(root.key>key)
      root.left = delete(root.left, key);
    else{
      // case3
      if(root.left!=null && root.right!=null){
        int minV = findSmallestInRight(root.right);
        root.key=minV;
        root.right = delete(root.right, minV);
      }
      // case2+case1
      else
        root= root.left==null ? root.right:root.left;
    }
    return root;
  }
  
  public int findSmallestInRight(TreeNode root){
    int minV = root.key;
    while(root.left!=null){
      minV = root.left.key;
      root=root.left;
    }
    return minV;
  }
  
  
}
