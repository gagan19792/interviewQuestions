package org.interview;

import java.util.*;

public class TwoPointer {

    public static void main(String[] args) {
        System.out.println("is palindrome - "+isPalindrome("a"));
        int[] arr = new int [] {1,2,3,4,5};
        reverseArray(arr);
        System.out.println("reverse Array - "+ Arrays.toString(arr));
        System.out.println("Pair sum : "+Arrays.toString(pairSum(new int[]{2,3,5,7,11,13}, 14)));
        System.out.println("Three Sum : "+threeSum(new int[] {1,0,1,2,-1,-4}));
        System.out.println("Is valid word abbreviation : "+validWordAbbreviation("internationalization","13iz4n"));
        System.out.println("Is valid Strobogrammatic Number : "+validStrobogrammaticNumber("90"));
        System.out.println("Minimum Number of Moves to Make Palindrome : "+minMovesToMakePalindrom("eggeekgbbeg"));
        System.out.println("Count Pairs Whose Sum is Less than Target : "+countPairs(Arrays.asList(1,3,2,4,5), 6));
        System.out.println("Valid Palindrome II : "+isPalindromeII("tebbem"));
    }

    private static int countPairs(List<Integer> nums, int target) {
        //Sorting takes O(nlogn) + 2 pointers traversal O(n) = O(nlogn) , So time complexity : O(nlogn) and Space is O(1)
        int count = 0;
        int low = 0;
        int high = nums.size()-1;
        while(low < high){
            if(nums.get(low)+nums.get(high) < target){
                count += (high-low);
                low++;
            }else{
                high--;
            }
        }
        return count;
    }

    private static int[] reverseArray(int[] nums) {
        //Time : O(N) Space : O(1)
        int l = 0;
        int r = nums.length-1;
        while(l < r){
            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
            l++;
            r--;
        }
        return nums;
    }

    public static boolean isPalindrome(String str){
        //Time : O(N) Space : O(1)
        if(str == null || str.length() < 2){
            return false;
        }
        int l = 0;
        int r = str.length()-1;
        while(l <r){
            if(str.charAt(l) != str.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static int[] pairSum(int nums[] , int num){
        int l =0;
        int r = nums.length-1;

        while(l<r){
            if(nums[l]+ nums[r] == num){
                return new int[] {nums[l], nums[r]};
            }else if(nums[l]+ nums[r] < num){
                l++;
            }else {
                r--;
            }
        }
        return new int[]{};
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for (int pivot = 0; pivot < n - 2; pivot++) {
            if (nums[pivot] > 0) {
                break;
            }
            if (pivot > 0 && nums[pivot] == nums[pivot - 1]) {
                continue;
            }

            int low = pivot + 1, high = n - 1;
            while (low < high) {
                int total = nums[pivot] + nums[low] + nums[high];
                if (total < 0) {
                    low++;
                } else if (total > 0) {
                    high--;
                } else {
                    result.add(Arrays.asList(nums[pivot], nums[low], nums[high]));
                    low++;
                    high--;
                    while (low < high && nums[low] == nums[low - 1]) {
                        low++;
                    }
                    while (low < high && nums[high] == nums[high + 1]) {
                        high--;
                    }
                }
            }
        }
        System.out.println(String.join(" ", Arrays.asList("A", "B", "B")));;
        return result;
    }

    public static boolean validWordAbbreviation(String word, String abbr) {
        //Time complexity# O(N), Space : O(1)
        int wordIndex = 0; int abbrIndex =0;
        while(wordIndex < word.length() && abbrIndex < abbr.length()){
            // Check if the current character is a digit.
            if(Character.isDigit(abbr.charAt(abbrIndex))){
                // Check if there's a leading zero. If there is, return False.
                if(abbr.charAt(abbrIndex) == '0'){
                    return false;
                }
                int num =0;
                while(abbrIndex < abbr.length() && Character.isDigit(abbr.charAt(abbrIndex))){
                    num = num * 10 + (abbr.charAt(abbrIndex)) -'0';
                    abbrIndex++;
                }
                // Skip the number of characters in word as found in abbreviation.
                wordIndex +=num;
            }else {
                // Check if characters the match, then increment the pointers. Otherwise return False.
                if(wordIndex >= word.length() || word.charAt(wordIndex) != abbr.charAt(abbrIndex)){
                    return false;
                }
                wordIndex++;
                abbrIndex++;
            }
        }
        // Check if both indices have reached the end of their respective strings.
        return wordIndex == word.length() && abbrIndex == abbr.length();
    }

    public static boolean validStrobogrammaticNumber(String num){
        //Time complexity# O(N) Space : O(1)
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put('0','0');
        mapping.put('1','1');
        mapping.put('6','9');
        mapping.put('8','8');
        mapping.put('9','6');

        int left =0;
        int right = num.length()-1;
        while(left <= right){
            if(!mapping.containsKey(num.charAt(left)) || mapping.get(num.charAt(left)) != num.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static int minMovesToMakePalindrom(String str){
        char[] chars = str.toCharArray();
        int moves =0;
        for (int i = 0, j = chars.length - 1; i < j; ++i) {
            int k=j;
            for(; k>i; --k){
                if(chars[k] == chars[i]){
                    for(; k <j; k++){
                        char temp = chars[k];
                        chars[k] = chars[k+1];
                        chars[k+1] = temp;
                        ++moves;
                    }
                    --j;
                    break;
                }
            }
            if(k == i){
                moves += chars.length / 2 - i;
            }
        }
        return moves;
    }

    private  static boolean isPalindromeII(String str){
        int low = 0;
        int high = str.length()-1;
        while(low < high){
            if(str.charAt(low) == str.charAt(high)){
                low++;
                high--;
            }
            else {
                return isPalindromeRange(str, low+1, high) || isPalindromeRange(str, low, high-1);
            }
        }
        return true;
    }

    private static boolean isPalindromeRange(String str, int low, int high){
        while(low < high){
            if(str.charAt(low) != str.charAt(high)){
                return false;
            }else{
                low++;
                high--;
            }
        }
        return true;
    }


}
