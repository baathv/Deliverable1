/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 * @author Prem Parashar
 * @author dancye
 */
public class Card {
    //default modifier for child classes

    public enum SUITS { CLUBS, DIAMONDS, HEARTS, SPADES }
    public enum VALUES { TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE }

    private VALUES value;
    private SUITS suit;

    public Card(VALUES value, SUITS suit) {
        this.value = value;
        this.suit = suit;
    }

    public VALUES getValue() {
        return value;
    }

    public SUITS getSuit() {
        return suit;
    }
   
}


