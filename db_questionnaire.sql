/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50643
Source Host           : localhost:3306
Source Database       : db_questionnaire

Target Server Type    : MYSQL
Target Server Version : 50643
File Encoding         : 65001

Date: 2019-02-25 23:44:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', 'yxd');

-- ----------------------------
-- Table structure for t_questionnaire
-- ----------------------------
DROP TABLE IF EXISTS `t_questionnaire`;
CREATE TABLE `t_questionnaire` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL COMMENT '问卷发起人',
  `submit_id` int(11) DEFAULT NULL COMMENT '问卷提交人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `release_time` datetime DEFAULT NULL COMMENT '发布时间',
  `state` int(11) DEFAULT NULL COMMENT '问卷状态：-1:删除 0:已完成 1:创建未提交 2:提交未评测 ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=139 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_questionnaire
-- ----------------------------
INSERT INTO `t_questionnaire` VALUES ('122', '测试1', '6', '3', '2019-02-25 13:05:18', '2019-02-25 13:05:30', '2');
INSERT INTO `t_questionnaire` VALUES ('123', '测试2', '6', null, '2019-02-25 13:09:09', '2019-02-25 13:09:31', '3');
INSERT INTO `t_questionnaire` VALUES ('124', '1', '6', null, '2019-02-25 15:53:14', '2019-02-25 15:59:39', '2');
INSERT INTO `t_questionnaire` VALUES ('125', '1', '6', null, '2019-02-25 15:53:21', '2019-02-25 15:59:39', '2');
INSERT INTO `t_questionnaire` VALUES ('126', '1', '6', null, '2019-02-25 15:53:28', '2019-02-25 15:59:39', '2');
INSERT INTO `t_questionnaire` VALUES ('127', '1', '6', null, '2019-02-25 15:53:34', '2019-02-25 15:59:39', '2');
INSERT INTO `t_questionnaire` VALUES ('128', '1', '6', null, '2019-02-25 15:53:40', '2019-02-25 15:59:39', '2');
INSERT INTO `t_questionnaire` VALUES ('129', '1', '6', null, '2019-02-25 15:53:47', '2019-02-25 15:59:39', '2');
INSERT INTO `t_questionnaire` VALUES ('130', '1', '6', null, '2019-02-25 15:53:53', '2019-02-25 15:59:39', '2');
INSERT INTO `t_questionnaire` VALUES ('131', '1', '6', null, '2019-02-25 15:54:00', '2019-02-25 15:59:39', '2');
INSERT INTO `t_questionnaire` VALUES ('132', '1', '6', null, '2019-02-25 15:54:08', '2019-02-25 15:59:39', '2');
INSERT INTO `t_questionnaire` VALUES ('133', '1', '6', null, '2019-02-25 15:54:16', '2019-02-25 15:59:39', '2');
INSERT INTO `t_questionnaire` VALUES ('134', '1', '6', null, '2019-02-25 15:54:22', '2019-02-25 15:59:39', '2');
INSERT INTO `t_questionnaire` VALUES ('135', '1', '6', null, '2019-02-25 15:54:29', '2019-02-25 15:59:39', '2');
INSERT INTO `t_questionnaire` VALUES ('136', '1', '6', null, '2019-02-25 15:54:39', '2019-02-25 15:59:39', '2');
INSERT INTO `t_questionnaire` VALUES ('137', '1', '6', null, '2019-02-25 15:54:49', '2019-02-25 15:59:39', '3');
INSERT INTO `t_questionnaire` VALUES ('138', 'java测试1', '6', null, '2019-02-25 17:51:56', '2019-02-25 17:53:04', '3');

-- ----------------------------
-- Table structure for t_questionnaire_context
-- ----------------------------
DROP TABLE IF EXISTS `t_questionnaire_context`;
CREATE TABLE `t_questionnaire_context` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `context` varchar(255) DEFAULT NULL,
  `questionnaire_id` int(11) DEFAULT NULL COMMENT '关联问卷id',
  `questionnaire_context_title_id` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL COMMENT '0：已完成 1：进行中 2：已完成 3：草稿',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=699 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_questionnaire_context
