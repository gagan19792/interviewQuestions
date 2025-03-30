package org.interview.questions.string;

public class ReverseString {

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        new ReverseString().reverseStringRecurrsion(s);
        System.out.println(s);
    }

    private static void reverseStringTwoPointer(char[] s) {
//        Time Complexity:
//        The time complexity of this algorithm is O(n), where n is the length of the array. This is because we only pass through the array once, swapping elements.
//
//        Space Complexity:
//        The space complexity is O(1) because we are using a constant amount of extra space for the temporary variable temp.
        int left = 0;
        int right = s.length-1;
        while(left < right){
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }

    public void reverseStringRecurrsion(char[] s){
        helper(s, 0, s.length-1);
    }

    //Time : O(n), Space O(N)
    private void helper(char[] s, int left, int right) {
        if(left>=right){
            return;
        }
        char tmp = s[left];
        s[left++] = s[right];
        s[right--] = tmp;
        helper(s, left, right);
    }
}
