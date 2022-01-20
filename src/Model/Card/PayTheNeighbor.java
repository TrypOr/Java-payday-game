package Model.Card;

import Model.Player.Player;

public class PayTheNeighbor extends MessageCard{
    /**
     * <b>constructor</b>:Constructs a new PayTheNeighbor Card
     *
     * @param money  the money that the card costs
     * @param text   the text that the card containts
     * @param imgURL the URL of the card's image
     */
    public PayTheNeighbor(int money, String text, String imgURL) {
        super(money, text, imgURL);
    }
    /**<b>Transformer:</>Takes money from player p1 and gives it to player p2
     *  <b>Postcondition:</b>Player p1 has lost money and Player p2 has gained money
     * @param p the player who draws the card
     */
    @Override
    public void CardAction(Player p) {
        if(this.getMoney()>p.getMoney())//In case players money dont suffice he gets a loan
        {
            p.setLoan(this.getMoney()-p.getMoney());
            p.setMoney(-this.getMoney());
        }
        p.setMoney(-this.getMoney());
        p.getOpponent().setMoney(this.getMoney());
    }
}
