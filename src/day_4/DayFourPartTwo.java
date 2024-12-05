package day_4;

import java.io.File;
import java.util.*;

public class DayFourPartTwo {
    static List<String> grid;
    static boolean checkMas(int r, int c){
        char center = grid.get(r).charAt(c);
        if (center != 'A') return false;

        char topLeft = grid.get(r - 1).charAt(c - 1);
        char topRight = grid.get(r - 1).charAt(c + 1);
        char bottomLeft = grid.get(r + 1).charAt(c - 1);
        char bottomRight = grid.get(r + 1).charAt(c + 1);
        if (topLeft == bottomRight || topRight == bottomLeft) return false;
        int[] count = new int[26];
        for (char ch : new char[]{topLeft, topRight, bottomLeft, bottomRight}) {
            count[ch - 'A']++;
        }
        return count ['M' - 'A'] == 2 && count['S'-'A'] == 2;

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
