<br><br>/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : pms

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 20/03/2019 20:17:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Bug表
-- ----------------------------
DROP TABLE IF EXISTS `bug`;
CREATE TABLE `bug`  (
  `id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `addtime` datetime(0) NOT NULL COMMENT '创建时间',
  `updatetime` datetime(0) NOT NULL COMMENT '更新时间',
  `project_id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目id',
  `is_noprocessing` tinyint(3) UNSIGNED NOT NULL COMMENT '是否不予处理',
  `bug_status` tinyint(3) UNSIGNED NOT NULL COMMENT 'bug状态：0为指派中，1为验收中，2为完成',
  `bug_title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'bug详情',
  `bug_content` varchar(4500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'bug描述',
  `bug_proposer` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '提出bug用户的id',
  `bug_processer` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '处理bug用户的id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'bug表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Bug说明表
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
-- Bug操作记录表
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
-- 部门表
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
INSERT INTO `department` VALUES ('0RKgHWcnOWIx', '2019-03-14 16:56:41', '2019-03-14 16:56:41', '测试部');

-- ----------------------------
-- 登陆日志表
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
-- 需求表
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
-- 权限表
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `addtime` datetime(0) NOT NULL COMMENT '创建时间',
  `updatetime` datetime(0) NOT NULL COMMENT '更新时间',
  `permission_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限名',
  `permission_field` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限字段',
  `is_menu` tinyint(3) UNSIGNED NOT NULL COMMENT '是否菜单',
  `parent_id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '父级菜单id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('0RJv6UEeJsHi', '2019-03-06 15:18:02', '2019-03-14 13:30:49', '用户系统', 'userSys', 1, '');
INSERT INTO `permission` VALUES ('0RJv9CfWO6RM', '2019-03-06 15:28:49', '2019-03-06 16:02:31', '产品', 'product', 1, '');
INSERT INTO `permission` VALUES ('0RJv9dWcNXGQ', '2019-03-06 15:30:33', '2019-03-14 13:30:58', '部门管理', 'department', 1, '0RJv6UEeJsHi');
INSERT INTO `permission` VALUES ('0RJvAOEbNZFl', '2019-03-06 15:33:32', '2019-03-14 13:31:08', '添加部门', 'add:department', 0, '0RJv9dWcNXGQ');
INSERT INTO `permission` VALUES ('0RK1LAUiK5wY', '2019-03-07 16:53:59', '2019-03-14 13:31:18', '修改部门', 'update:department', 0, '0RJv9dWcNXGQ');
INSERT INTO `permission` VALUES ('0RK1LMElNDsx', '2019-03-07 16:54:44', '2019-03-14 13:31:30', '删除部门', 'delete:department', 0, '0RJv9dWcNXGQ');
INSERT INTO `permission` VALUES ('0RK1LmnLOkB1', '2019-03-07 16:56:26', '2019-03-14 13:31:42', '用户管理', 'user', 1, '0RJv6UEeJsHi');
INSERT INTO `permission` VALUES ('0RK1M7PdMKEg', '2019-03-07 16:57:45', '2019-03-14 13:31:52', '添加用户', 'add:user', 0, '0RK1LmnLOkB1');
INSERT INTO `permission` VALUES ('0RK1PRkRNHPQ', '2019-03-07 17:10:59', '2019-03-14 13:31:59', '修改用户', 'update:user', 0, '0RK1LmnLOkB1');
INSERT INTO `permission` VALUES ('0RK1PsijNB9G', '2019-03-07 17:12:42', '2019-03-14 13:32:32', '角色管理', 'role', 1, '0RJv6UEeJsHi');
INSERT INTO `permission` VALUES ('0RK1PVPINvYW', '2019-03-07 17:11:13', '2019-03-14 13:32:24', '禁用/启用用户', 'delete:user', 0, '0RK1LmnLOkB1');
INSERT INTO `permission` VALUES ('0RK1Q531Rvcc', '2019-03-07 17:13:30', '2019-03-14 13:32:42', '添加角色', 'add:role', 0, '0RK1PsijNB9G');
INSERT INTO `permission` VALUES ('0RK1Q7V1ON8m', '2019-03-07 17:13:39', '2019-03-14 13:32:50', '删除角色', 'delete:role', 0, '0RK1PsijNB9G');
INSERT INTO `permission` VALUES ('0RK1QaPJMTWJ', '2019-03-07 17:15:30', '2019-03-14 13:33:16', '添加权限', 'add:permission', 0, '0RK1QSQdR0zI');
INSERT INTO `permission` VALUES ('0RK1QBmxR7nr', '2019-03-07 17:13:56', '2019-03-14 13:32:56', '修改角色', 'update:role', 0, '0RK1PsijNB9G');
INSERT INTO `permission` VALUES ('0RK1QcxgOBe8', '2019-03-07 17:15:40', '2019-03-14 13:33:22', '修改权限', 'update:permission', 0, '0RK1QSQdR0zI');
INSERT INTO `permission` VALUES ('0RK1QfsJOKYV', '2019-03-07 17:15:51', '2019-03-14 13:33:29', '删除权限', 'delete:permission', 0, '0RK1QSQdR0zI');
INSERT INTO `permission` VALUES ('0RK1QSQdR0zI', '2019-03-07 17:15:00', '2019-03-14 13:33:06', '权限管理', 'permission', 1, '0RJv6UEeJsHi');
INSERT INTO `permission` VALUES ('0RK1Re9pOp0j', '2019-03-07 17:19:43', '2019-03-14 13:34:09', '授权', 'authorization', 1, '');
INSERT INTO `permission` VALUES ('0RK1RphWKG0f', '2019-03-07 17:20:27', '2019-03-14 13:37:29', '赋予角色权限', 'grant:permission', 0, '0RK1Re9pOp0j');
INSERT INTO `permission` VALUES ('0RK1SCv7OLEE', '2019-03-07 17:21:57', '2019-03-14 13:37:42', '赋予用户角色', 'grant:role', 0, '0RK1Re9pOp0j');
INSERT INTO `permission` VALUES ('0RK1SfCsMpv6', '2019-03-07 17:23:45', '2019-03-14 13:37:51', '添加产品', 'add:product', 0, '0RJv9CfWO6RM');
INSERT INTO `permission` VALUES ('0RK1SrhOKO6j', '2019-03-07 17:24:33', '2019-03-14 13:37:59', '更新产品', 'update:product', 0, '0RJv9CfWO6RM');
INSERT INTO `permission` VALUES ('0RK1SyiBOta0', '2019-03-07 17:25:00', '2019-03-14 13:38:13', '增删产品成员', 'addUser:product', 0, '0RJv9CfWO6RM');
INSERT INTO `permission` VALUES ('0RK1TK4OKth9', '2019-03-07 17:26:22', '2019-03-07 17:26:22', '项目', 'project', 1, '');
INSERT INTO `permission` VALUES ('0RK1U5TRO7sN', '2019-03-07 17:29:25', '2019-03-14 13:38:28', '添加项目', 'add:project', 0, '0RK1TK4OKth9');
INSERT INTO `permission` VALUES ('0RK1Uf7zOloS', '2019-03-07 17:31:42', '2019-03-14 13:38:43', '添加Bug', 'add:bug', 0, '0RK1UXbMMUXK');
INSERT INTO `permission` VALUES ('0RK1UIH5R4tb', '2019-03-07 17:30:14', '2019-03-14 13:38:35', '更新项目', 'update:project', 0, '0RK1TK4OKth9');
INSERT INTO `permission` VALUES ('0RK1UXbMMUXK', '2019-03-07 17:31:13', '2019-03-07 17:31:13', 'Bug', 'bug', 1, '');
INSERT INTO `permission` VALUES ('0RK1Xl9JNUni', '2019-03-07 17:44:00', '2019-03-07 17:44:00', '需求', 'need', 1, '');
INSERT INTO `permission` VALUES ('0RK1Xo7TIgAX', '2019-03-07 17:44:11', '2019-03-14 13:38:53', '添加需求', 'add:need', 0, '0RK1Xl9JNUni');
INSERT INTO `permission` VALUES ('0RKaadqsNvuO', '2019-03-13 17:34:59', '2019-03-14 13:39:39', '查看部门', 'select:department', 0, '0RJv9dWcNXGQ');
INSERT INTO `permission` VALUES ('0RKabB0UJMCe', '2019-03-13 17:37:06', '2019-03-14 13:39:47', '查看用户', 'select:user', 0, '0RK1LmnLOkB1');
INSERT INTO `permission` VALUES ('0RKabdTBQ0q5', '2019-03-13 17:38:55', '2019-03-14 13:40:04', '查看权限', 'select:permission', 0, '0RK1QSQdR0zI');
INSERT INTO `permission` VALUES ('0RKabP2qNReH', '2019-03-13 17:38:00', '2019-03-14 13:39:55', '查看角色', 'select:role', 0, '0RK1PsijNB9G');
INSERT INTO `permission` VALUES ('0RKabvr1PoYA', '2019-03-13 17:40:06', '2019-03-14 13:40:13', '查看产品', 'select:product', 0, '0RJv9CfWO6RM');
INSERT INTO `permission` VALUES ('0RKac9wIQjDI', '2019-03-13 17:41:00', '2019-03-14 13:40:21', '查看项目', 'select:project', 0, '0RK1TK4OKth9');
INSERT INTO `permission` VALUES ('0RKacM9ZPVOO', '2019-03-13 17:41:47', '2019-03-14 13:40:28', '查看Bug', 'select:bug', 0, '0RK1UXbMMUXK');
INSERT INTO `permission` VALUES ('0RKacPAqNO6J', '2019-03-13 17:41:59', '2019-03-14 13:40:36', '查看需求', 'select:need', 0, '0RK1Xl9JNUni');
INSERT INTO `permission` VALUES ('0RKgRvmRMsZX', '2019-03-14 17:38:00', '2019-03-14 17:38:00', '查看登陆日志', 'loginLog', 0, '0RJv6UEeJsHi');
INSERT INTO `permission` VALUES ('0RKT0valWPoQ', '2019-03-12 10:29:13', '2019-03-14 13:39:08', '统计', 'statistic', 1, '');
INSERT INTO `permission` VALUES ('0RKT0zQCZvrn', '2019-03-12 10:29:27', '2019-03-14 13:39:05', '产品统计', 'products:statistic', 0, '0RKT0valWPoQ');
INSERT INTO `permission` VALUES ('0RKT17OmXwH8', '2019-03-12 10:29:58', '2019-03-14 13:39:17', '开发人员统计', 'developer:statistic', 0, '0RKT0valWPoQ');
INSERT INTO `permission` VALUES ('0RKT1A9CWBDQ', '2019-03-12 10:30:08', '2019-03-14 13:39:26', '测试人员统计', 'test:statistic', 0, '0RKT0valWPoQ');
INSERT INTO `permission` VALUES ('0RLDRLZEPdxx', '2019-03-20 09:02:40', '2019-03-20 09:02:40', '删除产品', 'delete:product', 0, '0RJv9CfWO6RM');
INSERT INTO `permission` VALUES ('0RLDWEC2OqB6', '2019-03-20 09:22:04', '2019-03-20 09:22:04', '删除项目', 'delete:project', 0, '0RK1TK4OKth9');

-- ----------------------------
-- 产品表
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
INSERT INTO `product` VALUES ('0RKlxLJTLqLn', '2019-03-15 16:14:08', '2019-03-20 08:49:05', '考核产品1号', '这是考核产品1号');
INSERT INTO `product` VALUES ('0RL7vndSRxnM', '2019-03-19 10:26:00', '2019-03-19 10:26:00', '测试产品', '这是一个测试产');
INSERT INTO `product` VALUES ('0RLDVH7KP4Gh', '2019-03-20 09:18:17', '2019-03-20 09:18:17', 'qwe', 'qwe');
INSERT INTO `product` VALUES ('0RLG86MPN0R8', '2019-03-20 20:05:03', '2019-03-20 20:05:12', 'asdf', 'wqeacsff');

-- ----------------------------
-- 产品成员表
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
INSERT INTO `product_member` VALUES ('0RKlxLJUL7zi', '2019-03-15 16:14:08', '2019-03-15 16:14:08', '0RKlxLJTLqLn', '0RKlrP1EOEdT');
INSERT INTO `product_member` VALUES ('0RKlxLJVLffV', '2019-03-15 16:14:08', '2019-03-15 16:14:08', '0RKlxLJTLqLn', '0RKls0EXLIPj');
INSERT INTO `product_member` VALUES ('0RKlyZQiLiz1', '2019-03-15 16:19:01', '2019-03-15 16:19:01', '0RKlxLJTLqLn', '0RJpq3vXMd0m');
INSERT INTO `product_member` VALUES ('0RKnRNIbOryL', '2019-03-15 22:19:42', '2019-03-15 22:19:42', '0RKlxLJTLqLn', '0RKlrdvSLysq');
INSERT INTO `product_member` VALUES ('0RL7vndTR9SL', '2019-03-19 10:26:00', '2019-03-19 10:26:00', '0RL7vndSRxnM', '0RJpq3vXMd0m');
INSERT INTO `product_member` VALUES ('0RL7vndTRlbP', '2019-03-19 10:26:00', '2019-03-19 10:26:00', '0RL7vndSRxnM', '0RKlrP1EOEdT');
INSERT INTO `product_member` VALUES ('0RL7vndURkkA', '2019-03-19 10:26:00', '2019-03-19 10:26:00', '0RL7vndSRxnM', '0RKlrZR4O9SZ');
INSERT INTO `product_member` VALUES ('0RL7vndURyrR', '2019-03-19 10:26:00', '2019-03-19 10:26:00', '0RL7vndSRxnM', '0RKlrTZ8LsvU');
INSERT INTO `product_member` VALUES ('0RL7vndVR0E4', '2019-03-19 10:26:00', '2019-03-19 10:26:00', '0RL7vndSRxnM', '0RKlrdvSLysq');
INSERT INTO `product_member` VALUES ('0RL7vndWRsO9', '2019-03-19 10:26:00', '2019-03-19 10:26:00', '0RL7vndSRxnM', '0RKls0EXLIPj');
INSERT INTO `product_member` VALUES ('0RL7vndWRU6m', '2019-03-19 10:26:00', '2019-03-19 10:26:00', '0RL7vndSRxnM', '0RKlrlmhOLUz');
INSERT INTO `product_member` VALUES ('0RL7vndXRPgU', '2019-03-19 10:26:00', '2019-03-19 10:26:00', '0RL7vndSRxnM', '0RL7c6UrNnGD');
INSERT INTO `product_member` VALUES ('0RL7vqGlJmXc', '2019-03-19 10:26:10', '2019-03-19 10:26:10', '0RL7vndSRxnM', '0RKlrhKFNoCc');
INSERT INTO `product_member` VALUES ('0RL7wvTcR6W0', '2019-03-19 10:30:29', '2019-03-19 10:30:29', '0RKlxLJTLqLn', '0RKlrhKFNoCc');
INSERT INTO `product_member` VALUES ('0RLDNs6XPd9T', '2019-03-20 08:48:52', '2019-03-20 08:48:52', '0RKlxLJTLqLn', '0RL7c6UrNnGD');
INSERT INTO `product_member` VALUES ('0RLDUkIEPHno', '2019-03-20 09:16:10', '2019-03-20 09:16:10', '0RLDUkIDPFfW', 'null');
INSERT INTO `product_member` VALUES ('0RLDV2KQN1Nf', '2019-03-20 09:17:20', '2019-03-20 09:17:20', '0RLDV2KPNs5D', 'null');
INSERT INTO `product_member` VALUES ('0RLDVB7KOdIo', '2019-03-20 09:17:54', '2019-03-20 09:17:54', '0RLDVB7JOgM5', 'null');
INSERT INTO `product_member` VALUES ('0RLEl0p6P2p2', '2019-03-20 14:27:04', '2019-03-20 14:27:04', '0RLDVH7KP4Gh', '0RJpq3vXMd0m');
INSERT INTO `product_member` VALUES ('0RLEl0p7PLnz', '2019-03-20 14:27:04', '2019-03-20 14:27:04', '0RLDVH7KP4Gh', '0RKlrP1EOEdT');
INSERT INTO `product_member` VALUES ('0RLEl0p7POl6', '2019-03-20 14:27:04', '2019-03-20 14:27:04', '0RLDVH7KP4Gh', '0RKlrTZ8LsvU');
INSERT INTO `product_member` VALUES ('0RLG86MQNX0l', '2019-03-20 20:05:03', '2019-03-20 20:05:03', '0RLG86MPN0R8', '0RJpq3vXMd0m');
INSERT INTO `product_member` VALUES ('0RLG86MRNPAk', '2019-03-20 20:05:03', '2019-03-20 20:05:03', '0RLG86MPN0R8', '0RL7c6UrNnGD');

-- ----------------------------
-- 项目表
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
INSERT INTO `project` VALUES ('0RKlxfcDMP9J', '2019-03-15 16:15:27', '2019-03-15 16:15:27', '2019-02-21', '2019-03-31', '0RKlxLJTLqLn', '考核项目1号', 0);
INSERT INTO `project` VALUES ('0RL1x6coMnxv', '2019-03-18 09:53:33', '2019-03-18 09:53:33', '2019-03-07', '2019-03-24', '0RKlxLJTLqLn', '考核项目1', 0);
INSERT INTO `project` VALUES ('0RL7w7PeR20t', '2019-03-19 10:27:16', '2019-03-19 10:27:24', '2019-03-01', '2019-03-24', '0RL7vndSRxnM', '测试项目1', 0);
INSERT INTO `project` VALUES ('0RLDavgXMOzC', '2019-03-20 09:40:44', '2019-03-20 09:41:38', '2019-03-16', '2019-03-30', '0RLDVH7KP4Gh', 'asdv', 0);
INSERT INTO `project` VALUES ('0RLEiLLPSuuF', '2019-03-20 14:16:27', '2019-03-20 14:16:27', '2019-03-01', '2019-03-31', '0RKlxLJTLqLn', 'qweqweqwe', 0);
INSERT INTO `project` VALUES ('0RLFNzruP3nV', '2019-03-20 17:01:55', '2019-03-20 17:01:55', '2019-03-01', '2019-03-24', '0RKlxLJTLqLn', 'qwe', 0);
INSERT INTO `project` VALUES ('0RLG8C4ZNmJF', '2019-03-20 20:05:25', '2019-03-20 20:05:25', '2019-03-30', '2019-03-03', '0RLG86MPN0R8', 'weqfasv', 0);

-- ----------------------------
-- 角色表
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `addtime` datetime(0) NOT NULL COMMENT '创建时间',
  `updatetime` datetime(0) NOT NULL COMMENT '更新时间',
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `role_name`(`role_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('0RJtkZdSNc7i', '2019-03-06 09:44:43', '2019-03-06 09:44:43', '产品经理');
INSERT INTO `role` VALUES ('0RJtmFzOOPoI', '2019-03-06 09:51:24', '2019-03-06 09:51:24', '项目经理');
INSERT INTO `role` VALUES ('0RJtmN5KNO2Z', '2019-03-06 09:51:52', '2019-03-06 10:11:44', '系统管理员');
INSERT INTO `role` VALUES ('0RJts9c8LcCi', '2019-03-06 10:14:50', '2019-03-12 10:28:14', '测试人员');
INSERT INTO `role` VALUES ('0RKT0hvkZ6qr', '2019-03-12 10:28:20', '2019-03-12 10:28:20', '开发人员');

-- ----------------------------
-- 角色权限表
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `addtime` datetime(0) NOT NULL COMMENT '创建时间',
  `updatetime` datetime(0) NOT NULL COMMENT '更新时间',
  `role_id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色id',
  `permission_id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色-权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('0RKln4NxaBOv', '2019-03-15 15:33:20', '2019-03-15 15:33:20', '0RJts9c8LcCi', '0RJv9CfWO6RM');
INSERT INTO `role_permission` VALUES ('0RKln4NxaCST', '2019-03-15 15:33:20', '2019-03-15 15:33:20', '0RJts9c8LcCi', '0RKabvr1PoYA');
INSERT INTO `role_permission` VALUES ('0RKln4NyalJS', '2019-03-15 15:33:20', '2019-03-15 15:33:20', '0RJts9c8LcCi', '0RKac9wIQjDI');
INSERT INTO `role_permission` VALUES ('0RKln4NyaND4', '2019-03-15 15:33:20', '2019-03-15 15:33:20', '0RJts9c8LcCi', '0RK1UXbMMUXK');
INSERT INTO `role_permission` VALUES ('0RKln4NyapnX', '2019-03-15 15:33:20', '2019-03-15 15:33:20', '0RJts9c8LcCi', '0RK1TK4OKth9');
INSERT INTO `role_permission` VALUES ('0RKln4NyaTyc', '2019-03-15 15:33:20', '2019-03-15 15:33:20', '0RJts9c8LcCi', '0RK1Uf7zOloS');
INSERT INTO `role_permission` VALUES ('0RKln4Nza7xv', '2019-03-15 15:33:20', '2019-03-15 15:33:20', '0RJts9c8LcCi', '0RKacM9ZPVOO');
INSERT INTO `role_permission` VALUES ('0RKln4NzadBs', '2019-03-15 15:33:20', '2019-03-15 15:33:20', '0RJts9c8LcCi', '0RK1Xo7TIgAX');
INSERT INTO `role_permission` VALUES ('0RKln4NzaOtD', '2019-03-15 15:33:20', '2019-03-15 15:33:20', '0RJts9c8LcCi', '0RK1Xl9JNUni');
INSERT INTO `role_permission` VALUES ('0RKln4NzaxXn', '2019-03-15 15:33:20', '2019-03-15 15:33:20', '0RJts9c8LcCi', '0RKacPAqNO6J');
INSERT INTO `role_permission` VALUES ('0RKln4O0aBNj', '2019-03-15 15:33:20', '2019-03-15 15:33:20', '0RJts9c8LcCi', '0RKT17OmXwH8');
INSERT INTO `role_permission` VALUES ('0RKln4O0aePf', '2019-03-15 15:33:20', '2019-03-15 15:33:20', '0RJts9c8LcCi', '0RKT0zQCZvrn');
INSERT INTO `role_permission` VALUES ('0RKln4O0aYyK', '2019-03-15 15:33:20', '2019-03-15 15:33:20', '0RJts9c8LcCi', '0RKT0valWPoQ');
INSERT INTO `role_permission` VALUES ('0RKln4O1ao3c', '2019-03-15 15:33:20', '2019-03-15 15:33:20', '0RJts9c8LcCi', '0RKT1A9CWBDQ');
INSERT INTO `role_permission` VALUES ('0RKln6FIclCs', '2019-03-15 15:33:27', '2019-03-15 15:33:27', '0RJtmFzOOPoI', '0RJv9CfWO6RM');
INSERT INTO `role_permission` VALUES ('0RKln6FIcUwP', '2019-03-15 15:33:27', '2019-03-15 15:33:27', '0RJtmFzOOPoI', '0RKabvr1PoYA');
INSERT INTO `role_permission` VALUES ('0RKln6FJcfZ8', '2019-03-15 15:33:27', '2019-03-15 15:33:27', '0RJtmFzOOPoI', '0RK1U5TRO7sN');
INSERT INTO `role_permission` VALUES ('0RKln6FJck3x', '2019-03-15 15:33:27', '2019-03-15 15:33:27', '0RJtmFzOOPoI', '0RKac9wIQjDI');
INSERT INTO `role_permission` VALUES ('0RKln6FJcLW1', '2019-03-15 15:33:27', '2019-03-15 15:33:27', '0RJtmFzOOPoI', '0RK1TK4OKth9');
INSERT INTO `role_permission` VALUES ('0RKln6FJcQhp', '2019-03-15 15:33:27', '2019-03-15 15:33:27', '0RJtmFzOOPoI', '0RK1UIH5R4tb');
INSERT INTO `role_permission` VALUES ('0RKln6FKcbIP', '2019-03-15 15:33:27', '2019-03-15 15:33:27', '0RJtmFzOOPoI', '0RKacM9ZPVOO');
INSERT INTO `role_permission` VALUES ('0RKln6FKcCBl', '2019-03-15 15:33:27', '2019-03-15 15:33:27', '0RJtmFzOOPoI', '0RK1Xl9JNUni');
INSERT INTO `role_permission` VALUES ('0RKln6FKcT5q', '2019-03-15 15:33:27', '2019-03-15 15:33:27', '0RJtmFzOOPoI', '0RK1Xo7TIgAX');
INSERT INTO `role_permission` VALUES ('0RKln6FKcx3M', '2019-03-15 15:33:27', '2019-03-15 15:33:27', '0RJtmFzOOPoI', '0RK1UXbMMUXK');
INSERT INTO `role_permission` VALUES ('0RKln6FLc5JF', '2019-03-15 15:33:27', '2019-03-15 15:33:27', '0RJtmFzOOPoI', '0RKT0valWPoQ');
INSERT INTO `role_permission` VALUES ('0RKln6FLcg1w', '2019-03-15 15:33:27', '2019-03-15 15:33:27', '0RJtmFzOOPoI', '0RKacPAqNO6J');
INSERT INTO `role_permission` VALUES ('0RKln6FLcIgy', '2019-03-15 15:33:27', '2019-03-15 15:33:27', '0RJtmFzOOPoI', '0RKT0zQCZvrn');
INSERT INTO `role_permission` VALUES ('0RKln6FMckG8', '2019-03-15 15:33:27', '2019-03-15 15:33:27', '0RJtmFzOOPoI', '0RKT17OmXwH8');
INSERT INTO `role_permission` VALUES ('0RKln6FMcZfT', '2019-03-15 15:33:27', '2019-03-15 15:33:27', '0RJtmFzOOPoI', '0RKT1A9CWBDQ');
INSERT INTO `role_permission` VALUES ('0RKlnDXbTCaU', '2019-03-15 15:33:55', '2019-03-15 15:33:55', '0RKT0hvkZ6qr', '0RJv9CfWO6RM');
INSERT INTO `role_permission` VALUES ('0RKlnDXbTcKS', '2019-03-15 15:33:55', '2019-03-15 15:33:55', '0RKT0hvkZ6qr', '0RKabvr1PoYA');
INSERT INTO `role_permission` VALUES ('0RKlnDXbTpDB', '2019-03-15 15:33:55', '2019-03-15 15:33:55', '0RKT0hvkZ6qr', '0RK1TK4OKth9');
INSERT INTO `role_permission` VALUES ('0RKlnDXcTc1M', '2019-03-15 15:33:55', '2019-03-15 15:33:55', '0RKT0hvkZ6qr', '0RK1UXbMMUXK');
INSERT INTO `role_permission` VALUES ('0RKlnDXcTGHm', '2019-03-15 15:33:55', '2019-03-15 15:33:55', '0RKT0hvkZ6qr', '0RK1Xl9JNUni');
INSERT INTO `role_permission` VALUES ('0RKlnDXcTmPN', '2019-03-15 15:33:55', '2019-03-15 15:33:55', '0RKT0hvkZ6qr', '0RKacM9ZPVOO');
INSERT INTO `role_permission` VALUES ('0RKlnDXcTXIX', '2019-03-15 15:33:55', '2019-03-15 15:33:55', '0RKT0hvkZ6qr', '0RKac9wIQjDI');
INSERT INTO `role_permission` VALUES ('0RKlnDXdTbEF', '2019-03-15 15:33:55', '2019-03-15 15:33:55', '0RKT0hvkZ6qr', '0RK1Xo7TIgAX');
INSERT INTO `role_permission` VALUES ('0RKlnDXdTltU', '2019-03-15 15:33:55', '2019-03-15 15:33:55', '0RKT0hvkZ6qr', '0RKT0valWPoQ');
INSERT INTO `role_permission` VALUES ('0RKlnDXdTnWf', '2019-03-15 15:33:55', '2019-03-15 15:33:55', '0RKT0hvkZ6qr', '0RKT0zQCZvrn');
INSERT INTO `role_permission` VALUES ('0RKlnDXdToOA', '2019-03-15 15:33:55', '2019-03-15 15:33:55', '0RKT0hvkZ6qr', '0RKacPAqNO6J');
INSERT INTO `role_permission` VALUES ('0RKlnDXeTp9x', '2019-03-15 15:33:55', '2019-03-15 15:33:55', '0RKT0hvkZ6qr', '0RKT17OmXwH8');
INSERT INTO `role_permission` VALUES ('0RKlnDXeTqIR', '2019-03-15 15:33:55', '2019-03-15 15:33:55', '0RKT0hvkZ6qr', '0RKT1A9CWBDQ');
INSERT INTO `role_permission` VALUES ('0RLDaUnlM8ya', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RJv6UEeJsHi');
INSERT INTO `role_permission` VALUES ('0RLDaUnmMRYz', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RJv9dWcNXGQ');
INSERT INTO `role_permission` VALUES ('0RLDaUnnMs6Y', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RJvAOEbNZFl');
INSERT INTO `role_permission` VALUES ('0RLDaUnoMJLU', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RK1LAUiK5wY');
INSERT INTO `role_permission` VALUES ('0RLDaUnoMza2', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RK1LMElNDsx');
INSERT INTO `role_permission` VALUES ('0RLDaUnpMdT7', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RK1LmnLOkB1');
INSERT INTO `role_permission` VALUES ('0RLDaUnpMxJx', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RKaadqsNvuO');
INSERT INTO `role_permission` VALUES ('0RLDaUnqMaym', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RK1PRkRNHPQ');
INSERT INTO `role_permission` VALUES ('0RLDaUnqMoGu', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RK1M7PdMKEg');
INSERT INTO `role_permission` VALUES ('0RLDaUnrM2pW', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RKabB0UJMCe');
INSERT INTO `role_permission` VALUES ('0RLDaUnrMnfZ', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RK1PVPINvYW');
INSERT INTO `role_permission` VALUES ('0RLDaUnsMutq', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RK1PsijNB9G');
INSERT INTO `role_permission` VALUES ('0RLDaUnsMWj1', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RK1Q531Rvcc');
INSERT INTO `role_permission` VALUES ('0RLDaUntM6nQ', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RK1QBmxR7nr');
INSERT INTO `role_permission` VALUES ('0RLDaUntMJ4h', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RK1Q7V1ON8m');
INSERT INTO `role_permission` VALUES ('0RLDaUnuMdL4', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RKabP2qNReH');
INSERT INTO `role_permission` VALUES ('0RLDaUnvMEw4', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RK1QSQdR0zI');
INSERT INTO `role_permission` VALUES ('0RLDaUnvMFHJ', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RK1QcxgOBe8');
INSERT INTO `role_permission` VALUES ('0RLDaUnvMQ6S', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RK1QaPJMTWJ');
INSERT INTO `role_permission` VALUES ('0RLDaUnwMs9V', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RKabdTBQ0q5');
INSERT INTO `role_permission` VALUES ('0RLDaUnwMYnr', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RK1QfsJOKYV');
INSERT INTO `role_permission` VALUES ('0RLDaUnxM6cP', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RJv9CfWO6RM');
INSERT INTO `role_permission` VALUES ('0RLDaUnxMKbE', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RKgRvmRMsZX');
INSERT INTO `role_permission` VALUES ('0RLDaUnyM3BO', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RK1SrhOKO6j');
INSERT INTO `role_permission` VALUES ('0RLDaUnyMJQv', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RK1SfCsMpv6');
INSERT INTO `role_permission` VALUES ('0RLDaUnzMmQC', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RKabvr1PoYA');
INSERT INTO `role_permission` VALUES ('0RLDaUnzMniA', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RK1SyiBOta0');
INSERT INTO `role_permission` VALUES ('0RLDaUo0Mcf8', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RK1Re9pOp0j');
INSERT INTO `role_permission` VALUES ('0RLDaUo0MRna', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RLDRLZEPdxx');
INSERT INTO `role_permission` VALUES ('0RLDaUo1MAlc', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RK1RphWKG0f');
INSERT INTO `role_permission` VALUES ('0RLDaUo2MCRx', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RK1SCv7OLEE');
INSERT INTO `role_permission` VALUES ('0RLDaUo2MEMJ', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RK1TK4OKth9');
INSERT INTO `role_permission` VALUES ('0RLDaUo3M4cv', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RK1UIH5R4tb');
INSERT INTO `role_permission` VALUES ('0RLDaUo3Miib', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RKac9wIQjDI');
INSERT INTO `role_permission` VALUES ('0RLDaUo3MMLk', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RK1U5TRO7sN');
INSERT INTO `role_permission` VALUES ('0RLDaUo4M2x9', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RK1UXbMMUXK');
INSERT INTO `role_permission` VALUES ('0RLDaUo4Mewt', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RK1Uf7zOloS');
INSERT INTO `role_permission` VALUES ('0RLDaUo4MnbW', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RLDWEC2OqB6');
INSERT INTO `role_permission` VALUES ('0RLDaUo5MG7H', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RK1Xl9JNUni');
INSERT INTO `role_permission` VALUES ('0RLDaUo5Msfg', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RKacM9ZPVOO');
INSERT INTO `role_permission` VALUES ('0RLDaUo6Mfi3', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RK1Xo7TIgAX');
INSERT INTO `role_permission` VALUES ('0RLDaUo6MMu0', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RKacPAqNO6J');
INSERT INTO `role_permission` VALUES ('0RLDaUo6Mvy0', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RKT0valWPoQ');
INSERT INTO `role_permission` VALUES ('0RLDaUo7M9ii', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RKT0zQCZvrn');
INSERT INTO `role_permission` VALUES ('0RLDaUo7MDHd', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RKT17OmXwH8');
INSERT INTO `role_permission` VALUES ('0RLDaUo7Mm6W', '2019-03-20 09:39:01', '2019-03-20 09:39:01', '0RJtmN5KNO2Z', '0RKT1A9CWBDQ');
INSERT INTO `role_permission` VALUES ('0RLDRWNfO71y', '2019-03-20 09:03:22', '2019-03-20 09:03:22', '0RJtkZdSNc7i', '0RJv9CfWO6RM');
INSERT INTO `role_permission` VALUES ('0RLDRWNgOG4A', '2019-03-20 09:03:22', '2019-03-20 09:03:22', '0RJtkZdSNc7i', '0RK1SfCsMpv6');
INSERT INTO `role_permission` VALUES ('0RLDRWNhO37b', '2019-03-20 09:03:22', '2019-03-20 09:03:22', '0RJtkZdSNc7i', '0RK1SrhOKO6j');
INSERT INTO `role_permission` VALUES ('0RLDRWNhOXYl', '2019-03-20 09:03:22', '2019-03-20 09:03:22', '0RJtkZdSNc7i', '0RK1SyiBOta0');
INSERT INTO `role_permission` VALUES ('0RLDRWNiOdr5', '2019-03-20 09:03:22', '2019-03-20 09:03:22', '0RJtkZdSNc7i', '0RKabvr1PoYA');
INSERT INTO `role_permission` VALUES ('0RLDRWNiOQCx', '2019-03-20 09:03:22', '2019-03-20 09:03:22', '0RJtkZdSNc7i', '0RLDRLZEPdxx');
INSERT INTO `role_permission` VALUES ('0RLDRWNjOxvU', '2019-03-20 09:03:22', '2019-03-20 09:03:22', '0RJtkZdSNc7i', '0RK1TK4OKth9');
INSERT INTO `role_permission` VALUES ('0RLDRWNkOaMI', '2019-03-20 09:03:22', '2019-03-20 09:03:22', '0RJtkZdSNc7i', '0RK1U5TRO7sN');
INSERT INTO `role_permission` VALUES ('0RLDRWNlO8kE', '2019-03-20 09:03:22', '2019-03-20 09:03:22', '0RJtkZdSNc7i', '0RKac9wIQjDI');
INSERT INTO `role_permission` VALUES ('0RLDRWNlOKvV', '2019-03-20 09:03:22', '2019-03-20 09:03:22', '0RJtkZdSNc7i', '0RK1UIH5R4tb');
INSERT INTO `role_permission` VALUES ('0RLDRWNmOGqh', '2019-03-20 09:03:22', '2019-03-20 09:03:22', '0RJtkZdSNc7i', '0RKacM9ZPVOO');
INSERT INTO `role_permission` VALUES ('0RLDRWNmOSBH', '2019-03-20 09:03:22', '2019-03-20 09:03:22', '0RJtkZdSNc7i', '0RK1UXbMMUXK');
INSERT INTO `role_permission` VALUES ('0RLDRWNoO08a', '2019-03-20 09:03:22', '2019-03-20 09:03:22', '0RJtkZdSNc7i', '0RK1Xl9JNUni');
INSERT INTO `role_permission` VALUES ('0RLDRWNoOlIS', '2019-03-20 09:03:22', '2019-03-20 09:03:22', '0RJtkZdSNc7i', '0RK1Xo7TIgAX');
INSERT INTO `role_permission` VALUES ('0RLDRWNpO5bS', '2019-03-20 09:03:22', '2019-03-20 09:03:22', '0RJtkZdSNc7i', '0RKacPAqNO6J');
INSERT INTO `role_permission` VALUES ('0RLDRWNpOdNn', '2019-03-20 09:03:22', '2019-03-20 09:03:22', '0RJtkZdSNc7i', '0RKT0valWPoQ');
INSERT INTO `role_permission` VALUES ('0RLDRWNqORTl', '2019-03-20 09:03:22', '2019-03-20 09:03:22', '0RJtkZdSNc7i', '0RKT0zQCZvrn');
INSERT INTO `role_permission` VALUES ('0RLDRWNrOWZh', '2019-03-20 09:03:22', '2019-03-20 09:03:22', '0RJtkZdSNc7i', '0RKT17OmXwH8');
INSERT INTO `role_permission` VALUES ('0RLDRWNrOwZW', '2019-03-20 09:03:22', '2019-03-20 09:03:22', '0RJtkZdSNc7i', '0RKT1A9CWBDQ');

-- ----------------------------
-- 用户表
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `addtime` datetime(0) NOT NULL COMMENT '创建时间',
  `updatetime` datetime(0) NOT NULL COMMENT '更新时间',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户姓名',
  `department_id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门id',
  `job_number` smallint(5) UNSIGNED NOT NULL COMMENT '工号',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `is_stopped` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否已停用',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `job_number`(`job_number`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0RJpq3vXMd0m', '2019-03-05 17:41:26', '2019-03-08 10:46:24', '吴桐', '0RIss2SAVU7n', 1425, 'wut@pvc123.com', '8a2c9f013da41efcd12e54a0c99fb960', 0);
INSERT INTO `user` VALUES ('0RKlrdvSLysq', '2019-03-15 15:51:30', '2019-03-15 15:51:30', '开发1号', '0RIss2SAVU7n', 211, 'dev1@qq.com', '3329e6bdb040567304d741bc397811e0', 0);
INSERT INTO `user` VALUES ('0RKlrhKFNoCc', '2019-03-15 15:51:43', '2019-03-15 15:51:43', '开发2号', '0RIss2SAVU7n', 212, 'dev2@qq.com', 'aabca7cf0dc507792f2a774eab3c8072', 0);
INSERT INTO `user` VALUES ('0RKlrlmhOLUz', '2019-03-15 15:52:00', '2019-03-15 15:52:25', '开发3号', '0RIss2SAVU7n', 213, 'dev3@qq.com', '4c5ba2d5dd8a9ef35ff9791a832b0d78', 0);
INSERT INTO `user` VALUES ('0RKlrP1EOEdT', '2019-03-15 15:50:33', '2019-03-15 15:50:33', '测试1号', '0RKgHWcnOWIx', 111, 'test1@qq.com', '158643ca4c5612128fa27f250155495c', 0);
INSERT INTO `user` VALUES ('0RKlrTZ8LsvU', '2019-03-15 15:50:50', '2019-03-15 15:50:50', '测试2号', '0RKgHWcnOWIx', 112, 'test2@qq.com', '220f25614836abc05a97cea70183bffd', 0);
INSERT INTO `user` VALUES ('0RKlrZR4O9SZ', '2019-03-15 15:51:13', '2019-03-15 15:51:13', '测试3号', '0RKgHWcnOWIx', 1113, 'test3@qq.com', '70f3377ccc8763364c328213eef02b28', 0);
INSERT INTO `user` VALUES ('0RKls0EXLIPj', '2019-03-15 15:52:56', '2019-03-15 15:52:56', '产品经理1号', '0RIss2SAVU7n', 311, 'prod1@qq.com', '3c86bb7b6e082efd0bc46595dafcebf3', 0);
INSERT INTO `user` VALUES ('0RKls4OyNEHb', '2019-03-15 15:53:12', '2019-03-15 15:53:12', '项目经理1号', '0RIss2SAVU7n', 411, 'proj1@qq.com', 'ada1e3a819b76a45a15d61c1e6deecb9', 0);
INSERT INTO `user` VALUES ('0RL7c6UrNnGD', '2019-03-19 09:07:46', '2019-03-19 09:07:46', '吴桐小号', '0RIss2SAVU7n', 1426, '806947301@qq.com', 'eb2ba7da19f1439f17fb78a09e2266fd', 0);

-- ----------------------------
-- 用户角色表
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
INSERT INTO `user_role` VALUES ('0RKls5UCMCDS', '2019-03-15 15:53:16', '2019-03-15 15:53:16', '0RKls4OyNEHb', '0RJtmFzOOPoI');
INSERT INTO `user_role` VALUES ('0RKls6L7Nhrm', '2019-03-15 15:53:19', '2019-03-15 15:53:19', '0RKls0EXLIPj', '0RJtkZdSNc7i');
INSERT INTO `user_role` VALUES ('0RKls7LRMPp2', '2019-03-15 15:53:23', '2019-03-15 15:53:23', '0RKlrlmhOLUz', '0RKT0hvkZ6qr');
INSERT INTO `user_role` VALUES ('0RKls80BLTLr', '2019-03-15 15:53:26', '2019-03-15 15:53:26', '0RKlrhKFNoCc', '0RKT0hvkZ6qr');
INSERT INTO `user_role` VALUES ('0RKls95eL5Pe', '2019-03-15 15:53:30', '2019-03-15 15:53:30', '0RKlrdvSLysq', '0RKT0hvkZ6qr');
INSERT INTO `user_role` VALUES ('0RKls9q9MYBB', '2019-03-15 15:53:33', '2019-03-15 15:53:33', '0RKlrZR4O9SZ', '0RJts9c8LcCi');
INSERT INTO `user_role` VALUES ('0RKlsAZQLbn5', '2019-03-15 15:53:36', '2019-03-15 15:53:36', '0RKlrTZ8LsvU', '0RJts9c8LcCi');
INSERT INTO `user_role` VALUES ('0RKlsBIcLHvG', '2019-03-15 15:53:38', '2019-03-15 15:53:38', '0RKlrP1EOEdT', '0RJts9c8LcCi');
INSERT INTO `user_role` VALUES ('0RKlyevaQOU4', '2019-03-15 16:19:22', '2019-03-15 16:19:22', '0RJpq3vXMd0m', '0RKT0hvkZ6qr');
INSERT INTO `user_role` VALUES ('0RL7woQ9TkQR', '2019-03-19 10:30:01', '2019-03-19 10:30:01', '0RKlrhKFNoCc', '0RJtkZdSNc7i');
INSERT INTO `user_role` VALUES ('0RL7woSkRClv', '2019-03-19 10:30:02', '2019-03-19 10:30:02', '0RKlrhKFNoCc', '0RJtmFzOOPoI');
INSERT INTO `user_role` VALUES ('0RL7woVCWqlR', '2019-03-19 10:30:02', '2019-03-19 10:30:02', '0RKlrhKFNoCc', '0RJtmN5KNO2Z');
INSERT INTO `user_role` VALUES ('0RL7woXgR6PL', '2019-03-19 10:30:02', '2019-03-19 10:30:02', '0RKlrhKFNoCc', '0RJts9c8LcCi');
INSERT INTO `user_role` VALUES ('0RLG7XVUNUUO', '2019-03-20 20:02:49', '2019-03-20 20:02:49', '0RL7c6UrNnGD', '0RKT0hvkZ6qr');

SET FOREIGN_KEY_CHECKS = 1;
