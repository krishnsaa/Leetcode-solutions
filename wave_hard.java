import java.util.*;
class wave_hard {
    long[][][][] countMemo;
    long[][][][] waviMemo;

    public long totalWaviness(long num1, long num2) {
        countMemo = new long[20][2][11][11];
        waviMemo = new long[20][2][11][11];

        for (long[][][] a : countMemo) {
            for (long[][] b : a) {
                for (long[] c : b) {
                    Arrays.fill(c, -1);
                }
            }
        }

        for (long[][][] a : waviMemo) {
            for (long[][] b : a) {
                for (long[] c : b) {
                    Arrays.fill(c, -1);
                }
            }
        }

        return solve(String.valueOf(num2)) - solve(String.valueOf(num1 - 1));
    }
    private long solve(String limit) {
        if (limit.equals("0") || limit.equals("-1"))
            return 0;
        return dfs(limit, 0, true, true, 10, 10)[1];
    }

    private long[] dfs(String limit, int idx, boolean tight, boolean lz, int ppd, int pd) {
        if (idx == limit.length()) {
            return new long[] { 1, 0 };
        }

        int rem = limit.length() - idx;
        int ilz = lz ? 1 : 0;

        if (!tight && countMemo[rem][ilz][ppd][pd] != -1) {
            return new long[] {
                    countMemo[rem][ilz][ppd][pd],
                    waviMemo[rem][ilz][ppd][pd]
            };
        }

        long totalCount = 0;
        long totalWavi = 0;
        int maxD = tight ? (limit.charAt(idx) - '0') : 9;

        for (int d = 0; d <= maxD; d++) {
            boolean newTight = tight && (d == maxD);
            boolean newLz = lz && (d == 0);

            int newPpd = 10;
            int newPd = 10;

            if (newLz) {
                newPpd = 10;
                newPd = 10;
            } else if (lz) {
                newPpd = 10;
                newPd = d;
            } else {
                newPpd = pd;
                newPd = d;
            }

            int isWavy = 0;
            if (ppd != 10 && pd != 10) {
                if ((pd > ppd && pd > d) || (pd < ppd && pd < d)) {
                    isWavy = 1;
                }
            }

            long[] res = dfs(limit, idx + 1, newTight, newLz, newPpd, newPd);

            totalCount += res[0];
            totalWavi += res[1] + res[0] * isWavy;
        }

        if (!tight) {
            countMemo[rem][ilz][ppd][pd] = totalCount;
            waviMemo[rem][ilz][ppd][pd] = totalWavi;
        }

        return new long[] { totalCount, totalWavi };
    }
}