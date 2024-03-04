package mypack;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import static mypack.Forgot_Pin.match;

public class Change_Pin extends JFrame {
    public Change_Pin(String form) {
        setLayout(null);

        ImageIcon i1 = new ImageIcon(getClass().getResource("Images//atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);

        JLabel txt1 = new JLabel("Enter New Pin");
        txt1.setBounds(200, 250, 250, 30);
        txt1.setFont(new Font("System", Font.BOLD, 16));
        txt1.setForeground(Color.WHITE);
        image.add(txt1);

        JTextField txt2 = new JTextField();
        txt2.setBounds(230, 285, 150, 30);
        txt2.setFont(new Font("System", Font.BOLD, 20));
        image.add(txt2);

        JLabel txt3 = new JLabel("Reenter The Pin");
        txt3.setBounds(200, 320, 250, 30);
        txt3.setFont(new Font("System", Font.BOLD, 16));
        txt3.setForeground(Color.WHITE);
        image.add(txt3);

        JTextField txt4 = new JTextField();
        txt4.setBounds(230, 355, 150, 30);
        txt4.setFont(new Font("System", Font.BOLD, 20));
        image.add(txt4);

        JButton btn1 = new JButton("Change PIN");
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
            if (txt2.getText().equals(txt4.getText()) && !txt2.getText().isEmpty()) {
                if (match(txt2.getText(), 4)) {
                    try {
                        String query = "update login set pinno = \"" + txt2.getText() + "\" where formno = \"" + form
                                + "\";";
                        Connection_DB con = new Connection_DB();
                        con.stm.executeUpdate(query);

                        // Refresh Database to update the pin
                        query = "select * from login where formno = \"" + form + "\";";
                        ResultSet rs = con.stm.executeQuery(query);
                        if (rs.next()) {
                            JOptionPane.showMessageDialog(null, "Pin Changed Successfully.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error Occurred!\n Try again after sometime.");
                        }
                        setVisible(false);
                        new Login();
                        setDefaultCloseOperation(EXIT_ON_CLOSE);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "4 digit Numeric PIN Required!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid PIN Entered!");
            }
        });

        btn2.addActionListener(e -> {
            setVisible(false);
            new Home(form);
        });
    }

    // public static void main(String[] args) {
    // JFrame frame = new Change_Pin("1123");
    // frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    // }
}
