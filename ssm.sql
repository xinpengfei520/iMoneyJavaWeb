/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2017-07-05 16:37:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for log_info
-- ----------------------------
DROP TABLE IF EXISTS `log_info`;
CREATE TABLE `log_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `msg` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log_info
-- ----------------------------
INSERT INTO `log_info` VALUES ('1', '2017-06-22 13:54:15', '用户 x-sir 注册成功...');
INSERT INTO `log_info` VALUES ('2', '2017-06-22 13:54:42', 'x-sir登录成功...');
INSERT INTO `log_info` VALUES ('3', '2017-06-22 15:32:14', 'x-sir登录成功...');
INSERT INTO `log_info` VALUES ('4', '2017-06-22 15:33:55', '用户 Wang 注册成功...');
INSERT INTO `log_info` VALUES ('5', '2017-06-22 15:34:04', 'Wang登录成功...');
INSERT INTO `log_info` VALUES ('6', '2017-06-27 08:36:31', 'x-sir登录成功...');
INSERT INTO `log_info` VALUES ('7', '2017-06-27 08:37:09', '用户Lin注册成功...');
INSERT INTO `log_info` VALUES ('8', '2017-06-27 08:37:19', 'Lin登录成功...');
INSERT INTO `log_info` VALUES ('9', '2017-06-27 15:49:42', '存在ID为 3 的用户，查询成功...');
INSERT INTO `log_info` VALUES ('10', '2017-06-27 15:51:08', '存在ID为 3 的用户，查询成功...');
INSERT INTO `log_info` VALUES ('11', '2017-06-27 15:52:18', '存在ID为 3 的用户，查询成功...');
INSERT INTO `log_info` VALUES ('12', '2017-06-30 08:23:43', '存在ID为 3 的用户，查询成功...');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(30) DEFAULT NULL,
  `passwd` varchar(30) DEFAULT NULL,
  `gentle` varchar(10) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'x-sir', '123', '男', 'x-sir@qq.com', 'Shanghai');
INSERT INTO `user_info` VALUES ('2', 'Jack', '123', 'nan', '123@qq.com', 'beijing');
INSERT INTO `user_info` VALUES ('3', 'Lin', '123', '男', 'lin@163.com', '大同');
INSERT INTO `user_info` VALUES ('36', 'x-sir', '123', '男', 'x-sir@qq.com', 'Shanghai');
INSERT INTO `user_info` VALUES ('37', 'Lee', '123', '男', 'wang@qq.com', '沈阳');
INSERT INTO `user_info` VALUES ('38', 'x-sir', '123', '男', 'x-sir@qq.com', 'Shanghai');
INSERT INTO `user_info` VALUES ('39', 'x-sir', '123', '男', 'x-sir@qq.com', 'Shanghai');
INSERT INTO `user_info` VALUES ('40', 'x-sir', '123', '男', 'x-sir@qq.com', 'Shanghai');
INSERT INTO `user_info` VALUES ('41', 'x-sir', '123', '男', 'x-sir@qq.com', 'Shanghai');
INSERT INTO `user_info` VALUES ('42', 'x-sir', '123', '男', 'x-sir@qq.com', 'Shanghai');
INSERT INTO `user_info` VALUES ('43', 'x-sir', '123', '男', 'x-sir@qq.com', 'Shanghai');
INSERT INTO `user_info` VALUES ('44', 'x-sir', '123', '男', 'x-sir@qq.com', 'Shanghai');
INSERT INTO `user_info` VALUES ('45', 'x-sir', '123', '男', 'x-sir@qq.com', 'Shanghai');
INSERT INTO `user_info` VALUES ('46', 'x-sir', '123', '男', 'x-sir@qq.com', 'Shanghai');
INSERT INTO `user_info` VALUES ('47', 'x-sir', '123', '男', 'x-sir@qq.com', 'Shanghai');
INSERT INTO `user_info` VALUES ('48', 'x-sir', '123', '男', 'x-sir@qq.com', 'Shanghai');
INSERT INTO `user_info` VALUES ('49', 'x-sir', '123', '男', 'x-sir@qq.com', 'Shanghai');
INSERT INTO `user_info` VALUES ('50', 'x-sir', '123', '男', 'x-sir@qq.com', 'Shanghai');
INSERT INTO `user_info` VALUES ('51', 'x-sir', '123', '男', 'x-sir@qq.com', 'Shanghai');
INSERT INTO `user_info` VALUES ('52', 'x-sir', '123', '男', 'x-sir@qq.com', 'Shanghai');
INSERT INTO `user_info` VALUES ('53', 'oo', '123', '男', 'x-sir@qq.com', 'Shanghai');
INSERT INTO `user_info` VALUES ('54', 'o', '123', '男', 'x-sir@qq.com', 'Shanghai');
INSERT INTO `user_info` VALUES ('55', 'Wang', '123', '男', 'x-sir@qq.com', 'Shanghai');
INSERT INTO `user_info` VALUES ('56', 'Wang', '123', '男', 'x-sir@qq.com', 'Shanghai');
INSERT INTO `user_info` VALUES ('57', 'Wang', '123', '男', 'x-sir@qq.com', 'Shanghai');
