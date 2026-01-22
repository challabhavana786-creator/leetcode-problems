import java.util.*;
public class bitwise3315 {
    public static int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int val = nums.get(i);
            if ((val & 1) == 0) {
                ans[i] = -1;
                continue;
            }
            int best = Integer.MAX_VALUE;
            for (int k = 0; k <= 30; k++) {
                int sub = 1 << k;
                if (sub > val) break;
                int x = val - sub;
                if (x >= 0 && (x | (x + 1)) == val) {
                    best = Math.min(best, x);
                }
            }
            ans[i] = (best == Integer.MAX_VALUE) ? -1 : best;
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(sc.nextInt());
        }
        int[] result = minBitwiseArray(nums);
        for (int x : result) {
            System.out.print(x + " ");
        }
        sc.close();
    }
}