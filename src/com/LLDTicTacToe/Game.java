package com.LLDTicTacToe;

import com.LLDTicTacToe.Model.*;

import java.util.*;

public class Game {

    private final UUID uuid;

    private final Board board;
    private final Deque<Player> players;
    private final Stack<Move> movesHistory;

    private static final Scanner sc = new Scanner(System.in);
    private static final List<Piece> availablePieces = List.of(new PieceO(), new PieceX());

    public Game(int boardSize, List<User> users) {

        this.uuid = UUID.randomUUID();
        this.board = new Board(boardSize);
        this.players = new ArrayDeque<>();
        this.movesHistory = new Stack<Move>();

        if(users.size() > availablePieces.size()) {
            throw new IllegalArgumentException("Currently not enough unique pieces available for all users");
        }

        // Add from the last to the dequeue
        for(int i = 0; i < users.size(); i++) {
            players.add(new Player(users.get(i), availablePieces.get(i)));
        }
    }

    public User start() {

        int totalMoves = board.getSize() * board.getSize();

        while(totalMoves != 0) {

            // pop the user from head of the queue
            Player turn = players.pop();

            System.out.printf("%s it's your chance. Place %s on the board\n", turn.getName(), turn.getPiece().getPieceType());
            this.board.printBoard();

            // Loop continues until it's a valid move
            while(true) {

                int x = sc.nextInt();
                int y = sc.nextInt();

                try {
                    if(board.playMove(new Move(x, y, turn))) {
                        turn.getUser().incrementWins();
                        return turn.getUser();
                    }
                    movesHistory.push(new Move(x, y, turn));
                    break;
                } catch(IllegalArgumentException e) {
                    System.out.println("Invalid move. " + e.getMessage() + "\n Try again!");
                }
            }

            System.out.println("Do you want to undo it ? (yes/no)");

            if(sc.next().equalsIgnoreCase("yes")) {
                // Add the player again in the front of the dequeue
                players.addFirst(turn);

                this.board.undoMove(movesHistory.getLast());
                this.movesHistory.pop();
            } else {
                // Else add the player in the tail
                players.add(turn);
                totalMoves -= 1;
            }
        }

        return null;
     }
}