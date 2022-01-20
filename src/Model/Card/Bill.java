package Model.Card;

import Model.Player.Player;

public class Bill  extends MessageCard{
    /**
     * <b>constructor</b>:Constructs a new Bill Card
     *
     * @param money  the money that the card costs
     * @param text   the text that the card containts
     * @param imgURL the URL of the card's image
     */
    public Bill(int money, String text, String imgURL) {
        super(money, text, imgURL);
    }
    /**
     * <b>Transformer:</b>This card contains an bill ,pay the bank 500 euros at the end of the month
     * <b>Postcondition:</b>Add 500 euros to player's bill
     * @param p
     */
    @Override
    public void CardAction(Player p) {
        p.setBills(this.getMoney());
        p.setMoney(-p.getBills());

    }
}
