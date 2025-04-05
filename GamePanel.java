import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 *
 * @author Simon
 */
public class GamePanel extends JPanel {

    private JTextField jTextField1, jTextField10, jTextField11, jTextField12, jTextField13, jTextField2,
            jTextField3, jTextField4, jTextField5, jTextField6, jTextField7, jTextField8, jTextField9;
    private JButton jButton2, jButton10, jButton11, jButton3, jButton1, jButton4,
            jButton5, jButton6, jButton7, jButton8, jButton9;
    private JPanel jPanel1, jPanel2, jPanel3, jPanel4;
    private JProgressBar jProgressBar1, jProgressBar2;

    private MainWindow mainWindow;

    private Player[] tempPlayers;
    private int tempCard;

    public GamePanel(MainWindow pMainWindow) {
        mainWindow = pMainWindow;

        initComponents();
    }

    private void initComponents() {
        jButton8 = new JButton();
        jPanel2 = new JPanel();
        jTextField8 = new JTextField();
        jTextField9 = new JTextField();
        jPanel1 = new JPanel();
        jButton3 = new JButton();
        jButton2 = new JButton();
        jButton1 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();
        jButton7 = new JButton();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        jTextField5 = new JTextField();
        jTextField6 = new JTextField();
        jTextField7 = new JTextField();
        jButton9 = new JButton();
        jButton10 = new JButton();
        jProgressBar1 = new JProgressBar();
        jProgressBar2 = new JProgressBar();
        jPanel3 = new JPanel();
        jTextField10 = new JTextField();
        jTextField11 = new JTextField();
        jPanel4 = new JPanel();
        jTextField12 = new JTextField();
        jTextField13 = new JTextField();
        jButton11 = new JButton();

        jButton8.setBackground(new Color(204, 204, 204));
        jButton8.setForeground(new Color(0, 0, 0));
        jButton8.setText("jButton1");
        jButton8.setBorder(new LineBorder(new Color(255, 255, 255), 20, true));
        jButton8.addActionListener(this::onCard8ButtonClick);

        setBackground(new Color(102, 102, 102));
        setForeground(new Color(153, 153, 153));

        jPanel2.setBackground(new Color(204, 204, 204));
        jPanel2.setBorder(new LineBorder(new Color(255, 255, 255), 15, true));
        jPanel2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        jTextField8.setBackground(new Color(204, 204, 204));
        jTextField8.setFont(new Font("Calibri", 1, 36));
        jTextField8.setForeground(new Color(0, 0, 0));
        jTextField8.setHorizontalAlignment(JTextField.CENTER);
        jTextField8.setEditable(false);
        jTextField8.setText("Name");
        jTextField8.addActionListener(this::jTextField8ActionPerformed);

        jTextField9.setBackground(new Color(204, 204, 204));
        jTextField9.setFont(new Font("Calibri", 1, 36));
        jTextField9.setForeground(new Color(0, 0, 0));
        jTextField9.setHorizontalAlignment(JTextField.CENTER);
        jTextField9.setEditable(false);
        jTextField9.setText("Cards");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(41, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField9, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTextField8)
                                .addGap(147, 147, 147)
                                .addComponent(jTextField9)
                                .addContainerGap())
        );

        jPanel1.setBackground(new Color(204, 204, 204));
        jPanel1.setBorder(new LineBorder(new Color(255, 255, 255), 15, true));
        jPanel1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        jButton1.setBackground(new Color(204, 204, 204));
        jButton1.setForeground(new Color(0, 0, 0));
        jButton1.setIcon(new ImageIcon(getClass().getResource("images/" + Card.values()[0].name().toLowerCase() + ".jpg")));
        jButton1.setBorder(new LineBorder(new Color(255, 255, 255), 13, true));
        jButton1.setLabel("");
        jButton1.addActionListener(this::onCard1ButtonClick);

        jButton2.setBackground(new Color(204, 204, 204));
        jButton2.setForeground(new Color(0, 0, 0));
        jButton2.setIcon(new ImageIcon(getClass().getResource("images/" + Card.values()[1].name().toLowerCase() + ".jpg")));
        jButton2.setBorder(new LineBorder(new Color(255, 255, 255), 13, true));
        jButton2.setLabel("");
        jButton2.addActionListener(this::onCard2ButtonClick);

        jButton3.setBackground(new Color(204, 204, 204));
        jButton3.setForeground(new Color(0, 0, 0));
        jButton3.setIcon(new ImageIcon(getClass().getResource("images/" + Card.values()[2].name().toLowerCase() + ".jpg")));
        jButton3.setBorder(new LineBorder(new Color(255, 255, 255), 13, true));
        jButton3.setLabel("");
        jButton3.addActionListener(this::onCard3ButtonClick);

        jButton4.setBackground(new Color(204, 204, 204));
        jButton4.setForeground(new Color(0, 0, 0));
        jButton4.setText("4");
        jButton4.setBorder(new LineBorder(new Color(255, 255, 255), 20, true));
        jButton4.addActionListener(this::onCard4ButtonClick);

        jButton5.setBackground(new Color(204, 204, 204));
        jButton5.setForeground(new Color(0, 0, 0));
        jButton5.setText("5");
        jButton5.setBorder(new LineBorder(new Color(255, 255, 255), 20, true));
        jButton5.addActionListener(this::onCard5ButtonClick);

        jButton6.setBackground(new Color(204, 204, 204));
        jButton6.setForeground(new Color(0, 0, 0));
        jButton6.setText("6");
        jButton6.setBorder(new LineBorder(new Color(255, 255, 255), 20, true));
        jButton6.addActionListener(this::onCard6ButtonClick);

        jButton7.setBackground(new Color(204, 204, 204));
        jButton7.setForeground(new Color(0, 0, 0));
        jButton7.setText("7");
        jButton7.setBorder(new LineBorder(new Color(255, 255, 255), 20, true));
        jButton7.addActionListener(this::onCard7ButtonClick);

        jTextField1.setBackground(new Color(204, 204, 204));
        jTextField1.setFont(new Font("Calibri", 1, 36));
        jTextField1.setForeground(new Color(0, 0, 0));
        jTextField1.setHorizontalAlignment(JTextField.CENTER);
        jTextField1.setEditable(false);
        jTextField1.setText("Count");

        jTextField2.setBackground(new Color(204, 204, 204));
        jTextField2.setFont(new Font("Calibri", 1, 36));
        jTextField2.setForeground(new Color(0, 0, 0));
        jTextField2.setHorizontalAlignment(JTextField.CENTER);
        jTextField2.setEditable(false);
        jTextField2.setText("Count");

        jTextField3.setBackground(new Color(204, 204, 204));
        jTextField3.setFont(new Font("Calibri", 1, 36));
        jTextField3.setForeground(new Color(0, 0, 0));
        jTextField3.setHorizontalAlignment(JTextField.CENTER);
        jTextField3.setEditable(false);
        jTextField3.setText("Count");

        jTextField4.setBackground(new Color(204, 204, 204));
        jTextField4.setFont(new Font("Calibri", 1, 36));
        jTextField4.setForeground(new Color(0, 0, 0));
        jTextField4.setHorizontalAlignment(JTextField.CENTER);
        jTextField4.setEditable(false);
        jTextField4.setText("Count");

        jTextField5.setBackground(new Color(204, 204, 204));
        jTextField5.setFont(new Font("Calibri", 1, 36));
        jTextField5.setForeground(new Color(0, 0, 0));
        jTextField5.setHorizontalAlignment(JTextField.CENTER);
        jTextField5.setEditable(false);
        jTextField5.setText("Count");

        jTextField6.setBackground(new Color(204, 204, 204));
        jTextField6.setFont(new Font("Calibri", 1, 36));
        jTextField6.setForeground(new Color(0, 0, 0));
        jTextField6.setHorizontalAlignment(JTextField.CENTER);
        jTextField6.setEditable(false);
        jTextField6.setText("Count");

        jTextField7.setBackground(new Color(204, 204, 204));
        jTextField7.setFont(new Font("Calibri", 1, 36));
        jTextField7.setForeground(new Color(0, 0, 0));
        jTextField7.setHorizontalAlignment(JTextField.CENTER);
        jTextField7.setEditable(false);
        jTextField7.setText("Count");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(145, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextField1, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                        .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField2, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField3, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField4, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField5, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField6, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton7, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField7))
                                .addContainerGap(145, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jTextField1)
                                                .addComponent(jTextField2)
                                                .addComponent(jTextField3))
                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jTextField6)
                                                .addComponent(jTextField5)
                                                .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField7)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton7, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14))
        );

        jButton9.setBackground(new Color(102, 102, 102));
        jButton9.setForeground(new Color(0, 0, 0));
        jButton9.setText("");
        jButton9.setIcon(null);
        jButton9.setBorder(new LineBorder(new Color(255, 255, 255), 20, true));
        jButton9.addActionListener(this::onPlacePileButtonClick);

        jButton10.setBackground(new Color(255, 255, 255));
        jButton10.setForeground(new Color(0, 0, 0));
        jButton10.setText("Pull");
        jButton10.setFont(new Font("Calibri", 1, 36));
        jButton10.setBorder(new LineBorder(new Color(255, 255, 255), 20, true));
        jButton10.addActionListener(this::onPullButtonClick);

        jPanel3.setBackground(new Color(204, 204, 204));
        jPanel3.setBorder(new LineBorder(new Color(255, 255, 255), 15, true));
        jPanel3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        jTextField10.setBackground(new Color(204, 204, 204));
        jTextField10.setFont(new Font("Calibri", 1, 36));
        jTextField10.setForeground(new Color(0, 0, 0));
        jTextField10.setHorizontalAlignment(JTextField.CENTER);
        jTextField10.setEditable(false);
        jTextField10.setText("Name");
        jTextField10.addActionListener(this::jTextField10ActionPerformed);

        jTextField11.setBackground(new Color(204, 204, 204));
        jTextField11.setFont(new Font("Calibri", 1, 36));
        jTextField11.setForeground(new Color(0, 0, 0));
        jTextField11.setHorizontalAlignment(JTextField.CENTER);
        jTextField11.setEditable(false);
        jTextField11.setText("Cards");

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap(41, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextField10, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField11, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTextField10)
                                .addGap(147, 147, 147)
                                .addComponent(jTextField11)
                                .addContainerGap())
        );

        jPanel4.setBackground(new Color(204, 204, 204));
        jPanel4.setBorder(new LineBorder(new Color(255, 255, 255), 15, true));
        jPanel4.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        jTextField12.setBackground(new Color(204, 204, 204));
        jTextField12.setFont(new Font("Calibri", 1, 36));
        jTextField12.setForeground(new Color(0, 0, 0));
        jTextField12.setHorizontalAlignment(JTextField.CENTER);
        jTextField12.setEditable(false);
        jTextField12.setText("Name");
        jTextField12.addActionListener(this::jTextField12ActionPerformed);

        jTextField13.setBackground(new Color(204, 204, 204));
        jTextField13.setFont(new Font("Calibri", 1, 36));
        jTextField13.setForeground(new Color(0, 0, 0));
        jTextField13.setHorizontalAlignment(JTextField.CENTER);
        jTextField13.setEditable(false);
        jTextField13.setText("Cards");

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap(41, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextField12, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField13, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTextField12)
                                .addGap(147, 147, 147)
                                .addComponent(jTextField13)
                                .addContainerGap())
        );

        jButton11.setFont(new Font("Calibri", 1, 36));
        jButton11.setText("Quit");
        jButton11.addActionListener(this::onQuitButtonClick);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jButton11, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(262, Short.MAX_VALUE)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
                                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
                                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(264, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jProgressBar2, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                                .addGap(352, 352, 352)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jProgressBar1, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton9, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton11)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jProgressBar1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jProgressBar2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton10, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton9, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
    }

    private void onCard1ButtonClick(ActionEvent evt) {
        onCardButtonClick(evt, 1);
    }

    private void onCard2ButtonClick(ActionEvent evt) {
        onCardButtonClick(evt, 2);
    }

    private void onCard3ButtonClick(ActionEvent evt) {
        onCardButtonClick(evt, 3);
    }

    private void onCard4ButtonClick(ActionEvent evt) {
        onCardButtonClick(evt, 4);
    }

    private void onCard5ButtonClick(ActionEvent evt) {
        onCardButtonClick(evt, 5);
    }

    private void onCard6ButtonClick(ActionEvent evt) {
        onCardButtonClick(evt, 6);
    }

    private void onCard7ButtonClick(ActionEvent evt) {
        onCardButtonClick(evt, 7);
    }

    private void onCard8ButtonClick(ActionEvent evt) {
        onCardButtonClick(evt, 8);
    }

    private void onCardButtonClick(ActionEvent evt, int card) {
        // check if the game started
        if (mainWindow.getClient().isInGame() && mainWindow.getClient().isTurn()) {
            // set temporary card id for use in onPlacePileButtonClick()
            tempCard = card;
            // mark the current card
            markCard(tempCard);
        }
    }

    private void onPlacePileButtonClick(ActionEvent evt) {
        // check if there is a valid card marked
        if (tempCard > 0) {
            // reset card markers
            resetCardMarkers();
            // send card place to the server
            Card card = Card.values()[tempCard - 1];
            mainWindow.getClient().placeCard(card);
            // reset temporary card
            tempCard = 0;
        }
    }

    private void onPullButtonClick(ActionEvent evt) {
        if (mainWindow.getClient().isInGame() && mainWindow.getClient().isTurn()) {
            mainWindow.getClient().takeCard();
        }
    }

    private void jTextField8ActionPerformed(ActionEvent evt) {
        // ignored
    }

    private void jTextField10ActionPerformed(ActionEvent evt) {
        // ignored
    }

    private void jTextField12ActionPerformed(ActionEvent evt) {
        // ignored
    }

    private void onQuitButtonClick(ActionEvent evt) {
        // leave the game
        mainWindow.getClient().leaveGame();
        // switch gui back to login
        mainWindow.switchToLogin();
    }

    public void updateNamesOrdered(boolean useCache) {
        jTextField8.setText("- Empty -");
        jTextField9.setText("");
        jTextField10.setText("- Empty -");
        jTextField11.setText("");
        jTextField12.setText("- Empty -");
        jTextField13.setText("");
        // check if everything should be updated
        if (!useCache) {
            // fill temp player array
            List<Player> players = mainWindow.getClient().getPlayers();
            // init array
            tempPlayers = new Player[4];
            // define vars
            int i = 0, j = 0;
            // start loop
            players.toFirst();
            while (players.hasAccess()) {
                // check if it is not out of bounds
                if (i > 3 || i < 0) break;
                // check for the index of our client
                if (players.getContent().getName().equalsIgnoreCase(mainWindow.getClient().getName()))
                    j = i;
                // fill the array and increase the index
                tempPlayers[i] = players.getContent();
                players.next();
                i++;
            }
            // move array index to make this client to index 0
            Player[] ordered = new Player[4];
            for (int k = j; k < tempPlayers.length; k++) {
                ordered[k - j] = tempPlayers[k];
            }
            for (int k = 0; k < j; k++) {
                ordered[k - j + tempPlayers.length] = tempPlayers[k];
            }
            tempPlayers = ordered;
        }
        // update players
        if (tempPlayers[1] != null) {
            jTextField8.setText(tempPlayers[1].getName());
            jTextField9.setText(tempPlayers[1].isAlive() ? "Alive" : "Dead");
        }
        if (tempPlayers[2] != null) {
            jTextField10.setText(tempPlayers[2].getName());
            jTextField11.setText(tempPlayers[2].isAlive() ? "Alive" : "Dead");
        }
        if (tempPlayers[3] != null) {
            jTextField12.setText(tempPlayers[3].getName());
            jTextField13.setText(tempPlayers[3].isAlive() ? "Alive" : "Dead");
        }
    }

    public void updatePlacedCard(Card card) {
        jButton9.setIcon(card != null ? new ImageIcon(getClass().getResource("images/" + card.name().toLowerCase() + ".jpg")) : null);
    }

    public void updateCardCounts() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###", new DecimalFormatSymbols(Locale.GERMAN));
        jTextField1.setText(decimalFormat.format(Card.values()[0].getCount()));
        jTextField2.setText(decimalFormat.format(Card.values()[1].getCount()));
        jTextField3.setText(decimalFormat.format(Card.values()[2].getCount()));
        /* jTextField4.setText(decimalFormat.format(Card.DEFUSE.getCount()));
        jTextField5.setText(decimalFormat.format(Card.DEFUSE.getCount()));
        jTextField6.setText(decimalFormat.format(Card.DEFUSE.getCount()));
        jTextField7.setText(decimalFormat.format(Card.DEFUSE.getCount())); */
    }

    public void updateProgress() {
        jProgressBar1.setValue((int) (((float) mainWindow.getClient().getPile() / (float) mainWindow.getClient().getFirstPile()) * 100));
        jProgressBar2.setValue((int) (((float) mainWindow.getClient().getPlaced() / (float) mainWindow.getClient().getFirstPile()) * 100));
    }

    public void markPlayer(String player) {
        // find index for player
        int i = 0;
        for (int j = 0; j < tempPlayers.length; j++) {
            if (tempPlayers[j].getName().equalsIgnoreCase(player)) {
                i = j + 1;
                break;
            }
        }
        // reset previous markers
        resetPlayerMarkers();
        // mark the panel at index i
        switch (i) {
            case 1 -> jPanel1.setBorder(new LineBorder(new Color(255, 0, 0), 15, true));
            case 2 -> jPanel2.setBorder(new LineBorder(new Color(255, 0, 0), 15, true));
            case 3 -> jPanel3.setBorder(new LineBorder(new Color(255, 0, 0), 15, true));
            case 4 -> jPanel4.setBorder(new LineBorder(new Color(255, 0, 0), 15, true));
        }
    }

    public void resetPlayerMarkers() {
        jPanel1.setBorder(new LineBorder(new Color(255, 255, 255), 15, true));
        jPanel2.setBorder(new LineBorder(new Color(255, 255, 255), 15, true));
        jPanel3.setBorder(new LineBorder(new Color(255, 255, 255), 15, true));
        jPanel4.setBorder(new LineBorder(new Color(255, 255, 255), 15, true));
    }

    public void markCard(int i) {
        // reset previous markers
        resetCardMarkers();
        // mark the card at index i
        switch (i) {
            case 1 -> jButton1.setBorder(new LineBorder(new Color(255, 165, 0), 15, true));
            case 2 -> jButton2.setBorder(new LineBorder(new Color(255, 165, 0), 15, true));
            case 3 -> jButton3.setBorder(new LineBorder(new Color(255, 165, 0), 15, true));
            case 4 -> jButton4.setBorder(new LineBorder(new Color(255, 165, 0), 15, true));
            case 5 -> jButton5.setBorder(new LineBorder(new Color(255, 165, 0), 15, true));
            case 6 -> jButton6.setBorder(new LineBorder(new Color(255, 165, 0), 15, true));
            case 7 -> jButton7.setBorder(new LineBorder(new Color(255, 165, 0), 15, true));
        }
    }

    public void resetCardMarkers() {
        jButton1.setBorder(new LineBorder(new Color(255, 255, 255), 15, true));
        jButton2.setBorder(new LineBorder(new Color(255, 255, 255), 15, true));
        jButton3.setBorder(new LineBorder(new Color(255, 255, 255), 15, true));
        jButton4.setBorder(new LineBorder(new Color(255, 255, 255), 15, true));
        jButton5.setBorder(new LineBorder(new Color(255, 255, 255), 15, true));
        jButton6.setBorder(new LineBorder(new Color(255, 255, 255), 15, true));
        jButton7.setBorder(new LineBorder(new Color(255, 255, 255), 15, true));
    }

    public void reset() {
        resetCardMarkers();
        resetPlayerMarkers();
        updatePlacedCard(null);
        // reset cards
        for (Card card : Card.values()) {
            card.setCount(0);
        }
        updateCardCounts();
        updateNamesOrdered(false);
    }

    public MainWindow getMainWindow() {
        return mainWindow;
    }

}
