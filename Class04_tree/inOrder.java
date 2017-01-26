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
  // 1. Iteration with stack
  /*
  public List<Integer> inOrder(TreeNode root) {
    // Write your solution here.
    List<Integer> result = new ArrayList<Integer>();
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    TreeNode curr = root;
    while(curr != null || !stack.isEmpty()){
      if(curr != null){
        stack.offerFirst(curr);
        curr = curr.left;
      }
      else{
        curr = stack.pollFirst();
        result.add(curr.key);
        curr = curr.right;
      }
    }
    return result;
  }
  */
  //2. Recursion 
  public List<Integer> inOrder(TreeNode root){
    List<Integer> result = new ArrayList<Integer>();
    inOrder(root, result);
    return result;
  }
  
  public void inOrder(TreeNode root, List<Integer> result){
    if (root != null){
      inOrder(root.left, result);
      result.add(root.key);
      inOrder(root.right, result);
    }
  }
}
