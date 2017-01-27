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
  // 1. Recursion
  public List<Integer> postOrder(TreeNode root) {
    // Write your solution here.
    List<Integer> result = new ArrayList<Integer>();
    postOrder(root, result);
    return result;
  }
  
  public void postOrder(TreeNode root, List<Integer> result){
    if (root != null){
      postOrder(root.left, result);
      postOrder(root.right, result);
      result.add(root.key);
    }
  }
  */
  //2. iteration with two stacks
  public List<Integer> postOrder(TreeNode root) {
    List<Integer> result = new LinkedList<Integer>();
    if (root == null){
      return result;
    }
    Deque<TreeNode> stack1 = new LinkedList<TreeNode>();
    Deque<TreeNode> stack2 = new LinkedList<TreeNode>();
    stack1.offerFirst(root);
    while(!stack1.isEmpty()){
      TreeNode curr = stack1.pollFirst();
      stack2.offerFirst(curr);
      if (curr.left != null){
        stack1.offerFirst(curr.left);
      }
      if (curr.right != null){
        stack1.offerFirst(curr.right);
      }
    }
    while( !stack2.isEmpty()){
      result.add(stack2.pollFirst().key);
    }
    
    return result;
  }
}
