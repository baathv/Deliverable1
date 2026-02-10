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
import java.util.Collections;

public class GenerateCards {

    public ArrayList<Card> generateDeck() {

        ArrayList<Card> deck = new ArrayList<>();

        for (Card.SUITS s : Card.SUITS.values()) {
            for (Card.VALUES v : Card.VALUES.values()) {
                deck.add(new Card(v, s));
            }
        }

        Collections.shuffle(deck);
        return deck;
    }

    public Card draw(ArrayList<Card> deck) {
        return deck.remove(0);
    }
}

