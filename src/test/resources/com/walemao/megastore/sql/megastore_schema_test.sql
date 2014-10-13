/*
Navicat MySQL Data Transfer

Source Server         : tycai
Source Server Version : 50536
Source Host           : 192.168.1.123:3306
Source Database       : megastore

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2014-10-11 16:54:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for d_city
-- ----------------------------
DROP TABLE IF EXISTS `d_city`;
CREATE TABLE `d_city` (
  `cityid` smallint(6) NOT NULL AUTO_INCREMENT COMMENT '城市ID',
  `cityname` varchar(50) DEFAULT NULL COMMENT '城市名称',
  `zipcode` varchar(6) DEFAULT NULL COMMENT '邮政编码',
  `provinceid` tinyint(4) DEFAULT NULL COMMENT '省份ID',
  PRIMARY KEY (`cityid`),
  KEY `idx_city_1` (`provinceid`)
) ENGINE=MyISAM AUTO_INCREMENT=346 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for d_comments
-- ----------------------------
DROP TABLE IF EXISTS `d_comments`;
CREATE TABLE `d_comments` (
  `id` tinyint(1) NOT NULL AUTO_INCREMENT COMMENT '值',
  `name` char(10) DEFAULT NULL COMMENT '评价名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for d_district
-- ----------------------------
DROP TABLE IF EXISTS `d_district`;
CREATE TABLE `d_district` (
  `districtid` smallint(6) NOT NULL AUTO_INCREMENT COMMENT '地区ID',
  `districtname` varchar(50) DEFAULT NULL COMMENT '地区名称',
  `cityid` smallint(6) DEFAULT NULL COMMENT '城市ID',
  PRIMARY KEY (`districtid`),
  KEY `idx_district_1` (`cityid`)
) ENGINE=MyISAM AUTO_INCREMENT=2863 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for d_province
-- ----------------------------
DROP TABLE IF EXISTS `d_province`;
CREATE TABLE `d_province` (
  `provinceid` tinyint(4) NOT NULL AUTO_INCREMENT COMMENT '省份ID',
  `provincename` varchar(50) DEFAULT NULL COMMENT '省份名称',
  PRIMARY KEY (`provinceid`)
) ENGINE=MyISAM AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for d_user
-- ----------------------------
DROP TABLE IF EXISTS `d_user`;
CREATE TABLE `d_user` (
  `ud_id` int(11) NOT NULL COMMENT '用户维表ID',
  `ud_key` int(11) DEFAULT NULL COMMENT 'key值',
  `ud_value` varchar(255) DEFAULT NULL COMMENT '具体值',
  `ud_type` tinyint(4) DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`ud_id`),
  KEY `idx_d_user_1` (`ud_type`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_address
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address` (
  `a_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '地址ID',
  `a_username` varchar(50) NOT NULL COMMENT '用户名',
  `a_consignee` char(50) DEFAULT NULL COMMENT '联系人',
  `a_province` tinyint(4) DEFAULT NULL COMMENT '省份',
  `a_city` smallint(6) DEFAULT NULL COMMENT '城市',
  `a_district` smallint(6) DEFAULT NULL COMMENT '地区',
  `a_address` varchar(255) DEFAULT NULL COMMENT '地址',
  `a_zip_code` char(6) DEFAULT NULL COMMENT '邮政编码',
  `a_mobilephone` char(11) DEFAULT NULL COMMENT '手机号码',
  `a_phone` char(20) DEFAULT NULL COMMENT '座机',
  `a_isdefault` tinyint(1) DEFAULT NULL COMMENT '是否默认',
  `a_createtime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_comments
-- ----------------------------
DROP TABLE IF EXISTS `t_comments`;
CREATE TABLE `t_comments` (
  `c_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论表ID',
  `c_username` varchar(50) NOT NULL COMMENT '用户名',
  `c_content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `c_type` tinyint(1) DEFAULT NULL COMMENT '评论类别（好评）详见d_comments',
  `c_productid` bigint(20) NOT NULL COMMENT '商品ID',
  `c_orderdetailid` bigint(20) NOT NULL COMMENT '订单详情ID，可以获取到购买物品以及购买时间',
  `c_createtime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `deletemark` timestamp NULL DEFAULT NULL COMMENT '删除标志',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_complaints
-- ----------------------------
DROP TABLE IF EXISTS `t_complaints`;
CREATE TABLE `t_complaints` (
  `c_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '投诉咨询表ID',
  `c_username` varchar(50) NOT NULL COMMENT '用户名',
  `c_subject` tinyint(2) DEFAULT NULL COMMENT '主题选择',
  `c_name` char(20) DEFAULT NULL COMMENT '姓名',
  `c_province` tinyint(4) DEFAULT NULL COMMENT '省份',
  `c_city` smallint(6) DEFAULT NULL COMMENT '城市',
  `c_contact` char(11) DEFAULT NULL COMMENT '联系电话',
  `c_email` varchar(255) DEFAULT NULL COMMENT '电子邮箱',
  `c_orderid` bigint(20) DEFAULT NULL COMMENT '关联订单号',
  `c_content` varchar(255) DEFAULT NULL COMMENT '内容',
  `c_createtime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_log
-- ----------------------------
DROP TABLE IF EXISTS `t_log`;
CREATE TABLE `t_log` (
  `l_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `l_content` varchar(255) DEFAULT NULL COMMENT '日志内容',
  PRIMARY KEY (`l_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `o_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `o_username` varchar(50) NOT NULL COMMENT '用户名',
  `o_createtime` timestamp NULL DEFAULT NULL COMMENT '下单时间',
  `o_addressinfo` longtext NOT NULL COMMENT '地址详细信息',
  `o_confirm` varchar(50) DEFAULT NULL COMMENT '确认人名称',
  `o_state` tinyint(1) DEFAULT NULL COMMENT '订单状态',
  `o_fee` decimal(12,0) DEFAULT NULL COMMENT '订单金额',
  `o_freight` decimal(12,0) DEFAULT NULL COMMENT '运费',
  `o_remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `o_paytype` tinyint(1) DEFAULT NULL COMMENT '支付方式',
  `deletemark` timestamp NULL DEFAULT NULL COMMENT '删除标志',
  PRIMARY KEY (`o_id`),
  KEY `idx_t_order_1` (`o_state`) USING BTREE COMMENT '订单状态索引',
  KEY `idx_t_order_2` (`o_paytype`) USING BTREE COMMENT '支付索引',
  KEY `idx_t_order_3` (`deletemark`) USING BTREE COMMENT '删除标志索引',
  KEY `idx_t_order_4` (`o_username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_order_detail`;
CREATE TABLE `t_order_detail` (
  `od_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单记录id',
  `od_productid` bigint(20) NOT NULL COMMENT '商品id',
  `od_typeid` bigint(20) DEFAULT NULL COMMENT '商品型号ID',
  `od_orderid` bigint(20) NOT NULL COMMENT '订单表id',
  `od_amount` int(11) DEFAULT '0' COMMENT '订单数量',
  `od_reamark` varchar(255) DEFAULT NULL COMMENT '备注',
  `od_createtime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `deletemark` timestamp NULL DEFAULT NULL COMMENT '删除标志',
  PRIMARY KEY (`od_id`),
  UNIQUE KEY `idx_t_order_detail_2` (`od_productid`,`od_typeid`),
  KEY `idx_t_order_detail_1` (`od_productid`,`od_orderid`,`od_typeid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_product_base
-- ----------------------------
DROP TABLE IF EXISTS `t_product_base`;
CREATE TABLE `t_product_base` (
  `p_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `p_number` varchar(255) DEFAULT NULL COMMENT '商品货号',
  `p_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `p_recommend` tinyint(1) DEFAULT '0' COMMENT '是否推荐，1表示推荐，0表示未推荐',
  `p_thumbnail` longtext COMMENT '商品缩略图',
  `p_classify` int(11) DEFAULT '0' COMMENT '商品分类,关联t_product_classify',
  `p_origin` varchar(50) DEFAULT NULL COMMENT '商品产地',
  `p_materials` varchar(50) DEFAULT NULL COMMENT '商品材质',
  `p_desc` varchar(255) DEFAULT NULL COMMENT '商品描述',
  `p_discount` double DEFAULT NULL COMMENT '商品折扣',
  `p_remark` varchar(255) DEFAULT NULL COMMENT '商品备注',
  `p_createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '商品上架时间',
  `deletemark` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`p_id`),
  UNIQUE KEY `idx_t_product_base_1` (`p_number`),
  KEY `idx_t_product_base_2` (`p_name`) USING BTREE,
  KEY `idx_t_product_base_4` (`deletemark`) USING BTREE,
  KEY `idx_t_product_base_3` (`p_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_product_classify
-- ----------------------------
DROP TABLE IF EXISTS `t_product_classify`;
CREATE TABLE `t_product_classify` (
  `pc_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品分类ID',
  `pc_name` varchar(50) DEFAULT NULL COMMENT '分类名称',
  PRIMARY KEY (`pc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_product_favorites
-- ----------------------------
DROP TABLE IF EXISTS `t_product_favorites`;
CREATE TABLE `t_product_favorites` (
  `pf_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '收藏表ID',
  `pf_username` varchar(50) NOT NULL COMMENT '用户名',
  `pf_productid` char(36) NOT NULL COMMENT '商品ID',
  `pf_typeid` bigint(20) DEFAULT NULL COMMENT '商品型号ID',
  `pf_creattime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `deletemark` timestamp NULL DEFAULT NULL COMMENT '删除标志',
  PRIMARY KEY (`pf_id`),
  UNIQUE KEY `idx_t_product_favorites_1` (`pf_username`,`pf_productid`,`pf_typeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_product_images
-- ----------------------------
DROP TABLE IF EXISTS `t_product_images`;
CREATE TABLE `t_product_images` (
  `pi_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pi_src` longtext COMMENT '图片地址',
  `pi_md5` char(16) DEFAULT NULL COMMENT '图片MD5',
  `pi_sort` int(11) DEFAULT '0' COMMENT '排序',
  `pi_productid` bigint(20) DEFAULT NULL COMMENT '商品ID',
  PRIMARY KEY (`pi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_product_info
-- ----------------------------
DROP TABLE IF EXISTS `t_product_info`;
CREATE TABLE `t_product_info` (
  `pd_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品编号',
  `pd_productid` bigint(20) NOT NULL DEFAULT '0' COMMENT '商品ID，关联t_product',
  `pd_name` varchar(255) NOT NULL COMMENT '商品型号名称',
  `pd_thumbnail` longtext COMMENT '缩略图',
  `pd_thummd5` char(16) DEFAULT NULL COMMENT '图片MD5',
  `pd_weight` varchar(20) DEFAULT NULL COMMENT '商品毛重',
  `pd_price` decimal(10,0) DEFAULT '0' COMMENT '商品价格',
  `pd_amount` int(11) DEFAULT '0' COMMENT '商品虚拟库存',
  `pd_createtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`pd_id`),
  UNIQUE KEY `idx_t_product_info_2` (`pd_thummd5`) USING BTREE,
  KEY `idx_t_product_info_1` (`pd_productid`) USING BTREE,
  CONSTRAINT `fk_product_info_1` FOREIGN KEY (`pd_productid`) REFERENCES `t_product_base` (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_proposal
-- ----------------------------
DROP TABLE IF EXISTS `t_proposal`;
CREATE TABLE `t_proposal` (
  `p_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '建议留言表ID',
  `p_username` varchar(50) NOT NULL COMMENT '用户名',
  `p_subject` tinyint(2) DEFAULT '0' COMMENT '建议留言类型',
  `p_name` char(20) DEFAULT NULL COMMENT '姓名',
  `p_province` tinyint(4) DEFAULT '0' COMMENT '省份',
  `p_city` smallint(6) DEFAULT '0' COMMENT '城市',
  `p_contact` char(11) DEFAULT NULL COMMENT '联系方式',
  `p_email` varchar(255) DEFAULT NULL COMMENT '电子邮箱',
  `p_content` varchar(255) DEFAULT NULL COMMENT '内容',
  `p_createtime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_shopping_cart`;
CREATE TABLE `t_shopping_cart` (
  `sc_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '购物车ID',
  `sc_username` varchar(50) NOT NULL COMMENT '用户名',
  `sc_productid` char(36) NOT NULL COMMENT '商品ID',
  `sc_typeid` bigint(20) NOT NULL COMMENT '商品型号ID',
  `sc_amount` int(11) DEFAULT NULL COMMENT '数量',
  `sc_createtime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `deletemark` timestamp NULL DEFAULT NULL COMMENT '删除标志',
  PRIMARY KEY (`sc_id`),
  UNIQUE KEY `idx_t_shopping_cart_1` (`sc_username`,`sc_productid`,`sc_typeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `u_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `u_username` varchar(50) NOT NULL COMMENT '用户名',
  `u_password` varchar(255) DEFAULT NULL COMMENT '密码',
  `u_salt` char(40) DEFAULT NULL COMMENT '盐',
  `u_mobilephone` char(11) DEFAULT NULL COMMENT '手机',
  `u_email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `u_createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `u_remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `u_type` tinyint(1) DEFAULT '0' COMMENT '用户类型0是普通用户，1是管理员',
  `u_level` tinyint(1) DEFAULT '0' COMMENT '会员等级，默认0',
  `u_enabled` tinyint(1) DEFAULT '1' COMMENT '是否启用，0是未启用，1是启用',
  `deletemark` timestamp NULL DEFAULT NULL COMMENT '删除标志',
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `idx_t_user_4` (`u_username`) USING BTREE,
  KEY `idx_t_user_1` (`u_type`) USING BTREE,
  KEY `idx_t_user_2` (`u_level`),
  KEY `idx_t_user_3` (`u_enabled`)
) ENGINE=InnoDB AUTO_INCREMENT=996 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_user_authority`;
CREATE TABLE `t_user_authority` (
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `authority` varchar(255) NOT NULL COMMENT '权限',
  UNIQUE KEY `idx_auth_username` (`username`,`authority`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user_base
-- ----------------------------
DROP TABLE IF EXISTS `t_user_base`;
CREATE TABLE `t_user_base` (
  `u_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户基本表id',
  `u_username` varchar(50) NOT NULL COMMENT '用户名，关联用户表',
  `u_head_portrait` longtext COMMENT '头像',
  `u_nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `u_realname` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `u_sex` tinyint(1) DEFAULT NULL COMMENT '性别',
  `u_birth` date DEFAULT NULL COMMENT '生日',
  `u_isval_email` tinyint(1) DEFAULT NULL COMMENT '是否严重邮箱',
  `u_provices` tinyint(4) DEFAULT NULL COMMENT '省份',
  `u_cities` smallint(6) DEFAULT NULL COMMENT '城市',
  `u_districts` smallint(6) DEFAULT NULL COMMENT '地区',
  `u_address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `u_zipcode` char(6) DEFAULT NULL COMMENT '邮政编码',
  `u_isval_mobilephone` tinyint(1) DEFAULT NULL COMMENT '是否验证手机',
  `u_telphone` varchar(20) DEFAULT NULL COMMENT '座机',
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `idx_t_user_base_1` (`u_username`) USING BTREE COMMENT '用户名唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_user_detail`;
CREATE TABLE `t_user_detail` (
  `u_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户详细资料ID',
  `u_username` varchar(50) NOT NULL COMMENT '用户名，关联用户表',
  `u_matrial_status` tinyint(2) DEFAULT '0' COMMENT '婚姻状况',
  `u_education` tinyint(2) DEFAULT '0' COMMENT '教育程度',
  `u_professional` tinyint(2) DEFAULT '0' COMMENT '从事职业',
  `u_industry` tinyint(2) DEFAULT '0' COMMENT '工作所属行业',
  `u_income` tinyint(2) DEFAULT '0' COMMENT '月均收入',
  `u_interests` varchar(255) DEFAULT NULL COMMENT '兴趣爱好',
  `u_selfdesc` varchar(255) DEFAULT NULL COMMENT '自我介绍',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user_login
-- ----------------------------
DROP TABLE IF EXISTS `t_user_login`;
CREATE TABLE `t_user_login` (
  `ul_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户登陆表ID',
  `ul_username` varchar(50) NOT NULL COMMENT '用户名',
  `ul_lastlogin` timestamp NULL DEFAULT NULL COMMENT '登录时间',
  PRIMARY KEY (`ul_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user_pay
-- ----------------------------
DROP TABLE IF EXISTS `t_user_pay`;
CREATE TABLE `t_user_pay` (
  `u_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户支付表ID',
  `u_username` varchar(50) NOT NULL COMMENT '用户名',
  `u_pay_passwd` varchar(255) DEFAULT NULL COMMENT '支付密码',
  `u_checktype` tinyint(4) DEFAULT NULL COMMENT '验证方式,0是手机，1是邮箱',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_warehouse_product
-- ----------------------------
DROP TABLE IF EXISTS `t_warehouse_product`;
CREATE TABLE `t_warehouse_product` (
  `wp_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品进出库ID',
  `wp_productid` char(36) NOT NULL COMMENT '商品ID',
  `wp_typeid` bigint(20) NOT NULL COMMENT '商品型号ID',
  `wp_amount` bigint(20) DEFAULT NULL COMMENT '数量',
  `wp_createtime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `deletemark` timestamp NULL DEFAULT NULL COMMENT '删除标志',
  PRIMARY KEY (`wp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_warehouse_product_rejected
-- ----------------------------
DROP TABLE IF EXISTS `t_warehouse_product_rejected`;
CREATE TABLE `t_warehouse_product_rejected` (
  `pr_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '退货表编号',
  `pr_productid` bigint(20) NOT NULL COMMENT '商品ID',
  `pr_typeid` bigint(20) NOT NULL COMMENT '商品型号ID',
  `pr_createtime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `pr_remark` varchar(255) DEFAULT NULL COMMENT '退货理由',
  `deletemark` timestamp NULL DEFAULT NULL COMMENT '删除标志',
  PRIMARY KEY (`pr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
