package mypack;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Fast_Cash extends JFrame {
    public Fast_Cash(String form) {
        setTitle("Fast Cash");
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(getClass().getResource("Images//atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);

        JLabel txt1 = new JLabel("Select Amount");
        txt1.setBounds(180, 250, 250, 30);
        txt1.setFont(new Font("System", Font.BOLD, 16));
        txt1.setForeground(Color.WHITE);
        image.add(txt1);

        JButton btn1 = new JButton("100");
        btn1.setBounds(150, 345, 130, 30);
        image.add(btn1);

        JButton btn2 = new JButton("200");
        btn2.setBounds(320, 345, 130, 30);
        image.add(btn2);

        JButton btn3 = new JButton("500");
        btn3.setBounds(150, 380, 130, 30);
        image.add(btn3);

        JButton btn4 = new JButton("1000");
        btn4.setBounds(320, 380, 130, 30);
        image.add(btn4);

        JButton btn5 = new JButton("5000");
        btn5.setBounds(150, 415, 130, 30);
        image.add(btn5);

        JButton btn6 = new JButton("10000");
        btn6.setBounds(320, 415, 130, 30);
        image.add(btn6);

        JButton btn7 = new JButton("Back");
        btn7.setBounds(320, 450, 130, 30);
        image.add(btn7);

        setSize(800, 800);
        setLocation(300, 25);
        setUndecorated(true);
        setVisible(true);

        btn1.addActionListener(e -> {
            Withdraw("100", form);
            setVisible(false);
            new Home(form);
        });

        btn2.addActionListener(e -> {
            Withdraw("200", form);
            setVisible(false);
            new Home(form);
        });

        btn3.addActionListener(e -> {
            Withdraw("500", form);
            setVisible(false);
            new Home(form);
        });

        btn4.addActionListener(e -> {
            Withdraw("1000", form);
            setVisible(false);
            new Home(form);
        });

        btn5.addActionListener(e -> {
            Withdraw("5000", form);
            setVisible(false);
            new Home(form);
        });

        btn6.addActionListener(e -> {
            Withdraw("10000", form);
            setVisible(false);
            new Home(form);
        });

        btn7.addActionListener(e -> {
            setVisible(false);
            new Home(form);
        });

    }

    public static void Withdraw(String amt, String form) {
        String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());
        try {
            Connection_DB con = new Connection_DB();
            String query = "select * from login where formno = \"" + form + "\";";
            ResultSet rs = con.stm.executeQuery(query);
            int bal = 0;
            if (rs.next())
                bal = Integer.parseInt(rs.getString(4));
            if (bal >= Integer.parseInt(amt)) {
                bal -= Integer.parseInt(amt);
                query = "update login set balence = \"" + bal + "\" where formno = \"" + form + "\";";
                con.stm.executeUpdate(query);
                query = "insert into transactions values ('" + form + "', '" + date + "', '" + amt + "', 'Debit', '"
                        + bal + "');";
                con.stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amt + " is Withdrawn Successfully.");
            } else {
                JOptionPane.showMessageDialog(null, " Your Account Balance is : Rs " + bal + ". \n Rs " + amt
                        + " can't be withdraw! \n If you need this amount please contact our branch to get a loan.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    // public static void main(String[] args) {
    // JFrame frame = new Fast_Cash("5823");
    // frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    // }
}
