package View;

import javax.swing.*;
import javax.swing.ImageIcon;
/**
 * Dialog that appears when players choses to get a loan
 */
public class GetLoanPopUp {
    int choice;
    ImageIcon imageicon;
    String loan;
    ClassLoader cldr = this.getClass().getClassLoader();
    /**
     * <b>constructor</b>: Constructs a new GamePhasePopUp <b/>
     */
    public GetLoanPopUp() {
        imageicon = GraphicUI.ImageScale("src/resources/images/loan.png", 120, 100);
        JFrame frame = new JFrame();
        Object[] options = {"1000", "2000", "3000", "4000", "5000","6000", "7000", "8000", "9000", "10000", "15000", "20000", "25000"};
        loan = (String) JOptionPane.showInputDialog(frame, "Choose the money you want", "Bank", JOptionPane.PLAIN_MESSAGE, imageicon, options, "1000");
    }
    /**
     * <b>Accessor<b> Returns the choice of the player
     * @return the choice of the player
     */
    public String getChoice() {
        if(loan == null){
            return "0";
        }else{
            return loan;
        }

    }

}
