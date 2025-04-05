import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Lumin007
 */
public class MainWindow extends JFrame {

    private PopupWindow popupWindow;

    private LoginPanel loginPanel;
    private GamePanel gamePanel;

    private DCClient client;

    public MainWindow(DCClient pClient) {
        client = pClient;

        initComponents();

        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void initComponents() {
        loginPanel = new LoginPanel(this);
        gamePanel = new GamePanel(this);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new CardLayout());
        getContentPane().add(loginPanel, "login");
        getContentPane().add(gamePanel, "game");

        pack();
    }

    public void switchToLogin() {
        ((CardLayout) getContentPane().getLayout()).show(getContentPane(), "login");
    }

    public void switchToGame() {
        ((CardLayout) getContentPane().getLayout()).show(getContentPane(), "game");
    }

    public void popupError(String pError) {
        createPopup();
        popupWindow.switchPanelToError();
        popupWindow.getErrorPopup().setErrorMessage(pError);
    }

    public void popupDeath() {
        createPopup();
        popupWindow.switchPanelToDeath();
    }

    public void popupDefuse() {
        createPopup();
        popupWindow.switchPanelToDefuse();
    }

    private void createPopup() {
        popupWindow = new PopupWindow(this);
        popupWindow.setVisible(true);
    }

    public PopupWindow getPopupWindow() {
        return popupWindow;
    }

    public LoginPanel getLoginPanel() {
        return loginPanel;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public DCClient getClient() {
        return client;
    }

}