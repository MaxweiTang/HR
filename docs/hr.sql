/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : hr

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2019-07-17 16:32:31
*/

SET FOREIGN_KEY_CHECKS=0;


DROP DATABASE IF EXISTS `hr`;
CREATE DATABASE `hr` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hr`;

-- ----------------------------
-- Table structure for `attendance`
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance` (
  `id` varchar(11) NOT NULL,
  `staff_id` varchar(11) DEFAULT NULL COMMENT '员工编号',
  `time` date DEFAULT NULL COMMENT '考勤时间',
  `type` varchar(11) DEFAULT NULL COMMENT '考勤情况；迟到、旷班、请假、出差、停职、事假',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='考勤';

-- ----------------------------
-- Records of attendance
-- ----------------------------
INSERT INTO `attendance` VALUES ('3001', '201604002', '2016-06-14', '迟到');
INSERT INTO `attendance` VALUES ('3002', '201604018', '2016-06-15', '旷班');
INSERT INTO `attendance` VALUES ('3003', '201603995', '2016-06-16', '迟到');
INSERT INTO `attendance` VALUES ('3004', '201604008', '2016-06-16', '迟到');
INSERT INTO `attendance` VALUES ('3005', '201604019', '2016-06-17', '请假');
INSERT INTO `attendance` VALUES ('3006', '201603997', '2016-06-17', '请假');
INSERT INTO `attendance` VALUES ('3007', '201603996', '2016-06-18', '出差');
INSERT INTO `attendance` VALUES ('3008', '201604008', '2016-06-18', '出差');
INSERT INTO `attendance` VALUES ('3009', '201604007', '2016-06-18', '事假');
INSERT INTO `attendance` VALUES ('3010', '201604006', '2016-06-20', '事假');
INSERT INTO `attendance` VALUES ('3011', '201603990', '2016-06-21', '旷班');
INSERT INTO `attendance` VALUES ('3012', '201603988', '2016-06-21', '迟到');
INSERT INTO `attendance` VALUES ('3013', '201603981', '2016-06-22', '迟到');
INSERT INTO `attendance` VALUES ('3014', '201603985', '2016-06-23', '迟到');
INSERT INTO `attendance` VALUES ('3015', '201604008', '2016-06-25', '请假');
INSERT INTO `attendance` VALUES ('3016', '201604019', '2016-06-29', '迟到');
INSERT INTO `attendance` VALUES ('3017', '201604016', '2016-06-30', '请假');
INSERT INTO `attendance` VALUES ('3018', '201603994', '2016-07-02', '请假');
INSERT INTO `attendance` VALUES ('3019', '201603991', '2016-07-02', '迟到');
INSERT INTO `attendance` VALUES ('3020', '201604012', '2016-07-03', '迟到');
INSERT INTO `attendance` VALUES ('3021', '201604009', '2016-07-04', '迟到');
INSERT INTO `attendance` VALUES ('3022', '201604003', '2016-07-08', '事假');
INSERT INTO `attendance` VALUES ('3023', '201603985', '2016-07-09', '迟到');

-- ----------------------------
-- Table structure for `contract`
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract` (
  `id` varchar(11) NOT NULL,
  `begin` date DEFAULT NULL COMMENT '合同开始时间',
  `end` date DEFAULT NULL COMMENT '合同截止时间',
  `position_id` varchar(11) DEFAULT NULL COMMENT '对应position_log中的某个ID',
  `content` varchar(1000) DEFAULT NULL COMMENT '合同内容',
  `remark` varchar(300) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of contract
-- ----------------------------
INSERT INTO `contract` VALUES ('3981', '2012-01-01', '2022-06-01', '', 'abc1', null);
INSERT INTO `contract` VALUES ('3982', '2012-01-01', '2022-06-01', '', 'abc2', null);
INSERT INTO `contract` VALUES ('3983', '2012-01-01', '2022-06-01', '', 'abc3', null);
INSERT INTO `contract` VALUES ('3984', '2012-01-01', '2022-06-01', '', 'abc4', null);
INSERT INTO `contract` VALUES ('3985', '2012-01-01', '2022-06-01', '', 'abc5', null);
INSERT INTO `contract` VALUES ('3986', '2012-01-01', '2022-06-01', '', 'abc6', null);
INSERT INTO `contract` VALUES ('3987', '2012-01-01', '2022-06-01', '', 'abc7', null);
INSERT INTO `contract` VALUES ('3988', '2012-01-01', '2022-06-01', '', 'abc8', null);
INSERT INTO `contract` VALUES ('3989', '2012-01-01', '2022-06-01', '', 'abc9', null);
INSERT INTO `contract` VALUES ('3990', '2012-01-01', '2022-06-01', '', 'abc10', null);
INSERT INTO `contract` VALUES ('3991', '2012-01-01', '2022-06-01', '', 'abc11', null);
INSERT INTO `contract` VALUES ('3992', '2012-01-01', '2022-06-01', '', 'abc12', null);
INSERT INTO `contract` VALUES ('3993', '2012-01-01', '2022-06-01', '', 'abc13', null);
INSERT INTO `contract` VALUES ('3994', '2012-01-01', '2022-06-01', '', 'abc14', null);
INSERT INTO `contract` VALUES ('3995', '2012-01-01', '2022-06-01', '', 'abc15', null);
INSERT INTO `contract` VALUES ('3996', '2012-01-01', '2022-06-01', '', 'abc16', null);
INSERT INTO `contract` VALUES ('3997', '2012-01-01', '2022-06-01', '', 'abc17', null);
INSERT INTO `contract` VALUES ('3998', '2012-01-01', '2022-06-01', '', 'abc18', null);
INSERT INTO `contract` VALUES ('3999', '2012-01-01', '2022-06-01', '', 'abc19', null);
INSERT INTO `contract` VALUES ('4000', '2012-01-01', '2022-06-01', '', 'abc20', null);
INSERT INTO `contract` VALUES ('4001', '2012-01-01', '2022-06-01', '', 'abc21', null);
INSERT INTO `contract` VALUES ('4002', '2012-01-01', '2022-06-01', '', 'abc22', null);
INSERT INTO `contract` VALUES ('4003', '2012-01-01', '2022-06-01', '', 'abc23', null);
INSERT INTO `contract` VALUES ('4004', '2012-01-01', '2022-06-01', '', 'abc24', null);
INSERT INTO `contract` VALUES ('4005', '2012-01-01', '2022-06-01', '', 'abc25', null);
INSERT INTO `contract` VALUES ('4007', '2012-01-01', '2022-06-01', '', 'abc26', null);
INSERT INTO `contract` VALUES ('4008', '2012-01-01', '2022-06-01', '', 'abc27', null);
INSERT INTO `contract` VALUES ('4009', '2012-01-01', '2022-06-01', '', 'abc28', null);
INSERT INTO `contract` VALUES ('4010', '2012-01-01', '2022-06-01', '', 'abc29', null);
INSERT INTO `contract` VALUES ('4011', '2012-01-01', '2022-06-01', '', 'abc30', null);
INSERT INTO `contract` VALUES ('4012', '2012-01-01', '2022-06-01', '', 'abc31', null);
INSERT INTO `contract` VALUES ('4013', '2012-01-01', '2022-06-01', '', 'abc32', null);
INSERT INTO `contract` VALUES ('4014', '2012-01-01', '2022-06-01', '', 'abc33', null);
INSERT INTO `contract` VALUES ('4015', '2012-01-01', '2022-06-01', '', 'abc34', null);
INSERT INTO `contract` VALUES ('4016', '2012-01-01', '2022-06-01', '', 'abc35', null);
INSERT INTO `contract` VALUES ('4017', '2012-01-01', '2022-06-01', '', 'abc36', null);
INSERT INTO `contract` VALUES ('4018', '2012-01-01', '2022-06-01', '', 'abc37', null);
INSERT INTO `contract` VALUES ('4020', '2012-01-01', '2022-06-01', '', 'abc38', null);
INSERT INTO `contract` VALUES ('4021', '2012-01-01', '2022-06-01', '', 'abc39', null);

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` varchar(11) NOT NULL,
  `name` varchar(20) NOT NULL COMMENT '部门名称',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '部门是否解散；0没有',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='部门';

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('2001', '保安部', '0');
INSERT INTO `department` VALUES ('2002', '清洁部', '0');
INSERT INTO `department` VALUES ('2003', '秘书部', '0');
INSERT INTO `department` VALUES ('2004', '人力资源部', '0');
INSERT INTO `department` VALUES ('2005', '财务部', '0');
INSERT INTO `department` VALUES ('2006', '生产技术部', '0');
INSERT INTO `department` VALUES ('2007', '营销部', '0');
INSERT INTO `department` VALUES ('2008', '监督部', '0');
INSERT INTO `department` VALUES ('2009', '已离职', '0');

-- ----------------------------
-- Table structure for `people`
-- ----------------------------
DROP TABLE IF EXISTS `people`;
CREATE TABLE `people` (
  `id` varchar(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `birth` date DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `degree` varchar(20) DEFAULT NULL COMMENT '学位',
  `register_date` date DEFAULT NULL COMMENT '登记时间',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '信息是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='所有人员信息，包括应聘但没入职的';

-- ----------------------------
-- Records of people
-- ----------------------------
INSERT INTO `people` VALUES ('201603981', '周正华', '男', '1997-10-10', '17780815403', 'WA4L4A@V1NT5N.com', '高中', '2016-09-01', '和席包路雁川', '0');
INSERT INTO `people` VALUES ('201603982', '周成龙', '男', '1997-10-10', '18281140583', 'JW3E1P@L25DS4.com', '高中', '2016-09-01', '卫包纪苗秋逸', '0');
INSERT INTO `people` VALUES ('201603983', '钟刚锐', '男', '1997-10-10', '13658175365', '2AMQZX@IBK2E3.com', '高中', '2016-09-01', '熊俞臧孙雷尧', '0');
INSERT INTO `people` VALUES ('201603984', '张玉梁', '男', '1997-10-10', '17738269664', 'I5Q7F8@1C6DSW.com', '高中', '2016-09-01', '赵葛严钱逸勇', '0');
INSERT INTO `people` VALUES ('201603985', '张进', '男', '1997-10-10', '17780817384', '3WJKIT@4K7687.com', '高中', '2016-09-01', '堪时明贝安露', '0');
INSERT INTO `people` VALUES ('201603986', '袁福森', '男', '1997-10-10', '15881492213', 'E8GB8E@1SIY02.com', '高中', '2016-09-01', '邹姜方左碧丽', '0');
INSERT INTO `people` VALUES ('201603987', '叶鹏', '男', '1997-10-10', '17781606405', 'G6N7CI@N5KGT7.com', '高中', '2016-09-01', '咎傅宋颜涵德', '0');
INSERT INTO `people` VALUES ('201603988', '严海峰', '男', '1997-10-10', '18681280960', '1A77S8@U45YQ3.com', '高中', '2016-09-01', '苏米喻奚化开', '0');
INSERT INTO `people` VALUES ('201603989', '吴威', '男', '1997-10-10', '18780286171', 'XP04F0@XCWLY5.com', '高中', '2016-09-01', '诸孔卜赵怀真', '0');
INSERT INTO `people` VALUES ('201603990', '文俊', '男', '1997-10-10', '18398260702', '0KR03J@44U50K.com', '高中', '2016-09-01', '董粱薛徐辰乃', '0');
INSERT INTO `people` VALUES ('201603991', '王晓晴', '男', '1997-10-10', '17781792544', 'CILTT6@4L1406.com', '高中', '2016-09-01', '熊祝郝郑碧镇', '0');
INSERT INTO `people` VALUES ('201603992', '汪维煊', '男', '1997-10-10', '15111936880', '35LLVN@Q47XVJ.com', '高中', '2016-09-01', '丁苗熊柳靖劲', '0');
INSERT INTO `people` VALUES ('201603993', '唐琦伟', '男', '1997-10-10', '13388339674', 'U33668@WUNRJ7.com', '高中', '2016-09-01', '安明项萧化湘', '0');
INSERT INTO `people` VALUES ('201603994', '覃铃杰', '男', '1997-10-10', '17780813897', 'F72264@D441V8.com', '高中', '2016-09-01', '宗宗樊薛友锡', '0');
INSERT INTO `people` VALUES ('201603995', '尚志', '男', '1997-10-10', '17780814313', 'RGLBE6@80MH0T.com', '高中', '2016-09-01', '熊成尤闵波咏', '0');
INSERT INTO `people` VALUES ('201603996', '邱依呷', '男', '1997-10-10', '17780816864', 'KVJLGK@GK55GK.com', '高中', '2016-09-01', '孙吉解毛杰裕', '0');
INSERT INTO `people` VALUES ('201603997', '彭晓祥', '男', '1997-10-10', '17781792745', 'RG85U4@15LROQ.com', '高中', '2016-09-01', '盛蒋郑钮灿雄', '0');
INSERT INTO `people` VALUES ('201603998', '罗志垚', '男', '1997-10-10', '18980158778', '106GX8@SLS278.com', '高中', '2016-09-01', '麻徐高舒邦中', '0');
INSERT INTO `people` VALUES ('201603999', '刘洵', '男', '1997-10-10', '18398263549', 'MT67FS@P87IK0.com', '高中', '2016-09-01', '左熊范袁秀嘉', '0');
INSERT INTO `people` VALUES ('201604000', '李懿恒', '男', '1997-10-10', '18783047537', '306L41@Y283JJ.com', '高中', '2016-09-01', '明范余宋羽哲', '0');
INSERT INTO `people` VALUES ('201604001', '李何平', '男', '1997-10-10', '18398211011', 'J6L50G@4JD8ZI.com', '高中', '2016-09-01', '傅童贺熊小权', '0');
INSERT INTO `people` VALUES ('201604002', '揭洋', '男', '1997-10-10', '17780818057', 'FX203Q@43HV56.com', '高中', '2016-09-01', '郝尤方戚婷根', '0');
INSERT INTO `people` VALUES ('201604003', '黄潇', '男', '1997-10-10', '18398263541', 'I4LCM4@1E1V34.com', '高中', '2016-09-01', '郑石钟诸劲征', '0');
INSERT INTO `people` VALUES ('201604004', '黄俊淞', '男', '1997-10-10', '15328480888', '0UFZNU@533I4H.com', '高中', '2016-09-01', '时乐田邱秋兴', '0');
INSERT INTO `people` VALUES ('201604005', '胡济成', '男', '1997-10-10', '18398260694', 'IMYO8M@M54U25.com', '高中', '2016-09-01', '孙徐卢赵茂生', '0');
INSERT INTO `people` VALUES ('201604007', '付金明', '男', '1997-10-10', '18398261121', 'M5I60X@Y8L8A7.com', '高中', '2016-09-01', '邓米周乐永珍', '0');
INSERT INTO `people` VALUES ('201604008', '丁仕涛', '男', '1997-10-10', '18398264689', 'W5RK36@MMTHMJ.com', '高中', '2016-09-01', '纪袁舒花劲腾', '0');
INSERT INTO `people` VALUES ('201604009', '陈云豪', '男', '1997-10-10', '18398261147', 'WEE510@67NWO7.com', '高中', '2016-09-01', '纪袁庞柏宇依', '0');
INSERT INTO `people` VALUES ('201604010', '陈浩', '男', '1997-10-10', '18398263526', '2YW34T@E1J2U3.com', '高中', '2016-09-01', '谢苏毛尤洋爱', '0');
INSERT INTO `people` VALUES ('201604011', '蔡华庆', '男', '1997-10-10', '17780816314', 'J6EA88@776G4Z.com', '高中', '2016-09-01', '贲钮姜万孝亮', '0');
INSERT INTO `people` VALUES ('201604012', '黄蓉', '女', '1997-10-10', '18398264693', '65JE81@Y42DTZ.com', '高中', '2016-09-01', '花戚崔郝福安', '0');
INSERT INTO `people` VALUES ('201604013', '冯娅楠', '女', '1997-10-10', '17781604351', '0J64B8@HTLUUD.com', '高中', '2016-09-01', '乐颜齐钱黎秋', '0');
INSERT INTO `people` VALUES ('201604014', '钟文玥希', '女', '1997-10-10', '18398263704', '4S5A55@FTMMPH.com', '高中', '2016-09-01', '廉郎云史妮仪', '0');
INSERT INTO `people` VALUES ('201604015', '张宇宁', '女', '1997-10-10', '17781604019', 'ZBOX26@P8MIZQ.com', '高中', '2016-09-01', '霍花贲徐安超', '0');
INSERT INTO `people` VALUES ('201604016', '杨丹瑞', '女', '1997-10-10', '13350039977', 'B3S631@K766E8.com', '高中', '2016-09-01', '周凤费柯铭宪', '0');
INSERT INTO `people` VALUES ('201604017', '吴燕梅', '女', '1997-10-10', '18398263578', 'TFDW20@S5G3OU.com', '高中', '2016-09-01', '咎吕吉成强伦', '0');
INSERT INTO `people` VALUES ('201604018', '王淑楠', '女', '1997-10-10', '18398264608', 'DC42A1@UB7148.com', '高中', '2016-09-01', '茅沈和任平波', '0');
INSERT INTO `people` VALUES ('201604020', '鲁芸露', '女', '1997-10-10', '17781609370', '8O7J77@A8H0DT.com', '高中', '2016-09-01', '路曹姚潘洲明', '0');
INSERT INTO `people` VALUES ('201604021', '李林芸', '女', '1997-10-10', '15729753325', 'EHCHIZ@6P03YR.com', '高中', '2016-09-01', '郝孙管花晨义', '0');

-- ----------------------------
-- Table structure for `position_log`
-- ----------------------------
DROP TABLE IF EXISTS `position_log`;
CREATE TABLE `position_log` (
  `id` varchar(11) NOT NULL,
  `staff_id` varchar(11) NOT NULL COMMENT '员工ID',
  `from` varchar(11) DEFAULT NULL COMMENT '旧职位',
  `to` varchar(11) DEFAULT NULL COMMENT '新职位',
  `time` date DEFAULT NULL COMMENT '调动时间',
  `reason` varchar(100) DEFAULT NULL COMMENT '调动理由',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of position_log
-- ----------------------------
INSERT INTO `position_log` VALUES ('4001', '201603981', '保安', '空闲', '2019-02-14', '公司调配');
INSERT INTO `position_log` VALUES ('4002', '201603982', '清洁工', '销售人员', '2019-05-16', '公司调配');
INSERT INTO `position_log` VALUES ('4003', '201603983', '销售人员', '开发人员', '2019-05-17', '个人申请');
INSERT INTO `position_log` VALUES ('4004', '201603984', '会计', '会计组长', '2019-05-18', '公司调配');
INSERT INTO `position_log` VALUES ('4005', '201603985', '清洁工', '销售人员', '2019-05-19', '个人申请');
INSERT INTO `position_log` VALUES ('4006', '201603986', '清洁工', '销售人员', '2019-05-19', '公司调配');
INSERT INTO `position_log` VALUES ('4007', '201603987', '保安', '空闲', '2019-05-20', '个人申请');
INSERT INTO `position_log` VALUES ('4008', '201603988', '会计', '开发人员', '2019-05-21', '个人申请');
INSERT INTO `position_log` VALUES ('4009', '201603989', '清洁工', '销售人员', '2019-05-21', '公司调配');
INSERT INTO `position_log` VALUES ('4010', '201603990', '保安', '开发人员', '2019-05-22', '个人申请');
INSERT INTO `position_log` VALUES ('4011', '201603991', '清洁工', '开发人员', '2019-06-11', '个人申请');
INSERT INTO `position_log` VALUES ('4012', '201603992', '会计', '清洁工', '2019-06-12', '公司调配');
INSERT INTO `position_log` VALUES ('4013', '201603993', '清洁工', '销售人员', '2019-06-13', '公司调配');
INSERT INTO `position_log` VALUES ('4014', '201603994', '销售人员', '开发人员', '2019-06-14', '个人申请');
INSERT INTO `position_log` VALUES ('4015', '201603995', '保安', '清洁工', '2019-06-15', '公司调配');
INSERT INTO `position_log` VALUES ('4016', '201603996', '清洁工', '开发人员', '2019-06-16', '公司调配');
INSERT INTO `position_log` VALUES ('4017', '201603997', '保安', '空闲', '2019-07-10', '公司调配');
INSERT INTO `position_log` VALUES ('4018', '201603998', '清洁工', '销售人员', '2019-05-21', '公司调配');
INSERT INTO `position_log` VALUES ('4019', '201603999', '销售人员', '开发人员', '2019-06-13', '个人申请');
INSERT INTO `position_log` VALUES ('4020', '201604000', '会计', '会计组长', '2019-06-15', '个人申请');
INSERT INTO `position_log` VALUES ('4021', '201604001', '保安', '销售人员', '2019-06-13', '公司调配');
INSERT INTO `position_log` VALUES ('4022', '201604002', '清洁工', '销售人员', '2019-05-21', '个人申请');
INSERT INTO `position_log` VALUES ('4023', '201604003', '销售人员', '空闲', '2019-06-15', '个人申请');
INSERT INTO `position_log` VALUES ('4024', '201604004', '会计', '开发人员', '2019-06-13', '公司调配');
INSERT INTO `position_log` VALUES ('4025', '201604005', '清洁工', '销售人员', '2019-06-13', '公司调配');
INSERT INTO `position_log` VALUES ('4026', '201604007', '清洁工', '开发人员', '2019-05-21', '个人申请');
INSERT INTO `position_log` VALUES ('4027', '201604008', '保安', '开发人员', '2019-06-13', '公司调配');
INSERT INTO `position_log` VALUES ('4028', '201604009', '会计', '清洁工', '2019-05-21', '公司调配');
INSERT INTO `position_log` VALUES ('4029', '201604010', '清洁工', '销售人员', '2019-05-21', '公司调配');
INSERT INTO `position_log` VALUES ('4030', '201604011', '保安', '开发人员', '2019-06-13', '公司调配');
INSERT INTO `position_log` VALUES ('4031', '201604012', '清洁工', '清洁工', '2019-06-13', '个人申请');
INSERT INTO `position_log` VALUES ('4032', '201604013', '会计', '开发人员', '2019-06-13', '个人申请');
INSERT INTO `position_log` VALUES ('4033', '201604014', '清洁工', '空闲', '2019-06-15', '公司调配');
INSERT INTO `position_log` VALUES ('4034', '201604015', '销售人员', '销售人员', '2019-06-13', '无');
INSERT INTO `position_log` VALUES ('4035', '201604016', '保安', '开发人员', '2019-06-15', '个人申请');
INSERT INTO `position_log` VALUES ('4036', '201604017', '清洁工', '会计组长', '2019-06-13', '公司调配');
INSERT INTO `position_log` VALUES ('4037', '201604018', '保安', '销售人员', '2019-06-15', '公司调配');
INSERT INTO `position_log` VALUES ('4038', '201604020', '清洁工', '销售人员', '2019-06-13', '公司调配');
INSERT INTO `position_log` VALUES ('4039', '201604021', '销售人员', '空闲', '2019-06-15', '公司调配');

-- ----------------------------
-- Table structure for `profile`
-- ----------------------------
DROP TABLE IF EXISTS `profile`;
CREATE TABLE `profile` (
  `id` varchar(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL COMMENT '档案名称',
  `abstract` varchar(50) DEFAULT NULL COMMENT '内容摘要',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '档案是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='档案';

-- ----------------------------
-- Records of profile
-- ----------------------------
INSERT INTO `profile` VALUES ('6001', '周正华的档案', '档案内容1', null, '0');
INSERT INTO `profile` VALUES ('6002', '周成龙的档案', '档案内容2', null, '0');
INSERT INTO `profile` VALUES ('6003', '钟刚锐的档案', '档案内容3', null, '0');
INSERT INTO `profile` VALUES ('6004', '张玉梁的档案', '档案内容4', null, '0');
INSERT INTO `profile` VALUES ('6005', '张进的档案', '档案内容5', null, '0');
INSERT INTO `profile` VALUES ('6006', '袁福森的档案', '档案内容6', null, '0');
INSERT INTO `profile` VALUES ('6007', '叶鹏的档案', '档案内容7', null, '0');
INSERT INTO `profile` VALUES ('6008', '严海峰的档案', '档案内容8', null, '0');
INSERT INTO `profile` VALUES ('6009', '吴威的档案', '档案内容9', null, '0');
INSERT INTO `profile` VALUES ('6010', '文俊的档案', '档案内容10', null, '0');
INSERT INTO `profile` VALUES ('6011', '王晓晴的档案', '档案内容11', null, '0');
INSERT INTO `profile` VALUES ('6012', '汪维煊的档案', '档案内容12', null, '0');
INSERT INTO `profile` VALUES ('6013', '唐琦伟的档案', '档案内容13', null, '0');
INSERT INTO `profile` VALUES ('6014', '覃铃杰的档案', '档案内容14', null, '0');
INSERT INTO `profile` VALUES ('6015', '尚志的档案', '档案内容15', null, '0');
INSERT INTO `profile` VALUES ('6016', '邱依呷的档案', '档案内容16', null, '0');
INSERT INTO `profile` VALUES ('6017', '彭晓祥的档案', '档案内容17', null, '0');
INSERT INTO `profile` VALUES ('6018', '罗志垚的档案', '档案内容18', null, '0');
INSERT INTO `profile` VALUES ('6019', '刘洵的档案', '档案内容19', null, '0');
INSERT INTO `profile` VALUES ('6020', '李懿恒的档案', '档案内容20', null, '0');
INSERT INTO `profile` VALUES ('6021', '李何平的档案', '档案内容21', null, '0');
INSERT INTO `profile` VALUES ('6022', '揭洋的档案', '档案内容22', null, '0');
INSERT INTO `profile` VALUES ('6023', '黄潇的档案', '档案内容23', null, '0');
INSERT INTO `profile` VALUES ('6024', '黄俊淞的档案', '档案内容24', null, '0');
INSERT INTO `profile` VALUES ('6025', '胡济成的档案', '档案内容25', null, '0');
INSERT INTO `profile` VALUES ('6026', '付金明的档案', '档案内容26', null, '0');
INSERT INTO `profile` VALUES ('6027', '丁仕涛的档案', '档案内容27', null, '0');
INSERT INTO `profile` VALUES ('6028', '陈云豪的档案', '档案内容28', null, '0');
INSERT INTO `profile` VALUES ('6029', '陈浩的档案', '档案内容29', null, '0');
INSERT INTO `profile` VALUES ('6030', '蔡华庆的档案', '档案内容30', null, '0');
INSERT INTO `profile` VALUES ('6031', '黄蓉的档案', '档案内容31', null, '0');
INSERT INTO `profile` VALUES ('6032', '冯娅楠的档案', '档案内容32', null, '0');
INSERT INTO `profile` VALUES ('6033', '钟文玥希的档案', '档案内容33', null, '0');
INSERT INTO `profile` VALUES ('6034', '张宇宁的档案', '档案内容34', null, '0');
INSERT INTO `profile` VALUES ('6035', '杨丹瑞的档案', '档案内容35', null, '0');
INSERT INTO `profile` VALUES ('6036', '吴燕梅的档案', '档案内容36', null, '0');
INSERT INTO `profile` VALUES ('6037', '王淑楠的档案', '档案内容37', null, '0');
INSERT INTO `profile` VALUES ('6038', '鲁芸露的档案', '档案内容38', null, '0');
INSERT INTO `profile` VALUES ('6039', '李林芸的档案', '档案内容39', null, '0');

-- ----------------------------
-- Table structure for `program`
-- ----------------------------
DROP TABLE IF EXISTS `program`;
CREATE TABLE `program` (
  `id` varchar(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL COMMENT '项目名称',
  `time` date DEFAULT NULL COMMENT '项目创建时间',
  `remark` varchar(40) DEFAULT NULL COMMENT '备注',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '项目是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='培训项目';

-- ----------------------------
-- Records of program
-- ----------------------------
INSERT INTO `program` VALUES ('7001', 'C', '2019-02-12', '项目备注1', '0');
INSERT INTO `program` VALUES ('7002', 'Java', '2019-04-10', '项目备注2', '0');
INSERT INTO `program` VALUES ('7003', 'C#', '2019-05-18', '项目备注3', '0');
INSERT INTO `program` VALUES ('7004', 'JS', '2019-06-04', '项目备注4', '0');
INSERT INTO `program` VALUES ('7005', 'Html', '2019-06-29', '项目备注5', '0');
INSERT INTO `program` VALUES ('7006', 'Python', '2019-07-11', '项目备注6', '0');

-- ----------------------------
-- Table structure for `salary`
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary` (
  `id` varchar(11) NOT NULL,
  `staff_id` varchar(11) NOT NULL COMMENT '员工ID',
  `base` int(11) NOT NULL DEFAULT '0' COMMENT '基本工资',
  `extra` int(11) NOT NULL DEFAULT '0' COMMENT '绩效工资',
  `bonus` int(11) NOT NULL DEFAULT '0' COMMENT '奖金',
  `fine` int(11) NOT NULL DEFAULT '0' COMMENT '罚款',
  `total` int(11) NOT NULL DEFAULT '0' COMMENT '合计工资',
  `time` date DEFAULT NULL COMMENT '工资发放时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='工资';

-- ----------------------------
-- Records of salary
-- ----------------------------
INSERT INTO `salary` VALUES ('8001', '201603981', '4000', '800', '800', '200', '5400', '2019-07-17');
INSERT INTO `salary` VALUES ('8002', '201603982', '4000', '2200', '1400', '1400', '6200', '2019-07-17');
INSERT INTO `salary` VALUES ('8003', '201603983', '6500', '1400', '800', '200', '8500', '2019-07-17');
INSERT INTO `salary` VALUES ('8004', '201603984', '8000', '700', '1400', '0', '10100', '2019-07-17');
INSERT INTO `salary` VALUES ('8005', '201603985', '11000', '1500', '1400', '200', '13700', '2019-07-17');
INSERT INTO `salary` VALUES ('8006', '201603986', '8000', '650', '1400', '1400', '8650', '2019-07-17');
INSERT INTO `salary` VALUES ('8007', '201603987', '6500', '800', '800', '200', '7900', '2019-07-17');
INSERT INTO `salary` VALUES ('8008', '201603988', '11000', '2000', '1200', '0', '14200', '2019-07-17');
INSERT INTO `salary` VALUES ('8009', '201603989', '8000', '1500', '1400', '200', '10700', '2019-07-17');
INSERT INTO `salary` VALUES ('8010', '201603990', '11000', '1200', '2000', '200', '14000', '2019-07-17');
INSERT INTO `salary` VALUES ('8011', '201603991', '4000', '800', '1200', '50', '5950', '2019-07-17');
INSERT INTO `salary` VALUES ('8012', '201603992', '4000', '650', '1200', '200', '5650', '2019-07-17');
INSERT INTO `salary` VALUES ('8013', '201603993', '11000', '1200', '2000', '800', '13400', '2019-07-17');
INSERT INTO `salary` VALUES ('8014', '201603994', '8000', '1200', '1400', '200', '10400', '2019-07-17');
INSERT INTO `salary` VALUES ('8015', '201603995', '6500', '1500', '1200', '0', '9200', '2019-07-17');
INSERT INTO `salary` VALUES ('8016', '201603996', '11000', '650', '1200', '200', '12650', '2019-07-17');
INSERT INTO `salary` VALUES ('8017', '201603997', '11000', '650', '2000', '50', '13600', '2019-07-17');
INSERT INTO `salary` VALUES ('8018', '201603998', '4000', '650', '1400', '50', '6000', '2019-07-17');
INSERT INTO `salary` VALUES ('8019', '201603999', '4000', '1500', '1400', '200', '6700', '2019-07-17');
INSERT INTO `salary` VALUES ('8020', '201604000', '11000', '1500', '800', '50', '13250', '2019-07-17');
INSERT INTO `salary` VALUES ('8021', '201604001', '8000', '1500', '1400', '1400', '9500', '2019-07-17');
INSERT INTO `salary` VALUES ('8022', '201604002', '6500', '1200', '2000', '200', '9500', '2019-07-17');
INSERT INTO `salary` VALUES ('8023', '201604003', '11000', '800', '1200', '50', '12950', '2019-07-17');
INSERT INTO `salary` VALUES ('8024', '201604004', '11000', '650', '2000', '0', '13650', '2019-07-17');
INSERT INTO `salary` VALUES ('8025', '201604005', '8000', '1500', '1200', '800', '9900', '2019-07-17');
INSERT INTO `salary` VALUES ('8026', '201604007', '4000', '1200', '2000', '200', '7000', '2019-07-17');
INSERT INTO `salary` VALUES ('8027', '201604008', '4000', '1500', '1200', '200', '6500', '2019-07-17');
INSERT INTO `salary` VALUES ('8028', '201604009', '6500', '1500', '800', '0', '8800', '2019-07-17');
INSERT INTO `salary` VALUES ('8029', '201604010', '11000', '1200', '1400', '50', '13550', '2019-07-17');
INSERT INTO `salary` VALUES ('8030', '201604011', '11000', '650', '800', '200', '12250', '2019-07-17');
INSERT INTO `salary` VALUES ('8031', '201604012', '8000', '800', '2000', '650', '10150', '2019-07-17');
INSERT INTO `salary` VALUES ('8032', '201604013', '11000', '1500', '1200', '0', '13700', '2019-07-17');
INSERT INTO `salary` VALUES ('8033', '201604014', '6500', '1200', '1400', '200', '8900', '2019-07-17');
INSERT INTO `salary` VALUES ('8034', '201604015', '11000', '1500', '2000', '650', '13850', '2019-07-17');
INSERT INTO `salary` VALUES ('8035', '201604016', '4000', '650', '1200', '0', '5850', '2019-07-17');
INSERT INTO `salary` VALUES ('8036', '201604017', '4000', '800', '1400', '800', '5400', '2019-07-17');
INSERT INTO `salary` VALUES ('8037', '201604018', '11000', '1200', '2000', '650', '13550', '2019-07-17');
INSERT INTO `salary` VALUES ('8038', '201604020', '8000', '1500', '1200', '0', '10700', '2019-07-17');
INSERT INTO `salary` VALUES ('8039', '201604021', '6500', '1200', '800', '0', '8500', '2019-07-17');

-- ----------------------------
-- Table structure for `staff`
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` varchar(11) NOT NULL COMMENT '员工编号',
  `pid` varchar(11) DEFAULT NULL COMMENT 'people id',
  `position_id` varchar(20) DEFAULT NULL COMMENT '职位；对应与 position_log 中的某个 ID',
  `status` varchar(10) DEFAULT NULL COMMENT '离职、在职',
  `department_id` varchar(11) DEFAULT NULL COMMENT '所在部门ID',
  `contract_id` varchar(11) DEFAULT NULL COMMENT '合同ID',
  `profile_id` varchar(11) DEFAULT NULL COMMENT '档案ID',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '信息是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='员工信息';

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('2001', '201603981', '4001', '离职', '2009', '3981', '6001', '0');
INSERT INTO `staff` VALUES ('2002', '201603982', '4002', '在职', '2007', '3982', '6002', '0');
INSERT INTO `staff` VALUES ('2003', '201603983', '4003', '在职', '2006', '3983', '6003', '0');
INSERT INTO `staff` VALUES ('2004', '201603984', '4004', '在职', '2005', '3984', '6004', '0');
INSERT INTO `staff` VALUES ('2005', '201603985', '4005', '在职', '2007', '3985', '6005', '0');
INSERT INTO `staff` VALUES ('2006', '201603986', '4006', '在职', '2007', '3986', '6006', '0');
INSERT INTO `staff` VALUES ('2007', '201603987', '4007', '离职', '2009', '3987', '6007', '0');
INSERT INTO `staff` VALUES ('2008', '201603988', '4008', '在职', '2006', '3988', '6008', '0');
INSERT INTO `staff` VALUES ('2009', '201603989', '4009', '在职', '2007', '3989', '6009', '0');
INSERT INTO `staff` VALUES ('2010', '201603990', '4010', '在职', '2006', '3990', '6010', '0');
INSERT INTO `staff` VALUES ('2011', '201603991', '4011', '在职', '2006', '3991', '6011', '0');
INSERT INTO `staff` VALUES ('2012', '201603992', '4012', '在职', '2002', '3992', '6012', '0');
INSERT INTO `staff` VALUES ('2013', '201603993', '4013', '在职', '2007', '3993', '6013', '0');
INSERT INTO `staff` VALUES ('2014', '201603994', '4014', '在职', '2006', '3994', '6014', '0');
INSERT INTO `staff` VALUES ('2015', '201603995', '4015', '在职', '2002', '3995', '6015', '0');
INSERT INTO `staff` VALUES ('2016', '201603996', '4016', '在职', '2006', '3996', '6016', '0');
INSERT INTO `staff` VALUES ('2017', '201603997', '4017', '离职', '2009', '3997', '6017', '0');
INSERT INTO `staff` VALUES ('2018', '201603998', '4018', '在职', '2007', '3998', '6018', '0');
INSERT INTO `staff` VALUES ('2019', '201603999', '4019', '在职', '2006', '3999', '6019', '0');
INSERT INTO `staff` VALUES ('2020', '201604000', '4020', '在职', '2005', '4000', '6020', '0');
INSERT INTO `staff` VALUES ('2021', '201604001', '4021', '在职', '2007', '4001', '6021', '0');
INSERT INTO `staff` VALUES ('2022', '201604002', '4022', '在职', '2007', '4002', '6022', '0');
INSERT INTO `staff` VALUES ('2023', '201604003', '4023', '离职', '2009', '4003', '6023', '0');
INSERT INTO `staff` VALUES ('2024', '201604004', '4024', '在职', '2006', '4004', '6024', '0');
INSERT INTO `staff` VALUES ('2025', '201604005', '4025', '在职', '2007', '4005', '6025', '0');
INSERT INTO `staff` VALUES ('2026', '201604007', '4026', '在职', '2006', '4007', '6026', '0');
INSERT INTO `staff` VALUES ('2027', '201604008', '4027', '在职', '2006', '4008', '6027', '0');
INSERT INTO `staff` VALUES ('2028', '201604009', '4028', '在职', '2002', '4009', '6028', '0');
INSERT INTO `staff` VALUES ('2029', '201604010', '4029', '在职', '2007', '4010', '6029', '0');
INSERT INTO `staff` VALUES ('2030', '201604011', '4030', '在职', '2006', '4011', '6030', '0');
INSERT INTO `staff` VALUES ('2031', '201604012', '4031', '在职', '2002', '4012', '6031', '0');
INSERT INTO `staff` VALUES ('2032', '201604013', '4032', '在职', '2006', '4013', '6032', '0');
INSERT INTO `staff` VALUES ('2033', '201604014', '4033', '离职', '2009', '4014', '6033', '0');
INSERT INTO `staff` VALUES ('2034', '201604015', '4034', '在职', '2007', '4015', '6034', '0');
INSERT INTO `staff` VALUES ('2035', '201604016', '4035', '在职', '2006', '4016', '6035', '0');
INSERT INTO `staff` VALUES ('2036', '201604017', '4036', '在职', '2005', '4017', '6036', '0');
INSERT INTO `staff` VALUES ('2037', '201604018', '4037', '在职', '2007', '4018', '6037', '0');
INSERT INTO `staff` VALUES ('2038', '201604020', '4038', '在职', '2007', '4020', '6038', '0');
INSERT INTO `staff` VALUES ('2039', '201604021', '4039', '离职', '2009', '4021', '6039', '0');

-- ----------------------------
-- Table structure for `user_auth`
-- ----------------------------
DROP TABLE IF EXISTS `user_auth`;
CREATE TABLE `user_auth` (
  `id` varchar(11) NOT NULL,
  `staff_id` varchar(11) NOT NULL COMMENT '职员ID',
  `password` varchar(30) NOT NULL,
  `avatar` varchar(30) DEFAULT NULL COMMENT '头像的地址，如：/avatar/1.png',
  `auth_level` int(11) NOT NULL DEFAULT '0' COMMENT '授权登记；普通用户为0，管理员为1',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '账号是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='登录信息';

-- ----------------------------
-- Records of user_auth
-- ----------------------------
INSERT INTO `user_auth` VALUES ('201603981', '1001', '382718', '/avatar/1.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201603982', '1002', '423215', '/avatar/2.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201603983', '1003', '490352', '/avatar/3.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201603984', '1004', '456657', '/avatar/4.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201603985', '1005', '459231', '/avatar/5.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201603986', '1006', '550732', '/avatar/6.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201603987', '1007', '947611', '/avatar/7.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201603988', '1008', '397771', '/avatar/8.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201603989', '1009', '808145', '/avatar/9.png', '1', '0');
INSERT INTO `user_auth` VALUES ('201603990', '1010', '259708', '/avatar/10.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201603991', '1011', '381094', '/avatar/11.png', '1', '0');
INSERT INTO `user_auth` VALUES ('201603992', '1012', '875438', '/avatar/12.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201603993', '1013', '228844', '/avatar/13.png', '1', '0');
INSERT INTO `user_auth` VALUES ('201603994', '1014', '772736', '/avatar/14.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201603995', '1015', '563199', '/avatar/15.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201603996', '1016', '946274', '/avatar/16.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201603997', '1017', '243909', '/avatar/17.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201603998', '1018', '561589', '/avatar/18.png', '1', '0');
INSERT INTO `user_auth` VALUES ('201603999', '1019', '373735', '/avatar/19.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201604000', '1020', '209515', '/avatar/20.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201604001', '1021', '678586', '/avatar/21.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201604002', '1022', '370770', '/avatar/22.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201604003', '1023', '915728', '/avatar/23.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201604004', '1024', '514635', '/avatar/24.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201604005', '1025', '765911', '/avatar/25.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201604007', '1026', '796579', '/avatar/26.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201604008', '1027', '273769', '/avatar/27.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201604009', '1028', '300408', '/avatar/28.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201604010', '1029', '704926', '/avatar/29.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201604011', '1030', '109937', '/avatar/30.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201604012', '1031', '349783', '/avatar/31.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201604013', '1032', '113189', '/avatar/32.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201604014', '1033', '148805', '/avatar/33.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201604015', '1034', '270124', '/avatar/34.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201604016', '1035', '278063', '/avatar/35.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201604017', '1036', '700228', '/avatar/36.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201604018', '1037', '370550', '/avatar/37.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201604020', '1038', '333910', '/avatar/38.png', '0', '0');
INSERT INTO `user_auth` VALUES ('201604021', '1039', '155904', '/avatar/39.png', '0', '0');

create table train
(
	id varchar(11) null,
	staff_id varchar(11) null comment '员工ID',
	program_id varchar(11) null comment '参加的培训项目的ID',
	time date null comment '培训时间',
	result varchar(30) null comment '培训评价'
)
comment '培训记录表';


