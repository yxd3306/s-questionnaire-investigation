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

 Date: 21/02/2019 20:32:13
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
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_questionnaire
-- ----------------------------
INSERT INTO `t_questionnaire` VALUES (30, 'java', 4, NULL, 1);

-- ----------------------------
-- Table structure for t_questionnaire_context
-- ----------------------------
DROP TABLE IF EXISTS `t_questionnaire_context`;
CREATE TABLE `t_questionnaire_context`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `context` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `questionnaire_id` int(11) NULL DEFAULT NULL COMMENT '关联问卷id',
  `state` int(11) NULL DEFAULT NULL COMMENT '0：已完成 1：进行中 2：已完成 3：草稿',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 187 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_questionnaire_context
-- ----------------------------
INSERT INTO `t_questionnaire_context` VALUES (179, '1', 30, 1);
INSERT INTO `t_questionnaire_context` VALUES (180, '2', 30, 1);
INSERT INTO `t_questionnaire_context` VALUES (181, '3', 30, 1);
INSERT INTO `t_questionnaire_context` VALUES (182, '4', 30, 1);
INSERT INTO `t_questionnaire_context` VALUES (183, 'a', 30, 1);
INSERT INTO `t_questionnaire_context` VALUES (184, 'b', 30, 1);
INSERT INTO `t_questionnaire_context` VALUES (185, 'c', 30, 1);
INSERT INTO `t_questionnaire_context` VALUES (186, 'd', 30, 1);

-- ----------------------------
-- Table structure for t_questionnaire_context_title
-- ----------------------------
DROP TABLE IF EXISTS `t_questionnaire_context_title`;
CREATE TABLE `t_questionnaire_context_title`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `questionnaire_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `questionnaire_context_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_questionnaire_context_title
-- ----------------------------
INSERT INTO `t_questionnaire_context_title` VALUES (22, 'java1', 182);
INSERT INTO `t_questionnaire_context_title` VALUES (23, 'java2', 186);

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
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES (1, '喻湘东', 'yxd123', 'yxd123', NULL, 1);
INSERT INTO `t_teacher` VALUES (2, NULL, 'yxd789', 'yxd789', NULL, 1);
INSERT INTO `t_teacher` VALUES (3, '喻湘东', 't_1', '123123', '2240170192@qq.com', 1);
INSERT INTO `t_teacher` VALUES (4, '喻湘东', 'yxd1', '915abfdd35c4a4307c940411bf17219a', '2240170192@qq.com', 1);

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
