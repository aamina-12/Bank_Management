
import java.io.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.border.*;

public class RepFix extends JFrame implements ListSelectionListener {

    DefaultTableModel dt;
    JTable jt;
    JLabel lb;
    JScrollPane jsp;
    Container cont;
    Connection con1;
    Statement stmt;
    ResultSet rs;
    int l, h, v;

    public RepFix() throws Exception {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        String msAccessDBName = "db\\bankdb.mdb";
        String dbURL = "jdbc:ucanaccess://" + msAccessDBName;
        con1 = DriverManager.getConnection(dbURL);
        stmt = con1.createStatement();
        cont = getContentPane();
        cont.setLayout(null);
        setTitle("Report Fixed Account");
        Border b = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.red, Color.green);
        dt = new DefaultTableModel(11, 8);
        jt = new JTable(dt);
        lb = new JLabel("Report for Fixed Account");
        jt.setCellSelectionEnabled(true);
        ListSelectionModel lsm = jt.getSelectionModel();
        lsm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
        h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        jsp = new JScrollPane(jt, v, h);
        jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jt.getTableHeader().setReorderingAllowed(false);
        jt.setBorder(b);
        jt.setBackground(new Color(204, 153, 255));
        jt.setForeground(Color.black);
        jsp.setBounds(25, 105, 700, 200);
        lb.setBounds(250, 25, 400, 100);
        cont.add(jsp);
        cont.add(lb);
        lsm.addListSelectionListener(this);
        try {
            rs = stmt.executeQuery("select * from FixedAccount");
            l = 0;
            while (rs.next()) {
                jt.setValueAt(rs.getString(1), l, 0);
                jt.setValueAt(rs.getString(2), l, 1);
                jt.setValueAt(rs.getString(3), l, 2);
                jt.setValueAt(rs.getString(4), l, 3);
                jt.setValueAt(rs.getString(5), l, 4);
                jt.setValueAt(rs.getString(6), l, 5);
                jt.setValueAt(rs.getString(7), l, 6);
                jt.setValueAt(rs.getString(8), l, 7);
                l++;
            }
        } catch (Exception h) {
        }
    }

    public void valueChanged(ListSelectionEvent v) {

    }

//    public static void main(String s[]) {
//        try {
//            RepFix newacc = new RepFix();
//            newacc.setVisible(true);
//            newacc.setSize(800, 575);
//        } catch (Exception aae) {
//        }
//    }
}
