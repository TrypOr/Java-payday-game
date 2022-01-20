package View;

import javax.swing.*;
/**
 * Dialog that appears when it is time for the players to pay their loan
 */
public class LoanDayPopUp {
    int choice;
    ImageIcon imageicon;
    /**
     * <b>constructor</b>: Constructs a new GamePhasePopUp <b/>
     */
    public LoanDayPopUp() {
        imageicon = GraphicUI.ImageScale("src/resources/images/LoanDay.jpg", 170, 100);
        JFrame dialog = new JFrame();
        Object options[] = {"YES", "Pay part of loan", "NO"};
        choice = JOptionPane.showOptionDialog(dialog, "Do you want to repay dept?", "Banker", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, imageicon, options, options[0]);
    }
    /**
     * <b>Accessor<b> Returns the choice of the player
     * @return the choice of the player
     */
    public int getChoice() {
        return choice;
    }
}
