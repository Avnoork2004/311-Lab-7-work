package org.example;

// Fig. 17.12: ArraysAndStreams2.java
// Demonstrating lambdas and streams with an array of Strings.
import java.util.Arrays;
import java.util.stream.Collectors;

public class ArraysAndStreams2 {
    public static void main(String[] args) {
        String[] strings =
                {"Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet"};

        // display original strings
        System.out.printf("Original strings: %s%n", Arrays.asList(strings));

        // strings in uppercase
        System.out.printf("strings in uppercase: %s%n",
                Arrays.stream(strings)
                        .map(String::toUpperCase)
                        .collect(Collectors.toList()));

        // strings less than "n" (case insensitive) sorted ascending
        System.out.printf("strings less than n sorted ascending: %s%n",
                Arrays.stream(strings)
                        .filter(s -> s.compareToIgnoreCase("n") < 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER)
                        .collect(Collectors.toList()));

        // strings less than "n" (case insensitive) sorted descending
        System.out.printf("strings less than n sorted descending: %s%n",
                Arrays.stream(strings)
                        .filter(s -> s.compareToIgnoreCase("n") < 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                        .collect(Collectors.toList()));



        // Edited version

        // #1
        //Used stream to filter strings that start with a vowel (case-insensitive)
        System.out.printf("strings start with a vowel (case-insensitive) : %s%n",
                Arrays.stream(strings)   // Created the stream of strings
                        .filter(s -> s.matches("(?i)^[aeiou].*")) // matched the strings starting with a vowel (case-insensitive)
                        .collect(Collectors.toList()));    // Collected the matching strings into a list and then printed it


        // #2
        //Used a stream to concatenate all the strings into a single string, separated by a comma
        System.out.printf("concatenated strings: %s%n",
                Arrays.stream(strings)  // Created the stream of strings
                        .collect(Collectors.joining(", "))); // Joined the strings in stream with  comma separator and printed it



        // #3
        //Used a stream to count the number of strings that contain more than 5 characters (case-insensitive)
        long count = Arrays.stream(strings)    // Created the stream of strings
                .filter(s -> s.length() > 5)   // Filtered the strings more than 5 characters
                .count();                      // Counted number of strings that would match the condition
        System.out.printf("number of strings that contain more than 5 characters (case-insensitive) : %d%n", count); // Printed the count



    }
}
