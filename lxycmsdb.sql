/*
Navicat MySQL Data Transfer

Source Server         : cridb
Source Server Version : 50518
Source Host           : localhost:3306
Source Database       : lxycmsdb

Target Server Type    : MYSQL
Target Server Version : 50518
File Encoding         : 65001

Date: 2014-12-18 10:02:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `country`
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `id` int(11) NOT NULL DEFAULT '0',
  `countryname` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `countrycode` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES ('1', 'Angola', 'AO');
INSERT INTO `country` VALUES ('2', 'Afghanistan', 'AF');
INSERT INTO `country` VALUES ('3', 'Albania', 'AL');
INSERT INTO `country` VALUES ('4', 'Algeria', 'DZ');
INSERT INTO `country` VALUES ('5', 'Andorra', 'AD');
INSERT INTO `country` VALUES ('6', 'Anguilla', 'AI');
INSERT INTO `country` VALUES ('7', 'Antigua and Barbuda', 'AG');
INSERT INTO `country` VALUES ('8', 'Argentina', 'AR');
INSERT INTO `country` VALUES ('9', 'Armenia', 'AM');
INSERT INTO `country` VALUES ('10', 'Australia', 'AU');
INSERT INTO `country` VALUES ('11', 'Austria', 'AT');
INSERT INTO `country` VALUES ('12', 'Azerbaijan', 'AZ');
INSERT INTO `country` VALUES ('13', 'Bahamas', 'BS');
INSERT INTO `country` VALUES ('14', 'Bahrain', 'BH');
INSERT INTO `country` VALUES ('15', 'Bangladesh', 'BD');
INSERT INTO `country` VALUES ('16', 'Barbados', 'BB');
INSERT INTO `country` VALUES ('17', 'Belarus', 'BY');
INSERT INTO `country` VALUES ('18', 'Belgium', 'BE');
INSERT INTO `country` VALUES ('19', 'Belize', 'BZ');
INSERT INTO `country` VALUES ('20', 'Benin', 'BJ');
INSERT INTO `country` VALUES ('21', 'Bermuda Is.', 'BM');
INSERT INTO `country` VALUES ('22', 'Bolivia', 'BO');
INSERT INTO `country` VALUES ('23', 'Botswana', 'BW');
INSERT INTO `country` VALUES ('24', 'Brazil', 'BR');
INSERT INTO `country` VALUES ('25', 'Brunei', 'BN');
INSERT INTO `country` VALUES ('26', 'Bulgaria', 'BG');
INSERT INTO `country` VALUES ('27', 'Burkina-faso', 'BF');
INSERT INTO `country` VALUES ('28', 'Burma', 'MM');
INSERT INTO `country` VALUES ('29', 'Burundi', 'BI');
INSERT INTO `country` VALUES ('30', 'Cameroon', 'CM');
INSERT INTO `country` VALUES ('31', 'Canada', 'CA');
INSERT INTO `country` VALUES ('32', 'Central African Republic', 'CF');
INSERT INTO `country` VALUES ('33', 'Chad', 'TD');
INSERT INTO `country` VALUES ('34', 'Chile', 'CL');
INSERT INTO `country` VALUES ('35', 'China', 'CN');
INSERT INTO `country` VALUES ('36', 'Colombia', 'CO');
INSERT INTO `country` VALUES ('37', 'Congo', 'CG');
INSERT INTO `country` VALUES ('38', 'Cook Is.', 'CK');
INSERT INTO `country` VALUES ('39', 'Costa Rica', 'CR');
INSERT INTO `country` VALUES ('40', 'Cuba', 'CU');
INSERT INTO `country` VALUES ('41', 'Cyprus', 'CY');
INSERT INTO `country` VALUES ('42', 'Czech Republic', 'CZ');
INSERT INTO `country` VALUES ('43', 'Denmark', 'DK');
INSERT INTO `country` VALUES ('44', 'Djibouti', 'DJ');
INSERT INTO `country` VALUES ('45', 'Dominica Rep.', 'DO');
INSERT INTO `country` VALUES ('46', 'Ecuador', 'EC');
INSERT INTO `country` VALUES ('47', 'Egypt', 'EG');
INSERT INTO `country` VALUES ('48', 'EI Salvador', 'SV');
INSERT INTO `country` VALUES ('49', 'Estonia', 'EE');
INSERT INTO `country` VALUES ('50', 'Ethiopia', 'ET');
INSERT INTO `country` VALUES ('51', 'Fiji', 'FJ');
INSERT INTO `country` VALUES ('52', 'Finland', 'FI');
INSERT INTO `country` VALUES ('53', 'France', 'FR');
INSERT INTO `country` VALUES ('54', 'French Guiana', 'GF');
INSERT INTO `country` VALUES ('55', 'Gabon', 'GA');
INSERT INTO `country` VALUES ('56', 'Gambia', 'GM');
INSERT INTO `country` VALUES ('57', 'Georgia', 'GE');
INSERT INTO `country` VALUES ('58', 'Germany', 'DE');
INSERT INTO `country` VALUES ('59', 'Ghana', 'GH');
INSERT INTO `country` VALUES ('60', 'Gibraltar', 'GI');
INSERT INTO `country` VALUES ('61', 'Greece', 'GR');
INSERT INTO `country` VALUES ('62', 'Grenada', 'GD');
INSERT INTO `country` VALUES ('63', 'Guam', 'GU');
INSERT INTO `country` VALUES ('64', 'Guatemala', 'GT');
INSERT INTO `country` VALUES ('65', 'Guinea', 'GN');
INSERT INTO `country` VALUES ('66', 'Guyana', 'GY');
INSERT INTO `country` VALUES ('67', 'Haiti', 'HT');
INSERT INTO `country` VALUES ('68', 'Honduras', 'HN');
INSERT INTO `country` VALUES ('69', 'Hongkong', 'HK');
INSERT INTO `country` VALUES ('70', 'Hungary', 'HU');
INSERT INTO `country` VALUES ('71', 'Iceland', 'IS');
INSERT INTO `country` VALUES ('72', 'India', 'IN');
INSERT INTO `country` VALUES ('73', 'Indonesia', 'ID');
INSERT INTO `country` VALUES ('74', 'Iran', 'IR');
INSERT INTO `country` VALUES ('75', 'Iraq', 'IQ');
INSERT INTO `country` VALUES ('76', 'Ireland', 'IE');
INSERT INTO `country` VALUES ('77', 'Israel', 'IL');
INSERT INTO `country` VALUES ('78', 'Italy', 'IT');
INSERT INTO `country` VALUES ('79', 'Jamaica', 'JM');
INSERT INTO `country` VALUES ('80', 'Japan', 'JP');
INSERT INTO `country` VALUES ('81', 'Jordan', 'JO');
INSERT INTO `country` VALUES ('82', 'Kampuchea (Cambodia )', 'KH');
INSERT INTO `country` VALUES ('83', 'Kazakstan', 'KZ');
INSERT INTO `country` VALUES ('84', 'Kenya', 'KE');
INSERT INTO `country` VALUES ('85', 'Korea', 'KR');
INSERT INTO `country` VALUES ('86', 'Kuwait', 'KW');
INSERT INTO `country` VALUES ('87', 'Kyrgyzstan', 'KG');
INSERT INTO `country` VALUES ('88', 'Laos', 'LA');
INSERT INTO `country` VALUES ('89', 'Latvia', 'LV');
INSERT INTO `country` VALUES ('90', 'Lebanon', 'LB');
INSERT INTO `country` VALUES ('91', 'Lesotho', 'LS');
INSERT INTO `country` VALUES ('92', 'Liberia', 'LR');
INSERT INTO `country` VALUES ('93', 'Libya', 'LY');
INSERT INTO `country` VALUES ('94', 'Liechtenstein', 'LI');
INSERT INTO `country` VALUES ('95', 'Lithuania', 'LT');
INSERT INTO `country` VALUES ('96', 'Luxembourg', 'LU');
INSERT INTO `country` VALUES ('97', 'Macao', 'MO');
INSERT INTO `country` VALUES ('98', 'Madagascar', 'MG');
INSERT INTO `country` VALUES ('99', 'Malawi', 'MW');
INSERT INTO `country` VALUES ('100', 'Malaysia', 'MY');
INSERT INTO `country` VALUES ('101', 'Maldives', 'MV');
INSERT INTO `country` VALUES ('102', 'Mali', 'ML');
INSERT INTO `country` VALUES ('103', 'Malta', 'MT');
INSERT INTO `country` VALUES ('104', 'Mauritius', 'MU');
INSERT INTO `country` VALUES ('105', 'Mexico', 'MX');
INSERT INTO `country` VALUES ('106', 'Moldova, Republic of', 'MD');
INSERT INTO `country` VALUES ('107', 'Monaco', 'MC');
INSERT INTO `country` VALUES ('108', 'Mongolia', 'MN');
INSERT INTO `country` VALUES ('109', 'Montserrat Is', 'MS');
INSERT INTO `country` VALUES ('110', 'Morocco', 'MA');
INSERT INTO `country` VALUES ('111', 'Mozambique', 'MZ');
INSERT INTO `country` VALUES ('112', 'Namibia', 'NA');
INSERT INTO `country` VALUES ('113', 'Nauru', 'NR');
INSERT INTO `country` VALUES ('114', 'Nepal', 'NP');
INSERT INTO `country` VALUES ('115', 'Netherlands', 'NL');
INSERT INTO `country` VALUES ('116', 'New Zealand', 'NZ');
INSERT INTO `country` VALUES ('117', 'Nicaragua', 'NI');
INSERT INTO `country` VALUES ('118', 'Niger', 'NE');
INSERT INTO `country` VALUES ('119', 'Nigeria', 'NG');
INSERT INTO `country` VALUES ('120', 'North Korea', 'KP');
INSERT INTO `country` VALUES ('121', 'Norway', 'NO');
INSERT INTO `country` VALUES ('122', 'Oman', 'OM');
INSERT INTO `country` VALUES ('123', 'Pakistan', 'PK');
INSERT INTO `country` VALUES ('124', 'Panama', 'PA');
INSERT INTO `country` VALUES ('125', 'Papua New Cuinea', 'PG');
INSERT INTO `country` VALUES ('126', 'Paraguay', 'PY');
INSERT INTO `country` VALUES ('127', 'Peru', 'PE');
INSERT INTO `country` VALUES ('128', 'Philippines', 'PH');
INSERT INTO `country` VALUES ('129', 'Poland', 'PL');
INSERT INTO `country` VALUES ('130', 'French Polynesia', 'PF');
INSERT INTO `country` VALUES ('131', 'Portugal', 'PT');
INSERT INTO `country` VALUES ('132', 'Puerto Rico', 'PR');
INSERT INTO `country` VALUES ('133', 'Qatar', 'QA');
INSERT INTO `country` VALUES ('134', 'Romania', 'RO');
INSERT INTO `country` VALUES ('135', 'Russia', 'RU');
INSERT INTO `country` VALUES ('136', 'Saint Lueia', 'LC');
INSERT INTO `country` VALUES ('137', 'Saint Vincent', 'VC');
INSERT INTO `country` VALUES ('138', 'San Marino', 'SM');
INSERT INTO `country` VALUES ('139', 'Sao Tome and Principe', 'ST');
INSERT INTO `country` VALUES ('140', 'Saudi Arabia', 'SA');
INSERT INTO `country` VALUES ('141', 'Senegal', 'SN');
INSERT INTO `country` VALUES ('142', 'Seychelles', 'SC');
INSERT INTO `country` VALUES ('143', 'Sierra Leone', 'SL');
INSERT INTO `country` VALUES ('144', 'Singapore', 'SG');
INSERT INTO `country` VALUES ('145', 'Slovakia', 'SK');
INSERT INTO `country` VALUES ('146', 'Slovenia', 'SI');
INSERT INTO `country` VALUES ('147', 'Solomon Is', 'SB');
INSERT INTO `country` VALUES ('148', 'Somali', 'SO');
INSERT INTO `country` VALUES ('149', 'South Africa', 'ZA');
INSERT INTO `country` VALUES ('150', 'Spain', 'ES');
INSERT INTO `country` VALUES ('151', 'Sri Lanka', 'LK');
INSERT INTO `country` VALUES ('152', 'St.Lucia', 'LC');
INSERT INTO `country` VALUES ('153', 'St.Vincent', 'VC');
INSERT INTO `country` VALUES ('154', 'Sudan', 'SD');
INSERT INTO `country` VALUES ('155', 'Suriname', 'SR');
INSERT INTO `country` VALUES ('156', 'Swaziland', 'SZ');
INSERT INTO `country` VALUES ('157', 'Sweden', 'SE');
INSERT INTO `country` VALUES ('158', 'Switzerland', 'CH');
INSERT INTO `country` VALUES ('159', 'Syria', 'SY');
INSERT INTO `country` VALUES ('160', 'Taiwan', 'TW');
INSERT INTO `country` VALUES ('161', 'Tajikstan', 'TJ');
INSERT INTO `country` VALUES ('162', 'Tanzania', 'TZ');
INSERT INTO `country` VALUES ('163', 'Thailand', 'TH');
INSERT INTO `country` VALUES ('164', 'Togo', 'TG');
INSERT INTO `country` VALUES ('165', 'Tonga', 'TO');
INSERT INTO `country` VALUES ('166', 'Trinidad and Tobago', 'TT');
INSERT INTO `country` VALUES ('167', 'Tunisia', 'TN');
INSERT INTO `country` VALUES ('168', 'Turkey', 'TR');
INSERT INTO `country` VALUES ('169', 'Turkmenistan', 'TM');
INSERT INTO `country` VALUES ('170', 'Uganda', 'UG');
INSERT INTO `country` VALUES ('171', 'Ukraine', 'UA');
INSERT INTO `country` VALUES ('172', 'United Arab Emirates', 'AE');
INSERT INTO `country` VALUES ('173', 'United Kiongdom', 'GB');
INSERT INTO `country` VALUES ('174', 'United States of America', 'US');
INSERT INTO `country` VALUES ('175', 'Uruguay', 'UY');
INSERT INTO `country` VALUES ('176', 'Uzbekistan', 'UZ');
INSERT INTO `country` VALUES ('177', 'Venezuela', 'VE');
INSERT INTO `country` VALUES ('178', 'Vietnam', 'VN');
INSERT INTO `country` VALUES ('179', 'Yemen', 'YE');
INSERT INTO `country` VALUES ('180', 'Yugoslavia', 'YU');
INSERT INTO `country` VALUES ('181', 'Zimbabwe', 'ZW');
INSERT INTO `country` VALUES ('182', 'Zaire', 'ZR');
INSERT INTO `country` VALUES ('183', 'Zambia', 'ZM');

-- ----------------------------
-- Table structure for `lxy_company_detail`
-- ----------------------------
DROP TABLE IF EXISTS `lxy_company_detail`;
CREATE TABLE `lxy_company_detail` (
  `COMPANY_DETAIL_ID` bigint(32) NOT NULL AUTO_INCREMENT,
  `VERSION` int(11) NOT NULL,
  `UUID` varchar(40) DEFAULT NULL,
  `COMPANY_NAME` varchar(60) DEFAULT NULL,
  `COMPANY_VALUE` varchar(80) DEFAULT NULL,
  `COMPANY_DESC` varchar(200) DEFAULT NULL,
  `COMPANY_FACTORY` varchar(10) DEFAULT NULL,
  `COMPANY_FACTORY_ID` bigint(20) DEFAULT NULL,
  `COMPANY_SUMMARY` varchar(150) DEFAULT NULL,
  `COMP_SUMMARY_DETAIL` varchar(2000) DEFAULT NULL,
  `COMPANY_IMAGE_PATH` varchar(150) DEFAULT NULL,
  `TYPE_DETAIL_ATTRIBUTE1` varchar(80) DEFAULT NULL,
  `TYPE_DETAIL_ATTRIBUTE2` varchar(80) DEFAULT NULL,
  `TYPE_DETAIL_ATTRIBUTE3` varchar(80) DEFAULT NULL,
  `TYPE_DETAIL_ATTRIBUTE4` varchar(80) DEFAULT NULL,
  `TYPE_DETAIL_ATTRIBUTE5` varchar(80) DEFAULT NULL,
  `TYPE_DETAIL_ATTRIBUTE6` varchar(80) DEFAULT NULL,
  `MAKER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `MAKER_BY` varchar(100) DEFAULT NULL,
  `CHECKER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `CHECKER_BY` varchar(100) DEFAULT NULL,
  `CREATE_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `CREATE_BY` varchar(100) DEFAULT NULL,
  `MODIFY_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `MODIFY_BY` varchar(100) DEFAULT NULL,
  `AUTHORIZER_BY` varchar(50) DEFAULT NULL,
  `AUTHORIZER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  PRIMARY KEY (`COMPANY_DETAIL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lxy_company_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `lxy_company_news`
-- ----------------------------
DROP TABLE IF EXISTS `lxy_company_news`;
CREATE TABLE `lxy_company_news` (
  `NEWS_ID` bigint(32) NOT NULL AUTO_INCREMENT,
  `VERSION` int(11) NOT NULL,
  `UUID` varchar(40) DEFAULT NULL,
  `NEWS_NAME` varchar(60) DEFAULT NULL,
  `NEWS_VALUE` varchar(80) DEFAULT NULL,
  `NEWS_DESC` varchar(200) DEFAULT NULL,
  `NEWS_CONTENT` varchar(2000) DEFAULT NULL,
  `NEWS_TYPE` varchar(20) DEFAULT NULL,
  `NEWS_URL` varchar(200) DEFAULT NULL,
  `DELETED_FLAG` varchar(10) DEFAULT NULL,
  `DETAIL_ATTRIBUTE1` varchar(80) DEFAULT NULL,
  `DETAIL_ATTRIBUTE2` varchar(80) DEFAULT NULL,
  `DETAIL_ATTRIBUTE3` varchar(80) DEFAULT NULL,
  `DETAIL_ATTRIBUTE4` varchar(80) DEFAULT NULL,
  `DETAIL_ATTRIBUTE5` varchar(80) DEFAULT NULL,
  `DETAIL_ATTRIBUTE6` varchar(80) DEFAULT NULL,
  `PROCESS_STATUS` varchar(32) DEFAULT NULL,
  `MAKER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `MAKER_BY` varchar(100) DEFAULT NULL,
  `CHECKER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `CHECKER_BY` varchar(100) DEFAULT NULL,
  `CREATE_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `CREATE_BY` varchar(100) DEFAULT NULL,
  `MODIFY_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `MODIFY_BY` varchar(100) DEFAULT NULL,
  `AUTHORIZER_BY` varchar(50) DEFAULT NULL,
  `AUTHORIZER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  PRIMARY KEY (`NEWS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lxy_company_news
-- ----------------------------

-- ----------------------------
-- Table structure for `lxy_product`
-- ----------------------------
DROP TABLE IF EXISTS `lxy_product`;
CREATE TABLE `lxy_product` (
  `PRODUCT_ID` bigint(32) NOT NULL AUTO_INCREMENT,
  `VERSION` int(11) NOT NULL,
  `UUID` varchar(40) DEFAULT NULL,
  `PRODUCT_NAME` varchar(60) DEFAULT NULL,
  `PRODUCT_VALUE` varchar(80) DEFAULT NULL,
  `PRODUCT_DESC` varchar(2000) DEFAULT NULL,
  `PRODUCT_DETAIL_ID` bigint(32) DEFAULT NULL,
  `PRODUCT_TYPE_ID` bigint(32) DEFAULT NULL,
  `PRODUCT_FROM_ID` bigint(32) DEFAULT NULL,
  `PRODUCT_TO_ID` bigint(32) DEFAULT NULL,
  `PRODUCT_PRIORITY` varchar(10) DEFAULT NULL,
  `AMT` varchar(32) DEFAULT NULL,
  `DELETED_FLAG` varchar(10) DEFAULT NULL,
  `PRODUCT_ATTRIBUTE1` varchar(80) DEFAULT NULL,
  `PRODUCT_ATTRIBUTE2` varchar(80) DEFAULT NULL,
  `PRODUCT_ATTRIBUTE3` varchar(80) DEFAULT NULL,
  `PRODUCT_ATTRIBUTE4` varchar(80) DEFAULT NULL,
  `PRODUCT_ATTRIBUTE5` varchar(80) DEFAULT NULL,
  `PRODUCT_ATTRIBUTE6` varchar(80) DEFAULT NULL,
  `PROCESS_STATUS` varchar(32) DEFAULT NULL,
  `MAKER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `MAKER_BY` varchar(100) DEFAULT NULL,
  `CHECKER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `CHECKER_BY` varchar(100) DEFAULT NULL,
  `CREATE_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `CREATE_BY` varchar(100) DEFAULT NULL,
  `MODIFY_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `MODIFY_BY` varchar(100) DEFAULT NULL,
  `AUTHORIZER_BY` varchar(50) DEFAULT NULL,
  `AUTHORIZER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  PRIMARY KEY (`PRODUCT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lxy_product
-- ----------------------------

-- ----------------------------
-- Table structure for `lxy_product_color`
-- ----------------------------
DROP TABLE IF EXISTS `lxy_product_color`;
CREATE TABLE `lxy_product_color` (
  `COLOR_ID` bigint(32) NOT NULL AUTO_INCREMENT,
  `VERSION` int(11) NOT NULL,
  `UUID` varchar(40) DEFAULT NULL,
  `COLOR_NAME` varchar(60) DEFAULT NULL,
  `COLOR_VALUE` varchar(80) DEFAULT NULL,
  `COLOR_DESC` varchar(200) DEFAULT NULL,
  `COLOR_TYPE` varchar(20) DEFAULT NULL,
  `DELETED_FLAG` varchar(10) DEFAULT NULL,
  `DETAIL_ATTRIBUTE1` varchar(80) DEFAULT NULL,
  `DETAIL_ATTRIBUTE2` varchar(80) DEFAULT NULL,
  `DETAIL_ATTRIBUTE3` varchar(80) DEFAULT NULL,
  `DETAIL_ATTRIBUTE4` varchar(80) DEFAULT NULL,
  `DETAIL_ATTRIBUTE5` varchar(80) DEFAULT NULL,
  `DETAIL_ATTRIBUTE6` varchar(80) DEFAULT NULL,
  `PROCESS_STATUS` varchar(32) DEFAULT NULL,
  `MAKER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `MAKER_BY` varchar(100) DEFAULT NULL,
  `CHECKER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `CHECKER_BY` varchar(100) DEFAULT NULL,
  `CREATE_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `CREATE_BY` varchar(100) DEFAULT NULL,
  `MODIFY_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `MODIFY_BY` varchar(100) DEFAULT NULL,
  `AUTHORIZER_BY` varchar(50) DEFAULT NULL,
  `AUTHORIZER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  PRIMARY KEY (`COLOR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lxy_product_color
-- ----------------------------

-- ----------------------------
-- Table structure for `lxy_product_detail`
-- ----------------------------
DROP TABLE IF EXISTS `lxy_product_detail`;
CREATE TABLE `lxy_product_detail` (
  `DETAIL_ID` bigint(32) NOT NULL AUTO_INCREMENT,
  `VERSION` int(11) NOT NULL,
  `UUID` varchar(40) DEFAULT NULL,
  `DETAIL_NAME` varchar(60) DEFAULT NULL,
  `DETAIL_VALUE` varchar(80) DEFAULT NULL,
  `DETAIL_DESC` varchar(2000) DEFAULT NULL,
  `PRODUCT_SIZE` varchar(20) DEFAULT NULL,
  `PRODUCT_COLOR_ID` bigint(32) DEFAULT NULL,
  `PRODUCT_COLOR_NAME` varchar(60) DEFAULT NULL,
  `PRODUCT_COLOR_VALUE` varchar(80) DEFAULT NULL,
  `AMT` varchar(32) DEFAULT NULL,
  `DELETED_FLAG` varchar(10) DEFAULT NULL,
  `PRODUCT_IMAGE_PATH` varchar(150) DEFAULT NULL,
  `DETAIL_ATTRIBUTE1` varchar(80) DEFAULT NULL,
  `DETAIL_ATTRIBUTE2` varchar(80) DEFAULT NULL,
  `DETAIL_ATTRIBUTE3` varchar(80) DEFAULT NULL,
  `DETAIL_ATTRIBUTE4` varchar(80) DEFAULT NULL,
  `DETAIL_ATTRIBUTE5` varchar(80) DEFAULT NULL,
  `DETAIL_ATTRIBUTE6` varchar(80) DEFAULT NULL,
  `PROCESS_STATUS` varchar(32) DEFAULT NULL,
  `MAKER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `MAKER_BY` varchar(100) DEFAULT NULL,
  `CHECKER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `CHECKER_BY` varchar(100) DEFAULT NULL,
  `CREATE_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `CREATE_BY` varchar(100) DEFAULT NULL,
  `MODIFY_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `MODIFY_BY` varchar(100) DEFAULT NULL,
  `AUTHORIZER_BY` varchar(50) DEFAULT NULL,
  `AUTHORIZER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  PRIMARY KEY (`DETAIL_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lxy_product_detail
-- ----------------------------
INSERT INTO `lxy_product_detail` VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1990-01-01 00:00:00', '1', '2014-12-11 13:12:48', '1', '1990-01-01 00:00:00', '1', '1990-01-01 00:00:00', '1', '1', '1990-01-01 00:00:00');

-- ----------------------------
-- Table structure for `lxy_product_type`
-- ----------------------------
DROP TABLE IF EXISTS `lxy_product_type`;
CREATE TABLE `lxy_product_type` (
  `TYPE_ID` bigint(32) NOT NULL AUTO_INCREMENT,
  `VERSION` int(11) NOT NULL,
  `UUID` varchar(40) DEFAULT NULL,
  `TYPE_DETAIL_ID` bigint(32) DEFAULT NULL,
  `PARENT_TYPE_ID` bigint(32) DEFAULT NULL,
  `TYPE_NAME` varchar(60) DEFAULT NULL,
  `TYPE_VALUE` varchar(80) DEFAULT NULL,
  `TYPE_DESC` varchar(2000) DEFAULT NULL,
  `DELETED_FLAG` varchar(10) DEFAULT NULL,
  `TYPE_FOLDER_PATH` varchar(150) DEFAULT NULL,
  `TYPE_ATTRIBUTE1` varchar(80) DEFAULT NULL,
  `TYPE_ATTRIBUTE2` varchar(80) DEFAULT NULL,
  `TYPE_ATTRIBUTE3` varchar(80) DEFAULT NULL,
  `TYPE_ATTRIBUTE4` varchar(80) DEFAULT NULL,
  `TYPE_ATTRIBUTE5` varchar(80) DEFAULT NULL,
  `TYPE_ATTRIBUTE6` varchar(80) DEFAULT NULL,
  `PROCESS_STATUS` varchar(32) DEFAULT NULL,
  `MAKER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `MAKER_BY` varchar(100) DEFAULT NULL,
  `CHECKER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `CHECKER_BY` varchar(100) DEFAULT NULL,
  `CREATE_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `CREATE_BY` varchar(100) DEFAULT NULL,
  `MODIFY_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `MODIFY_BY` varchar(100) DEFAULT NULL,
  `AUTHORIZER_BY` varchar(50) DEFAULT NULL,
  `AUTHORIZER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  PRIMARY KEY (`TYPE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lxy_product_type
-- ----------------------------
INSERT INTO `lxy_product_type` VALUES ('1', '1', '1', '1', null, '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1990-01-01 00:00:00', null, '1990-01-01 00:00:00', null, '1990-01-01 00:00:00', null, '1990-01-01 00:00:00', null, null, '1990-01-01 00:00:00');
INSERT INTO `lxy_product_type` VALUES ('2', '2', '2', '2', null, '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '1990-01-01 00:00:00', null, '1990-01-01 00:00:00', null, '1990-01-01 00:00:00', null, '1990-01-01 00:00:00', null, null, '1990-01-01 00:00:00');

-- ----------------------------
-- Table structure for `lxy_product_type_detail`
-- ----------------------------
DROP TABLE IF EXISTS `lxy_product_type_detail`;
CREATE TABLE `lxy_product_type_detail` (
  `TYPE_DETAIL_ID` bigint(32) NOT NULL AUTO_INCREMENT,
  `VERSION` int(11) NOT NULL,
  `UUID` varchar(40) DEFAULT NULL,
  `TYPE_DETAIL_NAME` varchar(60) DEFAULT NULL,
  `TYPE_DETAIL_VALUE` varchar(80) DEFAULT NULL,
  `TYPE_DETAIL_DESC` varchar(2000) DEFAULT NULL,
  `DELETED_FLAG` varchar(10) DEFAULT NULL,
  `TYPE_DETAIL_FOLDER_PATH` varchar(150) DEFAULT NULL,
  `TYPE_DETAIL_ATTRIBUTE1` varchar(80) DEFAULT NULL,
  `TYPE_DETAIL_ATTRIBUTE2` varchar(80) DEFAULT NULL,
  `TYPE_DETAIL_ATTRIBUTE3` varchar(80) DEFAULT NULL,
  `TYPE_DETAIL_ATTRIBUTE4` varchar(80) DEFAULT NULL,
  `TYPE_DETAIL_ATTRIBUTE5` varchar(80) DEFAULT NULL,
  `TYPE_DETAIL_ATTRIBUTE6` varchar(80) DEFAULT NULL,
  `PROCESS_STATUS` varchar(32) DEFAULT NULL,
  `MAKER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `MAKER_BY` varchar(100) DEFAULT NULL,
  `CHECKER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `CHECKER_BY` varchar(100) DEFAULT NULL,
  `CREATE_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `CREATE_BY` varchar(100) DEFAULT NULL,
  `MODIFY_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `MODIFY_BY` varchar(100) DEFAULT NULL,
  `AUTHORIZER_BY` varchar(50) DEFAULT NULL,
  `AUTHORIZER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  PRIMARY KEY (`TYPE_DETAIL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lxy_product_type_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `lxy_role`
-- ----------------------------
DROP TABLE IF EXISTS `lxy_role`;
CREATE TABLE `lxy_role` (
  `ROLE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `VERSION` int(11) NOT NULL,
  `ROLE_NAME` varchar(40) DEFAULT NULL,
  `LONG_DESC` varchar(60) DEFAULT NULL,
  `PROCESS_STATUS` varchar(20) DEFAULT NULL,
  `OLD_ID` bigint(20) DEFAULT NULL,
  `CREATE_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `CREATE_BY` varchar(100) DEFAULT NULL,
  `MODIFY_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `MODIFY_BY` varchar(100) DEFAULT NULL,
  `MAKER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `MAKER_BY` varchar(100) DEFAULT NULL,
  `CHECKER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `CHECKER_BY` varchar(100) DEFAULT NULL,
  `AUTHORIZER_BY` varchar(50) DEFAULT NULL,
  `AUTHORIZER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lxy_role
-- ----------------------------

-- ----------------------------
-- Table structure for `lxy_role_privilege`
-- ----------------------------
DROP TABLE IF EXISTS `lxy_role_privilege`;
CREATE TABLE `lxy_role_privilege` (
  `ROLE_ID` bigint(20) NOT NULL,
  `PRIVILEGE_VALUE` varchar(30) NOT NULL,
  PRIMARY KEY (`ROLE_ID`,`PRIVILEGE_VALUE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lxy_role_privilege
-- ----------------------------

-- ----------------------------
-- Table structure for `lxy_system_parameter`
-- ----------------------------
DROP TABLE IF EXISTS `lxy_system_parameter`;
CREATE TABLE `lxy_system_parameter` (
  `PARA_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `VERSION` int(11) NOT NULL,
  `PARA_NAME` varchar(60) DEFAULT NULL,
  `PARA_VALUE` varchar(2000) DEFAULT NULL,
  `PARA_DESC` varchar(80) DEFAULT NULL,
  `PROCESS_STATUS` varchar(20) DEFAULT NULL,
  `MAKER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `MAKER_BY` varchar(100) DEFAULT NULL,
  `CHECKER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `CHECKER_BY` varchar(100) DEFAULT NULL,
  `CREATE_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `CREATE_BY` varchar(100) DEFAULT NULL,
  `MODIFY_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `MODIFY_BY` varchar(100) DEFAULT NULL,
  `AUTHORIZER_BY` varchar(50) DEFAULT NULL,
  `AUTHORIZER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `SYSTEM_PARA` smallint(6) NOT NULL DEFAULT '0',
  PRIMARY KEY (`PARA_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lxy_system_parameter
-- ----------------------------

-- ----------------------------
-- Table structure for `lxy_user`
-- ----------------------------
DROP TABLE IF EXISTS `lxy_user`;
CREATE TABLE `lxy_user` (
  `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `OLD_ID` bigint(20) DEFAULT NULL,
  `VERSION` int(11) NOT NULL,
  `OPER_ID` varchar(10) DEFAULT NULL,
  `USER_NAME` varchar(40) DEFAULT NULL,
  `REAL_NAME` varchar(40) DEFAULT NULL,
  `GENDER` varchar(1) DEFAULT NULL,
  `PASSWORD` varchar(128) DEFAULT NULL,
  `LOGIN_FLAG` varchar(1) DEFAULT NULL,
  `LOGIN_IP_ADDRESS` varchar(20) DEFAULT NULL,
  `PROCESS_STATUS` varchar(20) DEFAULT NULL,
  `LAST_LOGIN_TIME` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `LAN_ID` varchar(100) DEFAULT NULL,
  `ENGLISH_NAME` varchar(250) DEFAULT NULL,
  `EXPIRE_DATE` date DEFAULT NULL,
  `QUESTION` varchar(200) DEFAULT NULL,
  `ANSWER` varchar(200) DEFAULT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  `CHECK_TYPES` varchar(250) DEFAULT NULL,
  `MAKER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `MAKER_BY` varchar(100) DEFAULT NULL,
  `CHECKER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `CHECKER_BY` varchar(100) DEFAULT NULL,
  `CREATE_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `CREATE_BY` varchar(100) DEFAULT NULL,
  `AUTHORIZER_BY` varchar(50) DEFAULT NULL,
  `AUTHORIZER_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `MODIFY_ON` timestamp NOT NULL DEFAULT '1990-01-01 00:00:00',
  `MODIFY_BY` varchar(100) DEFAULT NULL,
  `USER_STATUS` varchar(6) DEFAULT NULL,
  `LOGIN_FAILURE_TIMES` int(11) DEFAULT NULL,
  `BACK_UP_PASSWORD` varchar(128) DEFAULT NULL,
  `DEPT_ID` int(11) DEFAULT NULL,
  `BRANCH_ID` int(11) DEFAULT NULL,
  `ROLE_ID` int(11) DEFAULT NULL,
  `LEFT_PASSWORD` varchar(64) DEFAULT NULL,
  `RIGHT_PASSWORD` varchar(64) DEFAULT NULL,
  `ADMIN_FLAG` varchar(1) DEFAULT NULL,
  `LOCALE` varchar(20) DEFAULT NULL,
  `USER_IP` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lxy_user
-- ----------------------------
INSERT INTO `lxy_user` VALUES ('1', null, '77', 'qweqwe', 'qweqwe', 'qweqwe', null, 'qweqwe', '0', null, 'ZA', '2014-09-15 19:12:27', 'admin1', 'ADMIN1', null, null, null, null, 'ON,', '2013-07-16 14:54:41', 'lch1951', '1990-01-01 00:00:00', null, '1990-01-01 00:00:00', null, null, '1990-01-01 00:00:00', '2013-07-16 14:54:41', 'lch1951', 'NORMAL', '0', null, null, '1', null, null, null, null, null, null);
INSERT INTO `lxy_user` VALUES ('2', null, '58', 'ADMIN2', 'ADMIN2', 'ADMIN2', null, null, '0', '', 'LOCKED', '2013-08-15 15:47:09', 'admin2', 'ADMIN2', null, null, null, null, '', '2013-07-16 14:54:49', 'lch1951', '1990-01-01 00:00:00', null, '1990-01-01 00:00:00', null, null, '1990-01-01 00:00:00', '2013-07-16 14:54:49', 'lch1951', 'NORMAL', '0', null, null, '1', null, null, null, null, null, null);
INSERT INTO `lxy_user` VALUES ('3', null, '37', 'ADMIN3', 'ADMIN3', 'ADMIN3', null, null, '0', '', 'LOCKED', '2013-08-15 17:03:34', 'admin3', 'ADMIN3', null, null, null, null, '', '2013-07-16 14:54:53', 'lch1951', '1990-01-01 00:00:00', null, '1990-01-01 00:00:00', null, null, '1990-01-01 00:00:00', '2013-07-16 14:54:53', 'lch1951', 'NORMAL', '0', null, null, '1', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `lxy_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `lxy_user_role`;
CREATE TABLE `lxy_user_role` (
  `ROLE_ID` bigint(20) NOT NULL,
  `USER_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`USER_ID`,`ROLE_ID`),
  KEY `FK143BF46AFB006BDF` (`ROLE_ID`),
  CONSTRAINT `lxy_USER_ROLE_IBFK_1` FOREIGN KEY (`USER_ID`) REFERENCES `lxy_user` (`USER_ID`),
  CONSTRAINT `lxy_USER_ROLE_IBFK_2` FOREIGN KEY (`ROLE_ID`) REFERENCES `lxy_role` (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lxy_user_role
-- ----------------------------
