public class ConnectFour implements BoardGame {
    private int[][] board;
    private int currentPlayer;
    private Position[] winningPositions;
    private int winner;

    public ConnectFour() {
        newGame();
    }

    //Getter/Setter
    public int getCurrentPlayer() {
        return currentPlayer;
    }


    public boolean gameOver() {
        //HORIZONTAL
        /*for (int r = 0; r < board.length; r++) {
            for (int cStart = 0; cStart < 4; cStart++) {
                if ((board[r][cStart] == currentPlayer)&&(board[r][cStart + 1] == currentPlayer)&&(board[r][cStart + 2] == currentPlayer)&&(board[r][cStart + 3] == currentPlayer)) {
                    return true;

                }
            }
        }*/
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < 7 - 3; col++) {
                int player = board[row][col];
                if (player != 0 &&
                        player == board[row][col + 1] &&
                        player == board[row][col + 2] &&
                        player == board[row][col + 3]) {
                    for (int i = 0; i < 4; i++) {
                        winningPositions[i] = new Position(row, col + i);
                    }
                    return true;
                }
            }
        }

        //VERTICAL
        /*for (int c = 0; c < board[0].length; c++) {
            for (int rStart = 0; rStart < 3; rStart++) {
                if ((board[c][rStart] == currentPlayer)&&(board[c][rStart + 1] == currentPlayer)&&(board[c][rStart + 2] == currentPlayer)&&(board[c][rStart + 3] == currentPlayer)) {

                }
            }
        }*/
        for (int col = 0; col < board[0].length; col++) {
            for (int rowStart = 0; rowStart < board.length - 3; rowStart++) {
                int player = board[rowStart][col];
                if (player != 0 &&
                        player == board[rowStart + 1][col] &&
                        player == board[rowStart + 2][col] &&
                        player == board[rowStart + 3][col]) {
                    for (int i = 0; i < 4; i++) {
                        winningPositions[i] = new Position(rowStart + i, col);
                    }
                    return true;
                }
            }
        }


        //Diagonals
        /*for (int c = 0; c < 4; c++) {
            for (int r = 0; r < 3; r ++){
                if (board[c][r] == currentPlayer) {
                    if (board[c + 1][r + 1] == currentPlayer) {
                        if (board[c + 2][r + 2] == currentPlayer) {
                            if (board[c + 3][r + 3] == currentPlayer) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        for (int c = board[0].length; c > 2; c--) {
            for (int r = 0; r < 3; r ++) {
                if (board[c][r] == currentPlayer) {
                    if (board[c - 1][r + 1] == currentPlayer) {
                        if (board[c - 2][r + 2] == currentPlayer) {
                            if (board[c - 3][r + 3] == currentPlayer) {
                                return true;
                            }
                        }
                    }
                }
            }
        }*/
        // Diagonals (from top-left to bottom-right)
        for (int row = 0; row < board.length - 3; row++) {
            for (int col = 0; col < 7 - 3; col++) {
                int player = board[row][col];
                if (player != 0 &&
                        player == board[row + 1][col + 1] &&
                        player == board[row + 2][col + 2] &&
                        player == board[row + 3][col + 3]) {
                    for (int i = 0; i < 4; i++) {
                        winningPositions[i] = new Position(row + i, col + i);
                    }
                    return true;
                }
            }
        }

        // Diagonals (from top-right to bottom-left)
        for (int row = 0; row < board.length - 3; row++) {
            for (int col = 3; col < 7; col++) {
                int player = board[row][col];
                if (player != 0 &&
                        player == board[row + 1][col - 1] &&
                        player == board[row + 2][col - 2] &&
                        player == board[row + 3][col - 3]) {
                    for (int i = 0; i < 4; i++) {
                        winningPositions[i] = new Position(row + i, col - i);
                    }
                    return true;
                }
            }
        }

        // Full Board
        int count = 0;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] != 0) {
                    count++;
                }
                if (count == board.length*board[0].length) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Who is the winner?
     * @return 0 if there is no winner, 1 if the first player is a winner, 2 if the second player is a winner.
     */
    @Override
    public int getWinner() {
        if (gameOver()) {
            winner = currentPlayer;
            return winner;
        }
        return -1;
    }

    /**
     * Where are the tokens that determine who the winner is?
     *
     * @return the locations of the pieces that determine the game winner.
     */
    @Override
    public Position[] getWinningPositions() {
        return winningPositions;
    }

    public void newGame() {
        board = new int[6][7];
        currentPlayer = 1+(int)(Math.random()*2);
        winningPositions = new Position[4];
    }

    public boolean columnFull(int column) {
        return board[0][column] != 0;
    }

    public void play(int column) {
        if(!columnFull(column)) {
            for (int r = 5; r >=0; r--) {
                if (board[r][column] == 0) {
                    board[r][column] = currentPlayer;
                    currentPlayer = (currentPlayer == 1) ? 2 : 1;
                    return;
                }
            }
        }
    }

    /**
     * What is the current board configuration?
     *
     * @return for each cell on the board grid:
     * 0 if it is not filled,
     * 1 if it is filled by the first player's piece,
     * 2 if it is filled by the second player's piece.
     */
    @Override
    public int[][] getBoard() {
        return board;
    }
}
