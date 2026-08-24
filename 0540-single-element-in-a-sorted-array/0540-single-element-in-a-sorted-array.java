class Solution {
    public int singleNonDuplicate(int[] a) {
        int n = a.length;

        if (n == 1) return a[0];
        if (a[0] != a[1]) return a[0];
        if (a[n - 1] != a[n - 2]) return a[n - 1];

        int l = 1;
        int h = n - 2;

        while (l <= h) {
            int mid = (l + h) / 2;

            // Found single element
            if (a[mid] != a[mid - 1] && a[mid] != a[mid + 1]) {
                return a[mid];
            }

            // mid is odd and forms a correct pair with left
            if (mid % 2 == 1 && a[mid] == a[mid - 1]) {
                l = mid + 1;
            }

            // mid is even and forms a correct pair with right
            else if (mid % 2 == 0 && a[mid] == a[mid + 1]) {
                l = mid + 1;
            }

            // Pair pattern is broken → single is on left
            else {
                h = mid - 1;
            }
        }

        return -1;
    }
}