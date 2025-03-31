package org.interview.questions.math;

//Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

import java.util.HashMap;

//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
public class RomanToInteger {
    static HashMap<String, Integer> values = new HashMap<>();
    static {
        values.put("I",1);
        values.put("V",5);
        values.put("X",10);
        values.put("L",50);
        values.put("C",100);
        values.put("D",500);
        values.put("M",1000);
        values.put("IV",4);
        values.put("IX",9);
        values.put("XL",40);
        values.put("XC",90);
        values.put("CD",400);
        values.put("CM",900);

    }

    public static void main(String[] args) {
        System.out.println(romanToInteger("XLIX"));
    }
    public static int romanToInteger(String s){
        int currentSum = 0;
        int i = 0;
        while(i<s.length()){
            // start with double symbol
            if(i < s.length()-1){
                String doubleSymbol = s.substring(i, i+2);
                //check if symbol exist
                if(values.containsKey(doubleSymbol)){
                    currentSum += values.get(doubleSymbol);
                    i +=2;
                    continue;
                }
            }
            //otherwise single symbol
            String singleSymbol = s.substring(i, i+1);
            currentSum += values.get(singleSymbol);
            i +=1;
        }
        return  currentSum;
    }
}
