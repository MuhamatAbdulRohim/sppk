-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 03, 2017 at 07:15 AM
-- Server version: 10.1.28-MariaDB-1~xenial
-- PHP Version: 7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `spk_kesesuaian_lahan`
--

-- --------------------------------------------------------

--
-- Table structure for table `alternative`
--

CREATE TABLE `alternative` (
  `id_alternative` varchar(10) NOT NULL,
  `nama_alternative` varchar(20) NOT NULL,
  `alamat_alternative` varchar(50) NOT NULL,
  `nilai` double NOT NULL DEFAULT '0',
  `tgl_masuk` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status_delete` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `alternative`
--

INSERT INTO `alternative` (`id_alternative`, `nama_alternative`, `alamat_alternative`, `nilai`, `tgl_masuk`, `status_delete`) VALUES
('ALT1', 'Alternative-1', 'Rembangan', 73.5, '2017-05-23 22:49:32', 0),
('ALT2', 'Alternative-2', 'Rembangan', 66.75, '2017-05-23 22:56:08', 0),
('ALT3', 'Alternative-3', 'Kab. Lumajang', 81.33333333333333, '2017-05-24 05:24:57', 0),
('ALT4', 'Alternative-4', 'Kab. Jember', 75.25, '2017-05-25 07:18:31', 0),
('ALT5', 'Alternative-5', 'Kab. Lumajang', 67.41666666666666, '2017-05-25 07:18:48', 0);

-- --------------------------------------------------------

--
-- Table structure for table `data_lahan`
--

CREATE TABLE `data_lahan` (
  `id_lahan` int(11) NOT NULL,
  `id_alternative` varchar(10) NOT NULL,
  `curah_hujan` int(11) NOT NULL,
  `lama_bulan_kering` int(11) NOT NULL,
  `lereng` int(11) NOT NULL,
  `kedalaman_efektif` int(11) NOT NULL,
  `tekstur` int(11) NOT NULL,
  `prosentase_batu` int(11) NOT NULL,
  `genangan` int(11) NOT NULL,
  `ph` int(11) NOT NULL,
  `nitrogen` int(11) NOT NULL,
  `phospor` int(11) NOT NULL,
  `kalium` int(11) NOT NULL,
  `salinitas` int(11) NOT NULL,
  `kejenuhan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_lahan`
--

INSERT INTO `data_lahan` (`id_lahan`, `id_alternative`, `curah_hujan`, `lama_bulan_kering`, `lereng`, `kedalaman_efektif`, `tekstur`, `prosentase_batu`, `genangan`, `ph`, `nitrogen`, `phospor`, `kalium`, `salinitas`, `kejenuhan`) VALUES
(7, 'ALT1', 4, 3, 3, 3, 3, 2, 3, 3, 1, 4, 1, 4, 4),
(8, 'ALT2', 4, 4, 4, 1, 4, 1, 3, 1, 2, 3, 2, 3, 3),
(9, 'ALT3', 3, 3, 2, 2, 4, 1, 2, 2, 3, 3, 3, 2, 2),
(10, 'ALT4', 2, 2, 2, 2, 2, 4, 2, 3, 3, 4, 2, 2, 1),
(11, 'ALT5', 2, 2, 3, 3, 2, 3, 4, 1, 4, 1, 4, 3, 4);

-- --------------------------------------------------------

--
-- Table structure for table `kriteria`
--

CREATE TABLE `kriteria` (
  `id_kriteria` varchar(10) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `tgl_masuk` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status_delete` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kriteria`
--

INSERT INTO `kriteria` (`id_kriteria`, `nama`, `tgl_masuk`, `status_delete`) VALUES
('KRT1', 'Iklim', '2017-05-25 01:30:25', 0),
('KRT2', 'Lereng', '2017-05-25 01:31:40', 0),
('KRT3', 'Sifat Fisik Tanah', '2017-05-25 01:31:40', 0),
('KRT4', 'Genangan', '2017-05-25 01:32:25', 0),
('KRT5', 'Sifat Kimia Tanah', '2017-05-25 01:32:25', 0),
('KRT6', 'Toksitas', '2017-05-25 01:32:45', 0);

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `id_pegawai` varchar(20) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `tempat_lahir` varchar(15) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `tgl_masuk` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status_delete` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`id_pegawai`, `nama`, `alamat`, `tempat_lahir`, `tgl_lahir`, `tgl_masuk`, `status_delete`) VALUES
('ADM1', 'Muhamat Abdul Rohim', 'Kab. Lumajang', 'Lumajang', '1995-02-08', '2017-05-07 03:23:16', 0),
('ADM2', 'Alam Ardianto', 'Kab. Jember', 'Lumajang', '1995-05-28', '2017-05-09 05:36:01', 0),
('PEG3', 'Thoip', 'Kab. Situbondo', 'Situbondo', '1995-06-07', '2017-05-09 06:21:37', 0),
('PEG4', 'Moh. Thoip', 'Kab. Situbondo', 'Situbondo', '2017-05-01', '2017-05-11 02:37:28', 1),
('PEG5', 'Yuda Pratama', 'Kab. Lumajang', 'Lumajang', '1995-06-11', '2017-06-11 09:27:41', 0),
('PEG6', 'Rifqiy', 'Panti', 'Jember', '1995-06-13', '2017-06-13 02:14:20', 0);

