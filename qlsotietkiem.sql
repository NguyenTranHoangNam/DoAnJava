-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 19, 2019 at 05:28 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 5.6.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qlsotietkiem`
--

-- --------------------------------------------------------

--
-- Table structure for table `dangnhap`
--

CREATE TABLE `dangnhap` (
  `TenDangNhap` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `MatKhau` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `MaNhanVien` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `dangnhap`
--

INSERT INTO `dangnhap` (`TenDangNhap`, `MatKhau`, `MaNhanVien`) VALUES
('nthnam', '12345', 'NV0001');

-- --------------------------------------------------------

--
-- Table structure for table `loaitaikhoan`
--

CREATE TABLE `loaitaikhoan` (
  `MaLoaiTaiKhoan` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `TenLoaiTaiKhoan` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `loaitaikhoan`
--

INSERT INTO `loaitaikhoan` (`MaLoaiTaiKhoan`, `TenLoaiTaiKhoan`) VALUES
('LTK01', 'Tài khoản VIP'),
('LTK02', 'Tài khoản thường');

-- --------------------------------------------------------

--
-- Table structure for table `loaitietkiem`
--

CREATE TABLE `loaitietkiem` (
  `MaLoaiTietKiem` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ThoiHan` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `LaiSuat` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `loaitietkiem`
--

INSERT INTO `loaitietkiem` (`MaLoaiTietKiem`, `ThoiHan`, `LaiSuat`) VALUES
('L01', 'Không thời hạn', 0.001),
('L02', '3 tháng', 0.048),
('L03', '6 tháng', 0.074);

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNhanVien` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `HoTen` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `NgaySinh` date NOT NULL,
  `GioiTinh` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `CMND` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `DienThoai` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Email` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MaNhanVien`, `HoTen`, `NgaySinh`, `GioiTinh`, `DiaChi`, `CMND`, `DienThoai`, `Email`) VALUES
('NV0001', 'Nguyễn Trần Hoàng Nam', '1996-10-26', 'Nam', '1423, Nguyễn Trãi, P.Nguyễn Cư Trinh, Q.1, Tp.HCM', '312589620', '0945632810', 'nthnam96@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `phieuguitien`
--

CREATE TABLE `phieuguitien` (
  `MaPhieuGui` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `MaSoTietKiem` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `NgayGuiTien` date NOT NULL,
  `SoTienGui` decimal(20,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `phieuruttien`
--

CREATE TABLE `phieuruttien` (
  `MaPhieuRut` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `MaSoTietKiem` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `NgayRutTien` date NOT NULL,
  `SoTienRut` decimal(20,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sotietkiem`
--

