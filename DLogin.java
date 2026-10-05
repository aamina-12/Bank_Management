
import java.io.*;
import java.awt.*;
//import java.awt.List;
import java.awt.event.*;
import java.security.*;
import sun.misc.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.awt.image.*;

class NewUserDlg extends JFrame implements ActionListener {

    public JButton jbLogin, jbCancel;
    JLabel lblUserName, lblPassword, lblRePassword, lblHeading, jl4, err;

    JTextField txtUserName, md;
    JPasswordField txtPassword, txtRePassword;
    String un, up;
    byte[] buffer = new byte[8192];
    String input = new String();
    String msgDigest = new String();
    Connection cn;
    Statement st1;
    ResultSet rs1;

    public NewUserDlg() {
        super();
        Container con = getContentPane();
        con.setLayout(null);
        setTitle("New Login Form");
        Icon ic = new ImageIcon("images\\Globe1.GIF");
        JLabel jlIcon = new JLabel(ic);
        jlIcon.setBackground(Color.blue);
        jlIcon.setBounds(15, 20, 70, 70);
        lblHeading = new JLabel("New User Registration");
        lblHeading.setBounds(100, 20, 250, 30);
        lblHeading.setForeground(Color.pink);
        lblUserName = new JLabel("Username");
        lblUserName.setBounds(70, 100, 100, 30);
        lblUserName.setForeground(Color.pink);
        lblPassword = new JLabel("Password");
        lblPassword.setBounds(70, 150, 100, 30);
        lblPassword.setForeground(Color.pink);
        txtUserName = new JTextField(30);
        txtUserName.setBounds(160, 100, 140, 30);
        txtPassword = new JPasswordField(6);
        txtPassword.setBounds(160, 150, 140, 30);
        lblRePassword = new JLabel("Re Type");
        lblRePassword.setBounds(70, 200, 100, 30);
        lblRePassword.setForeground(Color.pink);

        txtRePassword = new JPasswordField(30);
        txtRePassword.setBounds(160, 200, 140, 30);

        jbLogin = new JButton("Submit");
        jbLogin.setBounds(100, 250, 90, 30);
        jbLogin.addActionListener(this);
        jbCancel = new JButton("Reset");
        jbCancel.setBounds(200, 250, 90, 30);

        jbCancel.addActionListener(this);

        md = new JTextField(50);
        md.setBounds(200, 300, 200, 30);
        md.setBackground(Color.white);
        md.setForeground(Color.blue);
        lblHeading.setFont(new Font("Times New Roman", Font.BOLD, 22));
        lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblRePassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
        txtUserName.setFont(new Font("Garamond", Font.BOLD, 16));
        txtPassword.setFont(new Font("Garamond", Font.BOLD, 16));
        txtRePassword.setFont(new Font("Garamond", Font.BOLD, 16));
        jbLogin.setBackground(Color.gray);
        jbCancel.setBackground(Color.gray);
        //res.setBackground(Color.darkGray);
        //conf.setBackground(Color.darkGray);
        jbLogin.setForeground(Color.white);
        jbCancel.setForeground(Color.white);

        txtUserName.setForeground(Color.black);
        txtPassword.setForeground(Color.black);
        jl4 = new JLabel("Message digest");
        jl4.setBounds(110, 300, 100, 30);
        //md1 = new JButton("MD");

        err = new JLabel("Know ur status of registration", JLabel.CENTER);
        err.setBackground(Color.blue);
        err.setForeground(Color.pink);
        err.setBounds(50, 250, 300, 90);
        err.setVisible(true);
        con.add(err);

//	con.add(conf);
        con.add(lblHeading);
        con.add(lblUserName);
        con.add(txtUserName);
        con.add(lblPassword);
        con.add(txtPassword);
        con.add(txtRePassword);
        con.add(lblRePassword);
        //con.add(md);
        con.add(jlIcon);
        con.add(lblRePassword);

        con.add(jbLogin);
        con.add(jbCancel);
        con.setBackground(Color.blue);
        setSize(800, 575);
        //show();
    }

