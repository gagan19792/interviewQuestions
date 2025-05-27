package org.interview.educative.slowfastpointer;

public class HappyNumber {

    public static void main(String[] args) {
        System.out.println("Is Happy Number : "+isHappyNumber(19));
        System.out.println("Is Happy Number : "+isHappyNumber(8));
    }

    //The time complexity for this algorithm is O(logn)O(logn)
    //Space O(1)
    public static int square(int n){
        int total = 0;
        while(n > 0){
            int digit = n % 10;
            n = n / 10;
            total += Math.pow(digit, 2);
        }
        return total;
    }
    public static boolean isHappyNumber(int n) {
        int slowP = n;
        int fastP = square(n);

        while(fastP != 1 && slowP != fastP){
            slowP = square(slowP);
            fastP = square(square(fastP));
        }

        return fastP == 1;
    }
}
