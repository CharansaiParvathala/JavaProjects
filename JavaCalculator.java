import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Main implements ActionListener {

  JFrame frame;
  JTextField textField;
  JButton[] numbers = new JButton[10];
  JButton[] functions = new JButton[9];
  JButton ad,clr,sub,mul,div,de,equ,sqr,dec;
  JPanel panel;
  double n1=0,n2=0,res=0;
  char op;
  int i=0;
  boolean f=false;
  public Main()
  {
    
    frame = new JFrame("Calculator");
    frame.setSize(390,550);
    frame.setLayout(null);

    panel = new JPanel();
    panel.setBounds(40,120,310,390);
    panel.setLayout(new GridLayout(5,4,10,10));

    textField = new JTextField();
    textField.setBounds(40,20,310,70);
    textField.setEditable(false);

    ad = new JButton("+");
    sub = new JButton("-");
    div = new JButton("/");
    mul = new JButton("*");
    sqr = new JButton("Pow");
    equ = new JButton("=");
    clr = new JButton("Clr");
    de = new JButton("Del");
    dec = new JButton(".");

    functions[0] = ad;
    functions[1] = sub;
    functions[2] = div;
    functions[3] = mul;
    functions[4] = sqr;
    functions[5] = equ;
    functions[6] = clr;
    functions[7] = de;
    functions[8] = dec;

    for(i = 0; i < 9; i++)
      {
        functions[i].addActionListener(this);
      }

    for(i = 0; i < 10; i++)
      {
        numbers[i] = new JButton(Integer.toString(i));
        numbers[i].addActionListener(this);
      }

    panel.add(clr);
    panel.add(de);
    panel.add(sqr);
    panel.add(div);
    panel.add(numbers[1]);
    panel.add(numbers[2]);
    panel.add(numbers[3]);
    panel.add(mul);
    panel.add(numbers[4]);
    panel.add(numbers[5]);
    panel.add(numbers[6]);
    panel.add(sub);
    panel.add(numbers[7]);
    panel.add(numbers[8]);
    panel.add(numbers[9]);
    panel.add(ad);
    panel.add(dec);
    panel.add(numbers[0]);

    frame.add(equ);
    equ.setBounds(200,440,150,70);
    frame.add(panel);
    frame.add(textField);
    frame.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    for(i=0;i<10;i++)
      {
        if(e.getSource()==numbers[i])
        {
textField.setText(textField.getText()+(Integer.toString(i)));
          f=false;
        }
      }
    if(e.getSource()==ad||e.getSource()==mul||e.getSource()==div||e.getSource()==sub||e.getSource()==sqr)
    {
  String checkOp=textField.getText();
if(checkOp.contains("+")||checkOp.contains("-")||checkOp.contains("*")||checkOp.contains("/")||checkOp.contains("^"))
{
JOptionPane.showMessageDialog(frame,"Enter Number","Operator Error",JOptionPane.ERROR_MESSAGE);
      f=true;
    }
    }
    if(e.getSource()==ad&&f==false)
    {
      op='+';
n1=Double.parseDouble(textField.getText());
textField.setText(textField.getText()+op);
        f=true;
    }
    if(e.getSource()==sub&&f==false)
    {
        op='-';
      n1=Double.parseDouble(textField.getText());
      textField.setText(textField.getText()+op);
        f=true;
    }
    if(e.getSource()==div&&f==false)
    {
        op='/';
      n1=Double.parseDouble(textField.getText());
      textField.setText(textField.getText()+op);
        f=true;
    } 
    if(e.getSource()==mul&&f==false)
    {
          op='*';
        n1=Double.parseDouble(textField.getText());
        textField.setText(textField.getText()+op);
          f=true;
    }
    if(e.getSource()==sqr&&f==false)
    {
          op='^';
        n1=Double.parseDouble(textField.getText());
        textField.setText(textField.getText()+op);
          f=true;
    }
    if (e.getSource() == dec) {
      String check = textField.getText();
        if (check.contains(String.valueOf(op))) {
            check = check.substring(check.indexOf(String.valueOf(op)) + 1, check.length());
        }
      if (check.contains(".")) {
            JOptionPane.showMessageDialog(frame, "Two Decimals Are Not Allowed", "Decimal Error", JOptionPane.ERROR_MESSAGE);
      }
      else
textField.setText(textField.getText() + ".");
    }

if(e.getSource()==equ)
{
  String s2=textField.getText();
s2=s2.substring(s2.indexOf(op)+1,s2.length());
  n2=Double.parseDouble(s2);
  switch(op)
    {
      case '+': res=n1+n2;
        break;
      case '-': res=n1-n2;
        break;
      case '/': 
        if(n2==0)
  JOptionPane.showMessageDialog(panel,"Invalid Division","Error",JOptionPane.ERROR_MESSAGE);
        else
        res=n1/n2;
        break;
      case '*': res=n1*n2;
        break;
      case '^': res=Math.pow(n1,n2);
        break;
    }
  textField.setText("");
  textField.setText(Double.toString(res));
  if(res==0)
    textField.setText("0");
  else
textField.setText(Double.toString(res));
  n1=res;
}
    if(e.getSource()==clr)
    {
      textField.setText("");
    }
    if(e.getSource()==de)
    {
      String s = textField.getText();
      if(s.length()>0)
textField.setText(s.substring(0,s.length()-1));
    }
 }
  
  public static void main(String[] args)
  {  Main obj = new Main(); }
}