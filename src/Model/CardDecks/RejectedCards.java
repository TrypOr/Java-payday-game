package Model.CardDecks;

import Model.Card.Card;
import Model.Card.DealCard;
import Model.Card.MessageCard;

import java.util.Stack;

/**
 * Class that contains the rejected cards and returns them to the corresponding card deck
 */
public class RejectedCards {
    private Stack<Card> RejectedDeck;

    /**
     * <b>constructor</b>: Constructs an arraylist of Cards
     * Postcondition:constructs a new arraylist empty
     */
    public  RejectedCards() {
        RejectedDeck = new Stack<Card>();
    }

    /**
     * <b>Transformer<b>:Function which returns rejected cards to their correspoding deck
     * <b>Precondition:</b>Must contain elements
     * <b>Postcondition:</b>cards are returned to their deck
     * @param mCard the MessageCardDeck
     * @param dCard the DealCardDeck
     */
    public void rejectedCard_return(MessageCardDeck mCard, DealCardDeck dCard) {
        while (!RejectedDeck.isEmpty()) {
            Card C = RejectedDeck.pop();
            if (C instanceof DealCard) {
                dCard.AddCard_to_Deck((DealCard) C);
            } else {
                mCard.AddCard_to_Deck((MessageCard) C);
            }
        }
        mCard.DeckShuffle();
        dCard.DeckShuffle();
    }

    /**
     *  <b>Transformer</b>:Add new card to arraylist
     *  <b>Postcondition: </b>new card is added to list ,at the end
     * @param rejCard the new card
     */
    public void RejectCard(Card rejCard) {
        RejectedDeck.push(rejCard);
    }

    /**
     * <b>Observer</b>:Checks whether the list is empty
     * @return true if empty else false
     */
    public boolean isEmpty() {
        return RejectedDeck.isEmpty();
    }
}
