package Model.Tiles;

import Model.Card.DealCard;
import Model.Player.Player;

public class YardSaleTile extends Tiles{
    /**
     * <b>constructor</b>::Constructs a new YardSaleTile Tile which inside calls
     * the constructor of Tiles to initialise the inherited variables imgURL for image path
     * and Tileposition for the position of the tile
     *
     * @param imgURL Url of the image
     * @param Tileposition the position of the tile (Between 1-30)
     */
    public YardSaleTile(String imgURL, int Tileposition) {
        super(imgURL, Tileposition);
    }
    /**
     * <b>Transformer</b>: The player on the tile rolls and pays bank roll X 100 ,then takes first dealcard for free
     * <b>Postcondition:</b>Player has a new deal card
     * @param p the player on the tile
     */
    public void TileAction(Player p, int roll, DealCard dcard) {
        int price=roll*100;
        if (price<p.getMoney()) {
            p.setMoney(-price);
        } else {

            p.setLoan(price - p.getMoney());
            p.setMoney(-p.getMoney());
        }
        p.HoldDealCard(dcard);
    }
}

