/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI;

import DAO.KhachHangDAO;
import Models.KhachHang;
import NewInterface.KhachhangInterface;
import helper.DataValidator;
import helper.MsgBox;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class QuanLiKhachHang extends javax.swing.JPanel {

    /**
     * Creates new form QuanLiKhachHang
     */
    DefaultTableModel model;
    int row = -1;
    KhachhangInterface KhachHangDao;

    public QuanLiKhachHang() {
        initComponents();
        KhachHangDao = new KhachHangDAO();
        model = (DefaultTableModel) tblMain.getModel();
        this.fillToTable();
    }

    public void fillToTable() {
        model.setRowCount(0);
        try {
            List<KhachHang> list = KhachHangDao.getList();
            for (KhachHang kh : list) {
                model.addRow(new Object[]{
                    kh.getMaKhachHan(),
                    kh.getTenKhachHang(),
                    kh.getMaVe(),
                    kh.getSoDienThoai(),
                    kh.getDiaChi(),
                    kh.getCmndCccd(),
                    kh.getEmail(),
                    kh.getMaChuyenBay()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.showErrorDialog(this, "Lỗi truy vấn dữ liệu chuyến bay!", "Error !");
        }

    }

    void clearForm() {
        KhachHang kh = new KhachHang();
        this.setForm(kh);
        this.row = -1;
//        this.updateStatus();
    }

    void setForm(KhachHang cb) {
        this.txtMaKhachHang.setText(cb.getMaKhachHan());
        this.txtTenKhachHang.setText(cb.getTenKhachHang());
        this.txtMaVe.setText(cb.getMaVe());
        this.txtSoDienThoai.setText(cb.getSoDienThoai());
        this.txtDiaChi.setText(cb.getDiaChi());
        this.txtCnmnd.setText(cb.getCmndCccd());
        this.txtEmail.setText(cb.getEmail());
        this.txtMaChuyenBay.setText(cb.getMaChuyenBay());

        //  tblChuyenDe.setRowSelectionInterval(row, row);
    }

    KhachHang getForm() {
        KhachHang kh = new KhachHang();
        kh.setMaKhachHan(txtMaKhachHang.getText());
        kh.setTenKhachHang(txtTenKhachHang.getText());
        kh.setMaVe(txtMaVe.getText());
        kh.setSoDienThoai(txtSoDienThoai.getText());
        kh.setDiaChi(txtDiaChi.getText());
        kh.setCmndCccd(txtCnmnd.getText());
        kh.setEmail(txtEmail.getText());
        kh.setMaChuyenBay(txtMaChuyenBay.getText());
        return kh;
    }

    void edit() {
        try {
            String MaKH = (String) tblMain.getValueAt(row, 0);
            KhachHang cd = (KhachHang) KhachHangDao.selectById(MaKH);
            this.setForm(cd);
            tblMain.setRowSelectionInterval(row, row);
//            this.updateStatus();
        } catch (Exception ex) {
            ex.printStackTrace();
            MsgBox.showErrorDialog(this, "Lỗi Mã Chuyến Bay!", "Error !");
        }
    }

    public boolean checkForm() {
        StringBuilder sb = new StringBuilder();
        DataValidator.validateEmpty(txtMaKhachHang, sb, "Không để trống mã khách hàng!");
        DataValidator.validateEmpty(txtTenKhachHang, sb, "Không để trống tên khách hàng!");
        DataValidator.validateEmpty(txtEmail, sb, "Không để trống Email!");
        DataValidator.validateEmpty(txtDiaChi, sb, "Không để trống địa chỉ!");
        DataValidator.validateEmpty(txtMaVe, sb, "Không để trống mã vé!");
        DataValidator.validateEmpty(txtMaChuyenBay, sb, "Không để trống mã chuyến bay!");
        DataValidator.validateEmpty(txtCnmnd, sb, "Không để trống Cccd/cmnd!");
        DataValidator.validateEmpty(txtSoDienThoai, sb, "Không để trống số điện thoại!");

        if (sb.length() > 0) {
            MsgBox.showErrorDialog(this, sb.toString(), "Error !");
            return false;
        }
        return true;
    }

    public boolean checkMaKH() {
        String maNV = txtMaKhachHang.getText();
        for (int i = 0; i < tblMain.getRowCount(); i++) {
            if (tblMain.getValueAt(i, 0).toString().trim().equalsIgnoreCase(maNV)) {
                return false;
            }
        }
        return true;
    }

    private void del() {
//        if (!Auth.isManager()) {
//            MsgBox.alert(this, "Bạn không có quyền xóa!");
//            return;}
        if (MsgBox.confirm(this, "Bạn có muốn xóa chuyên đề này không?")) {
            if (this.checkMaKH()) {
                MsgBox.showErrorDialog(this, "Mã chuyên đề chưa tồn tại", "Error !");
                return;
            }
            try {
                KhachHangDao.delete(txtMaKhachHang.getText());
                this.fillToTable();
                this.clearForm();
                MsgBox.alert(this, "Xóa thành công!");
            } catch (Exception ex) {
                ex.printStackTrace();
                MsgBox.showErrorDialog(this, "Không thể xóa!", "Error !");
            }
        }
    }

    private void insert() {
        if (!this.checkForm()) {
            return;
        }
        if (!this.checkMaKH()) {
            MsgBox.showErrorDialog(this, "Mã khách hàng", "Error !");
            return;
        }
        try {
            KhachHang kh = getForm();
            KhachHangDao.insert(kh);
            this.fillToTable();
            MsgBox.alert(this, "Thêm mới thành công!");
        } catch (Exception ex) {
            ex.printStackTrace();
            MsgBox.alert(this, "Thêm mới thất bại!");
        }
    }

    private void update() {
        if (!this.checkForm()) {
            return;
        }
        if (this.checkMaKH()) {
            MsgBox.showErrorDialog(this, "Mã khách hàng", "Error !");
            return;
        }
        try {
            KhachHang kh = getForm();
            KhachHangDao.update(kh);
            this.fillToTable();
            MsgBox.alert(this, "Cập nhập thành công!");
        } catch (Exception ex) {
            ex.printStackTrace();
            MsgBox.showErrorDialog(this, "Cập nhập thất bại!", "Error !");
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMain = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaKhachHang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTenKhachHang = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtMaVe = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCnmnd = new javax.swing.JTextField();
        txtMaChuyenBay = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(736, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Danh sách khách hàng:");

        tblMain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng ", "Tên khách hàng", "Số điện thoại", "Email", "Địa chỉ", "Mã vé", "Mã chuyến bay"
            }
        ));
        tblMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMainMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMain);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Thông tin cơ bản:");

        jLabel3.setText("Mã khách hàng:");

        txtMaKhachHang.setMinimumSize(new java.awt.Dimension(72, 22));
        txtMaKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKhachHangActionPerformed(evt);
            }
        });

        jLabel4.setText("Tên khách hàng:");

        jLabel5.setText("Số điện thoại:");

        txtTenKhachHang.setMinimumSize(new java.awt.Dimension(72, 22));

        txtSoDienThoai.setMinimumSize(new java.awt.Dimension(72, 22));

        jLabel6.setText("Cmnd/cccd:");

        jLabel7.setText("Email:");

        txtEmail.setMinimumSize(new java.awt.Dimension(72, 22));

        jLabel8.setText("Địa chỉ:");

        jLabel9.setText("Mã vé:");

        jLabel10.setText("Mã chuyến bay:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel9)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtCnmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtMaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(37, 37, 37)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel10)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtMaChuyenBay, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa)
                        .addGap(18, 18, 18)
                        .addComponent(btnLamMoi)))
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCnmnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaChuyenBay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKhachHangActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtMaKhachHangActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        this.clearForm();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void tblMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMainMouseClicked
        // TODO add your handling code here:
        this.row = tblMain.getSelectedRow();
        if (row == -1) {
            return;
        }
        this.edit();
    }//GEN-LAST:event_tblMainMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        this.del();
        this.clearForm();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        this.update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        this.insert();
    }//GEN-LAST:event_btnThemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMain;
    private javax.swing.JTextField txtCnmnd;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaChuyenBay;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtMaVe;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenKhachHang;
    // End of variables declaration//GEN-END:variables

    private static class KhachHangDao {
    }
}
