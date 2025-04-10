import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Simon
 */
public class FuturePopup extends JPanel {

    private JLabel jLabel11, jLabel12, jPanel13, jLabel3, jLabel1, jLabel2;
    private JButton jButton3;

    private PopupWindow popupWindow;

    public FuturePopup(PopupWindow pPopupWindow) {
        popupWindow = pPopupWindow;

        initComponents();
    }

    private void initComponents() {
        jButton3 = new JButton();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        jPanel13 = new JLabel();
        jLabel3 = new JLabel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();

        jButton3.setBackground(new Color(204, 204, 204));
        jButton3.setFont(new Font("Calibri", 1, 48));
        jButton3.setForeground(new Color(0, 0, 0));
        jButton3.setText("QUIT");
        jButton3.setToolTipText("");
        jButton3.setBorder(new LineBorder(new Color(255, 255, 255), 20, true));
        jButton3.addActionListener(this::onCloseButtonClick);

        jLabel11.setBorder(new LineBorder(new Color(255, 255, 255), 20, true));

        GroupLayout jPanel1Layout = new GroupLayout(jLabel11);
        jLabel11.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 181, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 286, Short.MAX_VALUE)
        );

        jLabel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 20, true));

        javax.swing.GroupLayout jLabel12Layout = new javax.swing.GroupLayout(jLabel12);
        jLabel12.setLayout(jLabel12Layout);
        jLabel12Layout.setHorizontalGroup(
                jLabel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 181, Short.MAX_VALUE)
        );
        jLabel12Layout.setVerticalGroup(
                jLabel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 286, Short.MAX_VALUE)
        );

        jPanel13.setBorder(new LineBorder(new Color(255, 255, 255), 20, true));

        GroupLayout jPanel4Layout = new GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 181, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 286, Short.MAX_VALUE)
        );

        jLabel3.setBackground(new Color(0, 0, 0));
        jLabel3.setFont(new Font("Calibri", 1, 36));
        jLabel3.setForeground(new Color(51, 255, 0));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setText("3");
        jLabel3.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 5));
        jLabel3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        jLabel2.setBackground(new Color(0, 0, 0));
        jLabel2.setFont(new Font("Calibri", 1, 36));
        jLabel2.setForeground(new Color(51, 255, 0));
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText("2");
        jLabel2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 5));
        jLabel2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        jLabel1.setBackground(new Color(0, 0, 0));
        jLabel1.setFont(new Font("Calibri", 1, 36));
        jLabel1.setForeground(new Color(51, 255, 0));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("1");
        jLabel1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 5));
        jLabel1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(177, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
                                                .addGap(34, 34, 34)
                                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(34, 34, 34)
                                                .addComponent(jPanel13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(200, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(83, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel13, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(104, 104, 104)
                                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97))
        );
    }

    private void onCloseButtonClick(ActionEvent evt) {
        popupWindow.dispose();
    }

    /**
     * Setzt die Karten, die angezeigt werden sollen
     *
     * @param cards die Karten (Länge des Arrays: 0 - 3)
     */
    public void setCards(Card[] cards) {
        jLabel12.setIcon(cards.length >= 3 ? new ImageIcon(getClass().getResource("images/" + cards[2].name().toLowerCase() + ".jpg")) : null);
        jLabel11.setIcon(cards.length >= 2 ? new ImageIcon(getClass().getResource("images/" + cards[1].name().toLowerCase() + ".jpg")): null);
        jPanel13.setIcon(cards.length >= 1 ? new ImageIcon(getClass().getResource("images/" + cards[0].name().toLowerCase() + ".jpg")): null);
    }

}