SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

create database bookstoremanagement;
-- connect to database bookstoremanagement--
use bookstoremanagement;

-- create tables --
CREATE TABLE Sach (
maSach nvarchar(10) NOT NULL,
tenSach nvarchar(100) NOT NULL,
theLoai nvarchar(50) NOT NULL,
tacGia nvarchar(100) NOT NULL,
namXB char(6) NOT NULL,
soLuong int(10) NOT NULL DEFAULT 0,
giaNhap float NOT NULL,
giaBan float NOT NULL,
trangThai bit NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

create table  NhanVien (
maNV nvarchar(10) NOT NULL,
tenNV nvarchar(100) NOT NULL,
ngaySinh date NOT NULL,
diaChi nvarchar(50) NOT NULL,
SDT nvarchar(15) NOT NULL UNIQUE,
trangThai bit NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

create table KhachHang (
maKH nvarchar(10) NOT NULL,
tenKH nvarchar(100) NOT NULL,
diaChi nvarchar(50) NOT NULL,
SDT nvarchar(15) NOT NULL UNIQUE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

create table NhaCungCap (
maNCC nvarchar(10) NOT NULL,
tenNCC nvarchar(100) NOT NULL,
diaChi nvarchar(50) NOT NULL,
SDT nvarchar(15) NOT NULL UNIQUE,
FAX nvarchar(30) NOT NULL UNIQUE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

create table KhuyenMai (
maKM nvarchar(10) NOT NULL,
tenKM nvarchar(100) NOT NULL,
dieuKienKM float NOT NULL,
phanTramKM float NOT NULL,
ngayBD date NOT NULL,
ngayKT date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

create table HoaDonBan (
maHDB nvarchar(10) NOT NULL,
maKH nvarchar(10) NOT NULL,
maNV nvarchar(10) NOT NULL,
maKM nvarchar(10) NOT NULL,
ngayLap date NOT NULL,
gioLap time NOT NULL,
tongTien float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

create table HoaDonNhap (
maHDN nvarchar(10) NOT NULL,
maNCC nvarchar(10) NOT NULL,
maNV nvarchar(10) NOT NULL,
ngayLap date NOT NULL,
gioLap time NOT NULL,
tongTien float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

create table ChiTietHoaDonBan (
maHDB nvarchar(10) NOT NULL,
maSach nvarchar(10) NOT NULL,
soLuong int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

create table ChiTietHoaDonNhap (
maHDN nvarchar(10) NOT NULL,
maSach nvarchar(10) NOT NULL,
soLuong int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

create table PhanQuyen (
maQuyen nvarchar(10) NOT NULL,
tenQuyen nvarchar(100) NOT NULL,
chiTietQuyen varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

create table TaiKhoan (
tenDangNhap nvarchar(50) NOT NULL,
matKhau nvarchar(50) NOT NULL,
maNV nvarchar(10) NOT NULL,
maQuyen nvarchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- add keys --
alter table Sach 
	add primary key (maSach);
    
alter table NhanVien
	add primary key (maNV);
    
alter table KhachHang 
	add primary key (maKH);
    
alter table NhaCungCap
	add primary key (maNCC);
    
alter table KhuyenMai
	add primary key (maKM);
    
alter table HoaDonBan
	add primary key (maHDB),
    add key (maKH),
    add key (maNV),
    add key (maKM);
    
alter table HoaDonNhap
	add primary key (maHDN),
    add key (maNCC),
    add key (maNV);

alter table ChiTietHoaDonBan
	add key (maHDB),
    add key (maSach),
	add primary key (maHDB, maSach);
    
alter table ChiTietHoaDonNhap
	add key (maHDN),
    add key (maSach),
	add primary key (maHDN, maSach);
    
alter table PhanQuyen
	add primary key (maQuyen);
    
alter table TaiKhoan
	add primary key (tenDangNhap),
    add key (maNV),
    add key (maQuyen);

alter table HoaDonBan
	add constraint hoadonban_ibfk_1 foreign key (maKH) references KhachHang (maKH) on update cascade,
    add constraint hoadonban_ibfk_2 foreign key (maNV) references NhanVien (maNV) on update cascade,
    add constraint hoadonban_ibfk_3 foreign key (maKM) references KhuyenMai (maKM) on update cascade;

alter table HoaDonNhap
	add constraint hoadonnhap_ibfk_1 foreign key (maNCC) references NhaCungCap (maNCC) on update cascade,
	add constraint hoadonnhap_ibfk_2 foreign key (maNV) references NhanVien (maNV) on update cascade;
    
alter table ChiTietHoaDonBan
	add constraint chitiethoadonban_ibfk_1 foreign key (maHDB) references HoaDonBan (maHDB) on update cascade,
    add constraint chitiethoadonban_ibfk_2 foreign key (maSach) references Sach (maSach) on update cascade;

alter table ChiTietHoaDonNhap
	add constraint chitiethoadonnhap_ibfk_1 foreign key (maHDN) references HoaDonNhap (maHDN) on update cascade,
    add constraint chitiethoadonnhap_ibfk_2 foreign key (maSach) references Sach (maSach) on update cascade;
    
alter table TaiKhoan
	add constraint taikhoan_ibfk_1 foreign key (maNV) references NhanVien (maNV) on update cascade,
    add constraint taikhoan_ibfk_2 foreign key (maQuyen) references PhanQuyen (maQuyen) on update cascade;
    
-- add values -- 
insert into Sach (maSach, tenSach, theLoai, tacGia, namXB, soLuong, giaNhap, giaBan, trangThai) values
	("MS1", "Đắc nhân tâm", "Sách tự giúp", "Dale Carnegie", "1936", 30, 119, 219, 0),
	("MS2", "Nhà giả Kim", "Tiểu thuyết", "Paulo Coelho	", "1988", 45, 109, 209, 0),
	("MS3", "Lược sử thời gian", "Khoa học", "Stephen Hawking", "2018", 30, 299, 399, 0),
	("MS4", "21 Bài học cho thế kỉ 21", "Sách tự giúp", "Yuval Noah Harari", "2018", 30, 199, 299, 0),
	("MS5", "Dạy con làm giảu", "Sách tự giúp", "Robert T. Kiyosaki", "2017", 20, 199, 299, 0),
	("MS6", "Quẳng gánh lo đi và vui sống", "Sách tự giúp", "Dale Carnegie", "2018", 22, 119, 219, 0),
	("MS7", "Hành trình về phương đông", "Tâm linh", "Helena Blavatsky", "2012", 19, 299, 399, 0),
	("MS8", "Agile Y", "Lập trình", "Alistair Cockburn", "2023", 31, 299, 399, 0),
	("MS9", "UX Design: The Basics", "Lập trình", "Luke Wroblewski", "2023", 34, 299, 399, 0),
	("MS10", "The Elements of User Experience: User-Centered Design for the Web and Beyond", "Lập trình", "Jesse James Garrett", "2023", 43, 299, 399, 0),
	("MS11", "The Lean Startup", "Kinh doanh", "Eric Ries", "2023", 49, 399, 499, 0),
	("MS12", "Lập trình Python", "Lập trình", "Phạm Minh Đức", "2023", 54, 199, 299, 0),
	("MS13", "Mạng máy tính", "Lập trình", "Nguyễn Quang Hưng", "2023", 50, 99, 199, 0),
	("MS14", "Kỹ thuật lập trình", "Lập trình", "Nguyễn Hữu Hiền", "2022", 47, 159, 259, 0),
	("MS15", "Lập trình game Unity", "Lập trình", "Nguyễn Việt Hùng", "2023", 50, 179, 279, 0);

insert into NhanVien (maNV, tenNV, ngaySinh, diaChi, SDT, trangThai) values
	('NV1', 'Nguyễn Ngọc Thiên Phúc', '2003-08-16', 'Đồng Nai', '0397357001', 0),
	('NV2', 'Trần Thị Thùy Ngân', '2003-04-05', 'TP HCM', '0123456489', 0),
	('NV3', 'Trần Song Nguyên', '2003-04-05', 'Hà Nội', '0128456786', 0),
	('NV4', 'Trần Văn Hoàng', '1999-11-12', 'TP HCM', '01207764668', 0),
	('NV5', 'Lê Thanh Tú', '1991-04-11', 'Hải Phòng', '0367756753', 0),
	('NV6', 'Nguyễn Hải Âu', '1992-04-24', 'Huế', '0364198226', 0),
	('NV7', 'Hoàng Thanh Hùng', '1989-11-13', 'Long An', '0276886265', 0),
	('NV8', 'Trịnh Văn Công', '1990-07-16', 'Tiền Giang', '0392656931', 0),
	('NV9', 'Dương Thanh Hồng', '1991-12-03', 'Vũng Tàu', '0977268398', 0);

insert into KhachHang (maKH, tenKH, diaChi, SDT) values
	("KH1", 'Nguyễn Ngọc Thiên Phúc', 'TP HCM', '0123456789'),
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

insert into NhaCungCap (maNCC, tenNCC, diaChi, SDT, FAX) values
	('NCC1', 'Nhà sách Phương Nam', 'TP HCM', '0123456789', '4598-8789-8789-7897'),
	('NCC2', 'Nhà xuất bản Khoa học và Kỹ thuật', 'Hà Nội', '0120728815', '3672-1782-3923-6091'),
	('NCC3', 'Nhà sách Cá Chép', 'TP HCM', '0703192738', '2364-2974-2384-2394'),
	('NCC4', 'Nhà sách Kim Đồng', 'TP HCM', '0501239237', '9823-6738-6739-6766'),
	('NCC5', 'Thế Giới Công Nghệ Độc Lạ', 'Bình Dương', '0801729329', '1830-7288-8900-7712');

insert into KhuyenMai (maKM, tenKM, dieuKienKM, phanTramKM, ngayBD, ngayKT) values
	("KM1", "Không Khuyến Mãi", 0, 0, "2023-01-01", "2024-10-25"),
	("KM2", "Khuyễn Mãi Nhập Học", 500, 30, "2024-08-01", "2024-08-25"),
	("KM3", "Khuyến Mãi Valentine", 400, 14, "2024-02-13", "2024-02-15"),
	("KM4", "Khuyến Mãi Đầu Năm", 700, 50, "2024-01-01", "2024-01-30"),
	("KM5", "Khuyến Mãi Cuối Năm", 450, 20, "2024-11-01", "2024-12-30");

insert into PhanQuyen (maQuyen, tenQuyen, chiTietQuyen) values
	('Q2', 'Nhân viên', 'qlBanHang qlNhapHang xemSach xemKhachHang xemNCC xemKM'),
	('Q1', 'Admin', 'qlBanHang qlNhapHang qlSach qlHoaDonBan qlKhuyenMai qlNhanVien qlKhachHang qlHoaDonNhap qlNCC qlTaiKhoan qlQuyen');

insert into TaiKhoan (tenDangNhap, matKhau, maNV, maQuyen) values
	("nnthienphuc", "nnthienphuc", "NV1", "Q1"),
    ("thuyngan", "thuyngan", "NV2", "Q2"),
    ("songnguyen", "songnguyen", "NV3", "Q2");

insert into HoaDonBan (maHDB, maKH, maNV, maKM, ngayLap, gioLap, tongTien) Values
	("HDB1", "KH1", "NV1", "KM1", "2023-10-18", "22:45:52", 399),
	("HDB2", "KH3", "NV3", "KM1", "2023-10-16", "12:22:52", 299),
	("HDB3", "KH3", "NV2", "KM1", "2023-09-15", "02:22:52", 299),
	("HDB4", "KH4", "NV2", "KM1", "2023-09-02", "02:22:52", 499);

insert into ChiTietHoaDonBan (maHDB, maSach, soLuong) values
	("HDB1", "MS3", 1),
	("HDB2", "MS5", 1),
	("HDB3", "MS5", 1),
	("HDB4", "MS11", 1);

insert into HoaDonNhap (maHDN, maNCC, maNV, ngayLap, gioLap, tongTien) Values
	("HDN1", "NCC1", "NV2", "2023-10-14", "22:45:52", 299),
	("HDN2", "NCC3", "NV3", "2023-10-16", "12:22:52", 199),
	("HDN3", "NCC2", "NV1", "2023-09-12", "02:22:52", 199),
	("HDN4", "NCC1", "NV2", "2023-09-11", "02:22:52", 399);

insert into ChiTietHoaDonNhap (maHDN, maSach, soLuong) values
	("HDN1", "MS3", 1),
	("HDN2", "MS5", 1),
	("HDN3", "MS5", 1),
	("HDN4", "MS11", 1);