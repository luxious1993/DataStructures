public class MyBinarySearchTree {
    TreeNode root;

    MyBinarySearchTree() {
        root = null;
    }

    public TreeNode search(int val) {
        if (root == null) {
            return null;
        }
        return search(root, val);
    }
    private TreeNode search(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return search(root.left, val);
        } else {
            return search(root.right, val);
        }
    }

    public boolean insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return true;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val == val) {
                return false;
            }
            if (cur.val > val && cur.left == null) {
                cur.left = new TreeNode(val);
                return true;
            } else if (cur.val > val) {
                cur = cur.left;
            }
            if (cur.val < val && cur.right == null) {
                cur.right = new TreeNode(val);
                return true;
            } else if (cur.val < val) {
                cur = cur.right;
            }
        }
        return false;
    }

    public void delete(int val) {
        if (root == null) {
            return;
        }
        root = delete(root, val);
    }
    private TreeNode delete(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        if (root.val > val) {
            root.left = delete(root.left, val);
            return root;
        } else if (root.val < val) {
            root.right = delete(root.right, val);
            return root;
        }

        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }

        if (root.right.left == null) {
            root.right.left = root.left;
            return root.right;
        }
        TreeNode node = findSmallest(root.right);
        root.right = delete(root.right, node.val);
        node.left = root.left;
        node.right = root.right;
        return node;
    }
    private TreeNode findSmallest(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
