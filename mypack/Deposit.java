package mypack;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Deposit extends JFrame {
    public Deposit(String form) {
        setTitle("Deposit");
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(getClass().getResource("Images//atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);

        JLabel txt1 = new JLabel("Enter amount to deposit ");
        txt1.setBounds(200, 250, 250, 30);
        txt1.setFont(new Font("System", Font.BOLD, 16));
        txt1.setForeground(Color.WHITE);
        image.add(txt1);

        JTextField txt2 = new JTextField();
        txt2.setBounds(230, 320, 150, 30);
        txt2.setFont(new Font("System", Font.BOLD, 20));
        image.add(txt2);

        JButton btn1 = new JButton("Deposit");
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
            } else {
                String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());
                try {
                    Connection_DB con = new Connection_DB();
                    String query = "select * from login where formno = \"" + form + "\";";
                    ResultSet rs = con.stm.executeQuery(query);
                    int bal = 0;
                    if (rs.next())
                        bal = Integer.parseInt(rs.getString(4));
                    bal += Integer.parseInt(amt);
                    query = "update login set balence = \"" + bal + "\" where formno = \"" + form + "\";";
                    con.stm.executeUpdate(query);
                    query = "insert into transactions values ('" + form + "', '" + date + "', '" + amt
                            + "', 'Credit', '" + bal + "');";
                    con.stm.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + amt + " is Deposited Successfully.");
                    txt2.setText("");
                    setVisible(false);
                    new Home(form);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        btn2.addActionListener(e -> {
            setVisible(false);
            new Home(form);
        });
    }

    public static boolean validation(String amt) {
        for (int i = 0; i < amt.length(); i++) {
            if (!(amt.charAt(i) >= '0' && amt.charAt(i) <= '9')) {
                return true;
            }
        }
        return false;
    }
    // public static void main(String[] args) {
    // JFrame frame = new Deposit("5823");
    // frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    // }
}
