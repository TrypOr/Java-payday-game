package Model.Tiles;

import Model.Player.Player;

public class RadioContestTile extends Tiles{
    /**
     * <b>constructor</b>::Constructs a new RadioContestTile Tile which inside calls
     * the constructor of Tiles to initialise the inherited variables imgURL for image path
     * and Tileposition for the position of the tile
     *
     * @param imgURL Url of the image
     * @param Tileposition the position of the tile (Between 1-30)
     */
    public RadioContestTile(String imgURL, int Tileposition) {
        super(imgURL, Tileposition);
    }
}
