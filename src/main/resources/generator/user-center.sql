DROP TABLE IF EXISTS `mybatis`.`tb_user`;
create table `mybatis`.`tb_user`(
	id int(11) auto_increment comment '主键id',
	user_id varchar(32) not null comment '用户id',
	user_name VARCHAR(200) not null comment '用户名',
	user_en_name VARCHAR(200) comment '用户名英文名',
	user_password varchar(32) comment '用户密码',
	user_phone int(11) comment '电话号码',
	user_sex TINYINT(1) not null  comment '性别，0-男 1-女',
	user_age SMALLINT(3) comment '年龄',
	user_address varchar(400) comment '家庭住址',
	user_marry_state TINYINT(1) comment '是否已婚，0-未婚，1-已婚',
	user_state TINYINT(1) default 0 comment '用户状态，0-信息不完整，1-正常状态，2-已注销',
	user_job_type tinyint(2) comment '用户职业，1-事业单位，2-程序员，具体参考职业表',
	user_id_card varchar(22) comment '证件号',
	user_email varchar(30) comment '用户邮箱',
	user_birthday varchar(8) comment '用户生日',
	create_time BIGINT(32) comment '创建时间',
	update_time BIGINT(32) comment '最后更新时间',
	primary key(id),
	UNIQUE INDEX tb_user_ux(user_id)
)COMMENT='用户表';

DROP TABLE IF EXISTS `mybatis`.`tb_role`;
create table `mybatis`.`tb_role`(
	id int(11) auto_increment comment '主键id',
	role_id SMALLINT(3) not null comment '角色id',
	role_name varchar(200) not null comment '角色名称',
	role_state TINYINT(1) default 0 not null comment '状态，0-不启用，1-启用',
	create_time BIGINT(32) comment '创建时间',
	PRIMARY key(id),
	UNIQUE index tb_role_ux(role_id)
)COMMENT='角色表';

DROP TABLE IF EXISTS `mybatis`.`tb_menu`;
create table `mybatis`.`tb_menu`(
	id int(11) auto_increment comment '主键id',
	menu_id SMALLINT(3) not null comment '菜单id',
	menu_parent_id SMALLINT(3)  comment '父菜单id',
	menu_name varchar(200) not null comment '角色名称',
	menu_url varchar(150) not null comment '菜单路径',
	menu_state TINYINT(1) default 0 not null comment '菜单状态，0-不启用，1-启用',
	create_time BIGINT(32) comment '创建时间',
	update_time BIGINT(32) comment '最后更新时间',
	PRIMARY key(id),
	UNIQUE index tb_menu_ux(menu_id)
)COMMENT='菜单表';

DROP TABLE IF EXISTS `mybatis`.`tb_resource`;
create table `mybatis`.`tb_resource`(
	id int(11) auto_increment comment '主键id',
	resource_code varchar(150) not null comment '资源code',
	resource_url varchar(150) not null comment '资源路径',
	resource_description varchar(200) comment '资源描述',
	resource_state TINYINT(1) default 0 not null comment '状态，0-不启用，1-启用',
	create_time BIGINT(32) comment '创建时间',
	update_time BIGINT(32) comment '最后更新时间',
	PRIMARY key(id),
	UNIQUE index tb_resource_ux(resource_code)
)COMMENT='资源表';

DROP TABLE IF EXISTS `mybatis`.`user_role`;
create table `mybatis`.`user_role`(
	id int(11) auto_increment comment '主键id',
	user_id int(11) not null comment '用户id',
	role_id int(11) not null comment '角色id',
	PRIMARY key(id),
	UNIQUE index user_role_ux(user_id,role_id)
)COMMENT='用户角色关联表';

DROP TABLE IF EXISTS `mybatis`.`role_menu`;
create table `mybatis`.`role_menu`(
	id int(11) auto_increment comment '主键id',
	role_id int(11) not null comment '角色id',
	menu_id int(11) not null comment '菜单id',
	PRIMARY key(id),
	UNIQUE index role_menu_ux(role_id,menu_id)
)COMMENT='角色菜单关联表';

DROP TABLE IF EXISTS `mybatis`.`menu_resource`;
create table `mybatis`.`menu_resource`(
	id int(11) auto_increment comment '主键id',
	menu_id int(11) not null comment '菜单id',
	resource_id int(11) not null comment '资源id',
	PRIMARY key(id),
	UNIQUE index menu_resource_ux(menu_id,resource_id)
)COMMENT='菜单资源关联表,一般不用';


DROP TABLE IF EXISTS `mybatis`.`role_resource`;
create table `mybatis`.`role_resource`(
	id int(11) auto_increment comment '主键id',
	role_id int(11) not null comment '菜单id',
	resource_id int(11) not null comment '资源id',
	PRIMARY key(id),
	UNIQUE index role_resource_ux(role_id,resource_id)
)COMMENT='角色资源，技术人员配置';

DROP TABLE IF EXISTS `mybatis`.`logon`;
create table `mybatis`.`logon`(
	token VARCHAR(32)  comment '主键id',
	user_id int(11) comment '用户表的id',
	logon_time BIGINT(21) comment '登录时间',
	resource_data varchar(4000) comment '会话数据',
	PRIMARY key(token),
	index logon_idx(user_id)
)COMMENT='登录会话表';