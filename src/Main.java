import leetcode.editor.en.Q1136.ParallelCourses;
import leetcode.editor.en.Q260.SingleNumberIii;
import leetcode.editor.en.Q864.ShortestPathToGetAllKeys;
import leetcode.editor.en.Q995.MinimumNumberOfKConsecutiveBitFlips;
import org.json.JSONArray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfKConsecutiveBitFlips().minKBitFlips(toIntArray("[0,0,0,1,0,1,1,0]"), 3));
    }


    private static String[] toStringArray(String s) {
        JSONArray jsonArray = new JSONArray(s);
        String[] result = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            result[i] = jsonArray.getString(i);
        }
        return result;
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



