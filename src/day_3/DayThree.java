package day_3;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayThree {
    public static void main(String[] args) {
        try {
            File file = new File("/home/tikursew/Documents/Advent of Code 2024/src/day_3/input.txt");
            Scanner scanner = new Scanner(file);
            long totalSum = 0;
            String exp = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
            Pattern pattern = Pattern.compile(exp);
            while (scanner.hasNextLine()) {
                String myData = scanner.nextLine();
                Matcher matcher = pattern.matcher(myData);
                while(matcher.find()){
                    totalSum += (Long.parseLong(matcher.group(1)) * Long.parseLong(matcher.group(2)));
                }
            }
            System.out.println(totalSum);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
