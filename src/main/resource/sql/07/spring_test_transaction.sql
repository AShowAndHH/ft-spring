/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : ft_spring

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 26/10/2022 12:29:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for spring_test_transaction
-- ----------------------------
DROP TABLE IF EXISTS `spring_test_transaction`;
CREATE TABLE `spring_test_transaction`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_bin NOT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_bin NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_bin ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
