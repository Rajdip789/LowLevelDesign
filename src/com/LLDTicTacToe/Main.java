package com.LLDTicTacToe;

import com.LLDTicTacToe.Model.User;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        User a = new User("Rajdip");
        User b = new User("Hritwick");

        Game game = new Game(3, Arrays.asList(a, b));
        User winner = game.start();

        if(winner == null) {
            System.out.println("Draw");
        } else {
            System.out.printf("%s is the winner\n", winner.getName());
        }
    }
}
