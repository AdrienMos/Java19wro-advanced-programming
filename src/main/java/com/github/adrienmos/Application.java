package com.github.adrienmos;

import CustomHashMap.CustomHashMap;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

class Application {

    public static void main(String[] args) {

        Map<String, String> map = new CustomHashMap<String, String>();

        map.put("Jan", "Kowalski");
        map.put("Danuta", "Nowak");

        System.out.println(map);

    }

    private static void experimentWithArrayList(int size) {
        List<Integer> numbers = IntStream.range(0, size)
                .boxed()
                .collect(toList());

        for (int i = size / 2; i < 1.5 * size; i++) {
            boolean contains = numbers.contains(i);
        }
    }

    private static void experimentWithHashSet(int size) {
        Set<Integer> numbers = IntStream.range(0, size)
                .boxed()
                .collect(toSet());

        for (int i = size / 2; i < 1.5 * size; i++) {
            boolean contains = numbers.contains(i);
        }
    }

}