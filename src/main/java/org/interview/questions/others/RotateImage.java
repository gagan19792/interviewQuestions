package org.interview.questions.others;

public class RotateImage {

//    Time and Space Complexity:
//
//    Time Complexity: O(n²), where n is the dimension of the matrix.
//
//    Space Complexity: O(1), as the transformation is done in-place.
    public static void rotateImage(int matrix[][]){
        int len = matrix.length;

        for(int i=0; i< len; i++){
            for(int j=i; j< len; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0; i< len; i++){
            reverse(matrix[i]);
        }
    }

    public static void  reverse(int row[]){
        int left= 0;;
        int right = row.length-1;
        while(left < right){
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }

    // Main method for testing purposes
    public static void main(String[] args) {
        RotateImage solution = new RotateImage();

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        rotateImage(matrix);

        // Print the rotated matrix
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        // Expected output:
        // 7 4 1
        // 8 5 2
        // 9 6 3
    }
}
