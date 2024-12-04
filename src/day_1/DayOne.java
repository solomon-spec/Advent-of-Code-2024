package day_1;

import java.io.File;
import java.util.*;

import static java.lang.Math.abs;

public class DayOne {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        try{
            File file = new File("/home/tikursew/Documents/Advent of Code 2024/src/day_1/input.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                int num1 = Integer.parseInt(parts[0]);
                int num2 = Integer.parseInt(parts[parts.length - 1]);
                list1.add(num1);
                list2.add(num2);

            }
            Collections.sort(list1);
            Collections.sort(list2);
            long ans = 0;
            for(int i = 0; i < list1.size(); i++){
                ans += abs(list1.get(i) - list2.get(i));
            }
            System.out.println(ans);

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
