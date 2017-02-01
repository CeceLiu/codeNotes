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
  // 1. level order traverse
  public boolean isCompleted(TreeNode root) {
    // Write your solution here.
    if (root == null){
      return true;
    }
    // flag setup to true when a non-full node was seen
    boolean flag = false;
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    while(!queue.isEmpty()){
      TreeNode curr = queue.poll();
      if(curr.left != null){
        if (flag){
          return false;
        }
        queue.offer(curr.left);
      }
      // update flag for current non-full node
      else{
        flag = true;
      }
      if (curr.right != null){
        if (flag){
          return false;
        }
        queue.offer(curr.right);
      }
      else{
        flag = true;
      }
    }
    return true;
  } */

  //2. Recursion
  // root index as i then lchild 2i+1 and rchild 2i+2
  // the assigned indices in case of a complete binary tree will strictly 
  // less be than the number of nodes in the complete binary tree
  public boolean isCompleted(TreeNode root){
    int totalNode = count(root);
    return isCompleted(root, 0, totalNode);
  }

  public boolean isCompleted(TreeNode root, int index, int totalNode){
    if (root == null)
      return true;

    if (index >= totalNode)
      return false;

    return isCompleted(root.left, 2*index+1, totalNode) &&
           isCompleted(root.right, 2*index+2, totalNode);
  }

  public int count(TreeNode root){
    if (root == null)
      return 0;
    return 1+count(root.left)+count(root.right);
  }
}
