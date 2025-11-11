package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Chapter9 {
    public static void main(String[] args) {
        System.out.println(Integer.getInteger("123"));
        List<String> list = new ArrayList<>();
        var map = new HashMap<Integer, Integer>();
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, null);
        map.merge(1, 3, (a,b) -> a + b);
        map.merge(3, 3, (a,b) -> a + b);
        System.out.println(map);

        ArrayList<Integer> source = new ArrayList<Integer>();
        source.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> destination = Collections.synchronizedList(new ArrayList<Integer>());
        source
                .parallelStream()  //1
                .peek(item->{destination.add(item); }) //2
                .forEachOrdered(System.out::print);
        System.out.println("");
        destination
                .stream() //3
                .forEach(System.out::print); //4
        System.out.println("");

        Comparator<Integer> c1 = (o1, o2) -> o2 - o1;
        Comparator<Integer> c2 = Comparator.naturalOrder();
        Comparator<Integer> c3 = Comparator.reverseOrder();

        var listt = Arrays.asList(5, 4, 7, 2);
        Collections.sort(listt,c3);
        Collections.reverse(listt);
        Collections.reverse(listt);
        System.out.println(Collections.binarySearch(listt, 2));

    }



    public static String longest (String s1, String s2) {
        // your code
        Set<String> letters = new HashSet(List.of(s1.split("") ));
        for(String letter : s2.split("")) {
            letters.add(letter);
        }

        return letters.stream().sorted(String::compareTo)
                .toString();


    }
}
