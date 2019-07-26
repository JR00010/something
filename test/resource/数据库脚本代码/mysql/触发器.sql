-- 创建三张分表 ，并建立总表   

CREATE TABLE `tb_member3` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `sex` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TRIGGER `demo` BEFORE INSERT ON `tb_member3` FOR EACH ROW BEGIN
     insert into member(name,sex) values ('jacson','0');

     END;
     
DROP table IF EXISTS tb_member1;
create table tb_member1(
    id bigint primary key auto_increment ,
    name varchar(20),
    sex tinyint not null default '0'
)ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ; 

DROP table IF EXISTS tb_member2;
create table tb_member2(
    id bigint primary key auto_increment ,
    name varchar(20),
    sex tinyint not null default '0'
)ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ; 
//创建tb_member2也可以用下面的语句  create table tb_member3 like tb_member1;   
     

DROP table IF EXISTS tb_member;
create table tb_member(
    id bigint primary key auto_increment ,
    name varchar(20),
    sex tinyint not null default '0'
)ENGINE=MERGE UNION=(tb_member1,tb_member2) INSERT_METHOD=LAST CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 在触发器所在的表中 插入数据 ，触发触发器运行
insert into tb_member3(name,sex) values ('jacson','0');  
-- 在总表中中插入数据 ，其数据会插入到 tb_member3 中   但是不会触发 触发器运行
insert into tb_member(name,sex) values ('jacson','0');
     