-- ----------------------------
INSERT INTO `t_questionnaire_context` VALUES ('607', 'mysql', '118', '129', '1');
INSERT INTO `t_questionnaire_context` VALUES ('608', 'redis', '118', '129', '1');
INSERT INTO `t_questionnaire_context` VALUES ('609', 'oracle', '118', '129', '1');
INSERT INTO `t_questionnaire_context` VALUES ('611', '2', '119', '130', '1');
INSERT INTO `t_questionnaire_context` VALUES ('612', '3', '119', '130', '1');
INSERT INTO `t_questionnaire_context` VALUES ('613', '4', '119', '130', '1');
INSERT INTO `t_questionnaire_context` VALUES ('614', '5', '119', '130', '1');
INSERT INTO `t_questionnaire_context` VALUES ('615', '1', '120', '131', '1');
INSERT INTO `t_questionnaire_context` VALUES ('616', '1', '120', '131', '1');
INSERT INTO `t_questionnaire_context` VALUES ('617', '1', '120', '131', '1');
INSERT INTO `t_questionnaire_context` VALUES ('618', '1', '120', '131', '1');
INSERT INTO `t_questionnaire_context` VALUES ('619', '1', '121', '132', '1');
INSERT INTO `t_questionnaire_context` VALUES ('620', '1', '121', '132', '1');
INSERT INTO `t_questionnaire_context` VALUES ('621', '1', '121', '132', '1');
INSERT INTO `t_questionnaire_context` VALUES ('622', '1', '121', '132', '1');
INSERT INTO `t_questionnaire_context` VALUES ('623', '1', '122', '133', '1');
INSERT INTO `t_questionnaire_context` VALUES ('624', '1', '122', '133', '1');
INSERT INTO `t_questionnaire_context` VALUES ('625', '1', '122', '133', '1');
INSERT INTO `t_questionnaire_context` VALUES ('626', '1', '122', '133', '1');
INSERT INTO `t_questionnaire_context` VALUES ('627', '2', '123', '134', '1');
INSERT INTO `t_questionnaire_context` VALUES ('628', '2', '123', '134', '1');
INSERT INTO `t_questionnaire_context` VALUES ('629', '2', '123', '134', '1');
INSERT INTO `t_questionnaire_context` VALUES ('630', '2', '123', '134', '1');
INSERT INTO `t_questionnaire_context` VALUES ('631', '1', '124', '135', '1');
INSERT INTO `t_questionnaire_context` VALUES ('632', '1', '124', '135', '1');
INSERT INTO `t_questionnaire_context` VALUES ('633', '1', '124', '135', '1');
INSERT INTO `t_questionnaire_context` VALUES ('634', '1', '124', '135', '1');
INSERT INTO `t_questionnaire_context` VALUES ('635', '1', '125', '136', '1');
INSERT INTO `t_questionnaire_context` VALUES ('636', '1', '125', '136', '1');
INSERT INTO `t_questionnaire_context` VALUES ('637', '1', '125', '136', '1');
INSERT INTO `t_questionnaire_context` VALUES ('638', '1', '125', '136', '1');
INSERT INTO `t_questionnaire_context` VALUES ('639', '1', '126', '137', '1');
INSERT INTO `t_questionnaire_context` VALUES ('640', '1', '126', '137', '1');
INSERT INTO `t_questionnaire_context` VALUES ('641', '1', '126', '137', '1');
INSERT INTO `t_questionnaire_context` VALUES ('642', '1', '126', '137', '1');
INSERT INTO `t_questionnaire_context` VALUES ('643', '1', '127', '138', '1');
INSERT INTO `t_questionnaire_context` VALUES ('644', '1', '127', '138', '1');
INSERT INTO `t_questionnaire_context` VALUES ('645', '1', '127', '138', '1');
INSERT INTO `t_questionnaire_context` VALUES ('646', '1', '127', '138', '1');
INSERT INTO `t_questionnaire_context` VALUES ('647', '11', '128', '139', '1');
INSERT INTO `t_questionnaire_context` VALUES ('648', '1', '128', '139', '1');
INSERT INTO `t_questionnaire_context` VALUES ('649', '1', '128', '139', '1');
INSERT INTO `t_questionnaire_context` VALUES ('650', '1', '128', '139', '1');
INSERT INTO `t_questionnaire_context` VALUES ('651', '1', '129', '140', '1');
INSERT INTO `t_questionnaire_context` VALUES ('652', '1', '129', '140', '1');
INSERT INTO `t_questionnaire_context` VALUES ('653', '1', '129', '140', '1');
INSERT INTO `t_questionnaire_context` VALUES ('654', '1', '129', '140', '1');
INSERT INTO `t_questionnaire_context` VALUES ('655', '11', '130', '141', '1');
INSERT INTO `t_questionnaire_context` VALUES ('656', '1', '130', '141', '1');
INSERT INTO `t_questionnaire_context` VALUES ('657', '1', '130', '141', '1');
INSERT INTO `t_questionnaire_context` VALUES ('658', '1', '130', '141', '1');
INSERT INTO `t_questionnaire_context` VALUES ('659', '1', '131', '142', '1');
INSERT INTO `t_questionnaire_context` VALUES ('660', '1', '131', '142', '1');
INSERT INTO `t_questionnaire_context` VALUES ('661', '1', '131', '142', '1');
INSERT INTO `t_questionnaire_context` VALUES ('662', '1', '131', '142', '1');
INSERT INTO `t_questionnaire_context` VALUES ('663', '1', '132', '143', '1');
INSERT INTO `t_questionnaire_context` VALUES ('664', '1', '132', '143', '1');
INSERT INTO `t_questionnaire_context` VALUES ('665', '1', '132', '143', '1');
INSERT INTO `t_questionnaire_context` VALUES ('666', '1', '132', '143', '1');
INSERT INTO `t_questionnaire_context` VALUES ('667', '1', '133', '144', '1');
INSERT INTO `t_questionnaire_context` VALUES ('668', '1', '133', '144', '1');
INSERT INTO `t_questionnaire_context` VALUES ('669', '1', '133', '144', '1');
INSERT INTO `t_questionnaire_context` VALUES ('670', '1', '133', '144', '1');
INSERT INTO `t_questionnaire_context` VALUES ('671', '1', '134', '145', '1');
INSERT INTO `t_questionnaire_context` VALUES ('672', '1', '134', '145', '1');
INSERT INTO `t_questionnaire_context` VALUES ('673', '1', '134', '145', '1');
INSERT INTO `t_questionnaire_context` VALUES ('674', '1', '134', '145', '1');
INSERT INTO `t_questionnaire_context` VALUES ('675', '1', '135', '146', '1');
INSERT INTO `t_questionnaire_context` VALUES ('676', '11', '135', '146', '1');
INSERT INTO `t_questionnaire_context` VALUES ('677', '1', '135', '146', '1');
INSERT INTO `t_questionnaire_context` VALUES ('678', '1', '135', '146', '1');
INSERT INTO `t_questionnaire_context` VALUES ('679', '2', '135', '147', '1');
INSERT INTO `t_questionnaire_context` VALUES ('680', '2', '135', '147', '1');
INSERT INTO `t_questionnaire_context` VALUES ('681', '2', '135', '147', '1');
INSERT INTO `t_questionnaire_context` VALUES ('682', '2', '135', '147', '1');
INSERT INTO `t_questionnaire_context` VALUES ('683', '1', '136', '148', '1');
INSERT INTO `t_questionnaire_context` VALUES ('684', '1', '136', '148', '1');
INSERT INTO `t_questionnaire_context` VALUES ('685', '1', '136', '148', '1');
INSERT INTO `t_questionnaire_context` VALUES ('686', '1', '136', '148', '1');
INSERT INTO `t_questionnaire_context` VALUES ('687', '1', '137', '149', '1');
INSERT INTO `t_questionnaire_context` VALUES ('688', '1', '137', '149', '1');
INSERT INTO `t_questionnaire_context` VALUES ('689', '1', '137', '149', '1');
INSERT INTO `t_questionnaire_context` VALUES ('690', '1', '137', '149', '1');
INSERT INTO `t_questionnaire_context` VALUES ('691', 'int', '138', '150', '1');
INSERT INTO `t_questionnaire_context` VALUES ('692', 'char', '138', '150', '1');
INSERT INTO `t_questionnaire_context` VALUES ('693', 'long', '138', '150', '1');
INSERT INTO `t_questionnaire_context` VALUES ('694', 'double', '138', '150', '1');
INSERT INTO `t_questionnaire_context` VALUES ('695', 'redis', '138', '151', '1');
INSERT INTO `t_questionnaire_context` VALUES ('696', 'mysql', '138', '151', '1');
INSERT INTO `t_questionnaire_context` VALUES ('697', 'mongodb', '138', '151', '1');
INSERT INTO `t_questionnaire_context` VALUES ('698', 'oracle', '138', '151', '1');

