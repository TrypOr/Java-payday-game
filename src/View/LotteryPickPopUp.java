package View;

import Model.Player.Player;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Dialog that appears when Lottery tiles is used
 */
public class LotteryPickPopUp {
    String choice;
    ImageIcon imageicon;
    /**
     * <b>constructor</b>: Constructs a new GamePhasePopUp <b/>
     */
    public LotteryPickPopUp(Player p, ArrayList number) {
        Object[] options = number.toArray();
        imageicon = GraphicUI.ImageScale("src/resources/images/lottery.jpg", 120, 100);
        JFrame frame = new JFrame();
        choice = (String) JOptionPane.showInputDialog(frame, "Choose number you wish to bet on",
                p.getName() + "Choice", JOptionPane.PLAIN_MESSAGE, imageicon, options, "1000");
    }
    /**
     * <b>Accessor<b> Returns the choice of the player
     * @return the choice of the player
     */
    public String getChoice() {
        int random=1+(int) (Math.random()*6);
        if(choice == null){
            return random+"";
        }else{
            return choice;
        }

    }
}
