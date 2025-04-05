import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author Simon
 */
public class ErrorPopup extends JPanel {

    private PopupWindow popupWindow;

    private JScrollPane jScrollPane1;
    private JButton jButton3;
    private JLabel jLabel1, jLabel2;

    public ErrorPopup(PopupWindow pPopupWindow) {
        popupWindow = pPopupWindow;

        initComponents();
    }

    private void initComponents() {
        jScrollPane1 = new JScrollPane();
        jLabel2 = new JLabel();
        jLabel1 = new JLabel();
        jButton3 = new JButton();

        jLabel2.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0), 10));
        jScrollPane1.setViewportView(jLabel2);
        jLabel2.setFont(new Font("Arial", Font.PLAIN, 40));
        jLabel2.setText("");

        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setVerticalAlignment(SwingConstants.CENTER);

        jLabel1.setBackground(new Color(0, 0, 0));
        jLabel1.setFont(new Font("Calibri", 1, 36));
        jLabel1.setForeground(new Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("ERROR");
        jLabel1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 5));
        jLabel1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        jButton3.setBackground(new Color(204, 204, 204));
        jButton3.setFont(new Font("Calibri", 1, 48));
        jButton3.setForeground(new Color(0, 0, 0));
        jButton3.setText("CLOSE");
        jButton3.setToolTipText("");
        jButton3.setBorder(new LineBorder(new Color(255, 255, 255), 20, true));
        jButton3.addActionListener(this::onCloseButtonClick);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
                                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(429, Short.MAX_VALUE)
                                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(429, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(29, Short.MAX_VALUE)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 477, GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))
        );
    }

    private void onCloseButtonClick(ActionEvent evt) {
        popupWindow.dispose();
    }

    public void setErrorMessage(String message) {
        jLabel2.setText("<html>" + message + "</html>");
    }

    public PopupWindow getPopupWindow() {
        return popupWindow;
    }

}
