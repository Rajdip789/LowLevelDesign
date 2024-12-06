package com.LLDTicTacToe.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {

    private final int size;
    private final Piece[][] board;

    private final List<HashMap<PieceType, Integer>> rowFreqMap, colFreqMap;
    private final HashMap<PieceType, Integer> mainDiagonalFreqMap, offDiagonalFreqMap;

    public Board(int size) {

        this.size = size;
        board = new Piece[size][size];

        rowFreqMap = new ArrayList<>();
        colFreqMap = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            rowFreqMap.add(new HashMap<>());
            colFreqMap.add(new HashMap<>());
        }

        mainDiagonalFreqMap = new HashMap<>();
        offDiagonalFreqMap = new HashMap<>();
    }

    /**
     * This function takes the user input and try to make that move on the board. Trows exception if there are invalid
     * argument and return true if current player win the game after this move.
     *
     * @param move represents a move made by the given player;
     * @return true if current player wins the game after this move, else false.
     * @throws IllegalArgumentException if x and y aren't valid or some piece is already there on the given position.
     */

    public boolean playMove(Move move) throws IllegalArgumentException {

        int x = move.getX();
        int y = move.getY();

        Player player = move.getPlayer();

        if(x < 0 || x >= size) {
            throw new IllegalArgumentException("Invalid row provided");
        } else if(y < 0 || y >= size) {
            throw new IllegalArgumentException("Invalid column provided");
        } else if(this.board[x][y] != null) {
            throw new IllegalArgumentException("Cell is already occupied");
        }

        PieceType pieceValue = player.getPiece().getPieceType();

        this.board[x][y] = player.getPiece();

        rowFreqMap.get(x).put(pieceValue, rowFreqMap.get(x).getOrDefault(pieceValue, 0) + 1);
        colFreqMap.get(y).put(pieceValue, colFreqMap.get(y).getOrDefault(pieceValue, 0) + 1);

        if(x == y) {
            mainDiagonalFreqMap.put(pieceValue, mainDiagonalFreqMap.getOrDefault(pieceValue, 0) + 1);
        }

        if(x + y == size - 1) {
            offDiagonalFreqMap.put(pieceValue, offDiagonalFreqMap.getOrDefault(pieceValue, 0) + 1);
        }

        /*
          Player will only be considered as won if any of the condition met.
          1. If freq of piece value in the row that corresponds to () is equal to size.
          2. If freq of piece value in the column that corresponds to (x, y) is equal to size.
          3. If freq of piece value in the main diagonal that corresponds to (w, y) is equal to size.
          4. If freq of piece value in the off diagonal that corresponds to (x, y) is equal to size.
         */

        boolean isWon = false;

        if(rowFreqMap.get(x).get(pieceValue) == size) { isWon = true; }

        if(colFreqMap.get(y).get(pieceValue) == size) { isWon = true; }

        if(x == y && mainDiagonalFreqMap.get(pieceValue) == size) { isWon = true; }

        if(x + y == size -1 && offDiagonalFreqMap.get(pieceValue) == size) { isWon = true; }

        return isWon;
    }

    public void undoMove(Move move) {

        int x = move.getX();
        int y = move.getY();
        PieceType pieceValue = move.getPlayer().getPiece().getPieceType();

        this.board[x][y] = null;

        // Decrease the entries for corresponding pieceValues
        rowFreqMap.get(x).put(pieceValue, rowFreqMap.get(x).get(pieceValue) - 1);
        colFreqMap.get(y).put(pieceValue, colFreqMap.get(y).get(pieceValue) - 1);

        // If it's part of main diagonal
        if(x == y) {
            mainDiagonalFreqMap.put(pieceValue, mainDiagonalFreqMap.get(pieceValue) - 1);
        }

        // If it's part of off diagonal
        if(x + y == size -1) {
            offDiagonalFreqMap.put(pieceValue, offDiagonalFreqMap.get(pieceValue) - 1);
        }
    }

    public int getSize() { return size; }

    public void printBoard() {

        for(Piece[] pieceArr : board) {
            for(Piece piece : pieceArr) {
                System.out.print(piece == null ? "   " : " "  + piece.getPieceType() + " ");
                System.out.print(" | ");
            }
            System.out.println();
        }
    }
}
