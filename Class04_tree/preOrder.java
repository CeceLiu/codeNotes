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
  // Iteration
  public List<Integer> preOrder(TreeNode root){
    List<Integer> result = new ArrayList<Integer>();
    if (root == null){
      return result;
    }
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    stack.offerFirst(root);
    while(!stack.isEmpty()){
      TreeNode curr = stack.pollFirst();
      result.add(curr.key);
      // need to first visit LEFT tree but stack is FIFO so push RIGHT first
      if (curr.right != null){
        stack.offerFirst(curr.right);
      }
      if (curr.left != null){
        stack.offerFirst(curr.left);
      }
    }
    return result;
  }
  
  /* Recursion
  public List<Integer> preOrder(TreeNode root) {
    // Write your solution here.
    List<Integer> result = new ArrayList<Integer>();
    preOrder(root, result);
    return result;
  }
  
  public void preOrder(TreeNode root, List<Integer> result){
    if (root != null){
      result.add(root.key);
      preOrder(root.left, result);
      preOrder(root.right, result);
    }
  }
  */
}
