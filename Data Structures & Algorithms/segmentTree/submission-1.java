class SegmentTree {
    private class Node {
        int L;
        int R;
        int sum;
        Node left;
        Node right;
        public Node(int L, int R, int sum) {
            this.L = L;
            this.R = R;
            this.sum = sum;
        }
    }
    private Node root;

    public SegmentTree(int[] nums) {
        this.root = buildTree(nums, 0, nums.length-1);
    }

    private Node buildTree(int[] nums, int L, int R) {
        if (L == R) {
            return new Node(L, R, nums[L]);
        }

        int M = L + (R - L) / 2;
        Node x = new Node(L, R, 0);

        x.left = buildTree(nums, L, M);
        x.right = buildTree(nums, M + 1, R);
        x.sum = x.left.sum + x.right.sum;
        return x;
    }

    public void update(int index, int val) {
        this.root = update(this.root, index, val);
    }

    private Node update(Node x, int index, int val) {
        if (x.L == x.R ) {
            x.sum = val;
            return x;
        }

        int M = x.L + (x.R - x.L) / 2;
        if (index <= M) {
            x.left = update(x.left, index, val);
        } else {
            x.right = update(x.right, index, val);
        }
        x.sum = x.left.sum + x.right.sum;
        return x;
    }

    public int query(int L, int R) {
        return query(this.root, L, R);
    }

    private int query(Node x, int L, int R) {
        if (x.L == x.R) {
            return x.sum;
        }

        int M = x.L + (x.R - x.L) / 2;

        if (R <= M) {
            return query(x.left, L, R);
        } else if (L > M) {
            return query(x.right, L, R);
        } else {
            return query(x.left, L, M) + query(x.right, M + 1, R);
        }

    }
}
