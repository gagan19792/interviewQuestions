package org.interview.questions.others;

public class ExpressionEvaluator {

    /**
     * Evaluates an arithmetic expression containing non‐negative integers,
     * '+', and '*' operators, with standard precedence ( * before + ).
     *
     * @param expr the input expression, e.g. "2+2*3+3*4"
     * @return the computed result
     */
    public static int evaluate(String expr) {
        // 1) First split by '+' to handle addition at the end
        String[] addTerms = expr.split("\\+");
        int result = 0;

        // 2) For each term between '+' signs, split by '*' and multiply them
        for (String term : addTerms) {
            String[] factors = term.split("\\*");
            int product = 1;
            for (String f : factors) {
                product *= Integer.parseInt(f);
            }
            // 3) Add the product of this term to the running total
            result += product;
        }

        return result;
    }

    public static void main(String[] args) {
        String expr = "2+2*3+3*4";
        int value = evaluate(expr);
        System.out.println(expr + " = " + value);
    }
}
