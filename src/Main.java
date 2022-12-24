import leetcode.editor.en.Q174.DungeonGame;
import leetcode.editor.en.Q207.CourseSchedule;
import leetcode.editor.en.Q210.CourseScheduleIi;
import leetcode.editor.en.Q834.SumOfDistancesInTree;
import org.json.JSONArray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(new CourseScheduleIi().findOrder(4, toIntMatrix("[[1,0],[2,0],[3,1],[3,2]]"))));
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



