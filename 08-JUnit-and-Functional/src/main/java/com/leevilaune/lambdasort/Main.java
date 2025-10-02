package com.leevilaune.lambdasort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Alice", 25, "Helsinki"));
        people.add(new Person("Jane",35,"Helsinki"));
        people.add(new Person("Bob", 30, "Tampere"));
        people.add(new Person("Clara", 22, "Espoo"));
        people.add(new Person("David", 28, "Turku"));

        people.sort(Comparator.comparing(p -> p.getAge()));
        System.out.println("List in ascending order");
        people.forEach(System.out::println);
        System.out.println("People living in Helsinki");
        people.removeIf(p -> !p.getCity().equalsIgnoreCase("Helsinki"));
        people.forEach(System.out::println);

    }
}