/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package UI;

import DAO.ChuyenBayDao;
import Models.ChuyenBay;
import NewInterface.ChuyenBayInterface;
import helper.DataValidator;
import helper.MsgBox;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class ChuyenBayUI extends javax.swing.JInternalFrame {

    /**
     * Creates new form ChuyenBayUI
     */
    ChuyenBayInterface chuyenBayDao;
    DefaultTableModel model;
    int row = -1;

    public ChuyenBayUI() {
        initComponents();
        chuyenBayDao = new ChuyenBayDao();
        model = (DefaultTableModel) tblqlcb.getModel();
        this.fillToTable();
    }

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
        this.txtghichu.setText(cb.getGhiChu());

        //  tblChuyenDe.setRowSelectionInterval(row, row);
    }

    void edit() {
        try {
            String maCD = (String) tblqlcb.getValueAt(row, 0);
            ChuyenBay cd = chuyenBayDao.selectByID(maCD);
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
        DataValidator.validateEmpty(txtghichu, sb, "Không để trống ghi chú!");

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
        cd.setGhiChu(txtghichu.getText());

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
        tblqlcb = new javax.swing.JTable();
        txtmacb = new javax.swing.JTextField();
        txtdiemdi = new javax.swing.JTextField();
        txtdiemden = new javax.swing.JTextField();
        txtmakh = new javax.swing.JTextField();
        txtgiobay = new javax.swing.JTextField();
        txtghichu = new javax.swing.JTextField();
        txtmamb = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Quản Lí Chuyến Bay");

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

        txtmacb.setText("Mã Chuyến Bay");

        txtdiemdi.setText("Điểm Đi");

        txtdiemden.setText("Điểm Đến");

        txtmakh.setText("Mã Khách Hàng");

        txtgiobay.setText("Giờ Bay");

        txtghichu.setText("Ghi Chú");

        txtmamb.setText("Mã Máy Bay");

        btnThem.setText("Thêm");
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });

        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(345, 345, 345))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtmacb, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtdiemdi, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtdiemden, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtgiobay, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(166, 166, 166)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(txtmakh, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtmamb, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtghichu, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(198, 198, 198)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmacb, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdiemdi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdiemden, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtgiobay, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmakh, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmamb, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtghichu, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
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

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        // TODO add your handling code here:
        this.insert();
    }//GEN-LAST:event_btnThemMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        this.update();
    }//GEN-LAST:event_btnSuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblqlcb;
    private javax.swing.JTextField txtdiemden;
    private javax.swing.JTextField txtdiemdi;
    private javax.swing.JTextField txtghichu;
    private javax.swing.JTextField txtgiobay;
    private javax.swing.JTextField txtmacb;
    private javax.swing.JTextField txtmakh;
    private javax.swing.JTextField txtmamb;
    // End of variables declaration//GEN-END:variables
}
