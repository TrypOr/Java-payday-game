package View;

import javax.swing.*;

/**
 * Dialog that appers when game has finished, to give players option to rematch or exit
 */
public class GamePhasePopUp {
    int choice;
    int temp;
    ImageIcon imageicon;
    /**
     * <b>constructor</b>: Constructs a new GamePhasePopUp <b/>
     */
    public GamePhasePopUp(Object ch1, Object ch2, String message, String Name, String o) {
        JFrame dialog = new JFrame();
        Object options[] = {ch1, ch2};
        imageicon = GraphicUI.ImageScale(o, 170, 100);
        temp=JOptionPane.showOptionDialog(dialog, message, Name, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                imageicon, options, options[0]);
        switch (temp) {
            case JOptionPane.YES_OPTION:
                choice = 1;
                break;
            case JOptionPane.NO_OPTION:
                choice = 2;
                break;
            default:
                choice = 0;
                break;
        }
    }
    /**
     * <b>Accessor<b> Returns the choice of the player
     * @return the choice of the player
     */
    public int getChoice() {
        return choice;
    }
}
