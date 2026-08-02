class Solution {
    public void gameOfLife(int[][] board) {
        int[][] direction = {
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, -1 }, { 0, 1 },
                { 1, -1 }, { 1, 0 }, { 1, 1 }
        };

        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int liveNeighbour = 0;

                // Counting live neighbours
                // iterating to all direction of the board[i][j] to get the no. of live neighbours
                for (int dir[] : direction) {

                    // the lenght of element of direction is 2 {row -> (dir[0]), col -> (dir[1])}
                    int newRow = i + dir[0];
                    int newCol = j + dir[1];

                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                        if (board[newRow][newCol] == 1 || board[newRow][newCol] == -1) {
                            liveNeighbour++;
                        }
                    }

                }
                //  Live cell dies
                if (board[i][j] == 1 && (liveNeighbour < 2 || liveNeighbour > 3))
                    // -1 means was live but died
                    board[i][j] = -1;

                // Died cell Live again
                if (board[i][j] == 0 && liveNeighbour == 3)
                    //  2 means was dead but live again
                    board[i][j] = 2;

            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Converting the temporary Values(-1,2) to 0 and 1
                if (board[i][j] == -1)
                    board[i][j] = 0;

                if (board[i][j] == 2)
                    board[i][j] = 1;

            }
        }
    }
}