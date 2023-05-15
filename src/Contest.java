import java.util.*;

import java.math.BigInteger;

class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        if (derived.length == 1) return derived[0] == 0;
        int[] original = new int[derived.length];
        Arrays.fill(original, -1);
        for (int i = 0; i < derived.length; i++) {
            if (derived[i] == 0) {
                original[i] = 0;
                original[(i + 1) % derived.length] = 0;
            }
        }
        return doesValidArrayExistHelper(0, derived, original);
    }

    public boolean doesValidArrayExistHelper(int i, int[] derived, int[] original) {
        if (i == derived.length) return true;

        if (derived[i] == 1) {
            if (original[i] == 0 && original[(i + 1) % derived.length] == 0) return false;
            if (original[i] == 0) {
                if (original[(i + 1) % derived.length] == 1) return false;
                original[(i + 1) % derived.length] = 0;
            }
            int before = (i - 1) < 0 ? derived.length - 1 : i - 1;
            int after = (i + 1) % derived.length;


            if (original[before] == 0 || original[after] == 0) {
                original[i] = 1;
                return doesValidArrayExistHelper(i + 1, derived, original);
            } else {
//                if (original[before] == -1) {
//                    original[before] = 0;
//                    original[i] = 1;
//                    if (doesValidArrayExistHelper(i + 1, derived, original)) {
//                        return true;
//                    }
//                    original[i] = -1;
//                    original[before] = -1;
//                }
                if (original[after] == -1) {
                    original[after] = 0;
                    original[i] = 1;
                }
            }

            return doesValidArrayExistHelper(i + 1, derived, original);
        } else {
            return doesValidArrayExistHelper(i + 1, derived, original);
        }

    }
}

public class Contest extends Solution {
}