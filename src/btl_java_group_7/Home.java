package btl_java_group_7;

import static btl_java_group_7.QuanLyHocSinh.LuuFile;
import static btl_java_group_7.QuanLyHocSinh.dslop;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

/**
 *
 * @author fuong
 */
public class Home extends javax.swing.JFrame {

    public DefaultTableModel model;
    public DefaultTableModel model2;
    public DefaultTableModel model3;
    public DefaultTableModel model4;
    public DefaultTableModel model5;
    public DefaultTableModel model6;
    public int rowIndex;
    public int rowIndex2;
    public int rowIndex3;
    public int rowIndex4;
    public int rowIndex5;
    public int rowIndex6;
    public String imagePath;

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        tableViewStudent();
        tableViewStudentHS();
        tableViewStudentMH();
        tableViewStudentDiem();
        tableViewStudentGV();
        tableViewStudentPCGD();
        loadIdSubject();
        loadIdSubjectGV();
        loadIdClass();
        loadIdClassGV();
        loadIdgvGV();
        loadPCDG();
        loadHotenGVLop();
    }

    public void init() {
        tableViewStudent();
        tableViewStudentHS();
        tableViewStudentMH();
        loadIdClass();
    }

    //Đẩy dữ liệu vào bảng danh sách lớp.
    public void showResult() {
        model.setRowCount(0);
        for (Lop b : QuanLyHocSinh.dslop) {
            model.addRow(new Object[]{b.getMalop(), b.getTenlop(), b.getNienKhoa(), b.getSiso(), b.getGvChuNhiem()});
        }
        model.fireTableDataChanged();
    }

    //Đẩy dữ liệu vào bảng danh sách học sinh.
    public void showResultHS() {
        model2.setRowCount(0);
        for (HocSinh b : QuanLyHocSinh.dshocsinh) {
            model2.addRow(new Object[]{b.getMaHs(), b.getHoTen(), b.getNgaySinh(), b.getGioiTinh(), b.getDiaChi(), b.getDiemVaoTruong(), b.getHoTenBoMe(), b.getSdt(), b.getMalop(), b.getPathImage()});
        }
        model2.fireTableDataChanged();
    }

    //Đẩy dữ liệu vào bảng danh sách môn học.
    public void showResultMH() {
        model3.setRowCount(0);
        for (MonHoc b : QuanLyHocSinh.dsmonhoc) {
            model3.addRow(new Object[]{b.getMamh(), b.getTenmh(), b.getSotiet()});
        }
        model3.fireTableDataChanged();
    }
    //Đẩy dữ liệu vào bảng danh sách điểm.

    public void showResultDiem() {
        model4.setRowCount(0);
        for (Diem b : QuanLyHocSinh.dsdiem) {
            model4.addRow(new Object[]{b.getMahs(), b.getMamh(), b.getDiemKtra_mieng(), b.getDiemKtra_15p(), b.getDiemKtra_heso1(), b.getDiemKtra_heso2(), b.getDiemKtra_thi(), b.getDiemtbky(), b.getKy(), b.getNamhoc()});
        }
        model4.fireTableDataChanged();
    }
    //Đẩy dữ liệu vào bảng danh sách giáo viên.

    public void showResultGV() {
        model6.setRowCount(0);
        for (CanBoGiaoVien b : QuanLyHocSinh.dsgv) {
            model6.addRow(new Object[]{b.getMagv(), b.getHoTen(), b.getDiachi(), b.getSdt(), b.getTaikhoan(), b.getMatkhau()});
        }
        model6.fireTableDataChanged();
    }
    //Đẩy dữ liệu vào bảng danh sách giảng dạy.

    public void showResultPCGD() {
        model5.setRowCount(0);
        for (PhanCongGiangDay b : QuanLyHocSinh.dspcgd) {
            model5.addRow(new Object[]{b.getMaLop(), b.getMaMonHoc(), b.getMaCBGV(), b.getTenCBGV(), b.getNgayPhanCong(), b.getTietDay()});
        }
        model5.fireTableDataChanged();
    }

    public void loadIdClass() {
        String[] labels = new String[dslop.size()];
        for (int i = 0; i < dslop.size(); i++) {
            labels[i] = dslop.get(i).getMalop();
        }
        final DefaultComboBoxModel model = new DefaultComboBoxModel(labels);
        txtmalophs.setModel(model);
    }

    public void loadIdClassGV() {
        String[] labels = new String[dslop.size()];
        for (int i = 0; i < dslop.size(); i++) {
            labels[i] = dslop.get(i).getMalop();
        }
        final DefaultComboBoxModel model = new DefaultComboBoxModel(labels);
        txtmalopGV.setModel(model);
    }

    public void loadIdSubject() {
        String[] labels = new String[QuanLyHocSinh.dsmonhoc.size()];
        for (int i = 0; i < QuanLyHocSinh.dsmonhoc.size(); i++) {
            labels[i] = QuanLyHocSinh.dsmonhoc.get(i).getMamh();
        }
        final DefaultComboBoxModel model = new DefaultComboBoxModel(labels);
        mamondiem.setModel(model);
    }

    public void loadIdSubjectGV() {
        String[] labels = new String[QuanLyHocSinh.dsmonhoc.size()];
        for (int i = 0; i < QuanLyHocSinh.dsmonhoc.size(); i++) {
            labels[i] = QuanLyHocSinh.dsmonhoc.get(i).getMamh();
        }
        final DefaultComboBoxModel model = new DefaultComboBoxModel(labels);
        txtmamonGV.setModel(model);
    }

    public void loadIdgvGV() {
        String[] labels = new String[QuanLyHocSinh.dsgv.size()];
        for (int i = 0; i < QuanLyHocSinh.dsgv.size(); i++) {
            labels[i] = QuanLyHocSinh.dsgv.get(i).getMagv();
        }
        final DefaultComboBoxModel model = new DefaultComboBoxModel(labels);
        txtmagvGV.setModel(model);
    }
    public void loadHotenGVLop() {
        String[] labels = new String[QuanLyHocSinh.dsgv.size()];
        for (int i = 0; i < QuanLyHocSinh.dsgv.size(); i++) {
            labels[i] = QuanLyHocSinh.dsgv.get(i).getHoTen();
        }
        final DefaultComboBoxModel model = new DefaultComboBoxModel(labels);
        jComboBox1.setModel(model);
    }

    public void loadPCDG() {
        String magv = txtmagvGV.getSelectedItem().toString();
        for (CanBoGiaoVien a : QuanLyHocSinh.dsgv) {
            if (a.getMagv().equals(magv)) {
                txthotengvphancong.setText(a.getHoTen());
                break;
            }
        }
    }

    public boolean checkMahs(List<Lop> dslop, String malop) {
        boolean check = false;
        for (Lop lop : dslop) {
            if (lop.getMalop().equals(malop)) {
                check = true;
                break;
            }
        }
        return check;
    }

    public boolean checkMaMonHoc(List<MonHoc> dsmonhoc, String mamonhoc) {
        boolean check = false;
        for (MonHoc monhoc : dsmonhoc) {
            if (monhoc.getMamh().equals(mamonhoc)) {
                check = true;
                break;
            }
        }
        return check;
    }

    public boolean checkMahocsinh(List<HocSinh> dshocsinh, String mahocsinh) {
        boolean check = false;
        for (HocSinh x : dshocsinh) {
            if (x.getMaHs().equals(mahocsinh)) {
                check = true;
                break;
            }
        }
        return check;
    }

    public boolean checkDiem(List<Diem> dsdiem, String mahs, String mamon) {
        boolean check = false;
        for (Diem x : dsdiem) {
            if (x.getMahs().equals(mahs) && x.getMamh().equals(mamon)) {
                check = true;
                break;
            }
        }
        return check;
    }

    public boolean checkPCGD(List<PhanCongGiangDay> dspcgd, String malop, String mamon) {
        boolean check = false;
        for (PhanCongGiangDay x : dspcgd) {
            if (x.getMaLop().equals(malop) && x.getMaMonHoc().equals(mamon)) {
                check = true;
                break;
            }
        }
        return check;
    }

    public boolean checkMaGV(List<CanBoGiaoVien> dsgv, String magv) {
        boolean check = false;
        for (CanBoGiaoVien x : dsgv) {
            if (x.getMagv().equals(magv)) {
                check = true;
                break;
            }
        }
        return check;
    }

    public void refresh() {
        txtmalop.setText(null);
        txttenlop.setText(null);
        txtnienkhoa1.setText(null);
        txtnienkhoa2.setText(null);
        txtsiso.setText(null);
        jComboBox1.setSelectedIndex(0);
    }

    public void refreshHS() {
        txtmahs.setText("");
        txthoten.setText("");
        txtngaysinh.setDate(null);
        txtsdt.setText("");
        txtdiachi.setText("");
        txthotenbome.setText("");
        txtmalophs.setSelectedIndex(0);
        txtdiemdauvao.setText("");
        jLabel26.setIcon(null);
    }

    public void refreshMH() {
        txtmamon.setText("");
        txttenmon.setText("");
        txtsotiet.setText("");
    }

    public void refreshDiem() {
        txtmahsdiem.setText("");
        mamondiem.setSelectedIndex(0);
        txtsotiet.setText("");
        txtdiemmieng.setText("");
        txtdiem15p.setText("");
        txtdiemtx1.setText("");
        txtdiemtx2.setText("");
        txtdiemthi.setText("");
        txtnamhoc.setText("");
        txthocky.setSelectedIndex(0);
    }

    public void refreshGV() {
        txtmagv.setText("");
        txthotengv.setText("");
        txtdiachigv.setText("");
        txtsdtgv.setText("");
        txttaikhoan.setText("");
        txtmatkhau.setText("");
    }

    public void refreshPCGD() {
        txtmalopGV.setSelectedIndex(0);
        txtmamonGV.setSelectedIndex(0);
        txtmagvGV.setSelectedIndex(0);
        loadPCDG();
        txtngayday.setDate(null);
        txttietday.setText("");
    }

    public void tableViewStudent() {
        model = (DefaultTableModel) table.getModel();
        table.setRowHeight(30);
        table.setShowGrid(true);
        table.setGridColor(Color.BLACK);
        table.setBackground(Color.white);
        try {
            QuanLyHocSinh.dslop = QuanLyHocSinh.DocFile();
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        showResult();

    }

    public void tableViewStudentHS() {
        model2 = (DefaultTableModel) table2.getModel();
        table2.setRowHeight(30);
        table2.setShowGrid(true);
        table2.setGridColor(Color.BLACK);
        table2.setBackground(Color.white);
        try {
            QuanLyHocSinh.dshocsinh = QuanLyHocSinh.DocFileHS();
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        showResultHS();

    }

    public void tableViewStudentMH() {
        model3 = (DefaultTableModel) table3.getModel();
        table3.setRowHeight(30);
        table3.setShowGrid(true);
        table3.setGridColor(Color.BLACK);
        table3.setBackground(Color.white);
        try {
            QuanLyHocSinh.dsmonhoc = QuanLyHocSinh.DocFileMH();
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        showResultMH();

    }

    public void tableViewStudentDiem() {
        model4 = (DefaultTableModel) table4.getModel();
        table4.setRowHeight(30);
        table4.setShowGrid(true);
        table4.setGridColor(Color.BLACK);
        table4.setBackground(Color.white);
        try {
            QuanLyHocSinh.dsdiem = QuanLyHocSinh.DocFileDiem();
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        showResultDiem();

    }

    public void tableViewStudentGV() {
        model6 = (DefaultTableModel) table6.getModel();
        table6.setRowHeight(30);
        table6.setShowGrid(true);
        table6.setGridColor(Color.BLACK);
        table6.setBackground(Color.white);
        try {
            QuanLyHocSinh.dsgv = QuanLyHocSinh.DocFileGV();
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        showResultGV();
    }

    public void tableViewStudentPCGD() {
        model5 = (DefaultTableModel) table5.getModel();
        table5.setRowHeight(30);
        table5.setShowGrid(true);
        table5.setGridColor(Color.BLACK);
        table5.setBackground(Color.white);
        try {
            QuanLyHocSinh.dspcgd = QuanLyHocSinh.DocFilePCGD();
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        showResultPCGD();
    }

    public boolean checkRegex() {
        if (txtmalop.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã Lớp Không được để trống !");
            return false;
        } else if (txttenlop.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên Lớp Không được để trống !");
            return false;
        } else if (txtnienkhoa1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Niên Khoá Không được để trống !");
            return false;
        } else if (txtnienkhoa2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Niên Khoá Không được để trống !");
            return false;
        } else if (txtsiso.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sĩ Số Không được để trống !");
            return false;
        } else {
            return true;
        }
    }

    public boolean checkRegexMonHoc() {
        if (txtmamon.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã Môn Không được để trống !");
            return false;
        } else if (txttenmon.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên Môn Không được để trống !");
            return false;
        } else if (txtsotiet.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số Tiết Không được để trống !");
            return false;
        } else {
            return true;
        }
    }

    public boolean checkRegexHocsinh() {
        if (txtmahs.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã Học Sinh Không được để trống !");
            return false;
        } else if (txthoten.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Họ Tên Không được để trống !");
            return false;
        } else if (txtngaysinh.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Ngày sinh Không được để trống !");
            return false;
        } else if (txtngaysinh.getDate().compareTo(new Date()) > 0) {
            JOptionPane.showMessageDialog(this, "Ngày sinh phải nhỏ hơn ngày tháng hiện tại !");
            return false;
        } else if (txtsdt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "SĐT Không được để trống !");
            return false;
        } else if (txtsdt.getText().length() >= 15) {
            JOptionPane.showMessageDialog(this, "SĐT quá dài được để trống !");
            return false;
        } else if (txtdiachi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Địa chỉ Không được để trống !");
            return false;
        } else if (txthotenbome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Họ tên bố/mẹ Không được để trống !");
            return false;
        } else {
            return true;
        }
    }

    public boolean checkRegexDiem() {
        if (txtmahsdiem.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã Học Sinh Không được để trống !");
            return false;
        } else if (txtdiemmieng.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Điểm miệng Không được để trống !");
            return false;
        } else if (txtdiem15p.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Điểm 15p Không được để trống !");
            return false;
        } else if (txtdiemtx1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Điểm TX1 Không được để trống !");
            return false;
        } else if (txtdiemtx2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Điểm TX2 Không được để trống !");
            return false;
        } else if (txtdiemthi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Điểm Thi Không được để trống !");
            return false;
        } else if (txtnamhoc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Năm Học Không được để trống !");
            return false;
        } else {
            return true;
        }
    }

    public boolean checkRegexGiaoVien() {
        if (txtmagv.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã giáo viên Không được để trống !");
            return false;
        } else if (txthotengv.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Họ tên giáo viên Không được để trống !");
            return false;
        } else if (txtdiachigv.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống Không được để trống !");
            return false;
        } else if (txtsdtgv.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại Không được để trống !");
            return false;
        } else if (txttaikhoan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tài khoản Không được để trống !");
            return false;
        } else if (txtmatkhau.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mật khẩu Không được để trống !");
            return false;
        } else {
            return true;
        }
    }

    public boolean checkRegexPCGD() {
        if (txtngayday.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Ngày dạy Không được để trống !");
            return false;
        } else if (txttietday.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tiết dạy không được để trống Không được để trống !");
            return false;
        } else {
            return true;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtmalop = new javax.swing.JTextField();
        txttenlop = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtnienkhoa1 = new javax.swing.JTextField();
        txtsiso = new javax.swing.JTextField();
        txtnienkhoa2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        txtsearchby = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        txtmahs = new javax.swing.JTextField();
        txthoten = new javax.swing.JTextField();
        txtgioitinh = new javax.swing.JComboBox<>();
        txtdiachi = new javax.swing.JTextField();
        txtdiemdauvao = new javax.swing.JTextField();
        txthotenbome = new javax.swing.JTextField();
        txtngaysinh = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        image = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtsdt = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtmalophs = new javax.swing.JComboBox<>();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        txtsearchhs = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        searchbyhs = new javax.swing.JComboBox<>();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        txtmamon = new javax.swing.JTextField();
        txttenmon = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        txtsotiet = new javax.swing.JTextField();
        jButton47 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        txtsearchmonhoc = new javax.swing.JTextField();
        jButton51 = new javax.swing.JButton();
        txtsearchby1 = new javax.swing.JComboBox<>();
        jPanel39 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();
        jButton52 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        txtmahsdiem = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        txtdiemthi = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        txthocky = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        txtnamhoc = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        txtdiemtx2 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        txtdiemtx1 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        mamondiem = new javax.swing.JComboBox<>();
        jLabel44 = new javax.swing.JLabel();
        txtdiemmieng = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        txtdiem15p = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        txtsearchhs1 = new javax.swing.JTextField();
        jButton20 = new javax.swing.JButton();
        searchbyhs1 = new javax.swing.JComboBox<>();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table4 = new javax.swing.JTable();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton55 = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        txttietday = new javax.swing.JTextField();
        jButton56 = new javax.swing.JButton();
        jButton57 = new javax.swing.JButton();
        jButton58 = new javax.swing.JButton();
        jButton59 = new javax.swing.JButton();
        txtmalopGV = new javax.swing.JComboBox<>();
        txtmamonGV = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        txtmagvGV = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        txtngayday = new com.toedter.calendar.JDateChooser();
        jLabel37 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        txthotengvphancong = new javax.swing.JTextField();
        jPanel25 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        txtsearchmonhoc1 = new javax.swing.JTextField();
        jButton60 = new javax.swing.JButton();
        txtsearchby2 = new javax.swing.JComboBox<>();
        jPanel41 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        table5 = new javax.swing.JTable();
        jButton61 = new javax.swing.JButton();
        jButton62 = new javax.swing.JButton();
        jButton63 = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        txtmagv = new javax.swing.JTextField();
        txthotengv = new javax.swing.JTextField();
        txtdiachigv = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        txtsdtgv = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        txttaikhoan = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        txtmatkhau = new javax.swing.JTextField();
        jPanel29 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        txtsearchhs2 = new javax.swing.JTextField();
        jButton29 = new javax.swing.JButton();
        searchbyhs2 = new javax.swing.JComboBox<>();
        jPanel31 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table6 = new javax.swing.JTable();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton64 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Trường Trung Học Phổ Thông Nguyễn Trãi");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseEntered(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));

        jPanel4.setBackground(new java.awt.Color(51, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 4));

        txtmalop.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        txttenlop.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setText("Mã Lớp:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setText("Tên Lớp: ");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setText("GVCN: ");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel10.setText("Niên Khoá: ");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel11.setText("Sĩ Số: ");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel15.setText("Thông Tin Lớp Học");

        txtsiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsisoActionPerformed(evt);
            }
        });

        txtnienkhoa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnienkhoa2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 153, 153));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 153, 153));
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 153, 153));
        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(0, 153, 153));
        jButton8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton8.setText("Refresh");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel21.setText(":");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/javaNguyenTrai.jpg"))); // NOI18N
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txttenlop)
                                    .addComponent(txtmalop)
                                    .addComponent(txtsiso)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(txtnienkhoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnienkhoa2, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                .addGap(40, 40, 40))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(jLabel14))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(141, 141, 141))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(40, 40, 40))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmalop, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttenlop, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtnienkhoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnienkhoa2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtsiso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        jPanel5.setBackground(new java.awt.Color(51, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 4));
        jPanel5.setPreferredSize(new java.awt.Dimension(677, 580));

        jPanel8.setBackground(new java.awt.Color(0, 204, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel12.setText("Tìm Kiếm Lớp Học");

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtsearchby.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo Mã Lớp", "Theo Tên Lớp", "Theo GVCN" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtsearchby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(txtsearchby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(0, 204, 204));
        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        table.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Lớp", "Tên Lớp", "Niên Khoá", "Sĩ Số", "Giáo Viên Chủ Nhiệm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton9.setBackground(new java.awt.Color(0, 153, 153));
        jButton9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton9.setText("SortByName");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(0, 153, 153));
        jButton10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton10.setText("SortByQuantity");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(0, 153, 153));
        jButton11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton11.setText("Exit");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton19.setBackground(new java.awt.Color(0, 153, 153));
        jButton19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton19.setText("Xem Danh Sách Học Sinh");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton9)
                        .addGap(18, 18, 18)
                        .addComponent(jButton10)
                        .addGap(18, 18, 18)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(130, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lớp", jPanel3);

        jPanel10.setBackground(new java.awt.Color(0, 204, 204));

        jPanel11.setBackground(new java.awt.Color(51, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 4));

        txtmahs.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        txthoten.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txthoten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthotenActionPerformed(evt);
            }
        });
        txthoten.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txthotenKeyTyped(evt);
            }
        });

        txtgioitinh.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtgioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        txtgioitinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgioitinhActionPerformed(evt);
            }
        });

        txtdiachi.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        txtdiemdauvao.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtdiemdauvao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdiemdauvaoKeyTyped(evt);
            }
        });

        txthotenbome.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txthotenbome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthotenbomeActionPerformed(evt);
            }
        });

        txtngaysinh.setDateFormatString("dd/MM/yyyy");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel16.setText("Mã HS:");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel17.setText("Họ Tên: ");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel20.setText("Họ Tên Bố/Mẹ: ");

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel22.setText("Địa Chỉ: ");

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel23.setText("Điểm Đầu Vào: ");

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel24.setText("Ngày Sinh: ");

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel25.setText("Giới Tính: ");

        jPanel12.setBackground(new java.awt.Color(51, 255, 255));
        jPanel12.setForeground(new java.awt.Color(204, 204, 204));

        jButton6.setBackground(new java.awt.Color(0, 102, 102));
        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Tải Ảnh Lên");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        image.setBackground(new java.awt.Color(204, 204, 204));

        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        javax.swing.GroupLayout imageLayout = new javax.swing.GroupLayout(image);
        image.setLayout(imageLayout);
        imageLayout.setHorizontalGroup(
            imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 136, Short.MAX_VALUE)
            .addGroup(imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
        );
        imageLayout.setVerticalGroup(
            imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 143, Short.MAX_VALUE)
            .addGroup(imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Hình Ảnh Học Sinh");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel5)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel28.setText("Thông Tin Học Sinh");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel19.setText("SDT: ");

        txtsdt.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtsdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsdtActionPerformed(evt);
            }
        });
        txtsdt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsdtKeyTyped(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel18.setText("Mã Lớp: ");

        txtmalophs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel23))
                                .addGap(1, 1, 1)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtdiachi)
                                    .addComponent(txtdiemdauvao)))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(33, 33, 33)))
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txthoten, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                    .addComponent(txtmahs)
                                    .addComponent(txtngaysinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtsdt)
                                    .addComponent(txthotenbome)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtgioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtmalophs, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(8, 8, 8))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(jLabel27))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmahs, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(4, 4, 4)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtgioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdiemdauvao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(txthotenbome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(6, 6, 6)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtmalophs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        jPanel14.setBackground(new java.awt.Color(51, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 4));
        jPanel14.setPreferredSize(new java.awt.Dimension(677, 580));

        jPanel15.setBackground(new java.awt.Color(0, 204, 204));
        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel29.setText("Tìm Kiếm Học Sinh ");

        jButton7.setText("Search");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        searchbyhs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SearchByName", "SearchByIdClass", "SearchById" }));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addGap(41, 41, 41)
                .addComponent(txtsearchhs, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(searchbyhs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtsearchhs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7)
                    .addComponent(searchbyhs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(0, 204, 204));
        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        table2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HS", "Họ Tên", "Ngày Sinh", "Giới Tính", "Địa Chỉ", "ĐiểmĐV", "Họ Tên Bố/Mẹ", "SĐT", "Mã Lớp", "Image"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true, false, true, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                table2MouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(table2);
        if (table2.getColumnModel().getColumnCount() > 0) {
            table2.getColumnModel().getColumn(1).setMinWidth(120);
            table2.getColumnModel().getColumn(6).setMinWidth(120);
            table2.getColumnModel().getColumn(6).setMaxWidth(120);
            table2.getColumnModel().getColumn(9).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton12.setBackground(new java.awt.Color(0, 153, 153));
        jButton12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton12.setText("Add");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(0, 153, 153));
        jButton13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton13.setText("Update");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(0, 153, 153));
        jButton14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton14.setText("Delete");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(0, 153, 153));
        jButton15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton15.setText("Refresh");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(0, 153, 153));
        jButton16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton16.setText("SortByName");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setBackground(new java.awt.Color(0, 153, 153));
        jButton17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton17.setText("SortByMark");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setBackground(new java.awt.Color(0, 153, 153));
        jButton18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton18.setText("Exit");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton46.setBackground(new java.awt.Color(0, 153, 153));
        jButton46.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton46.setText("SortByClass");
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton13)
                                .addGap(19, 19, 19)
                                .addComponent(jButton14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(33, 33, 33)
                                .addComponent(jButton16)
                                .addGap(18, 18, 18)
                                .addComponent(jButton17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(130, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Học Sinh", jPanel10);

        jPanel6.setBackground(new java.awt.Color(0, 204, 204));

        jPanel7.setBackground(new java.awt.Color(51, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 4));

        txtmamon.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        txttenmon.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel6.setText("Mã Môn: ");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel7.setText("Tên Môn:");

        jLabel72.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel72.setText("Số Tiết: ");

        jLabel74.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel74.setText("Thông Tin Môn Học");

        txtsotiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsotietActionPerformed(evt);
            }
        });

        jButton47.setBackground(new java.awt.Color(0, 153, 153));
        jButton47.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton47.setText("Add");
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });

        jButton48.setBackground(new java.awt.Color(0, 153, 153));
        jButton48.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton48.setText("Update");
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });

        jButton49.setBackground(new java.awt.Color(0, 153, 153));
        jButton49.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton49.setText("Delete");
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });

        jButton50.setBackground(new java.awt.Color(0, 153, 153));
        jButton50.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton50.setText("Refresh");
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/javaNguyenTrai.jpg"))); // NOI18N
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel73)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txttenmon)
                                    .addComponent(txtmamon)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtsotiet)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton47, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(141, 141, 141))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton49, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(56, 56, 56))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel8))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel73)
                .addGap(27, 27, 27)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel74)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmamon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttenmon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(txtsotiet, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton47, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton49, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );

        jPanel13.setBackground(new java.awt.Color(51, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 4));
        jPanel13.setPreferredSize(new java.awt.Dimension(677, 580));

        jPanel38.setBackground(new java.awt.Color(0, 204, 204));
        jPanel38.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel76.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel76.setText("Tìm Kiếm Môn Học");

        jButton51.setText("Search");
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });

        txtsearchby1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo Mã Môn", "Theo Tên Môn" }));

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(txtsearchmonhoc, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtsearchby1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton51)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(txtsearchmonhoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton51)
                    .addComponent(txtsearchby1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel39.setBackground(new java.awt.Color(0, 204, 204));
        jPanel39.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        table3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Môn", "Tên Môn", "Số Tiết"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table3MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(table3);

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton52.setBackground(new java.awt.Color(0, 153, 153));
        jButton52.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton52.setText("SortByName");
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });

        jButton53.setBackground(new java.awt.Color(0, 153, 153));
        jButton53.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton53.setText("SortByIdSubject");
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton53ActionPerformed(evt);
            }
        });

        jButton54.setBackground(new java.awt.Color(0, 153, 153));
        jButton54.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton54.setText("Exit");
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton54ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jButton52, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(jButton53, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton54, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton52, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton53, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton54, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(130, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Môn Học", jPanel6);

        jPanel17.setBackground(new java.awt.Color(0, 204, 204));

        jPanel18.setBackground(new java.awt.Color(51, 255, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 4));

        txtmahsdiem.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel30.setText("Mã HS:");

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel31.setText("Mã Môn:");

        jPanel19.setBackground(new java.awt.Color(51, 255, 255));
        jPanel19.setForeground(new java.awt.Color(204, 204, 204));

        txtdiemthi.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel48.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel48.setText("Điểm Thi: ");

        jLabel50.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel50.setText("Học Kỳ: ");

        txthocky.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Học Kỳ 1", "Học Kỳ 2" }));

        jLabel51.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel51.setText("Năm Học: ");

        txtnamhoc.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtnamhoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamhocActionPerformed(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel47.setText("Điểm TX2: ");

        txtdiemtx2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel46.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel46.setText("Điểm TX1: ");

        txtdiemtx1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnamhoc, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txthocky, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48)
                            .addComponent(jLabel47)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdiemtx1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdiemtx2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdiemthi, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(24, Short.MAX_VALUE))))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtdiemtx1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtdiemtx2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtdiemthi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(txthocky, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(txtnamhoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel40.setText("Thông Tin Điểm");

        mamondiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel44.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel44.setText("Điểm Miệng: ");

        txtdiemmieng.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel45.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel45.setText("Điểm 15p: ");

        txtdiem15p.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/javaNguyenTrai.jpg"))); // NOI18N
        jLabel32.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtmahsdiem, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtdiem15p, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtdiemmieng, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(mamondiem, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel39))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel32))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel40)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmahsdiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mamondiem, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdiemmieng, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtdiem15p, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        jPanel20.setBackground(new java.awt.Color(51, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 4));
        jPanel20.setPreferredSize(new java.awt.Dimension(677, 580));

        jPanel21.setBackground(new java.awt.Color(0, 204, 204));
        jPanel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel43.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel43.setText("Tìm Kiếm  ");

        jButton20.setText("Search");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        searchbyhs1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tìm Kiếm Theo Mã Môn", "Tìm Kiếm Theo Mã HS" }));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtsearchhs1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(searchbyhs1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton20)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(txtsearchhs1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20)
                    .addComponent(searchbyhs1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel22.setBackground(new java.awt.Color(0, 204, 204));
        jPanel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        table4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        table4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HS", "Mã Môn", "Điểm Miệng", "Điểm 15p", "Điểm TX1", "Điểm TX2", "Điểm Thi", "Điểm TB", "Học Kỳ", "Năm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table4MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table4);
        if (table4.getColumnModel().getColumnCount() > 0) {
            table4.getColumnModel().getColumn(0).setMaxWidth(70);
            table4.getColumnModel().getColumn(1).setMaxWidth(70);
            table4.getColumnModel().getColumn(2).setMinWidth(120);
            table4.getColumnModel().getColumn(2).setMaxWidth(120);
            table4.getColumnModel().getColumn(4).setMaxWidth(80);
            table4.getColumnModel().getColumn(5).setMaxWidth(80);
            table4.getColumnModel().getColumn(6).setMaxWidth(80);
            table4.getColumnModel().getColumn(7).setMaxWidth(100);
        }

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton21.setBackground(new java.awt.Color(0, 153, 153));
        jButton21.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton21.setText("Nhập Điểm");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setBackground(new java.awt.Color(0, 153, 153));
        jButton22.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton22.setText("Sửa Điểm");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setBackground(new java.awt.Color(0, 153, 153));
        jButton23.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton23.setText("Xoá Điểm");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton24.setBackground(new java.awt.Color(0, 153, 153));
        jButton24.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton24.setText("Refresh");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setBackground(new java.awt.Color(0, 153, 153));
        jButton25.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton25.setText("SortByName");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setBackground(new java.awt.Color(0, 153, 153));
        jButton26.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton26.setText("SortByMark");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton27.setBackground(new java.awt.Color(0, 153, 153));
        jButton27.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton27.setText("Exit");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton55.setBackground(new java.awt.Color(0, 153, 153));
        jButton55.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton55.setText("SortByClass");
        jButton55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton55ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jButton21)
                        .addGap(5, 5, 5)
                        .addComponent(jButton22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton55, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(130, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Điểm", jPanel17);

        jPanel23.setBackground(new java.awt.Color(0, 204, 204));

        jPanel24.setBackground(new java.awt.Color(51, 255, 255));
        jPanel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 4));

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel33.setText("Mã Lớp: ");

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel34.setText("Mã Môn: ");

        jLabel75.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel75.setText("Tiết Dạy: ");

        jLabel78.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel78.setText("Thông Tin Giảng Dạy");

        txttietday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttietdayActionPerformed(evt);
            }
        });
        txttietday.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttietdayKeyTyped(evt);
            }
        });

        jButton56.setBackground(new java.awt.Color(0, 153, 153));
        jButton56.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton56.setText("Add");
        jButton56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton56ActionPerformed(evt);
            }
        });

        jButton57.setBackground(new java.awt.Color(0, 153, 153));
        jButton57.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton57.setText("Update");
        jButton57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton57ActionPerformed(evt);
            }
        });

        jButton58.setBackground(new java.awt.Color(0, 153, 153));
        jButton58.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton58.setText("Delete");
        jButton58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton58ActionPerformed(evt);
            }
        });

        jButton59.setBackground(new java.awt.Color(0, 153, 153));
        jButton59.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton59.setText("Refresh");
        jButton59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton59ActionPerformed(evt);
            }
        });

        txtmalopGV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtmamonGV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel35.setText("Mã GV:");

        txtmagvGV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtmagvGV.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtmagvGVItemStateChanged(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel36.setText("Ngày Dạy:");

        txtngayday.setDateFormatString("dd/MM/yyyy");

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/javaNguyenTrai.jpg"))); // NOI18N
        jLabel37.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel80.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel80.setText("Tên GV:");

        txthotengvphancong.setEditable(false);
        txthotengvphancong.setBackground(new java.awt.Color(204, 204, 204));
        txthotengvphancong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthotengvphancongActionPerformed(evt);
            }
        });
        txthotengvphancong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txthotengvphancongKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap(331, Short.MAX_VALUE)
                .addComponent(jLabel77)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton56, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton59, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(141, 141, 141))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton58, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton57, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtmagvGV, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel37))
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel24Layout.createSequentialGroup()
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtmalopGV, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel24Layout.createSequentialGroup()
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtmamonGV, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txthotengvphancong, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtngayday, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttietday, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel77)
                .addGap(15, 15, 15)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel78)
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtmalopGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txtmamonGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtmagvGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80)
                    .addComponent(txthotengvphancong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel36)
                    .addComponent(txtngayday, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75)
                    .addComponent(txttietday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton56, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton57, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton59, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton58, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jPanel25.setBackground(new java.awt.Color(51, 255, 255));
        jPanel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 4));
        jPanel25.setPreferredSize(new java.awt.Dimension(677, 580));

        jPanel40.setBackground(new java.awt.Color(0, 204, 204));
        jPanel40.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel79.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel79.setText("Tìm Kiếm Lịch Dạy");

        jButton60.setText("Search");
        jButton60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton60ActionPerformed(evt);
            }
        });

        txtsearchby2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo Mã Môn", "Theo Tên Môn" }));
        txtsearchby2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchby2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(txtsearchmonhoc1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtsearchby2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton60)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(txtsearchmonhoc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton60)
                    .addComponent(txtsearchby2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel41.setBackground(new java.awt.Color(0, 204, 204));
        jPanel41.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        table5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        table5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Lớp", "Mã Môn", "Mã GV", "Tên GV", "Ngày Dạy", "Tiết Dạy"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table5MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(table5);

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton61.setBackground(new java.awt.Color(0, 153, 153));
        jButton61.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton61.setText("SortByName");
        jButton61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton61ActionPerformed(evt);
            }
        });

        jButton62.setBackground(new java.awt.Color(0, 153, 153));
        jButton62.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton62.setText("SortByIdSubject");
        jButton62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton62ActionPerformed(evt);
            }
        });

        jButton63.setBackground(new java.awt.Color(0, 153, 153));
        jButton63.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton63.setText("Exit");
        jButton63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton63ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jButton61, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(jButton62, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton63, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)))
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton61, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton62, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton63, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(124, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Phân Công Lịch Dạy", jPanel23);

        jPanel26.setBackground(new java.awt.Color(0, 204, 204));

        jPanel27.setBackground(new java.awt.Color(51, 255, 255));
        jPanel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 4));

        txtmagv.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        txthotengv.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txthotengv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthotengvActionPerformed(evt);
            }
        });
        txthotengv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txthotengvKeyTyped(evt);
            }
        });

        txtdiachigv.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel38.setText("Mã GV: ");

        jLabel41.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel41.setText("Họ Tên: ");

        jLabel49.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel49.setText("Địa Chỉ: ");

        jPanel28.setBackground(new java.awt.Color(51, 255, 255));
        jPanel28.setForeground(new java.awt.Color(204, 204, 204));

        jButton30.setBackground(new java.awt.Color(0, 153, 153));
        jButton30.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton30.setText("Add");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jButton31.setBackground(new java.awt.Color(0, 153, 153));
        jButton31.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton31.setText("Update");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jButton32.setBackground(new java.awt.Color(0, 153, 153));
        jButton32.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton32.setText("Delete");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jButton33.setBackground(new java.awt.Color(0, 153, 153));
        jButton33.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton33.setText("Refresh");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton32)
                    .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton31)
                    .addComponent(jButton33))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        jLabel58.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel58.setText("Thông Tin Giáo Viên");

        jLabel59.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel59.setText("SDT: ");

        txtsdtgv.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtsdtgv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsdtgvKeyTyped(evt);
            }
        });

        jLabel60.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel60.setText("Tài Khoản: ");

        txttaikhoan.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txttaikhoan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttaikhoanKeyTyped(evt);
            }
        });

        jLabel62.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel62.setText("Mật Khẩu: ");

        txtmatkhau.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtmatkhau.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmatkhauKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel57))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(jLabel49)
                                .addGap(51, 51, 51)
                                .addComponent(txtdiachigv))
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txthotengv)
                                    .addComponent(txtmagv, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel27Layout.createSequentialGroup()
                                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(32, 32, 32))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(63, 63, 63)))
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtsdtgv, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                    .addComponent(txttaikhoan)
                                    .addComponent(txtmatkhau)))))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel57)
                .addGap(46, 46, 46)
                .addComponent(jLabel58)
                .addGap(30, 30, 30)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtmagv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txthotengv, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdiachigv, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49))
                .addGap(18, 18, 18)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsdtgv, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60))
                .addGap(18, 18, 18)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62))
                .addGap(18, 18, 18)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        jPanel29.setBackground(new java.awt.Color(51, 255, 255));
        jPanel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 4));
        jPanel29.setPreferredSize(new java.awt.Dimension(677, 580));

        jPanel30.setBackground(new java.awt.Color(0, 204, 204));
        jPanel30.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel61.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel61.setText("Tìm Kiếm Giáo Viên ");

        jButton29.setText("Search");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        searchbyhs2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SearchByName", "SearchByIdClass", "SearchById" }));

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel61)
                .addGap(41, 41, 41)
                .addComponent(txtsearchhs2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(searchbyhs2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton29)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(txtsearchhs2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton29)
                    .addComponent(searchbyhs2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel31.setBackground(new java.awt.Color(0, 204, 204));
        jPanel31.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        table6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        table6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã GV", "Họ Tên", "Địa Chỉ", "SĐT", "Tài Khoản", "Mật Khẩu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                table6MouseEntered(evt);
            }
        });
        jScrollPane4.setViewportView(table6);

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton34.setBackground(new java.awt.Color(0, 153, 153));
        jButton34.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton34.setText("SortByName");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jButton35.setBackground(new java.awt.Color(0, 153, 153));
        jButton35.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton35.setText("SortByMark");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        jButton36.setBackground(new java.awt.Color(0, 153, 153));
        jButton36.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton36.setText("Exit");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        jButton64.setBackground(new java.awt.Color(0, 153, 153));
        jButton64.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton64.setText("SortByClass");
        jButton64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton64ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addGap(378, 378, 378)
                                .addComponent(jButton34)
                                .addGap(18, 18, 18)
                                .addComponent(jButton35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton64, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(130, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Giáo Viên", jPanel26);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        List<Lop> newds = new ArrayList<Lop>();
        String malop = txtsearch.getText();
        String tenlop = txtsearch.getText();
        String gvcn = txtsearch.getText();
        for (Lop x : dslop) {
            if (txtsearchby.getSelectedIndex() == 0) {
                if (x.getMalop().equals(malop)) {
                    newds.add(x);
                }
            }
            if (txtsearchby.getSelectedIndex() == 1) {
                if (x.getTenlop().equals(tenlop)) {
                    newds.add(x);
                }
            }
            if (txtsearchby.getSelectedIndex() == 2) {
                if (x.getGvChuNhiem().equals(gvcn)) {
                    newds.add(x);
                }
            }

        }
        model.setRowCount(0);
        for (Lop b : newds) {
            model.addRow(new Object[]{b.getMalop(), b.getTenlop(), b.getNienKhoa(), b.getSiso(), b.getGvChuNhiem()});
        }
        model.fireTableDataChanged();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            String malop = txtmalop.getText();
            for (int i = 0; i < dslop.size(); i++) {
                if (dslop.get(i).getMalop().equals(malop)) {
                    dslop.remove(dslop.get(i));
                }
            }
            refresh();
            showResult();
            LuuFile(dslop);
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtgioitinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgioitinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgioitinhActionPerformed

    private void txthotenbomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthotenbomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthotenbomeActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.dir")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.image", ".jpg", "png", "gif");
        file.addChoosableFileFilter(filter);
        int output = file.showSaveDialog(file);
        if (output == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            jLabel26.setIcon(imageAdjust(path, null));
            imagePath = path;
        } else {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Ảnh");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    public ImageIcon imageAdjust(String path, byte[] pic) {
        ImageIcon myImage = null;
        if (path != null) {
            myImage = new ImageIcon(path);
        } else {
            myImage = new ImageIcon(pic);
        }
        Image img = myImage.getImage();
        Image newImage = img.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(newImage);
        return icon;
    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        List<HocSinh> newds = new ArrayList<HocSinh>();
        String malop = txtsearchhs.getText();
        String mahs = txtsearchhs.getText();
        String hoten = txtsearchhs.getText();
        for (HocSinh x : QuanLyHocSinh.dshocsinh) {
            if (searchbyhs.getSelectedIndex() == 0) {
                if (x.getHoTen().equals(hoten)) {
                    newds.add(x);
                }
            }
            if (searchbyhs.getSelectedIndex() == 1) {
                if (x.getMalop().equals(malop)) {
                    newds.add(x);
                }
            }
            if (searchbyhs.getSelectedIndex() == 2) {
                if (x.getMaHs().equals(mahs)) {
                    newds.add(x);
                }
            }

        }
        model2.setRowCount(0);
        for (HocSinh b : newds) {
            model2.addRow(new Object[]{b.getMaHs(), b.getHoTen(), b.getNgaySinh(), b.getGioiTinh(), b.getDiaChi(), b.getDiemVaoTruong(), b.getHoTenBoMe(), b.getSdt(), b.getMalop(), b.getPathImage()});
        }
        model2.fireTableDataChanged();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if (checkRegexHocsinh()) {
            String mahs = txtmahs.getText();
            String hoten = txthoten.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String date = dateFormat.format(txtngaysinh.getDate());
            String gioitinh = txtgioitinh.getSelectedItem().toString();
            String phone = txtsdt.getText();
            String diachi = txtdiachi.getText();
            String tenbome = txthotenbome.getText();
            String malop = txtmalophs.getSelectedItem().toString();
            double diemdv = Double.parseDouble(txtdiemdauvao.getText().toString());
            String pathimage = imagePath;
            if (!checkMahocsinh(QuanLyHocSinh.dshocsinh, mahs)) {
                if (pathimage != null) {
                    HocSinh a = new HocSinh(mahs, hoten, date, gioitinh, diachi, diemdv, tenbome, phone, malop, pathimage);
                    QuanLyHocSinh.dshocsinh.add(a);
                    showResultHS();
                    refreshHS();
                    try {
                        QuanLyHocSinh.LuuFileHS(QuanLyHocSinh.dshocsinh);
                    } catch (Exception ex) {
                        Logger.getLogger(QuanLyHocSinh.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Ảnh");

                }
            } else {
                JOptionPane.showMessageDialog(this, "Mã Học Sinh Đã Tồn Tại !");

            }

        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        try {
            String mahs = txtmahs.getText();
            for (int i = 0; i < QuanLyHocSinh.dshocsinh.size(); i++) {
                if (QuanLyHocSinh.dshocsinh.get(i).getMaHs().equals(mahs)) {
                    QuanLyHocSinh.dshocsinh.remove(QuanLyHocSinh.dshocsinh.get(i));
                }
            }
            refreshHS();
            showResultHS();
            QuanLyHocSinh.LuuFileHS(QuanLyHocSinh.dshocsinh);
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "Xác Nhận Thoát Chương Trình", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            this.dispose();
            new Login().setVisible(true);

        }

        try {
            LuuFile(QuanLyHocSinh.dslop);
        } catch (Exception ex) {
            Logger.getLogger(QuanLyHocSinh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "Xác Nhận Thoát Chương Trình", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            new Login().setVisible(true);

            this.dispose();
        }    }//GEN-LAST:event_jButton18ActionPerformed

    private void txtnienkhoa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnienkhoa2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnienkhoa2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if (checkRegex()) {
            String malop = txtmalop.getText();
            String tenlop = txttenlop.getText();
            String gvcn = jComboBox1.getSelectedItem().toString();
            int nienkhoa1 = 0;
            int nienkhoa2 = 0;
            int siso = 0;
            if (!checkMahs(dslop, malop)) {
                try {
                    nienkhoa1 = Integer.parseInt(txtnienkhoa1.getText());
                    nienkhoa2 = Integer.parseInt(txtnienkhoa2.getText());

                    if (nienkhoa2 - nienkhoa1 <= 0) {
                        JOptionPane.showMessageDialog(this, "Niên khoá:  Năm sau phải lớn hơn năm trước");
                    } else {
                        try {
                            siso = Integer.parseInt(txtsiso.getText());
                            Lop a = new Lop(malop, tenlop, nienkhoa1 + "-" + nienkhoa2, siso, gvcn);
                            QuanLyHocSinh.dslop.add(a);
                            showResult();
                            refresh();
                            try {
                                LuuFile(dslop);
                            } catch (Exception ex) {
                                Logger.getLogger(QuanLyHocSinh.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(this, "Sĩ Số phải là số");
                        }

                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Niên khoá phải là số");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Mã lớp đã tồn tại");
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        refresh();
        showResult();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        model = (DefaultTableModel) table.getModel();
        rowIndex = table.getSelectedRow();
        txtmalop.setText(model.getValueAt(rowIndex, 0).toString());
        txttenlop.setText(model.getValueAt(rowIndex, 1).toString());
        String[] so = model.getValueAt(rowIndex, 2).toString().split("-");
        int nienkhoa1 = Integer.parseInt(so[0]);
        int nienkhoa2 = Integer.parseInt(so[1]);
        txtnienkhoa1.setText(nienkhoa1 + "");
        txtnienkhoa2.setText(nienkhoa2 + "");
        txtsiso.setText(model.getValueAt(rowIndex, 3).toString());
        jComboBox1.setSelectedItem(model.getValueAt(rowIndex, 4).toString());
    }//GEN-LAST:event_tableMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String malop = txtmalop.getText();
        String tenlop = txttenlop.getText();
        String gvcn = jComboBox1.getSelectedItem().toString();
        int nienkhoa1 = 0;
        int nienkhoa2 = 0;
        int siso = 0;
        if (checkMahs(dslop, malop)) {
            try {
                nienkhoa1 = Integer.parseInt(txtnienkhoa1.getText());
                nienkhoa2 = Integer.parseInt(txtnienkhoa2.getText());

                if (nienkhoa2 - nienkhoa1 <= 0) {
                    JOptionPane.showMessageDialog(this, "Niên khoá:  Năm sau phải lớn hơn năm trước");
                } else {
                    try {
                        siso = Integer.parseInt(txtsiso.getText());
                        //update
                        try {
                            malop = txtmalop.getText();
                            for (int i = 0; i < dslop.size(); i++) {
                                if (dslop.get(i).getMalop().equals(malop)) {
                                    dslop.get(i).setTenlop(tenlop);
                                    dslop.get(i).setNienKhoa(nienkhoa1 + "-" + nienkhoa2);
                                    dslop.get(i).setGvChuNhiem(gvcn);
                                    dslop.get(i).setSiso(siso);

                                }
                            }
                            refresh();
                            showResult();
                            LuuFile(dslop);
                        } catch (Exception ex) {
                            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Sĩ Số phải là số");
                    }

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Niên khoá phải là số");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy mã lớp để cập nhật, vui lòng chọn thêm mới");

        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        Collections.sort(dslop, new sosanh());
        showResult();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        Collections.sort(dslop, new sosanh1());
        showResult();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void txthotenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthotenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthotenActionPerformed

    private void txtsdtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsdtKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtsdtKeyTyped

    private void txthotenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthotenKeyTyped
        if (Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }    }//GEN-LAST:event_txthotenKeyTyped

    private void txtdiemdauvaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiemdauvaoKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }    }//GEN-LAST:event_txtdiemdauvaoKeyTyped

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if (checkRegexHocsinh()) {
            String mahs = txtmahs.getText();
            String hoten = txthoten.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String date = dateFormat.format(txtngaysinh.getDate());
            String gioitinh = txtgioitinh.getSelectedItem().toString();
            String phone = txtsdt.getText();
            String diachi = txtdiachi.getText();
            String tenbome = txthotenbome.getText();
            String malop = txtmalophs.getSelectedItem().toString();
            double diemdv = Double.parseDouble(txtdiemdauvao.getText().toString());
            String pathimage = imagePath;

            if (checkMahocsinh(QuanLyHocSinh.dshocsinh, mahs)) {
                for (int i = 0; i < QuanLyHocSinh.dshocsinh.size(); i++) {
                    if (QuanLyHocSinh.dshocsinh.get(i).getMaHs().equals(mahs)) {
                        QuanLyHocSinh.dshocsinh.get(i).setHoTen(hoten);
                        QuanLyHocSinh.dshocsinh.get(i).setNgaySinh(date);
                        QuanLyHocSinh.dshocsinh.get(i).setGioiTinh(gioitinh);
                        QuanLyHocSinh.dshocsinh.get(i).setSdt(phone);
                        QuanLyHocSinh.dshocsinh.get(i).setDiaChi(diachi);
                        QuanLyHocSinh.dshocsinh.get(i).setHoTenBoMe(tenbome);
                        QuanLyHocSinh.dshocsinh.get(i).setMalop(malop);
                        QuanLyHocSinh.dshocsinh.get(i).setDiemVaoTruong(diemdv);
                        if (pathimage != null) {
                            QuanLyHocSinh.dshocsinh.get(i).setPathImage(pathimage);
                        }

                    }
                }
                showResultHS();
                refreshHS();
                try {
                    QuanLyHocSinh.LuuFileHS(QuanLyHocSinh.dshocsinh);
                } catch (Exception ex) {
                    Logger.getLogger(QuanLyHocSinh.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Không Tìm thấy Mã Học Sinh Để Cập Nhật");

            }

        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        loadIdClass();
        tableViewStudentDiem();
        loadIdClassGV();
        loadIdSubject();
        loadIdSubjectGV();
        loadIdgvGV();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        refreshHS();
        showResultHS();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked
        model2 = (DefaultTableModel) table2.getModel();
        rowIndex2 = table2.getSelectedRow();
        txtmahs.setText(model2.getValueAt(rowIndex2, 0).toString());
        txthoten.setText(model2.getValueAt(rowIndex2, 1).toString());
        txtgioitinh.setSelectedItem(model2.getValueAt(rowIndex2, 3).toString());
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(model2.getValueAt(rowIndex2, 2).toString());
            txtngaysinh.setDate(date);
        } catch (Exception e) {
        }
        txtdiachi.setText(model2.getValueAt(rowIndex2, 4).toString());
        txtdiemdauvao.setText(model2.getValueAt(rowIndex2, 5).toString());
        txthotenbome.setText(model2.getValueAt(rowIndex2, 6).toString());
        txtsdt.setText(model2.getValueAt(rowIndex2, 7).toString());
        txtmalophs.setSelectedItem(model2.getValueAt(rowIndex2, 8).toString());
        jLabel26.setIcon(imageAdjust(model2.getValueAt(rowIndex2, 9).toString(), null));
    }//GEN-LAST:event_table2MouseClicked

    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
        Collections.sort(QuanLyHocSinh.dshocsinh, new sortbyclass());
        showResultHS();

    }//GEN-LAST:event_jButton46ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        Collections.sort(QuanLyHocSinh.dshocsinh, new sortbymark());
        showResultHS();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        Collections.sort(QuanLyHocSinh.dshocsinh, new sortbyname());
        showResultHS();

    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        if (checkRegexMonHoc()) {
            String mamon = txtmamon.getText();
            String tenmon = txttenmon.getText();
            int sotiet = 0;

            if (!checkMaMonHoc(QuanLyHocSinh.dsmonhoc, mamon)) {
                try {
                    sotiet = Integer.parseInt(txtsotiet.getText());

                    MonHoc a = new MonHoc(mamon, tenmon, sotiet);
                    QuanLyHocSinh.dsmonhoc.add(a);
                    showResultMH();
                    refreshMH();

                    try {
                        QuanLyHocSinh.LuuFileMH(QuanLyHocSinh.dsmonhoc);
                    } catch (Exception ex) {
                        Logger.getLogger(QuanLyHocSinh.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Số Tiết phải là số");
                }

            } else {
                JOptionPane.showMessageDialog(this, "Mã Môn đã tồn tại");
            }
        }
    }//GEN-LAST:event_jButton47ActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
        if (checkRegexMonHoc()) {
            String mamon = txtmamon.getText();
            String tenmon = txttenmon.getText();
            int sotiet = 0;

            if (checkMaMonHoc(QuanLyHocSinh.dsmonhoc, mamon)) {
                try {
                    sotiet = Integer.parseInt(txtsotiet.getText());

                    try {
                        mamon = txtmamon.getText();
                        for (int i = 0; i < QuanLyHocSinh.dsmonhoc.size(); i++) {
                            if (QuanLyHocSinh.dsmonhoc.get(i).getMamh().equals(mamon)) {
                                QuanLyHocSinh.dsmonhoc.get(i).setTenmh(tenmon);
                                QuanLyHocSinh.dsmonhoc.get(i).setSotiet(sotiet);
                            }
                        }
                        refreshMH();
                        showResultMH();
                        QuanLyHocSinh.LuuFileMH(QuanLyHocSinh.dsmonhoc);
                    } catch (Exception ex) {
                        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Số Tiết phải là số");
                }

            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy mã môn, vùi lòng chọn thêm mới");
            }
        }
    }//GEN-LAST:event_jButton48ActionPerformed

    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed
        try {
            String mamon = txtmamon.getText();
            for (int i = 0; i < QuanLyHocSinh.dsmonhoc.size(); i++) {
                if (QuanLyHocSinh.dsmonhoc.get(i).getMamh().equals(mamon)) {
                    QuanLyHocSinh.dsmonhoc.remove(QuanLyHocSinh.dsmonhoc.get(i));
                }
            }
            refreshMH();
            showResultMH();
            QuanLyHocSinh.LuuFileMH(QuanLyHocSinh.dsmonhoc);
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton49ActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
        refreshMH();
        showResultMH();
    }//GEN-LAST:event_jButton50ActionPerformed

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        List<MonHoc> newds = new ArrayList<MonHoc>();
        String mamon = txtsearchmonhoc.getText();
        String tenmon = txtsearchmonhoc.getText();
        for (MonHoc x : QuanLyHocSinh.dsmonhoc) {
            if (txtsearchby1.getSelectedIndex() == 0) {
                if (x.getMamh().equals(mamon)) {
                    newds.add(x);
                }
            }
            if (txtsearchby1.getSelectedIndex() == 1) {
                if (x.getTenmh().equals(tenmon)) {
                    newds.add(x);
                }
            }

        }
        model3.setRowCount(0);
        for (MonHoc b : newds) {
            model3.addRow(new Object[]{b.getMamh(), b.getTenmh(), b.getSotiet()});
        }
        model3.fireTableDataChanged();
    }//GEN-LAST:event_jButton51ActionPerformed

    private void table3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table3MouseClicked
        model3 = (DefaultTableModel) table3.getModel();
        rowIndex3 = table3.getSelectedRow();
        txtmamon.setText(model3.getValueAt(rowIndex3, 0).toString());
        txttenmon.setText(model3.getValueAt(rowIndex3, 1).toString());
        txtsotiet.setText(model3.getValueAt(rowIndex3, 2).toString());
    }//GEN-LAST:event_table3MouseClicked

    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed
        Collections.sort(QuanLyHocSinh.dsmonhoc, new sortbysubjetname());
        showResultMH();
    }//GEN-LAST:event_jButton52ActionPerformed

    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed
        Collections.sort(QuanLyHocSinh.dsmonhoc, new sortbyidsubject());
        showResultMH();
    }//GEN-LAST:event_jButton53ActionPerformed

    private void jButton54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton54ActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "Xác Nhận Thoát Chương Trình", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            new Login().setVisible(true);
            this.dispose();
        }

        try {
            QuanLyHocSinh.LuuFileMH(QuanLyHocSinh.dsmonhoc);
        } catch (Exception ex) {
            Logger.getLogger(QuanLyHocSinh.class.getName()).log(Level.SEVERE, null, ex);
        }    }//GEN-LAST:event_jButton54ActionPerformed

    private void txtsotietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsotietActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsotietActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton20ActionPerformed

    private void table4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table4MouseClicked
        model4 = (DefaultTableModel) table4.getModel();
        rowIndex4 = table4.getSelectedRow();

        txtmahsdiem.setText(model4.getValueAt(rowIndex4, 0).toString());
        mamondiem.setSelectedItem(model4.getValueAt(rowIndex4, 1).toString());
        txtdiemmieng.setText(model4.getValueAt(rowIndex4, 2).toString());
        txtdiem15p.setText(model4.getValueAt(rowIndex4, 3).toString());
        txtdiemtx1.setText(model4.getValueAt(rowIndex4, 4).toString());
        txtdiemtx2.setText(model4.getValueAt(rowIndex4, 5).toString());
        txtdiemthi.setText(model4.getValueAt(rowIndex4, 6).toString());
        txthocky.setSelectedItem(model4.getValueAt(rowIndex4, 8).toString());
        txtnamhoc.setText(model4.getValueAt(rowIndex4, 9).toString());
    }//GEN-LAST:event_table4MouseClicked

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        if (checkRegexDiem()) {
            String mahs = txtmahsdiem.getText();
            String mamon = mamondiem.getSelectedItem().toString();
            double diemmieng = 0;
            double diem15p = 0;
            double diemtx1 = 0;
            double diemtx2 = 0;
            double diemthi = 0;
            double diemtb = 0;
            String hocky = txthocky.getSelectedItem().toString();
            String namhoc = txtnamhoc.getText();
            try {
                diemmieng = Double.parseDouble(txtdiemmieng.getText());
                diem15p = Double.parseDouble(txtdiem15p.getText());
                diemtx1 = Double.parseDouble(txtdiemtx1.getText());
                diemtx2 = Double.parseDouble(txtdiemtx2.getText());
                diemthi = Double.parseDouble(txtdiemthi.getText());
                diemtb = Double.parseDouble(txtdiemthi.getText());
                diemtb = ((diemthi * 3) + diem15p + diemmieng + diemtx2 * 2 + diemtx1) / 8;
                Diem a = new Diem(mahs, mamon, diemmieng, diem15p, diemtx1, diemtx2, diemthi, diemtb, hocky, namhoc);
                QuanLyHocSinh.dsdiem.add(a);
                showResultDiem();
                refreshDiem();
                try {
                    QuanLyHocSinh.LuuFileDiem(QuanLyHocSinh.dsdiem);
                } catch (Exception ex) {
                    Logger.getLogger(QuanLyHocSinh.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Điểm phải là số");
            }
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        if (checkRegexDiem()) {
            String mahs = txtmahsdiem.getText();
            String mamon = mamondiem.getSelectedItem().toString();
            double diemmieng = 0;
            double diem15p = 0;
            double diemtx1 = 0;
            double diemtx2 = 0;
            double diemthi = 0;
            double diemtb = 0;
            String hocky = txthocky.getSelectedItem().toString();
            String namhoc = txtnamhoc.getText();

            if (checkDiem(QuanLyHocSinh.dsdiem, mahs, mamon)) {
                try {
                    diemmieng = Double.parseDouble(txtdiemmieng.getText());
                    diem15p = Double.parseDouble(txtdiem15p.getText());
                    diemtx1 = Double.parseDouble(txtdiemtx1.getText());
                    diemtx2 = Double.parseDouble(txtdiemtx2.getText());
                    diemthi = Double.parseDouble(txtdiemthi.getText());
                    diemtb = Double.parseDouble(txtdiemthi.getText());
                    diemtb = ((diemthi * 3) + diem15p + diemmieng + diemtx2 * 2 + diemtx1) / 8;
                    for (int i = 0; i < QuanLyHocSinh.dsdiem.size(); i++) {
                        if (QuanLyHocSinh.dsdiem.get(i).getMahs().equals(mahs) && QuanLyHocSinh.dsdiem.get(i).getMamh().equals(mamon)) {
                            QuanLyHocSinh.dsdiem.get(i).setDiemKtra_mieng(diemmieng);
                            QuanLyHocSinh.dsdiem.get(i).setDiemKtra_15p(diem15p);
                            QuanLyHocSinh.dsdiem.get(i).setDiemKtra_heso1(diemtx1);
                            QuanLyHocSinh.dsdiem.get(i).setDiemKtra_heso2(diemtx2);
                            QuanLyHocSinh.dsdiem.get(i).setDiemKtra_thi(diemthi);
                            QuanLyHocSinh.dsdiem.get(i).setDiemtbky(diemtb);
                            QuanLyHocSinh.dsdiem.get(i).setMamh(mamon);
                            QuanLyHocSinh.dsdiem.get(i).setNamhoc(namhoc);
                        }
                    }

                    showResultDiem();
                    refreshDiem();
                    try {
                        QuanLyHocSinh.LuuFileDiem(QuanLyHocSinh.dsdiem);
                    } catch (Exception ex) {
                        Logger.getLogger(QuanLyHocSinh.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Điểm phải là số");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Mã Môn thay đổi vui lòng chọn thêm mới");

            }
        }
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        try {
            String mahs = txtmahsdiem.getText();
            String mamon = mamondiem.getSelectedItem().toString();
            for (int i = 0; i < QuanLyHocSinh.dsdiem.size(); i++) {
                if (QuanLyHocSinh.dsdiem.get(i).getMahs().equals(mahs) || QuanLyHocSinh.dsdiem.get(i).getMamh().equals(mamon)) {
                    QuanLyHocSinh.dsdiem.remove(QuanLyHocSinh.dsdiem.get(i));
                }
            }
            refreshDiem();
            showResultDiem();
            QuanLyHocSinh.LuuFileDiem(QuanLyHocSinh.dsdiem);
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        refreshDiem();
        showResultDiem();
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton55ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton55ActionPerformed

    private void txtnamhocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamhocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamhocActionPerformed

    private void txtsisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsisoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsisoActionPerformed

    private void jTabbedPane1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseEntered

    private void table2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_table2MouseEntered

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        jTabbedPane1.setSelectedIndex(1);
        List<HocSinh> newds = new ArrayList<HocSinh>();
        String malop = model.getValueAt(rowIndex, 0).toString();
        for (HocSinh x : QuanLyHocSinh.dshocsinh) {
            if (x.getMalop().equals(malop)) {
                newds.add(x);
            }
        }
        model2.setRowCount(0);
        for (HocSinh b : newds) {
            model2.addRow(new Object[]{b.getMaHs(), b.getHoTen(), b.getNgaySinh(), b.getGioiTinh(), b.getDiaChi(), b.getDiemVaoTruong(), b.getHoTenBoMe(), b.getSdt(), b.getMalop(), b.getPathImage()});
        }
        model2.fireTableDataChanged();
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton60ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton60ActionPerformed

    private void table5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table5MouseClicked
        model5 = (DefaultTableModel) table5.getModel();
        rowIndex5 = table5.getSelectedRow();

        txtmalopGV.setSelectedItem(model5.getValueAt(rowIndex5, 0).toString());
        txtmamonGV.setSelectedItem(model5.getValueAt(rowIndex5, 1).toString());
        txtmagvGV.setSelectedItem(model5.getValueAt(rowIndex5, 2).toString());
        txthotengvphancong.setText(model5.getValueAt(rowIndex5, 3).toString());
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(model5.getValueAt(rowIndex5, 4).toString());
            txtngayday.setDate(date);
        } catch (Exception e) {
        }
        txttietday.setText(model5.getValueAt(rowIndex5, 5).toString());
    }//GEN-LAST:event_table5MouseClicked

    private void jButton61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton61ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton61ActionPerformed

    private void jButton62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton62ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton62ActionPerformed

    private void jButton63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton63ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton63ActionPerformed

    private void jButton59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton59ActionPerformed
        refreshPCGD();
        showResultPCGD();
    }//GEN-LAST:event_jButton59ActionPerformed

    private void jButton58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton58ActionPerformed
        try {
            String malop = txtmalopGV.getSelectedItem().toString();
            String mamon = txtmamonGV.getSelectedItem().toString();
            for (int i = 0; i < QuanLyHocSinh.dspcgd.size(); i++) {
                if (QuanLyHocSinh.dspcgd.get(i).getMaLop().equals(malop) && QuanLyHocSinh.dspcgd.get(i).getMaMonHoc().equals(mamon)) {
                    QuanLyHocSinh.dspcgd.remove(QuanLyHocSinh.dspcgd.get(i));
                }
            }
            refreshPCGD();
            showResultPCGD();
            QuanLyHocSinh.LuuFilePCGD(QuanLyHocSinh.dspcgd);
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton58ActionPerformed

    private void jButton57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton57ActionPerformed
        if (checkRegexPCGD()) {
            String malop = txtmalopGV.getSelectedItem().toString();
            String mamon = txtmamonGV.getSelectedItem().toString();
            String magv = txtmagvGV.getSelectedItem().toString();
            String tengv = txthotengvphancong.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String date = dateFormat.format(txtngayday.getDate());
            int tietday = 0;

            if (checkPCGD(QuanLyHocSinh.dspcgd, malop, mamon)) {
                try {
                    tietday = Integer.parseInt(txttietday.getText());

                    for (int i = 0; i < QuanLyHocSinh.dspcgd.size(); i++) {
                        if (QuanLyHocSinh.dspcgd.get(i).getMaLop().equals(malop) && QuanLyHocSinh.dspcgd.get(i).getMaMonHoc().equals(mamon)) {
                            QuanLyHocSinh.dspcgd.get(i).setMaCBGV(magv);
                            QuanLyHocSinh.dspcgd.get(i).setTenCBGV(tengv);
                            QuanLyHocSinh.dspcgd.get(i).setNgayPhanCong(date);
                            QuanLyHocSinh.dspcgd.get(i).setTietDay(tietday+"");

                        }
                    }

                    showResultPCGD();
                    refreshPCGD();
                    try {
                        QuanLyHocSinh.LuuFilePCGD(QuanLyHocSinh.dspcgd);
                    } catch (Exception ex) {
                        Logger.getLogger(QuanLyHocSinh.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Tiết dạy phải là số");
                }

            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thẫy mã lớp và mã môn, Vui lòng chọn thêm mới");
            }
        }
    }//GEN-LAST:event_jButton57ActionPerformed

    private void jButton56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton56ActionPerformed
        if (checkRegexPCGD()) {
            String malop = txtmalopGV.getSelectedItem().toString();
            String mamon = txtmamonGV.getSelectedItem().toString();
            String magv = txtmagvGV.getSelectedItem().toString();
            String tengv = txthotengvphancong.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String date = dateFormat.format(txtngayday.getDate());
            int tietday = 0;

            if (!checkPCGD(QuanLyHocSinh.dspcgd, malop, mamon)) {
                try {
                    tietday = Integer.parseInt(txttietday.getText());
                    PhanCongGiangDay a = new PhanCongGiangDay(malop, mamon, magv, tengv, date, tietday + "");
                    QuanLyHocSinh.dspcgd.add(a);
                    showResultPCGD();
                    refreshPCGD();
                    try {
                        QuanLyHocSinh.LuuFilePCGD(QuanLyHocSinh.dspcgd);
                    } catch (Exception ex) {
                        Logger.getLogger(QuanLyHocSinh.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Tiết dạy phải là số");
                }

            } else {
                JOptionPane.showMessageDialog(this, "Mã lớp và mã môn đã tồn tại");
            }
        }

    }//GEN-LAST:event_jButton56ActionPerformed

    private void txttietdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttietdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttietdayActionPerformed

    private void txtsearchby2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchby2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchby2ActionPerformed

    private void txthotengvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthotengvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthotengvActionPerformed

    private void txthotengvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthotengvKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txthotengvKeyTyped

    private void txtsdtgvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsdtgvKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtsdtgvKeyTyped

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton29ActionPerformed

    private void table6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table6MouseClicked
        model6 = (DefaultTableModel) table6.getModel();
        rowIndex6 = table6.getSelectedRow();

        txtmagv.setText(model6.getValueAt(rowIndex6, 0).toString());
        txthotengv.setText(model6.getValueAt(rowIndex6, 1).toString());
        txtdiachigv.setText(model6.getValueAt(rowIndex6, 2).toString());
        txtsdtgv.setText(model6.getValueAt(rowIndex6, 3).toString());
        txttaikhoan.setText(model6.getValueAt(rowIndex6, 4).toString());
        txtmatkhau.setText(model6.getValueAt(rowIndex6, 5).toString());

    }//GEN-LAST:event_table6MouseClicked

    private void table6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_table6MouseEntered

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        if (checkRegexGiaoVien()) {
            String magv = txtmagv.getText();
            String hotengv = txthotengv.getText();
            String diachi = txtdiachigv.getText();
            String sdt = txtsdtgv.getText();
            String tk = txttaikhoan.getText();
            String mk = txtmatkhau.getText();
            if (!checkMaGV(QuanLyHocSinh.dsgv, magv)) {
                try {
                    CanBoGiaoVien a = new CanBoGiaoVien(magv, hotengv, diachi, sdt, tk, mk);
                    QuanLyHocSinh.dsgv.add(a);
                    QuanLyHocSinh.LuuFileGV(QuanLyHocSinh.dsgv);
                    showResultGV();
                    refreshGV();
                } catch (Exception ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Mã giáo viên đã tồn tại !");
            }
        }
        try {
            QuanLyHocSinh.LuuFileGV(QuanLyHocSinh.dsgv);
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        loadHotenGVLop();
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        if (checkRegexGiaoVien()) {
            String magv = txtmagv.getText();
            String hotengv = txthotengv.getText();
            String diachi = txtdiachigv.getText();
            String sdt = txtsdtgv.getText();
            String tk = txttaikhoan.getText();
            String mk = txtmatkhau.getText();

            if (checkMaGV(QuanLyHocSinh.dsgv, magv)) {

                try {
                    for (int i = 0; i < QuanLyHocSinh.dsgv.size(); i++) {
                        if (QuanLyHocSinh.dsgv.get(i).getMagv().equals(magv)) {
                            QuanLyHocSinh.dsgv.get(i).setHoTen(hotengv);
                            QuanLyHocSinh.dsgv.get(i).setDiachi(diachi);
                            QuanLyHocSinh.dsgv.get(i).setSdt(sdt);
                            QuanLyHocSinh.dsgv.get(i).setTaikhoan(tk);
                            QuanLyHocSinh.dsgv.get(i).setMatkhau(mk);
                        }
                    }
                    refreshGV();
                    showResultGV();
                    QuanLyHocSinh.LuuFileGV(QuanLyHocSinh.dsgv);
                } catch (Exception ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy mã giáo viên, vui lòng chọn thêm mới");
            }
        }
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        try {
            String magv = txtmagv.getText();
            for (int i = 0; i < QuanLyHocSinh.dsgv.size(); i++) {
                if (QuanLyHocSinh.dsgv.get(i).getMagv().equals(magv)) {
                    QuanLyHocSinh.dsgv.remove(QuanLyHocSinh.dsgv.get(i));
                }
            }
            refreshGV();
            showResultGV();
            QuanLyHocSinh.LuuFileGV(QuanLyHocSinh.dsgv);
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        try {
            refreshGV();
            showResultGV();
            QuanLyHocSinh.LuuFileGV(QuanLyHocSinh.dsgv);
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton64ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton64ActionPerformed

    private void txttaikhoanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttaikhoanKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txttaikhoanKeyTyped

    private void txtmatkhauKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmatkhauKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmatkhauKeyTyped

    private void txtsdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsdtActionPerformed

    private void txttietdayKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttietdayKeyTyped

    }//GEN-LAST:event_txttietdayKeyTyped

    private void txthotengvphancongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthotengvphancongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthotengvphancongActionPerformed

    private void txthotengvphancongKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthotengvphancongKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txthotengvphancongKeyTyped

    private void txtmagvGVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtmagvGVItemStateChanged
        String magv = txtmagvGV.getSelectedItem().toString();
        for (CanBoGiaoVien a : QuanLyHocSinh.dsgv) {
            if (a.getMagv().equals(magv)) {
                txthotengvphancong.setText(a.getHoTen());
                break;
            }
        }
    }//GEN-LAST:event_txtmagvGVItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel image;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton63;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> mamondiem;
    private javax.swing.JComboBox<String> searchbyhs;
    private javax.swing.JComboBox<String> searchbyhs1;
    private javax.swing.JComboBox<String> searchbyhs2;
    private javax.swing.JTable table;
    private javax.swing.JTable table2;
    private javax.swing.JTable table3;
    private javax.swing.JTable table4;
    private javax.swing.JTable table5;
    private javax.swing.JTable table6;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtdiachigv;
    private javax.swing.JTextField txtdiem15p;
    private javax.swing.JTextField txtdiemdauvao;
    private javax.swing.JTextField txtdiemmieng;
    private javax.swing.JTextField txtdiemthi;
    private javax.swing.JTextField txtdiemtx1;
    private javax.swing.JTextField txtdiemtx2;
    private javax.swing.JComboBox<String> txtgioitinh;
    private javax.swing.JComboBox<String> txthocky;
    private javax.swing.JTextField txthoten;
    private javax.swing.JTextField txthotenbome;
    private javax.swing.JTextField txthotengv;
    private javax.swing.JTextField txthotengvphancong;
    private javax.swing.JTextField txtmagv;
    private javax.swing.JComboBox<String> txtmagvGV;
    private javax.swing.JTextField txtmahs;
    private javax.swing.JTextField txtmahsdiem;
    private javax.swing.JTextField txtmalop;
    private javax.swing.JComboBox<String> txtmalopGV;
    private javax.swing.JComboBox<String> txtmalophs;
    private javax.swing.JTextField txtmamon;
    private javax.swing.JComboBox<String> txtmamonGV;
    private javax.swing.JTextField txtmatkhau;
    private javax.swing.JTextField txtnamhoc;
    private com.toedter.calendar.JDateChooser txtngayday;
    private com.toedter.calendar.JDateChooser txtngaysinh;
    private javax.swing.JTextField txtnienkhoa1;
    private javax.swing.JTextField txtnienkhoa2;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txtsdtgv;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JComboBox<String> txtsearchby;
    private javax.swing.JComboBox<String> txtsearchby1;
    private javax.swing.JComboBox<String> txtsearchby2;
    private javax.swing.JTextField txtsearchhs;
    private javax.swing.JTextField txtsearchhs1;
    private javax.swing.JTextField txtsearchhs2;
    private javax.swing.JTextField txtsearchmonhoc;
    private javax.swing.JTextField txtsearchmonhoc1;
    private javax.swing.JTextField txtsiso;
    private javax.swing.JTextField txtsotiet;
    private javax.swing.JTextField txttaikhoan;
    private javax.swing.JTextField txttenlop;
    private javax.swing.JTextField txttenmon;
    private javax.swing.JTextField txttietday;
    // End of variables declaration//GEN-END:variables

}
