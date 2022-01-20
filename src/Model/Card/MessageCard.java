package Model.Card;

import Model.Player.Player;

public class MessageCard extends Card{
    /**
     * <b>constructor</b>:Constructs a new MessageCard Card
     *
     * @param money  the money that the card costs
     * @param text   the text that the card containts
     * @param imgURL the URL of the card's image
     */
    public MessageCard(int money, String text, String imgURL) {
        super(money, text, imgURL);
    }


    /**
     * @param p
     */
    @Override
    public void CardAction(Player p) {

    }
}
