package org.interview.questions.array;

import java.util.ArrayList;
import java.util.List;

public class KidsWiththeGreatestNumberofCandies {

    public static void main(String[] args) {

        int[] candies = new int[]{2,3,5,1,3};
        int extraCandies = 3 ;
        System.out.println(kidsWithCandies(candies, extraCandies));
    }
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies  = 0;
        for(int candy: candies){
            maxCandies = Math.max(candy, maxCandies);
        }
        List<Boolean> result = new ArrayList<>();
        for(int candy: candies){
            result.add(candy+extraCandies >= maxCandies);
        }
        return result;
    }
}
