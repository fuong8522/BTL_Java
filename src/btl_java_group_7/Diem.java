package btl_java_group_7;

import java.io.Serializable;

/**
 *
 * @author fuong
 */
public class Diem implements Serializable{
    private String mahs;
    private String mamh;
    private double diemKtra_mieng;
    private double diemKtra_15p;
    private double diemKtra_heso1;
    private double diemKtra_heso2; 
    private double diemKtra_thi; 
    private double diemtbky;
    private String ky;
    private String namhoc;
    
    public Diem() {
    }

    public Diem(String mahs, String mamh, double diemKtra_mieng, double diemKtra_15p, double diemKtra_heso1, double diemKtra_heso2, double diemKtra_thi, double diemtbky, String ky, String namhoc) {
        this.mahs = mahs;
        this.mamh = mamh;
        this.diemKtra_mieng = diemKtra_mieng;
        this.diemKtra_15p = diemKtra_15p;
        this.diemKtra_heso1 = diemKtra_heso1;
        this.diemKtra_heso2 = diemKtra_heso2;
        this.diemKtra_thi = diemKtra_thi;
        this.diemtbky = diemtbky;
        this.ky = ky;
        this.namhoc = namhoc;
    }

    public String getMahs() {
        return mahs;
    }

    public void setMahs(String mahs) {
        this.mahs = mahs;
    }

    public String getMamh() {
        return mamh;
    }

    public void setMamh(String mamh) {
        this.mamh = mamh;
    }

    public double getDiemKtra_mieng() {
        return diemKtra_mieng;
    }

    public void setDiemKtra_mieng(double diemKtra_mieng) {
        this.diemKtra_mieng = diemKtra_mieng;
    }

    public double getDiemKtra_15p() {
        return diemKtra_15p;
    }

    public void setDiemKtra_15p(double diemKtra_15p) {
        this.diemKtra_15p = diemKtra_15p;
    }

    public double getDiemKtra_heso1() {
        return diemKtra_heso1;
    }

    public void setDiemKtra_heso1(double diemKtra_heso1) {
        this.diemKtra_heso1 = diemKtra_heso1;
    }

    public double getDiemKtra_heso2() {
        return diemKtra_heso2;
    }

    public void setDiemKtra_heso2(double diemKtra_heso2) {
        this.diemKtra_heso2 = diemKtra_heso2;
    }

    public double getDiemKtra_thi() {
        return diemKtra_thi;
    }

    public void setDiemKtra_thi(double diemKtra_thi) {
        this.diemKtra_thi = diemKtra_thi;
    }

    public double getDiemtbky() {
        return diemtbky;
    }

    public void setDiemtbky(double diemtbky) {
        this.diemtbky = diemtbky;
    }

    public String getKy() {
        return ky;
    }

    public void setKy(String ky) {
        this.ky = ky;
    }

    public String getNamhoc() {
        return namhoc;
    }

    public void setNamhoc(String namhoc) {
        this.namhoc = namhoc;
    }
    
}
