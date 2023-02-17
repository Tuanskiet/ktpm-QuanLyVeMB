/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import Models.DanhMucDAO;
import UI.HeThong;
import UI.ManHinhChinh;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;

/**
 *
 * @author FPT
 */
public class Xcontrol {

    private JDesktopPane root;
    private String kinSelected = "";
    Color mainColor = new Color(51, 51, 89);
    Color colorChange = new Color(241, 134, 39);

    private List<DanhMucDAO> listItem = null;

    public Xcontrol(JDesktopPane jdpRoot) {
        this.root = jdpRoot;
    }

    public void setView(JPanel jpnItem) {
        kinSelected = "Main";

        jpnItem.setBackground(colorChange);

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new ManHinhChinh());
        root.validate();
        root.repaint();
    }

    public void setEvent(List<DanhMucDAO> listItem) {
        this.listItem = listItem;

        for (DanhMucDAO item : listItem) {
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
//                    node = new QLChuyenDe();
                    break;
            }
            switch (kind) {
                case "KhoaHoc":
//                    node = new QLKhoaHOc();
                    break;
            }
            switch (kind) {
                case "NguoiHoc":
//                    node = new QLNguoiHoc();
                    break;
            }
            switch (kind) {
                case "HocVien":
//                    node = new QLHocVien();
                    break;
            }
            switch (kind) {
                case "ThongKe":
//                    node = new QLThongKe();
                    break;
            }
            switch (kind) {
                case "DoiMatKhau":
//                    node = new DoiMatKhau();
                    break;
            }
            switch (kind) {
                case "HeThong":
                    node = new HeThong();
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
}
