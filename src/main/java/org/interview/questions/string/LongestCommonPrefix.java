package org.interview.questions.string;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix1(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
//        Explanation:
//        Initial Check: We first check if the array is null or empty. If it is, we return an empty string immediately.
//        Start with the First String: We take the first string as the initial prefix.
//        Iterate Over Remaining Strings: We iterate over the remaining strings and progressively shorten the prefix by removing characters from the end until the current string starts with the prefix.
//        Return the Prefix: If the prefix becomes empty during this process, we return an empty string. Otherwise, we return the longest common prefix after checking all strings.

//        Time Complexity:
//        The time complexity of this algorithm is O(S), where S is the sum of all characters in all strings. In the worst case, all characters are compared.

//        Space Complexity:
//        The space complexity is O(1) because we are using a constant amount of extra space for the prefix variable.

        if (strs == null || strs.length == 0) return "";

        // Start with the first string as the initial prefix
        String prefix = strs[0];

        // Iterate over the remaining strings
        for (int i = 1; i < strs.length; i++) {
            // While the current string does not start with the current prefix,
            // trim the prefix from the end
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                // If the prefix becomes empty, return an empty string
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }

    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

}
