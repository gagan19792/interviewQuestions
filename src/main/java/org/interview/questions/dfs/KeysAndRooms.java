package org.interview.questions.dfs;

import java.util.*;

public class KeysAndRooms {


    public static void main(String[] args) {
        List<List<Integer>> rooms1 = Arrays.asList(
                Arrays.asList(1),           // room 0 has key 1
                Arrays.asList(2),           // room 1 has key 2
                Arrays.asList(3),           // room 2 has key 3
                Collections.emptyList()     // room 3 has no keys
        );
        System.out.println(canVisitAllRooms(rooms1));
        // → true (0→1→2→3 visits all)

        List<List<Integer>> rooms2 = Arrays.asList(
                Arrays.asList(1, 3),        // room 0 has keys 1&3
                Arrays.asList(3, 0, 1),     // room 1 has keys 3,0,1
                Arrays.asList(2),           // room 2 has key 2
                Arrays.asList(0)            // room 3 has key 0
        );
        System.out.println(canVisitAllRooms(rooms2));
        // → false (room 2 is unreachable)
    }

//    Complexity
//    Time: O(N + K), where N = number of rooms and K = total number of keys across all rooms.
//
//            Space: O(N) for the visited array and the stack.
    /**
     * Returns true if you can visit all rooms starting from room 0.
     * rooms.get(i) is a list of keys in room i.
     */
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int s = rooms.size();
        boolean[] visited = new boolean[s];
        visited[0] = true;
        int seen = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        while(!stack.isEmpty()){
            int room = stack.pop();
            for(int key: rooms.get(room)){
                if(!visited[key]){
                    visited[key] = true;
                    seen++;
                    stack.push(key);
                }
            }
        }
        return seen == s;
    }
}
