/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import Models.DanhMucDAO;
import UI.DoiMK;
import UI.HeThong;
import UI.JPChuyenBay;
import UI.JPQLVE;
import UI.JPThongKe;
import UI.ManHinhChinh;
import UI.QuanLiKhachHang;
import UI.QuanLiNhanVien;
import UI.QuenMatKhau;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author FPT
 */
public class Xcontrol {

    private JPanel root;
    private String kinSelected = "";
    Color mainColor = new Color(51, 51, 89);
    Color colorChange = new Color(241, 134, 39);

    private List<DanhMucDAO> listItem = null;

    public Xcontrol() {
    }

    public Xcontrol(JPanel pnlRoot) {
        this.root = pnlRoot;
    }

    public void setView(JPanel panel) {
//        kinSelected = "DangNhap";
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(panel);
        root.validate();
        root.repaint();
    }

    public void setEvent(List<DanhMucDAO> listItem) {
        this.listItem = listItem;

        for (DanhMucDAO item : listItem) {
//            if (item.getKind().equals("DangNhap")) continue;
            item.getJpn().addMouseListener(new LabelEvent(item.getKind(), item.getJpn()));

        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;
        private String kind;

        private JPanel jpnItem;

        public LabelEvent(String kind, JPanel jpnItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "Main":
                    node = new ManHinhChinh();
                    break;
            }
            switch (kind) {
                case "NhanVien":
                    node = new QuanLiNhanVien();
                    break;
            }
            switch (kind) {
                case "KhachHang":
                    node = new QuanLiKhachHang();
                    break;
            }
            switch (kind) {
                case "QLChuyenBay":
                    node = new JPChuyenBay();
                    break;
            }
             switch (kind) {
                case "QLVe":
                    node = new JPQLVE();
                    break;
            }
           
            switch (kind) {
                case "ThongKe":
                    node = new JPThongKe();
                    break;
            }
            switch (kind) {
                case "DoiMK":
                    node = new DoiMK();
                    break;
            }
            switch (kind) {
                case "HeThong":
                    node = new HeThong();
                    break;
            }
            switch (kind) {
                case "QuenMK":
                    node = new QuenMatKhau();
                    break;
            }
         

            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kinSelected = kind;
            jpnItem.setBackground(colorChange);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(colorChange);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kinSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(mainColor);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
//            jpnItem.setBackground(mainColor);
        }

        private void setChangeBackground(String kind) {
            for (DanhMucDAO item : listItem) {
                if (item.getKind().equalsIgnoreCase(kind)) {
                    item.getJpn().setBackground(colorChange);
                } else {
                    item.getJpn().setBackground(mainColor);
                }
            }
        }
    }
    public static void exit(){
        System.exit(0);
    }
}
