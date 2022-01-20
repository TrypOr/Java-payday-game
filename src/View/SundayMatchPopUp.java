package View;

import javax.swing.*;
/**
 * Dialog that appears when sunday match tile is used
 */
public class SundayMatchPopUp {
    int choice;
    ImageIcon imageicon;
    /**
     * <b>constructor</b>: Constructs a new GamePhasePopUp <b/>
     */
    public SundayMatchPopUp() {
        imageicon=GraphicUI.ImageScale("src/resources/images/Barcelona_Real.jpg",170,100);
        JFrame match=new JFrame();
        Object options[]={"Νίκη Μπαρτσελόνα","Ισοπαλία","Νίκη Ρεάλ","Δεν θέλω να κάνω πρόβλεψη"};
        choice=JOptionPane.showOptionDialog(match,"Στοιχημάτισε 500 Ευρώ για τον αγώνα Μπαρτσελόνα-Ρεάλ","Ποδοσφαιρικός Αγώνας Κυριακής", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, imageicon, options, options[0]);
    }
    public SundayMatchPopUp(boolean BetWon){
        imageicon=GraphicUI.ImageScale("src/resources/images/Barcelona_Real.jpg",170,100);
        JFrame match=new JFrame();
        if(BetWon)
        {
            Object options[]={"Κέρδισες 1000 Ευρώ"};
            choice=JOptionPane.showOptionDialog(match,"Σωστή Πρόβλεψη","Ποδοσφαιρικός Αγώνας Κυριακής", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, imageicon, options, options[0]);
        }else
        {
            Object options[]={"Δυστυχώς έχασες"};
            choice=JOptionPane.showOptionDialog(match,"Λάθος Πρόβλεψη","Ποδοσφαιρικός Αγώνας Κυριακής", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, imageicon, options, options[0]);
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
