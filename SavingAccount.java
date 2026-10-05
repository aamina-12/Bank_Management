
import java.io.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.util.*;

class SavingAccount extends JFrame implements ActionListener, KeyListener {

    int t = 0;
    String auto = "1", ss;
    JLabel AcNo, Title, Name, DOB, DOJ, ResAdd, OffAdd, PhoneNo, CellNo, Email, Intro, Qual, Branch, AcType, Amount;
    JTextField TAcNo, TName, TDOB, TDOJ, TResAdd, TOffAdd, TPhoneNo, TCellNo, TEmail, TIntro, TQual, TAmount;
    Choice CBranch, CAcType;
    JButton New, Save, View, Close;
    Container con;
    Connection con1;
    Statement stmt;
    ResultSet rs;
    String opt = "", s1, s11, str, str1;
    String a, b, c, h, h1, a1, b1, c1;
    int account, int1, int2, cal;
    Date dat;

    public SavingAccount() throws Exception {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        String msAccessDBName = "db\\bankdb.mdb";
        String dbURL = "jdbc:ucanaccess://" + msAccessDBName;

        con1 = DriverManager.getConnection(dbURL);

//        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//        con1 = DriverManager.getConnection("jdbc:odbc:NewAccount");
        stmt = con1.createStatement();

        con = getContentPane();
        con.setLayout(null);
        setTitle("SAVING ACCOUNT");
        con.setBackground(new Color(160, 180, 20));
        Title = new JLabel("SAVING ACCOUNT");
        Title.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
        Title.setForeground(Color.black);
        AcNo = new JLabel("Account No:", JLabel.LEFT);
        AcNo.setForeground(Color.black);
        Name = new JLabel("Name:", JLabel.LEFT);
        Name.setForeground(Color.black);
        DOB = new JLabel("Date of Birth:", JLabel.LEFT);
        DOB.setForeground(Color.black);
        DOJ = new JLabel("Date of account opening:", JLabel.LEFT);
        DOJ.setForeground(Color.black);
        ResAdd = new JLabel("Res.Address:", JLabel.LEFT);
        ResAdd.setForeground(Color.black);
        OffAdd = new JLabel("Off.Address:", JLabel.LEFT);
        OffAdd.setForeground(Color.black);
        PhoneNo = new JLabel("Phone No:", JLabel.LEFT);
        PhoneNo.setForeground(Color.black);
        CellNo = new JLabel("Cell No:", JLabel.LEFT);
        CellNo.setForeground(Color.black);
        Email = new JLabel("Email:", JLabel.LEFT);
        Email.setForeground(Color.black);
        Intro = new JLabel("Introducer:", JLabel.LEFT);
        Intro.setForeground(Color.black);
        Qual = new JLabel("Qualification:", JLabel.LEFT);
        Qual.setForeground(Color.black);
        Branch = new JLabel("Branch Code:", JLabel.LEFT);
        Branch.setForeground(Color.black);
        AcType = new JLabel("Account Type:", JLabel.LEFT);
        AcType.setForeground(Color.black);
        Amount = new JLabel("Initial Amount:", JLabel.LEFT);
        Amount.setForeground(Color.black);

        Title.setBounds(200, 20, 170, 25);
        AcNo.setBounds(10, 70, 125, 25);
        Name.setBounds(10, 110, 125, 25);
        DOB.setBounds(10, 150, 125, 25);
        DOJ.setBounds(10, 190, 150, 25);
        ResAdd.setBounds(10, 230, 125, 25);
        OffAdd.setBounds(10, 270, 125, 25);
        PhoneNo.setBounds(10, 310, 125, 25);
        CellNo.setBounds(350, 70, 125, 25);
        Email.setBounds(350, 110, 125, 25);
        Intro.setBounds(350, 150, 125, 25);
        Qual.setBounds(350, 190, 125, 25);
        Branch.setBounds(350, 230, 125, 25);
        AcType.setBounds(350, 270, 125, 25);
        Amount.setBounds(350, 310, 125, 25);

        TAcNo = new JTextField();
        TAcNo.setForeground(Color.black);
        TAcNo.setBackground(new Color(160, 180, 20));
        TName = new JTextField();
        TName.setForeground(Color.black);
        TName.setBackground(new Color(160, 180, 20));
        TDOB = new JTextField();
        TDOB.setForeground(Color.black);
        TDOB.setBackground(new Color(160, 180, 20));

        String months[] = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        int year;
        GregorianCalendar gcalendar = new GregorianCalendar();
        ss = months[gcalendar.get(Calendar.MONTH)] + "-" + gcalendar.get(Calendar.DATE) + "-" + gcalendar.get(Calendar.YEAR);
        TDOJ = new JTextField(ss);
        TDOJ.setForeground(Color.black);
        TDOJ.setBackground(new Color(160, 180, 20));
        TResAdd = new JTextField();
        TResAdd.setForeground(Color.black);
        TResAdd.setBackground(new Color(160, 180, 20));
        TOffAdd = new JTextField();
        TOffAdd.setForeground(Color.black);
        TOffAdd.setBackground(new Color(160, 180, 20));
        TPhoneNo = new JTextField();
        TPhoneNo.setForeground(Color.black);
        TPhoneNo.setBackground(new Color(160, 180, 20));
        TCellNo = new JTextField();
        TCellNo.setForeground(Color.black);
        TCellNo.setBackground(new Color(160, 180, 20));
        TEmail = new JTextField();
        TEmail.setForeground(Color.black);
        TEmail.setBackground(new Color(160, 180, 20));
        TIntro = new JTextField();
        TIntro.setForeground(Color.black);
        TIntro.setBackground(new Color(160, 180, 20));
        TQual = new JTextField();
        TQual.setForeground(Color.black);
        TQual.setBackground(new Color(160, 180, 20));
        CBranch = new Choice();
        CBranch.setForeground(Color.black);
        CBranch.setBackground(new Color(160, 180, 20));
        CAcType = new Choice();
        CAcType.setForeground(Color.black);
        CAcType.setBackground(new Color(160, 180, 20));
        TAmount = new JTextField();
        TAmount.setForeground(Color.black);
        TAmount.setBackground(new Color(160, 180, 20));

        TAcNo.setBounds(200, 70, 120, 25);
        TName.setBounds(200, 110, 120, 25);
        TDOB.setBounds(200, 150, 120, 25);
        TDOJ.setBounds(200, 190, 120, 25);
        TResAdd.setBounds(200, 230, 120, 25);
        TOffAdd.setBounds(200, 270, 120, 25);
        TPhoneNo.setBounds(200, 310, 120, 25);
        TCellNo.setBounds(480, 70, 120, 25);
        TEmail.setBounds(480, 110, 120, 25);
        TIntro.setBounds(480, 150, 120, 25);
        TQual.setBounds(480, 190, 120, 25);
        CBranch.setBounds(480, 230, 120, 25);
        CAcType.setBounds(480, 270, 120, 25);
        TAmount.setBounds(480, 310, 120, 25);

        New = new JButton("NEW");
        New.setForeground(Color.black);
        New.setBackground(new Color(160, 180, 20));
        Save = new JButton("ADD");
        Save.setForeground(Color.black);
        Save.setBackground(new Color(160, 180, 20));
        View = new JButton("VIEW");
        View.setForeground(Color.black);
        View.setBackground(new Color(160, 180, 20));
        Close = new JButton("CLOSE");
        Close.setForeground(Color.black);
        Close.setBackground(new Color(160, 180, 20));

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
                        JOptionPane.showMessageDialog(SavingAccount.this, "please enter only numbers", "Error", JOptionPane.ERROR_MESSAGE);
                        TAcNo.setText("");
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
                        JOptionPane.showMessageDialog(SavingAccount.this, "please enter only numbers", "Error", JOptionPane.ERROR_MESSAGE);
                        TAmount.setText("");
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
                        JOptionPane.showMessageDialog(SavingAccount.this, "please enter only numbers", "Error", JOptionPane.ERROR_MESSAGE);
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
                        JOptionPane.showMessageDialog(SavingAccount.this, "please enter only numbers", "Error", JOptionPane.ERROR_MESSAGE);
                        TCellNo.setText("");
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
                        JOptionPane.showMessageDialog(SavingAccount.this, "please enter only alphabets", "Error", JOptionPane.ERROR_MESSAGE);
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

                TAmount.setText("");
                TAcNo.setText("");
                TAmount.requestFocus();
                TName.setText("");
                TDOB.setText("");
//TDOJ.setText("");
                TResAdd.setText("");
                TOffAdd.setText("");
                TPhoneNo.setText("");
                TCellNo.setText("");
                TEmail.setText("");
                TIntro.setText("");
                TQual.setText("");
//                try {
//                    stmt = con1.createStatement();
//                    rs = stmt.executeQuery("SELECT MAX(AccountNo) FROM saveaccount");
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
            if (ae.getSource() == View) {
                String temp = JOptionPane.showInputDialog(SavingAccount.this, "Enter Account no toView", "View", JOptionPane.QUESTION_MESSAGE);
                int AcNo = Integer.parseInt(temp);
                rs = stmt.executeQuery("select * from saveaccount where AccountNo=" + AcNo);
                if (rs.next()) {
                    TAcNo.setText(rs.getString("AccountNo"));
                    TName.setText(rs.getString("Name"));
//h1=rs.getString("DOB");
//a1=h1.substring(0,4);
//b1=h1.substring(5,6);
//c1=h1.substring(7,8);
//str1=c1+"/"+b1+"/"+a1;
                    TDOB.setText(rs.getString("DOB"));
//h=rs.getString("DOJ");
//a=h.substring(0,1);
//b=h.substring(2,3);
//c=h.substring(4,8);
//str=b+"/"+a+"/"+c;
//TDOJ.setText(str);
                    TDOJ.setText(rs.getString("DOJ"));
                    TResAdd.setText(rs.getString("ResAddress"));
                    TOffAdd.setText(rs.getString("OffAddress"));
                    TPhoneNo.setText(rs.getString("PhoneNo"));
                    TCellNo.setText(rs.getString("CellNo"));
                    TEmail.setText(rs.getString("Email"));
                    TIntro.setText(rs.getString("Introducer"));
                    TQual.setText(rs.getString("Qualification"));
                    CBranch.select(rs.getString("BranchCode"));
                    CAcType.select(rs.getString("AccountType"));
                    TAmount.setText(rs.getString("InitialAmount"));
                } else {
                    JOptionPane.showMessageDialog(SavingAccount.this, "Invalid Account number to view", "View", JOptionPane.WARNING_MESSAGE);
                }
            }

            if (ae.getSource() == Save) {
                account = Integer.parseInt(TAcNo.getText());
                rs = stmt.executeQuery("select * from saveaccount where AccountNo=" + account);
                if (rs.next()) {
                    int1 = Integer.parseInt(rs.getString("InitialAmount"));
                    int2 = Integer.parseInt(TAmount.getText());
                    cal = int1 + int2;
                    String sql = "update saveaccount set InitialAmount='" + cal + "' where  AccountNo=" + account;
                    stmt.executeUpdate(sql);
                    con1.commit();
                    JOptionPane.showMessageDialog(SavingAccount.this, "Successfully saved", "Save", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String sql1 = "INSERT INTO saveaccount "
                            + "(AccountNo, Name, DOB, DOJ, ResAddress, OffAddress, PhoneNo, CellNo, Email, Introducer, Qualification, BranchCode, AccountType, InitialAmount) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
                    int rows = pst.executeUpdate();
                    JOptionPane.showMessageDialog(SavingAccount.this, "Successfully Added", "Save", JOptionPane.INFORMATION_MESSAGE);

                    TAmount.setText("");
                    TAcNo.setText("");
                    TAmount.requestFocus();
                    TName.setText("");
                    TDOB.setText("");
                    TResAdd.setText("");
                    TOffAdd.setText("");
                    TPhoneNo.setText("");
                    TCellNo.setText("");
                    TEmail.setText("");
                    TIntro.setText("");
                    TQual.setText("");
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
        CAcType.addItem("Saving");
    }

    public void keyPressed(KeyEvent s) {
        if (s.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                account = Integer.parseInt(TAcNo.getText());
                rs = stmt.executeQuery("select * from saveaccount where AccountNo=" + account);
                if (rs.next()) {
                    TName.setText(rs.getString("Name"));

                    h1 = rs.getString("DOB");
                    a1 = h1.substring(0, 1);
                    b1 = h1.substring(2, 3);
                    c1 = h1.substring(4, 6);
                    str1 = a1 + "/" + b1 + "/" + c1;
                    TDOB.setText(str1);
                    dat = new Date();
                    h = "" + dat;
                    System.out.println(dat);
                    a = h.substring(4, 7);
                    b = h.substring(8, 10);
                    c = h.substring(30, 34);
                    str = c + "/" + a + "/" + b;
                    TDOJ.setText(str);
                    TResAdd.setText(rs.getString("ResAddress"));
                    TOffAdd.setText(rs.getString("OffAddress"));
                    TPhoneNo.setText(rs.getString("PhoneNo"));
                    TCellNo.setText(rs.getString("CellNo"));
                    TEmail.setText(rs.getString("Email"));
                    TIntro.setText(rs.getString("Introducer"));
                    TQual.setText(rs.getString("Qualification"));
                    CBranch.select(rs.getString("BranchCode"));
                    CAcType.select(rs.getString("AccountType"));
                } else {
                    TName.requestFocus();
                }
            } catch (Exception f) {
            }
        }
    }

    public void keyReleased(KeyEvent s) {
    }

    public void keyTyped(KeyEvent s) {
    }

//    public static void main(String s[]) throws IOException {
//        try {
//            SavingAccount newacc = new SavingAccount();
//            newacc.setVisible(true);
//            newacc.setSize(800, 575);
//        } catch (Exception aae) {
//        }
//    }
}
