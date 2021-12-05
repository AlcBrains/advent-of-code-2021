package com.christo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Part2 {
    public static void main(String... args) throws FileNotFoundException {
        Scanner myReader = Input.getInput();
        List<String> data = new ArrayList<>();
        while (myReader.hasNextLine()) {
            data.add(myReader.nextLine());
        }

        // divide the numbers into two lists, one with the most common value in the first bit, and one with the least
        // common value in the first bit. This is actually called "mode" in statistics, and there's a fairly complex
        // implementation of finding it with streams. Because it is Sunday, and I just wanna pass my time, I'll do it
        // with recursion. Don't judge me, Santa.
        String oxygenGenerator = survival(data, 0, true);
        String co2Scrubber = survival(data, 0, false);

        System.out.println(Integer.parseInt(oxygenGenerator, 2) * Integer.parseInt(co2Scrubber, 2));

    }

    private static String survival(List<String> data, int bitToSearch, boolean mostCommon) {

        if (data.size() == 1) {
            return data.get(0);
        }

        //find most common value in bit specified
        long zeroOccurrence = 0;
        long oneOccurrence = 0;

        for (String datum : data) {
            if (datum.charAt(bitToSearch) == '0') {
                zeroOccurrence++;
            } else {
                oneOccurrence++;
            }
        }

        if (mostCommon) {
            return zeroOccurrence > oneOccurrence ?
                    survival(data.stream().filter(d -> d.charAt(bitToSearch) == '0').collect(Collectors.toList()), bitToSearch + 1, true) :
                    survival(data.stream().filter(d -> d.charAt(bitToSearch) == '1').collect(Collectors.toList()), bitToSearch + 1, true);
        }

        return zeroOccurrence > oneOccurrence ? 
                survival(data.stream().filter(d -> d.charAt(bitToSearch) == '1').collect(Collectors.toList()), bitToSearch + 1, false) :
                survival(data.stream().filter(d -> d.charAt(bitToSearch) == '0').collect(Collectors.toList()), bitToSearch + 1, false);
    }

}
