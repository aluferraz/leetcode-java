
import leetcode.editor.en.Q131.PalindromePartitioning;
import leetcode.editor.en.Q132.PalindromePartitioningIi;
import leetcode.editor.en.Q416.PartitionEqualSubsetSum;
import leetcode.editor.en.Q486.PredictTheWinner;
import leetcode.editor.en.Q886.PossibleBipartition;
import leetcode.editor.en.Q983.MinimumCostForTickets;
import org.json.JSONArray;

public class Main {
    public static void main(String[] args) {

        System.out.println(new MinimumCostForTickets().mincostTickets(toIntArray("[1,4,6,7,8,20]"), toIntArray("[2,7,15]")));
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



