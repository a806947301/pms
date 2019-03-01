CREATE DATABASE pms DEFAULT CHARACTER SET utf8;

USE pms;

DROP TABLE IF EXISTS user;
CREATE TABLE user(
    id CHAR (12) PRIMARY KEY COMMENT 'id',
    addtime DATETIME NOT NULL COMMENT '创建时间',
    updatetime DATETIME NOT NULL COMMENT '更新时间',
    name VARCHAR(20) NOT NULL COMMENT '用户姓名',
    department_id CHAR(12) NOT NULL COMMENT '部门id',
    job_number SMALLINT UNSIGNED UNIQUE COMMENT '工号',
    email VARCHAR(30) UNIQUE COMMENT '邮箱',
    password CHAR(32) NOT NULL COMMENT '密码'
)COMMENT '用户表';

DROP TABLE IF EXISTS role;
CREATE TABLE role(
    id CHAR (12) PRIMARY KEY COMMENT 'id',
    addtime DATETIME NOT NULL COMMENT '创建时间',
    updatetime DATETIME NOT NULL COMMENT '更新时间',
    role_name varchar(20) NOT NULL COMMENT '角色名',
    role_field varchar(20) NOT NULL COMMENT '角色字段'
)COMMENT '角色表';

DROP TABLE IF EXISTS premission;
CREATE TABLE premission(
    id CHAR (12) PRIMARY KEY COMMENT 'id',
    addtime DATETIME NOT NULL COMMENT '创建时间',
    updatetime DATETIME NOT NULL COMMENT '更新时间',
    premission_name VARCHAR(20) NOT NULL COMMENT '权限名',
   premission_field VARCHAR(20) NOT NULL COMMENT '权限字段'
)COMMENT '权限表';

DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role(
    id CHAR (12) PRIMARY KEY COMMENT 'id',
    addtime DATETIME NOT NULL COMMENT '创建时间',
    updatetime DATETIME NOT NULL COMMENT '添加时间',
    user_id CHAR(12) NOT NULL COMMENT '用户id',
    role_id CHAR(12) NOT NULL COMMENT '角色id'
)COMMENT '用户-角色表';

DROP TABLE IF EXISTS Role_Premission;
CREATE TABLE Role_Premission(
    id CHAR (12) PRIMARY KEY COMMENT 'id',
    addtime DATETIME NOT NULL COMMENT '创建时间',
    updatetime DATETIME NOT NULL COMMENT '更新时间',
    role_id CHAR(12) NOT NULL COMMENT '角色id',
    premission_id CHAR(12) NOT NULL COMMENT '权限id'
)COMMENT '角色-权限表';

DROP TABLE IF EXISTS department;
CREATE TABLE department(
    id CHAR (12) PRIMARY KEY COMMENT 'id',
    addtime DATETIME NOT NULL COMMENT '创建时间',
    updatetime DATETIME NOT NULL COMMENT '更新时间',
    department_name VARCHAR(20) NOT NULL COMMENT '部门名'
)COMMENT '部门表';

DROP TABLE IF EXISTS login_log;
CREATE TABLE login_log(
    id CHAR (12) PRIMARY KEY COMMENT 'id',
    addtime DATETIME NOT NULL COMMENT '创建时间',
    updatetime DATETIME NOT NULL COMMENT '更新时间',
    user_id CHAR(12) NOT NULL COMMENT '登录用户id'
)COMMENT '登录日志表';

DROP TABLE IF EXISTS product;
CREATE TABLE product(
    id CHAR (12) PRIMARY KEY COMMENT 'id',
    addtime DATETIME NOT NULL COMMENT '创建时间',
    updatetime DATETIME NOT NULL COMMENT '更新时间',
    product_name VARCHAR(20) NOT NULL COMMENT '产品名',
    product_presentation VARCHAR(1000) NOT NULL COMMENT '产品介绍'
)COMMENT '产品表';

DROP TABLE IF EXISTS product_member;
CREATE TABLE product_member(
    id CHAR (12) PRIMARY KEY COMMENT 'id',
    addtime DATETIME NOT NULL COMMENT '创建时间',
    updatetime DATETIME NOT NULL COMMENT '更新时间',
    product_id CHAR (12) NOT NULL COMMENT '产品id',
    user_id CHAR (12) NOT NULL COMMENT '用户id'
)COMMENT '产品成员表';

