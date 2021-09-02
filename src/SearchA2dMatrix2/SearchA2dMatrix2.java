package SearchA2dMatrix2;

public class SearchA2dMatrix2 {

    public boolean inMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col -= 1;
            } else {
                row += 1;
            }
        }
        return false;
    }
}
