import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JButton[] numbers = new JButton[10];
    JButton[] operators = new JButton[10];
    JButton add, sub, mul, div, neg, perc;
    JButton dec, equ, del, clr;
    JPanel panel;

    Font font1 = new Font("Montserrat", Font.PLAIN, 50);
    Font font2 = new Font("Montserrat", Font.BOLD, 30);

    
    double num1 = 0, num2 = 0, result = 0;
    char operator;   // all operators (+,-,/)

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(320,540);
        frame.setLayout(null);
        frame.setResizable(false);

        textfield = new JTextField();
        textfield.setBounds(4, 20, 300, 100);
        textfield.setFont(font1);
        textfield.setEditable(false);

        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("×");
        div = new JButton("÷");
        dec = new JButton(".");
        del = new JButton("⌫");
        equ = new JButton("=");
        clr = new JButton("CLEAR");
        neg = new JButton("±");
        perc = new JButton("%");

        operators[0] = add;
        operators[1] = sub;
        operators[2] = mul;
        operators[3] = div;
        operators[4] = dec;
        operators[5] = del;
        operators[6] = equ;
        operators[7] = clr;
        operators[8] = neg;
        operators[9] = perc;

        for (int i = 0; i < 10; i++) {
            operators[i].addActionListener(this);
            operators[i].setFont(font2);
            operators[i].setFocusable(false);
        }
        for (int i = 0; i < 10; i++) {
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(font2);
            numbers[i].setFocusable(false);
        }
        
        del.setForeground(Color.WHITE);
       
        del.setBounds(270, 20, 50, 100);
        clr.setBounds(165, 450,150,50);

        panel = new JPanel();
        panel.setBounds(7, 150, 308,300);
        panel.setLayout(new GridLayout(5,10,10,10));
        
        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);

        neg.setForeground(Color.LIGHT_GRAY);
        panel.add(neg);
        
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);

        add.setForeground(Color.LIGHT_GRAY);
        panel.add(add);
     
        panel.add(numbers[7]);
       
        panel.add(numbers[8]);
        panel.add(numbers[9]);

        sub.setForeground(Color.LIGHT_GRAY);
        panel.add(sub);
        panel.add(numbers[0]);

        mul.setForeground(Color.LIGHT_GRAY);
        panel.add(mul);
        dec.setForeground(Color.LIGHT_GRAY);
        panel.add(dec);
        perc.setForeground(Color.LIGHT_GRAY);
        panel.add(perc);
        div.setForeground(Color.LIGHT_GRAY);
        panel.add(div);
        equ.setForeground(Color.LIGHT_GRAY);
        panel.add(equ);
        
       
       


        //panel.setBackground(Color.WHITE);

        frame.getContentPane().setBackground(Color.decode("#FADADD")); // Blush pink background
        panel.setBackground(Color.decode("#FADADD")); // Blush pink background
        frame.add(panel);

        del.setForeground(Color.PINK);
        frame.add(del);

        clr.setForeground(Color.PINK);
        frame.add(clr);

        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        Calculator calc = new Calculator();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numbers[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == dec) {
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource() == add) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if (e.getSource() == sub) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if (e.getSource() == mul) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '×';
            textfield.setText("");
        }
        if (e.getSource() == div) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '÷';
            textfield.setText("");
        }
        if (e.getSource() == perc) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '%';
            textfield.setText("");
        }
        if (e.getSource() == neg) {
            double temp = Double.parseDouble(textfield.getText());
            temp = temp * -1; 
            textfield.setText(String.valueOf(temp));
        }
        if (e.getSource() == equ) {
            num2 = Double.parseDouble(textfield.getText());

            switch(operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '×':
                    result = num1 * num2;
                    break;
                case '÷':
                    result = num1 / num2;
                    break;
                case '%':
                    result = (num1 / num2) * 100;
                    break; 
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
    }
    if (e.getSource() == clr) {
        textfield.setText("");
    }
    if (e.getSource() == del) {
        String str = textfield.getText();
        textfield.setText("");

        for (int i = 0; i < str.length() - 1; i++) {
            textfield.setText(textfield.getText() + str.charAt(i));
        }
    }
}
}
