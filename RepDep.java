
import java.io.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.border.*;

public class RepDep extends JFrame implements ListSelectionListener {

    DefaultTableModel dt;
    JTable jt;
    JScrollPane jsp;
    Container cont;
    Connection con1;
    Statement stmt;
    ResultSet rs;
    int l, h, v;

    public RepDep() throws Exception {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        String msAccessDBName = "db\\bankdb.mdb";
        String dbURL = "jdbc:ucanaccess://" + msAccessDBName;
        con1 = DriverManager.getConnection(dbURL);
        stmt = con1.createStatement();
        cont = getContentPane();
        cont.setLayout(null);
        setTitle("Report Saving Account");
        Border b = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.red, Color.green);
        dt = new DefaultTableModel(11, 5);
        jt = new JTable(dt);
        jt.setCellSelectionEnabled(true);
        ListSelectionModel lsm = jt.getSelectionModel();
        lsm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        jsp = new JScrollPane(jt, v, h);
        jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jt.getTableHeader().setReorderingAllowed(false);
        jt.setBorder(b);
        jt.setBackground(new Color(204, 153, 255));
        jt.setForeground(Color.black);
        jsp.setBounds(120, 105, 700, 200);
        cont.add(jsp);
        lsm.addListSelectionListener(this);
        try {
            rs = stmt.executeQuery("select * from DepositAccount");
            l = 0;
            while (rs.next()) {
                jt.setValueAt(rs.getString(1), l, 0);
                jt.setValueAt(rs.getString(2), l, 1);
                jt.setValueAt(rs.getString(3), l, 2);
                jt.setValueAt(rs.getString(4), l, 3);
                jt.setValueAt(rs.getString(5), l, 4);
                l++;
            }
        } catch (Exception h) {
        }
    }

    public void valueChanged(ListSelectionEvent v) {

    }

//    public static void main(String s[]) {
//        try {
//            RepDep newacc = new RepDep();
//            newacc.setVisible(true);
//            newacc.setSize(800, 575);
//        } catch (Exception aae) {
//        }
//    }
}
