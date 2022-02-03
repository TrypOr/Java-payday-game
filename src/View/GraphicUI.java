package View;

import Controller.Controller;
import Model.Card.*;
import Model.Dice.Dice;
import Model.Player.Player;
import Model.Tiles.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

public class GraphicUI extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final int width = (int) Math.round(screenSize.getWidth()) - 300;
    private final int height = (int) Math.round(screenSize.getHeight()) - 300;
    private JLayeredPaneExtension BasePanel;
    Controller game;
    private int counter = 0;
    private boolean isRadio = false;
    private boolean isLottery = false;
    private final ClassLoader cldr;
    private URL imgURL;
    private Image image;
    private final JButton DealCards;
    private final JButton MessageCards;
    private final JButton DealCardsA;
    private final JButton DealCardsB;
    private final JButton GetLoanP1;
    private final JButton GetLoanP2;
    private final JButton EndTurnP1;
    private final JButton EndTurnP2;
    private final JButton DiceP1;
    private final JButton DiceP2;
    private final JDesktopPane InfoBox;
    private final JDesktopPane table;
    private final JDesktopPane P1;
    private final JDesktopPane P2;
    private final JDesktopPane jackPotPanel;
    private final JLabel PayDayImage;
    private final JLabel NameP1;
    private final JLabel NameP2;
    private final JLabel jackPotLabel;
    private final JTextField MoneyP1;
    private final JTextField MoneyP2;
    private final JTextField LoanP1;
    private final JTextField LoanP2;
    private final JTextField BillsP1;
    private final JTextField BillsP2;
    private final JTextField jackPotText;
    private final JTextField info;
    private final JTextField turn;
    private final JTextField monthsleft;
    private final JTextField command;
    private final JDesktopPane[] Tiles;
    int LotterychoiceP1, LotterychoiceP2;
    JLayeredPaneExtension[] pawn_position;
    private JMenu MenuFile;
    ImageIcon imgICN;

    /**
     * <b>constructor</b>: Constructs the graphic UI creating all the buttons,panels etc
     * and initializes some of them
     * b>postconditions</b>: Creates a new Window and initializes some buttons and panels
     * * starting a new game.
     */
    public GraphicUI() {
        game = new Controller();
        cldr = this.getClass().getClassLoader();
        P1 = new JDesktopPane();
        P2 = new JDesktopPane();
        table = new JDesktopPane();
        Tiles = new JDesktopPane[32];
        pawn_position = new JLayeredPaneExtension[32];
        jackPotPanel = new JDesktopPane();
        jackPotText = new JTextField();
        jackPotLabel = new JLabel();

        InfoBox = new JDesktopPane();

        MoneyP1 = new JTextField();
        MoneyP2 = new JTextField();
        LoanP1 = new JTextField();
        LoanP2 = new JTextField();
        BillsP1 = new JTextField();
        BillsP2 = new JTextField();
        PayDayImage = new JLabel();
        NameP1 = new JLabel("Player 1");
        NameP1.setFont(new Font(null, Font.BOLD, 14));
        NameP2 = new JLabel("Player 2");
        NameP2.setFont(new Font(null, Font.BOLD, 14));

        info = new JTextField("Info Box");
        info.setFont(new Font(null, Font.BOLD, 12));
        turn = new JTextField();
        monthsleft = new JTextField();
        command = new JTextField();

        DealCards = new JButton();
        MessageCards = new JButton();
        GetLoanP1 = new JButton();
        EndTurnP1 = new JButton();
        GetLoanP2 = new JButton();
        EndTurnP2 = new JButton();
        DealCardsA = new JButton();
        DealCardsB = new JButton();
        DiceP1 = new JButton();
        DiceP2 = new JButton();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0, 102, 0));
        this.setResizable(false);
        this.setTitle("PayDay");
        imgURL = cldr.getResource("resources/images/logo.png");
        this.setIconImage(new ImageIcon(imgURL).getImage());
        this.setVisible(true);
        init_Components();

    }

    /**
     * <b>transformer(mutative)</b>:initializes some buttons and labels <br />
     * <p><b>Postcondition:</b> initializes some buttons and labels </p>
     */
    private void init_Components() {
        DealCards.setSize(width * (2 / 16) - 40, height * 1 / 7);
        imgURL = cldr.getResource("resources/images/dealCard.png");
        image = new ImageIcon(imgURL).getImage();
        image = image.getScaledInstance(width * (2 / 16) - 20, height * 1 / 7 - 15, Image.SCALE_SMOOTH);
        DealCards.setIcon(new ImageIcon(image));
        DealCards.addActionListener(new CardListener());

        MessageCards.setSize(width * (2 / 16) - 50, height * 1 / 7);
        imgURL = cldr.getResource("resources/images/mailCard.png");
        image = new ImageIcon(imgURL).getImage();
        image = image.getScaledInstance(width * (2 / 16) - 20, height * 1 / 7 - 15, Image.SCALE_SMOOTH);
        MessageCards.setIcon(new ImageIcon(image));
        MessageCards.addActionListener(new CardListener());

        DealCards.setEnabled(false);
        MessageCards.setEnabled(false);

        imgURL = cldr.getResource("resources/images/bg_green.png");
        image = new ImageIcon(imgURL).getImage();
        BasePanel = new JLayeredPaneExtension(image.getScaledInstance(width, height, Image.SCALE_DEFAULT));

        this.setPreferredSize(new Dimension(width, height));
        this.add(BasePanel);

        PayDayImage.setIcon(ImageScale("src/resources/images/logo.png", width * 6 / 8, height * 1 / 5));
        PayDayImage.setBounds(0, 0, width * 6 / 8, height * 1 / 5);
        BasePanel.add(PayDayImage);
        P1.setSize(width * 2 / 8 - 50, height * 2 / 7);
        P1.setBounds((width * 6 / 8) + 30, 10, width * 2 / 8 - 50, height * 2 / 7);
        P1.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));

        P2.setSize(width * 2 / 8 - 50, height * 2 / 7);
        P2.setBounds((width * 6 / 8) + 30, height * 5 / 7 - 40, width * 2 / 8 - 50, height * 2 / 7 - 20);
        P2.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));

        MessageCards.setBounds((width * 6 / 8) + 30, height * 1 / 2 + 20, width * 2 / 16 - 40, height * 1 / 10);
        DealCards.setBounds(width * 7 / 8 + 20, height * 1 / 2 + 20, width * 2 / 16 - 40, height * 1 / 10);

        BasePanel.add(DealCards);
        BasePanel.add(MessageCards);
        PlayerPanel();
        BasePanel.add(P1);
        BasePanel.add(P2);

        initialize_Infobox();
        BasePanel.add(InfoBox);


        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        CreateMenu();
        menuBar.add(MenuFile);


        pack();
        StartAll();
    }

    /**
     * <b>Accessor:</b>Shows the Mail card
     *
     * @param MailCard the card we want to show
     */
    public void showMailCard(Card MailCard) {
        String Type = "";
        String CardText = "";
        URL imageURL2;
        imageURL2 = cldr.getResource("resources/images/" + MailCard.getimgURL());
        Image image = null;
        image = new ImageIcon(imageURL2).getImage();
        image = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);

        if (MailCard instanceof PayTheNeighbor) {
            Type = "Πλήρωσε το γείτονα";
            CardText = "Πλήρωσε " + MailCard.getMoney() + " Ευρώ στον αντίπαλο";
        } else if (MailCard instanceof Advertisment) {
            Type = "Διαφήμιση";
            CardText = "Εντάξει";
        } else if (MailCard instanceof MoveTo) {
            Type = "Μετακίνηση σε θέση Συμφωνίας/Αγοραστή";
            CardText = "Εντάξει";
        } else if (MailCard instanceof Bill) {
            Type = "Εξόφληση λογαριασμού";
            CardText = "Κράτα το λογαριασμό";
        } else if (MailCard instanceof Charity) {
            Type = "Φιλανθρωπία";
            CardText = "Πλήρωσε " + MailCard.getMoney() + " Ευρώ στο Jackpot";
        } else if (MailCard instanceof TakeFromTheNeighbor) {
            Type = "Πάρε λεφτά από τον γείτονα";
            CardText = "Πάρε " + MailCard.getMoney() + " Ευρώ από τον αντίπαλο";
        }
        Object[] options = {CardText};
        int n = JOptionPane.showOptionDialog(this,
                MailCard.getText(),
                Type,
                JOptionPane.OK_OPTION,
                0,
                new ImageIcon(image),
                options,
                options[0]);
    }

    /**
     * <b>transformer(mutative)</b>:doing some actions after a card button has been pushed<br />
     * <p><b>Postcondition:</b> doing some actions after a card button has been pushed</p>
     */
    private class CardListener implements ActionListener {
        Player PlayerCards;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (game.p1.getTurn()) {
                PlayerCards = game.p1;
            } else if (game.p2.getTurn()) {
                PlayerCards = game.p2;
            } else {

            }
            if (e.getSource() == DealCards && game.table[PlayerCards.getPosition()] instanceof DealTile) {
                if (PlayerCards.get_HasPlayed()) {
                    if (game.DealDeck.isEmpty()) {
                        game.RejectedCards.rejectedCard_return(game.MessageDeck, game.DealDeck);
                    }
                    DealCard myCard = game.DealDeck.getCard();
                    if (showDealCard(myCard, "show") == 0) {
                        if (myCard.getMoney() > PlayerCards.getMoney()) {
                            InfoboxInformation("Must get loan to buy this Card");
                            GetLoanPopUp loan = new GetLoanPopUp();

                            if (myCard.getMoney() <= PlayerCards.getMoney() + Integer.parseInt(loan.getChoice())) {

                                PlayerCards.setLoan(Integer.parseInt(loan.getChoice()));
                                PlayerCards.setMoney(Integer.parseInt(loan.getChoice()));
                                myCard.CardAction(PlayerCards);
                                InfoboxInformation("Player " + PlayerCards.getName() + " bought the card ");
                                PlayerInformation();
                            } else {
                                InfoboxInformation("Not enough money to buy this card");
                                game.RejectedCards.RejectCard(myCard);
                            }
                        } else {
                            myCard.CardAction(PlayerCards);
                            InfoboxInformation("Player " + PlayerCards.getName() + " bought the card ");
                            PlayerInformation();
                        }
                    } else {
                        game.RejectedCards.RejectCard(myCard);
                    }
                    PlayerCards.set_HasPlayed(false);
                } else {

                }
            } else if (e.getSource() == MessageCards && game.table[PlayerCards.getPosition()] instanceof MailTile) {
                if (game.MessageDeck.isEmpty()) {
                    game.RejectedCards.rejectedCard_return(game.MessageDeck, game.DealDeck);//if stack is empty
                }
                MailTile pos = (MailTile) game.table[PlayerCards.getPosition()];
                if (PlayerCards.get_HasPlayed()) {
                    MessageCard myCard = game.MessageDeck.getCard();
                    showMailCard(myCard);
                    game.RejectedCards.RejectCard(myCard);

                    MessageCardAction(PlayerCards, myCard);
                    if (pos.isOneCard() && !(myCard instanceof MoveTo)) {

                        PlayerCards.set_HasPlayed(false);
                        InfoboxInformation("Card taken");
                    } else {

                        counter++;
                        if (counter >= 2 && !(myCard instanceof MoveTo)) {
                            PlayerCards.set_HasPlayed(false);
                            InfoboxInformation("Card taken");
                            counter = 0;
                        }
                    }
                }

            }
        }
    }

    /**
     * <b>transformer(mutative)</b>:initializes labels for the board <br />
     * <p><b>Postcondition:</b> initializes labels for the board </p>
     */
    public void initialize_board_graphics() {

        table.setBounds(10, height * 1 / 5 + 10, PayDayImage.getWidth() - 10, height - PayDayImage.getHeight() - 80);
        table.setSize(PayDayImage.getWidth() - 10, height - PayDayImage.getHeight() - 70);
        GridLayout grid = new GridLayout(0, 7);
        table.setOpaque(false);
        table.setLayout(grid);
        for (int i = 0; i < 32; i++) {
            Tiles[i] = new JDesktopPane();
            JTextField temptext = new JTextField();

            temptext.setText(game.table[i].getName() + " " + game.table[i].getTileposition());
            imgURL = cldr.getResource(game.table[i].getImage());
            Image pos = new ImageIcon(imgURL).getImage();
            pawn_position[i] = new JLayeredPaneExtension(pos.getScaledInstance(width * 1 / 9, height * 1 / (7 + 1 / 2), Image.SCALE_SMOOTH));

            pawn_position[i].setLayout(new FlowLayout());

            temptext.setEditable(false);
            temptext.setOpaque(true);
            temptext.setBackground(Color.BLUE);
            temptext.setFont(new Font(null, Font.BOLD, 12));
            temptext.setMaximumSize(new Dimension(width * 1 / 9, 30));

            Tiles[i].setLayout(new BoxLayout(Tiles[i], BoxLayout.Y_AXIS));
            Tiles[i].add(temptext);
            Tiles[i].add(pawn_position[i]);
            table.add(Tiles[i]);
        }
        //Create jackpotpanel
        jackPotPanel.setLayout(new BoxLayout(jackPotPanel, BoxLayout.Y_AXIS));
        jackPotPanel.setOpaque(false);
        //Create jackpottext
        JackpotInformation();
        jackPotText.setEditable(false);
        jackPotText.setOpaque(false);
        jackPotText.setHorizontalAlignment(JTextField.CENTER);
        jackPotText.setFont(new Font(null, Font.BOLD, 18));
        jackPotText.setForeground(Color.white);
        jackPotText.setBorder(null);

        ImageIcon imgICN = ImageScale("src/resources/images/jackpot.png", width * 1 / 9, height * 1 / 9);
        jackPotLabel.setIcon(imgICN);
        jackPotPanel.add(jackPotLabel);
        jackPotPanel.add(jackPotText);

        JLabel dummy = new JLabel();
        table.add(dummy);
        table.add(jackPotPanel);
    }

    /**
     * <b>transformer(mutative)</b>:doing some actions after the mail card button has been pushed<br />
     * <p><b>Postcondition:</b> doing some actions after the mail card button has been pushed</p>
     */
    public void MessageCardAction(Player player, MessageCard C) {
        if (C instanceof Advertisment) {
        } else if (C instanceof Bill) {
            Bill myCard = (Bill) C;
            myCard.CardAction(player);
            InfoboxInformation("Bills added");
            PlayerInformation();
        } else if (C instanceof TakeFromTheNeighbor) {
            TakeFromTheNeighbor myCard = (TakeFromTheNeighbor) C;
            myCard.CardAction(player);
            InfoboxInformation("Player " + player.getName() + " got the money");
            PlayerInformation();

        } else if (C instanceof Charity) {
            Charity myCard = (Charity) C;
            myCard.CardAction(player, game.JackpotSize);
            InfoboxInformation("Charity paid");
            PlayerInformation();
            JackpotInformation();
        } else if (C instanceof MoveTo) {
            MoveTo myCard = (MoveTo) C;
            pawn_position[player.getPosition()].removeAll();
            if (player.getPosition() == player.getOpponent().getPosition()) {
                PawnInformation(player.getOpponent().getPosition(), player.getOpponent().getName());
            }
            pawn_position[player.getPosition()].repaint();
            player.setPosition(((MoveTo) C).CardAction(player, game.table) - player.getPosition());
            PawnInformation(player.getPosition(), player.getName());
            if (((MoveTo) C).CardAction(player, game.table) - player.getPosition() != 0) Sunday(player);
            TileActions(player, player.getPosition());

        } else if (C instanceof PayTheNeighbor) {
            PayTheNeighbor myCard = (PayTheNeighbor) C;
            myCard.CardAction(player);
            InfoboxInformation("Player " + player.getOpponent().getName() + " got the money");
            PlayerInformation();
        }
    }

    /**
     * <b>transformer(mutative)</b>:doing some actions after a certain tile has been stepped on by the pawn<br />
     * <p><b>Postcondition:</b> doing some actions after a certain tile has been stepped on by the pawn</p>
     */
    private void TileActions(Player p, int position) {
        if (game.table[position] instanceof DealTile) {
            InfoboxInformation(p.getName() + " Draw a Deal Card");
            p.set_HasPlayed(true);
        } else if (game.table[game.p1.getPosition()] instanceof RadioContestTile && game.p1.getTurn() ||
                game.table[game.p1.getPosition()] instanceof RadioContestTile && game.p2.getTurn()) {
            isRadio = true;
            DiceP1.setEnabled(true);
            DiceP2.setEnabled(true);
            InfoboxInformation("Throw the dice");
            game.p1.getDice().setRolled(false);
            game.p2.getDice().setRolled(false);
        } else if (game.table[game.p1.getPosition()] instanceof LotteryTile && game.p1.getTurn()
                || game.table[game.p2.getPosition()] instanceof LotteryTile && game.p2.getTurn()) {
            isLottery = true;
            ArrayList<Object> opt = new ArrayList();
            opt.add("1");
            opt.add("2");
            opt.add("3");
            opt.add("4");
            opt.add("5");
            opt.add("6");
            LotteryPickPopUp dial1 = new LotteryPickPopUp(game.p1, opt);
            LotterychoiceP1 = Integer.parseInt(dial1.getChoice());
            opt.remove(LotterychoiceP1 - 1);
            LotteryPickPopUp dial2 = new LotteryPickPopUp(game.p2, opt);
            LotterychoiceP2 = Integer.parseInt(dial2.getChoice());
            InfoboxInformation("A choice: " + LotterychoiceP1 + " B choice: " + LotterychoiceP2);
            if (game.p1.getTurn()) {
                DiceP1.setEnabled(true);
                game.p1.getDice().setRolled(false);
            } else if (game.p2.getTurn()) {
                DiceP2.setEnabled(true);
                game.p2.getDice().setRolled(false);
            }
        } else if (game.table[position] instanceof PayDayTile) {

            PayDayTile pos = (PayDayTile) game.table[position];
            if (p.getLoan() != 0) {
                LoanDayPopUp dial = new LoanDayPopUp();
                pos.TileAction(p, dial.getChoice());
            } else {
                pos.TileAction(p, -1);
            }
            game.CardsFinish(p);
            if (game.GameOver()) {
                String s = game.GameWinner();
                InfoboxInformation("Player A Score: " + game.ScoreP1 + " Player B Score: " + game.ScoreP2);
                PlayerInformation();
                GamePhasePopUp dialog = new GamePhasePopUp("Start new game", "Exit", s, "Τελος Παιχνιδιού", "src/resources/images/winner.jpg");
                if (dialog.getChoice() == 1) {
                    NewGame();
                } else if (dialog.getChoice() == 2) {
                    System.exit(0);
                }
            }
            PlayerInformation();
        } else if (game.table[position] instanceof BuyerTile) {
            if (p.isEmptyCards()) {
                p.set_HasPlayed(false);
                InfoboxInformation(p.getName() + ": Does not own any Deal cards");
            } else {
                InfoboxInformation(p.getName() + ": Sell a card");
                p.set_HasPlayed(true);
            }
        } else if (game.table[position] instanceof MailTile) {
            MailTile pos = (MailTile) game.table[position];
            if (pos.isOneCard()) {
                InfoboxInformation(p.getName() + " Draw one Mail Card");
            } else {
                InfoboxInformation(p.getName() + " Draw two Mail Cards");
            }
            p.set_HasPlayed(true);
        } else if (game.table[position] instanceof FamilyCasinoNightTile) {
            FamilyCasinoNightTile pos = (FamilyCasinoNightTile) game.table[position];
            if (pos.TileAction(p, game.JackpotSize)) {
                InfoboxInformation(p.getName() + " Won in Family Casino 500 Euros");
                PlayerInformation();
            } else {
                InfoboxInformation(p.getName() + " Lost in Family Casino 500 Euros");
                JackpotInformation();
                PlayerInformation();
            }
        } else if (game.table[position] instanceof SweepstakesTile || game.table[position] instanceof YardSaleTile) {
            p.set_HasPlayed(true);
            InfoboxInformation("Roll the Dice again");
            if (p.getName().equals("P1")) {
                DiceP1.setEnabled(true);
            } else {
                DiceP2.setEnabled(true);
            }
        }
    }

    /**
     * <b>transformer(mutative)</b>:doing some actions after the pawn is on day Thursday<br />
     * <p><b>Postcondition:</b> doing some actions after the pawn is on day Thursday</p>
     */
    private void Thursday(Player p) {
        int result;
        if (game.table[p.getPosition()].isThursday()) {
            ThursdayCryptoPopUp crypto = new ThursdayCryptoPopUp();
            if (p.getDice().getRollNumber() == 1 || p.getDice().getRollNumber() == 2) {
                p.setMoney(-300);
                result = -1;
            } else if (p.getDice().getRollNumber() == 3 || p.getDice().getRollNumber() == 4) {
                result = 0;
            } else {
                result = 1;
                p.setMoney(600);
            }
            if (game.CreateThursdayCrypto(p, crypto.getChoice())) {
                ThursdayCryptoPopUp temp = new ThursdayCryptoPopUp(result);
            } else if (crypto.getChoice() != 3) {
                ThursdayCryptoPopUp temp = new ThursdayCryptoPopUp(result);
            }
            PlayerInformation();
        }

    }

    /**
     * <b>transformer(mutative)</b>:doing some actions after the pawn is on day Sunday<br />
     * <p><b>Postcondition:</b> doing some actions after the pawn is on day Sunday</p>
     */
    private void Sunday(Player p) {
        if (game.table[p.getPosition()].isSunday()) {
            SundayMatchPopUp match = new SundayMatchPopUp();
            if (game.CreateSundayMatch(p, match.getChoice())) {
                SundayMatchPopUp temp = new SundayMatchPopUp(true);
            } else if (match.getChoice() != 3) {
                SundayMatchPopUp temp = new SundayMatchPopUp(false);
            }
            PlayerInformation();
        }
    }

    /**
     * <b>transformer(mutative)</b>:Updates jackpot information<br />
     * <p><b>Postcondition:</b> Updates jackpot information</p>
     */
    private void JackpotInformation() {
        jackPotText.setText("Jackpot: " + game.JackpotSize.getjackpotSize() + " Euros");
    }

    /**
     * <b>transformer(mutative)</b>:Updates pawn information<br />
     * <p><b>Postcondition:</b> Updates pawn information</p>
     */
    private void PawnInformation(int position, String name) {
        JLabel pawn = new JLabel();

        if (name.equals("P1")) {
            imgICN = ImageScale("src/resources/images/pawn_yellow.png", 50, 50);
        } else {
            imgICN = ImageScale("src/resources/images/pawn_blue.png", 50, 50);
        }
        pawn.setIcon(imgICN);
        pawn_position[position].add(pawn);
        Graphics g1 = Tiles[position].getGraphics();
        Tiles[position].paintComponents(g1);
        Tiles[position].repaint();
    }

    /**
     * <b>Accessor:</b>Shows the Deal card
     *
     * @param dealcard the card we want to show
     * @param choice   players choice about what to do
     */
    public int showDealCard(DealCard dealcard, String choice) {
        System.out.println(dealcard);
        Object[] options = {"Buy", "Ignore Deal"};
        Object[] options2 = {"OK"};
        int n;

        URL imgURL = cldr.getResource("resources/images/" + dealcard.getText());
        Image image = new ImageIcon(imgURL).getImage();
        image = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        JOptionPane p = new JOptionPane();
        if (choice.equals("show")) {
            n = JOptionPane.showOptionDialog(this,
                    dealcard.getimgURL() + "\nΤιμή Αγοράς: " + dealcard.getMoney() + " Ευρώ \nΤιμή Πώλησης: " + dealcard.getSellPrice() + " Ευρώ \n",
                    "DealCard",
                    JOptionPane.OK_OPTION,
                    0,
                    new ImageIcon(image),
                    options,
                    options[0]);
        } else {
            n = JOptionPane.showOptionDialog(this,
                    dealcard.getimgURL() + "\nΤιμή Αγοράς: " + dealcard.getMoney() + " Ευρώ \nΤιμή Πώλησης: " + dealcard.getSellPrice() + " Ευρώ \n",
                    "DealCard",
                    JOptionPane.OK_OPTION,
                    0,
                    new ImageIcon(image),
                    options2,
                    options2[0]);
        }
        return n;

    }

    /**
     * <b>transformer(mutative)</b>:initializes labels for the infobox <br />
     * <p><b>Postcondition:</b> initializes labels for the infobox</p>
     */
    private void initialize_Infobox() {
        InfoBox.setBounds((width * 6 / 8) + 30, height * 1 / 3, width * 2 / 8 - 50, P1.getHeight() / 2 + 20);
        InfoBox.setSize(width * 2 / 8 - 50, P1.getHeight() / 2 + 20);
        InfoBox.setLayout(new BoxLayout(InfoBox, BoxLayout.Y_AXIS));
        InfoBox.setBackground(Color.WHITE);
        InfoBox.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black), BorderFactory.createCompoundBorder(
                        BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder())));

        info.setEditable(false);
        info.setBorder(null);
        info.setOpaque(false);

        turn.setEditable(false);
        turn.setOpaque(false);
        turn.setBorder(null);
        command.setEditable(false);
        command.setOpaque(false);
        command.setBorder(null);
        monthsleft.setEditable(false);
        monthsleft.setOpaque(false);
        monthsleft.setBorder(null);

        InfoboxInformation("");

        InfoBox.add(info);
        InfoBox.add(monthsleft);
        InfoBox.add(turn);
        InfoBox.add(command);
    }

    /**
     * <b>transformer(mutative)</b>:Updates infobox information<br />
     * <p><b>Postcondition:</b> Updates infobox information</p>
     */
    private void InfoboxInformation(String commandtxt) {

        monthsleft.setText(game.Infobox()[0]);
        turn.setText(game.Infobox()[1]);
        command.setText(commandtxt);
    }

    /**
     * <b>transformer(mutative)</b>:Updates player information<br />
     * <p><b>Postcondition:</b> Updates player information</p>
     */
    private void PlayerInformation() {
        MoneyP1.setText("Money: " + game.p1.getMoney() + " Euros");
        MoneyP2.setText("Money: " + game.p2.getMoney() + " Euros");
        LoanP1.setText("Loan: " + game.p1.getLoan() + " Euros");
        LoanP2.setText("Loan: " + game.p2.getLoan() + " Euros");
        BillsP1.setText("Bills: " + game.p1.getBills() + " Euros");
        BillsP2.setText("Bills: " + game.p2.getBills() + " Euros");
    }

    /**
     * <b>transformer(mutative)</b>:initializes everything(labels,buttons) for both the Players <br />
     * <p><b>Postcondition:</b> initializes everything(labels,buttons) for both the Players</p>
     */
    private void PlayerPanel() {
        PlayerInformation();
        /**
         * Initialize the first player P1
         */
        P1.setLayout(new BorderLayout());
        P1.add(NameP1, BorderLayout.NORTH);
        JDesktopPane statsP1 = new JDesktopPane();
        statsP1.setLayout(new BoxLayout(statsP1, BoxLayout.Y_AXIS));
        MoneyP1.setEditable(false);
        MoneyP1.setOpaque(false);
        MoneyP1.setBorder(null);
        statsP1.add(MoneyP1);
        BillsP1.setOpaque(false);
        BillsP1.setBorder(null);
        BillsP1.setEditable(false);
        statsP1.add(BillsP1);
        LoanP1.setEditable(false);
        LoanP1.setOpaque(false);
        LoanP1.setBorder(null);
        statsP1.add(LoanP1);
        DealCardsA.setText("My Deal Cards");
        DealCardsA.addActionListener(new ButtonListenerP1());
        statsP1.add(DealCardsA);
        P1.add(statsP1, BorderLayout.CENTER);

        JDesktopPane buttonsP1 = new JDesktopPane();
        GetLoanP1.setText("Get Loan");
        GetLoanP1.addActionListener(new ButtonListenerP1());
        EndTurnP1.setText("End Turn");
        EndTurnP1.addActionListener(new ButtonListenerP1());
        buttonsP1.setLayout(new BoxLayout(buttonsP1, BoxLayout.X_AXIS));
        buttonsP1.add(GetLoanP1);
        buttonsP1.add(EndTurnP1);
        P1.add(buttonsP1, BorderLayout.SOUTH);
        DiceP1.setBackground(Color.WHITE);
        DiceP1.setBorder(null);
        DiceP1.addActionListener(new DiceListener());
        DiceInformation(1, "P1");
        P1.add(DiceP1, BorderLayout.EAST);

        /**
         * Initialize the second player P2
         */
        P2.setLayout(new BorderLayout());
        P2.add(NameP2, BorderLayout.NORTH);

        JDesktopPane statsP2 = new JDesktopPane();
        statsP2.setLayout(new BoxLayout(statsP2, BoxLayout.Y_AXIS));

        MoneyP2.setEditable(false);
        MoneyP2.setOpaque(false);
        MoneyP2.setBorder(null);
        statsP2.add(MoneyP2);
        BillsP2.setOpaque(false);
        BillsP2.setBorder(null);
        BillsP2.setEditable(false);
        statsP2.add(BillsP2);
        LoanP2.setEditable(false);
        LoanP2.setOpaque(false);
        LoanP2.setBorder(null);
        statsP2.add(LoanP2);
        DealCardsB.setText("My Deal Cards");
        DealCardsB.addActionListener(new ButtonListenerP2());
        statsP2.add(DealCardsB);
        P2.add(statsP2, BorderLayout.CENTER);
        JDesktopPane buttonsP2 = new JDesktopPane();
        GetLoanP2.setText("Get Loan");
        GetLoanP2.addActionListener(new ButtonListenerP2());
        EndTurnP2.setText("End Turn");
        EndTurnP2.addActionListener(new ButtonListenerP2());
        buttonsP2.setLayout(new BoxLayout(buttonsP2, BoxLayout.X_AXIS));
        buttonsP2.add(GetLoanP2);
        buttonsP2.add(EndTurnP2);
        DiceP2.setBackground(Color.WHITE);
        DiceP2.setBorder(null);
        DiceP2.addActionListener(new DiceListener());
        DiceInformation(1, "P2");
        P2.add(DiceP2, BorderLayout.EAST);
        P2.add(buttonsP2, BorderLayout.SOUTH);
    }

    /**
     * <b>transformer(mutative)</b>:doing some action after a dice button has been pushed<br />
     * <p><b>Postcondition:</b> doing some action after a dice button has been pushed</p>
     */
    private class DiceListener implements ActionListener {
        Dice dicea = game.p1.getDice();
        Dice diceb = game.p2.getDice();

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand() != null) {
                if (e.getSource() == DiceP1 && game.p1.get_HasPlayed()) {
                    DiceInformation(dicea.setRoll(), "P1");
                    DiceP1.setEnabled(false);
                    if (game.table[game.p1.getPosition()] instanceof YardSaleTile) {
                        YardSaleTile pos = (YardSaleTile) game.table[game.p1.getPosition()];
                        DealCard C = game.DealDeck.getCard();
                        pos.TileAction(game.p1, dicea.getRollNumber(), C);
                        showDealCard(C, "");
                        PlayerInformation();
                        InfoboxInformation(game.p1.getName() + " bought this card for " + dicea.getRollNumber() * 100);
                        game.p1.set_HasPlayed(false);
                    } else if (game.table[game.p1.getPosition()] instanceof SweepstakesTile) {
                        SweepstakesTile pos = (SweepstakesTile) game.table[game.p1.getPosition()];
                        pos.TileAction(game.p1, dicea.getRollNumber());
                        PlayerInformation();
                        InfoboxInformation(game.p1.getName() + " Won " + dicea.getRollNumber() * 1000 + " E");
                        game.p1.set_HasPlayed(false);
                    }
                } else if (e.getSource() == DiceP2 && game.p2.get_HasPlayed()) {
                    DiceInformation(diceb.setRoll(), "P2");
                    DiceP2.setEnabled(false);
                    if (game.table[game.p2.getPosition()] instanceof SweepstakesTile) {
                        SweepstakesTile pos = (SweepstakesTile) game.table[game.p2.getPosition()];
                        pos.TileAction(game.p2, diceb.getRollNumber());
                        PlayerInformation();
                        InfoboxInformation(game.p2.getName() + " Won " + diceb.getRollNumber() * 1000 + " E");
                        game.p2.set_HasPlayed(false);
                    } else if (game.table[game.p2.getPosition()] instanceof YardSaleTile) {
                        YardSaleTile pos = (YardSaleTile) game.table[game.p2.getPosition()];
                        DealCard C = game.DealDeck.getCard();
                        pos.TileAction(game.p2, diceb.getRollNumber(), C);
                        showDealCard(C, "");
                        PlayerInformation();
                        InfoboxInformation(game.p2.getName() + " bought this card for " + diceb.getRollNumber() * 100);
                        game.p2.set_HasPlayed(false);
                    }
                } else if (isRadio) {
                    if (e.getSource() == DiceP1) {
                        DiceInformation(dicea.setRoll(), "P1");
                        DiceP1.setEnabled(false);
                    } else {
                        DiceInformation(diceb.setRoll(), "P2");
                        DiceP2.setEnabled(false);
                    }

                    if (dicea.getRolled() && diceb.getRolled()) {
                        if (dicea.getRollNumber() == diceb.getRollNumber()) {
                            DiceP1.setEnabled(true);
                            DiceP2.setEnabled(true);
                            dicea.setRolled(false);
                            diceb.setRolled(false);
                            InfoboxInformation("Throw again the dices");
                        } else {
                            if (dicea.getRollNumber() > diceb.getRollNumber()) {
                                game.p1.setMoney(1000);
                                PlayerInformation();
                                InfoboxInformation("A won 1000 from Radio");
                            } else {
                                game.p2.setMoney(1000);
                                PlayerInformation();
                                InfoboxInformation("B won 1000 from Radio");
                            }
                            isRadio = false;
                        }
                    }
                } else if (isLottery) {
                    if (e.getSource() == DiceP1) {
                        DiceInformation(dicea.setRoll(), "P1");
                        DiceP1.setEnabled(false);
                        if (dicea.getRollNumber() == LotterychoiceP1) {
                            game.p1.setMoney(1000);
                            PlayerInformation();
                            InfoboxInformation("A won 1000 from Lottery");
                            isLottery = false;
                        } else {
                            DiceP2.setEnabled(true);
                        }
                    } else {
                        DiceInformation(diceb.setRoll(), "P2");
                        DiceP2.setEnabled(false);
                        if (diceb.getRollNumber() == LotterychoiceP2) {
                            game.p2.setMoney(1000);
                            PlayerInformation();
                            InfoboxInformation("B won 1000 from Lottery");
                            isLottery = false;
                        } else {
                            DiceP1.setEnabled(true);
                        }
                    }
                } else {
                    Move_Player(e);
                }
            }
        }
    }

    /**
     * <b>transformer(mutative)</b>:Changes player's pawn position <br />
     * <p><b>Postcondition:</b> Changes player's pawn position</p>
     */
    private void Move_Player(ActionEvent e) {
        Dice dicea = game.p1.getDice();
        Dice diceb = game.p2.getDice();
        if (e.getSource() == DiceP1) {
            DiceInformation(dicea.setRoll(), "P1");
            if (dicea.getRolled()) {
                DiceP1.setEnabled(false);
                if (game.GameStart) {
                    if (dicea.getRollNumber() == 6) {
                        game.WinJackpot(game.p1);
                        JackpotInformation();
                        PlayerInformation();
                    }
                    if (game.p1.getPosition() == 0) {
                        pawn_position[31].removeAll();
                        pawn_position[31].repaint();
                    }
                    pawn_position[game.p1.getPosition()].removeAll();
                    if (game.p1.getPosition() == game.p2.getPosition()) {
                        PawnInformation(game.p2.getPosition(), "P2");
                    }
                    pawn_position[game.p1.getPosition()].repaint();
                    game.p1.setPosition(dicea.getRollNumber());
                    PawnInformation(game.p1.getPosition(), "P1");
                    Sunday(game.p1);
                    Thursday(game.p1);
                    TileActions(game.p1, game.p1.getPosition());
                }
            }
        } else {
            DiceInformation(diceb.setRoll(), "P2");
            if (diceb.getRolled()) {
                DiceP2.setEnabled(false);

                if (game.GameStart) {
                    if (diceb.getRollNumber() == 6) {
                        game.WinJackpot(game.p2);
                        JackpotInformation();
                        PlayerInformation();
                    }
                    if (game.p2.getPosition() == 0) {
                        pawn_position[31].removeAll();
                        pawn_position[31].repaint();
                    }
                    pawn_position[game.p2.getPosition()].removeAll();
                    if (game.p1.getPosition() == game.p2.getPosition()) {
                        PawnInformation(game.p1.getPosition(), "P1");
                    }
                    pawn_position[game.p2.getPosition()].repaint();
                    game.p2.setPosition(diceb.getRollNumber());
                    PawnInformation(game.p2.getPosition(), "P2");
                    Sunday(game.p2);
                    Thursday(game.p2);
                    TileActions(game.p2, game.p2.getPosition());
                }
            }
        }
        Starts_First();
    }

    /**
     * <b>Observer</b>:Checks both players dice roll and initializes the player with the bigger roll as first
     * <b>Postcondition</b>Checks both players dice roll and initializes the player with the bigger roll as first
     */
    public void Starts_First() {
        Dice dicea = game.p1.getDice();
        Dice diceb = game.p2.getDice();
        if (dicea.getRolled() && diceb.getRolled() && !game.p1.getTurn() && !game.p2.getTurn()) {
            if (dicea.getRollNumber() == diceb.getRollNumber()) {
                DiceP1.setEnabled(true);
                DiceP2.setEnabled(true);
                dicea.setRolled(false);
                diceb.setRolled(false);
            } else {
                game.initialize_GoesFirst(dicea.getRollNumber(), diceb.getRollNumber());
                DealCards.setEnabled(true);
                MessageCards.setEnabled(true);

                game.GameStart = true;
                InfoboxInformation("");
                if (game.p1.getTurn()) {
                    DiceP1.setEnabled(true);
                } else {
                    DiceP2.setEnabled(true);
                }

                dicea.setRolled(false);
                diceb.setRolled(false);
            }
        }
    }

    /**
     * <b>transformer(mutative)</b>:initializes buttons for both the dice <br />
     * <p><b>Postcondition:</b> initializes buttons for both the dice </p>
     */
    private void DiceInformation(int DiceRoll, String name) {
        if (name.equals("P1")) {
            imgURL = cldr.getResource("resources/images/dice-" + DiceRoll + ".jpg");
            System.out.println(imgURL);
            image = new ImageIcon(imgURL).getImage();
            image = image.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
            DiceP1.setIcon(new ImageIcon(image));
        } else if (name.equals("P2")) {
            System.out.println(DiceRoll);
            imgURL = cldr.getResource("resources/images/dice-" + DiceRoll + ".jpg");
            System.out.println(imgURL);
            image = new ImageIcon(imgURL).getImage();
            image = image.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
            DiceP2.setIcon(new ImageIcon(image));

        }
    }

    /**
     * <b>transformer(mutative)</b>:doing some action after Players 1 ,buttons have been pushed<br />
     * <p><b>Postcondition:</b> doing some action after Players 1 ,buttons have been pushed</p>
     */
    private class ButtonListenerP1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (game.p1.getTurn()) {
                if (command.equals("End Turn") && game.p1.getDice().getRolled()) {
                    if (game.p1.get_HasPlayed()) {

                    } else if (isRadio || isLottery) {

                    } else if (game.p2.get_has_finished()) {
                        if (game.p1.get_has_finished()) {
                            game.p1.setTurn(false);
                        } else {
                            DiceP1.setEnabled(true);
                            game.p1.getDice().setRolled(false);
                            game.p1.setTurn(true);
                            InfoboxInformation("");
                        }
                    } else {
                        game.p2.setTurn(true);
                        game.p1.setTurn(false);
                        DiceP2.setEnabled(true);
                        game.p1.getDice().setRolled(false);
                        InfoboxInformation("");
                    }
                } else if (command.equals("Get Loan")) {
                    GetLoan(game.p1);
                } else if (command.equals("My Deal Cards") && game.table[game.p1.getPosition()] instanceof BuyerTile) {
                    PlayersDealCards(game.p1);
                }
            }
        }

    }

    /**
     * @param p the player
     */
    public void PlayersDealCards(Player p) {
        if (!p.isEmptyCards() && p.get_HasPlayed()) {
            DealCard myCard = p.SellDealCard();
            showDealCard(myCard, "sell");
            p.set_HasPlayed(false);
            p.setMoney(myCard.getSellPrice());
            game.RejectedCards.RejectCard(myCard);
            PlayerInformation();
            InfoboxInformation(p.getName() + " : Sold the card");
        }
    }

    /**
     * <b>Transformer:</b>Creates a getloanpopup and gives player the option to take a loan
     *
     * @param p
     */
    public void GetLoan(Player p) {
        GetLoanPopUp loan = new GetLoanPopUp();
        if (Integer.parseInt(loan.getChoice()) != 0) {
            p.setLoan(Integer.parseInt(loan.getChoice()));
            p.setMoney(Integer.parseInt(loan.getChoice()));
            PlayerInformation();
            InfoboxInformation("Player " + p.getName() + " got " + Integer.parseInt(loan.getChoice()) + " loan");
        }
    }

    /**
     * <b>transformer(mutative)</b>:doing some action after Players 2 ,buttons have been pushed<br />
     * <p><b>Postcondition:</b> doing some action after Players 2 ,buttons have been pushed</p>
     */
    private class ButtonListenerP2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (game.p2.getTurn()) {
                String command = e.getActionCommand();
                if (command.equals("End Turn") && game.p2.getDice().getRolled()) {

                    if (game.p2.get_HasPlayed()) {

                    } else if (isRadio || isLottery) {

                    } else if (game.p1.get_has_finished()) {
                        if (game.p2.get_has_finished()) {
                            InfoboxInformation("Game has probably finished");
                            game.p2.setTurn(false);
                        } else {
                            DiceP2.setEnabled(true);
                            game.p2.getDice().setRolled(false);
                            game.p2.setTurn(true);
                            InfoboxInformation("");
                        }
                    } else {
                        game.p1.setTurn(true);
                        game.p2.setTurn(false);
                        DiceP1.setEnabled(true);
                        game.p2.getDice().setRolled(false);
                        InfoboxInformation("");
                    }

                } else if (command.equals("Get Loan")) {
                    GetLoan(game.p2);
                } else if (command.equals("My Deal Cards") && game.table[game.p2.getPosition()] instanceof BuyerTile) {
                    PlayersDealCards(game.p2);
                }
            }
        }
    }

    /**
     * <b>transformer(mutative)</b>:initializes a menu<br />
     * <p><b>Postcondition:</b> initializes a menu </p>
     */
    public void CreateMenu() {
        JMenuItem items;
        MenuFile = new JMenu("Options");
        items = new JMenuItem("Start New Game");
        items.addActionListener(new Menulistener());
        MenuFile.add(items);

        items = new JMenuItem("Exit the Game");
        items.addActionListener(new Menulistener());
        MenuFile.add(items);
        items = new JMenuItem("Save the Game");
        items.addActionListener(new Menulistener());
        MenuFile.add(items);
    }

    /**
     * <b>transformer(mutative)</b>:doing some action after menu button have been pushed<br />
     * <p><b>Postcondition:</b> doing some action after menu button have been pushed</p>
     */
    private class Menulistener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            switch (command) {
                case "Start New Game":
                    GamePhasePopUp win = new GamePhasePopUp("Yes", "No", "Do you really want to play a new game?", command, null);
                    if (win.getChoice() == 1) {
                        NewGame();
                    }
                    break;
                case "Exit the Game":
                    GamePhasePopUp win2 = new GamePhasePopUp("Yes", "No", "Do you really wish to exit?", command, null);
                    if (win2.getChoice() == 1) {
                        System.exit(0);
                    }
                    break;
                case "Save the Game":
                    JOptionPane.showMessageDialog(null, "Save not implemented!", "Save", JOptionPane.ERROR_MESSAGE);
                default:
                    break;
            }
        }
    }

    /**
     * Function that calls all initialziing functions
     */
    private void StartAll() {
        game.initialize_game();
        game.initialize_board();
        initialize_board_graphics();
        BasePanel.add(table);

        PawnInformation(game.p2.getPosition(), "P2");
        PawnInformation(game.p1.getPosition(), "P1");
        PlayerInformation();

        DiceInformation(1, "P1");
        DiceInformation(3, "P2");
        InfoboxInformation("");
    }

    /**
     * Function that starts a new game
     */
    public void NewGame() {
        this.setVisible(false);
        new GraphicUI();
    }


    static ImageIcon ImageScale(String image, int width, int height) {
        Image newimg = new ImageIcon(image).getImage().getScaledInstance(
                width, height, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }

    /**
     * Class used for setting background on JLayredPane
     */
    public class JLayeredPaneExtension extends JLayeredPane {

        private Image image;

        public JLayeredPaneExtension(Image img) {
            image = img;
        }

        public void setImage(Image image) {
            this.image = image;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }
    }


}


