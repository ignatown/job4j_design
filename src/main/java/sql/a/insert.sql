insert into role(rolelvl) values('Administrator');
insert into state(status) values('true');
insert into category(category_name) values('forum');
insert into users(name, role_id) values('ignatow.n', 1);
insert into rules(active) values('true');
insert into role_rules(role_id, rules_id) values(1, 1);
insert into item(user_id, category_id, state_id) values(1, 1, 1);
insert into comments(body, item_id) values('test', 1);
insert into attachs(note, item_id) values('warning made', 1); 