/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Game.java modified by Divyanshu Verma (991758829) -TechBrains-!
 */
package ca.sheridancollege.project;

// @author Divyanshu Verma Oct 2024

import java.util.ArrayList;

// Game.java
import java.util.Scanner;

public class Game {
    private GroupOfCards deck;
    private Player player;
    private Player dealer;

    public Game(String playerName) {
        deck = new GroupOfCards();
        initializeDeck();
        deck.shuffle();
        player = new Player(playerName);
        dealer = new Player("Dealer");
    }

    private void initializeDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.addCard(new Card(suit, rank));
            }
        }
    }

    public void start() {
        dealInitialCards();
        Scanner scanner = new Scanner(System.in);

        System.out.println(player);
        System.out.println(dealer);

        boolean playerTurn = true;

        while (playerTurn) {
            System.out.print("Do you want to hit or stand? (hit/stand): ");
            String action = scanner.nextLine();

            if (action.equalsIgnoreCase("hit")) {
                player.addCard(deck.drawCard());
                System.out.println(player);
                if (player.hasBusted()) {
                    System.out.println("You bust! Dealer wins.");
                    return;
                }
            } else if (action.equalsIgnoreCase("stand")) {
                playerTurn = false;
            } else {
                System.out.println("Invalid action. Please choose hit or stand.");
            }
        }

        // Dealer's turn
        while (dealer.getHandValue() < 17) {
            dealer.addCard(deck.drawCard());
        }

        System.out.println(dealer);

        // Determine winner
        determineWinner();
        scanner.close();
    }

    private void dealInitialCards() {
        for (int i = 0; i < 2; i++) {
            player.addCard(deck.drawCard());
            dealer.addCard(deck.drawCard());
        }
    }

    private void determineWinner() {
        int playerValue = player.getHandValue();
        int dealerValue = dealer.getHandValue();

        System.out.println("Your total: " + playerValue);
        System.out.println("Dealer's total: " + dealerValue);

        if (dealerValue > 21 || playerValue > dealerValue) {
            System.out.println("You win!");
        } else if (playerValue < dealerValue) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        Game game = new Game(playerName);
        game.start();

        scanner.close();
    }
}
