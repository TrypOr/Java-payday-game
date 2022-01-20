package Model.CardDecks;


import Model.Card.DealCard;

import java.util.Collections;
import java.util.Stack;

/**
 * class that contains the deal cards deck
 */
public class DealCardDeck {
    private Stack<DealCard> Deck; //We create an Stack to collect all the cards an arraylist could also been implemented
    /**
     *  <b>constructor</b>: Constructs the  Stack containing Dealcards
     *  Postcondition:constructs a new  Stack containing Dealcards
     */
    public DealCardDeck(){
        Deck=new Stack<DealCard>();
    }
    /**
     * <b>Transformer</b>:Shuffles the cards by shuffling the Stack
     *<b></b>Precondition</b>:The Stack must be full and contain all elements
     */
    public void DeckShuffle(){
        Collections.shuffle(Deck);
    }
    /**
     * <b>Observer</b>:Checks whether the Stack is empty
     * @return true if empty else false
     */
    public boolean isEmpty(){
        return Deck.isEmpty();
    }
    /**
     *  <b>Transformer</b>:Add new card to arraylist
     *  <b>Postcondition: </b>new card is added to list ,at the end
     * @param dCard the new card
     */
    public void AddCard_to_Deck(DealCard dCard){
        Deck.push(dCard);
    }
    /**
     *  <b>Transformer</b>:Get a card from the list and removes it
     *  <b>Postcondition: </b> Removes a card from the stack shortening it by 1 at the start
     *  @return dealcard (Void for the time being)
     */
    public DealCard getCard(){
        return Deck.pop();
    }
}
