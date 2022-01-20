package Model.Tiles;

import Model.Player.Player;

public class SweepstakesTile extends Tiles{
    /**
     * <b>constructor</b>::Constructs a new SweepstakesTile Tile which inside calls
     * the constructor of Tiles to initialise the inherited variables imgURL for image path
     * and Tileposition for the position of the tile
     *
     * @param imgURL Url of the image
     * @param Tileposition the position of the tile (Between 1-30)
     */
    public SweepstakesTile(String imgURL, int Tileposition) {
        super(imgURL, Tileposition);
    }
    /**
     * <b>Transformer:</b> Multiplies players cash according to the dice roll
     * @param p player on this tile
     * @param roll the dice roll
     */
    public void TileAction(Player p, int roll) {
        p.setMoney(roll * 1000);
    }
}
