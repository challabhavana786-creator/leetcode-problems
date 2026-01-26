import java.util.*;

public class MinimumAbsoluteDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i - 1] == minDiff) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        System.out.println(result);
        sc.close();
    }
}