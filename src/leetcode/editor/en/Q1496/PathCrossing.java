package leetcode.editor.en.Q1496;

import java.util.*;

import javafx.util.Pair;

//Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing 
//moving one unit north, south, east, or west, respectively. You start at the 
//origin (0, 0) on a 2D plane and walk on the path specified by path. 
//
// Return true if the path crosses itself at any point, that is, if at any time 
//you are on a location you have previously visited. Return false otherwise. 
//
// 
// Example 1: 
// 
// 
//Input: path = "NES"
//Output: false 
//Explanation: Notice that the path doesn't cross any point more than once.
// 
//
// Example 2: 
// 
// 
//Input: path = "NESWW"
//Output: true
//Explanation: Notice that the path visits the origin twice. 
//
// 
// Constraints: 
//
// 
// 1 <= path.length <= 10⁴ 
// path[i] is either 'N', 'S', 'E', or 'W'. 
// 
//
// 👍 625 👎 17


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    HashMap<Character, int[]> directions = new HashMap<>();
    HashSet<Pair<Integer, Integer>> seen = new HashSet<>();

    public boolean isPathCrossing(String path) {
        directions.put('N', new int[]{-1, 0});
        directions.put('S', new int[]{1, 0});
        directions.put('E', new int[]{0, 1});
        directions.put('W', new int[]{0, -1});

        return isPathCrossing(new Pair<>(0, 0), 0, path);
    }

    public boolean isPathCrossing(Pair<Integer, Integer> coord, int i, String s) {
        if (i == s.length()) {
            return seen.contains(coord);
        }

        if (seen.contains(coord)) return true;
        seen.add(coord);
        int[] next = directions.get(s.charAt(i));

        return isPathCrossing(new Pair<>(coord.getKey() + next[0], coord.getValue() + next[1]), i + 1, s);

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class PathCrossing extends Solution {
}