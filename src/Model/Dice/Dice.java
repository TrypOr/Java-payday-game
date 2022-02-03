package Model.Dice;
/**
 * This class represents the dice of the game
 * @version 1.0
 * @author Csd4235
 */
public class Dice {
    public int roll; //1-6
    private boolean hasrolled; //whether the player has rolled

    /**
     * <b>Constructor</b>Constructs dice
     *
     * <b>Postcondition</b>Creates a new Dice with 2 variables
     * one that shows the dice's roll
     * and the other that shows wheter the dice has been rolled
     */
    public Dice(){

        roll = 0;
        hasrolled=false;
    }
    /**
     * <b>Transformer:</b> sets the dice's roll
     * <b>Postcondition:</b> the dice's roll has been set
     * @return
     */
    public int setRoll() {
        int Diceroll=(int)(Math.random()*6)+1;
        hasrolled=true;
        roll=Diceroll;
        return Diceroll;
    }
    /**
     * <b>transformer</b>:
     * <b>precondition</b>:if the dice in a turn is rolled
     * hasrolled equals true else false
     *
     * @param rolled sets variable hasrolled to rolled
     */
    public void setRolled(boolean rolled) {
        hasrolled = rolled;
    }

    /**
     * <b>Observer</b>:Gains access to hasrolled
     *
     * @return value of hasrolled
     */
    public boolean getRolled() {
        return hasrolled;
    }
    /**
     * <b>Observer</b>:Gains access to roll
     *
     * @return value of roll
     */
public int getRollNumber(){
        return roll;
}
}
