/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : pms

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 11/03/2019 10:07:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bug
-- ----------------------------
DROP TABLE IF EXISTS `bug`;
CREATE TABLE `bug`  (
  `id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `addtime` datetime(0) NOT NULL COMMENT '创建时间',
  `updatetime` datetime(0) NOT NULL COMMENT '更新时间',
  `project_id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目id',
  `is_noprocessing` tinyint(3) UNSIGNED NOT NULL COMMENT '是否不予处理',
  `bug_status` tinyint(3) UNSIGNED NOT NULL COMMENT 'bug状态',
  `bug_title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'bug详情',
  `bug_content` varchar(4500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'bug描述',
  `bug_proposer` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '提出bug用户的id',
  `bug_processer` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '处理bug用户的id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'bug表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bug
-- ----------------------------
INSERT INTO `bug` VALUES ('0RK1WrXbJPBP', '2019-03-07 17:40:26', '2019-03-08 15:51:17', '0RJKxY2oMnpL', 0, 0, '这是一个bug', '<p style=\"\">啊实打实的阿瑟东阿瑟东阿三</p>', '0RJtVRByNyjL', '0RJpq3vXMd0m');
INSERT INTO `bug` VALUES ('0RKMnl2OOmVL', '2019-03-11 08:59:16', '2019-03-11 09:02:34', '0RJKxY2oMnpL', 1, 3, '这是一个测试bug', '<p style=\"\">bug信息信息信息<span style=\"color: rgb(51, 51, 51);\">bug信息信息信息</span><span style=\"color: rgb(51, 51, 51);\">bug信息信息信息</span><span style=\"color: rgb(51, 51, 51);\">bug信息信息信息</span><span style=\"color: rgb(51, 51, 51);\">bug信息信息信息</span><span style=\"color: rgb(51, 51, 51);\">bug信息信息信息</span><span style=\"color: rgb(51, 51, 51);\">bug信息信息信息</span><span style=\"color: rgb(51, 51, 51);\">bug信息</span></p>', '0RJpq3vXMd0m', '0RJpq3vXMd0m');
INSERT INTO `bug` VALUES ('0RKMqLmdQAch', '2019-03-11 09:09:34', '2019-03-11 09:15:46', '0RJKxY2oMnpL', 0, 0, '第二个测试', '<p><span style=\"color: rgb(51, 51, 51);\">这是bug！！！</span><span style=\"color: rgb(51, 51, 51);\">这是bug！！！</span><span style=\"color: rgb(51, 51, 51);\">这是bug！！！</span><span style=\"color: rgb(51, 51, 51);\">这是bug！！！</span><span style=\"color: rgb(51, 51, 51);\">这是bug！！！</span><span style=\"color: rgb(51, 51, 51);\">这是bug！！！</span><span style=\"color: rgb(51, 51, 51);\">这是bug！！！</span><span style=\"color: rgb(51, 51, 51);\">这是bug！！！</span><span style=\"color: rgb(51, 51, 51);\">这是bug！！！</span><span style=\"color: rgb(51, 51, 51);\">这是bug！！！</span><span style=\"color: rgb(51, 51, 51);\">这是bug！！！</span><span style=\"color: rgb(51, 51, 51);\">这是bug！！！</span><span style=\"color: rgb(51, 51, 51);\">这是bug！！！</span><span style=\"color: rgb(51, 51, 51);\">这是bug！！！</span><span style=\"color: rgb(51, 51, 51);\">这是bug！！！</span><span style=\"color: rgb(51, 51, 51);\">这是bug！！！</span><span style=\"color: rgb(51, 51, 51);\">这是bug！！！</span><br></p>', '0RJpq3vXMd0m', '0RJtVRByNyjL');

-- ----------------------------
-- Table structure for bug_description
-- ----------------------------
DROP TABLE IF EXISTS `bug_description`;
CREATE TABLE `bug_description`  (
  `id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `addtime` datetime(0) NOT NULL COMMENT '创建时间',
  `updatetime` datetime(0) NOT NULL COMMENT '更新时间',
  `bug_id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'bug id',
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '说明内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'bug说明表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bug_description
-- ----------------------------
INSERT INTO `bug_description` VALUES ('0RKMoIfwQ4Ko', '2019-03-11 09:01:25', '2019-03-11 09:01:25', '0RKMnl2OOmVL', '说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明');

-- ----------------------------
-- Table structure for bug_operating_record
-- ----------------------------
DROP TABLE IF EXISTS `bug_operating_record`;
CREATE TABLE `bug_operating_record`  (
  `id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `addtime` datetime(0) NOT NULL COMMENT '创建时间',
  `updatetime` datetime(0) NOT NULL COMMENT '更新时间',
  `user_id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作者id',
  `operation_number` tinyint(3) UNSIGNED NOT NULL COMMENT '0.指派 1.设置自己处理2.设置不予处理3.添加说明4.关闭Bug',
  `bug_id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'bug id',
  `operation_user_id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作对象id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'bug操作记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bug_operating_record
-- ----------------------------
INSERT INTO `bug_operating_record` VALUES ('0RK1Uxk5K6gg', '2019-03-07 17:32:53', '2019-03-07 17:32:53', '0RJA8qMVJNCF', 0, '0RK1UxjvK89s', '0RK1PBA2KpQt');
INSERT INTO `bug_operating_record` VALUES ('0RK1V4SoK6j0', '2019-03-07 17:33:19', '2019-03-07 17:33:19', '0RJA8qMVJNCF', 0, '0RK1V4SaKd1X', '0RJpq3vXMd0m');
INSERT INTO `bug_operating_record` VALUES ('0RK1V61gOErr', '2019-03-07 17:33:25', '2019-03-07 17:33:25', '0RJA8qMVJNCF', 0, '0RK1V61TOoy7', '0RJpq3vXMd0m');
INSERT INTO `bug_operating_record` VALUES ('0RK1WrXpJRtJ', '2019-03-07 17:40:26', '2019-03-07 17:40:26', '0RJtVRByNyjL', 0, '0RK1WrXbJPBP', '0RJpq3vXMd0m');
INSERT INTO `bug_operating_record` VALUES ('0RK6slDlK6h1', '2019-03-08 15:38:47', '2019-03-08 15:38:47', '0RJtVRByNyjL', 0, '0RK1WrXbJPBP', '0RK1PBA2KpQt');
INSERT INTO `bug_operating_record` VALUES ('0RK6tRS0Oe3V', '2019-03-08 15:41:29', '2019-03-08 15:41:29', '0RJtVRByNyjL', 1, '0RK1WrXbJPBP', '');
INSERT INTO `bug_operating_record` VALUES ('0RK6vkYJSIWR', '2019-03-08 15:50:39', '2019-03-08 15:50:39', '0RJtVRByNyjL', 2, '0RK1WrXbJPBP', '');
INSERT INTO `bug_operating_record` VALUES ('0RK6vuNIOn8b', '2019-03-08 15:51:17', '2019-03-08 15:51:17', '0RJtVRByNyjL', 0, '0RK1WrXbJPBP', '0RJpq3vXMd0m');
INSERT INTO `bug_operating_record` VALUES ('0RKMnl2aOwAd', '2019-03-11 08:59:16', '2019-03-11 08:59:16', '0RJpq3vXMd0m', 0, '0RKMnl2OOmVL', '0RJtVRByNyjL');
INSERT INTO `bug_operating_record` VALUES ('0RKMoadiJqaL', '2019-03-11 09:02:34', '2019-03-11 09:02:34', '0RJpq3vXMd0m', 4, '0RKMnl2OOmVL', '');
INSERT INTO `bug_operating_record` VALUES ('0RKMoFqKNd4i', '2019-03-11 09:01:14', '2019-03-11 09:01:14', '0RJtVRByNyjL', 1, '0RKMnl2OOmVL', '');
INSERT INTO `bug_operating_record` VALUES ('0RKMoIg6QRBO', '2019-03-11 09:01:25', '2019-03-11 09:01:25', '0RJtVRByNyjL', 3, '0RKMnl2OOmVL', '');
INSERT INTO `bug_operating_record` VALUES ('0RKMoZ0aReGD', '2019-03-11 09:02:28', '2019-03-11 09:02:28', '0RJpq3vXMd0m', 0, '0RKMnl2OOmVL', '0RJpq3vXMd0m');
INSERT INTO `bug_operating_record` VALUES ('0RKMoZaLN0Vu', '2019-03-11 09:02:30', '2019-03-11 09:02:30', '0RJpq3vXMd0m', 1, '0RKMnl2OOmVL', '');
INSERT INTO `bug_operating_record` VALUES ('0RKMoZruQ2CW', '2019-03-11 09:02:31', '2019-03-11 09:02:31', '0RJpq3vXMd0m', 2, '0RKMnl2OOmVL', '');
INSERT INTO `bug_operating_record` VALUES ('0RKMqLmnQWZZ', '2019-03-11 09:09:34', '2019-03-11 09:09:34', '0RJpq3vXMd0m', 0, '0RKMqLmdQAch', '0RJpq3vXMd0m');
INSERT INTO `bug_operating_record` VALUES ('0RKMrulOQPOx', '2019-03-11 09:15:46', '2019-03-11 09:15:46', '0RJpq3vXMd0m', 0, '0RKMqLmdQAch', '0RJtVRByNyjL');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `addtime` datetime(0) NOT NULL COMMENT '创建时间',
  `updatetime` datetime(0) NOT NULL COMMENT '更新时间',
  `department_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('0RIss2SAVU7n', '2019-02-23 15:39:13', '2019-02-23 15:39:13', '研发部');

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log`  (
  `id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `addtime` datetime(0) NOT NULL COMMENT '创建时间',
  `updatetime` datetime(0) NOT NULL COMMENT '更新时间',
  `user_id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录用户id',
  `ip` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登陆的ip地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '登录日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of login_log
-- ----------------------------
INSERT INTO `login_log` VALUES ('0RK6dITCLT5S', '2019-03-08 14:37:21', '2019-03-08 14:37:21', '0RJpq3vXMd0m', '0:0:0:0:0:0:0:1');
INSERT INTO `login_log` VALUES ('0RK6l3EhJb9q', '2019-03-08 15:08:09', '2019-03-08 15:08:09', '0RJpq3vXMd0m', '0:0:0:0:0:0:0:1');
INSERT INTO `login_log` VALUES ('0RK6n7XdOeH9', '2019-03-08 15:16:22', '2019-03-08 15:16:22', '0RJpq3vXMd0m', '0:0:0:0:0:0:0:1');
INSERT INTO `login_log` VALUES ('0RK6QeRQOpFh', '2019-03-08 13:47:07', '2019-03-08 13:47:07', '0RJpq3vXMd0m', '0:0:0:0:0:0:0:1');
INSERT INTO `login_log` VALUES ('0RK6tNSBKmBW', '2019-03-08 15:41:14', '2019-03-08 15:41:14', '0RK1PBA2KpQt', '0:0:0:0:0:0:0:1');
INSERT INTO `login_log` VALUES ('0RK6uFAbJqfR', '2019-03-08 15:44:40', '2019-03-08 15:44:40', '0RJpq3vXMd0m', '0:0:0:0:0:0:0:1');
INSERT INTO `login_log` VALUES ('0RK6vgcVJGTB', '2019-03-08 15:50:24', '2019-03-08 15:50:24', '0RK1PBA2KpQt', '0:0:0:0:0:0:0:1');
INSERT INTO `login_log` VALUES ('0RK6vqPPSisH', '2019-03-08 15:51:02', '2019-03-08 15:51:02', '0RJtVRByNyjL', '0:0:0:0:0:0:0:1');
INSERT INTO `login_log` VALUES ('0RK6vwnSQkcb', '2019-03-08 15:51:26', '2019-03-08 15:51:26', '0RJpq3vXMd0m', '0:0:0:0:0:0:0:1');
INSERT INTO `login_log` VALUES ('0RK6xiGFJI4b', '2019-03-08 15:58:27', '2019-03-08 15:58:27', '0RK1PBA2KpQt', '0:0:0:0:0:0:0:1');
INSERT INTO `login_log` VALUES ('0RK6xkkNJjyb', '2019-03-08 15:58:36', '2019-03-08 15:58:36', '0RJpq3vXMd0m', '0:0:0:0:0:0:0:1');
INSERT INTO `login_log` VALUES ('0RKMjuWUVmqz', '2019-03-11 08:43:59', '2019-03-11 08:43:59', '0RJpq3vXMd0m', '0:0:0:0:0:0:0:1');
INSERT INTO `login_log` VALUES ('0RKMmz9BS4n2', '2019-03-11 08:56:12', '2019-03-11 08:56:12', '0RJpq3vXMd0m', '0:0:0:0:0:0:0:1');
INSERT INTO `login_log` VALUES ('0RKMnEBPSVeG', '2019-03-11 08:57:09', '2019-03-11 08:57:09', '0RJpq3vXMd0m', '0:0:0:0:0:0:0:1');
INSERT INTO `login_log` VALUES ('0RKMnZoPJW7G', '2019-03-11 08:58:33', '2019-03-11 08:58:33', '0RJpq3vXMd0m', '0:0:0:0:0:0:0:1');
INSERT INTO `login_log` VALUES ('0RKMoDGYNrgg', '2019-03-11 09:01:04', '2019-03-11 09:01:04', '0RJtVRByNyjL', '0:0:0:0:0:0:0:1');
INSERT INTO `login_log` VALUES ('0RKMoMviQYSY', '2019-03-11 09:01:41', '2019-03-11 09:01:41', '0RJpq3vXMd0m', '0:0:0:0:0:0:0:1');
INSERT INTO `login_log` VALUES ('0RKMtg8NIF0a', '2019-03-11 09:22:47', '2019-03-11 09:22:47', '0RJpq3vXMd0m', '0:0:0:0:0:0:0:1');

-- ----------------------------
-- Table structure for need
-- ----------------------------
DROP TABLE IF EXISTS `need`;
CREATE TABLE `need`  (
  `id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `addtime` datetime(0) NOT NULL COMMENT '创建时间',
  `updatetime` datetime(0) NOT NULL COMMENT '更新时间',
  `need_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '需求名',
  `need_description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '需求的文字描述',
  `need_description_filepath` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '需求描述文件地址',
  `need_description_filename` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '需求描述文件文件名',
  `need_filepath` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '需求文件地址',
  `need_filename` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '需求文件文件名',
  `user_id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '提出需求的用户id',
  `project_id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目Id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '需求表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of need
-- ----------------------------
INSERT INTO `need` VALUES ('0RK1XxLwKgZt', '2019-03-07 17:44:47', '2019-03-07 17:44:47', '这是一个需求', '需求需求绣球', '\\needFile\\0RK1XxLwKgZt\\实习单位接收证明1.doc', '实习单位接收证明1.doc', '\\needFile\\0RK1XxLwKgZt\\jf.zip', 'jf.zip', '0RJpq3vXMd0m', '0RJKxY2oMnpL');
INSERT INTO `need` VALUES ('0RKMtrT2PVCC', '2019-03-11 09:23:30', '2019-03-11 09:23:30', '需求测试1', '这是一个需求!这是一个需求!这是一个需求!这是一个需求!这是一个需求!这是一个需求!这是一个需求!这是一个需求!这是一个需求!这是一个需求!这是一个需求!这是一个需求!这是一个需求!这是一个需求!这是一个需求!这是一个需求!这是一个需求!', '\\needFile\\0RKMtrT2PVCC\\实习单位接收证明1.doc', '实习单位接收证明1.doc', '\\needFile\\0RKMtrT2PVCC\\jf.zip', 'jf.zip', '0RJpq3vXMd0m', '0RJL0jTeL1Rs');

-- ----------------------------
-- Table structure for premission
-- ----------------------------
DROP TABLE IF EXISTS `premission`;
CREATE TABLE `premission`  (
  `id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `addtime` datetime(0) NOT NULL COMMENT '创建时间',
  `updatetime` datetime(0) NOT NULL COMMENT '更新时间',
  `premission_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限名',
  `premission_field` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限字段',
  `is_menu` tinyint(3) UNSIGNED NOT NULL COMMENT '是否菜单',
  `parent_id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '父级菜单id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of premission
-- ----------------------------
INSERT INTO `premission` VALUES ('0RJv6UEeJsHi', '2019-03-06 15:18:02', '2019-03-06 15:18:02', '用户系统', 'user', 1, '');
INSERT INTO `premission` VALUES ('0RJv9CfWO6RM', '2019-03-06 15:28:49', '2019-03-06 16:02:31', '产品', 'product', 1, '');
INSERT INTO `premission` VALUES ('0RJv9dWcNXGQ', '2019-03-06 15:30:33', '2019-03-06 15:30:33', '部门管理', 'user:department', 1, '0RJv6UEeJsHi');
INSERT INTO `premission` VALUES ('0RJvAOEbNZFl', '2019-03-06 15:33:32', '2019-03-06 15:33:32', '添加部门', 'user:department:add', 0, '0RJv9dWcNXGQ');
INSERT INTO `premission` VALUES ('0RK1LAUiK5wY', '2019-03-07 16:53:59', '2019-03-07 16:53:59', '修改部门', 'user:department:update', 0, '0RJv9dWcNXGQ');
INSERT INTO `premission` VALUES ('0RK1LMElNDsx', '2019-03-07 16:54:44', '2019-03-07 16:54:44', '删除部门', 'user:department:delete', 0, '0RJv9dWcNXGQ');
INSERT INTO `premission` VALUES ('0RK1LmnLOkB1', '2019-03-07 16:56:26', '2019-03-07 16:56:26', '用户管理', 'user:user', 1, '0RJv6UEeJsHi');
INSERT INTO `premission` VALUES ('0RK1M7PdMKEg', '2019-03-07 16:57:45', '2019-03-07 16:57:56', '添加用户', 'user:user:add', 0, '0RK1LmnLOkB1');
INSERT INTO `premission` VALUES ('0RK1PRkRNHPQ', '2019-03-07 17:10:59', '2019-03-07 17:10:59', '修改用户', 'user:user:update', 0, '0RK1LmnLOkB1');
INSERT INTO `premission` VALUES ('0RK1PsijNB9G', '2019-03-07 17:12:42', '2019-03-07 17:12:42', '角色管理', 'user:role', 1, '0RJv6UEeJsHi');
INSERT INTO `premission` VALUES ('0RK1PVPINvYW', '2019-03-07 17:11:13', '2019-03-07 17:11:13', '删除用户', 'user:user:delete', 0, '0RK1LmnLOkB1');
INSERT INTO `premission` VALUES ('0RK1Q531Rvcc', '2019-03-07 17:13:30', '2019-03-07 17:14:03', '添加角色', 'user:role:add', 0, '0RK1PsijNB9G');
INSERT INTO `premission` VALUES ('0RK1Q7V1ON8m', '2019-03-07 17:13:39', '2019-03-07 17:14:10', '删除角色', 'user:role:delete', 0, '0RK1PsijNB9G');
INSERT INTO `premission` VALUES ('0RK1QaPJMTWJ', '2019-03-07 17:15:30', '2019-03-07 17:15:30', '添加权限', 'user:premission:add', 0, '0RK1QSQdR0zI');
INSERT INTO `premission` VALUES ('0RK1QBmxR7nr', '2019-03-07 17:13:56', '2019-03-07 17:13:56', '修改角色', 'user:role:update', 0, '0RK1PsijNB9G');
INSERT INTO `premission` VALUES ('0RK1QcxgOBe8', '2019-03-07 17:15:40', '2019-03-07 17:15:40', '修改权限', 'user:premission:update', 0, '0RK1QSQdR0zI');
INSERT INTO `premission` VALUES ('0RK1QfsJOKYV', '2019-03-07 17:15:51', '2019-03-07 17:15:51', '删除权限', 'user:premission:delete', 0, '0RK1QSQdR0zI');
INSERT INTO `premission` VALUES ('0RK1QSQdR0zI', '2019-03-07 17:15:00', '2019-03-07 17:15:00', '权限管理', 'user:premission', 1, '0RJv6UEeJsHi');
INSERT INTO `premission` VALUES ('0RK1Re9pOp0j', '2019-03-07 17:19:43', '2019-03-07 17:19:43', '授权', 'role', 1, '');
INSERT INTO `premission` VALUES ('0RK1RphWKG0f', '2019-03-07 17:20:27', '2019-03-07 17:20:27', '赋予角色权限', 'role:authorization', 0, '0RK1Re9pOp0j');
INSERT INTO `premission` VALUES ('0RK1SCv7OLEE', '2019-03-07 17:21:57', '2019-03-07 17:21:57', '赋予用户角色', 'role:ascribedRole', 0, '0RK1Re9pOp0j');
INSERT INTO `premission` VALUES ('0RK1SfCsMpv6', '2019-03-07 17:23:45', '2019-03-07 17:23:45', '添加产品', 'product:add', 0, '0RJv9CfWO6RM');
INSERT INTO `premission` VALUES ('0RK1SrhOKO6j', '2019-03-07 17:24:33', '2019-03-07 17:24:33', '更新产品', 'product:update', 0, '0RJv9CfWO6RM');
INSERT INTO `premission` VALUES ('0RK1SyiBOta0', '2019-03-07 17:25:00', '2019-03-07 17:25:00', '添加成员', 'product:addUser', 0, '0RJv9CfWO6RM');
INSERT INTO `premission` VALUES ('0RK1TK4OKth9', '2019-03-07 17:26:22', '2019-03-07 17:26:22', '项目', 'project', 1, '');
INSERT INTO `premission` VALUES ('0RK1U5TRO7sN', '2019-03-07 17:29:25', '2019-03-07 17:29:25', '添加项目', 'project:add', 0, '0RK1TK4OKth9');
INSERT INTO `premission` VALUES ('0RK1Uf7zOloS', '2019-03-07 17:31:42', '2019-03-07 17:31:42', '添加Bug', 'bug:add', 0, '0RK1UXbMMUXK');
INSERT INTO `premission` VALUES ('0RK1UIH5R4tb', '2019-03-07 17:30:14', '2019-03-07 17:30:14', '更新项目', 'project:update', 0, '0RK1TK4OKth9');
INSERT INTO `premission` VALUES ('0RK1UXbMMUXK', '2019-03-07 17:31:13', '2019-03-07 17:31:13', 'Bug', 'bug', 1, '');
INSERT INTO `premission` VALUES ('0RK1Xl9JNUni', '2019-03-07 17:44:00', '2019-03-07 17:44:00', '需求', 'need', 1, '');
INSERT INTO `premission` VALUES ('0RK1Xo7TIgAX', '2019-03-07 17:44:11', '2019-03-08 14:40:29', '添加需求', 'need:add', 0, '0RK1Xl9JNUni');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `addtime` datetime(0) NOT NULL COMMENT '创建时间',
  `updatetime` datetime(0) NOT NULL COMMENT '更新时间',
  `product_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品名',
  `product_presentation` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品介绍',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('0RJFGfY1NxLh', '2019-02-27 11:35:03', '2019-02-27 11:35:03', '产品1', '这是产品1的介绍');
INSERT INTO `product` VALUES ('0RJFSg4kNuYC', '2019-02-27 12:22:45', '2019-02-27 20:25:01', '产品222', '这是一个产品2这是一个产品2这是一个产品2这是一个产品2这是一个产品2a\n这是一个产品2这是一个产品2这是一个产品2这是一个产品2\n这是一个产品2这是一个产品2这是一个产品2\n这是一个产品2这是一个产品2\n这是一个产品2小臭小子创造性');
INSERT INTO `product` VALUES ('0RJFSgboNr6v', '2019-02-27 12:22:47', '2019-02-27 12:22:47', '123', '123');
INSERT INTO `product` VALUES ('0RJFSgLYN6QS', '2019-02-27 12:22:46', '2019-02-28 08:35:37', '产品3', '123');
INSERT INTO `product` VALUES ('0RJFSgP8G5vx', '2019-02-27 12:22:46', '2019-02-28 08:35:46', '产品4', '123');
INSERT INTO `product` VALUES ('0RJFSgRrMBEb', '2019-02-27 12:22:46', '2019-02-28 08:35:53', '产品5', '123');
INSERT INTO `product` VALUES ('0RJFSgUONMuv', '2019-02-27 12:22:46', '2019-02-28 08:36:08', '产品6', '123');
INSERT INTO `product` VALUES ('0RJFSgWkGCkN', '2019-02-27 12:22:46', '2019-02-28 08:36:18', '产品7', '123');
INSERT INTO `product` VALUES ('0RJFSgZ0IlJ1', '2019-02-27 12:22:46', '2019-02-27 12:22:46', '123', '123');
INSERT INTO `product` VALUES ('0RJFShbINJa3', '2019-02-27 12:22:50', '2019-02-27 12:22:50', '123', '123');
INSERT INTO `product` VALUES ('0RJFShoDIvn0', '2019-02-27 12:22:51', '2019-02-27 12:22:51', '123', '123');
INSERT INTO `product` VALUES ('0RJFShuqGa2L', '2019-02-27 12:22:52', '2019-02-27 12:22:52', '123', '123');
INSERT INTO `product` VALUES ('0RJFShxYNbiJ', '2019-02-27 12:22:52', '2019-02-27 12:22:52', '123', '123');
INSERT INTO `product` VALUES ('0RJFSi0AMPzj', '2019-02-27 12:22:52', '2019-02-27 12:22:52', '123', '123');
INSERT INTO `product` VALUES ('0RJFSi2cGJ0I', '2019-02-27 12:22:52', '2019-02-27 12:22:52', '123', '123');
INSERT INTO `product` VALUES ('0RJFSi5BMGMm', '2019-02-27 12:22:52', '2019-02-27 12:22:52', '123', '123');
INSERT INTO `product` VALUES ('0RJFSi7mIdvY', '2019-02-27 12:22:52', '2019-02-27 12:22:52', '123', '123');
INSERT INTO `product` VALUES ('0RJFSiABGv0X', '2019-02-27 12:22:53', '2019-02-27 12:22:53', '123', '123');
INSERT INTO `product` VALUES ('0RJFTPaSMnYY', '2019-02-27 12:25:39', '2019-02-27 12:25:39', 'nh', 'null');
INSERT INTO `product` VALUES ('0RJFTS9wNyX2', '2019-02-27 12:25:49', '2019-02-27 12:25:49', 'nh', 'huihiuh');
INSERT INTO `product` VALUES ('0RJFTSbMIAD9', '2019-02-27 12:25:51', '2019-02-27 12:25:51', 'nh', 'huihiuh');
INSERT INTO `product` VALUES ('0RJFTSINMQYn', '2019-02-27 12:25:50', '2019-02-27 12:25:50', 'nh', 'huihiuh');
INSERT INTO `product` VALUES ('0RJFTSKkGgKO', '2019-02-27 12:25:50', '2019-02-27 12:25:50', 'nh', 'huihiuh');
INSERT INTO `product` VALUES ('0RJFTSN6IRPx', '2019-02-27 12:25:50', '2019-02-27 12:25:50', 'nh', 'huihiuh');
INSERT INTO `product` VALUES ('0RJFTSPNMpxl', '2019-02-27 12:25:50', '2019-02-27 12:25:50', 'nh', 'huihiuh');
INSERT INTO `product` VALUES ('0RJFTSRuGfLK', '2019-02-27 12:25:50', '2019-02-27 12:25:50', 'nh', 'huihiuh');
INSERT INTO `product` VALUES ('0RJFTSU7Ia8x', '2019-02-27 12:25:51', '2019-02-27 12:25:51', 'nh', 'huihiuh');
INSERT INTO `product` VALUES ('0RJFTSWQGwqB', '2019-02-27 12:25:51', '2019-02-27 12:25:51', 'nh', 'huihiuh');
INSERT INTO `product` VALUES ('0RJFTSZ8NSMH', '2019-02-27 12:25:51', '2019-02-27 12:25:51', 'nh', 'huihiuh');
INSERT INTO `product` VALUES ('0RJGhsNbI4c0', '2019-02-27 17:29:23', '2019-02-27 17:29:23', '新手考核项目', '一、公共模块\n1.用户系统，需要实现用户，角色，权限自定义功能，权限的控制精确到每个操作。注册用户必须填写，姓名，部门，工号，企业邮箱，以邮箱作为登录名。每个用户登录都需要有登录日志\n2.用户和角色是多对多的对应关系，一个用户可以有多重角色，他的权限为所有角色权限合并叠加。\n\n二、项目管理：需要实现项目管理的关键流程\n1.项目管理过程的数据组织形式： 产品 –> 项目(或者不同版本的需求)->需求(原型和文档) –> 测试(bug)\n2.添加产品（特定权限） ，需要处理产品名称、介绍、参与成员等信息\n3.添加项目（特定权限） ，需要处理所属产品、项目名称、开始结束日期、完成状态等信息（完成状态 由有特定权限人员维护，前提是该项目没有未处理的bug的情况下）');
INSERT INTO `product` VALUES ('0RK1O9OUMWke', '2019-03-07 17:05:50', '2019-03-07 17:05:50', '项目管理系统', '恶趣味我去恶趣味额');

-- ----------------------------
-- Table structure for product_member
-- ----------------------------
DROP TABLE IF EXISTS `product_member`;
CREATE TABLE `product_member`  (
  `id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `addtime` datetime(0) NOT NULL COMMENT '创建时间',
  `updatetime` datetime(0) NOT NULL COMMENT '更新时间',
  `product_id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品id',
  `user_id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品成员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_member
-- ----------------------------
INSERT INTO `product_member` VALUES ('0RJFGfYANU1f', '2019-02-27 11:35:03', '2019-02-27 11:35:03', '0RJFGfY1NxLh', 'asdrcxzv1234');
INSERT INTO `product_member` VALUES ('0RJFShbSNIoq', '2019-02-27 12:22:50', '2019-02-27 12:22:50', '0RJFShbINJa3', '0RJA8Rh6JjnA');
INSERT INTO `product_member` VALUES ('0RJFShoMI1WL', '2019-02-27 12:22:51', '2019-02-27 12:22:51', '0RJFShoDIvn0', '0RJA8Rh6JjnA');
INSERT INTO `product_member` VALUES ('0RJFShv2GBQs', '2019-02-27 12:22:52', '2019-02-27 12:22:52', '0RJFShuqGa2L', '0RJA8Rh6JjnA');
INSERT INTO `product_member` VALUES ('0RJFShxfNUkO', '2019-02-27 12:22:52', '2019-02-27 12:22:52', '0RJFShxYNbiJ', '0RJA8Rh6JjnA');
INSERT INTO `product_member` VALUES ('0RJFSi0HM199', '2019-02-27 12:22:52', '2019-02-27 12:22:52', '0RJFSi0AMPzj', '0RJA8Rh6JjnA');
INSERT INTO `product_member` VALUES ('0RJFSi2jGKgF', '2019-02-27 12:22:52', '2019-02-27 12:22:52', '0RJFSi2cGJ0I', '0RJA8Rh6JjnA');
INSERT INTO `product_member` VALUES ('0RJFSi5IMFkS', '2019-02-27 12:22:52', '2019-02-27 12:22:52', '0RJFSi5BMGMm', '0RJA8Rh6JjnA');
INSERT INTO `product_member` VALUES ('0RJFSi7tIuQO', '2019-02-27 12:22:52', '2019-02-27 12:22:52', '0RJFSi7mIdvY', '0RJA8Rh6JjnA');
INSERT INTO `product_member` VALUES ('0RJFSiAIGDQh', '2019-02-27 12:22:53', '2019-02-27 12:22:53', '0RJFSiABGv0X', '0RJA8Rh6JjnA');
INSERT INTO `product_member` VALUES ('0RJFTPaaMS71', '2019-02-27 12:25:39', '2019-02-27 12:25:39', '0RJFTPaSMnYY', '0RJA8Rh6JjnA');
INSERT INTO `product_member` VALUES ('0RJFTPahMqWc', '2019-02-27 12:25:40', '2019-02-27 12:25:40', '0RJFTPaSMnYY', '0RJA8qMVJNCF');
INSERT INTO `product_member` VALUES ('0RJFTSA4N2B9', '2019-02-27 12:25:49', '2019-02-27 12:25:49', '0RJFTS9wNyX2', '0RJA8Rh6JjnA');
INSERT INTO `product_member` VALUES ('0RJFTSAANzmi', '2019-02-27 12:25:49', '2019-02-27 12:25:49', '0RJFTS9wNyX2', '0RJA8qMVJNCF');
INSERT INTO `product_member` VALUES ('0RJFTSbTI2w5', '2019-02-27 12:25:51', '2019-02-27 12:25:51', '0RJFTSbMIAD9', '0RJA8Rh6JjnA');
INSERT INTO `product_member` VALUES ('0RJFTSbYIYMc', '2019-02-27 12:25:51', '2019-02-27 12:25:51', '0RJFTSbMIAD9', '0RJA8qMVJNCF');
INSERT INTO `product_member` VALUES ('0RJFTSIeMoWE', '2019-02-27 12:25:50', '2019-02-27 12:25:50', '0RJFTSINMQYn', '0RJA8qMVJNCF');
INSERT INTO `product_member` VALUES ('0RJFTSIXMcsC', '2019-02-27 12:25:50', '2019-02-27 12:25:50', '0RJFTSINMQYn', '0RJA8Rh6JjnA');
INSERT INTO `product_member` VALUES ('0RJFTSKrGzaj', '2019-02-27 12:25:50', '2019-02-27 12:25:50', '0RJFTSKkGgKO', '0RJA8Rh6JjnA');
INSERT INTO `product_member` VALUES ('0RJFTSKwG1ia', '2019-02-27 12:25:50', '2019-02-27 12:25:50', '0RJFTSKkGgKO', '0RJA8qMVJNCF');
INSERT INTO `product_member` VALUES ('0RJFTSNDImZa', '2019-02-27 12:25:50', '2019-02-27 12:25:50', '0RJFTSN6IRPx', '0RJA8Rh6JjnA');
INSERT INTO `product_member` VALUES ('0RJFTSNKIwbc', '2019-02-27 12:25:50', '2019-02-27 12:25:50', '0RJFTSN6IRPx', '0RJA8qMVJNCF');
INSERT INTO `product_member` VALUES ('0RJFTSPUM0Vk', '2019-02-27 12:25:50', '2019-02-27 12:25:50', '0RJFTSPNMpxl', '0RJA8Rh6JjnA');
INSERT INTO `product_member` VALUES ('0RJFTSPZMiQ0', '2019-02-27 12:25:50', '2019-02-27 12:25:50', '0RJFTSPNMpxl', '0RJA8qMVJNCF');
INSERT INTO `product_member` VALUES ('0RJFTSS2GJGF', '2019-02-27 12:25:50', '2019-02-27 12:25:50', '0RJFTSRuGfLK', '0RJA8Rh6JjnA');
INSERT INTO `product_member` VALUES ('0RJFTSS8GxJo', '2019-02-27 12:25:51', '2019-02-27 12:25:51', '0RJFTSRuGfLK', '0RJA8qMVJNCF');
INSERT INTO `product_member` VALUES ('0RJFTSUDIrKu', '2019-02-27 12:25:51', '2019-02-27 12:25:51', '0RJFTSU7Ia8x', '0RJA8Rh6JjnA');
INSERT INTO `product_member` VALUES ('0RJFTSUII1YM', '2019-02-27 12:25:51', '2019-02-27 12:25:51', '0RJFTSU7Ia8x', '0RJA8qMVJNCF');
INSERT INTO `product_member` VALUES ('0RJFTSWcGNQK', '2019-02-27 12:25:51', '2019-02-27 12:25:51', '0RJFTSWQGwqB', '0RJA8qMVJNCF');
INSERT INTO `product_member` VALUES ('0RJFTSWWGOxy', '2019-02-27 12:25:51', '2019-02-27 12:25:51', '0RJFTSWQGwqB', '0RJA8Rh6JjnA');
INSERT INTO `product_member` VALUES ('0RJFTSZENkX9', '2019-02-27 12:25:51', '2019-02-27 12:25:51', '0RJFTSZ8NSMH', '0RJA8Rh6JjnA');
INSERT INTO `product_member` VALUES ('0RJFTSZJNPCq', '2019-02-27 12:25:51', '2019-02-27 12:25:51', '0RJFTSZ8NSMH', '0RJA8qMVJNCF');
INSERT INTO `product_member` VALUES ('0RJGhsNlIZOQ', '2019-02-27 17:29:23', '2019-02-27 17:29:23', '0RJGhsNbI4c0', 'asdrcxzv1234');
INSERT INTO `product_member` VALUES ('0RJGhsNtIRNc', '2019-02-27 17:29:23', '2019-02-27 17:29:23', '0RJGhsNbI4c0', '0RJA8Rh6JjnA');
INSERT INTO `product_member` VALUES ('0RJGhsNzIDxT', '2019-02-27 17:29:23', '2019-02-27 17:29:23', '0RJGhsNbI4c0', '0RJA8qMVJNCF');
INSERT INTO `product_member` VALUES ('0RJGhsO6IHO5', '2019-02-27 17:29:23', '2019-02-27 17:29:23', '0RJGhsNbI4c0', '0RJA9gIwGymb');
INSERT INTO `product_member` VALUES ('0RJGhsOBIeVR', '2019-02-27 17:29:23', '2019-02-27 17:29:23', '0RJGhsNbI4c0', '0RJAh2vRLbN6');
INSERT INTO `product_member` VALUES ('0RJGhsOHIuwI', '2019-02-27 17:29:23', '2019-02-27 17:29:23', '0RJGhsNbI4c0', '0RJAh8B0ISkV');
INSERT INTO `product_member` VALUES ('0RJGhsOOIzPg', '2019-02-27 17:29:23', '2019-02-27 17:29:23', '0RJGhsNbI4c0', '0RJAp33LPem8');
INSERT INTO `product_member` VALUES ('0RJHDqSrIDBc', '2019-02-27 19:36:22', '2019-02-27 19:36:22', '0RJFSgLYN6QS', '0RJA8Rh6JjnA');
INSERT INTO `product_member` VALUES ('0RJHGPN1Ot1X', '2019-02-27 19:46:33', '2019-02-27 19:46:33', '0RJFSgLYN6QS', '0RJA8qMVJNCF');
INSERT INTO `product_member` VALUES ('0RJHGPN9OYtI', '2019-02-27 19:46:33', '2019-02-27 19:46:33', '0RJFSgLYN6QS', '0RJA9gIwGymb');
INSERT INTO `product_member` VALUES ('0RJHHMEeLdMv', '2019-02-27 19:50:19', '2019-02-27 19:50:19', '0RJFGfY1NxLh', '0RJA9gIwGymb');
INSERT INTO `product_member` VALUES ('0RJHHMEVL285', '2019-02-27 19:50:19', '2019-02-27 19:50:19', '0RJFGfY1NxLh', '0RJA8qMVJNCF');
INSERT INTO `product_member` VALUES ('0RJHQ8MpL0eq', '2019-02-27 20:25:11', '2019-02-27 20:25:11', '0RJFSg4kNuYC', '0RJA8qMVJNCF');
INSERT INTO `product_member` VALUES ('0RJHQ8MwLEMV', '2019-02-27 20:25:11', '2019-02-27 20:25:11', '0RJFSg4kNuYC', '0RJA9gIwGymb');
INSERT INTO `product_member` VALUES ('0RJHQMhbH3Dp', '2019-02-27 20:26:06', '2019-02-27 20:26:06', '0RJFSg4kNuYC', '0RJAh2vRLbN6');
INSERT INTO `product_member` VALUES ('0RJHQMhhHdng', '2019-02-27 20:26:06', '2019-02-27 20:26:06', '0RJFSg4kNuYC', '0RJAh8B0ISkV');
INSERT INTO `product_member` VALUES ('0RJHQQPJLFkd', '2019-02-27 20:26:20', '2019-02-27 20:26:20', '0RJFSg4kNuYC', 'asdrcxzv1234');
INSERT INTO `product_member` VALUES ('0RJHQQPRLTEs', '2019-02-27 20:26:20', '2019-02-27 20:26:20', '0RJFSg4kNuYC', '0RJA8Rh6JjnA');
INSERT INTO `product_member` VALUES ('0RJHRG5CN0uE', '2019-02-27 20:29:39', '2019-02-27 20:29:39', '0RJFSg4kNuYC', '0RJAp33LPem8');
INSERT INTO `product_member` VALUES ('0RJKcLVmGoL0', '2019-02-28 09:32:30', '2019-02-28 09:32:30', '0RJFSgP8G5vx', '0RJA8Rh6JjnA');
INSERT INTO `product_member` VALUES ('0RJKcLVwGS89', '2019-02-28 09:32:30', '2019-02-28 09:32:30', '0RJFSgP8G5vx', '0RJA9gIwGymb');
INSERT INTO `product_member` VALUES ('0RJM9fwwHYsN', '2019-02-28 15:51:10', '2019-02-28 15:51:10', '0RJFSgWkGCkN', 'null');
INSERT INTO `product_member` VALUES ('0RJM9geGLGgq', '2019-02-28 15:51:13', '2019-02-28 15:51:13', '0RJFSgWkGCkN', '0RJA8Rh6JjnA');
INSERT INTO `product_member` VALUES ('0RJM9geNLRgD', '2019-02-28 15:51:13', '2019-02-28 15:51:13', '0RJFSgWkGCkN', '0RJA9gIwGymb');
INSERT INTO `product_member` VALUES ('0RJST5DLNuu8', '2019-03-01 17:45:54', '2019-03-01 17:45:54', '0RJFGfY1NxLh', 'null');
INSERT INTO `product_member` VALUES ('0RJST6mbM2KZ', '2019-03-01 17:46:00', '2019-03-01 17:46:00', '0RJFGfY1NxLh', '0RJA8Rh6JjnA');
INSERT INTO `product_member` VALUES ('0RJST8FrIzXR', '2019-03-01 17:46:05', '2019-03-01 17:46:05', '0RJFGfY1NxLh', '0RJAh2vRLbN6');
INSERT INTO `product_member` VALUES ('0RJSTA4VIFgC', '2019-03-01 17:46:12', '2019-03-01 17:46:12', '0RJFGfY1NxLh', '0RJAh8B0ISkV');
INSERT INTO `product_member` VALUES ('0RJSTCQiJ9V2', '2019-03-01 17:46:21', '2019-03-01 17:46:21', '0RJFGfY1NxLh', '0RJAp33LPem8');
INSERT INTO `product_member` VALUES ('0RK1O9OdMu2a', '2019-03-07 17:05:50', '2019-03-07 17:05:50', '0RK1O9OUMWke', '0RJpq3vXMd0m');
INSERT INTO `product_member` VALUES ('0RK1OCB7O6H5', '2019-03-07 17:06:00', '2019-03-07 17:06:00', '0RK1O9OUMWke', '0RJtVRByNyjL');
INSERT INTO `product_member` VALUES ('0RK1UphMRpLW', '2019-03-07 17:32:22', '2019-03-07 17:32:22', '0RJFGfY1NxLh', '0RJpq3vXMd0m');
INSERT INTO `product_member` VALUES ('0RK1UphWR54t', '2019-03-07 17:32:22', '2019-03-07 17:32:22', '0RJFGfY1NxLh', '0RJtVRByNyjL');

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `addtime` datetime(0) NOT NULL COMMENT '创建时间',
  `updatetime` datetime(0) NOT NULL COMMENT '更新时间',
  `begindate` date NOT NULL COMMENT '项目开始时间',
  `enddate` date NULL DEFAULT NULL COMMENT '项目结束时间',
  `product_id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属产品id',
  `project_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目名',
  `is_finished` tinyint(3) UNSIGNED NOT NULL COMMENT '是否已经完成',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '项目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('0RJKxY2oMnpL', '2019-02-28 10:56:44', '2019-03-06 08:50:00', '2019-02-01', '2019-02-28', '0RJFGfY1NxLh', '项目1', 0);
INSERT INTO `project` VALUES ('0RJL0jTeL1Rs', '2019-02-28 11:09:22', '2019-02-28 15:51:23', '2019-01-11', '2019-12-11', '0RJFSgWkGCkN', '项目2', 0);
INSERT INTO `project` VALUES ('0RJL3C3lKgHr', '2019-02-28 11:19:09', '2019-03-02 16:16:37', '2019-02-01', '2019-02-21', '0RJFSg4kNuYC', '项目3', 0);
INSERT INTO `project` VALUES ('0RJL3CdsMnmX', '2019-02-28 11:19:11', '2019-02-28 15:23:52', '2019-02-01', '2019-02-21', '0RJGhsNbI4c0', '项目4', 0);
INSERT INTO `project` VALUES ('0RJL3DCkNYIR', '2019-02-28 11:19:13', '2019-02-28 11:19:13', '2019-02-01', '2019-02-21', '0RJFSg4kNuYC', '项目5', 0);
INSERT INTO `project` VALUES ('0RJL3DjLJasv', '2019-02-28 11:19:15', '2019-02-28 11:19:15', '2019-02-01', '2019-02-21', '0RJFSg4kNuYC', '项目6', 0);
INSERT INTO `project` VALUES ('0RJL3EIQMa1D', '2019-02-28 11:19:18', '2019-02-28 11:19:18', '2019-02-01', '2019-02-21', '0RJFSg4kNuYC', '项目7', 0);
INSERT INTO `project` VALUES ('0RJL3EwQJRpB', '2019-02-28 11:19:20', '2019-02-28 11:19:20', '2019-02-01', '2019-02-21', '0RJFSg4kNuYC', '项目8', 0);
INSERT INTO `project` VALUES ('0RJL3FURK1yl', '2019-02-28 11:19:22', '2019-02-28 11:19:22', '2019-02-01', '2019-02-21', '0RJFSg4kNuYC', '项目9', 0);
INSERT INTO `project` VALUES ('0RJL3G4JNnj0', '2019-02-28 11:19:24', '2019-02-28 11:19:24', '2019-02-01', '2019-02-21', '0RJFSg4kNuYC', '项目10', 0);
INSERT INTO `project` VALUES ('0RJL3H0EKXGK', '2019-02-28 11:19:28', '2019-02-28 11:19:28', '2019-02-01', '2019-02-21', '0RJFSg4kNuYC', '项目11', 0);
INSERT INTO `project` VALUES ('0RJL3IuYKuB3', '2019-02-28 11:19:35', '2019-02-28 11:19:35', '2019-02-01', '2019-02-21', '0RJFSg4kNuYC', '项目12', 0);
INSERT INTO `project` VALUES ('0RJL3JOpNaTi', '2019-02-28 11:19:37', '2019-02-28 11:19:37', '2019-02-01', '2019-02-21', '0RJFSg4kNuYC', '项目13', 0);
INSERT INTO `project` VALUES ('0RJL3JtpJZVB', '2019-02-28 11:19:39', '2019-02-28 11:19:39', '2019-02-01', '2019-02-21', '0RJFSg4kNuYC', '项目14', 0);
INSERT INTO `project` VALUES ('0RJL3KgeMIBO', '2019-02-28 11:19:42', '2019-02-28 11:19:42', '2019-02-01', '2019-02-21', '0RJFSg4kNuYC', '项目16', 0);
INSERT INTO `project` VALUES ('0RJL3KJRK0xF', '2019-02-28 11:19:41', '2019-02-28 11:19:41', '2019-02-01', '2019-02-21', '0RJFSg4kNuYC', '项目15', 0);
INSERT INTO `project` VALUES ('0RJL3L74KB8t', '2019-02-28 11:19:44', '2019-02-28 11:19:44', '2019-02-01', '2019-02-21', '0RJFSg4kNuYC', '项目17', 0);
INSERT INTO `project` VALUES ('0RJL3LZZJKkf', '2019-02-28 11:19:46', '2019-02-28 11:19:46', '2019-02-01', '2019-02-21', '0RJFSg4kNuYC', '项目18', 0);
INSERT INTO `project` VALUES ('0RJL3M0SNyxW', '2019-02-28 11:19:47', '2019-02-28 11:19:47', '2019-02-01', '2019-02-21', '0RJFSg4kNuYC', '项目19', 0);
INSERT INTO `project` VALUES ('0RJL3MgKJ4rc', '2019-02-28 11:19:50', '2019-02-28 11:19:50', '2019-02-01', '2019-02-21', '0RJFSg4kNuYC', '项目20', 0);
INSERT INTO `project` VALUES ('0RJL3vBcL1mt', '2019-02-28 11:22:02', '2019-02-28 11:22:02', '2019-02-01', '2019-11-21', '0RJGhsNbI4c0', '项目21', 0);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `addtime` datetime(0) NOT NULL COMMENT '创建时间',
  `updatetime` datetime(0) NOT NULL COMMENT '更新时间',
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('0RJtkZdSNc7i', '2019-03-06 09:44:43', '2019-03-06 09:44:43', '产品经理');
INSERT INTO `role` VALUES ('0RJtmFzOOPoI', '2019-03-06 09:51:24', '2019-03-06 09:51:24', '项目经理');
INSERT INTO `role` VALUES ('0RJtmN5KNO2Z', '2019-03-06 09:51:52', '2019-03-06 10:11:44', '系统管理员');
INSERT INTO `role` VALUES ('0RJts9c8LcCi', '2019-03-06 10:14:50', '2019-03-08 15:57:32', '测试角色');

-- ----------------------------
-- Table structure for role_premission
-- ----------------------------
DROP TABLE IF EXISTS `role_premission`;
CREATE TABLE `role_premission`  (
  `id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `addtime` datetime(0) NOT NULL COMMENT '创建时间',
  `updatetime` datetime(0) NOT NULL COMMENT '更新时间',
  `role_id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色id',
  `premission_id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色-权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_premission
-- ----------------------------
INSERT INTO `role_premission` VALUES ('0RK5D33nLW3L', '2019-03-08 08:46:49', '2019-03-08 08:46:49', '0RJtmN5KNO2Z', '0RJv6UEeJsHi');
INSERT INTO `role_premission` VALUES ('0RK5D33yLNo3', '2019-03-08 08:46:49', '2019-03-08 08:46:49', '0RJtmN5KNO2Z', '0RJv9dWcNXGQ');
INSERT INTO `role_premission` VALUES ('0RK5D345LPVv', '2019-03-08 08:46:49', '2019-03-08 08:46:49', '0RJtmN5KNO2Z', '0RJvAOEbNZFl');
INSERT INTO `role_premission` VALUES ('0RK5D34cLgu8', '2019-03-08 08:46:49', '2019-03-08 08:46:49', '0RJtmN5KNO2Z', '0RK1PRkRNHPQ');
INSERT INTO `role_premission` VALUES ('0RK5D34ELUxP', '2019-03-08 08:46:49', '2019-03-08 08:46:49', '0RJtmN5KNO2Z', '0RK1LAUiK5wY');
INSERT INTO `role_premission` VALUES ('0RK5D34iLat2', '2019-03-08 08:46:49', '2019-03-08 08:46:49', '0RJtmN5KNO2Z', '0RK1PVPINvYW');
INSERT INTO `role_premission` VALUES ('0RK5D34LLA2S', '2019-03-08 08:46:49', '2019-03-08 08:46:49', '0RJtmN5KNO2Z', '0RK1LMElNDsx');
INSERT INTO `role_premission` VALUES ('0RK5D34nLu7H', '2019-03-08 08:46:49', '2019-03-08 08:46:49', '0RJtmN5KNO2Z', '0RK1PsijNB9G');
INSERT INTO `role_premission` VALUES ('0RK5D34RL2Ei', '2019-03-08 08:46:49', '2019-03-08 08:46:49', '0RJtmN5KNO2Z', '0RK1LmnLOkB1');
INSERT INTO `role_premission` VALUES ('0RK5D34tLinS', '2019-03-08 08:46:49', '2019-03-08 08:46:49', '0RJtmN5KNO2Z', '0RK1Q531Rvcc');
INSERT INTO `role_premission` VALUES ('0RK5D34WLubR', '2019-03-08 08:46:49', '2019-03-08 08:46:49', '0RJtmN5KNO2Z', '0RK1M7PdMKEg');
INSERT INTO `role_premission` VALUES ('0RK5D34yLfHM', '2019-03-08 08:46:49', '2019-03-08 08:46:49', '0RJtmN5KNO2Z', '0RK1Q7V1ON8m');
INSERT INTO `role_premission` VALUES ('0RK5D354LVao', '2019-03-08 08:46:49', '2019-03-08 08:46:49', '0RJtmN5KNO2Z', '0RK1QBmxR7nr');
INSERT INTO `role_premission` VALUES ('0RK5D359Lpff', '2019-03-08 08:46:49', '2019-03-08 08:46:49', '0RJtmN5KNO2Z', '0RK1QSQdR0zI');
INSERT INTO `role_premission` VALUES ('0RK5D35aLgGv', '2019-03-08 08:46:49', '2019-03-08 08:46:49', '0RJtmN5KNO2Z', '0RK1SfCsMpv6');
INSERT INTO `role_premission` VALUES ('0RK5D35ELUey', '2019-03-08 08:46:49', '2019-03-08 08:46:49', '0RJtmN5KNO2Z', '0RK1QaPJMTWJ');
INSERT INTO `role_premission` VALUES ('0RK5D35gLKJJ', '2019-03-08 08:46:49', '2019-03-08 08:46:49', '0RJtmN5KNO2Z', '0RK1SrhOKO6j');
INSERT INTO `role_premission` VALUES ('0RK5D35KLByM', '2019-03-08 08:46:49', '2019-03-08 08:46:49', '0RJtmN5KNO2Z', '0RK1QcxgOBe8');
INSERT INTO `role_premission` VALUES ('0RK5D35lLa0X', '2019-03-08 08:46:49', '2019-03-08 08:46:49', '0RJtmN5KNO2Z', '0RK1SyiBOta0');
INSERT INTO `role_premission` VALUES ('0RK5D35QLO6R', '2019-03-08 08:46:49', '2019-03-08 08:46:49', '0RJtmN5KNO2Z', '0RK1QfsJOKYV');
INSERT INTO `role_premission` VALUES ('0RK5D35rLGwF', '2019-03-08 08:46:49', '2019-03-08 08:46:49', '0RJtmN5KNO2Z', '0RK1Re9pOp0j');
INSERT INTO `role_premission` VALUES ('0RK5D35VL4bo', '2019-03-08 08:46:49', '2019-03-08 08:46:49', '0RJtmN5KNO2Z', '0RJv9CfWO6RM');
INSERT INTO `role_premission` VALUES ('0RK5D35wLhFL', '2019-03-08 08:46:49', '2019-03-08 08:46:49', '0RJtmN5KNO2Z', '0RK1RphWKG0f');
INSERT INTO `role_premission` VALUES ('0RK5D361Lesl', '2019-03-08 08:46:49', '2019-03-08 08:46:49', '0RJtmN5KNO2Z', '0RK1SCv7OLEE');
INSERT INTO `role_premission` VALUES ('0RK5D367LFwc', '2019-03-08 08:46:49', '2019-03-08 08:46:49', '0RJtmN5KNO2Z', '0RK1TK4OKth9');
INSERT INTO `role_premission` VALUES ('0RK5D36CLZXl', '2019-03-08 08:46:49', '2019-03-08 08:46:49', '0RJtmN5KNO2Z', '0RK1U5TRO7sN');
INSERT INTO `role_premission` VALUES ('0RK5D36ILHic', '2019-03-08 08:46:49', '2019-03-08 08:46:49', '0RJtmN5KNO2Z', '0RK1UIH5R4tb');
INSERT INTO `role_premission` VALUES ('0RK5D36NLHdh', '2019-03-08 08:46:49', '2019-03-08 08:46:49', '0RJtmN5KNO2Z', '0RK1UXbMMUXK');
INSERT INTO `role_premission` VALUES ('0RK5D36ULP30', '2019-03-08 08:46:49', '2019-03-08 08:46:49', '0RJtmN5KNO2Z', '0RK1Uf7zOloS');
INSERT INTO `role_premission` VALUES ('0RK6DMWsMnNF', '2019-03-08 12:54:20', '2019-03-08 12:54:20', '0RJtkZdSNc7i', '0RJv9CfWO6RM');
INSERT INTO `role_premission` VALUES ('0RK6DMWzMxWG', '2019-03-08 12:54:20', '2019-03-08 12:54:20', '0RJtkZdSNc7i', '0RK1SfCsMpv6');
INSERT INTO `role_premission` VALUES ('0RK6DMX6MxQ4', '2019-03-08 12:54:20', '2019-03-08 12:54:20', '0RJtkZdSNc7i', '0RK1SrhOKO6j');
INSERT INTO `role_premission` VALUES ('0RK6DMXBM7ni', '2019-03-08 12:54:20', '2019-03-08 12:54:20', '0RJtkZdSNc7i', '0RK1SyiBOta0');
INSERT INTO `role_premission` VALUES ('0RK6DMXdMisV', '2019-03-08 12:54:20', '2019-03-08 12:54:20', '0RJtkZdSNc7i', '0RK1Uf7zOloS');
INSERT INTO `role_premission` VALUES ('0RK6DMXHMOOI', '2019-03-08 12:54:20', '2019-03-08 12:54:20', '0RJtkZdSNc7i', '0RK1TK4OKth9');
INSERT INTO `role_premission` VALUES ('0RK6DMXjM2G8', '2019-03-08 12:54:20', '2019-03-08 12:54:20', '0RJtkZdSNc7i', '0RK1Xl9JNUni');
INSERT INTO `role_premission` VALUES ('0RK6DMXNMyI3', '2019-03-08 12:54:20', '2019-03-08 12:54:20', '0RJtkZdSNc7i', '0RK1U5TRO7sN');
INSERT INTO `role_premission` VALUES ('0RK6DMXpMqgQ', '2019-03-08 12:54:20', '2019-03-08 12:54:20', '0RJtkZdSNc7i', '0RK1Xo7TIgAX');
INSERT INTO `role_premission` VALUES ('0RK6DMXSMsFE', '2019-03-08 12:54:20', '2019-03-08 12:54:20', '0RJtkZdSNc7i', '0RK1UIH5R4tb');
INSERT INTO `role_premission` VALUES ('0RK6DMXYMqTL', '2019-03-08 12:54:20', '2019-03-08 12:54:20', '0RJtkZdSNc7i', '0RK1UXbMMUXK');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `addtime` datetime(0) NOT NULL COMMENT '创建时间',
  `updatetime` datetime(0) NOT NULL COMMENT '更新时间',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户姓名',
  `department_id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门id',
  `job_number` smallint(5) UNSIGNED NULL DEFAULT NULL COMMENT '工号',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `is_stopped` tinyint(3) UNSIGNED NULL DEFAULT 0 COMMENT '是否已停用',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `job_number`(`job_number`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0RJpq3vXMd0m', '2019-03-05 17:41:26', '2019-03-08 10:46:24', '吴桐', '0RIss2SAVU7n', 1425, 'wut@pvc123.com', '8a2c9f013da41efcd12e54a0c99fb960', 0);
INSERT INTO `user` VALUES ('0RJtVRByNyjL', '2019-03-06 08:44:36', '2019-03-08 09:17:00', '张三', '0RIss2SAVU7n', 1, '1@qq.com', 'dfea898cad7a8e939e3975b671a90c72', 0);
INSERT INTO `user` VALUES ('0RK1PBA2KpQt', '2019-03-07 17:09:55', '2019-03-08 09:17:04', '李四', '0RIss2SAVU7n', 2, 'lisi@qq.com', '5b522b6e7904ee1286c46165e4d45867', 0);
INSERT INTO `user` VALUES ('0RK5hQ4sMF4B', '2019-03-08 10:47:27', '2019-03-08 10:59:12', '赵六', '0RIss2SAVU7n', 6, 'zl@qq.com', '3f2552b20ea4c4ed55456026ac330f27', 1);
INSERT INTO `user` VALUES ('0RK5LmTAKnnv', '2019-03-08 09:21:30', '2019-03-08 09:21:30', '王五', '0RIss2SAVU7n', 3, 'ww@qq.com', 'b56cf3bcd41a82cb94ee266ffafc6e2a', 0);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `addtime` datetime(0) NOT NULL COMMENT '创建时间',
  `updatetime` datetime(0) NOT NULL COMMENT '添加时间',
  `user_id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `role_id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户-角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('0RK5D71RNfNM', '2019-03-08 08:47:04', '2019-03-08 08:47:04', '0RJpq3vXMd0m', '0RJtmN5KNO2Z');
INSERT INTO `user_role` VALUES ('0RK5dEFUNcZg', '2019-03-08 10:30:49', '2019-03-08 10:30:49', '0RJtVRByNyjL', '0RJtkZdSNc7i');
INSERT INTO `user_role` VALUES ('0RK5Rk0lJTXq', '2019-03-08 09:45:11', '2019-03-08 09:45:11', '0RK1PBA2KpQt', '0RJtkZdSNc7i');
INSERT INTO `user_role` VALUES ('0RK6xXcyOIJg', '2019-03-08 15:57:46', '2019-03-08 15:57:46', '0RK5hQ4sMF4B', '0RJts9c8LcCi');

SET FOREIGN_KEY_CHECKS = 1;
