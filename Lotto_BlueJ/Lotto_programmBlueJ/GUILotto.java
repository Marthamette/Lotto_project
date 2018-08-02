import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 21.03.2018
  * @author 
  */

public class GUILotto extends JFrame {
  // Anfang Attribute
  private JLabel lb_tippNumbers = new JLabel();
  private JTextField tf_number1 = new JTextField();
  private JTextField tf_number2 = new JTextField();
  private JTextField tf_number3 = new JTextField();
  private JTextField tf_number4 = new JTextField();
  private JTextField tf_number5 = new JTextField();
  private JTextField tf_number6 = new JTextField();
  private JButton bt_checkNumbers = new JButton();
  private JButton bt_quicktipp = new JButton();
  private JLabel lb_tippNumbersSort = new JLabel();
  private JTextArea ta_sortNumbers = new JTextArea("");
    private JScrollPane ta_sortNumbersScrollPane = new JScrollPane(ta_sortNumbers);
  private JButton bt_takeNumbers = new JButton();
  private JLabel lb_lottoNumbersSort1 = new JLabel();
  private JTextArea ta_sortLottoNumbers = new JTextArea("");
    private JScrollPane ta_sortLottoNumbersScrollPane = new JScrollPane(ta_sortLottoNumbers);
  private JButton bt_checkWin = new JButton();
  private JTextArea ta_winningOutput = new JTextArea("");
    private JScrollPane ta_winningOutputScrollPane = new JScrollPane(ta_winningOutput);
  private JButton bt_again = new JButton();
  private Lottoschein ls = new Lottoschein();
  private Lottomaschine lm = new Lottomaschine();
  private Auswerter aw = new Auswerter(ls,lm);
  // Ende Attribute
  
