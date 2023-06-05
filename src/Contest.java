import javafx.util.Pair;

import java.util.*;

class Solution {


    HashMap<Integer, TreeSet<Integer[]>> sortedRowsRight = new HashMap<>();
    HashMap<Integer, TreeSet<Integer[]>> sortedColsRight = new HashMap<>();

    HashMap<Integer, TreeSet<Integer[]>> sortedRowsLeft = new HashMap<>();
    HashMap<Integer, TreeSet<Integer[]>> sortedColsLeft = new HashMap<>();


    HashSet<Pair<Integer, Integer>> visited = new HashSet<>();

    HashMap<Pair<Integer, Integer>, Integer> cache = new HashMap<>();

    public int maxIncreasingCells(int[][] mat) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[2], b[2]);
        });

        HashMap<Integer, int[]> cols = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                int[] colArr = cols.getOrDefault(j, new int[mat.length]);
                colArr[i] = mat[i][j];
                cols.put(j, colArr);

                pq.add(new int[]{i, j, mat[i][j]});

                sortedRowsRight.computeIfAbsent(i, (v) -> new TreeSet<>((a, b) -> {
                    if (a[1].equals(b[1])) {
                        return Integer.compare(a[0], b[0]);
                    }
                    return Integer.compare(a[1], b[1]);
                })).add(new Integer[]{i, mat[i][j], i, j});

                sortedRowsLeft.computeIfAbsent(i, (v) -> new TreeSet<>((a, b) -> {
                    if (a[1].equals(b[1])) {
                        return -Integer.compare(a[0], b[0]);
                    }
                    return Integer.compare(a[1], b[1]);
                })).add(new Integer[]{i, mat[i][j], i, j});


                sortedColsRight.computeIfAbsent(j, (v) -> new TreeSet<>((a, b) -> {
                    if (a[1].equals(b[1])) {
                        return Integer.compare(a[0], b[0]);
                    }
                    return Integer.compare(a[1], b[1]);
                })).add(new Integer[]{j, mat[i][j], i, j});

                sortedColsLeft.computeIfAbsent(j, (v) -> new TreeSet<>((a, b) -> {
                    if (a[1].equals(b[1])) {
                        return -Integer.compare(a[0], b[0]);
                    }
                    return Integer.compare(a[1], b[1]);
                })).add(new Integer[]{j, mat[i][j], i, j});
            }
        }


        int best = 1;
        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            best = Math.max(best, dfs(info[0], info[1], mat));
            visited = new HashSet<>();
        }


        return best;


    }


    private int dfs(Integer i, Integer j, int[][] mat) {
        if (!isValidIdx(i, j, mat)) return 0;
        Pair<Integer, Integer> vist = new Pair<>(i, j);
        if (visited.contains(vist)) return 0;
        if (cache.containsKey(vist)) return cache.get(vist);
        visited.add(vist);


        int best = 1;

        TreeSet<Integer[]> NGERRow = sortedRowsRight.get(i);
        TreeSet<Integer[]> NGELRow = sortedRowsLeft.get(i);

        TreeSet<Integer[]> NGERCol = sortedColsRight.get(j);
        TreeSet<Integer[]> NGELCol = sortedColsLeft.get(j);

        Integer[] nRow = NGERRow.higher(new Integer[]{i, mat[i][j], i, j});
        while (nRow != null && visited.contains(new Pair<>(nRow[2], nRow[3]))) {
            nRow = NGERRow.higher(new Integer[]{nRow[2], mat[nRow[2]][nRow[3]], nRow[2], nRow[3]});
        }
        Integer[] nCol = NGERCol.higher(new Integer[]{j, mat[i][j], i, j});

        while (nCol != null && visited.contains(new Pair<>(nCol[2], nCol[3]))) {
            nCol = NGERCol.higher(new Integer[]{nCol[2], mat[nCol[2]][nCol[3]], nCol[2], nCol[3]});
        }

        if (nRow != null) {
            best = Math.max(best, 1 + dfs(nRow[2], nRow[3], mat));
        }
        if (nCol != null) {
            best = Math.max(best, 1 + dfs(nCol[2], nCol[3], mat));
        }

        nRow = NGELRow.higher(new Integer[]{i, mat[i][j], i, j});
        while (nRow != null && visited.contains(new Pair<>(nRow[2], nRow[3]))) {
            nRow = NGELRow.higher(new Integer[]{nRow[2], mat[nRow[2]][nRow[3]], nRow[2], nRow[3]});
        }


        nCol = NGELCol.higher(new Integer[]{j, mat[i][j], i, j});

        while (nCol != null && visited.contains(new Pair<>(nCol[2], nCol[3]))) {
            nCol = NGELCol.higher(new Integer[]{nCol[2], mat[nCol[2]][nCol[3]], nCol[2], nCol[3]});
        }
        if (nRow != null) {
            best = Math.max(best, 1 + dfs(nRow[2], nRow[3], mat));
        }
        if (nCol != null) {
            best = Math.max(best, 1 + dfs(nCol[2], nCol[3], mat));
        }
        visited.remove(vist);
        cache.put(vist, best);
        return best;

    }


    private boolean isValidIdx(int i, int j, int[][] grid) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[i].length;
    }

}

public class Contest extends Solution {
}