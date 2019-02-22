/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50642
 Source Host           : localhost:3306
 Source Schema         : db_questionnaire

 Target Server Type    : MySQL
 Target Server Version : 50642
 File Encoding         : 65001

 Date: 22/02/2019 20:35:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_questionnaire
-- ----------------------------
DROP TABLE IF EXISTS `t_questionnaire`;
CREATE TABLE `t_questionnaire`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teacher_id` int(11) NULL DEFAULT NULL COMMENT '问卷发起人',
  `submit_id` int(11) NULL DEFAULT NULL COMMENT '问卷提交人',
  `state` int(11) NULL DEFAULT NULL COMMENT '问卷状态：-1:删除 0:已完成 1:创建未提交 2:提交未评测 ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 68 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_questionnaire
-- ----------------------------
INSERT INTO `t_questionnaire` VALUES (61, '1', 5, NULL, -1);
INSERT INTO `t_questionnaire` VALUES (62, 'ad', 5, NULL, -1);
INSERT INTO `t_questionnaire` VALUES (63, '1', 5, NULL, 2);
INSERT INTO `t_questionnaire` VALUES (64, '1', 5, NULL, 2);
INSERT INTO `t_questionnaire` VALUES (65, '123', 5, NULL, 2);
INSERT INTO `t_questionnaire` VALUES (66, '1', 5, NULL, 2);
INSERT INTO `t_questionnaire` VALUES (67, '1', 5, NULL, 2);

-- ----------------------------
-- Table structure for t_questionnaire_context
-- ----------------------------
DROP TABLE IF EXISTS `t_questionnaire_context`;
CREATE TABLE `t_questionnaire_context`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `context` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `questionnaire_id` int(11) NULL DEFAULT NULL COMMENT '关联问卷id',
  `questionnaire_context_title_id` int(11) NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL COMMENT '0：已完成 1：进行中 2：已完成 3：草稿',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 403 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_questionnaire_context
-- ----------------------------
INSERT INTO `t_questionnaire_context` VALUES (371, '2', 61, 70, -1);
INSERT INTO `t_questionnaire_context` VALUES (372, '3', 61, 70, -1);
INSERT INTO `t_questionnaire_context` VALUES (373, '4', 61, 70, -1);
INSERT INTO `t_questionnaire_context` VALUES (374, '5', 61, 70, -1);
INSERT INTO `t_questionnaire_context` VALUES (375, '2', 61, 71, -1);
INSERT INTO `t_questionnaire_context` VALUES (376, '2', 61, 71, -1);
INSERT INTO `t_questionnaire_context` VALUES (377, '2', 61, 71, -1);
INSERT INTO `t_questionnaire_context` VALUES (378, '2', 61, 71, -1);
INSERT INTO `t_questionnaire_context` VALUES (379, 'asda', 62, 72, -1);
INSERT INTO `t_questionnaire_context` VALUES (380, 'asdas', 62, 72, -1);
INSERT INTO `t_questionnaire_context` VALUES (381, 'asdas', 62, 72, -1);
INSERT INTO `t_questionnaire_context` VALUES (382, 'dasda', 62, 72, -1);
INSERT INTO `t_questionnaire_context` VALUES (383, '1', 63, 73, 1);
INSERT INTO `t_questionnaire_context` VALUES (384, '1', 63, 73, 1);
INSERT INTO `t_questionnaire_context` VALUES (385, '1', 63, 73, 1);
INSERT INTO `t_questionnaire_context` VALUES (386, '1', 63, 73, 1);
INSERT INTO `t_questionnaire_context` VALUES (387, '1', 64, 74, 1);
INSERT INTO `t_questionnaire_context` VALUES (388, '1', 64, 74, 1);
INSERT INTO `t_questionnaire_context` VALUES (389, '1', 64, 74, 1);
INSERT INTO `t_questionnaire_context` VALUES (390, '1', 64, 74, 1);
INSERT INTO `t_questionnaire_context` VALUES (391, '1', 65, 75, 1);
INSERT INTO `t_questionnaire_context` VALUES (392, '1', 65, 75, 1);
INSERT INTO `t_questionnaire_context` VALUES (393, '1', 65, 75, 1);
INSERT INTO `t_questionnaire_context` VALUES (394, '1', 65, 75, 1);
INSERT INTO `t_questionnaire_context` VALUES (395, '1', 66, 76, 1);
INSERT INTO `t_questionnaire_context` VALUES (396, '1', 66, 76, 1);
INSERT INTO `t_questionnaire_context` VALUES (397, '1', 66, 76, 1);
INSERT INTO `t_questionnaire_context` VALUES (398, '1', 66, 76, 1);
INSERT INTO `t_questionnaire_context` VALUES (399, '1', 67, 77, 1);
INSERT INTO `t_questionnaire_context` VALUES (400, '1', 67, 77, 1);
INSERT INTO `t_questionnaire_context` VALUES (401, '1', 67, 77, 1);
INSERT INTO `t_questionnaire_context` VALUES (402, '1', 67, 77, 1);

-- ----------------------------
-- Table structure for t_questionnaire_context_title
-- ----------------------------
DROP TABLE IF EXISTS `t_questionnaire_context_title`;
CREATE TABLE `t_questionnaire_context_title`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `questionnaire_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `questionnaire_id` int(11) NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_questionnaire_context_title
-- ----------------------------
INSERT INTO `t_questionnaire_context_title` VALUES (70, '1', 61, -1);
INSERT INTO `t_questionnaire_context_title` VALUES (71, '2', 61, -1);
INSERT INTO `t_questionnaire_context_title` VALUES (72, '789', 62, -1);
INSERT INTO `t_questionnaire_context_title` VALUES (73, '1', 63, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (74, '1', 64, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (75, '1', 65, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (76, '1', 66, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (77, '1', 67, 1);

-- ----------------------------
-- Table structure for t_questionnaire_type
-- ----------------------------
DROP TABLE IF EXISTS `t_questionnaire_type`;
CREATE TABLE `t_questionnaire_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型名称',
  `questionnarie_id` int(11) NULL DEFAULT NULL,
  `questionnarie_contex_id` int(11) NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL COMMENT '状态 -1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `state` int(11) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES (1, '喻湘东', 'yxd520', 'yxd520', NULL, 1);

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES (5, '喻湘东', 'yxd1', 'a0cf8379cd9726c90dec9c0e3b2c97cc', '2240170192@qq.com', 1);

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES (1, 'yxd');

SET FOREIGN_KEY_CHECKS = 1;
