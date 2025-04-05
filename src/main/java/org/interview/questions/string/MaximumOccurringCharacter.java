package org.interview.questions.string;

public class MaximumOccurringCharacter {

    public static char maxOccurringCharacter(String s){
        int frequence[] = new int[256];

        for(int i=0; i<s.length(); i++){
            frequence[s.charAt(i)]++;
        }

        int maxFrequency = -1;
        char maxChar =  ' ';
        for(int i=0; i <256; i++){
            if(frequence[i] > maxFrequency){
                maxFrequency = frequence[i];
                maxChar = (char)i;
            } else if (frequence[i] == maxFrequency && frequence[i] !=0) {
                if((char)i < maxChar){
                    maxChar = (char)i;
                }
            }
        }
        return maxChar;
    }

    // Main method for testing the solution
    public static void main(String[] args) {
        String s1 = "sample input string";
        System.out.println("Maximum occurring character in \"" + s1 + "\": " + maxOccurringCharacter(s1));

        String s2 = "abcaabbcc";
        System.out.println("Maximum occurring character in \"" + s2 + "\": " + maxOccurringCharacter(s2));
    }
}
