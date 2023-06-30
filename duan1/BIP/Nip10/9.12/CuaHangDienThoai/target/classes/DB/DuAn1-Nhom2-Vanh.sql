﻿CREATE DATABASE DuAn1
GO
USE DuAn1
GO
--Chức vụ
CREATE TABLE ChucVu(
	Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	Ma VARCHAR(20) UNIQUE,
	Ten NVARCHAR(50) not null,
	TrangThai int,
	Luong MONEY 
)
GO
--Bảo hành
CREATE TABLE BaoHanh(
	IdBH UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	IdKH UNIQUEIDENTIFIER,
	IdDienThoai UNIQUEIDENTIFIER,
	IdPhuKien UNIQUEIDENTIFIER,
	IdNCC UNIQUEIDENTIFIER,
	IdNV UNIQUEIDENTIFIER,
	MaBH VARCHAR(20),
	NgayBatDau DATE,
	NgayKetThuc DATE,
	TrangThai int,
	MoTa NVARCHAR(MAX)
)
GO
--Hãng
CREATE TABLE Hang(
	Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	Ma VARCHAR(20) UNIQUE,
	Ten NVARCHAR(50) DEFAULT NULL,
	TrangThai int
)
GO
--Ca
CREATE TABLE Ca(
	IdCong UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	BatDauLam DATE,
	KetThucLam DATE
)
GO
--Nhà cung cấp
CREATE TABLE NhaCungCap(
	IdNCC UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	MaNCC VARCHAR(20),
	DiaChi NVARCHAR(MAX),
	TenNhaCC NVARCHAR(30),
	SDT VARCHAR(10),
	Email VARCHAR(50),
	TrangThai INT
)
GO
--Hóa đơn
CREATE TABLE HoaDon(
	IdHD UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	IdKH UNIQUEIDENTIFIER,
	IdNhanVien UNIQUEIDENTIFIER,
	MaHD VARCHAR(20),
	NgayTao DATE,
	NgayThanhToan DATE,
	DiemTichLuy INT,
	TrangThai INT
)
GO
--Hóa đơn chi tiết
CREATE TABLE HoaDonChiTiet(
	IdHDCT UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	IdHD UNIQUEIDENTIFIER,
	IdPK UNIQUEIDENTIFIER,
	IdCTKM UNIQUEIDENTIFIER,
	IdDienThoai UNIQUEIDENTIFIER,
	SoLuong INT,
	DonGia MONEY
)
GO
--Chi tiết khuyến mãi
CREATE TABLE ChiTietKhuyenMai(
	IdCTKM UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	IdKM UNIQUEIDENTIFIER,
	IdPK UNIQUEIDENTIFIER,
	IdDienThoai UNIQUEIDENTIFIER,
	SoTienGiam MONEY
)
GO
--Điện thoại Nhà cung cấp
CREATE TABLE DienThoaiNCC(
	IdDTNCC UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	IdNCC UNIQUEIDENTIFIER,
	IdDT UNIQUEIDENTIFIER,
	GiaNhap MONEY,
	SoLuongNhap INT,
	NgayNhap DATE
)
GO
-- NhanVien
CREATE TABLE NhanVien(
	IDNhanVien UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	MaNhanVien VARCHAR(20) UNIQUE,
	HoTen NVARCHAR(100) NULL,
	GioiTinh INT NULL,
	NamSinh INT NULL,
	DiaChi NVARCHAR(MAX) NULL,
	CCCD VARCHAR(15) NULL,
	Email VARCHAR(50) NULL,
	SoDienThoai VARCHAR(10) NULL,
	TrangThai INT NULL,
	Anh IMAGE,
	QR NVARCHAR(MAX),
	IDTaiKhoan UNIQUEIDENTIFIER,
	IDChucVu UNIQUEIDENTIFIER
);
GO
--Phụ Kiện
CREATE TABLE PhuKien(
	IDPhuKien UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	MaPhuKien VARCHAR(20) UNIQUE,
	TenPhuKien NVARCHAR(100) NULL,
	SoLuongTon INT NULL,
	GiaBan MONEY NULL,
	Anh IMAGE NULL,
	ThoiGianBaoHanh INT NULL,
	Mota NVARCHAR(MAX) NULL,
	TrangThai INT NULL,
	IDHang UNIQUEIDENTIFIER
);
GO
--Điện Thoại
CREATE TABLE DienThoai(
	IdDienThoai UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	MaDienThoai VARCHAR(20) UNIQUE,
	TenDienThoai NVARCHAR(100) NULL,
	SoLuongTon INT,
	CPU VARCHAR(10),
	RAM VARCHAR(10),
	ROM VARCHAR(10),
	ManHinh VARCHAR(10),
	MauSac NVARCHAR(50),
	Pin VARCHAR(10),
	Camera VARCHAR(10),
	HeDieuHanh VARCHAR(10),
	Anh IMAGE,
	GiaBan MONEY,
	ThoiGianBaoHanh INT,
	MoTa NVARCHAR(MAX),
	TrangThai INT,
	IdHang UNIQUEIDENTIFIER,
	IdDienThoaiNCC UNIQUEIDENTIFIER,
)
GO
--Tài Khoản
CREATE TABLE TaiKhoan(
	IdTaiKhoan UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	TaiKhoan VARCHAR(50),
	MatKhau VARCHAR(50),
) 
GO
---- KhachHang
CREATE TABLE KhachHang(
	Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	CCCD VARCHAR(15),
	HoVaTen NVARCHAR(30),
	NgayMua DATE,
	NgaySinh DATE,
	Sdt VARCHAR(30),
	Email VARCHAR(30),
	DiaChi NVARCHAR(100) NOT NULL,
	GhiChu NVARCHAR(MAX),
	DiemTichLuy INT NULL,
	GioiTinh INT
)
GO
--KhuyenMai
CREATE TABLE KhuyenMai(
	Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	Ma VARCHAR(20) UNIQUE,
	Ten NVARCHAR(100) NOT NULL,
	MucKhuyenMai DECIMAL(20,0),
	HinhThucKhuyenMai  NVARCHAR(MAX),
	MoTa  NVARCHAR(MAX),
	TrangThai INT,
	NgayBatDau DATE  NOT NULL,
	NgayKetThuc DATE  NOT NULL
)
--//String maKM, String tenKM, BigDecimal mucKhuyenMai, String hinhThucKhuyenMai, Date ngayBatDau, Date ngayKT, Integer trangThai, String moTa
GO
--Công
CREATE TABLE Cong(
	IdCong UNIQUEIDENTIFIER,
	IdNhanVien UNIQUEIDENTIFIER,
	TrangThai INT,
	TangCa INT,
	GioTre INT,
	CONSTRAINT PK_Cong PRIMARY KEY (IdCong,IdNhanVien),
	CONSTRAINT FK_CongCa FOREIGN KEY(IdCong) REFERENCES Ca(IdCong),
	CONSTRAINT FK_CongNV FOREIGN KEY(IdNhanVien) REFERENCES NhanVien(IdNhanVien),
)
GO
--Phụ kiện Nhà cung cấp
CREATE TABLE PhuKienNCC(
	IdPK UNIQUEIDENTIFIER,
	IdNCC UNIQUEIDENTIFIER,
	GiaNhap MONEY,
	SoLuongNhap INT,
	NgayNhap DATE,
	CONSTRAINT PK_PhuKienNCC PRIMARY KEY (IdPK,IdNCC),
	CONSTRAINT FK1 FOREIGN KEY(IdPK) REFERENCES PhuKien(IdPhuKien),
	CONSTRAINT FK2 FOREIGN KEY(IdNCC) REFERENCES NhaCungCap(IdNCC),
)
GO
--TẠO QUAN HỆ GIỮA CÁC BẢNG
--NhanVien - TaiKhoan
ALTER TABLE NhanVien ADD FOREIGN KEY (IdTaiKhoan) REFERENCES TaiKhoan(IdTaiKhoan)
--NhanVien - ChucVu
ALTER TABLE NhanVien ADD FOREIGN KEY (IDChucVu) REFERENCES ChucVu(Id)
-- HoaDon - KhachHang
ALTER TABLE HoaDon ADD FOREIGN KEY (IdKH) REFERENCES KhachHang(Id)
-- HoaDon - NhanVien
ALTER TABLE HoaDon ADD FOREIGN KEY (IdNhanVien) REFERENCES NhanVien(IdNhanVien)
--BaoHanh - KhachHang
ALTER TABLE BaoHanh ADD FOREIGN KEY (IdKH) REFERENCES KhachHang(Id)
--BaoHanh - DienThoai
ALTER TABLE BaoHanh ADD FOREIGN KEY (IdDienThoai) REFERENCES DienThoai(IdDienThoai)
--BaoHanh - PhuKien
ALTER TABLE BaoHanh ADD FOREIGN KEY (IdPhuKien) REFERENCES PhuKien(IdPhuKien)
--BaoHanh - NhaCungCap
ALTER TABLE BaoHanh ADD FOREIGN KEY (IdNCC) REFERENCES NhaCungCap(IdNCC)
--BaoHanh - NhanVien
ALTER TABLE BaoHanh ADD FOREIGN KEY (IdNV) REFERENCES NhanVien(IdNhanVien)
-- HoaDonChiTiet - HoaDon
ALTER TABLE HoaDonChiTiet ADD FOREIGN KEY (IdHD) REFERENCES HoaDon(IdHD)
-- HoaDonChiTiet - PhuKien
ALTER TABLE HoaDonChiTiet ADD FOREIGN KEY (IdPK) REFERENCES PhuKien(IdPhuKien)
-- HoaDonChiTiet - DienThoai
ALTER TABLE HoaDonChiTiet ADD FOREIGN KEY (IdDienThoai) REFERENCES DienThoai(IdDienThoai)
-- HoaDonChiTiet - CTKM
ALTER TABLE HoaDonChiTiet ADD FOREIGN KEY (IdCTKM) REFERENCES ChiTietKhuyenMai(IdCTKM)
--DienThoai - Hang
ALTER TABLE DienThoai ADD FOREIGN KEY(IdHang) REFERENCES Hang(Id)
--DienThoai - DienThoaiNCC
ALTER TABLE DienThoai ADD FOREIGN KEY(IdDienThoaiNCC) REFERENCES DienThoaiNCC(IdDTNCC)
-- ChiTietKhuyenMai - PhuKien
ALTER TABLE ChiTietKhuyenMai ADD FOREIGN KEY(IdPK) REFERENCES PhuKien(IdPhuKien)
-- ChiTietKhuyenMai - KhuyenMai
ALTER TABLE ChiTietKhuyenMai ADD FOREIGN KEY(IdKM) REFERENCES KhuyenMai(Id)
-- ChiTietKhuyenMai - DienThoai
ALTER TABLE ChiTietKhuyenMai ADD FOREIGN KEY(IdDienThoai) REFERENCES DienThoai(IdDienThoai)
--PhuKien - Hang
ALTER TABLE PhuKien ADD FOREIGN KEY(IdHang) REFERENCES Hang(Id)
GO
