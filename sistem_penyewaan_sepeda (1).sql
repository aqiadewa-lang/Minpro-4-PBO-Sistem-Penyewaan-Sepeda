-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Oct 15, 2026 at 02:08 PM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sistem_penyewaan_sepeda`
--

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` varchar(10) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `no_telepon` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`id_pelanggan`, `nama`, `no_telepon`) VALUES
('P-001', 'Budi', '08123456789'),
('P-002', 'Siti Aminah', '08234567890'),
('P-003', 'Andi Pratama', '08345678901');

-- --------------------------------------------------------

--
-- Table structure for table `sepeda`
--

CREATE TABLE `sepeda` (
  `id_sepeda` varchar(10) NOT NULL,
  `merk` varchar(50) NOT NULL,
  `harga_sewa_per_hari` double NOT NULL,
  `jenis` varchar(10) NOT NULL,
  `jumlah_gear` int DEFAULT NULL,
  `suspensi` varchar(30) DEFAULT NULL,
  `kapasitas_baterai` int DEFAULT NULL
) ;

--
-- Dumping data for table `sepeda`
--

INSERT INTO `sepeda` (`id_sepeda`, `merk`, `harga_sewa_per_hari`, `jenis`, `jumlah_gear`, `suspensi`, `kapasitas_baterai`) VALUES
('SPD-01', 'Polygon Xtrada', 75000, 'GUNUNG', 21, 'Hardtail', NULL),
('SPD-02', 'Selis Eagle', 100000, 'LISTRIK', NULL, NULL, 10000),
('SPD-03', 'United Detroit', 85000, 'GUNUNG', 24, 'Full Suspension', NULL),
('SPD-04', 'Exotic E-Bike', 120000, 'LISTRIK', NULL, NULL, 12000);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_sewa`
--

CREATE TABLE `transaksi_sewa` (
  `id_transaksi` varchar(10) NOT NULL,
  `id_pelanggan` varchar(10) NOT NULL,
  `id_sepeda` varchar(10) NOT NULL,
  `lama_sewa_hari` int NOT NULL,
  `diskon` double NOT NULL DEFAULT '0',
  `total_biaya` double NOT NULL,
  `tanggal_sewa` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `transaksi_sewa`
--

INSERT INTO `transaksi_sewa` (`id_transaksi`, `id_pelanggan`, `id_sepeda`, `lama_sewa_hari`, `diskon`, `total_biaya`, `tanggal_sewa`) VALUES
('T-001', 'P-001', 'SPD-01', 3, 0, 225000, '2026-10-10'),
('T-002', 'P-002', 'SPD-02', 2, 0, 210000, '2026-10-11'),
('TRX-3', 'P-001', 'SPD-01', 5, 0, 375000, '2026-10-15');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indexes for table `sepeda`
--
ALTER TABLE `sepeda`
  ADD PRIMARY KEY (`id_sepeda`);

--
-- Indexes for table `transaksi_sewa`
--
ALTER TABLE `transaksi_sewa`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `fk_transaksi_pelanggan` (`id_pelanggan`),
  ADD KEY `fk_transaksi_sepeda` (`id_sepeda`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `transaksi_sewa`
--
ALTER TABLE `transaksi_sewa`
  ADD CONSTRAINT `fk_transaksi_pelanggan` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id_pelanggan`) ON DELETE RESTRICT ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_transaksi_sepeda` FOREIGN KEY (`id_sepeda`) REFERENCES `sepeda` (`id_sepeda`) ON DELETE RESTRICT ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
