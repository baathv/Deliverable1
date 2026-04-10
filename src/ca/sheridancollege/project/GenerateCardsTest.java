package ca.sheridancollege.project;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class GenerateCardsTest {

    @Test
    public void testGenerateDeckSize() {
        GenerateCards deck = new GenerateCards();
        ArrayList<Card> cards = deck.generateDeck();

        assertEquals(52, cards.size());
    }

    @Test
    public void testGenerateDeckNotEmpty() {
        GenerateCards deck = new GenerateCards();
        ArrayList<Card> cards = deck.generateDeck();

        assertFalse(cards.isEmpty());
    }

    @Test
    public void testDrawReducesDeckSize() {
        GenerateCards deck = new GenerateCards();
        ArrayList<Card> cards = deck.generateDeck();

        int before = cards.size();
        deck.draw(cards);
        int after = cards.size();

        assertEquals(before - 1, after);
    }

    @Test
    public void testDrawReturnsCard() {
        GenerateCards deck = new GenerateCards();
        ArrayList<Card> cards = deck.generateDeck();

        Card c = deck.draw(cards);

        assertNotNull(c);
    }

    @Test
    public void testDrawFromEmptyDeck() {
        GenerateCards deck = new GenerateCards();
        ArrayList<Card> cards = new ArrayList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> {
            deck.draw(cards);
        });
    }

    @Test
    public void testCardValue() {
        Card card = new Card(Card.VALUES.ACE, Card.SUITS.SPADES);

        assertEquals(Card.VALUES.ACE, card.getValue());
    }

    @Test
    public void testCardSuit() {
        Card card = new Card(Card.VALUES.KING, Card.SUITS.HEARTS);

        assertEquals(Card.SUITS.HEARTS, card.getSuit());
    }
}
