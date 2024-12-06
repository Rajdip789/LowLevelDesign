package com.LLDTicTacToe.Model;

public class Player {

    private final User user;
    private final Piece piece;

    public Player(User user, Piece piece) {
        this.user = user;
        this.piece = piece;
    }

    public String getName() {
        return this.user.getName();
    }

    public Piece getPiece() { return piece; }

    public User getUser() { return user; }
}
