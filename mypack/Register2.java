package mypack;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.Random;

public class Register2 extends JFrame {
    Register2(int rand) {
        setLayout(null);

        JLabel form = new JLabel("Application Form No: " + rand);
        form.setFont(new Font("Rale way", Font.BOLD, 38));
        form.setBounds(120, 20, 600, 40);
        add(form);

        JLabel personal = new JLabel("Page 2: Additional Details");
        personal.setFont(new Font("Rale way", Font.BOLD, 24));
        personal.setBounds(210, 80, 600, 40);
        add(personal);

        JLabel txt3 = new JLabel("Religion*: ");
        txt3.setFont(new Font("Rale way", Font.PLAIN, 18));
        txt3.setBounds(100, 150, 100, 40);
        add(txt3);
        String[] a = { "Select", "HINDU", "ISLAM", "CRISTIAN", "OTHERS" };
        JComboBox reg = new JComboBox(a);
        reg.setBounds(250, 160, 300, 20);
        add(reg);

        JLabel txt4 = new JLabel("Category*: ");
        txt4.setFont(new Font("Rale way", Font.PLAIN, 18));
        txt4.setBounds(100, 190, 100, 40);
        add(txt4);
        String[] b = { "Select", "General", "OBC-A", "OBC-B", "SC", "ST" };
        JComboBox cat = new JComboBox(b);
        cat.setBounds(250, 200, 300, 20);
        add(cat);

        JLabel txt1 = new JLabel("Aadhaar No*: ");
        txt1.setFont(new Font("Rale way", Font.PLAIN, 18));
        txt1.setBounds(100, 230, 150, 40);
        add(txt1);

        JTextField adn = new JTextField();
        adn.setFont(new Font("Rale way", Font.PLAIN, 14));
        adn.setBounds(250, 240, 300, 20);
        add(adn);

        JLabel txt2 = new JLabel("PAN No: ");
        txt2.setFont(new Font("Rale way", Font.PLAIN, 18));
        txt2.setBounds(100, 270, 150, 40);
        add(txt2);

        JTextField panno = new JTextField();
        panno.setFont(new Font("Rale way", Font.PLAIN, 14));
        panno.setBounds(250, 280, 300, 20);
        add(panno);

        JLabel txt5 = new JLabel("Education*: ");
        txt5.setFont(new Font("Rale way", Font.PLAIN, 18));
        txt5.setBounds(100, 310, 100, 40);
        add(txt5);
        String[] c = { "Select", "8th Pass", "Secondary", "Higher-Secondary", "Undergraduate", "Postgraduate", "PhD" };
        JComboBox edu = new JComboBox(c);
        edu.setBounds(250, 320, 300, 20);
        add(edu);

        JLabel txt6 = new JLabel("Account Type*:");
        txt6.setFont(new Font("Rale way", Font.PLAIN, 18));
        txt6.setBounds(100, 350, 150, 40);
        add(txt6);
        String[] d = { "Select", "Savings Account", "Current Account", "Fixed Account" };
        JComboBox ac = new JComboBox(d);
        ac.setBounds(250, 360, 300, 20);
        add(ac);

        JLabel txt7 = new JLabel("Service Required:");
        txt7.setFont(new Font("Rale way", Font.PLAIN, 18));
        txt7.setBounds(100, 390, 150, 40);
        add(txt7);

        JCheckBox c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Rale way", Font.PLAIN, 16));
        c1.setBounds(250, 400, 100, 20);
        add(c1);
        JCheckBox c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Rale way", Font.PLAIN, 16));
        c2.setBounds(450, 400, 150, 20);
        add(c2);
        JCheckBox c3 = new JCheckBox("EMAIL & SMS Alerts");
        c3.setFont(new Font("Rale way", Font.PLAIN, 16));
        c3.setBounds(250, 430, 200, 20);
        add(c3);
        JCheckBox c4 = new JCheckBox("E-Statement");
        c4.setFont(new Font("Rale way", Font.PLAIN, 16));
        c4.setBounds(450, 430, 150, 20);
        add(c4);
        JCheckBox c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Rale way", Font.PLAIN, 16));
        c5.setBounds(250, 460, 150, 20);
        add(c5);

        JCheckBox t = new JCheckBox("I hereby declare that the above entered details are correct.");
        t.setFont(new Font("Rale way", Font.PLAIN, 18));
        t.setBounds(100, 500, 1000, 20);
        add(t);

        JButton exit = new JButton("EXIT");
        exit.setFont(new Font("Rale way", Font.BOLD, 24));
        exit.setBounds(100, 570, 100, 30);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        add(exit);

        JButton back = new JButton("Back");
        back.setFont(new Font("Rale way", Font.BOLD, 24));
        back.setBounds(350, 570, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        // add(back);

        JButton next = new JButton("Next");
        next.setFont(new Font("Rale way", Font.BOLD, 24));
        next.setBounds(450, 570, 100, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        add(next);

        setSize(700, 700);
        setLocation(350, 50);
        setVisible(true);

        exit.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(null, "Are you sure to exit?");
            if (result == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        back.addActionListener(e -> {
            setVisible(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            new Register1();
        });

        next.addActionListener(e -> {
            boolean term = t.isSelected();
            String religion, category, aadhaar, pan, education, acc;
            boolean flag = false;
            religion = (String) reg.getSelectedItem();
            category = (String) cat.getSelectedItem();
            education = (String) edu.getSelectedItem();
            acc = (String) ac.getSelectedItem();
            if (religion.equals("Select") || category.equals("Select") || education.equals("Select")
                    || acc.equals("Select")) {
                JOptionPane.showMessageDialog(null, "Some fields are empty!");
                flag = true;
            } else {
                aadhaar = adn.getText();
                if (!check_Aadhaar(aadhaar, 12)) {
                    JOptionPane.showMessageDialog(null, "Invalid Aadhaar!");
                    flag = true;
                } else {
                    if (term && !flag) {
                        int result = JOptionPane.showConfirmDialog(null,
                                "Entered information's can't be change further. \n Are you sure to submit?");
                        if (result == JOptionPane.YES_OPTION) {
                            pan = panno.getText();
                            update_Reg2(String.valueOf(rand), religion, category, aadhaar, pan, education, acc);
                            String card = getCardNo(16);
                            String pin = getCardNo(4);
                            update_Login(String.valueOf(rand), card, pin);
                            JOptionPane.showMessageDialog(null,
                                    "Account Created Successfully. \nCard No: " + card + " \nPin: "
                                            + pin + " \n\nPlease remember Card and Pin numbers for further login");
                            setVisible(false);
                            JFrame frame = new Deposit(String.valueOf(rand));
                            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please check the checkbox.");
                    }
                }
            }
        });
    }

    public static void update_Reg2(String form, String reg, String cat, String Aad, String Pan, String Edu,
            String Acc) {
        try {
            Connection_DB con = new Connection_DB();
            String query = "insert into Reg2 values ('" + form + "', '" + reg + "', '" + cat + "', '" + Aad + "', '"
                    + Pan + "', '" + Edu + "', '" + Acc + "');";
            con.stm.executeUpdate(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void update_Login(String form, String card, String pin) {
        try {
            Connection_DB con = new Connection_DB();
            String query = "insert into login values ('" + form + "', '" + card + "', '" + pin + "', '" + 0 + "');";
            con.stm.executeUpdate(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static boolean check_Aadhaar(String str, int size) {
        int c = 0;
        if (str.length() != size)
            return false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
                c++;
            else
                return false;
        }
        return true;
    }

    public static String getCardNo(int n) {
        char[] data = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            int no = r.nextInt(data.length);
            sb.append(data[no]);
        }
        return sb.toString();
    }

    // public static void main(String[] args) {
    // JFrame frame = new Register2(1123);
    // frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    // }
}
