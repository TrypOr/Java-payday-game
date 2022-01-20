package Model.Tiles;

import Model.Player.Player;

public class PayDayTile extends Tiles{
    /**
     * <b>constructor</b>::Constructs a new PayDayTile Tile which inside calls
     * the constructor of Tiles to initialise the inherited variables imgURL for image path
     * and Tileposition for the position of the tile
     *
     * @param imgURL Url of the image
     */
    public PayDayTile(String imgURL) {
        super(imgURL, 31);
    }
    /**
     * <b>transformer</b>: here are the actions of this position take place
     *postcondition:do all the neccessary actions of the payday
     * @param p the player on the tile
     * @param LoanChoice true if player wants to pay loan else flase
     */
    public void TileAction(Player p, int LoanChoice){
        p.setAvailableMonths(p.getAvailableMonths()-1);
        p.setMoney(2500);
        /**
         * TAX
         */
        int tax=p.getLoan()/10;
        if(tax>p.getMoney())
        {
            p.setLoan(tax-p.getMoney());
            p.setMoney(-p.getMoney());
        }else p.setMoney(-tax);
        //PAY BILLS

        if(p.getBills()>p.getMoney())
        {
            p.setLoan(p.getBills()-p.getMoney());
            p.setMoney(-p.getMoney());
            p.setBills(-p.getBills());
        }else
        {
            p.setMoney(-p.getBills());
            p.setBills(-p.getBills());
        }

        //Loan Payments
        if(LoanChoice==0){
            if(p.getLoan()>p.getMoney())
            {
                p.setLoan(-p.getMoney());
                p.setMoney(-p.getMoney());

            }else
            {
                p.setMoney(-p.getLoan());
                p.setLoan(-p.getLoan());
            }
        }else
        {
            if(p.getLoan()/2>p.getMoney())
            {
                p.setLoan(-p.getMoney()/2);
                p.setMoney(-p.getMoney()/2);
            }else
            {
                p.setMoney(-p.getLoan()/2);
                p.setLoan(-p.getLoan()/2);
            }
        }

        if(p.getAvailableMonths()<=0)
        {
            p.set_has_finished();
        }
        if(!p.get_has_finished()) p.setPosition(-31);
    }
    }


