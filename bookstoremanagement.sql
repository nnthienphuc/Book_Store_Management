-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/

-- Host: 127.0.0.1
-- Generation Time: Jul 19, 2024 at 01:55 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12
-- @author nnthienphuc

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bookstoremanagement`
--
CREATE DATABASE IF NOT EXISTS `bookstoremanagement` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bookstoremanagement`;

-- --------------------------------------------------------

--
-- Table structure for table `chitiethoadonban`
--

CREATE TABLE `chitiethoadonban` (
  `maHDB` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `maSach` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `soLuong` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- RELATIONSHIPS FOR TABLE `chitiethoadonban`:
--   `maHDB`
--       `hoadonban` -> `maHDB`
--   `maSach`
--       `sach` -> `maSach`
--

--
-- Dumping data for table `chitiethoadonban`
--

INSERT INTO `chitiethoadonban` (`maHDB`, `maSach`, `soLuong`) VALUES
('HDB1', 'MS3', 1),
('HDB2', 'MS5', 1),
('HDB3', 'MS5', 1),
('HDB4', 'MS11', 1),
('HDB5', 'MS14', 2),
('HDB5', 'MS4', 1),
('HDB6', 'MS11', 1),
('HDB6', 'MS2', 3),
('HDB6', 'MS5', 2),
('HDB7', 'MS3', 10);

-- --------------------------------------------------------

--
-- Table structure for table `chitiethoadonnhap`
--

CREATE TABLE `chitiethoadonnhap` (
  `maHDN` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `maSach` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `soLuong` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- RELATIONSHIPS FOR TABLE `chitiethoadonnhap`:
--   `maHDN`
--       `hoadonnhap` -> `maHDN`
--   `maSach`
--       `sach` -> `maSach`
--

--
-- Dumping data for table `chitiethoadonnhap`
--

INSERT INTO `chitiethoadonnhap` (`maHDN`, `maSach`, `soLuong`) VALUES
('HDN1', 'MS3', 1),
('HDN2', 'MS5', 1),
('HDN3', 'MS5', 1),
('HDN4', 'MS11', 1),
('HDN5', 'MS1', 31),
('HDN5', 'MS13', 10),
('HDN5', 'MS15', 10),
('HDN5', 'MS2', 8),
('HDN5', 'MS7', 40),
('HDN6', 'MS1', 10),
('HDN6', 'MS10', 10),
('HDN6', 'MS11', 10),
('HDN6', 'MS12', 10),
('HDN6', 'MS13', 10),
('HDN6', 'MS14', 10),
('HDN6', 'MS15', 10),
('HDN6', 'MS2', 10),
('HDN6', 'MS3', 10),
('HDN6', 'MS4', 10),
('HDN6', 'MS5', 10),
('HDN6', 'MS6', 10),
('HDN6', 'MS7', 10),
('HDN6', 'MS8', 10),
('HDN6', 'MS9', 10),
('HDN7', 'MS10', 17),
('HDN7', 'MS11', 12),
('HDN7', 'MS12', 16),
('HDN7', 'MS15', 1),
('HDN7', 'MS4', 10);

-- --------------------------------------------------------

--
-- Table structure for table `hoadonban`
--

CREATE TABLE `hoadonban` (
  `maHDB` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `maKH` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `maNV` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `maKM` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ngayLap` date NOT NULL,
  `gioLap` time NOT NULL,
  `tongTien` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- RELATIONSHIPS FOR TABLE `hoadonban`:
--   `maKH`
--       `khachhang` -> `maKH`
--   `maNV`
--       `nhanvien` -> `maNV`
--   `maKM`
--       `khuyenmai` -> `maKM`
--

--
-- Dumping data for table `hoadonban`
--

INSERT INTO `hoadonban` (`maHDB`, `maKH`, `maNV`, `maKM`, `ngayLap`, `gioLap`, `tongTien`) VALUES
('HDB1', 'KH1', 'NV1', 'KM1', '2023-10-10', '22:45:52', 399),
('HDB2', 'KH3', 'NV3', 'KM1', '2023-10-16', '12:22:52', 299),
('HDB3', 'KH3', 'NV2', 'KM1', '2023-11-15', '02:22:52', 299),
('HDB4', 'KH4', 'NV2', 'KM1', '2024-09-02', '02:22:52', 499),
('HDB5', 'KH14', 'NV1', 'KM1', '2024-07-19', '18:43:00', 817),
('HDB6', 'KH1', 'NV1', 'KM6', '2024-07-19', '18:43:00', 1206.8),
('HDB7', 'KH20', 'NV1', 'KM6', '2024-07-19', '18:43:00', 2793);

-- --------------------------------------------------------

--
-- Table structure for table `hoadonnhap`
--

CREATE TABLE `hoadonnhap` (
  `maHDN` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `maNCC` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `maNV` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ngayLap` date NOT NULL,
  `gioLap` time NOT NULL,
  `tongTien` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- RELATIONSHIPS FOR TABLE `hoadonnhap`:
--   `maNCC`
--       `nhacungcap` -> `maNCC`
--   `maNV`
--       `nhanvien` -> `maNV`
--

--
-- Dumping data for table `hoadonnhap`
--

INSERT INTO `hoadonnhap` (`maHDN`, `maNCC`, `maNV`, `ngayLap`, `gioLap`, `tongTien`) VALUES
('HDN1', 'NCC1', 'NV2', '2023-10-14', '22:45:52', 299),
('HDN2', 'NCC3', 'NV3', '2023-10-16', '12:22:52', 199),
('HDN3', 'NCC2', 'NV1', '2023-11-12', '02:22:52', 199),
('HDN4', 'NCC1', 'NV2', '2023-12-11', '02:22:52', 399),
('HDN5', 'NCC1', 'NV1', '2024-07-19', '18:43:00', 19301),
('HDN6', 'NCC4', 'NV1', '2024-07-19', '18:43:00', 32750),
('HDN7', 'NCC5', 'NV1', '2024-07-19', '18:43:00', 15224);

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `maKH` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tenKH` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `diaChi` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `SDT` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- RELATIONSHIPS FOR TABLE `khachhang`:
--

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`maKH`, `tenKH`, `diaChi`, `SDT`) VALUES
('KH1', 'Nguyễn Ngọc Thiên Phúc', 'TP HCM', '0123456789'),
('KH10', 'Trần Ngọc Hải', 'Kiên Giang', '0905271941'),
('KH11', 'Nguyễn Xuân Diệu', 'TP HCM', '0301279552'),
('KH12', 'Trần Thanh Thiện', 'Hà Nội', '0123617389'),
('KH13', 'Huỳnh Minh Mẫn', 'An Giang', '0389230581'),
('KH14', 'Trần Xuân An', 'Long An', '0972136531'),
('KH15', 'Nguyễn Thị Xuân', 'TP HCM', '0702571936'),
('KH16', 'Huỳnh Anh Thư', 'Bến Tre', '0892383623'),
('KH17', 'Trần Thanh Nhã', 'TP HCM', '0702397442'),
('KH18', 'Huỳnh Nhựt Trường', 'TP HCM', '0120982736'),
('KH19', 'Trần Ngọc Hà', 'TP HCM', '0702843627'),
('KH2', 'Nguyễn Thiên Hữu', 'Huế', '0126461589'),
('KH20', 'Trần Thị Hoài Anh', 'TP HCM', '0126729137'),
('KH21', 'Nguyễn Văn Thắng', 'Kiên Giang', '0723812935'),
('KH22', 'Huỳnh Lê Diệu Hân', 'Hà Nội', '0306279178'),
('KH3', 'Phan Thanh Tùng', 'Hà Nội', '0952612771'),
('KH4', 'Trần Thanh Sơn', 'Hải Phòng', '0120617231'),
('KH5', 'Trần Thanh Thái', 'Bến Tre', '0912385524'),
('KH6', 'Nguyễn Hồng Nhung', 'Huế', '0967263941'),
('KH7', 'Từ Ngọc Cảnh', 'Sóc Trăng', '0306172915'),
('KH8', 'Nguyễn Thiên Phụng', 'Vũng Tàu', '0703167293'),
('KH9', 'Nguyễn Diệu Ái', 'TP HCM', '0805178293');

-- --------------------------------------------------------

--
-- Table structure for table `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `maKM` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tenKM` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dieuKienKM` float NOT NULL,
  `phanTramKM` float NOT NULL,
  `ngayBD` date NOT NULL,
  `ngayKT` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- RELATIONSHIPS FOR TABLE `khuyenmai`:
--

--
-- Dumping data for table `khuyenmai`
--

INSERT INTO `khuyenmai` (`maKM`, `tenKM`, `dieuKienKM`, `phanTramKM`, `ngayBD`, `ngayKT`) VALUES
('KM1', 'Không Khuyến Mãi', 0, 0, '2023-01-01', '2024-10-25'),
('KM2', 'Khuyễn Mãi Nhập Học', 500, 30, '2024-08-01', '2024-08-25'),
('KM3', 'Khuyến Mãi Valentine', 400, 14, '2024-02-13', '2024-02-15'),
('KM4', 'Khuyến Mãi Đầu Năm', 700, 50, '2024-01-01', '2024-01-30'),
('KM5', 'Khuyến Mãi Cuối Năm', 450, 20, '2024-11-01', '2024-12-30'),
('KM6', 'Khuyến Mãi Hè 2024', 500, 30, '2024-07-19', '2024-08-16');

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `maNCC` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tenNCC` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `diaChi` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `SDT` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `FAX` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- RELATIONSHIPS FOR TABLE `nhacungcap`:
--

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`maNCC`, `tenNCC`, `diaChi`, `SDT`, `FAX`) VALUES
('NCC1', 'Nhà sách Phương Nam', 'TP HCM', '0123456789', '4598-8789-8789-7897'),
('NCC2', 'Nhà xuất bản Khoa học và Kỹ thuật', 'Hà Nội', '0120728815', '3672-1782-3923-6091'),
('NCC3', 'Nhà sách Cá Chép', 'TP HCM', '0703192738', '2364-2974-2384-2394'),
('NCC4', 'Nhà sách Kim Đồng', 'TP HCM', '0501239237', '9823-6738-6739-6766'),
('NCC5', 'Thế Giới Lập Trình', 'Đồng Nai', '0801729329', '1830-7288-8900-7712');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `maNV` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tenNV` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ngaySinh` date NOT NULL,
  `diaChi` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `SDT` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `trangThai` int(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- RELATIONSHIPS FOR TABLE `nhanvien`:
--

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`maNV`, `tenNV`, `ngaySinh`, `diaChi`, `SDT`, `trangThai`) VALUES
('NV1', 'Nguyễn Ngọc Thiên Phúc', '2003-08-16', 'Đồng Nai', '0397357001', 0),
('NV2', 'Trần Thị Thùy Ngân', '2003-04-05', 'TP HCM', '0123456489', 0),
('NV3', 'Trần Song Nguyên', '2003-04-05', 'Hà Nội', '0128456786', 0),
('NV4', 'Trần Văn Hoàng', '1999-11-12', 'TP HCM', '0120776466', 0),
('NV5', 'Lê Thanh Tú', '1991-04-11', 'Hải Phòng', '0367756753', 0),
('NV6', 'Nguyễn Hải Âu', '1992-04-24', 'Huế', '0364198226', 0),
('NV7', 'Hoàng Thanh Hùng', '1989-11-13', 'Long An', '0276886265', 0),
('NV8', 'Trịnh Văn Công', '1990-07-16', 'Tiền Giang', '0392656931', 0),
('NV9', 'Dương Thanh Hồng', '1991-12-03', 'Vũng Tàu', '0977268398', 0);

-- --------------------------------------------------------

--
-- Table structure for table `phanquyen`
--

CREATE TABLE `phanquyen` (
  `maQuyen` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tenQuyen` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `chiTietQuyen` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- RELATIONSHIPS FOR TABLE `phanquyen`:
--

--
-- Dumping data for table `phanquyen`
--

INSERT INTO `phanquyen` (`maQuyen`, `tenQuyen`, `chiTietQuyen`) VALUES
('Q1', 'Admin', 'qlBanHang qlNhapHang qlSach qlHoaDonBan qlKhuyenMai qlNhanVien qlKhachHang qlHoaDonNhap qlNCC qlTaiKhoan qlQuyen'),
('Q2', 'Nhân viên', 'qlBanHang qlNhapHang xemSach xemKhachHang xemNCC xemKM');

-- --------------------------------------------------------

--
-- Table structure for table `sach`
--

CREATE TABLE `sach` (
  `maSach` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tenSach` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `theLoai` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tacGia` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `namXB` char(4) NOT NULL,
  `soLuong` int(10) NOT NULL DEFAULT 0,
  `giaNhap` float NOT NULL,
  `giaBan` float NOT NULL,
  `trangThai` int(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- RELATIONSHIPS FOR TABLE `sach`:
--

--
-- Dumping data for table `sach`
--

INSERT INTO `sach` (`maSach`, `tenSach`, `theLoai`, `tacGia`, `namXB`, `soLuong`, `giaNhap`, `giaBan`, `trangThai`) VALUES
('MS1', 'Đắc nhân tâm', 'Sách tự giúp', 'Dale Carnegie', '1936', 71, 119, 219, 0),
('MS10', 'The Elements of UX', 'Lập trình', 'Jesse James Garrett', '2023', 70, 299, 399, 0),
('MS11', 'The Lean Startup', 'Kinh doanh', 'Eric Ries', '2023', 70, 399, 499, 0),
('MS12', 'Lập trình Python', 'Lập trình', 'Phạm Minh Đức', '2023', 80, 199, 299, 0),
('MS13', 'Mạng máy tính', 'Lập trình', 'Nguyễn Quang Hưng', '2023', 70, 99, 199, 0),
('MS14', 'Kỹ thuật lập trình', 'Lập trình', 'Nguyễn Hữu Hiền', '2022', 55, 159, 259, 0),
('MS15', 'Lập trình game Unity', 'Lập trình', 'Nguyễn Việt Hùng', '2023', 71, 179, 279, 0),
('MS2', 'Nhà giả Kim', 'Tiểu thuyết', 'Paulo Coelho	', '1988', 60, 109, 209, 0),
('MS3', 'Lược sử thời gian', 'Khoa học', 'Stephen Hawking', '2018', 30, 299, 399, 0),
('MS4', '21 Bài học cho thế kỉ 21', 'Sách tự giúp', 'Yuval Noah Harari', '2018', 49, 199, 299, 0),
('MS5', 'Dạy con làm giàu', 'Sách tự giúp', 'Robert T Kiyosaki', '2017', 28, 199, 299, 1),
('MS6', 'Quẳng gánh lo đi và vui sống', 'Sách tự giúp', 'Dale Carnegie', '2018', 32, 119, 219, 0),
('MS7', 'Hành trình về phương đông', 'Tâm linh', 'Helena Blavatsky', '2012', 69, 299, 399, 0),
('MS8', 'Agile Y', 'Lập trình', 'Alistair Cockburn', '2023', 41, 299, 399, 0),
('MS9', 'UX Design: The Basics', 'Lập trình', 'Luke Wroblewski', '2023', 44, 299, 399, 0);

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `tenDangNhap` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `matKhau` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `maNV` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `maQuyen` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- RELATIONSHIPS FOR TABLE `taikhoan`:
--   `maNV`
--       `nhanvien` -> `maNV`
--   `maQuyen`
--       `phanquyen` -> `maQuyen`
--

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`tenDangNhap`, `matKhau`, `maNV`, `maQuyen`) VALUES
('nnthienphuc', 'nnthienphuc', 'NV1', 'Q1'),
('songnguyen', 'songnguyen', 'NV3', 'Q2'),
('thuyngan', 'thuyngan', 'NV2', 'Q2');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitiethoadonban`
--
ALTER TABLE `chitiethoadonban`
  ADD PRIMARY KEY (`maHDB`,`maSach`),
  ADD KEY `maHDB` (`maHDB`),
  ADD KEY `maSach` (`maSach`);

--
-- Indexes for table `chitiethoadonnhap`
--
ALTER TABLE `chitiethoadonnhap`
  ADD PRIMARY KEY (`maHDN`,`maSach`),
  ADD KEY `maHDN` (`maHDN`),
  ADD KEY `maSach` (`maSach`);

--
-- Indexes for table `hoadonban`
--
ALTER TABLE `hoadonban`
  ADD PRIMARY KEY (`maHDB`),
  ADD KEY `maKH` (`maKH`),
  ADD KEY `maNV` (`maNV`),
  ADD KEY `maKM` (`maKM`);

--
-- Indexes for table `hoadonnhap`
--
ALTER TABLE `hoadonnhap`
  ADD PRIMARY KEY (`maHDN`),
  ADD KEY `maNCC` (`maNCC`),
  ADD KEY `maNV` (`maNV`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`maKH`),
  ADD UNIQUE KEY `SDT` (`SDT`);

--
-- Indexes for table `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`maKM`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`maNCC`),
  ADD UNIQUE KEY `SDT` (`SDT`),
  ADD UNIQUE KEY `FAX` (`FAX`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`maNV`),
  ADD UNIQUE KEY `SDT` (`SDT`);

--
-- Indexes for table `phanquyen`
--
ALTER TABLE `phanquyen`
  ADD PRIMARY KEY (`maQuyen`);

--
-- Indexes for table `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`maSach`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`tenDangNhap`),
  ADD UNIQUE KEY `taikhoan_uk` (`maNV`),
  ADD KEY `maNV` (`maNV`),
  ADD KEY `maQuyen` (`maQuyen`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitiethoadonban`
--
ALTER TABLE `chitiethoadonban`
  ADD CONSTRAINT `chitiethoadonban_ibfk_1` FOREIGN KEY (`maHDB`) REFERENCES `hoadonban` (`maHDB`) ON UPDATE CASCADE,
  ADD CONSTRAINT `chitiethoadonban_ibfk_2` FOREIGN KEY (`maSach`) REFERENCES `sach` (`maSach`) ON UPDATE CASCADE;

--
-- Constraints for table `chitiethoadonnhap`
--
ALTER TABLE `chitiethoadonnhap`
  ADD CONSTRAINT `chitiethoadonnhap_ibfk_1` FOREIGN KEY (`maHDN`) REFERENCES `hoadonnhap` (`maHDN`) ON UPDATE CASCADE,
  ADD CONSTRAINT `chitiethoadonnhap_ibfk_2` FOREIGN KEY (`maSach`) REFERENCES `sach` (`maSach`) ON UPDATE CASCADE;

--
-- Constraints for table `hoadonban`
--
ALTER TABLE `hoadonban`
  ADD CONSTRAINT `hoadonban_ibfk_1` FOREIGN KEY (`maKH`) REFERENCES `khachhang` (`maKH`) ON UPDATE CASCADE,
  ADD CONSTRAINT `hoadonban_ibfk_2` FOREIGN KEY (`maNV`) REFERENCES `nhanvien` (`maNV`) ON UPDATE CASCADE,
  ADD CONSTRAINT `khuyenmai_ibfk_3` FOREIGN KEY (`maKM`) REFERENCES `khuyenmai` (`maKM`) ON UPDATE CASCADE;

--
-- Constraints for table `hoadonnhap`
--
ALTER TABLE `hoadonnhap`
  ADD CONSTRAINT `hoadonnhap_ibfk_1` FOREIGN KEY (`maNCC`) REFERENCES `nhacungcap` (`maNCC`) ON UPDATE CASCADE,
  ADD CONSTRAINT `hoadonnhap_ibfk_2` FOREIGN KEY (`maNV`) REFERENCES `nhanvien` (`maNV`) ON UPDATE CASCADE;

--
-- Constraints for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `taikhoan_ibfk_1` FOREIGN KEY (`maNV`) REFERENCES `nhanvien` (`maNV`) ON UPDATE CASCADE,
  ADD CONSTRAINT `taikhoan_ibfk_2` FOREIGN KEY (`maQuyen`) REFERENCES `phanquyen` (`maQuyen`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
