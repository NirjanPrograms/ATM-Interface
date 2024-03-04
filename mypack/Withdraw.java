package mypack;

import javax.swing.*;
import java.awt.*;

import static mypack.Deposit.validation;

public class Withdraw extends JFrame {
    public Withdraw(String form) {
        setLayout(null);

        ImageIcon i1 = new ImageIcon(getClass().getResource("Images//atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);

        JLabel txt1 = new JLabel("Enter amount to withdraw ");
        txt1.setBounds(200, 250, 250, 30);
        txt1.setFont(new Font("System", Font.BOLD, 16));
        txt1.setForeground(Color.WHITE);
        image.add(txt1);

        JTextField txt2 = new JTextField();
        txt2.setBounds(230, 320, 150, 30);
        txt2.setFont(new Font("System", Font.BOLD, 20));
        image.add(txt2);

        JButton btn1 = new JButton("Withdraw");
        btn1.setBounds(320, 415, 130, 30);
        image.add(btn1);

        JButton btn2 = new JButton("Back");
        btn2.setBounds(320, 450, 130, 30);
        image.add(btn2);

        setSize(800, 800);
        setLocation(300, 25);
        setUndecorated(true);
        setVisible(true);

        btn1.addActionListener(e -> {
            String amt = txt2.getText();
            if (validation(amt)) {
                JOptionPane.showMessageDialog(null, "Invalid Amount!");
                txt2.setText("");
            } else if (amt.charAt(amt.length() - 1) != '0' && amt.charAt(amt.length() - 2) != '0') {
                JOptionPane.showMessageDialog(null,
                        "Entered Amount can't be withdraw! \n Enter amount should be multiple of 100");
                txt2.setText("");
            } else {
                mypack.Fast_Cash.Withdraw(amt, form);
                setVisible(false);
                new Home(form);
            }

        });

        btn2.addActionListener(e -> {
            setVisible(false);
            new Home(form);
        });
    }

    // public static void main(String[] args) {
    // JFrame frame = new Withdraw("5823");
    // frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    // }
}
