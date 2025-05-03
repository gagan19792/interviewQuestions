package org.interview.javastreams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamPractice {



    public static void main(String[] args) {
        System.out.println("Sum of list [1,2,3,4,5] - "+findSum(Arrays.asList(1,2,3,4,5)));
        System.out.println("Max element in List [1,2,3,4,5] - "+maxElement(Arrays.asList(1,2,3,4,5)));
        System.out.println("Fruits start with b "+countStartWith(Arrays.asList("apple", "banana","cherry","berry"), "b"));
    }
    //Count the number of string starts with certain character
    public static long countStartWith(List<String> fruits, String startsWith){
        return fruits.stream().filter(fruit -> fruit.startsWith(startsWith)).count();
    }

    //Given a list of Integers write a program to find the maximum element using stream.
    public static  int maxElement(List<Integer> numbers){
        return numbers.stream().max(Comparator.naturalOrder()).get();
    }
    //Find the sum of all elements in a list using Streams
    public static  int findSum(List<Integer> numbers){
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
