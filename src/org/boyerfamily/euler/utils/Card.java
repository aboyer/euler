package org.boyerfamily.euler.utils;

import javax.sql.StatementEvent;
import javax.swing.plaf.FontUIResource;
import java.util.Comparator;

/**
 * TODO: File Purpose
 * <p/>
 * Created by : aboyer (7/28/13 14:56)
 */
public class Card implements Comparable<Card> {
    private Rank rank;
    private Suit suit;

    public enum Rank {
        TWO ('2'), THREE ('3'), FOUR ('4'), FIVE ('5'),
        SIX ('6'), SEVEN ('7'), EIGHT ('8'), NINE ('9'), TEN ('T'),
        JACK ('J'), QUEEN ('Q'), KING ('K'), ACE ('A');

        private final char rankChar;
        Rank(char rank) {
            this.rankChar = rank;
        };

        public static Rank rankByChar(char rankChar) {
            for (Rank r : Rank.values())  {
                if (r.rankChar == rankChar)
                    return r;
            }
            return null;
        }

        public Rank next() {
            if (this.ordinal() == Rank.ACE.ordinal())
                return null;

            return Rank.values()[this.ordinal()+1];
        };
    };

    public enum Suit {
        HEARTS ('H'), CLUBS ('C'), DIAMONDS ('D'), SPADES ('S');

        private final char suitChar;
        Suit(char suitChar) {
            this.suitChar = suitChar;
        }

        public static Suit suitByChar(char suitChar) {
            for (Suit s : Suit.values()) {
                if (s.suitChar == suitChar)
                    return s;
            }
            return null;
        }
    }

    public Card(String cardStr) {
        char[] chars = cardStr.toCharArray();

        this.rank = Rank.rankByChar(chars[0]);
        this.suit = Suit.suitByChar(chars[1]);

        if (this.rank == null || this.suit == null)
            System.err.println("ERROR: Bad card string - " + cardStr);
    }

    public String toString() {
        return (this.rank + " OF " + this.suit).toLowerCase();
    }

    public int compareTo(Card c) {
        return rank.compareTo(c.rank);
    }

    public boolean equals(Card c) {
        return rank.equals(c.rank) && suit.equals(c.suit);
    }

    public static Comparator<Card> COMPARE_BY_SUIT_AND_RANK = new Comparator<Card>() {
        public int compare(Card card, Card card1) {
            int rankCompare = card.rank.compareTo(card1.rank);

            if (rankCompare == 0)
                return card.suit.compareTo(card1.suit);
            else
                return rankCompare;
        }
    };

    public static void main(String[] args) {
        Card cardOne = new Card("JS");
        Card cardTwo = new Card("0H");

        if (cardOne.compareTo(cardTwo) < 0) {
            System.out.println(cardOne + " < " + cardTwo);
        } else if (cardOne.compareTo(cardTwo) == 0) {
            System.out.println(cardOne + " = " + cardTwo);
        } else {
            System.out.println(cardOne + " > " + cardTwo);
        }

        if (cardTwo.rank.equals(cardOne.rank.next()))
            System.out.println("Card two is next card");
    }
}
