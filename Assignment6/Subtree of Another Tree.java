class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) return false;
        return same(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    private boolean same(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.val == b.val && same(a.left, b.left) && same(a.right, b.right);
    }
    
}
