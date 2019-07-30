insert into Course (id, name, created_date, last_updated_date) values (10001, 'mathematics', sysdate(), sysdate());
insert into Course (id, name, created_date, last_updated_date) values (10002, 'korean', sysdate(), sysdate());


insert into passport(id,number) values(40001, 'abcd1111');
insert into passport(id,number) values(40002, 'zfdf2233');
insert into passport(id,number) values(40003, 'adfd8776');

insert into student(id, name, passport_id) values(20001, 'minsik', 40001);
insert into student(id, name, passport_id) values(20002, 'chulsoo', 40002);
insert into student(id, name, passport_id) values(20003, 'younghee', 40003);


insert into review(id,rating, description) values(50003, '5', 'great!');
insert into review(id,rating, description) values(50004, '1', 'it sucks');
insert into review(id,rating, description) values(50005, '3', 'soso');