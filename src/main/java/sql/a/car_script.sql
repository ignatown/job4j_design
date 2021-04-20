create table body(
    id serial primary key,
	    name varchar(255));

create table engine(
    id serial primary key,
	    name varchar(255));

create table transmission(
    id serial primary key,
	    name varchar(255));

create table car(
    id serial primary key,
	    name varchar(255),
		body_id int,
		engine_id int,
		transmission_id int
);

insert into body(name) values ('body1');
insert into body(name) values ('body2');
insert into body(name) values ('body3');
insert into body(name) values ('body4');
insert into body(name) values ('body5');
insert into body(name) values ('body6');
insert into engine(name) values ('engine1');
insert into engine(name) values ('engine2');
insert into engine(name) values ('engine3');
insert into engine(name) values ('engine4');
insert into transmission(name) values ('transmission1');
insert into transmission(name) values ('transmission2');
insert into transmission(name) values ('transmission3');
insert into transmission(name) values ('transmission4');
insert into transmission(name) values ('transmission5');
insert into car(name, body_id, engine_id, transmission_id) values ('car1', 6, 4, 5);
insert into car(name, body_id, engine_id, transmission_id) values ('car2', 4, 2, 3);
insert into car(name, body_id, engine_id, transmission_id) values ('car3', 2, 1, 1);

select * from car;

select body.id, body.name from car right join body on body.id = car.body_id where car.body_id is null;
select engine.id, engine.name from car right join engine on engine.id = car.engine_id where car.engine_id is null;
select transmission.id, transmission.name from car right join transmission on transmission.id = car.transmission_id where car.transmission_id is null;

