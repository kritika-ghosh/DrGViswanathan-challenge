/**
 * Day 28: Flood Fill
 * Problem Link: https://leetcode.com/problems/flood-fill/
 */
import java.util.Arrays;

public class Day28FloodFill {

    int newColor;
    int oldColor;

    int[][] dir = {
        {-1,0},
        {1,0},
        {0,-1},
        {0,1}
    };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        newColor = color;
        oldColor = image[sr][sc];

        if(oldColor != newColor){
            dfs(image, sr, sc);
        }

        return image;
    }


    public void dfs(int[][] image, int r, int c){

        if(r < 0 || c < 0 ||
           r >= image.length ||
           c >= image[0].length ||
           image[r][c] != oldColor){

            return;
        }


        image[r][c] = newColor;


        for(int[] d : dir){
            dfs(image, r + d[0], c + d[1]);
        }
    }

    // Driver code to test the implementation
    public static void main(String[] args) {
        Day28FloodFill solver = new Day28FloodFill();

        System.out.println("--- Day 28: Flood Fill ---");

        // Test Case 1: Standard grid with connected components
        int[][] image1 = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr1 = 1, sc1 = 1, color1 = 2;
        
        System.out.println("Original Image 1:");
        for (int[] row : image1) System.out.println(Arrays.toString(row));
        
        int[][] result1 = solver.floodFill(image1, sr1, sc1, color1);
        
        System.out.println("\nAfter Flood Fill (Start: [1,1], Color: 2):");
        for (int[] row : result1) System.out.println(Arrays.toString(row));
        System.out.println();

        // Test Case 2: Image color matches the replacement color (No modification)
        int[][] image2 = {
            {0, 0, 0},
            {0, 0, 0}
        };
        int sr2 = 0, sc2 = 0, color2 = 0;
        
        System.out.println("Original Image 2:");
        for (int[] row : image2) System.out.println(Arrays.toString(row));
        
        int[][] result2 = solver.floodFill(image2, sr2, sc2, color2);
        
        System.out.println("\nAfter Flood Fill (Start: [0,0], Color: 0):");
        for (int[] row : result2) System.out.println(Arrays.toString(row));
    }
}