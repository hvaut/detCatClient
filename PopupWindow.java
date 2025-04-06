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

    /**
     * Setzt das aktuelle Fenster auf Death
     */
    public void switchPanelToDeath() {
        ((CardLayout) getContentPane().getLayout()).show(getContentPane(), "death");
    }

    /**
     * Setzt das aktuelle Fenster auf Error
     */
    public void switchPanelToError() {
        ((CardLayout) getContentPane().getLayout()).show(getContentPane(), "error");
    }

    /**
     * Setzt das aktuelle Fenster auf Defuse
     */
    public void switchPanelToDefuse() {
        ((CardLayout) getContentPane().getLayout()).show(getContentPane(), "defuse");
    }

    /**
     * Gibt das Todesfenster zurück
     *
     * @return das Todesfenster
     */
    public DeathPopup getDeathPopup() {
        return deathPopup;
    }

    /**
     * Gibt das Entschärfungsfenster zurück
     *
     * @return das Entschärfungsfenster
     */
    public DefusePopup getDefusePopup() {
        return defusePopup;
    }

    /**
     * Gibt das Fehlerfenster zurück
     *
     * @return das Fehlerfenster
     */
    public ErrorPopup getErrorPopup() {
        return errorPopup;
    }

    /**
     * Gibt das Hauptfenster zurück
     *
     * @return das Hauptfenster
     */
    public MainWindow getMainWindow() {
        return mainWindow;
    }

}