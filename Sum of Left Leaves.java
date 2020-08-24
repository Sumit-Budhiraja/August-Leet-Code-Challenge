class Solution {
    
    public int sumOfLeftLeaves(TreeNode root) {        
        return sum(root, false);
    }
    
    private int sum(TreeNode root, boolean isLeft) {
        
        if(root == null) return 0;
        if(root.left == null && root.right == null) return isLeft ? root.val : 0;
        return sum(root.left, true) + sum(root.right, false);
    }
}