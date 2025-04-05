import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author Simon
 */
public class DefusePopup extends JPanel {

    private PopupWindow popupWindow;

    private JTextField jTextField1, jTextField2;
    private JButton jButton3;
    private JSlider jSlider1;
    private JLabel jLabel1;

    private WindowListener windowListener;

    public DefusePopup(PopupWindow pPopupWindow) {
        popupWindow = pPopupWindow;

        initComponents();

        windowListener = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);

                popupWindow.getMainWindow().getClient().defuseCard(jSlider1.getValue());
            }

        };
    }

    private void initComponents() {
        jLabel1 = new JLabel();
        jButton3 = new JButton();
        jSlider1 = new JSlider();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();

        jLabel1.setBackground(new Color(0, 0, 0));
        jLabel1.setFont(new Font("Calibri", 1, 36));
        jLabel1.setForeground(new Color(51, 255, 0));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("YOU DEFUSED");
        jLabel1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 5));
        jLabel1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        jButton3.setBackground(new Color(204, 204, 204));
        jButton3.setFont(new Font("Calibri", 1, 48));
        jButton3.setForeground(new Color(0, 0, 0));
        jButton3.setText("INSERT BOMB");
        jButton3.setToolTipText("");
        jButton3.setBorder(new LineBorder(new Color(255, 255, 255), 20, true));
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jTextField1.setText("TOP");
        jTextField1.setEditable(false);
        jTextField1.addActionListener(this::jTextField1ActionPerformed);

        jTextField2.setText("BOTTOM");
        jTextField2.setEditable(false);
        jTextField2.addActionListener(this::jTextField2ActionPerformed);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
                                        .addComponent(jSlider1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(426, 426, 426)
                                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(439, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(328, Short.MAX_VALUE)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jSlider1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(108, 108, 108)
                                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79))
        );
    }

    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);

        if (aFlag) {
            popupWindow.addWindowListener(windowListener);
        } else {
            popupWindow.removeWindowListener(windowListener);
        }
    }

    private void jButton3ActionPerformed(ActionEvent evt) {
        popupWindow.getMainWindow().getClient().defuseCard(jSlider1.getValue());
        popupWindow.dispose();
    }

    private void jTextField1ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField2ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    public PopupWindow getPopupWindow() {
        return popupWindow;
    }

}
