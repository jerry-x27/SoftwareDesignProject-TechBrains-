/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Player.java modified by Eshaarveer Singh (991744745) -TechBrains-!
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author Eshaarveer Singh Oct 2024
 */
public class Player {
    private String name;
    private GroupOfCards hand;

    public Player(String name) {
        this.name = name;
        this.hand = new GroupOfCards();
    }

    public void addCard(Card card) {
        hand.addCard(card);
    }

    public Card playCard(int index) {
        return hand.removeCard(index);
    }

    public int getHandValue() {
        return hand.getValue();
    }

    public boolean hasBusted() {
        return getHandValue() > 21;
    }

    public GroupOfCards getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ": " + hand + " (Total: " + getHandValue() + ")";
    }
}
