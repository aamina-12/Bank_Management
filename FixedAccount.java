
import java.io.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.util.*;

class FixedAccount extends JFrame implements ActionListener, KeyListener {

    int t = 0;
    String auto = "1", ss;

    JLabel AcNo, Title, Name, DOB, DOJ, ResAdd, OffAdd, PhoneNo, CellNo, Email, Intro, Qual, Branch, AcType, Amount, Years, IntRate, SetAmount;
    JTextField TAcNo, TName, TDOB, TDOJ, TResAdd, TOffAdd, TPhoneNo, TCellNo, TEmail, TIntro, TQual, TAmount, TYears, TIntRate, TSetAmount;
    Choice CBranch, CAcType;
    JButton New, Save, View, Close;
    Container con;
    Connection con1;
    Statement stmt;
    ResultSet rs;
    String opt = "", s11, s1, a, b, c, a1, b1, c1, h, h1, str, str1;
    int amount, year, intrate, ac;
    double setamt, interest;
    Date dat;

    public FixedAccount() throws Exception {

        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        String msAccessDBName = "db\\bankdb.mdb";
        String dbURL = "jdbc:ucanaccess://" + msAccessDBName;
        con1 = DriverManager.getConnection(dbURL);
        stmt = con1.createStatement();

        con = getContentPane();
        con.setLayout(null);
        setTitle("FIXED ACCOUNT");
        con.setBackground(new Color(23, 30, 16));
        Title = new JLabel("FIXED ACCOUNT");
        Title.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
        Title.setForeground(Color.green);
        AcNo = new JLabel("Account No:", JLabel.LEFT);
        AcNo.setForeground(Color.green);
        Name = new JLabel("Name:", JLabel.LEFT);
        Name.setForeground(Color.green);
        DOB = new JLabel("Date of Birth:", JLabel.LEFT);
        DOB.setForeground(Color.green);
        DOJ = new JLabel("Date of account opening:", JLabel.LEFT);
        DOJ.setForeground(Color.green);
        ResAdd = new JLabel("Res.Address:", JLabel.LEFT);
        ResAdd.setForeground(Color.green);
        OffAdd = new JLabel("Off.Address:", JLabel.LEFT);
        OffAdd.setForeground(Color.green);
        PhoneNo = new JLabel("Phone No:", JLabel.LEFT);
        PhoneNo.setForeground(Color.green);
        CellNo = new JLabel("Cell No:", JLabel.LEFT);
        CellNo.setForeground(Color.green);
        Email = new JLabel("Email:", JLabel.LEFT);
        Email.setForeground(Color.green);
        Intro = new JLabel("Introducer:", JLabel.LEFT);
        Intro.setForeground(Color.green);
        Qual = new JLabel("Qualification:", JLabel.LEFT);
        Qual.setForeground(Color.green);
        Branch = new JLabel("Branch Code:", JLabel.LEFT);
        Branch.setForeground(Color.green);
        AcType = new JLabel("Account Type:", JLabel.LEFT);
        AcType.setForeground(Color.green);
        Amount = new JLabel("Fixed Amount:", JLabel.LEFT);
        Amount.setForeground(Color.green);
        Years = new JLabel("Years:", JLabel.LEFT);
        Years.setForeground(Color.green);
        IntRate = new JLabel("Interest Rate:", JLabel.LEFT);
        IntRate.setForeground(Color.green);
        SetAmount = new JLabel("Settle Amount:", JLabel.LEFT);
        SetAmount.setForeground(Color.green);

        Title.setBounds(200, 20, 155, 25);
        AcNo.setBounds(10, 60, 125, 25);
        Name.setBounds(10, 90, 125, 25);
        DOB.setBounds(10, 120, 125, 25);
        DOJ.setBounds(10, 150, 150, 25);
        ResAdd.setBounds(10, 180, 125, 25);
        OffAdd.setBounds(10, 210, 125, 25);
        PhoneNo.setBounds(10, 240, 125, 25);
        Years.setBounds(10, 270, 125, 25);
        IntRate.setBounds(10, 300, 125, 25);
        CellNo.setBounds(350, 60, 125, 25);
        Email.setBounds(350, 95, 125, 25);
        Intro.setBounds(350, 130, 125, 25);
        Qual.setBounds(350, 165, 125, 25);
        Branch.setBounds(350, 200, 125, 25);
        AcType.setBounds(350, 235, 125, 25);
        Amount.setBounds(350, 270, 125, 25);
        SetAmount.setBounds(350, 305, 125, 25);

        TAcNo = new JTextField();
        TAcNo.setForeground(Color.green);
        TAcNo.setBackground(new Color(23, 30, 16));
        TName = new JTextField();
        TName.setForeground(Color.green);
        TName.setBackground(new Color(23, 30, 16));
        TDOB = new JTextField();
        TDOB.setForeground(Color.green);
        TDOB.setBackground(new Color(23, 30, 16));
//TDOJ=new JTextField(ss);
//
//TDOJ.setBackground(new Color(23,30,16));
        String months[] = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        int year;
        GregorianCalendar gcalendar = new GregorianCalendar();
        ss = months[gcalendar.get(Calendar.MONTH)] + "-" + gcalendar.get(Calendar.DATE) + "-" + gcalendar.get(Calendar.YEAR);
        TDOJ = new JTextField(ss);
        TDOJ.setForeground(Color.green);
        TDOJ.setBackground(new Color(23, 30, 16));
        TResAdd = new JTextField();
        TResAdd.setForeground(Color.green);
        TResAdd.setBackground(new Color(23, 30, 16));
        TOffAdd = new JTextField();
        TOffAdd.setForeground(Color.green);
        TOffAdd.setBackground(new Color(23, 30, 16));
        TPhoneNo = new JTextField();
        TPhoneNo.setForeground(Color.green);
        TPhoneNo.setBackground(new Color(23, 30, 16));
        TCellNo = new JTextField();
        TCellNo.setForeground(Color.green);
        TCellNo.setBackground(new Color(23, 30, 16));
        TEmail = new JTextField();
        TEmail.setForeground(Color.green);
        TEmail.setBackground(new Color(23, 30, 16));
        TIntro = new JTextField();
        TIntro.setForeground(Color.green);
        TIntro.setBackground(new Color(23, 30, 16));
        TQual = new JTextField();
        TQual.setForeground(Color.green);
        TQual.setBackground(new Color(23, 30, 16));
        CBranch = new Choice();
        CBranch.setForeground(Color.green);
        CBranch.setBackground(new Color(23, 30, 16));
        CAcType = new Choice();
        CAcType.setForeground(Color.green);
        CAcType.setBackground(new Color(23, 30, 16));
        TAmount = new JTextField();
        TAmount.setForeground(Color.green);
        TAmount.setBackground(new Color(23, 30, 16));
        TYears = new JTextField();
        TYears.setForeground(Color.green);
        TYears.setBackground(new Color(23, 30, 16));
        TIntRate = new JTextField();
        TIntRate.setForeground(Color.green);
        TIntRate.setBackground(new Color(23, 30, 16));
        TSetAmount = new JTextField();
        TSetAmount.setForeground(Color.green);
        TSetAmount.setBackground(new Color(23, 30, 16));

        TAcNo.setBounds(200, 60, 120, 25);
        TName.setBounds(200, 90, 120, 25);
        TDOB.setBounds(200, 120, 120, 25);
        TDOJ.setBounds(200, 150, 120, 25);
        TResAdd.setBounds(200, 180, 120, 25);
        TOffAdd.setBounds(200, 210, 120, 25);
        TPhoneNo.setBounds(200, 240, 120, 25);
        TYears.setBounds(200, 270, 120, 25);
        TIntRate.setBounds(200, 300, 120, 25);
        TCellNo.setBounds(480, 60, 120, 25);
        TEmail.setBounds(480, 95, 120, 25);
        TIntro.setBounds(480, 130, 120, 25);
        TQual.setBounds(480, 165, 120, 25);
        CBranch.setBounds(480, 200, 120, 25);
        CAcType.setBounds(480, 235, 120, 25);
        TAmount.setBounds(480, 270, 120, 25);
        TSetAmount.setBounds(480, 305, 120, 25);

        New = new JButton("NEW");
        New.setForeground(Color.green);
        New.setBackground(new Color(23, 30, 16));
        Save = new JButton("ADD");
        Save.setForeground(Color.green);
        Save.setBackground(new Color(23, 30, 16));
        View = new JButton("VIEW");
        View.setForeground(Color.green);
        View.setBackground(new Color(23, 30, 16));
        Close = new JButton("CLOSE");
        Close.setForeground(Color.green);
        Close.setBackground(new Color(23, 30, 16));

        New.setBounds(150, 380, 80, 25);
        Save.setBounds(230, 380, 80, 25);
        View.setBounds(310, 380, 80, 25);
        Close.setBounds(390, 380, 80, 25);

        con.add(Title);
        con.add(AcNo);
        con.add(Name);
        con.add(DOB);
        con.add(DOJ);
        con.add(ResAdd);
        con.add(OffAdd);
        con.add(PhoneNo);
        con.add(CellNo);
        con.add(Email);
        con.add(Intro);
        con.add(Qual);
        con.add(Branch);
        con.add(AcType);
        con.add(Amount);
        con.add(Years);
        con.add(IntRate);
        con.add(SetAmount);

        con.add(TAcNo);
        con.add(TName);
        con.add(TDOB);
        con.add(TDOJ);
        con.add(TResAdd);
        con.add(TOffAdd);
        con.add(TPhoneNo);
        con.add(TCellNo);
        con.add(TEmail);
        con.add(TIntro);
        con.add(TQual);
        con.add(CBranch);
        con.add(CAcType);
        con.add(TAmount);
        con.add(TYears);
        con.add(TIntRate);
        con.add(TSetAmount);

        con.add(New);
        con.add(Save);
        con.add(View);
        con.add(Close);

        New.addActionListener(this);
        Save.addActionListener(this);
        View.addActionListener(this);
        Close.addActionListener(this);
        TAcNo.addKeyListener(this);
        choice1();
        choice2();
        TAcNo.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                s11 = TAcNo.getText();
                for (int i = 0; i < s11.length(); i++) {
                    if (!(Character.isDigit(s11.charAt(i)))) {
                        JOptionPane.showMessageDialog(FixedAccount.this, "please enter only numer", "Error", JOptionPane.ERROR_MESSAGE);
                        TAcNo.setText("");
                        break;
                    }
                }
            }
        });
        TPhoneNo.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                s11 = TPhoneNo.getText();
                for (int i = 0; i < s11.length(); i++) {
                    if (!(Character.isDigit(s11.charAt(i)))) {
                        JOptionPane.showMessageDialog(FixedAccount.this, "please enter only numbers", "Error", JOptionPane.ERROR_MESSAGE);
                        TPhoneNo.setText("");
                        break;
                    }
                }
            }
        });
        TCellNo.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                s11 = TCellNo.getText();
                for (int i = 0; i < s11.length(); i++) {
                    if (!(Character.isDigit(s11.charAt(i)))) {
                        JOptionPane.showMessageDialog(FixedAccount.this, "please enter only numbers", "Error", JOptionPane.ERROR_MESSAGE);
                        TCellNo.setText("");
                        break;
                    }
                }
            }
        });
        TAmount.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                s11 = TAmount.getText();
                for (int i = 0; i < s11.length(); i++) {
                    if (!(Character.isDigit(s11.charAt(i)))) {
                        JOptionPane.showMessageDialog(FixedAccount.this, "please enter only numbers", "Error", JOptionPane.ERROR_MESSAGE);
                        TAmount.setText("");
                        break;
                    }
                }
            }
        });
        TYears.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                s11 = TYears.getText();
                for (int i = 0; i < s11.length(); i++) {
                    if (!(Character.isDigit(s11.charAt(i)))) {
                        JOptionPane.showMessageDialog(FixedAccount.this, "please enter only numbers", "Error", JOptionPane.ERROR_MESSAGE);
                        TYears.setText("");
                        break;
                    }
                }
            }
        });
        TIntRate.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                s11 = TIntRate.getText();
                for (int i = 0; i < s11.length(); i++) {
                    if (!(Character.isDigit(s11.charAt(i)))) {
                        JOptionPane.showMessageDialog(FixedAccount.this, "please enter only numbers", "Error", JOptionPane.ERROR_MESSAGE);
                        TIntRate.setText("");
                        break;
                    }
                }
            }
        });
        TSetAmount.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                s11 = TSetAmount.getText();

