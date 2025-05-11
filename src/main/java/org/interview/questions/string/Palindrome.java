package org.interview.questions.string;

//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
//
//Given a string s, return true if it is a palindrome, or false otherwise.
//
//        Example 1:
//
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
//        Example 2:
//
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
//Example 3:
//
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric characters.
//Since an empty string reads the same forward and backward, it is a palindrome.
//        Constraints:
//
//        1 <= s.length <= 2 * 105
//s consists only of printable ASCII characters.


public class Palindrome {
    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = " ";

        System.out.println(isPalindrome(s1)); // true
        System.out.println(isPalindrome(s2)); // false
        System.out.println(isPalindrome(s3)); // true
    }
    public static boolean isPalindrome(String str){

//        Example:
//        For the input "A man, a plan, a canal: Panama", the filtered string becomes "amanaplanacanalpanama", which reads the same forward and backward, so the output is true.
//
//        Time Complexity:
//        The time complexity is O(n), where n is the length of the input string. This is because we make a single pass to filter the string and another pass to check for the palindrome.
//
//        Space Complexity:
//        The space complexity is O(n) for storing the filtered string.
        //Filter the string
        StringBuilder filtered = new StringBuilder();
        for(char c : str.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                filtered.append(Character.toLowerCase(c));
            }
        }
        int left = 0;
        int right = filtered.length()-1;
        //Check for palindrome
        while(left<right){
            if(filtered.charAt(left++) != filtered.charAt(right--)){
                return false;
            }
        }
        return true;
    }
    //Time : O(N)
    //SPace : O(N)
    public static boolean isPalindrome2(String s){
        StringBuffer sb = new StringBuffer();
        for(char ch: s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                sb.append(Character.toLowerCase(ch));
            }
        }

        String filtered = sb.toString();
        String reveresed = sb.reverse().toString();

        return (filtered.equals(reveresed));
    }
}
