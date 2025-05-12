package org.interview.questions.dfs;

public class FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if(oldColor == newColor) return image;
        dfs(image,sr, sc, newColor, oldColor);
        return image;
    }

    public static void dfs(int[][] image, int r, int c, int newColor, int oldColor){
        if(r < 0 || c < 0 || r>=image.length || c>= image[0].length)return;
        if(image[r][c] != oldColor) return;

        dfs(image,r - 1, c, newColor, oldColor); // TOP

        dfs(image,r + 1, c, newColor, oldColor); // DOWN

        dfs(image,r, c - 1, newColor, oldColor); //LEFT

        dfs(image,r, c + 1, newColor, oldColor); //RIGHT


    }

    public static void main(String[] args) {

    }
}
