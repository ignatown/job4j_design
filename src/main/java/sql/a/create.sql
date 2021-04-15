create table role(
	id serial primary key,
	rolelvl varchar(200)
);
create table state(
	id serial primary key,
	status bool
);
create table category(
	id serial primary key,
	category_name text
);
create table users(
	id serial primary key,
	name varchar(100),
	role_id int references role(id)
);
create table rules(
	id serial primary key,
	state bool
);
create table role_rules(
	id serial primary key,
	role_id int references rules(id),
	rules_id int references role(id)
);
create table item(
	id serial primary key,
	user_id int references users(id),
	category_id int references category(id),
	state_id int references state(id)
);
create table comments(
	id serial primary key,
	body text,
	item_id int references item(id)
);
create table attachs(
	id serial primary key,
	attachs_text text,
	item_id int references item(id)
); 