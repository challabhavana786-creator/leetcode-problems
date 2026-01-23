import java.util.*;

class MinimumPairRemoval {
    static class Pair {
        long sum;
        int idx;
        Pair(long s, int i) {
            sum = s;
            idx = i;
        }
    }

    public int minimumOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        int[] left = new int[n];
        int[] right = new int[n];
        boolean[] alive = new boolean[n];

        for (int i = 0; i < n; i++) {
            left[i] = i - 1;
            right[i] = i + 1;
            alive[i] = true;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.sum == b.sum ? a.idx - b.idx : Long.compare(a.sum, b.sum)
        );

        int badCount = 0;
        for (int i = 0; i < n - 1; i++) {
            pq.offer(new Pair((long) nums[i] + nums[i + 1], i));
            if (nums[i] > nums[i + 1]) badCount++;
        }

        int operations = 0;

        while (badCount > 0) {
            Pair p;
            while (true) {
                p = pq.poll();
                int i = p.idx;
                if (i >= 0 && alive[i] && right[i] < n && alive[right[i]]) break;
            }

            int i = p.idx;
            int j = right[i];

            int li = left[i];
            int rj = right[j];

            if (li != -1 && nums[li] > nums[i]) badCount--;
            if (nums[i] > nums[j]) badCount--;
            if (rj < n && nums[j] > nums[rj]) badCount--;

            nums[i] += nums[j];
            alive[j] = false;

            right[i] = rj;
            if (rj < n) left[rj] = i;

            if (li != -1 && nums[li] > nums[i]) badCount++;
            if (rj < n && nums[i] > nums[rj]) badCount++;

            if (li != -1) pq.offer(new Pair((long) nums[li] + nums[i], li));
            if (rj < n) pq.offer(new Pair((long) nums[i] + nums[rj], i));

            operations++;
        }

        return operations;
    }
}
