/*
Navicat MySQL Data Transfer

Source Server         : A_Ubuntu
Source Server Version : 50726
Source Host           : 192.168.56.101:3306
Source Database       : o2o_identity

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-07-19 19:13:07
*/

SET FOREIGN_KEY_CHECKS=0;

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
  `register_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '注册时间',
  `update_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `create_time` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '18809090909', 'wmx', 'XXX', 'xxx', '1563524190', '1563524200', '1563524190');
INSERT INTO `user` VALUES ('2', '18809010901', '', '123', '123', '1563526572958', '0', '0');
INSERT INTO `user` VALUES ('3', '18809010901', '', '123', '123', '1563526696411', '0', '0');
