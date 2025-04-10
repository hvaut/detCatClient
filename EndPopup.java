import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author Simon
 */
public class EndPopup extends JPanel {

    private PopupWindow popupWindow;

    private JButton jButton3;
    private JLabel jLabel1;

    public EndPopup(PopupWindow pPopupWindow) {
        popupWindow = pPopupWindow;

        initComponents();
    }

    private void initComponents() {
        jLabel1 = new JLabel();
        jButton3 = new JButton();

        jLabel1.setBackground(new Color(0, 0, 0));
        jLabel1.setFont(new Font("Calibri", 1, 36));
        jLabel1.setForeground(new Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("");
        jLabel1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 5));
        jLabel1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        jButton3.setBackground(new Color(204, 204, 204));
        jButton3.setFont(new Font("Calibri", 1, 48));
        jButton3.setForeground(new Color(0, 0, 0));
        jButton3.setText("QUIT");
        jButton3.setToolTipText("");
        jButton3.setBorder(new LineBorder(new Color(255, 255, 255), 20, true));
        jButton3.addActionListener(this::jButton3ActionPerformed);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(297, Short.MAX_VALUE)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 662, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(297, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(328, Short.MAX_VALUE)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                .addGap(212, 212, 212)
                                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76))
        );
    }

    private void jButton3ActionPerformed(ActionEvent evt) {
        popupWindow.dispose();
    }

    /**
     * Setzt den Modus des Fensters
     * 0 = Todesfenster
     * 1 = Siegerfenster
     *
     * @param id der Modus (0 - 1)
     */
    public void setMode(int id) {
        switch (id) {
            case 0 -> {
                jLabel1.setText("YOU EXPLODED");
                jLabel1.setForeground(new Color(255, 0, 0));
            }
            case 1 -> {
                jLabel1.setText("YOU WON");
                jLabel1.setForeground(new Color(0, 255, 0));
            }
        }
    }

}
