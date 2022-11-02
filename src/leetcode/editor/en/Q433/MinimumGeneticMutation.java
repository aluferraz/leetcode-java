package leetcode.editor.en.Q433;

//A gene string can be represented by an 8-character long string, with choices 
//from 'A', 'C', 'G', and 'T'. 
//
// Suppose we need to investigate a mutation from a gene string start to a gene 
//string end where one mutation is defined as one single character changed in the 
//gene string. 
//
// 
// For example, "AACCGGTT" --> "AACCGGTA" is one mutation. 
// 
//
// There is also a gene bank bank that records all the valid gene mutations. A 
//gene must be in bank to make it a valid gene string. 
//
// Given the two gene strings start and end and the gene bank bank, return the 
//minimum number of mutations needed to mutate from start to end. If there is no 
//such a mutation, return -1. 
//
// Note that the starting point is assumed to be valid, so it might not be 
//included in the bank. 
//
// 
// Example 1: 
//
// 
//Input: start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA",
//"AAACGGTA"]
//Output: 2
// 
//
// Example 3: 
//
// 
//Input: start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC",
//"AACCCCCC"]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// start.length == 8 
// end.length == 8 
// 0 <= bank.length <= 10 
// bank[i].length == 8 
// start, end, and bank[i] consist of only the characters ['A', 'C', 'G', 'T']. 
//
// 
//
// 👍 1783 👎 184


import java.util.*;

public class MinimumGeneticMutation {
    public static int minMutation(String start, String end, String[] bank) {
        return new Solution().minMutation(start, end, bank);
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> words = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        Collections.addAll(words, bank);
        if (!(words.contains(end))) return -1;
        words.add(start);
        queue.add(end);
        HashMap<String, ArrayList<String>> validDNAMutations = this.getMutations(words);
        int mutations = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String dna = queue.remove();
                if (dna.equals(start)) return mutations;
                if (visited.contains(dna)) continue;
                visited.add(dna);
                ArrayList<String> nextMutations = validDNAMutations.get(dna);
                for (String nextDNA : nextMutations) {
                    if (!visited.contains(nextDNA)) queue.add(nextDNA);
                }
            }
            mutations++;
        }
        return -1;
    }

    private HashMap<String, ArrayList<String>> getMutations(HashSet<String> words) {
        HashMap<String, ArrayList<String>> mutations = new HashMap<>();
        int n = words.size();
        String[] arr = new String[n];
        arr = words.toArray(arr);
        for (int i = 0; i < arr.length; i++) {
            String from = arr[i];
            ArrayList<String> validMutations = new ArrayList<>();
            for (int j = 0; j < arr.length; j++) {
                if (j == i) continue;
                String to = arr[j];
                if (canMutate(from, to)) {
                    validMutations.add(to);
                }
            }
            mutations.put(from, validMutations);
        }
        return mutations;
    }

    private boolean canMutate(String from, String to) {
        int diff = 0;
        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i) != to.charAt(i)) diff++;
        }
        return diff == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