//                int amt = Integer.parseInt(TAmount.getText());
//                int year = Integer.parseInt(TYears.getText());
//                int irt = Integer.parseInt(TIntRate.getText());
//                interest = (amt * year * intrate * 12) / 100;
//                setamt = interest + amount;
//                TSetAmount.setText("" + setamt);
                for (int i = 0; i < s11.length(); i++) {
                    if (!(Character.isDigit(s11.charAt(i)))) {
                        JOptionPane.showMessageDialog(FixedAccount.this, "please enter only numbers", "Error", JOptionPane.ERROR_MESSAGE);
                        TSetAmount.setText("");
                        break;
                    }
                }
            }
        });
        TName.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                s1 = TName.getText();
                for (int i = 0; i < s1.length(); i++) {
                    if (!(Character.isLetter(s1.charAt(i)))) {
                        JOptionPane.showMessageDialog(FixedAccount.this, "please enter only alphabets", "Error", JOptionPane.ERROR_MESSAGE);
                        TName.setText("");
                        break;
                    }
                }
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == New) {

                TAmount.requestFocus();
                TAmount.setText("");
                TName.setText("");
                TDOB.setText("");
                TResAdd.setText("");
                TOffAdd.setText("");
                TPhoneNo.setText("");
                TCellNo.setText("");
                TEmail.setText("");
                TIntro.setText("");
                TQual.setText("");
                TAmount.setText("");
                TYears.setText("");
                TIntRate.setText("");
                TSetAmount.setText("");
//                try {
//                    stmt = con1.createStatement();
//                    rs = stmt.executeQuery("SELECT MAX(AccountNo) FROM FixedAccount");
//                    rs.next();
//                    t = Integer.parseInt(rs.getString(1));
//                    if (t != 0) {
//                        t = t + 1;
//                    } else {
//                        t = 1;
//                    }
//                    auto = String.valueOf(t).trim();
//                    TAcNo.setText(auto);
//                    //stat.close();
//                } catch (SQLException ne) {
//                    t = 1;
//                    auto = String.valueOf(t).trim();
//                    TAcNo.setText(auto);
//                }
            }

            if (ae.getSource() == Save) {
                choice1();
                choice2();

                amount = Integer.parseInt(TAmount.getText());
                year = Integer.parseInt(TYears.getText());
                intrate = Integer.parseInt(TIntRate.getText());
                interest = (amount * year * intrate * 12) / 100;
                setamt = interest + amount;
                TSetAmount.setText("" + setamt);
//                String sql = "insert into FixedAccount values('" + 
//                        TAcNo.getText() + "','" + 
//                        TName.getText() + "','" + 
//                        TDOB.getText() + "','" + 
//                        TDOJ.getText() + "','" + 
//                        TResAdd.getText() + "','" + 
//                        TOffAdd.getText() + "','" + 
//                        TPhoneNo.getText() + "','" + 
//                        TCellNo.getText() + "','" + 
//                        TEmail.getText() + "','" + 
//                        TIntro.getText() + "','" +
//                        TQual.getText() + "','" + 
//                        CBranch.getSelectedItem() + "','" + 
//                        CAcType.getSelectedItem() + "','" + 
//                        TAmount.getText() + "','" + 
//                        TYears.getText() + "','" + 
//                        TIntRate.getText() + "','" + 
//                        TSetAmount.getText() + "')";
//                
//                stmt.executeUpdate(sql);
//                con1.commit();
                String sql1 = "INSERT INTO FixedAccount "
                        + "(AccountNo, Name, DOB, DOJ, ResAddress, OffAddress, PhoneNo, CellNo, Email, Introducer, Qualification, BranchCode, AccountType, "
                        + "FixedAmount, Years, InterestRate, SettleAmount) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

//                    // Create PreparedStatement
                PreparedStatement pst = con1.prepareStatement(sql1);
                // Set values
                pst.setString(1, TAcNo.getText());
                pst.setString(2, TName.getText());
                pst.setString(3, TDOB.getText());
                pst.setString(4, TDOJ.getText());
                pst.setString(5, TResAdd.getText());
                pst.setString(6, TOffAdd.getText());
                pst.setString(7, TPhoneNo.getText());
                pst.setString(8, TCellNo.getText());
                pst.setString(9, TEmail.getText());
                pst.setString(10, TIntro.getText());
                pst.setString(11, TQual.getText());
                pst.setString(12, CBranch.getSelectedItem());
                pst.setString(13, CAcType.getSelectedItem());
                pst.setString(14, TAmount.getText());
                pst.setString(15, TYears.getText());
                pst.setString(16, TIntRate.getText());
                pst.setString(17, TSetAmount.getText());
                int rows = pst.executeUpdate();
                JOptionPane.showMessageDialog(FixedAccount.this, "Successfully saved", "Save", JOptionPane.INFORMATION_MESSAGE);
                                TAmount.requestFocus();
                TAmount.setText("");
                TName.setText("");
                TDOB.setText("");
                TResAdd.setText("");
                TOffAdd.setText("");
                TPhoneNo.setText("");
                TCellNo.setText("");
                TEmail.setText("");
                TIntro.setText("");
                TQual.setText("");
                TAmount.setText("");
                TYears.setText("");
                TIntRate.setText("");
                TSetAmount.setText("");
            }
            if (ae.getSource() == View) {
                String temp = JOptionPane.showInputDialog(FixedAccount.this, "Enter Account no toView", "View", JOptionPane.QUESTION_MESSAGE);
                int AcNo = Integer.parseInt(temp);
                rs = stmt.executeQuery("select * from FixedAccount where AccountNo=" + AcNo);
                if (rs.next()) {
                    TAcNo.setText(rs.getString("AccountNo"));
                    TName.setText(rs.getString("Name"));
                    h1 = rs.getString("DOB");
                    a1 = h1.substring(0, 1);
                    b1 = h1.substring(2, 3);
                    c1 = h1.substring(4, 6);
                    str1 = a1 + "/" + b1 + "/" + c1;
                    TDOB.setText(str1);
//h=rs.getString("DOJ");
//a=h.substring(0,1);
//b=h.substring(2,3);
//c=h.substring(4,6);
//str=c+"/"+a+"/"+b;
//TDOJ.setText(str);
                    TResAdd.setText(rs.getString("ResAddress"));
                    TOffAdd.setText(rs.getString("OffAddress"));
                    TPhoneNo.setText(rs.getString("PhoneNo"));
                    TCellNo.setText(rs.getString("CellNo"));
                    TEmail.setText(rs.getString("Email"));
                    TIntro.setText(rs.getString("Introducer"));
                    TQual.setText(rs.getString("Qualification"));
                    CBranch.select(rs.getString("BranchCode"));
                    CAcType.select(rs.getString("AccountType"));
                    TAmount.setText(rs.getString("FixedAmount"));
                    TYears.setText(rs.getString("Years"));
                    TIntRate.setText(rs.getString("InterestRate"));
                    TSetAmount.setText(rs.getString("SettleAmount"));
                } else {
                    JOptionPane.showMessageDialog(FixedAccount.this, "Invalid Account number to view", "View", JOptionPane.WARNING_MESSAGE);
                }

            }
            if (ae.getSource() == Close) {
                dispose();
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void choice1() {
        CBranch.addItem("B1");
        CBranch.addItem("B2");
        CBranch.addItem("B3");
    }

    public void choice2() {
//CAcType.addItem("Saving");
        CAcType.addItem("Fixed");
//CAcType.addItem("Recurring");
    }

    public void keyPressed(KeyEvent ee) {
        if (ee.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                ac = Integer.parseInt(TAcNo.getText());
                rs = stmt.executeQuery("select * from FixedAccount where AccountNo=" + ac);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(FixedAccount.this, "Account Number already exists", "Save", JOptionPane.INFORMATION_MESSAGE);
                    TAcNo.setText("");
                } else {
                    dat = new Date();
                }
                h = "" + dat;
                a = h.substring(4, 7);
                b = h.substring(8, 10);
                c = h.substring(30, 34);
                str = c + "/" + a + "/" + b;
                TDOJ.setText(str);
                TName.requestFocus();
            } catch (Exception s) {
            }
        }
    }

    public void keyReleased(KeyEvent ee) {
    }

    public void keyTyped(KeyEvent ee) {
    }

//    public static void main(String s[]) throws IOException {
//        try {
//            FixedAccount newacc = new FixedAccount();
//            newacc.setVisible(true);
//            newacc.setSize(800, 575);
//        } catch (Exception aae) {
//        }
//    }
}
