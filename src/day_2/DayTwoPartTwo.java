package day_2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayTwoPartTwo {
    public static boolean checkValidIncreasing(List<Integer> numbers){
        int prev = numbers.getFirst() - 1;
        for(Integer number: numbers){
            if(number - prev < 1 || number - prev > 3){
                return false;
            }
            prev = number;
        }
        return true;
    }
    public static boolean checkValidDecreasing(List<Integer> numbers){
        int prev = numbers.getFirst() + 1;
        for(Integer number : numbers){
            if(prev - number < 1 || prev - number > 3){
                return false;
            }
            prev = number;
        }
        return true;

    }
    public static void main(String[] args) {
        try{
            File file = new File("/home/tikursew/Documents/Advent of Code 2024/src/day_2/input.txt");
            Scanner scanner = new Scanner(file);
            int totalAnswer = 0;
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] stringNums  = line.split(" ");
                List<Integer> nums = new ArrayList<>();
                for(var stringNum : stringNums){
                    nums.add(Integer.parseInt(stringNum));
                }
                boolean isCurrentListValid = false;
                for(int i = 0; i < nums.size();i++){
                    List<Integer> newNums = new ArrayList<>(nums);
                    newNums.remove(i);
                    if(checkValidDecreasing(newNums) || checkValidIncreasing(newNums)){
                        isCurrentListValid = true;
                        break;
                    }
                }
                if(isCurrentListValid){
                    totalAnswer++;
                }
            }
            System.out.println(totalAnswer);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
