package btl_java_group_7;

import java.io.Serializable;

/**
 *
 * @author fuong
 */
public class PhanCongGiangDay implements Serializable{
    private String maLop;
    private String maMonHoc;
    private String maCBGV;
    private String tenCBGV;
    private String ngayPhanCong;
    private String tietDay;

    public PhanCongGiangDay() {
    }

    public PhanCongGiangDay(String maLop, String maMonHoc, String maCBGV,String tenCBGV, String ngayPhanCong, String tietDay) {
        this.maLop = maLop;
        this.maMonHoc = maMonHoc;
        this.maCBGV = maCBGV;
        this.tenCBGV = tenCBGV;
        this.ngayPhanCong = ngayPhanCong;
        this.tietDay = tietDay;
    }

    public String getMaCBGV() {
        return maCBGV;
    }

    public void setMaCBGV(String maCBGV) {
        this.maCBGV = maCBGV;
    }
   
    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }
    public String getTietDay() {
        return tietDay;
    }

    public void setTietDay(String tietDay) {
        this.tietDay = tietDay;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getTenCBGV() {
        return tenCBGV;
    }

    public void setTenCBGV(String maCBGV) {
        this.tenCBGV = maCBGV;
    }

    public String getNgayPhanCong() {
        return ngayPhanCong;
    }

    public void setNgayPhanCong(String ngayPhanCong) {
        this.ngayPhanCong = ngayPhanCong;
    }
}

