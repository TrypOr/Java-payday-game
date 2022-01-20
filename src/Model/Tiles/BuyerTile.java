package Model.Tiles;

import Model.Jackpot.Jackpot;
import Model.Player.Player;

public class BuyerTile extends Tiles{
    /**
     * <b>constructor</b>::Constructs a new BuyerTile Tile which inside calls
     * the constructor of Tiles to initialise the inherited variables imgURL for image path
     * and Tileposition for the position of the tile
     *
     * @param imgURL Url of the image
     * @param Tileposition the position of the tile (Between 1-30)
     */
    public BuyerTile(String imgURL, int Tileposition) {
        super(imgURL, Tileposition);
    }
    /**
     * <b>transformer</b>: The player on the tile has a choice to sell a deal card and chose which one to sell if he
     * has more than one deal card
     * <b>Precondition:</b>Player must have deal cards
     * <b>Postcondition:</b>Player's money have changed if he sold something
     * @param p the player on the tile
     */
    public void TileAction(Player p) {

    }
}