DROP TABLE IF EXISTS project;
CREATE TABLE project(
    id CHAR (12) PRIMARY KEY COMMENT 'id',
    addtime DATETIME NOT NULL COMMENT '创建时间',
    updatetime DATETIME NOT NULL COMMENT '更新时间',
    begindate DATE NOT NULL COMMENT '项目开始时间',
    enddate DATE COMMENT '项目结束时间',
    product_id CHAR(12) NOT NULL COMMENT '所属产品id',
    project_name VARCHAR(20) NOT NULL COMMENT '项目名',
    is_finished TINYINT UNSIGNED NOT NULL COMMENT '是否已经完成'
)COMMENT '项目表';

DROP TABLE IF EXISTS bug;
CREATE TABLE bug(
    id CHAR (12) PRIMARY KEY COMMENT 'id',
    addtime DATETIME NOT NULL COMMENT '创建时间',
    updatetime DATETIME NOT NULL COMMENT '更新时间',
    project_id CHAR (12) NOT NULL COMMENT '项目id',
    is_noprocessing TINYINT UNSIGNED NOT NULL COMMENT '是否不予处理',
    bug_status TINYINT UNSIGNED NOT NULL COMMENT 'bug状态 0.指派中	1.处理中	2.验收中	3.已完成',
    bug_title VARCHAR(100) NOT NULL COMMENT 'bug详情',
    bug_content VARCHAR(1000) NOT NULL COMMENT 'bug描述',
    bug_proposer CHAR(12) NOT NULL COMMENT '提出bug用户的id',
    bug_processer CHAR(12) NOT NULL COMMENT '处理bug用户的id'
)COMMENT 'bug表';

DROP TABLE IF EXISTS bug_description;
CREATE TABLE bug_description(
    id CHAR (12) PRIMARY KEY COMMENT 'id',
    addtime DATETIME NOT NULL COMMENT '创建时间',
    updatetime DATETIME NOT NULL COMMENT '更新时间',
    bug_id CHAR(12) NOT NULL COMMENT 'bug id',
    content VARCHAR(1000) NOT NULL COMMENT '说明内容'
)COMMENT 'bug说明表';

DROP TABLE IF EXISTS bug_operating_record;
CREATE TABLE bug_operating_record(
    id CHAR (12) PRIMARY KEY COMMENT 'id',
    addtime DATETIME NOT NULL COMMENT '创建时间',
    updatetime DATETIME NOT NULL COMMENT '更新时间',
    user_id CHAR(12) NOT NULL COMMENT '',
    operation_number TINYINT UNSIGNED NOT NULL COMMENT '',
    bug_id CHAR(12) NOT NULL COMMENT '',
    operation_user_id CHAR(12) NOT NULL COMMENT ''
)COMMENT 'bug操作记录表';

DROP TABLE IF EXISTS need;
CREATE TABLE need(
    id CHAR (12) PRIMARY KEY COMMENT 'id',
    addtime DATETIME NOT NULL COMMENT '创建时间',
    updatetime DATETIME NOT NULL COMMENT '更新时间',
    file_path VARCHAR(300) NOT NULL COMMENT '需求文件地址',
    user_id CHAR(12) NOT NULL COMMENT '提出需求的用户id',
    need_name VARCHAR(50) NOT NULL COMMIT '需求名',
    need_description VARCHAR(1000) NOT NULL COMMENT '需求的文字描述',
    project_id CHAR(12) NOT NULL COMMENT '项目Id'
)COMMENT '需求表';
/*
DROP TABLE IF EXISTS student;
CREATE TABLE student(
    id INT (12) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
    name VARCHAR(128) NOT NULL COMMENT '学生名称',
    age SMALLINT NOT NULL DEFAULT 0 COMMENT '年龄',
    create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
    update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间'
)COMMENT '用户表';
INSERT INTO student(name,age)
VALUES ('张三',15),
       ('李四',16),
       ('王五',17);
*/





