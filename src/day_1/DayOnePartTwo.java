package day_1;

import java.io.File;
import java.util.*;

import static java.lang.Math.abs;

public class DayOnePartTwo {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Map<Integer,Integer> count = new HashMap<>();
        try{
            File file = new File("/home/tikursew/Documents/Advent of Code 2024/src/day_1/input.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                int num1 = Integer.parseInt(parts[0]);
                int num2 = Integer.parseInt(parts[parts.length - 1]);
                list1.add(num1);
                count.put(num2, count.getOrDefault(num2, 0) + 1);
            }
            long total = 0;
            for(Integer val: list1){
                total += (long) val * count.getOrDefault(val, 0);

            }
            System.out.println(total);


        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
