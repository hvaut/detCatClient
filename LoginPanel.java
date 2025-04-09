import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author Lumin007
 *
 */
public class LoginPanel extends JPanel {

    private JTextField jTextField1, jTextField2;
    private JButton jButton1, jButton2;
    private JLabel jLabel2, jLabel3;

    private MainWindow mainWindow;

    public LoginPanel(MainWindow pMainWindow) {
        mainWindow = pMainWindow;
        
        initComponents();
    }
    
    private void initComponents() {
        jLabel2 = new JLabel();
        jTextField1 = new JTextField();
        jLabel3 = new JLabel();
        jTextField2 = new JTextField();
        jButton1 = new JButton();
        jButton2 = new JButton();

        jLabel2.setBackground(new Color(255, 255, 255));
        jLabel2.setFont(jLabel2.getFont().deriveFont(jLabel2.getFont().getStyle() | Font.BOLD, jLabel2.getFont().getSize() + 24));
        jLabel2.setForeground(new Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText("Enter Name:");
        jLabel2.setToolTipText("");
        jLabel2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3));
        jLabel2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        jTextField1.setBackground(new Color(204, 204, 204));
        jTextField1.setFont(new Font("Segoe UI", 1, 36));
        jTextField1.setForeground(new Color(0, 0, 0));
        jTextField1.setHorizontalAlignment(JTextField.CENTER);
        jTextField1.setToolTipText("Enter Name");
        jTextField1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3));
        jTextField1.setCaretColor(new Color(0, 0, 0));
        jTextField1.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        jTextField1.addActionListener(this::jTextField1ActionPerformed);

        jLabel3.setBackground(new Color(255, 255, 255));
        jLabel3.setFont(jLabel3.getFont().deriveFont(jLabel3.getFont().getStyle() | Font.BOLD, jLabel3.getFont().getSize() + 24));
        jLabel3.setForeground(new Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setText("Enter Code:");
        jLabel3.setToolTipText("Enter Code:");
        jLabel3.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3));
        jLabel3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        jTextField2.setBackground(new Color(204, 204, 204));
        jTextField2.setFont(new Font("Segoe UI", 1, 36));
        jTextField2.setForeground(new Color(0, 0, 0));
        jTextField2.setHorizontalAlignment(JTextField.CENTER);
        jTextField2.setToolTipText("Enter Code");
        jTextField2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3));
        jTextField2.setCaretColor(new Color(0, 0, 0));

        jButton1.setBackground(new Color(255, 255, 255));
        jButton1.setFont(new Font("Calibri", 1, 36));
        jButton1.setForeground(new Color(0, 0, 0));
        jButton1.setText("Host");
        jButton1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        jButton1.addActionListener(this::onHostButtonClicked);

        jButton2.setBackground(new Color(255, 255, 255));
        jButton2.setFont(new Font("Calibri", 1, 36));
        jButton2.setForeground(new Color(0, 0, 0));
        jButton2.setText("Join");
        jButton2.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        jButton2.addActionListener(this::onJoinButtonClicked);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 2232, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap(577, Short.MAX_VALUE)
                                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jTextField1)
                                                .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel3, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTextField2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 800, GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(577, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 928, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap(126, Short.MAX_VALUE)
                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 339, Short.MAX_VALUE)
                                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTextField2)
                                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(127, Short.MAX_VALUE)))
        );
    }

    private void jTextField1ActionPerformed(ActionEvent evt) {
        // ignored
    }

    private void jTextField2ActionPerformed(ActionEvent evt) {
        // ignored
    }

    private void onHostButtonClicked(ActionEvent evt) {
        if (validateFields()) {
            mainWindow.getClient().setName(jTextField1.getText());
            mainWindow.getClient().hostGame(jTextField2.getText());
        }
    }

    private void onJoinButtonClicked(ActionEvent evt) {
        if (validateFields()) {
            mainWindow.getClient().setName(jTextField1.getText());
            mainWindow.getClient().joinGame(jTextField2.getText());
        }
    }

    private boolean validateFields() {
        boolean valid = true;
        // clear previous marks
        loginError(0);
        // check for name issues
        if (jTextField1.getText().isBlank()) {
            loginError(1);
            valid = false;
        }
        // check for code issues
        if (jTextField2.getText().isBlank()) {
            loginError(2);
            valid = false;
        }
        return valid;
    }

    private void loginError(int loginError) {
        switch (loginError) {
            case 1 -> jTextField1.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0), 3));
            case 2 -> jTextField2.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0), 3));
            case 0 -> {
                jTextField1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3));
                jTextField2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3));
            }
        }
    }

}
