
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class MDI extends JFrame implements ActionListener {

    JMenuBar mb;
    JMenu m1, m2, m3, m4;
    JMenuItem mi1, mi2, mi3, mi4, mi5, mi6, mi7, mi8, mi9, mi10, mi11, mi12;
    JButton b;

    public MDI() throws IOException {
        mb = new JMenuBar();
        m1 = new JMenu("New Account");
        mi1 = new JMenuItem("Saving Account");
        mi2 = new JMenuItem("Fixed Account");
        mi3 = new JMenuItem("Recurring Account");
        m2 = new JMenu("Transaction");
        mi4 = new JMenuItem("WithDraw Account");
        mi5 = new JMenuItem("Deposit Account");
        m3 = new JMenu("Loan");
        mi6 = new JMenuItem("New Loan");
        mi7 = new JMenuItem("Loan Transaction");
        m4 = new JMenu("Report");
//mi8=new JMenuItem("Saving");
        mi9 = new JMenuItem("Fixed");
        mi10 = new JMenuItem("Recurring");
        mi11 = new JMenuItem("Withdraw");
        mi12 = new JMenuItem("Deposit");
        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
        m2.add(mi4);
        m2.add(mi5);
        m3.add(mi6);
        m3.add(mi7);
//m4.add(mi8);
        m4.add(mi9);
        m4.add(mi10);
        m4.add(mi11);
        m4.add(mi12);
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        mb.add(m4);
        setJMenuBar(mb);
        mi1.addActionListener(this);
        mi2.addActionListener(this);
        mi3.addActionListener(this);
        mi4.addActionListener(this);
        mi5.addActionListener(this);
        mi6.addActionListener(this);
        mi7.addActionListener(this);
//mi8.addActionListener(this);
        mi9.addActionListener(this);
        mi10.addActionListener(this);
        mi11.addActionListener(this);
        mi12.addActionListener(this);
        Container con = getContentPane();
        con.setLayout(null);
        b = new JButton(new ImageIcon("nature8.jpg"));
        b.setBounds(0, 0, 800, 600);
//b.addActionListener(this);
        con.add(b);
    }

    public void actionPerformed(ActionEvent s) {
        try {
            if (s.getSource() == mi1) {
                SavingAccount newacc = new SavingAccount();
                newacc.setVisible(true);
                newacc.setLocation(0, 40);
                newacc.setSize(800, 490);
            }
            if (s.getSource() == mi2) {
                FixedAccount newacc = new FixedAccount();
                newacc.setVisible(true);
                newacc.setLocation(0, 40);
                newacc.setSize(800, 500);
            }
            if (s.getSource() == mi3) {
                RecurringAccount newacc = new RecurringAccount();
                newacc.setVisible(true);
                newacc.setLocation(0, 40);
                newacc.setSize(800, 500);
            }
            if (s.getSource() == mi4) {
                WithDrawAccount newacc1 = new WithDrawAccount();
                newacc1.setVisible(true);
                newacc1.setLocation(0, 40);
                newacc1.setSize(800, 490);
            }
            if (s.getSource() == mi5) {
                DepositAccount newacc1 = new DepositAccount();
                newacc1.setVisible(true);
                newacc1.setLocation(0, 40);
                newacc1.setSize(800, 490);
            }
            if (s.getSource() == mi6) {
                Loan newacc2 = new Loan();
                newacc2.setVisible(true);
                newacc2.setLocation(0, 40);
                newacc2.setSize(800, 500);
            }
            if (s.getSource() == mi7) {
                LoanTransaction aa = new LoanTransaction();
                aa.setVisible(true);
                aa.setLocation(0, 40);
                aa.setSize(800, 490);
            }
            if (s.getSource() == mi8) {
//RepSave newacc=new RepSave();
//newacc.setVisible(true);
//newacc.setLocation(0,40);
//newacc.setSize(800,500);
            }
            if (s.getSource() == mi9) {
                RepFix newacc = new RepFix();
                newacc.setVisible(true);
                newacc.setLocation(0, 40);
                newacc.setSize(800, 500);
            }
            if (s.getSource() == mi10) {
                RepRec newacc = new RepRec();
                newacc.setVisible(true);
                newacc.setLocation(0, 40);
                newacc.setSize(800, 500);
            }
            if (s.getSource() == mi11) {
                RepWD newacc = new RepWD();
                newacc.setVisible(true);
                newacc.setLocation(0, 40);
                newacc.setSize(800, 500);
            }
            if (s.getSource() == mi12) {
                RepDep newacc = new RepDep();
                newacc.setVisible(true);
                newacc.setLocation(0, 40);
                newacc.setSize(800, 500);
            }
        } catch (Exception f) {
        }
    }

//    public static void main(String a[]) throws Exception {
//        MDI md1 = new MDI();
//        md1.setVisible(true);
//        md1.setSize(800, 575);
//    }
}
