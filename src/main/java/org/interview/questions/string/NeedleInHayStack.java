package org.interview.questions.string;

public class NeedleInHayStack {

    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
    }
//    Time : O(MN)
//    Space : O(1)
    public static int strStr(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();

        for (int windowStart = 0; windowStart <= n - m; windowStart++) {
            for (int i = 0; i < m; i++) {
                if (needle.charAt(i) != haystack.charAt(windowStart + i)) {
                    break;
                }
                if (i == m - 1) {
                    return windowStart;
                }
            }
        }

        return -1;
    }
}
