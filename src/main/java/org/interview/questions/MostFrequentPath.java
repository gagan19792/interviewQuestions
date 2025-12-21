package org.interview.questions;

import java.util.*;

public class MostFrequentPath {

    public static String mostFrequentPath(List<String> logs) {
        if (logs == null || logs.isEmpty()) return "";
        Map<String, Integer> countMap = new HashMap<>();

        for (String line : logs) {
            if (line == null) continue;

            String[] parts = line.trim().split("\\s+");
            if (parts.length != 3) continue;

            String path = parts[2];
            countMap.put(path, countMap.getOrDefault(path, 0) + 1);
        }
        if (countMap.isEmpty()) return "";
        int maxCount = 0;
        String bestPath = null;

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            String path = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount) {
                maxCount = count;
                bestPath = path;
            } else if (count == maxCount) {
                // tie-break: lexicographically smallest
                if (bestPath == null || path.compareTo(bestPath) < 0) {
                    bestPath = path;
                }
            }
        }

        return bestPath;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<String> logs = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            logs.add(sc.nextLine());
        }

        System.out.println(mostFrequentPath(logs));
    }
}
