package Model.CardDecks;

import Model.Card.MessageCard;

import java.util.Collections;
import java.util.Stack;

/**
 * class that contains the message cards deck
 */
public class MessageCardDeck {
    private Stack<MessageCard> Deck; //We create an Stack to collect all the cards an arraylist could also been implemented
    /**
     *  <b>constructor</b>: Constructs the  Stack containing MessageCards
     *  Postcondition:constructs a new  Stack containing MessageCards
     */
    public MessageCardDeck(){
        Deck=new Stack<MessageCard>();
    }
    /**
     * <b>Transformer</b>:Shuffles the cards by shuffling the Stack
     *<b></b>Precondition</b>:The list must be full and contain all elements
     */
    public void DeckShuffle(){
        Collections.shuffle(Deck);
    }
    /**
     * <b>Observer</b>:Checks whether the list is empty
     * @return true if empty else false
     */
    public boolean isEmpty(){
        return Deck.isEmpty();
    }
    /**
     *  <b>Transformer</b>:Add new card to Stack
     *  <b>Postcondition: </b>new card is added to Stack ,at the end
     * @param mCard the new card
     */
    public void AddCard_to_Deck(MessageCard mCard){
        Deck.push(mCard);
    }
    /**
     *  <b>Transformer</b>:Get a card from the Stack and removes it
     *  <b>Postcondition: </b> Removes a card from the Stack shortening it by 1 at the start
     *  @return dealcard (Void for the time being)
     */
    public MessageCard getCard(){
        return Deck.pop();
    }
}

