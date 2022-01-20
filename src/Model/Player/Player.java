package Model.Player;

import Model.Card.DealCard;
import Model.Dice.Dice;

import java.util.Collections;
import java.util.Stack;

/**
 * This class represents the Players of the game
 * I chose not make player class as abstract
 * @version 1.0
 * @author Csd4235
 */
public class Player {
    private boolean turn;
    private String name;
    private boolean hasPlayed,hasFinished;
    private int money,loan,bills;
    private int position;
    private int AvailableMonths;
    private Stack<DealCard> pDealCards;
    private  Player Opponent;
    private Dice pDice;

    /**
     * <b>constructor</b>: Constructs a new Player with the given
     * parameter name<br />
     * <b>postcondition</b>: Creates and initializes a player with the given
     * name.Also initializes some variables money loan bills
     * has played and his position
     * @param name is the name of the player.
     */
    public Player(String name)
    {
        this.name = name;
        hasPlayed=false;
        money=3500;
        loan=0;
        bills=0;
        hasFinished=false;
        position=0;
        pDice=new Dice();
        pDealCards=new Stack<>();
    }
    /**
     * <b>Accessor<b>Returns the dice of the player
     * @return the dice of the player
     */
    public Dice getDice() {
        return pDice;
    }
    /**
     * <b>accessor(selector)</b>:Returns the money of the player <br />
     *
     * <p><b>Postcondition:</b> returns the money of the player </p>
     *
     * @return the  money of the player
     */
    public int getMoney() {
        return money;
    }
    /**
     * <b>transformer(mutative)</b>: sets the money of the player to money <br />
     * <p><b>Postcondition:</b> the money of this player is changed to money</p>
     *
     * @param newMoney the new money of the player
     *
     */
    public void setMoney(int newMoney) {
        money = money+newMoney;
    }
    /**
     * <b>accessor(selector)</b>:Returns the loan of the player <br />
     *
     * <p><b>Postcondition:</b> returns the loan of the player </p>
     *
     * @return the  loan of the player
     */
    public int getLoan() {
        return loan;
    }
    /**
     * <b>transformer(mutative)</b>: sets the loan of the player to loan <br />
     * <p><b>Postcondition:</b> the loan of this player is changed to loan</p>
     *
     * @param loanamount the new loan of the player
     *
     */
    public void setLoan(int loanamount) {
        loan = loanamount+loan;
    }
    /**
     * <b>accessor(selector)</b>:Returns the bills of the player <br />
     *
     * <p><b>Postcondition:</b> returns the bills of the player </p>
     *
     * @return the  bills of the player
     */
    public int getBills() {
        return bills;
    }

    /**
     * <b>transformer(mutative)</b>: sets the bills of the player to bills <br />
     * <p><b>Postcondition:</b> the bills of this player is changed to bills</p>
     *
     * @param newBills the new bills of the player
     *
     */
    public void setBills(int newBills) {this.bills = bills+newBills;
    }
    /**
     * <b>accessor(selector)</b>:Returns the bills of the player <br />
     *
     * <p><b>Postcondition:</b> Returns the bills of the player </p>
     *
     * @return the  position of the player
     */
    public int getPosition() {
        return position;
    }
    /**
     * <b>transformer(mutative)</b>: sets the position of the player to position <br />
     * <p><b>Postcondition:</b> the position of this player is changed to position</p>
     *
     * @param temp the new position of the player
     *
     */
    public void setPosition(int temp) {
        if (temp + position > 31) {
            position = 31;
        } else {
            position = temp + position;
        }
    }
    /**
     * <b>accessor(selector)</b>:Returns the AvailableMonths <br />
     *
     * <p><b>Postcondition:</b> Returns the AvailableMonths</p>
     *
     * @return the AvailableMonths
     */
    public int getAvailableMonths() {
        return AvailableMonths;
    }
    /**
     * <b>transformer(mutative)</b>: sets the availableMonths of the player to availableMonths <br />
     * <p><b>Postcondition:</b> the availableMonths of this player is changed to availableMonths</p>
     *
     * @param availableMonths the availableMonths
     *
     */
    public void setAvailableMonths(int availableMonths) {
        AvailableMonths = availableMonths;
    }

    /**
     * <b>Observer:<b>Checks whether player deck is empty
     * @return true if empty deck else false
     */
    public boolean isEmptyCards() {
        return pDealCards.isEmpty();
    }

    /**
     * <b>accessor(selector)</b>:Returns the name of the player <br />
     *
     * <p><b>Postcondition:</b> returns the name of the player </p>
     *
     * @return the the name of the player
     */
    public String getName()
    {

        return name;
    }


    /**
     * <b>transformer(mutative)</b>: if a player plays for the first time it sets the variable hasplayed to true
     * <p><b>Postcondition:</b>  sets the variable hasplayed to true</p>
     */

    public void set_HasPlayed(boolean action){
        this.hasPlayed=action;
    }
    /**
     * <b>transformer(mutative)</b>: if a player plays for the last time it sets the variable hasfinished to true
     * <p><b>Postcondition:</b>  sets the variable hasfinished to true</p>
     */
    public void set_has_finished(){
        this.hasFinished=true;
    }
    /**
     * <b>Observer</b>:Returns if a player has played at least one time <br />
     *
     * <p><b>Postcondition:</b> Returns if a player has played at least one time </p>
     *
     * @return true if a player has played at least one time false otherwise
     */
    public boolean get_HasPlayed(){
        return this.hasPlayed;
    }
    /**
     * <b>Observer</b>:Returns if a player has ended the turn<br />
     *
     * <p><b>Postcondition:</b> Returns if a player hashas ended the turn</p>
     *
     * @return true if a player has finished the turn , false otherwise
     */
    public boolean get_has_finished(){
        return this.hasFinished;
    }

    /**
     *<b>Transformer:</b>Adds a new deal card to players stack
     * <b> Postcondition:</b>Add a new element to card stack
     * @param dCard the deal card you take
     */
    public void HoldDealCard(DealCard dCard) {
        this.pDealCards.add(dCard);
    }
    /**<b>Transformer:</b>removes a card from players stack
     * <b> Postcondition:</b>Pop a element from stack
     * @return the element
     */
    public DealCard SellDealCard() {
        return  pDealCards.pop();
    }
    /**
     * <b>Transformer<b> sets the opponent of the player
     * @param  opp the opponent
     */
    public void setOpponent(Player opp) {
        this.Opponent = opp;
    }
    /**
     * <b>accessor(selector)</b>:Returns the players opponent <br />
     *
     *
     * @return the players opponent
     */
    public Player getOpponent() {
        return this.Opponent;
    }
    /**
     * <b>transformer(mutative)</b>: Sets players turn to true or false
     * <p><b>Postcondition:</b>  sets the variable turn to true or false</p>
     */
    public void setTurn(boolean turn) {
        if (this.hasFinished) {
            this.turn = false;
        } else {
            this.turn = turn;
        }
    }
    /**
     * <b>Observer</b>:Returns a players turn<br />
     *
     * <p><b>Postcondition:</b> Returns a players turn>/p>
*/
    public boolean getTurn() {
        return turn;
    }
}
