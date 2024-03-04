package mypack;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Home extends JFrame {
    private static String[] getName(String form) {
        String name = "", gender = "";
        try {
            String query = "select * from reg1 where formno = \"" + form + "\";";
            Connection_DB con = new Connection_DB();
            ResultSet rs = con.stm.executeQuery(query);
            if (rs.next()) {
                name = rs.getString(2);
                gender = rs.getString(5);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        String[] str = new String[2];
        str[0] = name;
        str[1] = gender;

        return str;
    }

    Home(String form) {
        setTitle("Home");
        getContentPane().setBackground(Color.white);
        setLayout(null);

        // ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        ImageIcon i1 = new ImageIcon(getClass().getResource("Images//atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);

        String[] str = getName(form);
        String pre = "";
        if (str[1].equals("Male")) {
            pre = "Mr.";
        } else if (str[1].equals("Female")) {
            pre = "Mrs.";
        }

        JLabel txt1 = new JLabel("Welcome " + pre + " " + str[0]);
        txt1.setBounds(170, 220, 250, 30);
        txt1.setFont(new Font("System", Font.BOLD, 16));
        txt1.setForeground(Color.WHITE);
        image.add(txt1);

        JLabel txt2 = new JLabel("Please Select Your Transaction ");
        txt2.setBounds(170, 250, 250, 30);
        txt2.setFont(new Font("System", Font.BOLD, 16));
        txt2.setForeground(Color.WHITE);
        image.add(txt2);

        JButton btn1 = new JButton("Deposit");
        btn1.setBounds(150, 345, 130, 30);
        image.add(btn1);

        JButton btn2 = new JButton("Cash Withdrawal");
        btn2.setBounds(320, 345, 130, 30);
        image.add(btn2);

        JButton btn3 = new JButton("Fast Cash");
        btn3.setBounds(150, 380, 130, 30);
        image.add(btn3);

        JButton btn4 = new JButton("Mini Statement");
        btn4.setBounds(320, 380, 130, 30);
        image.add(btn4);

        JButton btn5 = new JButton("Pin Change");
        btn5.setBounds(150, 415, 130, 30);
        image.add(btn5);

        JButton btn6 = new JButton("Balance Enquiry");
        btn6.setBounds(320, 415, 130, 30);
        image.add(btn6);

        JButton btn7 = new JButton("Exit");
        btn7.setBounds(320, 450, 130, 30);
        image.add(btn7);

        setSize(800, 800);
        setLocation(300, 25);
        setUndecorated(true);
        setVisible(true);

        btn1.addActionListener(e -> {
            setVisible(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            new Deposit(form);

        });

        btn2.addActionListener(e -> {
            setVisible(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            new Withdraw(form);
        });

        btn3.addActionListener(e -> {
            setVisible(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            new Fast_Cash(form);
        });

        btn4.addActionListener(e -> {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            M_State dialog = new M_State(form);
            dialog.setVisible(true);
        });

        btn5.addActionListener(e -> {
            setVisible(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            new Forgot_Pin(form);
        });
        btn6.addActionListener(e -> {
            try {
                String query = "select * from login where formno = \"" + form + "\";";
                Connection_DB con = new Connection_DB();
                String amt = "";
                ResultSet rs = con.stm.executeQuery(query);
                if (rs.next())
                    amt = rs.getString(4);
                JOptionPane.showMessageDialog(null, "Account Balance: Rs " + amt);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                // System.out.println(ex.getMessage());
            }
        });
        btn7.addActionListener(e -> System.exit(0));
    }

    // public static void main(String[] args) {
    // JFrame frame = new Home("5823");
    // frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    // }

}
