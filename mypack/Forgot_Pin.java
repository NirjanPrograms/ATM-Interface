package mypack;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

public class Forgot_Pin extends JFrame {
    public Forgot_Pin(String form) {
        setLayout(null);

        ImageIcon i1 = new ImageIcon(getClass().getResource("Images//atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);

        JLabel txt1 = new JLabel("Enter 16 digit card number");
        txt1.setBounds(200, 250, 250, 30);
        txt1.setFont(new Font("System", Font.BOLD, 16));
        txt1.setForeground(Color.WHITE);
        image.add(txt1);

        JTextField txt2 = new JTextField();
        txt2.setBounds(230, 320, 200, 30);
        txt2.setFont(new Font("System", Font.BOLD, 20));
        image.add(txt2);

        JButton btn1 = new JButton("Send OTP");
        btn1.setBounds(320, 415, 130, 30);
        image.add(btn1);

        JButton btn2 = new JButton("Back");
        btn2.setBounds(320, 450, 130, 30);
        image.add(btn2);

        setSize(800, 800);
        setLocation(300, 25);
        setUndecorated(true);
        setVisible(true);

        final int[] gotp = new int[1];

        btn1.addActionListener(e -> {
            String card = txt2.getText();
            String formno = "";
            if (match(card, 16) && !card.isEmpty()) {
                String query = "select * from login where cardno = \"" + card + "\";";
                try {
                    Connection_DB con = new Connection_DB();
                    ResultSet rs = con.stm.executeQuery(query);
                    if (rs.next())
                        formno = rs.getString(1);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    System.out.println(ex.getMessage());
                }
                if (!formno.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "OTP is sent into the command prompt.");
                    gotp[0] = ThreadLocalRandom.current().nextInt(100000, 999999);
                    System.out.println(gotp[0]);
                    setVisible(false);
                    new OTP_Verify(formno, gotp[0]);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Card Number!");
                    txt2.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Card Number!");
            }
        });

        btn2.addActionListener(e -> {
            setVisible(false);
            if (form.isEmpty()) {
                new Login();
            } else {
                new Home(form);
            }
        });
    }

    public static boolean match(String card, int size) {
        boolean flag = true;
        int c = 0;
        for (int i = 0; i < card.length(); i++) {
            if (card.charAt(i) >= '0' && card.charAt(i) <= '9') {
                flag = false;
                c++;
            } else {
                flag = true;
                break;
            }
        }
        return flag || c == size;
    }

    // public static void main(String[] args) {
    // JFrame frame = new Forgot_Pin("5823");
    // frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    // }
}
