import leetcode.editor.en.Q862.ShortestSubarrayWithSumAtLeastK;
import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
//        System.out.println(new ShortestSubarrayWithSumAtLeastK().shortestSubarray(toIntArray("[-34,37,51,3,-12,-50,51,100,-47,99,34,14,-13,89,31,-14,-44,23,-38,6]\n"),151));
        System.out.println(new ShortestSubarrayWithSumAtLeastK().shortestSubarray(toIntArray("[56,-21,56,35,-9]\n"),61));
//        System.out.println(new ShortestSubarrayWithSumAtLeastK().shortestSubarray(toIntArray("[-10,36,13,93,41,-10,78,91,34,-47,-17,37,41,70,44,23,23,42,70,8]\n\n\n"),207));
//        System.out.println(new ShortestSubarrayWithSumAtLeastK().shortestSubarray(toIntArray("[-34,37,51,3,-12,-50,51,100,-47,99,34,14,-13,89,31,-14,-44,23,-38,6]\n"),151));


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



