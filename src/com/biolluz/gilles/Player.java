package com.biolluz.gilles;

import java.util.ArrayList;
import java.util.Collections;

public class Player {
    private String name;
    private ArrayList deck;
    private ArrayList reserve;

    public Player(String name, ArrayList deck) {
        this.name = name;
        this.deck = deck;
        this.reserve = new ArrayList();
    }

    public int takeACard (){
        if (deck.isEmpty()){
            if (reserve.isEmpty()) {
                System.out.println(this.name +" Loose");
                // System.exit(0);
                // on retourne 0 qui n'est pas une carte pour eviter le Systeme.exit un peu brutal
                // mais son deck sera vide et on sortira du while initiale à la prochaine iterration
                // ce qui entrainera la victoire de sont adversaire
                return 0;
            } else {
                Collections.shuffle(reserve);
                while (!reserve.isEmpty()) {
                    deck.add(reserve.get(0));
                    reserve.remove(0);
                }
                int card = (int) this.deck.get(0);
                this.deck.remove(0);
                return card;
            }
        }

        int card = (int) this.deck.get(0);
        this.deck.remove(0);
        return card;

    }

    public void PickUpTheCards (ArrayList boardGame){
        while (!boardGame.isEmpty()){
            reserve.add(boardGame.get(0));
            boardGame.remove(0);
        }
    }

    public int numberOfCards (){
        return this.deck.size()+this.reserve.size();
    }

    public String getname(){return this.name;}
}
