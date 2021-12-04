package com.christo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // write your code here
        File file = new File("input.txt");
        Scanner myReader = new Scanner(file);
        List<Long> data = new ArrayList<>();
        while (myReader.hasNextLine()) {
            data.add(Long.parseLong(myReader.nextLine()));
        }
        // Interestingly, creating a zero sized array is usually faster than pre sized array.
        // see https://stackoverflow.com/questions/9572795/convert-list-to-array-in-java
        Long[] dataArray = data.toArray(new Long[0]);

        long currentWindow = getWindowSum(dataArray, 0, 2);
        long previousWindow = currentWindow;

        int counter = 0;

        for (int i = 1; i <= dataArray.length - 3; i++) {

            currentWindow = getWindowSum(dataArray, i, i + 2);

            if (currentWindow > previousWindow) {
                counter++;
            }

            previousWindow = currentWindow;
        }
        System.out.println(counter);
    }

    private static long getWindowSum(Long[] array, int start, int end) {
        // Stream flexing
        return Arrays.stream(array, start, end + 1).mapToLong(Long::longValue).sum();
    }
}
