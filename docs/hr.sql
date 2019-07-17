/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50525
 Source Host           : localhost:3306
 Source Schema         : hr

 Target Server Type    : MySQL
 Target Server Version : 50525
 File Encoding         : 65001

 Date: 17/07/2019 09:25:18
*/
CREATE DATABASE IF NOT EXISTS `hr` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hr`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attendance
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance`  (
  `id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `staff_id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工编号',
  `time` date NULL DEFAULT NULL COMMENT '考勤时间',
  `type` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '考勤情况；迟到、旷班、请假、出差、停职、事假',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '考勤' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of attendance
-- ----------------------------
INSERT INTO `attendance` VALUES ('1', '20161010', '1997-10-10', '迟到');
INSERT INTO `attendance` VALUES ('2', '201603154', '1997-01-24', '迟到');
INSERT INTO `attendance` VALUES ('4', '20161010', '1997-10-10', '迟到');

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract`  (
  `id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `begin` date NULL DEFAULT NULL COMMENT '合同开始时间',
  `end` date NULL DEFAULT NULL COMMENT '合同截止时间',
  `position_id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对应position_log中的某个ID',
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合同内容',
  `remark` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of contract
-- ----------------------------
INSERT INTO `contract` VALUES ('201603981', '2016-11-29', '2016-12-17', '10', '麒显汉双茂扬裕化希珊锡丹', '无');
INSERT INTO `contract` VALUES ('201603982', '2016-07-25', '2016-09-02', '13', '庭继为阳来伯聪景向大飞星', '无');
INSERT INTO `contract` VALUES ('201603983', '2016-06-26', '2016-02-06', '40', '友潮珊淇雪青炳心丹成震胜', '无');
INSERT INTO `contract` VALUES ('201603984', '2016-02-17', '2017-10-17', '43', '夫万力建灿立霖钧彦贤强炳', '无');
INSERT INTO `contract` VALUES ('201603985', '2016-01-24', '2017-03-19', '50', '义露楚安仲利滨湘开锦兴颖', '无');
INSERT INTO `contract` VALUES ('201603986', '2016-01-07', '2016-11-14', '66', '惠佩宗栋咏冰泰长靖汝平逸', '无');
INSERT INTO `contract` VALUES ('201603987', '2017-09-28', '2017-08-15', '67', '祥京立若紫雄慧波腾捷基雨', '无');
INSERT INTO `contract` VALUES ('201603988', '2016-12-07', '2016-12-10', '68', '年承岩哲璇山森萌汝宜杰奕', '无');
INSERT INTO `contract` VALUES ('201603989', '2016-01-27', '2017-04-17', '91', '若诗胜诗锋绍伟中翔森哲城', '无');
INSERT INTO `contract` VALUES ('201603990', '2016-12-12', '2016-01-24', '92', '孟文源喜非昕大震行迪舒志', '无');
INSERT INTO `contract` VALUES ('201603991', '2017-05-15', '2017-07-22', '93', '书武为虎若星荣泰鸣琴栋咏', '无');
INSERT INTO `contract` VALUES ('201603992', '2017-06-29', '2017-01-04', '96', '其双学昌仪海武鹏棋瑞依涛', '无');
INSERT INTO `contract` VALUES ('201603993', '2017-12-31', '2017-03-02', NULL, '雅亮先彤天丹祖宝倩锡如依', '无');
INSERT INTO `contract` VALUES ('201603994', '2016-07-14', '2017-01-18', NULL, '佳旭锦高子晨田波良书桐鑫', '无');
INSERT INTO `contract` VALUES ('201603995', '2016-02-24', '2017-06-06', NULL, '泉忠中玉昕仪虹庭咏丹伟银', '无');
INSERT INTO `contract` VALUES ('201603996', '2017-12-31', '2017-09-13', NULL, '亮孟承兴聪孝嘉涵之启珠菁', '无');
INSERT INTO `contract` VALUES ('201603997', '2016-09-02', '2017-06-04', NULL, '洁慧亮震星黎锡书诚有翰晨', '无');
INSERT INTO `contract` VALUES ('201603998', '2016-09-19', '2017-10-05', NULL, '升开邦洋泰豪喜枫燕宪若伦', '无');
INSERT INTO `contract` VALUES ('201603999', '2017-08-01', '2016-08-24', NULL, '辉真兰琳枫利爽一骏如顺杰', '无');
INSERT INTO `contract` VALUES ('201604000', '2017-08-22', '2016-05-24', NULL, '妍彤圣乐宁楚尧百彪靖秀勇', '无');
INSERT INTO `contract` VALUES ('201604001', '2016-11-26', '2017-09-01', NULL, '蔚康月岩琴良少梦若琳凌润', '无');
INSERT INTO `contract` VALUES ('201604002', '2016-05-19', '2016-02-16', NULL, '梦来兵越洁钰书孝锦振琳素', '无');
INSERT INTO `contract` VALUES ('201604003', '2017-02-02', '2017-05-21', NULL, '邦新进庭洲伟秋泉申伯福会', '无');
INSERT INTO `contract` VALUES ('201604004', '2017-04-11', '2017-03-06', NULL, '政麟淇鸿迪宇安骏奇钧靖涵', '无');
INSERT INTO `contract` VALUES ('201604005', '2016-05-30', '2017-11-21', NULL, '麟福奇星夫冬石贵智一标乃', '无');
INSERT INTO `contract` VALUES ('201604007', '2016-04-28', '2017-04-18', NULL, '骏子岚楠化成菲亮萌升定广', '无');
INSERT INTO `contract` VALUES ('201604008', '2016-05-28', '2017-08-09', NULL, '立乐庭振颖信珠臣宁友炜岳', '无');
INSERT INTO `contract` VALUES ('201604009', '2016-10-21', '2016-10-24', NULL, '良光腾平宏素云彤英浩群龙', '无');
INSERT INTO `contract` VALUES ('201604010', '2017-08-29', '2017-01-01', NULL, '根京长洁臣大仲思震晶根贵', '无');
INSERT INTO `contract` VALUES ('201604011', '2016-04-06', '2017-09-14', NULL, '化华良雅爱迪锦静雁萍全承', '无');
INSERT INTO `contract` VALUES ('201604012', '2016-01-18', '2017-05-12', NULL, '高义峰建梓迪跃汝慧道振健', '无');
INSERT INTO `contract` VALUES ('201604013', '2016-06-24', '2016-07-13', NULL, '小小正铭江满伯振沛祖楠海', '无');
INSERT INTO `contract` VALUES ('201604014', '2016-09-16', '2017-11-01', NULL, '俊美夫德洁君西秀刚雷利宪', '无');
INSERT INTO `contract` VALUES ('201604015', '2017-02-15', '2016-01-25', NULL, '克灿枫祖颖瑞虎逸曼冬平滨', '无');
INSERT INTO `contract` VALUES ('201604016', '2016-12-28', '2016-09-15', NULL, '璇政银超吉月峰怀根威正枫', '无');
INSERT INTO `contract` VALUES ('201604017', '2016-09-19', '2016-10-26', NULL, '为政伊茜艳辰年宝彪章楠力', '无');
INSERT INTO `contract` VALUES ('201604018', '2016-09-16', '2017-03-19', NULL, '振斌延夏宪顺诗章泽劲宁珍', '无');
INSERT INTO `contract` VALUES ('201604020', '2017-01-09', '2017-09-09', NULL, '勋佩亦奇萍可滨为宪刚来雁', '无');
INSERT INTO `contract` VALUES ('201604021', '2017-01-23', '2017-03-08', NULL, '圣贤福佩俊蔚仪耀奕力富晶', '无');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `deleted` tinyint(4) NULL DEFAULT 0 COMMENT '部门是否解散；0没有',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('201603981', '周正华', 0);
INSERT INTO `department` VALUES ('201603982', '周成龙', 0);
INSERT INTO `department` VALUES ('201603983', '钟刚锐', 0);
INSERT INTO `department` VALUES ('201603984', '张玉梁', 0);
INSERT INTO `department` VALUES ('201603985', '张进', 0);
INSERT INTO `department` VALUES ('201603986', '袁福森', 0);
INSERT INTO `department` VALUES ('201603987', '叶鹏', 0);
INSERT INTO `department` VALUES ('201603988', '严海峰', 0);
INSERT INTO `department` VALUES ('201603989', '吴威', 0);
INSERT INTO `department` VALUES ('201603990', '文俊', 0);
INSERT INTO `department` VALUES ('201603991', '王晓晴', 0);
INSERT INTO `department` VALUES ('201603992', '汪维煊', 0);
INSERT INTO `department` VALUES ('201603993', '唐琦伟', 0);
INSERT INTO `department` VALUES ('201603994', '覃铃杰', 0);
INSERT INTO `department` VALUES ('201603995', '尚志', 0);
INSERT INTO `department` VALUES ('201603996', '邱依呷', 0);
INSERT INTO `department` VALUES ('201603997', '彭晓祥', 0);
INSERT INTO `department` VALUES ('201603998', '罗志垚', 0);
INSERT INTO `department` VALUES ('201603999', '刘洵', 0);
INSERT INTO `department` VALUES ('201604000', '李懿恒', 0);
INSERT INTO `department` VALUES ('201604001', '李何平', 0);
INSERT INTO `department` VALUES ('201604002', '揭洋', 0);
INSERT INTO `department` VALUES ('201604003', '黄潇', 0);
INSERT INTO `department` VALUES ('201604004', '黄俊淞', 0);
INSERT INTO `department` VALUES ('201604005', '胡济成', 0);
INSERT INTO `department` VALUES ('201604007', '付金明', 0);
INSERT INTO `department` VALUES ('201604008', '丁仕涛', 0);
INSERT INTO `department` VALUES ('201604009', '陈云豪', 0);
INSERT INTO `department` VALUES ('201604010', '陈浩', 0);
INSERT INTO `department` VALUES ('201604011', '蔡华庆', 0);
INSERT INTO `department` VALUES ('201604012', '黄蓉', 0);
INSERT INTO `department` VALUES ('201604013', '冯娅楠', 0);
INSERT INTO `department` VALUES ('201604014', '钟文玥希', 0);
INSERT INTO `department` VALUES ('201604015', '张宇宁', 0);
INSERT INTO `department` VALUES ('201604016', '杨丹瑞', 0);
INSERT INTO `department` VALUES ('201604017', '吴燕梅', 0);
INSERT INTO `department` VALUES ('201604018', '王淑楠', 0);
INSERT INTO `department` VALUES ('201604020', '鲁芸露', 0);
INSERT INTO `department` VALUES ('201604021', '李林芸', 0);

-- ----------------------------
-- Table structure for people
-- ----------------------------
DROP TABLE IF EXISTS `people`;
CREATE TABLE `people`  (
  `id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `birth` date NULL DEFAULT NULL,
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `degree` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学位',
  `register_date` date NULL DEFAULT NULL COMMENT '登记时间',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `deleted` tinyint(4) NULL DEFAULT 0 COMMENT '信息是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '所有人员信息，包括应聘但没入职的' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of people
-- ----------------------------
INSERT INTO `people` VALUES ('201603981', '周正华', '男', '1997-10-10', '17780815403', 'WA4L4A@V1NT5N.com', '高中', '2016-09-01', '和席包路雁川', 0);
INSERT INTO `people` VALUES ('201603982', '周成龙', '男', '1997-10-10', '18281140583', 'JW3E1P@L25DS4.com', '高中', '2016-09-01', '卫包纪苗秋逸', 0);
INSERT INTO `people` VALUES ('201603983', '钟刚锐', '男', '1997-10-10', '13658175365', '2AMQZX@IBK2E3.com', '高中', '2016-09-01', '熊俞臧孙雷尧', 0);
INSERT INTO `people` VALUES ('201603984', '张玉梁', '男', '1997-10-10', '17738269664', 'I5Q7F8@1C6DSW.com', '高中', '2016-09-01', '赵葛严钱逸勇', 0);
INSERT INTO `people` VALUES ('201603985', '张进', '男', '1997-10-10', '17780817384', '3WJKIT@4K7687.com', '高中', '2016-09-01', '堪时明贝安露', 0);
INSERT INTO `people` VALUES ('201603986', '袁福森', '男', '1997-10-10', '15881492213', 'E8GB8E@1SIY02.com', '高中', '2016-09-01', '邹姜方左碧丽', 0);
INSERT INTO `people` VALUES ('201603987', '叶鹏', '男', '1997-10-10', '17781606405', 'G6N7CI@N5KGT7.com', '高中', '2016-09-01', '咎傅宋颜涵德', 0);
INSERT INTO `people` VALUES ('201603988', '严海峰', '男', '1997-10-10', '18681280960', '1A77S8@U45YQ3.com', '高中', '2016-09-01', '苏米喻奚化开', 0);
INSERT INTO `people` VALUES ('201603989', '吴威', '男', '1997-10-10', '18780286171', 'XP04F0@XCWLY5.com', '高中', '2016-09-01', '诸孔卜赵怀真', 0);
INSERT INTO `people` VALUES ('201603990', '文俊', '男', '1997-10-10', '18398260702', '0KR03J@44U50K.com', '高中', '2016-09-01', '董粱薛徐辰乃', 0);
INSERT INTO `people` VALUES ('201603991', '王晓晴', '男', '1997-10-10', '17781792544', 'CILTT6@4L1406.com', '高中', '2016-09-01', '熊祝郝郑碧镇', 0);
INSERT INTO `people` VALUES ('201603992', '汪维煊', '男', '1997-10-10', '15111936880', '35LLVN@Q47XVJ.com', '高中', '2016-09-01', '丁苗熊柳靖劲', 0);
INSERT INTO `people` VALUES ('201603993', '唐琦伟', '男', '1997-10-10', '13388339674', 'U33668@WUNRJ7.com', '高中', '2016-09-01', '安明项萧化湘', 0);
INSERT INTO `people` VALUES ('201603994', '覃铃杰', '男', '1997-10-10', '17780813897', 'F72264@D441V8.com', '高中', '2016-09-01', '宗宗樊薛友锡', 0);
INSERT INTO `people` VALUES ('201603995', '尚志', '男', '1997-10-10', '17780814313', 'RGLBE6@80MH0T.com', '高中', '2016-09-01', '熊成尤闵波咏', 0);
INSERT INTO `people` VALUES ('201603996', '邱依呷', '男', '1997-10-10', '17780816864', 'KVJLGK@GK55GK.com', '高中', '2016-09-01', '孙吉解毛杰裕', 0);
INSERT INTO `people` VALUES ('201603997', '彭晓祥', '男', '1997-10-10', '17781792745', 'RG85U4@15LROQ.com', '高中', '2016-09-01', '盛蒋郑钮灿雄', 0);
INSERT INTO `people` VALUES ('201603998', '罗志垚', '男', '1997-10-10', '18980158778', '106GX8@SLS278.com', '高中', '2016-09-01', '麻徐高舒邦中', 0);
INSERT INTO `people` VALUES ('201603999', '刘洵', '男', '1997-10-10', '18398263549', 'MT67FS@P87IK0.com', '高中', '2016-09-01', '左熊范袁秀嘉', 0);
INSERT INTO `people` VALUES ('201604000', '李懿恒', '男', '1997-10-10', '18783047537', '306L41@Y283JJ.com', '高中', '2016-09-01', '明范余宋羽哲', 0);
INSERT INTO `people` VALUES ('201604001', '李何平', '男', '1997-10-10', '18398211011', 'J6L50G@4JD8ZI.com', '高中', '2016-09-01', '傅童贺熊小权', 0);
INSERT INTO `people` VALUES ('201604002', '揭洋', '男', '1997-10-10', '17780818057', 'FX203Q@43HV56.com', '高中', '2016-09-01', '郝尤方戚婷根', 0);
INSERT INTO `people` VALUES ('201604003', '黄潇', '男', '1997-10-10', '18398263541', 'I4LCM4@1E1V34.com', '高中', '2016-09-01', '郑石钟诸劲征', 0);
INSERT INTO `people` VALUES ('201604004', '黄俊淞', '男', '1997-10-10', '15328480888', '0UFZNU@533I4H.com', '高中', '2016-09-01', '时乐田邱秋兴', 0);
INSERT INTO `people` VALUES ('201604005', '胡济成', '男', '1997-10-10', '18398260694', 'IMYO8M@M54U25.com', '高中', '2016-09-01', '孙徐卢赵茂生', 0);
INSERT INTO `people` VALUES ('201604007', '付金明', '男', '1997-10-10', '18398261121', 'M5I60X@Y8L8A7.com', '高中', '2016-09-01', '邓米周乐永珍', 0);
INSERT INTO `people` VALUES ('201604008', '丁仕涛', '男', '1997-10-10', '18398264689', 'W5RK36@MMTHMJ.com', '高中', '2016-09-01', '纪袁舒花劲腾', 0);
INSERT INTO `people` VALUES ('201604009', '陈云豪', '男', '1997-10-10', '18398261147', 'WEE510@67NWO7.com', '高中', '2016-09-01', '纪袁庞柏宇依', 0);
INSERT INTO `people` VALUES ('201604010', '陈浩', '男', '1997-10-10', '18398263526', '2YW34T@E1J2U3.com', '高中', '2016-09-01', '谢苏毛尤洋爱', 0);
INSERT INTO `people` VALUES ('201604011', '蔡华庆', '男', '1997-10-10', '17780816314', 'J6EA88@776G4Z.com', '高中', '2016-09-01', '贲钮姜万孝亮', 0);
INSERT INTO `people` VALUES ('201604012', '黄蓉', '女', '1997-10-10', '18398264693', '65JE81@Y42DTZ.com', '高中', '2016-09-01', '花戚崔郝福安', 0);
INSERT INTO `people` VALUES ('201604013', '冯娅楠', '女', '1997-10-10', '17781604351', '0J64B8@HTLUUD.com', '高中', '2016-09-01', '乐颜齐钱黎秋', 0);
INSERT INTO `people` VALUES ('201604014', '钟文玥希', '女', '1997-10-10', '18398263704', '4S5A55@FTMMPH.com', '高中', '2016-09-01', '廉郎云史妮仪', 0);
INSERT INTO `people` VALUES ('201604015', '张宇宁', '女', '1997-10-10', '17781604019', 'ZBOX26@P8MIZQ.com', '高中', '2016-09-01', '霍花贲徐安超', 0);
INSERT INTO `people` VALUES ('201604016', '杨丹瑞', '女', '1997-10-10', '13350039977', 'B3S631@K766E8.com', '高中', '2016-09-01', '周凤费柯铭宪', 0);
INSERT INTO `people` VALUES ('201604017', '吴燕梅', '女', '1997-10-10', '18398263578', 'TFDW20@S5G3OU.com', '高中', '2016-09-01', '咎吕吉成强伦', 0);
INSERT INTO `people` VALUES ('201604018', '王淑楠', '女', '1997-10-10', '18398264608', 'DC42A1@UB7148.com', '高中', '2016-09-01', '茅沈和任平波', 0);
INSERT INTO `people` VALUES ('201604020', '鲁芸露', '女', '1997-10-10', '17781609370', '8O7J77@A8H0DT.com', '高中', '2016-09-01', '路曹姚潘洲明', 0);
INSERT INTO `people` VALUES ('201604021', '李林芸', '女', '1997-10-10', '15729753325', 'EHCHIZ@6P03YR.com', '高中', '2016-09-01', '郝孙管花晨义', 0);

-- ----------------------------
-- Table structure for position_log
-- ----------------------------
DROP TABLE IF EXISTS `position_log`;
CREATE TABLE `position_log`  (
  `id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `staff_id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工ID',
  `from` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '旧职位',
  `to` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新职位',
  `time` date NULL DEFAULT NULL COMMENT '调动时间',
  `reason` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '调动理由',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of position_log
-- ----------------------------
INSERT INTO `position_log` VALUES ('10', '20168038', '西良', '雯健', '1997-10-10', '迟到');
INSERT INTO `position_log` VALUES ('13', '20165085', '正钰', '晓尧', '1997-10-10', '迟到');
INSERT INTO `position_log` VALUES ('40', '20168395', '乐仲', '秀雄', '1997-10-10', '迟到');
INSERT INTO `position_log` VALUES ('43', '20167018', '迪毅', '昕鸿', '1997-10-10', '迟到');
INSERT INTO `position_log` VALUES ('50', '20161244', '兰蕾', '德伟', '1997-10-10', '迟到');
INSERT INTO `position_log` VALUES ('66', '20162843', '鸿剑', '昕子', '1997-10-10', '迟到');
INSERT INTO `position_log` VALUES ('67', '20168525', '羽城', '伟政', '1997-10-10', '迟到');
INSERT INTO `position_log` VALUES ('68', '20164520', '心银', '山浩', '1997-10-10', '迟到');
INSERT INTO `position_log` VALUES ('91', '20161181', '燕利', '冰向', '1997-10-10', '迟到');
INSERT INTO `position_log` VALUES ('92', '20166759', '露恒', '鑫良', '1997-10-10', '迟到');
INSERT INTO `position_log` VALUES ('93', '20164232', '雷虹', '道荣', '1997-10-10', '迟到');
INSERT INTO `position_log` VALUES ('96', '20161940', '来宝', '潮湘', '1997-10-10', '迟到');

-- ----------------------------
-- Table structure for profile
-- ----------------------------
DROP TABLE IF EXISTS `profile`;
CREATE TABLE `profile`  (
  `id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '档案名称',
  `abstract` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容摘要',
  `remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `deleted` tinyint(4) NULL DEFAULT 0 COMMENT '档案是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '档案' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of profile
-- ----------------------------
INSERT INTO `profile` VALUES ('12', '银泰', '杰亦', '长和', 0);
INSERT INTO `profile` VALUES ('16', '国湘', '声涛', '奇浩', 0);
INSERT INTO `profile` VALUES ('34', '书旭', '军虎', '为曼', 0);
INSERT INTO `profile` VALUES ('40', '逸媛', '宇秋', '德高', 0);
INSERT INTO `profile` VALUES ('44', '婷鹤', '清卫', '中玲', 0);
INSERT INTO `profile` VALUES ('51', '日蕾', '凌川', '锦菲', 0);
INSERT INTO `profile` VALUES ('81', '森儿', '福佳', '奎风', 0);
INSERT INTO `profile` VALUES ('82', '红革', '富元', '素菊', 0);

-- ----------------------------
-- Table structure for program
-- ----------------------------
DROP TABLE IF EXISTS `program`;
CREATE TABLE `program`  (
  `id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `time` date NULL DEFAULT NULL COMMENT '项目创建时间',
  `remark` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `deleted` tinyint(4) NULL DEFAULT 0 COMMENT '项目是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '培训项目' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of program
-- ----------------------------
INSERT INTO `program` VALUES ('15', '桐启忠石鸣', '1997-10-10', '然寿勋颖安', 0);
INSERT INTO `program` VALUES ('30', '汝平银宇航', '1997-10-10', '朝骏凯雨淑', 0);
INSERT INTO `program` VALUES ('43', '双彪高星轩', '1997-10-10', '哲恩萌星哲', 0);
INSERT INTO `program` VALUES ('54', '东劲信银舒', '1997-10-10', '敬诗翔如满', 0);
INSERT INTO `program` VALUES ('59', '申建佳萍鸣', '1997-10-10', '湘剑钰蕾良', 0);
INSERT INTO `program` VALUES ('66', '进一祥斌琦', '1997-10-10', '年兴石伦鹏', 0);
INSERT INTO `program` VALUES ('68', '孝洁然章远', '1997-10-10', '昕兆靖有坤', 0);
INSERT INTO `program` VALUES ('70', '朝朝革睿毅', '1997-10-10', '克少依成兴', 0);
INSERT INTO `program` VALUES ('74', '希怀晨章柏', '1997-10-10', '维妮荣丹逸', 0);
INSERT INTO `program` VALUES ('94', '才玲昊炳升', '1997-10-10', '新连金月申', 0);

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary`  (
  `id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `staff_id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工ID',
  `base` int(11) NOT NULL DEFAULT 0 COMMENT '基本工资',
  `extra` int(11) NOT NULL DEFAULT 0 COMMENT '绩效工资',
  `bonus` int(11) NOT NULL DEFAULT 0 COMMENT '奖金',
  `fine` int(11) NOT NULL DEFAULT 0 COMMENT '罚款',
  `total` int(11) NOT NULL DEFAULT 0 COMMENT '合计工资',
  `time` date NULL DEFAULT NULL COMMENT '工资发放时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '工资' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of salary
-- ----------------------------
INSERT INTO `salary` VALUES ('40', '20165870', 74, 62, 90, 64, 53, '1997-10-10');
INSERT INTO `salary` VALUES ('54', '20167830', 1193, 7237, 2604, 1310, 87365, '1997-10-30');
INSERT INTO `salary` VALUES ('55', '20169460', 4500, 8970, 9820, 2220, 81532, '1997-10-10');
INSERT INTO `salary` VALUES ('81', '20162162', 4501, 4093, 6959, 2515, 16979, '1997-10-10');
INSERT INTO `salary` VALUES ('83', '20165316', 20, 53, 30, 54, 64, '1997-10-10');

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff`  (
  `id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工编号',
  `pid` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'people id',
  `position_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位；对应与 position_log 中的某个 ID',
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '离职、在职',
  `department_id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在部门ID',
  `contract_id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合同ID',
  `profile_id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '档案ID',
  `deleted` tinyint(4) NULL DEFAULT 0 COMMENT '信息是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工信息' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('10', '3610', '20168038', '在职', '7517', '9849', '6685', 0);
INSERT INTO `staff` VALUES ('13', '9468', '20166759', '在职', '5733', '5212', '2465', 0);
INSERT INTO `staff` VALUES ('40', '5990', '20164232', '在职', '9472', '4084', '5368', 0);
INSERT INTO `staff` VALUES ('43', '7186', '20161940', '在职', '7768', '5076', '8380', 0);
INSERT INTO `staff` VALUES ('50', '1623', '20165085', '在职', '8037', '6282', '9235', 0);
INSERT INTO `staff` VALUES ('66', '6557', '20168395', '在职', '6296', '2474', '9990', 0);
INSERT INTO `staff` VALUES ('67', '8764', '20167018', '在职', '9480', '9865', '5290', 0);
INSERT INTO `staff` VALUES ('68', '5794', '20161244', '在职', '2059', '3262', '9394', 0);
INSERT INTO `staff` VALUES ('91', '9913', '20162843', '在职', '3492', '1693', '9068', 0);
INSERT INTO `staff` VALUES ('92', '6693', '20168525', '在职', '5780', '1760', '6835', 0);
INSERT INTO `staff` VALUES ('93', '6440', '20164520', '在职', '7129', '7767', '7253', 0);
INSERT INTO `staff` VALUES ('96', '8020', '20161181', '在职', '3480', '3015', '4985', 0);

-- ----------------------------
-- Table structure for user_auth
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user_auth`  (
  `id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `staff_id` varchar(11) not null comment '职员ID',
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `avatar` varchar(30) null comment '头像的地址，如：/avatar/1.png',
  `auth_level` int(11) NOT NULL DEFAULT 0 COMMENT '授权登记；普通用户为0，管理员为1',
  `deleted` tinyint(4) NULL DEFAULT 0 COMMENT '账号是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '登录信息' ROW_FORMAT = Compact;


SET FOREIGN_KEY_CHECKS = 1;
