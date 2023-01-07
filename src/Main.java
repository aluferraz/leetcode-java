import leetcode.editor.en.Q121.BestTimeToBuyAndSellStock;
import leetcode.editor.en.Q1833.MaximumIceCreamBars;
import leetcode.editor.en.Q452.MinimumNumberOfArrowsToBurstBalloons;
import leetcode.editor.en.Q566.ReshapeTheMatrix;
import org.json.JSONArray;

public class Main {
    public static void main(String[] args) {
        new ReshapeTheMatrix().matrixReshape(toIntMatrix("[[1,2],[3,4]]"), 1, 4);

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



