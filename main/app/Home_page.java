/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tanzim
 */
public class Home_page extends javax.swing.JFrame {

    String id = "asa";
    
    public Home_page(String temp) {
        initComponents();
        id = temp;
        info();
        show_elec();
        show_book();
        show_fashion();
        show_home();
        show_other();
        show_not();
        show_prof();
        show_dash();
    }
    private void info() {
        Connection con = null;
        Statement pst = null;
        ResultSet rs = null;
        con = DbConnection.ConnectionDB();
        try{
            pst = con.createStatement();
            rs = pst.executeQuery("SELECT * from Profile");
            
            while(rs.next()) {
                jLabel21.setText(id);
                if(rs.getString("user_name").equals(id)) {
                    jLabel28.setText(rs.getString("name"));
                    jLabel29.setText(rs.getString("id"));
                    jLabel30.setText(rs.getString("gender"));
                    jLabel31.setText(rs.getString("dept"));
                    jLabel32.setText(rs.getString("cont_num"));
                    jLabel21.setText(id);
                }
                
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Error!");
        }
        
    }

    private JPanel item(ResultSet rss) throws SQLException {
        JPanel temp = new JPanel();
        temp.setBackground(new Color(102,102,255));
        temp.setLayout(null);
                // image
                JLabel l1 = new JLabel();
                l1.setBounds(10, 10, 100, 100);
                ImageIcon image = new ImageIcon(new ImageIcon(rss.getBytes("image")).getImage()
             .getScaledInstance(100, 100, Image.SCALE_SMOOTH) );
                l1.setIcon(image);
                temp.add(l1);
                // name
                JLabel l2 = new JLabel("Name :");
                l2.setFont(new Font("Courier", Font.BOLD,12));
                l2.setBounds(120, 10, 100, 20);
                JLabel l3 = new JLabel(rss.getString("name"));
                l3.setBounds(120, 35, 100, 20);
                temp.add(l2);
                temp.add(l3);
                // description
                JLabel l4 = new JLabel("Description :");
                l4.setFont(new Font("Courier", Font.BOLD,12));
                l4.setBounds(120, 60, 100, 20);
                JLabel l5 = new JLabel("<html>" + rss.getString("Description") + "</html>");
                l5.setBounds(120, 85, 100, 50);
                l5.setHorizontalAlignment(JLabel.LEFT);
                l5.setVerticalAlignment(JLabel.TOP);
                temp.add(l4);
                temp.add(l5);
                // contact
                JLabel l6 = new JLabel("Contact :");
                l6.setFont(new Font("Courier", Font.BOLD,12));
                l6.setBounds(120, 140, 100, 20);
                JLabel l7 = new JLabel(rss.getString("Contact"));
                l7.setBounds(120, 165, 100, 20);
                temp.add(l6);
                temp.add(l7);
                // price
                JLabel l8 = new JLabel("price :");
                l8.setFont(new Font("Courier", Font.BOLD,12));
                l8.setBounds(10, 140, 100, 20);
                JLabel l9 = new JLabel(rss.getString("price"));
                l9.setBounds(10, 165, 100, 20);
                temp.add(l8);
                temp.add(l9);
                
                // buy button
                JButton b = new JButton("Buy");
                b.setBounds(80, 210, 80, 25);
                b.setBackground(Color.white);
                temp.add(b);
                String name = rss.getString("user_name");
                String pro_name = rss.getString("name");
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(name == id) {
                            JOptionPane.showMessageDialog(null, "This is your product!");
                        }
                        else
                        add_not(name, pro_name);
                    }
                });
                
                
        return temp;
    }
    private JPanel item1(ResultSet rss) throws SQLException {
        JPanel temp = new JPanel();
        temp.setBackground(new Color(102,102,255));
        temp.setLayout(null);
                // image
                JLabel l1 = new JLabel();
                l1.setBounds(10, 10, 100, 100);
                ImageIcon image = new ImageIcon(new ImageIcon(rss.getBytes("image")).getImage()
             .getScaledInstance(100, 100, Image.SCALE_SMOOTH) );
                l1.setIcon(image);
                temp.add(l1);
                // name
                JLabel l2 = new JLabel("Name :");
                l2.setFont(new Font("Courier", Font.BOLD,12));
                l2.setBounds(120, 10, 100, 20);
                JLabel l3 = new JLabel(rss.getString("name"));
                l3.setBounds(120, 35, 100, 20);
                temp.add(l2);
                temp.add(l3);
                // description
                JLabel l4 = new JLabel("Description :");
                l4.setFont(new Font("Courier", Font.BOLD,12));
                l4.setBounds(120, 60, 100, 20);
                JLabel l5 = new JLabel("<html>" + rss.getString("Description") + "</html>");
                l5.setBounds(120, 85, 100, 50);
                l5.setHorizontalAlignment(JLabel.LEFT);
                l5.setVerticalAlignment(JLabel.TOP);
                temp.add(l4);
                temp.add(l5);
                // contact
                JLabel l6 = new JLabel("Contact :");
                l6.setFont(new Font("Courier", Font.BOLD,12));
                l6.setBounds(120, 140, 100, 20);
                JLabel l7 = new JLabel(rss.getString("Contact"));
                l7.setBounds(120, 165, 100, 20);
                temp.add(l6);
                temp.add(l7);
                // price
                JLabel l8 = new JLabel("price :");
                l8.setFont(new Font("Courier", Font.BOLD,12));
                l8.setBounds(10, 140, 100, 20);
                JLabel l9 = new JLabel(rss.getString("price"));
                l9.setBounds(10, 165, 100, 20);
                temp.add(l8);
                temp.add(l9);
                
                // buy button
                JLabel l10 = new JLabel("Product Id:");
                l10.setFont(new Font("Courier", Font.BOLD,12));
                l10.setBounds(10, 210, 100, 20);
                JLabel l11 = new JLabel(rss.getString("Id"));
                l11.setBounds(100, 210, 100, 20);
                temp.add(l10);
                temp.add(l11);
         
                
                
        return temp;
    }
    private void add_not(String to,String name) {
        if(to.equals(id)) {
            JOptionPane.showMessageDialog(null, "You can't buy your products!");
            return;
        }
        Connection con1 = null;
        PreparedStatement pst1 = null;
        ResultSet rs1 = null;
        con1 = DbConnection.ConnectionDB();
        String sql = "INSERT INTO notification VALUES (?,?,?,?);";
        String mess = JOptionPane.showInputDialog(null, "Give your contact number and price");
        try{
            pst1 = con1.prepareStatement(sql);
            pst1.setString(1, to);
            pst1.setString(2, id);
            pst1.setString(3, name);
            pst1.setString(4, mess);
            pst1.execute();
            JOptionPane.showMessageDialog(null, "Sent!");
            ((DefaultTableModel)jTable1.getModel()).setRowCount(0);
            
            show_not();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error!");
        }
    }
    private void show_dash() {
        Connection con1 = null;
        Statement pst1 = null;
        ResultSet rs1 = null;
        con1 = DbConnection.ConnectionDB();
        try{
            pst1 = con1.createStatement();
            rs1 = pst1.executeQuery("SELECT * from Books");
            int i = 1,x = 30, y = 10;
            while(rs1.next()) {
                JPanel temp = item(rs1);
                temp.setBounds(x, y, 240, 240);
                jPanel19.add((temp));
                if(i % 3 == 0) {
                    x = 30;
                    y = y + 250;
                }
                else x = x + 250;
                ++i;
            }
            jPanel19.setMaximumSize(new Dimension(x + 50, y + 300));
            jPanel19.setPreferredSize(new Dimension(x + 50, y + 300));
            jPanel19.repaint();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error!");
        }
    }
    private void show_prof() {
        Connection con = null;
        Statement pst = null;
        ResultSet rs = null;
        con = DbConnection.ConnectionDB();
        try{
            pst = con.createStatement();
            rs = pst.executeQuery("SELECT * from Books");
            int i = 1,x = 10, y = 10;
            while(rs.next()) {
                if((rs.getString("user_name").equals(id))) {
                    JPanel temp = item1(rs);
                    temp.setBounds(x, y, 240, 240);
                    jPanel18.add(temp);
                    if(i % 2 == 0) {
                        x = 10;
                        y = y + 250;
                    }
                    else x = x + 250;
                    ++i;
                }
                
            }
            jPanel18.setMaximumSize(new Dimension(x + 300, y + 300));
            jPanel18.setPreferredSize(new Dimension(x + 300, y + 300));
        }
        catch(Exception e) {
            
        }
    }
    private void show_elec() {
        Connection con = null;
        Statement pst = null;
        ResultSet rs = null;
        con = DbConnection.ConnectionDB();
        try{
            pst = con.createStatement();
            rs = pst.executeQuery("SELECT * from Books");
            int i = 1,x = 30, y = 10;
            while(rs.next()) {
                if(!(rs.getString("cate").equals("Electronics"))) continue;
                JPanel temp = item(rs);
                temp.setBounds(x, y, 240, 240);
                jPanel14.add(temp);
                if(i % 3 == 0) {
                    x = 30;
                    y = y + 250;
                }
                else x = x + 250;
                ++i;
            }
            jPanel14.setMaximumSize(new Dimension(x + 50, y + 300));
            jPanel14.setPreferredSize(new Dimension(x + 50, y + 300));
        }
        catch(Exception e) {
            
        }
    }
    private void show_book() {
        Connection con = null;
        Statement pst = null;
        ResultSet rs = null;
        con = DbConnection.ConnectionDB();
        try{
            pst = con.createStatement();
            rs = pst.executeQuery("SELECT * from Books");
            int i = 1,x = 30, y = 10;
            while(rs.next()) {
                if(!(rs.getString("cate").equals("Books"))) continue;
                JPanel temp = item(rs);
                temp.setBounds(x, y, 240, 240);
                jPanel13.add(temp);
                if(i % 3 == 0) {
                    x = 30;
                    y = y + 250;
                }
                else x = x + 250;
                ++i;
            }
            jPanel13.setMaximumSize(new Dimension(x + 50, y + 300));
            jPanel13.setPreferredSize(new Dimension(x + 50, y + 300));
        }
        catch(Exception e) {
            
        }
    }
    private void show_fashion() {
        Connection con = null;
        Statement pst = null;
        ResultSet rs = null;
        con = DbConnection.ConnectionDB();
        try{
            pst = con.createStatement();
            rs = pst.executeQuery("SELECT * from Books");
            int i = 1,x = 30, y = 10;
            while(rs.next()) {
                if(!(rs.getString("cate").equals("Fashion"))) continue;
                JPanel temp = item(rs);
                temp.setBounds(x, y, 240, 240);
                jPanel12.add(temp);
                if(i % 3 == 0) {
                    x = 30;
                    y = y + 250;
                }
                else x = x + 250;
                ++i;
            }
            jPanel12.setMaximumSize(new Dimension(x + 50, y + 300));
            jPanel12.setPreferredSize(new Dimension(x + 50, y + 300));
        }
        catch(Exception e) {
            
        }
    }
    private void show_home() {
        Connection con = null;
        Statement pst = null;
        ResultSet rs = null;
        con = DbConnection.ConnectionDB();
        try{
            pst = con.createStatement();
            rs = pst.executeQuery("SELECT * from Books");
            int i = 1,x = 30, y = 10;
            while(rs.next()) {
                if(!(rs.getString("cate").equals("Home & Living"))) continue;
                JPanel temp = item(rs);
                temp.setBounds(x, y, 240, 240);
                jPanel15.add(temp);
                if(i % 3 == 0) {
                    x = 30;
                    y = y + 250;
                }
                else x = x + 250;
                ++i;
            }
            jPanel15.setMaximumSize(new Dimension(x + 50, y + 300));
            jPanel15.setPreferredSize(new Dimension(x + 50, y + 300));
        }
        catch(Exception e) {
            
        }
    }
    private void show_other() {
        Connection con = null;
        Statement pst = null;
        ResultSet rs = null;
        con = DbConnection.ConnectionDB();
        try{
            pst = con.createStatement();
            rs = pst.executeQuery("SELECT * from Books");
            int i = 1,x = 30, y = 10;
            while(rs.next()) {
                if(!(rs.getString("cate").equals("Others"))) continue;
                JPanel temp = item(rs);
                temp.setBounds(x, y, 240, 240);
                jPanel16.add(temp);
                if(i % 3 == 0) {
                    x = 30;
                    y = y + 250;
                }
                else x = x + 250;
                ++i;
            }
            jPanel16.setMaximumSize(new Dimension(x + 50, y + 300));
            jPanel16.setPreferredSize(new Dimension(x + 50, y + 300));
        }
        catch(Exception e) {
            
        }
    }
    private void show_not () {
        Connection con1 = null;
        Statement pst1 = null;
        ResultSet rs1 = null;
        con1 = DbConnection.ConnectionDB();
        try{
            pst1 = con1.createStatement();
            rs1 = pst1.executeQuery("SELECT * from notification");
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            while(rs1.next()) {
                if(rs1.getString(1).equals(id))
                model.addRow(new Object[]{rs1.getString(2),rs1.getString(3),rs1.getString(4)});
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error!");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        cat1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cat2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cat3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cat5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cat4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cat_home = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        pnicards = new javax.swing.JPanel();
        home = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jTextField5 = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jPanel19 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        pnicard1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel14 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        pnicard2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel13 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        pnicard3 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel12 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        pnicard4 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel15 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        pnicard5 = new javax.swing.JPanel();
        jButton18 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        jPanel16 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        pnisell = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel38 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel40 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        cate = new javax.swing.JComboBox<>();
        pniprofile = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel18 = new javax.swing.JPanel();
        pninot = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSplitPane1.setBackground(new java.awt.Color(0, 51, 153));
        jSplitPane1.setDividerLocation(-3);
        jSplitPane1.setDividerSize(3);
        jSplitPane1.setForeground(new java.awt.Color(102, 255, 204));

        jPanel2.setBackground(new java.awt.Color(0, 51, 153));

        cat1.setBackground(new java.awt.Color(236, 235, 235));
        cat1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cat1MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Siemens Sans", 1, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/gadgets.png"))); // NOI18N
        jLabel1.setText("ELECTRONICS");

        javax.swing.GroupLayout cat1Layout = new javax.swing.GroupLayout(cat1);
        cat1.setLayout(cat1Layout);
        cat1Layout.setHorizontalGroup(
            cat1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cat1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cat1Layout.setVerticalGroup(
            cat1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cat1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cat2.setBackground(new java.awt.Color(236, 235, 235));
        cat2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cat2MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Siemens Sans", 1, 12)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/book-stack.png"))); // NOI18N
        jLabel2.setText("BOOKS");

        javax.swing.GroupLayout cat2Layout = new javax.swing.GroupLayout(cat2);
        cat2.setLayout(cat2Layout);
        cat2Layout.setHorizontalGroup(
            cat2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cat2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cat2Layout.setVerticalGroup(
            cat2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cat2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        cat3.setBackground(new java.awt.Color(236, 235, 235));
        cat3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cat3MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Siemens Sans", 1, 12)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/male-clothes.png"))); // NOI18N
        jLabel3.setText("FASHION");

        javax.swing.GroupLayout cat3Layout = new javax.swing.GroupLayout(cat3);
        cat3.setLayout(cat3Layout);
        cat3Layout.setHorizontalGroup(
            cat3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cat3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cat3Layout.setVerticalGroup(
            cat3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cat3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        cat5.setBackground(new java.awt.Color(236, 235, 235));
        cat5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cat5MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Siemens Sans", 1, 12)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/three-dots.png"))); // NOI18N
        jLabel5.setText("OTHERS");

        javax.swing.GroupLayout cat5Layout = new javax.swing.GroupLayout(cat5);
        cat5.setLayout(cat5Layout);
        cat5Layout.setHorizontalGroup(
            cat5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cat5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cat5Layout.setVerticalGroup(
            cat5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cat5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        cat4.setBackground(new java.awt.Color(236, 235, 235));
        cat4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cat4MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Siemens Sans", 1, 12)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/furniture.png"))); // NOI18N
        jLabel4.setText("HOME & LIVINGS");

        javax.swing.GroupLayout cat4Layout = new javax.swing.GroupLayout(cat4);
        cat4.setLayout(cat4Layout);
        cat4Layout.setHorizontalGroup(
            cat4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cat4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        cat4Layout.setVerticalGroup(
            cat4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cat4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        cat_home.setBackground(new java.awt.Color(0, 51, 153));
        cat_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cat_homeMouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Logo small.png"))); // NOI18N
        jLabel12.setText("CUET.SHOP");

        javax.swing.GroupLayout cat_homeLayout = new javax.swing.GroupLayout(cat_home);
        cat_home.setLayout(cat_homeLayout);
        cat_homeLayout.setHorizontalGroup(
            cat_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cat_homeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        cat_homeLayout.setVerticalGroup(
            cat_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cat_homeLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton8.setFont(new java.awt.Font("Siemens Sans", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/user.png"))); // NOI18N
        jButton8.setText("tanzim");
        jButton8.setContentAreaFilled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Siemens Sans", 1, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/turn-off.png"))); // NOI18N
        jButton9.setText("Log out");
        jButton9.setContentAreaFilled(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton16.setFont(new java.awt.Font("Siemens Sans", 1, 12)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/notification-bell.png"))); // NOI18N
        jButton16.setText("Notifications");
        jButton16.setContentAreaFilled(false);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cat1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cat2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cat3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cat4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cat5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cat_home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator5)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton16)
                    .addComponent(jButton9)
                    .addComponent(jButton8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cat_home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(cat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cat2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cat3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cat4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cat5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton16)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel2);

        pnicards.setBackground(new java.awt.Color(255, 255, 255));
        pnicards.setLayout(new java.awt.CardLayout());

        home.setBackground(new java.awt.Color(204, 204, 255));

        jButton2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 204));
        jButton2.setText("X");
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/selling.png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField5.setFont(new java.awt.Font("Siemens Sans", 0, 14)); // NOI18N
        jTextField5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        jTextField5.setSelectionColor(new java.awt.Color(0, 51, 204));

        jButton17.setBackground(new java.awt.Color(0, 51, 204));
        jButton17.setForeground(new java.awt.Color(255, 255, 255));
        jButton17.setContentAreaFilled(false);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jScrollPane8.setBorder(null);

        jPanel19.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 816, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );

        jScrollPane8.setViewportView(jPanel19);

        jLabel7.setFont(new java.awt.Font("Siemens Sans", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 204));
        jLabel7.setText("Fresh recommendations");

        jLabel8.setText("Follow us");

        jLabel15.setText("Copyright © 1904037,1904052");

        jLabel18.setFont(new java.awt.Font("Siemens Sans", 1, 12)); // NOI18N
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/info.png"))); // NOI18N
        jLabel18.setText("About us");

        jLabel47.setFont(new java.awt.Font("Siemens Sans", 1, 12)); // NOI18N
        jLabel47.setText("Download app");

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search.png"))); // NOI18N

        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/google-play.png"))); // NOI18N

        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/app-store.png"))); // NOI18N

        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/facebook.png"))); // NOI18N

        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/instagram.png"))); // NOI18N

        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/twitter.png"))); // NOI18N

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(homeLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homeLayout.createSequentialGroup()
                        .addComponent(jTextField5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton17)
                            .addComponent(jLabel52)))
                    .addGroup(homeLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addComponent(jScrollPane8)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homeLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(homeLayout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 334, Short.MAX_VALUE)
                        .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, homeLayout.createSequentialGroup()
                                .addComponent(jLabel48)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel49))
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel61)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel62)
                        .addGap(117, 117, 117)))
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homeLayout.createSequentialGroup()
                        .addComponent(jLabel63)
                        .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(homeLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel10)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13))
                            .addGroup(homeLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel64)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel65))))
                    .addComponent(jLabel8))
                .addGap(20, 20, 20))
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homeLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton17)
                            .addGroup(homeLayout.createSequentialGroup()
                                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel52))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addGap(12, 12, 12))
                            .addGroup(homeLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel63)
                                    .addComponent(jLabel64)
                                    .addComponent(jLabel65))
                                .addGap(8, 8, 8)
                                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel13))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(jLabel61)
                            .addComponent(jLabel62))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel48)
                            .addComponent(jLabel49))
                        .addGap(25, 25, 25))))
        );

        pnicards.add(home, "card7");

        pnicard1.setBackground(new java.awt.Color(204, 204, 255));

        jButton3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 51, 204));
        jButton3.setText("X");
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(153, 204, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 204));
        jLabel14.setText("Electronics Category");

        jScrollPane3.setBorder(null);

        jPanel14.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 816, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 636, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jPanel14);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        jLabel6.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Filter by price :");

        jLabel9.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("to");

        jButton7.setBackground(new java.awt.Color(0, 51, 204));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Apply");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton19.setBackground(new java.awt.Color(0, 51, 204));
        jButton19.setForeground(new java.awt.Color(255, 255, 255));
        jButton19.setText("Reset");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7)
                    .addComponent(jButton19))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnicard1Layout = new javax.swing.GroupLayout(pnicard1);
        pnicard1.setLayout(pnicard1Layout);
        pnicard1Layout.setHorizontalGroup(
            pnicard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
            .addGroup(pnicard1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnicard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnicard1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addGroup(pnicard1Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
        );
        pnicard1Layout.setVerticalGroup(
            pnicard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnicard1Layout.createSequentialGroup()
                .addComponent(jButton3)
                .addGap(15, 15, 15)
                .addGroup(pnicard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE))
        );

        pnicards.add(pnicard1, "pnicard1");

        pnicard2.setBackground(new java.awt.Color(204, 204, 255));

        jButton4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 51, 204));
        jButton4.setText("X");
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 204));
        jLabel16.setText("Books Category");

        jScrollPane2.setBorder(null);

        jPanel13.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 826, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 543, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel13);

        jLabel50.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(102, 102, 102));
        jLabel50.setText("Filter by price :");

        jLabel51.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(102, 102, 102));
        jLabel51.setText("Filter by price :");

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        jLabel53.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(102, 102, 102));
        jLabel53.setText("Filter by price :");

        jLabel54.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(102, 102, 102));
        jLabel54.setText("to");

        jButton20.setBackground(new java.awt.Color(0, 51, 204));
        jButton20.setForeground(new java.awt.Color(255, 255, 255));
        jButton20.setText("Apply");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setBackground(new java.awt.Color(0, 51, 204));
        jButton21.setForeground(new java.awt.Color(255, 255, 255));
        jButton21.setText("Reset");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20)
                    .addComponent(jButton21))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnicard2Layout = new javax.swing.GroupLayout(pnicard2);
        pnicard2.setLayout(pnicard2Layout);
        pnicard2Layout.setHorizontalGroup(
            pnicard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnicard2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
            .addGroup(pnicard2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addComponent(jScrollPane2)
            .addGroup(pnicard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnicard2Layout.createSequentialGroup()
                    .addGap(353, 353, 353)
                    .addComponent(jLabel50)
                    .addContainerGap(362, Short.MAX_VALUE)))
            .addGroup(pnicard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnicard2Layout.createSequentialGroup()
                    .addContainerGap(371, Short.MAX_VALUE)
                    .addComponent(jLabel51)
                    .addGap(344, 344, 344)))
        );
        pnicard2Layout.setVerticalGroup(
            pnicard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnicard2Layout.createSequentialGroup()
                .addComponent(jButton4)
                .addGap(10, 10, 10)
                .addGroup(pnicard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2))
            .addGroup(pnicard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnicard2Layout.createSequentialGroup()
                    .addGap(308, 308, 308)
                    .addComponent(jLabel50)
                    .addContainerGap(308, Short.MAX_VALUE)))
            .addGroup(pnicard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnicard2Layout.createSequentialGroup()
                    .addContainerGap(318, Short.MAX_VALUE)
                    .addComponent(jLabel51)
                    .addGap(298, 298, 298)))
        );

        pnicards.add(pnicard2, "pnicard2");

        pnicard3.setBackground(new java.awt.Color(204, 204, 255));

        jButton5.setBackground(new java.awt.Color(0, 204, 255));
        jButton5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 51, 204));
        jButton5.setText("X");
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(null);

        jPanel12.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 826, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel12);

        jLabel25.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 51, 204));
        jLabel25.setText("Fashion Category");

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));

        jLabel55.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(102, 102, 102));
        jLabel55.setText("Filter by price :");

        jLabel56.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(102, 102, 102));
        jLabel56.setText("to");

        jButton22.setBackground(new java.awt.Color(0, 51, 204));
        jButton22.setForeground(new java.awt.Color(255, 255, 255));
        jButton22.setText("Apply");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setBackground(new java.awt.Color(0, 51, 204));
        jButton23.setForeground(new java.awt.Color(255, 255, 255));
        jButton23.setText("Reset");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel55)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton23)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton22)
                    .addComponent(jButton23))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnicard3Layout = new javax.swing.GroupLayout(pnicard3);
        pnicard3.setLayout(pnicard3Layout);
        pnicard3Layout.setHorizontalGroup(
            pnicard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnicard3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5))
            .addGroup(pnicard3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel25)
                .addGap(154, 154, 154)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        pnicard3Layout.setVerticalGroup(
            pnicard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnicard3Layout.createSequentialGroup()
                .addGroup(pnicard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnicard3Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel25))
                    .addGroup(pnicard3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1))
        );

        pnicards.add(pnicard3, "pnicard3");

        pnicard4.setBackground(new java.awt.Color(204, 204, 255));

        jButton6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 51, 204));
        jButton6.setText("X");
        jButton6.setContentAreaFilled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jScrollPane4.setBorder(null);

        jPanel15.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 826, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 543, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(jPanel15);

        jLabel17.setBackground(new java.awt.Color(153, 204, 255));
        jLabel17.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 51, 204));
        jLabel17.setText("Home & Living Category");

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));

        jLabel59.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(102, 102, 102));
        jLabel59.setText("Filter by price :");

        jLabel60.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(102, 102, 102));
        jLabel60.setText("to");

        jButton26.setBackground(new java.awt.Color(0, 51, 204));
        jButton26.setForeground(new java.awt.Color(255, 255, 255));
        jButton26.setText("Apply");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton27.setBackground(new java.awt.Color(0, 51, 204));
        jButton27.setForeground(new java.awt.Color(255, 255, 255));
        jButton27.setText("Reset");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel59)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton27)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton26)
                    .addComponent(jButton27))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnicard4Layout = new javax.swing.GroupLayout(pnicard4);
        pnicard4.setLayout(pnicard4Layout);
        pnicard4Layout.setHorizontalGroup(
            pnicard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnicard4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6))
            .addComponent(jScrollPane4)
        );
        pnicard4Layout.setVerticalGroup(
            pnicard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnicard4Layout.createSequentialGroup()
                .addGroup(pnicard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnicard4Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel17))
                    .addGroup(pnicard4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane4))
        );

        pnicards.add(pnicard4, "pnicard4");

        pnicard5.setBackground(new java.awt.Color(204, 204, 255));

        jButton18.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton18.setForeground(new java.awt.Color(0, 51, 204));
        jButton18.setText("X");
        jButton18.setContentAreaFilled(false);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jScrollPane10.setBorder(null);

        jPanel16.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 826, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 543, Short.MAX_VALUE)
        );

        jScrollPane10.setViewportView(jPanel16);

        jLabel44.setBackground(new java.awt.Color(153, 204, 255));
        jLabel44.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 51, 204));
        jLabel44.setText("Others Category");

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));

        jLabel57.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(102, 102, 102));
        jLabel57.setText("Filter by price :");

        jLabel58.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(102, 102, 102));
        jLabel58.setText("to");

        jButton24.setBackground(new java.awt.Color(0, 51, 204));
        jButton24.setForeground(new java.awt.Color(255, 255, 255));
        jButton24.setText("Apply");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setBackground(new java.awt.Color(0, 51, 204));
        jButton25.setForeground(new java.awt.Color(255, 255, 255));
        jButton25.setText("Reset");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel57)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel58)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton24)
                    .addComponent(jButton25))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnicard5Layout = new javax.swing.GroupLayout(pnicard5);
        pnicard5.setLayout(pnicard5Layout);
        pnicard5Layout.setHorizontalGroup(
            pnicard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnicard5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnicard5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addComponent(jScrollPane10)
        );
        pnicard5Layout.setVerticalGroup(
            pnicard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnicard5Layout.createSequentialGroup()
                .addGroup(pnicard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnicard5Layout.createSequentialGroup()
                        .addComponent(jButton18)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel44))
                    .addGroup(pnicard5Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane10))
        );

        pnicards.add(pnicard5, "pnicard4");

        pnisell.setBackground(new java.awt.Color(204, 204, 255));

        jButton12.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton12.setForeground(new java.awt.Color(0, 51, 204));
        jButton12.setText("X");
        jButton12.setContentAreaFilled(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 51, 204));
        jLabel36.setText("Product Sell");

        jLabel37.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel37.setText("Information of Product ");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 51, 204));
        jLabel38.setText("Product Name :");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 51, 204));
        jLabel39.setText("Description :");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane7.setViewportView(jTextArea1);

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 51, 204));
        jLabel40.setText("Contact :");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 51, 204));
        jLabel41.setText("Price :");

        jButton13.setBackground(new java.awt.Color(0, 51, 204));
        jButton13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Submit");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 51, 204));
        jLabel42.setText("Image :");

        jButton14.setText("Browse");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel43.setBackground(new java.awt.Color(204, 204, 204));
        jLabel43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 51, 204));
        jLabel46.setText("Category :");

        cate.setBackground(new java.awt.Color(0, 51, 204));
        cate.setForeground(new java.awt.Color(255, 255, 255));
        cate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Electronics", "Books", "Fashion", "Home & Living", "Others" }));

        javax.swing.GroupLayout pnisellLayout = new javax.swing.GroupLayout(pnisell);
        pnisell.setLayout(pnisellLayout);
        pnisellLayout.setHorizontalGroup(
            pnisellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnisellLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnisellLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addGroup(pnisellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnisellLayout.createSequentialGroup()
                        .addGroup(pnisellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnisellLayout.createSequentialGroup()
                                .addGroup(pnisellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel40)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(60, 60, 60)
                                .addComponent(jLabel42))
                            .addComponent(jLabel41)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnisellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton14)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnisellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel39)
                        .addGroup(pnisellLayout.createSequentialGroup()
                            .addComponent(jLabel38)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel46)
                            .addGap(182, 182, 182))
                        .addComponent(jLabel37)
                        .addComponent(jSeparator4)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                        .addGroup(pnisellLayout.createSequentialGroup()
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cate, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(84, 84, 84))))
                .addContainerGap(121, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnisellLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnisellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnisellLayout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(350, 350, 350))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnisellLayout.createSequentialGroup()
                        .addComponent(jButton13)
                        .addGap(359, 359, 359))))
        );
        pnisellLayout.setVerticalGroup(
            pnisellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnisellLayout.createSequentialGroup()
                .addComponent(jButton12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36)
                .addGap(49, 49, 49)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnisellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnisellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnisellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jLabel42)
                    .addComponent(jButton14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnisellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnisellLayout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jButton13)
                .addGap(88, 88, 88))
        );

        pnicards.add(pnisell, "card9");

        pniprofile.setBackground(new java.awt.Color(204, 204, 255));

        jButton10.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(0, 51, 204));
        jButton10.setText("X");
        jButton10.setContentAreaFilled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 36)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 51, 204));
        jLabel19.setText("My Profile");

        jLabel21.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 51, 204));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("tanzim_bn");
        jLabel21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel17.setBackground(new java.awt.Color(102, 102, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 204), null, null));

        jPanel10.setBackground(new java.awt.Color(102, 102, 255));
        jPanel10.setForeground(new java.awt.Color(0, 153, 255));

        jLabel22.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel22.setText("Name                :");

        jLabel23.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel23.setText("Id                      :");

        jLabel24.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel24.setText("Gender             :");

        jLabel26.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel26.setText("Department      :");

        jLabel27.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel27.setText("Contact             :");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel26)
                .addGap(12, 12, 12)
                .addComponent(jLabel27)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(102, 102, 255));
        jPanel11.setForeground(new java.awt.Color(0, 153, 255));

        jLabel28.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel28.setText("Tanzim Bin Nasir");

        jLabel29.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel29.setText("1904037");

        jLabel30.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel30.setText("Male");

        jLabel31.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel31.setText("CSE");

        jLabel32.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel32.setText("016290729974");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel31)
                .addGap(12, 12, 12)
                .addComponent(jLabel32)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        jLabel34.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Do you want to remove an item ?");

        jLabel35.setText("Enter Product Id :");

        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Remove");
        jButton11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton11.setContentAreaFilled(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1))
                            .addComponent(jLabel34)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addComponent(jLabel34)
                .addGap(2, 2, 2)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        jLabel33.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel33.setText("Your Products List");

        jScrollPane6.setBorder(null);

        jPanel18.setBackground(new java.awt.Color(204, 204, 255));
        jPanel18.setPreferredSize(new java.awt.Dimension(793, 526));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 793, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );

        jScrollPane6.setViewportView(jPanel18);

        javax.swing.GroupLayout pniprofileLayout = new javax.swing.GroupLayout(pniprofile);
        pniprofile.setLayout(pniprofileLayout);
        pniprofileLayout.setHorizontalGroup(
            pniprofileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pniprofileLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton10))
            .addGroup(pniprofileLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pniprofileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pniprofileLayout.createSequentialGroup()
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pniprofileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pniprofileLayout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addContainerGap(408, Short.MAX_VALUE))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
            .addGroup(pniprofileLayout.createSequentialGroup()
                .addGroup(pniprofileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pniprofileLayout.createSequentialGroup()
                        .addGap(374, 374, 374)
                        .addComponent(jLabel20))
                    .addGroup(pniprofileLayout.createSequentialGroup()
                        .addGap(347, 347, 347)
                        .addGroup(pniprofileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))))
                .addContainerGap())
        );
        pniprofileLayout.setVerticalGroup(
            pniprofileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pniprofileLayout.createSequentialGroup()
                .addGroup(pniprofileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton10)
                    .addGroup(pniprofileLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pniprofileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pniprofileLayout.createSequentialGroup()
                        .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pniprofileLayout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
        );

        pnicards.add(pniprofile, "card8");

        pninot.setBackground(new java.awt.Color(204, 204, 255));

        jButton15.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton15.setForeground(new java.awt.Color(0, 51, 204));
        jButton15.setText("X");
        jButton15.setContentAreaFilled(false);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jLabel45.setBackground(new java.awt.Color(153, 204, 255));
        jLabel45.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 51, 204));
        jLabel45.setText("Notifications ");

        jTable1.setBackground(new java.awt.Color(204, 204, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "From", "Product Name", "Message"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(0, 51, 204));
        jTable1.setRowHeight(100);
        jScrollPane9.setViewportView(jTable1);

        jSeparator6.setBackground(new java.awt.Color(0, 0, 204));
        jSeparator6.setForeground(new java.awt.Color(0, 51, 204));

        jSeparator7.setForeground(new java.awt.Color(0, 51, 204));

        javax.swing.GroupLayout pninotLayout = new javax.swing.GroupLayout(pninot);
        pninot.setLayout(pninotLayout);
        pninotLayout.setHorizontalGroup(
            pninotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pninotLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pninotLayout.createSequentialGroup()
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane9)
        );
        pninotLayout.setVerticalGroup(
            pninotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pninotLayout.createSequentialGroup()
                .addComponent(jButton15)
                .addGap(15, 15, 15)
                .addGroup(pninotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel45)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnicards.add(pninot, "card6");

        jSplitPane1.setRightComponent(pnicards);

        jPanel1.add(jSplitPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 640));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void onLeaveClick(JPanel panel) {
        panel.setBackground(new Color(236,235,235));
    }
    private void onClick(JPanel panel) {
        panel.setBackground(new Color(0,204,255));
    }
    
    private void cat1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cat1MouseClicked
        // TODO add your handling code here:
        onClick(cat1);
        onLeaveClick(cat2);
        onLeaveClick(cat3);
        onLeaveClick(cat4);
        onLeaveClick(cat5);
        //onLeaveClick(cat_home);
        pnicard1.setVisible(true);
        pnicard2.setVisible(false);
        pnicard3.setVisible(false);
        pnicard4.setVisible(false);
        pnicard5.setVisible(false);
        pniprofile.setVisible(false);
        home.setVisible(false);
        pnisell.setVisible(false);
        pninot.setVisible(false);
    }//GEN-LAST:event_cat1MouseClicked

    private void cat2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cat2MouseClicked
        // TODO add your handling code here:
        onClick(cat2);
        onLeaveClick(cat1);
        onLeaveClick(cat3);
        onLeaveClick(cat4);
        onLeaveClick(cat5);
        //onLeaveClick(cat_home);
        pnicard2.setVisible(true);
        pnicard1.setVisible(false);
        pnicard3.setVisible(false);
        pnicard4.setVisible(false);
        pnicard5.setVisible(false);
        pniprofile.setVisible(false);
        home.setVisible(false);
        pnisell.setVisible(false);
        pninot.setVisible(false);
    }//GEN-LAST:event_cat2MouseClicked

    private void cat3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cat3MouseClicked
        // TODO add your handling code here:
        onClick(cat3);
        onLeaveClick(cat2);
        onLeaveClick(cat1);
        onLeaveClick(cat4);
        onLeaveClick(cat5);
        //onLeaveClick(cat_home);
        pnicard3.setVisible(true);
        pnicard2.setVisible(false);
        pnicard1.setVisible(false);
        pnicard4.setVisible(false);
        pnicard5.setVisible(false);
        pniprofile.setVisible(false);
        home.setVisible(false);
        pnisell.setVisible(false);
        pninot.setVisible(false);
    }//GEN-LAST:event_cat3MouseClicked

    private void cat4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cat4MouseClicked
        // TODO add your handling code here:
        onClick(cat4);
        onLeaveClick(cat2);
        onLeaveClick(cat3);
        onLeaveClick(cat1);
        onLeaveClick(cat5);
        //onLeaveClick(cat_home);
        pnicard4.setVisible(true);
        pnicard2.setVisible(false);
        pnicard3.setVisible(false);
        pnicard1.setVisible(false);
        pnicard5.setVisible(false);
        pniprofile.setVisible(false);
        home.setVisible(false);
        pnisell.setVisible(false);
        pninot.setVisible(false);
    }//GEN-LAST:event_cat4MouseClicked

    private void cat5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cat5MouseClicked
        // TODO add your handling code here:
        onClick(cat5);
        onLeaveClick(cat1);
        onLeaveClick(cat2);
        onLeaveClick(cat3);
        onLeaveClick(cat4);
        //onLeaveClick(cat_home);
        pnicard2.setVisible(false);
        pnicard5.setVisible(true);
        pnicard2.setVisible(false);
        pnicard3.setVisible(false);
        pnicard1.setVisible(false);
        pnicard4.setVisible(false);
        pniprofile.setVisible(false);
        home.setVisible(false);
        pnisell.setVisible(false);
        pninot.setVisible(false);
    }//GEN-LAST:event_cat5MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int a=JOptionPane.showConfirmDialog(null, "Do you really want to Exit?","Select",JOptionPane.YES_NO_OPTION);
        if(a==0){
            System.exit(0);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int a=JOptionPane.showConfirmDialog(null, "Do you really want to Exit?","Select",JOptionPane.YES_NO_OPTION);
        if(a==0){
            System.exit(0);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int a=JOptionPane.showConfirmDialog(null, "Do you really want to Exit?","Select",JOptionPane.YES_NO_OPTION);
        if(a==0){
            System.exit(0);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int a=JOptionPane.showConfirmDialog(null, "Do you really want to Exit?","Select",JOptionPane.YES_NO_OPTION);
        if(a==0){
            System.exit(0);
        }
    }//GEN-LAST:event_jButton5ActionPerformed
    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int a=JOptionPane.showConfirmDialog(null, "Do you really want to Exit?","Select",JOptionPane.YES_NO_OPTION);
        if(a==0){
            System.exit(0);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void cat_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cat_homeMouseClicked

        onLeaveClick(cat2);
        onLeaveClick(cat3);
        onLeaveClick(cat4);
        onLeaveClick(cat5);
        onLeaveClick(cat1);
        pnicard1.setVisible(false);
        pnicard2.setVisible(false);
        pnicard3.setVisible(false);
        pnicard4.setVisible(false);
        pnicard5.setVisible(false);
        pniprofile.setVisible(false);
        home.setVisible(true);
        pnisell.setVisible(false);
        pninot.setVisible(false);
    }//GEN-LAST:event_cat_homeMouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int a=JOptionPane.showConfirmDialog(null, "Do you really want to logout?","Select",JOptionPane.YES_NO_OPTION);
        if(a==0){
            setVisible(false);
            new login().setVisible(true);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        onLeaveClick(cat2);
        onLeaveClick(cat3);
        onLeaveClick(cat4);
        onLeaveClick(cat5);
        onLeaveClick(cat1);
        pnicard1.setVisible(false);
        pnicard2.setVisible(false);
        pnicard3.setVisible(false);
        pnicard4.setVisible(false);
        pnicard5.setVisible(false);
        pniprofile.setVisible(true);
        home.setVisible(false);
        pnisell.setVisible(false);
        pninot.setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        onLeaveClick(cat2);
        onLeaveClick(cat3);
        onLeaveClick(cat4);
        onLeaveClick(cat5);
        onLeaveClick(cat1);
        pnicard1.setVisible(false);
        pnicard2.setVisible(false);
        pnicard3.setVisible(false);
        pnicard4.setVisible(false);
        pnicard5.setVisible(false);
        pniprofile.setVisible(false);
        home.setVisible(false);
        pnisell.setVisible(true);
        pninot.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        int a=JOptionPane.showConfirmDialog(null, "Do you really want to Exit?","Select",JOptionPane.YES_NO_OPTION);
        if(a==0){
            System.exit(0);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        int a=JOptionPane.showConfirmDialog(null, "Do you really want to Exit?","Select",JOptionPane.YES_NO_OPTION);
        if(a==0){
            System.exit(0);
        }
    }//GEN-LAST:event_jButton12ActionPerformed
    String path = null;
    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        JFileChooser imgfile = new JFileChooser();
        
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
        imgfile.addChoosableFileFilter(fnef);
        int show = imgfile.showOpenDialog(null);
        if(show == JFileChooser.APPROVE_OPTION) {
            File sel_img = imgfile.getSelectedFile();
            path = sel_img.getAbsolutePath();
//            JOptionPane.showMessageDialog(null,"Image added Successfully!");
            
            ImageIcon img = new ImageIcon(path);
            ImageIcon image = new ImageIcon(img.getImage()
             .getScaledInstance(170, 143, Image.SCALE_SMOOTH) );
          //  Image image = img.getImage().getScaledInstance(WIDTH, HEIGHT, WIDTH)
            jLabel43.setIcon(image);
        }
    }//GEN-LAST:event_jButton14ActionPerformed
    Connection con2 = null;
    PreparedStatement pst2 = null;
    ResultSet rs2 = null;
    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
    
        con2 = DbConnection.ConnectionDB();
        try {
            String sql = "INSERT INTO Books VALUES (?,?,?,?,?,?,?,?);";
            pst2 = con2.prepareStatement(sql);
            pst2.setString(2, jTextField2.getText());
            pst2.setString(3, jTextArea1.getText());
            pst2.setString(5, jTextField3.getText());
            pst2.setString(4, jTextField4.getText());
            pst2.setString(6, id);
            pst2.setString(8, cate.getSelectedItem().toString());
                File myFile = new File(path);
                try (FileInputStream fin = new FileInputStream(myFile)) {
                    pst2.setBinaryStream(7, fin, (int) myFile.length());
                } catch (IOException ex) {

                    JOptionPane.showMessageDialog(this, "Error_pic!");
                }   
            pst2.execute();
            JOptionPane.showMessageDialog(this, "SUCCESSFUL!");
            jTextField2.setText("");
            jTextArea1.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            jLabel43.setIcon(null);
            // refresh
            jPanel14.removeAll();
            jPanel14.repaint();
            show_elec();
            jPanel13.removeAll();
            jPanel13.repaint();
            show_book();
            jPanel12.removeAll();
            jPanel12.repaint();
            show_fashion();
            jLabel17.removeAll();
            jLabel17.repaint();
            show_home();
            jPanel16.removeAll();
            jPanel16.repaint();
            show_other();
            jPanel18.removeAll();
            jPanel18.repaint();
            show_prof();
            show_dash();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Error!");
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        int a=JOptionPane.showConfirmDialog(null, "Do you really want to Exit?","Select",JOptionPane.YES_NO_OPTION);
        if(a==0){
            System.exit(0);
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        onLeaveClick(cat2);
        onLeaveClick(cat3);
        onLeaveClick(cat4);
        onLeaveClick(cat5);
        onLeaveClick(cat1);
        pnicard1.setVisible(false);
        pnicard2.setVisible(false);
        pnicard3.setVisible(false);
        pnicard4.setVisible(false);
        pnicard5.setVisible(false);
        pniprofile.setVisible(false);
        home.setVisible(false);
        pnisell.setVisible(false);
        pninot.setVisible(true);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        jPanel19.removeAll();
        jPanel19.repaint();
        String srch = jTextField5.getText();
        Connection con1 = null;
        Statement pst1 = null;
        ResultSet rs1 = null;
        con1 = DbConnection.ConnectionDB();
        try{
            pst1 = con1.createStatement();
            rs1 = pst1.executeQuery("SELECT * from Books");
            int i = 1,x = 10, y = 10;
            while(rs1.next()) {
                String name = rs1.getString("name");
                if(!(name.toLowerCase().contains(srch.toLowerCase()))) continue;
                
                JPanel temp = item(rs1);
                temp.setBounds(x, y, 240, 240);
                jPanel19.add((temp));
                if(i % 3 == 0) {
                    x = 10;
                    y = y + 250;
                }
                else x = x + 250;
                ++i;
            }
            jPanel19.setMaximumSize(new Dimension(x + 50, y + 300));
            jPanel19.setPreferredSize(new Dimension(x + 50, y + 300));
            jPanel19.repaint();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error!");
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        int a=JOptionPane.showConfirmDialog(null, "Do you really want to Exit?","Select",JOptionPane.YES_NO_OPTION);
        if(a==0){
            System.exit(0);
        }
    }//GEN-LAST:event_jButton18ActionPerformed
    
    private int check(String temp) {
        Connection con = null;
        Statement pst = null;
        ResultSet rs = null;
        con = DbConnection.ConnectionDB();
        try{
            pst = con.createStatement();
            rs = pst.executeQuery("SELECT * from Books");
            int i = 0, t = 0;
            while(rs.next()) {
                if(rs.getString("Id").equals(temp)) {
                    t = 1;
                }
            }
            return t;
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Error!");
        }
        return 0;
    }
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        Connection con = null;
        Statement pst = null;
        ResultSet rs = null;
        con = DbConnection.ConnectionDB();
        try{
            if(check(jTextField1.getText()) == 0) {
                JOptionPane.showMessageDialog(this, "Invalid Id!");
                
            }
            else {
                pst = con.createStatement();
                String sql = "DELETE FROM Books WHERE Id =" + jTextField1.getText();
                pst.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Successfully Removed!");
                // refresh
                jPanel14.removeAll();
                jPanel14.repaint();
                show_elec();
                jPanel13.removeAll();
                jPanel13.repaint();
                show_book();
                jPanel12.removeAll();
                jPanel12.repaint();
                 show_fashion();
                jLabel17.removeAll();
                jLabel17.repaint();
                show_home();
                jPanel16.removeAll();
                jPanel16.repaint();
                show_other();
                jPanel18.removeAll();
                jPanel18.repaint();
                show_prof();
            }
        }
        catch(Exception e) {
//            System.err.println(e);
//            JOptionPane.showMessageDialog(this, e.getMessage());
              JOptionPane.showMessageDialog(null, "Error!");
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int min = Integer.parseInt(jTextField6.getText());
        int max = Integer.parseInt(jTextField7.getText());
        jPanel14.removeAll();
        jPanel14.repaint();
        Connection con = null;
        Statement pst = null;
        ResultSet rs = null;
        con = DbConnection.ConnectionDB();
        try{
            pst = con.createStatement();
            rs = pst.executeQuery("SELECT * from Books");
            int i = 1, t = 0, x = 30, y = 10;
            while(rs.next()) {
                String pr = rs.getString("price");
                int temp = Integer.parseInt(pr);
                
                if(temp >= min && temp <= max && rs.getString("cate").equals("Electronics")) {
                    JPanel temp1 = item(rs);
                    temp1.setBounds(x, y, 240, 240);
                    jPanel14.add(temp1);
                    if(i % 3 == 0) {
                        x = 30;
                        y = y + 250;
                    }
                    else x = x + 250;
                    ++i;
                }
            }
            jPanel14.setMaximumSize(new Dimension(x + 300, y + 300));
            jPanel14.setPreferredSize(new Dimension(x + 300, y + 300));
            jPanel14.repaint();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Error!");
        }
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        jPanel14.removeAll();
        jPanel14.repaint();
        jTextField6.setText("");
        jTextField7.setText("");
        show_elec();
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        int min = Integer.parseInt(jTextField9.getText());
        int max = Integer.parseInt(jTextField10.getText());
        jPanel13.removeAll();
        jPanel13.repaint();
        Connection con = null;
        Statement pst = null;
        ResultSet rs = null;
        con = DbConnection.ConnectionDB();
        try{
            pst = con.createStatement();
            rs = pst.executeQuery("SELECT * from Books");
            int i = 1, t = 0, x = 30, y = 10;
            while(rs.next()) {
                String pr = rs.getString("price");
                int temp = Integer.parseInt(pr);
                
                if(temp >= min && temp <= max && rs.getString("cate").equals("Books")) {
                    JPanel temp1 = item(rs);
                    temp1.setBounds(x, y, 240, 240);
                    jPanel13.add(temp1);
                    if(i % 3 == 0) {
                        x = 30;
                        y = y + 250;
                    }
                    else x = x + 250;
                    ++i;
                }
            }
            jPanel13.setMaximumSize(new Dimension(x + 300, y + 300));
            jPanel13.setPreferredSize(new Dimension(x + 300, y + 300));
            jPanel13.repaint();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Error!");
        }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        jPanel13.removeAll();
        jPanel13.repaint();
        jTextField10.setText("");
        jTextField9.setText("");
        show_book();
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        int min = Integer.parseInt(jTextField11.getText());
        int max = Integer.parseInt(jTextField12.getText());
        jPanel12.removeAll();
        jPanel12.repaint();
        Connection con = null;
        Statement pst = null;
        ResultSet rs = null;
        con = DbConnection.ConnectionDB();
        try{
            pst = con.createStatement();
            rs = pst.executeQuery("SELECT * from Books");
            int i = 1, t = 0, x = 30, y = 10;
            while(rs.next()) {
                String pr = rs.getString("price");
                int temp = Integer.parseInt(pr);
                
                if(temp >= min && temp <= max && rs.getString("cate").equals("Fashion")) {
                    JPanel temp1 = item(rs);
                    temp1.setBounds(x, y, 240, 240);
                    jPanel12.add(temp1);
                    if(i % 3 == 0) {
                        x = 30;
                        y = y + 250;
                    }
                    else x = x + 250;
                    ++i;
                }
            }
            jPanel12.setMaximumSize(new Dimension(x + 300, y + 300));
            jPanel12.setPreferredSize(new Dimension(x + 300, y + 300));
            jPanel12.repaint();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Error!");
        }
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        jPanel12.removeAll();
        jPanel12.repaint();
        jTextField11.setText("");
        jTextField12.setText("");
        show_fashion();
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        int min = Integer.parseInt(jTextField13.getText());
        int max = Integer.parseInt(jTextField14.getText());
        jPanel16.removeAll();
        jPanel16.repaint();
        Connection con = null;
        Statement pst = null;
        ResultSet rs = null;
        con = DbConnection.ConnectionDB();
        try{
            pst = con.createStatement();
            rs = pst.executeQuery("SELECT * from Books");
            int i = 1, t = 0, x = 30, y = 10;
            while(rs.next()) {
                String pr = rs.getString("price");
                int temp = Integer.parseInt(pr);
                
                if(temp >= min && temp <= max && rs.getString("cate").equals("Others")) {
                    JPanel temp1 = item(rs);
                    temp1.setBounds(x, y, 240, 240);
                    jPanel16.add(temp1);
                    if(i % 3 == 0) {
                        x = 30;
                        y = y + 250;
                    }
                    else x = x + 250;
                    ++i;
                }
            }
            jPanel16.setMaximumSize(new Dimension(x + 300, y + 300));
            jPanel16.setPreferredSize(new Dimension(x + 300, y + 300));
            jPanel16.repaint();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Error!");
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        jPanel16.removeAll();
        jPanel16.repaint();
        jTextField13.setText("");
        jTextField14.setText("");
        show_other();
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        int min = Integer.parseInt(jTextField15.getText());
        int max = Integer.parseInt(jTextField16.getText());
        jPanel15.removeAll();
        jPanel15.repaint();
        Connection con = null;
        Statement pst = null;
        ResultSet rs = null;
        con = DbConnection.ConnectionDB();
        try{
            pst = con.createStatement();
            rs = pst.executeQuery("SELECT * from Books");
            int i = 1, t = 0, x = 30, y = 10;
            while(rs.next()) {
                String pr = rs.getString("price");
                int temp = Integer.parseInt(pr);
                
                if(temp >= min && temp <= max && rs.getString("cate").equals("Home & Living")) {
                    JPanel temp1 = item(rs);
                    temp1.setBounds(x, y, 240, 240);
                    jPanel15.add(temp1);
                    if(i % 3 == 0) {
                        x = 30;
                        y = y + 250;
                    }
                    else x = x + 250;
                    ++i;
                }
            }
            jPanel15.setMaximumSize(new Dimension(x + 300, y + 300));
            jPanel15.setPreferredSize(new Dimension(x + 300, y + 300));
            jPanel15.repaint();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Error!");
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        jPanel15.removeAll();
        jPanel15.repaint();
        jTextField15.setText("");
        jTextField16.setText("");
        show_home();
    }//GEN-LAST:event_jButton27ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home_page("tanzim_bn").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cat1;
    private javax.swing.JPanel cat2;
    private javax.swing.JPanel cat3;
    private javax.swing.JPanel cat4;
    private javax.swing.JPanel cat5;
    private javax.swing.JPanel cat_home;
    private javax.swing.JComboBox<String> cate;
    private javax.swing.JPanel home;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel pnicard1;
    private javax.swing.JPanel pnicard2;
    private javax.swing.JPanel pnicard3;
    private javax.swing.JPanel pnicard4;
    private javax.swing.JPanel pnicard5;
    private javax.swing.JPanel pnicards;
    private javax.swing.JPanel pninot;
    private javax.swing.JPanel pniprofile;
    private javax.swing.JPanel pnisell;
    // End of variables declaration//GEN-END:variables
}
