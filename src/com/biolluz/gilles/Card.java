package com.biolluz.gilles;

public class Card {

    private String color;
    private int value;
    public static String[] colors = new String[] {"spade","heart","diamond","club"};
    public static int[] values = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13};

    public Card(String color, int value)
    {
        this.color = color;
        this.value = value;
    }

    public String getColor()
    {
        return this.color;
    }

    public int getValue()
    {
        return this.value;
    }

    public int comparator(Card card2)
    {
        return (this.value == card2.getValue()) ? 2 : ((this.value>card2.getValue()) ? 1 : 0);
    }

    public String toString()
    {
        return this.value + " of " + this.color;
    }

}