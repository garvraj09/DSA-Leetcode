import java.util.*;

class Solution {

    static class Interval {
        int l, r, w, idx;

        Interval(int l, int r, int w, int idx) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.idx = idx;
        }
    }

    static class Result {
        long score;
        int[] indices;

        Result(long score, int[] indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    Interval[] arr;
    int[] starts;
    int[] next;
    Result[][] memo;

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        arr = new Interval[n];

        for (int i = 0; i < n; i++) {

            int l = intervals.get(i).get(0);
            int r = intervals.get(i).get(1);
            int w = intervals.get(i).get(2);

            arr[i] = new Interval(l, r, w, i);
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.l != b.l)
                return Integer.compare(a.l, b.l);

            if (a.r != b.r)
                return Integer.compare(a.r, b.r);

            return Integer.compare(a.idx, b.idx);
        });

        starts = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = arr[i].l;
        }

        next = new int[n];

        for (int i = 0; i < n; i++) {
            next[i] = lowerBound(arr[i].r);
        }

        memo = new Result[n + 1][5];

        return solve(0, 4).indices;
    }

    private int lowerBound(int right) {

        int lo = 0;
        int hi = starts.length;

        while (lo < hi) {

            int mid = lo + (hi - lo) / 2;

            if (starts[mid] > right) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private Result solve(int i, int k) {

        if (i >= arr.length || k == 0) {
            return new Result(0, new int[0]);
        }

        if (memo[i][k] != null) {
            return memo[i][k];
        }

        Result skip = solve(i + 1, k);

        Result nextResult = solve(next[i], k - 1);

        long takeScore = arr[i].w + nextResult.score;

        int[] takeIndices = addSorted(
            nextResult.indices,
            arr[i].idx
        );

        Result take = new Result(takeScore, takeIndices);

        Result best;

        if (take.score > skip.score) {
            best = take;
        }
        else if (take.score < skip.score) {
            best = skip;
        }
        else {
            best = lexicographicallySmaller(take, skip);
        }

        memo[i][k] = best;

        return best;
    }

    // Insert value into already sorted array
    private int[] addSorted(int[] arr, int value) {

        int[] result = new int[arr.length + 1];

        int i = 0;

        while (i < arr.length && arr[i] < value) {
            result[i] = arr[i];
            i++;
        }

        result[i] = value;

        while (i < arr.length) {
            result[i + 1] = arr[i];
            i++;
        }

        return result;
    }

    private Result lexicographicallySmaller(Result a, Result b) {

        int len = Math.min(
            a.indices.length,
            b.indices.length
        );

        for (int i = 0; i < len; i++) {

            if (a.indices[i] < b.indices[i]) {
                return a;
            }

            if (a.indices[i] > b.indices[i]) {
                return b;
            }
        }
        if (a.indices.length <= b.indices.length) {
            return a;
        }

        return b;
    }
}