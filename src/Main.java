
import leetcode.editor.en.Q2244.MinimumRoundsToCompleteAllTasks;
import leetcode.editor.en.Q28.FindTheIndexOfTheFirstOccurrenceInAString;
import leetcode.editor.en.Q88.MergeSortedArray;
import leetcode.editor.en.Q980.UniquePathsIii;
import leetcode.editor.en.Q995.MinimumNumberOfKConsecutiveBitFlips;
import org.json.JSONArray;

public class Main {
    public static void main(String[] args) {
        new MergeSortedArray().merge(toIntArray("[4,5,6,0,0,0]\n"), 3, toIntArray("[1,2,3]\n"), 3);
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



