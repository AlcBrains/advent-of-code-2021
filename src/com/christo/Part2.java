package com.christo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Part2 {
    public static void main(String... args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner myReader = new Scanner(file);
        Map<String, Integer> data = new HashMap<>();
        data.put("depth", 0);
        data.put("horizontal", 0);
        data.put("aim", 0);

        while (myReader.hasNextLine()) {
            String[] line = myReader.nextLine().split(" ");

            String direction = line[0];
            Integer value = Integer.parseInt(line[1]);

            switch (direction) {
                case "forward":
                    data.merge("horizontal", value, Integer::sum);
                    data.put("depth", data.get("depth") + (data.get("aim") * value));
                    break;
                case "down":
                    data.merge("aim", value, Integer::sum);
                    break;
                case "up":
                    data.merge("aim", value, (oldVal, newVal) -> oldVal - newVal);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + direction);
            }
        }
        System.out.println(data.get("horizontal") * data.get("depth"));
    }
}

