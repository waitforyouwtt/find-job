/*
Navicat MySQL Data Transfer

Source Server         : find-job
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : mowa_db

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2020-01-11 10:55:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_title` varchar(70) DEFAULT NULL COMMENT '活动标题',
  `activity_content` varchar(255) DEFAULT NULL COMMENT '活动内容',
  `activity_create_date` datetime DEFAULT NULL COMMENT '活动创建时间',
  `activity_end_date` datetime DEFAULT NULL COMMENT '活动结束时间',
  `activity_status` int(11) DEFAULT NULL COMMENT '活动状态：1 初始化 2 有效 3 失效',
  `examine_status` int(11) DEFAULT NULL COMMENT '审核状态：1 待审核 2 已通过 3已驳回',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除：1 删除 2 未删除',
  `founder` varchar(50) DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(50) DEFAULT NULL COMMENT '修改人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_id` int(11) DEFAULT NULL COMMENT '活动id',
  `activity_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '活动图片url',
  `rank_field` int(11) DEFAULT NULL COMMENT '排次',
  `banner_img_status` int(11) DEFAULT NULL COMMENT '图片状态：1 正常 2失效',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除：1 删除 2 未删除',
  `founder` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '修改人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of banner
-- ----------------------------
INSERT INTO `banner` VALUES ('4', '3', '十里春风不如你', '3', '1', '1', 'admin', null, null, null);

-- ----------------------------
-- Table structure for bbs_area
-- ----------------------------
DROP TABLE IF EXISTS `bbs_area`;
CREATE TABLE `bbs_area` (
  `area_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(255) DEFAULT NULL COMMENT '名称',
  `pid` int(11) DEFAULT '0' COMMENT '父级ID',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  PRIMARY KEY (`area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3985 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bbs_area
-- ----------------------------
INSERT INTO `bbs_area` VALUES ('1', '北京', '0', '1');
INSERT INTO `bbs_area` VALUES ('2', '北京市', '1', '1');
INSERT INTO `bbs_area` VALUES ('3', '东城区', '2', '1');
INSERT INTO `bbs_area` VALUES ('4', '西城区', '2', '1');
INSERT INTO `bbs_area` VALUES ('5', '崇文区', '2', '1');
INSERT INTO `bbs_area` VALUES ('6', '宣武区', '2', '1');
INSERT INTO `bbs_area` VALUES ('7', '朝阳区', '2', '1');
INSERT INTO `bbs_area` VALUES ('8', '丰台区', '2', '1');
INSERT INTO `bbs_area` VALUES ('9', '石景山区', '2', '1');
INSERT INTO `bbs_area` VALUES ('10', '海淀区', '2', '1');
INSERT INTO `bbs_area` VALUES ('11', '门头沟区', '2', '1');
INSERT INTO `bbs_area` VALUES ('12', '房山区', '2', '1');
INSERT INTO `bbs_area` VALUES ('13', '通州区', '2', '1');
INSERT INTO `bbs_area` VALUES ('14', '顺义区', '2', '1');
INSERT INTO `bbs_area` VALUES ('15', '昌平区', '2', '1');
INSERT INTO `bbs_area` VALUES ('16', '大兴区', '2', '1');
INSERT INTO `bbs_area` VALUES ('17', '怀柔区', '2', '1');
INSERT INTO `bbs_area` VALUES ('18', '平谷区', '2', '1');
INSERT INTO `bbs_area` VALUES ('19', '密云县', '2', '1');
INSERT INTO `bbs_area` VALUES ('20', '延庆县', '2', '1');
INSERT INTO `bbs_area` VALUES ('21', '天津', '0', '1');
INSERT INTO `bbs_area` VALUES ('22', '天津市', '21', '1');
INSERT INTO `bbs_area` VALUES ('23', '和平区', '22', '1');
INSERT INTO `bbs_area` VALUES ('24', '河东区', '22', '1');
INSERT INTO `bbs_area` VALUES ('25', '河西区', '22', '1');
INSERT INTO `bbs_area` VALUES ('26', '南开区', '22', '1');
INSERT INTO `bbs_area` VALUES ('27', '河北区', '22', '1');
INSERT INTO `bbs_area` VALUES ('28', '红桥区', '22', '1');
INSERT INTO `bbs_area` VALUES ('29', '塘沽区', '22', '1');
INSERT INTO `bbs_area` VALUES ('30', '汉沽区', '22', '1');
INSERT INTO `bbs_area` VALUES ('31', '大港区', '22', '1');
INSERT INTO `bbs_area` VALUES ('32', '东丽区', '22', '1');
INSERT INTO `bbs_area` VALUES ('33', '西青区', '22', '1');
INSERT INTO `bbs_area` VALUES ('34', '津南区', '22', '1');
INSERT INTO `bbs_area` VALUES ('35', '北辰区', '22', '1');
INSERT INTO `bbs_area` VALUES ('36', '武清区', '22', '1');
INSERT INTO `bbs_area` VALUES ('37', '宝坻区', '22', '1');
INSERT INTO `bbs_area` VALUES ('38', '宁河县', '22', '1');
INSERT INTO `bbs_area` VALUES ('39', '静海县', '22', '1');
INSERT INTO `bbs_area` VALUES ('40', '蓟县', '22', '1');
INSERT INTO `bbs_area` VALUES ('41', '河北', '0', '1');
INSERT INTO `bbs_area` VALUES ('42', '石家庄市', '41', '1');
INSERT INTO `bbs_area` VALUES ('43', '长安区', '42', '1');
INSERT INTO `bbs_area` VALUES ('44', '桥东区', '42', '1');
INSERT INTO `bbs_area` VALUES ('45', '桥西区', '42', '1');
INSERT INTO `bbs_area` VALUES ('46', '新华区', '42', '1');
INSERT INTO `bbs_area` VALUES ('47', '井陉矿区', '42', '1');
INSERT INTO `bbs_area` VALUES ('48', '裕华区', '42', '1');
INSERT INTO `bbs_area` VALUES ('49', '井陉县', '42', '1');
INSERT INTO `bbs_area` VALUES ('50', '正定县', '42', '1');
INSERT INTO `bbs_area` VALUES ('51', '栾城县', '42', '1');
INSERT INTO `bbs_area` VALUES ('52', '行唐县', '42', '1');
INSERT INTO `bbs_area` VALUES ('53', '灵寿县', '42', '1');
INSERT INTO `bbs_area` VALUES ('54', '高邑县', '42', '1');
INSERT INTO `bbs_area` VALUES ('55', '深泽县', '42', '1');
INSERT INTO `bbs_area` VALUES ('56', '赞皇县', '42', '1');
INSERT INTO `bbs_area` VALUES ('57', '无极县', '42', '1');
INSERT INTO `bbs_area` VALUES ('58', '平山县', '42', '1');
INSERT INTO `bbs_area` VALUES ('59', '元氏县', '42', '1');
INSERT INTO `bbs_area` VALUES ('60', '赵县', '42', '1');
INSERT INTO `bbs_area` VALUES ('61', '辛集市', '42', '1');
INSERT INTO `bbs_area` VALUES ('62', '藁城市', '42', '1');
INSERT INTO `bbs_area` VALUES ('63', '晋州市', '42', '1');
INSERT INTO `bbs_area` VALUES ('64', '新乐市', '42', '1');
INSERT INTO `bbs_area` VALUES ('65', '鹿泉市', '42', '1');
INSERT INTO `bbs_area` VALUES ('66', '唐山市', '41', '1');
INSERT INTO `bbs_area` VALUES ('67', '路南区', '66', '1');
INSERT INTO `bbs_area` VALUES ('68', '路北区', '66', '1');
INSERT INTO `bbs_area` VALUES ('69', '古冶区', '66', '1');
INSERT INTO `bbs_area` VALUES ('70', '开平区', '66', '1');
INSERT INTO `bbs_area` VALUES ('71', '丰南区', '66', '1');
INSERT INTO `bbs_area` VALUES ('72', '丰润区', '66', '1');
INSERT INTO `bbs_area` VALUES ('73', '滦县', '66', '1');
INSERT INTO `bbs_area` VALUES ('74', '滦南县', '66', '1');
INSERT INTO `bbs_area` VALUES ('75', '乐亭县', '66', '1');
INSERT INTO `bbs_area` VALUES ('76', '迁西县', '66', '1');
INSERT INTO `bbs_area` VALUES ('77', '玉田县', '66', '1');
INSERT INTO `bbs_area` VALUES ('78', '唐海县', '66', '1');
INSERT INTO `bbs_area` VALUES ('79', '遵化市', '66', '1');
INSERT INTO `bbs_area` VALUES ('80', '迁安市', '66', '1');
INSERT INTO `bbs_area` VALUES ('81', '秦皇岛市', '41', '1');
INSERT INTO `bbs_area` VALUES ('82', '海港区', '81', '1');
INSERT INTO `bbs_area` VALUES ('83', '山海关区', '81', '1');
INSERT INTO `bbs_area` VALUES ('84', '北戴河区', '81', '1');
INSERT INTO `bbs_area` VALUES ('85', '青龙满族自治县', '81', '1');
INSERT INTO `bbs_area` VALUES ('86', '昌黎县', '81', '1');
INSERT INTO `bbs_area` VALUES ('87', '抚宁县', '81', '1');
INSERT INTO `bbs_area` VALUES ('88', '卢龙县', '81', '1');
INSERT INTO `bbs_area` VALUES ('89', '邯郸市', '41', '1');
INSERT INTO `bbs_area` VALUES ('90', '邯山区', '89', '1');
INSERT INTO `bbs_area` VALUES ('91', '丛台区', '89', '1');
INSERT INTO `bbs_area` VALUES ('92', '复兴区', '89', '1');
INSERT INTO `bbs_area` VALUES ('93', '峰峰矿区', '89', '1');
INSERT INTO `bbs_area` VALUES ('94', '邯郸县', '89', '1');
INSERT INTO `bbs_area` VALUES ('95', '临漳县', '89', '1');
INSERT INTO `bbs_area` VALUES ('96', '成安县', '89', '1');
INSERT INTO `bbs_area` VALUES ('97', '大名县', '89', '1');
INSERT INTO `bbs_area` VALUES ('98', '涉县', '89', '1');
INSERT INTO `bbs_area` VALUES ('99', '磁县', '89', '1');
INSERT INTO `bbs_area` VALUES ('100', '肥乡县', '89', '1');
INSERT INTO `bbs_area` VALUES ('101', '永年县', '89', '1');
INSERT INTO `bbs_area` VALUES ('102', '邱县', '89', '1');
INSERT INTO `bbs_area` VALUES ('103', '鸡泽县', '89', '1');
INSERT INTO `bbs_area` VALUES ('104', '广平县', '89', '1');
INSERT INTO `bbs_area` VALUES ('105', '馆陶县', '89', '1');
INSERT INTO `bbs_area` VALUES ('106', '魏县', '89', '1');
INSERT INTO `bbs_area` VALUES ('107', '曲周县', '89', '1');
INSERT INTO `bbs_area` VALUES ('108', '武安市', '89', '1');
INSERT INTO `bbs_area` VALUES ('109', '邢台市', '41', '1');
INSERT INTO `bbs_area` VALUES ('110', '桥东区', '109', '1');
INSERT INTO `bbs_area` VALUES ('111', '桥西区', '109', '1');
INSERT INTO `bbs_area` VALUES ('112', '邢台县', '109', '1');
INSERT INTO `bbs_area` VALUES ('113', '临城县', '109', '1');
INSERT INTO `bbs_area` VALUES ('114', '内丘县', '109', '1');
INSERT INTO `bbs_area` VALUES ('115', '柏乡县', '109', '1');
INSERT INTO `bbs_area` VALUES ('116', '隆尧县', '109', '1');
INSERT INTO `bbs_area` VALUES ('117', '任县', '109', '1');
INSERT INTO `bbs_area` VALUES ('118', '南和县', '109', '1');
INSERT INTO `bbs_area` VALUES ('119', '宁晋县', '109', '1');
INSERT INTO `bbs_area` VALUES ('120', '巨鹿县', '109', '1');
INSERT INTO `bbs_area` VALUES ('121', '新河县', '109', '1');
INSERT INTO `bbs_area` VALUES ('122', '广宗县', '109', '1');
INSERT INTO `bbs_area` VALUES ('123', '平乡县', '109', '1');
INSERT INTO `bbs_area` VALUES ('124', '威县', '109', '1');
INSERT INTO `bbs_area` VALUES ('125', '清河县', '109', '1');
INSERT INTO `bbs_area` VALUES ('126', '临西县', '109', '1');
INSERT INTO `bbs_area` VALUES ('127', '南宫市', '109', '1');
INSERT INTO `bbs_area` VALUES ('128', '沙河市', '109', '1');
INSERT INTO `bbs_area` VALUES ('129', '保定市', '41', '1');
INSERT INTO `bbs_area` VALUES ('130', '新市区', '129', '1');
INSERT INTO `bbs_area` VALUES ('131', '北市区', '129', '1');
INSERT INTO `bbs_area` VALUES ('132', '南市区', '129', '1');
INSERT INTO `bbs_area` VALUES ('133', '满城县', '129', '1');
INSERT INTO `bbs_area` VALUES ('134', '清苑县', '129', '1');
INSERT INTO `bbs_area` VALUES ('135', '涞水县', '129', '1');
INSERT INTO `bbs_area` VALUES ('136', '阜平县', '129', '1');
INSERT INTO `bbs_area` VALUES ('137', '徐水县', '129', '1');
INSERT INTO `bbs_area` VALUES ('138', '定兴县', '129', '1');
INSERT INTO `bbs_area` VALUES ('139', '唐县', '129', '1');
INSERT INTO `bbs_area` VALUES ('140', '高阳县', '129', '1');
INSERT INTO `bbs_area` VALUES ('141', '容城县', '129', '1');
INSERT INTO `bbs_area` VALUES ('142', '涞源县', '129', '1');
INSERT INTO `bbs_area` VALUES ('143', '望都县', '129', '1');
INSERT INTO `bbs_area` VALUES ('144', '安新县', '129', '1');
INSERT INTO `bbs_area` VALUES ('145', '易县', '129', '1');
INSERT INTO `bbs_area` VALUES ('146', '曲阳县', '129', '1');
INSERT INTO `bbs_area` VALUES ('147', '蠡县', '129', '1');
INSERT INTO `bbs_area` VALUES ('148', '顺平县', '129', '1');
INSERT INTO `bbs_area` VALUES ('149', '博野县', '129', '1');
INSERT INTO `bbs_area` VALUES ('150', '雄县', '129', '1');
INSERT INTO `bbs_area` VALUES ('151', '涿州市', '129', '1');
INSERT INTO `bbs_area` VALUES ('152', '定州市', '129', '1');
INSERT INTO `bbs_area` VALUES ('153', '安国市', '129', '1');
INSERT INTO `bbs_area` VALUES ('154', '高碑店市', '129', '1');
INSERT INTO `bbs_area` VALUES ('155', '张家口市', '41', '1');
INSERT INTO `bbs_area` VALUES ('156', '桥东区', '155', '1');
INSERT INTO `bbs_area` VALUES ('157', '桥西区', '155', '1');
INSERT INTO `bbs_area` VALUES ('158', '宣化区', '155', '1');
INSERT INTO `bbs_area` VALUES ('159', '下花园区', '155', '1');
INSERT INTO `bbs_area` VALUES ('160', '宣化县', '155', '1');
INSERT INTO `bbs_area` VALUES ('161', '张北县', '155', '1');
INSERT INTO `bbs_area` VALUES ('162', '康保县', '155', '1');
INSERT INTO `bbs_area` VALUES ('163', '沽源县', '155', '1');
INSERT INTO `bbs_area` VALUES ('164', '尚义县', '155', '1');
INSERT INTO `bbs_area` VALUES ('165', '蔚县', '155', '1');
INSERT INTO `bbs_area` VALUES ('166', '阳原县', '155', '1');
INSERT INTO `bbs_area` VALUES ('167', '怀安县', '155', '1');
INSERT INTO `bbs_area` VALUES ('168', '万全县', '155', '1');
INSERT INTO `bbs_area` VALUES ('169', '怀来县', '155', '1');
INSERT INTO `bbs_area` VALUES ('170', '涿鹿县', '155', '1');
INSERT INTO `bbs_area` VALUES ('171', '赤城县', '155', '1');
INSERT INTO `bbs_area` VALUES ('172', '崇礼县', '155', '1');
INSERT INTO `bbs_area` VALUES ('173', '承德市', '41', '1');
INSERT INTO `bbs_area` VALUES ('174', '双桥区', '173', '1');
INSERT INTO `bbs_area` VALUES ('175', '双滦区', '173', '1');
INSERT INTO `bbs_area` VALUES ('176', '鹰手营子矿区', '173', '1');
INSERT INTO `bbs_area` VALUES ('177', '承德县', '173', '1');
INSERT INTO `bbs_area` VALUES ('178', '兴隆县', '173', '1');
INSERT INTO `bbs_area` VALUES ('179', '平泉县', '173', '1');
INSERT INTO `bbs_area` VALUES ('180', '滦平县', '173', '1');
INSERT INTO `bbs_area` VALUES ('181', '隆化县', '173', '1');
INSERT INTO `bbs_area` VALUES ('182', '丰宁满族自治县', '173', '1');
INSERT INTO `bbs_area` VALUES ('183', '宽城满族自治县', '173', '1');
INSERT INTO `bbs_area` VALUES ('184', '围场满族蒙古族自治县', '173', '1');
INSERT INTO `bbs_area` VALUES ('185', '沧州市', '41', '1');
INSERT INTO `bbs_area` VALUES ('186', '新华区', '185', '1');
INSERT INTO `bbs_area` VALUES ('187', '运河区', '185', '1');
INSERT INTO `bbs_area` VALUES ('188', '沧县', '185', '1');
INSERT INTO `bbs_area` VALUES ('189', '青县', '185', '1');
INSERT INTO `bbs_area` VALUES ('190', '东光县', '185', '1');
INSERT INTO `bbs_area` VALUES ('191', '海兴县', '185', '1');
INSERT INTO `bbs_area` VALUES ('192', '盐山县', '185', '1');
INSERT INTO `bbs_area` VALUES ('193', '肃宁县', '185', '1');
INSERT INTO `bbs_area` VALUES ('194', '南皮县', '185', '1');
INSERT INTO `bbs_area` VALUES ('195', '吴桥县', '185', '1');
INSERT INTO `bbs_area` VALUES ('196', '献县', '185', '1');
INSERT INTO `bbs_area` VALUES ('197', '孟村回族自治县', '185', '1');
INSERT INTO `bbs_area` VALUES ('198', '泊头市', '185', '1');
INSERT INTO `bbs_area` VALUES ('199', '任丘市', '185', '1');
INSERT INTO `bbs_area` VALUES ('200', '黄骅市', '185', '1');
INSERT INTO `bbs_area` VALUES ('201', '河间市', '185', '1');
INSERT INTO `bbs_area` VALUES ('202', '廊坊市', '41', '1');
INSERT INTO `bbs_area` VALUES ('203', '安次区', '202', '1');
INSERT INTO `bbs_area` VALUES ('204', '广阳区', '202', '1');
INSERT INTO `bbs_area` VALUES ('205', '固安县', '202', '1');
INSERT INTO `bbs_area` VALUES ('206', '永清县', '202', '1');
INSERT INTO `bbs_area` VALUES ('207', '香河县', '202', '1');
INSERT INTO `bbs_area` VALUES ('208', '大城县', '202', '1');
INSERT INTO `bbs_area` VALUES ('209', '文安县', '202', '1');
INSERT INTO `bbs_area` VALUES ('210', '大厂回族自治县', '202', '1');
INSERT INTO `bbs_area` VALUES ('211', '霸州市', '202', '1');
INSERT INTO `bbs_area` VALUES ('212', '三河市', '202', '1');
INSERT INTO `bbs_area` VALUES ('213', '衡水市', '41', '1');
INSERT INTO `bbs_area` VALUES ('214', '桃城区', '213', '1');
INSERT INTO `bbs_area` VALUES ('215', '枣强县', '213', '1');
INSERT INTO `bbs_area` VALUES ('216', '武邑县', '213', '1');
INSERT INTO `bbs_area` VALUES ('217', '武强县', '213', '1');
INSERT INTO `bbs_area` VALUES ('218', '饶阳县', '213', '1');
INSERT INTO `bbs_area` VALUES ('219', '安平县', '213', '1');
INSERT INTO `bbs_area` VALUES ('220', '故城县', '213', '1');
INSERT INTO `bbs_area` VALUES ('221', '景县', '213', '1');
INSERT INTO `bbs_area` VALUES ('222', '阜城县', '213', '1');
INSERT INTO `bbs_area` VALUES ('223', '冀州市', '213', '1');
INSERT INTO `bbs_area` VALUES ('224', '深州市', '213', '1');
INSERT INTO `bbs_area` VALUES ('225', '山西', '0', '1');
INSERT INTO `bbs_area` VALUES ('226', '太原市', '225', '1');
INSERT INTO `bbs_area` VALUES ('227', '小店区', '226', '1');
INSERT INTO `bbs_area` VALUES ('228', '迎泽区', '226', '1');
INSERT INTO `bbs_area` VALUES ('229', '杏花岭区', '226', '1');
INSERT INTO `bbs_area` VALUES ('230', '尖草坪区', '226', '1');
INSERT INTO `bbs_area` VALUES ('231', '万柏林区', '226', '1');
INSERT INTO `bbs_area` VALUES ('232', '晋源区', '226', '1');
INSERT INTO `bbs_area` VALUES ('233', '清徐县', '226', '1');
INSERT INTO `bbs_area` VALUES ('234', '阳曲县', '226', '1');
INSERT INTO `bbs_area` VALUES ('235', '娄烦县', '226', '1');
INSERT INTO `bbs_area` VALUES ('236', '古交市', '226', '1');
INSERT INTO `bbs_area` VALUES ('237', '大同市', '225', '1');
INSERT INTO `bbs_area` VALUES ('238', '城区', '237', '1');
INSERT INTO `bbs_area` VALUES ('239', '矿区', '237', '1');
INSERT INTO `bbs_area` VALUES ('240', '南郊区', '237', '1');
INSERT INTO `bbs_area` VALUES ('241', '新荣区', '237', '1');
INSERT INTO `bbs_area` VALUES ('242', '阳高县', '237', '1');
INSERT INTO `bbs_area` VALUES ('243', '天镇县', '237', '1');
INSERT INTO `bbs_area` VALUES ('244', '广灵县', '237', '1');
INSERT INTO `bbs_area` VALUES ('245', '灵丘县', '237', '1');
INSERT INTO `bbs_area` VALUES ('246', '浑源县', '237', '1');
INSERT INTO `bbs_area` VALUES ('247', '左云县', '237', '1');
INSERT INTO `bbs_area` VALUES ('248', '大同县', '237', '1');
INSERT INTO `bbs_area` VALUES ('249', '阳泉市', '225', '1');
INSERT INTO `bbs_area` VALUES ('250', '城区', '249', '1');
INSERT INTO `bbs_area` VALUES ('251', '矿区', '249', '1');
INSERT INTO `bbs_area` VALUES ('252', '郊区', '249', '1');
INSERT INTO `bbs_area` VALUES ('253', '平定县', '249', '1');
INSERT INTO `bbs_area` VALUES ('254', '盂县', '249', '1');
INSERT INTO `bbs_area` VALUES ('255', '长治市', '225', '1');
INSERT INTO `bbs_area` VALUES ('256', '城区', '255', '1');
INSERT INTO `bbs_area` VALUES ('257', '郊区', '255', '1');
INSERT INTO `bbs_area` VALUES ('258', '长治县', '255', '1');
INSERT INTO `bbs_area` VALUES ('259', '襄垣县', '255', '1');
INSERT INTO `bbs_area` VALUES ('260', '屯留县', '255', '1');
INSERT INTO `bbs_area` VALUES ('261', '平顺县', '255', '1');
INSERT INTO `bbs_area` VALUES ('262', '黎城县', '255', '1');
INSERT INTO `bbs_area` VALUES ('263', '壶关县', '255', '1');
INSERT INTO `bbs_area` VALUES ('264', '长子县', '255', '1');
INSERT INTO `bbs_area` VALUES ('265', '武乡县', '255', '1');
INSERT INTO `bbs_area` VALUES ('266', '沁县', '255', '1');
INSERT INTO `bbs_area` VALUES ('267', '沁源县', '255', '1');
INSERT INTO `bbs_area` VALUES ('268', '潞城市', '255', '1');
INSERT INTO `bbs_area` VALUES ('269', '晋城市', '225', '1');
INSERT INTO `bbs_area` VALUES ('270', '城区', '269', '1');
INSERT INTO `bbs_area` VALUES ('271', '沁水县', '269', '1');
INSERT INTO `bbs_area` VALUES ('272', '阳城县', '269', '1');
INSERT INTO `bbs_area` VALUES ('273', '陵川县', '269', '1');
INSERT INTO `bbs_area` VALUES ('274', '泽州县', '269', '1');
INSERT INTO `bbs_area` VALUES ('275', '高平市', '269', '1');
INSERT INTO `bbs_area` VALUES ('276', '朔州市', '225', '1');
INSERT INTO `bbs_area` VALUES ('277', '朔城区', '276', '1');
INSERT INTO `bbs_area` VALUES ('278', '平鲁区', '276', '1');
INSERT INTO `bbs_area` VALUES ('279', '山阴县', '276', '1');
INSERT INTO `bbs_area` VALUES ('280', '应县', '276', '1');
INSERT INTO `bbs_area` VALUES ('281', '右玉县', '276', '1');
INSERT INTO `bbs_area` VALUES ('282', '怀仁县', '276', '1');
INSERT INTO `bbs_area` VALUES ('283', '晋中市', '225', '1');
INSERT INTO `bbs_area` VALUES ('284', '榆次区', '283', '1');
INSERT INTO `bbs_area` VALUES ('285', '榆社县', '283', '1');
INSERT INTO `bbs_area` VALUES ('286', '左权县', '283', '1');
INSERT INTO `bbs_area` VALUES ('287', '和顺县', '283', '1');
INSERT INTO `bbs_area` VALUES ('288', '昔阳县', '283', '1');
INSERT INTO `bbs_area` VALUES ('289', '寿阳县', '283', '1');
INSERT INTO `bbs_area` VALUES ('290', '太谷县', '283', '1');
INSERT INTO `bbs_area` VALUES ('291', '祁县', '283', '1');
INSERT INTO `bbs_area` VALUES ('292', '平遥县', '283', '1');
INSERT INTO `bbs_area` VALUES ('293', '灵石县', '283', '1');
INSERT INTO `bbs_area` VALUES ('294', '介休市', '283', '1');
INSERT INTO `bbs_area` VALUES ('295', '运城市', '225', '1');
INSERT INTO `bbs_area` VALUES ('296', '盐湖区', '295', '1');
INSERT INTO `bbs_area` VALUES ('297', '临猗县', '295', '1');
INSERT INTO `bbs_area` VALUES ('298', '万荣县', '295', '1');
INSERT INTO `bbs_area` VALUES ('299', '闻喜县', '295', '1');
INSERT INTO `bbs_area` VALUES ('300', '稷山县', '295', '1');
INSERT INTO `bbs_area` VALUES ('301', '新绛县', '295', '1');
INSERT INTO `bbs_area` VALUES ('302', '绛县', '295', '1');
INSERT INTO `bbs_area` VALUES ('303', '垣曲县', '295', '1');
INSERT INTO `bbs_area` VALUES ('304', '夏县', '295', '1');
INSERT INTO `bbs_area` VALUES ('305', '平陆县', '295', '1');
INSERT INTO `bbs_area` VALUES ('306', '芮城县', '295', '1');
INSERT INTO `bbs_area` VALUES ('307', '永济市', '295', '1');
INSERT INTO `bbs_area` VALUES ('308', '河津市', '295', '1');
INSERT INTO `bbs_area` VALUES ('309', '忻州市', '225', '1');
INSERT INTO `bbs_area` VALUES ('310', '忻府区', '309', '1');
INSERT INTO `bbs_area` VALUES ('311', '定襄县', '309', '1');
INSERT INTO `bbs_area` VALUES ('312', '五台县', '309', '1');
INSERT INTO `bbs_area` VALUES ('313', '代县', '309', '1');
INSERT INTO `bbs_area` VALUES ('314', '繁峙县', '309', '1');
INSERT INTO `bbs_area` VALUES ('315', '宁武县', '309', '1');
INSERT INTO `bbs_area` VALUES ('316', '静乐县', '309', '1');
INSERT INTO `bbs_area` VALUES ('317', '神池县', '309', '1');
INSERT INTO `bbs_area` VALUES ('318', '五寨县', '309', '1');
INSERT INTO `bbs_area` VALUES ('319', '岢岚县', '309', '1');
INSERT INTO `bbs_area` VALUES ('320', '河曲县', '309', '1');
INSERT INTO `bbs_area` VALUES ('321', '保德县', '309', '1');
INSERT INTO `bbs_area` VALUES ('322', '偏关县', '309', '1');
INSERT INTO `bbs_area` VALUES ('323', '原平市', '309', '1');
INSERT INTO `bbs_area` VALUES ('324', '临汾市', '225', '1');
INSERT INTO `bbs_area` VALUES ('325', '尧都区', '324', '1');
INSERT INTO `bbs_area` VALUES ('326', '曲沃县', '324', '1');
INSERT INTO `bbs_area` VALUES ('327', '翼城县', '324', '1');
INSERT INTO `bbs_area` VALUES ('328', '襄汾县', '324', '1');
INSERT INTO `bbs_area` VALUES ('329', '洪洞县', '324', '1');
INSERT INTO `bbs_area` VALUES ('330', '古县', '324', '1');
INSERT INTO `bbs_area` VALUES ('331', '安泽县', '324', '1');
INSERT INTO `bbs_area` VALUES ('332', '浮山县', '324', '1');
INSERT INTO `bbs_area` VALUES ('333', '吉县', '324', '1');
INSERT INTO `bbs_area` VALUES ('334', '乡宁县', '324', '1');
INSERT INTO `bbs_area` VALUES ('335', '大宁县', '324', '1');
INSERT INTO `bbs_area` VALUES ('336', '隰县', '324', '1');
INSERT INTO `bbs_area` VALUES ('337', '永和县', '324', '1');
INSERT INTO `bbs_area` VALUES ('338', '蒲县', '324', '1');
INSERT INTO `bbs_area` VALUES ('339', '汾西县', '324', '1');
INSERT INTO `bbs_area` VALUES ('340', '侯马市', '324', '1');
INSERT INTO `bbs_area` VALUES ('341', '霍州市', '324', '1');
INSERT INTO `bbs_area` VALUES ('342', '吕梁市', '225', '1');
INSERT INTO `bbs_area` VALUES ('343', '离石区', '342', '1');
INSERT INTO `bbs_area` VALUES ('344', '文水县', '342', '1');
INSERT INTO `bbs_area` VALUES ('345', '交城县', '342', '1');
INSERT INTO `bbs_area` VALUES ('346', '兴县', '342', '1');
INSERT INTO `bbs_area` VALUES ('347', '临县', '342', '1');
INSERT INTO `bbs_area` VALUES ('348', '柳林县', '342', '1');
INSERT INTO `bbs_area` VALUES ('349', '石楼县', '342', '1');
INSERT INTO `bbs_area` VALUES ('350', '岚县', '342', '1');
INSERT INTO `bbs_area` VALUES ('351', '方山县', '342', '1');
INSERT INTO `bbs_area` VALUES ('352', '中阳县', '342', '1');
INSERT INTO `bbs_area` VALUES ('353', '交口县', '342', '1');
INSERT INTO `bbs_area` VALUES ('354', '孝义市', '342', '1');
INSERT INTO `bbs_area` VALUES ('355', '汾阳市', '342', '1');
INSERT INTO `bbs_area` VALUES ('356', '内蒙古', '0', '1');
INSERT INTO `bbs_area` VALUES ('357', '呼和浩特市', '356', '1');
INSERT INTO `bbs_area` VALUES ('358', '新城区', '357', '1');
INSERT INTO `bbs_area` VALUES ('359', '回民区', '357', '1');
INSERT INTO `bbs_area` VALUES ('360', '玉泉区', '357', '1');
INSERT INTO `bbs_area` VALUES ('361', '赛罕区', '357', '1');
INSERT INTO `bbs_area` VALUES ('362', '土默特左旗', '357', '1');
INSERT INTO `bbs_area` VALUES ('363', '托克托县', '357', '1');
INSERT INTO `bbs_area` VALUES ('364', '和林格尔县', '357', '1');
INSERT INTO `bbs_area` VALUES ('365', '清水河县', '357', '1');
INSERT INTO `bbs_area` VALUES ('366', '武川县', '357', '1');
INSERT INTO `bbs_area` VALUES ('367', '包头市', '356', '1');
INSERT INTO `bbs_area` VALUES ('368', '东河区', '367', '1');
INSERT INTO `bbs_area` VALUES ('369', '昆都仑区', '367', '1');
INSERT INTO `bbs_area` VALUES ('370', '青山区', '367', '1');
INSERT INTO `bbs_area` VALUES ('371', '石拐区', '367', '1');
INSERT INTO `bbs_area` VALUES ('372', '白云矿区', '367', '1');
INSERT INTO `bbs_area` VALUES ('373', '九原区', '367', '1');
INSERT INTO `bbs_area` VALUES ('374', '土默特右旗', '367', '1');
INSERT INTO `bbs_area` VALUES ('375', '固阳县', '367', '1');
INSERT INTO `bbs_area` VALUES ('376', '达尔罕茂明安联合旗', '367', '1');
INSERT INTO `bbs_area` VALUES ('377', '乌海市', '356', '1');
INSERT INTO `bbs_area` VALUES ('378', '海勃湾区', '377', '1');
INSERT INTO `bbs_area` VALUES ('379', '海南区', '377', '1');
INSERT INTO `bbs_area` VALUES ('380', '乌达区', '377', '1');
INSERT INTO `bbs_area` VALUES ('381', '赤峰市', '356', '1');
INSERT INTO `bbs_area` VALUES ('382', '红山区', '381', '1');
INSERT INTO `bbs_area` VALUES ('383', '元宝山区', '381', '1');
INSERT INTO `bbs_area` VALUES ('384', '松山区', '381', '1');
INSERT INTO `bbs_area` VALUES ('385', '阿鲁科尔沁旗', '381', '1');
INSERT INTO `bbs_area` VALUES ('386', '巴林左旗', '381', '1');
INSERT INTO `bbs_area` VALUES ('387', '巴林右旗', '381', '1');
INSERT INTO `bbs_area` VALUES ('388', '林西县', '381', '1');
INSERT INTO `bbs_area` VALUES ('389', '克什克腾旗', '381', '1');
INSERT INTO `bbs_area` VALUES ('390', '翁牛特旗', '381', '1');
INSERT INTO `bbs_area` VALUES ('391', '喀喇沁旗', '381', '1');
INSERT INTO `bbs_area` VALUES ('392', '宁城县', '381', '1');
INSERT INTO `bbs_area` VALUES ('393', '敖汉旗', '381', '1');
INSERT INTO `bbs_area` VALUES ('394', '通辽市', '356', '1');
INSERT INTO `bbs_area` VALUES ('395', '科尔沁区', '394', '1');
INSERT INTO `bbs_area` VALUES ('396', '科尔沁左翼中旗', '394', '1');
INSERT INTO `bbs_area` VALUES ('397', '科尔沁左翼后旗', '394', '1');
INSERT INTO `bbs_area` VALUES ('398', '开鲁县', '394', '1');
INSERT INTO `bbs_area` VALUES ('399', '库伦旗', '394', '1');
INSERT INTO `bbs_area` VALUES ('400', '奈曼旗', '394', '1');
INSERT INTO `bbs_area` VALUES ('401', '扎鲁特旗', '394', '1');
INSERT INTO `bbs_area` VALUES ('402', '霍林郭勒市', '394', '1');
INSERT INTO `bbs_area` VALUES ('403', '鄂尔多斯市', '356', '1');
INSERT INTO `bbs_area` VALUES ('404', '市辖区', '403', '1');
INSERT INTO `bbs_area` VALUES ('405', '东胜区', '403', '1');
INSERT INTO `bbs_area` VALUES ('406', '达拉特旗', '403', '1');
INSERT INTO `bbs_area` VALUES ('407', '准格尔旗', '403', '1');
INSERT INTO `bbs_area` VALUES ('408', '鄂托克前旗', '403', '1');
INSERT INTO `bbs_area` VALUES ('409', '鄂托克旗', '403', '1');
INSERT INTO `bbs_area` VALUES ('410', '杭锦旗', '403', '1');
INSERT INTO `bbs_area` VALUES ('411', '乌审旗', '403', '1');
INSERT INTO `bbs_area` VALUES ('412', '伊金霍洛旗', '403', '1');
INSERT INTO `bbs_area` VALUES ('413', '呼伦贝尔市', '356', '1');
INSERT INTO `bbs_area` VALUES ('414', '海拉尔区', '413', '1');
INSERT INTO `bbs_area` VALUES ('415', '阿荣旗', '413', '1');
INSERT INTO `bbs_area` VALUES ('416', '莫力达瓦达斡尔族自治旗', '413', '1');
INSERT INTO `bbs_area` VALUES ('417', '鄂伦春自治旗', '413', '1');
INSERT INTO `bbs_area` VALUES ('418', '鄂温克族自治旗', '413', '1');
INSERT INTO `bbs_area` VALUES ('419', '陈巴尔虎旗', '413', '1');
INSERT INTO `bbs_area` VALUES ('420', '新巴尔虎左旗', '413', '1');
INSERT INTO `bbs_area` VALUES ('421', '新巴尔虎右旗', '413', '1');
INSERT INTO `bbs_area` VALUES ('422', '满洲里市', '413', '1');
INSERT INTO `bbs_area` VALUES ('423', '牙克石市', '413', '1');
INSERT INTO `bbs_area` VALUES ('424', '扎兰屯市', '413', '1');
INSERT INTO `bbs_area` VALUES ('425', '额尔古纳市', '413', '1');
INSERT INTO `bbs_area` VALUES ('426', '根河市', '413', '1');
INSERT INTO `bbs_area` VALUES ('427', '巴彦淖尔市', '356', '1');
INSERT INTO `bbs_area` VALUES ('428', '临河区', '427', '1');
INSERT INTO `bbs_area` VALUES ('429', '五原县', '427', '1');
INSERT INTO `bbs_area` VALUES ('430', '磴口县', '427', '1');
INSERT INTO `bbs_area` VALUES ('431', '乌拉特前旗', '427', '1');
INSERT INTO `bbs_area` VALUES ('432', '乌拉特中旗', '427', '1');
INSERT INTO `bbs_area` VALUES ('433', '乌拉特后旗', '427', '1');
INSERT INTO `bbs_area` VALUES ('434', '杭锦后旗', '427', '1');
INSERT INTO `bbs_area` VALUES ('435', '乌兰察布市', '356', '1');
INSERT INTO `bbs_area` VALUES ('436', '集宁区', '435', '1');
INSERT INTO `bbs_area` VALUES ('437', '卓资县', '435', '1');
INSERT INTO `bbs_area` VALUES ('438', '化德县', '435', '1');
INSERT INTO `bbs_area` VALUES ('439', '商都县', '435', '1');
INSERT INTO `bbs_area` VALUES ('440', '兴和县', '435', '1');
INSERT INTO `bbs_area` VALUES ('441', '凉城县', '435', '1');
INSERT INTO `bbs_area` VALUES ('442', '察哈尔右翼前旗', '435', '1');
INSERT INTO `bbs_area` VALUES ('443', '察哈尔右翼中旗', '435', '1');
INSERT INTO `bbs_area` VALUES ('444', '察哈尔右翼后旗', '435', '1');
INSERT INTO `bbs_area` VALUES ('445', '四子王旗', '435', '1');
INSERT INTO `bbs_area` VALUES ('446', '丰镇市', '435', '1');
INSERT INTO `bbs_area` VALUES ('447', '兴安盟', '356', '1');
INSERT INTO `bbs_area` VALUES ('448', '乌兰浩特市', '447', '1');
INSERT INTO `bbs_area` VALUES ('449', '阿尔山市', '447', '1');
INSERT INTO `bbs_area` VALUES ('450', '科尔沁右翼前旗', '447', '1');
INSERT INTO `bbs_area` VALUES ('451', '科尔沁右翼中旗', '447', '1');
INSERT INTO `bbs_area` VALUES ('452', '扎赉特旗', '447', '1');
INSERT INTO `bbs_area` VALUES ('453', '突泉县', '447', '1');
INSERT INTO `bbs_area` VALUES ('454', '锡林郭勒盟', '356', '1');
INSERT INTO `bbs_area` VALUES ('455', '二连浩特市', '454', '1');
INSERT INTO `bbs_area` VALUES ('456', '锡林浩特市', '454', '1');
INSERT INTO `bbs_area` VALUES ('457', '阿巴嘎旗', '454', '1');
INSERT INTO `bbs_area` VALUES ('458', '苏尼特左旗', '454', '1');
INSERT INTO `bbs_area` VALUES ('459', '苏尼特右旗', '454', '1');
INSERT INTO `bbs_area` VALUES ('460', '东乌珠穆沁旗', '454', '1');
INSERT INTO `bbs_area` VALUES ('461', '西乌珠穆沁旗', '454', '1');
INSERT INTO `bbs_area` VALUES ('462', '太仆寺旗', '454', '1');
INSERT INTO `bbs_area` VALUES ('463', '镶黄旗', '454', '1');
INSERT INTO `bbs_area` VALUES ('464', '正镶白旗', '454', '1');
INSERT INTO `bbs_area` VALUES ('465', '正蓝旗', '454', '1');
INSERT INTO `bbs_area` VALUES ('466', '多伦县', '454', '1');
INSERT INTO `bbs_area` VALUES ('467', '阿拉善盟', '356', '1');
INSERT INTO `bbs_area` VALUES ('468', '阿拉善左旗', '467', '1');
INSERT INTO `bbs_area` VALUES ('469', '阿拉善右旗', '467', '1');
INSERT INTO `bbs_area` VALUES ('470', '额济纳旗', '467', '1');
INSERT INTO `bbs_area` VALUES ('471', '辽宁', '0', '1');
INSERT INTO `bbs_area` VALUES ('472', '沈阳市', '471', '1');
INSERT INTO `bbs_area` VALUES ('473', '和平区', '472', '1');
INSERT INTO `bbs_area` VALUES ('474', '沈河区', '472', '1');
INSERT INTO `bbs_area` VALUES ('475', '大东区', '472', '1');
INSERT INTO `bbs_area` VALUES ('476', '皇姑区', '472', '1');
INSERT INTO `bbs_area` VALUES ('477', '铁西区', '472', '1');
INSERT INTO `bbs_area` VALUES ('478', '苏家屯区', '472', '1');
INSERT INTO `bbs_area` VALUES ('479', '东陵区', '472', '1');
INSERT INTO `bbs_area` VALUES ('480', '沈北新区', '472', '1');
INSERT INTO `bbs_area` VALUES ('481', '于洪区', '472', '1');
INSERT INTO `bbs_area` VALUES ('482', '辽中县', '472', '1');
INSERT INTO `bbs_area` VALUES ('483', '康平县', '472', '1');
INSERT INTO `bbs_area` VALUES ('484', '法库县', '472', '1');
INSERT INTO `bbs_area` VALUES ('485', '新民市', '472', '1');
INSERT INTO `bbs_area` VALUES ('486', '大连市', '471', '1');
INSERT INTO `bbs_area` VALUES ('487', '中山区', '486', '1');
INSERT INTO `bbs_area` VALUES ('488', '西岗区', '486', '1');
INSERT INTO `bbs_area` VALUES ('489', '沙河口区', '486', '1');
INSERT INTO `bbs_area` VALUES ('490', '甘井子区', '486', '1');
INSERT INTO `bbs_area` VALUES ('491', '旅顺口区', '486', '1');
INSERT INTO `bbs_area` VALUES ('492', '金州区', '486', '1');
INSERT INTO `bbs_area` VALUES ('493', '长海县', '486', '1');
INSERT INTO `bbs_area` VALUES ('494', '瓦房店市', '486', '1');
INSERT INTO `bbs_area` VALUES ('495', '普兰店市', '486', '1');
INSERT INTO `bbs_area` VALUES ('496', '庄河市', '486', '1');
INSERT INTO `bbs_area` VALUES ('497', '鞍山市', '471', '1');
INSERT INTO `bbs_area` VALUES ('498', '铁东区', '497', '1');
INSERT INTO `bbs_area` VALUES ('499', '铁西区', '497', '1');
INSERT INTO `bbs_area` VALUES ('500', '立山区', '497', '1');
INSERT INTO `bbs_area` VALUES ('501', '千山区', '497', '1');
INSERT INTO `bbs_area` VALUES ('502', '台安县', '497', '1');
INSERT INTO `bbs_area` VALUES ('503', '岫岩满族自治县', '497', '1');
INSERT INTO `bbs_area` VALUES ('504', '海城市', '497', '1');
INSERT INTO `bbs_area` VALUES ('505', '抚顺市', '471', '1');
INSERT INTO `bbs_area` VALUES ('506', '新抚区', '505', '1');
INSERT INTO `bbs_area` VALUES ('507', '东洲区', '505', '1');
INSERT INTO `bbs_area` VALUES ('508', '望花区', '505', '1');
INSERT INTO `bbs_area` VALUES ('509', '顺城区', '505', '1');
INSERT INTO `bbs_area` VALUES ('510', '抚顺县', '505', '1');
INSERT INTO `bbs_area` VALUES ('511', '新宾满族自治县', '505', '1');
INSERT INTO `bbs_area` VALUES ('512', '清原满族自治县', '505', '1');
INSERT INTO `bbs_area` VALUES ('513', '本溪市', '471', '1');
INSERT INTO `bbs_area` VALUES ('514', '平山区', '513', '1');
INSERT INTO `bbs_area` VALUES ('515', '溪湖区', '513', '1');
INSERT INTO `bbs_area` VALUES ('516', '明山区', '513', '1');
INSERT INTO `bbs_area` VALUES ('517', '南芬区', '513', '1');
INSERT INTO `bbs_area` VALUES ('518', '本溪满族自治县', '513', '1');
INSERT INTO `bbs_area` VALUES ('519', '桓仁满族自治县', '513', '1');
INSERT INTO `bbs_area` VALUES ('520', '丹东市', '471', '1');
INSERT INTO `bbs_area` VALUES ('521', '元宝区', '520', '1');
INSERT INTO `bbs_area` VALUES ('522', '振兴区', '520', '1');
INSERT INTO `bbs_area` VALUES ('523', '振安区', '520', '1');
INSERT INTO `bbs_area` VALUES ('524', '宽甸满族自治县', '520', '1');
INSERT INTO `bbs_area` VALUES ('525', '东港市', '520', '1');
INSERT INTO `bbs_area` VALUES ('526', '凤城市', '520', '1');
INSERT INTO `bbs_area` VALUES ('527', '锦州市', '471', '1');
INSERT INTO `bbs_area` VALUES ('528', '古塔区', '527', '1');
INSERT INTO `bbs_area` VALUES ('529', '凌河区', '527', '1');
INSERT INTO `bbs_area` VALUES ('530', '太和区', '527', '1');
INSERT INTO `bbs_area` VALUES ('531', '黑山县', '527', '1');
INSERT INTO `bbs_area` VALUES ('532', '义县', '527', '1');
INSERT INTO `bbs_area` VALUES ('533', '凌海市', '527', '1');
INSERT INTO `bbs_area` VALUES ('534', '北镇市', '527', '1');
INSERT INTO `bbs_area` VALUES ('535', '营口市', '471', '1');
INSERT INTO `bbs_area` VALUES ('536', '站前区', '535', '1');
INSERT INTO `bbs_area` VALUES ('537', '西市区', '535', '1');
INSERT INTO `bbs_area` VALUES ('538', '鲅鱼圈区', '535', '1');
INSERT INTO `bbs_area` VALUES ('539', '老边区', '535', '1');
INSERT INTO `bbs_area` VALUES ('540', '盖州市', '535', '1');
INSERT INTO `bbs_area` VALUES ('541', '大石桥市', '535', '1');
INSERT INTO `bbs_area` VALUES ('542', '阜新市', '471', '1');
INSERT INTO `bbs_area` VALUES ('543', '海州区', '542', '1');
INSERT INTO `bbs_area` VALUES ('544', '新邱区', '542', '1');
INSERT INTO `bbs_area` VALUES ('545', '太平区', '542', '1');
INSERT INTO `bbs_area` VALUES ('546', '清河门区', '542', '1');
INSERT INTO `bbs_area` VALUES ('547', '细河区', '542', '1');
INSERT INTO `bbs_area` VALUES ('548', '阜新蒙古族自治县', '542', '1');
INSERT INTO `bbs_area` VALUES ('549', '彰武县', '542', '1');
INSERT INTO `bbs_area` VALUES ('550', '辽阳市', '471', '1');
INSERT INTO `bbs_area` VALUES ('551', '白塔区', '550', '1');
INSERT INTO `bbs_area` VALUES ('552', '文圣区', '550', '1');
INSERT INTO `bbs_area` VALUES ('553', '宏伟区', '550', '1');
INSERT INTO `bbs_area` VALUES ('554', '弓长岭区', '550', '1');
INSERT INTO `bbs_area` VALUES ('555', '太子河区', '550', '1');
INSERT INTO `bbs_area` VALUES ('556', '辽阳县', '550', '1');
INSERT INTO `bbs_area` VALUES ('557', '灯塔市', '550', '1');
INSERT INTO `bbs_area` VALUES ('558', '盘锦市', '471', '1');
INSERT INTO `bbs_area` VALUES ('559', '双台子区', '558', '1');
INSERT INTO `bbs_area` VALUES ('560', '兴隆台区', '558', '1');
INSERT INTO `bbs_area` VALUES ('561', '大洼县', '558', '1');
INSERT INTO `bbs_area` VALUES ('562', '盘山县', '558', '1');
INSERT INTO `bbs_area` VALUES ('563', '铁岭市', '471', '1');
INSERT INTO `bbs_area` VALUES ('564', '银州区', '563', '1');
INSERT INTO `bbs_area` VALUES ('565', '清河区', '563', '1');
INSERT INTO `bbs_area` VALUES ('566', '铁岭县', '563', '1');
INSERT INTO `bbs_area` VALUES ('567', '西丰县', '563', '1');
INSERT INTO `bbs_area` VALUES ('568', '昌图县', '563', '1');
INSERT INTO `bbs_area` VALUES ('569', '调兵山市', '563', '1');
INSERT INTO `bbs_area` VALUES ('570', '开原市', '563', '1');
INSERT INTO `bbs_area` VALUES ('571', '朝阳市', '471', '1');
INSERT INTO `bbs_area` VALUES ('572', '双塔区', '571', '1');
INSERT INTO `bbs_area` VALUES ('573', '龙城区', '571', '1');
INSERT INTO `bbs_area` VALUES ('574', '朝阳县', '571', '1');
INSERT INTO `bbs_area` VALUES ('575', '建平县', '571', '1');
INSERT INTO `bbs_area` VALUES ('576', '喀喇沁左翼蒙古族自治县', '571', '1');
INSERT INTO `bbs_area` VALUES ('577', '北票市', '571', '1');
INSERT INTO `bbs_area` VALUES ('578', '凌源市', '571', '1');
INSERT INTO `bbs_area` VALUES ('579', '葫芦岛市', '471', '1');
INSERT INTO `bbs_area` VALUES ('580', '连山区', '579', '1');
INSERT INTO `bbs_area` VALUES ('581', '龙港区', '579', '1');
INSERT INTO `bbs_area` VALUES ('582', '南票区', '579', '1');
INSERT INTO `bbs_area` VALUES ('583', '绥中县', '579', '1');
INSERT INTO `bbs_area` VALUES ('584', '建昌县', '579', '1');
INSERT INTO `bbs_area` VALUES ('585', '兴城市', '579', '1');
INSERT INTO `bbs_area` VALUES ('586', '吉林', '0', '1');
INSERT INTO `bbs_area` VALUES ('587', '长春市', '586', '1');
INSERT INTO `bbs_area` VALUES ('588', '南关区', '587', '1');
INSERT INTO `bbs_area` VALUES ('589', '宽城区', '587', '1');
INSERT INTO `bbs_area` VALUES ('590', '朝阳区', '587', '1');
INSERT INTO `bbs_area` VALUES ('591', '二道区', '587', '1');
INSERT INTO `bbs_area` VALUES ('592', '绿园区', '587', '1');
INSERT INTO `bbs_area` VALUES ('593', '双阳区', '587', '1');
INSERT INTO `bbs_area` VALUES ('594', '农安县', '587', '1');
INSERT INTO `bbs_area` VALUES ('595', '九台市', '587', '1');
INSERT INTO `bbs_area` VALUES ('596', '榆树市', '587', '1');
INSERT INTO `bbs_area` VALUES ('597', '德惠市', '587', '1');
INSERT INTO `bbs_area` VALUES ('598', '吉林市', '586', '1');
INSERT INTO `bbs_area` VALUES ('599', '昌邑区', '598', '1');
INSERT INTO `bbs_area` VALUES ('600', '龙潭区', '598', '1');
INSERT INTO `bbs_area` VALUES ('601', '船营区', '598', '1');
INSERT INTO `bbs_area` VALUES ('602', '丰满区', '598', '1');
INSERT INTO `bbs_area` VALUES ('603', '永吉县', '598', '1');
INSERT INTO `bbs_area` VALUES ('604', '蛟河市', '598', '1');
INSERT INTO `bbs_area` VALUES ('605', '桦甸市', '598', '1');
INSERT INTO `bbs_area` VALUES ('606', '舒兰市', '598', '1');
INSERT INTO `bbs_area` VALUES ('607', '磐石市', '598', '1');
INSERT INTO `bbs_area` VALUES ('608', '四平市', '586', '1');
INSERT INTO `bbs_area` VALUES ('609', '铁西区', '608', '1');
INSERT INTO `bbs_area` VALUES ('610', '铁东区', '608', '1');
INSERT INTO `bbs_area` VALUES ('611', '梨树县', '608', '1');
INSERT INTO `bbs_area` VALUES ('612', '伊通满族自治县', '608', '1');
INSERT INTO `bbs_area` VALUES ('613', '公主岭市', '608', '1');
INSERT INTO `bbs_area` VALUES ('614', '双辽市', '608', '1');
INSERT INTO `bbs_area` VALUES ('615', '辽源市', '586', '1');
INSERT INTO `bbs_area` VALUES ('616', '龙山区', '615', '1');
INSERT INTO `bbs_area` VALUES ('617', '西安区', '615', '1');
INSERT INTO `bbs_area` VALUES ('618', '东丰县', '615', '1');
INSERT INTO `bbs_area` VALUES ('619', '东辽县', '615', '1');
INSERT INTO `bbs_area` VALUES ('620', '通化市', '586', '1');
INSERT INTO `bbs_area` VALUES ('621', '东昌区', '620', '1');
INSERT INTO `bbs_area` VALUES ('622', '二道江区', '620', '1');
INSERT INTO `bbs_area` VALUES ('623', '通化县', '620', '1');
INSERT INTO `bbs_area` VALUES ('624', '辉南县', '620', '1');
INSERT INTO `bbs_area` VALUES ('625', '柳河县', '620', '1');
INSERT INTO `bbs_area` VALUES ('626', '梅河口市', '620', '1');
INSERT INTO `bbs_area` VALUES ('627', '集安市', '620', '1');
INSERT INTO `bbs_area` VALUES ('628', '白山市', '586', '1');
INSERT INTO `bbs_area` VALUES ('629', '八道江区', '628', '1');
INSERT INTO `bbs_area` VALUES ('630', '江源区', '628', '1');
INSERT INTO `bbs_area` VALUES ('631', '抚松县', '628', '1');
INSERT INTO `bbs_area` VALUES ('632', '靖宇县', '628', '1');
INSERT INTO `bbs_area` VALUES ('633', '长白朝鲜族自治县', '628', '1');
INSERT INTO `bbs_area` VALUES ('634', '临江市', '628', '1');
INSERT INTO `bbs_area` VALUES ('635', '松原市', '586', '1');
INSERT INTO `bbs_area` VALUES ('636', '宁江区', '635', '1');
INSERT INTO `bbs_area` VALUES ('637', '前郭尔罗斯蒙古族自治县', '635', '1');
INSERT INTO `bbs_area` VALUES ('638', '长岭县', '635', '1');
INSERT INTO `bbs_area` VALUES ('639', '乾安县', '635', '1');
INSERT INTO `bbs_area` VALUES ('640', '扶余县', '635', '1');
INSERT INTO `bbs_area` VALUES ('641', '白城市', '586', '1');
INSERT INTO `bbs_area` VALUES ('642', '洮北区', '641', '1');
INSERT INTO `bbs_area` VALUES ('643', '镇赉县', '641', '1');
INSERT INTO `bbs_area` VALUES ('644', '通榆县', '641', '1');
INSERT INTO `bbs_area` VALUES ('645', '洮南市', '641', '1');
INSERT INTO `bbs_area` VALUES ('646', '大安市', '641', '1');
INSERT INTO `bbs_area` VALUES ('647', '延边朝鲜族自治州', '586', '1');
INSERT INTO `bbs_area` VALUES ('648', '延吉市', '647', '1');
INSERT INTO `bbs_area` VALUES ('649', '图们市', '647', '1');
INSERT INTO `bbs_area` VALUES ('650', '敦化市', '647', '1');
INSERT INTO `bbs_area` VALUES ('651', '珲春市', '647', '1');
INSERT INTO `bbs_area` VALUES ('652', '龙井市', '647', '1');
INSERT INTO `bbs_area` VALUES ('653', '和龙市', '647', '1');
INSERT INTO `bbs_area` VALUES ('654', '汪清县', '647', '1');
INSERT INTO `bbs_area` VALUES ('655', '安图县', '647', '1');
INSERT INTO `bbs_area` VALUES ('656', '黑龙江', '0', '1');
INSERT INTO `bbs_area` VALUES ('657', '哈尔滨市', '656', '1');
INSERT INTO `bbs_area` VALUES ('658', '道里区', '657', '1');
INSERT INTO `bbs_area` VALUES ('659', '南岗区', '657', '1');
INSERT INTO `bbs_area` VALUES ('660', '道外区', '657', '1');
INSERT INTO `bbs_area` VALUES ('661', '平房区', '657', '1');
INSERT INTO `bbs_area` VALUES ('662', '松北区', '657', '1');
INSERT INTO `bbs_area` VALUES ('663', '香坊区', '657', '1');
INSERT INTO `bbs_area` VALUES ('664', '呼兰区', '657', '1');
INSERT INTO `bbs_area` VALUES ('665', '阿城区', '657', '1');
INSERT INTO `bbs_area` VALUES ('666', '依兰县', '657', '1');
INSERT INTO `bbs_area` VALUES ('667', '方正县', '657', '1');
INSERT INTO `bbs_area` VALUES ('668', '宾县', '657', '1');
INSERT INTO `bbs_area` VALUES ('669', '巴彦县', '657', '1');
INSERT INTO `bbs_area` VALUES ('670', '木兰县', '657', '1');
INSERT INTO `bbs_area` VALUES ('671', '通河县', '657', '1');
INSERT INTO `bbs_area` VALUES ('672', '延寿县', '657', '1');
INSERT INTO `bbs_area` VALUES ('673', '双城市', '657', '1');
INSERT INTO `bbs_area` VALUES ('674', '尚志市', '657', '1');
INSERT INTO `bbs_area` VALUES ('675', '五常市', '657', '1');
INSERT INTO `bbs_area` VALUES ('676', '齐齐哈尔市', '656', '1');
INSERT INTO `bbs_area` VALUES ('677', '龙沙区', '676', '1');
INSERT INTO `bbs_area` VALUES ('678', '建华区', '676', '1');
INSERT INTO `bbs_area` VALUES ('679', '铁锋区', '676', '1');
INSERT INTO `bbs_area` VALUES ('680', '昂昂溪区', '676', '1');
INSERT INTO `bbs_area` VALUES ('681', '富拉尔基区', '676', '1');
INSERT INTO `bbs_area` VALUES ('682', '碾子山区', '676', '1');
INSERT INTO `bbs_area` VALUES ('683', '梅里斯达斡尔族区', '676', '1');
INSERT INTO `bbs_area` VALUES ('684', '龙江县', '676', '1');
INSERT INTO `bbs_area` VALUES ('685', '依安县', '676', '1');
INSERT INTO `bbs_area` VALUES ('686', '泰来县', '676', '1');
INSERT INTO `bbs_area` VALUES ('687', '甘南县', '676', '1');
INSERT INTO `bbs_area` VALUES ('688', '富裕县', '676', '1');
INSERT INTO `bbs_area` VALUES ('689', '克山县', '676', '1');
INSERT INTO `bbs_area` VALUES ('690', '克东县', '676', '1');
INSERT INTO `bbs_area` VALUES ('691', '拜泉县', '676', '1');
INSERT INTO `bbs_area` VALUES ('692', '讷河市', '676', '1');
INSERT INTO `bbs_area` VALUES ('693', '鸡西市', '656', '1');
INSERT INTO `bbs_area` VALUES ('694', '鸡冠区', '693', '1');
INSERT INTO `bbs_area` VALUES ('695', '恒山区', '693', '1');
INSERT INTO `bbs_area` VALUES ('696', '滴道区', '693', '1');
INSERT INTO `bbs_area` VALUES ('697', '梨树区', '693', '1');
INSERT INTO `bbs_area` VALUES ('698', '城子河区', '693', '1');
INSERT INTO `bbs_area` VALUES ('699', '麻山区', '693', '1');
INSERT INTO `bbs_area` VALUES ('700', '鸡东县', '693', '1');
INSERT INTO `bbs_area` VALUES ('701', '虎林市', '693', '1');
INSERT INTO `bbs_area` VALUES ('702', '密山市', '693', '1');
INSERT INTO `bbs_area` VALUES ('703', '鹤岗市', '656', '1');
INSERT INTO `bbs_area` VALUES ('704', '向阳区', '703', '1');
INSERT INTO `bbs_area` VALUES ('705', '工农区', '703', '1');
INSERT INTO `bbs_area` VALUES ('706', '南山区', '703', '1');
INSERT INTO `bbs_area` VALUES ('707', '兴安区', '703', '1');
INSERT INTO `bbs_area` VALUES ('708', '东山区', '703', '1');
INSERT INTO `bbs_area` VALUES ('709', '兴山区', '703', '1');
INSERT INTO `bbs_area` VALUES ('710', '萝北县', '703', '1');
INSERT INTO `bbs_area` VALUES ('711', '绥滨县', '703', '1');
INSERT INTO `bbs_area` VALUES ('712', '双鸭山市', '656', '1');
INSERT INTO `bbs_area` VALUES ('713', '尖山区', '712', '1');
INSERT INTO `bbs_area` VALUES ('714', '岭东区', '712', '1');
INSERT INTO `bbs_area` VALUES ('715', '四方台区', '712', '1');
INSERT INTO `bbs_area` VALUES ('716', '宝山区', '712', '1');
INSERT INTO `bbs_area` VALUES ('717', '集贤县', '712', '1');
INSERT INTO `bbs_area` VALUES ('718', '友谊县', '712', '1');
INSERT INTO `bbs_area` VALUES ('719', '宝清县', '712', '1');
INSERT INTO `bbs_area` VALUES ('720', '饶河县', '712', '1');
INSERT INTO `bbs_area` VALUES ('721', '大庆市', '656', '1');
INSERT INTO `bbs_area` VALUES ('722', '萨尔图区', '721', '1');
INSERT INTO `bbs_area` VALUES ('723', '龙凤区', '721', '1');
INSERT INTO `bbs_area` VALUES ('724', '让胡路区', '721', '1');
INSERT INTO `bbs_area` VALUES ('725', '红岗区', '721', '1');
INSERT INTO `bbs_area` VALUES ('726', '大同区', '721', '1');
INSERT INTO `bbs_area` VALUES ('727', '肇州县', '721', '1');
INSERT INTO `bbs_area` VALUES ('728', '肇源县', '721', '1');
INSERT INTO `bbs_area` VALUES ('729', '林甸县', '721', '1');
INSERT INTO `bbs_area` VALUES ('730', '杜尔伯特蒙古族自治县', '721', '1');
INSERT INTO `bbs_area` VALUES ('731', '伊春市', '656', '1');
INSERT INTO `bbs_area` VALUES ('732', '伊春区', '731', '1');
INSERT INTO `bbs_area` VALUES ('733', '南岔区', '731', '1');
INSERT INTO `bbs_area` VALUES ('734', '友好区', '731', '1');
INSERT INTO `bbs_area` VALUES ('735', '西林区', '731', '1');
INSERT INTO `bbs_area` VALUES ('736', '翠峦区', '731', '1');
INSERT INTO `bbs_area` VALUES ('737', '新青区', '731', '1');
INSERT INTO `bbs_area` VALUES ('738', '美溪区', '731', '1');
INSERT INTO `bbs_area` VALUES ('739', '金山屯区', '731', '1');
INSERT INTO `bbs_area` VALUES ('740', '五营区', '731', '1');
INSERT INTO `bbs_area` VALUES ('741', '乌马河区', '731', '1');
INSERT INTO `bbs_area` VALUES ('742', '汤旺河区', '731', '1');
INSERT INTO `bbs_area` VALUES ('743', '带岭区', '731', '1');
INSERT INTO `bbs_area` VALUES ('744', '乌伊岭区', '731', '1');
INSERT INTO `bbs_area` VALUES ('745', '红星区', '731', '1');
INSERT INTO `bbs_area` VALUES ('746', '上甘岭区', '731', '1');
INSERT INTO `bbs_area` VALUES ('747', '嘉荫县', '731', '1');
INSERT INTO `bbs_area` VALUES ('748', '铁力市', '731', '1');
INSERT INTO `bbs_area` VALUES ('749', '佳木斯市', '656', '1');
INSERT INTO `bbs_area` VALUES ('750', '向阳区', '749', '1');
INSERT INTO `bbs_area` VALUES ('751', '前进区', '749', '1');
INSERT INTO `bbs_area` VALUES ('752', '东风区', '749', '1');
INSERT INTO `bbs_area` VALUES ('753', '郊区', '749', '1');
INSERT INTO `bbs_area` VALUES ('754', '桦南县', '749', '1');
INSERT INTO `bbs_area` VALUES ('755', '桦川县', '749', '1');
INSERT INTO `bbs_area` VALUES ('756', '汤原县', '749', '1');
INSERT INTO `bbs_area` VALUES ('757', '抚远县', '749', '1');
INSERT INTO `bbs_area` VALUES ('758', '同江市', '749', '1');
INSERT INTO `bbs_area` VALUES ('759', '富锦市', '749', '1');
INSERT INTO `bbs_area` VALUES ('760', '七台河市', '656', '1');
INSERT INTO `bbs_area` VALUES ('761', '新兴区', '760', '1');
INSERT INTO `bbs_area` VALUES ('762', '桃山区', '760', '1');
INSERT INTO `bbs_area` VALUES ('763', '茄子河区', '760', '1');
INSERT INTO `bbs_area` VALUES ('764', '勃利县', '760', '1');
INSERT INTO `bbs_area` VALUES ('765', '牡丹江市', '656', '1');
INSERT INTO `bbs_area` VALUES ('766', '东安区', '765', '1');
INSERT INTO `bbs_area` VALUES ('767', '阳明区', '765', '1');
INSERT INTO `bbs_area` VALUES ('768', '爱民区', '765', '1');
INSERT INTO `bbs_area` VALUES ('769', '西安区', '765', '1');
INSERT INTO `bbs_area` VALUES ('770', '东宁县', '765', '1');
INSERT INTO `bbs_area` VALUES ('771', '林口县', '765', '1');
INSERT INTO `bbs_area` VALUES ('772', '绥芬河市', '765', '1');
INSERT INTO `bbs_area` VALUES ('773', '海林市', '765', '1');
INSERT INTO `bbs_area` VALUES ('774', '宁安市', '765', '1');
INSERT INTO `bbs_area` VALUES ('775', '穆棱市', '765', '1');
INSERT INTO `bbs_area` VALUES ('776', '黑河市', '656', '1');
INSERT INTO `bbs_area` VALUES ('777', '爱辉区', '776', '1');
INSERT INTO `bbs_area` VALUES ('778', '嫩江县', '776', '1');
INSERT INTO `bbs_area` VALUES ('779', '逊克县', '776', '1');
INSERT INTO `bbs_area` VALUES ('780', '孙吴县', '776', '1');
INSERT INTO `bbs_area` VALUES ('781', '北安市', '776', '1');
INSERT INTO `bbs_area` VALUES ('782', '五大连池市', '776', '1');
INSERT INTO `bbs_area` VALUES ('783', '绥化市', '656', '1');
INSERT INTO `bbs_area` VALUES ('784', '北林区', '783', '1');
INSERT INTO `bbs_area` VALUES ('785', '望奎县', '783', '1');
INSERT INTO `bbs_area` VALUES ('786', '兰西县', '783', '1');
INSERT INTO `bbs_area` VALUES ('787', '青冈县', '783', '1');
INSERT INTO `bbs_area` VALUES ('788', '庆安县', '783', '1');
INSERT INTO `bbs_area` VALUES ('789', '明水县', '783', '1');
INSERT INTO `bbs_area` VALUES ('790', '绥棱县', '783', '1');
INSERT INTO `bbs_area` VALUES ('791', '安达市', '783', '1');
INSERT INTO `bbs_area` VALUES ('792', '肇东市', '783', '1');
INSERT INTO `bbs_area` VALUES ('793', '海伦市', '783', '1');
INSERT INTO `bbs_area` VALUES ('794', '大兴安岭地区', '656', '1');
INSERT INTO `bbs_area` VALUES ('795', '加格达奇区', '794', '1');
INSERT INTO `bbs_area` VALUES ('796', '松岭区', '794', '1');
INSERT INTO `bbs_area` VALUES ('797', '新林区', '794', '1');
INSERT INTO `bbs_area` VALUES ('798', '呼中区', '794', '1');
INSERT INTO `bbs_area` VALUES ('799', '呼玛县', '794', '1');
INSERT INTO `bbs_area` VALUES ('800', '塔河县', '794', '1');
INSERT INTO `bbs_area` VALUES ('801', '漠河县', '794', '1');
INSERT INTO `bbs_area` VALUES ('802', '上海', '0', '1');
INSERT INTO `bbs_area` VALUES ('803', '上海市', '802', '1');
INSERT INTO `bbs_area` VALUES ('804', '黄浦区', '803', '1');
INSERT INTO `bbs_area` VALUES ('805', '卢湾区', '803', '1');
INSERT INTO `bbs_area` VALUES ('806', '徐汇区', '803', '1');
INSERT INTO `bbs_area` VALUES ('807', '长宁区', '803', '1');
INSERT INTO `bbs_area` VALUES ('808', '静安区', '803', '1');
INSERT INTO `bbs_area` VALUES ('809', '普陀区', '803', '1');
INSERT INTO `bbs_area` VALUES ('810', '闸北区', '803', '1');
INSERT INTO `bbs_area` VALUES ('811', '虹口区', '803', '1');
INSERT INTO `bbs_area` VALUES ('812', '杨浦区', '803', '1');
INSERT INTO `bbs_area` VALUES ('813', '闵行区', '803', '1');
INSERT INTO `bbs_area` VALUES ('814', '宝山区', '803', '1');
INSERT INTO `bbs_area` VALUES ('815', '嘉定区', '803', '1');
INSERT INTO `bbs_area` VALUES ('816', '浦东新区', '803', '1');
INSERT INTO `bbs_area` VALUES ('817', '金山区', '803', '1');
INSERT INTO `bbs_area` VALUES ('818', '松江区', '803', '1');
INSERT INTO `bbs_area` VALUES ('819', '青浦区', '803', '1');
INSERT INTO `bbs_area` VALUES ('820', '南汇区', '803', '1');
INSERT INTO `bbs_area` VALUES ('821', '奉贤区', '803', '1');
INSERT INTO `bbs_area` VALUES ('822', '崇明区', '803', '1');
INSERT INTO `bbs_area` VALUES ('823', '江苏', '0', '1');
INSERT INTO `bbs_area` VALUES ('824', '南京市', '823', '1');
INSERT INTO `bbs_area` VALUES ('825', '玄武区', '824', '1');
INSERT INTO `bbs_area` VALUES ('826', '白下区', '824', '1');
INSERT INTO `bbs_area` VALUES ('827', '秦淮区', '824', '1');
INSERT INTO `bbs_area` VALUES ('828', '建邺区', '824', '1');
INSERT INTO `bbs_area` VALUES ('829', '鼓楼区', '824', '1');
INSERT INTO `bbs_area` VALUES ('830', '下关区', '824', '1');
INSERT INTO `bbs_area` VALUES ('831', '浦口区', '824', '1');
INSERT INTO `bbs_area` VALUES ('832', '栖霞区', '824', '1');
INSERT INTO `bbs_area` VALUES ('833', '雨花台区', '824', '1');
INSERT INTO `bbs_area` VALUES ('834', '江宁区', '824', '1');
INSERT INTO `bbs_area` VALUES ('835', '六合区', '824', '1');
INSERT INTO `bbs_area` VALUES ('836', '溧水县', '824', '1');
INSERT INTO `bbs_area` VALUES ('837', '高淳县', '824', '1');
INSERT INTO `bbs_area` VALUES ('838', '无锡市', '823', '1');
INSERT INTO `bbs_area` VALUES ('839', '崇安区', '838', '1');
INSERT INTO `bbs_area` VALUES ('840', '南长区', '838', '1');
INSERT INTO `bbs_area` VALUES ('841', '北塘区', '838', '1');
INSERT INTO `bbs_area` VALUES ('842', '锡山区', '838', '1');
INSERT INTO `bbs_area` VALUES ('843', '惠山区', '838', '1');
INSERT INTO `bbs_area` VALUES ('844', '滨湖区', '838', '1');
INSERT INTO `bbs_area` VALUES ('845', '江阴市', '838', '1');
INSERT INTO `bbs_area` VALUES ('846', '宜兴市', '838', '1');
INSERT INTO `bbs_area` VALUES ('847', '徐州市', '823', '1');
INSERT INTO `bbs_area` VALUES ('848', '鼓楼区', '847', '1');
INSERT INTO `bbs_area` VALUES ('849', '云龙区', '847', '1');
INSERT INTO `bbs_area` VALUES ('850', '九里区', '847', '1');
INSERT INTO `bbs_area` VALUES ('851', '贾汪区', '847', '1');
INSERT INTO `bbs_area` VALUES ('852', '泉山区', '847', '1');
INSERT INTO `bbs_area` VALUES ('853', '丰县', '847', '1');
INSERT INTO `bbs_area` VALUES ('854', '沛县', '847', '1');
INSERT INTO `bbs_area` VALUES ('855', '铜山县', '847', '1');
INSERT INTO `bbs_area` VALUES ('856', '睢宁县', '847', '1');
INSERT INTO `bbs_area` VALUES ('857', '新沂市', '847', '1');
INSERT INTO `bbs_area` VALUES ('858', '邳州市', '847', '1');
INSERT INTO `bbs_area` VALUES ('859', '常州市', '823', '1');
INSERT INTO `bbs_area` VALUES ('860', '天宁区', '859', '1');
INSERT INTO `bbs_area` VALUES ('861', '钟楼区', '859', '1');
INSERT INTO `bbs_area` VALUES ('862', '戚墅堰区', '859', '1');
INSERT INTO `bbs_area` VALUES ('863', '新北区', '859', '1');
INSERT INTO `bbs_area` VALUES ('864', '武进区', '859', '1');
INSERT INTO `bbs_area` VALUES ('865', '溧阳市', '859', '1');
INSERT INTO `bbs_area` VALUES ('866', '金坛市', '859', '1');
INSERT INTO `bbs_area` VALUES ('867', '苏州市', '823', '1');
INSERT INTO `bbs_area` VALUES ('868', '沧浪区', '867', '1');
INSERT INTO `bbs_area` VALUES ('869', '平江区', '867', '1');
INSERT INTO `bbs_area` VALUES ('870', '金阊区', '867', '1');
INSERT INTO `bbs_area` VALUES ('871', '虎丘区', '867', '1');
INSERT INTO `bbs_area` VALUES ('872', '吴中区', '867', '1');
INSERT INTO `bbs_area` VALUES ('873', '相城区', '867', '1');
INSERT INTO `bbs_area` VALUES ('874', '常熟市', '867', '1');
INSERT INTO `bbs_area` VALUES ('875', '张家港市', '867', '1');
INSERT INTO `bbs_area` VALUES ('876', '昆山市', '867', '1');
INSERT INTO `bbs_area` VALUES ('877', '吴江市', '867', '1');
INSERT INTO `bbs_area` VALUES ('878', '太仓市', '867', '1');
INSERT INTO `bbs_area` VALUES ('879', '南通市', '823', '1');
INSERT INTO `bbs_area` VALUES ('880', '崇川区', '879', '1');
INSERT INTO `bbs_area` VALUES ('881', '港闸区', '879', '1');
INSERT INTO `bbs_area` VALUES ('882', '海安县', '879', '1');
INSERT INTO `bbs_area` VALUES ('883', '如东县', '879', '1');
INSERT INTO `bbs_area` VALUES ('884', '启东市', '879', '1');
INSERT INTO `bbs_area` VALUES ('885', '如皋市', '879', '1');
INSERT INTO `bbs_area` VALUES ('886', '通州市', '879', '1');
INSERT INTO `bbs_area` VALUES ('887', '海门市', '879', '1');
INSERT INTO `bbs_area` VALUES ('888', '连云港市', '823', '1');
INSERT INTO `bbs_area` VALUES ('889', '连云区', '888', '1');
INSERT INTO `bbs_area` VALUES ('890', '新浦区', '888', '1');
INSERT INTO `bbs_area` VALUES ('891', '海州区', '888', '1');
INSERT INTO `bbs_area` VALUES ('892', '赣榆县', '888', '1');
INSERT INTO `bbs_area` VALUES ('893', '东海县', '888', '1');
INSERT INTO `bbs_area` VALUES ('894', '灌云县', '888', '1');
INSERT INTO `bbs_area` VALUES ('895', '灌南县', '888', '1');
INSERT INTO `bbs_area` VALUES ('896', '淮安市', '823', '1');
INSERT INTO `bbs_area` VALUES ('897', '清河区', '896', '1');
INSERT INTO `bbs_area` VALUES ('898', '楚州区', '896', '1');
INSERT INTO `bbs_area` VALUES ('899', '淮阴区', '896', '1');
INSERT INTO `bbs_area` VALUES ('900', '清浦区', '896', '1');
INSERT INTO `bbs_area` VALUES ('901', '涟水县', '896', '1');
INSERT INTO `bbs_area` VALUES ('902', '洪泽县', '896', '1');
INSERT INTO `bbs_area` VALUES ('903', '盱眙县', '896', '1');
INSERT INTO `bbs_area` VALUES ('904', '金湖县', '896', '1');
INSERT INTO `bbs_area` VALUES ('905', '盐城市', '823', '1');
INSERT INTO `bbs_area` VALUES ('906', '亭湖区', '905', '1');
INSERT INTO `bbs_area` VALUES ('907', '盐都区', '905', '1');
INSERT INTO `bbs_area` VALUES ('908', '响水县', '905', '1');
INSERT INTO `bbs_area` VALUES ('909', '滨海县', '905', '1');
INSERT INTO `bbs_area` VALUES ('910', '阜宁县', '905', '1');
INSERT INTO `bbs_area` VALUES ('911', '射阳县', '905', '1');
INSERT INTO `bbs_area` VALUES ('912', '建湖县', '905', '1');
INSERT INTO `bbs_area` VALUES ('913', '东台市', '905', '1');
INSERT INTO `bbs_area` VALUES ('914', '大丰市', '905', '1');
INSERT INTO `bbs_area` VALUES ('915', '扬州市', '823', '1');
INSERT INTO `bbs_area` VALUES ('916', '广陵区', '915', '1');
INSERT INTO `bbs_area` VALUES ('917', '邗江区', '915', '1');
INSERT INTO `bbs_area` VALUES ('918', '维扬区', '915', '1');
INSERT INTO `bbs_area` VALUES ('919', '宝应县', '915', '1');
INSERT INTO `bbs_area` VALUES ('920', '仪征市', '915', '1');
INSERT INTO `bbs_area` VALUES ('921', '高邮市', '915', '1');
INSERT INTO `bbs_area` VALUES ('922', '江都市', '915', '1');
INSERT INTO `bbs_area` VALUES ('923', '镇江市', '823', '1');
INSERT INTO `bbs_area` VALUES ('924', '京口区', '923', '1');
INSERT INTO `bbs_area` VALUES ('925', '润州区', '923', '1');
INSERT INTO `bbs_area` VALUES ('926', '丹徒区', '923', '1');
INSERT INTO `bbs_area` VALUES ('927', '丹阳市', '923', '1');
INSERT INTO `bbs_area` VALUES ('928', '扬中市', '923', '1');
INSERT INTO `bbs_area` VALUES ('929', '句容市', '923', '1');
INSERT INTO `bbs_area` VALUES ('930', '泰州市', '823', '1');
INSERT INTO `bbs_area` VALUES ('931', '海陵区', '930', '1');
INSERT INTO `bbs_area` VALUES ('932', '高港区', '930', '1');
INSERT INTO `bbs_area` VALUES ('933', '兴化市', '930', '1');
INSERT INTO `bbs_area` VALUES ('934', '靖江市', '930', '1');
INSERT INTO `bbs_area` VALUES ('935', '泰兴市', '930', '1');
INSERT INTO `bbs_area` VALUES ('936', '姜堰市', '930', '1');
INSERT INTO `bbs_area` VALUES ('937', '宿迁市', '823', '1');
INSERT INTO `bbs_area` VALUES ('938', '宿城区', '937', '1');
INSERT INTO `bbs_area` VALUES ('939', '宿豫区', '937', '1');
INSERT INTO `bbs_area` VALUES ('940', '沭阳县', '937', '1');
INSERT INTO `bbs_area` VALUES ('941', '泗阳县', '937', '1');
INSERT INTO `bbs_area` VALUES ('942', '泗洪县', '937', '1');
INSERT INTO `bbs_area` VALUES ('943', '浙江', '0', '1');
INSERT INTO `bbs_area` VALUES ('944', '杭州市', '943', '1');
INSERT INTO `bbs_area` VALUES ('945', '上城区', '944', '1');
INSERT INTO `bbs_area` VALUES ('946', '下城区', '944', '1');
INSERT INTO `bbs_area` VALUES ('947', '江干区', '944', '1');
INSERT INTO `bbs_area` VALUES ('948', '拱墅区', '944', '1');
INSERT INTO `bbs_area` VALUES ('949', '西湖区', '944', '1');
INSERT INTO `bbs_area` VALUES ('950', '滨江区', '944', '1');
INSERT INTO `bbs_area` VALUES ('951', '萧山区', '944', '1');
INSERT INTO `bbs_area` VALUES ('952', '余杭区', '944', '1');
INSERT INTO `bbs_area` VALUES ('953', '桐庐县', '944', '1');
INSERT INTO `bbs_area` VALUES ('954', '淳安县', '944', '1');
INSERT INTO `bbs_area` VALUES ('955', '建德市', '944', '1');
INSERT INTO `bbs_area` VALUES ('956', '富阳市', '944', '1');
INSERT INTO `bbs_area` VALUES ('957', '临安市', '944', '1');
INSERT INTO `bbs_area` VALUES ('958', '宁波市', '943', '1');
INSERT INTO `bbs_area` VALUES ('959', '海曙区', '958', '1');
INSERT INTO `bbs_area` VALUES ('960', '江东区', '958', '1');
INSERT INTO `bbs_area` VALUES ('961', '江北区', '958', '1');
INSERT INTO `bbs_area` VALUES ('962', '北仑区', '958', '1');
INSERT INTO `bbs_area` VALUES ('963', '镇海区', '958', '1');
INSERT INTO `bbs_area` VALUES ('964', '鄞州区', '958', '1');
INSERT INTO `bbs_area` VALUES ('965', '象山县', '958', '1');
INSERT INTO `bbs_area` VALUES ('966', '宁海县', '958', '1');
INSERT INTO `bbs_area` VALUES ('967', '余姚市', '958', '1');
INSERT INTO `bbs_area` VALUES ('968', '慈溪市', '958', '1');
INSERT INTO `bbs_area` VALUES ('969', '奉化市', '958', '1');
INSERT INTO `bbs_area` VALUES ('970', '温州市', '943', '1');
INSERT INTO `bbs_area` VALUES ('971', '鹿城区', '970', '1');
INSERT INTO `bbs_area` VALUES ('972', '龙湾区', '970', '1');
INSERT INTO `bbs_area` VALUES ('973', '瓯海区', '970', '1');
INSERT INTO `bbs_area` VALUES ('974', '洞头县', '970', '1');
INSERT INTO `bbs_area` VALUES ('975', '永嘉县', '970', '1');
INSERT INTO `bbs_area` VALUES ('976', '平阳县', '970', '1');
INSERT INTO `bbs_area` VALUES ('977', '苍南县', '970', '1');
INSERT INTO `bbs_area` VALUES ('978', '文成县', '970', '1');
INSERT INTO `bbs_area` VALUES ('979', '泰顺县', '970', '1');
INSERT INTO `bbs_area` VALUES ('980', '瑞安市', '970', '1');
INSERT INTO `bbs_area` VALUES ('981', '乐清市', '970', '1');
INSERT INTO `bbs_area` VALUES ('982', '嘉兴市', '943', '1');
INSERT INTO `bbs_area` VALUES ('983', '南湖区', '982', '1');
INSERT INTO `bbs_area` VALUES ('984', '秀洲区', '982', '1');
INSERT INTO `bbs_area` VALUES ('985', '嘉善县', '982', '1');
INSERT INTO `bbs_area` VALUES ('986', '海盐县', '982', '1');
INSERT INTO `bbs_area` VALUES ('987', '海宁市', '982', '1');
INSERT INTO `bbs_area` VALUES ('988', '平湖市', '982', '1');
INSERT INTO `bbs_area` VALUES ('989', '桐乡市', '982', '1');
INSERT INTO `bbs_area` VALUES ('990', '湖州市', '943', '1');
INSERT INTO `bbs_area` VALUES ('991', '吴兴区', '990', '1');
INSERT INTO `bbs_area` VALUES ('992', '南浔区', '990', '1');
INSERT INTO `bbs_area` VALUES ('993', '德清县', '990', '1');
INSERT INTO `bbs_area` VALUES ('994', '长兴县', '990', '1');
INSERT INTO `bbs_area` VALUES ('995', '安吉县', '990', '1');
INSERT INTO `bbs_area` VALUES ('996', '绍兴市', '943', '1');
INSERT INTO `bbs_area` VALUES ('997', '越城区', '996', '1');
INSERT INTO `bbs_area` VALUES ('998', '绍兴县', '996', '1');
INSERT INTO `bbs_area` VALUES ('999', '新昌县', '996', '1');
INSERT INTO `bbs_area` VALUES ('1000', '诸暨市', '996', '1');
INSERT INTO `bbs_area` VALUES ('1001', '上虞市', '996', '1');
INSERT INTO `bbs_area` VALUES ('1002', '嵊州市', '996', '1');
INSERT INTO `bbs_area` VALUES ('1003', '金华市', '943', '1');
INSERT INTO `bbs_area` VALUES ('1004', '婺城区', '1003', '1');
INSERT INTO `bbs_area` VALUES ('1005', '金东区', '1003', '1');
INSERT INTO `bbs_area` VALUES ('1006', '武义县', '1003', '1');
INSERT INTO `bbs_area` VALUES ('1007', '浦江县', '1003', '1');
INSERT INTO `bbs_area` VALUES ('1008', '磐安县', '1003', '1');
INSERT INTO `bbs_area` VALUES ('1009', '兰溪市', '1003', '1');
INSERT INTO `bbs_area` VALUES ('1010', '义乌市', '1003', '1');
INSERT INTO `bbs_area` VALUES ('1011', '东阳市', '1003', '1');
INSERT INTO `bbs_area` VALUES ('1012', '永康市', '1003', '1');
INSERT INTO `bbs_area` VALUES ('1013', '衢州市', '943', '1');
INSERT INTO `bbs_area` VALUES ('1014', '柯城区', '1013', '1');
INSERT INTO `bbs_area` VALUES ('1015', '衢江区', '1013', '1');
INSERT INTO `bbs_area` VALUES ('1016', '常山县', '1013', '1');
INSERT INTO `bbs_area` VALUES ('1017', '开化县', '1013', '1');
INSERT INTO `bbs_area` VALUES ('1018', '龙游县', '1013', '1');
INSERT INTO `bbs_area` VALUES ('1019', '江山市', '1013', '1');
INSERT INTO `bbs_area` VALUES ('1020', '舟山市', '943', '1');
INSERT INTO `bbs_area` VALUES ('1021', '定海区', '1020', '1');
INSERT INTO `bbs_area` VALUES ('1022', '普陀区', '1020', '1');
INSERT INTO `bbs_area` VALUES ('1023', '岱山县', '1020', '1');
INSERT INTO `bbs_area` VALUES ('1024', '嵊泗县', '1020', '1');
INSERT INTO `bbs_area` VALUES ('1025', '台州市', '943', '1');
INSERT INTO `bbs_area` VALUES ('1026', '椒江区', '1025', '1');
INSERT INTO `bbs_area` VALUES ('1027', '黄岩区', '1025', '1');
INSERT INTO `bbs_area` VALUES ('1028', '路桥区', '1025', '1');
INSERT INTO `bbs_area` VALUES ('1029', '玉环县', '1025', '1');
INSERT INTO `bbs_area` VALUES ('1030', '三门县', '1025', '1');
INSERT INTO `bbs_area` VALUES ('1031', '天台县', '1025', '1');
INSERT INTO `bbs_area` VALUES ('1032', '仙居县', '1025', '1');
INSERT INTO `bbs_area` VALUES ('1033', '温岭市', '1025', '1');
INSERT INTO `bbs_area` VALUES ('1034', '临海市', '1025', '1');
INSERT INTO `bbs_area` VALUES ('1035', '丽水市', '943', '1');
INSERT INTO `bbs_area` VALUES ('1036', '莲都区', '1035', '1');
INSERT INTO `bbs_area` VALUES ('1037', '青田县', '1035', '1');
INSERT INTO `bbs_area` VALUES ('1038', '缙云县', '1035', '1');
INSERT INTO `bbs_area` VALUES ('1039', '遂昌县', '1035', '1');
INSERT INTO `bbs_area` VALUES ('1040', '松阳县', '1035', '1');
INSERT INTO `bbs_area` VALUES ('1041', '云和县', '1035', '1');
INSERT INTO `bbs_area` VALUES ('1042', '庆元县', '1035', '1');
INSERT INTO `bbs_area` VALUES ('1043', '景宁畲族自治县', '1035', '1');
INSERT INTO `bbs_area` VALUES ('1044', '龙泉市', '1035', '1');
INSERT INTO `bbs_area` VALUES ('1045', '安徽', '0', '1');
INSERT INTO `bbs_area` VALUES ('1046', '合肥市', '1045', '1');
INSERT INTO `bbs_area` VALUES ('1047', '瑶海区', '1046', '1');
INSERT INTO `bbs_area` VALUES ('1048', '庐阳区', '1046', '1');
INSERT INTO `bbs_area` VALUES ('1049', '蜀山区', '1046', '1');
INSERT INTO `bbs_area` VALUES ('1050', '包河区', '1046', '1');
INSERT INTO `bbs_area` VALUES ('1051', '长丰县', '1046', '1');
INSERT INTO `bbs_area` VALUES ('1052', '肥东县', '1046', '1');
INSERT INTO `bbs_area` VALUES ('1053', '肥西县', '1046', '1');
INSERT INTO `bbs_area` VALUES ('1054', '芜湖市', '1045', '1');
INSERT INTO `bbs_area` VALUES ('1055', '镜湖区', '1054', '1');
INSERT INTO `bbs_area` VALUES ('1056', '弋江区', '1054', '1');
INSERT INTO `bbs_area` VALUES ('1057', '鸠江区', '1054', '1');
INSERT INTO `bbs_area` VALUES ('1058', '三山区', '1054', '1');
INSERT INTO `bbs_area` VALUES ('1059', '芜湖县', '1054', '1');
INSERT INTO `bbs_area` VALUES ('1060', '繁昌县', '1054', '1');
INSERT INTO `bbs_area` VALUES ('1061', '南陵县', '1054', '1');
INSERT INTO `bbs_area` VALUES ('1062', '蚌埠市', '1045', '1');
INSERT INTO `bbs_area` VALUES ('1063', '龙子湖区', '1062', '1');
INSERT INTO `bbs_area` VALUES ('1064', '蚌山区', '1062', '1');
INSERT INTO `bbs_area` VALUES ('1065', '禹会区', '1062', '1');
INSERT INTO `bbs_area` VALUES ('1066', '淮上区', '1062', '1');
INSERT INTO `bbs_area` VALUES ('1067', '怀远县', '1062', '1');
INSERT INTO `bbs_area` VALUES ('1068', '五河县', '1062', '1');
INSERT INTO `bbs_area` VALUES ('1069', '固镇县', '1062', '1');
INSERT INTO `bbs_area` VALUES ('1070', '淮南市', '1045', '1');
INSERT INTO `bbs_area` VALUES ('1071', '大通区', '1070', '1');
INSERT INTO `bbs_area` VALUES ('1072', '田家庵区', '1070', '1');
INSERT INTO `bbs_area` VALUES ('1073', '谢家集区', '1070', '1');
INSERT INTO `bbs_area` VALUES ('1074', '八公山区', '1070', '1');
INSERT INTO `bbs_area` VALUES ('1075', '潘集区', '1070', '1');
INSERT INTO `bbs_area` VALUES ('1076', '凤台县', '1070', '1');
INSERT INTO `bbs_area` VALUES ('1077', '马鞍山市', '1045', '1');
INSERT INTO `bbs_area` VALUES ('1078', '金家庄区', '1077', '1');
INSERT INTO `bbs_area` VALUES ('1079', '花山区', '1077', '1');
INSERT INTO `bbs_area` VALUES ('1080', '雨山区', '1077', '1');
INSERT INTO `bbs_area` VALUES ('1081', '当涂县', '1077', '1');
INSERT INTO `bbs_area` VALUES ('1082', '淮北市', '1045', '1');
INSERT INTO `bbs_area` VALUES ('1083', '杜集区', '1082', '1');
INSERT INTO `bbs_area` VALUES ('1084', '相山区', '1082', '1');
INSERT INTO `bbs_area` VALUES ('1085', '烈山区', '1082', '1');
INSERT INTO `bbs_area` VALUES ('1086', '濉溪县', '1082', '1');
INSERT INTO `bbs_area` VALUES ('1087', '铜陵市', '1045', '1');
INSERT INTO `bbs_area` VALUES ('1088', '铜官山区', '1087', '1');
INSERT INTO `bbs_area` VALUES ('1089', '狮子山区', '1087', '1');
INSERT INTO `bbs_area` VALUES ('1090', '郊区', '1087', '1');
INSERT INTO `bbs_area` VALUES ('1091', '铜陵县', '1087', '1');
INSERT INTO `bbs_area` VALUES ('1092', '安庆市', '1045', '1');
INSERT INTO `bbs_area` VALUES ('1093', '迎江区', '1092', '1');
INSERT INTO `bbs_area` VALUES ('1094', '大观区', '1092', '1');
INSERT INTO `bbs_area` VALUES ('1095', '宜秀区', '1092', '1');
INSERT INTO `bbs_area` VALUES ('1096', '怀宁县', '1092', '1');
INSERT INTO `bbs_area` VALUES ('1097', '枞阳县', '1092', '1');
INSERT INTO `bbs_area` VALUES ('1098', '潜山县', '1092', '1');
INSERT INTO `bbs_area` VALUES ('1099', '太湖县', '1092', '1');
INSERT INTO `bbs_area` VALUES ('1100', '宿松县', '1092', '1');
INSERT INTO `bbs_area` VALUES ('1101', '望江县', '1092', '1');
INSERT INTO `bbs_area` VALUES ('1102', '岳西县', '1092', '1');
INSERT INTO `bbs_area` VALUES ('1103', '桐城市', '1092', '1');
INSERT INTO `bbs_area` VALUES ('1104', '黄山市', '1045', '1');
INSERT INTO `bbs_area` VALUES ('1105', '屯溪区', '1104', '1');
INSERT INTO `bbs_area` VALUES ('1106', '黄山区', '1104', '1');
INSERT INTO `bbs_area` VALUES ('1107', '徽州区', '1104', '1');
INSERT INTO `bbs_area` VALUES ('1108', '歙县', '1104', '1');
INSERT INTO `bbs_area` VALUES ('1109', '休宁县', '1104', '1');
INSERT INTO `bbs_area` VALUES ('1110', '黟县', '1104', '1');
INSERT INTO `bbs_area` VALUES ('1111', '祁门县', '1104', '1');
INSERT INTO `bbs_area` VALUES ('1112', '滁州市', '1045', '1');
INSERT INTO `bbs_area` VALUES ('1113', '琅琊区', '1112', '1');
INSERT INTO `bbs_area` VALUES ('1114', '南谯区', '1112', '1');
INSERT INTO `bbs_area` VALUES ('1115', '来安县', '1112', '1');
INSERT INTO `bbs_area` VALUES ('1116', '全椒县', '1112', '1');
INSERT INTO `bbs_area` VALUES ('1117', '定远县', '1112', '1');
INSERT INTO `bbs_area` VALUES ('1118', '凤阳县', '1112', '1');
INSERT INTO `bbs_area` VALUES ('1119', '天长市', '1112', '1');
INSERT INTO `bbs_area` VALUES ('1120', '明光市', '1112', '1');
INSERT INTO `bbs_area` VALUES ('1121', '阜阳市', '1045', '1');
INSERT INTO `bbs_area` VALUES ('1122', '颍州区', '1121', '1');
INSERT INTO `bbs_area` VALUES ('1123', '颍东区', '1121', '1');
INSERT INTO `bbs_area` VALUES ('1124', '颍泉区', '1121', '1');
INSERT INTO `bbs_area` VALUES ('1125', '临泉县', '1121', '1');
INSERT INTO `bbs_area` VALUES ('1126', '太和县', '1121', '1');
INSERT INTO `bbs_area` VALUES ('1127', '阜南县', '1121', '1');
INSERT INTO `bbs_area` VALUES ('1128', '颍上县', '1121', '1');
INSERT INTO `bbs_area` VALUES ('1129', '界首市', '1121', '1');
INSERT INTO `bbs_area` VALUES ('1130', '宿州市', '1045', '1');
INSERT INTO `bbs_area` VALUES ('1131', '埇桥区', '1130', '1');
INSERT INTO `bbs_area` VALUES ('1132', '砀山县', '1130', '1');
INSERT INTO `bbs_area` VALUES ('1133', '萧县', '1130', '1');
INSERT INTO `bbs_area` VALUES ('1134', '灵璧县', '1130', '1');
INSERT INTO `bbs_area` VALUES ('1135', '泗县', '1130', '1');
INSERT INTO `bbs_area` VALUES ('1136', '巢湖市', '1045', '1');
INSERT INTO `bbs_area` VALUES ('1137', '居巢区', '1136', '1');
INSERT INTO `bbs_area` VALUES ('1138', '庐江县', '1136', '1');
INSERT INTO `bbs_area` VALUES ('1139', '无为县', '1136', '1');
INSERT INTO `bbs_area` VALUES ('1140', '含山县', '1136', '1');
INSERT INTO `bbs_area` VALUES ('1141', '和县', '1136', '1');
INSERT INTO `bbs_area` VALUES ('1142', '六安市', '1045', '1');
INSERT INTO `bbs_area` VALUES ('1143', '金安区', '1142', '1');
INSERT INTO `bbs_area` VALUES ('1144', '裕安区', '1142', '1');
INSERT INTO `bbs_area` VALUES ('1145', '寿县', '1142', '1');
INSERT INTO `bbs_area` VALUES ('1146', '霍邱县', '1142', '1');
INSERT INTO `bbs_area` VALUES ('1147', '舒城县', '1142', '1');
INSERT INTO `bbs_area` VALUES ('1148', '金寨县', '1142', '1');
INSERT INTO `bbs_area` VALUES ('1149', '霍山县', '1142', '1');
INSERT INTO `bbs_area` VALUES ('1150', '亳州市', '1045', '1');
INSERT INTO `bbs_area` VALUES ('1151', '谯城区', '1150', '1');
INSERT INTO `bbs_area` VALUES ('1152', '涡阳县', '1150', '1');
INSERT INTO `bbs_area` VALUES ('1153', '蒙城县', '1150', '1');
INSERT INTO `bbs_area` VALUES ('1154', '利辛县', '1150', '1');
INSERT INTO `bbs_area` VALUES ('1155', '池州市', '1045', '1');
INSERT INTO `bbs_area` VALUES ('1156', '贵池区', '1155', '1');
INSERT INTO `bbs_area` VALUES ('1157', '东至县', '1155', '1');
INSERT INTO `bbs_area` VALUES ('1158', '石台县', '1155', '1');
INSERT INTO `bbs_area` VALUES ('1159', '青阳县', '1155', '1');
INSERT INTO `bbs_area` VALUES ('1160', '宣城市', '1045', '1');
INSERT INTO `bbs_area` VALUES ('1161', '宣州区', '1160', '1');
INSERT INTO `bbs_area` VALUES ('1162', '郎溪县', '1160', '1');
INSERT INTO `bbs_area` VALUES ('1163', '广德县', '1160', '1');
INSERT INTO `bbs_area` VALUES ('1164', '泾县', '1160', '1');
INSERT INTO `bbs_area` VALUES ('1165', '绩溪县', '1160', '1');
INSERT INTO `bbs_area` VALUES ('1166', '旌德县', '1160', '1');
INSERT INTO `bbs_area` VALUES ('1167', '宁国市', '1160', '1');
INSERT INTO `bbs_area` VALUES ('1168', '福建', '0', '1');
INSERT INTO `bbs_area` VALUES ('1169', '福州市', '1168', '1');
INSERT INTO `bbs_area` VALUES ('1170', '鼓楼区', '1169', '1');
INSERT INTO `bbs_area` VALUES ('1171', '台江区', '1169', '1');
INSERT INTO `bbs_area` VALUES ('1172', '仓山区', '1169', '1');
INSERT INTO `bbs_area` VALUES ('1173', '马尾区', '1169', '1');
INSERT INTO `bbs_area` VALUES ('1174', '晋安区', '1169', '1');
INSERT INTO `bbs_area` VALUES ('1175', '闽侯县', '1169', '1');
INSERT INTO `bbs_area` VALUES ('1176', '连江县', '1169', '1');
INSERT INTO `bbs_area` VALUES ('1177', '罗源县', '1169', '1');
INSERT INTO `bbs_area` VALUES ('1178', '闽清县', '1169', '1');
INSERT INTO `bbs_area` VALUES ('1179', '永泰县', '1169', '1');
INSERT INTO `bbs_area` VALUES ('1180', '平潭县', '1169', '1');
INSERT INTO `bbs_area` VALUES ('1181', '福清市', '1169', '1');
INSERT INTO `bbs_area` VALUES ('1182', '长乐市', '1169', '1');
INSERT INTO `bbs_area` VALUES ('1183', '厦门市', '1168', '1');
INSERT INTO `bbs_area` VALUES ('1184', '思明区', '1183', '1');
INSERT INTO `bbs_area` VALUES ('1185', '海沧区', '1183', '1');
INSERT INTO `bbs_area` VALUES ('1186', '湖里区', '1183', '1');
INSERT INTO `bbs_area` VALUES ('1187', '集美区', '1183', '1');
INSERT INTO `bbs_area` VALUES ('1188', '同安区', '1183', '1');
INSERT INTO `bbs_area` VALUES ('1189', '翔安区', '1183', '1');
INSERT INTO `bbs_area` VALUES ('1190', '莆田市', '1168', '1');
INSERT INTO `bbs_area` VALUES ('1191', '城厢区', '1190', '1');
INSERT INTO `bbs_area` VALUES ('1192', '涵江区', '1190', '1');
INSERT INTO `bbs_area` VALUES ('1193', '荔城区', '1190', '1');
INSERT INTO `bbs_area` VALUES ('1194', '秀屿区', '1190', '1');
INSERT INTO `bbs_area` VALUES ('1195', '仙游县', '1190', '1');
INSERT INTO `bbs_area` VALUES ('1196', '三明市', '1168', '1');
INSERT INTO `bbs_area` VALUES ('1197', '梅列区', '1196', '1');
INSERT INTO `bbs_area` VALUES ('1198', '三元区', '1196', '1');
INSERT INTO `bbs_area` VALUES ('1199', '明溪县', '1196', '1');
INSERT INTO `bbs_area` VALUES ('1200', '清流县', '1196', '1');
INSERT INTO `bbs_area` VALUES ('1201', '宁化县', '1196', '1');
INSERT INTO `bbs_area` VALUES ('1202', '大田县', '1196', '1');
INSERT INTO `bbs_area` VALUES ('1203', '尤溪县', '1196', '1');
INSERT INTO `bbs_area` VALUES ('1204', '沙县', '1196', '1');
INSERT INTO `bbs_area` VALUES ('1205', '将乐县', '1196', '1');
INSERT INTO `bbs_area` VALUES ('1206', '泰宁县', '1196', '1');
INSERT INTO `bbs_area` VALUES ('1207', '建宁县', '1196', '1');
INSERT INTO `bbs_area` VALUES ('1208', '永安市', '1196', '1');
INSERT INTO `bbs_area` VALUES ('1209', '泉州市', '1168', '1');
INSERT INTO `bbs_area` VALUES ('1210', '鲤城区', '1209', '1');
INSERT INTO `bbs_area` VALUES ('1211', '丰泽区', '1209', '1');
INSERT INTO `bbs_area` VALUES ('1212', '洛江区', '1209', '1');
INSERT INTO `bbs_area` VALUES ('1213', '泉港区', '1209', '1');
INSERT INTO `bbs_area` VALUES ('1214', '惠安县', '1209', '1');
INSERT INTO `bbs_area` VALUES ('1215', '安溪县', '1209', '1');
INSERT INTO `bbs_area` VALUES ('1216', '永春县', '1209', '1');
INSERT INTO `bbs_area` VALUES ('1217', '德化县', '1209', '1');
INSERT INTO `bbs_area` VALUES ('1218', '金门县', '1209', '1');
INSERT INTO `bbs_area` VALUES ('1219', '石狮市', '1209', '1');
INSERT INTO `bbs_area` VALUES ('1220', '晋江市', '1209', '1');
INSERT INTO `bbs_area` VALUES ('1221', '南安市', '1209', '1');
INSERT INTO `bbs_area` VALUES ('1222', '漳州市', '1168', '1');
INSERT INTO `bbs_area` VALUES ('1223', '芗城区', '1222', '1');
INSERT INTO `bbs_area` VALUES ('1224', '龙文区', '1222', '1');
INSERT INTO `bbs_area` VALUES ('1225', '云霄县', '1222', '1');
INSERT INTO `bbs_area` VALUES ('1226', '漳浦县', '1222', '1');
INSERT INTO `bbs_area` VALUES ('1227', '诏安县', '1222', '1');
INSERT INTO `bbs_area` VALUES ('1228', '长泰县', '1222', '1');
INSERT INTO `bbs_area` VALUES ('1229', '东山县', '1222', '1');
INSERT INTO `bbs_area` VALUES ('1230', '南靖县', '1222', '1');
INSERT INTO `bbs_area` VALUES ('1231', '平和县', '1222', '1');
INSERT INTO `bbs_area` VALUES ('1232', '华安县', '1222', '1');
INSERT INTO `bbs_area` VALUES ('1233', '龙海市', '1222', '1');
INSERT INTO `bbs_area` VALUES ('1234', '南平市', '1168', '1');
INSERT INTO `bbs_area` VALUES ('1235', '延平区', '1234', '1');
INSERT INTO `bbs_area` VALUES ('1236', '顺昌县', '1234', '1');
INSERT INTO `bbs_area` VALUES ('1237', '浦城县', '1234', '1');
INSERT INTO `bbs_area` VALUES ('1238', '光泽县', '1234', '1');
INSERT INTO `bbs_area` VALUES ('1239', '松溪县', '1234', '1');
INSERT INTO `bbs_area` VALUES ('1240', '政和县', '1234', '1');
INSERT INTO `bbs_area` VALUES ('1241', '邵武市', '1234', '1');
INSERT INTO `bbs_area` VALUES ('1242', '武夷山市', '1234', '1');
INSERT INTO `bbs_area` VALUES ('1243', '建瓯市', '1234', '1');
INSERT INTO `bbs_area` VALUES ('1244', '建阳市', '1234', '1');
INSERT INTO `bbs_area` VALUES ('1245', '龙岩市', '1168', '1');
INSERT INTO `bbs_area` VALUES ('1246', '新罗区', '1245', '1');
INSERT INTO `bbs_area` VALUES ('1247', '长汀县', '1245', '1');
INSERT INTO `bbs_area` VALUES ('1248', '永定县', '1245', '1');
INSERT INTO `bbs_area` VALUES ('1249', '上杭县', '1245', '1');
INSERT INTO `bbs_area` VALUES ('1250', '武平县', '1245', '1');
INSERT INTO `bbs_area` VALUES ('1251', '连城县', '1245', '1');
INSERT INTO `bbs_area` VALUES ('1252', '漳平市', '1245', '1');
INSERT INTO `bbs_area` VALUES ('1253', '宁德市', '1168', '1');
INSERT INTO `bbs_area` VALUES ('1254', '蕉城区', '1253', '1');
INSERT INTO `bbs_area` VALUES ('1255', '霞浦县', '1253', '1');
INSERT INTO `bbs_area` VALUES ('1256', '古田县', '1253', '1');
INSERT INTO `bbs_area` VALUES ('1257', '屏南县', '1253', '1');
INSERT INTO `bbs_area` VALUES ('1258', '寿宁县', '1253', '1');
INSERT INTO `bbs_area` VALUES ('1259', '周宁县', '1253', '1');
INSERT INTO `bbs_area` VALUES ('1260', '柘荣县', '1253', '1');
INSERT INTO `bbs_area` VALUES ('1261', '福安市', '1253', '1');
INSERT INTO `bbs_area` VALUES ('1262', '福鼎市', '1253', '1');
INSERT INTO `bbs_area` VALUES ('1263', '江西', '0', '1');
INSERT INTO `bbs_area` VALUES ('1264', '南昌市', '1263', '1');
INSERT INTO `bbs_area` VALUES ('1265', '东湖区', '1264', '1');
INSERT INTO `bbs_area` VALUES ('1266', '西湖区', '1264', '1');
INSERT INTO `bbs_area` VALUES ('1267', '青云谱区', '1264', '1');
INSERT INTO `bbs_area` VALUES ('1268', '湾里区', '1264', '1');
INSERT INTO `bbs_area` VALUES ('1269', '青山湖区', '1264', '1');
INSERT INTO `bbs_area` VALUES ('1270', '南昌县', '1264', '1');
INSERT INTO `bbs_area` VALUES ('1271', '新建县', '1264', '1');
INSERT INTO `bbs_area` VALUES ('1272', '安义县', '1264', '1');
INSERT INTO `bbs_area` VALUES ('1273', '进贤县', '1264', '1');
INSERT INTO `bbs_area` VALUES ('1274', '景德镇市', '1263', '1');
INSERT INTO `bbs_area` VALUES ('1275', '昌江区', '1274', '1');
INSERT INTO `bbs_area` VALUES ('1276', '珠山区', '1274', '1');
INSERT INTO `bbs_area` VALUES ('1277', '浮梁县', '1274', '1');
INSERT INTO `bbs_area` VALUES ('1278', '乐平市', '1274', '1');
INSERT INTO `bbs_area` VALUES ('1279', '萍乡市', '1263', '1');
INSERT INTO `bbs_area` VALUES ('1280', '安源区', '1279', '1');
INSERT INTO `bbs_area` VALUES ('1281', '湘东区', '1279', '1');
INSERT INTO `bbs_area` VALUES ('1282', '莲花县', '1279', '1');
INSERT INTO `bbs_area` VALUES ('1283', '上栗县', '1279', '1');
INSERT INTO `bbs_area` VALUES ('1284', '芦溪县', '1279', '1');
INSERT INTO `bbs_area` VALUES ('1285', '九江市', '1263', '1');
INSERT INTO `bbs_area` VALUES ('1286', '庐山区', '1285', '1');
INSERT INTO `bbs_area` VALUES ('1287', '浔阳区', '1285', '1');
INSERT INTO `bbs_area` VALUES ('1288', '九江县', '1285', '1');
INSERT INTO `bbs_area` VALUES ('1289', '武宁县', '1285', '1');
INSERT INTO `bbs_area` VALUES ('1290', '修水县', '1285', '1');
INSERT INTO `bbs_area` VALUES ('1291', '永修县', '1285', '1');
INSERT INTO `bbs_area` VALUES ('1292', '德安县', '1285', '1');
INSERT INTO `bbs_area` VALUES ('1293', '星子县', '1285', '1');
INSERT INTO `bbs_area` VALUES ('1294', '都昌县', '1285', '1');
INSERT INTO `bbs_area` VALUES ('1295', '湖口县', '1285', '1');
INSERT INTO `bbs_area` VALUES ('1296', '彭泽县', '1285', '1');
INSERT INTO `bbs_area` VALUES ('1297', '瑞昌市', '1285', '1');
INSERT INTO `bbs_area` VALUES ('1298', '新余市', '1263', '1');
INSERT INTO `bbs_area` VALUES ('1299', '渝水区', '1298', '1');
INSERT INTO `bbs_area` VALUES ('1300', '分宜县', '1298', '1');
INSERT INTO `bbs_area` VALUES ('1301', '鹰潭市', '1263', '1');
INSERT INTO `bbs_area` VALUES ('1302', '月湖区', '1301', '1');
INSERT INTO `bbs_area` VALUES ('1303', '余江县', '1301', '1');
INSERT INTO `bbs_area` VALUES ('1304', '贵溪市', '1301', '1');
INSERT INTO `bbs_area` VALUES ('1305', '赣州市', '1263', '1');
INSERT INTO `bbs_area` VALUES ('1306', '章贡区', '1305', '1');
INSERT INTO `bbs_area` VALUES ('1307', '赣县', '1305', '1');
INSERT INTO `bbs_area` VALUES ('1308', '信丰县', '1305', '1');
INSERT INTO `bbs_area` VALUES ('1309', '大余县', '1305', '1');
INSERT INTO `bbs_area` VALUES ('1310', '上犹县', '1305', '1');
INSERT INTO `bbs_area` VALUES ('1311', '崇义县', '1305', '1');
INSERT INTO `bbs_area` VALUES ('1312', '安远县', '1305', '1');
INSERT INTO `bbs_area` VALUES ('1313', '龙南县', '1305', '1');
INSERT INTO `bbs_area` VALUES ('1314', '定南县', '1305', '1');
INSERT INTO `bbs_area` VALUES ('1315', '全南县', '1305', '1');
INSERT INTO `bbs_area` VALUES ('1316', '宁都县', '1305', '1');
INSERT INTO `bbs_area` VALUES ('1317', '于都县', '1305', '1');
INSERT INTO `bbs_area` VALUES ('1318', '兴国县', '1305', '1');
INSERT INTO `bbs_area` VALUES ('1319', '会昌县', '1305', '1');
INSERT INTO `bbs_area` VALUES ('1320', '寻乌县', '1305', '1');
INSERT INTO `bbs_area` VALUES ('1321', '石城县', '1305', '1');
INSERT INTO `bbs_area` VALUES ('1322', '瑞金市', '1305', '1');
INSERT INTO `bbs_area` VALUES ('1323', '南康市', '1305', '1');
INSERT INTO `bbs_area` VALUES ('1324', '吉安市', '1263', '1');
INSERT INTO `bbs_area` VALUES ('1325', '吉州区', '1324', '1');
INSERT INTO `bbs_area` VALUES ('1326', '青原区', '1324', '1');
INSERT INTO `bbs_area` VALUES ('1327', '吉安县', '1324', '1');
INSERT INTO `bbs_area` VALUES ('1328', '吉水县', '1324', '1');
INSERT INTO `bbs_area` VALUES ('1329', '峡江县', '1324', '1');
INSERT INTO `bbs_area` VALUES ('1330', '新干县', '1324', '1');
INSERT INTO `bbs_area` VALUES ('1331', '永丰县', '1324', '1');
INSERT INTO `bbs_area` VALUES ('1332', '泰和县', '1324', '1');
INSERT INTO `bbs_area` VALUES ('1333', '遂川县', '1324', '1');
INSERT INTO `bbs_area` VALUES ('1334', '万安县', '1324', '1');
INSERT INTO `bbs_area` VALUES ('1335', '安福县', '1324', '1');
INSERT INTO `bbs_area` VALUES ('1336', '永新县', '1324', '1');
INSERT INTO `bbs_area` VALUES ('1337', '井冈山市', '1324', '1');
INSERT INTO `bbs_area` VALUES ('1338', '宜春市', '1263', '1');
INSERT INTO `bbs_area` VALUES ('1339', '袁州区', '1338', '1');
INSERT INTO `bbs_area` VALUES ('1340', '奉新县', '1338', '1');
INSERT INTO `bbs_area` VALUES ('1341', '万载县', '1338', '1');
INSERT INTO `bbs_area` VALUES ('1342', '上高县', '1338', '1');
INSERT INTO `bbs_area` VALUES ('1343', '宜丰县', '1338', '1');
INSERT INTO `bbs_area` VALUES ('1344', '靖安县', '1338', '1');
INSERT INTO `bbs_area` VALUES ('1345', '铜鼓县', '1338', '1');
INSERT INTO `bbs_area` VALUES ('1346', '丰城市', '1338', '1');
INSERT INTO `bbs_area` VALUES ('1347', '樟树市', '1338', '1');
INSERT INTO `bbs_area` VALUES ('1348', '高安市', '1338', '1');
INSERT INTO `bbs_area` VALUES ('1349', '抚州市', '1263', '1');
INSERT INTO `bbs_area` VALUES ('1350', '临川区', '1349', '1');
INSERT INTO `bbs_area` VALUES ('1351', '南城县', '1349', '1');
INSERT INTO `bbs_area` VALUES ('1352', '黎川县', '1349', '1');
INSERT INTO `bbs_area` VALUES ('1353', '南丰县', '1349', '1');
INSERT INTO `bbs_area` VALUES ('1354', '崇仁县', '1349', '1');
INSERT INTO `bbs_area` VALUES ('1355', '乐安县', '1349', '1');
INSERT INTO `bbs_area` VALUES ('1356', '宜黄县', '1349', '1');
INSERT INTO `bbs_area` VALUES ('1357', '金溪县', '1349', '1');
INSERT INTO `bbs_area` VALUES ('1358', '资溪县', '1349', '1');
INSERT INTO `bbs_area` VALUES ('1359', '东乡县', '1349', '1');
INSERT INTO `bbs_area` VALUES ('1360', '广昌县', '1349', '1');
INSERT INTO `bbs_area` VALUES ('1361', '上饶市', '1263', '1');
INSERT INTO `bbs_area` VALUES ('1362', '信州区', '1361', '1');
INSERT INTO `bbs_area` VALUES ('1363', '上饶县', '1361', '1');
INSERT INTO `bbs_area` VALUES ('1364', '广丰县', '1361', '1');
INSERT INTO `bbs_area` VALUES ('1365', '玉山县', '1361', '1');
INSERT INTO `bbs_area` VALUES ('1366', '铅山县', '1361', '1');
INSERT INTO `bbs_area` VALUES ('1367', '横峰县', '1361', '1');
INSERT INTO `bbs_area` VALUES ('1368', '弋阳县', '1361', '1');
INSERT INTO `bbs_area` VALUES ('1369', '余干县', '1361', '1');
INSERT INTO `bbs_area` VALUES ('1370', '鄱阳县', '1361', '1');
INSERT INTO `bbs_area` VALUES ('1371', '万年县', '1361', '1');
INSERT INTO `bbs_area` VALUES ('1372', '婺源县', '1361', '1');
INSERT INTO `bbs_area` VALUES ('1373', '德兴市', '1361', '1');
INSERT INTO `bbs_area` VALUES ('1374', '山东', '0', '1');
INSERT INTO `bbs_area` VALUES ('1375', '济南市', '1374', '1');
INSERT INTO `bbs_area` VALUES ('1376', '历下区', '1375', '1');
INSERT INTO `bbs_area` VALUES ('1377', '市中区', '1375', '1');
INSERT INTO `bbs_area` VALUES ('1378', '槐荫区', '1375', '1');
INSERT INTO `bbs_area` VALUES ('1379', '天桥区', '1375', '1');
INSERT INTO `bbs_area` VALUES ('1380', '历城区', '1375', '1');
INSERT INTO `bbs_area` VALUES ('1381', '长清区', '1375', '1');
INSERT INTO `bbs_area` VALUES ('1382', '平阴县', '1375', '1');
INSERT INTO `bbs_area` VALUES ('1383', '济阳县', '1375', '1');
INSERT INTO `bbs_area` VALUES ('1384', '商河县', '1375', '1');
INSERT INTO `bbs_area` VALUES ('1385', '章丘市', '1375', '1');
INSERT INTO `bbs_area` VALUES ('1386', '青岛市', '1374', '1');
INSERT INTO `bbs_area` VALUES ('1387', '市南区', '1386', '1');
INSERT INTO `bbs_area` VALUES ('1388', '市北区', '1386', '1');
INSERT INTO `bbs_area` VALUES ('1389', '四方区', '1386', '1');
INSERT INTO `bbs_area` VALUES ('1390', '黄岛区', '1386', '1');
INSERT INTO `bbs_area` VALUES ('1391', '崂山区', '1386', '1');
INSERT INTO `bbs_area` VALUES ('1392', '李沧区', '1386', '1');
INSERT INTO `bbs_area` VALUES ('1393', '城阳区', '1386', '1');
INSERT INTO `bbs_area` VALUES ('1394', '胶州市', '1386', '1');
INSERT INTO `bbs_area` VALUES ('1395', '即墨市', '1386', '1');
INSERT INTO `bbs_area` VALUES ('1396', '平度市', '1386', '1');
INSERT INTO `bbs_area` VALUES ('1397', '胶南市', '1386', '1');
INSERT INTO `bbs_area` VALUES ('1398', '莱西市', '1386', '1');
INSERT INTO `bbs_area` VALUES ('1399', '淄博市', '1374', '1');
INSERT INTO `bbs_area` VALUES ('1400', '淄川区', '1399', '1');
INSERT INTO `bbs_area` VALUES ('1401', '张店区', '1399', '1');
INSERT INTO `bbs_area` VALUES ('1402', '博山区', '1399', '1');
INSERT INTO `bbs_area` VALUES ('1403', '临淄区', '1399', '1');
INSERT INTO `bbs_area` VALUES ('1404', '周村区', '1399', '1');
INSERT INTO `bbs_area` VALUES ('1405', '桓台县', '1399', '1');
INSERT INTO `bbs_area` VALUES ('1406', '高青县', '1399', '1');
INSERT INTO `bbs_area` VALUES ('1407', '沂源县', '1399', '1');
INSERT INTO `bbs_area` VALUES ('1408', '枣庄市', '1374', '1');
INSERT INTO `bbs_area` VALUES ('1409', '市中区', '1408', '1');
INSERT INTO `bbs_area` VALUES ('1410', '薛城区', '1408', '1');
INSERT INTO `bbs_area` VALUES ('1411', '峄城区', '1408', '1');
INSERT INTO `bbs_area` VALUES ('1412', '台儿庄区', '1408', '1');
INSERT INTO `bbs_area` VALUES ('1413', '山亭区', '1408', '1');
INSERT INTO `bbs_area` VALUES ('1414', '滕州市', '1408', '1');
INSERT INTO `bbs_area` VALUES ('1415', '东营市', '1374', '1');
INSERT INTO `bbs_area` VALUES ('1416', '东营区', '1415', '1');
INSERT INTO `bbs_area` VALUES ('1417', '河口区', '1415', '1');
INSERT INTO `bbs_area` VALUES ('1418', '垦利县', '1415', '1');
INSERT INTO `bbs_area` VALUES ('1419', '利津县', '1415', '1');
INSERT INTO `bbs_area` VALUES ('1420', '广饶县', '1415', '1');
INSERT INTO `bbs_area` VALUES ('1421', '烟台市', '1374', '1');
INSERT INTO `bbs_area` VALUES ('1422', '芝罘区', '1421', '1');
INSERT INTO `bbs_area` VALUES ('1423', '福山区', '1421', '1');
INSERT INTO `bbs_area` VALUES ('1424', '牟平区', '1421', '1');
INSERT INTO `bbs_area` VALUES ('1425', '莱山区', '1421', '1');
INSERT INTO `bbs_area` VALUES ('1426', '长岛县', '1421', '1');
INSERT INTO `bbs_area` VALUES ('1427', '龙口市', '1421', '1');
INSERT INTO `bbs_area` VALUES ('1428', '莱阳市', '1421', '1');
INSERT INTO `bbs_area` VALUES ('1429', '莱州市', '1421', '1');
INSERT INTO `bbs_area` VALUES ('1430', '蓬莱市', '1421', '1');
INSERT INTO `bbs_area` VALUES ('1431', '招远市', '1421', '1');
INSERT INTO `bbs_area` VALUES ('1432', '栖霞市', '1421', '1');
INSERT INTO `bbs_area` VALUES ('1433', '海阳市', '1421', '1');
INSERT INTO `bbs_area` VALUES ('1434', '潍坊市', '1374', '1');
INSERT INTO `bbs_area` VALUES ('1435', '潍城区', '1434', '1');
INSERT INTO `bbs_area` VALUES ('1436', '寒亭区', '1434', '1');
INSERT INTO `bbs_area` VALUES ('1437', '坊子区', '1434', '1');
INSERT INTO `bbs_area` VALUES ('1438', '奎文区', '1434', '1');
INSERT INTO `bbs_area` VALUES ('1439', '临朐县', '1434', '1');
INSERT INTO `bbs_area` VALUES ('1440', '昌乐县', '1434', '1');
INSERT INTO `bbs_area` VALUES ('1441', '青州市', '1434', '1');
INSERT INTO `bbs_area` VALUES ('1442', '诸城市', '1434', '1');
INSERT INTO `bbs_area` VALUES ('1443', '寿光市', '1434', '1');
INSERT INTO `bbs_area` VALUES ('1444', '安丘市', '1434', '1');
INSERT INTO `bbs_area` VALUES ('1445', '高密市', '1434', '1');
INSERT INTO `bbs_area` VALUES ('1446', '昌邑市', '1434', '1');
INSERT INTO `bbs_area` VALUES ('1447', '济宁市', '1374', '1');
INSERT INTO `bbs_area` VALUES ('1448', '市中区', '1447', '1');
INSERT INTO `bbs_area` VALUES ('1449', '任城区', '1447', '1');
INSERT INTO `bbs_area` VALUES ('1450', '微山县', '1447', '1');
INSERT INTO `bbs_area` VALUES ('1451', '鱼台县', '1447', '1');
INSERT INTO `bbs_area` VALUES ('1452', '金乡县', '1447', '1');
INSERT INTO `bbs_area` VALUES ('1453', '嘉祥县', '1447', '1');
INSERT INTO `bbs_area` VALUES ('1454', '汶上县', '1447', '1');
INSERT INTO `bbs_area` VALUES ('1455', '泗水县', '1447', '1');
INSERT INTO `bbs_area` VALUES ('1456', '梁山县', '1447', '1');
INSERT INTO `bbs_area` VALUES ('1457', '曲阜市', '1447', '1');
INSERT INTO `bbs_area` VALUES ('1458', '兖州市', '1447', '1');
INSERT INTO `bbs_area` VALUES ('1459', '邹城市', '1447', '1');
INSERT INTO `bbs_area` VALUES ('1460', '泰安市', '1374', '1');
INSERT INTO `bbs_area` VALUES ('1461', '泰山区', '1460', '1');
INSERT INTO `bbs_area` VALUES ('1462', '岱岳区', '1460', '1');
INSERT INTO `bbs_area` VALUES ('1463', '宁阳县', '1460', '1');
INSERT INTO `bbs_area` VALUES ('1464', '东平县', '1460', '1');
INSERT INTO `bbs_area` VALUES ('1465', '新泰市', '1460', '1');
INSERT INTO `bbs_area` VALUES ('1466', '肥城市', '1460', '1');
INSERT INTO `bbs_area` VALUES ('1467', '威海市', '1374', '1');
INSERT INTO `bbs_area` VALUES ('1468', '环翠区', '1467', '1');
INSERT INTO `bbs_area` VALUES ('1469', '文登市', '1467', '1');
INSERT INTO `bbs_area` VALUES ('1470', '荣成市', '1467', '1');
INSERT INTO `bbs_area` VALUES ('1471', '乳山市', '1467', '1');
INSERT INTO `bbs_area` VALUES ('1472', '日照市', '1374', '1');
INSERT INTO `bbs_area` VALUES ('1473', '东港区', '1472', '1');
INSERT INTO `bbs_area` VALUES ('1474', '岚山区', '1472', '1');
INSERT INTO `bbs_area` VALUES ('1475', '五莲县', '1472', '1');
INSERT INTO `bbs_area` VALUES ('1476', '莒县', '1472', '1');
INSERT INTO `bbs_area` VALUES ('1477', '莱芜市', '1374', '1');
INSERT INTO `bbs_area` VALUES ('1478', '莱城区', '1477', '1');
INSERT INTO `bbs_area` VALUES ('1479', '钢城区', '1477', '1');
INSERT INTO `bbs_area` VALUES ('1480', '临沂市', '1374', '1');
INSERT INTO `bbs_area` VALUES ('1481', '兰山区', '1480', '1');
INSERT INTO `bbs_area` VALUES ('1482', '罗庄区', '1480', '1');
INSERT INTO `bbs_area` VALUES ('1483', '河东区', '1480', '1');
INSERT INTO `bbs_area` VALUES ('1484', '沂南县', '1480', '1');
INSERT INTO `bbs_area` VALUES ('1485', '郯城县', '1480', '1');
INSERT INTO `bbs_area` VALUES ('1486', '沂水县', '1480', '1');
INSERT INTO `bbs_area` VALUES ('1487', '苍山县', '1480', '1');
INSERT INTO `bbs_area` VALUES ('1488', '费县', '1480', '1');
INSERT INTO `bbs_area` VALUES ('1489', '平邑县', '1480', '1');
INSERT INTO `bbs_area` VALUES ('1490', '莒南县', '1480', '1');
INSERT INTO `bbs_area` VALUES ('1491', '蒙阴县', '1480', '1');
INSERT INTO `bbs_area` VALUES ('1492', '临沭县', '1480', '1');
INSERT INTO `bbs_area` VALUES ('1493', '德州市', '1374', '1');
INSERT INTO `bbs_area` VALUES ('1494', '德城区', '1493', '1');
INSERT INTO `bbs_area` VALUES ('1495', '陵县', '1493', '1');
INSERT INTO `bbs_area` VALUES ('1496', '宁津县', '1493', '1');
INSERT INTO `bbs_area` VALUES ('1497', '庆云县', '1493', '1');
INSERT INTO `bbs_area` VALUES ('1498', '临邑县', '1493', '1');
INSERT INTO `bbs_area` VALUES ('1499', '齐河县', '1493', '1');
INSERT INTO `bbs_area` VALUES ('1500', '平原县', '1493', '1');
INSERT INTO `bbs_area` VALUES ('1501', '夏津县', '1493', '1');
INSERT INTO `bbs_area` VALUES ('1502', '武城县', '1493', '1');
INSERT INTO `bbs_area` VALUES ('1503', '乐陵市', '1493', '1');
INSERT INTO `bbs_area` VALUES ('1504', '禹城市', '1493', '1');
INSERT INTO `bbs_area` VALUES ('1505', '聊城市', '1374', '1');
INSERT INTO `bbs_area` VALUES ('1506', '东昌府区', '1505', '1');
INSERT INTO `bbs_area` VALUES ('1507', '阳谷县', '1505', '1');
INSERT INTO `bbs_area` VALUES ('1508', '莘县', '1505', '1');
INSERT INTO `bbs_area` VALUES ('1509', '茌平县', '1505', '1');
INSERT INTO `bbs_area` VALUES ('1510', '东阿县', '1505', '1');
INSERT INTO `bbs_area` VALUES ('1511', '冠县', '1505', '1');
INSERT INTO `bbs_area` VALUES ('1512', '高唐县', '1505', '1');
INSERT INTO `bbs_area` VALUES ('1513', '临清市', '1505', '1');
INSERT INTO `bbs_area` VALUES ('1514', '滨州市', '1374', '1');
INSERT INTO `bbs_area` VALUES ('1515', '滨城区', '1514', '1');
INSERT INTO `bbs_area` VALUES ('1516', '惠民县', '1514', '1');
INSERT INTO `bbs_area` VALUES ('1517', '阳信县', '1514', '1');
INSERT INTO `bbs_area` VALUES ('1518', '无棣县', '1514', '1');
INSERT INTO `bbs_area` VALUES ('1519', '沾化县', '1514', '1');
INSERT INTO `bbs_area` VALUES ('1520', '博兴县', '1514', '1');
INSERT INTO `bbs_area` VALUES ('1521', '邹平县', '1514', '1');
INSERT INTO `bbs_area` VALUES ('1522', '菏泽市', '1374', '1');
INSERT INTO `bbs_area` VALUES ('1523', '牡丹区', '1522', '1');
INSERT INTO `bbs_area` VALUES ('1524', '曹县', '1522', '1');
INSERT INTO `bbs_area` VALUES ('1525', '单县', '1522', '1');
INSERT INTO `bbs_area` VALUES ('1526', '成武县', '1522', '1');
INSERT INTO `bbs_area` VALUES ('1527', '巨野县', '1522', '1');
INSERT INTO `bbs_area` VALUES ('1528', '郓城县', '1522', '1');
INSERT INTO `bbs_area` VALUES ('1529', '鄄城县', '1522', '1');
INSERT INTO `bbs_area` VALUES ('1530', '定陶县', '1522', '1');
INSERT INTO `bbs_area` VALUES ('1531', '东明县', '1522', '1');
INSERT INTO `bbs_area` VALUES ('1532', '河南', '0', '1');
INSERT INTO `bbs_area` VALUES ('1533', '郑州市', '1532', '1');
INSERT INTO `bbs_area` VALUES ('1534', '中原区', '1533', '1');
INSERT INTO `bbs_area` VALUES ('1535', '二七区', '1533', '1');
INSERT INTO `bbs_area` VALUES ('1536', '管城回族区', '1533', '1');
INSERT INTO `bbs_area` VALUES ('1537', '金水区', '1533', '1');
INSERT INTO `bbs_area` VALUES ('1538', '上街区', '1533', '1');
INSERT INTO `bbs_area` VALUES ('1539', '惠济区', '1533', '1');
INSERT INTO `bbs_area` VALUES ('1540', '中牟县', '1533', '1');
INSERT INTO `bbs_area` VALUES ('1541', '巩义市', '1533', '1');
INSERT INTO `bbs_area` VALUES ('1542', '荥阳市', '1533', '1');
INSERT INTO `bbs_area` VALUES ('1543', '新密市', '1533', '1');
INSERT INTO `bbs_area` VALUES ('1544', '新郑市', '1533', '1');
INSERT INTO `bbs_area` VALUES ('1545', '登封市', '1533', '1');
INSERT INTO `bbs_area` VALUES ('1546', '开封市', '1532', '1');
INSERT INTO `bbs_area` VALUES ('1547', '龙亭区', '1546', '1');
INSERT INTO `bbs_area` VALUES ('1548', '顺河回族区', '1546', '1');
INSERT INTO `bbs_area` VALUES ('1549', '鼓楼区', '1546', '1');
INSERT INTO `bbs_area` VALUES ('1550', '禹王台区', '1546', '1');
INSERT INTO `bbs_area` VALUES ('1551', '金明区', '1546', '1');
INSERT INTO `bbs_area` VALUES ('1552', '杞县', '1546', '1');
INSERT INTO `bbs_area` VALUES ('1553', '通许县', '1546', '1');
INSERT INTO `bbs_area` VALUES ('1554', '尉氏县', '1546', '1');
INSERT INTO `bbs_area` VALUES ('1555', '开封县', '1546', '1');
INSERT INTO `bbs_area` VALUES ('1556', '兰考县', '1546', '1');
INSERT INTO `bbs_area` VALUES ('1557', '洛阳市', '1532', '1');
INSERT INTO `bbs_area` VALUES ('1558', '老城区', '1557', '1');
INSERT INTO `bbs_area` VALUES ('1559', '西工区', '1557', '1');
INSERT INTO `bbs_area` VALUES ('1560', '瀍河回族区', '1557', '1');
INSERT INTO `bbs_area` VALUES ('1561', '涧西区', '1557', '1');
INSERT INTO `bbs_area` VALUES ('1562', '吉利区', '1557', '1');
INSERT INTO `bbs_area` VALUES ('1563', '洛龙区', '1557', '1');
INSERT INTO `bbs_area` VALUES ('1564', '孟津县', '1557', '1');
INSERT INTO `bbs_area` VALUES ('1565', '新安县', '1557', '1');
INSERT INTO `bbs_area` VALUES ('1566', '栾川县', '1557', '1');
INSERT INTO `bbs_area` VALUES ('1567', '嵩县', '1557', '1');
INSERT INTO `bbs_area` VALUES ('1568', '汝阳县', '1557', '1');
INSERT INTO `bbs_area` VALUES ('1569', '宜阳县', '1557', '1');
INSERT INTO `bbs_area` VALUES ('1570', '洛宁县', '1557', '1');
INSERT INTO `bbs_area` VALUES ('1571', '伊川县', '1557', '1');
INSERT INTO `bbs_area` VALUES ('1572', '偃师市', '1557', '1');
INSERT INTO `bbs_area` VALUES ('1573', '平顶山市', '1532', '1');
INSERT INTO `bbs_area` VALUES ('1574', '新华区', '1573', '1');
INSERT INTO `bbs_area` VALUES ('1575', '卫东区', '1573', '1');
INSERT INTO `bbs_area` VALUES ('1576', '石龙区', '1573', '1');
INSERT INTO `bbs_area` VALUES ('1577', '湛河区', '1573', '1');
INSERT INTO `bbs_area` VALUES ('1578', '宝丰县', '1573', '1');
INSERT INTO `bbs_area` VALUES ('1579', '叶县', '1573', '1');
INSERT INTO `bbs_area` VALUES ('1580', '鲁山县', '1573', '1');
INSERT INTO `bbs_area` VALUES ('1581', '郏县', '1573', '1');
INSERT INTO `bbs_area` VALUES ('1582', '舞钢市', '1573', '1');
INSERT INTO `bbs_area` VALUES ('1583', '汝州市', '1573', '1');
INSERT INTO `bbs_area` VALUES ('1584', '安阳市', '1532', '1');
INSERT INTO `bbs_area` VALUES ('1585', '文峰区', '1584', '1');
INSERT INTO `bbs_area` VALUES ('1586', '北关区', '1584', '1');
INSERT INTO `bbs_area` VALUES ('1587', '殷都区', '1584', '1');
INSERT INTO `bbs_area` VALUES ('1588', '龙安区', '1584', '1');
INSERT INTO `bbs_area` VALUES ('1589', '安阳县', '1584', '1');
INSERT INTO `bbs_area` VALUES ('1590', '汤阴县', '1584', '1');
INSERT INTO `bbs_area` VALUES ('1591', '滑县', '1584', '1');
INSERT INTO `bbs_area` VALUES ('1592', '内黄县', '1584', '1');
INSERT INTO `bbs_area` VALUES ('1593', '林州市', '1584', '1');
INSERT INTO `bbs_area` VALUES ('1594', '鹤壁市', '1532', '1');
INSERT INTO `bbs_area` VALUES ('1595', '鹤山区', '1594', '1');
INSERT INTO `bbs_area` VALUES ('1596', '山城区', '1594', '1');
INSERT INTO `bbs_area` VALUES ('1597', '淇滨区', '1594', '1');
INSERT INTO `bbs_area` VALUES ('1598', '浚县', '1594', '1');
INSERT INTO `bbs_area` VALUES ('1599', '淇县', '1594', '1');
INSERT INTO `bbs_area` VALUES ('1600', '新乡市', '1532', '1');
INSERT INTO `bbs_area` VALUES ('1601', '红旗区', '1600', '1');
INSERT INTO `bbs_area` VALUES ('1602', '卫滨区', '1600', '1');
INSERT INTO `bbs_area` VALUES ('1603', '凤泉区', '1600', '1');
INSERT INTO `bbs_area` VALUES ('1604', '牧野区', '1600', '1');
INSERT INTO `bbs_area` VALUES ('1605', '新乡县', '1600', '1');
INSERT INTO `bbs_area` VALUES ('1606', '获嘉县', '1600', '1');
INSERT INTO `bbs_area` VALUES ('1607', '原阳县', '1600', '1');
INSERT INTO `bbs_area` VALUES ('1608', '延津县', '1600', '1');
INSERT INTO `bbs_area` VALUES ('1609', '封丘县', '1600', '1');
INSERT INTO `bbs_area` VALUES ('1610', '长垣县', '1600', '1');
INSERT INTO `bbs_area` VALUES ('1611', '卫辉市', '1600', '1');
INSERT INTO `bbs_area` VALUES ('1612', '辉县市', '1600', '1');
INSERT INTO `bbs_area` VALUES ('1613', '焦作市', '1532', '1');
INSERT INTO `bbs_area` VALUES ('1614', '解放区', '1613', '1');
INSERT INTO `bbs_area` VALUES ('1615', '中站区', '1613', '1');
INSERT INTO `bbs_area` VALUES ('1616', '马村区', '1613', '1');
INSERT INTO `bbs_area` VALUES ('1617', '山阳区', '1613', '1');
INSERT INTO `bbs_area` VALUES ('1618', '修武县', '1613', '1');
INSERT INTO `bbs_area` VALUES ('1619', '博爱县', '1613', '1');
INSERT INTO `bbs_area` VALUES ('1620', '武陟县', '1613', '1');
INSERT INTO `bbs_area` VALUES ('1621', '温县', '1613', '1');
INSERT INTO `bbs_area` VALUES ('1622', '济源市', '1613', '1');
INSERT INTO `bbs_area` VALUES ('1623', '沁阳市', '1613', '1');
INSERT INTO `bbs_area` VALUES ('1624', '孟州市', '1613', '1');
INSERT INTO `bbs_area` VALUES ('1625', '濮阳市', '1532', '1');
INSERT INTO `bbs_area` VALUES ('1626', '华龙区', '1625', '1');
INSERT INTO `bbs_area` VALUES ('1627', '清丰县', '1625', '1');
INSERT INTO `bbs_area` VALUES ('1628', '南乐县', '1625', '1');
INSERT INTO `bbs_area` VALUES ('1629', '范县', '1625', '1');
INSERT INTO `bbs_area` VALUES ('1630', '台前县', '1625', '1');
INSERT INTO `bbs_area` VALUES ('1631', '濮阳县', '1625', '1');
INSERT INTO `bbs_area` VALUES ('1632', '许昌市', '1532', '1');
INSERT INTO `bbs_area` VALUES ('1633', '魏都区', '1632', '1');
INSERT INTO `bbs_area` VALUES ('1634', '许昌县', '1632', '1');
INSERT INTO `bbs_area` VALUES ('1635', '鄢陵县', '1632', '1');
INSERT INTO `bbs_area` VALUES ('1636', '襄城县', '1632', '1');
INSERT INTO `bbs_area` VALUES ('1637', '禹州市', '1632', '1');
INSERT INTO `bbs_area` VALUES ('1638', '长葛市', '1632', '1');
INSERT INTO `bbs_area` VALUES ('1639', '漯河市', '1532', '1');
INSERT INTO `bbs_area` VALUES ('1640', '源汇区', '1639', '1');
INSERT INTO `bbs_area` VALUES ('1641', '郾城区', '1639', '1');
INSERT INTO `bbs_area` VALUES ('1642', '召陵区', '1639', '1');
INSERT INTO `bbs_area` VALUES ('1643', '舞阳县', '1639', '1');
INSERT INTO `bbs_area` VALUES ('1644', '临颍县', '1639', '1');
INSERT INTO `bbs_area` VALUES ('1645', '三门峡市', '1532', '1');
INSERT INTO `bbs_area` VALUES ('1646', '湖滨区', '1645', '1');
INSERT INTO `bbs_area` VALUES ('1647', '渑池县', '1645', '1');
INSERT INTO `bbs_area` VALUES ('1648', '陕县', '1645', '1');
INSERT INTO `bbs_area` VALUES ('1649', '卢氏县', '1645', '1');
INSERT INTO `bbs_area` VALUES ('1650', '义马市', '1645', '1');
INSERT INTO `bbs_area` VALUES ('1651', '灵宝市', '1645', '1');
INSERT INTO `bbs_area` VALUES ('1652', '南阳市', '1532', '1');
INSERT INTO `bbs_area` VALUES ('1653', '宛城区', '1652', '1');
INSERT INTO `bbs_area` VALUES ('1654', '卧龙区', '1652', '1');
INSERT INTO `bbs_area` VALUES ('1655', '南召县', '1652', '1');
INSERT INTO `bbs_area` VALUES ('1656', '方城县', '1652', '1');
INSERT INTO `bbs_area` VALUES ('1657', '西峡县', '1652', '1');
INSERT INTO `bbs_area` VALUES ('1658', '镇平县', '1652', '1');
INSERT INTO `bbs_area` VALUES ('1659', '内乡县', '1652', '1');
INSERT INTO `bbs_area` VALUES ('1660', '淅川县', '1652', '1');
INSERT INTO `bbs_area` VALUES ('1661', '社旗县', '1652', '1');
INSERT INTO `bbs_area` VALUES ('1662', '唐河县', '1652', '1');
INSERT INTO `bbs_area` VALUES ('1663', '新野县', '1652', '1');
INSERT INTO `bbs_area` VALUES ('1664', '桐柏县', '1652', '1');
INSERT INTO `bbs_area` VALUES ('1665', '邓州市', '1652', '1');
INSERT INTO `bbs_area` VALUES ('1666', '商丘市', '1532', '1');
INSERT INTO `bbs_area` VALUES ('1667', '梁园区', '1666', '1');
INSERT INTO `bbs_area` VALUES ('1668', '睢阳区', '1666', '1');
INSERT INTO `bbs_area` VALUES ('1669', '民权县', '1666', '1');
INSERT INTO `bbs_area` VALUES ('1670', '睢县', '1666', '1');
INSERT INTO `bbs_area` VALUES ('1671', '宁陵县', '1666', '1');
INSERT INTO `bbs_area` VALUES ('1672', '柘城县', '1666', '1');
INSERT INTO `bbs_area` VALUES ('1673', '虞城县', '1666', '1');
INSERT INTO `bbs_area` VALUES ('1674', '夏邑县', '1666', '1');
INSERT INTO `bbs_area` VALUES ('1675', '永城市', '1666', '1');
INSERT INTO `bbs_area` VALUES ('1676', '信阳市', '1532', '1');
INSERT INTO `bbs_area` VALUES ('1677', '浉河区', '1676', '1');
INSERT INTO `bbs_area` VALUES ('1678', '平桥区', '1676', '1');
INSERT INTO `bbs_area` VALUES ('1679', '罗山县', '1676', '1');
INSERT INTO `bbs_area` VALUES ('1680', '光山县', '1676', '1');
INSERT INTO `bbs_area` VALUES ('1681', '新县', '1676', '1');
INSERT INTO `bbs_area` VALUES ('1682', '商城县', '1676', '1');
INSERT INTO `bbs_area` VALUES ('1683', '固始县', '1676', '1');
INSERT INTO `bbs_area` VALUES ('1684', '潢川县', '1676', '1');
INSERT INTO `bbs_area` VALUES ('1685', '淮滨县', '1676', '1');
INSERT INTO `bbs_area` VALUES ('1686', '息县', '1676', '1');
INSERT INTO `bbs_area` VALUES ('1687', '周口市', '1532', '1');
INSERT INTO `bbs_area` VALUES ('1688', '川汇区', '1687', '1');
INSERT INTO `bbs_area` VALUES ('1689', '扶沟县', '1687', '1');
INSERT INTO `bbs_area` VALUES ('1690', '西华县', '1687', '1');
INSERT INTO `bbs_area` VALUES ('1691', '商水县', '1687', '1');
INSERT INTO `bbs_area` VALUES ('1692', '沈丘县', '1687', '1');
INSERT INTO `bbs_area` VALUES ('1693', '郸城县', '1687', '1');
INSERT INTO `bbs_area` VALUES ('1694', '淮阳县', '1687', '1');
INSERT INTO `bbs_area` VALUES ('1695', '太康县', '1687', '1');
INSERT INTO `bbs_area` VALUES ('1696', '鹿邑县', '1687', '1');
INSERT INTO `bbs_area` VALUES ('1697', '项城市', '1687', '1');
INSERT INTO `bbs_area` VALUES ('1698', '驻马店市', '1532', '1');
INSERT INTO `bbs_area` VALUES ('1699', '驿城区', '1698', '1');
INSERT INTO `bbs_area` VALUES ('1700', '西平县', '1698', '1');
INSERT INTO `bbs_area` VALUES ('1701', '上蔡县', '1698', '1');
INSERT INTO `bbs_area` VALUES ('1702', '平舆县', '1698', '1');
INSERT INTO `bbs_area` VALUES ('1703', '正阳县', '1698', '1');
INSERT INTO `bbs_area` VALUES ('1704', '确山县', '1698', '1');
INSERT INTO `bbs_area` VALUES ('1705', '泌阳县', '1698', '1');
INSERT INTO `bbs_area` VALUES ('1706', '汝南县', '1698', '1');
INSERT INTO `bbs_area` VALUES ('1707', '遂平县', '1698', '1');
INSERT INTO `bbs_area` VALUES ('1708', '新蔡县', '1698', '1');
INSERT INTO `bbs_area` VALUES ('1709', '湖北', '0', '1');
INSERT INTO `bbs_area` VALUES ('1710', '武汉市', '1709', '1');
INSERT INTO `bbs_area` VALUES ('1711', '江岸区', '1710', '1');
INSERT INTO `bbs_area` VALUES ('1712', '江汉区', '1710', '1');
INSERT INTO `bbs_area` VALUES ('1713', '硚口区', '1710', '1');
INSERT INTO `bbs_area` VALUES ('1714', '汉阳区', '1710', '1');
INSERT INTO `bbs_area` VALUES ('1715', '武昌区', '1710', '1');
INSERT INTO `bbs_area` VALUES ('1716', '青山区', '1710', '1');
INSERT INTO `bbs_area` VALUES ('1717', '洪山区', '1710', '1');
INSERT INTO `bbs_area` VALUES ('1718', '东西湖区', '1710', '1');
INSERT INTO `bbs_area` VALUES ('1719', '汉南区', '1710', '1');
INSERT INTO `bbs_area` VALUES ('1720', '蔡甸区', '1710', '1');
INSERT INTO `bbs_area` VALUES ('1721', '江夏区', '1710', '1');
INSERT INTO `bbs_area` VALUES ('1722', '黄陂区', '1710', '1');
INSERT INTO `bbs_area` VALUES ('1723', '新洲区', '1710', '1');
INSERT INTO `bbs_area` VALUES ('1724', '黄石市', '1709', '1');
INSERT INTO `bbs_area` VALUES ('1725', '黄石港区', '1724', '1');
INSERT INTO `bbs_area` VALUES ('1726', '西塞山区', '1724', '1');
INSERT INTO `bbs_area` VALUES ('1727', '下陆区', '1724', '1');
INSERT INTO `bbs_area` VALUES ('1728', '铁山区', '1724', '1');
INSERT INTO `bbs_area` VALUES ('1729', '阳新县', '1724', '1');
INSERT INTO `bbs_area` VALUES ('1730', '大冶市', '1724', '1');
INSERT INTO `bbs_area` VALUES ('1731', '十堰市', '1709', '1');
INSERT INTO `bbs_area` VALUES ('1732', '茅箭区', '1731', '1');
INSERT INTO `bbs_area` VALUES ('1733', '张湾区', '1731', '1');
INSERT INTO `bbs_area` VALUES ('1734', '郧县', '1731', '1');
INSERT INTO `bbs_area` VALUES ('1735', '郧西县', '1731', '1');
INSERT INTO `bbs_area` VALUES ('1736', '竹山县', '1731', '1');
INSERT INTO `bbs_area` VALUES ('1737', '竹溪县', '1731', '1');
INSERT INTO `bbs_area` VALUES ('1738', '房县', '1731', '1');
INSERT INTO `bbs_area` VALUES ('1739', '丹江口市', '1731', '1');
INSERT INTO `bbs_area` VALUES ('1740', '宜昌市', '1709', '1');
INSERT INTO `bbs_area` VALUES ('1741', '西陵区', '1740', '1');
INSERT INTO `bbs_area` VALUES ('1742', '伍家岗区', '1740', '1');
INSERT INTO `bbs_area` VALUES ('1743', '点军区', '1740', '1');
INSERT INTO `bbs_area` VALUES ('1744', '猇亭区', '1740', '1');
INSERT INTO `bbs_area` VALUES ('1745', '夷陵区', '1740', '1');
INSERT INTO `bbs_area` VALUES ('1746', '远安县', '1740', '1');
INSERT INTO `bbs_area` VALUES ('1747', '兴山县', '1740', '1');
INSERT INTO `bbs_area` VALUES ('1748', '秭归县', '1740', '1');
INSERT INTO `bbs_area` VALUES ('1749', '长阳土家族自治县', '1740', '1');
INSERT INTO `bbs_area` VALUES ('1750', '五峰土家族自治县', '1740', '1');
INSERT INTO `bbs_area` VALUES ('1751', '宜都市', '1740', '1');
INSERT INTO `bbs_area` VALUES ('1752', '当阳市', '1740', '1');
INSERT INTO `bbs_area` VALUES ('1753', '枝江市', '1740', '1');
INSERT INTO `bbs_area` VALUES ('1754', '襄阳市', '1709', '1');
INSERT INTO `bbs_area` VALUES ('1755', '襄城区', '1754', '1');
INSERT INTO `bbs_area` VALUES ('1756', '樊城区', '1754', '1');
INSERT INTO `bbs_area` VALUES ('1757', '襄阳区', '1754', '1');
INSERT INTO `bbs_area` VALUES ('1758', '南漳县', '1754', '1');
INSERT INTO `bbs_area` VALUES ('1759', '谷城县', '1754', '1');
INSERT INTO `bbs_area` VALUES ('1760', '保康县', '1754', '1');
INSERT INTO `bbs_area` VALUES ('1761', '老河口市', '1754', '1');
INSERT INTO `bbs_area` VALUES ('1762', '枣阳市', '1754', '1');
INSERT INTO `bbs_area` VALUES ('1763', '宜城市', '1754', '1');
INSERT INTO `bbs_area` VALUES ('1764', '鄂州市', '1709', '1');
INSERT INTO `bbs_area` VALUES ('1765', '梁子湖区', '1764', '1');
INSERT INTO `bbs_area` VALUES ('1766', '华容区', '1764', '1');
INSERT INTO `bbs_area` VALUES ('1767', '鄂城区', '1764', '1');
INSERT INTO `bbs_area` VALUES ('1768', '荆门市', '1709', '1');
INSERT INTO `bbs_area` VALUES ('1769', '东宝区', '1768', '1');
INSERT INTO `bbs_area` VALUES ('1770', '掇刀区', '1768', '1');
INSERT INTO `bbs_area` VALUES ('1771', '京山县', '1768', '1');
INSERT INTO `bbs_area` VALUES ('1772', '沙洋县', '1768', '1');
INSERT INTO `bbs_area` VALUES ('1773', '钟祥市', '1768', '1');
INSERT INTO `bbs_area` VALUES ('1774', '孝感市', '1709', '1');
INSERT INTO `bbs_area` VALUES ('1775', '孝南区', '1774', '1');
INSERT INTO `bbs_area` VALUES ('1776', '孝昌县', '1774', '1');
INSERT INTO `bbs_area` VALUES ('1777', '大悟县', '1774', '1');
INSERT INTO `bbs_area` VALUES ('1778', '云梦县', '1774', '1');
INSERT INTO `bbs_area` VALUES ('1779', '应城市', '1774', '1');
INSERT INTO `bbs_area` VALUES ('1780', '安陆市', '1774', '1');
INSERT INTO `bbs_area` VALUES ('1781', '汉川市', '1774', '1');
INSERT INTO `bbs_area` VALUES ('1782', '荆州市', '1709', '1');
INSERT INTO `bbs_area` VALUES ('1783', '沙市区', '1782', '1');
INSERT INTO `bbs_area` VALUES ('1784', '荆州区', '1782', '1');
INSERT INTO `bbs_area` VALUES ('1785', '公安县', '1782', '1');
INSERT INTO `bbs_area` VALUES ('1786', '监利县', '1782', '1');
INSERT INTO `bbs_area` VALUES ('1787', '江陵县', '1782', '1');
INSERT INTO `bbs_area` VALUES ('1788', '石首市', '1782', '1');
INSERT INTO `bbs_area` VALUES ('1789', '洪湖市', '1782', '1');
INSERT INTO `bbs_area` VALUES ('1790', '松滋市', '1782', '1');
INSERT INTO `bbs_area` VALUES ('1791', '黄冈市', '1709', '1');
INSERT INTO `bbs_area` VALUES ('1792', '黄州区', '1791', '1');
INSERT INTO `bbs_area` VALUES ('1793', '团风县', '1791', '1');
INSERT INTO `bbs_area` VALUES ('1794', '红安县', '1791', '1');
INSERT INTO `bbs_area` VALUES ('1795', '罗田县', '1791', '1');
INSERT INTO `bbs_area` VALUES ('1796', '英山县', '1791', '1');
INSERT INTO `bbs_area` VALUES ('1797', '浠水县', '1791', '1');
INSERT INTO `bbs_area` VALUES ('1798', '蕲春县', '1791', '1');
INSERT INTO `bbs_area` VALUES ('1799', '黄梅县', '1791', '1');
INSERT INTO `bbs_area` VALUES ('1800', '麻城市', '1791', '1');
INSERT INTO `bbs_area` VALUES ('1801', '武穴市', '1791', '1');
INSERT INTO `bbs_area` VALUES ('1802', '咸宁市', '1709', '1');
INSERT INTO `bbs_area` VALUES ('1803', '咸安区', '1802', '1');
INSERT INTO `bbs_area` VALUES ('1804', '嘉鱼县', '1802', '1');
INSERT INTO `bbs_area` VALUES ('1805', '通城县', '1802', '1');
INSERT INTO `bbs_area` VALUES ('1806', '崇阳县', '1802', '1');
INSERT INTO `bbs_area` VALUES ('1807', '通山县', '1802', '1');
INSERT INTO `bbs_area` VALUES ('1808', '赤壁市', '1802', '1');
INSERT INTO `bbs_area` VALUES ('1809', '随州市', '1709', '1');
INSERT INTO `bbs_area` VALUES ('1810', '曾都区', '1809', '1');
INSERT INTO `bbs_area` VALUES ('1811', '广水市', '1809', '1');
INSERT INTO `bbs_area` VALUES ('1812', '恩施土家族苗族自治州', '1709', '1');
INSERT INTO `bbs_area` VALUES ('1813', '恩施市', '1812', '1');
INSERT INTO `bbs_area` VALUES ('1814', '利川市', '1812', '1');
INSERT INTO `bbs_area` VALUES ('1815', '建始县', '1812', '1');
INSERT INTO `bbs_area` VALUES ('1816', '巴东县', '1812', '1');
INSERT INTO `bbs_area` VALUES ('1817', '宣恩县', '1812', '1');
INSERT INTO `bbs_area` VALUES ('1818', '咸丰县', '1812', '1');
INSERT INTO `bbs_area` VALUES ('1819', '来凤县', '1812', '1');
INSERT INTO `bbs_area` VALUES ('1820', '鹤峰县', '1812', '1');
INSERT INTO `bbs_area` VALUES ('1822', '仙桃市', '1709', '1');
INSERT INTO `bbs_area` VALUES ('1823', '潜江市', '1709', '1');
INSERT INTO `bbs_area` VALUES ('1824', '天门市', '1709', '1');
INSERT INTO `bbs_area` VALUES ('1825', '神农架林区', '1709', '1');
INSERT INTO `bbs_area` VALUES ('1826', '湖南', '0', '1');
INSERT INTO `bbs_area` VALUES ('1827', '长沙市', '1826', '1');
INSERT INTO `bbs_area` VALUES ('1828', '芙蓉区', '1827', '1');
INSERT INTO `bbs_area` VALUES ('1829', '天心区', '1827', '1');
INSERT INTO `bbs_area` VALUES ('1830', '岳麓区', '1827', '1');
INSERT INTO `bbs_area` VALUES ('1831', '开福区', '1827', '1');
INSERT INTO `bbs_area` VALUES ('1832', '雨花区', '1827', '1');
INSERT INTO `bbs_area` VALUES ('1833', '长沙县', '1827', '1');
INSERT INTO `bbs_area` VALUES ('1834', '望城县', '1827', '1');
INSERT INTO `bbs_area` VALUES ('1835', '宁乡县', '1827', '1');
INSERT INTO `bbs_area` VALUES ('1836', '浏阳市', '1827', '1');
INSERT INTO `bbs_area` VALUES ('1837', '株洲市', '1826', '1');
INSERT INTO `bbs_area` VALUES ('1838', '荷塘区', '1837', '1');
INSERT INTO `bbs_area` VALUES ('1839', '芦淞区', '1837', '1');
INSERT INTO `bbs_area` VALUES ('1840', '石峰区', '1837', '1');
INSERT INTO `bbs_area` VALUES ('1841', '天元区', '1837', '1');
INSERT INTO `bbs_area` VALUES ('1842', '株洲县', '1837', '1');
INSERT INTO `bbs_area` VALUES ('1843', '攸县', '1837', '1');
INSERT INTO `bbs_area` VALUES ('1844', '茶陵县', '1837', '1');
INSERT INTO `bbs_area` VALUES ('1845', '炎陵县', '1837', '1');
INSERT INTO `bbs_area` VALUES ('1846', '醴陵市', '1837', '1');
INSERT INTO `bbs_area` VALUES ('1847', '湘潭市', '1826', '1');
INSERT INTO `bbs_area` VALUES ('1848', '雨湖区', '1847', '1');
INSERT INTO `bbs_area` VALUES ('1849', '岳塘区', '1847', '1');
INSERT INTO `bbs_area` VALUES ('1850', '湘潭县', '1847', '1');
INSERT INTO `bbs_area` VALUES ('1851', '湘乡市', '1847', '1');
INSERT INTO `bbs_area` VALUES ('1852', '韶山市', '1847', '1');
INSERT INTO `bbs_area` VALUES ('1853', '衡阳市', '1826', '1');
INSERT INTO `bbs_area` VALUES ('1854', '珠晖区', '1853', '1');
INSERT INTO `bbs_area` VALUES ('1855', '雁峰区', '1853', '1');
INSERT INTO `bbs_area` VALUES ('1856', '石鼓区', '1853', '1');
INSERT INTO `bbs_area` VALUES ('1857', '蒸湘区', '1853', '1');
INSERT INTO `bbs_area` VALUES ('1858', '南岳区', '1853', '1');
INSERT INTO `bbs_area` VALUES ('1859', '衡阳县', '1853', '1');
INSERT INTO `bbs_area` VALUES ('1860', '衡南县', '1853', '1');
INSERT INTO `bbs_area` VALUES ('1861', '衡山县', '1853', '1');
INSERT INTO `bbs_area` VALUES ('1862', '衡东县', '1853', '1');
INSERT INTO `bbs_area` VALUES ('1863', '祁东县', '1853', '1');
INSERT INTO `bbs_area` VALUES ('1864', '耒阳市', '1853', '1');
INSERT INTO `bbs_area` VALUES ('1865', '常宁市', '1853', '1');
INSERT INTO `bbs_area` VALUES ('1866', '邵阳市', '1826', '1');
INSERT INTO `bbs_area` VALUES ('1867', '双清区', '1866', '1');
INSERT INTO `bbs_area` VALUES ('1868', '大祥区', '1866', '1');
INSERT INTO `bbs_area` VALUES ('1869', '北塔区', '1866', '1');
INSERT INTO `bbs_area` VALUES ('1870', '邵东县', '1866', '1');
INSERT INTO `bbs_area` VALUES ('1871', '新邵县', '1866', '1');
INSERT INTO `bbs_area` VALUES ('1872', '邵阳县', '1866', '1');
INSERT INTO `bbs_area` VALUES ('1873', '隆回县', '1866', '1');
INSERT INTO `bbs_area` VALUES ('1874', '洞口县', '1866', '1');
INSERT INTO `bbs_area` VALUES ('1875', '绥宁县', '1866', '1');
INSERT INTO `bbs_area` VALUES ('1876', '新宁县', '1866', '1');
INSERT INTO `bbs_area` VALUES ('1877', '城步苗族自治县', '1866', '1');
INSERT INTO `bbs_area` VALUES ('1878', '武冈市', '1866', '1');
INSERT INTO `bbs_area` VALUES ('1879', '岳阳市', '1826', '1');
INSERT INTO `bbs_area` VALUES ('1880', '岳阳楼区', '1879', '1');
INSERT INTO `bbs_area` VALUES ('1881', '云溪区', '1879', '1');
INSERT INTO `bbs_area` VALUES ('1882', '君山区', '1879', '1');
INSERT INTO `bbs_area` VALUES ('1883', '岳阳县', '1879', '1');
INSERT INTO `bbs_area` VALUES ('1884', '华容县', '1879', '1');
INSERT INTO `bbs_area` VALUES ('1885', '湘阴县', '1879', '1');
INSERT INTO `bbs_area` VALUES ('1886', '平江县', '1879', '1');
INSERT INTO `bbs_area` VALUES ('1887', '汨罗市', '1879', '1');
INSERT INTO `bbs_area` VALUES ('1888', '临湘市', '1879', '1');
INSERT INTO `bbs_area` VALUES ('1889', '常德市', '1826', '1');
INSERT INTO `bbs_area` VALUES ('1890', '武陵区', '1889', '1');
INSERT INTO `bbs_area` VALUES ('1891', '鼎城区', '1889', '1');
INSERT INTO `bbs_area` VALUES ('1892', '安乡县', '1889', '1');
INSERT INTO `bbs_area` VALUES ('1893', '汉寿县', '1889', '1');
INSERT INTO `bbs_area` VALUES ('1894', '澧县', '1889', '1');
INSERT INTO `bbs_area` VALUES ('1895', '临澧县', '1889', '1');
INSERT INTO `bbs_area` VALUES ('1896', '桃源县', '1889', '1');
INSERT INTO `bbs_area` VALUES ('1897', '石门县', '1889', '1');
INSERT INTO `bbs_area` VALUES ('1898', '津市市', '1889', '1');
INSERT INTO `bbs_area` VALUES ('1899', '张家界市', '1826', '1');
INSERT INTO `bbs_area` VALUES ('1900', '永定区', '1899', '1');
INSERT INTO `bbs_area` VALUES ('1901', '武陵源区', '1899', '1');
INSERT INTO `bbs_area` VALUES ('1902', '慈利县', '1899', '1');
INSERT INTO `bbs_area` VALUES ('1903', '桑植县', '1899', '1');
INSERT INTO `bbs_area` VALUES ('1904', '益阳市', '1826', '1');
INSERT INTO `bbs_area` VALUES ('1905', '资阳区', '1904', '1');
INSERT INTO `bbs_area` VALUES ('1906', '赫山区', '1904', '1');
INSERT INTO `bbs_area` VALUES ('1907', '南县', '1904', '1');
INSERT INTO `bbs_area` VALUES ('1908', '桃江县', '1904', '1');
INSERT INTO `bbs_area` VALUES ('1909', '安化县', '1904', '1');
INSERT INTO `bbs_area` VALUES ('1910', '沅江市', '1904', '1');
INSERT INTO `bbs_area` VALUES ('1911', '郴州市', '1826', '1');
INSERT INTO `bbs_area` VALUES ('1912', '北湖区', '1911', '1');
INSERT INTO `bbs_area` VALUES ('1913', '苏仙区', '1911', '1');
INSERT INTO `bbs_area` VALUES ('1914', '桂阳县', '1911', '1');
INSERT INTO `bbs_area` VALUES ('1915', '宜章县', '1911', '1');
INSERT INTO `bbs_area` VALUES ('1916', '永兴县', '1911', '1');
INSERT INTO `bbs_area` VALUES ('1917', '嘉禾县', '1911', '1');
INSERT INTO `bbs_area` VALUES ('1918', '临武县', '1911', '1');
INSERT INTO `bbs_area` VALUES ('1919', '汝城县', '1911', '1');
INSERT INTO `bbs_area` VALUES ('1920', '桂东县', '1911', '1');
INSERT INTO `bbs_area` VALUES ('1921', '安仁县', '1911', '1');
INSERT INTO `bbs_area` VALUES ('1922', '资兴市', '1911', '1');
INSERT INTO `bbs_area` VALUES ('1923', '永州市', '1826', '1');
INSERT INTO `bbs_area` VALUES ('1924', '零陵区', '1923', '1');
INSERT INTO `bbs_area` VALUES ('1925', '冷水滩区', '1923', '1');
INSERT INTO `bbs_area` VALUES ('1926', '祁阳县', '1923', '1');
INSERT INTO `bbs_area` VALUES ('1927', '东安县', '1923', '1');
INSERT INTO `bbs_area` VALUES ('1928', '双牌县', '1923', '1');
INSERT INTO `bbs_area` VALUES ('1929', '道县', '1923', '1');
INSERT INTO `bbs_area` VALUES ('1930', '江永县', '1923', '1');
INSERT INTO `bbs_area` VALUES ('1931', '宁远县', '1923', '1');
INSERT INTO `bbs_area` VALUES ('1932', '蓝山县', '1923', '1');
INSERT INTO `bbs_area` VALUES ('1933', '新田县', '1923', '1');
INSERT INTO `bbs_area` VALUES ('1934', '江华瑶族自治县', '1923', '1');
INSERT INTO `bbs_area` VALUES ('1935', '怀化市', '1826', '1');
INSERT INTO `bbs_area` VALUES ('1936', '鹤城区', '1935', '1');
INSERT INTO `bbs_area` VALUES ('1937', '中方县', '1935', '1');
INSERT INTO `bbs_area` VALUES ('1938', '沅陵县', '1935', '1');
INSERT INTO `bbs_area` VALUES ('1939', '辰溪县', '1935', '1');
INSERT INTO `bbs_area` VALUES ('1940', '溆浦县', '1935', '1');
INSERT INTO `bbs_area` VALUES ('1941', '会同县', '1935', '1');
INSERT INTO `bbs_area` VALUES ('1942', '麻阳苗族自治县', '1935', '1');
INSERT INTO `bbs_area` VALUES ('1943', '新晃侗族自治县', '1935', '1');
INSERT INTO `bbs_area` VALUES ('1944', '芷江侗族自治县', '1935', '1');
INSERT INTO `bbs_area` VALUES ('1945', '靖州苗族侗族自治县', '1935', '1');
INSERT INTO `bbs_area` VALUES ('1946', '通道侗族自治县', '1935', '1');
INSERT INTO `bbs_area` VALUES ('1947', '洪江市', '1935', '1');
INSERT INTO `bbs_area` VALUES ('1948', '娄底市', '1826', '1');
INSERT INTO `bbs_area` VALUES ('1949', '娄星区', '1948', '1');
INSERT INTO `bbs_area` VALUES ('1950', '双峰县', '1948', '1');
INSERT INTO `bbs_area` VALUES ('1951', '新化县', '1948', '1');
INSERT INTO `bbs_area` VALUES ('1952', '冷水江市', '1948', '1');
INSERT INTO `bbs_area` VALUES ('1953', '涟源市', '1948', '1');
INSERT INTO `bbs_area` VALUES ('1954', '湘西土家族苗族自治州', '1826', '1');
INSERT INTO `bbs_area` VALUES ('1955', '吉首市', '1954', '1');
INSERT INTO `bbs_area` VALUES ('1956', '泸溪县', '1954', '1');
INSERT INTO `bbs_area` VALUES ('1957', '凤凰县', '1954', '1');
INSERT INTO `bbs_area` VALUES ('1958', '花垣县', '1954', '1');
INSERT INTO `bbs_area` VALUES ('1959', '保靖县', '1954', '1');
INSERT INTO `bbs_area` VALUES ('1960', '古丈县', '1954', '1');
INSERT INTO `bbs_area` VALUES ('1961', '永顺县', '1954', '1');
INSERT INTO `bbs_area` VALUES ('1962', '龙山县', '1954', '1');
INSERT INTO `bbs_area` VALUES ('1963', '广东', '0', '1');
INSERT INTO `bbs_area` VALUES ('1964', '广州市', '1963', '1');
INSERT INTO `bbs_area` VALUES ('1965', '荔湾区', '1964', '1');
INSERT INTO `bbs_area` VALUES ('1966', '越秀区', '1964', '1');
INSERT INTO `bbs_area` VALUES ('1967', '海珠区', '1964', '1');
INSERT INTO `bbs_area` VALUES ('1968', '天河区', '1964', '1');
INSERT INTO `bbs_area` VALUES ('1969', '白云区', '1964', '1');
INSERT INTO `bbs_area` VALUES ('1970', '黄埔区', '1964', '1');
INSERT INTO `bbs_area` VALUES ('1971', '番禺区', '1964', '1');
INSERT INTO `bbs_area` VALUES ('1972', '花都区', '1964', '1');
INSERT INTO `bbs_area` VALUES ('1973', '南沙区', '1964', '1');
INSERT INTO `bbs_area` VALUES ('1974', '萝岗区', '1964', '1');
INSERT INTO `bbs_area` VALUES ('1975', '增城市', '1964', '1');
INSERT INTO `bbs_area` VALUES ('1976', '从化市', '1964', '1');
INSERT INTO `bbs_area` VALUES ('1977', '韶关市', '1963', '1');
INSERT INTO `bbs_area` VALUES ('1978', '武江区', '1977', '1');
INSERT INTO `bbs_area` VALUES ('1979', '浈江区', '1977', '1');
INSERT INTO `bbs_area` VALUES ('1980', '曲江区', '1977', '1');
INSERT INTO `bbs_area` VALUES ('1981', '始兴县', '1977', '1');
INSERT INTO `bbs_area` VALUES ('1982', '仁化县', '1977', '1');
INSERT INTO `bbs_area` VALUES ('1983', '翁源县', '1977', '1');
INSERT INTO `bbs_area` VALUES ('1984', '乳源瑶族自治县', '1977', '1');
INSERT INTO `bbs_area` VALUES ('1985', '新丰县', '1977', '1');
INSERT INTO `bbs_area` VALUES ('1986', '乐昌市', '1977', '1');
INSERT INTO `bbs_area` VALUES ('1987', '南雄市', '1977', '1');
INSERT INTO `bbs_area` VALUES ('1988', '深圳市', '1963', '1');
INSERT INTO `bbs_area` VALUES ('1989', '罗湖区', '1988', '1');
INSERT INTO `bbs_area` VALUES ('1990', '福田区', '1988', '1');
INSERT INTO `bbs_area` VALUES ('1991', '南山区', '1988', '1');
INSERT INTO `bbs_area` VALUES ('1992', '宝安区', '1988', '1');
INSERT INTO `bbs_area` VALUES ('1993', '龙岗区', '1988', '1');
INSERT INTO `bbs_area` VALUES ('1994', '盐田区', '1988', '1');
INSERT INTO `bbs_area` VALUES ('1995', '珠海市', '1963', '1');
INSERT INTO `bbs_area` VALUES ('1996', '香洲区', '1995', '1');
INSERT INTO `bbs_area` VALUES ('1997', '斗门区', '1995', '1');
INSERT INTO `bbs_area` VALUES ('1998', '金湾区', '1995', '1');
INSERT INTO `bbs_area` VALUES ('1999', '汕头市', '1963', '1');
INSERT INTO `bbs_area` VALUES ('2000', '龙湖区', '1999', '1');
INSERT INTO `bbs_area` VALUES ('2001', '金平区', '1999', '1');
INSERT INTO `bbs_area` VALUES ('2002', '濠江区', '1999', '1');
INSERT INTO `bbs_area` VALUES ('2003', '潮阳区', '1999', '1');
INSERT INTO `bbs_area` VALUES ('2004', '潮南区', '1999', '1');
INSERT INTO `bbs_area` VALUES ('2005', '澄海区', '1999', '1');
INSERT INTO `bbs_area` VALUES ('2006', '南澳县', '1999', '1');
INSERT INTO `bbs_area` VALUES ('2007', '佛山市', '1963', '1');
INSERT INTO `bbs_area` VALUES ('2008', '禅城区', '2007', '1');
INSERT INTO `bbs_area` VALUES ('2009', '南海区', '2007', '1');
INSERT INTO `bbs_area` VALUES ('2010', '顺德区', '2007', '1');
INSERT INTO `bbs_area` VALUES ('2011', '三水区', '2007', '1');
INSERT INTO `bbs_area` VALUES ('2012', '高明区', '2007', '1');
INSERT INTO `bbs_area` VALUES ('2013', '江门市', '1963', '1');
INSERT INTO `bbs_area` VALUES ('2014', '蓬江区', '2013', '1');
INSERT INTO `bbs_area` VALUES ('2015', '江海区', '2013', '1');
INSERT INTO `bbs_area` VALUES ('2016', '新会区', '2013', '1');
INSERT INTO `bbs_area` VALUES ('2017', '台山市', '2013', '1');
INSERT INTO `bbs_area` VALUES ('2018', '开平市', '2013', '1');
INSERT INTO `bbs_area` VALUES ('2019', '鹤山市', '2013', '1');
INSERT INTO `bbs_area` VALUES ('2020', '恩平市', '2013', '1');
INSERT INTO `bbs_area` VALUES ('2021', '湛江市', '1963', '1');
INSERT INTO `bbs_area` VALUES ('2022', '赤坎区', '2021', '1');
INSERT INTO `bbs_area` VALUES ('2023', '霞山区', '2021', '1');
INSERT INTO `bbs_area` VALUES ('2024', '坡头区', '2021', '1');
INSERT INTO `bbs_area` VALUES ('2025', '麻章区', '2021', '1');
INSERT INTO `bbs_area` VALUES ('2026', '遂溪县', '2021', '1');
INSERT INTO `bbs_area` VALUES ('2027', '徐闻县', '2021', '1');
INSERT INTO `bbs_area` VALUES ('2028', '廉江市', '2021', '1');
INSERT INTO `bbs_area` VALUES ('2029', '雷州市', '2021', '1');
INSERT INTO `bbs_area` VALUES ('2030', '吴川市', '2021', '1');
INSERT INTO `bbs_area` VALUES ('2031', '茂名市', '1963', '1');
INSERT INTO `bbs_area` VALUES ('2032', '茂南区', '2031', '1');
INSERT INTO `bbs_area` VALUES ('2033', '茂港区', '2031', '1');
INSERT INTO `bbs_area` VALUES ('2034', '电白县', '2031', '1');
INSERT INTO `bbs_area` VALUES ('2035', '高州市', '2031', '1');
INSERT INTO `bbs_area` VALUES ('2036', '化州市', '2031', '1');
INSERT INTO `bbs_area` VALUES ('2037', '信宜市', '2031', '1');
INSERT INTO `bbs_area` VALUES ('2038', '肇庆市', '1963', '1');
INSERT INTO `bbs_area` VALUES ('2039', '端州区', '2038', '1');
INSERT INTO `bbs_area` VALUES ('2040', '鼎湖区', '2038', '1');
INSERT INTO `bbs_area` VALUES ('2041', '广宁县', '2038', '1');
INSERT INTO `bbs_area` VALUES ('2042', '怀集县', '2038', '1');
INSERT INTO `bbs_area` VALUES ('2043', '封开县', '2038', '1');
INSERT INTO `bbs_area` VALUES ('2044', '德庆县', '2038', '1');
INSERT INTO `bbs_area` VALUES ('2045', '高要市', '2038', '1');
INSERT INTO `bbs_area` VALUES ('2046', '四会市', '2038', '1');
INSERT INTO `bbs_area` VALUES ('2047', '惠州市', '1963', '1');
INSERT INTO `bbs_area` VALUES ('2048', '惠城区', '2047', '1');
INSERT INTO `bbs_area` VALUES ('2049', '惠阳区', '2047', '1');
INSERT INTO `bbs_area` VALUES ('2050', '博罗县', '2047', '1');
INSERT INTO `bbs_area` VALUES ('2051', '惠东县', '2047', '1');
INSERT INTO `bbs_area` VALUES ('2052', '龙门县', '2047', '1');
INSERT INTO `bbs_area` VALUES ('2053', '梅州市', '1963', '1');
INSERT INTO `bbs_area` VALUES ('2054', '梅江区', '2053', '1');
INSERT INTO `bbs_area` VALUES ('2055', '梅县', '2053', '1');
INSERT INTO `bbs_area` VALUES ('2056', '大埔县', '2053', '1');
INSERT INTO `bbs_area` VALUES ('2057', '丰顺县', '2053', '1');
INSERT INTO `bbs_area` VALUES ('2058', '五华县', '2053', '1');
INSERT INTO `bbs_area` VALUES ('2059', '平远县', '2053', '1');
INSERT INTO `bbs_area` VALUES ('2060', '蕉岭县', '2053', '1');
INSERT INTO `bbs_area` VALUES ('2061', '兴宁市', '2053', '1');
INSERT INTO `bbs_area` VALUES ('2062', '汕尾市', '1963', '1');
INSERT INTO `bbs_area` VALUES ('2063', '城区', '2062', '1');
INSERT INTO `bbs_area` VALUES ('2064', '海丰县', '2062', '1');
INSERT INTO `bbs_area` VALUES ('2065', '陆河县', '2062', '1');
INSERT INTO `bbs_area` VALUES ('2066', '陆丰市', '2062', '1');
INSERT INTO `bbs_area` VALUES ('2067', '河源市', '1963', '1');
INSERT INTO `bbs_area` VALUES ('2068', '源城区', '2067', '1');
INSERT INTO `bbs_area` VALUES ('2069', '紫金县', '2067', '1');
INSERT INTO `bbs_area` VALUES ('2070', '龙川县', '2067', '1');
INSERT INTO `bbs_area` VALUES ('2071', '连平县', '2067', '1');
INSERT INTO `bbs_area` VALUES ('2072', '和平县', '2067', '1');
INSERT INTO `bbs_area` VALUES ('2073', '东源县', '2067', '1');
INSERT INTO `bbs_area` VALUES ('2074', '阳江市', '1963', '1');
INSERT INTO `bbs_area` VALUES ('2075', '江城区', '2074', '1');
INSERT INTO `bbs_area` VALUES ('2076', '阳西县', '2074', '1');
INSERT INTO `bbs_area` VALUES ('2077', '阳东县', '2074', '1');
INSERT INTO `bbs_area` VALUES ('2078', '阳春市', '2074', '1');
INSERT INTO `bbs_area` VALUES ('2079', '清远市', '1963', '1');
INSERT INTO `bbs_area` VALUES ('2080', '清城区', '2079', '1');
INSERT INTO `bbs_area` VALUES ('2081', '佛冈县', '2079', '1');
INSERT INTO `bbs_area` VALUES ('2082', '阳山县', '2079', '1');
INSERT INTO `bbs_area` VALUES ('2083', '连山壮族瑶族自治县', '2079', '1');
INSERT INTO `bbs_area` VALUES ('2084', '连南瑶族自治县', '2079', '1');
INSERT INTO `bbs_area` VALUES ('2085', '清新县', '2079', '1');
INSERT INTO `bbs_area` VALUES ('2086', '英德市', '2079', '1');
INSERT INTO `bbs_area` VALUES ('2087', '连州市', '2079', '1');
INSERT INTO `bbs_area` VALUES ('2088', '东莞市', '1963', '1');
INSERT INTO `bbs_area` VALUES ('2089', '中山市', '1963', '1');
INSERT INTO `bbs_area` VALUES ('2090', '潮州市', '1963', '1');
INSERT INTO `bbs_area` VALUES ('2091', '湘桥区', '2090', '1');
INSERT INTO `bbs_area` VALUES ('2092', '潮安县', '2090', '1');
INSERT INTO `bbs_area` VALUES ('2093', '饶平县', '2090', '1');
INSERT INTO `bbs_area` VALUES ('2094', '揭阳市', '1963', '1');
INSERT INTO `bbs_area` VALUES ('2095', '榕城区', '2094', '1');
INSERT INTO `bbs_area` VALUES ('2096', '揭东县', '2094', '1');
INSERT INTO `bbs_area` VALUES ('2097', '揭西县', '2094', '1');
INSERT INTO `bbs_area` VALUES ('2098', '惠来县', '2094', '1');
INSERT INTO `bbs_area` VALUES ('2099', '普宁市', '2094', '1');
INSERT INTO `bbs_area` VALUES ('2100', '云浮市', '1963', '1');
INSERT INTO `bbs_area` VALUES ('2101', '云城区', '2100', '1');
INSERT INTO `bbs_area` VALUES ('2102', '新兴县', '2100', '1');
INSERT INTO `bbs_area` VALUES ('2103', '郁南县', '2100', '1');
INSERT INTO `bbs_area` VALUES ('2104', '云安县', '2100', '1');
INSERT INTO `bbs_area` VALUES ('2105', '罗定市', '2100', '1');
INSERT INTO `bbs_area` VALUES ('2106', '广西', '0', '1');
INSERT INTO `bbs_area` VALUES ('2107', '南宁市', '2106', '1');
INSERT INTO `bbs_area` VALUES ('2108', '兴宁区', '2107', '1');
INSERT INTO `bbs_area` VALUES ('2109', '青秀区', '2107', '1');
INSERT INTO `bbs_area` VALUES ('2110', '江南区', '2107', '1');
INSERT INTO `bbs_area` VALUES ('2111', '西乡塘区', '2107', '1');
INSERT INTO `bbs_area` VALUES ('2112', '良庆区', '2107', '1');
INSERT INTO `bbs_area` VALUES ('2113', '邕宁区', '2107', '1');
INSERT INTO `bbs_area` VALUES ('2114', '武鸣县', '2107', '1');
INSERT INTO `bbs_area` VALUES ('2115', '隆安县', '2107', '1');
INSERT INTO `bbs_area` VALUES ('2116', '马山县', '2107', '1');
INSERT INTO `bbs_area` VALUES ('2117', '上林县', '2107', '1');
INSERT INTO `bbs_area` VALUES ('2118', '宾阳县', '2107', '1');
INSERT INTO `bbs_area` VALUES ('2119', '横县', '2107', '1');
INSERT INTO `bbs_area` VALUES ('2120', '柳州市', '2106', '1');
INSERT INTO `bbs_area` VALUES ('2121', '城中区', '2120', '1');
INSERT INTO `bbs_area` VALUES ('2122', '鱼峰区', '2120', '1');
INSERT INTO `bbs_area` VALUES ('2123', '柳南区', '2120', '1');
INSERT INTO `bbs_area` VALUES ('2124', '柳北区', '2120', '1');
INSERT INTO `bbs_area` VALUES ('2125', '柳江县', '2120', '1');
INSERT INTO `bbs_area` VALUES ('2126', '柳城县', '2120', '1');
INSERT INTO `bbs_area` VALUES ('2127', '鹿寨县', '2120', '1');
INSERT INTO `bbs_area` VALUES ('2128', '融安县', '2120', '1');
INSERT INTO `bbs_area` VALUES ('2129', '融水苗族自治县', '2120', '1');
INSERT INTO `bbs_area` VALUES ('2130', '三江侗族自治县', '2120', '1');
INSERT INTO `bbs_area` VALUES ('2131', '桂林市', '2106', '1');
INSERT INTO `bbs_area` VALUES ('2132', '秀峰区', '2131', '1');
INSERT INTO `bbs_area` VALUES ('2133', '叠彩区', '2131', '1');
INSERT INTO `bbs_area` VALUES ('2134', '象山区', '2131', '1');
INSERT INTO `bbs_area` VALUES ('2135', '七星区', '2131', '1');
INSERT INTO `bbs_area` VALUES ('2136', '雁山区', '2131', '1');
INSERT INTO `bbs_area` VALUES ('2137', '阳朔县', '2131', '1');
INSERT INTO `bbs_area` VALUES ('2138', '临桂县', '2131', '1');
INSERT INTO `bbs_area` VALUES ('2139', '灵川县', '2131', '1');
INSERT INTO `bbs_area` VALUES ('2140', '全州县', '2131', '1');
INSERT INTO `bbs_area` VALUES ('2141', '兴安县', '2131', '1');
INSERT INTO `bbs_area` VALUES ('2142', '永福县', '2131', '1');
INSERT INTO `bbs_area` VALUES ('2143', '灌阳县', '2131', '1');
INSERT INTO `bbs_area` VALUES ('2144', '龙胜各族自治县', '2131', '1');
INSERT INTO `bbs_area` VALUES ('2145', '资源县', '2131', '1');
INSERT INTO `bbs_area` VALUES ('2146', '平乐县', '2131', '1');
INSERT INTO `bbs_area` VALUES ('2147', '荔蒲县', '2131', '1');
INSERT INTO `bbs_area` VALUES ('2148', '恭城瑶族自治县', '2131', '1');
INSERT INTO `bbs_area` VALUES ('2149', '梧州市', '2106', '1');
INSERT INTO `bbs_area` VALUES ('2150', '万秀区', '2149', '1');
INSERT INTO `bbs_area` VALUES ('2151', '蝶山区', '2149', '1');
INSERT INTO `bbs_area` VALUES ('2152', '长洲区', '2149', '1');
INSERT INTO `bbs_area` VALUES ('2153', '苍梧县', '2149', '1');
INSERT INTO `bbs_area` VALUES ('2154', '藤县', '2149', '1');
INSERT INTO `bbs_area` VALUES ('2155', '蒙山县', '2149', '1');
INSERT INTO `bbs_area` VALUES ('2156', '岑溪市', '2149', '1');
INSERT INTO `bbs_area` VALUES ('2157', '北海市', '2106', '1');
INSERT INTO `bbs_area` VALUES ('2158', '海城区', '2157', '1');
INSERT INTO `bbs_area` VALUES ('2159', '银海区', '2157', '1');
INSERT INTO `bbs_area` VALUES ('2160', '铁山港区', '2157', '1');
INSERT INTO `bbs_area` VALUES ('2161', '合浦县', '2157', '1');
INSERT INTO `bbs_area` VALUES ('2162', '防城港市', '2106', '1');
INSERT INTO `bbs_area` VALUES ('2163', '港口区', '2162', '1');
INSERT INTO `bbs_area` VALUES ('2164', '防城区', '2162', '1');
INSERT INTO `bbs_area` VALUES ('2165', '上思县', '2162', '1');
INSERT INTO `bbs_area` VALUES ('2166', '东兴市', '2162', '1');
INSERT INTO `bbs_area` VALUES ('2167', '钦州市', '2106', '1');
INSERT INTO `bbs_area` VALUES ('2168', '钦南区', '2167', '1');
INSERT INTO `bbs_area` VALUES ('2169', '钦北区', '2167', '1');
INSERT INTO `bbs_area` VALUES ('2170', '灵山县', '2167', '1');
INSERT INTO `bbs_area` VALUES ('2171', '浦北县', '2167', '1');
INSERT INTO `bbs_area` VALUES ('2172', '贵港市', '2106', '1');
INSERT INTO `bbs_area` VALUES ('2173', '港北区', '2172', '1');
INSERT INTO `bbs_area` VALUES ('2174', '港南区', '2172', '1');
INSERT INTO `bbs_area` VALUES ('2175', '覃塘区', '2172', '1');
INSERT INTO `bbs_area` VALUES ('2176', '平南县', '2172', '1');
INSERT INTO `bbs_area` VALUES ('2177', '桂平市', '2172', '1');
INSERT INTO `bbs_area` VALUES ('2178', '玉林市', '2106', '1');
INSERT INTO `bbs_area` VALUES ('2179', '玉州区', '2178', '1');
INSERT INTO `bbs_area` VALUES ('2180', '容县', '2178', '1');
INSERT INTO `bbs_area` VALUES ('2181', '陆川县', '2178', '1');
INSERT INTO `bbs_area` VALUES ('2182', '博白县', '2178', '1');
INSERT INTO `bbs_area` VALUES ('2183', '兴业县', '2178', '1');
INSERT INTO `bbs_area` VALUES ('2184', '北流市', '2178', '1');
INSERT INTO `bbs_area` VALUES ('2185', '百色市', '2106', '1');
INSERT INTO `bbs_area` VALUES ('2186', '右江区', '2185', '1');
INSERT INTO `bbs_area` VALUES ('2187', '田阳县', '2185', '1');
INSERT INTO `bbs_area` VALUES ('2188', '田东县', '2185', '1');
INSERT INTO `bbs_area` VALUES ('2189', '平果县', '2185', '1');
INSERT INTO `bbs_area` VALUES ('2190', '德保县', '2185', '1');
INSERT INTO `bbs_area` VALUES ('2191', '靖西县', '2185', '1');
INSERT INTO `bbs_area` VALUES ('2192', '那坡县', '2185', '1');
INSERT INTO `bbs_area` VALUES ('2193', '凌云县', '2185', '1');
INSERT INTO `bbs_area` VALUES ('2194', '乐业县', '2185', '1');
INSERT INTO `bbs_area` VALUES ('2195', '田林县', '2185', '1');
INSERT INTO `bbs_area` VALUES ('2196', '西林县', '2185', '1');
INSERT INTO `bbs_area` VALUES ('2197', '隆林各族自治县', '2185', '1');
INSERT INTO `bbs_area` VALUES ('2198', '贺州市', '2106', '1');
INSERT INTO `bbs_area` VALUES ('2199', '八步区', '2198', '1');
INSERT INTO `bbs_area` VALUES ('2200', '昭平县', '2198', '1');
INSERT INTO `bbs_area` VALUES ('2201', '钟山县', '2198', '1');
INSERT INTO `bbs_area` VALUES ('2202', '富川瑶族自治县', '2198', '1');
INSERT INTO `bbs_area` VALUES ('2203', '河池市', '2106', '1');
INSERT INTO `bbs_area` VALUES ('2204', '金城江区', '2203', '1');
INSERT INTO `bbs_area` VALUES ('2205', '南丹县', '2203', '1');
INSERT INTO `bbs_area` VALUES ('2206', '天峨县', '2203', '1');
INSERT INTO `bbs_area` VALUES ('2207', '凤山县', '2203', '1');
INSERT INTO `bbs_area` VALUES ('2208', '东兰县', '2203', '1');
INSERT INTO `bbs_area` VALUES ('2209', '罗城仫佬族自治县', '2203', '1');
INSERT INTO `bbs_area` VALUES ('2210', '环江毛南族自治县', '2203', '1');
INSERT INTO `bbs_area` VALUES ('2211', '巴马瑶族自治县', '2203', '1');
INSERT INTO `bbs_area` VALUES ('2212', '都安瑶族自治县', '2203', '1');
INSERT INTO `bbs_area` VALUES ('2213', '大化瑶族自治县', '2203', '1');
INSERT INTO `bbs_area` VALUES ('2214', '宜州市', '2203', '1');
INSERT INTO `bbs_area` VALUES ('2215', '来宾市', '2106', '1');
INSERT INTO `bbs_area` VALUES ('2216', '兴宾区', '2215', '1');
INSERT INTO `bbs_area` VALUES ('2217', '忻城县', '2215', '1');
INSERT INTO `bbs_area` VALUES ('2218', '象州县', '2215', '1');
INSERT INTO `bbs_area` VALUES ('2219', '武宣县', '2215', '1');
INSERT INTO `bbs_area` VALUES ('2220', '金秀瑶族自治县', '2215', '1');
INSERT INTO `bbs_area` VALUES ('2221', '合山市', '2215', '1');
INSERT INTO `bbs_area` VALUES ('2222', '崇左市', '2106', '1');
INSERT INTO `bbs_area` VALUES ('2223', '江洲区', '2222', '1');
INSERT INTO `bbs_area` VALUES ('2224', '扶绥县', '2222', '1');
INSERT INTO `bbs_area` VALUES ('2225', '宁明县', '2222', '1');
INSERT INTO `bbs_area` VALUES ('2226', '龙州县', '2222', '1');
INSERT INTO `bbs_area` VALUES ('2227', '大新县', '2222', '1');
INSERT INTO `bbs_area` VALUES ('2228', '天等县', '2222', '1');
INSERT INTO `bbs_area` VALUES ('2229', '凭祥市', '2222', '1');
INSERT INTO `bbs_area` VALUES ('2230', '海南', '0', '1');
INSERT INTO `bbs_area` VALUES ('2231', '海口市', '2230', '1');
INSERT INTO `bbs_area` VALUES ('2232', '秀英区', '2231', '1');
INSERT INTO `bbs_area` VALUES ('2233', '龙华区', '2231', '1');
INSERT INTO `bbs_area` VALUES ('2234', '琼山区', '2231', '1');
INSERT INTO `bbs_area` VALUES ('2235', '美兰区', '2231', '1');
INSERT INTO `bbs_area` VALUES ('2236', '三亚市', '2230', '1');
INSERT INTO `bbs_area` VALUES ('2238', '五指山市', '2230', '1');
INSERT INTO `bbs_area` VALUES ('2239', '琼海市', '2230', '1');
INSERT INTO `bbs_area` VALUES ('2240', '儋州市', '2230', '1');
INSERT INTO `bbs_area` VALUES ('2241', '文昌市', '2230', '1');
INSERT INTO `bbs_area` VALUES ('2242', '万宁市', '2230', '1');
INSERT INTO `bbs_area` VALUES ('2243', '东方市', '2230', '1');
INSERT INTO `bbs_area` VALUES ('2244', '定安县', '2230', '1');
INSERT INTO `bbs_area` VALUES ('2245', '屯昌县', '2230', '1');
INSERT INTO `bbs_area` VALUES ('2246', '澄迈县', '2230', '1');
INSERT INTO `bbs_area` VALUES ('2247', '临高县', '2230', '1');
INSERT INTO `bbs_area` VALUES ('2248', '白沙黎族自治县', '2230', '1');
INSERT INTO `bbs_area` VALUES ('2249', '昌江黎族自治县', '2230', '1');
INSERT INTO `bbs_area` VALUES ('2250', '乐东黎族自治县', '2230', '1');
INSERT INTO `bbs_area` VALUES ('2251', '陵水黎族自治县', '2230', '1');
INSERT INTO `bbs_area` VALUES ('2252', '保亭黎族苗族自治县', '2230', '1');
INSERT INTO `bbs_area` VALUES ('2253', '琼中黎族苗族自治县', '2230', '1');
INSERT INTO `bbs_area` VALUES ('2257', '重庆', '0', '1');
INSERT INTO `bbs_area` VALUES ('2258', '重庆市', '2257', '1');
INSERT INTO `bbs_area` VALUES ('2259', '万州区', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2260', '涪陵区', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2261', '渝中区', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2262', '大渡口区', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2263', '江北区', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2264', '沙坪坝区', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2265', '九龙坡区', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2266', '南岸区', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2267', '北碚区', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2268', '万盛区', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2269', '双桥区', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2270', '渝北区', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2271', '巴南区', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2272', '黔江区', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2273', '长寿区', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2274', '江津区', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2275', '合川区', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2276', '永川区', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2277', '南川区', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2278', '綦江县', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2279', '潼南县', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2280', '铜梁县', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2281', '大足县', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2282', '荣昌县', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2283', '璧山县', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2284', '梁平县', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2285', '城口县', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2286', '丰都县', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2287', '垫江县', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2288', '武隆县', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2289', '忠县', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2290', '开县', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2291', '云阳县', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2292', '奉节县', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2293', '巫山县', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2294', '巫溪县', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2295', '石柱土家族自治县', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2296', '秀山土家族苗族自治县', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2297', '酉阳土家族苗族自治县', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2298', '彭水苗族土家族自治县', '2258', '1');
INSERT INTO `bbs_area` VALUES ('2299', '四川', '0', '1');
INSERT INTO `bbs_area` VALUES ('2300', '成都市', '2299', '1');
INSERT INTO `bbs_area` VALUES ('2301', '锦江区', '2300', '1');
INSERT INTO `bbs_area` VALUES ('2302', '青羊区', '2300', '1');
INSERT INTO `bbs_area` VALUES ('2303', '金牛区', '2300', '1');
INSERT INTO `bbs_area` VALUES ('2304', '武侯区', '2300', '1');
INSERT INTO `bbs_area` VALUES ('2305', '成华区', '2300', '1');
INSERT INTO `bbs_area` VALUES ('2306', '龙泉驿区', '2300', '1');
INSERT INTO `bbs_area` VALUES ('2307', '青白江区', '2300', '1');
INSERT INTO `bbs_area` VALUES ('2308', '新都区', '2300', '1');
INSERT INTO `bbs_area` VALUES ('2309', '温江区', '2300', '1');
INSERT INTO `bbs_area` VALUES ('2310', '金堂县', '2300', '1');
INSERT INTO `bbs_area` VALUES ('2311', '双流区', '2300', '1');
INSERT INTO `bbs_area` VALUES ('2312', '郫都区', '2300', '1');
INSERT INTO `bbs_area` VALUES ('2313', '大邑县', '2300', '1');
INSERT INTO `bbs_area` VALUES ('2314', '蒲江县', '2300', '1');
INSERT INTO `bbs_area` VALUES ('2315', '新津县', '2300', '1');
INSERT INTO `bbs_area` VALUES ('2316', '都江堰市', '2300', '1');
INSERT INTO `bbs_area` VALUES ('2317', '彭州市', '2300', '1');
INSERT INTO `bbs_area` VALUES ('2318', '邛崃市', '2300', '1');
INSERT INTO `bbs_area` VALUES ('2319', '崇州市', '2300', '1');
INSERT INTO `bbs_area` VALUES ('2320', '自贡市', '2299', '1');
INSERT INTO `bbs_area` VALUES ('2321', '自流井区', '2320', '1');
INSERT INTO `bbs_area` VALUES ('2322', '贡井区', '2320', '1');
INSERT INTO `bbs_area` VALUES ('2323', '大安区', '2320', '1');
INSERT INTO `bbs_area` VALUES ('2324', '沿滩区', '2320', '1');
INSERT INTO `bbs_area` VALUES ('2325', '荣县', '2320', '1');
INSERT INTO `bbs_area` VALUES ('2326', '富顺县', '2320', '1');
INSERT INTO `bbs_area` VALUES ('2327', '攀枝花市', '2299', '1');
INSERT INTO `bbs_area` VALUES ('2328', '东区', '2327', '1');
INSERT INTO `bbs_area` VALUES ('2329', '西区', '2327', '1');
INSERT INTO `bbs_area` VALUES ('2330', '仁和区', '2327', '1');
INSERT INTO `bbs_area` VALUES ('2331', '米易县', '2327', '1');
INSERT INTO `bbs_area` VALUES ('2332', '盐边县', '2327', '1');
INSERT INTO `bbs_area` VALUES ('2333', '泸州市', '2299', '1');
INSERT INTO `bbs_area` VALUES ('2334', '江阳区', '2333', '1');
INSERT INTO `bbs_area` VALUES ('2335', '纳溪区', '2333', '1');
INSERT INTO `bbs_area` VALUES ('2336', '龙马潭区', '2333', '1');
INSERT INTO `bbs_area` VALUES ('2337', '泸县', '2333', '1');
INSERT INTO `bbs_area` VALUES ('2338', '合江县', '2333', '1');
INSERT INTO `bbs_area` VALUES ('2339', '叙永县', '2333', '1');
INSERT INTO `bbs_area` VALUES ('2340', '古蔺县', '2333', '1');
INSERT INTO `bbs_area` VALUES ('2341', '德阳市', '2299', '1');
INSERT INTO `bbs_area` VALUES ('2342', '旌阳区', '2341', '1');
INSERT INTO `bbs_area` VALUES ('2343', '中江县', '2341', '1');
INSERT INTO `bbs_area` VALUES ('2344', '罗江县', '2341', '1');
INSERT INTO `bbs_area` VALUES ('2345', '广汉市', '2341', '1');
INSERT INTO `bbs_area` VALUES ('2346', '什邡市', '2341', '1');
INSERT INTO `bbs_area` VALUES ('2347', '绵竹市', '2341', '1');
INSERT INTO `bbs_area` VALUES ('2348', '绵阳市', '2299', '1');
INSERT INTO `bbs_area` VALUES ('2349', '涪城区', '2348', '1');
INSERT INTO `bbs_area` VALUES ('2350', '游仙区', '2348', '1');
INSERT INTO `bbs_area` VALUES ('2351', '三台县', '2348', '1');
INSERT INTO `bbs_area` VALUES ('2352', '盐亭县', '2348', '1');
INSERT INTO `bbs_area` VALUES ('2353', '安县', '2348', '1');
INSERT INTO `bbs_area` VALUES ('2354', '梓潼县', '2348', '1');
INSERT INTO `bbs_area` VALUES ('2355', '北川羌族自治县', '2348', '1');
INSERT INTO `bbs_area` VALUES ('2356', '平武县', '2348', '1');
INSERT INTO `bbs_area` VALUES ('2357', '江油市', '2348', '1');
INSERT INTO `bbs_area` VALUES ('2358', '广元市', '2299', '1');
INSERT INTO `bbs_area` VALUES ('2359', '市中区', '2358', '1');
INSERT INTO `bbs_area` VALUES ('2360', '元坝区', '2358', '1');
INSERT INTO `bbs_area` VALUES ('2361', '朝天区', '2358', '1');
INSERT INTO `bbs_area` VALUES ('2362', '旺苍县', '2358', '1');
INSERT INTO `bbs_area` VALUES ('2363', '青川县', '2358', '1');
INSERT INTO `bbs_area` VALUES ('2364', '剑阁县', '2358', '1');
INSERT INTO `bbs_area` VALUES ('2365', '苍溪县', '2358', '1');
INSERT INTO `bbs_area` VALUES ('2366', '遂宁市', '2299', '1');
INSERT INTO `bbs_area` VALUES ('2367', '船山区', '2366', '1');
INSERT INTO `bbs_area` VALUES ('2368', '安居区', '2366', '1');
INSERT INTO `bbs_area` VALUES ('2369', '蓬溪县', '2366', '1');
INSERT INTO `bbs_area` VALUES ('2370', '射洪县', '2366', '1');
INSERT INTO `bbs_area` VALUES ('2371', '大英县', '2366', '1');
INSERT INTO `bbs_area` VALUES ('2372', '内江市', '2299', '1');
INSERT INTO `bbs_area` VALUES ('2373', '市中区', '2372', '1');
INSERT INTO `bbs_area` VALUES ('2374', '东兴区', '2372', '1');
INSERT INTO `bbs_area` VALUES ('2375', '威远县', '2372', '1');
INSERT INTO `bbs_area` VALUES ('2376', '资中县', '2372', '1');
INSERT INTO `bbs_area` VALUES ('2377', '隆昌县', '2372', '1');
INSERT INTO `bbs_area` VALUES ('2378', '乐山市', '2299', '1');
INSERT INTO `bbs_area` VALUES ('2379', '市中区', '2378', '1');
INSERT INTO `bbs_area` VALUES ('2380', '沙湾区', '2378', '1');
INSERT INTO `bbs_area` VALUES ('2381', '五通桥区', '2378', '1');
INSERT INTO `bbs_area` VALUES ('2382', '金口河区', '2378', '1');
INSERT INTO `bbs_area` VALUES ('2383', '犍为县', '2378', '1');
INSERT INTO `bbs_area` VALUES ('2384', '井研县', '2378', '1');
INSERT INTO `bbs_area` VALUES ('2385', '夹江县', '2378', '1');
INSERT INTO `bbs_area` VALUES ('2386', '沐川县', '2378', '1');
INSERT INTO `bbs_area` VALUES ('2387', '峨边彝族自治县', '2378', '1');
INSERT INTO `bbs_area` VALUES ('2388', '马边彝族自治县', '2378', '1');
INSERT INTO `bbs_area` VALUES ('2389', '峨眉山市', '2378', '1');
INSERT INTO `bbs_area` VALUES ('2390', '南充市', '2299', '1');
INSERT INTO `bbs_area` VALUES ('2391', '顺庆区', '2390', '1');
INSERT INTO `bbs_area` VALUES ('2392', '高坪区', '2390', '1');
INSERT INTO `bbs_area` VALUES ('2393', '嘉陵区', '2390', '1');
INSERT INTO `bbs_area` VALUES ('2394', '南部县', '2390', '1');
INSERT INTO `bbs_area` VALUES ('2395', '营山县', '2390', '1');
INSERT INTO `bbs_area` VALUES ('2396', '蓬安县', '2390', '1');
INSERT INTO `bbs_area` VALUES ('2397', '仪陇县', '2390', '1');
INSERT INTO `bbs_area` VALUES ('2398', '西充县', '2390', '1');
INSERT INTO `bbs_area` VALUES ('2399', '阆中市', '2390', '1');
INSERT INTO `bbs_area` VALUES ('2400', '眉山市', '2299', '1');
INSERT INTO `bbs_area` VALUES ('2401', '东坡区', '2400', '1');
INSERT INTO `bbs_area` VALUES ('2402', '仁寿县', '2400', '1');
INSERT INTO `bbs_area` VALUES ('2403', '彭山县', '2400', '1');
INSERT INTO `bbs_area` VALUES ('2404', '洪雅县', '2400', '1');
INSERT INTO `bbs_area` VALUES ('2405', '丹棱县', '2400', '1');
INSERT INTO `bbs_area` VALUES ('2406', '青神县', '2400', '1');
INSERT INTO `bbs_area` VALUES ('2407', '宜宾市', '2299', '1');
INSERT INTO `bbs_area` VALUES ('2408', '翠屏区', '2407', '1');
INSERT INTO `bbs_area` VALUES ('2409', '宜宾县', '2407', '1');
INSERT INTO `bbs_area` VALUES ('2410', '南溪县', '2407', '1');
INSERT INTO `bbs_area` VALUES ('2411', '江安县', '2407', '1');
INSERT INTO `bbs_area` VALUES ('2412', '长宁县', '2407', '1');
INSERT INTO `bbs_area` VALUES ('2413', '高县', '2407', '1');
INSERT INTO `bbs_area` VALUES ('2414', '珙县', '2407', '1');
INSERT INTO `bbs_area` VALUES ('2415', '筠连县', '2407', '1');
INSERT INTO `bbs_area` VALUES ('2416', '兴文县', '2407', '1');
INSERT INTO `bbs_area` VALUES ('2417', '屏山县', '2407', '1');
INSERT INTO `bbs_area` VALUES ('2418', '广安市', '2299', '1');
INSERT INTO `bbs_area` VALUES ('2419', '广安区', '2418', '1');
INSERT INTO `bbs_area` VALUES ('2420', '岳池县', '2418', '1');
INSERT INTO `bbs_area` VALUES ('2421', '武胜县', '2418', '1');
INSERT INTO `bbs_area` VALUES ('2422', '邻水县', '2418', '1');
INSERT INTO `bbs_area` VALUES ('2423', '华蓥市', '2418', '1');
INSERT INTO `bbs_area` VALUES ('2424', '达州市', '2299', '1');
INSERT INTO `bbs_area` VALUES ('2425', '通川区', '2424', '1');
INSERT INTO `bbs_area` VALUES ('2426', '达县', '2424', '1');
INSERT INTO `bbs_area` VALUES ('2427', '宣汉县', '2424', '1');
INSERT INTO `bbs_area` VALUES ('2428', '开江县', '2424', '1');
INSERT INTO `bbs_area` VALUES ('2429', '大竹县', '2424', '1');
INSERT INTO `bbs_area` VALUES ('2430', '渠县', '2424', '1');
INSERT INTO `bbs_area` VALUES ('2431', '万源市', '2424', '1');
INSERT INTO `bbs_area` VALUES ('2432', '雅安市', '2299', '1');
INSERT INTO `bbs_area` VALUES ('2433', '雨城区', '2432', '1');
INSERT INTO `bbs_area` VALUES ('2434', '名山县', '2432', '1');
INSERT INTO `bbs_area` VALUES ('2435', '荥经县', '2432', '1');
INSERT INTO `bbs_area` VALUES ('2436', '汉源县', '2432', '1');
INSERT INTO `bbs_area` VALUES ('2437', '石棉县', '2432', '1');
INSERT INTO `bbs_area` VALUES ('2438', '天全县', '2432', '1');
INSERT INTO `bbs_area` VALUES ('2439', '芦山县', '2432', '1');
INSERT INTO `bbs_area` VALUES ('2440', '宝兴县', '2432', '1');
INSERT INTO `bbs_area` VALUES ('2441', '巴中市', '2299', '1');
INSERT INTO `bbs_area` VALUES ('2442', '巴州区', '2441', '1');
INSERT INTO `bbs_area` VALUES ('2443', '通江县', '2441', '1');
INSERT INTO `bbs_area` VALUES ('2444', '南江县', '2441', '1');
INSERT INTO `bbs_area` VALUES ('2445', '平昌县', '2441', '1');
INSERT INTO `bbs_area` VALUES ('2446', '资阳市', '2299', '1');
INSERT INTO `bbs_area` VALUES ('2447', '雁江区', '2446', '1');
INSERT INTO `bbs_area` VALUES ('2448', '安岳县', '2446', '1');
INSERT INTO `bbs_area` VALUES ('2449', '乐至县', '2446', '1');
INSERT INTO `bbs_area` VALUES ('2450', '简阳市', '2446', '1');
INSERT INTO `bbs_area` VALUES ('2451', '阿坝藏族羌族自治州', '2299', '1');
INSERT INTO `bbs_area` VALUES ('2452', '汶川县', '2451', '1');
INSERT INTO `bbs_area` VALUES ('2453', '理县', '2451', '1');
INSERT INTO `bbs_area` VALUES ('2454', '茂县', '2451', '1');
INSERT INTO `bbs_area` VALUES ('2455', '松潘县', '2451', '1');
INSERT INTO `bbs_area` VALUES ('2456', '九寨沟县', '2451', '1');
INSERT INTO `bbs_area` VALUES ('2457', '金川县', '2451', '1');
INSERT INTO `bbs_area` VALUES ('2458', '小金县', '2451', '1');
INSERT INTO `bbs_area` VALUES ('2459', '黑水县', '2451', '1');
INSERT INTO `bbs_area` VALUES ('2460', '马尔康县', '2451', '1');
INSERT INTO `bbs_area` VALUES ('2461', '壤塘县', '2451', '1');
INSERT INTO `bbs_area` VALUES ('2462', '阿坝县', '2451', '1');
INSERT INTO `bbs_area` VALUES ('2463', '若尔盖县', '2451', '1');
INSERT INTO `bbs_area` VALUES ('2464', '红原县', '2451', '1');
INSERT INTO `bbs_area` VALUES ('2465', '甘孜藏族自治州', '2299', '1');
INSERT INTO `bbs_area` VALUES ('2466', '康定县', '2465', '1');
INSERT INTO `bbs_area` VALUES ('2467', '泸定县', '2465', '1');
INSERT INTO `bbs_area` VALUES ('2468', '丹巴县', '2465', '1');
INSERT INTO `bbs_area` VALUES ('2469', '九龙县', '2465', '1');
INSERT INTO `bbs_area` VALUES ('2470', '雅江县', '2465', '1');
INSERT INTO `bbs_area` VALUES ('2471', '道孚县', '2465', '1');
INSERT INTO `bbs_area` VALUES ('2472', '炉霍县', '2465', '1');
INSERT INTO `bbs_area` VALUES ('2473', '甘孜县', '2465', '1');
INSERT INTO `bbs_area` VALUES ('2474', '新龙县', '2465', '1');
INSERT INTO `bbs_area` VALUES ('2475', '德格县', '2465', '1');
INSERT INTO `bbs_area` VALUES ('2476', '白玉县', '2465', '1');
INSERT INTO `bbs_area` VALUES ('2477', '石渠县', '2465', '1');
INSERT INTO `bbs_area` VALUES ('2478', '色达县', '2465', '1');
INSERT INTO `bbs_area` VALUES ('2479', '理塘县', '2465', '1');
INSERT INTO `bbs_area` VALUES ('2480', '巴塘县', '2465', '1');
INSERT INTO `bbs_area` VALUES ('2481', '乡城县', '2465', '1');
INSERT INTO `bbs_area` VALUES ('2482', '稻城县', '2465', '1');
INSERT INTO `bbs_area` VALUES ('2483', '得荣县', '2465', '1');
INSERT INTO `bbs_area` VALUES ('2484', '凉山彝族自治州', '2299', '1');
INSERT INTO `bbs_area` VALUES ('2485', '西昌市', '2484', '1');
INSERT INTO `bbs_area` VALUES ('2486', '木里藏族自治县', '2484', '1');
INSERT INTO `bbs_area` VALUES ('2487', '盐源县', '2484', '1');
INSERT INTO `bbs_area` VALUES ('2488', '德昌县', '2484', '1');
INSERT INTO `bbs_area` VALUES ('2489', '会理县', '2484', '1');
INSERT INTO `bbs_area` VALUES ('2490', '会东县', '2484', '1');
INSERT INTO `bbs_area` VALUES ('2491', '宁南县', '2484', '1');
INSERT INTO `bbs_area` VALUES ('2492', '普格县', '2484', '1');
INSERT INTO `bbs_area` VALUES ('2493', '布拖县', '2484', '1');
INSERT INTO `bbs_area` VALUES ('2494', '金阳县', '2484', '1');
INSERT INTO `bbs_area` VALUES ('2495', '昭觉县', '2484', '1');
INSERT INTO `bbs_area` VALUES ('2496', '喜德县', '2484', '1');
INSERT INTO `bbs_area` VALUES ('2497', '冕宁县', '2484', '1');
INSERT INTO `bbs_area` VALUES ('2498', '越西县', '2484', '1');
INSERT INTO `bbs_area` VALUES ('2499', '甘洛县', '2484', '1');
INSERT INTO `bbs_area` VALUES ('2500', '美姑县', '2484', '1');
INSERT INTO `bbs_area` VALUES ('2501', '雷波县', '2484', '1');
INSERT INTO `bbs_area` VALUES ('2502', '贵州', '0', '1');
INSERT INTO `bbs_area` VALUES ('2503', '贵阳市', '2502', '1');
INSERT INTO `bbs_area` VALUES ('2504', '南明区', '2503', '1');
INSERT INTO `bbs_area` VALUES ('2505', '云岩区', '2503', '1');
INSERT INTO `bbs_area` VALUES ('2506', '花溪区', '2503', '1');
INSERT INTO `bbs_area` VALUES ('2507', '乌当区', '2503', '1');
INSERT INTO `bbs_area` VALUES ('2508', '白云区', '2503', '1');
INSERT INTO `bbs_area` VALUES ('2509', '小河区', '2503', '1');
INSERT INTO `bbs_area` VALUES ('2510', '开阳县', '2503', '1');
INSERT INTO `bbs_area` VALUES ('2511', '息烽县', '2503', '1');
INSERT INTO `bbs_area` VALUES ('2512', '修文县', '2503', '1');
INSERT INTO `bbs_area` VALUES ('2513', '清镇市', '2503', '1');
INSERT INTO `bbs_area` VALUES ('2514', '六盘水市', '2502', '1');
INSERT INTO `bbs_area` VALUES ('2515', '钟山区', '2514', '1');
INSERT INTO `bbs_area` VALUES ('2516', '六枝特区', '2514', '1');
INSERT INTO `bbs_area` VALUES ('2517', '水城县', '2514', '1');
INSERT INTO `bbs_area` VALUES ('2518', '盘县', '2514', '1');
INSERT INTO `bbs_area` VALUES ('2519', '遵义市', '2502', '1');
INSERT INTO `bbs_area` VALUES ('2520', '红花岗区', '2519', '1');
INSERT INTO `bbs_area` VALUES ('2521', '汇川区', '2519', '1');
INSERT INTO `bbs_area` VALUES ('2522', '遵义县', '2519', '1');
INSERT INTO `bbs_area` VALUES ('2523', '桐梓县', '2519', '1');
INSERT INTO `bbs_area` VALUES ('2524', '绥阳县', '2519', '1');
INSERT INTO `bbs_area` VALUES ('2525', '正安县', '2519', '1');
INSERT INTO `bbs_area` VALUES ('2526', '道真仡佬族苗族自治县', '2519', '1');
INSERT INTO `bbs_area` VALUES ('2527', '务川仡佬族苗族自治县', '2519', '1');
INSERT INTO `bbs_area` VALUES ('2528', '凤冈县', '2519', '1');
INSERT INTO `bbs_area` VALUES ('2529', '湄潭县', '2519', '1');
INSERT INTO `bbs_area` VALUES ('2530', '余庆县', '2519', '1');
INSERT INTO `bbs_area` VALUES ('2531', '习水县', '2519', '1');
INSERT INTO `bbs_area` VALUES ('2532', '赤水市', '2519', '1');
INSERT INTO `bbs_area` VALUES ('2533', '仁怀市', '2519', '1');
INSERT INTO `bbs_area` VALUES ('2534', '安顺市', '2502', '1');
INSERT INTO `bbs_area` VALUES ('2535', '西秀区', '2534', '1');
INSERT INTO `bbs_area` VALUES ('2536', '平坝县', '2534', '1');
INSERT INTO `bbs_area` VALUES ('2537', '普定县', '2534', '1');
INSERT INTO `bbs_area` VALUES ('2538', '镇宁布依族苗族自治县', '2534', '1');
INSERT INTO `bbs_area` VALUES ('2539', '关岭布依族苗族自治县', '2534', '1');
INSERT INTO `bbs_area` VALUES ('2540', '紫云苗族布依族自治县', '2534', '1');
INSERT INTO `bbs_area` VALUES ('2541', '铜仁地区', '2502', '1');
INSERT INTO `bbs_area` VALUES ('2542', '铜仁市', '2541', '1');
INSERT INTO `bbs_area` VALUES ('2543', '江口县', '2541', '1');
INSERT INTO `bbs_area` VALUES ('2544', '玉屏侗族自治县', '2541', '1');
INSERT INTO `bbs_area` VALUES ('2545', '石阡县', '2541', '1');
INSERT INTO `bbs_area` VALUES ('2546', '思南县', '2541', '1');
INSERT INTO `bbs_area` VALUES ('2547', '印江土家族苗族自治县', '2541', '1');
INSERT INTO `bbs_area` VALUES ('2548', '德江县', '2541', '1');
INSERT INTO `bbs_area` VALUES ('2549', '沿河土家族自治县', '2541', '1');
INSERT INTO `bbs_area` VALUES ('2550', '松桃苗族自治县', '2541', '1');
INSERT INTO `bbs_area` VALUES ('2551', '万山特区', '2541', '1');
INSERT INTO `bbs_area` VALUES ('2552', '黔西南布依族苗族自治州', '2502', '1');
INSERT INTO `bbs_area` VALUES ('2553', '兴义市', '2552', '1');
INSERT INTO `bbs_area` VALUES ('2554', '兴仁县', '2552', '1');
INSERT INTO `bbs_area` VALUES ('2555', '普安县', '2552', '1');
INSERT INTO `bbs_area` VALUES ('2556', '晴隆县', '2552', '1');
INSERT INTO `bbs_area` VALUES ('2557', '贞丰县', '2552', '1');
INSERT INTO `bbs_area` VALUES ('2558', '望谟县', '2552', '1');
INSERT INTO `bbs_area` VALUES ('2559', '册亨县', '2552', '1');
INSERT INTO `bbs_area` VALUES ('2560', '安龙县', '2552', '1');
INSERT INTO `bbs_area` VALUES ('2561', '毕节地区', '2502', '1');
INSERT INTO `bbs_area` VALUES ('2562', '毕节市', '2561', '1');
INSERT INTO `bbs_area` VALUES ('2563', '大方县', '2561', '1');
INSERT INTO `bbs_area` VALUES ('2564', '黔西县', '2561', '1');
INSERT INTO `bbs_area` VALUES ('2565', '金沙县', '2561', '1');
INSERT INTO `bbs_area` VALUES ('2566', '织金县', '2561', '1');
INSERT INTO `bbs_area` VALUES ('2567', '纳雍县', '2561', '1');
INSERT INTO `bbs_area` VALUES ('2568', '威宁彝族回族苗族自治县', '2561', '1');
INSERT INTO `bbs_area` VALUES ('2569', '赫章县', '2561', '1');
INSERT INTO `bbs_area` VALUES ('2570', '黔东南苗族侗族自治州', '2502', '1');
INSERT INTO `bbs_area` VALUES ('2571', '凯里市', '2570', '1');
INSERT INTO `bbs_area` VALUES ('2572', '黄平县', '2570', '1');
INSERT INTO `bbs_area` VALUES ('2573', '施秉县', '2570', '1');
INSERT INTO `bbs_area` VALUES ('2574', '三穗县', '2570', '1');
INSERT INTO `bbs_area` VALUES ('2575', '镇远县', '2570', '1');
INSERT INTO `bbs_area` VALUES ('2576', '岑巩县', '2570', '1');
INSERT INTO `bbs_area` VALUES ('2577', '天柱县', '2570', '1');
INSERT INTO `bbs_area` VALUES ('2578', '锦屏县', '2570', '1');
INSERT INTO `bbs_area` VALUES ('2579', '剑河县', '2570', '1');
INSERT INTO `bbs_area` VALUES ('2580', '台江县', '2570', '1');
INSERT INTO `bbs_area` VALUES ('2581', '黎平县', '2570', '1');
INSERT INTO `bbs_area` VALUES ('2582', '榕江县', '2570', '1');
INSERT INTO `bbs_area` VALUES ('2583', '从江县', '2570', '1');
INSERT INTO `bbs_area` VALUES ('2584', '雷山县', '2570', '1');
INSERT INTO `bbs_area` VALUES ('2585', '麻江县', '2570', '1');
INSERT INTO `bbs_area` VALUES ('2586', '丹寨县', '2570', '1');
INSERT INTO `bbs_area` VALUES ('2587', '黔南布依族苗族自治州', '2502', '1');
INSERT INTO `bbs_area` VALUES ('2588', '都匀市', '2587', '1');
INSERT INTO `bbs_area` VALUES ('2589', '福泉市', '2587', '1');
INSERT INTO `bbs_area` VALUES ('2590', '荔波县', '2587', '1');
INSERT INTO `bbs_area` VALUES ('2591', '贵定县', '2587', '1');
INSERT INTO `bbs_area` VALUES ('2592', '瓮安县', '2587', '1');
INSERT INTO `bbs_area` VALUES ('2593', '独山县', '2587', '1');
INSERT INTO `bbs_area` VALUES ('2594', '平塘县', '2587', '1');
INSERT INTO `bbs_area` VALUES ('2595', '罗甸县', '2587', '1');
INSERT INTO `bbs_area` VALUES ('2596', '长顺县', '2587', '1');
INSERT INTO `bbs_area` VALUES ('2597', '龙里县', '2587', '1');
INSERT INTO `bbs_area` VALUES ('2598', '惠水县', '2587', '1');
INSERT INTO `bbs_area` VALUES ('2599', '三都水族自治县', '2587', '1');
INSERT INTO `bbs_area` VALUES ('2600', '云南', '0', '1');
INSERT INTO `bbs_area` VALUES ('2601', '昆明市', '2600', '1');
INSERT INTO `bbs_area` VALUES ('2602', '五华区', '2601', '1');
INSERT INTO `bbs_area` VALUES ('2603', '盘龙区', '2601', '1');
INSERT INTO `bbs_area` VALUES ('2604', '官渡区', '2601', '1');
INSERT INTO `bbs_area` VALUES ('2605', '西山区', '2601', '1');
INSERT INTO `bbs_area` VALUES ('2606', '东川区', '2601', '1');
INSERT INTO `bbs_area` VALUES ('2607', '呈贡县', '2601', '1');
INSERT INTO `bbs_area` VALUES ('2608', '晋宁县', '2601', '1');
INSERT INTO `bbs_area` VALUES ('2609', '富民县', '2601', '1');
INSERT INTO `bbs_area` VALUES ('2610', '宜良县', '2601', '1');
INSERT INTO `bbs_area` VALUES ('2611', '石林彝族自治县', '2601', '1');
INSERT INTO `bbs_area` VALUES ('2612', '嵩明县', '2601', '1');
INSERT INTO `bbs_area` VALUES ('2613', '禄劝彝族苗族自治县', '2601', '1');
INSERT INTO `bbs_area` VALUES ('2614', '寻甸回族彝族自治县', '2601', '1');
INSERT INTO `bbs_area` VALUES ('2615', '安宁市', '2601', '1');
INSERT INTO `bbs_area` VALUES ('2616', '曲靖市', '2600', '1');
INSERT INTO `bbs_area` VALUES ('2617', '麒麟区', '2616', '1');
INSERT INTO `bbs_area` VALUES ('2618', '马龙县', '2616', '1');
INSERT INTO `bbs_area` VALUES ('2619', '陆良县', '2616', '1');
INSERT INTO `bbs_area` VALUES ('2620', '师宗县', '2616', '1');
INSERT INTO `bbs_area` VALUES ('2621', '罗平县', '2616', '1');
INSERT INTO `bbs_area` VALUES ('2622', '富源县', '2616', '1');
INSERT INTO `bbs_area` VALUES ('2623', '会泽县', '2616', '1');
INSERT INTO `bbs_area` VALUES ('2624', '沾益县', '2616', '1');
INSERT INTO `bbs_area` VALUES ('2625', '宣威市', '2616', '1');
INSERT INTO `bbs_area` VALUES ('2626', '玉溪市', '2600', '1');
INSERT INTO `bbs_area` VALUES ('2627', '红塔区', '2626', '1');
INSERT INTO `bbs_area` VALUES ('2628', '江川县', '2626', '1');
INSERT INTO `bbs_area` VALUES ('2629', '澄江县', '2626', '1');
INSERT INTO `bbs_area` VALUES ('2630', '通海县', '2626', '1');
INSERT INTO `bbs_area` VALUES ('2631', '华宁县', '2626', '1');
INSERT INTO `bbs_area` VALUES ('2632', '易门县', '2626', '1');
INSERT INTO `bbs_area` VALUES ('2633', '峨山彝族自治县', '2626', '1');
INSERT INTO `bbs_area` VALUES ('2634', '新平彝族傣族自治县', '2626', '1');
INSERT INTO `bbs_area` VALUES ('2635', '元江哈尼族彝族傣族自治县', '2626', '1');
INSERT INTO `bbs_area` VALUES ('2636', '保山市', '2600', '1');
INSERT INTO `bbs_area` VALUES ('2637', '隆阳区', '2636', '1');
INSERT INTO `bbs_area` VALUES ('2638', '施甸县', '2636', '1');
INSERT INTO `bbs_area` VALUES ('2639', '腾冲县', '2636', '1');
INSERT INTO `bbs_area` VALUES ('2640', '龙陵县', '2636', '1');
INSERT INTO `bbs_area` VALUES ('2641', '昌宁县', '2636', '1');
INSERT INTO `bbs_area` VALUES ('2642', '昭通市', '2600', '1');
INSERT INTO `bbs_area` VALUES ('2643', '昭阳区', '2642', '1');
INSERT INTO `bbs_area` VALUES ('2644', '鲁甸县', '2642', '1');
INSERT INTO `bbs_area` VALUES ('2645', '巧家县', '2642', '1');
INSERT INTO `bbs_area` VALUES ('2646', '盐津县', '2642', '1');
INSERT INTO `bbs_area` VALUES ('2647', '大关县', '2642', '1');
INSERT INTO `bbs_area` VALUES ('2648', '永善县', '2642', '1');
INSERT INTO `bbs_area` VALUES ('2649', '绥江县', '2642', '1');
INSERT INTO `bbs_area` VALUES ('2650', '镇雄县', '2642', '1');
INSERT INTO `bbs_area` VALUES ('2651', '彝良县', '2642', '1');
INSERT INTO `bbs_area` VALUES ('2652', '威信县', '2642', '1');
INSERT INTO `bbs_area` VALUES ('2653', '水富县', '2642', '1');
INSERT INTO `bbs_area` VALUES ('2654', '丽江市', '2600', '1');
INSERT INTO `bbs_area` VALUES ('2655', '古城区', '2654', '1');
INSERT INTO `bbs_area` VALUES ('2656', '玉龙纳西族自治县', '2654', '1');
INSERT INTO `bbs_area` VALUES ('2657', '永胜县', '2654', '1');
INSERT INTO `bbs_area` VALUES ('2658', '华坪县', '2654', '1');
INSERT INTO `bbs_area` VALUES ('2659', '宁蒗彝族自治县', '2654', '1');
INSERT INTO `bbs_area` VALUES ('2660', '普洱市', '2600', '1');
INSERT INTO `bbs_area` VALUES ('2661', '思茅区', '2660', '1');
INSERT INTO `bbs_area` VALUES ('2662', '宁洱哈尼族彝族自治县', '2660', '1');
INSERT INTO `bbs_area` VALUES ('2663', '墨江哈尼族自治县', '2660', '1');
INSERT INTO `bbs_area` VALUES ('2664', '景东彝族自治县', '2660', '1');
INSERT INTO `bbs_area` VALUES ('2665', '景谷傣族彝族自治县', '2660', '1');
INSERT INTO `bbs_area` VALUES ('2666', '镇沅彝族哈尼族拉祜族自治县', '2660', '1');
INSERT INTO `bbs_area` VALUES ('2667', '江城哈尼族彝族自治县', '2660', '1');
INSERT INTO `bbs_area` VALUES ('2668', '孟连傣族拉祜族佤族自治县', '2660', '1');
INSERT INTO `bbs_area` VALUES ('2669', '澜沧拉祜族自治县', '2660', '1');
INSERT INTO `bbs_area` VALUES ('2670', '西盟佤族自治县', '2660', '1');
INSERT INTO `bbs_area` VALUES ('2671', '临沧市', '2600', '1');
INSERT INTO `bbs_area` VALUES ('2672', '临翔区', '2671', '1');
INSERT INTO `bbs_area` VALUES ('2673', '凤庆县', '2671', '1');
INSERT INTO `bbs_area` VALUES ('2674', '云县', '2671', '1');
INSERT INTO `bbs_area` VALUES ('2675', '永德县', '2671', '1');
INSERT INTO `bbs_area` VALUES ('2676', '镇康县', '2671', '1');
INSERT INTO `bbs_area` VALUES ('2677', '双江拉祜族佤族布朗族傣族自治县', '2671', '1');
INSERT INTO `bbs_area` VALUES ('2678', '耿马傣族佤族自治县', '2671', '1');
INSERT INTO `bbs_area` VALUES ('2679', '沧源佤族自治县', '2671', '1');
INSERT INTO `bbs_area` VALUES ('2680', '楚雄彝族自治州', '2600', '1');
INSERT INTO `bbs_area` VALUES ('2681', '楚雄市', '2680', '1');
INSERT INTO `bbs_area` VALUES ('2682', '双柏县', '2680', '1');
INSERT INTO `bbs_area` VALUES ('2683', '牟定县', '2680', '1');
INSERT INTO `bbs_area` VALUES ('2684', '南华县', '2680', '1');
INSERT INTO `bbs_area` VALUES ('2685', '姚安县', '2680', '1');
INSERT INTO `bbs_area` VALUES ('2686', '大姚县', '2680', '1');
INSERT INTO `bbs_area` VALUES ('2687', '永仁县', '2680', '1');
INSERT INTO `bbs_area` VALUES ('2688', '元谋县', '2680', '1');
INSERT INTO `bbs_area` VALUES ('2689', '武定县', '2680', '1');
INSERT INTO `bbs_area` VALUES ('2690', '禄丰县', '2680', '1');
INSERT INTO `bbs_area` VALUES ('2691', '红河哈尼族彝族自治州', '2600', '1');
INSERT INTO `bbs_area` VALUES ('2692', '个旧市', '2691', '1');
INSERT INTO `bbs_area` VALUES ('2693', '开远市', '2691', '1');
INSERT INTO `bbs_area` VALUES ('2694', '蒙自县', '2691', '1');
INSERT INTO `bbs_area` VALUES ('2695', '屏边苗族自治县', '2691', '1');
INSERT INTO `bbs_area` VALUES ('2696', '建水县', '2691', '1');
INSERT INTO `bbs_area` VALUES ('2697', '石屏县', '2691', '1');
INSERT INTO `bbs_area` VALUES ('2698', '弥勒县', '2691', '1');
INSERT INTO `bbs_area` VALUES ('2699', '泸西县', '2691', '1');
INSERT INTO `bbs_area` VALUES ('2700', '元阳县', '2691', '1');
INSERT INTO `bbs_area` VALUES ('2701', '红河县', '2691', '1');
INSERT INTO `bbs_area` VALUES ('2702', '金平苗族瑶族傣族自治县', '2691', '1');
INSERT INTO `bbs_area` VALUES ('2703', '绿春县', '2691', '1');
INSERT INTO `bbs_area` VALUES ('2704', '河口瑶族自治县', '2691', '1');
INSERT INTO `bbs_area` VALUES ('2705', '文山壮族苗族自治州', '2600', '1');
INSERT INTO `bbs_area` VALUES ('2706', '文山县', '2705', '1');
INSERT INTO `bbs_area` VALUES ('2707', '砚山县', '2705', '1');
INSERT INTO `bbs_area` VALUES ('2708', '西畴县', '2705', '1');
INSERT INTO `bbs_area` VALUES ('2709', '麻栗坡县', '2705', '1');
INSERT INTO `bbs_area` VALUES ('2710', '马关县', '2705', '1');
INSERT INTO `bbs_area` VALUES ('2711', '丘北县', '2705', '1');
INSERT INTO `bbs_area` VALUES ('2712', '广南县', '2705', '1');
INSERT INTO `bbs_area` VALUES ('2713', '富宁县', '2705', '1');
INSERT INTO `bbs_area` VALUES ('2714', '西双版纳傣族自治州', '2600', '1');
INSERT INTO `bbs_area` VALUES ('2715', '景洪市', '2714', '1');
INSERT INTO `bbs_area` VALUES ('2716', '勐海县', '2714', '1');
INSERT INTO `bbs_area` VALUES ('2717', '勐腊县', '2714', '1');
INSERT INTO `bbs_area` VALUES ('2718', '大理白族自治州', '2600', '1');
INSERT INTO `bbs_area` VALUES ('2719', '大理市', '2718', '1');
INSERT INTO `bbs_area` VALUES ('2720', '漾濞彝族自治县', '2718', '1');
INSERT INTO `bbs_area` VALUES ('2721', '祥云县', '2718', '1');
INSERT INTO `bbs_area` VALUES ('2722', '宾川县', '2718', '1');
INSERT INTO `bbs_area` VALUES ('2723', '弥渡县', '2718', '1');
INSERT INTO `bbs_area` VALUES ('2724', '南涧彝族自治县', '2718', '1');
INSERT INTO `bbs_area` VALUES ('2725', '巍山彝族回族自治县', '2718', '1');
INSERT INTO `bbs_area` VALUES ('2726', '永平县', '2718', '1');
INSERT INTO `bbs_area` VALUES ('2727', '云龙县', '2718', '1');
INSERT INTO `bbs_area` VALUES ('2728', '洱源县', '2718', '1');
INSERT INTO `bbs_area` VALUES ('2729', '剑川县', '2718', '1');
INSERT INTO `bbs_area` VALUES ('2730', '鹤庆县', '2718', '1');
INSERT INTO `bbs_area` VALUES ('2731', '德宏傣族景颇族自治州', '2600', '1');
INSERT INTO `bbs_area` VALUES ('2732', '瑞丽市', '2731', '1');
INSERT INTO `bbs_area` VALUES ('2733', '潞西市', '2731', '1');
INSERT INTO `bbs_area` VALUES ('2734', '梁河县', '2731', '1');
INSERT INTO `bbs_area` VALUES ('2735', '盈江县', '2731', '1');
INSERT INTO `bbs_area` VALUES ('2736', '陇川县', '2731', '1');
INSERT INTO `bbs_area` VALUES ('2737', '怒江傈僳族自治州', '2600', '1');
INSERT INTO `bbs_area` VALUES ('2738', '泸水县', '2737', '1');
INSERT INTO `bbs_area` VALUES ('2739', '福贡县', '2737', '1');
INSERT INTO `bbs_area` VALUES ('2740', '贡山独龙族怒族自治县', '2737', '1');
INSERT INTO `bbs_area` VALUES ('2741', '兰坪白族普米族自治县', '2737', '1');
INSERT INTO `bbs_area` VALUES ('2742', '迪庆藏族自治州', '2600', '1');
INSERT INTO `bbs_area` VALUES ('2743', '香格里拉县', '2742', '1');
INSERT INTO `bbs_area` VALUES ('2744', '德钦县', '2742', '1');
INSERT INTO `bbs_area` VALUES ('2745', '维西傈僳族自治县', '2742', '1');
INSERT INTO `bbs_area` VALUES ('2746', '西藏', '0', '1');
INSERT INTO `bbs_area` VALUES ('2747', '拉萨市', '2746', '1');
INSERT INTO `bbs_area` VALUES ('2748', '城关区', '2747', '1');
INSERT INTO `bbs_area` VALUES ('2749', '林周县', '2747', '1');
INSERT INTO `bbs_area` VALUES ('2750', '当雄县', '2747', '1');
INSERT INTO `bbs_area` VALUES ('2751', '尼木县', '2747', '1');
INSERT INTO `bbs_area` VALUES ('2752', '曲水县', '2747', '1');
INSERT INTO `bbs_area` VALUES ('2753', '堆龙德庆县', '2747', '1');
INSERT INTO `bbs_area` VALUES ('2754', '达孜县', '2747', '1');
INSERT INTO `bbs_area` VALUES ('2755', '墨竹工卡县', '2747', '1');
INSERT INTO `bbs_area` VALUES ('2756', '昌都地区', '2746', '1');
INSERT INTO `bbs_area` VALUES ('2757', '昌都县', '2756', '1');
INSERT INTO `bbs_area` VALUES ('2758', '江达县', '2756', '1');
INSERT INTO `bbs_area` VALUES ('2759', '贡觉县', '2756', '1');
INSERT INTO `bbs_area` VALUES ('2760', '类乌齐县', '2756', '1');
INSERT INTO `bbs_area` VALUES ('2761', '丁青县', '2756', '1');
INSERT INTO `bbs_area` VALUES ('2762', '察雅县', '2756', '1');
INSERT INTO `bbs_area` VALUES ('2763', '八宿县', '2756', '1');
INSERT INTO `bbs_area` VALUES ('2764', '左贡县', '2756', '1');
INSERT INTO `bbs_area` VALUES ('2765', '芒康县', '2756', '1');
INSERT INTO `bbs_area` VALUES ('2766', '洛隆县', '2756', '1');
INSERT INTO `bbs_area` VALUES ('2767', '边坝县', '2756', '1');
INSERT INTO `bbs_area` VALUES ('2768', '山南地区', '2746', '1');
INSERT INTO `bbs_area` VALUES ('2769', '乃东县', '2768', '1');
INSERT INTO `bbs_area` VALUES ('2770', '扎囊县', '2768', '1');
INSERT INTO `bbs_area` VALUES ('2771', '贡嘎县', '2768', '1');
INSERT INTO `bbs_area` VALUES ('2772', '桑日县', '2768', '1');
INSERT INTO `bbs_area` VALUES ('2773', '琼结县', '2768', '1');
INSERT INTO `bbs_area` VALUES ('2774', '曲松县', '2768', '1');
INSERT INTO `bbs_area` VALUES ('2775', '措美县', '2768', '1');
INSERT INTO `bbs_area` VALUES ('2776', '洛扎县', '2768', '1');
INSERT INTO `bbs_area` VALUES ('2777', '加查县', '2768', '1');
INSERT INTO `bbs_area` VALUES ('2778', '隆子县', '2768', '1');
INSERT INTO `bbs_area` VALUES ('2779', '错那县', '2768', '1');
INSERT INTO `bbs_area` VALUES ('2780', '浪卡子县', '2768', '1');
INSERT INTO `bbs_area` VALUES ('2781', '日喀则地区', '2746', '1');
INSERT INTO `bbs_area` VALUES ('2782', '日喀则市', '2781', '1');
INSERT INTO `bbs_area` VALUES ('2783', '南木林县', '2781', '1');
INSERT INTO `bbs_area` VALUES ('2784', '江孜县', '2781', '1');
INSERT INTO `bbs_area` VALUES ('2785', '定日县', '2781', '1');
INSERT INTO `bbs_area` VALUES ('2786', '萨迦县', '2781', '1');
INSERT INTO `bbs_area` VALUES ('2787', '拉孜县', '2781', '1');
INSERT INTO `bbs_area` VALUES ('2788', '昂仁县', '2781', '1');
INSERT INTO `bbs_area` VALUES ('2789', '谢通门县', '2781', '1');
INSERT INTO `bbs_area` VALUES ('2790', '白朗县', '2781', '1');
INSERT INTO `bbs_area` VALUES ('2791', '仁布县', '2781', '1');
INSERT INTO `bbs_area` VALUES ('2792', '康马县', '2781', '1');
INSERT INTO `bbs_area` VALUES ('2793', '定结县', '2781', '1');
INSERT INTO `bbs_area` VALUES ('2794', '仲巴县', '2781', '1');
INSERT INTO `bbs_area` VALUES ('2795', '亚东县', '2781', '1');
INSERT INTO `bbs_area` VALUES ('2796', '吉隆县', '2781', '1');
INSERT INTO `bbs_area` VALUES ('2797', '聂拉木县', '2781', '1');
INSERT INTO `bbs_area` VALUES ('2798', '萨嘎县', '2781', '1');
INSERT INTO `bbs_area` VALUES ('2799', '岗巴县', '2781', '1');
INSERT INTO `bbs_area` VALUES ('2800', '那曲地区', '2746', '1');
INSERT INTO `bbs_area` VALUES ('2801', '那曲县', '2800', '1');
INSERT INTO `bbs_area` VALUES ('2802', '嘉黎县', '2800', '1');
INSERT INTO `bbs_area` VALUES ('2803', '比如县', '2800', '1');
INSERT INTO `bbs_area` VALUES ('2804', '聂荣县', '2800', '1');
INSERT INTO `bbs_area` VALUES ('2805', '安多县', '2800', '1');
INSERT INTO `bbs_area` VALUES ('2806', '申扎县', '2800', '1');
INSERT INTO `bbs_area` VALUES ('2807', '索县', '2800', '1');
INSERT INTO `bbs_area` VALUES ('2808', '班戈县', '2800', '1');
INSERT INTO `bbs_area` VALUES ('2809', '巴青县', '2800', '1');
INSERT INTO `bbs_area` VALUES ('2810', '尼玛县', '2800', '1');
INSERT INTO `bbs_area` VALUES ('2811', '阿里地区', '2746', '1');
INSERT INTO `bbs_area` VALUES ('2812', '普兰县', '2811', '1');
INSERT INTO `bbs_area` VALUES ('2813', '札达县', '2811', '1');
INSERT INTO `bbs_area` VALUES ('2814', '噶尔县', '2811', '1');
INSERT INTO `bbs_area` VALUES ('2815', '日土县', '2811', '1');
INSERT INTO `bbs_area` VALUES ('2816', '革吉县', '2811', '1');
INSERT INTO `bbs_area` VALUES ('2817', '改则县', '2811', '1');
INSERT INTO `bbs_area` VALUES ('2818', '措勤县', '2811', '1');
INSERT INTO `bbs_area` VALUES ('2819', '林芝地区', '2746', '1');
INSERT INTO `bbs_area` VALUES ('2820', '林芝县', '2819', '1');
INSERT INTO `bbs_area` VALUES ('2821', '工布江达县', '2819', '1');
INSERT INTO `bbs_area` VALUES ('2822', '米林县', '2819', '1');
INSERT INTO `bbs_area` VALUES ('2823', '墨脱县', '2819', '1');
INSERT INTO `bbs_area` VALUES ('2824', '波密县', '2819', '1');
INSERT INTO `bbs_area` VALUES ('2825', '察隅县', '2819', '1');
INSERT INTO `bbs_area` VALUES ('2826', '朗县', '2819', '1');
INSERT INTO `bbs_area` VALUES ('2827', '陕西', '0', '1');
INSERT INTO `bbs_area` VALUES ('2828', '西安市', '2827', '1');
INSERT INTO `bbs_area` VALUES ('2829', '新城区', '2828', '1');
INSERT INTO `bbs_area` VALUES ('2830', '碑林区', '2828', '1');
INSERT INTO `bbs_area` VALUES ('2831', '莲湖区', '2828', '1');
INSERT INTO `bbs_area` VALUES ('2832', '灞桥区', '2828', '1');
INSERT INTO `bbs_area` VALUES ('2833', '未央区', '2828', '1');
INSERT INTO `bbs_area` VALUES ('2834', '雁塔区', '2828', '1');
INSERT INTO `bbs_area` VALUES ('2835', '阎良区', '2828', '1');
INSERT INTO `bbs_area` VALUES ('2836', '临潼区', '2828', '1');
INSERT INTO `bbs_area` VALUES ('2837', '长安区', '2828', '1');
INSERT INTO `bbs_area` VALUES ('2838', '蓝田县', '2828', '1');
INSERT INTO `bbs_area` VALUES ('2839', '周至县', '2828', '1');
INSERT INTO `bbs_area` VALUES ('2840', '户县', '2828', '1');
INSERT INTO `bbs_area` VALUES ('2841', '高陵县', '2828', '1');
INSERT INTO `bbs_area` VALUES ('2842', '铜川市', '2827', '1');
INSERT INTO `bbs_area` VALUES ('2843', '王益区', '2842', '1');
INSERT INTO `bbs_area` VALUES ('2844', '印台区', '2842', '1');
INSERT INTO `bbs_area` VALUES ('2845', '耀州区', '2842', '1');
INSERT INTO `bbs_area` VALUES ('2846', '宜君县', '2842', '1');
INSERT INTO `bbs_area` VALUES ('2847', '宝鸡市', '2827', '1');
INSERT INTO `bbs_area` VALUES ('2848', '渭滨区', '2847', '1');
INSERT INTO `bbs_area` VALUES ('2849', '金台区', '2847', '1');
INSERT INTO `bbs_area` VALUES ('2850', '陈仓区', '2847', '1');
INSERT INTO `bbs_area` VALUES ('2851', '凤翔县', '2847', '1');
INSERT INTO `bbs_area` VALUES ('2852', '岐山县', '2847', '1');
INSERT INTO `bbs_area` VALUES ('2853', '扶风县', '2847', '1');
INSERT INTO `bbs_area` VALUES ('2854', '眉县', '2847', '1');
INSERT INTO `bbs_area` VALUES ('2855', '陇县', '2847', '1');
INSERT INTO `bbs_area` VALUES ('2856', '千阳县', '2847', '1');
INSERT INTO `bbs_area` VALUES ('2857', '麟游县', '2847', '1');
INSERT INTO `bbs_area` VALUES ('2858', '凤县', '2847', '1');
INSERT INTO `bbs_area` VALUES ('2859', '太白县', '2847', '1');
INSERT INTO `bbs_area` VALUES ('2860', '咸阳市', '2827', '1');
INSERT INTO `bbs_area` VALUES ('2861', '秦都区', '2860', '1');
INSERT INTO `bbs_area` VALUES ('2862', '杨凌区', '2860', '1');
INSERT INTO `bbs_area` VALUES ('2863', '渭城区', '2860', '1');
INSERT INTO `bbs_area` VALUES ('2864', '三原县', '2860', '1');
INSERT INTO `bbs_area` VALUES ('2865', '泾阳县', '2860', '1');
INSERT INTO `bbs_area` VALUES ('2866', '乾县', '2860', '1');
INSERT INTO `bbs_area` VALUES ('2867', '礼泉县', '2860', '1');
INSERT INTO `bbs_area` VALUES ('2868', '永寿县', '2860', '1');
INSERT INTO `bbs_area` VALUES ('2869', '彬县', '2860', '1');
INSERT INTO `bbs_area` VALUES ('2870', '长武县', '2860', '1');
INSERT INTO `bbs_area` VALUES ('2871', '旬邑县', '2860', '1');
INSERT INTO `bbs_area` VALUES ('2872', '淳化县', '2860', '1');
INSERT INTO `bbs_area` VALUES ('2873', '武功县', '2860', '1');
INSERT INTO `bbs_area` VALUES ('2874', '兴平市', '2860', '1');
INSERT INTO `bbs_area` VALUES ('2875', '渭南市', '2827', '1');
INSERT INTO `bbs_area` VALUES ('2876', '临渭区', '2875', '1');
INSERT INTO `bbs_area` VALUES ('2877', '华县', '2875', '1');
INSERT INTO `bbs_area` VALUES ('2878', '潼关县', '2875', '1');
INSERT INTO `bbs_area` VALUES ('2879', '大荔县', '2875', '1');
INSERT INTO `bbs_area` VALUES ('2880', '合阳县', '2875', '1');
INSERT INTO `bbs_area` VALUES ('2881', '澄城县', '2875', '1');
INSERT INTO `bbs_area` VALUES ('2882', '蒲城县', '2875', '1');
INSERT INTO `bbs_area` VALUES ('2883', '白水县', '2875', '1');
INSERT INTO `bbs_area` VALUES ('2884', '富平县', '2875', '1');
INSERT INTO `bbs_area` VALUES ('2885', '韩城市', '2875', '1');
INSERT INTO `bbs_area` VALUES ('2886', '华阴市', '2875', '1');
INSERT INTO `bbs_area` VALUES ('2887', '延安市', '2827', '1');
INSERT INTO `bbs_area` VALUES ('2888', '宝塔区', '2887', '1');
INSERT INTO `bbs_area` VALUES ('2889', '延长县', '2887', '1');
INSERT INTO `bbs_area` VALUES ('2890', '延川县', '2887', '1');
INSERT INTO `bbs_area` VALUES ('2891', '子长县', '2887', '1');
INSERT INTO `bbs_area` VALUES ('2892', '安塞县', '2887', '1');
INSERT INTO `bbs_area` VALUES ('2893', '志丹县', '2887', '1');
INSERT INTO `bbs_area` VALUES ('2894', '吴起县', '2887', '1');
INSERT INTO `bbs_area` VALUES ('2895', '甘泉县', '2887', '1');
INSERT INTO `bbs_area` VALUES ('2896', '富县', '2887', '1');
INSERT INTO `bbs_area` VALUES ('2897', '洛川县', '2887', '1');
INSERT INTO `bbs_area` VALUES ('2898', '宜川县', '2887', '1');
INSERT INTO `bbs_area` VALUES ('2899', '黄龙县', '2887', '1');
INSERT INTO `bbs_area` VALUES ('2900', '黄陵县', '2887', '1');
INSERT INTO `bbs_area` VALUES ('2901', '汉中市', '2827', '1');
INSERT INTO `bbs_area` VALUES ('2902', '汉台区', '2901', '1');
INSERT INTO `bbs_area` VALUES ('2903', '南郑县', '2901', '1');
INSERT INTO `bbs_area` VALUES ('2904', '城固县', '2901', '1');
INSERT INTO `bbs_area` VALUES ('2905', '洋县', '2901', '1');
INSERT INTO `bbs_area` VALUES ('2906', '西乡县', '2901', '1');
INSERT INTO `bbs_area` VALUES ('2907', '勉县', '2901', '1');
INSERT INTO `bbs_area` VALUES ('2908', '宁强县', '2901', '1');
INSERT INTO `bbs_area` VALUES ('2909', '略阳县', '2901', '1');
INSERT INTO `bbs_area` VALUES ('2910', '镇巴县', '2901', '1');
INSERT INTO `bbs_area` VALUES ('2911', '留坝县', '2901', '1');
INSERT INTO `bbs_area` VALUES ('2912', '佛坪县', '2901', '1');
INSERT INTO `bbs_area` VALUES ('2913', '榆林市', '2827', '1');
INSERT INTO `bbs_area` VALUES ('2914', '榆阳区', '2913', '1');
INSERT INTO `bbs_area` VALUES ('2915', '神木县', '2913', '1');
INSERT INTO `bbs_area` VALUES ('2916', '府谷县', '2913', '1');
INSERT INTO `bbs_area` VALUES ('2917', '横山县', '2913', '1');
INSERT INTO `bbs_area` VALUES ('2918', '靖边县', '2913', '1');
INSERT INTO `bbs_area` VALUES ('2919', '定边县', '2913', '1');
INSERT INTO `bbs_area` VALUES ('2920', '绥德县', '2913', '1');
INSERT INTO `bbs_area` VALUES ('2921', '米脂县', '2913', '1');
INSERT INTO `bbs_area` VALUES ('2922', '佳县', '2913', '1');
INSERT INTO `bbs_area` VALUES ('2923', '吴堡县', '2913', '1');
INSERT INTO `bbs_area` VALUES ('2924', '清涧县', '2913', '1');
INSERT INTO `bbs_area` VALUES ('2925', '子洲县', '2913', '1');
INSERT INTO `bbs_area` VALUES ('2926', '安康市', '2827', '1');
INSERT INTO `bbs_area` VALUES ('2927', '汉滨区', '2926', '1');
INSERT INTO `bbs_area` VALUES ('2928', '汉阴县', '2926', '1');
INSERT INTO `bbs_area` VALUES ('2929', '石泉县', '2926', '1');
INSERT INTO `bbs_area` VALUES ('2930', '宁陕县', '2926', '1');
INSERT INTO `bbs_area` VALUES ('2931', '紫阳县', '2926', '1');
INSERT INTO `bbs_area` VALUES ('2932', '岚皋县', '2926', '1');
INSERT INTO `bbs_area` VALUES ('2933', '平利县', '2926', '1');
INSERT INTO `bbs_area` VALUES ('2934', '镇坪县', '2926', '1');
INSERT INTO `bbs_area` VALUES ('2935', '旬阳县', '2926', '1');
INSERT INTO `bbs_area` VALUES ('2936', '白河县', '2926', '1');
INSERT INTO `bbs_area` VALUES ('2937', '商洛市', '2827', '1');
INSERT INTO `bbs_area` VALUES ('2938', '商州区', '2937', '1');
INSERT INTO `bbs_area` VALUES ('2939', '洛南县', '2937', '1');
INSERT INTO `bbs_area` VALUES ('2940', '丹凤县', '2937', '1');
INSERT INTO `bbs_area` VALUES ('2941', '商南县', '2937', '1');
INSERT INTO `bbs_area` VALUES ('2942', '山阳县', '2937', '1');
INSERT INTO `bbs_area` VALUES ('2943', '镇安县', '2937', '1');
INSERT INTO `bbs_area` VALUES ('2944', '柞水县', '2937', '1');
INSERT INTO `bbs_area` VALUES ('2945', '甘肃', '0', '1');
INSERT INTO `bbs_area` VALUES ('2946', '兰州市', '2945', '1');
INSERT INTO `bbs_area` VALUES ('2947', '城关区', '2946', '1');
INSERT INTO `bbs_area` VALUES ('2948', '七里河区', '2946', '1');
INSERT INTO `bbs_area` VALUES ('2949', '西固区', '2946', '1');
INSERT INTO `bbs_area` VALUES ('2950', '安宁区', '2946', '1');
INSERT INTO `bbs_area` VALUES ('2951', '红古区', '2946', '1');
INSERT INTO `bbs_area` VALUES ('2952', '永登县', '2946', '1');
INSERT INTO `bbs_area` VALUES ('2953', '皋兰县', '2946', '1');
INSERT INTO `bbs_area` VALUES ('2954', '榆中县', '2946', '1');
INSERT INTO `bbs_area` VALUES ('2955', '嘉峪关市', '2945', '1');
INSERT INTO `bbs_area` VALUES ('2956', '金昌市', '2945', '1');
INSERT INTO `bbs_area` VALUES ('2957', '金川区', '2956', '1');
INSERT INTO `bbs_area` VALUES ('2958', '永昌县', '2956', '1');
INSERT INTO `bbs_area` VALUES ('2959', '白银市', '2945', '1');
INSERT INTO `bbs_area` VALUES ('2960', '白银区', '2959', '1');
INSERT INTO `bbs_area` VALUES ('2961', '平川区', '2959', '1');
INSERT INTO `bbs_area` VALUES ('2962', '靖远县', '2959', '1');
INSERT INTO `bbs_area` VALUES ('2963', '会宁县', '2959', '1');
INSERT INTO `bbs_area` VALUES ('2964', '景泰县', '2959', '1');
INSERT INTO `bbs_area` VALUES ('2965', '天水市', '2945', '1');
INSERT INTO `bbs_area` VALUES ('2966', '秦州区', '2965', '1');
INSERT INTO `bbs_area` VALUES ('2967', '麦积区', '2965', '1');
INSERT INTO `bbs_area` VALUES ('2968', '清水县', '2965', '1');
INSERT INTO `bbs_area` VALUES ('2969', '秦安县', '2965', '1');
INSERT INTO `bbs_area` VALUES ('2970', '甘谷县', '2965', '1');
INSERT INTO `bbs_area` VALUES ('2971', '武山县', '2965', '1');
INSERT INTO `bbs_area` VALUES ('2972', '张家川回族自治县', '2965', '1');
INSERT INTO `bbs_area` VALUES ('2973', '武威市', '2945', '1');
INSERT INTO `bbs_area` VALUES ('2974', '凉州区', '2973', '1');
INSERT INTO `bbs_area` VALUES ('2975', '民勤县', '2973', '1');
INSERT INTO `bbs_area` VALUES ('2976', '古浪县', '2973', '1');
INSERT INTO `bbs_area` VALUES ('2977', '天祝藏族自治县', '2973', '1');
INSERT INTO `bbs_area` VALUES ('2978', '张掖市', '2945', '1');
INSERT INTO `bbs_area` VALUES ('2979', '甘州区', '2978', '1');
INSERT INTO `bbs_area` VALUES ('2980', '肃南裕固族自治县', '2978', '1');
INSERT INTO `bbs_area` VALUES ('2981', '民乐县', '2978', '1');
INSERT INTO `bbs_area` VALUES ('2982', '临泽县', '2978', '1');
INSERT INTO `bbs_area` VALUES ('2983', '高台县', '2978', '1');
INSERT INTO `bbs_area` VALUES ('2984', '山丹县', '2978', '1');
INSERT INTO `bbs_area` VALUES ('2985', '平凉市', '2945', '1');
INSERT INTO `bbs_area` VALUES ('2986', '崆峒区', '2985', '1');
INSERT INTO `bbs_area` VALUES ('2987', '泾川县', '2985', '1');
INSERT INTO `bbs_area` VALUES ('2988', '灵台县', '2985', '1');
INSERT INTO `bbs_area` VALUES ('2989', '崇信县', '2985', '1');
INSERT INTO `bbs_area` VALUES ('2990', '华亭县', '2985', '1');
INSERT INTO `bbs_area` VALUES ('2991', '庄浪县', '2985', '1');
INSERT INTO `bbs_area` VALUES ('2992', '静宁县', '2985', '1');
INSERT INTO `bbs_area` VALUES ('2993', '酒泉市', '2945', '1');
INSERT INTO `bbs_area` VALUES ('2994', '肃州区', '2993', '1');
INSERT INTO `bbs_area` VALUES ('2995', '金塔县', '2993', '1');
INSERT INTO `bbs_area` VALUES ('2996', '瓜州县', '2993', '1');
INSERT INTO `bbs_area` VALUES ('2997', '肃北蒙古族自治县', '2993', '1');
INSERT INTO `bbs_area` VALUES ('2998', '阿克塞哈萨克族自治县', '2993', '1');
INSERT INTO `bbs_area` VALUES ('2999', '玉门市', '2993', '1');
INSERT INTO `bbs_area` VALUES ('3000', '敦煌市', '2993', '1');
INSERT INTO `bbs_area` VALUES ('3001', '庆阳市', '2945', '1');
INSERT INTO `bbs_area` VALUES ('3002', '西峰区', '3001', '1');
INSERT INTO `bbs_area` VALUES ('3003', '庆城县', '3001', '1');
INSERT INTO `bbs_area` VALUES ('3004', '环县', '3001', '1');
INSERT INTO `bbs_area` VALUES ('3005', '华池县', '3001', '1');
INSERT INTO `bbs_area` VALUES ('3006', '合水县', '3001', '1');
INSERT INTO `bbs_area` VALUES ('3007', '正宁县', '3001', '1');
INSERT INTO `bbs_area` VALUES ('3008', '宁县', '3001', '1');
INSERT INTO `bbs_area` VALUES ('3009', '镇原县', '3001', '1');
INSERT INTO `bbs_area` VALUES ('3010', '定西市', '2945', '1');
INSERT INTO `bbs_area` VALUES ('3011', '安定区', '3010', '1');
INSERT INTO `bbs_area` VALUES ('3012', '通渭县', '3010', '1');
INSERT INTO `bbs_area` VALUES ('3013', '陇西县', '3010', '1');
INSERT INTO `bbs_area` VALUES ('3014', '渭源县', '3010', '1');
INSERT INTO `bbs_area` VALUES ('3015', '临洮县', '3010', '1');
INSERT INTO `bbs_area` VALUES ('3016', '漳县', '3010', '1');
INSERT INTO `bbs_area` VALUES ('3017', '岷县', '3010', '1');
INSERT INTO `bbs_area` VALUES ('3018', '陇南市', '2945', '1');
INSERT INTO `bbs_area` VALUES ('3019', '武都区', '3018', '1');
INSERT INTO `bbs_area` VALUES ('3020', '成县', '3018', '1');
INSERT INTO `bbs_area` VALUES ('3021', '文县', '3018', '1');
INSERT INTO `bbs_area` VALUES ('3022', '宕昌县', '3018', '1');
INSERT INTO `bbs_area` VALUES ('3023', '康县', '3018', '1');
INSERT INTO `bbs_area` VALUES ('3024', '西和县', '3018', '1');
INSERT INTO `bbs_area` VALUES ('3025', '礼县', '3018', '1');
INSERT INTO `bbs_area` VALUES ('3026', '徽县', '3018', '1');
INSERT INTO `bbs_area` VALUES ('3027', '两当县', '3018', '1');
INSERT INTO `bbs_area` VALUES ('3028', '临夏回族自治州', '2945', '1');
INSERT INTO `bbs_area` VALUES ('3029', '临夏市', '3028', '1');
INSERT INTO `bbs_area` VALUES ('3030', '临夏县', '3028', '1');
INSERT INTO `bbs_area` VALUES ('3031', '康乐县', '3028', '1');
INSERT INTO `bbs_area` VALUES ('3032', '永靖县', '3028', '1');
INSERT INTO `bbs_area` VALUES ('3033', '广河县', '3028', '1');
INSERT INTO `bbs_area` VALUES ('3034', '和政县', '3028', '1');
INSERT INTO `bbs_area` VALUES ('3035', '东乡族自治县', '3028', '1');
INSERT INTO `bbs_area` VALUES ('3036', '积石山保安族东乡族撒拉族自治县', '3028', '1');
INSERT INTO `bbs_area` VALUES ('3037', '甘南藏族自治州', '2945', '1');
INSERT INTO `bbs_area` VALUES ('3038', '合作市', '3037', '1');
INSERT INTO `bbs_area` VALUES ('3039', '临潭县', '3037', '1');
INSERT INTO `bbs_area` VALUES ('3040', '卓尼县', '3037', '1');
INSERT INTO `bbs_area` VALUES ('3041', '舟曲县', '3037', '1');
INSERT INTO `bbs_area` VALUES ('3042', '迭部县', '3037', '1');
INSERT INTO `bbs_area` VALUES ('3043', '玛曲县', '3037', '1');
INSERT INTO `bbs_area` VALUES ('3044', '碌曲县', '3037', '1');
INSERT INTO `bbs_area` VALUES ('3045', '夏河县', '3037', '1');
INSERT INTO `bbs_area` VALUES ('3046', '青海', '0', '1');
INSERT INTO `bbs_area` VALUES ('3047', '西宁市', '3046', '1');
INSERT INTO `bbs_area` VALUES ('3048', '城东区', '3047', '1');
INSERT INTO `bbs_area` VALUES ('3049', '城中区', '3047', '1');
INSERT INTO `bbs_area` VALUES ('3050', '城西区', '3047', '1');
INSERT INTO `bbs_area` VALUES ('3051', '城北区', '3047', '1');
INSERT INTO `bbs_area` VALUES ('3052', '大通回族土族自治县', '3047', '1');
INSERT INTO `bbs_area` VALUES ('3053', '湟中县', '3047', '1');
INSERT INTO `bbs_area` VALUES ('3054', '湟源县', '3047', '1');
INSERT INTO `bbs_area` VALUES ('3055', '海东地区', '3046', '1');
INSERT INTO `bbs_area` VALUES ('3056', '平安县', '3055', '1');
INSERT INTO `bbs_area` VALUES ('3057', '民和回族土族自治县', '3055', '1');
INSERT INTO `bbs_area` VALUES ('3058', '乐都县', '3055', '1');
INSERT INTO `bbs_area` VALUES ('3059', '互助土族自治县', '3055', '1');
INSERT INTO `bbs_area` VALUES ('3060', '化隆回族自治县', '3055', '1');
INSERT INTO `bbs_area` VALUES ('3061', '循化撒拉族自治县', '3055', '1');
INSERT INTO `bbs_area` VALUES ('3062', '海北藏族自治州', '3046', '1');
INSERT INTO `bbs_area` VALUES ('3063', '门源回族自治县', '3062', '1');
INSERT INTO `bbs_area` VALUES ('3064', '祁连县', '3062', '1');
INSERT INTO `bbs_area` VALUES ('3065', '海晏县', '3062', '1');
INSERT INTO `bbs_area` VALUES ('3066', '刚察县', '3062', '1');
INSERT INTO `bbs_area` VALUES ('3067', '黄南藏族自治州', '3046', '1');
INSERT INTO `bbs_area` VALUES ('3068', '同仁县', '3067', '1');
INSERT INTO `bbs_area` VALUES ('3069', '尖扎县', '3067', '1');
INSERT INTO `bbs_area` VALUES ('3070', '泽库县', '3067', '1');
INSERT INTO `bbs_area` VALUES ('3071', '河南蒙古族自治县', '3067', '1');
INSERT INTO `bbs_area` VALUES ('3072', '海南藏族自治州', '3046', '1');
INSERT INTO `bbs_area` VALUES ('3073', '共和县', '3072', '1');
INSERT INTO `bbs_area` VALUES ('3074', '同德县', '3072', '1');
INSERT INTO `bbs_area` VALUES ('3075', '贵德县', '3072', '1');
INSERT INTO `bbs_area` VALUES ('3076', '兴海县', '3072', '1');
INSERT INTO `bbs_area` VALUES ('3077', '贵南县', '3072', '1');
INSERT INTO `bbs_area` VALUES ('3078', '果洛藏族自治州', '3046', '1');
INSERT INTO `bbs_area` VALUES ('3079', '玛沁县', '3078', '1');
INSERT INTO `bbs_area` VALUES ('3080', '班玛县', '3078', '1');
INSERT INTO `bbs_area` VALUES ('3081', '甘德县', '3078', '1');
INSERT INTO `bbs_area` VALUES ('3082', '达日县', '3078', '1');
INSERT INTO `bbs_area` VALUES ('3083', '久治县', '3078', '1');
INSERT INTO `bbs_area` VALUES ('3084', '玛多县', '3078', '1');
INSERT INTO `bbs_area` VALUES ('3085', '玉树藏族自治州', '3046', '1');
INSERT INTO `bbs_area` VALUES ('3086', '玉树县', '3085', '1');
INSERT INTO `bbs_area` VALUES ('3087', '杂多县', '3085', '1');
INSERT INTO `bbs_area` VALUES ('3088', '称多县', '3085', '1');
INSERT INTO `bbs_area` VALUES ('3089', '治多县', '3085', '1');
INSERT INTO `bbs_area` VALUES ('3090', '囊谦县', '3085', '1');
INSERT INTO `bbs_area` VALUES ('3091', '曲麻莱县', '3085', '1');
INSERT INTO `bbs_area` VALUES ('3092', '海西蒙古族藏族自治州', '3046', '1');
INSERT INTO `bbs_area` VALUES ('3093', '格尔木市', '3092', '1');
INSERT INTO `bbs_area` VALUES ('3094', '德令哈市', '3092', '1');
INSERT INTO `bbs_area` VALUES ('3095', '乌兰县', '3092', '1');
INSERT INTO `bbs_area` VALUES ('3096', '都兰县', '3092', '1');
INSERT INTO `bbs_area` VALUES ('3097', '天峻县', '3092', '1');
INSERT INTO `bbs_area` VALUES ('3098', '宁夏', '0', '1');
INSERT INTO `bbs_area` VALUES ('3099', '银川市', '3098', '1');
INSERT INTO `bbs_area` VALUES ('3100', '兴庆区', '3099', '1');
INSERT INTO `bbs_area` VALUES ('3101', '西夏区', '3099', '1');
INSERT INTO `bbs_area` VALUES ('3102', '金凤区', '3099', '1');
INSERT INTO `bbs_area` VALUES ('3103', '永宁县', '3099', '1');
INSERT INTO `bbs_area` VALUES ('3104', '贺兰县', '3099', '1');
INSERT INTO `bbs_area` VALUES ('3105', '灵武市', '3099', '1');
INSERT INTO `bbs_area` VALUES ('3106', '石嘴山市', '3098', '1');
INSERT INTO `bbs_area` VALUES ('3107', '大武口区', '3106', '1');
INSERT INTO `bbs_area` VALUES ('3108', '惠农区', '3106', '1');
INSERT INTO `bbs_area` VALUES ('3109', '平罗县', '3106', '1');
INSERT INTO `bbs_area` VALUES ('3110', '吴忠市', '3098', '1');
INSERT INTO `bbs_area` VALUES ('3111', '利通区', '3110', '1');
INSERT INTO `bbs_area` VALUES ('3112', '盐池县', '3110', '1');
INSERT INTO `bbs_area` VALUES ('3113', '同心县', '3110', '1');
INSERT INTO `bbs_area` VALUES ('3114', '青铜峡市', '3110', '1');
INSERT INTO `bbs_area` VALUES ('3115', '固原市', '3098', '1');
INSERT INTO `bbs_area` VALUES ('3116', '原州区', '3115', '1');
INSERT INTO `bbs_area` VALUES ('3117', '西吉县', '3115', '1');
INSERT INTO `bbs_area` VALUES ('3118', '隆德县', '3115', '1');
INSERT INTO `bbs_area` VALUES ('3119', '泾源县', '3115', '1');
INSERT INTO `bbs_area` VALUES ('3120', '彭阳县', '3115', '1');
INSERT INTO `bbs_area` VALUES ('3121', '中卫市', '3098', '1');
INSERT INTO `bbs_area` VALUES ('3122', '沙坡头区', '3121', '1');
INSERT INTO `bbs_area` VALUES ('3123', '中宁县', '3121', '1');
INSERT INTO `bbs_area` VALUES ('3124', '海原县', '3121', '1');
INSERT INTO `bbs_area` VALUES ('3125', '新疆', '0', '1');
INSERT INTO `bbs_area` VALUES ('3126', '乌鲁木齐市', '3125', '1');
INSERT INTO `bbs_area` VALUES ('3127', '天山区', '3126', '1');
INSERT INTO `bbs_area` VALUES ('3128', '沙依巴克区', '3126', '1');
INSERT INTO `bbs_area` VALUES ('3129', '新市区', '3126', '1');
INSERT INTO `bbs_area` VALUES ('3130', '水磨沟区', '3126', '1');
INSERT INTO `bbs_area` VALUES ('3131', '头屯河区', '3126', '1');
INSERT INTO `bbs_area` VALUES ('3132', '达坂城区', '3126', '1');
INSERT INTO `bbs_area` VALUES ('3133', '米东区', '3126', '1');
INSERT INTO `bbs_area` VALUES ('3134', '乌鲁木齐县', '3126', '1');
INSERT INTO `bbs_area` VALUES ('3135', '克拉玛依市', '3125', '1');
INSERT INTO `bbs_area` VALUES ('3136', '独山子区', '3135', '1');
INSERT INTO `bbs_area` VALUES ('3137', '克拉玛依区', '3135', '1');
INSERT INTO `bbs_area` VALUES ('3138', '白碱滩区', '3135', '1');
INSERT INTO `bbs_area` VALUES ('3139', '乌尔禾区', '3135', '1');
INSERT INTO `bbs_area` VALUES ('3140', '吐鲁番地区', '3125', '1');
INSERT INTO `bbs_area` VALUES ('3141', '吐鲁番市', '3140', '1');
INSERT INTO `bbs_area` VALUES ('3142', '鄯善县', '3140', '1');
INSERT INTO `bbs_area` VALUES ('3143', '托克逊县', '3140', '1');
INSERT INTO `bbs_area` VALUES ('3144', '哈密地区', '3125', '1');
INSERT INTO `bbs_area` VALUES ('3145', '昌吉回族自治州', '3125', '1');
INSERT INTO `bbs_area` VALUES ('3146', '昌吉市', '3145', '1');
INSERT INTO `bbs_area` VALUES ('3147', '阜康市', '3145', '1');
INSERT INTO `bbs_area` VALUES ('3148', '呼图壁县', '3145', '1');
INSERT INTO `bbs_area` VALUES ('3149', '玛纳斯县', '3145', '1');
INSERT INTO `bbs_area` VALUES ('3150', '奇台县', '3145', '1');
INSERT INTO `bbs_area` VALUES ('3151', '吉木萨尔县', '3145', '1');
INSERT INTO `bbs_area` VALUES ('3152', '木垒哈萨克自治县', '3145', '1');
INSERT INTO `bbs_area` VALUES ('3153', '博尔塔拉蒙古自治州', '3125', '1');
INSERT INTO `bbs_area` VALUES ('3154', '博乐市', '3153', '1');
INSERT INTO `bbs_area` VALUES ('3155', '精河县', '3153', '1');
INSERT INTO `bbs_area` VALUES ('3156', '温泉县', '3153', '1');
INSERT INTO `bbs_area` VALUES ('3157', '巴音郭楞蒙古自治州', '3125', '1');
INSERT INTO `bbs_area` VALUES ('3158', '库尔勒市', '3157', '1');
INSERT INTO `bbs_area` VALUES ('3159', '轮台县', '3157', '1');
INSERT INTO `bbs_area` VALUES ('3160', '尉犁县', '3157', '1');
INSERT INTO `bbs_area` VALUES ('3161', '若羌县', '3157', '1');
INSERT INTO `bbs_area` VALUES ('3162', '且末县', '3157', '1');
INSERT INTO `bbs_area` VALUES ('3163', '焉耆回族自治县', '3157', '1');
INSERT INTO `bbs_area` VALUES ('3164', '和静县', '3157', '1');
INSERT INTO `bbs_area` VALUES ('3165', '和硕县', '3157', '1');
INSERT INTO `bbs_area` VALUES ('3166', '博湖县', '3157', '1');
INSERT INTO `bbs_area` VALUES ('3167', '阿克苏地区', '3125', '1');
INSERT INTO `bbs_area` VALUES ('3168', '阿克苏市', '3167', '1');
INSERT INTO `bbs_area` VALUES ('3169', '温宿县', '3167', '1');
INSERT INTO `bbs_area` VALUES ('3170', '库车县', '3167', '1');
INSERT INTO `bbs_area` VALUES ('3171', '沙雅县', '3167', '1');
INSERT INTO `bbs_area` VALUES ('3172', '新和县', '3167', '1');
INSERT INTO `bbs_area` VALUES ('3173', '拜城县', '3167', '1');
INSERT INTO `bbs_area` VALUES ('3174', '乌什县', '3167', '1');
INSERT INTO `bbs_area` VALUES ('3175', '阿瓦提县', '3167', '1');
INSERT INTO `bbs_area` VALUES ('3176', '柯坪县', '3167', '1');
INSERT INTO `bbs_area` VALUES ('3177', '克孜勒苏柯尔克孜自治州', '3125', '1');
INSERT INTO `bbs_area` VALUES ('3178', '阿图什市', '3177', '1');
INSERT INTO `bbs_area` VALUES ('3179', '阿克陶县', '3177', '1');
INSERT INTO `bbs_area` VALUES ('3180', '阿合奇县', '3177', '1');
INSERT INTO `bbs_area` VALUES ('3181', '乌恰县', '3177', '1');
INSERT INTO `bbs_area` VALUES ('3182', '喀什地区', '3125', '1');
INSERT INTO `bbs_area` VALUES ('3183', '喀什市', '3182', '1');
INSERT INTO `bbs_area` VALUES ('3184', '疏附县', '3182', '1');
INSERT INTO `bbs_area` VALUES ('3185', '疏勒县', '3182', '1');
INSERT INTO `bbs_area` VALUES ('3186', '英吉沙县', '3182', '1');
INSERT INTO `bbs_area` VALUES ('3187', '泽普县', '3182', '1');
INSERT INTO `bbs_area` VALUES ('3188', '莎车县', '3182', '1');
INSERT INTO `bbs_area` VALUES ('3189', '叶城县', '3182', '1');
INSERT INTO `bbs_area` VALUES ('3190', '麦盖提县', '3182', '1');
INSERT INTO `bbs_area` VALUES ('3191', '岳普湖县', '3182', '1');
INSERT INTO `bbs_area` VALUES ('3192', '伽师县', '3182', '1');
INSERT INTO `bbs_area` VALUES ('3193', '巴楚县', '3182', '1');
INSERT INTO `bbs_area` VALUES ('3194', '塔什库尔干塔吉克自治县', '3182', '1');
INSERT INTO `bbs_area` VALUES ('3195', '和田地区', '3125', '1');
INSERT INTO `bbs_area` VALUES ('3196', '和田市', '3195', '1');
INSERT INTO `bbs_area` VALUES ('3197', '和田县', '3195', '1');
INSERT INTO `bbs_area` VALUES ('3198', '墨玉县', '3195', '1');
INSERT INTO `bbs_area` VALUES ('3199', '皮山县', '3195', '1');
INSERT INTO `bbs_area` VALUES ('3200', '洛浦县', '3195', '1');
INSERT INTO `bbs_area` VALUES ('3201', '策勒县', '3195', '1');
INSERT INTO `bbs_area` VALUES ('3202', '于田县', '3195', '1');
INSERT INTO `bbs_area` VALUES ('3203', '民丰县', '3195', '1');
INSERT INTO `bbs_area` VALUES ('3204', '伊犁哈萨克自治州', '3125', '1');
INSERT INTO `bbs_area` VALUES ('3205', '伊宁市', '3204', '1');
INSERT INTO `bbs_area` VALUES ('3206', '奎屯市', '3204', '1');
INSERT INTO `bbs_area` VALUES ('3207', '伊宁县', '3204', '1');
INSERT INTO `bbs_area` VALUES ('3208', '察布查尔锡伯自治县', '3204', '1');
INSERT INTO `bbs_area` VALUES ('3209', '霍城县', '3204', '1');
INSERT INTO `bbs_area` VALUES ('3210', '巩留县', '3204', '1');
INSERT INTO `bbs_area` VALUES ('3211', '新源县', '3204', '1');
INSERT INTO `bbs_area` VALUES ('3212', '昭苏县', '3204', '1');
INSERT INTO `bbs_area` VALUES ('3213', '特克斯县', '3204', '1');
INSERT INTO `bbs_area` VALUES ('3214', '尼勒克县', '3204', '1');
INSERT INTO `bbs_area` VALUES ('3215', '塔城地区', '3125', '1');
INSERT INTO `bbs_area` VALUES ('3216', '塔城市', '3215', '1');
INSERT INTO `bbs_area` VALUES ('3217', '乌苏市', '3215', '1');
INSERT INTO `bbs_area` VALUES ('3218', '额敏县', '3215', '1');
INSERT INTO `bbs_area` VALUES ('3219', '沙湾县', '3215', '1');
INSERT INTO `bbs_area` VALUES ('3220', '托里县', '3215', '1');
INSERT INTO `bbs_area` VALUES ('3221', '裕民县', '3215', '1');
INSERT INTO `bbs_area` VALUES ('3222', '和布克赛尔蒙古自治县', '3215', '1');
INSERT INTO `bbs_area` VALUES ('3223', '阿勒泰地区', '3125', '1');
INSERT INTO `bbs_area` VALUES ('3224', '阿勒泰市', '3223', '1');
INSERT INTO `bbs_area` VALUES ('3225', '布尔津县', '3223', '1');
INSERT INTO `bbs_area` VALUES ('3226', '富蕴县', '3223', '1');
INSERT INTO `bbs_area` VALUES ('3227', '福海县', '3223', '1');
INSERT INTO `bbs_area` VALUES ('3228', '哈巴河县', '3223', '1');
INSERT INTO `bbs_area` VALUES ('3229', '青河县', '3223', '1');
INSERT INTO `bbs_area` VALUES ('3230', '吉木乃县', '3223', '1');
INSERT INTO `bbs_area` VALUES ('3231', '石河子市', '3125', '1');
INSERT INTO `bbs_area` VALUES ('3232', '阿拉尔市', '3125', '1');
INSERT INTO `bbs_area` VALUES ('3233', '图木舒克市', '3125', '1');
INSERT INTO `bbs_area` VALUES ('3234', '五家渠市', '3125', '1');
INSERT INTO `bbs_area` VALUES ('3235', '吉阳区', '2236', '1');
INSERT INTO `bbs_area` VALUES ('3236', '崖州区', '2236', '1');
INSERT INTO `bbs_area` VALUES ('3237', '天涯区', '2236', '1');
INSERT INTO `bbs_area` VALUES ('3238', '海棠区', '2236', '1');
INSERT INTO `bbs_area` VALUES ('3239', '三沙市', '2230', '1');
INSERT INTO `bbs_area` VALUES ('3240', '西沙群岛', '3239', '1');
INSERT INTO `bbs_area` VALUES ('3241', '中沙群岛', '3239', '1');
INSERT INTO `bbs_area` VALUES ('3242', '南沙群岛', '3239', '1');
INSERT INTO `bbs_area` VALUES ('3243', '哈密市', '3144', '1');
INSERT INTO `bbs_area` VALUES ('3244', '巴里坤哈萨克自治县', '3144', '1');
INSERT INTO `bbs_area` VALUES ('3245', '伊吾县', '3144', '1');
INSERT INTO `bbs_area` VALUES ('3246', '东莞市', '2088', '1');
INSERT INTO `bbs_area` VALUES ('3247', '中山市', '2089', '1');
INSERT INTO `bbs_area` VALUES ('3249', '北屯市', '3125', '1');
INSERT INTO `bbs_area` VALUES ('3250', '铁门关市', '3125', '1');
INSERT INTO `bbs_area` VALUES ('3251', '双河市', '3248', '1');
INSERT INTO `bbs_area` VALUES ('3252', '营根镇', '2253', '1');
INSERT INTO `bbs_area` VALUES ('3253', '湾岭镇', '2253', '1');
INSERT INTO `bbs_area` VALUES ('3254', '黎母山镇', '2253', '1');
INSERT INTO `bbs_area` VALUES ('3255', '红毛镇', '2253', '1');
INSERT INTO `bbs_area` VALUES ('3256', '长征镇', '2253', '1');
INSERT INTO `bbs_area` VALUES ('3257', '中平镇', '2253', '1');
INSERT INTO `bbs_area` VALUES ('3258', '和平镇', '2253', '1');
INSERT INTO `bbs_area` VALUES ('3259', '什运乡', '2253', '1');
INSERT INTO `bbs_area` VALUES ('3260', '上安乡', '2253', '1');
INSERT INTO `bbs_area` VALUES ('3261', '吊罗山乡', '2253', '1');
INSERT INTO `bbs_area` VALUES ('3262', '保城镇', '2252', '1');
INSERT INTO `bbs_area` VALUES ('3263', '什玲镇', '2252', '1');
INSERT INTO `bbs_area` VALUES ('3264', '加茂镇', '2252', '1');
INSERT INTO `bbs_area` VALUES ('3265', '响水镇', '2252', '1');
INSERT INTO `bbs_area` VALUES ('3266', '新政镇', '2252', '1');
INSERT INTO `bbs_area` VALUES ('3267', '三道镇', '2252', '1');
INSERT INTO `bbs_area` VALUES ('3268', '六弓乡', '2252', '1');
INSERT INTO `bbs_area` VALUES ('3269', '南林乡', '2252', '1');
INSERT INTO `bbs_area` VALUES ('3270', '毛感乡', '2252', '1');
INSERT INTO `bbs_area` VALUES ('3271', '椰林镇', '2251', '1');
INSERT INTO `bbs_area` VALUES ('3272', '新村镇', '2251', '1');
INSERT INTO `bbs_area` VALUES ('3273', '英州镇', '2251', '1');
INSERT INTO `bbs_area` VALUES ('3274', '本号镇', '2251', '1');
INSERT INTO `bbs_area` VALUES ('3275', '隆广镇', '2251', '1');
INSERT INTO `bbs_area` VALUES ('3276', '三才镇', '2251', '1');
INSERT INTO `bbs_area` VALUES ('3277', '光坡镇', '2251', '1');
INSERT INTO `bbs_area` VALUES ('3278', '文罗镇', '2251', '1');
INSERT INTO `bbs_area` VALUES ('3279', '黎安镇', '2251', '1');
INSERT INTO `bbs_area` VALUES ('3280', '提蒙乡', '2251', '1');
INSERT INTO `bbs_area` VALUES ('3281', '群英乡', '2251', '1');
INSERT INTO `bbs_area` VALUES ('3282', '抱由镇', '2250', '1');
INSERT INTO `bbs_area` VALUES ('3283', '万冲镇', '2250', '1');
INSERT INTO `bbs_area` VALUES ('3284', '大安镇', '2250', '1');
INSERT INTO `bbs_area` VALUES ('3285', '志仲镇', '2250', '1');
INSERT INTO `bbs_area` VALUES ('3286', '千家镇', '2250', '1');
INSERT INTO `bbs_area` VALUES ('3287', '九所镇', '2250', '1');
INSERT INTO `bbs_area` VALUES ('3288', '利国镇', '2250', '1');
INSERT INTO `bbs_area` VALUES ('3289', '黄流镇', '2250', '1');
INSERT INTO `bbs_area` VALUES ('3290', '佛罗镇', '2250', '1');
INSERT INTO `bbs_area` VALUES ('3291', '尖峰镇', '2250', '1');
INSERT INTO `bbs_area` VALUES ('3292', '莺歌海镇', '2250', '1');
INSERT INTO `bbs_area` VALUES ('3293', '石碌镇', '2249', '1');
INSERT INTO `bbs_area` VALUES ('3294', '叉河镇', '2249', '1');
INSERT INTO `bbs_area` VALUES ('3295', '十月田镇', '2249', '1');
INSERT INTO `bbs_area` VALUES ('3296', '乌烈镇', '2249', '1');
INSERT INTO `bbs_area` VALUES ('3297', '昌化镇', '2249', '1');
INSERT INTO `bbs_area` VALUES ('3298', '海尾镇', '2249', '1');
INSERT INTO `bbs_area` VALUES ('3299', '七叉镇', '2249', '1');
INSERT INTO `bbs_area` VALUES ('3300', '王下乡', '2249', '1');
INSERT INTO `bbs_area` VALUES ('3301', '牙叉镇', '2248', '1');
INSERT INTO `bbs_area` VALUES ('3302', '七坊镇', '2248', '1');
INSERT INTO `bbs_area` VALUES ('3303', '邦溪镇', '2248', '1');
INSERT INTO `bbs_area` VALUES ('3304', '打安镇', '2248', '1');
INSERT INTO `bbs_area` VALUES ('3305', '细水乡', '2248', '1');
INSERT INTO `bbs_area` VALUES ('3306', '元门乡', '2248', '1');
INSERT INTO `bbs_area` VALUES ('3307', '南开乡', '2248', '1');
INSERT INTO `bbs_area` VALUES ('3308', '阜龙乡', '2248', '1');
INSERT INTO `bbs_area` VALUES ('3309', '青松乡', '2248', '1');
INSERT INTO `bbs_area` VALUES ('3310', '金波乡', '2248', '1');
INSERT INTO `bbs_area` VALUES ('3311', '荣邦乡', '2248', '1');
INSERT INTO `bbs_area` VALUES ('3312', '临城镇', '2247', '1');
INSERT INTO `bbs_area` VALUES ('3313', '波莲镇', '2247', '1');
INSERT INTO `bbs_area` VALUES ('3314', '东英镇', '2247', '1');
INSERT INTO `bbs_area` VALUES ('3315', '博厚镇', '2247', '1');
INSERT INTO `bbs_area` VALUES ('3316', '皇桐镇', '2247', '1');
INSERT INTO `bbs_area` VALUES ('3317', '多文镇', '2247', '1');
INSERT INTO `bbs_area` VALUES ('3318', '和舍镇', '2247', '1');
INSERT INTO `bbs_area` VALUES ('3319', '南宝镇', '2247', '1');
INSERT INTO `bbs_area` VALUES ('3320', '新盈镇', '2247', '1');
INSERT INTO `bbs_area` VALUES ('3321', '调楼镇', '2247', '1');
INSERT INTO `bbs_area` VALUES ('3322', '加来镇', '2247', '1');
INSERT INTO `bbs_area` VALUES ('3323', '国营红华农场', '2247', '1');
INSERT INTO `bbs_area` VALUES ('3324', '国营加来农场', '2247', '1');
INSERT INTO `bbs_area` VALUES ('3325', '金江镇', '2246', '1');
INSERT INTO `bbs_area` VALUES ('3326', '瑞溪镇', '2246', '1');
INSERT INTO `bbs_area` VALUES ('3327', '永发镇', '2246', '1');
INSERT INTO `bbs_area` VALUES ('3328', '老城镇', '2246', '1');
INSERT INTO `bbs_area` VALUES ('3329', '加乐镇', '2246', '1');
INSERT INTO `bbs_area` VALUES ('3330', '文儒镇', '2246', '1');
INSERT INTO `bbs_area` VALUES ('3331', '福山镇', '2246', '1');
INSERT INTO `bbs_area` VALUES ('3332', '桥头镇', '2246', '1');
INSERT INTO `bbs_area` VALUES ('3333', '中兴镇', '2246', '1');
INSERT INTO `bbs_area` VALUES ('3334', '仁兴镇', '2246', '1');
INSERT INTO `bbs_area` VALUES ('3335', '大丰镇', '2246', '1');
INSERT INTO `bbs_area` VALUES ('3336', '屯城镇', '2245', '1');
INSERT INTO `bbs_area` VALUES ('3337', '新兴镇', '2245', '1');
INSERT INTO `bbs_area` VALUES ('3338', '枫木镇', '2245', '1');
INSERT INTO `bbs_area` VALUES ('3339', '乌坡镇', '2245', '1');
INSERT INTO `bbs_area` VALUES ('3340', '南吕镇', '2245', '1');
INSERT INTO `bbs_area` VALUES ('3341', '南坤镇', '2245', '1');
INSERT INTO `bbs_area` VALUES ('3342', '坡心镇', '2245', '1');
INSERT INTO `bbs_area` VALUES ('3343', '西昌镇', '2245', '1');
INSERT INTO `bbs_area` VALUES ('3344', '海垦中建农场', '2245', '1');
INSERT INTO `bbs_area` VALUES ('3345', '海垦中坤农场', '2245', '1');
INSERT INTO `bbs_area` VALUES ('3346', '海垦黄岭农场', '2245', '1');
INSERT INTO `bbs_area` VALUES ('3347', '海垦南吕农场', '2245', '1');
INSERT INTO `bbs_area` VALUES ('3348', '海垦广青农场', '2245', '1');
INSERT INTO `bbs_area` VALUES ('3349', '海垦晨星农场', '2245', '1');
INSERT INTO `bbs_area` VALUES ('3350', '定城镇', '2244', '1');
INSERT INTO `bbs_area` VALUES ('3351', '新竹镇', '2244', '1');
INSERT INTO `bbs_area` VALUES ('3352', '龙湖镇', '2244', '1');
INSERT INTO `bbs_area` VALUES ('3353', '黄竹镇', '2244', '1');
INSERT INTO `bbs_area` VALUES ('3354', '雷鸣镇', '2244', '1');
INSERT INTO `bbs_area` VALUES ('3355', '龙门镇', '2244', '1');
INSERT INTO `bbs_area` VALUES ('3356', '龙河镇', '2244', '1');
INSERT INTO `bbs_area` VALUES ('3357', '岭口镇', '2244', '1');
INSERT INTO `bbs_area` VALUES ('3358', '翰林镇', '2244', '1');
INSERT INTO `bbs_area` VALUES ('3359', '富文镇', '2244', '1');
INSERT INTO `bbs_area` VALUES ('3360', '八所镇', '2243', '1');
INSERT INTO `bbs_area` VALUES ('3361', '东河镇', '2243', '1');
INSERT INTO `bbs_area` VALUES ('3362', '大田镇', '2243', '1');
INSERT INTO `bbs_area` VALUES ('3363', '感城镇', '2243', '1');
INSERT INTO `bbs_area` VALUES ('3364', '板桥镇', '2243', '1');
INSERT INTO `bbs_area` VALUES ('3365', '三家镇', '2243', '1');
INSERT INTO `bbs_area` VALUES ('3366', '四更镇', '2243', '1');
INSERT INTO `bbs_area` VALUES ('3367', '新龙镇', '2243', '1');
INSERT INTO `bbs_area` VALUES ('3368', '天安乡', '2243', '1');
INSERT INTO `bbs_area` VALUES ('3369', '江边乡', '2243', '1');
INSERT INTO `bbs_area` VALUES ('3370', '万城镇', '2242', '1');
INSERT INTO `bbs_area` VALUES ('3371', '龙滚镇', '2242', '1');
INSERT INTO `bbs_area` VALUES ('3372', '山根镇', '2242', '1');
INSERT INTO `bbs_area` VALUES ('3373', '和乐镇', '2242', '1');
INSERT INTO `bbs_area` VALUES ('3374', '后安镇', '2242', '1');
INSERT INTO `bbs_area` VALUES ('3375', '大茂镇', '2242', '1');
INSERT INTO `bbs_area` VALUES ('3376', '东澳镇', '2242', '1');
INSERT INTO `bbs_area` VALUES ('3377', '礼纪镇', '2242', '1');
INSERT INTO `bbs_area` VALUES ('3378', '长丰镇', '2242', '1');
INSERT INTO `bbs_area` VALUES ('3379', '北大镇', '2242', '1');
INSERT INTO `bbs_area` VALUES ('3380', '南桥镇', '2242', '1');
INSERT INTO `bbs_area` VALUES ('3381', '三更罗镇', '2242', '1');
INSERT INTO `bbs_area` VALUES ('3382', '国营东兴农场', '2242', '1');
INSERT INTO `bbs_area` VALUES ('3383', '国营东和农场', '2242', '1');
INSERT INTO `bbs_area` VALUES ('3384', '国营东岭农场', '2242', '1');
INSERT INTO `bbs_area` VALUES ('3385', '国营南林农场', '2242', '1');
INSERT INTO `bbs_area` VALUES ('3386', '国营新中农场', '2242', '1');
INSERT INTO `bbs_area` VALUES ('3387', '兴隆华侨农场', '2242', '1');
INSERT INTO `bbs_area` VALUES ('3388', '文城镇', '2241', '1');
INSERT INTO `bbs_area` VALUES ('3389', '重兴镇', '2241', '1');
INSERT INTO `bbs_area` VALUES ('3390', '蓬莱镇', '2241', '1');
INSERT INTO `bbs_area` VALUES ('3391', '会文镇', '2241', '1');
INSERT INTO `bbs_area` VALUES ('3392', '东路镇', '2241', '1');
INSERT INTO `bbs_area` VALUES ('3393', '潭牛镇', '2241', '1');
INSERT INTO `bbs_area` VALUES ('3394', '东阁镇', '2241', '1');
INSERT INTO `bbs_area` VALUES ('3395', '文教镇', '2241', '1');
INSERT INTO `bbs_area` VALUES ('3396', '东郊镇', '2241', '1');
INSERT INTO `bbs_area` VALUES ('3397', '龙楼镇', '2241', '1');
INSERT INTO `bbs_area` VALUES ('3398', '昌洒镇', '2241', '1');
INSERT INTO `bbs_area` VALUES ('3399', '翁田镇', '2241', '1');
INSERT INTO `bbs_area` VALUES ('3400', '抱罗镇', '2241', '1');
INSERT INTO `bbs_area` VALUES ('3401', '冯坡镇', '2241', '1');
INSERT INTO `bbs_area` VALUES ('3402', '锦山镇', '2241', '1');
INSERT INTO `bbs_area` VALUES ('3403', '铺前镇', '2241', '1');
INSERT INTO `bbs_area` VALUES ('3404', '公坡镇', '2241', '1');
INSERT INTO `bbs_area` VALUES ('3405', '那大镇', '2240', '1');
INSERT INTO `bbs_area` VALUES ('3406', '南丰镇', '2240', '1');
INSERT INTO `bbs_area` VALUES ('3407', '雅星镇', '2240', '1');
INSERT INTO `bbs_area` VALUES ('3408', '和庆镇', '2240', '1');
INSERT INTO `bbs_area` VALUES ('3409', '大成镇', '2240', '1');
INSERT INTO `bbs_area` VALUES ('3410', '新州镇', '2240', '1');
INSERT INTO `bbs_area` VALUES ('3411', '光村镇', '2240', '1');
INSERT INTO `bbs_area` VALUES ('3412', '东成镇', '2240', '1');
INSERT INTO `bbs_area` VALUES ('3413', '中和镇', '2240', '1');
INSERT INTO `bbs_area` VALUES ('3414', '峨蔓镇', '2240', '1');
INSERT INTO `bbs_area` VALUES ('3415', '兰洋镇', '2240', '1');
INSERT INTO `bbs_area` VALUES ('3416', '王五镇', '2240', '1');
INSERT INTO `bbs_area` VALUES ('3417', '排浦镇', '2240', '1');
INSERT INTO `bbs_area` VALUES ('3418', '海头镇', '2240', '1');
INSERT INTO `bbs_area` VALUES ('3419', '木棠镇', '2240', '1');
INSERT INTO `bbs_area` VALUES ('3420', '白马井镇', '2240', '1');
INSERT INTO `bbs_area` VALUES ('3421', '三都办事处', '2240', '1');
INSERT INTO `bbs_area` VALUES ('3422', '嘉积镇', '2239', '1');
INSERT INTO `bbs_area` VALUES ('3423', '博鳌镇', '2239', '1');
INSERT INTO `bbs_area` VALUES ('3424', '万泉镇', '2239', '1');
INSERT INTO `bbs_area` VALUES ('3425', '潭门镇', '2239', '1');
INSERT INTO `bbs_area` VALUES ('3426', '长坡镇', '2239', '1');
INSERT INTO `bbs_area` VALUES ('3427', '塔洋镇', '2239', '1');
INSERT INTO `bbs_area` VALUES ('3428', '大路镇', '2239', '1');
INSERT INTO `bbs_area` VALUES ('3429', '中原镇', '2239', '1');
INSERT INTO `bbs_area` VALUES ('3430', '阳江镇', '2239', '1');
INSERT INTO `bbs_area` VALUES ('3431', '龙江镇', '2239', '1');
INSERT INTO `bbs_area` VALUES ('3432', '石壁镇', '2239', '1');
INSERT INTO `bbs_area` VALUES ('3433', '会山镇', '2239', '1');
INSERT INTO `bbs_area` VALUES ('3434', '通什镇', '2238', '1');
INSERT INTO `bbs_area` VALUES ('3435', '南圣镇', '2238', '1');
INSERT INTO `bbs_area` VALUES ('3436', '毛阳镇', '2238', '1');
INSERT INTO `bbs_area` VALUES ('3437', '番阳镇', '2238', '1');
INSERT INTO `bbs_area` VALUES ('3438', '畅好乡', '2238', '1');
INSERT INTO `bbs_area` VALUES ('3439', '毛道乡', '2238', '1');
INSERT INTO `bbs_area` VALUES ('3440', '水满乡', '2238', '1');
INSERT INTO `bbs_area` VALUES ('3441', '多宝镇', '1824', '1');
INSERT INTO `bbs_area` VALUES ('3442', '拖市镇', '1824', '1');
INSERT INTO `bbs_area` VALUES ('3443', '张港镇', '1824', '1');
INSERT INTO `bbs_area` VALUES ('3444', '渔薪镇', '1824', '1');
INSERT INTO `bbs_area` VALUES ('3445', '	蒋场镇', '1824', '1');
INSERT INTO `bbs_area` VALUES ('3446', '汪场镇', '1824', '1');
INSERT INTO `bbs_area` VALUES ('3447', '横林镇', '1824', '1');
INSERT INTO `bbs_area` VALUES ('3448', '	彭市镇', '1824', '1');
INSERT INTO `bbs_area` VALUES ('3449', '麻洋镇', '1824', '1');
INSERT INTO `bbs_area` VALUES ('3450', '	胡市镇', '1824', '1');
INSERT INTO `bbs_area` VALUES ('3451', '干驿镇', '1824', '1');
INSERT INTO `bbs_area` VALUES ('3452', '	马湾镇', '1824', '1');
INSERT INTO `bbs_area` VALUES ('3453', '卢市镇', '1824', '1');
INSERT INTO `bbs_area` VALUES ('3454', '	九真镇', '1824', '1');
INSERT INTO `bbs_area` VALUES ('3455', '	净潭乡', '1824', '1');
INSERT INTO `bbs_area` VALUES ('3456', '皂市镇', '1824', '1');
INSERT INTO `bbs_area` VALUES ('3457', '石家河镇', '1824', '1');
INSERT INTO `bbs_area` VALUES ('3458', '佛子山镇', '1824', '1');
INSERT INTO `bbs_area` VALUES ('3459', '岳口镇', '1824', '1');
INSERT INTO `bbs_area` VALUES ('3460', '黄潭镇', '1824', '1');
INSERT INTO `bbs_area` VALUES ('3461', '小板镇', '1824', '1');
INSERT INTO `bbs_area` VALUES ('3462', '多祥镇(天门工业园)', '1824', '1');
INSERT INTO `bbs_area` VALUES ('3463', '竟陵街道办事处', '1824', '1');
INSERT INTO `bbs_area` VALUES ('3464', '杨林街道办事处', '1824', '1');
INSERT INTO `bbs_area` VALUES ('3465', '候口街道办事处(天门高新园)', '1824', '1');
INSERT INTO `bbs_area` VALUES ('3466', '白茅湖棉花原种场', '1824', '1');
INSERT INTO `bbs_area` VALUES ('3467', '	蒋湖农场', '1824', '1');
INSERT INTO `bbs_area` VALUES ('3468', '沉湖农业综合示范区', '1824', '1');
INSERT INTO `bbs_area` VALUES ('3469', '园林街道', '1823', '1');
INSERT INTO `bbs_area` VALUES ('3470', '广华街道', '1823', '1');
INSERT INTO `bbs_area` VALUES ('3471', '杨市街道', '1823', '1');
INSERT INTO `bbs_area` VALUES ('3472', '周矶街道', '1823', '1');
INSERT INTO `bbs_area` VALUES ('3473', '泰丰街道', '1823', '1');
INSERT INTO `bbs_area` VALUES ('3474', '高场街道', '1823', '1');
INSERT INTO `bbs_area` VALUES ('3475', '熊口镇', '1823', '1');
INSERT INTO `bbs_area` VALUES ('3476', '竹根滩镇', '1823', '1');
INSERT INTO `bbs_area` VALUES ('3477', '高石碑镇', '1823', '1');
INSERT INTO `bbs_area` VALUES ('3478', '老新镇', '1823', '1');
INSERT INTO `bbs_area` VALUES ('3479', '王场镇', '1823', '1');
INSERT INTO `bbs_area` VALUES ('3480', '渔洋镇', '1823', '1');
INSERT INTO `bbs_area` VALUES ('3481', '龙湾镇', '1823', '1');
INSERT INTO `bbs_area` VALUES ('3482', '浩口镇', '1823', '1');
INSERT INTO `bbs_area` VALUES ('3483', '积玉口镇', '1823', '1');
INSERT INTO `bbs_area` VALUES ('3484', '张金镇', '1823', '1');
INSERT INTO `bbs_area` VALUES ('3485', '白鹭湖管理区', '1823', '1');
INSERT INTO `bbs_area` VALUES ('3486', '总口管理区', '1823', '1');
INSERT INTO `bbs_area` VALUES ('3487', '熊口农场管理区', '1823', '1');
INSERT INTO `bbs_area` VALUES ('3488', '运粮湖管理区', '1823', '1');
INSERT INTO `bbs_area` VALUES ('3489', '后湖管理区', '1823', '1');
INSERT INTO `bbs_area` VALUES ('3490', '周矶管理区', '1823', '1');
INSERT INTO `bbs_area` VALUES ('3491', '干河街道', '1822', '1');
INSERT INTO `bbs_area` VALUES ('3492', '龙华山街道', '1822', '1');
INSERT INTO `bbs_area` VALUES ('3493', '沙嘴街道', '1822', '1');
INSERT INTO `bbs_area` VALUES ('3494', '郑场镇', '1822', '1');
INSERT INTO `bbs_area` VALUES ('3495', '毛嘴镇', '1822', '1');
INSERT INTO `bbs_area` VALUES ('3496', '剅河镇', '1822', '1');
INSERT INTO `bbs_area` VALUES ('3497', '三伏潭镇', '1822', '1');
INSERT INTO `bbs_area` VALUES ('3498', '胡场镇', '1822', '1');
INSERT INTO `bbs_area` VALUES ('3499', '长埫口镇', '1822', '1');
INSERT INTO `bbs_area` VALUES ('3500', '西流河镇', '1822', '1');
INSERT INTO `bbs_area` VALUES ('3501', '彭场镇', '1822', '1');
INSERT INTO `bbs_area` VALUES ('3502', '沙湖镇', '1822', '1');
INSERT INTO `bbs_area` VALUES ('3503', '杨林尾镇', '1822', '1');
INSERT INTO `bbs_area` VALUES ('3504', '张沟镇', '1822', '1');
INSERT INTO `bbs_area` VALUES ('3505', '郭河镇', '1822', '1');
INSERT INTO `bbs_area` VALUES ('3506', '沔城回族镇', '1822', '1');
INSERT INTO `bbs_area` VALUES ('3507', '通海口镇', '1822', '1');
INSERT INTO `bbs_area` VALUES ('3508', '陈场镇', '1822', '1');
INSERT INTO `bbs_area` VALUES ('3509', '松柏镇', '1825', '1');
INSERT INTO `bbs_area` VALUES ('3510', '阳日镇', '1825', '1');
INSERT INTO `bbs_area` VALUES ('3511', '木鱼镇', '1825', '1');
INSERT INTO `bbs_area` VALUES ('3512', '红坪镇', '1825', '1');
INSERT INTO `bbs_area` VALUES ('3513', '新华镇', '1825', '1');
INSERT INTO `bbs_area` VALUES ('3514', '宋洛乡', '1825', '1');
INSERT INTO `bbs_area` VALUES ('3515', '九湖乡', '1825', '1');
INSERT INTO `bbs_area` VALUES ('3516', '下谷坪土家族乡', '1825', '1');
INSERT INTO `bbs_area` VALUES ('3517', '新城街道', '3231', '1');
INSERT INTO `bbs_area` VALUES ('3518', '向阳街道', '3231', '1');
INSERT INTO `bbs_area` VALUES ('3519', '红山街道', '3231', '1');
INSERT INTO `bbs_area` VALUES ('3520', '老街街道', '3231', '1');
INSERT INTO `bbs_area` VALUES ('3521', '东城街道', '3231', '1');
INSERT INTO `bbs_area` VALUES ('3522', '北泉镇', '3231', '1');
INSERT INTO `bbs_area` VALUES ('3523', '石河子镇', '3231', '1');
INSERT INTO `bbs_area` VALUES ('3524', '幸福路街道', '3232', '1');
INSERT INTO `bbs_area` VALUES ('3525', '金银川路街道', '3232', '1');
INSERT INTO `bbs_area` VALUES ('3526', '青松路街道', '3232', '1');
INSERT INTO `bbs_area` VALUES ('3527', '南口街道', '3232', '1');
INSERT INTO `bbs_area` VALUES ('3528', '托喀依乡', '3232', '1');
INSERT INTO `bbs_area` VALUES ('3529', '金银川镇', '3232', '1');
INSERT INTO `bbs_area` VALUES ('3530', '沙河镇', '3232', '1');
INSERT INTO `bbs_area` VALUES ('3531', '双城镇', '3232', '1');
INSERT INTO `bbs_area` VALUES ('3532', '齐干却勒街道', '3233', '1');
INSERT INTO `bbs_area` VALUES ('3533', '前海街道', '3233', '1');
INSERT INTO `bbs_area` VALUES ('3534', '永安坝街道', '3233', '1');
INSERT INTO `bbs_area` VALUES ('3535', '草湖镇', '3233', '1');
INSERT INTO `bbs_area` VALUES ('3536', '兵团四十四团', '3233', '1');
INSERT INTO `bbs_area` VALUES ('3537', '兵团四十九团', '3233', '1');
INSERT INTO `bbs_area` VALUES ('3538', '兵团五十团', '3233', '1');
INSERT INTO `bbs_area` VALUES ('3539', '兵团五十一团', '3233', '1');
INSERT INTO `bbs_area` VALUES ('3540', '兵团五十三团', '3233', '1');
INSERT INTO `bbs_area` VALUES ('3541', '兵团图木舒克市喀拉拜勒镇', '3233', '1');
INSERT INTO `bbs_area` VALUES ('3542', '兵团图木舒克市永安坝', '3233', '1');
INSERT INTO `bbs_area` VALUES ('3543', '军垦路街道', '3234', '1');
INSERT INTO `bbs_area` VALUES ('3544', '青湖路街道', '3234', '1');
INSERT INTO `bbs_area` VALUES ('3545', '人民路街道', '3234', '1');
INSERT INTO `bbs_area` VALUES ('3546', '101团(铁牛镇)', '3234', '1');
INSERT INTO `bbs_area` VALUES ('3547', '102团(梧桐镇)', '3234', '1');
INSERT INTO `bbs_area` VALUES ('3548', '103团(蔡家湖镇)', '3234', '1');
INSERT INTO `bbs_area` VALUES ('3549', '北屯镇', '3249', '1');
INSERT INTO `bbs_area` VALUES ('3550', '一八八团(海川镇)', '3249', '1');
INSERT INTO `bbs_area` VALUES ('3551', '一八七团(丰庆镇)', '3249', '1');
INSERT INTO `bbs_area` VALUES ('3552', '一八三团(锡伯渡镇)', '3249', '1');
INSERT INTO `bbs_area` VALUES ('3553', '二十一团', '3250', '1');
INSERT INTO `bbs_area` VALUES ('3554', '二十二团', '3250', '1');
INSERT INTO `bbs_area` VALUES ('3555', '二十四团', '3250', '1');
INSERT INTO `bbs_area` VALUES ('3556', '二十五团', '3250', '1');
INSERT INTO `bbs_area` VALUES ('3557', '二十七团', '3250', '1');
INSERT INTO `bbs_area` VALUES ('3558', '二十九团', '3250', '1');
INSERT INTO `bbs_area` VALUES ('3559', '三十团(双丰镇)', '3250', '1');
INSERT INTO `bbs_area` VALUES ('3560', '三十一团', '3250', '1');
INSERT INTO `bbs_area` VALUES ('3561', '三十三团', '3250', '1');
INSERT INTO `bbs_area` VALUES ('3562', '三十四团', '3250', '1');
INSERT INTO `bbs_area` VALUES ('3563', '三十六团', '3250', '1');
INSERT INTO `bbs_area` VALUES ('3564', '二二三团', '3250', '1');
INSERT INTO `bbs_area` VALUES ('3565', '且末支队', '3250', '1');
INSERT INTO `bbs_area` VALUES ('3566', '二十八团(博古其镇)', '3250', '1');
INSERT INTO `bbs_area` VALUES ('3567', '香港', '0', '1');
INSERT INTO `bbs_area` VALUES ('3568', '香港岛', '3567', '1');
INSERT INTO `bbs_area` VALUES ('3569', '中西区', '3568', '1');
INSERT INTO `bbs_area` VALUES ('3570', '湾仔区', '3568', '1');
INSERT INTO `bbs_area` VALUES ('3571', '东区', '3568', '1');
INSERT INTO `bbs_area` VALUES ('3572', '南区', '3568', '1');
INSERT INTO `bbs_area` VALUES ('3573', '九龙', '3567', '1');
INSERT INTO `bbs_area` VALUES ('3574', '油尖旺区', '3573', '1');
INSERT INTO `bbs_area` VALUES ('3575', '深水埗区', '3573', '1');
INSERT INTO `bbs_area` VALUES ('3576', '九龙城区', '3573', '1');
INSERT INTO `bbs_area` VALUES ('3577', '黄大仙区', '3573', '1');
INSERT INTO `bbs_area` VALUES ('3578', '观塘区', '3573', '1');
INSERT INTO `bbs_area` VALUES ('3579', '新界', '3567', '1');
INSERT INTO `bbs_area` VALUES ('3580', '北区', '3579', '1');
INSERT INTO `bbs_area` VALUES ('3581', '大埔区', '3579', '1');
INSERT INTO `bbs_area` VALUES ('3582', '沙田区', '3579', '1');
INSERT INTO `bbs_area` VALUES ('3583', '西贡区', '3579', '1');
INSERT INTO `bbs_area` VALUES ('3584', '荃湾区', '3579', '1');
INSERT INTO `bbs_area` VALUES ('3585', '屯门区', '3579', '1');
INSERT INTO `bbs_area` VALUES ('3586', '元朗区', '3579', '1');
INSERT INTO `bbs_area` VALUES ('3587', '葵青区', '3579', '1');
INSERT INTO `bbs_area` VALUES ('3588', '离岛区', '3579', '1');
INSERT INTO `bbs_area` VALUES ('3589', '澳门', '0', '1');
INSERT INTO `bbs_area` VALUES ('3590', '澳门半岛', '3589', '1');
INSERT INTO `bbs_area` VALUES ('3591', '花地玛堂区', '3590', '1');
INSERT INTO `bbs_area` VALUES ('3592', '圣安多尼堂区', '3590', '1');
INSERT INTO `bbs_area` VALUES ('3593', '大堂区', '3590', '1');
INSERT INTO `bbs_area` VALUES ('3594', '望德堂区', '3590', '1');
INSERT INTO `bbs_area` VALUES ('3595', '风顺堂区', '3590', '1');
INSERT INTO `bbs_area` VALUES ('3596', '澳门离岛', '3589', '1');
INSERT INTO `bbs_area` VALUES ('3597', '嘉模堂区', '3596', '1');
INSERT INTO `bbs_area` VALUES ('3598', '圣方济各堂区', '3596', '1');
INSERT INTO `bbs_area` VALUES ('3599', '无堂区划分区域', '3589', '1');
INSERT INTO `bbs_area` VALUES ('3600', '路氹城', '3599', '1');
INSERT INTO `bbs_area` VALUES ('3601', '台湾', '0', '1');
INSERT INTO `bbs_area` VALUES ('3602', '台北市', '3601', '1');
INSERT INTO `bbs_area` VALUES ('3603', '中正区', '3602', '1');
INSERT INTO `bbs_area` VALUES ('3604', '大同区', '3602', '1');
INSERT INTO `bbs_area` VALUES ('3605', '中山区', '3602', '1');
INSERT INTO `bbs_area` VALUES ('3606', '松山区', '3602', '1');
INSERT INTO `bbs_area` VALUES ('3607', '大安区', '3602', '1');
INSERT INTO `bbs_area` VALUES ('3608', '万华区', '3602', '1');
INSERT INTO `bbs_area` VALUES ('3609', '信义区', '3602', '1');
INSERT INTO `bbs_area` VALUES ('3610', '士林区', '3602', '1');
INSERT INTO `bbs_area` VALUES ('3611', '北投区', '3602', '1');
INSERT INTO `bbs_area` VALUES ('3612', '内湖区', '3602', '1');
INSERT INTO `bbs_area` VALUES ('3613', '南港区', '3602', '1');
INSERT INTO `bbs_area` VALUES ('3614', '文山区', '3602', '1');
INSERT INTO `bbs_area` VALUES ('3615', '高雄市', '3601', '1');
INSERT INTO `bbs_area` VALUES ('3616', '新兴区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3617', '前金区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3618', '芩雅区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3619', '盐埕区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3620', '鼓山区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3621', '旗津区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3622', '前镇区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3623', '三民区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3624', '左营区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3625', '楠梓区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3626', '小港区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3627', '基隆市', '3601', '1');
INSERT INTO `bbs_area` VALUES ('3628', '仁爱区', '3627', '1');
INSERT INTO `bbs_area` VALUES ('3629', '信义区', '3627', '1');
INSERT INTO `bbs_area` VALUES ('3630', '中正区', '3627', '1');
INSERT INTO `bbs_area` VALUES ('3631', '中山区', '3627', '1');
INSERT INTO `bbs_area` VALUES ('3632', '安乐区', '3627', '1');
INSERT INTO `bbs_area` VALUES ('3633', '暖暖区', '3627', '1');
INSERT INTO `bbs_area` VALUES ('3634', '七堵区', '3627', '1');
INSERT INTO `bbs_area` VALUES ('3635', '台中市', '3601', '1');
INSERT INTO `bbs_area` VALUES ('3636', '中区', '3635', '1');
INSERT INTO `bbs_area` VALUES ('3637', '东区', '3635', '1');
INSERT INTO `bbs_area` VALUES ('3638', '南区', '3635', '1');
INSERT INTO `bbs_area` VALUES ('3639', '西区', '3635', '1');
INSERT INTO `bbs_area` VALUES ('3640', '北区', '3635', '1');
INSERT INTO `bbs_area` VALUES ('3641', '北屯区', '3635', '1');
INSERT INTO `bbs_area` VALUES ('3642', '西屯区', '3635', '1');
INSERT INTO `bbs_area` VALUES ('3643', '南屯区', '3635', '1');
INSERT INTO `bbs_area` VALUES ('3644', '台南市', '3601', '1');
INSERT INTO `bbs_area` VALUES ('3645', '中西区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3646', '东区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3647', '南区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3648', '北区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3649', '安平区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3650', '安南区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3651', '新竹市', '3601', '1');
INSERT INTO `bbs_area` VALUES ('3652', '东区', '3651', '1');
INSERT INTO `bbs_area` VALUES ('3653', '北区', '3651', '1');
INSERT INTO `bbs_area` VALUES ('3654', '香山区', '3651', '1');
INSERT INTO `bbs_area` VALUES ('3655', '嘉义市', '3601', '1');
INSERT INTO `bbs_area` VALUES ('3656', '东区', '3655', '1');
INSERT INTO `bbs_area` VALUES ('3657', '西区', '3655', '1');
INSERT INTO `bbs_area` VALUES ('3658', '丰原区', '3635', '1');
INSERT INTO `bbs_area` VALUES ('3659', '大里区', '3635', '1');
INSERT INTO `bbs_area` VALUES ('3660', '太平区', '3635', '1');
INSERT INTO `bbs_area` VALUES ('3661', '东势区', '3635', '1');
INSERT INTO `bbs_area` VALUES ('3662', '大甲区', '3635', '1');
INSERT INTO `bbs_area` VALUES ('3663', '清水区', '3635', '1');
INSERT INTO `bbs_area` VALUES ('3664', '沙鹿区', '3635', '1');
INSERT INTO `bbs_area` VALUES ('3665', '梧栖区', '3635', '1');
INSERT INTO `bbs_area` VALUES ('3666', '后里区', '3635', '1');
INSERT INTO `bbs_area` VALUES ('3667', '神冈区', '3635', '1');
INSERT INTO `bbs_area` VALUES ('3668', '潭子区', '3635', '1');
INSERT INTO `bbs_area` VALUES ('3669', '大雅区', '3635', '1');
INSERT INTO `bbs_area` VALUES ('3670', '新小区', '3635', '1');
INSERT INTO `bbs_area` VALUES ('3671', '石冈区', '3635', '1');
INSERT INTO `bbs_area` VALUES ('3672', '外埔区', '3635', '1');
INSERT INTO `bbs_area` VALUES ('3673', '大安区', '3635', '1');
INSERT INTO `bbs_area` VALUES ('3674', '乌日区', '3635', '1');
INSERT INTO `bbs_area` VALUES ('3675', '大肚区', '3635', '1');
INSERT INTO `bbs_area` VALUES ('3676', '龙井区', '3635', '1');
INSERT INTO `bbs_area` VALUES ('3677', '雾峰区', '3635', '1');
INSERT INTO `bbs_area` VALUES ('3678', '和平区', '3635', '1');
INSERT INTO `bbs_area` VALUES ('3679', '永康区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3680', '归仁区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3681', '新化区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3682', '左镇区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3683', '玉井区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3684', '楠西区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3685', '南化区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3686', '仁德区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3687', '关庙区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3688', '龙崎区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3689', '官田区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3690', '麻豆区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3691', '佳里区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3692', '西港区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3693', '七股区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3694', '将军区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3695', '学甲区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3696', '北门区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3697', '新营区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3698', '后壁区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3699', '白河区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3700', '东山区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3701', '六甲区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3702', '下营区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3703', '柳营区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3704', '盐水区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3705', '善化区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3706', '大内区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3707', '山上区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3708', '新市区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3709', '安定区', '3644', '1');
INSERT INTO `bbs_area` VALUES ('3710', '新北市', '3601', '1');
INSERT INTO `bbs_area` VALUES ('3711', '板桥区', '3710', '1');
INSERT INTO `bbs_area` VALUES ('3712', '汐止区', '3710', '1');
INSERT INTO `bbs_area` VALUES ('3713', '新店区', '3710', '1');
INSERT INTO `bbs_area` VALUES ('3714', '永和区', '3710', '1');
INSERT INTO `bbs_area` VALUES ('3715', '中和区', '3710', '1');
INSERT INTO `bbs_area` VALUES ('3716', '土城区', '3710', '1');
INSERT INTO `bbs_area` VALUES ('3717', '树林区', '3710', '1');
INSERT INTO `bbs_area` VALUES ('3718', '三重区', '3710', '1');
INSERT INTO `bbs_area` VALUES ('3719', '新庄区', '3710', '1');
INSERT INTO `bbs_area` VALUES ('3720', '芦洲区', '3710', '1');
INSERT INTO `bbs_area` VALUES ('3721', '瑞芳区', '3710', '1');
INSERT INTO `bbs_area` VALUES ('3722', '三峡区', '3710', '1');
INSERT INTO `bbs_area` VALUES ('3723', '莺歌区', '3710', '1');
INSERT INTO `bbs_area` VALUES ('3724', '淡水区', '3710', '1');
INSERT INTO `bbs_area` VALUES ('3725', '万里区', '3710', '1');
INSERT INTO `bbs_area` VALUES ('3726', '金山区', '3710', '1');
INSERT INTO `bbs_area` VALUES ('3727', '深坑区', '3710', '1');
INSERT INTO `bbs_area` VALUES ('3728', '石碇区', '3710', '1');
INSERT INTO `bbs_area` VALUES ('3729', '平溪区', '3710', '1');
INSERT INTO `bbs_area` VALUES ('3730', '双溪区', '3710', '1');
INSERT INTO `bbs_area` VALUES ('3731', '贡寮区', '3710', '1');
INSERT INTO `bbs_area` VALUES ('3732', '坪林区', '3710', '1');
INSERT INTO `bbs_area` VALUES ('3733', '乌来区', '3710', '1');
INSERT INTO `bbs_area` VALUES ('3734', '泰山区', '3710', '1');
INSERT INTO `bbs_area` VALUES ('3735', '林口区', '3710', '1');
INSERT INTO `bbs_area` VALUES ('3736', '五股区', '3710', '1');
INSERT INTO `bbs_area` VALUES ('3737', '八里区', '3710', '1');
INSERT INTO `bbs_area` VALUES ('3738', '三芝区', '3710', '1');
INSERT INTO `bbs_area` VALUES ('3739', '石门区', '3710', '1');
INSERT INTO `bbs_area` VALUES ('3740', '桃园市', '3601', '1');
INSERT INTO `bbs_area` VALUES ('3741', '桃园区', '3740', '1');
INSERT INTO `bbs_area` VALUES ('3742', '中坜区', '3740', '1');
INSERT INTO `bbs_area` VALUES ('3743', '平镇区', '3740', '1');
INSERT INTO `bbs_area` VALUES ('3744', '八德区', '3740', '1');
INSERT INTO `bbs_area` VALUES ('3745', '杨梅区', '3740', '1');
INSERT INTO `bbs_area` VALUES ('3746', '芦竹区', '3740', '1');
INSERT INTO `bbs_area` VALUES ('3747', '大溪区', '3740', '1');
INSERT INTO `bbs_area` VALUES ('3748', '龙潭区', '3740', '1');
INSERT INTO `bbs_area` VALUES ('3749', '龟山区', '3740', '1');
INSERT INTO `bbs_area` VALUES ('3750', '大园区', '3740', '1');
INSERT INTO `bbs_area` VALUES ('3751', '观音区', '3740', '1');
INSERT INTO `bbs_area` VALUES ('3752', '新屋区', '3740', '1');
INSERT INTO `bbs_area` VALUES ('3753', '复兴区', '3740', '1');
INSERT INTO `bbs_area` VALUES ('3754', '凤山区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3755', '大寮区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3756', '鸟松区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3757', '林园区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3758', '仁武区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3759', '大树区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3760', '大社区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3761', '冈山区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3762', '路竹区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3763', '桥头区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3764', '梓官区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3765', '弥陀区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3766', '永安区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3767', '燕巢区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3768', '阿莲区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3769', '茄萣区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3770', '湖内区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3771', '旗山区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3772', '美浓区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3773', '内门区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3774', '杉林区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3775', '甲仙区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3776', '六龟区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3777', '茂林区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3778', '桃源区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3779', '那玛夏区', '3615', '1');
INSERT INTO `bbs_area` VALUES ('3780', '新竹县', '3601', '1');
INSERT INTO `bbs_area` VALUES ('3781', '竹北市', '3780', '1');
INSERT INTO `bbs_area` VALUES ('3782', '竹东镇', '3780', '1');
INSERT INTO `bbs_area` VALUES ('3783', '新埔镇', '3780', '1');
INSERT INTO `bbs_area` VALUES ('3784', '关西镇', '3780', '1');
INSERT INTO `bbs_area` VALUES ('3785', '新丰乡', '3780', '1');
INSERT INTO `bbs_area` VALUES ('3786', '峨眉乡', '3780', '1');
INSERT INTO `bbs_area` VALUES ('3787', '宝山乡', '3780', '1');
INSERT INTO `bbs_area` VALUES ('3788', '五峰乡', '3780', '1');
INSERT INTO `bbs_area` VALUES ('3789', '横山乡', '3780', '1');
INSERT INTO `bbs_area` VALUES ('3790', '北埔乡', '3780', '1');
INSERT INTO `bbs_area` VALUES ('3791', '尖石乡', '3780', '1');
INSERT INTO `bbs_area` VALUES ('3792', '芎林乡', '3780', '1');
INSERT INTO `bbs_area` VALUES ('3793', '湖口乡', '3780', '1');
INSERT INTO `bbs_area` VALUES ('3794', '苗栗县', '3601', '1');
INSERT INTO `bbs_area` VALUES ('3795', '苗栗市', '3794', '1');
INSERT INTO `bbs_area` VALUES ('3796', '通霄镇', '3794', '1');
INSERT INTO `bbs_area` VALUES ('3797', '苑里镇', '3794', '1');
INSERT INTO `bbs_area` VALUES ('3798', '西湖乡', '3794', '1');
INSERT INTO `bbs_area` VALUES ('3799', '头屋乡', '3794', '1');
INSERT INTO `bbs_area` VALUES ('3800', '公馆乡', '3794', '1');
INSERT INTO `bbs_area` VALUES ('3801', '铜锣乡', '3794', '1');
INSERT INTO `bbs_area` VALUES ('3802', '三义乡', '3794', '1');
INSERT INTO `bbs_area` VALUES ('3803', '竹南镇', '3794', '1');
INSERT INTO `bbs_area` VALUES ('3804', '头份市', '3794', '1');
INSERT INTO `bbs_area` VALUES ('3805', '后龙镇', '3794', '1');
INSERT INTO `bbs_area` VALUES ('3806', '造桥乡', '3794', '1');
INSERT INTO `bbs_area` VALUES ('3807', '三湾乡', '3794', '1');
INSERT INTO `bbs_area` VALUES ('3808', '南庄乡', '3794', '1');
INSERT INTO `bbs_area` VALUES ('3809', '大湖乡', '3794', '1');
INSERT INTO `bbs_area` VALUES ('3810', '卓兰镇', '3794', '1');
INSERT INTO `bbs_area` VALUES ('3811', '狮潭乡', '3794', '1');
INSERT INTO `bbs_area` VALUES ('3812', '泰安乡', '3794', '1');
INSERT INTO `bbs_area` VALUES ('3813', '彰化县', '3601', '1');
INSERT INTO `bbs_area` VALUES ('3814', '员林镇', '3813', '1');
INSERT INTO `bbs_area` VALUES ('3815', '和美镇', '3813', '1');
INSERT INTO `bbs_area` VALUES ('3816', '鹿港镇', '3813', '1');
INSERT INTO `bbs_area` VALUES ('3817', '溪湖镇', '3813', '1');
INSERT INTO `bbs_area` VALUES ('3818', '田中镇', '3813', '1');
INSERT INTO `bbs_area` VALUES ('3819', '北斗镇', '3813', '1');
INSERT INTO `bbs_area` VALUES ('3820', '二林镇', '3813', '1');
INSERT INTO `bbs_area` VALUES ('3821', '线西乡', '3813', '1');
INSERT INTO `bbs_area` VALUES ('3822', '伸港乡', '3813', '1');
INSERT INTO `bbs_area` VALUES ('3823', '芬园乡', '3813', '1');
INSERT INTO `bbs_area` VALUES ('3824', '秀水乡', '3813', '1');
INSERT INTO `bbs_area` VALUES ('3825', '花坛乡', '3813', '1');
INSERT INTO `bbs_area` VALUES ('3826', '福兴乡', '3813', '1');
INSERT INTO `bbs_area` VALUES ('3827', '大村乡', '3813', '1');
INSERT INTO `bbs_area` VALUES ('3828', '埔心乡', '3813', '1');
INSERT INTO `bbs_area` VALUES ('3829', '埔盐乡', '3813', '1');
INSERT INTO `bbs_area` VALUES ('3830', '永靖乡', '3813', '1');
INSERT INTO `bbs_area` VALUES ('3831', '社头乡', '3813', '1');
INSERT INTO `bbs_area` VALUES ('3832', '田尾乡', '3813', '1');
INSERT INTO `bbs_area` VALUES ('3833', '二水乡', '3813', '1');
INSERT INTO `bbs_area` VALUES ('3834', '埤头乡', '3813', '1');
INSERT INTO `bbs_area` VALUES ('3835', '溪州乡', '3813', '1');
INSERT INTO `bbs_area` VALUES ('3836', '竹塘乡', '3813', '1');
INSERT INTO `bbs_area` VALUES ('3837', '芳苑乡', '3813', '1');
INSERT INTO `bbs_area` VALUES ('3838', '大城乡', '3813', '1');
INSERT INTO `bbs_area` VALUES ('3839', '南投县', '3601', '1');
INSERT INTO `bbs_area` VALUES ('3840', '南投市', '3839', '1');
INSERT INTO `bbs_area` VALUES ('3841', '草屯镇', '3839', '1');
INSERT INTO `bbs_area` VALUES ('3842', '埔里镇', '3839', '1');
INSERT INTO `bbs_area` VALUES ('3843', '集集镇', '3839', '1');
INSERT INTO `bbs_area` VALUES ('3844', '竹山镇', '3839', '1');
INSERT INTO `bbs_area` VALUES ('3845', '中寮乡', '3839', '1');
INSERT INTO `bbs_area` VALUES ('3846', '国姓乡', '3839', '1');
INSERT INTO `bbs_area` VALUES ('3847', '仁爱乡', '3839', '1');
INSERT INTO `bbs_area` VALUES ('3848', '名间乡', '3839', '1');
INSERT INTO `bbs_area` VALUES ('3849', '水里乡', '3839', '1');
INSERT INTO `bbs_area` VALUES ('3850', '鱼池乡', '3839', '1');
INSERT INTO `bbs_area` VALUES ('3851', '信义乡', '3839', '1');
INSERT INTO `bbs_area` VALUES ('3852', '鹿谷乡', '3839', '1');
INSERT INTO `bbs_area` VALUES ('3853', '云林县', '3601', '1');
INSERT INTO `bbs_area` VALUES ('3854', '斗六市', '3853', '1');
INSERT INTO `bbs_area` VALUES ('3855', '斗南镇', '3853', '1');
INSERT INTO `bbs_area` VALUES ('3856', '虎尾镇', '3853', '1');
INSERT INTO `bbs_area` VALUES ('3857', '土库镇', '3853', '1');
INSERT INTO `bbs_area` VALUES ('3858', '西螺镇', '3853', '1');
INSERT INTO `bbs_area` VALUES ('3859', '北港镇', '3853', '1');
INSERT INTO `bbs_area` VALUES ('3860', '大埤乡', '3853', '1');
INSERT INTO `bbs_area` VALUES ('3861', '褒忠乡', '3853', '1');
INSERT INTO `bbs_area` VALUES ('3862', '东势乡', '3853', '1');
INSERT INTO `bbs_area` VALUES ('3863', '台西乡', '3853', '1');
INSERT INTO `bbs_area` VALUES ('3864', '仑背乡', '3853', '1');
INSERT INTO `bbs_area` VALUES ('3865', '麦寮乡', '3853', '1');
INSERT INTO `bbs_area` VALUES ('3866', '林内乡', '3853', '1');
INSERT INTO `bbs_area` VALUES ('3867', '古坑乡', '3853', '1');
INSERT INTO `bbs_area` VALUES ('3868', '莿桐乡', '3853', '1');
INSERT INTO `bbs_area` VALUES ('3869', '二仑乡', '3853', '1');
INSERT INTO `bbs_area` VALUES ('3870', '水林乡', '3853', '1');
INSERT INTO `bbs_area` VALUES ('3871', '口湖乡', '3853', '1');
INSERT INTO `bbs_area` VALUES ('3872', '四湖乡', '3853', '1');
INSERT INTO `bbs_area` VALUES ('3873', '元长乡', '3853', '1');
INSERT INTO `bbs_area` VALUES ('3874', '嘉义县', '3601', '1');
INSERT INTO `bbs_area` VALUES ('3875', '太保市', '3874', '1');
INSERT INTO `bbs_area` VALUES ('3876', '朴子市', '3874', '1');
INSERT INTO `bbs_area` VALUES ('3877', '布袋镇', '3874', '1');
INSERT INTO `bbs_area` VALUES ('3878', '大林镇', '3874', '1');
INSERT INTO `bbs_area` VALUES ('3879', '民雄乡', '3874', '1');
INSERT INTO `bbs_area` VALUES ('3880', '溪口乡', '3874', '1');
INSERT INTO `bbs_area` VALUES ('3881', '新港乡', '3874', '1');
INSERT INTO `bbs_area` VALUES ('3882', '六脚乡', '3874', '1');
INSERT INTO `bbs_area` VALUES ('3883', '东石乡', '3874', '1');
INSERT INTO `bbs_area` VALUES ('3884', '义竹乡', '3874', '1');
INSERT INTO `bbs_area` VALUES ('3885', '鹿草乡', '3874', '1');
INSERT INTO `bbs_area` VALUES ('3886', '水上乡', '3874', '1');
INSERT INTO `bbs_area` VALUES ('3887', '中埔乡', '3874', '1');
INSERT INTO `bbs_area` VALUES ('3888', '竹崎乡', '3874', '1');
INSERT INTO `bbs_area` VALUES ('3889', '梅山乡', '3874', '1');
INSERT INTO `bbs_area` VALUES ('3890', '番路乡', '3874', '1');
INSERT INTO `bbs_area` VALUES ('3891', '大埔乡', '3874', '1');
INSERT INTO `bbs_area` VALUES ('3892', '阿里山乡', '3874', '1');
INSERT INTO `bbs_area` VALUES ('3893', '屏东县', '3601', '1');
INSERT INTO `bbs_area` VALUES ('3894', '屏东市', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3895', '潮州镇', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3896', '东港镇', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3897', '恒春镇', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3898', '三地门乡', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3899', '雾台乡', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3900', '玛家乡', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3901', '九如乡', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3902', '里港乡', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3903', '高树乡', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3904', '盐埔乡', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3905', '长治乡', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3906', '麟洛乡', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3907', '竹田乡', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3908', '内埔乡', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3909', '万丹乡', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3910', '泰武乡', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3911', '来义乡', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3912', '万峦乡', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3913', '莰顶乡', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3914', '新埤乡', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3915', '南州乡', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3916', '林边乡', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3917', '琉球乡', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3918', '佳冬乡', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3919', '新园乡', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3920', '枋寮乡', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3921', '枋山乡', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3922', '春日乡', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3923', '狮子乡', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3924', '车城乡', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3925', '牡丹乡', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3926', '满州乡', '3893', '1');
INSERT INTO `bbs_area` VALUES ('3927', '宜兰县', '3601', '1');
INSERT INTO `bbs_area` VALUES ('3928', '宜兰市', '3927', '1');
INSERT INTO `bbs_area` VALUES ('3929', '头城镇', '3927', '1');
INSERT INTO `bbs_area` VALUES ('3930', '罗东镇', '3927', '1');
INSERT INTO `bbs_area` VALUES ('3931', '苏澳镇', '3927', '1');
INSERT INTO `bbs_area` VALUES ('3932', '礁溪乡', '3927', '1');
INSERT INTO `bbs_area` VALUES ('3933', '壮围乡', '3927', '1');
INSERT INTO `bbs_area` VALUES ('3934', '员山乡', '3927', '1');
INSERT INTO `bbs_area` VALUES ('3935', '冬山乡', '3927', '1');
INSERT INTO `bbs_area` VALUES ('3936', '五结乡', '3927', '1');
INSERT INTO `bbs_area` VALUES ('3937', '三星乡', '3927', '1');
INSERT INTO `bbs_area` VALUES ('3938', '大同乡', '3927', '1');
INSERT INTO `bbs_area` VALUES ('3939', '南澳乡', '3927', '1');
INSERT INTO `bbs_area` VALUES ('3940', '花莲县', '3601', '1');
INSERT INTO `bbs_area` VALUES ('3941', '花莲市', '3940', '1');
INSERT INTO `bbs_area` VALUES ('3942', '凤林镇', '3940', '1');
INSERT INTO `bbs_area` VALUES ('3943', '玉里镇', '3940', '1');
INSERT INTO `bbs_area` VALUES ('3944', '新城乡', '3940', '1');
INSERT INTO `bbs_area` VALUES ('3945', '吉安乡', '3940', '1');
INSERT INTO `bbs_area` VALUES ('3946', '寿丰乡', '3940', '1');
INSERT INTO `bbs_area` VALUES ('3947', '光复乡', '3940', '1');
INSERT INTO `bbs_area` VALUES ('3948', '丰滨乡', '3940', '1');
INSERT INTO `bbs_area` VALUES ('3949', '瑞穗乡', '3940', '1');
INSERT INTO `bbs_area` VALUES ('3950', '富里乡', '3940', '1');
INSERT INTO `bbs_area` VALUES ('3951', '秀林乡', '3940', '1');
INSERT INTO `bbs_area` VALUES ('3952', '万荣乡', '3940', '1');
INSERT INTO `bbs_area` VALUES ('3953', '卓溪乡', '3940', '1');
INSERT INTO `bbs_area` VALUES ('3954', '台东县', '3601', '1');
INSERT INTO `bbs_area` VALUES ('3955', '台东市', '3954', '1');
INSERT INTO `bbs_area` VALUES ('3956', '成功镇', '3954', '1');
INSERT INTO `bbs_area` VALUES ('3957', '关山镇', '3954', '1');
INSERT INTO `bbs_area` VALUES ('3958', '卑南乡', '3954', '1');
INSERT INTO `bbs_area` VALUES ('3959', '鹿野乡', '3954', '1');
INSERT INTO `bbs_area` VALUES ('3960', '池上乡', '3954', '1');
INSERT INTO `bbs_area` VALUES ('3961', '东河乡', '3954', '1');
INSERT INTO `bbs_area` VALUES ('3962', '长滨乡', '3954', '1');
INSERT INTO `bbs_area` VALUES ('3963', '太麻里乡', '3954', '1');
INSERT INTO `bbs_area` VALUES ('3964', '大武乡', '3954', '1');
INSERT INTO `bbs_area` VALUES ('3965', '绿岛乡', '3954', '1');
INSERT INTO `bbs_area` VALUES ('3966', '海端乡', '3954', '1');
INSERT INTO `bbs_area` VALUES ('3967', '延平乡', '3954', '1');
INSERT INTO `bbs_area` VALUES ('3968', '金峰乡', '3954', '1');
INSERT INTO `bbs_area` VALUES ('3969', '达仁乡', '3954', '1');
INSERT INTO `bbs_area` VALUES ('3970', '兰屿乡', '3954', '1');
INSERT INTO `bbs_area` VALUES ('3971', '澎湖县', '3601', '1');
INSERT INTO `bbs_area` VALUES ('3972', '马公市', '3971', '1');
INSERT INTO `bbs_area` VALUES ('3973', '西屿乡', '3971', '1');
INSERT INTO `bbs_area` VALUES ('3974', '望安乡', '3971', '1');
INSERT INTO `bbs_area` VALUES ('3975', '七美乡', '3971', '1');
INSERT INTO `bbs_area` VALUES ('3976', '白沙乡', '3971', '1');
INSERT INTO `bbs_area` VALUES ('3977', '湖西乡', '3971', '1');
INSERT INTO `bbs_area` VALUES ('3978', '金门县', '3601', '1');
INSERT INTO `bbs_area` VALUES ('3979', '金城镇', '3978', '1');
INSERT INTO `bbs_area` VALUES ('3980', '金湖镇', '3978', '1');
INSERT INTO `bbs_area` VALUES ('3981', '金沙镇', '3978', '1');
INSERT INTO `bbs_area` VALUES ('3982', '金宁乡', '3978', '1');
INSERT INTO `bbs_area` VALUES ('3983', '烈屿乡', '3978', '1');
INSERT INTO `bbs_area` VALUES ('3984', '乌丘乡', '3978', '1');

-- ----------------------------
-- Table structure for browse_record_info
-- ----------------------------
DROP TABLE IF EXISTS `browse_record_info`;
CREATE TABLE `browse_record_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `company_id` int(11) DEFAULT NULL COMMENT '商家[公司]id',
  `company_name` varchar(100) DEFAULT NULL COMMENT '公司名字',
  `project_id` int(11) DEFAULT NULL COMMENT '兼职项目id',
  `project_title` varchar(100) DEFAULT NULL COMMENT '兼职项目标题',
  `salary` decimal(10,0) DEFAULT NULL COMMENT '薪水',
  `salary_unit` int(11) DEFAULT NULL COMMENT '薪水单位：1 天 2 小时 3 月 4 次 5 单',
  `project_label` varchar(50) DEFAULT NULL COMMENT '项目标签：1长期工 2 短期工 3寒假工 4暑假工 5钟点工 ',
  `province_id` int(11) DEFAULT NULL COMMENT '省份id',
  `province_title` varchar(100) DEFAULT NULL COMMENT '省份名字',
  `city_id` int(11) DEFAULT NULL COMMENT '城市id',
  `city_title` varchar(100) DEFAULT NULL COMMENT '城市名字',
  `area_id` int(11) DEFAULT NULL COMMENT '区域id',
  `area_title` varchar(100) DEFAULT NULL COMMENT '区域名称',
  `work_address` varchar(255) DEFAULT NULL COMMENT '上班详细地址',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除：1 删除 2 未删除',
  `founder` varchar(50) DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(50) DEFAULT NULL COMMENT '修改人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of browse_record_info
-- ----------------------------

-- ----------------------------
-- Table structure for cash_withdrawal
-- ----------------------------
DROP TABLE IF EXISTS `cash_withdrawal`;
CREATE TABLE `cash_withdrawal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cash_withdrawal_order_id` varchar(50) DEFAULT NULL COMMENT '提现订单号',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `cash_withdrawal_amount` decimal(10,0) DEFAULT NULL COMMENT '提现金额',
  `cash_withdrawal_account` varchar(255) DEFAULT NULL COMMENT '提现账号',
  `cash_withdrawal_account_type` int(11) DEFAULT NULL COMMENT '提现账号类型：1 支付宝 2 微信 3 qq 4 银行卡 5 红包 6 转账',
  `cash_withdrawal_status` int(11) DEFAULT NULL COMMENT '提现状态：1 处理中 2 成功 3 失败 ',
  `examine_status` int(11) DEFAULT NULL COMMENT '审核状态：1 待审核 2 已通过 3已驳回',
  `cash_withdrawal_date` datetime DEFAULT NULL COMMENT '提现时间',
  `examine_date` datetime DEFAULT NULL COMMENT '审核时间',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除：1 删除 2 未删除',
  `founder` varchar(50) DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(50) DEFAULT NULL COMMENT '修改人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cash_withdrawal
-- ----------------------------

-- ----------------------------
-- Table structure for change_amount_record_info
-- ----------------------------
DROP TABLE IF EXISTS `change_amount_record_info`;
CREATE TABLE `change_amount_record_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `project_id` int(11) DEFAULT NULL COMMENT '项目id',
  `change_amount` decimal(10,0) DEFAULT NULL COMMENT '变动余额',
  `current_surplus_amount` decimal(10,0) DEFAULT NULL COMMENT '当前剩余余额',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除：1 删除 2 未删除',
  `founder` varchar(50) DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(50) DEFAULT NULL COMMENT '修改人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of change_amount_record_info
-- ----------------------------

-- ----------------------------
-- Table structure for collection_record_info
-- ----------------------------
DROP TABLE IF EXISTS `collection_record_info`;
CREATE TABLE `collection_record_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `company_id` int(11) DEFAULT NULL COMMENT '商家[公司]id',
  `company_name` varchar(100) DEFAULT NULL COMMENT '公司名字',
  `project_id` int(11) DEFAULT NULL COMMENT '兼职项目id',
  `project_title` varchar(100) DEFAULT NULL COMMENT '兼职项目标题',
  `salary` decimal(10,0) DEFAULT NULL COMMENT '薪水',
  `salary_unit` int(11) DEFAULT NULL COMMENT '薪水单位：1 天 2 小时 3 月 4 次 5 单',
  `project_label` varchar(50) DEFAULT NULL COMMENT '项目标签：1长期工 2 短期工 3寒假工 4暑假工 5钟点工 ',
  `province_id` int(11) DEFAULT NULL COMMENT '省份id',
  `province_title` varchar(100) DEFAULT NULL COMMENT '省份名称',
  `city_id` int(11) DEFAULT NULL COMMENT '城市id',
  `city_title` varchar(100) DEFAULT NULL COMMENT '城市名称',
  `area_id` int(11) DEFAULT NULL COMMENT '区域id',
  `area_title` varchar(100) DEFAULT NULL COMMENT '区域名称',
  `work_address` varchar(255) DEFAULT NULL COMMENT '上班详细地址',
  `is_collection` int(11) DEFAULT NULL COMMENT '是否收藏：1 已收藏 2 取消收藏',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除：1 删除 2 未删除',
  `founder` varchar(50) DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(50) DEFAULT NULL COMMENT '修改人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collection_record_info
-- ----------------------------
INSERT INTO `collection_record_info` VALUES ('1', '1', '1', '五芳斋', '1', '厨师', '1', '2', '1,2', '1', '河南省', '1', '商丘市', '1', '民权县', '浙江省普陀区', '2', '2', '1', '1', '2020-01-09 18:18:17', '2020-01-09 18:36:50');
INSERT INTO `collection_record_info` VALUES ('2', '1', '1', '上海朝浩信息科技有限公司', '2', 'CTO', '1', '2', '1,4', '1', null, '1', null, '1', null, '浙江省普陀区', '1', '2', '1', '1', '2020-01-09 18:19:11', '2020-01-09 18:34:02');

-- ----------------------------
-- Table structure for evaluate_info
-- ----------------------------
DROP TABLE IF EXISTS `evaluate_info`;
CREATE TABLE `evaluate_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `project_id` int(11) DEFAULT NULL COMMENT '项目id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `company_id` int(11) DEFAULT NULL COMMENT '商家[公司]id',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `user_mobile` varchar(12) DEFAULT NULL COMMENT '用户手机号',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除：1 删除 2 未删除',
  `star_level` int(11) DEFAULT NULL COMMENT '评价星级',
  `evaluate_content` varchar(255) DEFAULT NULL COMMENT '评价内容',
  `evaluate_source` int(11) DEFAULT NULL COMMENT '评价来源： 1 用户对商家[公司]  2商家[公司]对用户',
  `founder` varchar(50) DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(50) DEFAULT NULL COMMENT '修改人',
  `create_date` datetime DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of evaluate_info
-- ----------------------------
INSERT INTO `evaluate_info` VALUES ('1', '2', '2', '2', null, '17621007255', '2', '5', '插画小姑娘长的真好看，回头让我家傻儿子娶了她', '1', '2', '2', '2020-01-09 15:13:39', '2020-01-09 15:13:39');
INSERT INTO `evaluate_info` VALUES ('2', '1', '1', '2', null, '17621007255', '2', '1', '垃圾公司，说好的5个接口，结果干到了55个接口，干拖着不给结算工资', '1', '1', '1', '2020-01-09 15:14:54', '2020-01-09 15:14:54');

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `login_status` int(11) DEFAULT NULL COMMENT '登陆状态：1成功 2 失败',
  `login_date` datetime DEFAULT NULL COMMENT '登陆日期',
  `fail_remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '失败原因',
  `login_ip` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '登陆ip',
  `is_delete` int(1) DEFAULT NULL COMMENT '是否删除：1删除，2未删除',
  `founder` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '修改人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of login_log
-- ----------------------------
INSERT INTO `login_log` VALUES ('22', '23', '1', '2020-01-07 15:41:33', '登录成功', '192.168.56.1', null, '23', '23', '2020-01-07 15:41:33', '2020-01-07 15:41:33');

-- ----------------------------
-- Table structure for login_log_info
-- ----------------------------
DROP TABLE IF EXISTS `login_log_info`;
CREATE TABLE `login_log_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `login_status` int(11) DEFAULT NULL COMMENT '登陆状态：1成功 2 失败',
  `login_date` datetime DEFAULT NULL COMMENT '登陆日期',
  `fail_remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '失败原因',
  `login_ip` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '登陆ip',
  `founder` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '修改人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of login_log_info
-- ----------------------------

-- ----------------------------
-- Table structure for message_count
-- ----------------------------
DROP TABLE IF EXISTS `message_count`;
CREATE TABLE `message_count` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `mobile` varchar(12) DEFAULT NULL COMMENT '用户手机号',
  `message_type` int(11) DEFAULT NULL COMMENT '短信类型: 1 注册 2 找回密码 3.登录',
  `send_content` varchar(255) DEFAULT NULL COMMENT '短信发送内容',
  `send_date` datetime DEFAULT NULL COMMENT '发送时间',
  `send_ip` varchar(50) DEFAULT NULL COMMENT '发送ip',
  `founder` varchar(50) DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(50) DEFAULT NULL COMMENT '修改人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message_count
-- ----------------------------

-- ----------------------------
-- Table structure for message_record
-- ----------------------------
DROP TABLE IF EXISTS `message_record`;
CREATE TABLE `message_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `mobile` varchar(12) DEFAULT NULL COMMENT '用户手机号',
  `message_type` int(11) DEFAULT NULL COMMENT '短信类型: 1 注册 2 找回密码 3.登录',
  `send_content` varchar(255) DEFAULT NULL COMMENT '短信发送内容',
  `send_date` datetime DEFAULT NULL COMMENT '发送时间',
  `send_ip` varchar(50) DEFAULT NULL COMMENT '发送ip',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除：1 删除 2 未删除',
  `founder` varchar(50) DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(50) DEFAULT NULL COMMENT '修改人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message_record
-- ----------------------------
INSERT INTO `message_record` VALUES ('10', null, '17621007255', '1', '您正在进行使用短信注册新账号', null, '192.168.56.1', null, '17621007255', '17621007255', '2020-01-07 15:27:52', '2020-01-07 15:27:52');
INSERT INTO `message_record` VALUES ('11', null, '17621007255', '1', '您正在进行使用短信注册新账号', null, '192.168.56.1', null, '17621007255', '17621007255', '2020-01-07 15:35:41', '2020-01-07 15:35:41');

-- ----------------------------
-- Table structure for project_info
-- ----------------------------
DROP TABLE IF EXISTS `project_info`;
CREATE TABLE `project_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '商家id',
  `user_name` varchar(50) DEFAULT NULL COMMENT '创建人',
  `project_type_id` int(11) DEFAULT NULL COMMENT '项目所属类型id',
  `project_type_name` varchar(50) DEFAULT '' COMMENT '类型名称',
  `project_title` varchar(100) DEFAULT NULL COMMENT '项目名字',
  `project_content` varchar(255) DEFAULT NULL COMMENT '岗位简介',
  `project_ascription_company` varchar(100) DEFAULT NULL COMMENT '项目所属公司',
  `province_id` int(11) DEFAULT NULL COMMENT '省份id',
  `province_title` varchar(100) DEFAULT NULL COMMENT '省份名称',
  `city_id` int(11) DEFAULT NULL COMMENT '城市id',
  `city_title` varchar(100) DEFAULT NULL COMMENT '城市名称',
  `area_id` int(11) DEFAULT NULL COMMENT '县区[区域]id',
  `area_title` varchar(100) DEFAULT NULL COMMENT '区域名称',
  `work_address` varchar(100) DEFAULT NULL COMMENT '上班详细地址',
  `gender_requirement` int(11) DEFAULT NULL COMMENT '性别要求：1 男 2 女 3 不限',
  `project_label` varchar(50) DEFAULT NULL COMMENT '项目标签：1长期工 2 短期工 3寒假工 4暑假工 5钟点工 ',
  `salary` decimal(10,0) DEFAULT NULL COMMENT '薪水',
  `salary_unit` int(11) DEFAULT NULL COMMENT '工资单位：1 天 2 小时 3 月 4 次 5 单',
  `settlement_cycle` int(11) DEFAULT NULL COMMENT '结算周期：1 完工结 2 日结 3 周结 4 月结',
  `work_welfares_id` varchar(50) DEFAULT '' COMMENT '工作福利:1包饭 2 包住 3交通费 4电话费 5股权 6 年终奖 7 暂无   ',
  `project_need_num` int(11) DEFAULT NULL COMMENT '项目需要人数',
  `project_contacts_name` varchar(50) DEFAULT NULL COMMENT '项目联系人姓名',
  `project_contacts_mobile` varchar(12) DEFAULT NULL COMMENT '项目联系人手机号码',
  `project_contacts_email` varchar(255) DEFAULT NULL COMMENT '联系邮箱',
  `project_skill` varchar(255) DEFAULT NULL COMMENT '项目要求',
  `work_time_num` int(11) DEFAULT NULL COMMENT '工作时间数',
  `work_time_unit` int(255) DEFAULT NULL COMMENT '工作时间单位：1.小时 2.天 3.月 4年 ',
  `work_time_interval_min` time DEFAULT NULL COMMENT '上班时段[开始时间]',
  `work_time_interval_max` time DEFAULT NULL COMMENT '上班时段[结束时间]',
  `work_time_requirement` varchar(255) DEFAULT NULL COMMENT '时间要求',
  `project_begin_time` datetime DEFAULT NULL COMMENT '项目开始时间',
  `project_end_time` datetime DEFAULT NULL COMMENT '项目截至时间',
  `project_remark` varchar(255) DEFAULT NULL COMMENT '项目备注',
  `order_id` varchar(100) DEFAULT NULL COMMENT '订单id',
  `totalPay_amount` decimal(10,0) DEFAULT NULL COMMENT '总支付',
  `service_charge` decimal(10,0) DEFAULT NULL COMMENT '手续费',
  `service_charge_rate` decimal(10,0) DEFAULT NULL COMMENT '手续费费率',
  `order_state` int(11) DEFAULT NULL COMMENT '订单状态',
  `project_state` int(11) DEFAULT NULL COMMENT '项目状态：1 项目发布 2 用户报名 3 开始工作 4交易完成',
  `examine_status` int(11) DEFAULT NULL COMMENT '审核状态 1待审核 2 已通过 3 已驳回',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除：1 删除 2 未删除',
  `founder` varchar(50) DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(50) DEFAULT NULL COMMENT '修改人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project_info
-- ----------------------------
INSERT INTO `project_info` VALUES ('1', '1', null, '1002', '杂志店', '插画师', '插画师', '插画师', '1', null, '2', null, '1', null, '浦东新区', '3', '1,2,3', null, '1', '1', '1,4', '1', '马浩然', '17621007255', '17621007255@163.com', '1', '5', '1', null, null, '1', null, null, null, null, null, null, null, null, '1', '2', '1', '1', '1', '2020-01-08 15:53:47', '2020-01-08 15:53:48');
INSERT INTO `project_info` VALUES ('2', '1', null, '1002', '杂志店', '编辑', '编辑', '编辑', '1', null, '2', null, '1', null, '浦东新区', '3', '2,3,4', null, '1', '1', '1,2', '1', '马浩然', '17621007255', '17621007255@163.com', '1', '5', '1', null, null, '1', null, null, null, null, null, null, null, null, '1', '2', '2', '1', '1', '2020-01-08 15:55:43', '2020-01-08 15:55:43');
INSERT INTO `project_info` VALUES ('3', '1', null, '1002', '杂志店', '模特', '模特', '模特', '1', null, '2', null, '1', null, '浦东新区', '3', '3,4,5', null, '1', '1', '1,3', '1', '马浩然', '17621007255', '17621007255@163.com', '1', '5', '1', null, null, '1', null, null, null, null, null, null, null, null, '1', '2', '2', '1', '1', '2020-01-08 15:58:13', '2020-01-08 15:58:13');

-- ----------------------------
-- Table structure for project_type
-- ----------------------------
DROP TABLE IF EXISTS `project_type`;
CREATE TABLE `project_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL COMMENT '父级id',
  `category_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '分类名称',
  `charge_rate` double DEFAULT NULL COMMENT '收费百分比',
  `project_type_status` int(11) DEFAULT NULL COMMENT '项目类型状态：1 正常 2.禁用',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除：1 删除 2 未删除',
  `founder` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '修改人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of project_type
-- ----------------------------

-- ----------------------------
-- Table structure for project_work_date_info
-- ----------------------------
DROP TABLE IF EXISTS `project_work_date_info`;
CREATE TABLE `project_work_date_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) DEFAULT NULL COMMENT '项目关联id',
  `work_date_begin` varchar(50) DEFAULT '' COMMENT '开始上班日期',
  `work_date_end` varchar(50) DEFAULT '' COMMENT '结束上班日期',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除：1 删除 2 未删除',
  `founder` varchar(50) DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(255) DEFAULT NULL COMMENT '修改人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project_work_date_info
-- ----------------------------
INSERT INTO `project_work_date_info` VALUES ('1', '1', '2020-1-20', '2020-1-30', '2', '1', '1', '2020-01-08 15:54:14', '2020-01-08 15:54:14');
INSERT INTO `project_work_date_info` VALUES ('2', '2', '2020-1-20', '2020-1-30', '2', '1', '1', '2020-01-08 15:55:51', '2020-01-08 15:55:51');
INSERT INTO `project_work_date_info` VALUES ('3', '3', '2020-1-20', '2020-1-30', '2', '1', '1', '2020-01-08 15:58:13', '2020-01-08 15:58:13');

-- ----------------------------
-- Table structure for project_work_time_info
-- ----------------------------
DROP TABLE IF EXISTS `project_work_time_info`;
CREATE TABLE `project_work_time_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) DEFAULT NULL COMMENT '项目关联id',
  `work_time_begin` varchar(30) DEFAULT '' COMMENT '开始上班时间',
  `work_time_end` varchar(30) DEFAULT '' COMMENT '结束上班时间',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除：1 删除 2 未删除',
  `founder` varchar(50) DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(255) DEFAULT NULL COMMENT '修改人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project_work_time_info
-- ----------------------------
INSERT INTO `project_work_time_info` VALUES ('1', '1', '08:00:00', '18:00:00', '2', '1', '1', '2020-01-08 15:54:16', '2020-01-08 15:54:16');
INSERT INTO `project_work_time_info` VALUES ('2', '2', '08:00:00', '18:00:00', '2', '1', '1', '2020-01-08 15:55:53', '2020-01-08 15:55:53');
INSERT INTO `project_work_time_info` VALUES ('3', '3', '08:00:00', '18:00:00', '2', '1', '1', '2020-01-08 15:58:13', '2020-01-08 15:58:13');

-- ----------------------------
-- Table structure for recharge
-- ----------------------------
DROP TABLE IF EXISTS `recharge`;
CREATE TABLE `recharge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `recharge_order_id` varchar(50) DEFAULT NULL COMMENT '充值订单号',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户姓名',
  `recharge_amount` decimal(10,0) DEFAULT NULL COMMENT '充值金额',
  `recharge_account` varchar(50) DEFAULT NULL COMMENT '充值账号',
  `recharge_account_type` int(11) DEFAULT NULL COMMENT '充值账号类型：1 支付宝 2 微信 3 qq 4 银行 5 红包 6转账',
  `recharge_date` datetime DEFAULT NULL COMMENT '支付时间',
  `recharge_order_status` int(11) DEFAULT NULL COMMENT '充值订单状态：1 已成功 2 已失败 3 处理中',
  `thread_callback_params` varchar(100) DEFAULT NULL COMMENT '第三方回调参数',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除：1 删除 2 未删除',
  `founder` varchar(50) DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(50) DEFAULT NULL COMMENT '修改人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recharge
-- ----------------------------

-- ----------------------------
-- Table structure for sign_up_info
-- ----------------------------
DROP TABLE IF EXISTS `sign_up_info`;
CREATE TABLE `sign_up_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `project_id` int(11) DEFAULT NULL COMMENT '项目id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `user_mobile` varchar(12) DEFAULT NULL COMMENT '用户手机号',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除：1 删除 2 未删除',
  `state` int(11) DEFAULT NULL COMMENT '报名状态：1 待录用 2 已录用 3已结算 4 待评价 5 已取消',
  `founder` varchar(50) DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(50) DEFAULT NULL COMMENT '修改人',
  `create_date` datetime DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sign_up_info
-- ----------------------------
INSERT INTO `sign_up_info` VALUES ('1', '1', '1', '1', '17621007255', '2', '2', '1', '1', '2020-01-07 09:51:21', '2020-01-07 09:51:21');
INSERT INTO `sign_up_info` VALUES ('3', '1', '2', '凤凰小哥哥', '17621007255', '2', '1', null, null, '2020-01-07 14:40:38', '2020-01-07 14:40:38');
INSERT INTO `sign_up_info` VALUES ('4', '3', '2', '凤凰小哥哥', '17621007255', '2', '1', null, null, '2020-01-07 14:50:28', '2020-01-07 14:50:28');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `user_nickName` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户昵称',
  `id_card` varchar(19) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户身份证号码',
  `user_head` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户头像',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户密码',
  `wechat` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '微信',
  `qq` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'QQ',
  `email` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户邮箱',
  `gender` int(2) DEFAULT NULL COMMENT '性别：1 男 2 女',
  `mobile` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户手机号',
  `province_id` int(11) DEFAULT NULL COMMENT '省份id',
  `city_id` int(11) DEFAULT NULL COMMENT '城市id',
  `county_Area_id` int(11) DEFAULT NULL COMMENT '县区id',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户地址',
  `id_card_x` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '身份证正面',
  `id_card_y` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '身份证反面',
  `user_status` int(1) DEFAULT NULL COMMENT '用户状态：1冻结，2正常',
  `is_delete` int(1) DEFAULT NULL COMMENT '是否删除：1删除，2未删除',
  `amount` decimal(10,0) DEFAULT NULL COMMENT '余额',
  `user_type` int(11) DEFAULT NULL COMMENT '用户类型：1前台[app用户] 2 后台[admin]',
  `user_level` int(11) DEFAULT NULL COMMENT '用户等级',
  `emergency_contact_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '紧急联系人',
  `emergency_contact_mobile` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '紧急联系人手机号',
  `founder` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '修改人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', '罗显', '凤凰小哥哥', null, 'string', '58VcrX596YpqZ2ivfISwBQ==', null, null, null, null, 'string', '0', '0', '0', '河南商丘', null, null, '0', null, null, '0', null, 'string', 'string', null, 'string', null, null);
