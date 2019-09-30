set names utf8;
set foreign_key_checks = 0;
drop database if exists interStudents;
create database if not exists interStudents;
use interStudents;

drop table if exists login_user_table;

create table login_user_table(
id int not null primary key auto_increment,
login_id varchar(16)unique,
login_pass varchar(16),
user_name varchar(32),
user_hobby varchar(32),
generation varchar(32),
furigana varchar(32),
birthplace varchar(32),
team_name varchar(32),
table_number int(2),
profile_img_pass varchar(32),
header_img_pass varchar(32),
user_comment varchar(255),
admin_comment varchar(255),
insert_date datetime,
updated_date datetime,
admin_flg varchar(1)
);

drop table if exists study_progress_table;

create table study_progress_table(
id int not null primary key auto_increment,
user_master_id varchar(16),
study_name varchar(50),
study_homework varchar(50),
study_period varchar(50),
insert_date datetime,
update_date datetime
);

drop table if exists board_table;

create table board_table(
id int not null primary key auto_increment,
contributor_name varchar(32),
attribute varchar(32),
title varchar(32),
comment varchar(255),
insert_date datetime
);

drop table if exists news_table;

create table news_table(
id int not null primary key auto_increment,
template_img_pass varchar(32),
attribute varchar(32),
title varchar(32),
comment varchar(255),
insert_date datetime
);

drop table if exists team_table;

create table team_table(
id int not null primary key auto_increment,
name varchar(32),
generation varchar(32)
);

INSERT INTO login_user_table(login_id, login_pass, user_name, user_hobby, generation, furigana, table_number,birthplace,team_name,admin_flg)VALUE("AOIDAICHI", "0705", "青井 大地", "読書", "7月生", "あおいだいち","5", "島根県","olive", "A");
INSERT INTO study_progress_table(user_master_id, study_name,study_homework, study_period)VALUE("AOIDAICHI", "HTML", "2カラムレイアウト", "なし");
INSERT INTO board_table(contributor_name, attribute)VALUE("青井 大地", "admin");
INSERT INTO news_table(template_img_pass, attribute, title, comment)VALUE("consult.jpg", "admin", "面談", "9/30 13:00 青井さん面談です。");
INSERT INTO news_table(template_img_pass, attribute, title, comment)VALUE("close.jpeg", "admin", "休校", "9/30 休校になります。");
INSERT INTO news_table(template_img_pass, attribute, title, comment)VALUE("重要.jpg", "admin", "重要", "9/30 席替えがあります。");
INSERT INTO news_table(template_img_pass, attribute, title, comment)VALUE("study.jpeg", "olive", "教材", "教材です。");
INSERT INTO team_table(name, generation)VALUE("olive", "7月生");
INSERT INTO team_table(name, generation)VALUE("maple", "7月生");

INSERT INTO login_user_table(login_id, login_pass, user_name, user_hobby, generation, furigana, table_number,birthplace,team_name, admin_flg)VALUE("ONODERA", "123", "小野寺 聖", "営業", "7月生", "おのでらあきら","2", "埼玉県","olive", "A");
INSERT INTO study_progress_table(user_master_id, study_name,study_homework, study_period)VALUE("ONODERA", "HTML", "2カラムレイアウト", "なし");
INSERT INTO board_table(contributor_name, attribute)VALUE("小野寺 聖", "admin");

INSERT INTO login_user_table(login_id, login_pass, user_name, user_hobby, generation, furigana, table_number,birthplace,team_name)VALUE("TEST", "test", "てすと", "なし", "1月生", "てすと","6", "東京","olive");
INSERT INTO study_progress_table(user_master_id, study_name,study_homework, study_period)VALUE("TEST", "HTML", "2カラムレイアウト", "なし");

INSERT INTO login_user_table(login_id, login_pass, user_name, user_hobby, generation, furigana, table_number,birthplace,team_name)VALUE("TEST2", "test2", "てすと2", "なし", "2月生", "てすと","6", "東京","olive");
INSERT INTO study_progress_table(user_master_id, study_name,study_homework, study_period)VALUE("TEST2", "HTML", "2カラムレイアウト", "なし");

INSERT INTO login_user_table(login_id, login_pass, user_name, user_hobby, generation, furigana, table_number,birthplace,team_name)VALUE("TEST3", "test3", "てすと3", "なし", "12月生", "てすと","6", "東京","olive");
INSERT INTO study_progress_table(user_master_id, study_name,study_homework, study_period)VALUE("TEST3", "HTML", "2カラムレイアウト", "なし");