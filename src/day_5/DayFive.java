package day_5;

import java.io.File;
import java.util.*;

public class DayFive {
    private static void addValue(Map<Integer, Set<Integer>> map, int key, int value) {
        map.putIfAbsent(key, new HashSet<>());
        map.get(key).add(value);
    }
    public static void main(String[] args) {
        try{
            File file = new File("/home/tikursew/Documents/Advent of Code 2024/src/day_5/input.txt");
            Scanner scanner = new Scanner(file);
            Map<Integer, Set<Integer>> graph = new HashMap<>();
            // data structure
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(line.length() > 2){
                    String[] nums = line.split("\\|");
                    int num1 = Integer.parseInt(nums[0]);
                    int num2 = Integer.parseInt(nums[1]);
                    addValue(graph, num1, num2);

                }
            }
            int middlePageSum = 0;
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] stringNums = line.split(",");
                List<Integer> nums = new ArrayList<>();
                for(String stringNum: stringNums){
                    nums.add(Integer.parseInt(stringNum));
                }

                boolean isValid = true;
                for(int i = 0; i < nums.size(); i++){
                    for(int j = i +1 ; j < nums.size(); j++){
                        if(graph.containsKey(nums.get(j)) && graph.get(nums.get(j)).contains(nums.get(i))){
                            isValid = false;
                            break;
                        }
                    }
                    if(!isValid){
                        break;
                    }
                }
                if(isValid){
                    int length = nums.size();
                    middlePageSum += nums.get(length/2);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