    String digest(String input) {
        String base64 = new String();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");

            int length = input.length();
            for (int i = 0; i < length + 1; i = i + 1) {
                int upperLimit = i + 8191;
                if (upperLimit > length) {
                    upperLimit = length;
                }
                String chunk = input.substring(i, upperLimit);
                buffer = chunk.getBytes();
                md.update(buffer);
            }
            byte[] raw = md.digest();
            BASE64Encoder encoder = new BASE64Encoder();
            base64 = encoder.encode(raw);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return base64;

    }

    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource() == jbLogin) {
                if (txtPassword.getText().length() >= 6) {
                    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                    String msAccessDBName = "db\\bankdb.mdb";
                    String dbURL = "jdbc:ucanaccess://" + msAccessDBName;

                    cn = DriverManager.getConnection(dbURL);
                    st1 = cn.createStatement();
                    rs1 = st1.executeQuery("select * from login where username='" + txtUserName.getText() + "'");

                    if (rs1.next()) {
                        JOptionPane.showMessageDialog(this, "User already exist");
                        err.setText("User already exist");
                    } else {
                        if (txtPassword.getText().compareTo(txtRePassword.getText()) == 0) {
                            String st = digest(txtPassword.getText());
                            int n = st1.executeUpdate("insert into login values('" + txtUserName.getText() + "','" + st + "')");
                            st1.close();
                            err.setText("User has been added");
                            JOptionPane.showMessageDialog(this, "User has been added");

                        } else {
                            err.setText("ReType the correct password");
                            JOptionPane.showMessageDialog(this, "ReType the correct password");

                        }
                    }
                } else {
                    err.setText("Password should be atleast 6 characters in length");
                    JOptionPane.showMessageDialog(this, "Password should be atleast 6 characters in length");

                    txtPassword.setText("");
                    txtRePassword.setText("");
                }

            }

            if (e.getSource() == jbCancel) {
                txtUserName.setText("");
                txtPassword.setText("");
                txtRePassword.setText("");
            }

        } catch (Exception e1) {
            e1.printStackTrace();
            err.setText(e1.getMessage());
        }

    }

}

class DLogin extends JFrame implements ActionListener, KeyListener {

    JButton md1;
    public JButton jbLogin, jbCancel, jbNewUser;
    JLabel lblUserName, lblPassword, jl3, lblHeading, jl4, err;

    JTextField txtUserName, md;
    JPasswordField txtPassword;
    String un, up;
    byte[] buffer = new byte[8192];
    String input = new String();
    String msgDigest = new String();
    Connection cn;
    Statement st1;
    ResultSet rs1;
    Image img11;

    public DLogin() {
        // super(s,"Login Dialog",true);
        Container con = getContentPane();
        con.setLayout(null);
        //WindowHandler theWindowHandler = new WindowHandler();
        Icon ic = new ImageIcon("images\\Globe.GIF");

        img11 = getToolkit().getImage("images\\HI.GIF");
        JButton jlIcon = new JButton(ic);
        jlIcon.setBounds(15, 20, 80, 80);
        //jlIcon.setBackground(Color.pink);
        setTitle("Login Form");
        lblHeading = new JLabel("Login Window");
        lblHeading.setBounds(130, 20, 200, 30);

        lblUserName = new JLabel("User Name");
        lblUserName.setBounds(70, 100, 100, 30);
        lblPassword = new JLabel("Password");
        lblPassword.setBounds(70, 150, 100, 30);
        txtUserName = new JTextField(30);
        txtUserName.setBounds(160, 100, 140, 30);
        txtPassword = new JPasswordField(30);
        txtPassword.setBounds(160, 150, 140, 30);
        jbLogin = new JButton("Login");
        jbLogin.setBounds(50, 220, 90, 30);
        jbLogin.addActionListener(this);
        jbCancel = new JButton("Logout");
        jbCancel.setBounds(150, 220, 90, 30);
        jbNewUser = new JButton("New User");
        jbNewUser.setBounds(250, 220, 90, 30);
        jbNewUser.addActionListener(this);
        jbNewUser.setBackground(Color.darkGray);
        jbNewUser.setForeground(Color.white);

        jbCancel.addActionListener(this);

        jl3 = new JLabel("");
        jl3.setBounds(70, 350, 300, 100);
        jl3.setBackground(Color.pink);
        jl3.setForeground(Color.blue);
        jl3.setFont(new Font("Garamond", Font.BOLD, 16));
        md = new JTextField(50);
        md.setBounds(200, 300, 200, 30);
        md.setBackground(Color.white);
        md.setForeground(Color.blue);
        lblHeading.setFont(new Font("Times New Roman", Font.BOLD, 22));
        lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
        txtUserName.setFont(new Font("Garamond", Font.BOLD, 16));
        txtPassword.setFont(new Font("Garamond", Font.BOLD, 16));
        jbLogin.setBackground(Color.darkGray);
        jbCancel.setBackground(Color.darkGray);
        //res.setBackground(Color.darkGray);
        //conf.setBackground(Color.darkGray);
        jbLogin.setForeground(Color.white);
        jbCancel.setForeground(Color.white);
        //conf.setForeground(Color.white);
        //res.setForeground(Color.white);
        lblHeading.setBackground(Color.gray);
        lblUserName.setBackground(Color.gray);
        lblPassword.setBackground(Color.gray);
        txtUserName.setBackground(Color.white);
        lblHeading.setForeground(Color.black);
        lblUserName.setForeground(Color.black);
        lblPassword.setForeground(Color.black);
        txtUserName.setForeground(Color.black);
        txtPassword.setForeground(Color.black);
        jl4 = new JLabel("Message digest");
        jl4.setBounds(110, 300, 100, 30);
        md1 = new JButton("MD");
        md1.setBackground(Color.darkGray);
        md1.setForeground(Color.white);
        md1.setBounds(300, 220, 90, 30);
        md1.setVisible(true);
        //con.add(md1);
        md1.addActionListener(this);
        txtPassword.addKeyListener(this);
        err = new JLabel("Know ur status of login");
        err.setBackground(Color.blue);
        err.setForeground(Color.blue);
        err.setBounds(110, 250, 190, 90);
        err.setVisible(true);
        con.add(err);
//	con.add(conf);
        con.add(lblHeading);
        con.add(lblUserName);
        con.add(txtUserName);
        con.add(lblPassword);
        con.add(txtPassword);
        con.add(jl3);
        con.add(jlIcon);

        con.add(jbNewUser);
        con.add(jbLogin);
        con.add(jbCancel);
        con.setBackground(Color.pink);

    }

