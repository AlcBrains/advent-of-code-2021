package com.christo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Input {
    public static Scanner getInput() throws FileNotFoundException {
        File file = new File("input.txt");
        return new Scanner(file);
    }
}
