
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
    
    public static List<Lop> dslop = new ArrayList<Lop>();
    public static List<HocSinh> dshocsinh = new ArrayList<HocSinh>();
    public static List<MonHoc> dsmonhoc = new ArrayList<MonHoc>();
    public static List<Username> dsuser = new ArrayList<Username>();
    
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

    public static List<Lop> DocFile() throws Exception {
        
        Object kq = null;
        FileInputStream fi = new FileInputStream("lop.dat");
        ObjectInputStream ois = new ObjectInputStream(fi);
        kq = ois.readObject();
        fi.close();
        ois.close();
        return (List<Lop>)kq;
    }
    public static List<HocSinh> DocFileHS() throws Exception {
        
        Object kq = null;
        FileInputStream fi = new FileInputStream("hs.dat");
        ObjectInputStream ois = new ObjectInputStream(fi);
        kq = ois.readObject();
        fi.close();
        ois.close();
        return (List<HocSinh>)kq;
    }
    public static List<MonHoc> DocFileMH() throws Exception {
        
        Object kq = null;
        FileInputStream fi = new FileInputStream("monhoc.dat");
        ObjectInputStream ois = new ObjectInputStream(fi);
        kq = ois.readObject();
        fi.close();
        ois.close();
        return (List<MonHoc>)kq;
    }
    public static List<Username> DocFileUser() throws Exception {
        
        Object kq = null;
        FileInputStream fi = new FileInputStream("user.dat");
        ObjectInputStream ois = new ObjectInputStream(fi);
        kq = ois.readObject();
        fi.close();
        ois.close();
        return (List<Username>)kq;
    }
    
    
    public static void main(String[] args) {
        
        
        try {
            DocFile();
        } catch (Exception ex) {
            Logger.getLogger(QuanLyHocSinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            LuuFile(dslop);
        } catch (Exception ex) {
            Logger.getLogger(QuanLyHocSinh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
