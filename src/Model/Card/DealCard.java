package Model.Card;

import Model.Player.Player;

public class DealCard extends Card{
    private int sellPrice;
    /**
     * <b>constructor</b>:Constructs a new Card
     *
     * @param money  the money that the card costs
     * @param text   the text that the card containts
     * @param imgURL the URL of the card's image
     * @param sellPrice the Cards sell price
     */
    public DealCard(int money, String text, String imgURL,int sellPrice) {
        super(money, text, imgURL);
        this.sellPrice=sellPrice;
    }


    /**
     * <b>Transformer:</b>If the player buys the card ,
     * it is added to his card deck
     *else card goes to rejected cards
     * @param p
     */
    @Override
    public void CardAction(Player p) {
        p.setMoney(-this.getMoney());
        p.HoldDealCard(this);
    }
    /**
     *  <b>Accessor</b>:Returns the card's sell price
     * @return the sell price
     */
    public int getSellPrice(){
        return sellPrice;
    }

}
