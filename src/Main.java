import leetcode.editor.en.Q1061.LexicographicallySmallestEquivalentString;
import leetcode.editor.en.Q1443.MinimumTimeToCollectAllApplesInATree;
import leetcode.editor.en.Q1519.NumberOfNodesInTheSubTreeWithTheSameLabel;
import leetcode.editor.en.Q2214.MinimumHealthToBeatGame;
import leetcode.editor.en.Q2246.LongestPathWithDifferentAdjacentCharacters;
import leetcode.editor.en.Q2421.NumberOfGoodPaths;
import leetcode.editor.en.Q315.CountOfSmallerNumbersAfterSelf;
import leetcode.editor.en.Q387.FirstUniqueCharacterInAString;
import leetcode.editor.en.Q56.MergeIntervals;
import leetcode.editor.en.Q57.InsertInterval;
import leetcode.editor.en.Q59.SpiralMatrixIi;
import leetcode.editor.en.Q75.SortColors;
import leetcode.editor.en.Q918.MaximumSumCircularSubarray;
import leetcode.editor.en.Q974.SubarraySumsDivisibleByK;
import org.json.JSONArray;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new SpiralMatrixIi().generateMatrix(3)));
    }

    private static List<Boolean> toBooleanList(String s) {
        boolean[] arr = toBooleanArray(s);
        List<Boolean> res = new LinkedList<>();
        for (boolean b : arr) {
            res.add(b);
        }
        return res;
    }

    private static boolean[] toBooleanArray(String s) {
        JSONArray jsonArray = new JSONArray(s);
        boolean[] result = new boolean[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            result[i] = jsonArray.getBoolean(i);
        }
        return result;
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



