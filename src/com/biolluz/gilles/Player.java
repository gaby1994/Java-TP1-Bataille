package com.biolluz.gilles;

import java.util.ArrayList;
import java.util.Collections;

public class Player {
    private String name;
    private ArrayList<Card> deck;
    private ArrayList<Card> reserve;

    public Player(String name, ArrayList<Card> deck) {
        this.name = name;
        this.deck = deck;
        this.reserve = new ArrayList<>();
    }

    public Card takeACard (){
        if (this.deck.isEmpty()){
            if (this.reserve.isEmpty()) {
                System.out.println(this.name +" Loose");
                // System.exit(0);
                // on retourne une carte vide pour eviter le Systeme.exit un peu brutal
                // mais son deck sera vide et on sortira du while initiale à la prochaine iterration
                // ce qui entrainera la victoire de sont adversaire
                Card empty = new Card("empty", 0);
                return empty;
            } else {
                Collections.shuffle(this.reserve);
                while (!this.reserve.isEmpty()) {
                    // System.out.println(this.reserve);
                    this.deck.add(this.reserve.get(0));
                    this.reserve.remove(0);
                }
                // int card = (int) this.deck.get(0);
                Card tempCard = this.deck.get(0);
                this.deck.remove(0);
                return tempCard;
            }
        }

        Card tempCard = this.deck.get(0);
        this.deck.remove(0);
        return tempCard;

    }

    public void PickUpTheCards (ArrayList<Card> boardGame){
        while (!boardGame.isEmpty()){
            reserve.add(boardGame.get(0));
            boardGame.remove(0);
        }
    }

    public int numberOfCards () {
        int sizeOfDeck = this.deck.size();
        int sizeOfReserve = this.reserve.size();
        int numberOfCards = sizeOfDeck+sizeOfReserve;
        return numberOfCards;
    }

    public String getname(){return this.name;}

    public String getInfos(){
        int number;
        // remise à 52 pour tenir compte de l'introduction de cartes ("empty",0) en cas d'impossibilité de piocher lors d'une défaite sur bataille
        if (numberOfCards()>52) {
            number = 52;
        } else {
            number = numberOfCards();
        }
        return " There are "+number+" cards left in "+this.name;
    }
}
