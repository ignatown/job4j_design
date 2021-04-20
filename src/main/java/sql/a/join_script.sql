create table departments(
    id serial primary key,
	    name varchar(255));

create table emploees(
		id serial primary key,
		departments_id int references departments(id),
	   	 name varchar(255));

insert into departments(name) values('departments1');
insert into departments(name) values('departments2');
insert into departments(name) values('departments3');

insert into emploees(departments_id , name) values(1, 'emploee1');
insert into emploees(departments_id , name) values(1, 'emploee2');
insert into emploees(departments_id , name) values(1, 'emploee3');
insert into emploees(departments_id , name) values(2, 'emploee4');
insert into emploees(departments_id , name) values(2, 'emploee5');

select * from departments left join emploees on emploees.departments_id = departments.id;
select * from departments right join emploees on emploees.departments_id = departments.id;
select * from departments full join emploees on emploees.departments_id = departments.id;
select * from departments cross join emploees;

select departments.id, departments.name from departments left join emploees on emploees.departments_id = departments.id where emploees.departments_id is null;

select * from departments right join emploees on emploees.departments_id = departments.id where emploees.departments_id is not null;
select * from departments left join emploees on emploees.departments_id = departments.id where emploees.departments_id is not null;