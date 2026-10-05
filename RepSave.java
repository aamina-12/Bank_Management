
import java.io.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.border.*;

public class RepSave extends JFrame implements ListSelectionListener {

    DefaultTableModel dt;
    JTable jt;
    JScrollPane jsp;
    Container cont;
    Connection con1;
    Statement stmt;
    ResultSet rs;
    int l, h, v;
    String str, h1, a, b, c, a1, b1, c1, str1;

    public RepSave() throws Exception {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        String msAccessDBName = "db\\bankdb.mdb";
        String dbURL = "jdbc:ucanaccess://" + msAccessDBName;
        con1 = DriverManager.getConnection(dbURL);
        stmt = con1.createStatement();
        cont = getContentPane();
        cont.setLayout(null);
        setTitle("Report Saving Account");
        Border b = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.red, Color.green);
        dt = new DefaultTableModel(11, 8);
        jt = new JTable(dt);
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
        cont.add(jsp);
        lsm.addListSelectionListener(this);
        try {
            rs = stmt.executeQuery("select * from saveaccount");
            l = 0;
            while (rs.next()) {
                jt.setValueAt(rs.getString(1), l, 0);
                jt.setValueAt(rs.getString(2), l, 1);
//jt.setValueAt(rs.getString(3),l,2);
//jt.setValueAt(rs.getString(4),l,3);

//jt.setValueAt(str);
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
//            RepSave newacc = new RepSave();
//            newacc.setVisible(true);
//            newacc.setSize(800, 575);
//        } catch (Exception aae) {
//        }
//    }
}