    String digest(String input) {
        String base64 = new String();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");

            int length = input.length();
            for (int i = 0; i < length + 1; i = i + 1) {
                int upperLimit = i + 8191;
                if (upperLimit > length) {
                    upperLimit = length;
                }
                String chunk = input.substring(i, upperLimit);
                buffer = chunk.getBytes();
                md.update(buffer);
            }
            byte[] raw = md.digest();
            BASE64Encoder encoder = new BASE64Encoder();
            base64 = encoder.encode(raw);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return base64;

    }

    //suj
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_ENTER) {

            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                String msAccessDBName = "db\\bankdb.mdb";
                String dbURL = "jdbc:ucanaccess://" + msAccessDBName;

                cn = DriverManager.getConnection(dbURL);
                st1 = cn.createStatement();
                String st = digest(txtPassword.getText());
                rs1 = st1.executeQuery("select * from login where username='" + txtUserName.getText() + "' and message='" + st + "'");

                if (rs1.next()) {
                    dispose();

                    MDI newacc = new MDI();
                    newacc.setVisible(true);
                    newacc.setSize(800, 575);
                } else {
                    JOptionPane.showMessageDialog(this, "user does not exists");

                    err.setText("user  does not exists");

                    //	err.setText("username added to DB");
                    //	rs1 = st1.executeQuery("insert into login values('"+txtUserName.getText()+"','"+md.getText()+"')");
                    st1.close();
                    rs1.close();
                }

            } catch (Exception e1) {
            }

        }

    }

    public void keyReleased(KeyEvent ke) {
    }

    public void keyTyped(KeyEvent ke) {
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbLogin) {
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                String msAccessDBName = "db\\bankdb.mdb";
                String dbURL = "jdbc:ucanaccess://" + msAccessDBName;

                cn = DriverManager.getConnection(dbURL);
                st1 = cn.createStatement();
                String st = digest(txtPassword.getText());
                rs1 = st1.executeQuery("select * from login where username='" + txtUserName.getText() + "' and message='" + st + "'");

                if (rs1.next()) {

                    dispose();
                    MDI newacc = new MDI();
                    newacc.setVisible(true);
                    newacc.setSize(800, 575);
                } else {
                    JOptionPane.showMessageDialog(this, "user does not exists");

                    err.setText("user  does not exists");

                    //	err.setText("username added to DB");
                    //	rs1 = st1.executeQuery("insert into login values('"+txtUserName.getText()+"','"+md.getText()+"')");
                    st1.close();
                    rs1.close();
                }

            } catch (Exception e1) {
            }

        }
        if (e.getSource() == jbNewUser) {
            try {
                NewUserDlg dd = new NewUserDlg();
                dd.setVisible(true);
            } catch (Exception e2) {
            }

        }

        if (e.getSource() == jbCancel) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        DLogin applet = new DLogin();
        applet.setVisible(true);
        applet.setSize(800, 575);

    }

}
