
package btl_java_group_7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author fuong
 */
public class QuanLyHocSinh implements Serializable{
        public static String userName;
    public static String gvName;
    //Khai báo danh sách.
    public static List<Lop> dslop = new ArrayList<Lop>();
    public static List<HocSinh> dshocsinh = new ArrayList<HocSinh>();
    public static List<MonHoc> dsmonhoc = new ArrayList<MonHoc>();
    public static List<Username> dsuser = new ArrayList<Username>();
    public static List<Diem> dsdiem = new ArrayList<Diem>();
    public static List<CanBoGiaoVien> dsgv = new ArrayList<CanBoGiaoVien>();
    public static List<PhanCongGiangDay> dspcgd = new ArrayList<PhanCongGiangDay>();

    
    //Lưu file danh sách lớp.
    public static void LuuFile(List<Lop> ds) throws Exception {
        FileOutputStream fs = new FileOutputStream("lop.dat");
        //Tạo luồng để serial đối tượng
        ObjectOutputStream os = new ObjectOutputStream(fs);
        //chuyển tải đối tượng tới đích (tập tin)
        os.writeObject(ds);
        //đóng luồng
        os.close();
        fs.close();
    }
    
    //Lưu file danh sách học sinh.
    public static void LuuFileHS(List<HocSinh> ds) throws Exception {
        FileOutputStream fs = new FileOutputStream("hs.dat");
        //Tạo luồng để serial đối tượng
        ObjectOutputStream os = new ObjectOutputStream(fs);
        //chuyển tải đối tượng tới đích (tập tin)
        os.writeObject(ds);
        //đóng luồng
        os.close();
        fs.close();
    }
    
    //Lưu file danh sách môn học.
    public static void LuuFileMH(List<MonHoc> ds) throws Exception {
        FileOutputStream fs = new FileOutputStream("monhoc.dat");
        //Tạo luồng để serial đối tượng
        ObjectOutputStream os = new ObjectOutputStream(fs);
        //chuyển tải đối tượng tới đích (tập tin)
        os.writeObject(ds);
        //đóng luồng
        os.close();
        fs.close();
    }
    
    //Lưu file danh sách điểm.
    public static void LuuFileDiem(List<Diem> ds) throws Exception {
        FileOutputStream fs = new FileOutputStream("diem.dat");
        //Tạo luồng để serial đối tượng
        ObjectOutputStream os = new ObjectOutputStream(fs);
        //chuyển tải đối tượng tới đích (tập tin)
        os.writeObject(ds);
        //đóng luồng
        os.close();
        fs.close();
    }
    
    //Lưu file danh sách tài khoản.
    public static void LuuFileUser(List<Username> ds) throws Exception {
        FileOutputStream fs = new FileOutputStream("user.dat");
        //Tạo luồng để serial đối tượng
        ObjectOutputStream os = new ObjectOutputStream(fs);
        //chuyển tải đối tượng tới đích (tập tin)
        os.writeObject(ds);
        //đóng luồng
        os.close();
        fs.close();
    }
    
    //Lưu file danh sách giáo viên.
    public static void LuuFileGV(List<CanBoGiaoVien> ds) throws Exception {
        FileOutputStream fs = new FileOutputStream("giaovien.dat");
        //Tạo luồng để serial đối tượng
        ObjectOutputStream os = new ObjectOutputStream(fs);
        //chuyển tải đối tượng tới đích (tập tin)
        os.writeObject(ds);
        //đóng luồng
        os.close();
        fs.close();
    }    
    
    //Lưu file danh sách phân công giảng dạy.
    public static void LuuFilePCGD(List<PhanCongGiangDay> ds) throws Exception {
        FileOutputStream fs = new FileOutputStream("phancong.dat");
        //Tạo luồng để serial đối tượng
        ObjectOutputStream os = new ObjectOutputStream(fs);
        //chuyển tải đối tượng tới đích (tập tin)
        os.writeObject(ds);
        //đóng luồng
        os.close();
        fs.close();
    }

    //ĐỌC FILE
    //Đọc file danh sách lớp.
    
    public static List<Lop> DocFile() throws Exception {
        
        Object kq = null;
        FileInputStream fi = new FileInputStream("lop.dat");
        ObjectInputStream ois = new ObjectInputStream(fi);
        kq = ois.readObject();
        fi.close();
        ois.close();
        return (List<Lop>)kq;
    }
    
    //Đọc file danh sách học sinh.
    public static List<HocSinh> DocFileHS() throws Exception {
        
        Object kq = null;
        FileInputStream fi = new FileInputStream("hs.dat");
        ObjectInputStream ois = new ObjectInputStream(fi);
        kq = ois.readObject();
        fi.close();
        ois.close();
        return (List<HocSinh>)kq;
    }
    
    //Đọc file danh sách môn học.
    public static List<MonHoc> DocFileMH() throws Exception {
        
        Object kq = null;
        FileInputStream fi = new FileInputStream("monhoc.dat");
        ObjectInputStream ois = new ObjectInputStream(fi);
        kq = ois.readObject();
        fi.close();
        ois.close();
        return (List<MonHoc>)kq;
    }
    
    //Đọc file danh sách điểm.
    public static List<Diem> DocFileDiem() throws Exception {
        
        Object kq = null;
        FileInputStream fi = new FileInputStream("diem.dat");
        ObjectInputStream ois = new ObjectInputStream(fi);
        kq = ois.readObject();
        fi.close();
        ois.close();
        return (List<Diem>)kq;
    }
    
    //Đọc file danh sách tài khoản.
    public static List<Username> DocFileUser() throws Exception {
        
        Object kq = null;
        FileInputStream fi = new FileInputStream("user.dat");
        ObjectInputStream ois = new ObjectInputStream(fi);
        kq = ois.readObject();
        fi.close();
        ois.close();
        return (List<Username>)kq;
    }
    
    //Đọc file danh sách giáo viên.
    public static List<CanBoGiaoVien> DocFileGV() throws Exception {
        
        Object kq = null;
        FileInputStream fi = new FileInputStream("giaovien.dat");
        ObjectInputStream ois = new ObjectInputStream(fi);
        kq = ois.readObject();
        fi.close();
        ois.close();
        return (List<CanBoGiaoVien>)kq;
    }
    
    //Đọc file danh sách phân công giảng dạy.
    public static List<PhanCongGiangDay> DocFilePCGD() throws Exception {
        
        Object kq = null;
        FileInputStream fi = new FileInputStream("phancong.dat");
        ObjectInputStream ois = new ObjectInputStream(fi);
        kq = ois.readObject();
        fi.close();
        ois.close();
        return (List<PhanCongGiangDay>)kq;
    }
    
    
    public static void main(String[] args) {

    }
}
