package org.interview.questions.string;

public class StringCompression {

    public static void main(String[] args) {
        char[] chars = "aabbccc".toCharArray();
        System.out.println("StringCompression : "+compressString(chars));
        System.out.println(chars);
    }

    public static int compressString(char[] chars){
        int index = 0;
        int i=0;
        while(i < chars.length){
            char currentChar = chars[i];
            int count = 0;
            while(i < chars.length && chars[i] == currentChar){
                i++;
                count++;
            }
            chars[index++] = currentChar;

            if(count > 1){
                for(char c: String.valueOf(count).toCharArray()){
                    chars[index++] = c;
                }
            }
        }
        return index;
    }
}
