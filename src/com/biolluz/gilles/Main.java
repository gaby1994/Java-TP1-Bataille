package com.biolluz.gilles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        // Creation of cards pack
        ArrayList<Card> deck = new ArrayList<>();
        for(int i = 0 ; i < Card.colors.length ; i++) {
            for(int j = 0 ; j < Card.values.length; j++) {
                Card tempCard = new Card(Card.colors[i], Card.values[j]);
                deck.add(tempCard);
            }
        }

        // Shuffle
        Collections.shuffle(deck);

        // Initialization of two decks of the same number of cards
        ArrayList<Card> deck1 = new ArrayList<>();
        ArrayList<Card> deck2 = new ArrayList<>();
        for (int i = 0; i <= 51; i=i+2){
            deck1.add(deck.get(i));
            deck2.add(deck.get(i+1));
        }
        System.out.print ("deck1 : "+deck1+"\n");
        System.out.print ("deck2 : "+deck2+"\n");

        // Initialization of the players
        // Player player1 = new Player("player1", deck1);
        // Player player2 = new Player("player2", deck2);
        String player1_first_name;
        System.out.print ("Player1 enter your first name:");
        Scanner user_input1 = new Scanner ( System.in );
        player1_first_name = user_input1.next ();
        Player player1 = new Player(player1_first_name, deck1);

        String player2_first_name;
        System.out.print ("Player2 enter your first name:");
        Scanner user_input2 = new Scanner ( System.in );
        player2_first_name = user_input2.next ();
        Player player2 = new Player(player2_first_name, deck2);

        // Initialization of the board game
        ArrayList<Card> boardGame = new ArrayList<>();

        // Battle

        while (player1.numberOfCards() != 0 && player2.numberOfCards() != 0){
            Card card1 = player1.takeACard();
            Card card2 = player2.takeACard();
            boardGame.add(card1);
            boardGame.add(card2);
            if (card1.getValue() == card2.getValue()) {
                while (card1.getValue() == card2.getValue()) {
                    boardGame.add(player1.takeACard());
                    boardGame.add(player2.takeACard());
                    card1 = player1.takeACard();
                    card2 = player2.takeACard();
                    boardGame.add(card1);
                    boardGame.add(card2);
                }
            }
            if (card1.getValue() > card2.getValue()){
                System.out.println(boardGame+" ====> "+player1.getname()+" wins the battle");
                player1.PickUpTheCards(boardGame);
                boardGame.removeAll(boardGame);
            } else {
                System.out.println(boardGame+" ====> "+player2.getname()+" wins, the battle");
                player2.PickUpTheCards(boardGame);
                boardGame.removeAll(boardGame);
            }

            System.out.println("balance sheet : "+player1.getInfos());
            System.out.println("balance sheet : "+player2.getInfos());
            System.out.println("==============================================================================================================");

        }

        if (player1.numberOfCards() == 0) {
            System.out.println(player2.getname()+" wins the war");
        }
        if (player2.numberOfCards() == 0) {
            System.out.println(player1.getname()+" wins the war");
        }




    }

}
