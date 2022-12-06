package leetcode.editor.en.Q42;

import java.awt.image.renderable.RenderableImage;
import java.util.*;

//Given n non-negative integers representing an elevation map where the width 
//of each bar is 1, compute how much water it can trap after raining. 
//
// 
// Example 1: 
// 
// 
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [
//0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) 
//are being trapped.
// 
//
// Example 2: 
//
// 
//Input: height = [4,2,0,3,2,5]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// 👍 24091 👎 334


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int[] LTR = new int[height.length];
        int[] RTL = new int[height.length];
        LTR[0] = height[0];
        RTL[height.length - 1] = height[height.length - 1];
        int water = 0;
        for (int i = 1; i < height.length; i++) {
            LTR[i] = Math.max(LTR[i - 1], height[i]);
            RTL[height.length - 1 - i] = Math.max(RTL[height.length - 1 - i + 1], height[height.length - 1 - i]);
        }
        for (int i = 0; i < height.length; i++) {
            int boundary = Math.min(LTR[i], RTL[i]);
            int captured = boundary - height[i];
            water += Math.max(captured, 0);
        }


        return water;

    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class TrappingRainWater extends Solution {
}