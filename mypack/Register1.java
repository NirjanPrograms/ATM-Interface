package mypack;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Register1 extends JFrame {
    Register1() {
        setLayout(null);
        Random r = new Random();
        int rand = Math.abs((r.nextInt() % 9000) + 1000);

        JLabel form = new JLabel("Application Form No: " + rand);
        form.setFont(new Font("Rale way", Font.BOLD, 38));
        form.setBounds(120, 20, 600, 40);
        add(form);

        JLabel personal = new JLabel("Page 1: Personal Details");
        personal.setFont(new Font("Rale way", Font.BOLD, 24));
        personal.setBounds(210, 80, 600, 40);
        add(personal);

        JLabel name = new JLabel("Name*: ");
        name.setFont(new Font("Rale way", Font.PLAIN, 18));
        name.setBounds(100, 150, 100, 40);
        add(name);

        JTextField nametxt = new JTextField();
        nametxt.setFont(new Font("Rale way", Font.PLAIN, 14));
        nametxt.setBounds(250, 160, 300, 20);
        add(nametxt);

        JLabel fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Rale way", Font.PLAIN, 18));
        fname.setBounds(100, 190, 150, 40);
        add(fname);

        JTextField fnametxt = new JTextField();
        fnametxt.setFont(new Font("Rale way", Font.PLAIN, 14));
        fnametxt.setBounds(250, 200, 300, 20);
        add(fnametxt);

        JLabel dob = new JLabel("Date of Birth*: ");
        dob.setFont(new Font("Rale way", Font.PLAIN, 18));
        dob.setBounds(100, 230, 150, 40);
        add(dob);

        JDateChooser date = new JDateChooser();
        date.setBounds(250, 240, 300, 20);
        date.setForeground(Color.BLACK);
        add(date);

        JLabel gen = new JLabel("Gender*: ");
        gen.setFont(new Font("Rale way", Font.PLAIN, 18));
        gen.setBounds(100, 270, 100, 40);
        add(gen);

        JRadioButton male = new JRadioButton("Male");
        male.setFont(new Font("Rale way", Font.PLAIN, 18));
        male.setBounds(250, 270, 100, 40);
        add(male);

        JRadioButton female = new JRadioButton("Female");
        female.setFont(new Font("Raleway", Font.PLAIN, 18));
        female.setBounds(350, 270, 100, 40);
        add(female);

        JRadioButton oth = new JRadioButton("Others");
        oth.setFont(new Font("Raleway", Font.PLAIN, 18));
        oth.setBounds(450, 270, 100, 40);
        add(oth);

        ButtonGroup gendgrp = new ButtonGroup();
        gendgrp.add(male);
        gendgrp.add(female);
        gendgrp.add(oth);

        JLabel ema = new JLabel("Email: ");
        ema.setFont(new Font("Raleway", Font.PLAIN, 18));
        ema.setBounds(100, 310, 100, 40);
        add(ema);

        JTextField emailtxt = new JTextField();
        emailtxt.setFont(new Font("Raleway", Font.PLAIN, 14));
        emailtxt.setBounds(250, 320, 300, 20);
        add(emailtxt);

        JLabel mob = new JLabel("Mobile No*: ");
        mob.setFont(new Font("Raleway", Font.PLAIN, 18));
        mob.setBounds(100, 350, 100, 40);
        add(mob);

        JTextField mobtxt = new JTextField();
        mobtxt.setFont(new Font("Raleway", Font.PLAIN, 14));
        mobtxt.setBounds(250, 360, 300, 20);
        add(mobtxt);

        JLabel a = new JLabel("Address: ");
        a.setFont(new Font("Raleway", Font.PLAIN, 18));
        a.setBounds(100, 390, 100, 40);
        add(a);

        JTextField address = new JTextField();
        address.setFont(new Font("Raleway", Font.PLAIN, 14));
        address.setBounds(250, 400, 300, 20);
        add(address);

        JLabel c = new JLabel("City: ");
        c.setFont(new Font("Raleway", Font.PLAIN, 18));
        c.setBounds(100, 430, 100, 40);
        add(c);

        JTextField citytxt = new JTextField();
        citytxt.setFont(new Font("Raleway", Font.PLAIN, 14));
        citytxt.setBounds(250, 440, 300, 20);
        add(citytxt);

        JLabel s = new JLabel("State: ");
        s.setFont(new Font("Raleway", Font.PLAIN, 18));
        s.setBounds(100, 470, 100, 40);
        add(s);

        JTextField statetxt = new JTextField();
        statetxt.setFont(new Font("Raleway", Font.PLAIN, 14));
        statetxt.setBounds(250, 480, 300, 20);
        add(statetxt);

        JLabel p = new JLabel("Pin Code*: ");
        p.setFont(new Font("Raleway", Font.PLAIN, 18));
        p.setBounds(100, 510, 100, 40);
        add(p);

        JTextField pinno = new JTextField();
        pinno.setFont(new Font("Raleway", Font.PLAIN, 14));
        pinno.setBounds(250, 520, 300, 20);
        add(pinno);

        JButton back = new JButton("Back");
        back.setFont(new Font("Raleway", Font.BOLD, 24));
        back.setBounds(100, 580, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        JButton next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 24));
        next.setBounds(450, 580, 100, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        add(next);

        setSize(700, 700);
        setLocation(350, 50);
        setUndecorated(true);
        setVisible(true);

        back.addActionListener(e -> {
            setVisible(false);
            JFrame frame = new Login();
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        });

        next.addActionListener(e -> {
            String nam, fnam, dofb, gender, email, mobile, add, city, state, pin;
            nam = nametxt.getText();
            fnam = fnametxt.getText();
            dofb = ((JTextField) date.getDateEditor().getUiComponent()).getText();
            // System.out.println(dofb.length());
            gender = null;
            if (male.isSelected())
                gender = "Male";
            else if (female.isSelected())
                gender = "Female";
            email = emailtxt.getText();
            mobile = mobtxt.getText();
            add = address.getText();
            city = citytxt.getText();
            state = statetxt.getText();
            pin = pinno.getText();

            if (check_DOB(dofb)) {
                if (nam.isEmpty() || !Register2.check_Aadhaar(mobile, 10) || !Register2.check_Aadhaar(pin, 6)) {
                    JOptionPane.showMessageDialog(null, "Invalid Details!");
                } else {
                    int result = JOptionPane.showConfirmDialog(null,
                            "Entered information's can't be change further. \n Be sure all the entered information are correct");
                    if (result == JOptionPane.YES_OPTION) {
                        try {
                            Connection_DB con = new Connection_DB();
                            String query = "insert into Reg1 values ('" + rand + "', '" + nam + "', '" + fnam + "', '"
                                    + dofb + "', '" + gender + "', '" + email + "', '" + mobile + "', '" + add + "', '"
                                    + city + "', '" + state + "', '" + pin + "');";
                            con.stm.executeUpdate(query);
                            setVisible(false);
                            JFrame frame = new Register2(rand);
                            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                            // System.out.println(ex.getMessage());
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Date of Birth! \nChoose it from the button");
            }

        });
    }

    // public static void main(String[] args) {
    // JFrame frame = new Register1();
    // frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    // }

    public static boolean check_DOB(String dob) {
        if (dob.length() == 11) {
            for (int i = 0; i < dob.length(); i++) {
                if (i == 0 || i == 1 || i == 7 || i == 8 || i == 9 || i == 10) {
                    if (dob.charAt(i) < '0' || dob.charAt(i) > '9')
                        return false;
                } else if (i == 2 || i == 6) {
                    if (dob.charAt(i) != '-')
                        return false;
                } else if (i == 3) {
                    if (dob.charAt(i) < 'A' || dob.charAt(i) > 'Z')
                        return false;
                } else {
                    if (dob.charAt(i) < 'a' || dob.charAt(i) > 'z')
                        return false;
                }
            }
            return true;
        }
        return false;
    }

}
