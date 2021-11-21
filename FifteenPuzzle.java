package MetroHacks2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FifteenPuzzle {
    public static void main(String[] args) {
        int[][] board = new int[4][4];
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
        int[][] solved = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
        Scanner input = new Scanner(System.in);

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

        // Find the location of the zero, or the empty square
        int[] zeroPos = findNum(0, board);

        // Set up more variables
        int[] pickPos, temp;
        int pick, dx, dy;
        // Game loop
        while(!(Arrays.deepEquals(board, solved))){
            System.out.print("\nPick a tile to slide: ");
            pick = input.nextInt();
            pickPos = findNum(pick, board);
            dx = Math.abs(pickPos[0]-zeroPos[0]);
            dy = Math.abs(pickPos[1]-zeroPos[1]);
            if(dx<=1 && dy <= 1){
                System.out.println("test");
                temp = new int[]{pickPos[0], pickPos[1]};
                pickPos = new int[]{zeroPos[0], zeroPos[1]};
                zeroPos = new int[]{temp[0], temp[1]};
                board[zeroPos[0]][zeroPos[1]] = 0;
                board[pickPos[0]][pickPos[1]] = pick;
            }
            printArr(board[0]); printArr(board[1]); printArr(board[2]); printArr(board[3]);
        }
    }

    public static void printArr(int[] arr) {
        for (int elem : arr) {
            System.out.print(elem + "\t");
        }
        System.out.println();
    }

    public static int[] findNum(int n, int[][] arr){
        int x = 0, y = 0;
        boolean exit = false;
        for(int i = 0; i < 4; i++){
            x = i;
            for(int j = 0; j < 4; j++){
                if(arr[i][j] == n){
                    y = j;
                    exit = true;
                    break;
                }
            }
            if(exit)
                break;
        }
        return new int[]{x, y};
    }
}
