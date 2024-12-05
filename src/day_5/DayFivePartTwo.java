package day_5;

import java.io.File;
import java.util.Scanner;

public class DayFivePartTwo {
    public static void main(String[] args) {
        try{
            File file = new File("/home/tikursew/Documents/Advent of Code 2024/src/day_5/input.txt");
            Scanner scanner = new Scanner(file);
            // data structure
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
