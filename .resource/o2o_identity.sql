/*
 Navicat Premium Data Transfer

 Source Server         : MY_LOCAL_33306
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:33306
 Source Schema         : o2o_identity

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 11/10/2019 15:06:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `phonenumber` char(11) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '手机号码',
  `username` varchar(20) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '用户名',
  `password` char(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '密码',
  `salt` char(6) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '密码盐值',
  `register_time` datetime NOT NULL DEFAULT '1970-01-01 08:00:00' COMMENT '注册时间',
  `update_time` datetime NOT NULL DEFAULT '1970-01-01 08:00:00' COMMENT '更新时间',
  `create_time` datetime NOT NULL DEFAULT '1970-01-01 08:00:00' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, '18809090901', 'wmx01', 'pass123', 'aabbcc', '2019-07-23 00:34:01', '2019-07-08 00:34:06', '2019-07-14 00:34:12');
INSERT INTO `user` VALUES (2, '18809090902', 'wmx02', '123123', '111223', '2019-07-22 11:57:15', '2019-07-22 11:57:15', '2019-07-22 11:57:15');
INSERT INTO `user` VALUES (3, '18809090903', 'wmx03', '123123', '111223', '2019-07-22 12:04:41', '2019-07-22 12:04:41', '2019-07-22 12:04:41');
INSERT INTO `user` VALUES (4, '18809090904', 'wmx04', '123123', '111223', '2019-07-22 12:09:16', '2019-07-22 12:09:16', '2019-07-22 12:09:16');
INSERT INTO `user` VALUES (5, '18809090905', 'wmx05', '123123', '111223', '2019-07-22 12:10:16', '2019-07-22 12:10:16', '2019-07-22 12:10:16');
INSERT INTO `user` VALUES (6, '18809090906', 'wmx06', '123123', '111223', '2019-07-23 01:22:16', '2019-07-23 01:22:16', '2019-07-23 01:22:16');
INSERT INTO `user` VALUES (7, '18809090907', 'wmx07', '123123', '111223', '2019-07-23 01:30:46', '2019-07-23 01:30:46', '2019-07-23 01:30:46');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
