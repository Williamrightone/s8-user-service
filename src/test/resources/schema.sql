DROP TABLE IF EXISTS end_user;
DROP TABLE IF EXISTS auth_group;
DROP TABLE IF EXISTS group_permission_mp;
DROP TABLE IF EXISTS permission;
DROP TABLE IF EXISTS user_group_mp;

CREATE TABLE end_user (
    id bigint PRIMARY KEY AUTO_INCREMENT NOT NULL,
    passwd varchar(255) NOT NULL,
    sid varchar(255) NOT NULL,
    user_name varchar(255) NOT NULL
);

CREATE TABLE auth_group (
	auth_group_id bigint PRIMARY KEY AUTO_INCREMENT NOT NULL,
	group_description varchar(255) NOT NULL,
	group_name varchar(255) NOT NULL
);

CREATE TABLE group_permission_mp (
	group_permission_mp_id bigint PRIMARY KEY AUTO_INCREMENT NOT NULL,
	auth_group_id bigint NOT NULL,
	permission_id bigint NOT NULL
);

CREATE TABLE permission (
	permission_id bigint PRIMARY KEY AUTO_INCREMENT NOT NULL,
	permission_description varchar(255),
	permission_name varchar(255)
);

CREATE TABLE user_group_mp (
	user_group_mp_id bigint PRIMARY KEY AUTO_INCREMENT NOT NULL,
	auth_group_id bigint NOT NULL,
	sid varchar(255) NOT NULL
);
