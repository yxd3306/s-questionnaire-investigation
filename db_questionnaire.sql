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

 Date: 26/02/2019 18:48:39
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
) ENGINE = InnoDB AUTO_INCREMENT = 200 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_questionnaire
-- ----------------------------
INSERT INTO `t_questionnaire` VALUES (122, '测试1', 6, 3, '2019-02-25 13:05:18', '2019-02-25 13:05:30', 2);
INSERT INTO `t_questionnaire` VALUES (123, '测试2', 6, NULL, '2019-02-25 13:09:09', '2019-02-25 13:09:31', 3);
INSERT INTO `t_questionnaire` VALUES (124, '1', 6, NULL, '2019-02-25 15:53:14', '2019-02-25 15:59:39', 2);
INSERT INTO `t_questionnaire` VALUES (125, '1', 6, NULL, '2019-02-25 15:53:21', '2019-02-25 15:59:39', 2);
INSERT INTO `t_questionnaire` VALUES (126, '1', 6, NULL, '2019-02-25 15:53:28', '2019-02-25 15:59:39', 2);
INSERT INTO `t_questionnaire` VALUES (127, '1', 6, NULL, '2019-02-25 15:53:34', '2019-02-25 15:59:39', 2);
INSERT INTO `t_questionnaire` VALUES (128, '1', 6, NULL, '2019-02-25 15:53:40', '2019-02-25 15:59:39', 2);
INSERT INTO `t_questionnaire` VALUES (129, '1', 6, NULL, '2019-02-25 15:53:47', '2019-02-25 15:59:39', 2);
INSERT INTO `t_questionnaire` VALUES (130, '1', 6, NULL, '2019-02-25 15:53:53', '2019-02-25 15:59:39', 2);
INSERT INTO `t_questionnaire` VALUES (131, '1', 6, NULL, '2019-02-25 15:54:00', '2019-02-25 15:59:39', 2);
INSERT INTO `t_questionnaire` VALUES (132, '1', 6, NULL, '2019-02-25 15:54:08', '2019-02-25 15:59:39', 2);
INSERT INTO `t_questionnaire` VALUES (133, '1', 6, NULL, '2019-02-25 15:54:16', '2019-02-25 15:59:39', 2);
INSERT INTO `t_questionnaire` VALUES (134, '1', 6, NULL, '2019-02-25 15:54:22', '2019-02-25 15:59:39', 2);
INSERT INTO `t_questionnaire` VALUES (135, '1', 6, NULL, '2019-02-25 15:54:29', '2019-02-25 15:59:39', 2);
INSERT INTO `t_questionnaire` VALUES (136, '1', 6, NULL, '2019-02-25 15:54:39', '2019-02-25 15:59:39', 2);
INSERT INTO `t_questionnaire` VALUES (137, '1', 6, NULL, '2019-02-25 15:54:49', '2019-02-25 15:59:39', 4);
INSERT INTO `t_questionnaire` VALUES (138, 'java测试1', 6, NULL, '2019-02-25 17:51:56', '2019-02-25 17:53:04', 4);
INSERT INTO `t_questionnaire` VALUES (139, '喻湘东', 6, NULL, '2019-02-26 10:08:43', '2019-02-26 10:09:27', 2);
INSERT INTO `t_questionnaire` VALUES (140, '喻湘东2', 6, NULL, '2019-02-26 10:08:55', '2019-02-26 10:09:27', 2);
INSERT INTO `t_questionnaire` VALUES (141, '存储', 6, NULL, '2019-02-26 10:15:07', '2019-02-26 10:16:48', 2);
INSERT INTO `t_questionnaire` VALUES (142, '11', 6, NULL, '2019-02-26 10:15:19', '2019-02-26 10:16:48', 2);
INSERT INTO `t_questionnaire` VALUES (143, '请问', 6, NULL, '2019-02-26 10:19:12', '2019-02-26 10:24:28', 2);
INSERT INTO `t_questionnaire` VALUES (144, '1', 6, NULL, '2019-02-26 10:19:21', '2019-02-26 10:24:28', 2);
INSERT INTO `t_questionnaire` VALUES (145, '1', 6, NULL, '2019-02-26 10:25:27', '2019-02-26 10:44:39', 2);
INSERT INTO `t_questionnaire` VALUES (146, '2', 6, NULL, '2019-02-26 10:25:33', '2019-02-26 10:25:48', 2);
INSERT INTO `t_questionnaire` VALUES (147, 'q', 6, NULL, '2019-02-26 10:31:56', '2019-02-26 10:37:23', 2);
INSERT INTO `t_questionnaire` VALUES (148, 'q', 6, NULL, '2019-02-26 10:32:02', '2019-02-26 10:37:23', 2);
INSERT INTO `t_questionnaire` VALUES (149, 'q', 6, NULL, '2019-02-26 10:32:10', '2019-02-26 10:37:23', 2);
INSERT INTO `t_questionnaire` VALUES (150, 'q', 6, NULL, '2019-02-26 10:32:22', '2019-02-26 10:37:23', 2);
INSERT INTO `t_questionnaire` VALUES (151, 'q', 6, NULL, '2019-02-26 10:32:28', '2019-02-26 10:37:23', 2);
INSERT INTO `t_questionnaire` VALUES (152, '1', 6, NULL, '2019-02-26 10:41:35', '2019-02-26 10:42:25', 2);
INSERT INTO `t_questionnaire` VALUES (153, '1', 6, NULL, '2019-02-26 10:41:41', '2019-02-26 10:41:49', 2);
INSERT INTO `t_questionnaire` VALUES (154, '1', 6, NULL, '2019-02-26 10:43:20', '2019-02-26 10:43:38', 2);
INSERT INTO `t_questionnaire` VALUES (155, '1', 6, NULL, '2019-02-26 10:43:26', '2019-02-26 10:43:38', 2);
INSERT INTO `t_questionnaire` VALUES (156, '1', 6, NULL, '2019-02-26 10:44:01', '2019-02-26 10:52:36', 2);
INSERT INTO `t_questionnaire` VALUES (157, '1', 6, NULL, '2019-02-26 10:44:07', '2019-02-26 10:44:39', 2);
INSERT INTO `t_questionnaire` VALUES (158, '1', 6, NULL, '2019-02-26 10:48:47', '2019-02-26 10:52:11', 2);
INSERT INTO `t_questionnaire` VALUES (159, '2', 6, NULL, '2019-02-26 10:56:16', '2019-02-26 10:58:45', 2);
INSERT INTO `t_questionnaire` VALUES (160, '123', 6, NULL, '2019-02-26 10:56:24', '2019-02-26 10:58:06', 2);
INSERT INTO `t_questionnaire` VALUES (161, '1', 6, NULL, '2019-02-26 10:56:29', '2019-02-26 10:57:56', 2);
INSERT INTO `t_questionnaire` VALUES (162, '1', 6, NULL, '2019-02-26 11:00:14', '2019-02-26 11:01:07', 2);
INSERT INTO `t_questionnaire` VALUES (163, '2', 6, NULL, '2019-02-26 11:00:20', '2019-02-26 11:00:42', 2);
INSERT INTO `t_questionnaire` VALUES (164, '3', 6, NULL, '2019-02-26 11:00:25', '2019-02-26 11:00:39', 2);
INSERT INTO `t_questionnaire` VALUES (165, '1', 6, NULL, '2019-02-26 11:03:32', '2019-02-26 11:21:08', 2);
INSERT INTO `t_questionnaire` VALUES (166, '2', 6, NULL, '2019-02-26 11:03:39', '2019-02-26 11:21:08', 2);
INSERT INTO `t_questionnaire` VALUES (167, '3', 6, NULL, '2019-02-26 11:03:46', '2019-02-26 11:21:08', 2);
INSERT INTO `t_questionnaire` VALUES (168, '4', 6, NULL, '2019-02-26 11:03:52', '2019-02-26 11:05:35', 2);
INSERT INTO `t_questionnaire` VALUES (169, '5', 6, NULL, '2019-02-26 11:03:59', '2019-02-26 11:05:35', 2);
INSERT INTO `t_questionnaire` VALUES (170, '6', 6, NULL, '2019-02-26 11:04:05', '2019-02-26 11:05:35', 2);
INSERT INTO `t_questionnaire` VALUES (171, '7', 6, NULL, '2019-02-26 11:04:11', '2019-02-26 11:05:35', 2);
INSERT INTO `t_questionnaire` VALUES (172, '8', 6, NULL, '2019-02-26 11:04:17', '2019-02-26 11:05:35', 2);
INSERT INTO `t_questionnaire` VALUES (173, '1', 6, NULL, '2019-02-26 11:21:22', '2019-02-26 11:26:35', 2);
INSERT INTO `t_questionnaire` VALUES (174, '2', 6, NULL, '2019-02-26 11:21:29', '2019-02-26 11:24:35', 2);
INSERT INTO `t_questionnaire` VALUES (175, '3', 6, NULL, '2019-02-26 11:21:36', '2019-02-26 11:24:35', 2);
INSERT INTO `t_questionnaire` VALUES (176, '4', 6, NULL, '2019-02-26 11:21:41', '2019-02-26 11:24:35', 2);
INSERT INTO `t_questionnaire` VALUES (177, '5', 6, NULL, '2019-02-26 11:21:50', '2019-02-26 11:24:35', 2);
INSERT INTO `t_questionnaire` VALUES (178, '1', 6, NULL, '2019-02-26 11:26:47', '2019-02-26 11:30:53', 2);
INSERT INTO `t_questionnaire` VALUES (179, '2', 6, NULL, '2019-02-26 11:26:54', '2019-02-26 11:29:46', 2);
INSERT INTO `t_questionnaire` VALUES (180, '3', 6, NULL, '2019-02-26 11:27:01', '2019-02-26 11:29:46', 2);
INSERT INTO `t_questionnaire` VALUES (181, '4', 6, NULL, '2019-02-26 11:27:07', '2019-02-26 11:29:46', 2);
INSERT INTO `t_questionnaire` VALUES (182, '5', 6, NULL, '2019-02-26 11:27:14', '2019-02-26 11:29:46', 2);
INSERT INTO `t_questionnaire` VALUES (183, '1', 6, NULL, '2019-02-26 11:32:16', '2019-02-26 11:34:14', 2);
INSERT INTO `t_questionnaire` VALUES (184, '2', 6, NULL, '2019-02-26 11:32:22', '2019-02-26 11:32:34', 2);
INSERT INTO `t_questionnaire` VALUES (185, '1', 6, NULL, '2019-02-26 11:33:21', '2019-02-26 11:33:27', 2);
INSERT INTO `t_questionnaire` VALUES (186, '1', 6, NULL, '2019-02-26 11:34:53', '2019-02-26 11:35:42', 2);
INSERT INTO `t_questionnaire` VALUES (187, '2', 6, NULL, '2019-02-26 11:34:59', '2019-02-26 11:35:42', 2);
INSERT INTO `t_questionnaire` VALUES (188, '1', 6, NULL, '2019-02-26 11:36:03', '2019-02-26 11:37:21', 2);
INSERT INTO `t_questionnaire` VALUES (189, '1', 6, NULL, '2019-02-26 11:36:08', '2019-02-26 11:37:21', 2);
INSERT INTO `t_questionnaire` VALUES (190, '1', 6, NULL, '2019-02-26 11:38:19', '2019-02-26 11:38:39', 2);
INSERT INTO `t_questionnaire` VALUES (191, '2', 6, NULL, '2019-02-26 11:38:26', '2019-02-26 11:38:39', 2);
INSERT INTO `t_questionnaire` VALUES (192, '1', 6, NULL, '2019-02-26 11:44:17', '2019-02-26 11:45:00', 2);
INSERT INTO `t_questionnaire` VALUES (193, '1', 6, NULL, '2019-02-26 11:44:25', '2019-02-26 11:45:00', 2);
INSERT INTO `t_questionnaire` VALUES (194, '1', 6, NULL, '2019-02-26 11:45:27', '2019-02-26 11:47:06', 4);
INSERT INTO `t_questionnaire` VALUES (195, '1', 6, NULL, '2019-02-26 11:45:34', '2019-02-26 11:45:40', 2);
INSERT INTO `t_questionnaire` VALUES (196, '1', 6, NULL, '2019-02-26 11:46:09', '2019-02-26 11:47:06', 3);
INSERT INTO `t_questionnaire` VALUES (197, '1', 6, NULL, '2019-02-26 11:49:12', '2019-02-26 11:49:43', 2);
INSERT INTO `t_questionnaire` VALUES (198, '1', 6, NULL, '2019-02-26 11:49:22', '2019-02-26 11:49:30', 4);
INSERT INTO `t_questionnaire` VALUES (199, '1', 6, NULL, '2019-02-26 18:34:35', NULL, 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 947 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_questionnaire_context
-- ----------------------------
INSERT INTO `t_questionnaire_context` VALUES (607, 'mysql', 118, 129, 1);
INSERT INTO `t_questionnaire_context` VALUES (608, 'redis', 118, 129, 1);
INSERT INTO `t_questionnaire_context` VALUES (609, 'oracle', 118, 129, 1);
INSERT INTO `t_questionnaire_context` VALUES (611, '2', 119, 130, 1);
INSERT INTO `t_questionnaire_context` VALUES (612, '3', 119, 130, 1);
INSERT INTO `t_questionnaire_context` VALUES (613, '4', 119, 130, 1);
INSERT INTO `t_questionnaire_context` VALUES (614, '5', 119, 130, 1);
INSERT INTO `t_questionnaire_context` VALUES (615, '1', 120, 131, 1);
INSERT INTO `t_questionnaire_context` VALUES (616, '1', 120, 131, 1);
INSERT INTO `t_questionnaire_context` VALUES (617, '1', 120, 131, 1);
INSERT INTO `t_questionnaire_context` VALUES (618, '1', 120, 131, 1);
INSERT INTO `t_questionnaire_context` VALUES (619, '1', 121, 132, 1);
INSERT INTO `t_questionnaire_context` VALUES (620, '1', 121, 132, 1);
INSERT INTO `t_questionnaire_context` VALUES (621, '1', 121, 132, 1);
INSERT INTO `t_questionnaire_context` VALUES (622, '1', 121, 132, 1);
INSERT INTO `t_questionnaire_context` VALUES (623, '1', 122, 133, 1);
INSERT INTO `t_questionnaire_context` VALUES (624, '1', 122, 133, 1);
INSERT INTO `t_questionnaire_context` VALUES (625, '1', 122, 133, 1);
INSERT INTO `t_questionnaire_context` VALUES (626, '1', 122, 133, 1);
INSERT INTO `t_questionnaire_context` VALUES (627, '2', 123, 134, 1);
INSERT INTO `t_questionnaire_context` VALUES (628, '2', 123, 134, 1);
INSERT INTO `t_questionnaire_context` VALUES (629, '2', 123, 134, 1);
INSERT INTO `t_questionnaire_context` VALUES (630, '2', 123, 134, 1);
INSERT INTO `t_questionnaire_context` VALUES (631, '1', 124, 135, 1);
INSERT INTO `t_questionnaire_context` VALUES (632, '1', 124, 135, 1);
INSERT INTO `t_questionnaire_context` VALUES (633, '1', 124, 135, 1);
INSERT INTO `t_questionnaire_context` VALUES (634, '1', 124, 135, 1);
INSERT INTO `t_questionnaire_context` VALUES (635, '1', 125, 136, 1);
INSERT INTO `t_questionnaire_context` VALUES (636, '1', 125, 136, 1);
INSERT INTO `t_questionnaire_context` VALUES (637, '1', 125, 136, 1);
INSERT INTO `t_questionnaire_context` VALUES (638, '1', 125, 136, 1);
INSERT INTO `t_questionnaire_context` VALUES (639, '1', 126, 137, 1);
INSERT INTO `t_questionnaire_context` VALUES (640, '1', 126, 137, 1);
INSERT INTO `t_questionnaire_context` VALUES (641, '1', 126, 137, 1);
INSERT INTO `t_questionnaire_context` VALUES (642, '1', 126, 137, 1);
INSERT INTO `t_questionnaire_context` VALUES (643, '1', 127, 138, 1);
INSERT INTO `t_questionnaire_context` VALUES (644, '1', 127, 138, 1);
INSERT INTO `t_questionnaire_context` VALUES (645, '1', 127, 138, 1);
INSERT INTO `t_questionnaire_context` VALUES (646, '1', 127, 138, 1);
INSERT INTO `t_questionnaire_context` VALUES (647, '11', 128, 139, 1);
INSERT INTO `t_questionnaire_context` VALUES (648, '1', 128, 139, 1);
INSERT INTO `t_questionnaire_context` VALUES (649, '1', 128, 139, 1);
INSERT INTO `t_questionnaire_context` VALUES (650, '1', 128, 139, 1);
INSERT INTO `t_questionnaire_context` VALUES (651, '1', 129, 140, 1);
INSERT INTO `t_questionnaire_context` VALUES (652, '1', 129, 140, 1);
INSERT INTO `t_questionnaire_context` VALUES (653, '1', 129, 140, 1);
INSERT INTO `t_questionnaire_context` VALUES (654, '1', 129, 140, 1);
INSERT INTO `t_questionnaire_context` VALUES (655, '11', 130, 141, 1);
INSERT INTO `t_questionnaire_context` VALUES (656, '1', 130, 141, 1);
INSERT INTO `t_questionnaire_context` VALUES (657, '1', 130, 141, 1);
INSERT INTO `t_questionnaire_context` VALUES (658, '1', 130, 141, 1);
INSERT INTO `t_questionnaire_context` VALUES (659, '1', 131, 142, 1);
INSERT INTO `t_questionnaire_context` VALUES (660, '1', 131, 142, 1);
INSERT INTO `t_questionnaire_context` VALUES (661, '1', 131, 142, 1);
INSERT INTO `t_questionnaire_context` VALUES (662, '1', 131, 142, 1);
INSERT INTO `t_questionnaire_context` VALUES (663, '1', 132, 143, 1);
INSERT INTO `t_questionnaire_context` VALUES (664, '1', 132, 143, 1);
INSERT INTO `t_questionnaire_context` VALUES (665, '1', 132, 143, 1);
INSERT INTO `t_questionnaire_context` VALUES (666, '1', 132, 143, 1);
INSERT INTO `t_questionnaire_context` VALUES (667, '1', 133, 144, 1);
INSERT INTO `t_questionnaire_context` VALUES (668, '1', 133, 144, 1);
INSERT INTO `t_questionnaire_context` VALUES (669, '1', 133, 144, 1);
INSERT INTO `t_questionnaire_context` VALUES (670, '1', 133, 144, 1);
INSERT INTO `t_questionnaire_context` VALUES (671, '1', 134, 145, 1);
INSERT INTO `t_questionnaire_context` VALUES (672, '1', 134, 145, 1);
INSERT INTO `t_questionnaire_context` VALUES (673, '1', 134, 145, 1);
INSERT INTO `t_questionnaire_context` VALUES (674, '1', 134, 145, 1);
INSERT INTO `t_questionnaire_context` VALUES (675, '1', 135, 146, 1);
INSERT INTO `t_questionnaire_context` VALUES (676, '11', 135, 146, 1);
INSERT INTO `t_questionnaire_context` VALUES (677, '1', 135, 146, 1);
INSERT INTO `t_questionnaire_context` VALUES (678, '1', 135, 146, 1);
INSERT INTO `t_questionnaire_context` VALUES (679, '2', 135, 147, 1);
INSERT INTO `t_questionnaire_context` VALUES (680, '2', 135, 147, 1);
INSERT INTO `t_questionnaire_context` VALUES (681, '2', 135, 147, 1);
INSERT INTO `t_questionnaire_context` VALUES (682, '2', 135, 147, 1);
INSERT INTO `t_questionnaire_context` VALUES (683, '1', 136, 148, 1);
INSERT INTO `t_questionnaire_context` VALUES (684, '1', 136, 148, 1);
INSERT INTO `t_questionnaire_context` VALUES (685, '1', 136, 148, 1);
INSERT INTO `t_questionnaire_context` VALUES (686, '1', 136, 148, 1);
INSERT INTO `t_questionnaire_context` VALUES (687, '1', 137, 149, 1);
INSERT INTO `t_questionnaire_context` VALUES (688, '1', 137, 149, 1);
INSERT INTO `t_questionnaire_context` VALUES (689, '1', 137, 149, 1);
INSERT INTO `t_questionnaire_context` VALUES (690, '1', 137, 149, 1);
INSERT INTO `t_questionnaire_context` VALUES (691, 'int', 138, 150, 1);
INSERT INTO `t_questionnaire_context` VALUES (692, 'char', 138, 150, 1);
INSERT INTO `t_questionnaire_context` VALUES (693, 'long', 138, 150, 1);
INSERT INTO `t_questionnaire_context` VALUES (694, 'double', 138, 150, 1);
INSERT INTO `t_questionnaire_context` VALUES (695, 'redis', 138, 151, 1);
INSERT INTO `t_questionnaire_context` VALUES (696, 'mysql', 138, 151, 1);
INSERT INTO `t_questionnaire_context` VALUES (697, 'mongodb', 138, 151, 1);
INSERT INTO `t_questionnaire_context` VALUES (698, 'oracle', 138, 151, 1);
INSERT INTO `t_questionnaire_context` VALUES (699, '1', 139, 152, 1);
INSERT INTO `t_questionnaire_context` VALUES (700, '1', 139, 152, 1);
INSERT INTO `t_questionnaire_context` VALUES (701, '1', 139, 152, 1);
INSERT INTO `t_questionnaire_context` VALUES (702, '1', 139, 152, 1);
INSERT INTO `t_questionnaire_context` VALUES (703, '1', 140, 153, 1);
INSERT INTO `t_questionnaire_context` VALUES (704, '1', 140, 153, 1);
INSERT INTO `t_questionnaire_context` VALUES (705, '1', 140, 153, 1);
INSERT INTO `t_questionnaire_context` VALUES (706, '1', 140, 153, 1);
INSERT INTO `t_questionnaire_context` VALUES (707, '的', 141, 154, 1);
INSERT INTO `t_questionnaire_context` VALUES (708, '的', 141, 154, 1);
INSERT INTO `t_questionnaire_context` VALUES (709, '_(:з」∠)_', 141, 154, 1);
INSERT INTO `t_questionnaire_context` VALUES (710, 'dd', 141, 154, 1);
INSERT INTO `t_questionnaire_context` VALUES (711, '123', 142, 155, 1);
INSERT INTO `t_questionnaire_context` VALUES (712, '123', 142, 155, 1);
INSERT INTO `t_questionnaire_context` VALUES (713, '123', 142, 155, 1);
INSERT INTO `t_questionnaire_context` VALUES (714, '123', 142, 155, 1);
INSERT INTO `t_questionnaire_context` VALUES (715, '123', 143, 156, 1);
INSERT INTO `t_questionnaire_context` VALUES (716, '12312', 143, 156, 1);
INSERT INTO `t_questionnaire_context` VALUES (717, '123', 143, 156, 1);
INSERT INTO `t_questionnaire_context` VALUES (718, '123', 143, 156, 1);
INSERT INTO `t_questionnaire_context` VALUES (719, '123', 144, 157, 1);
INSERT INTO `t_questionnaire_context` VALUES (720, '123', 144, 157, 1);
INSERT INTO `t_questionnaire_context` VALUES (721, '123', 144, 157, 1);
INSERT INTO `t_questionnaire_context` VALUES (722, '1233', 144, 157, 1);
INSERT INTO `t_questionnaire_context` VALUES (723, '1', 145, 158, 1);
INSERT INTO `t_questionnaire_context` VALUES (724, '1', 145, 158, 1);
INSERT INTO `t_questionnaire_context` VALUES (725, '1', 145, 158, 1);
INSERT INTO `t_questionnaire_context` VALUES (726, '1', 145, 158, 1);
INSERT INTO `t_questionnaire_context` VALUES (727, '1', 146, 159, 1);
INSERT INTO `t_questionnaire_context` VALUES (728, '1', 146, 159, 1);
INSERT INTO `t_questionnaire_context` VALUES (729, '1', 146, 159, 1);
INSERT INTO `t_questionnaire_context` VALUES (730, '1', 146, 159, 1);
INSERT INTO `t_questionnaire_context` VALUES (731, 'q', 147, 160, 1);
INSERT INTO `t_questionnaire_context` VALUES (732, 'q', 147, 160, 1);
INSERT INTO `t_questionnaire_context` VALUES (733, 'q', 147, 160, 1);
INSERT INTO `t_questionnaire_context` VALUES (734, 'q', 147, 160, 1);
INSERT INTO `t_questionnaire_context` VALUES (735, 'q', 148, 161, 1);
INSERT INTO `t_questionnaire_context` VALUES (736, 'q', 148, 161, 1);
INSERT INTO `t_questionnaire_context` VALUES (737, 'q', 148, 161, 1);
INSERT INTO `t_questionnaire_context` VALUES (738, 'q', 148, 161, 1);
INSERT INTO `t_questionnaire_context` VALUES (739, 'q', 149, 162, 1);
INSERT INTO `t_questionnaire_context` VALUES (740, 'q', 149, 162, 1);
INSERT INTO `t_questionnaire_context` VALUES (741, 'q', 149, 162, 1);
INSERT INTO `t_questionnaire_context` VALUES (742, 'q', 149, 162, 1);
INSERT INTO `t_questionnaire_context` VALUES (743, 'q', 149, 163, 1);
INSERT INTO `t_questionnaire_context` VALUES (744, 'q', 149, 163, 1);
INSERT INTO `t_questionnaire_context` VALUES (745, 'q', 149, 163, 1);
INSERT INTO `t_questionnaire_context` VALUES (746, 'q', 149, 163, 1);
INSERT INTO `t_questionnaire_context` VALUES (747, 'q', 150, 164, 1);
INSERT INTO `t_questionnaire_context` VALUES (748, 'q', 150, 164, 1);
INSERT INTO `t_questionnaire_context` VALUES (749, 'q', 150, 164, 1);
INSERT INTO `t_questionnaire_context` VALUES (750, 'q', 150, 164, 1);
INSERT INTO `t_questionnaire_context` VALUES (751, 'q', 151, 165, 1);
INSERT INTO `t_questionnaire_context` VALUES (752, 'q', 151, 165, 1);
INSERT INTO `t_questionnaire_context` VALUES (753, 'q', 151, 165, 1);
INSERT INTO `t_questionnaire_context` VALUES (754, 'q', 151, 165, 1);
INSERT INTO `t_questionnaire_context` VALUES (755, '1', 152, 166, 1);
INSERT INTO `t_questionnaire_context` VALUES (756, '1', 152, 166, 1);
INSERT INTO `t_questionnaire_context` VALUES (757, '1', 152, 166, 1);
INSERT INTO `t_questionnaire_context` VALUES (758, '1', 152, 166, 1);
INSERT INTO `t_questionnaire_context` VALUES (759, '1', 153, 167, 1);
INSERT INTO `t_questionnaire_context` VALUES (760, '1', 153, 167, 1);
INSERT INTO `t_questionnaire_context` VALUES (761, '1', 153, 167, 1);
INSERT INTO `t_questionnaire_context` VALUES (762, '1', 153, 167, 1);
INSERT INTO `t_questionnaire_context` VALUES (763, '1', 154, 168, 1);
INSERT INTO `t_questionnaire_context` VALUES (764, '1', 154, 168, 1);
INSERT INTO `t_questionnaire_context` VALUES (765, '1', 154, 168, 1);
INSERT INTO `t_questionnaire_context` VALUES (766, '1', 154, 168, 1);
INSERT INTO `t_questionnaire_context` VALUES (767, '1', 155, 169, 1);
INSERT INTO `t_questionnaire_context` VALUES (768, '1', 155, 169, 1);
INSERT INTO `t_questionnaire_context` VALUES (769, '1', 155, 169, 1);
INSERT INTO `t_questionnaire_context` VALUES (770, '1', 155, 169, 1);
INSERT INTO `t_questionnaire_context` VALUES (771, '1', 156, 170, 1);
INSERT INTO `t_questionnaire_context` VALUES (772, '1', 156, 170, 1);
INSERT INTO `t_questionnaire_context` VALUES (773, '1', 156, 170, 1);
INSERT INTO `t_questionnaire_context` VALUES (774, '1', 156, 170, 1);
INSERT INTO `t_questionnaire_context` VALUES (775, '1', 157, 171, 1);
INSERT INTO `t_questionnaire_context` VALUES (776, '1', 157, 171, 1);
INSERT INTO `t_questionnaire_context` VALUES (777, '1', 157, 171, 1);
INSERT INTO `t_questionnaire_context` VALUES (778, '1', 157, 171, 1);
INSERT INTO `t_questionnaire_context` VALUES (779, '1', 158, 172, 1);
INSERT INTO `t_questionnaire_context` VALUES (780, '1', 158, 172, 1);
INSERT INTO `t_questionnaire_context` VALUES (781, '1', 158, 172, 1);
INSERT INTO `t_questionnaire_context` VALUES (782, '1', 158, 172, 1);
INSERT INTO `t_questionnaire_context` VALUES (783, '2', 159, 173, 1);
INSERT INTO `t_questionnaire_context` VALUES (784, '2', 159, 173, 1);
INSERT INTO `t_questionnaire_context` VALUES (785, '2', 159, 173, 1);
INSERT INTO `t_questionnaire_context` VALUES (786, '2', 159, 173, 1);
INSERT INTO `t_questionnaire_context` VALUES (787, '1', 160, 174, 1);
INSERT INTO `t_questionnaire_context` VALUES (788, '1', 160, 174, 1);
INSERT INTO `t_questionnaire_context` VALUES (789, '1', 160, 174, 1);
INSERT INTO `t_questionnaire_context` VALUES (790, '1', 160, 174, 1);
INSERT INTO `t_questionnaire_context` VALUES (791, '1', 161, 175, 1);
INSERT INTO `t_questionnaire_context` VALUES (792, '1', 161, 175, 1);
INSERT INTO `t_questionnaire_context` VALUES (793, '1', 161, 175, 1);
INSERT INTO `t_questionnaire_context` VALUES (794, '1', 161, 175, 1);
INSERT INTO `t_questionnaire_context` VALUES (795, '1', 162, 176, 1);
INSERT INTO `t_questionnaire_context` VALUES (796, '1', 162, 176, 1);
INSERT INTO `t_questionnaire_context` VALUES (797, '1', 162, 176, 1);
INSERT INTO `t_questionnaire_context` VALUES (798, '1', 162, 176, 1);
INSERT INTO `t_questionnaire_context` VALUES (799, '2', 163, 177, 1);
INSERT INTO `t_questionnaire_context` VALUES (800, '2', 163, 177, 1);
INSERT INTO `t_questionnaire_context` VALUES (801, '2', 163, 177, 1);
INSERT INTO `t_questionnaire_context` VALUES (802, '2', 163, 177, 1);
INSERT INTO `t_questionnaire_context` VALUES (803, '3', 164, 178, 1);
INSERT INTO `t_questionnaire_context` VALUES (804, '3', 164, 178, 1);
INSERT INTO `t_questionnaire_context` VALUES (805, '3', 164, 178, 1);
INSERT INTO `t_questionnaire_context` VALUES (806, '3', 164, 178, 1);
INSERT INTO `t_questionnaire_context` VALUES (807, '1', 165, 179, 1);
INSERT INTO `t_questionnaire_context` VALUES (808, '1', 165, 179, 1);
INSERT INTO `t_questionnaire_context` VALUES (809, '1', 165, 179, 1);
INSERT INTO `t_questionnaire_context` VALUES (810, '1', 165, 179, 1);
INSERT INTO `t_questionnaire_context` VALUES (811, '2', 166, 180, 1);
INSERT INTO `t_questionnaire_context` VALUES (812, '2', 166, 180, 1);
INSERT INTO `t_questionnaire_context` VALUES (813, '2', 166, 180, 1);
INSERT INTO `t_questionnaire_context` VALUES (814, '2', 166, 180, 1);
INSERT INTO `t_questionnaire_context` VALUES (815, '3', 167, 181, 1);
INSERT INTO `t_questionnaire_context` VALUES (816, '3', 167, 181, 1);
INSERT INTO `t_questionnaire_context` VALUES (817, '3', 167, 181, 1);
INSERT INTO `t_questionnaire_context` VALUES (818, '3', 167, 181, 1);
INSERT INTO `t_questionnaire_context` VALUES (819, '4', 168, 182, 1);
INSERT INTO `t_questionnaire_context` VALUES (820, '4', 168, 182, 1);
INSERT INTO `t_questionnaire_context` VALUES (821, '4', 168, 182, 1);
INSERT INTO `t_questionnaire_context` VALUES (822, '4', 168, 182, 1);
INSERT INTO `t_questionnaire_context` VALUES (823, '5', 169, 183, 1);
INSERT INTO `t_questionnaire_context` VALUES (824, '5', 169, 183, 1);
INSERT INTO `t_questionnaire_context` VALUES (825, '5', 169, 183, 1);
INSERT INTO `t_questionnaire_context` VALUES (826, '5', 169, 183, 1);
INSERT INTO `t_questionnaire_context` VALUES (827, '6', 170, 184, 1);
INSERT INTO `t_questionnaire_context` VALUES (828, '6', 170, 184, 1);
INSERT INTO `t_questionnaire_context` VALUES (829, '6', 170, 184, 1);
INSERT INTO `t_questionnaire_context` VALUES (830, '6', 170, 184, 1);
INSERT INTO `t_questionnaire_context` VALUES (831, '7', 171, 185, 1);
INSERT INTO `t_questionnaire_context` VALUES (832, '7', 171, 185, 1);
INSERT INTO `t_questionnaire_context` VALUES (833, '7', 171, 185, 1);
INSERT INTO `t_questionnaire_context` VALUES (834, '7', 171, 185, 1);
INSERT INTO `t_questionnaire_context` VALUES (835, '8', 172, 186, 1);
INSERT INTO `t_questionnaire_context` VALUES (836, '8', 172, 186, 1);
INSERT INTO `t_questionnaire_context` VALUES (837, '8', 172, 186, 1);
INSERT INTO `t_questionnaire_context` VALUES (838, '8', 172, 186, 1);
INSERT INTO `t_questionnaire_context` VALUES (839, '1', 173, 187, 1);
INSERT INTO `t_questionnaire_context` VALUES (840, '1', 173, 187, 1);
INSERT INTO `t_questionnaire_context` VALUES (841, '1', 173, 187, 1);
INSERT INTO `t_questionnaire_context` VALUES (842, '1', 173, 187, 1);
INSERT INTO `t_questionnaire_context` VALUES (843, '2', 174, 188, 1);
INSERT INTO `t_questionnaire_context` VALUES (844, '2', 174, 188, 1);
INSERT INTO `t_questionnaire_context` VALUES (845, '2', 174, 188, 1);
INSERT INTO `t_questionnaire_context` VALUES (846, '2', 174, 188, 1);
INSERT INTO `t_questionnaire_context` VALUES (847, '3', 175, 189, 1);
INSERT INTO `t_questionnaire_context` VALUES (848, '3', 175, 189, 1);
INSERT INTO `t_questionnaire_context` VALUES (849, '3', 175, 189, 1);
INSERT INTO `t_questionnaire_context` VALUES (850, '3', 175, 189, 1);
INSERT INTO `t_questionnaire_context` VALUES (851, '4', 176, 190, 1);
INSERT INTO `t_questionnaire_context` VALUES (852, '4', 176, 190, 1);
INSERT INTO `t_questionnaire_context` VALUES (853, '4', 176, 190, 1);
INSERT INTO `t_questionnaire_context` VALUES (854, '4', 176, 190, 1);
INSERT INTO `t_questionnaire_context` VALUES (855, '5', 177, 191, 1);
INSERT INTO `t_questionnaire_context` VALUES (856, '5', 177, 191, 1);
INSERT INTO `t_questionnaire_context` VALUES (857, '5', 177, 191, 1);
INSERT INTO `t_questionnaire_context` VALUES (858, '5', 177, 191, 1);
INSERT INTO `t_questionnaire_context` VALUES (859, '1', 178, 192, 1);
INSERT INTO `t_questionnaire_context` VALUES (860, '1', 178, 192, 1);
INSERT INTO `t_questionnaire_context` VALUES (861, '1', 178, 192, 1);
INSERT INTO `t_questionnaire_context` VALUES (862, '1', 178, 192, 1);
INSERT INTO `t_questionnaire_context` VALUES (863, '2', 179, 193, 1);
INSERT INTO `t_questionnaire_context` VALUES (864, '2', 179, 193, 1);
INSERT INTO `t_questionnaire_context` VALUES (865, '2', 179, 193, 1);
INSERT INTO `t_questionnaire_context` VALUES (866, '2', 179, 193, 1);
INSERT INTO `t_questionnaire_context` VALUES (867, '3', 180, 194, 1);
INSERT INTO `t_questionnaire_context` VALUES (868, '3', 180, 194, 1);
INSERT INTO `t_questionnaire_context` VALUES (869, '3', 180, 194, 1);
INSERT INTO `t_questionnaire_context` VALUES (870, '3', 180, 194, 1);
INSERT INTO `t_questionnaire_context` VALUES (871, '4', 181, 195, 1);
INSERT INTO `t_questionnaire_context` VALUES (872, '4', 181, 195, 1);
INSERT INTO `t_questionnaire_context` VALUES (873, '4', 181, 195, 1);
INSERT INTO `t_questionnaire_context` VALUES (874, '4', 181, 195, 1);
INSERT INTO `t_questionnaire_context` VALUES (875, '5', 182, 196, 1);
INSERT INTO `t_questionnaire_context` VALUES (876, '5', 182, 196, 1);
INSERT INTO `t_questionnaire_context` VALUES (877, '5', 182, 196, 1);
INSERT INTO `t_questionnaire_context` VALUES (878, '5', 182, 196, 1);
INSERT INTO `t_questionnaire_context` VALUES (879, '1', 183, 197, 1);
INSERT INTO `t_questionnaire_context` VALUES (880, '1', 183, 197, 1);
INSERT INTO `t_questionnaire_context` VALUES (881, '1', 183, 197, 1);
INSERT INTO `t_questionnaire_context` VALUES (882, '1', 183, 197, 1);
INSERT INTO `t_questionnaire_context` VALUES (883, '2', 184, 198, 1);
INSERT INTO `t_questionnaire_context` VALUES (884, '2', 184, 198, 1);
INSERT INTO `t_questionnaire_context` VALUES (885, '2', 184, 198, 1);
INSERT INTO `t_questionnaire_context` VALUES (886, '2', 184, 198, 1);
INSERT INTO `t_questionnaire_context` VALUES (887, '1', 185, 199, 1);
INSERT INTO `t_questionnaire_context` VALUES (888, '1', 185, 199, 1);
INSERT INTO `t_questionnaire_context` VALUES (889, '1', 185, 199, 1);
INSERT INTO `t_questionnaire_context` VALUES (890, '1', 185, 199, 1);
INSERT INTO `t_questionnaire_context` VALUES (891, '1', 186, 200, 1);
INSERT INTO `t_questionnaire_context` VALUES (892, '1', 186, 200, 1);
INSERT INTO `t_questionnaire_context` VALUES (893, '1', 186, 200, 1);
INSERT INTO `t_questionnaire_context` VALUES (894, '1', 186, 200, 1);
INSERT INTO `t_questionnaire_context` VALUES (895, '2', 187, 201, 1);
INSERT INTO `t_questionnaire_context` VALUES (896, '2', 187, 201, 1);
INSERT INTO `t_questionnaire_context` VALUES (897, '2', 187, 201, 1);
INSERT INTO `t_questionnaire_context` VALUES (898, '2', 187, 201, 1);
INSERT INTO `t_questionnaire_context` VALUES (899, '2', 188, 202, 1);
INSERT INTO `t_questionnaire_context` VALUES (900, '2', 188, 202, 1);
INSERT INTO `t_questionnaire_context` VALUES (901, '2', 188, 202, 1);
INSERT INTO `t_questionnaire_context` VALUES (902, '2', 188, 202, 1);
INSERT INTO `t_questionnaire_context` VALUES (903, '2', 189, 203, 1);
INSERT INTO `t_questionnaire_context` VALUES (904, '2', 189, 203, 1);
INSERT INTO `t_questionnaire_context` VALUES (905, '2', 189, 203, 1);
INSERT INTO `t_questionnaire_context` VALUES (906, '2', 189, 203, 1);
INSERT INTO `t_questionnaire_context` VALUES (907, '1', 190, 204, 1);
INSERT INTO `t_questionnaire_context` VALUES (908, '1', 190, 204, 1);
INSERT INTO `t_questionnaire_context` VALUES (909, '1', 190, 204, 1);
INSERT INTO `t_questionnaire_context` VALUES (910, '1', 190, 204, 1);
INSERT INTO `t_questionnaire_context` VALUES (911, '2', 191, 205, 1);
INSERT INTO `t_questionnaire_context` VALUES (912, '2', 191, 205, 1);
INSERT INTO `t_questionnaire_context` VALUES (913, '2', 191, 205, 1);
INSERT INTO `t_questionnaire_context` VALUES (914, '2', 191, 205, 1);
INSERT INTO `t_questionnaire_context` VALUES (915, '1', 192, 206, 1);
INSERT INTO `t_questionnaire_context` VALUES (916, '1', 192, 206, 1);
INSERT INTO `t_questionnaire_context` VALUES (917, '1', 192, 206, 1);
INSERT INTO `t_questionnaire_context` VALUES (918, '1', 192, 206, 1);
INSERT INTO `t_questionnaire_context` VALUES (919, '1', 193, 207, 1);
INSERT INTO `t_questionnaire_context` VALUES (920, '1', 193, 207, 1);
INSERT INTO `t_questionnaire_context` VALUES (921, '1', 193, 207, 1);
INSERT INTO `t_questionnaire_context` VALUES (922, '1', 193, 207, 1);
INSERT INTO `t_questionnaire_context` VALUES (923, '1', 194, 208, 1);
INSERT INTO `t_questionnaire_context` VALUES (924, '1', 194, 208, 1);
INSERT INTO `t_questionnaire_context` VALUES (925, '1', 194, 208, 1);
INSERT INTO `t_questionnaire_context` VALUES (926, '1', 194, 208, 1);
INSERT INTO `t_questionnaire_context` VALUES (927, '1', 195, 209, 1);
INSERT INTO `t_questionnaire_context` VALUES (928, '1', 195, 209, 1);
INSERT INTO `t_questionnaire_context` VALUES (929, '1', 195, 209, 1);
INSERT INTO `t_questionnaire_context` VALUES (930, '1', 195, 209, 1);
INSERT INTO `t_questionnaire_context` VALUES (931, '1', 196, 210, 1);
INSERT INTO `t_questionnaire_context` VALUES (932, '1', 196, 210, 1);
INSERT INTO `t_questionnaire_context` VALUES (933, '1', 196, 210, 1);
INSERT INTO `t_questionnaire_context` VALUES (934, '1', 196, 210, 1);
INSERT INTO `t_questionnaire_context` VALUES (935, '1', 197, 211, 1);
INSERT INTO `t_questionnaire_context` VALUES (936, '1', 197, 211, 1);
INSERT INTO `t_questionnaire_context` VALUES (937, '1', 197, 211, 1);
INSERT INTO `t_questionnaire_context` VALUES (938, '1', 197, 211, 1);
INSERT INTO `t_questionnaire_context` VALUES (939, '1', 198, 212, 1);
INSERT INTO `t_questionnaire_context` VALUES (940, '1', 198, 212, 1);
INSERT INTO `t_questionnaire_context` VALUES (941, '1', 198, 212, 1);
INSERT INTO `t_questionnaire_context` VALUES (942, '1', 198, 212, 1);
INSERT INTO `t_questionnaire_context` VALUES (943, '1', 199, 213, 1);
INSERT INTO `t_questionnaire_context` VALUES (944, '1', 199, 213, 1);
INSERT INTO `t_questionnaire_context` VALUES (945, '1', 199, 213, 1);
INSERT INTO `t_questionnaire_context` VALUES (946, '1', 199, 213, 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 214 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_questionnaire_context_title
-- ----------------------------
INSERT INTO `t_questionnaire_context_title` VALUES (130, '1', 119, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (131, '1', 120, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (132, '1', 121, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (133, '1', 122, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (134, '2', 123, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (135, '1', 124, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (136, '11', 125, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (137, '1', 126, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (138, '1', 127, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (139, '1', 128, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (140, '1', 129, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (141, '11', 130, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (142, '1', 131, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (143, '1', 132, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (144, '1', 133, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (145, '1', 134, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (146, '1', 135, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (147, '2', 135, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (148, '1', 136, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (149, '1', 137, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (150, '基本数据类型', 138, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (151, '哪些是NoSql', 138, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (152, '1', 139, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (153, '1', 140, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (154, '的', 141, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (155, '123', 142, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (156, '123', 143, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (157, '123', 144, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (158, '1', 145, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (159, '1', 146, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (160, 'q', 147, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (161, 'q', 148, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (162, 'q', 149, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (163, 'q', 149, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (164, 'q', 150, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (165, 'q', 151, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (166, '1', 152, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (167, '1', 153, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (168, '1', 154, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (169, '1', 155, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (170, '1', 156, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (171, '1', 157, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (172, '1', 158, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (173, '33', 159, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (174, '1', 160, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (175, '11', 161, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (176, '1', 162, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (177, '2', 163, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (178, '3', 164, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (179, '1', 165, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (180, '2', 166, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (181, '3', 167, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (182, '4', 168, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (183, '5', 169, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (184, '6', 170, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (185, '7', 171, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (186, '8', 172, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (187, '1', 173, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (188, '2', 174, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (189, '3', 175, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (190, '4', 176, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (191, '5', 177, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (192, '1', 178, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (193, '2', 179, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (194, '3', 180, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (195, '4', 181, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (196, '5', 182, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (197, '1', 183, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (198, '2', 184, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (199, '1', 185, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (200, '1', 186, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (201, '2', 187, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (202, '2', 188, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (203, '2', 189, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (204, '1', 190, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (205, '2', 191, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (206, '1', 192, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (207, '1', 193, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (208, '1', 194, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (209, '1', 195, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (210, '1', 196, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (211, '1', 197, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (212, '1', 198, 1);
INSERT INTO `t_questionnaire_context_title` VALUES (213, '1', 199, 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES (3, '喻湘东', 'yxd520', '9281e5dc4ffc80a9baf8d2071154badc', '2240170192@qq.com', 1);

-- ----------------------------
-- Table structure for t_submit_questionnaire
-- ----------------------------
DROP TABLE IF EXISTS `t_submit_questionnaire`;
CREATE TABLE `t_submit_questionnaire`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `questionnaire_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `questionnaire_title_id` int(11) NULL DEFAULT NULL,
  `questionnaire_context_id` int(11) NULL DEFAULT NULL,
  `submit_state` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_submit_questionnaire
-- ----------------------------
INSERT INTO `t_submit_questionnaire` VALUES (19, 138, 3, NULL, 691, 1);
INSERT INTO `t_submit_questionnaire` VALUES (20, 138, 3, NULL, 692, 1);
INSERT INTO `t_submit_questionnaire` VALUES (21, 138, 3, NULL, 695, 1);
INSERT INTO `t_submit_questionnaire` VALUES (22, 138, 3, NULL, 697, 1);
INSERT INTO `t_submit_questionnaire` VALUES (23, 137, 3, NULL, 687, 1);
INSERT INTO `t_submit_questionnaire` VALUES (24, 196, 3, NULL, 931, 1);
INSERT INTO `t_submit_questionnaire` VALUES (25, 196, 3, NULL, 932, 1);
INSERT INTO `t_submit_questionnaire` VALUES (26, 196, 3, NULL, 933, 1);
INSERT INTO `t_submit_questionnaire` VALUES (27, 198, 3, NULL, 939, 1);
INSERT INTO `t_submit_questionnaire` VALUES (28, 198, 3, NULL, 940, 1);
INSERT INTO `t_submit_questionnaire` VALUES (29, 198, 3, NULL, 941, 1);
INSERT INTO `t_submit_questionnaire` VALUES (30, 198, 3, NULL, 942, 1);
INSERT INTO `t_submit_questionnaire` VALUES (31, 194, 3, NULL, 923, 1);

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
-- Records of t_teacher_questionnaire_student
-- ----------------------------
INSERT INTO `t_teacher_questionnaire_student` VALUES (4, 6, 123, 3, 0);
INSERT INTO `t_teacher_questionnaire_student` VALUES (5, 6, 122, 3, 0);
INSERT INTO `t_teacher_questionnaire_student` VALUES (6, 6, 124, 3, 0);
INSERT INTO `t_teacher_questionnaire_student` VALUES (7, 6, 125, 3, 0);
INSERT INTO `t_teacher_questionnaire_student` VALUES (8, 6, 126, 3, 0);
INSERT INTO `t_teacher_questionnaire_student` VALUES (9, 6, 127, 3, 0);
INSERT INTO `t_teacher_questionnaire_student` VALUES (10, 6, 128, 3, 0);
INSERT INTO `t_teacher_questionnaire_student` VALUES (11, 6, 129, 3, 0);
INSERT INTO `t_teacher_questionnaire_student` VALUES (12, 6, 130, 3, 0);
INSERT INTO `t_teacher_questionnaire_student` VALUES (13, 6, 131, 3, 0);
INSERT INTO `t_teacher_questionnaire_student` VALUES (14, 6, 132, 3, 0);
INSERT INTO `t_teacher_questionnaire_student` VALUES (15, 6, 133, 3, 0);
INSERT INTO `t_teacher_questionnaire_student` VALUES (16, 6, 134, 3, 0);
INSERT INTO `t_teacher_questionnaire_student` VALUES (17, 6, 135, 3, 0);
INSERT INTO `t_teacher_questionnaire_student` VALUES (18, 6, 136, 3, 0);
INSERT INTO `t_teacher_questionnaire_student` VALUES (19, 6, 137, 3, 0);
INSERT INTO `t_teacher_questionnaire_student` VALUES (20, 6, 138, 3, 0);

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