-- ----------------------------
-- Table structure for t_questionnaire_context_title
-- ----------------------------
DROP TABLE IF EXISTS `t_questionnaire_context_title`;
CREATE TABLE `t_questionnaire_context_title` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `questionnaire_title` varchar(255) DEFAULT NULL,
  `questionnaire_id` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_questionnaire_context_title
-- ----------------------------
INSERT INTO `t_questionnaire_context_title` VALUES ('130', '1', '119', '1');
INSERT INTO `t_questionnaire_context_title` VALUES ('131', '1', '120', '1');
INSERT INTO `t_questionnaire_context_title` VALUES ('132', '1', '121', '1');
INSERT INTO `t_questionnaire_context_title` VALUES ('133', '1', '122', '1');
INSERT INTO `t_questionnaire_context_title` VALUES ('134', '2', '123', '1');
INSERT INTO `t_questionnaire_context_title` VALUES ('135', '1', '124', '1');
INSERT INTO `t_questionnaire_context_title` VALUES ('136', '11', '125', '1');
INSERT INTO `t_questionnaire_context_title` VALUES ('137', '1', '126', '1');
INSERT INTO `t_questionnaire_context_title` VALUES ('138', '1', '127', '1');
INSERT INTO `t_questionnaire_context_title` VALUES ('139', '1', '128', '1');
INSERT INTO `t_questionnaire_context_title` VALUES ('140', '1', '129', '1');
INSERT INTO `t_questionnaire_context_title` VALUES ('141', '11', '130', '1');
INSERT INTO `t_questionnaire_context_title` VALUES ('142', '1', '131', '1');
INSERT INTO `t_questionnaire_context_title` VALUES ('143', '1', '132', '1');
INSERT INTO `t_questionnaire_context_title` VALUES ('144', '1', '133', '1');
INSERT INTO `t_questionnaire_context_title` VALUES ('145', '1', '134', '1');
INSERT INTO `t_questionnaire_context_title` VALUES ('146', '1', '135', '1');
INSERT INTO `t_questionnaire_context_title` VALUES ('147', '2', '135', '1');
INSERT INTO `t_questionnaire_context_title` VALUES ('148', '1', '136', '1');
INSERT INTO `t_questionnaire_context_title` VALUES ('149', '1', '137', '1');
INSERT INTO `t_questionnaire_context_title` VALUES ('150', '基本数据类型', '138', '1');
INSERT INTO `t_questionnaire_context_title` VALUES ('151', '哪些是NoSql', '138', '1');

