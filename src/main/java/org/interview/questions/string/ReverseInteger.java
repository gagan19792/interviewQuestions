package org.interview.questions.string;

//Input: x = 123
//Output: 321
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverseInteger(-123));
    }

//    Time Complexity: O(log(x))
//    Space Complexity: O(1).
    public static int reverseInteger(int x){
        int rev = 0;
        while(x!=0){
            int pop = x % 10;
            x /= 10;
            if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if(rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;

            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static int unique(String s){
        for(int i = 0; i< s.length(); i++){
            if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))){
                return i;
            }
        }
        return -1;
    }
}
