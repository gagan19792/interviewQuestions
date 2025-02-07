package org.interview.questions.string;

public class LastWordLength {

    public static void main(String[] args) {
        System.out.println(lastWordLength("Hello World"));
    }

    private static int lastWordLength(String str) {
        // Time Complexity: O(n)
        // Space Complexity: O(1)
    if(null == str)
        return 0;

    str = str.trim();
    int lastIdx = str.lastIndexOf(' ');
    return str.length() - lastIdx -1;
    }


}
