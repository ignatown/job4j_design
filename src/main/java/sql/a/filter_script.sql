create table product(
    id serial primary key,
	    name varchar(255),
	type_id int,
	expired_date date, 
	price int);

create table type(
		id serial primary key,
	    name varchar(255));

insert into type(name) values('Молоко');
insert into type(name) values('Сыр');

insert into product(name,type_id,expired_date,price) values('Молоко1', 1 ,'30.04.2021', 85);
insert into product(name,type_id,expired_date,price) values('Молоко2', 1 , '20.04.2021', 59);
insert into product(name,type_id,expired_date,price) values('Молоко3', 1 , '02.05.2021', 70);
insert into product(name,type_id,expired_date,price) values('Молоко4', 1 , '19.04.2021', 48);
insert into product(name,type_id,expired_date,price) values('Молоко5', 1 , '19.04.2021', 50);

insert into product(name,type_id,expired_date,price) values('Сыр1', 2 ,'30.05.2021', 126);
insert into product(name,type_id,expired_date,price) values('Сыр2', 2 , '19.04.2021', 672);
insert into product(name,type_id,expired_date,price) values('Сыр3', 2 , '07.05.2021', 340);
insert into product(name,type_id,expired_date,price) values('Сыр4', 2 , '14.05.2021', 195);
insert into product(name,type_id,expired_date,price) values('Сыр5', 2 , '20.04.2021', 220);


select * from product where type_id = 2;
select * from product where name LIKE  '%мороженное%';
select * from product where EXTRACT(MONTH from expired_date) = EXTRACT(MONTH from current_date) and EXTRACT(YEAR from expired_date) = EXTRACT(YEAR from current_date)
select name, price from product where price = (select max(price) from product);
select type_id, sum(price) from product group by type_id;
select type.name, product.name, expired_date from product join type on product.type_id = type.id;
select type.id, type.name, count(*) from product join type on product.type_id = type.id group by type.id;
