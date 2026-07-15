
public class advancesCommon {
    public int gcdOfOddEvenSums(int n) {
        int a = 0;
        int b = 0;
        for (int i = 1; i <= n; i++) {
            a += i * 2;
            b += i * 2 - 1;
        }
        return Utils.gcd(a, b);
    }
}

class Utils {
    public static class Pair<T1, T2> {

        T1 val1;
        T2 val2;

        public Pair(T1 val1, T2 val2) {
            this.val1 = val1;
            this.val2 = val2;
        }

        public int hashCode() {
            return val1.hashCode() * 65537 + val2.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Pair<?, ?> other)) {
                return false;
            }
            return val1.equals(other.val1) && val2.equals(other.val2);
        }
    }

    public static java.util.Comparator<int[]> intArrComparator(int[] ind) {
        return (e1, e2) -> {
            for (int i = 0; i < ind.length; i += 2) {
                long v = (long) e1[ind[i >> 1]] - e2[ind[i >> 1]];
                if (v != 0) {
                    return Long.signum(v) * ind[i + 1];
                }
            }
            return 0;
        };
    }

    public static java.util.Comparator<long[]> longArrComparator(int[] ind) {
        return (e1, e2) -> {
            for (int i = 0; i < ind.length; i += 2) {
                long v = e1[ind[i >> 1]] - e2[ind[i >> 1]];
                if (v != 0) {
                    return Long.signum(v) * ind[i + 1];
                }
            }
            return 0;
        };
    }

    public static long[] prefixSum(int[] arr) {
        long[] pSum = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pSum[i] = arr[i] + (i == 0 ? 0 : pSum[i - 1]);
        }
        return pSum;
    }

    public static long[] prefixSum(long[] arr) {
        long[] pSum = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pSum[i] = arr[i] + (i == 0 ? 0 : pSum[i - 1]);
        }
        return pSum;
    }

    public static int[] prefixMax(int[] arr) {
        int[] pMax = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pMax[i] = i == 0 ? arr[i] : Math.max(arr[i], pMax[i - 1]);
        }
        return pMax;
    }

    public static long[] prefixMax(long[] arr) {
        long[] pMax = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pMax[i] = i == 0 ? arr[i] : Math.max(arr[i], pMax[i - 1]);
        }
        return pMax;
    }

    public static int log2(long a) {
        return log(a, 2);
    }

    public static int log(long a, long b) {
        int res = 0;
        while (a >= b) {
            res++;
            a /= b;
        }
        return res;
    }

    public static long modPow(long a, long x, long mod) {
        long res = 1;
        while (x > 0) {
            if ((x & 1) == 1) {
                res = res * a % mod;
            }
            x >>= 1;
            a = a * a % mod;
        }
        return res;
    }

    public static long modInv(long a, long mod) {
        return modPow(a, mod - 2, mod);
    }
    
    public static int gcd(int a, int b) {
        if (a < b) {
            int c = a;
            a = b;
            b = c;
        }
        while (b > 0) {
            a %= b;
            int c = a;
            a = b;
            b = c;
        }
        return a;
    }
}