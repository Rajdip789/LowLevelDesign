package com.LLDTicTacToe.Model;

public class Piece {

    private final PieceType type;

    public Piece(PieceType type) {
        this.type = type;
    }

    public PieceType getPieceType() {
        return type;
    }
}
