package Model.Tiles;

import Model.Jackpot.Jackpot;
import Model.Player.Player;

public class FamilyCasinoNightTile extends Tiles{

    /**
 * <b>constructor</b>::Constructs a new FamilyCasinoNightTile Tile which inside calls
 * the constructor of Tiles to initialise the inherited variables imgURL for image path
 * and Tileposition for the position of the tile
 *
 * @param imgURL Url of the image
 * @param Tileposition the position of the tile (Between 1-30)
 */
    public FamilyCasinoNightTile(String imgURL, int Tileposition) {
        super(imgURL, Tileposition);
    }
    /**
     * <b>transformer</b>: The player on the tile receives the money of the jackpot depending on the dice
     * @param p the player on the tile
     * @param jackpotSize the jackpot size
     * @return true for now (true if won else false)
     */
    public boolean TileAction(Player p, Jackpot jackpotSize) {
        int numb = p.getDice().getRollNumber();
        if (numb % 2 == 0) {
            p.setMoney(500);
            return true;
        } else {
            if (p.getMoney() < 500) { //Gets a loan if players doesnt have enough money
                p.setLoan(500 - p.getMoney());
                p.setMoney(-p.getMoney());
            } else {
                p.setMoney(-500);
            }
            jackpotSize.AddJackpot(500);
        }
        return false;
    }
}

