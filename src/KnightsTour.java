import java.util.*;

public class KnightsTour {

  public int boardSize;

  // valid moves for knight from any position
  int[][] validMoves = { { 1, -2 }, { 1, 2 }, { -1, 2 }, { -1, -2 }, { 2, -1 }, { 2, 1 }, { -2, 1 }, { -2, -1 } };

  int chessBoard[][] = null;

  int maxMoves = 0;

  KnightsTour(int size) {
    boardSize = size;
    chessBoard = new int[boardSize][boardSize];

    maxMoves = boardSize * boardSize;
  }

  public boolean solve() {

    System.out.println("Board size " + boardSize + " * " + boardSize + ", Total moves - " + maxMoves);

    if (maxMoves > 0) {
      // initialize to store less than 0
      for (int x = 0; x < boardSize; x++)
        for (int y = 0; y < boardSize; y++)
          chessBoard[x][y] = 0;

      // move 1 - x =0, y =0
      chessBoard[0][0] = 1;

      if (getNextMove(0, 0, 2)) {
        print();
        return true;
      } else {
        System.out.println("No solution available");
      }
    } else {
      System.out.println("No solution available");
    }

    return false;
  }

  // prints the current board
  private void print() {
    System.out.println("------Start------");
    for (int x = 0; x < boardSize; x++) {
      for (int y = 0; y < boardSize; y++)
        System.out.print(chessBoard[x][y] + " ");
      System.out.println();
    }

    System.out.println("------END------");
  }

  // recursive method to get the next Move
  private boolean getNextMove(int x, int y, int moveNum) {
    if (moveNum > maxMoves)
      return true;

    List<int[]> availableMoves = getAvailableMoves(x, y);

    if (availableMoves.isEmpty() && moveNum != maxMoves)
      return false;

    // The logic here is to make sure surrounding items are taken care of first this
    // way, we don't have to return back
    Collections.sort(availableMoves, new Comparator<int[]>() {
      public int compare(int[] a, int[] b) {
        return a[2] - b[2];
      }
    });

    for (int[] newMove : availableMoves) {
      x = newMove[0];
      y = newMove[1];
      chessBoard[x][y] = moveNum;

      if (!emptyBoardCell(moveNum, x, y) && getNextMove(x, y, moveNum + 1))
        return true;

      // this will backtrack if no solution is found and moves are within max moves
      chessBoard[x][y] = 0;
    }

    return false;
  }

  // this will get list of cells where the knight can move from current position
  private List<int[]> getAvailableMoves(int r, int c) {

    List<int[]> availableMoves = new ArrayList<>();

    for (int[] m : validMoves) {
      int x = m[0];
      int y = m[1];

      // making sure current position + moves are within range before accessing array
      if (r + y >= 0 && r + y < boardSize) {
        if (c + x >= 0 && c + x < boardSize) {
          if (chessBoard[r + y][c + x] == 0) {
            int num = getEmptyNeighbors(r + y, c + x);
            availableMoves.add(new int[] { r + y, c + x, num });
          }
        }
      }
    }
    return availableMoves;
  }

  // this is to get the empty neighbor count
  private int getEmptyNeighbors(int r, int c) {
    int num = 0;
    for (int[] m : validMoves) {
      if (r + m[1] >= 0 && r + m[1] < boardSize) {
        if (c + m[0] >= 0 && c + m[0] < boardSize) {
          if (chessBoard[r + m[1]][c + m[0]] == 0)
            num++;
        }
      }
    }
    return num;
  }

  private boolean emptyBoardCell(int cnt, int r, int c) {
    if (cnt < (maxMoves - 1)) {
      List<int[]> availMoves = getAvailableMoves(r, c);
      for (int[] availMove : availMoves)
        if (getEmptyNeighbors(availMove[0], availMove[1]) == 0)
          return true;
    }
    return false;
  }
}
