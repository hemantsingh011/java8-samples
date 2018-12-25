package com.github.samples.collection_sample;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class Sample {
    public static List<Person> createPeople() {
        return Arrays.asList(
                new Person("A", Gender.MALE, 20),
                new Person("B", Gender.MALE, 30),
                new Person("C", Gender.FEMALE, 20),
                new Person("D", Gender.FEMALE, 10),
                new Person("AB", Gender.MALE, 20),
                new Person("AC", Gender.MALE, 40),
                new Person("DA", Gender.MALE, 20),
                new Person("EA", Gender.FEMALE, 20)
        );
    }

    public static void printSorted(List<Person> people, Comparator<Person> comparator) {
        people.stream()
                .sorted(comparator)
                .forEach(System.out::println);

        System.out.println(people.stream()
                .collect(Collectors.groupingBy(Person::getAge, Collectors.toList())));
    }

    public static void main(String[] args) {
        List<Person> people = createPeople();

     //   Collections.sort(people); -> People needs to implement the Comparable

        //===================Step1 ==============================
      /*  printSorted(people, new Comparator<Person>() {
            @Override public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });*/

      // printSorted(people, (c1, c2) -> c1.getName().compareTo(c2.getName()));

        //======================Step 2=====================

       /* printSorted(people, comparing(new Function<Person, String>() {
            @Override public String with(Person person) {
                return person.getName();
            }
        }));*/

      /*  comparing implementation
        public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
                Function<? super T, ? extends U> keyExtractor)
        {
            Objects.requireNonNull(keyExtractor);
            return (Comparator<T> & Serializable)
                    (c1, c2) -> keyExtractor.with(c1).compareTo(keyExtractor.with(c2));
        }*/


        //======================Final Step 3=====================
        printSorted(people, comparing(Person::getName).thenComparing(Person::getAge).reversed());
    }
}
