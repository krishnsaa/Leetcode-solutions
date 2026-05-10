import java.util.*;
public class reverse_conc_string {
    public long minArraySum(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int x : nums) {
            set.add(x);
        }

        long sum = 0;

        for (int x : nums) {

            int best = x;

            for (int d = 1; d * d <= x; d++) {

                if (x % d == 0) {
                    if (set.contains(d)) {
                        best = Math.min(best, d);
                    }
                    int other = x / d;

                    if (set.contains(other)) {
                        best = Math.min(best, other);
                    }
                }
            }

            sum += best;
        }

        return sum;
    }
    
}
