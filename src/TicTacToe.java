import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
 * ;;; Tic-tac-toe
 * ;;;
 * ;;; Problem Statement:
 * ;;;
 * ;;; Metabase wants to offer an exciting new feature, where our users can play
 * ;;; the classic game of tic-tac-toe together. We need you to write up the core
 * ;;; logic that decides who won. Some customers were asking about were asking
 * ;;; about making it more than the usual 3x3 board, but for now we only have
 * ;;; resources to give them the classic version.
 * ;;;
 * ;;; It's up to you to decide what the board's structure is. The frontend will
 * ;;; send their boards to be checked to your calculate-winner function over our
 * ;;; json API. The frontend team wants to highlight the winning move, so please
 * ;;; relay that information as well.
 * ;;;
 * ;;; We need you to choose a shape for the board, and implement calculate-winner.
 *
 * (defn calculate-winner [board]
 *
 *   )
 *
 * ;; Such that:
 *
 * (calculate-winner empty-board)
 * ;;=> {:winner nil}
 *
 * (calculate-winner x-wins-board)
 * ;;=> {:winner :x
 * ;;    :position your-representation-of-the-winning-position}
 *
 * (calculate-winner full-board)
 * ;;=> {:winner nil :game-over? true}
 */
public class TicTacToe {

    interface TicTacToeScenarios {
        Map<String, Object> calculateScenario(BOARD_STATE[][] board);
    }

    private enum BOARD_STATE {
        EMPTY,
        X,
        O
    }

    public static void main (String[] args) {

        // 1 0 1
        // 1 2 2
        // 1 2 0
        BOARD_STATE[][] board = new BOARD_STATE[3][3];
        board[0][0] = BOARD_STATE.X;
        board[0][1] = BOARD_STATE.EMPTY;
        board[0][2] = BOARD_STATE.X;
        board[1][0] = BOARD_STATE.X;
        board[1][1] = BOARD_STATE.O;
        board[1][2] = BOARD_STATE.O;
        board[2][0] = BOARD_STATE.X;
        board[2][1] = BOARD_STATE.O;
        board[2][2] = BOARD_STATE.EMPTY;

        Map<String, Object> json = calculateWinner(board);

        if (json == null) {
            System.out.println("NO WINNER!");
            return;
        }

        printResults(json);

    }

    private static void printResults(Map<String, Object> result) {
        result.forEach((k, v) -> {
            if (v instanceof int[][]) {
                System.out.print(k + " -> ");
                for (int[] pos : (int[][]) v) {
                    System.out.print("[" + pos[0] + ", " + pos[1] + "] ");
                }
            } else if (v instanceof Character) {
                System.out.println(k + " -> " + (Character) v);
            } else {
                throw new IllegalStateException("Unknown Type Found.");
            }
        });
    }

    public static Map<String, Object> calculateWinner(BOARD_STATE[][] board) {
        // check if its n x n
        if (board.length == 0 || board.length != board[0].length) {
            throw new IllegalArgumentException("Board must be square.");
        }

        Map<String, Object> result;

        TicTacToeScenarios[] winnerScenarios = new TicTacToeScenarios[] {
                board1 -> findAcrossLine(board1, true),
                board2 -> findAcrossLine(board2, false),
                board3 -> findAcrossDiagonal(board3, true),
                board4 -> findAcrossDiagonal(board4, false),
        };

        for (TicTacToeScenarios scenario : winnerScenarios) {
            result = scenario.calculateScenario(board);
            if (result != null) {
                return result;
            }
        }

        return null;
    }

    // ANALYZE THE BOARD METHODS
    private static Map<String, Object> findAcrossDiagonal(BOARD_STATE[][] board, boolean isLeft) {
        int[][] pos = new int[board.length][2];
        BOARD_STATE initialState = BOARD_STATE.EMPTY;
        for (int d = 0; d < board.length; d++) {
            if (d == 0) {
                initialState = getValueAtDiagonalPosition(board, d, isLeft);
            }
            else if (getValueAtDiagonalPosition(board, d, isLeft) != initialState){
                break;
            }
            pos[d][0] = d;
            pos[d][1] = isLeft ? d : board.length - d - 1;
        }
        if (initialState != BOARD_STATE.EMPTY) {
            return generateWinnerResult(initialState, pos);
        }
        return null;
    }

    private static Map<String, Object> findAcrossLine(BOARD_STATE[][] board, boolean isRow) {
        BOARD_STATE initialState = BOARD_STATE.EMPTY;
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (j == 0) {
                    initialState = getValueAtLinePosition(board, i, j, isRow);
                } else if (getValueAtLinePosition(board, i, j, isRow) != initialState) {
                    break;
                }
            }

            if (initialState != BOARD_STATE.EMPTY) {
                return generateWinnerResult(initialState,  calculateWinningPositions(i, board.length - 1, isRow));
            }
        }
        return null;
    }
    private static BOARD_STATE getValueAtLinePosition(BOARD_STATE[][] board, int i, int j, boolean isRow) {
        return isRow ? board[i][j] : board[j][i];
    }

    private static BOARD_STATE getValueAtDiagonalPosition(BOARD_STATE[][] board, int i, boolean isLeft) {
        return isLeft ? board[i][i] : board[i][board.length - i];
    }

    // GENERATE WINNER RESULTS
    private static int[][] calculateWinningPositions(int i, int j, boolean isRow) {
        int boardLen = Math.max(i, j) + 1;
        int[][] pos = new int[boardLen][2];

        for (int l = 0; l < boardLen; l++) {
            pos[boardLen - l - 1][0] = i;
            pos[boardLen - l - 1][1] = j;
            if (isRow) {
                j--;
            } else {
                i--;
            }
        }
        return pos;
    }

    private static Map<String, Object> generateWinnerResult(BOARD_STATE winner, int[][] pos) {
        Map<String, Object> result = new HashMap<>();
        result.put("winner", winner == BOARD_STATE.X ? 'X' : 'O');
        result.put("positions", pos);
        return result;
    }

}
