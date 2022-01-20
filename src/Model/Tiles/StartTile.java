package Model.Tiles;

public class StartTile extends Tiles{
    /**
     * <b>constructor</b>::Constructs a new StartTile Tile which inside calls
     * the constructor of Tiles to initialise the inherited variables imgURL for image path
     * and Tileposition for the position of the tile
     *
     * @param imgURL Url of the image
     */
    public StartTile(String imgURL) {
        super(imgURL, 0);
    }
}
