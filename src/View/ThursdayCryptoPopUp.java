package View;

import javax.swing.*;
/**
 * Dialog that appears when thursday crypto tile is used
 */
public class ThursdayCryptoPopUp {
    int choice;
    ImageIcon imageicon;
    /**
     * <b>constructor</b>: Constructs a new GamePhasePopUp <b/>
     */
    public ThursdayCryptoPopUp() {
        imageicon=GraphicUI.ImageScale("src/resources/images/crypto.jpg",170,100);
        JFrame match=new JFrame();
        Object options[]={"Πονταρε σε κρυπτονομισμα","Παραβλεψε το Πονταρισμα"};
        choice=JOptionPane.showOptionDialog(match,"Πονταρισμα σε κρυπτονομισμα",
                "Crypto Thursday", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, imageicon, options, options[0]);
    }

    public ThursdayCryptoPopUp(int result) {
        imageicon=GraphicUI.ImageScale("src/resources/images/crypto.jpg",170,100);
        JFrame match=new JFrame();
        if(result==0)
        {
            Object options[]={"Επιστροφη 300 ευρω"};
            choice=JOptionPane.showOptionDialog(match,"Σταθεροποίηση αξίας","Crypto Thursday", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, imageicon, options, options[0]);
        }else if(result==1)
        {
            Object options[]={"Επιστροφη 600 ευρω"};
            choice=JOptionPane.showOptionDialog(match," Aνοδος αξίας","Crypto Thursday", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, imageicon, options, options[0]);
        }else{
            Object options[]={"Εχασες"};
            choice=JOptionPane.showOptionDialog(match," Πτώση αξίας","Crypto Thursday", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, imageicon, options, options[0]);
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
