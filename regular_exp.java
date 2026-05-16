public class regular_exp {
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() + 1];
        return support(s, p, 0, 0);
    }

    private boolean support(String s, String p, int i, int j) {

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int slen = s.length();
        int plen = p.length();

        if (j == plen) {
            return dp[i][j] = (i == slen);
        }

        boolean fm = (i < slen &&
                (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        if (j + 1 < plen && p.charAt(j + 1) == '*') {

            return dp[i][j] =support(s, p, i, j + 2) ||
                            (fm && support(s, p, i + 1, j));
        }

        return dp[i][j] =
                fm && support(s, p, i + 1, j + 1);
    }
}

    
