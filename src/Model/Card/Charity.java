package Model.Card;

import Model.Jackpot.Jackpot;
import Model.Player.Player;

public class Charity extends MessageCard{
    /**
     * <b>constructor</b>:Constructs a new Charity Card
     *
     * @param money  the money that the card costs
     * @param text   the text that the card containts
     * @param imgURL the URL of the card's image
     */
    public Charity(int money, String text, String imgURL) {
        super(money, text, imgURL);
    }


    /**
     * <b>Transformer:</b>This card contains an number of money ,pay the money,if not available a loan is compulsory
     * <b>Precondition:</b>Player must have the money
     * <b>Postcondition:</b>Add money to jackpot
     * @param p the player
     * @param jackpotSize the jackpotsize
     */
    public void CardAction(Player p, Jackpot jackpotSize) {
        if(this.getMoney()>p.getMoney()) //In case players money dont suffice he gets a loan
        {
            p.setLoan(this.getMoney()-p.getMoney());
            p.setMoney(this.getMoney()-p.getMoney());
        }
        p.setMoney(-this.getMoney());
        jackpotSize.AddJackpot(this.getMoney());
    }
}
