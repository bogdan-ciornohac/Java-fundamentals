package org.example;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Chapter10 {
    public static void main(String[] args) {

        //1. Filter even numbers
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> even = integers.stream().filter(num -> num % 2 == 0).toList();

        System.out.println("List of numbers: " + integers);
        System.out.println("List of even numbers: " + even);

        //2. Convert to uppercase
        List<String> words = Arrays.asList("john", "terry", "andrew");
        List<String> wordsToUppercase = words.stream().map(String::toUpperCase).toList();

        System.out.println("List of words: " + words);
        System.out.println("List of words to uppercase: " + wordsToUppercase);

        //3. Find names starting with A
        List<String> names = Arrays.asList("John", "Terry", "Andrew");
        List<String> namesWithA = names.stream().filter(s -> s.startsWith("A")).toList();

        System.out.println("List of names: " + names);
        System.out.println("List of names with A: " + namesWithA);

        //4. Sum of numbers
        int sum = integers.stream().mapToInt(num -> num).sum();
        System.out.println("Sum of " + integers + " is " + sum);

        //5. Find the longest string
        var longestName = names.stream().max(Comparator.comparingInt(String::length)).get();
        System.out.println("Longest name is " + longestName);

        //6. Count unique elements
        List<Integer> repeatedElements = Arrays.asList(1, 2, 2, 4, 5, 11, 3, 4, 5, 6, 7, 8, 9, 10);
        long uniqueElements = repeatedElements.stream().distinct().count();
    }

    public static int duplicateCount(String text){
        Map<Character, Integer> map = new HashMap<>();

        for(char c : text.toLowerCase().toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);

        }

       return (int)map.entrySet().stream().filter(e-> e.getValue()>=2).count();

    }

    public static boolean comp(int[] a, int[] b) {
        if(a.length != b.length) return false;

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : b){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(int num : a){
            if(map.containsKey(num) == false) return false;
            if(map.get(num)==1) map.remove(num);
            else{
                map.put(num, map.get(num)-1);
            }
        }

        return true;
    }
    private static List<String> refactored(List<String> list) {
        return list.stream()
                .sorted((a, b) -> b.compareTo(a))
                .collect(Collectors.toList());
    }
}
