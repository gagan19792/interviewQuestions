package org.interview.questions.string;

public class ReverseString {

    public static void main(String[] args) {
        reverserString(null);
        reverserString("");
        reverserString("ABC");
    }

    //    Time	O(n)
    //    Space	O(n) (char array)
    public static void reverserString(String s){
        if(s == null || s.isEmpty()) return;
        System.out.println("Actual String : "+s);
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
        System.out.println("Reversed String : "+ new String(arr));
    }

}
