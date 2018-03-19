--数据库初始化脚本

--创建数据库
CREATE DATABASE loginTest

--使用loginTest数据库
use loginTest

--创建T_SignUp表
CREATE TABLE T_SignUp(
	'SignUpID' bigint(120) NOT NULL AUTO_INCREMENT COMMENT '主键',
	'LoginName' varchar(100) NOT NULL COMMENT '登录名',
	'Password' varchar(1000) DEFAULT NULL COMMENT '密码',
	'Name' varchar(20) DEFAULT NULL COMMENT '姓名',
	'SignUpDateTime' datetime DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (SignUpID)
)ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 COMMENT='用户登录信息表'

--创建T_Conference表
CREATE TABLE T_Conference(
	'ConferenceID' bigint(120) NOT NULL AUTO_INCREMENT COMMENT '主键',
	'ConferenceName' varchar(100) NOT NULL COMMENT '会议名称',
	'ChineseConferenceLocation' varchar(100) NOT NULL COMMENT '会议地点',
	'ConferenceBeginningDateTime' datetime DEFAULT NULL COMMENT '会议开始时间',
	'ConferenceEndingDateTime' datetime DEFAULT NULL COMMENT '会议结束时间',
	'SignUpID' bigint(120) NOT NULL COMMENT '会议提交人的注册ID',
	'CreatedDateTime' datetime DEFAULT NULL COMMENT '创建时间',
	'ConferenceType' varchar(100) NOT NULL COMMENT '会议类型',
  PRIMARY KEY (ConferenceID)
)ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 COMMENT='会议信息表'


--初始化数据
insert into
	user_info(name,user_name,email,password,create_time,last_login_time,status,account)
values
	('测试1', 'admin', null, '123456', null, null, '1', '1500.00'),
	('测试2', 'zhangsan', null, '123456', null, null, '1', '3500.00');
	