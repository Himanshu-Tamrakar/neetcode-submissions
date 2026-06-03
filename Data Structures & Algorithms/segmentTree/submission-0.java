class SegmentTree {

    private static class Node {
        private int L;
        private int R;
        private int val = 0;
        Node left, right;

        public Node(int l, int r) {
            L = l;
            R = r;
        }
    }
    private Node root;

    public SegmentTree(int[] nums) {
        build(nums);
    }

    private void build(int[] nums) {
        root = build(root, nums, 0, nums.length-1);
    }

    private Node build(Node x, int[] nums, int l, int r) {
        if (x == null) x = new Node(l, r);
        if (l == r) {
            x.val = nums[l];
            return x;
        }

        int mid = l + (r-l) / 2;

        x.left = build(x.left, nums, l, mid);
        x.right = build(x.right, nums, mid+1, r);
        x.val = x.left.val + x.right.val;
        return x;
    }

    public void update(int index, int val) {
        root = update(root, index, val);
    }

    private Node update(Node x, int index, int val) {
        if (x.L == x.R) {
            x.val = val;
            return x;
        }
        int mid = x.L + (x.R-x.L) / 2;

        if (index <= mid) {
            x.left = update(x.left, index, val);
        } else {
            x.right = update(x.right, index, val);
        }
        x.val = x.left.val + x.right.val;
        return x;

    }

    public int query(int L, int R) {
        return query(root, L, R);
    }

    private int query(Node x, int L, int R) {
        if (x == null) return -1;

        int l = x.L;
        int r = x.R;

        if (L == l && R == r) return x.val;

        int mid = l + (r-l) / 2;

        if (L > mid) {
            return query(x.right, L, R);
        } else if (R <= mid) {
            return query(x.left, L, R);
        } else {
            return query(x.left, L, mid) + query(x.right, mid+1, R);
        }
    }
}
