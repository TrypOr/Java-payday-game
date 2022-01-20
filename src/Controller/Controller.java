package Controller;
import java.io.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import Model.Card.DealCard;
import Model.CardDecks.DealCardDeck;
import Model.CardDecks.MessageCardDeck;
import Model.CardDecks.RejectedCards;
import Model.Jackpot.Jackpot;
import Model.Player.Player;
import Model.Tiles.*;
import View.GraphicUI;
import Model.Card.*;
import View.MonthChoicePopUp;
import javafx.scene.media.MediaPlayer;

import javax.print.attribute.standard.Media;

public class Controller {
    public Player p1;
    public Player p2;
    public Tiles table[];
    public MessageCardDeck MessageDeck;
    public DealCardDeck DealDeck;
    public RejectedCards RejectedCards;
    public Jackpot JackpotSize;
    private ClassLoader cldr;
    public boolean GameStart;
    public int ScoreP1;
    public int ScoreP2;
    /**
     * <b>constructor</b>: Constructs a new Controller and sets the game as
     * eligible to start .<br />
     * <b>postcondition</b>: constructs a new Controller,with 2 players.So,is responsible for creating a new game and
     * initializing it.
     */
    public Controller() {
        cldr = this.getClass().getClassLoader();
        JackpotSize = new Jackpot();
        MessageDeck = new MessageCardDeck();
        DealDeck = new DealCardDeck();
        RejectedCards = new RejectedCards();
        p1=new Player("P1");
        p2=new Player("P2");
        p1.setOpponent(p2);
        p2.setOpponent(p1);
    }
    /**
     * Function that initializes the game bu calling all its functions
     */
    public void initialize_game(){
        MonthChoicePopUp monthchoice=new MonthChoicePopUp();
        initialize_CardDecks();
        initialize_PlayMonths(Integer.parseInt(monthchoice.getChoice()));
    }

    /**
     * Function that initializes the board bu setting all tiles
     */
    public void initialize_board(){
        table = new Tiles[32];
        table[0] = new StartTile("resources/images/start.png");
        table[31] = new PayDayTile("resources/images/pay.png");

        int i = 1;
        while (i < 5) {
            table[i] = new MailTile("resources/images/mc1.png", 0, true);
            i++;
        }
        while (i < 9) {
            table[i] = new MailTile("resources/images/mc2.png", 0, false);
            i++;
        }
        while (i < 14) {
            table[i] = new DealTile("resources/images/deal.png", 0);
            i++;
        }
        while (i < 16) {
            table[i] = new SweepstakesTile("resources/images/sweep.png", 0);
            i++;
        }
        while (i < 19) {
            table[i] = new LotteryTile("resources/images/lottery.png", 0);
            i++;
        }
        while (i < 21) {
            table[i] = new RadioContestTile("resources/images/radio.png", 0);
            i++;
        }
        while (i < 27) {
            table[i] = new BuyerTile("resources/images/buyer.png", 0);
            i++;
        }
        while (i < 29) {
            table[i] = new FamilyCasinoNightTile("resources/images/casino.png", 0);
            i++;
        }
        while (i < 31) {
            table[i] = new YardSaleTile("resources/images/yard.png", 0);
            i++;
        }
        randomize_board(table);
    }
    /**
     * Function that randomises the board bu putting tiles at random places except start tile and payday tile
     */
    public void randomize_board(Tiles[] tiles){
        int n = tiles.length - 1;
        for (int i = 1; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            Tiles tmp = tiles[i];
            tiles[i] = tiles[r];
            tiles[r] = tmp;
        }
        tiles[0].setName("Start");
        tiles[0].setTileposition(0);
        tiles[31].setName("Wednesday");
        tiles[31].setTileposition(31);
        for (int i = 1; i < n; i++) {
            tiles[i].setTileposition(i);
            switch (i % 7) {
                case 0:
                    tiles[i].setName("Sunday");
                    break;
                case 1:
                    tiles[i].setName("Monday");
                    break;
                case 2:
                    tiles[i].setName("Tuesday");
                    break;
                case 3:
                    tiles[i].setName("Wednesday");
                    break;
                case 4:
                    tiles[i].setName("Thursday");
                    break;
                case 5:
                    tiles[i].setName("Friday");
                    break;
                case 6:
                    tiles[i].setName("Saturday");
                    break;
                default:
                    break;
            }
        }
    }
    /**
     * Function that randomises the cards bu putting them at their decks
     */
    public void initialize_CardDecks(){
        String DealCards[][] = readFile("resources/dealCards.csv", "Deal");
        String MessageCards[][] = readFile("resources/mailCards.csv", "Mail");

        for (int i = 0; i < 20; i++) {
            int buyValue = Integer.parseInt(DealCards[i][3]);
            int sellValue = Integer.parseInt(DealCards[i][4]);
            String mess = DealCards[i][2];
            String img = DealCards[i][5];
            DealDeck.AddCard_to_Deck(new DealCard(buyValue, img, mess, sellValue));
        }
        DealDeck.DeckShuffle();
        for(int i=0;i<48;i++)
        {
            if(MessageCards[i][1].equals("Advertisment")) MessageDeck.AddCard_to_Deck(new Advertisment(MessageCards[i][2],MessageCards[i][5]));
            else if(MessageCards[i][1].equals("Bill")) MessageDeck.AddCard_to_Deck(new Bill(Integer.parseInt(MessageCards[i][4]),MessageCards[i][2],MessageCards[i][5]));
            else if(MessageCards[i][1].equals("Charity")) MessageDeck.AddCard_to_Deck(new Charity(Integer.parseInt(MessageCards[i][4]),MessageCards[i][2],MessageCards[i][5]));
            else if(MessageCards[i][1].equals("PayTheNeighbor")) MessageDeck.AddCard_to_Deck(new PayTheNeighbor(Integer.parseInt(MessageCards[i][4]),MessageCards[i][2],MessageCards[i][5]));
            else if(MessageCards[i][1].equals("TakeFromTheNeighbor")) MessageDeck.AddCard_to_Deck(new TakeFromTheNeighbor(Integer.parseInt(MessageCards[i][4]),MessageCards[i][2],MessageCards[i][5]));
            else if(MessageCards[i][1].equals("MoveTo")) MessageDeck.AddCard_to_Deck(new MoveTo(MessageCards[i][2],MessageCards[i][5]));
        }
        MessageDeck.DeckShuffle();
    }

