package Model.Card;

import Model.Player.Player;
import Model.Tiles.BuyerTile;
import Model.Tiles.DealTile;
import Model.Tiles.Tiles;

public class MoveTo  extends MessageCard{
    /**
     * <b>constructor</b>:Constructs a new MoveTo Card
     *
     * @param text   the text that the card containts
     * @param imgURL the URL of the card's image
     */
    public MoveTo(String text, String imgURL) {
        super(0,text, imgURL);
    }


    /**
     *<b>Accessor:</b> Returns a number which is how many steps does to player have to make to go to a deal/buyer tile
     *<b>Postcondition:</b>Returns number of steps
     * @param p Player who gets card
     * @param table An array which contains all the positions of the board
     * @return the position that the player must go ( 1 for now)
     *
     */
    public int CardAction(Player p,Tiles table[]) {
        for (int i = p.getPosition(); i < table.length; i++) {
            if (table[i] instanceof BuyerTile || table[i] instanceof DealTile) {
                return i;
            }
        }
        return p.getPosition();

    }
}
