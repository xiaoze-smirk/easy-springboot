create table tbl_course(
   course_no varchar(50) primary key,
   course_name varchar(100) not null,
   course_hours int not null,
   type_id int not null,
   course_status varchar(1) not null,
   course_reqs varchar(20) not null,
   course_point decimal(3,1),
   course_memo varchar(1000),
   course_textbook_pic mediumblob,
   constraint FK_COURSE_TYPE FOREIGN KEY (type_id) references tbl_course_type(type_id) 
);

create table tbl_course_type(
   type_id int primary key auto_increment,
   type_name varchar(30) not null
 );
 
 insert into tbl_course_type(type_name) values('专业必修');
 insert into tbl_course_type(type_name) values('专业任选');
 insert into tbl_course_type(type_name) values('校选课');
 insert into tbl_course_type(type_name) values('专家讲座');


create table tbl_users(
   user_no    varchar(20) primary key,
   user_pwd   varchar(1000) not null,
   user_name  varchar(100) not null
);

insert into tbl_users values('000101','123456','王海涛');
insert into tbl_users values('000102','123456','张明');


