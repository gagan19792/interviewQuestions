package org.interview.questions.others;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class FirstBadVersion {

    private static final Random random = new Random();

    public static  int firstBadVersion(int n){
        int left = 1;
        int right = n;
        while(left < right){
            int mid = left+(right-left)/2;
            if(isBadVersion(mid)){
                right = mid;
            }else {
                left = mid +1;
            }
        }
        return left;
    }


    public static boolean isBadVersion(int num){
        if(num == 3){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(7));
    }
}
