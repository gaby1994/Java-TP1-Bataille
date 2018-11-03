package com.biolluz.gilles;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args){

        // Creation of cards pack
        ArrayList cardsPack = new ArrayList();
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j<= 13; j++){
                cardsPack.add(j);
            }
        }

        // Scuffle
        Collections.shuffle(cardsPack);

        // Initialization of two decks of the same number of cards
        ArrayList deck1 = new ArrayList();
        ArrayList deck2 = new ArrayList();
        for (int i = 0; i <= 51; i=i+2){
            deck1.add(cardsPack.get(i));
            deck2.add(cardsPack.get(i+1));
        }

        // Initialization of the players
        Player player1 = new Player("player1", deck1);
        Player player2 = new Player("player2", deck2);

        // Initialization of the board game
        ArrayList boardGame = new ArrayList();

        // Battle

        while (player1.numberOfCards() != 0 && player2.numberOfCards() != 0){
            int card1 = player1.takeACard();
            int card2 = player2.takeACard();
            boardGame.add(card1);
            boardGame.add(card2);
            if (card1 == card2) {
                while (card1 == card2) {
                    boardGame.add(player1.takeACard());
                    boardGame.add(player2.takeACard());
                    card1 = player1.takeACard();
                    card2 = player2.takeACard();
                    boardGame.add(card1);
                    boardGame.add(card2);
                }
            }
            if (card1 > card2){
                System.out.println(boardGame+" Player1 wins the round, there are "+player2.numberOfCards()+" cards left to his opponent");
                player1.PickUpTheCards(boardGame);
                boardGame.removeAll(boardGame);
            } else {
                System.out.println(boardGame+" Player2 wins the round, there are "+player1.numberOfCards()+" cards left to his opponent");
                player2.PickUpTheCards(boardGame);
                boardGame.removeAll(boardGame);
            }
        }

        if (player1.numberOfCards() == 0) {
            System.out.println("Player2 wins the game");
        }
        if (player2.numberOfCards() == 0) {
            System.out.println("Player1 wins the game");
        }

    }

}
