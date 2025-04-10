import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Lumin007
 */
public class PopupWindow extends JFrame {

    private EndPopup endPopup;
    private DefusePopup defusePopup;
    private FuturePopup futurePopup;
    private ErrorPopup errorPopup;

    private MainWindow mainWindow;

    public PopupWindow(MainWindow pMainWindow) {
        mainWindow = pMainWindow;

        initComponents();

        setLocationRelativeTo(null);
    }

    private void initComponents() {
        endPopup = new EndPopup(this);
        errorPopup = new ErrorPopup(this);
        defusePopup = new DefusePopup(this);
        futurePopup = new FuturePopup(this);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new CardLayout());
        getContentPane().add(endPopup, "end");
        getContentPane().add(errorPopup, "error");
        getContentPane().add(defusePopup, "defuse");
        getContentPane().add(futurePopup, "future");

        pack();
    }

    /**
     * Setzt das aktuelle Fenster auf End
     */
    public void switchPanelToEnd() {
        ((CardLayout) getContentPane().getLayout()).show(getContentPane(), "end");
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
     * Setzt das aktuelle Fenster auf Future
     */
    public void switchPanelToFuture() {
        ((CardLayout) getContentPane().getLayout()).show(getContentPane(), "future");
    }

    /**
     * Gibt das Todesfenster bzw. Siegerfenster zurück
     *
     * @return das Todesfenster bzw. Siegerfenster
     */
    public EndPopup getEndPopup() {
        return endPopup;
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
     * Gibt das Zukunftssfenster zurück
     *
     * @return das Zukunftssfenster
     */
    public FuturePopup getFuturePopup() {
        return futurePopup;
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