import HashSet.StringHashSet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Application {

    public static void main(String[] args) {

        Set<String> set = new StringHashSet();
        set.add("Ala");
        set.add("Alan");
        set.add("Marek");
        set.add("Marek");
        set.add("Jakub");

        long start = System.currentTimeMillis();
        experimentWithArrayList(10_000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        experimentWithHashSet(1000_000);
        end = System.currentTimeMillis();
        System.out.println(end - start);

        Set<String> set1 = new HashSet<>();
        set1.add("Ala");
        set1.add("Alan");
        set1.add("Marek");
        set1.add("Marek");
        set1.add("Jakub");


        System.out.println(set);

        //Zad. contains
//        System.out.println(set.contains("Ala"));
        //Zad. remove
//        System.out.println(set.remove("Jakub"));
//        System.out.println(set);

        //Zad. size
        System.out.println(set.size());

        //Zad. isEmpty
        System.out.println(set.isEmpty());

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
                .collect(Collectors.toSet());

        for (int i = size / 2; i < 1.5 * size; i++) {
            boolean contains = numbers.contains(i);
        }
    }
}
