/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.ChiTietKhuyenMai;
import domainmodel.DienThoai;
import domainmodel.DungLuong;
import domainmodel.HoaDonChiTiet;
import domainmodel.KhuyenMai;
import domainmodel.MauSac;
import domainmodel.PhuKien;
import domainmodel.Ram;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernatUtil;
import util.ImageHelper;

/**
 *
 * @author sktfk
 */
public class HoaDonChiTietRepository {

    public static List<HoaDonChiTiet> getAll(String maHD) {
        List<HoaDonChiTiet> list;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("From HoaDonChiTiet c where c.hoaDon.MaHD =: mahd");
            q.setParameter("mahd", maHD);
//            q.setParameter("madt", maDT);
            list = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
        return list;
    }

    public static HoaDonChiTiet getAllDT(String maHD, String maDT) {
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("From HoaDonChiTiet c where c.hoaDon.MaHD =:mahd and c.dienThoai.maDienThoai =:madt");
            q.setParameter("mahd", maHD);
            q.setParameter("madt", maDT);
            List<HoaDonChiTiet> list = q.getResultList();
            if (list.isEmpty()) {
                return null;
            }
            return list.get(0);
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }

//    public static void main(String[] args) {
//        System.out.println(getAllDT("HD5", "DT04"));
//    }
    public HoaDonChiTiet getAllPK(String maHD, String maPK) {
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("From HoaDonChiTiet c where c.hoaDon.MaHD =:mahd and c.phuKien.ma =:mapk");
            q.setParameter("mahd", maHD);
            q.setParameter("mapk", maPK);
            List<HoaDonChiTiet> list = q.getResultList();
            if (list.isEmpty()) {
                return null;
            }
            return list.get(0);
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }
//    public static void main(String[] args) {
////        for (HoaDonChiTiet x : getAllDT("HD05","DT05")) {
////            System.out.println(x);
////        }
////        System.out.println(getAllDT("HD05","DT05").isEmpty());
//        System.out.println(getAll("HD05"));
//    }

