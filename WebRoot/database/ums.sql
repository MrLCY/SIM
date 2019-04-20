/*
Navicat MySQL Data Transfer

Source Server         : MySQL5.5
Source Server Version : 50500
Source Host           : localhost:3306
Source Database       : ums

Target Server Type    : MYSQL
Target Server Version : 50500
File Encoding         : 65001

Date: 2016-02-01 10:37:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adminId` varchar(50) NOT NULL COMMENT '登录号',
  `adminname` varchar(50) DEFAULT NULL COMMENT '姓名',
  `adminpwd` varchar(50) NOT NULL COMMENT '密码',
  `roleid` int(11) NOT NULL COMMENT '角色id',
  `admintel` varchar(50) DEFAULT NULL COMMENT '电话',
  `admindate` date DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`),
  KEY `admin_role` (`roleid`),
  CONSTRAINT `admin_role` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员');
INSERT INTO `role` VALUES ('2', '教师');
INSERT INTO `role` VALUES ('3', '学生');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentid` varchar(10) NOT NULL COMMENT '学号',
  `studentname` varchar(50) NOT NULL COMMENT '姓名',
  `roleid` int(11) NOT NULL,
  `majorid` varchar(10) NOT NULL COMMENT '专业id-待扩展外键',
  PRIMARY KEY (`id`),
  UNIQUE KEY `studentid` (`studentid`),
  KEY `student_role` (`roleid`),
  CONSTRAINT `student_role` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacherID` varchar(50) NOT NULL COMMENT '登录号',
  `teacherName` varchar(50) NOT NULL COMMENT '姓名',
  `teacherPwd` varchar(50) NOT NULL COMMENT '密码',
  `roleId` int(11) DEFAULT NULL COMMENT '角色id',
  `deptId` varchar(10) DEFAULT NULL COMMENT '系id-待扩展外键',
  `teacherTel` varchar(50) DEFAULT NULL COMMENT '电话',
  `teacherDate` date DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `teacherid` (`teacherID`),
  KEY `teacher_role` (`roleId`),
  CONSTRAINT `teacher_role` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
