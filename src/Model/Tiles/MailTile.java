package Model.Tiles;

import Model.Player.Player;

public class MailTile extends Tiles{
    boolean isOneCard;
    /**
     * <b>constructor</b>::Constructs a new MailTile Tile which inside calls
     * the constructor of Tiles to initialise the inherited variables imgURL for image path
     * and Tileposition for the position of the tile
     *
     * @param imgURL Url of the image
     * @param Tileposition the position of the tile (Between 1-30)
     */
    public MailTile(String imgURL,int Tileposition,boolean isOneCard) {
        super(imgURL, Tileposition);
        this.isOneCard=isOneCard;
    }
    public boolean isOneCard(){return isOneCard;}

}
