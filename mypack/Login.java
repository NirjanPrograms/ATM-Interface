package mypack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class Login extends JFrame {
    Login() {
        setTitle("Login");
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(getClass().getResource("Images//bank.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(30, 100, 200, 200);
        add(image);

        JLabel headings = new JLabel("Welcome to ABC ATM");
        headings.setFont(new Font("Osward", Font.BOLD, 28));
        headings.setBounds(300, 30, 400, 50);
        headings.setForeground(Color.magenta);
        add(headings);

        JLabel text1 = new JLabel("Card No: ");
        text1.setFont(new Font("Osward", Font.BOLD, 20));
        text1.setBounds(300, 150, 100, 20);
        add(text1);

        JLabel text2 = new JLabel("PIN: ");
        text2.setFont(new Font("Osward", Font.BOLD, 20));
        text2.setBounds(300, 200, 150, 20);
        add(text2);

        JTextField txt1 = new JTextField();
        txt1.setBounds(420, 150, 200, 25);
        txt1.setFont(new Font("Osward", Font.BOLD, 20));
        add(txt1);

        JTextField txt2 = new JTextField();
        txt2.setBounds(420, 200, 200, 25);
        txt2.setFont(new Font("Osward", Font.BOLD, 20));
        add(txt2);

        final String[] captcha = { getCaptcha() };
        JLabel text4 = new JLabel(captcha[0]);
        text4.setFont(new Font("Osward", Font.PLAIN, 16));
        text4.setBounds(420, 230, 150, 30);
        add(text4);

        // ImageIcon i4 = new
        // ImageIcon(ClassLoader.getSystemResource("icons/refresh.png"));
        ImageIcon i4 = new ImageIcon(getClass().getResource("Images//refresh.png"));
        Image i5 = i4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image1 = new JLabel(i6);
        image1.setBounds(480, 220, 50, 50);
        add(image1);

        JLabel text5 = new JLabel("Captcha: ");
        text5.setFont(new Font("Osward", Font.BOLD, 20));
        text5.setBounds(300, 280, 150, 25);
        add(text5);

        JTextField txt3 = new JTextField();
        txt3.setBounds(420, 280, 200, 30);
        txt3.setFont(new Font("Osward", Font.BOLD, 25));
        add(txt3);

        JButton btn1 = new JButton("Sign In");
        btn1.setBounds(320, 350, 110, 30);
        btn1.setFont(new Font("Osward", Font.BOLD, 22));
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(Color.white);
        add(btn1);

        JButton btn2 = new JButton("Sign Up");
        btn2.setBounds(480, 350, 120, 30);
        btn2.setFont(new Font("Osward", Font.BOLD, 22));
        btn2.setBackground(Color.BLACK);
        btn2.setForeground(Color.white);
        add(btn2);

        JLabel text3 = new JLabel("Forgot PIN?");
        text3.setFont(new Font("Osward", Font.BOLD, 16));
        text3.setBounds(400, 400, 150, 25);
        text3.setForeground(Color.black);
        add(text3);
        btn1.addActionListener(e -> extracted(txt1, txt2, captcha, text4, txt3));

        btn2.addActionListener(e -> {
            setVisible(false);
            JFrame frame = new Register1();
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        });

        text3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                JFrame frame = new Forgot_Pin("");
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
        });

        image1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String capt = getCaptcha();
                text4.setText(capt);
            }
        });

        setSize(700, 500);
        setLocation(350, 150);
        setVisible(true);
    }

    private void extracted(JTextField txt1, JTextField txt2, final String[] captcha, JLabel text4, JTextField txt3) {
        String card = txt1.getText();
        String pin = txt2.getText();
        String capt = txt3.getText();
        String query = "select * from login where cardno = \"" + card + "\" and pinno = \"" + pin + "\";";
        if (capt.equals(captcha[0])) {
            try {
                Connection_DB con = new Connection_DB();
                ResultSet rs = con.stm.executeQuery(query);
                if (rs.next()) {
                    String form = rs.getString(1);
                    setVisible(false);
                    JFrame frame = new Home(form);
                    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Invalid Credentials!");
                txt1.setText("");
                txt2.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Captcha!");
            txt3.setText("");
        }
        captcha[0] = getCaptcha();
        text4.setText(captcha[0]);
        txt3.setText("");
    }

    public static String getCaptcha() {
        char[] data = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
                'W', 'X', 'Y', 'Z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            int c = r.nextInt(data.length);
            sb.append(data[c]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        JFrame frame = new Login();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