-- ----------------------------
-- Table structure for t_questionnaire_type
-- ----------------------------
DROP TABLE IF EXISTS `t_questionnaire_type`;
CREATE TABLE `t_questionnaire_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) DEFAULT NULL COMMENT '类型名称',
  `questionnarie_id` int(11) DEFAULT NULL,
  `questionnarie_contex_id` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL COMMENT '状态 -1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_questionnaire_type
-- ----------------------------

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `username` varchar(255) DEFAULT NULL COMMENT '账号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('3', '喻湘东', 'yxd520', '9281e5dc4ffc80a9baf8d2071154badc', '2240170192@qq.com', '1');

-- ----------------------------
-- Table structure for t_submit_questionnaire
-- ----------------------------
DROP TABLE IF EXISTS `t_submit_questionnaire`;
CREATE TABLE `t_submit_questionnaire` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `questionnaire_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `questionnaire_title_id` int(11) DEFAULT NULL,
  `questionnaire_context_id` int(11) DEFAULT NULL,
  `submit_state` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_submit_questionnaire
-- ----------------------------
INSERT INTO `t_submit_questionnaire` VALUES ('19', '138', '3', null, '691', '1');
INSERT INTO `t_submit_questionnaire` VALUES ('20', '138', '3', null, '692', '1');
INSERT INTO `t_submit_questionnaire` VALUES ('21', '138', '3', null, '695', '1');
INSERT INTO `t_submit_questionnaire` VALUES ('22', '138', '3', null, '697', '1');
INSERT INTO `t_submit_questionnaire` VALUES ('23', '137', '3', null, '687', '1');

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES ('5', '喻湘东', 'yxd1', 'a0cf8379cd9726c90dec9c0e3b2c97cc', '2240170192@qq.com', '1');
INSERT INTO `t_teacher` VALUES ('6', '喻湘东', 'q123', '4297f44b13955235245b2497399d7a93', '2240170192@qq.com', '1');

