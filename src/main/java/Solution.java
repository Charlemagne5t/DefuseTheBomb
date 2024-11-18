class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if (k == 0) {
            return res;
        }
        if (k > 0) {
            int sum = 0;
            for (int i = 1; i <= k; i++) {
                sum += code[i];
            }
            res[0] = sum;
            int j = k + 1;
            for (int i = 1; i < n; i++) {
                if (j == n) {
                    j = 0;
                }
                res[i] = res[i - 1] - code[i] + code[j];
                j++;

            }
        }
        if (k < 0) {
            k = -k;
            int sum = 0;
            for (int i = n - k; i < n; i++) {
                sum += code[i];
            }
            res[0] = sum;
            int j = n - k;
            for (int i = 1; i < n; i++) {
                if (j == n) {
                    j = 0;
                }
                res[i] = res[i - 1] + code[i - 1] - code[j];
                j++;

            }
        }

        return res;
    }
}