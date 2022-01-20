package Model.Jackpot;

public class Jackpot {
    private int jackpotSize;
    /**
     * <b>constructor</b>:Constructs a new Jackpot instance
     * <b>postcondition</b>:initialises the jackpotSize  equal to zero
     */
    public Jackpot() {
        this.jackpotSize = 0;
    }

    /**
     * <b>transformer</b>:Adds euros to the jackpotSize
     * <b>Precondition</b>:Cash must have greater value than zero
     * <b>Postcondition</b>:the new jackpotSize is greater than the old jackpotSize
     *
     * @param cash
     */
    public void AddJackpot(int cash) {
        if (cash <= 0) {
            throw new IllegalArgumentException();
        }
        jackpotSize =jackpotSize + cash;
    }

    /**
     * <b>transformer</b>:if a player wins the jackpot takes the balance that
     * jackpotSize contains and the new jackpotSize equals 0
     *<b>Postcondition</b>:the new jackpotSize is 0
     * @return the jackpotSize
     */
    public int JackpotBalance() {
        int tmp = jackpotSize;
        jackpotSize = 0;
        return tmp;
    }

    /**
     * <b>Accessor</b>:Gets the jackpot Size
     *
     * @return the size of the jackpot
     */
    public int getjackpotSize() {
        return jackpotSize;
    }

    /**
     * To string function to print jackpotSize on board
     * @return jackpotSize
     */
    public String toString() {
        return jackpotSize + "";
    }
}