--
-- Triggers `pegawai`
--
DELIMITER $$
CREATE TRIGGER `addUser` AFTER INSERT ON `pegawai` FOR EACH ROW INSERT into user VALUES(new.id_pegawai,'1234',new.id_pegawai,'Pegawai','Offline')
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `subkriteria`
--

CREATE TABLE `subkriteria` (
  `id_subkriteria` varchar(10) NOT NULL,
  `id_kriteria` varchar(10) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `kategori` enum('Cost','Benefit') NOT NULL DEFAULT 'Cost',
  `bobot` double NOT NULL,
  `tgl_masuk` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status_delete` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subkriteria`
--

INSERT INTO `subkriteria` (`id_subkriteria`, `id_kriteria`, `nama`, `kategori`, `bobot`, `tgl_masuk`, `status_delete`) VALUES
('SUB1', 'KRT1', 'curah_hujan', 'Benefit', 15, '2017-05-25 01:33:34', 0),
('SUB10', 'KRT5', 'phospor', 'Benefit', 3, '2017-05-25 01:40:46', 0),
('SUB11', 'KRT5', 'kalium', 'Benefit', 3, '2017-05-25 01:40:46', 0),
('SUB12', 'KRT6', 'salinitas', 'Cost', 2, '2017-05-25 01:41:36', 0),
('SUB13', 'KRT6', 'kejenuhan', 'Cost', 2, '2017-05-25 01:41:36', 0),
('SUB2', 'KRT1', 'lama_bulan_kering', 'Cost', 20, '2017-05-25 01:34:05', 0),
('SUB3', 'KRT2', 'lereng', 'Cost', 7, '2017-05-25 01:34:28', 0),
('SUB4', 'KRT3', 'kedalaman_efektif', 'Benefit', 12, '2017-05-25 01:35:55', 0),
('SUB5', 'KRT3', 'tekstur', 'Benefit', 10, '2017-05-25 01:35:55', 0),
('SUB6', 'KRT3', 'prosentase_batu', 'Cost', 8, '2017-05-25 01:37:19', 0),
('SUB7', 'KRT4', 'genangan', 'Cost', 12, '2017-05-25 01:37:19', 0),
('SUB8', 'KRT5', 'ph', 'Benefit', 3, '2017-05-25 01:40:13', 0),
('SUB9', 'KRT5', 'nitrogen', 'Benefit', 3, '2017-05-25 01:40:13', 0);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `id_pegawai` varchar(20) NOT NULL,
  `level` enum('admin','pegawai') NOT NULL DEFAULT 'pegawai',
  `status` enum('online','offline') NOT NULL DEFAULT 'offline'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `id_pegawai`, `level`, `status`) VALUES
('admin', 'admin', 'ADM1', 'admin', 'offline'),
('PEG4', '1234', 'PEG4', 'pegawai', 'offline'),
('PEG5', '1234', 'PEG5', 'pegawai', 'offline'),
('PEG6', '1234', 'PEG6', 'pegawai', 'offline'),
('pegawai', 'pegawai', 'PEG3', 'pegawai', 'offline');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alternative`
--
ALTER TABLE `alternative`
  ADD PRIMARY KEY (`id_alternative`);

--
-- Indexes for table `data_lahan`
--
ALTER TABLE `data_lahan`
  ADD PRIMARY KEY (`id_lahan`),
  ADD KEY `id_alternative` (`id_alternative`);

--
-- Indexes for table `kriteria`
--
ALTER TABLE `kriteria`
  ADD PRIMARY KEY (`id_kriteria`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`id_pegawai`);

--
-- Indexes for table `subkriteria`
--
ALTER TABLE `subkriteria`
  ADD PRIMARY KEY (`id_subkriteria`),
  ADD KEY `id_kriteria` (`id_kriteria`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`),
  ADD UNIQUE KEY `id_pegawai` (`id_pegawai`) USING BTREE;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `data_lahan`
--
ALTER TABLE `data_lahan`
  MODIFY `id_lahan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `data_lahan`
--
ALTER TABLE `data_lahan`
  ADD CONSTRAINT `data_lahan_ibfk_1` FOREIGN KEY (`id_alternative`) REFERENCES `alternative` (`id_alternative`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `subkriteria`
--
ALTER TABLE `subkriteria`
  ADD CONSTRAINT `subkriteria_ibfk_1` FOREIGN KEY (`id_kriteria`) REFERENCES `kriteria` (`id_kriteria`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id_pegawai`) REFERENCES `pegawai` (`id_pegawai`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
