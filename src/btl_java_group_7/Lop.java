
package btl_java_group_7;

import java.io.Serializable;

/**
 *
 * @author fuong
 */
public class Lop implements Serializable{
    private String malop;
    private String tenlop;
    private String nienKhoa;
    private int siso;
    private String gvChuNhiem;

    public Lop() {
    }

    public Lop(String malop, String tenlop, String nienKhoa, int siso, String gvChuNhiem) {
        this.malop = malop;
        this.tenlop = tenlop;
        this.nienKhoa = nienKhoa;
        this.siso = siso;
        this.gvChuNhiem = gvChuNhiem;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public String getNienKhoa() {
        return nienKhoa;
    }

    public void setNienKhoa(String nienKhoa) {
        this.nienKhoa = nienKhoa;
    }

    public int getSiso() {
        return siso;
    }

    public void setSiso(int siso) {
        this.siso = siso;
    }

    public String getGvChuNhiem() {
        return gvChuNhiem;
    }

    public void setGvChuNhiem(String gvChuNhiem) {
        this.gvChuNhiem = gvChuNhiem;
    }
    
    
    
}
