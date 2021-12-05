package com.christo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        // write your code here
        File file = new File("input.txt");
        Scanner myReader = new Scanner(file);
        List<String> data = new ArrayList<>();
        while (myReader.hasNextLine()) {
            data.add(myReader.nextLine());
        }

        //count number of digits
        final int DIGIT_COUNT = data.get(0).length();
        StringBuilder mostCommon = new StringBuilder();
        StringBuilder leastCommon = new StringBuilder();
        for (int i = 0; i < DIGIT_COUNT; i++) {
            int finalI = i;
            // Okay, for each digit, we stream all numbers of the list, and map them so that
            // we end up with a map that contains the digit, and the number of times it appeared in this position.
            // e.g. if we encountered 5 zeroes and 3 ones in the first position, our hashmap would look like this :
            // "0" -> 5 , "1" -> 3
            // and that's the longest comment I'll write for this challenge. For everything else (there's Mastercard) you're on your own
            Map<String, Long> wh = data.stream().collect(
                    Collectors.groupingBy(datum -> String.valueOf(datum.charAt(finalI)), Collectors.counting()));

            mostCommon.append(wh.get("0") > wh.get("1") ? "0" : "1");
            leastCommon.append(wh.get("0") < wh.get("1") ? "0" : "1");
        }

        System.out.println(Integer.parseInt(mostCommon.toString(), 2) * Integer.parseInt(leastCommon.toString(), 2));
    }
}
