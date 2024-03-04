package mypack;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

import static mypack.Forgot_Pin.match;

public class OTP_Verify extends JFrame {
    OTP_Verify(String form, int otp) {
        setLayout(null);

        ImageIcon i1 = new ImageIcon(getClass().getResource("Images//atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);

        JLabel txt1 = new JLabel("Enter 6 digit otp");
        txt1.setBounds(200, 250, 250, 30);
        txt1.setFont(new Font("System", Font.BOLD, 16));
        txt1.setForeground(Color.WHITE);
        image.add(txt1);

        JTextField txt2 = new JTextField();
        txt2.setBounds(230, 320, 150, 30);
        txt2.setFont(new Font("System", Font.BOLD, 20));
        image.add(txt2);

        JButton btn1 = new JButton("Verify OTP");
        btn1.setBounds(320, 415, 130, 30);
        image.add(btn1);

        JButton btn2 = new JButton("Back");
        btn2.setBounds(320, 450, 130, 30);
        image.add(btn2);

        JButton btn3 = new JButton("Resend OTP");
        btn3.setBounds(150, 415, 130, 30);
        image.add(btn3);

        setSize(800, 800);
        setLocation(300, 25);
        setUndecorated(true);
        setVisible(true);

        final int[] o = { otp };

        btn1.addActionListener(e -> {
            String getotp = txt2.getText();
            if (match(getotp, 6)) {
                if (o[0] == (Integer.parseInt(getotp))) {
                    // go next page
                    setVisible(false);
                    new Change_Pin(form);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect OTP Entered!");
                    txt2.setText("");
                    o[0] = resend_OTP();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid OTP!");
                txt2.setText("");
                o[0] = resend_OTP();
            }
        });

        btn2.addActionListener(e -> {
            setVisible(false);
            new Forgot_Pin(form);
        });

        btn3.addActionListener(e -> o[0] = resend_OTP());
    }

    public static int resend_OTP() {
        final int[] gotp = new int[1];
        gotp[0] = ThreadLocalRandom.current().nextInt(100000, 999999);
        System.out.println(gotp[0]);
        JOptionPane.showMessageDialog(null, "OTP is sent into the command prompt.");
        return gotp[0];
    }
    // public static void main(String[] args) {
    // JFrame frame = new OTP_Verify("", 0);
    // frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    // }
}
