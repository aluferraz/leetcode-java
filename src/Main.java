import leetcode.editor.en.Q210.CourseScheduleIi;
import leetcode.editor.en.Q310.MinimumHeightTrees;
import leetcode.editor.en.Q329.LongestIncreasingPathInAMatrix;
import leetcode.editor.en.Q790.DominoAndTrominoTiling;
import org.json.JSONArray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println(new LongestIncreasingPathInAMatrix().longestIncreasingPath(toIntMatrix("[[9,9,4],[6,6,8],[2,1,1]]")));
    }

    private static int[] toIntArray(String s) {
        JSONArray jsonArray = new JSONArray(s);
        int[] result = new int[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            result[i] = jsonArray.getInt(i);
        }
        return result;
    }

    private static int[][] toIntMatrix(String s) {
        JSONArray jsonArray = new JSONArray(s);
        int[][] result = new int[jsonArray.length()][jsonArray.getJSONArray(0).length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONArray row = jsonArray.getJSONArray(i);
            for (int j = 0; j < row.length(); j++) {
                result[i][j] = row.getInt(j);
            }
        }
        return result;
    }

}



