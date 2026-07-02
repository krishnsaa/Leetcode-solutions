import java.util.*;
class bfs_graph_safe_walk {
    int n, m;
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        n = grid.size();
        m = grid.get(0).size();
        
        int startHealth = health - grid.get(0).get(0);
        if (startHealth <= 0) return false;
        int[][] maxHealthAtCell = new int[n][m];
        for (int[] row : maxHealthAtCell) Arrays.fill(row, -1);
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, startHealth});
        maxHealthAtCell[0][0] = startHealth;
        
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1], hp = curr[2];
            
            if (r == n-1 && c == m-1) return true;
            
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                
                int newHealth = hp - grid.get(nr).get(nc);
                if (newHealth <= 0) continue;
                
                if (newHealth > maxHealthAtCell[nr][nc]) {
                    maxHealthAtCell[nr][nc] = newHealth;
                    q.offer(new int[]{nr, nc, newHealth});
                }
            }
        }
        return false;
    }
}
