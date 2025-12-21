package org.interview.questions;

import java.util.*;

public class CountBlocked {

    public static int countBlocked(List<Integer> timestamps, List<String> userIds) {
        if(timestamps == null || userIds == null || timestamps.size() != userIds.size()){
            return 0;
        }
        // For each user, keep timestamps of ALLOWED requests in the last 10 seconds window.
        Map<String, Deque<Integer>> allowedWindowByUser = new HashMap<>();
        int blocked = 0;
        for (int i=0; i< timestamps.size(); i++){
            int t = timestamps.get(i);
            String user = userIds.get(i);

            Deque<Integer> window = allowedWindowByUser.computeIfAbsent(user, k -> new ArrayDeque<>());
            // Remove allowed requests that are outside the window [t - 9, t]
            int windowStarts = t - 9;
            while(!window.isEmpty() && window.peekFirst()< windowStarts){
                window.poll();
            }
            // If already 3 allowed requests in the window, block this request
            if(window.size()>= 3){
                blocked++;
            } else {
                window.add(t);
            }
        }

        return blocked;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Integer> timestamps = new ArrayList<>(n);
        List<String> userIds = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            timestamps.add(Integer.parseInt(parts[0]));
            userIds.add(parts[1]);
        }

        System.out.println(countBlocked(timestamps, userIds));
    }
}