    public String[][] readFile(String path, String type) {
        String[][] MessageCards = new String[48][4];
        String[][] DealCards = new String[20][8];

        BufferedReader br = null;
        String sCurrentLine;
        try {
            String fullPath = cldr.getResource(path).getPath();
            br = new BufferedReader(new FileReader(fullPath));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        int count = 0;
        int splitCount = 0;
        HashMap<Integer, String> domainsMap = new HashMap<>();
        try {
            br.readLine();
            while ((sCurrentLine = br.readLine()) != null) {
                if (type.equals("Mail")) {
                    MessageCards[count++] = sCurrentLine.split(",");
                } else {

                    DealCards[count++] = sCurrentLine.split(",");
                }
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (type.equals("Mail")) {
            return MessageCards;
        } else {
            return DealCards;
        }
    }
    /**
     * Function that set how many months the players want to play ,according to their votes
     */
    public void initialize_PlayMonths(int months){
        p1.setAvailableMonths(months);
        p2.setAvailableMonths(months);
    }
    /**
     * Function that chooses which player goes first according to their rolls
     */
    public void initialize_GoesFirst(int rollp1,int rollp2){
        if(rollp1>rollp2) p1.setTurn(true);
        else p2.setTurn(true);
    }
    /**
     * Function that finishes the game if both players have reached the end of the last montrh
     */
    public boolean GameOver(){
        return p1.get_has_finished()
                &&p2.get_has_finished();
    }
    /**
     * Function that calculates the winner according to their money ,loans and bills
     * @return
     */
    public String GameWinner(){
        String s;
        ScoreP1=p1.getMoney()-p1.getBills()-p1.getLoan();
        ScoreP2=p2.getMoney()-p2.getBills()-p2.getLoan();
        if(ScoreP1>ScoreP2) {
            s = "Ο παίκτης Α κέρδισε!";
        }
        else if(ScoreP2>ScoreP1) {
            s="O παίκτης Β κέρδισε!";
        }
        else s="Ισοπαλία!";
        return s;
    }

    /**
     * <b>Transformer<b>Makes player choose if he wants to bet on a football match
     * Player can win ,lose or dont bet
     * Adds or removes balance from player
     * @return
     */
    public boolean CreateSundayMatch(Player p, int choice){
        boolean BetWon=false;
        if(choice!=3&&p.getMoney()<500)
        {
            p.setLoan(500);
            p.setMoney(500);
        }

        switch (choice) {
            case 0:
                if(p.getDice().getRollNumber()==1||p.getDice().getRollNumber()==2)
                {
                    p.setMoney(500);
                    BetWon=true;
                }else {
                    p.setMoney(-500);
                    BetWon=false;
                }   break;
            case 1:
                if(p.getDice().getRollNumber()==3||p.getDice().getRollNumber()==4) {
                    p.setMoney(500);
                    BetWon= true;
                }
                else {
                    p.setMoney(-500);
                    BetWon= false;
                }   break;
            case 2:
                if(p.getDice().getRollNumber()==5||p.getDice().getRollNumber()==6)
                {
                    p.setMoney(500);
                    BetWon= true;
                }
                else{
                    p.setMoney(-500);
                    BetWon= false;
                }   break;
            default:
                break;
        }
        return BetWon;
    }
    /**
     * <b>Postcondition:</b>returns a string describing the state of the game
     *
     * @return a string that is displayed in infobox that contains information
     * everytime an action is made
     */
    public String[] Infobox() {

        String arrayInfos[]=new String [2];
        if(p1.getAvailableMonths()>p2.getAvailableMonths())  arrayInfos[0]=p1.getAvailableMonths() + " Months remaining to play";
        else  arrayInfos[0]=p2.getAvailableMonths() + " Months remaining to play";

        if(p1.getTurn()) arrayInfos[1]="Turn: A has turn";
        else if(p2.getTurn())arrayInfos[1]="Turn: B has turn";

        return arrayInfos;
    }
    /**
     * <b>Transformer<b>Makes player choose if he wants to bet on crypto
     * Player can win ,lose or dont bet
     * Adds or removes or keeps balance from player
     * @return
     */
    public boolean CreateThursdayCrypto(Player p, int choice){
        boolean CryptoWin=false;
        switch (choice) {
            case 0:
                if(p.getMoney()<300)
                {
                    p.setLoan(300);
                    p.setMoney(300);
                }
            default:
                break;
        }
        return CryptoWin;
    }
    /**
     * <b>Transformer:</b>Adds jackpotmoney to player
     * <b>Postcondition:</b> the jackpotSize is  added to winner
     * @param p takes the jackpotSize
     */
    public void WinJackpot(Player p) {
        p.setMoney(this.JackpotSize.JackpotBalance());
    }
    public static void main(String[] args) {

        GraphicUI game=new GraphicUI();
        game.setVisible(true);

    }

    public void CardsFinish(Player p) {
        if(p.get_has_finished())
        {
            while(!p.isEmptyCards()){
                this.RejectedCards.RejectCard(p.SellDealCard());
            }
        }
    }

}


