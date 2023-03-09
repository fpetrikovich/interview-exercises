public class RotateImage {
    public void rotate(int[][] matrix) {
        /**
         * We will rotate it in cycles, where each cycle n is the rotation
         * of the nth outer layer. Inside the loop, we will rotate by however
         * many elements the row/col of the cycle has.
         * EX: 1 loop in both fors will start by rotating the corners.
         */

        int N = matrix.length;

        for (int cycle = 0; cycle < N/2; cycle++) {
            for (int i = cycle; i < N - cycle - 1; i++) {
                int temp = matrix[cycle][i];
                matrix[cycle][i] = matrix[N-1-i][cycle];
                matrix[N-1-i][cycle] = matrix[N-1-cycle][N-1-i];
                matrix[N-1-cycle][N-1-i] = matrix[i][N-1-cycle];
                matrix[i][N-1-cycle] = temp;
            }
        }
    }
}
