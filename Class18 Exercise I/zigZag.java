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
  public List<Integer> zigZag(TreeNode root) {
    // To print the nodes in spiral order, nodes at different levels should be printed in alternating order.
    /* M1: iteration
    List<Integer> res = new LinkedList<>();
    if(root==null)
      return res;
    // two stacks print left-right and right-left
    Deque<TreeNode> s1 = new LinkedList<>();
    Deque<TreeNode> s2 = new LinkedList<>();
    s1.offerFirst(root);
    
    while(!s1.isEmpty() || !s2.isEmpty()){
      while(!s1.isEmpty()){
        TreeNode curr = s1.pollFirst();
        res.add(curr.key);
        if(curr.right!=null)
          s2.offerFirst(curr.right);
        if(curr.left != null)
          s2.offerFirst(curr.left);
      }
      while(!s2.isEmpty()){
        TreeNode curr = s2.pollFirst();
        res.add(curr.key);
        if(curr.left!=null)
          s1.offerFirst(curr.left);
        if(curr.right!=null)
          s1.offerFirst(curr.right);
      }
    }
    return res;
    */
    
    // M2: Recursion
    List<Integer> res = new LinkedList<>();
    if(root==null)
      return res;
    boolean l2r = false;
    int h = getHeight(root);
    for(int i=1; i<=h; i++){
      getNodes(root, i, l2r, res);
      l2r = !l2r;
    }
    return res;
  }
  
  public int getHeight(TreeNode root){
    if(root==null)
      return 0;
    int leftH = getHeight(root.left);
    int rightH = getHeight(root.right);
    return leftH>rightH? leftH+1: rightH+1;
  }
  
  public void getNodes(TreeNode node, int level, boolean l2r, List<Integer> res){
    if(node==null)
      return;
    if(level==1)
      res.add(node.key);
    if(level>1){
      if(l2r){
        getNodes(node.left, level-1, l2r, res);
        getNodes(node.right, level-1, l2r, res);
      }
      else{
        getNodes(node.right, level-1, l2r, res);
        getNodes(node.left, level-1, l2r, res);
      }
    }
  }
  
}
