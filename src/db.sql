CREATE DATABASE photo DEFAULT CHARACTER SET utf8;
--用户表
CREATE TABLE t_user(
  u_id int PRIMARY KEY auto_increment,
  username varchar(32) not null default '',
  password varchar(32) not null default ''
)ENGINE=innoDB;

--角色表（序列）
CREATE TABLE t_role(
	id int PRIMARY KEY auto_increment,
	rolename VARCHAR(32)
)ENGINE=innoDB;

--权限表
CREATE TABLE t_privilege(
	id int PRIMARY KEY auto_increment,
	privilegename VARCHAR(32)
)ENGINE=innoDB;	

--管理员角色表
CREATE TABLE t_user_role(
	user_id int,
	role_id int,
	PRIMARY KEY(user_id,role_id)
)ENGINE=innoDB;	

--角色权限表
CREATE TABLE t_role_privilege(
	role_id int(4),
	privilege_id int(4),
	PRIMARY KEY(role_id,privilege_id)
)ENGINE=innoDB;	

--添加外键
ALTER TABLE t_user_role ADD FOREIGN KEY(user_id) REFERENCES t_user(id);
ALTER TABLE t_user_role ADD FOREIGN KEY(role_id) REFERENCES t_role(id);

ALTER TABLE t_role_privilege ADD FOREIGN KEY(privilege_id) REFERENCES t_privilege(id);
ALTER TABLE t_role_privilege ADD FOREIGN KEY(role_id) REFERENCES t_role(id);



--相册表
CREATE TABLE t_photoalbum(
 	id int PRIMARY KEY auto_increment,
    name VARCHAR(100),
    type int,
    coverUrl VARCHAR(32),
    userId int references t_user(id)
)ENGINE=innoDB;	



CREATE TABLE t_photo(
	id int PRIMARY KEY auto_increment,
	name VARCHAR(100),
	photoUrl VARCHAR(100),
	belongId int references t_photoalbum(id),
	userId int references t_user(id)
)ENGINE=innoDB;


CREATE TABLE t_comment(
	id int PRIMARY KEY auto_increment,
	content VARCHAR(300),
	date Date,
	photoId int references t_photo(id),
	userId int references t_user(id),
	userName VARCHAR(32)
)ENGINE=innoDB;


CREATE TABLE t_vote(
	id int PRIMARY KEY auto_increment,
	photoId int references t_photo(id),
	voteValue double
)ENGINE=innoDB;

