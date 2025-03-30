package org.interview.questions.string;

public class Practice {

    public static void main(String[] args) {
        String s = "Hello world";
        s = s.trim();
        int lastIndx = s.lastIndexOf(' ');
        System.out.println("s.length() : "+s.length());
        System.out.println("lastIndx : "+lastIndx);
        System.out.println(s.length() - lastIndx);
    }
}
