package org.learn;

public class TestApp {

    public static void main(String[] args) {
        int[][] matrix = { {1,2, 3, 4, 13}, {5, 6, 7, 8, 14}, {9, 10, 11, 12, 15} };
        int row = matrix.length, column = matrix[0].length;
        /**
         * 
         * 0 0, 0 1, 0 2, 0 3
         * 1 0, 1 1, 1 2, 1 3
         * 
         * 00 01     10 00
         * 10 11     11 01
         * 20 21     12 02
         * 30 31     13 03
         */
        int y = 0;
        int [][] transpose = new int [column][row];
        for (int i = 0; i < column; i++) {
        	int x = row - 1;
	        for (int j = 0; j < row ; j++) {
	        		transpose[i][j] = matrix[x][y];
	        		x--;
	        	}
	            y++;
	    }
        
        for (int i = 0; i < column; i++) {
        	 
	        for (int j = 0; j < row ; j++) {
	           System.out.print(transpose[i][j] + " "); 
	        }
	        	System.out.println();
	    }
    }
}
