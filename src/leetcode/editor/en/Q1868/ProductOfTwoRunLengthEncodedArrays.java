package leetcode.editor.en.Q1868;

import java.util.*;

//Run-length encoding is a compression algorithm that allows for an integer 
//array nums with many segments of consecutive repeated numbers to be represented by 
//a (generally smaller) 2D array encoded. Each encoded[i] = [vali, freqi] 
//describes the iᵗʰ segment of repeated numbers in nums where vali is the value that is 
//repeated freqi times. 
//
// 
// For example, nums = [1,1,1,2,2,2,2,2] is represented by the run-length 
//encoded array encoded = [[1,3],[2,5]]. Another way to read this is "three 1's 
//followed by five 2's". 
// 
//
// The product of two run-length encoded arrays encoded1 and encoded2 can be 
//calculated using the following steps: 
//
// 
// Expand both encoded1 and encoded2 into the full arrays nums1 and nums2 
//respectively. 
// Create a new array prodNums of length nums1.length and set prodNums[i] = 
//nums1[i] * nums2[i]. 
// Compress prodNums into a run-length encoded array and return it. 
// 
//
// You are given two run-length encoded arrays encoded1 and encoded2 
//representing full arrays nums1 and nums2 respectively. Both nums1 and nums2 have the same 
//length. Each encoded1[i] = [vali, freqi] describes the iᵗʰ segment of nums1, and 
//each encoded2[j] = [valj, freqj] describes the jᵗʰ segment of nums2. 
//
// Return the product of encoded1 and encoded2. 
//
// Note: Compression should be done such that the run-length encoded array has 
//the minimum possible length. 
//
// 
// Example 1: 
//
// 
//Input: encoded1 = [[1,3],[2,3]], encoded2 = [[6,3],[3,3]]
//Output: [[6,6]]
//Explanation: encoded1 expands to [1,1,1,2,2,2] and encoded2 expands to [6,6,6,
//3,3,3].
//prodNums = [6,6,6,6,6,6], which is compressed into the run-length encoded 
//array [[6,6]].
// 
//
// Example 2: 
//
// 
//Input: encoded1 = [[1,3],[2,1],[3,2]], encoded2 = [[2,3],[3,3]]
//Output: [[2,3],[6,1],[9,2]]
//Explanation: encoded1 expands to [1,1,1,2,3,3] and encoded2 expands to [2,2,2,
//3,3,3].
//prodNums = [2,2,2,6,9,9], which is compressed into the run-length encoded 
//array [[2,3],[6,1],[9,2]].
// 
//
// 
// Constraints: 
//
// 
// 1 <= encoded1.length, encoded2.length <= 10⁵ 
// encoded1[i].length == 2 
// encoded2[j].length == 2 
// 1 <= vali, freqi <= 10⁴ for each encoded1[i]. 
// 1 <= valj, freqj <= 10⁴ for each encoded2[j]. 
// The full arrays that encoded1 and encoded2 represent are the same length. 
// 
//
// 👍 271 👎 45


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        int p1 = 0;
        int p2 = 0;
        Stack<List<Integer>> result = new Stack<>();

        while (p1 < encoded1.length && p2 < encoded2.length) {

            if (encoded1[p1][1] == 0) p1++;
            if (encoded2[p2][1] == 0) p2++;
            if (encoded1[p1][1] >= encoded2[p2][1]) {
                while (p2 < encoded2.length && encoded1[p1][1] >= encoded2[p2][1]) {
                    List<Integer> element = new ArrayList<>();
                    element.add(encoded1[p1][0] * encoded2[p2][0]);
                    element.add(encoded2[p2][1]);
                    encoded1[p1][1] -= encoded2[p2][1];
                    addElement(result, element);
                    p2++;
                }
            } else {
                while (p1 < encoded1.length && encoded1[p1][1] < encoded2[p2][1]) {
                    List<Integer> element = new ArrayList<>();
                    element.add(encoded1[p1][0] * encoded2[p2][0]);
                    element.add(encoded1[p1][1]);
                    encoded2[p2][1] -= encoded1[p1][1];
                    addElement(result, element);
                    p1++;
                }
            }
        }
        return result;

    }

    private void addElement(Stack<List<Integer>> result, List<Integer> element) {
        if (result.size() > 0 && Objects.equals(element.get(0), result.peek().get(0))) {
            int total = element.get(1);
            total += result.pop().get(1);
            element.set(1, total);
        }
        result.push(element);
    }

}

//    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
//        List<Integer> decoded1 = decode(encoded1);
//        List<Integer> decoded2 = decode(encoded2);
//        List<Integer> decodedProd = new ArrayList<>();
//        for (int i = 0; i < decoded1.size(); i++) {
//            decodedProd.add(decoded1.get(i) * decoded2.get(i));
//        }
//        return encode(decodedProd);
//
//    }
//
//    private List<List<Integer>> encode(List<Integer> decoded) {
//        List<List<Integer>> result = new ArrayList<>();
//        for (int i = 0; i < decoded.size(); i++) {
//            int size = 1;
//            List<Integer> element = new ArrayList<>();
//            for (int j = i + 1; j < decoded.size(); j++) {
//                if (!Objects.equals(decoded.get(j), decoded.get(i))) {
//                    break;
//                }
//                size++;
//                i++;
//            }
//            element.add(decoded.get(i));
//            element.add(size);
//            result.add(element);
//        }
//        return result;
//    }
//
//    private List<Integer> decode(int[][] encoded) {
//        List<Integer> decoded = new ArrayList<>();
//        for (int[] ints : encoded) {
//            for (int j = 0; j < ints[1]; j++) {
//                decoded.add(ints[0]);
//            }
//        }
//        return decoded;
//    }
//leetcode submit region end(Prohibit modification and deletion)


public class ProductOfTwoRunLengthEncodedArrays extends Solution {
}