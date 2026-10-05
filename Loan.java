
import java.io.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class Loan extends JFrame implements ActionListener {

    int t = 0;
    String auto = "1", ss, aa;
    JLabel CusName, BD, LD, MonIns, LA, ID, IR, RA, OA, PN, Email, Title, lid;
    JTextField TCusName, TBD, TLD, TMonIns, TLA, TID, TIR, TRA, TOA, TPN, TEmail, cid;
    JButton Submit, Exit, New;
    //JComboBox cid;
    Container con;
    Connection con1;
    Statement stmt;
    ResultSet rs;
    String name = "", s11, s1;

    public Loan() throws Exception {

        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        String msAccessDBName = "db\\bankdb.mdb";
        String dbURL = "jdbc:ucanaccess://" + msAccessDBName;
        con1 = DriverManager.getConnection(dbURL);
        stmt = con1.createStatement();

        con = getContentPane();
        con.setLayout(null);
        setTitle("Loan Account");
        con.setBackground(new Color(13, 3, 56));
        Title = new JLabel("LOAN ACCOUNT");
        Title.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
        Title.setForeground(Color.green);
        CusName = new JLabel("Customer Name:", JLabel.LEFT);
        CusName.setForeground(Color.green);
        BD = new JLabel("BirthDate:", JLabel.LEFT);
        BD.setForeground(Color.green);
        LD = new JLabel("Loan date:", JLabel.LEFT);
        LD.setForeground(Color.green);
        MonIns = new JLabel("Monthly Installment:", JLabel.LEFT);
        MonIns.setForeground(Color.green);
        LA = new JLabel("Loan Amount:", JLabel.LEFT);
        LA.setForeground(Color.green);
        ID = new JLabel("Installment Date:", JLabel.LEFT);
        ID.setForeground(Color.green);
        IR = new JLabel("Interest Rate:", JLabel.LEFT);
        IR.setForeground(Color.green);
        RA = new JLabel("Residence Address:", JLabel.LEFT);
        RA.setForeground(Color.green);
        OA = new JLabel("Office Address:", JLabel.LEFT);
        OA.setForeground(Color.green);
        PN = new JLabel("Phone No:", JLabel.LEFT);
        PN.setForeground(Color.green);
        Email = new JLabel("Email:", JLabel.LEFT);
        Email.setForeground(Color.green);
        lid = new JLabel("Loan ID:", JLabel.LEFT);
        lid.setForeground(Color.green);

        Title.setBounds(200, 20, 155, 25);
//lid.setBounds(10, 25, 125, 25);
        lid.setBounds(10, 70, 125, 25);
        CusName.setBounds(10, 110, 125, 25);
        BD.setBounds(10, 150, 125, 25);
        LD.setBounds(10, 190, 150, 25);
        MonIns.setBounds(10, 230, 125, 25);
        LA.setBounds(10, 270, 125, 25);
        ID.setBounds(10, 300, 125, 25);

        IR.setBounds(350, 70, 125, 25);

        RA.setBounds(350, 120, 125, 25);
        OA.setBounds(350, 170, 125, 25);
        PN.setBounds(350, 220, 125, 25);
        Email.setBounds(350, 270, 125, 25);

			//CusName.setBounds(10, 110, 125, 25);
        //BD.setBounds(10, 150, 125, 25);
        //LD.setBounds(10, 190, 150, 25);
        //MonIns.setBounds(10, 230, 125, 25);
        //LA.setBounds(10, 270, 125, 25);
        //ID.setBounds(10, 270, 125, 25);
        //.setBounds(480, 70, 120, 25);
        cid = new JTextField();
        cid.setForeground(Color.green);
        cid.setBackground(new Color(13, 3, 56));

        TCusName = new JTextField();
        TCusName.setForeground(Color.green);
        TCusName.setBackground(new Color(13, 3, 56));
        TBD = new JTextField();
        TBD.setForeground(Color.green);
        TBD.setBackground(new Color(13, 3, 56));
        String months[] = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        int year;
        GregorianCalendar gcalendar = new GregorianCalendar();
        ss = months[gcalendar.get(Calendar.MONTH)] + "-" + gcalendar.get(Calendar.DATE) + "-" + gcalendar.get(Calendar.YEAR);
        aa = months[gcalendar.get(Calendar.MONTH) + 1] + "-" + gcalendar.get(Calendar.DATE) + "-" + (gcalendar.get(Calendar.YEAR));
        TLD = new JTextField(ss);
        TLD.setForeground(Color.green);
        TLD.setBackground(new Color(13, 3, 56));
        TMonIns = new JTextField();
        TMonIns.setForeground(Color.green);
        TMonIns.setBackground(new Color(13, 3, 56));
        TLA = new JTextField();
        TLA.setForeground(Color.green);
        TLA.setBackground(new Color(13, 3, 56));

        TID = new JTextField(aa);
        TID.setForeground(Color.green);
        TID.setBackground(new Color(13, 3, 56));
        TIR = new JTextField();
        TIR.setForeground(Color.green);
        TIR.setBackground(new Color(13, 3, 56));
        TRA = new JTextField();
        TRA.setForeground(Color.green);
        TRA.setBackground(new Color(13, 3, 56));
        TOA = new JTextField();
        TOA.setForeground(Color.green);
        TOA.setBackground(new Color(13, 3, 56));
        TPN = new JTextField();
        TPN.setForeground(Color.green);
        TPN.setBackground(new Color(13, 3, 56));
        TEmail = new JTextField();
        TEmail.setForeground(Color.green);
        TEmail.setBackground(new Color(13, 3, 56));
//cid.setBounds(200, 50, 120, 25);
        cid.setBounds(200, 70, 120, 25);
        TCusName.setBounds(200, 110, 120, 25);
        TBD.setBounds(200, 150, 120, 25);
        TLD.setBounds(200, 190, 120, 25);
        TMonIns.setBounds(200, 230, 120, 25);
        TLA.setBounds(200, 270, 120, 25);

        TID.setBounds(200, 300, 120, 25);
        TIR.setBounds(480, 70, 120, 25);
        TRA.setBounds(480, 120, 120, 25);
        TOA.setBounds(480, 170, 120, 25);
        TPN.setBounds(480, 220, 120, 25);
        TEmail.setBounds(480, 270, 120, 25);

        Submit = new JButton("Submit");
        Submit.setForeground(Color.green);
        Submit.setBackground(new Color(13, 3, 56));
        Exit = new JButton("Exit");
        Exit.setForeground(Color.green);
        Exit.setBackground(new Color(13, 3, 56));
        New = new JButton("New");
        New.setForeground(Color.green);
        New.setBackground(new Color(13, 3, 56));
        New.setBounds(200, 350, 80, 25);
        Submit.setBounds(290, 350, 80, 25);
        Exit.setBounds(380, 350, 80, 25);
        con.add(Title);
        con.add(CusName);
        con.add(BD);
        con.add(LD);
        con.add(MonIns);
        con.add(LA);
        con.add(ID);
        con.add(IR);
        con.add(RA);
        con.add(OA);
        con.add(PN);
        con.add(Email);
        con.add(lid);
        con.add(TCusName);
        con.add(TBD);
        con.add(TLD);
        con.add(TMonIns);
        con.add(TLA);
        con.add(TID);
        con.add(TIR);
        con.add(TRA);
        con.add(TOA);
        con.add(TPN);
        con.add(TEmail);
        con.add(cid);
        con.add(Submit);
        con.add(Exit);
        con.add(New);
        Submit.addActionListener(this);
        Exit.addActionListener(this);
        New.addActionListener(this);
        TCusName.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                s1 = TCusName.getText();
                for (int i = 0; i < s1.length(); i++) {
                    if (!(Character.isLetter(s1.charAt(i)))) {
                        JOptionPane.showMessageDialog(Loan.this, "please enter only alphabets", "Error", JOptionPane.ERROR_MESSAGE);
                        TCusName.setText("");
                        break;
                    }
                }
            }
        });
        TPN.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                s11 = TPN.getText();
                for (int i = 0; i < s11.length(); i++) {
                    if (!(Character.isDigit(s11.charAt(i)))) {
                        JOptionPane.showMessageDialog(Loan.this, "please enter only numbers", "Error", JOptionPane.ERROR_MESSAGE);
                        TPN.setText("");
                        break;
                    }
                }
            }
        });
        TIR.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                s11 = TIR.getText();
                for (int i = 0; i < s11.length(); i++) {
                    if (!(Character.isDigit(s11.charAt(i)))) {
                        JOptionPane.showMessageDialog(Loan.this, "please enter only numbers", "Error", JOptionPane.ERROR_MESSAGE);
                        TIR.setText("");
                        break;
                    }
                }
            }
        });
        TLA.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                s11 = TLA.getText();
                for (int i = 0; i < s11.length(); i++) {
                    if (!(Character.isDigit(s11.charAt(i)))) {
                        JOptionPane.showMessageDialog(Loan.this, "please enter only numbers", "Error", JOptionPane.ERROR_MESSAGE);
                        TLA.setText("");
                        break;
                    }
                }
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == New) {

                //TAmount.setText("");TCusName,TBD,TLD,TMonIns,TLA,TID,TIR,TRA,TOA,TPN,TEmail,cid
                TCusName.setText("");
                TBD.setText("");
                //TLD.seText("");
                TMonIns.setText("");
                //TLA.seText("");
                //TID.setText("");
                TIR.setText("");
                TRA.setText("");
                TOA.setText("");
                TPN.setText("");
                TEmail.setText("");
                TLA.setText("");

                try {
                    stmt = con1.createStatement();
                    rs = stmt.executeQuery("SELECT MAX(LID) FROM Loan");
                    rs.next();
                    t = Integer.parseInt(rs.getString(1));
                    if (t != 0) {
                        t = t + 1;
                    } else {
                        t = 1;
                    }
                    auto = String.valueOf(t).trim();
                    cid.setText(auto);
                    //stat.close();
                } catch (SQLException ne) {
                    t = 1;
                    auto = String.valueOf(t).trim();
                    cid.setText(auto);
                }
            }
            if (ae.getSource() == Submit) {
                String sql = "insert into Loan values('" + cid.getText() + "','" + TCusName.getText() + "','" + TBD.getText() + "','" + TLD.getText() + "','" + Integer.parseInt(TMonIns.getText()) + "','" + Integer.parseInt(TLA.getText()) + "','" + TID.getText() + "','" + Integer.parseInt(TIR.getText()) + "','" + TRA.getText() + "','" + TOA.getText() + "','" + Integer.parseInt(TPN.getText()) + "','" + TEmail.getText() + "')";
                stmt.executeUpdate(sql);
                con1.commit();
                JOptionPane.showMessageDialog(Loan.this, "Loan agreeded", "Loan", JOptionPane.INFORMATION_MESSAGE);
            }
            if (ae.getSource() == Exit) {
                dispose();
            }
        } catch (Exception ee) {
        }
    }

//    public static void main(String s[]) throws IOException {
//        try {
//            Loan newacc2 = new Loan();
//            newacc2.setVisible(true);
//            newacc2.setSize(800, 575);
//        } catch (Exception aae) {
//        }
//    }
}
