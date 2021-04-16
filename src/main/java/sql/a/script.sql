create table car(
     id serial primary key,
     vin_number varchar(255)
 );

create table car_number(
     id serial primary key,
     number varchar(255),
     car_id int references car(id)
 );


insert into car(vin_number) values ('15A31V2');
insert into car(vin_number) values ('G532S41');
insert into car(vin_number) values ('124d1245Q');
insert into car(vin_number) values ('1531QSS');

insert into car_number(number, car_id) values('R324ZU', 1);
insert into car_number(number, car_id) values('I384IV', 2);
insert into car_number(number, car_id) values('K827SD', 3);
insert into car_number(number, car_id) values('P932IQ', 4);

select * from car join car_number p on car.id = p.id;
select vin_number, p.number from car join car_number p on car.id = p.id;
select pp.id, pp.vin_number, p.number from car as pp join car_number p on pp.id = p.id;