package org.interview.questions.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UniqueOccurrences {

    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[] {1,2,2,1,1,3}));
    }
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: arr){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        Set<Integer> set = new HashSet<>(map.values());
        return map.size() == set.size();
    }
}
