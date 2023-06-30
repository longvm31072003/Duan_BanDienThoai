package util;

import domainmodel.ChiTietKhuyenMai;
import domainmodel.ChucVu;
import domainmodel.NhanVien;
import domainmodel.PhuKien;
import domainmodel.DienThoai;
import domainmodel.DienThoaiNCC;
import domainmodel.DungLuong;
import domainmodel.GenDB;
import domainmodel.Hang;
import domainmodel.HoaDon;
import domainmodel.HoaDonChiTiet;
import domainmodel.Imei;
import domainmodel.ImeiDaBan;
import domainmodel.KhachHang;
import domainmodel.KhuyenMai;
import domainmodel.MauSac;
import domainmodel.NhaCungCap;
import domainmodel.PhuKienNCC;
import domainmodel.Ram;
import domainmodel.TaiKhoan;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernatUtil {

    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=DuAn1");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "123456");
        properties.put(Environment.SHOW_SQL, "true");
        //gen DB tự động
//        properties.put(Environment.HBM2DDL_AUTO, "create");

        conf.setProperties(properties);
        conf.addAnnotatedClass(DienThoai.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(TaiKhoan.class);
        conf.addAnnotatedClass(PhuKien.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(KhuyenMai.class);
        conf.addAnnotatedClass(Hang.class);
        conf.addAnnotatedClass(HoaDonChiTiet.class);
        conf.addAnnotatedClass(ChiTietKhuyenMai.class);
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(DienThoaiNCC.class);
        conf.addAnnotatedClass(PhuKienNCC.class);
        conf.addAnnotatedClass(NhaCungCap.class);
        conf.addAnnotatedClass(DungLuong.class);
        conf.addAnnotatedClass(Ram.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(Imei.class);
        conf.addAnnotatedClass(ImeiDaBan.class);
        
        
//        conf.addAnnotatedClass(GenDB.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        getFACTORY();
    }

}
