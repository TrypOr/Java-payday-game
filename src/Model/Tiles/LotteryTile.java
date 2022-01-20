package Model.Tiles;

import Model.Player.Player;

public class LotteryTile extends Tiles{
    /**
     * <b>constructor</b>::Constructs a new LotteryTile Tile which inside calls
     * the constructor of Tiles to initialise the inherited variables imgURL for image path
     * and Tileposition for the position of the tile
     *
     * @param imgURL Url of the image
     * @param Tileposition the position of the tile (Between 1-30)
     */
    public LotteryTile(String imgURL, int Tileposition) {
        super(imgURL, Tileposition);
    }
    /**
     * <b>transformer</b>:If a player is on this tile then the bank gives 1000 euros, to the player that his
     * choice is the same as the banks
     * <b>Postcondition:</b>Winner has 1000 more euros
     * @param p1 the player on the tile
     * @param p2 the other player
     * @param p1Choice the player on the tile's choice
     * @param p2Choice the other player's choice
     */
    public void TileAction(Player p1,Player p2,int p1Choice,int p2Choice) {

    }
}
