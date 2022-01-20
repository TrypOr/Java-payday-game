package Model.Card;

import Model.Player.Player;

public class Advertisment  extends MessageCard{
    /**
     * <b>constructor</b>:Constructs a new Advertisment Card
     * @param text   the text that the card containts
     * @param imgURL the URL of the card's image
     */
    public Advertisment(String text, String imgURL) {
        super(0,text, imgURL);
    }


    /**
     * <b>Transformer:</b>This card contains an add sell it for 20 euros
     * <b>Postocondition:</b>adds 20 euros to players balance
     * @param p
     */
    @Override
    public void CardAction(Player p) {

    }
}
