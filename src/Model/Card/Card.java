package Model.Card;

import Model.Player.Player;

public abstract class Card {
    private final String text;
    private final int money;
    private final String imgURL;
    /**
     * <b>constructor</b>:Constructs a new Card
     * @param money the money that the card costs
     * @param text the text that the card containts
     * @param imgURL the URL of the card's image
     * <b>postcondition</b>:creates a new card with a money a displayed message and an image
     */
    public Card(int money,String text,String imgURL)
    {
        if(money<0) throw new IllegalArgumentException();
        this.text=text;
        this.money=money;
        this.imgURL=imgURL;
    }

    /**
     * <b>Accessor:</b>:Returns the cards text
     * <p><b>Postcondition:</b> Returns the cards text</p>
     * @return the cards text
     */
    public String getText(){return text;}
    /**
     *  <b>Accessor</b>:Returns the cards money
     * <p><b>Postcondition:</b> Returns the cards money</p>
     * @return the cards money
     */
    public int getMoney(){return money;}
    /**
     * <b>Accessor:</b>Returns the image's path
     * <p><b>Postcondition:</b> Returns the image's path </p>
     * @return the image's path
     */
    public String getimgURL(){return imgURL;}
    /**
     * Card Action is a function that every other card class will inherit
     */
    public abstract void CardAction(Player p);
}
