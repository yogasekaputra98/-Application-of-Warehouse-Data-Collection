-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 31, 2019 at 05:18 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `apg`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang_gudang`
--

CREATE TABLE `barang_gudang` (
  `id_barangG` varchar(10) NOT NULL,
  `nama_barang` varchar(15) DEFAULT NULL,
  `harga_barang` int(10) DEFAULT NULL,
  `stock` int(5) DEFAULT NULL,
  `tanggal_pasok` date DEFAULT NULL,
  `id_kategori` varchar(5) DEFAULT NULL,
  `id_supplier` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang_gudang`
--

INSERT INTO `barang_gudang` (`id_barangG`, `nama_barang`, `harga_barang`, `stock`, `tanggal_pasok`, `id_kategori`, `id_supplier`) VALUES
('BG001', 'Mie Instan', 3000, 45, '2019-01-01', 'K001', 'S002'),
('BG002', 'Teh Box', 3500, 50, '2019-01-01', 'K002', 'S001'),
('BG003', 'Apel Fuji 1ons', 3000, 20, '2019-01-18', 'K003', 'S001'),
('BG004', 'Sayur Kol 1kg', 8000, 10, '2019-01-18', 'K004', 'S001'),
('BG005', 'Garam 1ons', 3000, 40, '2019-01-08', 'K005', 'S002'),
('BG006', 'Terminal', 18000, 10, '2019-01-01', 'K006', 'S003'),
('BG007', 'Gula Pasir 1kg', 12000, 20, '2019-01-07', 'K007', 'S004'),
('BG008', 'Sabun Mandi', 2000, 100, '2019-01-18', 'K008', 'S004'),
('BG009', 'Pensil 2B', 3500, 100, '2019-01-18', 'K009', 'S002'),
('BG010', 'Sabun Cuci', 2000, 70, '2019-01-10', 'K010', 'S005'),
('BG011', 'Obat Demam', 2500, 60, '2019-01-11', 'K011', 'S003'),
('BG012', 'Popok Bayi XL', 50000, 20, '2019-01-18', 'K012', 'S005'),
('BG013', 'Majalah Anak', 5000, 10, '2019-01-18', 'K013', 'S005'),
('BG014', 'Topi', 20000, 30, '2019-01-09', 'K014', 'S003'),
('BG015', 'Rokok 12btg', 12000, 30, '2019-11-01', 'K015', 'S004');

-- --------------------------------------------------------

--
-- Table structure for table `barang_store`
--

