package leetcode.editor.en.Q649;
import java.util.*;
import javafx.util.Pair;

//In the world of Dota2, there are two parties: the Radiant and the Dire. 
//
// The Dota2 senate consists of senators coming from two parties. Now the 
//Senate wants to decide on a change in the Dota2 game. The voting for this change is a 
//round-based procedure. In each round, each senator can exercise one of the two 
//rights: 
//
// 
// Ban one senator's right: A senator can make another senator lose all his 
//rights in this and all the following rounds. 
// Announce the victory: If this senator found the senators who still have 
//rights to vote are all from the same party, he can announce the victory and decide 
//on the change in the game. 
// 
//
// Given a string senate representing each senator's party belonging. The 
//character 'R' and 'D' represent the Radiant party and the Dire party. Then if there 
//are n senators, the size of the given string will be n. 
//
// The round-based procedure starts from the first senator to the last senator 
//in the given order. This procedure will last until the end of voting. All the 
//senators who have lost their rights will be skipped during the procedure. 
//
// Suppose every senator is smart enough and will play the best strategy for 
//his own party. Predict which party will finally announce the victory and change 
//the Dota2 game. The output should be "Radiant" or "Dire". 
//
// 
// Example 1: 
//
// 
//Input: senate = "RD"
//Output: "Radiant"
//Explanation: 
//The first senator comes from Radiant and he can just ban the next senator's 
//right in round 1. 
//And the second senator can't exercise any rights anymore since his right has 
//been banned. 
//And in round 2, the first senator can just announce the victory since he is 
//the only guy in the senate who can vote.
// 
//
// Example 2: 
//
// 
//Input: senate = "RDD"
//Output: "Dire"
//Explanation: 
//The first senator comes from Radiant and he can just ban the next senator's 
//right in round 1. 
//And the second senator can't exercise any rights anymore since his right has 
//been banned. 
//And the third senator comes from Dire and he can ban the first senator's 
//right in round 1. 
//And in round 2, the third senator can just announce the victory since he is 
//the only guy in the senate who can vote.
// 
//
// 
// Constraints: 
//
// 
// n == senate.length 
// 1 <= n <= 10⁴ 
// senate[i] is either 'R' or 'D'. 
// 
//
// 👍 1025 👎 812


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String predictPartyVictory(String senate) {
        LinkedList<Character> senators = new LinkedList<>();
        int radiant = 0;
        int dire = 0;
        for (int i = 0; i < senate.length(); i++) {
            char c = senate.charAt(i);
            senators.add(c);
            switch (c) {
                case 'R' -> {
                    radiant++;
                }
                case 'D' -> {
                    dire++;
                }
            }

        }
        int removedRadiant = 0;
        int removedDire = 0;

        while (!senators.isEmpty() && removedRadiant != radiant && removedDire != dire) {
            char c = senators.pollFirst();
            switch (c) {
                case 'R' -> {
                    if (removedRadiant == 0) {
                        //We have at least one radian for the next round
                        senators.add('R');
                        removedDire++;
                    } else {
                        removedRadiant--;
                    }
                }
                case 'D' -> {
                    if (removedDire == 0) {
                        //We have at least one radian for the next round
                        senators.add('D');
                        removedRadiant++;
                    } else {
                        removedDire--;
                    }
                }
            }
        }

        if(removedRadiant == radiant ) return "Dire";
        return "Radiant";

    }

}
//leetcode submit region end(Prohibit modification and deletion)



public class Dota2Senate extends Solution {}