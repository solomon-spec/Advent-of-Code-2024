package day_4;

import java.io.File;
import java.util.*;

public class DayFour {
    static Map<String,Integer> wordCount;
    static List<String>  grid;
    public static String getVertical(int rowIndex, int colIndex, boolean reversed){
        int[] next = reversed ? new int[]{0, 1, 2, 3} : new int[]{3, 2, 1, 0};

        char[] chars = {grid.get(rowIndex + next[0]).charAt(colIndex),
                grid.get(rowIndex + next[1]).charAt(colIndex),
                grid.get(rowIndex + next[2]).charAt(colIndex),
                grid.get(rowIndex + next[3]).charAt(colIndex)
        };
        return new String(chars);
    }
    public static String getHorizontal(int rowIndex, int colIndex, boolean reversed){
        int[] next = reversed ? new int[]{0, 1, 2, 3} : new int[]{3, 2, 1, 0};

        char[] chars = {grid.get(rowIndex).charAt(colIndex + next[0]),
                grid.get(rowIndex).charAt(colIndex + next[1]),
                grid.get(rowIndex).charAt(colIndex + next[2]),
                grid.get(rowIndex).charAt(colIndex + next[3]),
        };
        return new String(chars);
    }
    public static String getDiagonal(int rowIndex, int colIndex, boolean reversed){
        int[] next = reversed ? new int[]{0, 1, 2, 3} : new int[]{3, 2, 1, 0};

        char[] chars = {grid.get(rowIndex + next[0]).charAt(colIndex + next[0]),
                grid.get(rowIndex + next[1]).charAt(colIndex + next[1]),
                grid.get(rowIndex + next[2]).charAt(colIndex + next[2]),
                grid.get(rowIndex + next[3]).charAt(colIndex + next[3]),
        };
        return new String(chars);
    }
    public static String getDiagonal2(int rowIndex, int colIndex, boolean reversed){
        int[] next = reversed ? new int[]{0, 1, 2, 3} : new int[]{3, 2, 1, 0};

        char[] chars = {grid.get(rowIndex - next[0]).charAt(colIndex + next[0]),
                grid.get(rowIndex - next[1]).charAt(colIndex + next[1]),
                grid.get(rowIndex - next[2]).charAt(colIndex + next[2]),
                grid.get(rowIndex - next[3]).charAt(colIndex + next[3]),
        };
        return new String(chars);
    }
    public static void main(String[] args){
        try{
            File file = new File("/home/tikursew/Documents/Advent of Code 2024/src/day_4/input.txt");
            Scanner scanner = new Scanner(file);
            grid = new ArrayList<>();
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                grid.add(line);

            }
            wordCount = new HashMap<>();
            int row = grid.size();
            int col = grid.getFirst().length();

            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(i < row - 3 && j < col - 3){
                        String curWord = getDiagonal(i,j, false);
                        wordCount.put(curWord, wordCount.getOrDefault(curWord,0) + 1);

                        curWord = getDiagonal(i,j, true);
                        wordCount.put(curWord, wordCount.getOrDefault(curWord,0) + 1);
                    }
                    if(i > 2 && j < col-3){
                        String curWord = getDiagonal2(i,j, false);
                        wordCount.put(curWord, wordCount.getOrDefault(curWord,0) + 1);

                        curWord = getDiagonal2(i,j, true);
                        wordCount.put(curWord, wordCount.getOrDefault(curWord,0) + 1);
                    }
                     if(i < row - 3){
                        String curWord = getVertical(i,j, false);
                        wordCount.put(curWord, wordCount.getOrDefault(curWord,0) + 1);

                        curWord = getVertical(i,j, true);
                        wordCount.put(curWord, wordCount.getOrDefault(curWord,0) + 1);

                    }
                     if(j < col - 3){
                        String curWord = getHorizontal(i,j, false);
                        wordCount.put(curWord, wordCount.getOrDefault(curWord,0) + 1);

                        curWord = getHorizontal(i,j, true);
                        wordCount.put(curWord, wordCount.getOrDefault(curWord,0) + 1);

                    }

                }
            }
            int totalXMAS = wordCount.getOrDefault("XMAS", 0);
            System.out.println(totalXMAS);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
