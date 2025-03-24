/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.awt.CardLayout;
/**
 *
 * @author Lumin007 & tali-yuh
 */
public class MainGui extends javax.swing.JFrame
{

    /**
     * Creates new form DetonatingCats
     */
    public MainGui()
    {
        initComponents();
        initializeEvents();
    }

    /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents()
    {

        loginWindow1 = new LoginWindow();
        mainWindow2 = new MainWindow();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());
        getContentPane().add(loginWindow1, "card1");
        getContentPane().add(mainWindow2, "card2");

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->
                {
                    new MainGui().setVisible(true);
            });
    }

    // Variables declaration - do not modify                     
    private LoginWindow loginWindow1;
    private MainWindow mainWindow2;
    // End of variables declaration                   
    private int akt = 1;
    boolean io = false;
    
    /**
     * switcht zwischen den Pannels
     */
    void switchPanel()
    {   
        login();
        if (io == true){if (akt == 1){
                akt++;
            }else{
                akt--;
            }
            ((CardLayout) getContentPane().getLayout()).show(getContentPane(), "card"+akt);
        }

    }

    /**
     * initialisiert die Pannels
     */
    private void initializeEvents()
    {
        loginWindow1.setMg(this);
        mainWindow2.setMg(this);
    }
    
    /**
     * Updated die GUI
     */
    public void guiUpdate(){
        mainWindow2.next();
        mainWindow2.setCards();
        mainWindow2.getTotalCrads();
    }

    /**
     * für die Spieleranzeige in der GUI
     */
    public String getPlayers(){
        String p1 = "Bob";
        String p2 = "Lumin007";
        String p3 = "Ross";
        return p1+"-"+p2+"-"+p3;
    }
    
    /**
     * Anzahl der Karten aller Spieler
     */
    public String getPCards(){
        int p1 = 1;
        int p2 = 2;
        int p3 = 3;
        return p1+"-"+p2+"-"+p3;
    }
    int i = 1;
    public int next(){
        if (i == 4){i = 1;}else{i++;}
        return i;
    }

    public String place(){
        String akt = mainWindow2.aktCrad();
        return akt;
    }
    int stack = 78;
    int aktStack = stack;
    public int progress(){
        double count = (double)stack/aktStack*100;
        int a = (int) Math.round(count);
        stack--;
        return (a);
    }
    String pName;
    String code;
    boolean loggedin = false;
    /**
     * Für den Loginprozess der GUI
     */
    public void login()
    {
        pName = loginWindow1.getPName();
        code = loginWindow1.getCode();
        mainWindow2.setName();
        mainWindow2.setUiCards();
        guiUpdate();
        mainWindow2.setName();
        mainWindow2.setCards();
        mainWindow2.showProgress();
        loggedin = true;
        if (pName.isEmpty() == true | code.isEmpty() == true){
            io = false;
        }else{
            io = true;
        }
        loginWindow1.loginError();
    }

    public int loginError (){
        if(pName.isEmpty() == true){
            return 1;
        }
        if(code.isEmpty() == true){
            return 2;
        }
        if(pName.isEmpty() == false && code.isEmpty() == false){
            return 0;
        }else return -1;
    }
    /**
     * Zieht karte nach
     */
    public String pull(){
        return"";
    }
    // für daten übergabe(Client)
    /**
     * Gibt die gesamte Karten Anzahl
     */
    public int getTotalCards(){
        int a = mainWindow2.getTotalCrads();
        return a;
    }
    /**
     * Gibt den Namen
     */
    public String getPName(){
        return pName;
    }
    /**
     * Gibt den Code
     */
    public int getCode(){
        int a = Integer.parseInt(code);
        return a;
    }
}
