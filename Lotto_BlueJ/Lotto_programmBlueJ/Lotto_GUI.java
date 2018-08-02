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
public class Lotto_GUI extends JFrame {
  // Anfang Attribute
  private JLabel lTippzahlen1 = new JLabel();
  private JTextField tfNumber2 = new JTextField();
  private JTextField tfNumber1 = new JTextField();
  private JTextField tfNumber3 = new JTextField();
  private JTextField tfNumber4 = new JTextField();
  private JTextField tfNumber5 = new JTextField();
  private JTextField tfNumber6 = new JTextField();
  private JButton btCheckTipp = new JButton();
  private JButton bQuickTipp = new JButton();
  private JTextArea taSorting = new JTextArea("");
    private JScrollPane taSortingScrollPane = new JScrollPane(taSorting);
  private JLabel lbSorting = new JLabel();
  private JButton bSetyonumbers = new JButton();
  private JLabel lbWinningNumbers = new JLabel();
  private JTextArea taWinningNumbers = new JTextArea("");
    private JScrollPane taWinningNumbersScrollPane = new JScrollPane(taWinningNumbers);
  private JButton bDidIWin = new JButton();
  private JTextArea taWin = new JTextArea("");
    private JScrollPane taWinScrollPane = new JScrollPane(taWin);
  private JButton bAgain = new JButton();
  
  
 private Lottomaschine aLottomaschine;
  private Lottoschein aLottoschein;
  private Auswerter auswerter1= new Auswerter(aLottoschein,aLottomaschine);
  private Lottoschein lottoschein1= new Lottoschein();
  private Lottomaschine lottomaschine1= new Lottomaschine();
  
  // Ende Attribute
  
  public Lotto_GUI() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 299; 
    int frameHeight = 413;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Lotto-GUI");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    lTippzahlen1.setBounds(8, 8, 70, 20);
    lTippzahlen1.setText("Tippzahlen:");
    cp.add(lTippzahlen1);
    tfNumber2.setBounds(40, 32, 22, 20);
    cp.add(tfNumber2);
    tfNumber1.setBounds(8, 32, 22, 20);
    cp.add(tfNumber1);
    tfNumber3.setBounds(72, 32, 22, 20);
    cp.add(tfNumber3);
    tfNumber4.setBounds(104, 32, 22, 20);
    cp.add(tfNumber4);
    tfNumber5.setBounds(136, 32, 22, 20);
    cp.add(tfNumber5);
    tfNumber6.setBounds(168, 32, 22, 20);
    cp.add(tfNumber6);
    btCheckTipp.setBounds(8, 56, 75, 25);
    btCheckTipp.setText("Check");
    btCheckTipp.setMargin(new Insets(2, 2, 2, 2));
    btCheckTipp.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btCheckTipp_ActionPerformed(evt);
      }
    });
    cp.add(btCheckTipp);
    bQuickTipp.setBounds(96, 56, 75, 25);
    bQuickTipp.setText("Quick Tipp");
    bQuickTipp.setMargin(new Insets(2, 2, 2, 2));
    bQuickTipp.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bQuickTipp_ActionPerformed(evt);
      }
    });
    cp.add(bQuickTipp);
    taSortingScrollPane.setBounds(8, 112, 176, 20);
    cp.add(taSortingScrollPane);
    lbSorting.setBounds(8, 88, 86, 19);
    lbSorting.setText("Sorting:");
    cp.add(lbSorting);
    bSetyonumbers.setBounds(8, 136, 163, 25);
    bSetyonumbers.setText("Set yo numbers");
    bSetyonumbers.setMargin(new Insets(2, 2, 2, 2));
    bSetyonumbers.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bSetyonumbers_ActionPerformed(evt);
      }
    });
    cp.add(bSetyonumbers);
    lbWinningNumbers.setBounds(8, 184, 110, 20);
    lbWinningNumbers.setText("Winning Numbers:");
    cp.add(lbWinningNumbers);
    taWinningNumbersScrollPane.setBounds(8, 208, 176, 36);
    cp.add(taWinningNumbersScrollPane);
    bDidIWin.setBounds(8, 264, 97, 25);
    bDidIWin.setText("Did I Win?");
    bDidIWin.setMargin(new Insets(2, 2, 2, 2));
    bDidIWin.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bDidIWin_ActionPerformed(evt);
      }
    });
    cp.add(bDidIWin);
    taWinScrollPane.setBounds(8, 296, 129, 25);
    cp.add(taWinScrollPane);
    bAgain.setBounds(8, 336, 161, 25);
    bAgain.setText("Again.....!!!");
    bAgain.setMargin(new Insets(2, 2, 2, 2));
    bAgain.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bAgain_ActionPerformed(evt);
      }
    });
    cp.add(bAgain);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Lotto_GUI
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Lotto_GUI();
  } // end of main
  
  public void btCheckTipp_ActionPerformed(ActionEvent evt) {
    if(!tfNumber1.getText().equals("") && !tfNumber2.getText().equals("") && !tfNumber3.getText().equals("") && !tfNumber4.getText().equals("") && !tfNumber5.getText().equals("") && !tfNumber6.getText().equals(""))
    {
      lottoschein1.uebernehmen(Integer.valueOf(tfNumber1.getText()),Integer.valueOf(tfNumber2.getText()),Integer.valueOf(tfNumber3.getText()),Integer.valueOf(tfNumber4.getText()),Integer.valueOf(tfNumber5.getText()),Integer.valueOf(tfNumber6.getText()));
      if(lottoschein1.pruefeTipp())
      {
          taSorting.setText(lottoschein1.zeigeTippzahlen());
      }
      else
      {
          taSorting.setText("[ERROR] something is wrong");
      }
    }
  } // end of btCheckTipp_ActionPerformed

  public void bQuickTipp_ActionPerformed(ActionEvent evt) {
      lottoschein1.quickTipp();
      tfNumber1.setText(String.valueOf(lottoschein1.getTippzahlen()[0]));
      tfNumber2.setText(String.valueOf(lottoschein1.getTippzahlen()[1]));
      tfNumber3.setText(String.valueOf(lottoschein1.getTippzahlen()[2]));
      tfNumber4.setText(String.valueOf(lottoschein1.getTippzahlen()[3]));
      tfNumber5.setText(String.valueOf(lottoschein1.getTippzahlen()[4]));
      tfNumber6.setText(String.valueOf(lottoschein1.getTippzahlen()[5]));
      taSorting.setText(lottoschein1.zeigeTippzahlen());
  } // end of bQuickTipp_ActionPerformed
  
  public void bSetyonumbers_ActionPerformed(ActionEvent evt) {
    lottomaschine1.zieheZahlen();
    taWinningNumbers.setText(lottomaschine1.zeigeZiehungszahlen());
    
  } // end of bSetyonumbers_ActionPerformed

  public void bDidIWin_ActionPerformed(ActionEvent evt) {
    taWin.setText("You have " + auswerter1.bestimmeGewinnrang() + " matching numbers.");
  } // end of bDidIWin_ActionPerformed

  public void bAgain_ActionPerformed(ActionEvent evt) {
   tfNumber1.setText("");
   tfNumber2.setText("");
   tfNumber3.setText("");
   tfNumber4.setText("");
   tfNumber5.setText("");
   tfNumber6.setText("");
   taWinningNumbers.setText("");
   taWinningNumbers.setText("");
   taSorting.setText(""); 
  } // end of bAgain_ActionPerformed

  // Ende Methoden
} // end of class Lotto_GUI

