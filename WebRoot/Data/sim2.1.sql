/*
Navicat MySQL Data Transfer

Source Server         : FirstConnect
Source Server Version : 50500
Source Host           : 127.0.0.1:3306
Source Database       : sim2.1

Target Server Type    : MYSQL
Target Server Version : 50500
File Encoding         : 65001

Date: 2019-04-16 12:24:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `adminno` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '杨迪', '10001', 'admin');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coursename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', 'JavaWeb编程');
INSERT INTO `course` VALUES ('2', '计算机网络');
INSERT INTO `course` VALUES ('3', 'Android编程');
INSERT INTO `course` VALUES ('4', '数据库原理与设计');
INSERT INTO `course` VALUES ('6', '软件测试');
INSERT INTO `course` VALUES ('8', '软件工程');
INSERT INTO `course` VALUES ('9', '11');
INSERT INTO `course` VALUES ('10', '22');
INSERT INTO `course` VALUES ('11', '英语四级');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `birthday` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `nativeplace` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `studentno` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('2', '2019-04-14', '2234@qq.com', '2c:image', '湖北2', 'password2', 'Mr.Li2', '20160012', '21368898');
INSERT INTO `student` VALUES ('4', '2019-04-14', '4234@qq.com', '4c:image', '湖北4', 'password4', 'Mr.Li4', '20160014', '41368898');
INSERT INTO `student` VALUES ('5', '2019-04-14', '5234@qq.com', '5c:image', '湖北5', 'password5', 'Mr.Li5', '20160015', '51368898');
INSERT INTO `student` VALUES ('6', '2019-04-14', '6234@qq.com', '6c:image', '湖北6', 'password6', 'Mr.Li6', '20160016', '61368898');
INSERT INTO `student` VALUES ('7', '2019-04-14', '7234@qq.com', '7c:image', '湖北7', 'password7', 'Mr.Li7', '20160017', '71368898');
INSERT INTO `student` VALUES ('8', '2019-04-14', '8234@qq.com', '8c:image', '湖北8', 'password8', 'Mr.Li8', '20160018', '81368898');
INSERT INTO `student` VALUES ('9', '2019-04-14', '9234@qq.com', '9c:image', '湖北9', 'password9', 'Mr.Li9', '20160019', '91368898');
INSERT INTO `student` VALUES ('10', '2019-04-14', '10234@qq.com', '10c:image', '湖北10', 'password10', 'Mr.Li10', '201600110', '101368898');
INSERT INTO `student` VALUES ('11', '2019-04-14', '11234@qq.com', '11c:image', '湖北11', 'password11', 'Mr.Li11', '201600111', '111368898');
INSERT INTO `student` VALUES ('12', '2019-04-14', '12234@qq.com', '12c:image', '湖北12', 'password12', 'Mr.Li12', '201600112', '121368898');
INSERT INTO `student` VALUES ('14', '2019-04-14', '14234@qq.com', '14c:image', '湖北14', 'password14', 'Mr.Li14', '201600114', '141368898');
INSERT INTO `student` VALUES ('15', '2019-04-14', '15234@qq.com', '15c:image', '湖北15', 'password15', 'Mr.Li15', '201600115', '151368898');
INSERT INTO `student` VALUES ('16', '2019-04-14', '16234@qq.com', '16c:image', '湖北16', 'password16', 'Mr.Li16', '201600116', '161368898');
INSERT INTO `student` VALUES ('17', '2019-04-14', '17234@qq.com', '17c:image', '湖北17', 'password17', 'Mr.Li17', '201600117', '171368898');
INSERT INTO `student` VALUES ('18', '2019-04-14', '18234@qq.com', '18c:image', '湖北18', 'password18', 'Mr.Li18', '201600118', '181368898');

-- ----------------------------
-- Table structure for student_course
-- ----------------------------
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKB0A3729FFD2CA3B9` (`student_id`),
  KEY `FKB0A3729FDA97201B` (`course_id`),
  CONSTRAINT `FKB0A3729FDA97201B` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
  CONSTRAINT `FKB0A3729FFD2CA3B9` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_course
-- ----------------------------
INSERT INTO `student_course` VALUES ('2', '2', '1');
INSERT INTO `student_course` VALUES ('8', '4', '1');
INSERT INTO `student_course` VALUES ('9', '5', '1');
INSERT INTO `student_course` VALUES ('10', '6', '1');
INSERT INTO `student_course` VALUES ('11', '7', '1');
INSERT INTO `student_course` VALUES ('12', '8', '1');
INSERT INTO `student_course` VALUES ('13', '9', '1');
INSERT INTO `student_course` VALUES ('14', '10', '1');
INSERT INTO `student_course` VALUES ('15', '11', '1');
INSERT INTO `student_course` VALUES ('16', '12', '1');
INSERT INTO `student_course` VALUES ('21', '2', '8');
INSERT INTO `student_course` VALUES ('23', '12', '2');
INSERT INTO `student_course` VALUES ('25', '2', '8');
INSERT INTO `student_course` VALUES ('26', '2', '2');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `teacherid` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '1234', 'LIHENG', '02', 'MRLI');
INSERT INTO `teacher` VALUES ('3', '123456', '孙越', '00003', 'MR.SUN');
INSERT INTO `teacher` VALUES ('4', '1111', '李英', '00001', 'MRLI');

-- ----------------------------
-- Table structure for teacher_course
-- ----------------------------
DROP TABLE IF EXISTS `teacher_course`;
CREATE TABLE `teacher_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK40C04F18DC7EE59` (`teacher_id`),
  KEY `FK40C04F18DA97201B` (`course_id`),
  CONSTRAINT `FK40C04F18DA97201B` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
  CONSTRAINT `FK40C04F18DC7EE59` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher_course
-- ----------------------------
INSERT INTO `teacher_course` VALUES ('1', '1', '1');
INSERT INTO `teacher_course` VALUES ('2', '3', '1');
INSERT INTO `teacher_course` VALUES ('3', '2', '1');
INSERT INTO `teacher_course` VALUES ('6', '4', '1');
INSERT INTO `teacher_course` VALUES ('8', '6', '1');
INSERT INTO `teacher_course` VALUES ('10', '8', '1');
INSERT INTO `teacher_course` VALUES ('14', '11', '4');
