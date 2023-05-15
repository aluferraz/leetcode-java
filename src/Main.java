import leetcode.editor.en.Q1035.UncrossedLines;
import leetcode.editor.en.Q1220.CountVowelsPermutation;
import leetcode.editor.en.Q1259.HandshakesThatDontCross;
import leetcode.editor.en.Q1498.NumberOfSubsequencesThatSatisfyTheGivenSumCondition;
import leetcode.editor.en.Q1697.CheckingExistenceOfEdgeLengthLimitedPaths;
import leetcode.editor.en.Q1752.CheckIfArrayIsSortedAndRotated;
import leetcode.editor.en.Q1799.MaximizeScoreAfterNOperations;
import leetcode.editor.en.Q188.BestTimeToBuyAndSellStockIv;
import leetcode.editor.en.Q1964.FindTheLongestValidObstacleCourseAtEachPosition;
import leetcode.editor.en.Q2466.CountWaysToBuildGoodStrings;
import leetcode.editor.en.Q311.SparseMatrixMultiplication;
import leetcode.editor.en.Q354.RussianDollEnvelopes;
import leetcode.editor.en.Q376.WiggleSubsequence;
import leetcode.editor.en.Q377.CombinationSumIv;
import leetcode.editor.en.Q474.OnesAndZeroes;
import leetcode.editor.en.Q518.CoinChangeII;
import leetcode.editor.en.Q54.SpiralMatrix;
import leetcode.editor.en.Q649.Dota2Senate;
import leetcode.editor.en.Q651.FourKeysKeyboard;
import leetcode.editor.en.Q91.DecodeWays;
import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println(new MaximizeScoreAfterNOperations().maxScore(toIntArray("[370435,481435,953948,282360,691237,574616,638525,764832]\n")));

    }


    private static String[] toStringArrayFromFile(String resourceName) {
        //String resourceName = "testcase.txt";
        InputStream is = Main.class.getResourceAsStream(resourceName);
        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + resourceName);
        }
        JSONTokener tokener = new JSONTokener(is);
        JSONArray jsonArray = new JSONArray(tokener);
        String[] result = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            result[i] = jsonArray.getString(i);
        }
        return result;
    }

    private static int[] toIntArrayFromFile(String resourceName) {
        //String resourceName = "testcase.txt";
        InputStream is = Main.class.getResourceAsStream(resourceName);
        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + resourceName);
        }
        JSONTokener tokener = new JSONTokener(is);
        JSONArray jsonArray = new JSONArray(tokener);
        int[] result = new int[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            result[i] = jsonArray.getInt(i);
        }
        return result;
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

    private static List<String> toStringList(String s) {
        JSONArray jsonArray = new JSONArray(s);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            result.add(jsonArray.getString(i));
        }
        return result;
    }

    private static String[][] toStringMatrix(String s) {
        JSONArray jsonArray = new JSONArray(s);
        String[][] result = new String[jsonArray.length()][jsonArray.getJSONArray(0).length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONArray row = jsonArray.getJSONArray(i);
            for (int j = 0; j < row.length(); j++) {
                result[i][j] = row.getString(j);
            }
        }
        return result;
    }

    private static List<List<String>> toStringMatrixList(String s) {
        JSONArray jsonArray = new JSONArray(s);
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONArray row = jsonArray.getJSONArray(i);
            List<String> resultRow = new ArrayList<>();
            for (int j = 0; j < row.length(); j++) {
                resultRow.add(row.getString(j));
            }
            result.add(resultRow);
        }
        return result;
    }

    private static char[] toCharArray(String s) {
        JSONArray jsonArray = new JSONArray(s);
        char[] result = new char[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            result[i] = jsonArray.getString(i).charAt(0);
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
            result[i] = new int[row.length()];
            for (int j = 0; j < row.length(); j++) {
                result[i][j] = row.getInt(j);
            }
        }
        return result;
    }

    private static List<List<Integer>> toIntMatrixList(String s) {
        JSONArray jsonArray = new JSONArray(s);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONArray row = jsonArray.getJSONArray(i);
            ArrayList<Integer> resultRow = new ArrayList<>();
            for (int j = 0; j < row.length(); j++) {
                resultRow.add(row.getInt(j));
            }
            result.add(resultRow);
        }
        return result;
    }

    private static int[][] toIntMatrixFromFile() {
        String resourceName = "testcase.txt";
        InputStream is = Main.class.getResourceAsStream(resourceName);
        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + resourceName);
        }
        JSONTokener tokener = new JSONTokener(is);
        JSONArray jsonArray = new JSONArray(tokener);
        int[][] result = new int[jsonArray.length()][jsonArray.getJSONArray(0).length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONArray row = jsonArray.getJSONArray(i);
            result[i] = new int[row.length()];
            for (int j = 0; j < row.length(); j++) {
                result[i][j] = row.getInt(j);
            }
        }
        return result;
    }

    private static List<List<Integer>> twoDArrayToList(int[][] twoDArray) {
        List<List<Integer>> list = new ArrayList<>();
        for (int[] array : twoDArray) {
            List<Integer> row = new ArrayList<>();
            for (int num :
                    array) {
                row.add(num);
            }
            list.add(row);
        }
        return list;
    }
}



