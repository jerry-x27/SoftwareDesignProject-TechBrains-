/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * GroupOfCards.java modified by Anupreet Kaur (991752090) -TechBrains-!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Anupreet Kaur
 */
public class GroupOfCards {
    private ArrayList<Card> cards;

    public GroupOfCards() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card removeCard(int index) {
        return cards.remove(index);
    }

    public Card drawCard() {
        return cards.remove(cards.size() - 1);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public int getValue() {
        int value = 0;
        int aces = 0;

        for (Card card : cards) {
            value += card.getValue();
            if (card.getRank() == Rank.ACE) {
                aces++;
            }
        }

        while (value > 21 && aces > 0) {
            value -= 10; // Count ACE as 1 instead of 11
            aces--;
        }
        return value;
    }

    public int size() {
        return cards.size();
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
