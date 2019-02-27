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

 Date: 27/02/2019 19:02:43
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
  `state` int(11) NULL DEFAULT NULL COMMENT '问卷状态：-1:删除 1创建 2发布/进行中 3提交/待收回 4结束',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 210 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_questionnaire
-- ----------------------------
INSERT INTO `t_questionnaire` VALUES (209, '1', 6, NULL, '2019-02-27 18:44:09', '2019-02-27 18:44:17', 4);

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
) ENGINE = InnoDB AUTO_INCREMENT = 995 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_questionnaire_context
-- ----------------------------
INSERT INTO `t_questionnaire_context` VALUES (991, '1', 209, 225, 1);
INSERT INTO `t_questionnaire_context` VALUES (992, '1', 209, 225, 1);
INSERT INTO `t_questionnaire_context` VALUES (993, '1', 209, 225, 1);
INSERT INTO `t_questionnaire_context` VALUES (994, '1', 209, 225, 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 226 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_questionnaire_context_title
-- ----------------------------
INSERT INTO `t_questionnaire_context_title` VALUES (225, '1', 209, 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES (3, '喻湘东', 'yxd520', 'efe6398127928f1b2e9ef3207fb82663', '2240170192@qq.com', 1);
INSERT INTO `t_student` VALUES (4, '方坤', '123123', '4297f44b13955235245b2497399d7a93', '2240170192@qq.com', 1);
INSERT INTO `t_student` VALUES (5, '熊锡锡', '111', '698d51a19d8a121ce581499d7b701668', '2240170192@qq.com', 1);
INSERT INTO `t_student` VALUES (6, '喻湘东', 's1', '8ddf878039b70767c4a5bcf4f0c4f65e', '2240170192@qq.com', 1);
INSERT INTO `t_student` VALUES (7, 's2', 's2', 'fac989447cad2edbc89fbcba70003b36', '2240170192@qq.com', 1);
INSERT INTO `t_student` VALUES (8, 's3', 's3', 'c0828e0381730befd1f7a025057c74fb', '2240170192@qq.com', 1);

-- ----------------------------
-- Table structure for t_submit_context
-- ----------------------------
DROP TABLE IF EXISTS `t_submit_context`;
CREATE TABLE `t_submit_context`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `questionnaire_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `questionnaire_title_id` int(11) NULL DEFAULT NULL,
  `questionnaire_context_id` int(11) NULL DEFAULT NULL,
  `submit_state` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 59 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_submit_context
-- ----------------------------
INSERT INTO `t_submit_context` VALUES (52, 209, 8, NULL, 991, 1);
INSERT INTO `t_submit_context` VALUES (53, 209, 8, NULL, 992, 1);
INSERT INTO `t_submit_context` VALUES (54, 209, 8, NULL, 993, 1);
INSERT INTO `t_submit_context` VALUES (55, 209, 7, NULL, 991, 1);
INSERT INTO `t_submit_context` VALUES (56, 209, 7, NULL, 992, 1);
INSERT INTO `t_submit_context` VALUES (57, 209, 6, NULL, 993, 1);
INSERT INTO `t_submit_context` VALUES (58, 209, 6, NULL, 994, 1);

-- ----------------------------
-- Table structure for t_submit_questionnaire
-- ----------------------------
DROP TABLE IF EXISTS `t_submit_questionnaire`;
CREATE TABLE `t_submit_questionnaire`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NULL DEFAULT NULL,
  `questionnaire_id` int(11) NULL DEFAULT NULL,
  `submit_time` datetime(0) NULL DEFAULT NULL,
  `submit_state` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_submit_questionnaire
-- ----------------------------
INSERT INTO `t_submit_questionnaire` VALUES (8, 8, 209, '2019-02-27 18:44:24', 1);
INSERT INTO `t_submit_questionnaire` VALUES (9, 7, 209, '2019-02-27 18:44:33', 1);
INSERT INTO `t_submit_questionnaire` VALUES (10, 6, 209, '2019-02-27 18:44:42', 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES (5, '喻湘东', 'yxd1', 'a0cf8379cd9726c90dec9c0e3b2c97cc', '2240170192@qq.com', 1);
INSERT INTO `t_teacher` VALUES (6, '喻湘东', 'q123', '4297f44b13955235245b2497399d7a93', '2240170192@qq.com', 1);
INSERT INTO `t_teacher` VALUES (7, '111', '111111', '698d51a19d8a121ce581499d7b701668', '2240170192@qq.com', 1);

-- ----------------------------
-- Table structure for t_teacher_questionnaire_student
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher_questionnaire_student`;
CREATE TABLE `t_teacher_questionnaire_student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) NULL DEFAULT NULL COMMENT '老师id',
  `questionnaire_id` int(11) NULL DEFAULT NULL COMMENT '问卷id',
  `student_id` int(11) NULL DEFAULT NULL COMMENT '学生id',
  `state` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

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
