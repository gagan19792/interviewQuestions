package org.interview.questions.string;

public class OptimalSubstringFinder {

    // Returns the optimal substring based on the given criteria.
    public static String findOptimalSubstring(String text, String prefixString, String suffixString) {
        int n = text.length();
        int bestScore = -1;
        String bestCandidate = "";

        // Consider every possible substring of 'text'
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String candidate = text.substring(i, j + 1);
                int prefixScore = computePrefixScore(candidate, prefixString);
                int suffixScore = computeSuffixScore(candidate, suffixString);
                int totalScore = prefixScore + suffixScore;

                // Update best candidate if we get a higher score,
                // or if score ties, choose lexicographically smallest candidate.
                if (totalScore > bestScore) {
                    bestScore = totalScore;
                    bestCandidate = candidate;
                } else if (totalScore == bestScore && candidate.compareTo(bestCandidate) < 0) {
                    bestCandidate = candidate;
                }
            }
        }

        return bestCandidate;
    }

    // Computes the prefixScore:
    // The longest length 'k' such that candidate's beginning (first k characters)
    // equals the ending (last k characters) of prefixString.
    private static int computePrefixScore(String candidate, String prefixString) {
        int maxScore = 0;
        int lenCandidate = candidate.length();
        int lenPrefix = prefixString.length();

        // Try lengths from 1 to the minimum of candidate and prefixString lengths.
        for (int k = 1; k <= lenCandidate && k <= lenPrefix; k++) {
            String candidatePrefix = candidate.substring(0, k);
            String prefixEnd = prefixString.substring(lenPrefix - k);
            if (candidatePrefix.equals(prefixEnd)) {
                maxScore = k;
            }
        }
        return maxScore;
    }

    // Computes the suffixScore:
    // The longest length 'k' such that candidate's ending (last k characters)
    // equals the beginning (first k characters) of suffixString.
    private static int computeSuffixScore(String candidate, String suffixString) {
        int maxScore = 0;
        int lenCandidate = candidate.length();
        int lenSuffix = suffixString.length();

        for (int k = 1; k <= lenCandidate && k <= lenSuffix; k++) {
            String candidateSuffix = candidate.substring(lenCandidate - k);
            String suffixStart = suffixString.substring(0, k);
            if (candidateSuffix.equals(suffixStart)) {
                maxScore = k;
            }
        }
        return maxScore;
    }

    public static void main(String[] args) {
        // Example 1:
        String text1 = "engine";
        String prefixString1 = "raven";
        String suffixString1 = "ginkgo";
        // Explanation:
        // For candidate "engin":
        //   prefixScore: "en" (length 2) matches the end of "raven"
        //   suffixScore: "gin" (length 3) matches the beginning of "ginkgo"
        //   Total score = 2 + 3 = 5, which is optimal.
        System.out.println("Optimal substring: " + findOptimalSubstring(text1, prefixString1, suffixString1));

        // You can add more tests below if needed.
    }
}

