package btl_java_group_7;

import java.io.Serializable;

/**
 *
 * @author fuong
 */
public class HocSinh implements Serializable{
    private String maHs;
    private String hoTen;
    private String ngaySinh;
    private String gioiTinh;
    private String diaChi;
    private double diemVaoTruong;
    private String hoTenBoMe;
    private String sdt;
    private String malop;
    public String pathImage;

    public HocSinh() {
    }

    public HocSinh(String maHs, String hoTen, String ngaySinh, String gioiTinh, String diaChi, double diemVaoTruong, String hoTenBoMe, String sdt, String malop,String pathImage) {
        this.maHs = maHs;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.diemVaoTruong = diemVaoTruong;
        this.hoTenBoMe = hoTenBoMe;
        this.sdt = sdt;
        this.malop = malop;
        this.pathImage = pathImage;
    }

    public String getMaHs() {
        return maHs;
    }

    public void setMaHs(String maHs) {
        this.maHs = maHs;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public double getDiemVaoTruong() {
        return diemVaoTruong;
    }

    public void setDiemVaoTruong(double diemVaoTruong) {
        this.diemVaoTruong = diemVaoTruong;
    }

    public String getHoTenBoMe() {
        return hoTenBoMe;
    }

    public void setHoTenBoMe(String hoTenBoMe) {
        this.hoTenBoMe = hoTenBoMe;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }
    
}