CREATE TABLE `barang_store` (
  `id_barangS` varchar(10) NOT NULL,
  `nama_barang` varchar(20) DEFAULT NULL,
  `harga_barang` int(11) DEFAULT NULL,
  `tanggal_pasok` datetime DEFAULT NULL,
  `stok` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang_store`
--

INSERT INTO `barang_store` (`id_barangS`, `nama_barang`, `harga_barang`, `tanggal_pasok`, `stok`) VALUES
('BG001', 'Mie Instan', 3000, '2019-01-01 00:00:00', 25),
('BG002', 'Teh Box', 3500, '2019-01-01 00:00:00', 20),
('BG003', 'Apel Fuji 1ons', 3000, '2019-01-18 00:00:00', 10),
('BG004', 'Sayur Kol 1kg', 8000, '2019-01-18 00:00:00', 4),
('BG005', 'Garam 1ons', 3000, '2019-01-08 00:00:00', 20),
('BG006', 'Terminal', 18000, '2019-01-01 00:00:00', 4),
('BG007', 'Gula Pasir 1kg', 12000, '2019-01-07 00:00:00', 7),
('BG008', 'Sabun Mandi', 2000, '2019-01-18 00:00:00', 30),
('BG009', 'Pensil 2B', 3500, '2019-01-18 00:00:00', 40),
('BG010', 'Sabun Cuci', 2000, '2019-01-10 00:00:00', 20),
('BG011', 'Obat Demam', 2500, '2019-01-11 00:00:00', 25),
('BG012', 'Popok Bayi XL', 50000, '2019-01-18 00:00:00', 10),
('BG013', 'Majalah Anak', 5000, '2019-01-18 00:00:00', 5),
('BG014', 'Topi', 20000, '2019-01-09 00:00:00', 15),
('BG015', 'Rokok 12btg', 12000, '2019-11-01 00:00:00', 20);

-- --------------------------------------------------------

--
-- Table structure for table `job`
--

CREATE TABLE `job` (
  `id_job` varchar(10) NOT NULL,
  `nama_job` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `job`
--

INSERT INTO `job` (`id_job`, `nama_job`) VALUES
('J001', 'Manajer'),
('J002', 'Gudang'),
('J003', 'Minimarket'),
('J004', 'Logistik'),
('J005', 'Direktur'),
('J006', 'Office Boy');

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `id_kategori` varchar(5) NOT NULL,
  `nama_kategori` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`id_kategori`, `nama_kategori`) VALUES
('K001', 'Makanan'),
('K002', 'Minuman'),
('K003', 'Buah-buahan'),
('K004', 'Sayuran'),
('K005', 'Bumbu dapur'),
('K006', 'Alat elektronik'),
('K007', 'Sembako'),
('K008', 'Peralatan mandi'),
('K009', 'Alat tulis'),
('K010', 'Peralatan cuci'),
('K011', 'Obat-obatan'),
('K012', 'Peralatan bayi'),
('K013', 'Bacaan'),
('K014', 'Pakaian'),
('K015', 'Lainnya');

-- --------------------------------------------------------

--
-- Table structure for table `permintaan`
--

CREATE TABLE `permintaan` (
  `id_permintaan` varchar(20) NOT NULL,
  `id_barang` varchar(20) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `id_user` varchar(20) DEFAULT NULL,
  `tanggal_permintaan` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `permintaan`
--

INSERT INTO `permintaan` (`id_permintaan`, `id_barang`, `jumlah`, `id_user`, `tanggal_permintaan`) VALUES
('P001', 'BG003', 10, 'U0003', '2019-01-24 00:00:00'),
('P002', 'BG008', 20, 'U0003', '2019-01-23 00:00:00'),
('P003', 'BG011', 30, 'U0003', '2019-01-24 00:00:00'),
('P004', 'BG009', 15, 'U0003', '2019-01-23 00:00:00'),
('P005', 'BG014', 10, 'U0003', '2019-01-24 00:00:00'),
('P006', 'BG002', 30, 'U0003', '2019-01-23 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `id_supplier` varchar(10) NOT NULL,
  `nama_supplier` varchar(20) DEFAULT NULL,
  `alamat` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`id_supplier`, `nama_supplier`, `alamat`) VALUES
('S001', 'PT. Mundur Jaya', 'Sukabirus'),
('S002', 'CV. Tronjal Tronjol', 'Sukapura'),
('S003', 'PT. Bubat Kerja', 'Buah Batu'),
('S004', 'PT. BE Adil Makmur', 'Baleendah'),
('S005', 'PT. Dago Bermartabat', 'Dago');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` varchar(20) NOT NULL,
  `nama` varchar(30) DEFAULT NULL,
  `alamat` varchar(50) DEFAULT NULL,
  `username` varchar(16) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  `id_job` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `nama`, `alamat`, `username`, `password`, `id_job`) VALUES
('U0001', 'Fadhillah', 'Baleendah', 'ramaanhar', 'alpukat', 'J002'),
('U0002', 'Yogas', 'Garut', 'yogasdark', 'belimbing', 'J001'),
('U0003', 'Vita', 'Ciparay', 'vitajuliani', 'cempedak', 'J003'),
('U0004', 'Avelisa', 'Medan', 'avelisa', 'durian', 'J004'),
('U0005', 'Nurhadi', 'Kudus', 'nurhadi', 'egoji', 'J005'),
('U0006', 'Fulan', 'Wakanda', 'fulan', 'fulan', 'J006');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang_gudang`
--
ALTER TABLE `barang_gudang`
  ADD PRIMARY KEY (`id_barangG`),
  ADD KEY `id_supplier` (`id_supplier`),
  ADD KEY `id_kategori` (`id_kategori`);

--
-- Indexes for table `barang_store`
--
ALTER TABLE `barang_store`
  ADD PRIMARY KEY (`id_barangS`);

--
-- Indexes for table `job`
--
ALTER TABLE `job`
  ADD PRIMARY KEY (`id_job`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id_kategori`);

--
-- Indexes for table `permintaan`
--
ALTER TABLE `permintaan`
  ADD PRIMARY KEY (`id_permintaan`),
  ADD KEY `id_barang` (`id_barang`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id_supplier`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `id_job` (`id_job`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `barang_gudang`
--
ALTER TABLE `barang_gudang`
  ADD CONSTRAINT `barang_gudang_ibfk_1` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`id_supplier`),
  ADD CONSTRAINT `barang_gudang_ibfk_2` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id_kategori`);

--
-- Constraints for table `permintaan`
--
ALTER TABLE `permintaan`
  ADD CONSTRAINT `permintaan_ibfk_1` FOREIGN KEY (`id_barang`) REFERENCES `barang_gudang` (`id_barangG`),
  ADD CONSTRAINT `permintaan_ibfk_2` FOREIGN KEY (`id_barang`) REFERENCES `barang_gudang` (`id_barangG`),
  ADD CONSTRAINT `permintaan_ibfk_3` FOREIGN KEY (`id_barang`) REFERENCES `barang_gudang` (`id_barangG`),
  ADD CONSTRAINT `permintaan_ibfk_4` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id_job`) REFERENCES `job` (`id_job`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
