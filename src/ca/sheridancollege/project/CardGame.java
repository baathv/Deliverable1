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

        ArrayList<Card> deck = new GenerateCards().generateDeck();

        ArrayList<Card> player = new ArrayList<>();
        ArrayList<Card> computer = new ArrayList<>();

        // Deal cards alternately
        for (int i = 0; i < deck.size(); i++) {
            if (i % 2 == 0) {
                player.add(deck.get(i));
            } else {
                computer.add(deck.get(i));
            }
        }

        int rounds = 0;
        int maxRounds = 5000; // safety to avoid infinite loop

        while (player.size() > 0 && computer.size() > 0 && rounds < maxRounds) {

            ArrayList<Card> pile = new ArrayList<>();
            int result = 0; // 0 = tie/war continues, 1 = player wins pile, 2 = computer wins pile

            // Keep battling until someone wins the pile OR someone runs out
            while (result == 0 && player.size() > 0 && computer.size() > 0) {

                Card playerCard = player.remove(0);
                Card computerCard = computer.remove(0);

                pile.add(playerCard);
                pile.add(computerCard);

                int playerValue = value(playerCard);
                int computerValue = value(computerCard);

                if (playerValue > computerValue) {
                    result = 1;
                } else if (computerValue > playerValue) {
                    result = 2;
                } else {
                    // WAR: 3 face-down cards each (if possible)
                    for (int i = 0; i < 3; i++) {
                        if (player.size() > 0) {
                            pile.add(player.remove(0));
                        }
                        if (computer.size() > 0) {
                            pile.add(computer.remove(0));
                        }
                    }
                    // loop continues and they flip again
                }
            }

            // If someone ran out during war, the other player should take the pile
            if (result == 0) {
                if (player.size() == 0 && computer.size() > 0) {
                    computer.addAll(pile);
                } else if (computer.size() == 0 && player.size() > 0) {
                    player.addAll(pile);
                }
            } else if (result == 1) {
                player.addAll(pile);
            } else if (result == 2) {
                computer.addAll(pile);
            }

            rounds++;
        }

        if (player.size() == 0) {
            System.out.println("Computer wins!");
        } else if (computer.size() == 0) {
            System.out.println("Player wins!");
        } else {
            System.out.println("Game stopped (too many rounds).");
        }
    }

    private static int value(Card card) {
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
