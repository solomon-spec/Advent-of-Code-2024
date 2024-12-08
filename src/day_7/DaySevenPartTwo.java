package  day_7;

import java.io.File;
import java.util.Scanner;

public class DaySevenPartTwo {
    public static long target;
    public static long[] numbers;
    public static boolean checkIfNumbersCanReachTarget(int index, long curTotal){
        if(index == numbers.length){
            return curTotal == target;
        }
        if(curTotal > target){
            return false;
        }
        String concat = String.valueOf(curTotal) + String.valueOf(numbers[index]);
        return checkIfNumbersCanReachTarget(index + 1, curTotal * numbers[index])
                || checkIfNumbersCanReachTarget(index + 1, curTotal + numbers[index])
                || checkIfNumbersCanReachTarget(index + 1, Long.parseLong(concat));

    }
    public static void main(String[] args) {
        try{
            File file = new File("/home/tikursew/Documents/Advent of Code 2024/src/day_7/input.txt");
            Scanner scanner = new Scanner(file);
            long totalAnswer = 0;
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] parts = line.split(":");

                target = Long.parseLong(parts[0].trim());
                String[] numberStrings = parts[1].trim().split(" ");
                numbers = new long[numberStrings.length];
                for (int i = 0; i < numberStrings.length; i++) {
                    numbers[i] = Long.parseLong(numberStrings[i]);
                }
                if(checkIfNumbersCanReachTarget(1,numbers[0])){
                    totalAnswer += target;
                }
            }
            System.out.println(totalAnswer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
