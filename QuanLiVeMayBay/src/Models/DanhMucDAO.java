/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import javax.swing.JPanel;

/**
 *
 * @author FPT
 */
public class DanhMucDAO {
    private String kind;
    private JPanel jpn;

    public DanhMucDAO() {
    }

    public DanhMucDAO(String kind, JPanel jpn) {
        this.kind = kind;
        this.jpn = jpn;
    }
    

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public JPanel getJpn() {
        return jpn;
    }

    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }
}
