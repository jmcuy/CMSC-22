
import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import  java.lang.*;
import  java.math.*;

/**
 * Created by jhessa on 02/11/2016.
 */
public class Cal extends JFrame {

    private JButton two = new JButton("2");
    private JButton zero = new JButton("0");
    private JButton three = new JButton("3");
    private JButton five = new JButton("5");
    private JButton six = new JButton("6");
    private JButton times = new JButton("x");
    private JButton eight = new JButton("8");
    private JButton nine = new JButton("9");
    private JButton dot = new JButton(".");
    private JButton four = new JButton("4");
    private JButton AC = new JButton("AC");
    private JButton seven = new JButton("7");
    private JButton one = new JButton("1");
    private JButton hash = new JButton("+/-");
    private JButton mod = new JButton("%");
    private JButton plus = new JButton("+");
    private JButton divide = new JButton("÷");
    private JButton equall = new JButton("=");
    private JButton minus = new JButton("-");
    private JPanel jPanel1 = new JPanel();
    private JTextArea tf = new JTextArea("");

    String firstnum, secondnum,operator;
    BigDecimal fnum, snum, Decres;

        public Cal() {
            initComponents();
        }


        public void setNumOptr(JButton b, int x, int y, int w, int h, JTextArea tf, Color color){
            b.setFont(new Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
            b.setBorder(new SoftBevelBorder(0));
            b.setBackground(color);
            getContentPane().add(b);
            b.setBounds(x,y,w,h);
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        if(b.getText().matches("[0123456789.]")) {
                            tf.setText(tf.getText() + b.getText());
                        }
                        else if(b.getText().matches("[+-x÷%]")) {
                            firstnum = tf.getText();
                            tf.setText("");
                            operator = b.getText();
                            //tf.setText(operator);
                        }
                        else if(b.getText().equals("AC")){
                            tf.setText("");
                            firstnum = "";
                            operator = "";

                        }

                }
            });
        }

        private void initComponents(){
            tf.setBackground(new Color(188,143,143));
            tf.setFont(new Font("Arial Rounded MT Bold", 0, 20)); 
            tf.setLineWrap(true);
            tf.setWrapStyleWord(true);
            tf.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            tf.setEditable(false);
            JScrollPane p = new JScrollPane(tf,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            getContentPane().add(p);
            p.setBounds(0, 0, 239, 70);


            setNumOptr(one, 0,120,60,50,tf,new Color(255,228,225));
            setNumOptr(two,60,120,60,50,tf,new Color(255,228,225));
            setNumOptr(zero, 0,270,120,50,tf,new Color(255,228,225));
            setNumOptr(four,0,170,60,50,tf,new Color(255,228,225));
            setNumOptr(eight,60,220,60,50,tf,new Color(255,228,225));
            setNumOptr(nine, 120,220,60,50,tf,new Color(255,228,225));
            setNumOptr(seven, 0,220,60,50,tf,new Color(255,228,225));
            setNumOptr(three,120,120,60,50,tf,new Color(255,228,225));
            setNumOptr(five,60,170,60,50,tf,new Color(255,228,225));
            setNumOptr(six,120,170,60,50,tf,new Color(255,228,225));
            setNumOptr(AC,0,70,60,50,tf,new Color(255, 144, 48));

            hash.setFont(new Font("Arial Rounded MT Bold", 0, 18));
            hash.setBorder(new SoftBevelBorder(0));
            getContentPane().add(hash);
            hash.setBounds(60, 70, 60, 50);
            hash.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   BigDecimal prev = new BigDecimal(tf.getText()).multiply(new BigDecimal(Integer.toString(-1)));
                    tf.setText(prev.toString());
                }
            });

            setNumOptr(hash, 60,70,60,50,tf,new Color(219,112,147));
            setNumOptr(mod,120,70,60,50,tf,new Color(219,112,147));
            setNumOptr(plus,180,220,60,50,tf,new Color(219,112,147));
            setNumOptr(divide,180,70,60,50,tf,new Color(219,112,147));
            setNumOptr(minus,180,170,60,50,tf,new Color(219,112,147));
            setNumOptr(times, 180,120,60,50,tf,new Color(219,112,147));
            setNumOptr(dot,120, 270, 60, 50,tf,new Color(255,228,225));

            equall.setFont(new Font("Times New Roman", 0, 18)); // NOI18N
            equall.setBorder(new SoftBevelBorder(0));
            equall.setBackground(new Color(255, 144, 48));
            getContentPane().add(equall);
            equall.setBounds(180, 270, 60, 50);
            equall.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    secondnum = tf.getText();
                    fnum = new BigDecimal(firstnum);
                    snum = new BigDecimal(secondnum);
                    if (operator.equals("+")) {
                        Decres = fnum.add(snum);
                        tf.setText(Decres.toString());
                    }
                    if (operator.equals("-")) {
                        Decres = fnum.subtract(snum);
                        tf.setText(Decres.toString());
                    }
                    if (operator.equals("x")) {
                        Decres = fnum.multiply(snum);
                        tf.setText(Decres.toString());
                    }
                    if (operator.equals("÷")) {
                        Decres = fnum.divide(snum, 10, RoundingMode.HALF_UP).stripTrailingZeros();
                        tf.setText(Decres.toPlainString());
                    }
                    if (operator.equals("%")) {
                        Decres = fnum.multiply(snum).divide(new BigDecimal(100),2, RoundingMode.HALF_UP).stripTrailingZeros();
                        tf.setText(Decres.toPlainString());
                    }

                }
            });

            GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGap(0, 240, Short.MAX_VALUE)
            );
            jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGap(0, 330, Short.MAX_VALUE)
            );

            getContentPane().add(jPanel1);
            jPanel1.setBounds(0, 0, 240, 330);
            pack();
        }
        public static void main(String args[]) {
            Cal c = new Cal();
            c.setVisible(true);
            c.setSize(245,345);
            c.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            c.getContentPane().setLayout(null);
            c.setResizable(false);


        }



}