-- ----------------------------
-- Table structure for t_teacher_questionnaire_student
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher_questionnaire_student`;
CREATE TABLE `t_teacher_questionnaire_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) DEFAULT NULL COMMENT '老师id',
  `questionnaire_id` int(11) DEFAULT NULL COMMENT '问卷id',
  `student_id` int(11) DEFAULT NULL COMMENT '学生id',
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_teacher_questionnaire_student
-- ----------------------------
INSERT INTO `t_teacher_questionnaire_student` VALUES ('4', '6', '123', '3', '0');
INSERT INTO `t_teacher_questionnaire_student` VALUES ('5', '6', '122', '3', '0');
INSERT INTO `t_teacher_questionnaire_student` VALUES ('6', '6', '124', '3', '0');
INSERT INTO `t_teacher_questionnaire_student` VALUES ('7', '6', '125', '3', '0');
INSERT INTO `t_teacher_questionnaire_student` VALUES ('8', '6', '126', '3', '0');
INSERT INTO `t_teacher_questionnaire_student` VALUES ('9', '6', '127', '3', '0');
INSERT INTO `t_teacher_questionnaire_student` VALUES ('10', '6', '128', '3', '0');
INSERT INTO `t_teacher_questionnaire_student` VALUES ('11', '6', '129', '3', '0');
INSERT INTO `t_teacher_questionnaire_student` VALUES ('12', '6', '130', '3', '0');
INSERT INTO `t_teacher_questionnaire_student` VALUES ('13', '6', '131', '3', '0');
INSERT INTO `t_teacher_questionnaire_student` VALUES ('14', '6', '132', '3', '0');
INSERT INTO `t_teacher_questionnaire_student` VALUES ('15', '6', '133', '3', '0');
INSERT INTO `t_teacher_questionnaire_student` VALUES ('16', '6', '134', '3', '0');
INSERT INTO `t_teacher_questionnaire_student` VALUES ('17', '6', '135', '3', '0');
INSERT INTO `t_teacher_questionnaire_student` VALUES ('18', '6', '136', '3', '0');
INSERT INTO `t_teacher_questionnaire_student` VALUES ('19', '6', '137', '3', '0');
INSERT INTO `t_teacher_questionnaire_student` VALUES ('20', '6', '138', '3', '0');
