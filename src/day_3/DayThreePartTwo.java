package day_3;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayThreePartTwo {
    public static void main(String[] args) {
        try {
            File file = new File("/home/tikursew/Documents/Advent of Code 2024/src/day_3/input.txt");
            Scanner scanner = new Scanner(file);
            long totalSum = 0;
            String exp = "mul\\((\\d{1,3}),(\\d{1,3})\\)|do\\(\\)|don't\\(\\)";
            Pattern pattern = Pattern.compile(exp);
            boolean isPreviousDo = true;
            while (scanner.hasNextLine()) {
                String myData = scanner.nextLine();
                Matcher matcher = pattern.matcher(myData);
                while(matcher.find()){
                    if(matcher.group().contains("m")){
                        if(isPreviousDo){
                            totalSum += (Long.parseLong(matcher.group(1)) * Long.parseLong(matcher.group(2)));
                        }
                    }
                    else{
                        isPreviousDo = matcher.group().equals("do()");
                    }
                }
            }
            System.out.println(totalSum);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
