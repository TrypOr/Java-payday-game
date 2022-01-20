package Model.Card;

import Model.Player.Player;

public class TakeFromTheNeighbor  extends MessageCard{
    /**
     * <b>constructor</b>:Constructs a new TakeFromTheNeighbor Card
     *
     * @param money  the money that the card costs
     * @param text   the text that the card containts
     * @param imgURL the URL of the card's image
     */
    public TakeFromTheNeighbor(int money, String text, String imgURL) {
        super(0, text, imgURL);
    }
    /**<b>Transformer:</>Takes money from player p2 and gives it to player p1
     *  <b>Postcondition:</b>Player p2 has lost money and Player p1 has gained money
     * @param p the player who draws the card
     */
    @Override
    public void CardAction(Player p) {
        if(this.getMoney()>(p.getOpponent()).getMoney())//In case players money dont suffice he gets a loan
        {
            (p.getOpponent()).setLoan(this.getMoney()-(p.getOpponent()).getMoney());
            (p.getOpponent()).setMoney(this.getMoney()-(p.getOpponent()).getMoney());
        }
        (p.getOpponent()).setMoney(-this.getMoney());
        p.setMoney(this.getMoney());
    }
}

