import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;
public class JavaGuessingGame implements ActionListener {

  JFrame frame;
  JTextField textField,notice;
  JButton[] numbers = new JButton[10];
  JButton check,del,clr;
  JPanel panel;
  static int r,x;
  int i=0,f=0;
  public JavaGuessingGame()
  {

    Random rand = new Random();
    r=rand.nextInt(100)+1;

    frame = new JFrame("Calculator");
    frame.setSize(390,550);
    frame.setLayout(null);

    panel = new JPanel();
    panel.setBounds(40,130,310,300);
    panel.setLayout(new GridLayout(4,3,10,10));

    textField = new JTextField();
    textField.setBounds(40,10,310,60);
    textField.setEditable(false);

    notice = new JTextField("                         Start guessing!");
    notice.setBounds(40,80,310,40);
    notice.setEditable(false);

    check = new JButton("CHECK");
    check.addActionListener(this);
    del = new JButton("DEL");
    del.addActionListener(this);
    clr = new JButton("CLR");
    clr.addActionListener(this);
    
    for(i = 0; i < 10; i++)
      {
        numbers[i] = new JButton(Integer.toString(i));
        numbers[i].addActionListener(this);
      }

    panel.add(numbers[1]);
    panel.add(numbers[2]);
    panel.add(numbers[3]);
    panel.add(numbers[4]);
    panel.add(numbers[5]);
    panel.add(numbers[6]);
    panel.add(numbers[7]);
    panel.add(numbers[8]);
    panel.add(numbers[9]);
    panel.add(numbers[0]);
    panel.add(del);
    panel.add(clr);
    
    frame.add(check);
    check.setBounds(40,450,310,70);
    frame.add(panel);
    frame.add(textField);
    frame.add(notice);
    frame.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    for(i=0;i<10;i++)
      {
        if(f==0)
        {
        if(e.getSource()==numbers[i])
        {
textField.setText(textField.getText()+(Integer.toString(i)));
        }
        }
        else
        {
          JOptionPane.showMessageDialog(panel,"Do You Want To Restart The Game");
          textField.setText("");
Random rand = new Random();
          notice.setText("                             Guess Again");
          r=rand.nextInt(100)+1;
          f=0;
        }
          
      }

    if(e.getSource()==del)
      {
        String s = textField.getText();
        if(s.length()>0)
    textField.setText(s.substring(0,s.length()-1));
      }

    if(e.getSource()==clr)
    {
      textField.setText("");
    }

    if(e.getSource()==check)
    {
      String s = textField.getText();
      textField.setText("");
      x = Integer.parseInt(s);
      if(x==r)
      {
        notice.setText("                  *******___Correct___*******");
        textField.setText("      ***Congratulations You Won The Game***");
        f=1;
      }
      else if(x>r)
      {
        notice.setText("               *****Your guess is High*****");
      }
      else
      {
        notice.setText("               *****Your guess is Low****");
      }
      }
    }

  public static void main(String[] args)
  {
    JavaGuessingGame obj = new JavaGuessingGame(); 
  }
}
