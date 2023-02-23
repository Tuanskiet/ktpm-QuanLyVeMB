/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI;

import DAO.NhanVienDAO;
import Models.NhanVien;
import Models.listAccoutRemembers;
import NewInterface.MainInterface;
import static UI.quanly.lblHoTen;
import static UI.quanly.menu;
import static UI.quanly.showView;
import helper.Auth;
import helper.DataValidator;
import helper.MsgBox;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author FPT
 */
public class dn extends javax.swing.JPanel {

    /**
     * Creates new form dn
     */
    MainInterface<NhanVien> qlNV;
    listAccoutRemembers listAR;
    private String rememberID = "";
    private String remembersPass = "";
    private String path = "LoginRemembers.txt";

    public dn() {
        initComponents();
//        this.setIconImage(XImage.getAppIcon());
        qlNV = new NhanVienDAO();
        this.listAR = new listAccoutRemembers();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            this.listAR = (listAccoutRemembers) ois.readObject();
            this.rememberID = listAR.getId();
            this.remembersPass = listAR.getPass();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
//            MsgBox.alert(this, "Chưa có ID nào được lưu!");
        }

        this.txtUserName.setText(rememberID);
        this.txtPassWord.setText(remembersPass);
        this.chkNhoMK.setSelected(rememberID.equals("") ? false : true);

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
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPassWord = new javax.swing.JPasswordField();
        chkNhoMK = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        lblQuenMK = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnLogin1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(27, 27, 54));

        jLabel3.setForeground(new java.awt.Color(238, 240, 255));
        jLabel3.setText("Tên đăng nhập : ");

        jLabel5.setForeground(new java.awt.Color(238, 240, 255));
        jLabel5.setText("Mật khẩu : ");

        txtUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserNameKeyPressed(evt);
            }
        });

        txtPassWord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPassWordMousePressed(evt);
            }
        });
        txtPassWord.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassWordKeyPressed(evt);
            }
        });

        chkNhoMK.setBackground(new java.awt.Color(51, 51, 89));
        chkNhoMK.setForeground(new java.awt.Color(238, 240, 255));
        chkNhoMK.setText("Nhớ mật khẩu ?");

        jLabel7.setBackground(new java.awt.Color(95, 175, 32));
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(238, 240, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Đăng nhập");

        lblQuenMK.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblQuenMK.setForeground(new java.awt.Color(200, 165, 75));
        lblQuenMK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuenMK.setText("Quên mật khẩu ?");
        lblQuenMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuenMKMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblQuenMKMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblQuenMKMouseExited(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(63, 114, 232));
        btnLogin.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(238, 240, 255));
        btnLogin.setText("ĐĂNG NHẬP");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnLogin1.setBackground(new java.awt.Color(165, 30, 76));
        btnLogin1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnLogin1.setForeground(new java.awt.Color(238, 240, 255));
        btnLogin1.setText("NHẬP LẠI");
        btnLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogin1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(txtUserName)
                    .addComponent(jLabel5)
                    .addComponent(chkNhoMK)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPassWord)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                    .addComponent(lblQuenMK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(175, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassWord, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chkNhoMK)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblQuenMK)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNameKeyPressed
        this.enter(evt);
    }//GEN-LAST:event_txtUserNameKeyPressed

    private void txtPassWordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPassWordMousePressed

    }//GEN-LAST:event_txtPassWordMousePressed

    private void txtPassWordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassWordKeyPressed
        this.enter(evt);
    }//GEN-LAST:event_txtPassWordKeyPressed

    private void lblQuenMKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMKMouseClicked
        menu.setView(new QuenMatKhau());
    }//GEN-LAST:event_lblQuenMKMouseClicked

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        login();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogin1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogin1ActionPerformed

    private void lblQuenMKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMKMouseEntered
        lblQuenMK.setForeground(new Color(63,114,232)); 
    }//GEN-LAST:event_lblQuenMKMouseEntered

    private void lblQuenMKMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMKMouseExited
        lblQuenMK.setForeground(new Color(200,165,75)); 
    }//GEN-LAST:event_lblQuenMKMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLogin1;
    private javax.swing.JCheckBox chkNhoMK;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblQuenMK;
    private javax.swing.JPasswordField txtPassWord;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
private void login() {

        String tenDN = txtUserName.getText();
        String matKhau = new String(txtPassWord.getPassword());
        StringBuilder sb = new StringBuilder();
        DataValidator.validateEmpty(txtUserName, sb, "Không để trống ID!");
        DataValidator.validateEmpty(txtPassWord, sb, "Không để trống pass!");
        if (sb.length() > 0) {
            MsgBox.showErrorDialog(this, sb.toString(), "Error !");
            return;
        } else {
        }
        try {
            NhanVien nv = null;
            nv = qlNV.selectById(tenDN);
            if (nv == null) {
                MsgBox.showErrorDialog(this, "Sai tên Đăng Nhập", "Error !");
                txtUserName.setBackground(Color.YELLOW);
                return;
            } else if (!matKhau.equals(nv.getMatKhau())) {
                MsgBox.showErrorDialog(this, "Sai mật khẩu", "Error !");
                txtPassWord.setBackground(Color.YELLOW);
                return;
            } else {
                Auth.user = nv;
                this.rememberLogin();
                MsgBox.alert(this, "Xin chào, " + (Auth.user.getChucVu() ? "Admin" : "Nhân Viên") + ": " + (Auth.user.getTenNV()));
                String hoTen = Auth.user.getTenNV();
                lblHoTen.setText(hoTen);
                menu.setView(new ManHinhChinh());
                showView();
            }
        } catch (Exception ex) {
            MsgBox.showErrorDialog(this, "Lỗi Đăng Nhập!", "Error !");
            ex.printStackTrace();
        }
    }

    private void rememberLogin() {
        if (this.chkNhoMK.isSelected()) {
            this.rememberID = txtUserName.getText();
            this.remembersPass = String.valueOf(txtPassWord.getPassword());
        } else {
            this.rememberID = "";
            this.remembersPass = "";
        }
        listAR = new listAccoutRemembers(rememberID, remembersPass);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(listAR);
        } catch (IOException e) {
            e.printStackTrace();
            MsgBox.showErrorDialog(this, "Ghi nhớ mật khẩu thất bại!", "Error !");

        }
    }

    private void enter(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.btnLogin.doClick();
        }
    }

    private void exit() {
        System.exit(0);
    }
}
