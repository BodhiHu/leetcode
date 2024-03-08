class Solution {
    public int mySqrt(int x) {
        int left = 0, right = x;
        // 5, 101, 2
        // 9, 1001 >> 100, 4 >> 10, 2
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (mid <= x / mid) {
                // mid*mid <= x
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}