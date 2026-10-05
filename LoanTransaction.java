
import java.io.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class LoanTransaction extends JFrame implements ActionListener, ItemListener {

    int t = 0;//KeyListener,
    String auto = "1", ss, aa;
    JLabel CusName, LD, ID, IA, PB, CB, Title, lid;
    JTextField TCusName, TLD, TID, TIA, TPB, TCB;
    JButton Submit, Exit;
    JComboBox cid;
    Container con;
    Connection con1;
    Statement stmt;
    ResultSet rs;
    String nam = "", s11, s1, h1, a1, b1, c1, str1, d1, d2, d3, d4, d5, d6;
    int l, l1, l2;

    public LoanTransaction() throws Exception {

        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        String msAccessDBName = "db\\bankdb.mdb";
        String dbURL = "jdbc:ucanaccess://" + msAccessDBName;
        con1 = DriverManager.getConnection(dbURL);
        stmt = con1.createStatement();

        con = getContentPane();
        con.setLayout(null);
        setTitle("LOAN TRANSACTION");
        con.setBackground(new Color(155, 166, 221));
        Title = new JLabel("LOAN ACCOUNT");
        Title.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
        Title.setForeground(Color.green);
        CusName = new JLabel("Customer Name:", JLabel.LEFT);
        CusName.setForeground(Color.green);
        ID = new JLabel("Installment Date:", JLabel.LEFT);
        ID.setForeground(Color.green);
        LD = new JLabel("Loan date:", JLabel.LEFT);
        LD.setForeground(Color.green);
        IA = new JLabel("Installment  Amount:", JLabel.LEFT);
        IA.setForeground(Color.green);
        PB = new JLabel("Paid By:", JLabel.LEFT);
        PB.setForeground(Color.green);
        CB = new JLabel("Collected By:", JLabel.LEFT);
        CB.setForeground(Color.green);
        lid = new JLabel("Loan ID:", JLabel.LEFT);
        lid.setForeground(Color.green);

        Title.setBounds(200, 20, 155, 25);
        lid.setBounds(60, 70, 125, 25);
        CusName.setBounds(60, 110, 125, 25);
        LD.setBounds(60, 150, 125, 25);
        ID.setBounds(60, 190, 125, 25);
        IA.setBounds(60, 230, 150, 25);
        PB.setBounds(60, 270, 125, 25);
        CB.setBounds(60, 300, 125, 25);

        TCusName = new JTextField();
        TCusName.setForeground(Color.green);
        TCusName.setBackground(new Color(155, 166, 221));
        TLD = new JTextField();
        TLD.setForeground(Color.green);
        TLD.setBackground(new Color(155, 166, 221));
        TID = new JTextField();
        TID.setForeground(Color.green);
        TID.setBackground(new Color(155, 166, 221));
        TIA = new JTextField();
        TIA.setForeground(Color.green);
        TIA.setBackground(new Color(155, 166, 221));
        TPB = new JTextField();
        TPB.setForeground(Color.green);
        TPB.setBackground(new Color(155, 166, 221));
        TCB = new JTextField();
        TCB.setForeground(Color.green);
        TCB.setBackground(new Color(155, 166, 221));
        cid = new JComboBox();
        cid.setForeground(Color.green);
        cid.setBackground(new Color(155, 166, 221));
        cid.setBounds(230, 70, 120, 25);
        TCusName.setBounds(230, 110, 120, 25);
        TLD.setBounds(230, 150, 120, 25);
        TID.setBounds(230, 190, 120, 25);
        TIA.setBounds(230, 230, 120, 25);
        TPB.setBounds(230, 270, 120, 25);
        TCB.setBounds(230, 310, 120, 25);

        Submit = new JButton("Paid");
        Submit.setForeground(Color.green);
        Submit.setBackground(new Color(155, 166, 221));
        Exit = new JButton("Exit");
        Exit.setForeground(Color.green);
        Exit.setBackground(new Color(155, 166, 221));
        Submit.setBounds(350, 360, 120, 25);
//Exit.setBounds(230, 380, 130, 25);

//Submit.setBounds(390,330,80,25);
        Exit.setBounds(350, 400, 120, 25);

        con.add(Title);
        con.add(CusName);
        con.add(LD);
        con.add(ID);
        con.add(IA);
        con.add(PB);
        con.add(CB);
        con.add(lid);
        con.add(TCusName);
        con.add(TLD);
        con.add(TID);
        con.add(TIA);
        con.add(TPB);
        con.add(TCB);
        con.add(cid);
        con.add(Submit);
        con.add(Exit);

        Submit.addActionListener(this);
        Exit.addActionListener(this);
//TCusName.addKeyListener(this);
//TCusName.addKeyListener(new KeyAdapter()
//{
//public void keyPressed(KeyEvent ke)
//{
//s1=TCusName.getText();
//for(int i=0;i<s1.length();i++)
//{
//if(!(Character.isLetter(s1.charAt(i))))
//{
//JOptionPane.showMessageDialog(LoanTransaction.this,"please enter only alphabets","Error",JOptionPane.ERROR_MESSAGE);
//TCusName.setText("");
//break;
//}
//}
//}
//});
//TIA.addKeyListener(new KeyAdapter()
//{
//public void keyPressed(KeyEvent ke)
//{
//s11=TIA.getText();
//for(int i=0;i<s11.length();i++)
//{
//if(!(Character.isDigit(s11.charAt(i))))
//{
//JOptionPane.showMessageDialog(LoanTransaction.this,"please enter only numbers","Error",JOptionPane.ERROR_MESSAGE);
//TIA.setText("");
//break;
//}
//}
//}
//});
        try {
            rs = stmt.executeQuery("SELECT LID FROM Loan");

            while (rs.next()) {
                cid.addItem(rs.getString("LID"));
            }
        } catch (Exception e) {
            System.out.println("Loading Error... " + e);
        }

        cid.addItemListener(this);
    }

    public void itemStateChanged(ItemEvent ev) {
        if (ev.getStateChange() == ItemEvent.SELECTED) {
            String str1 = (String) cid.getSelectedItem();
            try {
                rs = stmt.executeQuery("SELECT * FROM Loan WHERE LID='" + str1 + "'");
                if (rs.next()) {
                    //TCusName,TLD,TID
                    TCusName.setText(rs.getString(2));
                    TLD.setText(rs.getString(3));
                    TID.setText(rs.getString(4));

                }
            } catch (SQLException ee) {
                System.out.println("rsDisp1 Exception " + ee);
            }
        }
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == Submit) {
                nam = TCusName.getText();
                String str = "select * from Loan where CusName='" + nam + "'";
                rs = stmt.executeQuery(str);
                if (rs.next()) {
                    l = rs.getInt("LA");
                    l1 = Integer.parseInt(TIA.getText());
                    l2 = l - l1;
                    //TCusName,TLD,TID,TIA,TPB,TCB
                    d1 = (String) cid.getSelectedItem();
//d2 = TCusName.getText();
//d3 = TLD.getText();
//d4 = TID.getText();

                    if (l2 < 0) {
                        JOptionPane.showMessageDialog(LoanTransaction.this, "Loan amount received", "Transaction", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        stmt.executeUpdate("update Loan set LA='" + l2 + "'  where CusName='" + nam + "'");
                        con1.commit();
                        JOptionPane.showMessageDialog(LoanTransaction.this, "Amount Received", "Transaction", JOptionPane.INFORMATION_MESSAGE);
                    }
                    String sql = "insert into LoanTran values('" + d1 + "','" + TCusName.getText() + "','" + TLD.getText() + "','" + TID.getText() + "','" + TIA.getText() + "','" + TPB.getText() + "','" + TCB.getText() + "')";

                    stmt.executeUpdate(sql);
                    con1.commit();
                } else {
                    JOptionPane.showMessageDialog(LoanTransaction.this, "Invalid", "Transaction", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if (ae.getSource() == Exit) {
                dispose();
            }
        } catch (Exception w) {
        }
    }

//    public static void main(String s[]) throws Exception {
//        LoanTransaction aa = new LoanTransaction();
//        aa.setVisible(true);
//        aa.setSize(800, 575);
//    }
}
