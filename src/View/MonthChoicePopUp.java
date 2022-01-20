package View;

import javax.swing.*;
/**
 * Dialog that appears in the start of the game to give players the option to chose how many months of the game they
 * want to play
 */
public class MonthChoicePopUp {
    String choice;
    ImageIcon imageicon;
    /**
     * <b>constructor</b>: Constructs a new GamePhasePopUp <b/>
     */
    public MonthChoicePopUp() {
        imageicon = GraphicUI.ImageScale("src/resources/logo.png", 120, 100);
        JFrame frame = new JFrame();
        Object[] options = {"1", "2", "3"};
        choice = (String) JOptionPane.showInputDialog(frame, "How many months you wish to play", "Months Playing", JOptionPane.PLAIN_MESSAGE, imageicon, options, "1");
    }
    /**
     * <b>Accessor<b> Returns the choice of the player
     * @return the choice of the player
     */
    public String getChoice() {
        if (choice == null) {
            return "1";
        } else {
            return choice;
        }
    }
}
