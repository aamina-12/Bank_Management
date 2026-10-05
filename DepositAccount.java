
import java.io.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

class DepositAccount extends JFrame implements ActionListener {

    String ss;
    JLabel Title, AcType, AcNumber, AcHolder, DepDate, Amount;
    JTextField TAcNumber, TAcHolder, TDepDate, TAmount;
    JButton new1, Deposit, Exit;
    Choice TAcType;
    Container con;
    Connection con1;
    Statement stmt;
    ResultSet rs;
    int acno, amt, amt1, cal;
    String s11;

    public DepositAccount() throws Exception {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        String msAccessDBName = "db\\bankdb.mdb";
        String dbURL = "jdbc:ucanaccess://" + msAccessDBName;
        con1 = DriverManager.getConnection(dbURL);
//        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//        con1 = DriverManager.getConnection("jdbc:odbc:NewAccount");
        stmt = con1.createStatement();

        con = getContentPane();
        con.setLayout(null);
        setTitle("DEPOSIT ACCOUNT");
        con.setBackground(new Color(13, 34, 56));
        Title = new JLabel("DEPOSIT ACCOUNT");
        Title.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
        Title.setForeground(Color.green);
        AcType = new JLabel("Account Type:", JLabel.LEFT);
        AcType.setForeground(Color.green);
        AcNumber = new JLabel("Account Number:", JLabel.LEFT);
        AcNumber.setForeground(Color.green);
        AcHolder = new JLabel("Account Holder:", JLabel.LEFT);
        AcHolder.setForeground(Color.green);
        DepDate = new JLabel("Account Date:", JLabel.LEFT);
        DepDate.setForeground(Color.green);
        Amount = new JLabel("Deposit Amount:", JLabel.LEFT);
        Amount.setForeground(Color.green);

        TAcType = new Choice();
        TAcType.setForeground(Color.green);
        TAcType.setBackground(new Color(13, 34, 56));
        TAcNumber = new JTextField();
        TAcNumber.setForeground(Color.green);
        TAcNumber.setBackground(new Color(13, 34, 56));
        TAcHolder = new JTextField();
        TAcHolder.setForeground(Color.green);
        TAcHolder.setBackground(new Color(13, 34, 56));
        String months[] = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        int year;
        GregorianCalendar gcalendar = new GregorianCalendar();
        ss = months[gcalendar.get(Calendar.MONTH)] + "-" + gcalendar.get(Calendar.DATE) + "-" + gcalendar.get(Calendar.YEAR);
        TDepDate = new JTextField(ss);

        TDepDate.setForeground(Color.green);
        TDepDate.setBackground(new Color(13, 34, 56));
        TAmount = new JTextField();
        TAmount.setForeground(Color.green);
        TAmount.setBackground(new Color(13, 34, 56));

        new1 = new JButton("New");
        new1.setForeground(Color.green);
        new1.setBackground(new Color(13, 34, 56));
        Deposit = new JButton("Deposit");
        Deposit.setForeground(Color.green);
        Deposit.setBackground(new Color(13, 34, 56));
        Exit = new JButton("Exit");
        Exit.setForeground(Color.green);
        Exit.setBackground(new Color(13, 34, 56));

        Title.setBounds(180, 30, 200, 25);
        AcType.setBounds(130, 80, 125, 25);
        AcNumber.setBounds(130, 125, 125, 25);
        AcHolder.setBounds(130, 170, 125, 25);
        DepDate.setBounds(130, 215, 125, 25);
        Amount.setBounds(130, 260, 125, 25);

        TAcType.setBounds(310, 80, 120, 25);
        TAcNumber.setBounds(310, 125, 120, 25);
        TAcHolder.setBounds(310, 170, 120, 25);
        TDepDate.setBounds(310, 215, 120, 25);
        TAmount.setBounds(310, 260, 120, 25);

        new1.setBounds(180, 330, 90, 25);
        Deposit.setBounds(290, 330, 90, 25);
        Exit.setBounds(400, 330, 90, 25);

        con.add(Title);
        con.add(AcType);
        con.add(TAcType);
        con.add(AcNumber);
        con.add(TAcNumber);
        con.add(AcHolder);
        con.add(TAcHolder);
        con.add(DepDate);
        con.add(TDepDate);
        con.add(Amount);
        con.add(TAmount);
        TAcHolder.setEnabled(false);

        con.add(new1);
        con.add(Deposit);
        con.add(Exit);
        choice1();
        Deposit.addActionListener(this);
        Exit.addActionListener(this);
        new1.addActionListener(this);
        TAmount.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                s11 = TAmount.getText();
                for (int i = 0; i < s11.length(); i++) {
                    if (!(Character.isDigit(s11.charAt(i)))) {
                        JOptionPane.showMessageDialog(DepositAccount.this, "please enter only numbers", "Error", JOptionPane.ERROR_MESSAGE);
                        TAmount.setText("");
                        break;
                    }
                }
            }
        });
        TAcNumber.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                s11 = TAcNumber.getText();
                for (int i = 0; i < s11.length(); i++) {
                    if (!(Character.isDigit(s11.charAt(i)))) {
                        JOptionPane.showMessageDialog(DepositAccount.this, "please enter only numbers", "Error", JOptionPane.ERROR_MESSAGE);
                        TAcNumber.setText("");
                        break;
                    }
                }
            }
        });
    }

    public void actionPerformed(ActionEvent k) {
        try {
            if (k.getSource() == new1) {
                TAcNumber.setText("");
                TAcHolder.setText("");
//TDepDate.setText("");
                TAmount.setText("");
            }
            if (k.getSource() == Deposit) {
                if (TAcType.getSelectedItem() == "Saving") {
                    acno = Integer.parseInt(TAcNumber.getText());
                    rs = stmt.executeQuery("select * from saveaccount where AccountNo=" + acno);
                    if (rs.next()) {
                        amt = rs.getInt("InitialAmount");
                        TAcHolder.setText(rs.getString("Name"));
                        amt1 = Integer.parseInt(TAmount.getText());
                        cal = amt + amt1;
                        stmt.executeUpdate("update saveaccount set InitialAmount='" + cal + "'  where AccountNo=" + acno);
                        con1.commit();
                        JOptionPane.showMessageDialog(DepositAccount.this, "Deposit Successfully", "Saving", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(DepositAccount.this, "Invalid Account No", "Saving", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                if (TAcType.getSelectedItem() == "Fixed") {
                    acno = Integer.parseInt(TAcNumber.getText());
                    rs = stmt.executeQuery("select * from FixedAccount where AccountNo=" + acno);
                    if (rs.next()) {
                        TAcHolder.setText(rs.getString("Name"));
                        amt = rs.getInt("FixedAmount");
                        amt1 = Integer.parseInt(TAmount.getText());
                        cal = amt + amt1;
                        stmt.executeUpdate("update FixedAccount set FixedAmount='" + cal + "' where AccountNo=" + acno);
                        con1.commit();
                        JOptionPane.showMessageDialog(DepositAccount.this, "Deposit Successfully", "Fixed", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(DepositAccount.this, "Invalid Account No", "Fixed", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                if (TAcType.getSelectedItem() == "Recurring") {
                    acno = Integer.parseInt(TAcNumber.getText());
                    rs = stmt.executeQuery("select * from RecurseAccount where AccountNo=" + acno);
                    if (rs.next()) {
                        TAcHolder.setText(rs.getString("Name"));
                        amt = rs.getInt("SettleAmount");
                        amt1 = Integer.parseInt(TAmount.getText());
                        cal = amt + amt1;
                        stmt.executeUpdate("update RecurseAccount set SettleAmount='" + cal + "' where AccountNo=" + acno);
                        con1.commit();
                        JOptionPane.showMessageDialog(DepositAccount.this, "Deposit Successfully", "Recurring", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(DepositAccount.this, "Invalid Account No", "Recurring", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                String sql = "insert into DepositAccount values('" + TAcType.getSelectedItem() + "','" + Integer.parseInt(TAcNumber.getText()) + "','" + TAcHolder.getText() + "','" + TDepDate.getText() + "','" + Integer.parseInt(TAmount.getText()) + "')";
                stmt.executeUpdate(sql);
            }
            if (k.getSource() == Exit) {
                dispose();
            }
        } catch (Exception f) {
        }
    }

    public void choice1() {
        TAcType.addItem("Saving");
        TAcType.addItem("Fixed");
        TAcType.addItem("Recurring");
    }

//    public static void main(String s[]) throws Exception {
//        DepositAccount newacc1 = new DepositAccount();
//        newacc1.setVisible(true);
//        newacc1.setSize(800, 575);
//    }
}
