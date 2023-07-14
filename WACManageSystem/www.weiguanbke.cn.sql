# Host: localhost  (Version: 5.5.47)
# Date: 2022-07-24 13:33:00
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "admin"
#

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_account` int(11) NOT NULL COMMENT '管理员账号',
  `admin_password` varchar(255) DEFAULT NULL COMMENT '管理员密码',
  PRIMARY KEY (`admin_account`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Data for table "admin"
#

INSERT INTO `admin` VALUES (1001,'weiguanke'),(1002,'123456'),(1003,'123456');

#
# Structure for table "class_order"
#

DROP TABLE IF EXISTS `class_order`;
CREATE TABLE `class_order` (
  `class_order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '报名表id',
  `class_id` int(11) DEFAULT NULL COMMENT '课程id',
  `class_name` varchar(255) DEFAULT NULL COMMENT '课程名称',
  `coach` varchar(255) DEFAULT NULL COMMENT '教练',
  `member_name` varchar(255) DEFAULT NULL COMMENT '会员姓名',
  `member_account` int(11) DEFAULT NULL COMMENT '会员账号',
  `class_begin` varchar(255) DEFAULT NULL COMMENT '开课时间',
  PRIMARY KEY (`class_order_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Data for table "class_order"
#

INSERT INTO `class_order` VALUES (1,2,'瑜伽','瑜伽教练','李四',202200788,'2022年1月2日 10:20'),(2,2,'瑜伽','瑜伽教练','王五',2022232539,'2022年1月2日 10:20'),(3,4,'运动康复','运动康复教练','Mike',202256754,'2022年2月2日 10:00'),(4,1,'增肌','增肌教练','Mike',202256754,'2022年1月1日 15:00'),(5,1,'增肌','增肌教练','Tylor',202283406,'2022年1月1日 15:00'),(6,2,'瑜伽','瑜伽教练','Tylor',202283406,'2022年1月2日 10:20'),(7,1,'增肌','增肌教练','李四',202200788,'2022年1月1日 15:00'),(8,1,'增肌','增肌教练','马六',202286416,'2022年1月1日 15:00'),(9,3,'减脂','减脂教练','马六',202286416,'2022年3月6日 18:00'),(10,3,'减脂','减脂教练','Lily',202223664,'2022年3月6日 18:00'),(11,3,'减脂','减脂教练','Emma',202253468,'2022年3月6日 18:00'),(15,7,'普拉提','普拉提教练','张三',202209867,'2022年3月1日 17:30'),(16,2,'瑜伽','瑜伽教练','张三',202209867,'2022年1月2日 10:20');

#
# Structure for table "class_table"
#

DROP TABLE IF EXISTS `class_table`;
CREATE TABLE `class_table` (
  `class_id` int(11) NOT NULL DEFAULT '0' COMMENT '课程id',
  `class_name` varchar(255) DEFAULT NULL COMMENT '课程名称',
  `class_begin` varchar(255) DEFAULT NULL COMMENT '开课时间',
  `class_time` varchar(255) DEFAULT NULL COMMENT '课程时长',
  `coach` varchar(255) DEFAULT NULL COMMENT '教练',
  PRIMARY KEY (`class_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Data for table "class_table"
#

INSERT INTO `class_table` VALUES (1,'增肌','2022年4月1日 15:00','60分钟','增肌教练'),(2,'瑜伽','2022年4月2日 10:20','90分钟','瑜伽教练'),(3,'减脂','2022年4月6日 18:00','90分钟','减脂教练'),(4,'运动康复','2022年4月2日 10:00','45分钟','运动康复教练'),(5,'综合格斗','2022年4月3日 15:00','60分钟','综合格斗教练'),(6,'塑形','2022年4月3日 15:00','60分钟','塑形教练'),(7,'普拉提','2022年4月1日 17:30','60分钟','普拉提教练'),(8,'爵士舞','2022年4月22日 09:00','90分钟','爵士舞教练'),(9,'杠铃操','2022年4月4日 15:00','60分钟','杠铃操教练'),(10,'动感单车','2022年4月8日 15:00','45分钟','动感单车教练'),(11,'健美操','2022年4月22日 18:00','60分钟','健美操教练'),(12,'1','2022年4月7日 09:30','20分钟','张教练');

#
# Structure for table "employee"
#

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `employee_account` int(11) NOT NULL COMMENT '员工账号',
  `employee_password` varchar(255) DEFAULT NULL,
  `employee_name` varchar(255) DEFAULT NULL COMMENT '员工姓名',
  `employee_gender` varchar(255) DEFAULT NULL COMMENT '员工性别',
  `employee_age` int(11) DEFAULT NULL COMMENT '员工年龄',
  `entry_time` date DEFAULT NULL COMMENT '入职时间',
  `staff` varchar(255) DEFAULT NULL COMMENT '职务',
  `employee_message` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`employee_account`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Data for table "employee"
#

INSERT INTO `employee` VALUES (101034208,'123456','保洁2','女',48,'2010-08-01','保洁员',''),(101038721,'123456','教练1','女',26,'2016-06-29','健身教练','健美冠军'),(101045354,'123456','教练4','男',24,'2021-01-07','健身教练','职业教练'),(101053687,'123456','教练3','男',30,'2020-06-06','健身教练','职业教练'),(101058973,'123456','保洁1','女',48,'2019-08-24','保洁员','模范员工'),(101068283,'123456','教练2','男',34,'2020-01-06','健身教练','职业教练');

#
# Structure for table "eq_order"
#

DROP TABLE IF EXISTS `eq_order`;
CREATE TABLE `eq_order` (
  `eq_order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '报名表id',
  `eq_id` int(11) DEFAULT NULL COMMENT '课程id',
  `eq_name` varchar(255) DEFAULT NULL COMMENT '课程名称',
  `coach` varchar(255) DEFAULT NULL COMMENT '教练',
  `member_name` varchar(255) DEFAULT NULL COMMENT '会员姓名',
  `member_account` int(11) DEFAULT NULL COMMENT '会员账号',
  `eq_begin` varchar(255) DEFAULT NULL COMMENT '开课时间',
  `eq_date` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`eq_order_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=328 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Data for table "eq_order"
#

INSERT INTO `eq_order` VALUES (31,1,'哑铃1','50',NULL,202209867,'08点-12点','2022-03-16','已到店'),(32,4,'跑步机2','50','张三',202209867,'08点-12点','2022-03-16','爽约'),(33,5,'跑步机3','50','张三',202209867,'08点-12点','2022-03-16','已到店'),(34,6,'杠铃1','50','张三',202209867,'08点-12点','2022-03-16','已到店'),(35,7,'杠铃2','50','李四',202200788,'08点-12点','2022-03-16','已到店'),(36,1,'哑铃1','50','李四',202200788,'14点-18点','2022-03-16','已到店'),(40,7,'杠铃2','50','Tom',202206725,'14点-18点','2022-03-16','已到店'),(41,1,'哑铃1','50','Tom',202206725,'18点-22点','2022-03-16','已到店'),(51,1,'哑铃1','50','张三',202209867,'14点-18点','2022-03-18','已到店'),(57,4,'跑步机2','50','张三',202209867,'18点-22点','2022-03-18','爽约'),(202,1,'哑铃1','50',NULL,NULL,'08点-12点','2022-05-07','未预约'),(203,4,'跑步机2','50',NULL,NULL,'08点-12点','2022-05-07','未预约'),(204,5,'跑步机3','50',NULL,NULL,'08点-12点','2022-05-07','未预约'),(205,6,'杠铃1','50',NULL,NULL,'08点-12点','2022-05-07','未预约'),(206,7,'杠铃2','50',NULL,NULL,'08点-12点','2022-05-07','未预约'),(207,8,'杠铃5','10',NULL,NULL,'08点-12点','2022-05-07','未预约'),(238,1,'哑铃1','50',NULL,NULL,'08点-12点','2022-05-07','未预约'),(239,4,'跑步机2','50',NULL,NULL,'08点-12点','2022-05-07','未预约'),(240,5,'跑步机3','50',NULL,NULL,'08点-12点','2022-05-07','未预约'),(241,6,'杠铃1','50',NULL,NULL,'08点-12点','2022-05-07','未预约'),(242,7,'杠铃2','50',NULL,NULL,'08点-12点','2022-05-07','未预约'),(243,8,'杠铃5','10',NULL,NULL,'08点-12点','2022-05-07','未预约'),(244,1,'哑铃1','50',NULL,NULL,'14点-18点','2022-05-07','未预约'),(245,4,'跑步机2','50',NULL,NULL,'14点-18点','2022-05-07','未预约'),(246,5,'跑步机3','50',NULL,NULL,'14点-18点','2022-05-07','未预约'),(247,6,'杠铃1','50',NULL,NULL,'14点-18点','2022-05-07','未预约'),(248,7,'杠铃2','50',NULL,NULL,'14点-18点','2022-05-07','未预约'),(249,8,'杠铃5','10',NULL,NULL,'14点-18点','2022-05-07','未预约'),(250,1,'哑铃1','50',NULL,NULL,'18点-22点','2022-05-07','未预约'),(251,4,'跑步机2','50',NULL,NULL,'18点-22点','2022-05-07','未预约'),(252,5,'跑步机3','50',NULL,NULL,'18点-22点','2022-05-07','未预约'),(253,6,'杠铃1','50',NULL,NULL,'18点-22点','2022-05-07','未预约'),(254,7,'杠铃2','50',NULL,NULL,'18点-22点','2022-05-07','未预约'),(255,8,'杠铃5','10',NULL,NULL,'18点-22点','2022-05-07','未预约'),(256,1,'哑铃1','50',NULL,NULL,'08点-12点','2022-05-07','未预约'),(257,4,'跑步机2','50',NULL,NULL,'08点-12点','2022-05-07','未预约'),(258,5,'跑步机3','50',NULL,NULL,'08点-12点','2022-05-07','未预约'),(259,6,'杠铃1','50',NULL,NULL,'08点-12点','2022-05-07','未预约'),(260,7,'杠铃2','50',NULL,NULL,'08点-12点','2022-05-07','未预约'),(261,8,'杠铃5','10',NULL,NULL,'08点-12点','2022-05-07','未预约'),(262,1,'哑铃1','50',NULL,NULL,'14点-18点','2022-05-07','未预约'),(263,4,'跑步机2','50',NULL,NULL,'14点-18点','2022-05-07','未预约'),(264,5,'跑步机3','50',NULL,NULL,'14点-18点','2022-05-07','未预约'),(265,6,'杠铃1','50',NULL,NULL,'14点-18点','2022-05-07','未预约'),(266,7,'杠铃2','50',NULL,NULL,'14点-18点','2022-05-07','未预约'),(267,8,'杠铃5','10',NULL,NULL,'14点-18点','2022-05-07','未预约'),(268,1,'哑铃1','50',NULL,NULL,'18点-22点','2022-05-07','未预约'),(269,4,'跑步机2','50',NULL,NULL,'18点-22点','2022-05-07','未预约'),(270,5,'跑步机3','50',NULL,NULL,'18点-22点','2022-05-07','未预约'),(271,6,'杠铃1','50',NULL,NULL,'18点-22点','2022-05-07','未预约'),(272,7,'杠铃2','50',NULL,NULL,'18点-22点','2022-05-07','未预约'),(273,8,'杠铃5','10',NULL,NULL,'18点-22点','2022-05-07','未预约'),(274,1,'哑铃1','50',NULL,NULL,'08点-12点','2022-05-07','未预约'),(275,4,'跑步机2','50',NULL,NULL,'08点-12点','2022-05-07','未预约'),(276,5,'跑步机3','50',NULL,NULL,'08点-12点','2022-05-07','未预约'),(277,6,'杠铃1','50',NULL,NULL,'08点-12点','2022-05-07','未预约'),(278,7,'杠铃2','50',NULL,NULL,'08点-12点','2022-05-07','未预约'),(279,8,'杠铃5','10',NULL,NULL,'08点-12点','2022-05-07','未预约'),(280,1,'哑铃1','50',NULL,NULL,'14点-18点','2022-05-07','未预约'),(281,4,'跑步机2','50',NULL,NULL,'14点-18点','2022-05-07','未预约'),(282,5,'跑步机3','50',NULL,NULL,'14点-18点','2022-05-07','未预约'),(283,6,'杠铃1','50',NULL,NULL,'14点-18点','2022-05-07','未预约'),(284,7,'杠铃2','50',NULL,NULL,'14点-18点','2022-05-07','未预约'),(285,8,'杠铃5','10',NULL,NULL,'14点-18点','2022-05-07','未预约'),(286,1,'哑铃1','50',NULL,NULL,'18点-22点','2022-05-07','未预约'),(287,4,'跑步机2','50',NULL,NULL,'18点-22点','2022-05-07','未预约'),(288,5,'跑步机3','50',NULL,NULL,'18点-22点','2022-05-07','未预约'),(289,6,'杠铃1','50',NULL,NULL,'18点-22点','2022-05-07','未预约'),(290,7,'杠铃2','50',NULL,NULL,'18点-22点','2022-05-07','未预约'),(291,8,'杠铃5','10',NULL,NULL,'18点-22点','2022-05-07','未预约'),(292,1,'哑铃1','50',NULL,NULL,'08点-12点','2022-05-07','未预约'),(293,4,'跑步机2','50',NULL,NULL,'08点-12点','2022-05-07','未预约'),(294,5,'跑步机3','50',NULL,NULL,'08点-12点','2022-05-07','未预约'),(295,6,'杠铃1','50',NULL,NULL,'08点-12点','2022-05-07','未预约'),(296,7,'杠铃2','50',NULL,NULL,'08点-12点','2022-05-07','未预约'),(297,8,'杠铃5','10',NULL,NULL,'08点-12点','2022-05-07','未预约'),(298,1,'哑铃1','50',NULL,NULL,'14点-18点','2022-05-07','未预约'),(299,4,'跑步机2','50',NULL,NULL,'14点-18点','2022-05-07','未预约'),(300,5,'跑步机3','50',NULL,NULL,'14点-18点','2022-05-07','未预约'),(301,6,'杠铃1','50',NULL,NULL,'14点-18点','2022-05-07','未预约'),(302,7,'杠铃2','50',NULL,NULL,'14点-18点','2022-05-07','未预约'),(303,8,'杠铃5','10',NULL,NULL,'14点-18点','2022-05-07','未预约'),(304,1,'哑铃1','50',NULL,NULL,'18点-22点','2022-05-07','未预约'),(305,4,'跑步机2','50',NULL,NULL,'18点-22点','2022-05-07','未预约'),(306,5,'跑步机3','50',NULL,NULL,'18点-22点','2022-05-07','未预约'),(307,6,'杠铃1','50',NULL,NULL,'18点-22点','2022-05-07','未预约'),(308,7,'杠铃2','50',NULL,NULL,'18点-22点','2022-05-07','未预约'),(309,8,'杠铃5','10',NULL,NULL,'18点-22点','2022-05-07','未预约'),(310,1,'哑铃1','50',NULL,NULL,'08点-12点','2022-05-08','未预约'),(311,4,'跑步机2','50','张三',202209867,'08点-12点','2022-05-08','爽约'),(312,5,'跑步机3','50',NULL,NULL,'08点-12点','2022-05-08','未预约'),(313,6,'杠铃1','50','张三',202209867,'08点-12点','2022-05-08','爽约'),(314,7,'杠铃2','50',NULL,NULL,'08点-12点','2022-05-08','未预约'),(315,8,'杠铃5','10',NULL,NULL,'08点-12点','2022-05-08','未预约'),(316,1,'哑铃1','50',NULL,NULL,'14点-18点','2022-05-08','未预约'),(317,4,'跑步机2','50',NULL,NULL,'14点-18点','2022-05-08','未预约'),(318,5,'跑步机3','50','张三',202209867,'14点-18点','2022-05-08','已预约'),(319,6,'杠铃1','50',NULL,NULL,'14点-18点','2022-05-08','未预约'),(320,7,'杠铃2','50',NULL,NULL,'14点-18点','2022-05-08','未预约'),(321,8,'杠铃5','10',NULL,NULL,'14点-18点','2022-05-08','未预约'),(322,1,'哑铃1','50',NULL,NULL,'18点-22点','2022-05-08','未预约'),(323,4,'跑步机2','50',NULL,NULL,'18点-22点','2022-05-08','未预约'),(324,5,'跑步机3','50',NULL,NULL,'18点-22点','2022-05-08','未预约'),(325,6,'杠铃1','50',NULL,NULL,'18点-22点','2022-05-08','未预约'),(326,7,'杠铃2','50',NULL,NULL,'18点-22点','2022-05-08','未预约'),(327,8,'杠铃5','10',NULL,NULL,'18点-22点','2022-05-08','未预约');

#
# Structure for table "equipment"
#

DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment` (
  `equipment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '器材id',
  `equipment_name` varchar(255) DEFAULT NULL COMMENT '器材名称',
  `equipment_location` varchar(255) DEFAULT NULL COMMENT '器材位置',
  `equipment_status` varchar(255) DEFAULT NULL COMMENT '器材状态',
  `equipment_message` varchar(255) DEFAULT NULL COMMENT '器材备注信息',
  `equipment_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`equipment_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Data for table "equipment"
#

INSERT INTO `equipment` VALUES (1,'哑铃1','1号房间','正常','','50'),(2,'杠铃1','2号房间','损坏','待维修','50'),(3,'跑步机1','2号房间','维修中','联系厂家维修','50'),(4,'跑步机2','2号房间','正常','','50'),(5,'跑步机3','2号房间','正常','','50'),(6,'杠铃1','1号房间','正常','','50'),(7,'杠铃2','1号房间','正常','','50'),(8,'杠铃5','1号房间','正常','锻炼肩膀、肱二头肌','10');

#
# Structure for table "member"
#

DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `member_account` int(11) NOT NULL COMMENT '会员账号',
  `member_password` varchar(255) DEFAULT '123456' COMMENT '会员密码',
  `member_name` varchar(255) DEFAULT NULL COMMENT '会员姓名',
  `member_gender` varchar(255) DEFAULT '' COMMENT '会员性别',
  `member_age` int(11) DEFAULT NULL COMMENT '会员年龄',
  `member_height` int(11) DEFAULT NULL COMMENT '会员身高',
  `member_weight` int(11) DEFAULT NULL COMMENT '会员体重',
  `member_phone` bigint(20) DEFAULT NULL COMMENT '会员电话',
  `card_time` date DEFAULT NULL COMMENT '办卡时间',
  `card_class` int(11) DEFAULT NULL COMMENT '购买课时',
  `card_next_class` int(11) DEFAULT NULL COMMENT '剩余课时',
  PRIMARY KEY (`member_account`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Data for table "member"
#

INSERT INTO `member` VALUES (202206725,'123456','Tom','男',24,178,90,13758784959,'2022-04-02',30,30),(202209867,'1234567','张三','女',26,167,40,13515548482,'2022-05-05',40,40),(202217729,'123456','李四四','男',20,150,50,13511112222,'2022-05-08',10,10),(202221345,'123456','Ava','女',29,160,40,13754457488,'2022-04-02',30,30),(202223664,'123456','Lily','女',25,165,51,15986457423,'2022-04-02',30,30),(202225039,'123456','张三按','女',25,180,67,18911112222,'2022-05-07',20,20),(202232539,'123456','王五','男',31,178,60,13154875489,'2022-04-02',40,40),(202244754,'123456','张三按','男',20,180,80,13811112222,'2022-05-06',20,20),(202253468,'123456','Emma','女',25,173,44,13786457124,'2022-04-02',50,50),(202259841,'123456','123','男',29,159,67,13411112222,'2022-05-05',12,12),(202262015,'123456','张三三','女',20,150,80,13911112222,'2022-05-06',20,20),(202262693,'123456','张三风','女',25,189,80,18711112222,'2022-05-07',10,10),(202283406,'123456','Tylor','女',19,170,60,13786457488,'2022-02-27',30,30),(202299636,'123456','新一','男',20,150,50,13222222222,'2022-05-08',10,10);

#
# Structure for table "notice"
#

DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(32) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `time` varchar(32) DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "notice"
#

INSERT INTO `notice` VALUES (10,'大优惠','买三送一',NULL);
