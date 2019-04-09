-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 09, 2019 at 06:07 AM
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
  `NgaySinh` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
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
('NV0001', 'Nguyễn Trần Hoàng Nam', '26/10/1996', 'Nam', '1423, Nguyễn Trãi, P.Nguyễn Cư Trinh, Q.1, Tp.HCM', '312589620', '0945632810', 'nthnam96@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `phieuguitien`
--
-- Error reading structure for table qlsotietkiem.phieuguitien: #1932 - Table 'qlsotietkiem.phieuguitien' doesn't exist in engine
-- Error reading data for table qlsotietkiem.phieuguitien: #1064 - You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near 'FROM `qlsotietkiem`.`phieuguitien`' at line 1

-- --------------------------------------------------------

--
-- Table structure for table `phieuruttien`
--
-- Error reading structure for table qlsotietkiem.phieuruttien: #1932 - Table 'qlsotietkiem.phieuruttien' doesn't exist in engine
-- Error reading data for table qlsotietkiem.phieuruttien: #1064 - You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near 'FROM `qlsotietkiem`.`phieuruttien`' at line 1

-- --------------------------------------------------------

--
-- Table structure for table `sotietkiem`
--

CREATE TABLE `sotietkiem` (
  `MaSo` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `LoaiTietKiem` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `KhachHang` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `CMND` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `NgayMoSo` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `NgayDaoHan` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `SoTienGui` double NOT NULL,
  `LaiSuat` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `taikhoankhachhang`
--

CREATE TABLE `taikhoankhachhang` (
  `MaTaiKhoan` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `HoTen` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `NgaySinh` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `GioiTinh` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `CMND` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `SoDienThoai` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Email` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `taikhoankhachhang`
--

INSERT INTO `taikhoankhachhang` (`MaTaiKhoan`, `HoTen`, `NgaySinh`, `GioiTinh`, `CMND`, `DiaChi`, `SoDienThoai`, `Email`) VALUES
('TK0001', 'Nguyễn Trần A', '12-03-1980', 'Nam', '311580237', '227, Nguyễn Văn Cừ, P.4, Q.5, Tp.HCM', '0975495075', 'nta8861@gmail.com'),
('TK0002', 'Trương Bích B', '03-09-1991', 'Nữ', '312080641', '126, Kinh Dương Vương, P.An Lạc A, Q.Bình Tân, Tp.HCM', '0917590790', 'tbb1991@gmail.com');

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
-- Indexes for table `sotietkiem`
--
ALTER TABLE `sotietkiem`
  ADD PRIMARY KEY (`MaSo`);

--
-- Indexes for table `taikhoankhachhang`
--
ALTER TABLE `taikhoankhachhang`
  ADD PRIMARY KEY (`MaTaiKhoan`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dangnhap`
--
ALTER TABLE `dangnhap`
  ADD CONSTRAINT `DangNhap_NhanVien` FOREIGN KEY (`MaNhanVien`) REFERENCES `nhanvien` (`MaNhanVien`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
