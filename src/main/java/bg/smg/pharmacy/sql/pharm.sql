-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 28, 2024 at 06:41 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pharm`
--

-- --------------------------------------------------------

--
-- Table structure for table `drugs`
--

CREATE TABLE `drugs` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `prescription_required` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `standard_dosage` varchar(255) DEFAULT NULL,
  `stock_quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `drugs`
--

INSERT INTO `drugs` (`id`, `description`, `name`, `prescription_required`, `price`, `standard_dosage`, `stock_quantity`) VALUES
(1, 'Pain relief', 'Aspirin', 'no', 5.99, '1 tablet every 4 hours', 5),
(2, 'Antibiotic', 'Amoxicillin', 'no', 10.5, '1 capsule every 12 hours', 0),
(3, 'Cholesterol medication', 'Lipitor', 'yes', 15.75, '1 tablet daily', 0),
(4, 'Anxiety medication', 'Xanax', 'yes', 9.99, '1 tablet every 12 hours', 10),
(5, 'Allergy medication', 'Claritin', 'no', 7.49, '1 tablet daily', 10),
(6, 'Antibiotic', 'Augmentin', 'yes', 12.99, '1 capsule every 12 hours', 3),
(7, 'Insomnia medication', 'Circadin', 'no', 9.99, '1 tablet daily at bedtime', 8),
(8, 'Blood pressure medication', 'Losartan', 'yes', 15.99, '1 tablet daily', 6),
(9, 'Antacid', 'Tums', 'no', 3.99, '2 tablets as needed after meals', 15),
(10, 'Antidepressant', 'Sertraline', 'yes', 20.99, '1 tablet daily', 4),
(11, 'Antihistamine', 'Banophen', 'no', 6.99, '1 tablet every 6 hours as needed', 12),
(12, 'Muscle relaxant', 'Amrix', 'yes', 8.99, '1 tablet every 8 hours', 7),
(13, 'Diabetes medication', 'Glucophage', 'yes', 11.99, '1 tablet twice daily with meals', 9),
(14, 'Cholesterol medication', 'Atorvaliq', 'yes', 17.99, '1 tablet daily', 5),
(15, 'Migraine medication', 'Tylenol', 'no', 6.99, '2 tablets every 4-6 hours', 8),
(16, 'Allergy medication', 'Benadryl', 'no', 9.49, '1 tablet daily', 12),
(17, 'Acid reflux medication', 'Nexium', 'yes', 17.99, '1 capsule daily before breakfast', 6),
(18, 'Insomnia medication', 'Ambien', 'yes', 23.99, '1 tablet at bedtime', 4),
(19, 'Antidepressant', 'Prozac', 'yes', 21.99, '1 tablet daily', 7),
(20, 'Cough syrup', 'Robitussin', 'no', 8.29, '2 teaspoons every 4 hours', 10),
(21, 'Sinus relief', 'Sudafed', 'no', 10.99, '1 tablet every 4-6 hours', 9),
(22, 'Migraine medication', 'Imitrex', 'yes', 18.99, '1 tablet at onset of migraine', 5),
(23, 'Muscle pain relief', 'Advil', 'no', 7.49, '1 tablet every 4-6 hours as needed', 25),
(24, 'Constipation medication', 'Dulcolax', 'no', 6.79, '1 tablet at bedtime', 11);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `drugs`
--
ALTER TABLE `drugs`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `drugs`
--
ALTER TABLE `drugs`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
