import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Lumin007
 */
public class PopupWindow extends JFrame {

    private DeathPopup deathPopup;
    private DefusePopup defusePopup;
    private ErrorPopup errorPopup;

    private MainWindow mainWindow;

    public PopupWindow(MainWindow pMainWindow) {
        mainWindow = pMainWindow;

        initComponents();

        setLocationRelativeTo(null);
    }

    private void initComponents() {
        deathPopup = new DeathPopup(this);
        errorPopup = new ErrorPopup(this);
        defusePopup = new DefusePopup(this);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new CardLayout());
        getContentPane().add(deathPopup, "death");
        getContentPane().add(errorPopup, "error");
        getContentPane().add(defusePopup, "defuse");

        pack();
    }

    public void switchPanelToDeath() {
        ((CardLayout) getContentPane().getLayout()).show(getContentPane(), "death");
    }

    public void switchPanelToError() {
        ((CardLayout) getContentPane().getLayout()).show(getContentPane(), "error");
    }

    public void switchPanelToDefuse() {
        ((CardLayout) getContentPane().getLayout()).show(getContentPane(), "defuse");
    }

    public DeathPopup getDeathPopup() {
        return deathPopup;
    }

    public DefusePopup getDefusePopup() {
        return defusePopup;
    }

    public ErrorPopup getErrorPopup() {
        return errorPopup;
    }

    public MainWindow getMainWindow() {
        return mainWindow;
    }

}