  public GUILotto(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 354; 
    int frameHeight = 433;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    this.setTitle("MEAG Lotto SPIEL 9000");
    // Anfang Komponente
    lb_tippNumbers.setBounds(8, 8, 68, 25);
    lb_tippNumbers.setText("Tippzahlen:");
    cp.add(lb_tippNumbers);
    tf_number1.setBounds(8, 40, 41, 25);
    cp.add(tf_number1);
    tf_number2.setBounds(64, 40, 41, 25);
    cp.add(tf_number2);
    tf_number3.setBounds(120, 40, 41, 25);
    cp.add(tf_number3);
    tf_number4.setBounds(176, 40, 41, 25);
    cp.add(tf_number4);
    tf_number5.setBounds(232, 40, 41, 25);
    cp.add(tf_number5);
    tf_number6.setBounds(288, 40, 41, 25);
    cp.add(tf_number6);
    bt_checkNumbers.setBounds(8, 72, 153, 33);
    bt_checkNumbers.setText("Prüfe Tippzahlen");
    bt_checkNumbers.setMargin(new Insets(2, 2, 2, 2));
    bt_checkNumbers.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bt_checkNumbers_ActionPerformed(evt);
      }
    });
    cp.add(bt_checkNumbers);
    bt_quicktipp.setBounds(176, 72, 153, 33);
    bt_quicktipp.setText("Quicktipp");
    bt_quicktipp.setMargin(new Insets(2, 2, 2, 2));
    bt_quicktipp.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bt_quicktipp_ActionPerformed(evt);
      }
    });
    cp.add(bt_quicktipp);
    lb_tippNumbersSort.setBounds(8, 112, 114, 25);
    lb_tippNumbersSort.setText("Tippzahlen sortiert:");
    cp.add(lb_tippNumbersSort);
    ta_sortNumbersScrollPane.setBounds(8, 144, 321, 25);
    ta_sortNumbers.setEditable(false);
    cp.add(ta_sortNumbersScrollPane);
    bt_takeNumbers.setBounds(8, 176, 321, 33);
    bt_takeNumbers.setText("Ziehe Lottozahlen");
    bt_takeNumbers.setMargin(new Insets(2, 2, 2, 2));
    bt_takeNumbers.setEnabled(false);
    bt_takeNumbers.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bt_takeNumbers_ActionPerformed(evt);
      }
    });
    cp.add(bt_takeNumbers);
    lb_lottoNumbersSort1.setBounds(8, 216, 118, 25);
    lb_lottoNumbersSort1.setText("Lottozahlen sortiert:");
    cp.add(lb_lottoNumbersSort1);
    ta_sortLottoNumbersScrollPane.setBounds(8, 248, 321, 25);
    ta_sortLottoNumbers.setEditable(false);
    cp.add(ta_sortLottoNumbersScrollPane);
    bt_checkWin.setBounds(8, 280, 321, 33);
    bt_checkWin.setText("Bestimme den Gewinnbetrag");
    bt_checkWin.setMargin(new Insets(2, 2, 2, 2));
    bt_checkWin.setEnabled(false);
    bt_checkWin.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bt_checkWin_ActionPerformed(evt);
      }
    });
    cp.add(bt_checkWin);
    ta_winningOutputScrollPane.setBounds(8, 320, 321, 25);
    ta_winningOutput.setEditable(false);
    cp.add(ta_winningOutputScrollPane);
    bt_again.setBounds(88, 352, 161, 33);
    bt_again.setText("Nochmal");
    bt_again.setMargin(new Insets(2, 2, 2, 2));
    bt_again.setEnabled(false);
    bt_again.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bt_again_ActionPerformed(evt);
      }
    });
    cp.add(bt_again);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public GUILotto
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new GUILotto("GUILotto");
  } // end of main
  
  public void bt_checkNumbers_ActionPerformed(ActionEvent evt) {
      if(!tf_number1.getText().equals("") && !tf_number2.getText().equals("") && !tf_number3.getText().equals("") && !tf_number4.getText().equals("") && !tf_number5.getText().equals("") && !tf_number6.getText().equals(""))
      {
      ls.uebernehmen(Integer.valueOf(tf_number1.getText()),Integer.valueOf(tf_number2.getText()),Integer.valueOf(tf_number3.getText()),Integer.valueOf(tf_number4.getText()),Integer.valueOf(tf_number5.getText()),Integer.valueOf(tf_number6.getText()));
      if(ls.pruefeTipp())
      {
          ta_sortNumbers.setText(ls.zeigeTippzahlen());
          bt_takeNumbers.setEnabled(true);
      }
      else
      {
          ta_sortNumbers.setText("[ERROR] something is wrong");
          bt_takeNumbers.setEnabled(false);
      }
    }
  } // end of bt_checkNumbers_ActionPerformed

  public void bt_quicktipp_ActionPerformed(ActionEvent evt) {
      ls.quickTipp();
      tf_number1.setText(String.valueOf(ls.getTippzahlen()[0]));
      tf_number2.setText(String.valueOf(ls.getTippzahlen()[1]));
      tf_number3.setText(String.valueOf(ls.getTippzahlen()[2]));
      tf_number4.setText(String.valueOf(ls.getTippzahlen()[3]));
      tf_number5.setText(String.valueOf(ls.getTippzahlen()[4]));
      tf_number6.setText(String.valueOf(ls.getTippzahlen()[5]));
      ta_sortNumbers.setText(ls.zeigeTippzahlen());
      bt_takeNumbers.setEnabled(true);
  } // end of bt_quicktipp_ActionPerformed

  public void bt_takeNumbers_ActionPerformed(ActionEvent evt) {
      lm.zieheZahlen();
      ta_sortLottoNumbers.setText(lm.zeigeZiehungszahlen());
      bt_takeNumbers.setEnabled(false);
      bt_checkNumbers.setEnabled(false);
      bt_quicktipp.setEnabled(false);
      tf_number1.setEditable(false);
      tf_number2.setEditable(false);
      tf_number3.setEditable(false);
      tf_number4.setEditable(false);
      tf_number5.setEditable(false);
      tf_number6.setEditable(false);
      bt_checkWin.setEnabled(true);
  } // end of bt_takeNumbers_ActionPerformed

  public void bt_checkWin_ActionPerformed(ActionEvent evt) {
      bt_again.setEnabled(true);
      bt_checkWin.setEnabled(false);
      ta_winningOutput.setText("You have " + aw.bestimmeGewinnrang() + " matching numbers.");
  } // end of bt_checkWin_ActionPerformed

  public void bt_again_ActionPerformed(ActionEvent evt) {
      bt_checkNumbers.setEnabled(true);
      bt_quicktipp.setEnabled(true);
      bt_again.setEnabled(false);
      tf_number1.setEditable(true);
      tf_number2.setEditable(true);
      tf_number3.setEditable(true);
      tf_number4.setEditable(true);
      tf_number5.setEditable(true);
      tf_number6.setEditable(true);
      tf_number1.setText("");
      tf_number2.setText("");
      tf_number3.setText("");
      tf_number4.setText("");
      tf_number5.setText("");
      tf_number6.setText("");
      ta_winningOutput.setText("");
      ta_sortLottoNumbers.setText("");
      ta_sortNumbers.setText("");
  } // end of bt_again_ActionPerformed

  // Ende Methoden
} // end of class GUILotto