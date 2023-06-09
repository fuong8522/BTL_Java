package btl_java_group_7;

import java.io.Serializable;

/**
 *
 * @author fuong
 */
public class CanBoGiaoVien implements Serializable{

    private String magv;
    private String hoTen;
    private String diachi;
    private String sdt;
    private String taikhoan;
    private String matkhau;

    public CanBoGiaoVien() {
    }

    public CanBoGiaoVien(String magv, String hoTen, String diachi, String sdt, String taikhoan, String matkhau) {
        this.magv = magv;
        this.hoTen = hoTen;
        this.diachi = diachi;
        this.sdt = sdt;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;

    }

    public String getMagv() {
        return magv;
    }

    public void setMagv(String magv) {
        this.magv = magv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

}
