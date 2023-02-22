/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI;

import DAO.ChuyenBayDao;
import Models.ChuyenBay;
import NewInterface.MainInterface;
import helper.DataValidator;
import helper.MsgBox;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FPT
 */
public class JPChuyenBay extends javax.swing.JPanel {

    MainInterface chuyenBayDao;
    DefaultTableModel model;
    int row = -1;

    public JPChuyenBay() {
        initComponents();
        chuyenBayDao = new ChuyenBayDao();
        model = (DefaultTableModel) tblqlcb.getModel();
        this.fillToTable();
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
        btnMoi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblqlcb = new javax.swing.JTable();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        txtmacb = new javax.swing.JTextField();
        txtdiemdi = new javax.swing.JTextField();
        txtdiemden = new javax.swing.JTextField();
        txtmakh = new javax.swing.JTextField();
        txtgiobay = new javax.swing.JTextField();
        txtmamb = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(27, 27, 54));

        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        tblqlcb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Chuyến Bay", "Điểm Đi ", "Điểm  Đến", "Giờ Bay", "Mã Khách Hàng", "Mã Máy Bay", "Ghi Chú"
            }
        ));
        tblqlcb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblqlcbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblqlcb);

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        txtmacb.setText("Mã Chuyến Bay");

        txtdiemdi.setText("Điểm Đi");

        txtdiemden.setText("Điểm Đến");

        txtmakh.setText("Mã Khách Hàng");

        txtgiobay.setText("Giờ Bay");

        txtmamb.setText("Mã Máy Bay");

        btnThem.setText("Thêm");
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmacb, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdiemdi, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(155, 155, 155)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtdiemden, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtgiobay, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtmamb, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtmakh, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtmacb, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtmakh, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtmamb, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtdiemdi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdiemden, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtgiobay, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(47, 47, 47))
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

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        this.clearForm();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void tblqlcbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblqlcbMouseClicked
        // TODO add your handling code here:
        this.row = tblqlcb.getSelectedRow();
        if (row == -1) {
            return;
        }
        this.edit();
    }//GEN-LAST:event_tblqlcbMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        this.del();
        this.clearForm();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        this.update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        // TODO add your handling code here:
        this.insert();
    }//GEN-LAST:event_btnThemMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblqlcb;
    private javax.swing.JTextField txtdiemden;
    private javax.swing.JTextField txtdiemdi;
    private javax.swing.JTextField txtgiobay;
    private javax.swing.JTextField txtmacb;
    private javax.swing.JTextField txtmakh;
    private javax.swing.JTextField txtmamb;
    // End of variables declaration//GEN-END:variables

 private void fillToTable() {
        model.setRowCount(0);
        try {
            List<ChuyenBay> list = chuyenBayDao.getList();
            for (ChuyenBay cb : list) {
                model.addRow(new Object[]{
                    cb.getMaCB(),
                    cb.getDiemDi(),
                    cb.getDiemDen(),
                    cb.getGioBay(),
                    cb.getMaKH(),
                    cb.getMaMB(),
                    cb.getGhiChu()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.showErrorDialog(this, "Lỗi truy vấn dữ liệu chuyến bay!", "Error !");
        }
    }

    void clearForm() {
        ChuyenBay cd = new ChuyenBay();
        this.setForm(cd);
        this.row = -1;
//        this.updateStatus();
    }

    void setForm(ChuyenBay cb) {
        this.txtmacb.setText(cb.getMaCB());
        this.txtdiemdi.setText(cb.getDiemDi());
        this.txtdiemden.setText(cb.getDiemDen());
        this.txtgiobay.setText(cb.getGioBay());
        this.txtmakh.setText(cb.getMaKH());
        this.txtmamb.setText(cb.getMaMB());

        //  tblChuyenDe.setRowSelectionInterval(row, row);
    }

    void edit() {
        try {
            String maCD = (String) tblqlcb.getValueAt(row, 0);
            ChuyenBay cd = (ChuyenBay) chuyenBayDao.selectById(maCD);
            this.setForm(cd);
            tblqlcb.setRowSelectionInterval(row, row);
//            this.updateStatus();
        } catch (Exception ex) {
            ex.printStackTrace();
            MsgBox.showErrorDialog(this, "Lỗi Mã Chuyến Bay!", "Error !");
        }
    }

    private void del() {
//        if (!Auth.isManager()) {
//            MsgBox.alert(this, "Bạn không có quyền xóa!");
//            return;}
        if (MsgBox.confirm(this, "Bạn có muốn xóa chuyên đề này không?")) {
            if (this.checkMaCB()) {
                MsgBox.showErrorDialog(this, "Mã chuyên đề chưa tồn tại", "Error !");
                return;
            }
            try {
                chuyenBayDao.delete(txtmacb.getText());
                this.fillToTable();
                this.clearForm();
                MsgBox.alert(this, "Xóa thành công!");
            } catch (Exception ex) {
                ex.printStackTrace();
                MsgBox.showErrorDialog(this, "Không thể xóa chuyên đề (Chuyên đề đã có khóa học)!", "Error !");
            }
        }
    }

    public boolean checkForm() {
        StringBuilder sb = new StringBuilder();
        DataValidator.validateEmpty(txtmacb, sb, "Không để trống mã chuyến bay!");
        DataValidator.validateEmpty(txtdiemdi, sb, "Không để trống điểm đi!");
        DataValidator.validateEmpty(txtdiemden, sb, "Không để trống điểm đến!");
        DataValidator.validateEmpty(txtgiobay, sb, "Không để trống học phí!");
        DataValidator.validateEmpty(txtmakh, sb, "Không để trống mã khách hàng!");
        DataValidator.validateEmpty(txtmamb, sb, "Không để trống mã máy bay!");

        if (sb.length() > 0) {
            MsgBox.showErrorDialog(this, sb.toString(), "Error !");
            return false;
        }
        return true;
    }

    public boolean checkMaCB() {
        String maNV = txtmacb.getText();
        for (int i = 0; i < tblqlcb.getRowCount(); i++) {
            if (tblqlcb.getValueAt(i, 0).toString().trim().equalsIgnoreCase(maNV)) {
                return false;
            }
        }
        return true;
    }

    private void insert() {
        if (!this.checkForm()) {
            return;
        }
        if (!this.checkMaCB()) {
            MsgBox.showErrorDialog(this, "Mã chuyến bay đã tồn tại", "Error !");
            return;
        }
        try {
            ChuyenBay cd = getForm();
            chuyenBayDao.insert(cd);
            this.fillToTable();
            MsgBox.alert(this, "Thêm mới thành công!");
        } catch (Exception ex) {
            ex.printStackTrace();
            MsgBox.alert(this, "Thêm mới thất bại!");
        }
    }

    ChuyenBay getForm() {
        ChuyenBay cd = new ChuyenBay();
        cd.setMaCB(txtmacb.getText());
        cd.setDiemDi(txtdiemdi.getText());
        cd.setDiemDen(txtdiemden.getText());
        cd.setGioBay(txtgiobay.getText());
        cd.setMaKH(txtmakh.getText());
        cd.setMaMB(txtmamb.getText());

        return cd;
    }

    private void update() {
        if (!this.checkForm()) {
            return;
        }
        if (this.checkMaCB()) {
            MsgBox.showErrorDialog(this, "Mã chuyến bay chưa tồn tại", "Error !");
            return;
        }
        try {
            ChuyenBay cd = getForm();
            chuyenBayDao.update(cd);
            this.fillToTable();
            MsgBox.alert(this, "Cập nhập thành công!");
        } catch (Exception ex) {
            ex.printStackTrace();
            MsgBox.showErrorDialog(this, "Cập nhập thất bại!", "Error !");
        }
    }
}