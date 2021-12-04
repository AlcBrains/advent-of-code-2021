package com.christo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner myReader = new Scanner(file);
        Map<String, Integer> data = new HashMap<>();

        while (myReader.hasNextLine()) {
            String[] line = myReader.nextLine().split(" ");
            String direction = line[0];
            Integer value = Integer.parseInt(line[1]);
            data.merge(direction, value, (Integer::sum));
        }
        System.out.println(data.get("forward") * (data.get("down") - data.get("up")));
    }
}
