/*
 Navicat Premium Data Transfer

 Source Server         : bsp
 Source Server Type    : MySQL
 Source Server Version : 50536
 Source Host           : localhost:3306
 Source Schema         : book_sharing_platform

 Target Server Type    : MySQL
 Target Server Version : 50536
 File Encoding         : 65001

 Date: 26/03/2018 23:41:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator`  (
  `a_uuid` varchar(33) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员唯一标识',
  `a_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '运营方名称',
  `a_password` varchar(21) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '运营方地址',
  `a_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '运营者描述',
  `a_phone` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话',
  `a_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员登录账号',
  `a_comments` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `isdelete` tinyint(4) NOT NULL COMMENT '是否可用，登录时需要判断，0没有禁用，1被禁用',
  PRIMARY KEY (`a_uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for check_demand_book
-- ----------------------------
DROP TABLE IF EXISTS `check_demand_book`;
CREATE TABLE `check_demand_book`  (
  `cdb_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '需求图书标识，数字自增长',
  `cdb_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '需求图书名称',
  `cdb_author` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '需求图书作者',
  `cdb_publishing` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '需求图书出版社',
  `isbn` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '需求图书的ISBN',
  `cdb_duration` int(11) NOT NULL COMMENT '需求图书需求时长',
  `cdb_number` int(11) NOT NULL COMMENT '需要图书数量',
  `image_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '需求图书照片路径',
  `cdb_comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `phone` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '需求者联系电话',
  `cdb_status` tinyint(4) NOT NULL COMMENT '图书审核状态:0提交申请未审核转态，1申请失败返回原因',
  `failure_cause` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '审核人员填写，审核失败的原因',
  `sc_id` int(11) NOT NULL COMMENT '需求图书所属的二级分类',
  `uuid` varchar(33) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '需求图书申请人',
  PRIMARY KEY (`cdb_id`) USING BTREE,
  INDEX `FKc6if89oh86n3vxut5uuave8a8`(`sc_id`) USING BTREE,
  INDEX `FKhid2mb9kb9d8a2p0yovaapvfb`(`uuid`) USING BTREE,
  CONSTRAINT `FKhid2mb9kb9d8a2p0yovaapvfb` FOREIGN KEY (`uuid`) REFERENCES `user` (`uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKc6if89oh86n3vxut5uuave8a8` FOREIGN KEY (`sc_id`) REFERENCES `secondary_classification` (`sc_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for check_loanable_book
-- ----------------------------
DROP TABLE IF EXISTS `check_loanable_book`;
CREATE TABLE `check_loanable_book`  (
  `clb_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '共享的图书标识，数字自增长',
  `clb_author` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '共享图书作者',
  `clb_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '共享图书名称',
  `clb_publishing` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '共享图书出版社',
  `isbn` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '共享图书的ISBN',
  `clb_duration` int(11) NOT NULL COMMENT '图书可共享时长',
  `clb_number` int(11) NOT NULL COMMENT '可共享图书数量',
  `image_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '共享图书照片路径',
  `clb_comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `phone` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '共享者的联系电话',
  `clb_status` tinyint(4) NOT NULL COMMENT '图书审核状态:0提交申请未审核转态，1申请失败返回原因',
  `failure_cause` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '审核人员填写，审核失败的原因',
  `sc_id` int(11) NOT NULL COMMENT '共享图书所属的二级分类',
  `uuid` varchar(33) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '共享图书申请人',
  PRIMARY KEY (`clb_id`) USING BTREE,
  INDEX `FKkld0wnb45l7fsg94ulvg97jgm`(`sc_id`) USING BTREE,
  INDEX `FKqckqc9s430podyftxap7a8skx`(`uuid`) USING BTREE,
  CONSTRAINT `FKqckqc9s430podyftxap7a8skx` FOREIGN KEY (`uuid`) REFERENCES `user` (`uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKkld0wnb45l7fsg94ulvg97jgm` FOREIGN KEY (`sc_id`) REFERENCES `secondary_classification` (`sc_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for demand_book
-- ----------------------------
DROP TABLE IF EXISTS `demand_book`;
CREATE TABLE `demand_book`  (
  `db_id` int(11) NOT NULL COMMENT '需求图书标识，来源于check_demand_book表主键',
  `db_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '需求图书名称',
  `db_author` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '需求图书作者',
  `db_publishing` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT ' 需求图书的出版社',
  `isbn` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '需求图书的ISBN',
  `db_duratuin` int(11) NOT NULL COMMENT '需求图书时长',
  `db_number` int(11) NOT NULL COMMENT '需求图书的数量',
  `image_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '需求图书照片路径',
  `db_comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `phone` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT ' 需求者的联系电话',
  `open_demand_time` datetime DEFAULT NULL COMMENT ' 开启图书需求的时间',
  `db_status` tinyint(4) NOT NULL COMMENT '开启需求状态：0停止需求，1开始需求',
  `is_delete` tinyint(4) NOT NULL COMMENT '删除图书：0没有删除，1表示删除，默认为0',
  `sc_id` int(11) NOT NULL COMMENT ' 需求图书所属的二级分类',
  `uuid` varchar(33) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '需求图书所属的用户',
  PRIMARY KEY (`db_id`) USING BTREE,
  INDEX `FKm8v0asyr2m1gj705j3au5d6e6`(`sc_id`) USING BTREE,
  INDEX `FKpsm7rge07898jwqf63o33t7fg`(`uuid`) USING BTREE,
  CONSTRAINT `FKpsm7rge07898jwqf63o33t7fg` FOREIGN KEY (`uuid`) REFERENCES `user` (`uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKm8v0asyr2m1gj705j3au5d6e6` FOREIGN KEY (`sc_id`) REFERENCES `secondary_classification` (`sc_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for donated_book
-- ----------------------------
DROP TABLE IF EXISTS `donated_book`;
CREATE TABLE `donated_book`  (
  `dob_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '捐赠的图书标识，数字自增值',
  `dob_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '捐赠的图书名称',
  `isbn` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '捐赠的图书ISBN号',
  `number` int(11) NOT NULL COMMENT '捐赠的图书数量',
  `sc_id` int(11) NOT NULL COMMENT '捐赠图书所属的二级分类',
  `uuid` varchar(33) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '捐赠人',
  PRIMARY KEY (`dob_id`) USING BTREE,
  INDEX `FKh45bmrwc34etref3un2f51pj0`(`sc_id`) USING BTREE,
  INDEX `FKqk83s5hu3qrgnydw0dboku20e`(`uuid`) USING BTREE,
  CONSTRAINT `FKqk83s5hu3qrgnydw0dboku20e` FOREIGN KEY (`uuid`) REFERENCES `user` (`uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKh45bmrwc34etref3un2f51pj0` FOREIGN KEY (`sc_id`) REFERENCES `secondary_classification` (`sc_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for lending_history
-- ----------------------------
DROP TABLE IF EXISTS `lending_history`;
CREATE TABLE `lending_history`  (
  `lh_id` int(11) NOT NULL COMMENT '借出记录历史标识，来源于LendingRecord表的主键',
  `create_time` datetime DEFAULT NULL COMMENT '借阅人申请时间，创建订单',
  `agree_time` datetime DEFAULT NULL COMMENT '借出人同意申请时间',
  `send_to_time` datetime DEFAULT NULL COMMENT '借出人送达运营商服务点时间',
  `take_away_time` datetime DEFAULT NULL COMMENT '借阅人取走图书时间',
  `expected_return_time` datetime DEFAULT NULL COMMENT '借阅人预期还书时间',
  `actual_return_time` datetime DEFAULT NULL COMMENT '借阅人实际还书时间',
  `take_back_time` datetime DEFAULT NULL COMMENT '借出人取回图书时间',
  `lh_struts` tinyint(4) NOT NULL COMMENT '1借阅人取消，2借出人拒绝申请，3申请超时借出人未同意，5借出人逾期未送达运营方，12借出人取回归还的图书，13借出人捐赠图书',
  `loan_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '借阅人电话号码',
  `lb_id` int(11) NOT NULL COMMENT '借阅的图书',
  `uuid` varchar(33) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '借阅人',
  `receive_uuid` varchar(33) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收到借出人送达图书的机构',
  `back_uuid` varchar(33) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收到借阅人还图书的机构',
  PRIMARY KEY (`lh_id`) USING BTREE,
  INDEX `FKh4lfbyr8nb9px111xy30sq53a`(`back_uuid`) USING BTREE,
  INDEX `FKr8bar09oqoy4qtbhmuajgggfw`(`lb_id`) USING BTREE,
  INDEX `FK4mb3dn1kfkapetlj4v9x37krn`(`receive_uuid`) USING BTREE,
  INDEX `FKmwnhbcswmtuspk8hyyrakxna4`(`uuid`) USING BTREE,
  CONSTRAINT `FKmwnhbcswmtuspk8hyyrakxna4` FOREIGN KEY (`uuid`) REFERENCES `user` (`uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK4mb3dn1kfkapetlj4v9x37krn` FOREIGN KEY (`receive_uuid`) REFERENCES `administrator` (`a_uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKh4lfbyr8nb9px111xy30sq53a` FOREIGN KEY (`back_uuid`) REFERENCES `administrator` (`a_uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKr8bar09oqoy4qtbhmuajgggfw` FOREIGN KEY (`lb_id`) REFERENCES `loanable_book` (`lb_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for lending_record
-- ----------------------------
DROP TABLE IF EXISTS `lending_record`;
CREATE TABLE `lending_record`  (
  `lr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '借出记录标识，数字自增长',
  `create_time` datetime DEFAULT NULL COMMENT '借阅人申请时间，创建订单',
  `agree_time` datetime DEFAULT NULL COMMENT '借出人同意申请时间',
  `send_to_time` datetime DEFAULT NULL COMMENT '借出人送达运营商服务点时间',
  `take_away_time` datetime DEFAULT NULL COMMENT '借阅人取走图书时间',
  `expected_return_time` datetime DEFAULT NULL COMMENT '借阅人预期还书时间',
  `actual_return_time` datetime DEFAULT NULL COMMENT '借阅人实际还书时间',
  `take_back_time` datetime DEFAULT NULL COMMENT '借出人取回图书时间',
  `lr_struts` tinyint(4) NOT NULL COMMENT '借出记录状态 0发布申请，4借出人同意借书申请，6借出人送达运营商，7借阅人逾期未取书，8借阅人拿到图书，9借阅人逾期未还，10借出方已经还书，11借出方逾期没有取回图书',
  `loan_phone` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '借阅人电话号码',
  `lb_id` int(11) NOT NULL COMMENT '借阅的图书',
  `uuid` varchar(33) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '借阅人',
  `receive_uuid` varchar(33) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收到借出人送达图书的机构',
  `back_uuid` varchar(33) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收到借阅人还图书的机构',
  PRIMARY KEY (`lr_id`) USING BTREE,
  INDEX `FK3ihcdi8oemx69a00pcb9fkrpg`(`back_uuid`) USING BTREE,
  INDEX `FK25q7i39xrtwj48c2wq6kb4dr6`(`lb_id`) USING BTREE,
  INDEX `FKawpqnxsx4w797jlmoykoos37k`(`receive_uuid`) USING BTREE,
  INDEX `FK9d77hacy0ngffex45q08qx8j5`(`uuid`) USING BTREE,
  CONSTRAINT `FK9d77hacy0ngffex45q08qx8j5` FOREIGN KEY (`uuid`) REFERENCES `user` (`uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK25q7i39xrtwj48c2wq6kb4dr6` FOREIGN KEY (`lb_id`) REFERENCES `loanable_book` (`lb_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK3ihcdi8oemx69a00pcb9fkrpg` FOREIGN KEY (`back_uuid`) REFERENCES `administrator` (`a_uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKawpqnxsx4w797jlmoykoos37k` FOREIGN KEY (`receive_uuid`) REFERENCES `administrator` (`a_uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for loanable_book
-- ----------------------------
DROP TABLE IF EXISTS `loanable_book`;
CREATE TABLE `loanable_book`  (
  `lb_id` int(11) NOT NULL COMMENT '共享的图书标识，来源CheckLoanableBook表主键',
  `lb_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '共享图书名称',
  `lb_author` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '共享图书作者',
  `lb_publishing` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '共享图书出版社',
  `isbn` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '共享图书的ISBN',
  `lb_duratuin` int(11) NOT NULL COMMENT '共享图书可共享时长',
  `lb_number` int(11) NOT NULL COMMENT '可共享图书数量',
  `image_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '共享图书照片路径',
  `lb_comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `phone` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '共享者的联系电话',
  `open_loan_time` datetime DEFAULT NULL COMMENT '开启图书共享的时间',
  `total_lending` int(11) DEFAULT NULL COMMENT '共享累计借出总数,初始为0',
  `lb_status` tinyint(4) NOT NULL COMMENT '开启借阅状态：0停止共享，1开始共享，默认为1',
  `is_delete` tinyint(4) NOT NULL COMMENT '删除图书：0没有删除，1表示删除，默认为0',
  `sc_id` int(11) NOT NULL COMMENT '共享图书所属的二级分类',
  `uuid` varchar(33) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '共享图书所属的用户',
  PRIMARY KEY (`lb_id`) USING BTREE,
  INDEX `FKtdh9wvruiyi1w3t03m4ollqpd`(`sc_id`) USING BTREE,
  INDEX `FK1xj6yghopeuuwsp2i6wlilpfg`(`uuid`) USING BTREE,
  CONSTRAINT `FK1xj6yghopeuuwsp2i6wlilpfg` FOREIGN KEY (`uuid`) REFERENCES `user` (`uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKtdh9wvruiyi1w3t03m4ollqpd` FOREIGN KEY (`sc_id`) REFERENCES `secondary_classification` (`sc_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for mapping
-- ----------------------------
DROP TABLE IF EXISTS `mapping`;
CREATE TABLE `mapping`  (
  `mapkey` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键，键',
  `m_value` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT ' 值',
  PRIMARY KEY (`mapkey`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `n_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '通知消息记录ID，数字自增长	',
  `n_subject` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '通知消息标题',
  `n_content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '通知消息内容',
  `news_time` datetime NOT NULL COMMENT '产生消息的时间',
  `uuid` varchar(33) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '通知消息所属的用户 ',
  PRIMARY KEY (`n_id`) USING BTREE,
  INDEX `FKf96u6pu7bsv28mi8kwql3ubb7`(`uuid`) USING BTREE,
  CONSTRAINT `FKf96u6pu7bsv28mi8kwql3ubb7` FOREIGN KEY (`uuid`) REFERENCES `user` (`uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for outdated_news
-- ----------------------------
DROP TABLE IF EXISTS `outdated_news`;
CREATE TABLE `outdated_news`  (
  `n_id` int(11) NOT NULL COMMENT '通知消息记录ID，来源news表主键	',
  `n_subject` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '通知消息标题',
  `n_content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '通知消息内容',
  `news_time` datetime NOT NULL COMMENT '产生消息的时间',
  `uuid` varchar(33) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '通知消息所属的用户 ',
  PRIMARY KEY (`n_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for primary_classification
-- ----------------------------
DROP TABLE IF EXISTS `primary_classification`;
CREATE TABLE `primary_classification`  (
  `pc_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图书一级分类唯一标识，数字自增长',
  `pc_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否删除分类 0表示没有删除，1表示删除，默认为0',
  `is_delete` tinyint(4) NOT NULL COMMENT '一级分类名称',
  PRIMARY KEY (`pc_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for respond_history
-- ----------------------------
DROP TABLE IF EXISTS `respond_history`;
CREATE TABLE `respond_history`  (
  `rh_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '响应记录标识，来源RespondRecord表主键',
  `respond_time` datetime DEFAULT NULL COMMENT '需求者响应时间',
  `send_to_time` datetime DEFAULT NULL COMMENT '响应者送达运营商服务点时间',
  `take_away_time` datetime DEFAULT NULL COMMENT '需求者取走图书时间',
  `expected_return_time` datetime DEFAULT NULL COMMENT '需求者预期还书时间',
  `actual_return_time` datetime DEFAULT NULL COMMENT '需求者实际还书时间',
  `take_back_time` datetime DEFAULT NULL COMMENT '响应者取回图书时间',
  `rh_struts` tinyint(4) NOT NULL COMMENT '1需求者取消需求，2响应者取消响应，3响应者逾期未送达运营方，10响应者取回图书，11响应者捐赠图书',
  `respond_phone` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '响应者电话号码',
  `db_id` int(11) NOT NULL COMMENT '需求的图书',
  `uuid` varchar(33) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '响应者',
  `receive_uuid` varchar(33) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收到借出人送到图书的机构',
  `back_uuid` varchar(33) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收到借阅人还图书的机构',
  PRIMARY KEY (`rh_id`) USING BTREE,
  INDEX `FKc4n2o3pnt7v1ro1llit26bdh9`(`back_uuid`) USING BTREE,
  INDEX `FKpitdtd9j0unkorryr5v9o6peo`(`db_id`) USING BTREE,
  INDEX `FKm3dc3iuwl80ca9gg0nixapqpa`(`receive_uuid`) USING BTREE,
  INDEX `FKen5iu87u8vxcd5fiigbd7m2fy`(`uuid`) USING BTREE,
  CONSTRAINT `FKen5iu87u8vxcd5fiigbd7m2fy` FOREIGN KEY (`uuid`) REFERENCES `user` (`uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKc4n2o3pnt7v1ro1llit26bdh9` FOREIGN KEY (`back_uuid`) REFERENCES `administrator` (`a_uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKm3dc3iuwl80ca9gg0nixapqpa` FOREIGN KEY (`receive_uuid`) REFERENCES `administrator` (`a_uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKpitdtd9j0unkorryr5v9o6peo` FOREIGN KEY (`db_id`) REFERENCES `demand_book` (`db_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for respond_record
-- ----------------------------
DROP TABLE IF EXISTS `respond_record`;
CREATE TABLE `respond_record`  (
  `rr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '响应记录标识，数字自增长',
  `respond_time` datetime DEFAULT NULL COMMENT '需求者响应时间',
  `send_to_time` datetime DEFAULT NULL COMMENT '响应者送达运营商服务点时间',
  `take_away_time` datetime DEFAULT NULL COMMENT '需求者取走图书时间',
  `expected_return_time` datetime DEFAULT NULL COMMENT '需求者预期还书时间',
  `actual_return_time` datetime DEFAULT NULL COMMENT '需求者实际还书时间',
  `take_back_time` datetime DEFAULT NULL COMMENT '响应者取回图书时间',
  `rr_struts` tinyint(4) NOT NULL COMMENT '0需求被响应，4响应者送达图书到运营方，5需求者逾期未取书，6需求者取走图书，7需求者逾期未还，8需求者还书，9响应者逾期未取回',
  `respond_phone` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '响应者电话号码',
  `db_id` int(11) NOT NULL COMMENT '需求的图书',
  `uuid` varchar(33) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '响应者',
  `receive_uuid` varchar(33) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收到借出人送到图书的机构',
  `back_uuid` varchar(33) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收到借阅人还图书的机构',
  PRIMARY KEY (`rr_id`) USING BTREE,
  INDEX `FK89a26aixakyy0k9o7ikpukkre`(`back_uuid`) USING BTREE,
  INDEX `FK1cmp26fjwow0e0srh5q4xkaor`(`db_id`) USING BTREE,
  INDEX `FK8qaplwhx6f0yc7qjwtby8d2dr`(`receive_uuid`) USING BTREE,
  INDEX `FK5k9cn0i74f6tkxvypn0x6p33a`(`uuid`) USING BTREE,
  CONSTRAINT `FK5k9cn0i74f6tkxvypn0x6p33a` FOREIGN KEY (`uuid`) REFERENCES `user` (`uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK1cmp26fjwow0e0srh5q4xkaor` FOREIGN KEY (`db_id`) REFERENCES `demand_book` (`db_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK89a26aixakyy0k9o7ikpukkre` FOREIGN KEY (`back_uuid`) REFERENCES `administrator` (`a_uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK8qaplwhx6f0yc7qjwtby8d2dr` FOREIGN KEY (`receive_uuid`) REFERENCES `administrator` (`a_uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for secondary_classification
-- ----------------------------
DROP TABLE IF EXISTS `secondary_classification`;
CREATE TABLE `secondary_classification`  (
  `sc_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图书二级分类唯一标识，数字增长值',
  `sc_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '二级分类名称',
  `pc_id` int(11) NOT NULL COMMENT '所属一级分类',
  `is_dalete` tinyint(4) NOT NULL COMMENT '是否删除分类 0表示没有删除，1表示删除，默认为0',
  PRIMARY KEY (`sc_id`) USING BTREE,
  INDEX `FKfnox8i80pxh4rxj3ubjk7b0kd`(`pc_id`) USING BTREE,
  CONSTRAINT `FKfnox8i80pxh4rxj3ubjk7b0kd` FOREIGN KEY (`pc_id`) REFERENCES `primary_classification` (`pc_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uuid` varchar(33) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户唯一标识符号',
  `mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户邮箱，作为用户登录账号',
  `password` varchar(33) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户登录账号密码',
  `isDelete` tinyint(4) NOT NULL COMMENT '0没有禁用，1被禁用，默认为0',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user_infor
-- ----------------------------
DROP TABLE IF EXISTS `user_infor`;
CREATE TABLE `user_infor`  (
  `uuid` varchar(33) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户唯一标识来源于user表主键',
  `u_nickname` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户的昵称',
  `u_sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户性别',
  `u_phone` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户联系手机号码',
  `u_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户联系地址',
  `u_qq` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户QQ号',
  `u_wechat` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户微信号',
  `u_headpath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像路径',
  `u_signature` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户个性签名 ',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
