/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Vishav.Baath
 */
import java.util.ArrayList;

public class CardGame {

    public static void main(String[] args) {

        GenerateCards generator = new GenerateCards();
        ArrayList<Card> deck = generator.generateDeck();

        int playerScore = 0;
        int computerScore = 0;

        System.out.println("=== WAR GAME ===\n");

        for (int round = 1; round <= 5; round++) {

            Card playerCard = generator.draw(deck);
            Card computerCard = generator.draw(deck);

            int playerValue = cardValue(playerCard);
            int computerValue = cardValue(computerCard);

            System.out.println("Round " + round);
            System.out.println("Player card: " + playerCard.getValue() + " of " + playerCard.getSuit());
            System.out.println("Computer card: " + computerCard.getValue() + " of " + computerCard.getSuit());

            if (playerValue > computerValue) {
                playerScore++;
                System.out.println("Player wins this round!\n");
            } else if (computerValue > playerValue) {
                computerScore++;
                System.out.println("Computer wins this round!\n");
            } else {
                System.out.println("Tie round!\n");
            }
        }

        System.out.println("=== FINAL SCORE ===");
        System.out.println("Player: " + playerScore);
        System.out.println("Computer: " + computerScore);

        if (playerScore > computerScore) {
            System.out.println("PLAYER WINS THE GAME!");
        } else if (computerScore > playerScore) {
            System.out.println("COMPUTER WINS THE GAME!");
        } else {
            System.out.println("GAME IS A TIE!");
        }
    }

    // Convert card to number (very clear mapping)
    private static int cardValue(Card card) {
        switch (card.getValue()) {
            case TWO: return 2;
            case THREE: return 3;
            case FOUR: return 4;
            case FIVE: return 5;
            case SIX: return 6;
            case SEVEN: return 7;
            case EIGHT: return 8;
            case NINE: return 9;
            case TEN: return 10;
            case JACK: return 11;
            case QUEEN: return 12;
            case KING: return 13;
            case ACE: return 14;
            default: return 0;
        }
    }
}


