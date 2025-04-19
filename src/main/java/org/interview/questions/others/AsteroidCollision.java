package org.interview.questions.others;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class AsteroidCollision {

    public static void main(String[] args) {
        int[][] tests = {
                {5, 10, -5},       // → [5,10]
                {8, -8},           // → []
                {10, 2, -5},       // → [10]
                {-2, -1, 1, 2},    // → [-2,-1,1,2]
                {1, -2, -2, -2},   // → [-2, -2, -2]
        };
        for (int[] t : tests) {
            System.out.printf("%s → %s%n",
                    Arrays.toString(t),
                    Arrays.toString(asteroidCollision(t)));
        }
    }

    /**
     * Given an array of asteroids, each with a direction (sign) and size (abs value),
     * returns the state of asteroids after all collisions.
     */
    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int ast : asteroids){
            boolean alive = true;
            // Only possible collision: stack top moving right (>0) and current moving left (<0)
            while(alive && ast < 0 && !stack.isEmpty() && stack.peekLast() >0){
                int top = stack.peekLast();
                if(top < -ast){
                    // top explodes; pop and retry collision with new top
                    stack.removeLast();
                    continue;
                } else if (top == -ast) {
                    // both explode
                    stack.removeLast();
                    alive = false;
                    break;
                }else {
                    // current asteroid explodes
                    alive = false;
                    break;
                }
            }
            if(alive){
                stack.addLast(ast);
            }
        }

        // Convert stack to result array
        int[] result = new int[stack.size()];
        int i = 0;
        for (int a : stack) {
            result[i++] = a;
        }
        return result;
    }
}
