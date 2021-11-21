package MetroHacks2021;

import java.util.ArrayList;
import java.util.Arrays;

public class FifteenPuzzle {
    public static void main(String[] args) {
        int[][] board = new int[4][4];
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));

        // Assign board values
        for(int i = 0; i < 15; i++){
            int ind = (int)(Math.random()*nums.size());
            int num = nums.get(ind);
            int row = 0;
            int col = 0;
            while(board[row][col] != 0){
                col = (int)(Math.random()*4);
                row = (int)(Math.random()*4);
            }
            board[row][col] = num;
            nums.remove(ind);
        }

        printArr(board[0]); printArr(board[1]); printArr(board[2]); printArr(board[3]);


    }

    public static void printArr(int[] arr) {
        for (int elem : arr) {
            System.out.print(elem + "\t");
        }
        System.out.println();
    }
}
