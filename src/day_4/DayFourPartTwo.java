package day_4;

import java.io.File;
import java.util.*;

public class DayFourPartTwo {
    static List<String> grid;
    static boolean checkMas(int r, int c){
        if(grid.get(r).charAt(c) == 'A'){
            boolean diagonalNotEqual = grid.get(r-1).charAt(c-1) != grid.get(r+1).charAt(c+1);
            boolean diagonal2NotEqual = grid.get(r+1).charAt(c-1) != grid.get(r-1).charAt(c+1);
            Map<Character, Integer> count = new HashMap<>();
            char[] chars = {
                    grid.get(r-1).charAt(c-1),
                    grid.get(r+1).charAt(c-1),
                    grid.get(r-1).charAt(c+1),
                    grid.get(r+1).charAt(c+1)
            };
            for(char x: chars){
                count.put(x,count.getOrDefault(x,0)+1);
            }

            return diagonal2NotEqual && diagonalNotEqual &&
                    count.getOrDefault('M', 0) == 2
                    && count.getOrDefault('S', 0) == 2;
        }
        return false;
    }
    public static void main(String[] args) {
        try {
            grid = new ArrayList<>();
            File file = new File("/home/tikursew/Documents/Advent of Code 2024/src/day_4/input.txt");
            Scanner scanner = new Scanner(file);
            grid = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                grid.add(line);

            }
            int row = grid.size();
            int col = grid.getFirst().length();
            int totalMas = 0;

            for(int i = 1; i < row -1; i++){
                for(int j = 1; j < col -1; j++){
                    if(checkMas(i,j)){
                        totalMas++;
                    }
                }
            }
            System.out.println(totalMas);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
