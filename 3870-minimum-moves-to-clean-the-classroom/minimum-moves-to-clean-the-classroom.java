import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0, sc = 0;
        int litterCount = 0;

        int[][] id = new int[m][n];
        for (int[] row : id) Arrays.fill(row, -1);

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char ch = classroom[r].charAt(c);

                if (ch == 'S') {
                    sr = r;
                    sc = c;
                } else if (ch == 'L') {
                    id[r][c] = litterCount++;
                }
            }
        }

        int target = (1 << litterCount) - 1;

        if (target == 0) return 0;

        int[][][] best = new int[m][n][1 << litterCount];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                Arrays.fill(best[r][c], -1);
            }
        }

        Queue<State> q = new ArrayDeque<>();

        best[sr][sc][0] = energy;
        q.offer(new State(sr, sc, energy, 0, 0));

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.mask == target) {
                return cur.moves;
            }

            if (cur.energy == 0) continue;

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n ||
                    classroom[nr].charAt(nc) == 'X') {
                    continue;
                }

                int newEnergy = cur.energy - 1;
                int newMask = cur.mask;

                char ch = classroom[nr].charAt(nc);

                if (ch == 'L') {
                    newMask |= 1 << id[nr][nc];
                }

                if (ch == 'R') {
                    newEnergy = energy;
                }

                if (newEnergy > best[nr][nc][newMask]) {
                    best[nr][nc][newMask] = newEnergy;

                    q.offer(new State(
                        nr,
                        nc,
                        newEnergy,
                        newMask,
                        cur.moves + 1
                    ));
                }
            }
        }

        return -1;
    }

    static class State {
        int r, c, energy, mask, moves;

        State(int r, int c, int energy, int mask, int moves) {
            this.r = r;
            this.c = c;
            this.energy = energy;
            this.mask = mask;
            this.moves = moves;
        }
    }
}