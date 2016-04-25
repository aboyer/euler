package org.boyerfamily.euler.utils;

import java.util.Set;
import java.util.TreeSet;
import static org.boyerfamily.euler.utils.Card.COMPARE_BY_SUIT_AND_RANK;

/**
 * TODO: File Purpose
 * <p/>
 * Created by : aboyer (7/28/13 15:44)
 */
public class PokerHand {
    public static final int HAND_LIMIT = 5;
    public enum HandRanks {
        ROYAL_FLUSH,STRAIGHT_FLUSH,FOUR_OF_A_KIND,FULL_HOUSE,FLUSH,STRAIGHT,
        THREE_OF_A_KIND,TWO_PAIR,ONE_PAIR,HIGH_CARD};

    private Set<Card> cards;
    private HandRanks handRank;
    private Card.Rank firstRank;
    private Card.Rank secondRank;

    public PokerHand() {
        cards = new TreeSet<Card>(COMPARE_BY_SUIT_AND_RANK);
    }

    public PokerHand(Card one, Card two, Card three, Card four, Card five) {
        cards = new TreeSet<Card>(COMPARE_BY_SUIT_AND_RANK);
        cards.add(one);
        cards.add(two);
        cards.add(three);
        cards.add(four);
        cards.add(five);
    }

    public PokerHand(String handStr) {
        cards = new TreeSet<Card>(COMPARE_BY_SUIT_AND_RANK);
        String[] cardsStr = handStr.split(" ");

        for (int i=0; i<cardsStr.length; i++) {
            cards.add(new Card(cardsStr[i]));
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(handRank.name()+": ");

        for(Card card : cards) {
            result.append(card);
            result.append(",");
        }

        return result.substring(0, result.length() - 1);
    }

    public void addCard(Card c) {
        if (cards.size() == HAND_LIMIT)
            throw new ArrayIndexOutOfBoundsException("Added card to full hand");

        cards.add(c);
    }

    public void eval() {
        boolean hasFlush = false;
        boolean hasStraight = false;
        boolean hasFourOfAKind = false;
        boolean hasThreeOfAKind = false;
        boolean hasTwoPair = false;
        boolean hasPair = false;

//        Card.Suit suit =

    }

    public static void main(String[] args) {
        String[] hands = "AS KD 3D JD 8H|7C 8C 5C 9D 6C".split("\\|");
        System.out.println(hands[0]);
        System.out.println(hands[1]);

        PokerHand hand1 = new PokerHand(hands[0]);
        PokerHand hand2 = new PokerHand(hands[1]);

        hand1.eval();
        hand2.eval();

        System.out.println(hand1);
        System.out.println(hand2);
    }
}