    public void SaveOrUpdate(HoaDonChiTiet hd) {
        Transaction transaction = null;
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(hd);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            transaction.rollback();
        }
    }

    public void delete(HoaDonChiTiet hd) {
        Transaction transaction = null;
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(hd);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            transaction.rollback();
        }
    }

    public String sumMoney(String maHD) {
        Session session = HibernatUtil.getFACTORY().openSession();
        Query q = session.createQuery("select SUM(h.soLuong * h.donGia) from HoaDonChiTiet h where h.hoaDon.MaHD =:mahd",
                BigDecimal.class);
        q.setParameter("mahd", maHD);
        BigDecimal getSum = (BigDecimal) q.getSingleResult();
        return ImageHelper.resigeNumber(String.valueOf(String.format("%.0f", getSum)));
    }

    //
    public static List<DienThoai> getAllDT(String tenDT, String ram, String mauSac, String dungLuong) {
        List<DienThoai> list;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("FROM DienThoai d where d.tenDienThoai =:ten AND d.ram.ten =:r AND d.mauSac.ten =:ms AND d.dungLuong.ten =:dl");
            q.setParameter("ten", tenDT);
            q.setParameter("r", ram);
            q.setParameter("ms", mauSac);
            q.setParameter("dl", dungLuong);
            list = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
        return list;
    }

    public MauSac GetListMauSac(String ten) {
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            org.hibernate.query.Query query = session.createQuery("FROM MauSac where ten like :ten");
            query.setParameter("ten", ten);
            MauSac mauSac = (MauSac) query.getSingleResult();
            return mauSac;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Ram GetListRam(String ten) {
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            org.hibernate.query.Query query = session.createQuery("FROM Ram where ten like :ten");
            query.setParameter("ten", ten);
            Ram ram = (Ram) query.getSingleResult();
            return ram;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<DungLuong> GetListDungLuong(String tenDienThoai) {
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            Query query = session.createNativeQuery("SELECT DISTINCT d.IdDungLuong,d.Ma,d.Ten,d.TrangThai FROM dbo.DungLuong d JOIN dbo.DienThoai ON DienThoai.IdDungLuong = d.IdDungLuong WHERE dbo.DienThoai.TenDienThoai =:tenDT", DungLuong.class);
            query.setParameter("tenDT", tenDienThoai);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Ram> getListRam(String tenDienThoai, String dungLuong) {
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            Query query = session.createNativeQuery("SELECT DISTINCT r.IdRam,r.Ma,r.Ten,r.TrangThai FROM dbo.DungLuong d JOIN dbo.DienThoai ON DienThoai.IdDungLuong = d.IdDungLuong \n"
                    + "		JOIN dbo.Ram r ON r.IdRam = DienThoai.IdRam\n"
                    + "		WHERE dbo.DienThoai.TenDienThoai =:tenDT AND d.Ten =:tenDL", Ram.class);
            query.setParameter("tenDT", tenDienThoai);
            query.setParameter("tenDL", dungLuong);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<MauSac> getListColor(String tenDienThoai, String dungLuong, String rom) {
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            Query query = session.createNativeQuery("SELECT DISTINCT m.IdMauSac,m.Ma,m.Ten,m.TrangThai FROM dbo.DungLuong d JOIN dbo.DienThoai ON DienThoai.IdDungLuong = d.IdDungLuong \n"
                    + "		JOIN dbo.Ram r ON r.IdRam = DienThoai.IdRam JOIN dbo.MauSac m ON m.IdMauSac = DienThoai.IdMauSac\n"
                    + "		WHERE dbo.DienThoai.TenDienThoai =:tenDT AND d.Ten =:tenDL AND r.Ten=:tenRom", MauSac.class);
            query.setParameter("tenDT", tenDienThoai);
            query.setParameter("tenDL", dungLuong);
            query.setParameter("tenRom", rom);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer getSoLuong(String tenDienThoai, String dungLuong, String ram, String mauSac) {
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            Query query = session.createQuery("SELECT d.soLuongTon FROM DienThoai d Full Join d.dungLuong Full Join d.mauSac Full JOIN d.ram where d.tenDienThoai =:tenDT and d.dungLuong.ten =:tenDL "
                    + "and d.ram.ten=:tenRam and d.mauSac.ten =:mauSac", Integer.class);
            query.setParameter("tenDT", tenDienThoai);
            query.setParameter("tenDL", dungLuong);
            query.setParameter("tenRam", ram);
            query.setParameter("mauSac", mauSac);
            return (Integer) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Long getTongTen(String tenDienThoai) {
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            Query query = session.createQuery("SELECT SUM(d.soLuongTon) from DienThoai d where d.tenDienThoai =:tenDT", Long.class);
            query.setParameter("tenDT", tenDienThoai);
            return (Long) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ChiTietKhuyenMai> getChiTietKhuyenMai(String maDT) {
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            Query query = session.createQuery("SELECT c FROM ChiTietKhuyenMai c where c.dienThoai.maDienThoai =:madt");
            query.setParameter("madt", maDT);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ChiTietKhuyenMai getTienGiamCTKM(String maKM, String maDT) {
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            Query query = session.createQuery("SELECT c FROM ChiTietKhuyenMai c where c.khuyenMai.maKM =:maKM and c.dienThoai.maDienThoai =:madt");
            query.setParameter("maKM", maKM);
            query.setParameter("madt", maDT);
            return (ChiTietKhuyenMai) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void DeleteFromHDCT(String maHD) {
        Transaction transaction = null;
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createNativeQuery("EXEC XoaHDCT :thamSo");
            query.setParameter("thamSo", maHD);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            System.out.println("Lỗi");
        }
    }

    public void DeleteSingle(UUID idHDCT) {
        Transaction transaction = null;
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createNativeQuery("EXEC XoaSP :thamSo");
            query.setParameter("thamSo", idHDCT);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            System.out.println("Lỗi");
        }
    }

    public DienThoai getDienThoai(String ma) {
        String hql = "FROM DienThoai WHERE maDienThoai =:ma";
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            Query q = session.createQuery(hql);
            q.setParameter("ma", ma);
            DienThoai dt = (DienThoai) q.getSingleResult();
            return dt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public KhuyenMai getKM(String ma) {
        String hql = "FROM KhuyenMai WHERE maKM =:ma";
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            Query q = session.createQuery(hql);
            q.setParameter("ma", ma);
            KhuyenMai dt = (KhuyenMai) q.getSingleResult();
            return dt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ChiTietKhuyenMai getCTKM(UUID maDT, String maKM) {
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            Query q = session.createQuery("SELECT ct FROM ChiTietKhuyenMai ct WHERE ct.dienThoai.idDienThoai =:mat and ct.khuyenMai.maKM =:mak");
            q.setParameter("mat", maDT);
            q.setParameter("mak", maKM);
            List<ChiTietKhuyenMai> list = q.getResultList();
            if (list.isEmpty()) {
                return null;
            }
            return list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
//    public static ChiTietKhuyenMai getCTKM(String maDT,String maKM) {
//        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
//            Query q = session.createQuery("SELECT ct FROM ChiTietKhuyenMai ct WHERE ct.dienThoai.maDienThoai =:mat and ct.khuyenMai.maKM =:mak");
//            q.setParameter("mat", maDT);
//            q.setParameter("mak", maKM);
//            List<ChiTietKhuyenMai> list = q.getResultList();
//            if (list.isEmpty()) {
//                return null;
//            }
//            return list.get(0);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//    public static void main(String[] args) {
//        System.out.println(getCTKM("DT01", "KM01"));
//    }

    public void SaveOrUpdateCTKM(ChiTietKhuyenMai ctkm) {
        Transaction transaction = null;
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(ctkm);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            transaction.rollback();
        }
    }

    public void SaveCTKM(ChiTietKhuyenMai ctkm) {
        Transaction transaction = null;
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(ctkm);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            transaction.rollback();
        }
    }

    public List<DienThoai> getDTTKDienThoai(String timKiem) {
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            Query q = session.createQuery("SELECT d FROM DienThoai d WHERE d.maDienThoai Like :tc or d.tenDienThoai.tenDienThoai LIKE :tc");
            q.setParameter("tc", "%" + timKiem + "%");
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<PhuKien> getPKTK(String timKiem) {
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            Query q = session.createQuery("SELECT d From PhuKien d WHERE d.ma Like :tc or d.ten LIKE :tc");
            q.setParameter("tc", "%" + timKiem + "%");
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateDienThoai(DienThoai dienThoai) {
        Transaction transaction = null;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(dienThoai);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            transaction.rollback();
        }
    }

    public Long getCountDT() {
        Session session = HibernatUtil.getFACTORY().openSession();
        Query q = session.createQuery("SELECT COUNT(dt.idDienThoai) from DienThoai dt ",
                Long.class);
        Long getSum = (Long) q.getSingleResult();
        return getSum;
    }

    public Long getCountPK() {
        Session session = HibernatUtil.getFACTORY().openSession();
        Query q = session.createQuery("SELECT COUNT(pk.id) from PhuKien pk ",
                Long.class);
        Long getSum = (Long) q.getSingleResult();
        return getSum;
    }

    public List<DienThoai> getSoKM() {
        Session session = HibernatUtil.getFACTORY().openSession();
        Query q = session.createNativeQuery("SELECT d.* FROM dbo.DienThoai d"
                + " FULL OUTER JOIN dbo.DienThoaiNCC dncc ON dncc.IdDT = d.IdDienThoai FULL OUTER JOIN dbo.ChiTietKhuyenMai ct ON ct.IdDienThoai = d.IdDienThoai "
                + "",
                DienThoai.class);
        return q.getResultList();
    }

    public DienThoai getSinggleDT(String... ten) {
        Session session = HibernatUtil.getFACTORY().openSession();
        Query q = session.createNativeQuery("SELECT dbo.DienThoai.* FROM dbo.DienThoai JOIN dbo.Ram ON Ram.IdRam = DienThoai.IdRam JOIN\n"
                + "dbo.MauSac ON MauSac.IdMauSac = DienThoai.IdMauSac JOIN dbo.DungLuong ON DungLuong.IdDungLuong = DienThoai.IdDungLuong\n"
                + "WHERE Ram.Ten =:r AND DungLuong.Ten =:d AND MauSac.Ten =:m ",
                DienThoai.class);
        q.setParameter("r", ten[0]);
        q.setParameter("d", ten[1]);
        q.setParameter("m", ten[2]);
        List<DienThoai> list = q.getResultList();
        return list.get(0);
    }
//    public ChiTietKhuyenMai getSinggleDT(String... ten) {
//        Session session = HibernatUtil.getFACTORY().openSession();
//        Query q = session.createNativeQuery("SELECT dbo.DienThoai.* FROM dbo.DienThoai JOIN dbo.Ram ON Ram.IdRam = DienThoai.IdRam JOIN\n"
//                + "dbo.MauSac ON MauSac.IdMauSac = DienThoai.IdMauSac JOIN dbo.DungLuong ON DungLuong.IdDungLuong = DienThoai.IdDungLuong\n"
//                + "WHERE Ram.Ten =:r AND DungLuong.Ten =:d AND MauSac.Ten =:m ",
//                DienThoai.class);
//        q.setParameter("r", ten[0]);
//        q.setParameter("d", ten[1]);
//        q.setParameter("m", ten[2]);
//        List<DienThoai> list = q.getResultList();
//        return list.get(0);
//    }

//    public static void main(String[] args) {
//        for (DienThoai x : getSoKM()) {
//            System.out.println(x.getListCTKM());
//        }
//    }
}
