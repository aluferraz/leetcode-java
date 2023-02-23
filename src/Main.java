import leetcode.editor.en.Q1011.CapacityToShipPackagesWithinDDays;
import leetcode.editor.en.Q1129.ShortestPathWithAlternatingColors;
import leetcode.editor.en.Q1151.MinimumSwapsToGroupAll1sTogether;
import leetcode.editor.en.Q1162.AsFarFromLandAsPossible;
import leetcode.editor.en.Q1557.MinimumNumberOfVerticesToReachAllNodes;
import leetcode.editor.en.Q1588.SumOfAllOddLengthSubarrays;
import leetcode.editor.en.Q2306.NamingACompany;
import leetcode.editor.en.Q2477.MinimumFuelCostToReportToTheCapital;
import leetcode.editor.en.Q297.SerializeAndDeserializeBinaryTree;
import leetcode.editor.en.Q305.NumberOfIslandsIi;
import leetcode.editor.en.Q325.MaximumSizeSubarraySumEqualsK;
import leetcode.editor.en.Q448.FindAllNumbersDisappearedInAnArray;
import leetcode.editor.en.Q540.SingleElementInASortedArray;
import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(new CapacityToShipPackagesWithinDDays().shipWithinDays(toIntArray("[1,2,3,4,5,6,7,8,9,10]"), 5));
    }


    private static String[] toStringArrayFromFile() {
        String resourceName = "testcase.txt";
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

    private static int[] toIntArrayFromFile() {
        String resourceName = "testcase.txt";
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