CREATE TABLE `sotietkiem` (
  `MaSo` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `MaTaiKhoan` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `MaLoaiTietKiem` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `NgayMoSo` date NOT NULL,
  `NgayDaoHan` date NOT NULL,
  `SoDu` decimal(20,0) NOT NULL,
  `LaiSuat` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `sotietkiem`
--

INSERT INTO `sotietkiem` (`MaSo`, `MaTaiKhoan`, `MaLoaiTietKiem`, `NgayMoSo`, `NgayDaoHan`, `SoDu`, `LaiSuat`) VALUES
('STK0001', 'TK0002', 'L03', '2019-03-17', '2019-09-17', '250000000', 0.074);

-- --------------------------------------------------------

--
-- Table structure for table `taikhoankhachhang`
--

CREATE TABLE `taikhoankhachhang` (
  `MaTaiKhoan` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `MaLoaiTaiKhoan` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `HoTen` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `NgaySinh` date NOT NULL,
  `GioiTinh` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `CMND` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `DienThoai` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Email` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `taikhoankhachhang`
--

INSERT INTO `taikhoankhachhang` (`MaTaiKhoan`, `MaLoaiTaiKhoan`, `HoTen`, `NgaySinh`, `GioiTinh`, `DiaChi`, `CMND`, `DienThoai`, `Email`) VALUES
('TK0001', 'LTK01', 'Trần Thanh A', '1988-03-12', 'Nam', '172A, Trần Bình Trọng, P.4, Q.5, Tp.HCM', '311458710', '0919873201', 'tthanha@gmail.com'),
('TK0002', 'LTK01', 'Phạm Ngọc B', '1991-12-08', 'Nữ', '227, Kinh Dương Vương, P.An Lạc, Q.Bình Tân, Tp.HCM', '311023598', '0868423179', 'pngocbich08@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dangnhap`
--
ALTER TABLE `dangnhap`
  ADD PRIMARY KEY (`TenDangNhap`),
  ADD KEY `DangNhap_NhanVien` (`MaNhanVien`);

--
-- Indexes for table `loaitaikhoan`
--
ALTER TABLE `loaitaikhoan`
  ADD PRIMARY KEY (`MaLoaiTaiKhoan`);

--
-- Indexes for table `loaitietkiem`
--
ALTER TABLE `loaitietkiem`
  ADD PRIMARY KEY (`MaLoaiTietKiem`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNhanVien`);

--
-- Indexes for table `phieuguitien`
--
ALTER TABLE `phieuguitien`
  ADD PRIMARY KEY (`MaPhieuGui`),
  ADD KEY `PhieuGuiTien_SoTietKiem` (`MaSoTietKiem`);

--
-- Indexes for table `phieuruttien`
--
ALTER TABLE `phieuruttien`
  ADD PRIMARY KEY (`MaPhieuRut`),
  ADD KEY `PhieuRutTien_SoTietKiem` (`MaSoTietKiem`);

--
-- Indexes for table `sotietkiem`
--
ALTER TABLE `sotietkiem`
  ADD PRIMARY KEY (`MaSo`),
  ADD KEY `SoTietKiem_TaiKhoan` (`MaTaiKhoan`),
  ADD KEY `SoTietKiem_LoaiTietKiem` (`MaLoaiTietKiem`);

--
-- Indexes for table `taikhoankhachhang`
--
ALTER TABLE `taikhoankhachhang`
  ADD PRIMARY KEY (`MaTaiKhoan`),
  ADD KEY `TaiKhoan_LoaiTaiKhoan` (`MaLoaiTaiKhoan`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dangnhap`
--
ALTER TABLE `dangnhap`
  ADD CONSTRAINT `DangNhap_NhanVien` FOREIGN KEY (`MaNhanVien`) REFERENCES `nhanvien` (`MaNhanVien`);

--
-- Constraints for table `phieuguitien`
--
ALTER TABLE `phieuguitien`
  ADD CONSTRAINT `PhieuGuiTien_SoTietKiem` FOREIGN KEY (`MaSoTietKiem`) REFERENCES `sotietkiem` (`MaSo`);

--
-- Constraints for table `phieuruttien`
--
ALTER TABLE `phieuruttien`
  ADD CONSTRAINT `PhieuRutTien_SoTietKiem` FOREIGN KEY (`MaSoTietKiem`) REFERENCES `sotietkiem` (`MaSo`);

--
-- Constraints for table `sotietkiem`
--
ALTER TABLE `sotietkiem`
  ADD CONSTRAINT `SoTietKiem_LoaiTietKiem` FOREIGN KEY (`MaLoaiTietKiem`) REFERENCES `loaitietkiem` (`MaLoaiTietKiem`),
  ADD CONSTRAINT `SoTietKiem_TaiKhoan` FOREIGN KEY (`MaTaiKhoan`) REFERENCES `taikhoankhachhang` (`MaTaiKhoan`);

--
-- Constraints for table `taikhoankhachhang`
--
ALTER TABLE `taikhoankhachhang`
  ADD CONSTRAINT `TaiKhoan_LoaiTaiKhoan` FOREIGN KEY (`MaLoaiTaiKhoan`) REFERENCES `loaitaikhoan` (`MaLoaiTaiKhoan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
