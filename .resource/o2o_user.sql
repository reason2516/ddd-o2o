/*
 Navicat Premium Data Transfer

 Source Server         : LOCAL_docker
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:33306
 Source Schema         : o2o_user

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 11/11/2019 19:48:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` char(40) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '用户id',
  `phone_number` char(11) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '手机号',
  `password` char(40) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '密码',
  `salt` char(6) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '密码盐',
  `username` varchar(40) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '用户名',
  `email` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '邮箱',
  `status` int(3) NOT NULL DEFAULT '0' COMMENT '状态 0默认值 1正常 11注销',
  `register_time` datetime(3) NOT NULL DEFAULT '1970-01-01 08:00:00.000' COMMENT '注册时间',
  `last_login_time` datetime(3) NOT NULL DEFAULT '1970-01-01 08:00:00.000' COMMENT '最后一次登录时间',
  `create_time` datetime(3) NOT NULL DEFAULT '1970-01-01 08:00:00.000' COMMENT '创建时间',
  `update_time` datetime(3) NOT NULL DEFAULT '1970-01-01 08:00:00.000' COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uidx_phone_number` (`phone_number`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('UID157244023345452813', '18810498066', '123456', '', '', '', 0, '2019-10-30 20:57:13.454', '1970-01-01 08:00:00.000', '2019-10-30 20:57:13.459', '2019-10-30 20:57:13.459');
INSERT INTO `user` VALUES ('UID157244035101669289', '18810499090', '123411', '', '', '', 0, '2019-10-30 20:59:11.016', '1970-01-01 08:00:00.000', '2019-10-30 20:59:11.241', '2019-10-30 20:59:11.241');
INSERT INTO `user` VALUES ('UID157258146302738769', '18810499091', '111111', '', '', '', 1, '2019-11-01 12:11:03.027', '1970-01-01 08:00:00.000', '1970-01-01 08:00:00.000', '1970-01-01 08:00:00.000');
INSERT INTO `user` VALUES ('UID157258155177013442', '18801010101', '111111', '', '', '', 1, '2019-11-01 12:12:31.770', '1970-01-01 08:00:00.000', '1970-01-01 08:00:00.000', '1970-01-01 08:00:00.000');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
