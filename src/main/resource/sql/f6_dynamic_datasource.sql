-- 建库
CREATE DATABASE `ft_spring_01` CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_bin';
-- 建表
USE `ft_spring_01`;
DROP TABLE IF EXISTS `spring_test_table_01`;
CREATE TABLE `spring_test_table_01`  (
                                       `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_bin NOT NULL,
                                       `field01` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_bin NULL DEFAULT NULL,
                                       `field02` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_bin NULL DEFAULT NULL,
                                       PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_bin ROW_FORMAT = Dynamic;
-- 初始化数据
INSERT INTO `spring_test_table_01` VALUES ('1', '1', '1');

-- 建库
CREATE DATABASE `ft_spring_02` CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_bin';
-- 建表
USE `ft_spring_02`;
DROP TABLE IF EXISTS `spring_test_table_02`;
CREATE TABLE `spring_test_table_02`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_bin NOT NULL,
  `field01` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_bin NULL DEFAULT NULL,
  `field02` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_bin ROW_FORMAT = Dynamic;
-- 初始化数据
INSERT INTO `spring_test_table_02` VALUES ('2', '2', '2');