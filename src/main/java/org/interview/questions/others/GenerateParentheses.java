package org.interview.questions.others;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        backtracking(answer, new StringBuilder(), 0, 0, n);

        return answer;
    }

    private static void backtracking(
            List<String> answer,
            StringBuilder curString,
            int leftCount,
            int rightCount,
            int n
    ) {
        if (curString.length() == 2 * n) {
            answer.add(curString.toString());
            return;
        }
        if (leftCount < n) {
            curString.append("(");
            backtracking(answer, curString, leftCount + 1, rightCount, n);
            curString.deleteCharAt(curString.length() - 1);
        }
        if (leftCount > rightCount) {
            curString.append(")");
            backtracking(answer, curString, leftCount, rightCount + 1, n);
            curString.deleteCharAt(curString.length() - 1);
        }
    }
}
