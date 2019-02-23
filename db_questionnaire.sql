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

 Date: 23/02/2019 18:54:44
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
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `release_time` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  `state` int(11) NULL DEFAULT NULL COMMENT '问卷状态：-1:删除 0:已完成 1:创建未提交 2:提交未评测 ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 93 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_questionnaire
-- ----------------------------
INSERT INTO `t_questionnaire` VALUES (92, '测试1', 6, NULL, '2019-02-23 16:51:25', NULL, 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 507 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_questionnaire_context
-- ----------------------------
INSERT INTO `t_questionnaire_context` VALUES (499, '1', 92, 102, 1);
INSERT INTO `t_questionnaire_context` VALUES (500, '2', 92, 102, 1);
INSERT INTO `t_questionnaire_context` VALUES (501, '3', 92, 102, 1);
INSERT INTO `t_questionnaire_context` VALUES (502, '4', 92, 102, 1);
INSERT INTO `t_questionnaire_context` VALUES (503, 'a', 92, 103, 1);
INSERT INTO `t_questionnaire_context` VALUES (504, 'b', 92, 103, 1);
INSERT INTO `t_questionnaire_context` VALUES (505, 'c', 92, 103, 1);
INSERT INTO `t_questionnaire_context` VALUES (506, 'd', 92, 103, 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 104 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_questionnaire_context_title
-- ----------------------------
INSERT INTO `t_questionnaire_context_title` VALUES (102, '测试题目1', 92, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (103, '测试题目2', 92, 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES (5, '喻湘东', 'yxd1', 'a0cf8379cd9726c90dec9c0e3b2c97cc', '2240170192@qq.com', 1);
INSERT INTO `t_teacher` VALUES (6, '喻湘东', 'q123', '4297f44b13955235245b2497399d7a93', '2240170192@qq.com', 1);

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
