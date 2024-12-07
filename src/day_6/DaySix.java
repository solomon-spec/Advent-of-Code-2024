package day_6;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DaySix {
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

    public static void dfs(int x, int y){
        if(visited[x][y][curDirection]){
            return;
        }
        visited[x][y][curDirection] = true;
        for(int i = 0; i < 2; i++){
            int nextX = x + dx[curDirection];
            int nextY = y + dy[curDirection];
            if(isValidCell(nextX,nextY)){
                dfs(nextX,nextY);
                return;
            }
            else{
                if(!inBound(nextX,nextY)){
                    return;
                }
                curDirection = (curDirection + 1) % 4;
            }

        }

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
            for(int i = 0; i < row; i++){
                for(int  j = 0; j < col; j++){
                    if(grid.get(i).charAt(j) == '^'){
                        System.out.println(i + " " + j);
                        dfs(i,j);
                    }
                }
            }
            int totalVisitedCell = 0;
            for(boolean[][] row: visited){
                for(boolean[] cell: row){
                    boolean cellVisited = false;
                    for(boolean direction : cell){
                        cellVisited = cellVisited || direction;
                    }
                    if(cellVisited){
                        totalVisitedCell++;
                    }
                }
            }
            System.out.println(totalVisitedCell);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
