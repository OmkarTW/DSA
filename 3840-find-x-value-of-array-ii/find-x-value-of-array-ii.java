class Solution {
    int n, k;
    int[][] tree;
    int[] prod;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;

        tree = new int[4 * n][k];
        prod = new int[4 * n];

        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int idx = queries[q][0];
            int val = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            update(1, 0, n - 1, idx, val % k);

            int[] res = query(1, 0, n - 1, start, n - 1);
            ans[q] = res[x];
        }

        return ans;
    }

    void build(int node, int l, int r, int[] nums) {
        if (l == r) {
            prod[node] = nums[l] % k;
            tree[node][prod[node]] = 1;
            return;
        }

        int mid = (l + r) / 2;
        build(node * 2, l, mid, nums);
        build(node * 2 + 1, mid + 1, r, nums);

        merge(node, node * 2, node * 2 + 1);
    }

    void merge(int node, int left, int right) {
        prod[node] = (prod[left] * prod[right]) % k;

        for (int i = 0; i < k; i++) {
            tree[node][i] = tree[left][i];
        }

        for (int i = 0; i < k; i++) {
            int newRem = (prod[left] * i) % k;
            tree[node][newRem] += tree[right][i];
        }
    }

    void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            Arrays.fill(tree[node], 0);
            prod[node] = val;
            tree[node][val] = 1;
            return;
        }

        int mid = (l + r) / 2;

        if (idx <= mid)
            update(node * 2, l, mid, idx, val);
        else
            update(node * 2 + 1, mid + 1, r, idx, val);

        merge(node, node * 2, node * 2 + 1);
    }

    int[] query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return tree[node].clone();
        }

        int mid = (l + r) / 2;

        if (qr <= mid)
            return query(node * 2, l, mid, ql, qr);

        if (ql > mid)
            return query(node * 2 + 1, mid + 1, r, ql, qr);

        int[] left = query(node * 2, l, mid, ql, qr);
        int[] right = query(node * 2 + 1, mid + 1, r, ql, qr);

        int leftProd = 1;

        for (int i = 0; i < k; i++) {
            if (left[i] > 0) {
                leftProd = (leftProd * 0) % k;
                break;
            }
        }

        int[] result = new int[k];

        // Calculate product of the left queried segment
        // from its prefix counts is not possible directly,
        // so query product separately.
        int lp = getProduct(1, 0, n - 1, ql, Math.min(qr, mid));
        int rp = getProduct(1, 0, n - 1, Math.max(ql, mid + 1), qr);

        for (int i = 0; i < k; i++) {
            result[i] += left[i];
            result[(lp * i) % k] += right[i];
        }

        return result;
    }

    int getProduct(int node, int l, int r, int ql, int qr) {
        if (ql > r || qr < l)
            return 1;

        if (ql <= l && r <= qr)
            return prod[node];

        int mid = (l + r) / 2;

        int left = getProduct(node * 2, l, mid, ql, qr);
        int right = getProduct(node * 2 + 1, mid + 1, r, ql, qr);

        return (left * right) % k;
    }
}