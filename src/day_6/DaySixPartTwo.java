package day_6;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DaySixPartTwo {
    public static List<String> grid;
    public static boolean[][][] visited;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static int curDirection = 0,row,col;
    public static boolean isValidCell(int x, int y){
        return 0 <= x && x < row && 0 <= y && y < col && grid.get(x).charAt(y) != '#';
    }
    public static boolean inBound(int x, int y){
        return 0 <= x && x < row && 0 <= y && y < col;
    }

    public static boolean dfs(int x, int y){
        if(visited[x][y][curDirection]){
            return true ;
        }
        visited[x][y][curDirection] = true;
        for(int i = 0; i < 4; i++){
            int nextX = x + dx[curDirection];
            int nextY = y + dy[curDirection];
            if(isValidCell(nextX,nextY)){
                return dfs(nextX,nextY);

            }
            else{
                if(!inBound(nextX,nextY)){
                    return false;
                }
                curDirection = (curDirection + 1) % 4;
            }

        }
        return false;


    }
    public static void main(String[] args) {
        try{
            grid = new ArrayList<>();
            File file = new File("/home/tikursew/Documents/Advent of Code 2024/src/day_6/input.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String line  = scanner.nextLine();
                grid.add(line);
            }
            row = grid.size();
            col = grid.getFirst().length();
            visited = new boolean[row][col][4];
            int startX = 0, startY = 0;
            for(int i = 0; i < row; i++){
                for(int  j = 0; j < col; j++){
                    if(grid.get(i).charAt(j) == '^'){
                        startX = i;
                        startY = j;
                    }
                }
            }
            int totalCycle = 0;
            for(int i = 0; i < row; i++){
                for(int  j = 0; j < col; j++){
                    if(grid.get(i).charAt(j) == '.'){
                        String row = grid.get(i);
                        String newRow = row.substring(0, j) + '#' + row.substring(j + 1);
                        grid.set(i,newRow);
                        for(boolean[][] curRow: visited){
                            for(boolean[] cell: curRow){
                                for(int k = 0; k < 4; k++){
                                    cell[k] = false;
                                }
                            }
                        }
                        curDirection = 0;
                        if(dfs(startX,startY)){
                            totalCycle++;
                        }
                        grid.set(i,row);
                    }
                }
            }
            System.out.println(totalCycle);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
