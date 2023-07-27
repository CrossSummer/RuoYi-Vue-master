/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 8.0.11 : Database - ry-vue
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ry-vue` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ry-vue`;

/*Table structure for table `sys_dict_data` */

DROP TABLE IF EXISTS `sys_dict_data`;

CREATE TABLE `sys_dict_data` (
  `dict_code` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) DEFAULT '0' COMMENT '字典排序',
  `dict_label` varchar(100) DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8 COMMENT='字典数据表';

/*Data for the table `sys_dict_data` */

insert  into `sys_dict_data`(`dict_code`,`dict_sort`,`dict_label`,`dict_value`,`dict_type`,`css_class`,`list_class`,`is_default`,`status`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values 
(1,1,'男','0','sys_user_sex','','','Y','0','admin','2023-06-17 13:18:47','',NULL,'性别男'),
(2,2,'女','1','sys_user_sex','','','N','0','admin','2023-06-17 13:18:47','',NULL,'性别女'),
(3,3,'未知','2','sys_user_sex','','','N','0','admin','2023-06-17 13:18:47','',NULL,'性别未知'),
(4,1,'显示','0','sys_show_hide','','primary','Y','0','admin','2023-06-17 13:18:47','',NULL,'显示菜单'),
(5,2,'隐藏','1','sys_show_hide','','danger','N','0','admin','2023-06-17 13:18:47','',NULL,'隐藏菜单'),
(6,1,'正常','0','sys_normal_disable','','primary','Y','0','admin','2023-06-17 13:18:47','',NULL,'正常状态'),
(7,2,'停用','1','sys_normal_disable','','danger','N','0','admin','2023-06-17 13:18:47','',NULL,'停用状态'),
(8,1,'正常','0','sys_job_status','','primary','Y','0','admin','2023-06-17 13:18:47','',NULL,'正常状态'),
(9,2,'暂停','1','sys_job_status','','danger','N','0','admin','2023-06-17 13:18:47','',NULL,'停用状态'),
(10,1,'默认','DEFAULT','sys_job_group','','','Y','0','admin','2023-06-17 13:18:47','',NULL,'默认分组'),
(11,2,'系统','SYSTEM','sys_job_group','','','N','0','admin','2023-06-17 13:18:47','',NULL,'系统分组'),
(12,1,'是','Y','sys_yes_no','','primary','Y','0','admin','2023-06-17 13:18:47','',NULL,'系统默认是'),
(13,2,'否','N','sys_yes_no','','danger','N','0','admin','2023-06-17 13:18:47','',NULL,'系统默认否'),
(14,1,'通知','1','sys_notice_type','','warning','Y','0','admin','2023-06-17 13:18:47','',NULL,'通知'),
(15,2,'公告','2','sys_notice_type','','success','N','0','admin','2023-06-17 13:18:47','',NULL,'公告'),
(16,1,'正常','0','sys_notice_status','','primary','Y','0','admin','2023-06-17 13:18:47','',NULL,'正常状态'),
(17,2,'关闭','1','sys_notice_status','','danger','N','0','admin','2023-06-17 13:18:47','',NULL,'关闭状态'),
(18,99,'其他','0','sys_oper_type','','info','N','0','admin','2023-06-17 13:18:47','',NULL,'其他操作'),
(19,1,'新增','1','sys_oper_type','','info','N','0','admin','2023-06-17 13:18:47','',NULL,'新增操作'),
(20,2,'修改','2','sys_oper_type','','info','N','0','admin','2023-06-17 13:18:47','',NULL,'修改操作'),
(21,3,'删除','3','sys_oper_type','','danger','N','0','admin','2023-06-17 13:18:47','',NULL,'删除操作'),
(22,4,'授权','4','sys_oper_type','','primary','N','0','admin','2023-06-17 13:18:47','',NULL,'授权操作'),
(23,5,'导出','5','sys_oper_type','','warning','N','0','admin','2023-06-17 13:18:47','',NULL,'导出操作'),
(24,6,'导入','6','sys_oper_type','','warning','N','0','admin','2023-06-17 13:18:47','',NULL,'导入操作'),
(25,7,'强退','7','sys_oper_type','','danger','N','0','admin','2023-06-17 13:18:47','',NULL,'强退操作'),
(26,8,'生成代码','8','sys_oper_type','','warning','N','0','admin','2023-06-17 13:18:47','',NULL,'生成操作'),
(27,9,'清空数据','9','sys_oper_type','','danger','N','0','admin','2023-06-17 13:18:47','',NULL,'清空操作'),
(28,1,'成功','0','sys_common_status','','primary','N','0','admin','2023-06-17 13:18:47','',NULL,'正常状态'),
(29,2,'失败','1','sys_common_status','','danger','N','0','admin','2023-06-17 13:18:47','',NULL,'停用状态'),
(100,1,'Ordinary Passport','1','yq_passport_type',NULL,'info','N','0','admin','2023-07-20 21:00:47','',NULL,'普通护照'),
(101,1,'团队','1','yq_plan_type',NULL,'default','N','0','admin','2023-07-23 15:58:58','',NULL,NULL),
(102,2,'个签','2','yq_plan_type',NULL,'default','N','0','admin','2023-07-23 15:59:19','',NULL,NULL),
(103,3,'其他','3','yq_plan_type',NULL,'default','N','0','admin','2023-07-23 15:59:32','admin','2023-07-23 17:02:12',NULL);

/*Table structure for table `sys_dict_type` */

DROP TABLE IF EXISTS `sys_dict_type`;

CREATE TABLE `sys_dict_type` (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`),
  UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8 COMMENT='字典类型表';

/*Data for the table `sys_dict_type` */

insert  into `sys_dict_type`(`dict_id`,`dict_name`,`dict_type`,`status`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values 
(1,'用户性别','sys_user_sex','0','admin','2023-06-17 13:18:47','',NULL,'用户性别列表'),
(2,'菜单状态','sys_show_hide','0','admin','2023-06-17 13:18:47','',NULL,'菜单状态列表'),
(3,'系统开关','sys_normal_disable','0','admin','2023-06-17 13:18:47','',NULL,'系统开关列表'),
(4,'任务状态','sys_job_status','0','admin','2023-06-17 13:18:47','',NULL,'任务状态列表'),
(5,'任务分组','sys_job_group','0','admin','2023-06-17 13:18:47','',NULL,'任务分组列表'),
(6,'系统是否','sys_yes_no','0','admin','2023-06-17 13:18:47','',NULL,'系统是否列表'),
(7,'通知类型','sys_notice_type','0','admin','2023-06-17 13:18:47','',NULL,'通知类型列表'),
(8,'通知状态','sys_notice_status','0','admin','2023-06-17 13:18:47','',NULL,'通知状态列表'),
(9,'操作类型','sys_oper_type','0','admin','2023-06-17 13:18:47','',NULL,'操作类型列表'),
(10,'系统状态','sys_common_status','0','admin','2023-06-17 13:18:47','',NULL,'登录状态列表'),
(100,'护照类型','yq_passport_type','0','admin','2023-07-20 20:56:02','',NULL,'护照类型列表'),
(101,'计划类型','yq_plan_type','0','admin','2023-07-23 15:58:03','',NULL,'计划类型列表');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
